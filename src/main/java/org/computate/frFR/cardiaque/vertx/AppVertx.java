package org.computate.frFR.cardiaque.vertx;

import java.io.File;
import java.io.PrintWriter;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.computate.frFR.cardiaque.config.ConfigSite;
import org.computate.frFR.cardiaque.contexte.SiteContexte;
import org.computate.frFR.cardiaque.requete.RequeteSite;
import org.computate.frFR.cardiaque.warfarin.CalculInrApiGen;
import org.junit.Test;

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
import io.vertx.ext.sql.SQLConnection;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.api.contract.RouterFactoryOptions;
import io.vertx.ext.web.api.contract.openapi3.OpenAPI3RouterFactory;
import io.vertx.ext.web.handler.StaticHandler;

public class AppVertx extends AbstractVerticle {
	public static final String SQL_createTableC = "create table if not exists c(pk bigserial primary key, var text, nom_canonique text, cree timestamp with time zone default now(), modifie timestamp with time zone default now(), id_utilisateur text); ";
	public static final String SQL_uniqueIndexC = "create unique index if not exists c_index_utilisateur on c(pk, nom_canonique, id_utilisateur); ";
	public static final String SQL_createTableA = "create table if not exists a(pk bigserial primary key, pk1 bigint, pk2 bigint, champ1 text, champ2 text, foreign key(pk1) references c(pk), foreign key(pk2) references c(pk)); ";
	public static final String SQL_uniqueIndexA = "create unique index if not exists c_unique_pks on a(pk1, champ1, pk2, champ2); ";
	public static final String SQL_createTableP = "create table if not exists p(pk bigserial primary key, chemin text, valeur text, pk_c bigint, foreign key(pk_c) references c(pk)); ";
	public static final String SQL_uniqueIndexP = "create unique index if not exists p_index_chemin_pk_o_fk on p(chemin, pk_c); ";
	public static final String SQL_tout = SQL_createTableC + SQL_uniqueIndexC + SQL_createTableA + SQL_uniqueIndexA + SQL_createTableP + SQL_uniqueIndexP;

	private JDBCClient jdbcClient;

	private static final Logger LOGGER = LoggerFactory.getLogger(AppVertx.class);

	public static void main(String[] args) {
		CoureurVertx.run(AppVertx.class);
	}

	private Future<Void> preparerDonnees(SiteContexte siteContexte) {
		ConfigSite configSite = siteContexte.getConfigSite();
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
				SQLConnection connection = ar.result();
				connection.execute(SQL_tout, create -> {
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
				siteContexte.setUsineRouteur_(usineRouteur);
				// Create and mount options to router factory
//				RouterFactoryOptions options = new RouterFactoryOptions().setMountNotImplementedHandler(true)
//						.setMountValidationFailureHandler(false);
				CalculInrApiGen apiCalculInr = new CalculInrApiGen();
				apiCalculInr.handleGetCalculInr(siteContexte);
				future.complete();
			}
			else {
				LOGGER.error("Could not configure the api", ar.cause());
				future.fail(ar.cause());
			}
		});
		return future;
	}

	private Future<Void> demarrerServeur(SiteContexte siteContexte) {
		ConfigSite configSite = siteContexte.getConfigSite();
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
			siteContexte.setSiteAuth_(siteAuth);

			OpenAPI3RouterFactory.create(vertx, "src/main/resources/petstore.yaml", ar -> {
				if (ar.succeeded()) {
					OpenAPI3RouterFactory routerFactory = ar.result();
					// Create and mount options to router factory
					RouterFactoryOptions options = new RouterFactoryOptions().setMountNotImplementedHandler(true)
							.setMountValidationFailureHandler(false);

					CalculInrApiGen moissoneurOaiApi = new CalculInrApiGen();
				}
			});
	
			Router siteRouteur = siteContexte.getUsineRouteur_().getRouter();
//			siteContexte.setSiteRouteur_(siteRouteur);
	
			siteRouteur.route().handler(StaticHandler.create());
	
			HttpServerOptions options = new HttpServerOptions();
			// options.setMaxWebsocketFrameSize(1000000);
			options.setSsl(true);
			options.setKeyStoreOptions(new JksOptions().setPath(configSite.getSslJksChemin()).setPassword(configSite.getSslJksMotDePasse()));
			String siteNomHote = configSite.getSiteNomHote();
			Integer sitePort = configSite.getSitePort();
	
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
	
		SiteContexte siteContexte = new SiteContexte();
		siteContexte.setVertx_(vertx);

		RequeteSite requeteSite = new RequeteSite();
		requeteSite.setSiteContexte_(siteContexte);
		requeteSite.initLoinRequeteSite();

		siteContexte.initLoinSiteContexte();

		Future<Void> etapesFutures = preparerDonnees(siteContexte).compose(
				a -> configurerCluster(siteContexte).compose(
						b -> configurerOpenApi(siteContexte).compose(
							c -> demarrerServeur(siteContexte)
						)
				)
		);
		etapesFutures.setHandler(demarrerFuture.completer());
	}
}
