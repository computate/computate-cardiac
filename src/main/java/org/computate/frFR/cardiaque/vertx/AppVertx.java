package org.computate.frFR.cardiaque.vertx;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.computate.frFR.cardiaque.config.ConfigSite;
import org.computate.frFR.cardiaque.contexte.SiteContexte;
import org.computate.frFR.cardiaque.requete.RequeteSite;
import org.computate.frFR.cardiaque.warfarin.CalculInrApiServiceImpl;
import org.computate.frFR.cardiaque.warfarin.CalculInrGenApiService;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.eventbus.MessageConsumer;
import io.vertx.core.http.HttpServerOptions;
import io.vertx.core.json.JsonObject;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.core.net.JksOptions;
import io.vertx.core.shareddata.AsyncMap;
import io.vertx.core.shareddata.SharedData;
import io.vertx.ext.auth.oauth2.OAuth2Auth;
import io.vertx.ext.auth.oauth2.OAuth2FlowType;
import io.vertx.ext.auth.oauth2.providers.KeycloakAuth;
import io.vertx.ext.jdbc.JDBCClient;
import io.vertx.ext.sql.SQLConnection;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.api.contract.openapi3.OpenAPI3RouterFactory;
import io.vertx.ext.web.handler.OAuth2AuthHandler;
import io.vertx.ext.web.handler.StaticHandler;
import io.vertx.serviceproxy.ServiceBinder;
import io.vertx.serviceproxy.ServiceProxyBuilder;

public class AppVertx extends AbstractVerticle {
	public static final String SQL_createTableC = "create table if not exists c(pk bigserial primary key, ajour boolean, nom_canonique text, cree timestamp with time zone default now(), modifie timestamp with time zone default now(), id_utilisateur text); ";
	public static final String SQL_uniqueIndexC = "create unique index if not exists c_index_utilisateur on c(pk, nom_canonique, id_utilisateur); ";
	public static final String SQL_createTableA = "create table if not exists a(pk bigserial primary key, pk1 bigint, pk2 bigint, entite1 text, entite2 text, actuel boolean, cree timestamp with time zone default now(), modifie timestamp with time zone default now(), foreign key(pk1) references c(pk), foreign key(pk2) references c(pk)); ";
	// public static final String SQL_uniqueIndexA = "create unique index if not
	// exists c_unique_pks on a(pk1, entite1, pk2, entite2); ";
	public static final String SQL_createTableD = "create table if not exists d(pk bigserial primary key, chemin text, valeur text, actuel boolean, cree timestamp with time zone default now(), modifie timestamp with time zone default now(), pk_c bigint, foreign key(pk_c) references c(pk)); ";
	// public static final String SQL_uniqueIndexP = "create unique index if not
	// exists p_index_chemin_pk_o_fk on p(chemin, pk_c); ";
	public static final String SQL_initTout = SQL_createTableC + SQL_uniqueIndexC + SQL_createTableA + SQL_createTableD;

	private JDBCClient jdbcClient;

	private static final Logger LOGGER = LoggerFactory.getLogger(AppVertx.class);

	public static void main(String[] args) {
		CoureurVertx.run(AppVertx.class);
	}

