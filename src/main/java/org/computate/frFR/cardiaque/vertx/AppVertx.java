package org.computate.frFR.cardiaque.vertx;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.computate.frFR.cardiaque.config.ConfigSite;
import org.computate.frFR.cardiaque.contexte.SiteContexte;
import org.computate.frFR.cardiaque.requete.RequeteSite;
import org.computate.frFR.cardiaque.warfarin.CalculInrApiGen;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
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
import io.vertx.ext.web.Router;
import io.vertx.ext.web.api.contract.RouterFactoryOptions;
import io.vertx.ext.web.api.contract.openapi3.OpenAPI3RouterFactory;
import io.vertx.ext.web.handler.StaticHandler;

public class AppVertx extends AbstractVerticle {

	private JDBCClient jdbcClient;

	private static final Logger LOGGER = LoggerFactory.getLogger(AppVertx.class);

	public static void main(String[] args) {
		CoureurVertx.run(AppVertx.class);
	}

	private Future<Void> preparerDonnees(ConfigSite configSite) {
		Future<Void> future = Future.future();

		JsonObject jdbcConfig = new JsonObject();
		if(StringUtils.isNotEmpty(configSite.getJdbcUrl()))
			jdbcConfig.put("url", configSite.getJdbcUrl());
		if(StringUtils.isNotEmpty(configSite.getJdbcClassePilote()))
			jdbcConfig.put("driver_class", configSite.getJdbcClassePilote());
		if(StringUtils.isNotEmpty(configSite.getJdbcUtilisateur()))
			jdbcConfig.put("user", configSite.getJdbcUtilisateur());
		if(StringUtils.isNotEmpty(configSite.getJdbcMotDePasse()))
			jdbcConfig.put("password", configSite.getJdbcMotDePasse());
		if(configSite.getJdbcTailleMaxPiscine() != null)
			jdbcConfig.put("max_pool_size", configSite.getJdbcTailleMaxPiscine());
		if(configSite.getJdbcTailleInitialePiscine() != null)
			jdbcConfig.put("initial_pool_size", configSite.getJdbcTailleInitialePiscine());
		if(configSite.getJdbcTailleMinPiscine() != null)
			jdbcConfig.put("min_pool_size", configSite.getJdbcTailleMinPiscine());
		if(configSite.getJdbcMaxDeclarations() != null)
			jdbcConfig.put("max_statements", configSite.getJdbcMaxDeclarations());
		if(configSite.getJdbcMaxDeclarationsParConnexion() != null)
			jdbcConfig.put("max_statements_per_connection", configSite.getJdbcMaxDeclarationsParConnexion());
		if(configSite.getJdbcTempsInactiviteMax() != null)
			jdbcConfig.put("max_idle_time", configSite.getJdbcTempsInactiviteMax());
		jdbcClient = JDBCClient.createShared(vertx, jdbcConfig);

		jdbcClient.getConnection(ar -> {
			if (ar.failed()) {
				System.err.println("Could not open a database connection. ");
				ExceptionUtils.printRootCauseStackTrace(ar.cause());
				future.fail(ar.cause());
			} else {
				future.complete();
			}
		});

		return future;
	}

	private Future<Void> configurerCluster(ConfigSite configSite) {
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

	private Future<Void> configurerApi(ConfigSite configSite) {
		Future<Void> future = Future.future();
		OpenAPI3RouterFactory.create(vertx, "/swagger.yaml", ar -> {
			if (ar.succeeded()) {
//				OpenAPI3RouterFactory routerFactory = ar.result();
				// Create and mount options to router factory
//				RouterFactoryOptions options = new RouterFactoryOptions().setMountNotImplementedHandler(true)
//						.setMountValidationFailureHandler(false);
				future.complete();
			}
			else {
				LOGGER.error("Could not configure the api", ar.cause());
				future.fail(ar.cause());
			}
		});
		return future;
	}

	private Future<Void> demarrerServeur(ConfigSite configSite) {
		Future<Void> future = Future.future();

		try {
			JsonObject keycloakJson = new JsonObject() {
				{
					put("realm", configSite.getAuthRoyaume());
					// put("realm-public-key", "MIIBIjANBgkqhk...wIDAQAB");
					put("auth-server-url", configSite.getAuthUrl());
					put("ssl-required", configSite.getAuthSslRequis());
					put("resource", configSite.getAuthRessource());
					put("credentials", new JsonObject().put("secret", configSite.getAuthSecret()));
				}
			};
	
			// Initialize the OAuth2 Library
			OAuth2Auth siteAuth = KeycloakAuth.create(vertx, OAuth2FlowType.PASSWORD, keycloakJson);

			OpenAPI3RouterFactory.create(vertx, "src/main/resources/petstore.yaml", ar -> {
				if (ar.succeeded()) {
					OpenAPI3RouterFactory routerFactory = ar.result();
					// Create and mount options to router factory
					RouterFactoryOptions options = new RouterFactoryOptions().setMountNotImplementedHandler(true)
							.setMountValidationFailureHandler(false);

					CalculInrApiGen moissoneurOaiApi = new CalculInrApiGen();
				}
			});
	
			Router siteRouteur = Router.router(vertx);
	
			SiteContexte siteContexte = new SiteContexte();
			siteContexte.setVertx_(vertx);
			siteContexte.setSiteAuth_(siteAuth);
			siteContexte.setSiteRouteur_(siteRouteur);
	
			RequeteSite requeteSite = new RequeteSite();
			requeteSite.setSiteContexte_(siteContexte);
			requeteSite.initLoinRequeteSite();
	
			siteContexte.initLoinSiteContexte();
	
			moissoneurOaiApi.handleGetCalculInr(siteContexte);
	
			siteRouteur.route().handler(StaticHandler.create());
	
			HttpServerOptions options = new HttpServerOptions();
			// options.setMaxWebsocketFrameSize(1000000);
			options.setSsl(true);
			options.setKeyStoreOptions(new JksOptions().setPath(configSite.getSslJksChemin()).setPassword(configSite.getSslJksMotDePasse()));
			String siteNomHote = requeteSite.getConfigSite_().getSiteNomHote();
			Integer sitePort = requeteSite.getConfigSite_().getSitePort();
	
			LOGGER.info(String.format("HTTP server starting: %s://%s:%s", "https", siteNomHote, sitePort));
			vertx.createHttpServer(options).requestHandler(siteRouteur::accept).listen(sitePort,
					siteNomHote, ar -> {
				if (ar.succeeded()) {
					LOGGER.info(String.format("HTTP server running: %s:%s", siteNomHote, sitePort));
					future.complete();
				} else {
					LOGGER.error("Could not start a HTTP server", ar.cause());
					future.fail(ar.cause());
				}
			});
		} catch(Exception e) {
			LOGGER.error("Could not start a HTTP server", e.getMessage());
			future.fail(e);
		}

		return future;
	}

	@Override
	public void start(Future<Void> demarrerFuture) throws Exception {
		ConfigSite configSite = new ConfigSite();
		configSite.initLoinConfigSite();
		Future<Void> etapesFutures = preparerDonnees(configSite).compose(
				a -> configurerCluster(configSite).compose(
						b -> demarrerServeur(configSite)
				)
		);
		etapesFutures.setHandler(demarrerFuture.completer());
	}
}
