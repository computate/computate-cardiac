package org.computate.frFR.cardiaque.utilisateur;

import org.computate.frFR.cardiaque.ecrivain.ToutEcrivain;
import org.computate.frFR.cardiaque.recherche.ResultatRecherche;
import java.util.Arrays;
import org.computate.frFR.cardiaque.recherche.ListeRecherche;
import io.vertx.ext.web.api.validation.ParameterTypeValidator;
import org.computate.frFR.cardiaque.config.ConfigSite;
import org.apache.solr.common.SolrDocumentList;
import java.util.Date;
import org.computate.frFR.cardiaque.utilisateur.UtilisateurSite;
import io.vertx.core.MultiMap;
import io.vertx.ext.web.Router;
import io.vertx.ext.reactivestreams.ReactiveReadStream;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.api.OperationResponse;
import org.apache.commons.lang3.StringUtils;
import java.math.BigDecimal;
import java.util.Map;
import org.computate.frFR.cardiaque.requete.RequeteSite;
import io.vertx.ext.web.api.contract.openapi3.OpenAPI3RouterFactory;
import io.vertx.core.json.JsonObject;
import io.vertx.core.logging.Logger;
import io.vertx.core.http.CaseInsensitiveHeaders;
import java.io.PrintWriter;
import java.util.Collection;
import java.sql.Timestamp;
import java.util.Set;
import io.netty.handler.codec.http.HttpResponseStatus;
import java.util.stream.Collectors;
import io.vertx.core.Future;
import java.time.ZoneId;
import org.computate.frFR.cardiaque.contexte.SiteContexte;
import java.util.List;
import java.security.Principal;
import java.util.stream.Stream;
import io.vertx.core.buffer.Buffer;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.http.client.utils.URLEncodedUtils;
import java.util.Optional;
import io.vertx.ext.auth.oauth2.OAuth2Auth;
import org.apache.solr.client.solrj.util.ClientUtils;
import io.vertx.ext.sql.SQLClient;
import org.apache.http.NameValuePair;
import org.apache.commons.lang3.exception.ExceptionUtils;
import io.vertx.core.json.Json;
import java.time.LocalDateTime;
import io.vertx.core.logging.LoggerFactory;
import java.util.ArrayList;
import io.vertx.core.CompositeFuture;
import java.nio.charset.Charset;
import io.vertx.ext.web.api.validation.HTTPRequestValidationHandler;
import io.vertx.core.AsyncResult;
import io.vertx.ext.web.api.validation.ValidationException;
import org.apache.solr.client.solrj.response.QueryResponse;
import io.vertx.core.Vertx;
import java.io.IOException;
import io.vertx.ext.reactivestreams.ReactiveWriteStream;
import java.util.concurrent.TimeUnit;
import org.apache.solr.common.SolrDocument;
import io.vertx.core.json.JsonArray;
import io.vertx.ext.web.api.OperationRequest;
import java.time.format.DateTimeFormatter;
import io.vertx.ext.sql.SQLConnection;
import org.apache.solr.client.solrj.SolrQuery.ORDER;
import io.vertx.core.Handler;
import java.util.Collections;