	private Future<Void> preparerDonnees(SiteContexte siteContexte) {
		ConfigSite configSite = siteContexte.getConfigSite();
		Future<Void> future = Future.future();

		JsonObject jdbcConfig = new JsonObject();
		if (StringUtils.isNotEmpty(configSite.getJdbcUrl()))
			jdbcConfig.put("url", configSite.getJdbcUrl());
		if (StringUtils.isNotEmpty(configSite.getJdbcClassePilote()))
			jdbcConfig.put("driver_class", configSite.getJdbcClassePilote());
		if (StringUtils.isNotEmpty(configSite.getJdbcUtilisateur()))
			jdbcConfig.put("user", configSite.getJdbcUtilisateur());
		if (StringUtils.isNotEmpty(configSite.getJdbcMotDePasse()))
			jdbcConfig.put("password", configSite.getJdbcMotDePasse());
		if (configSite.getJdbcTailleMaxPiscine() != null)
			jdbcConfig.put("max_pool_size", configSite.getJdbcTailleMaxPiscine());
		if (configSite.getJdbcTailleInitialePiscine() != null)
			jdbcConfig.put("initial_pool_size", configSite.getJdbcTailleInitialePiscine());
		if (configSite.getJdbcTailleMinPiscine() != null)
			jdbcConfig.put("min_pool_size", configSite.getJdbcTailleMinPiscine());
		if (configSite.getJdbcMaxDeclarations() != null)
			jdbcConfig.put("max_statements", configSite.getJdbcMaxDeclarations());
		if (configSite.getJdbcMaxDeclarationsParConnexion() != null)
			jdbcConfig.put("max_statements_per_connection", configSite.getJdbcMaxDeclarationsParConnexion());
		if (configSite.getJdbcTempsInactiviteMax() != null)
			jdbcConfig.put("max_idle_time", configSite.getJdbcTempsInactiviteMax());
		jdbcClient = JDBCClient.createShared(vertx, jdbcConfig);

		jdbcClient.getConnection(ar -> {
			if (ar.failed()) {
				System.err.println("Could not open a database connection. ");
				ExceptionUtils.printRootCauseStackTrace(ar.cause());
				future.fail(ar.cause());
			} else {
				SQLConnection connection = ar.result();
				connection.execute(SQL_initTout, create -> {
					connection.close();
					if (create.failed()) {
						LOGGER.error("Database preparation error", create.cause());
						future.fail(create.cause());
					} else {
						future.complete();
					}
				});
			}
		});

		return future;
	}

	private Future<Void> configurerCluster(SiteContexte siteContexte) {
		ConfigSite configSite = siteContexte.getConfigSite();
		Future<Void> future = Future.future();
		SharedData donneesPartagees = vertx.sharedData();
		donneesPartagees.getClusterWideMap("donneesCluster", res -> {
			if (res.succeeded()) {
				try {
					AsyncMap<Object, Object> donneesCluster = res.result();
					donneesCluster.put("configSite", configSite, resPut -> {
						if (resPut.succeeded()) {
							future.complete();
						} else {
							LOGGER.error("Could not configure the cluster", res.cause());
							future.fail(res.cause());
						}
					});
				} catch (Exception e) {
					LOGGER.error("Could not configure the cluster", res.cause());
					future.fail(e);
				}
			} else {
				LOGGER.error("Could not configure the cluster", res.cause());
				future.fail(res.cause());
			}
		});
		return future;
	}

	private Future<Void> configurerOpenApi(SiteContexte siteContexte) {
		ConfigSite configSite = siteContexte.getConfigSite();
		Future<Void> future = Future.future();
		OpenAPI3RouterFactory.create(vertx, "src/main/resources/openapi3.yaml", ar -> {
			if (ar.succeeded()) {
				OpenAPI3RouterFactory usineRouteur = ar.result();
				usineRouteur.mountServicesFromExtensions();
				siteContexte.setUsineRouteur(usineRouteur);

				JsonObject keycloakJson = new JsonObject() {
					{
						put("realm", configSite.getAuthRoyaume());
						// put("realm-public-key", "MIIBIjANBgkqhk...wIDAQAB");
						put("auth-server-url", configSite.getAuthUrl());
						put("ssl-required", configSite.getAuthSslRequis());
						put("resource", configSite.getAuthRessource());
						put("credentials", new JsonObject().put("secret", configSite.getAuthSecret()));
						put("use-resource-role-mappings", true);
						put("policy-enforcer", new JsonObject());
					}
				};
		
				// Initialize the OAuth2 Library
	//			OAuth2FlowType AUTH_CODE AUTH_JWT CLIENT PASSWORD;
				OAuth2Auth siteAuth = KeycloakAuth.create(vertx, OAuth2FlowType.AUTH_CODE, keycloakJson);
				OAuth2AuthHandler gestionnaireAuth = OAuth2AuthHandler.create(siteAuth);
				siteContexte.setSiteAuth(siteAuth);
				usineRouteur.addSecurityHandler("oauth2", gestionnaireAuth);

				// Create and mount options to router factory
				// RouterFactoryOptions options = new
//				 RouterFactoryOptions().setMountNotImplementedHandler(true)
//				 .setMountValidationFailureHandler(false);
//				CalculInrApiGen apiCalculInr = new CalculInrApiGen();
//				apiCalculInr.handleGetCalculInr(siteContexte);
				future.complete();
			} else {
				LOGGER.error("Could not configure the api", ar.cause());
				future.fail(ar.cause());
			}
		});
		return future;
	}
//
//	private Future<Void> configurerServices(SiteContexte siteContexte) {
//		Future<Void> future = Future.future();
////		ClusterApiService clusterApi = ClusterApiService.create(siteContexte, vertx);
//		// ClusterApiService clusterApi = ClusterApiSesrvice.new
//		// ClusterApiServiceImpl(siteContexte, vertx);
//		// Register the handler
//		ServiceBinder clusterApiBinder = new ServiceBinder(vertx);
//		clusterApiBinder.setAddress("ClusterApi-address");
////		MessageConsumer<JsonObject> clusterApiConsumer = clusterApiBinder.register(ClusterApiServiceImpl.class,
////				clusterApi);
//
//		ServiceProxyBuilder clusterApiBuilder = new ServiceProxyBuilder(vertx).setAddress("ClusterApi-address");
//		// or with delivery options:
////		ClusterApiServiceImpl clusterApiService = clusterApiBuilder.setOptions(new DeliveryOptions(new JsonObject()))
////				.build(ClusterApiServiceImpl.class);
//
//		future.complete();
//		return future;
//	}