public class UtilisateurSiteGenApiServiceImpl implements UtilisateurSiteGenApiService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UtilisateurSiteGenApiServiceImpl.class);

	private static final String SERVICE_ADDRESS = "UtilisateurSiteApiServiceImpl";

	protected SiteContexte siteContexte;

	public UtilisateurSiteGenApiServiceImpl(SiteContexte siteContexte) {
		this.siteContexte = siteContexte;
		UtilisateurSiteGenApiService service = UtilisateurSiteGenApiService.creerProxy(siteContexte.getVertx(), SERVICE_ADDRESS);
	}

	public String varIndexeUtilisateurSite(String entiteVar) {
		switch(entiteVar) {
			case "calculInrPks":
				return "calculInrPks_indexed_longs";
			case "utilisateurNom":
				return "utilisateurNom_indexed_string";
			case "utilisateurMail":
				return "utilisateurMail_indexed_string";
			case "utilisateurId":
				return "utilisateurId_indexed_string";
			case "utilisateurPrenom":
				return "utilisateurPrenom_indexed_string";
			case "utilisateurNomFamille":
				return "utilisateurNomFamille_indexed_string";
			case "utilisateurNomComplet":
				return "utilisateurNomComplet_indexed_string";
			case "utilisateurSite":
				return "utilisateurSite_indexed_string";
			case "utilisateurRecevoirCourriels":
				return "utilisateurRecevoirCourriels_indexed_boolean";
			case "modeleSupprime":
				return "modeleSupprime_indexed_boolean";
			case "modeleCree":
				return "modeleCree_indexed_date";
			case "modeleModifie":
				return "modeleModifie_indexed_date";
			case "modeleClasseNomCanonique":
				return "modeleClasseNomCanonique_indexed_string";
			case "modeleCle":
				return "modeleCle_indexed_long";
			case "modeleSuggestionStocke":
				return "modeleSuggestionStocke_indexed_string";
			case "modeleSuggestionIndexe":
				return "modeleSuggestionIndexe_indexed_string";
			default:
				throw new RuntimeException(String.format("\"%s\" n'est pas une entité indexé. ", entiteVar));
		}
	}

	public Future<Void> sqlUtilisateurSite(RequeteSite requeteSite) {
		Future<Void> future = Future.future();
		try {
			SQLClient clientSql = requeteSite.getSiteContexte_().getClientSql();

			clientSql.getConnection(sqlAsync -> {
				if(sqlAsync.succeeded()) {
					requeteSite.setConnexionSql(sqlAsync.result());
					future.complete();
				}
			});
			return future;
		} catch(Exception e) {
			ExceptionUtils.printRootCauseStackTrace(e);
			return Future.failedFuture(e);
		}
	}

	// Partagé //

	public RequeteSite genererRequeteSitePourUtilisateurSite(SiteContexte siteContexte, OperationRequest operationRequete) {
		return genererRequeteSitePourUtilisateurSite(siteContexte, operationRequete, null);
	}

	public RequeteSite genererRequeteSitePourUtilisateurSite(SiteContexte siteContexte, OperationRequest operationRequete, JsonObject objetJson) {
		Vertx vertx = siteContexte.getVertx();
		RequeteSite requeteSite = new RequeteSite();
		requeteSite.setObjetJson(objetJson);
		requeteSite.setVertx(vertx);
		requeteSite.setSiteContexte_(siteContexte);
		requeteSite.setConfigSite_(siteContexte.getConfigSite());
		requeteSite.setOperationRequete(operationRequete);
		requeteSite.initLoinRequeteSite(requeteSite);

		UtilisateurSite utilisateurSite = new UtilisateurSite();
		utilisateurSite.initLoinUtilisateurSite(requeteSite);
		requeteSite.setUtilisateurSite(utilisateurSite);
		utilisateurSite.setRequeteSite_(requeteSite);
		return requeteSite;
	}

	public Future<Void> definirUtilisateurSite(UtilisateurSite o) {
		Future<Void> future = Future.future();
		try {
			RequeteSite requeteSite = o.getRequeteSite_();
			SQLConnection connexionSql = requeteSite.getConnexionSql();
			Long pk = o.getPk();
			connexionSql.queryWithParams(
					SiteContexte.SQL_definir
					, new JsonArray(Arrays.asList(pk))
					, definirAsync
			-> {
				for(JsonArray definition : definirAsync.result().getResults()) {
					o.definirPourClasse(definition.getString(0), definition.getString(1));
				}
				future.complete();
			});
		} catch(Exception e) {
			ExceptionUtils.printRootCauseStackTrace(e);
			return Future.failedFuture(e);
		}
		return future;
	}

	public Future<Void> attribuerUtilisateurSite(UtilisateurSite o) {
		Future<Void> future = Future.future();
		try {
			RequeteSite requeteSite = o.getRequeteSite_();
			SQLConnection connexionSql = requeteSite.getConnexionSql();
			Long pk = o.getPk();
			connexionSql.queryWithParams(
					SiteContexte.SQL_attribuer
					, new JsonArray(Arrays.asList(pk))
					, attribuerAsync
			-> {
				if(attribuerAsync.result() != null) {
					for(JsonArray definition : attribuerAsync.result().getResults()) {
						o.attribuerPourClasse(definition.getString(0), definition.getString(1));
					}
				}
				future.complete();
			});
		} catch(Exception e) {
			ExceptionUtils.printRootCauseStackTrace(e);
			return Future.failedFuture(e);
		}
		return future;
	}

	public Future<Void> indexerUtilisateurSite(UtilisateurSite o) {
		Future<Void> future = Future.future();
		RequeteSite requeteSite = o.getRequeteSite_();
		try {
			o.initLoinPourClasse(requeteSite);
			o.indexerPourClasse();
			future.complete();
		} catch(Exception e) {
			requeteSite.getConnexionSql().close();
			ExceptionUtils.printRootCauseStackTrace(e);
			return Future.failedFuture(e);
		}
		return future;
	}
}