	private Future<Void> demarrerServeur(SiteContexte siteContexte) {
		ConfigSite configSite = siteContexte.getConfigSite();
		Future<Void> future = Future.future();

		final ServiceBinder serviceBinder = new ServiceBinder(vertx).setAddress(configSite.getVertxServiceAddresse());

		CalculInrGenApiService calculInrApiService = new CalculInrApiServiceImpl(siteContexte);
		MessageConsumer<JsonObject> calculInrApiConsumer = serviceBinder.register(CalculInrGenApiService.class, calculInrApiService);

		Router siteRouteur = siteContexte.getUsineRouteur().getRouter();
//			siteContexte.setSiteRouteur_(siteRouteur);

		siteRouteur.route("/static/*").handler(StaticHandler.create().setCachingEnabled(false).setFilesReadOnly(true));

		String siteNomHote = configSite.getSiteNomHote();
		Integer sitePort = configSite.getSitePort();
		HttpServerOptions options = new HttpServerOptions();
		// options.setMaxWebsocketFrameSize(1000000);
		options.setSsl(true);
		options.setKeyStoreOptions(new JksOptions().setPath(configSite.getSslJksChemin()).setPassword(configSite.getSslJksMotDePasse()));
		options.setPort(sitePort);
		options.setHost(siteNomHote);

		LOGGER.info(String.format("HTTP server starting: %s://%s:%s", "https", siteNomHote, sitePort));
		vertx.createHttpServer(options).requestHandler(siteRouteur).listen(ar -> {
			if (ar.succeeded()) {
				LOGGER.info(String.format("HTTP server running: %s:%s", siteNomHote, sitePort));
				future.complete();
			} else {
				LOGGER.error("Could not start a HTTP server", ar.cause());
				future.fail(ar.cause());
			}
		});

		return future;
	}

	@Override
	public void start(Future<Void> demarrerFuture) throws Exception {

		SiteContexte siteContexte = new SiteContexte();
		siteContexte.setVertx(vertx);

		RequeteSite requeteSite = new RequeteSite();
		requeteSite.setSiteContexte_(siteContexte);
		requeteSite.initLoinRequeteSite();

		siteContexte.initLoinSiteContexte();

		Future<Void> etapesFutures = preparerDonnees(siteContexte).compose(a -> 
			configurerCluster(siteContexte).compose(b -> 
				configurerOpenApi(siteContexte).compose(c -> 
					demarrerServeur(siteContexte)
				)
			)
		);
		etapesFutures.setHandler(demarrerFuture.completer());
	}
}
