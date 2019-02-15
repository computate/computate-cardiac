package org.computate.frFR.cardiaque.cluster;

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


public class ClusterGenApiServiceImpl implements ClusterGenApiService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ClusterGenApiServiceImpl.class);

	private static final String SERVICE_ADDRESS = "ClusterApiServiceImpl";

	protected SiteContexte siteContexte;

	public ClusterGenApiServiceImpl(SiteContexte siteContexte) {
		this.siteContexte = siteContexte;
		ClusterGenApiService service = ClusterGenApiService.creerProxy(siteContexte.getVertx(), SERVICE_ADDRESS);
	}

	// Recherche //

	@Override
	public void rechercheCluster(OperationRequest operationRequete, Handler<AsyncResult<OperationResponse>> gestionnaireEvenements) {
		RequeteSite requeteSite = genererRequeteSitePourCluster(siteContexte, operationRequete);
		Future<OperationResponse> etapesFutures = rechercheCluster(requeteSite).compose(listeCluster -> 
			reponse200RechercheCluster(listeCluster)
		);
		etapesFutures.setHandler(gestionnaireEvenements);
	}

	public Future<ListeRecherche<Cluster>> rechercheCluster(RequeteSite requeteSite) {
		try {
			OperationRequest operationRequete = requeteSite.getOperationRequete();
			String entiteListeStr = requeteSite.getOperationRequete().getParams().getJsonObject("query").getString("fl");
			String[] entiteListe = entiteListeStr == null ? null : entiteListeStr.split(",\\s*");
			ListeRecherche<Cluster> listeRecherche = new ListeRecherche<Cluster>();
			listeRecherche.setQuery("*:*");
			listeRecherche.setC(Cluster.class);
			listeRecherche.setRows(1000000);
			if(entiteListe != null)
			listeRecherche.setFields(entiteListe);
			listeRecherche.addSort("partNumero_indexed_int", ORDER.asc);
			operationRequete.getParams().getJsonObject("query").forEach(paramRequete -> {
				String entiteVar = null;
				String valeurIndexe = null;
				String varIndexe = null;
				String valeurTri = null;
				Integer rechercheDebut = null;
				Integer rechercheNum = null;
				String paramNom = paramRequete.getKey();
				Object paramValeursObjet = paramRequete.getValue();
				JsonArray paramObjets = paramValeursObjet instanceof JsonArray ? (JsonArray)paramValeursObjet : new JsonArray().add(paramValeursObjet);

				for(Object paramObjet : paramObjets) {
					switch(paramNom) {
						case "q":
							entiteVar = StringUtils.trim(StringUtils.substringBefore((String)paramObjet, ":"));
							valeurIndexe = StringUtils.trim(StringUtils.substringAfter((String)paramObjet, ":"));
							varIndexe = "*".equals(entiteVar) ? entiteVar : varIndexeCluster(entiteVar);
							listeRecherche.setQuery(varIndexe + ":" + ("*".equals(valeurIndexe) ? valeurIndexe : ClientUtils.escapeQueryChars(valeurIndexe)));
							break;
						case "fq":
							entiteVar = StringUtils.trim(StringUtils.substringBefore((String)paramObjet, ":"));
							valeurIndexe = StringUtils.trim(StringUtils.substringAfter((String)paramObjet, ":"));
							varIndexe = varIndexeCluster(entiteVar);
							listeRecherche.addFilterQuery(varIndexe + ":" + ClientUtils.escapeQueryChars(valeurIndexe));
							break;
						case "sort":
							entiteVar = StringUtils.trim(StringUtils.substringBefore((String)paramObjet, " "));
							valeurTri = StringUtils.trim(StringUtils.substringAfter((String)paramObjet, " "));
							varIndexe = varIndexeCluster(entiteVar);
							listeRecherche.addSort(varIndexe, ORDER.valueOf(valeurTri));
							break;
						case "fl":
							entiteVar = StringUtils.trim((String)paramObjet);
							varIndexe = varIndexeCluster(entiteVar);
							listeRecherche.addField(varIndexe);
							break;
						case "start":
							rechercheDebut = (Integer)paramObjet;
							listeRecherche.setStart(rechercheDebut);
							break;
						case "rows":
							rechercheNum = (Integer)paramObjet;
							listeRecherche.setRows(rechercheNum);
							break;
					}
				}
			});
			listeRecherche.initLoinPourClasse(requeteSite);
			return Future.succeededFuture(listeRecherche);
		} catch(Exception e) {
			ExceptionUtils.printRootCauseStackTrace(e);
			return Future.failedFuture(e);
		}
	}

	public Future<OperationResponse> reponse200RechercheCluster(ListeRecherche<Cluster> listeCluster) {
		try {
			Buffer buffer = Buffer.buffer();
			RequeteSite requeteSite = listeCluster.getRequeteSite_();
			ToutEcrivain w = ToutEcrivain.creer(listeCluster.getRequeteSite_(), buffer);
			QueryResponse reponseRecherche = listeCluster.getQueryResponse();
			SolrDocumentList documentsSolr = listeCluster.getSolrDocumentList();
			Long millisRecherche = Long.valueOf(reponseRecherche.getQTime());
			Long millisTransmission = reponseRecherche.getElapsedTime();
			Long numCommence = reponseRecherche.getResults().getStart();
			Long numTrouve = reponseRecherche.getResults().getNumFound();
			Integer numRetourne = reponseRecherche.getResults().size();
			String tempsRecherche = String.format("%d.%03d sec", TimeUnit.MILLISECONDS.toSeconds(millisRecherche), TimeUnit.MILLISECONDS.toMillis(millisRecherche) - TimeUnit.SECONDS.toMillis(TimeUnit.MILLISECONDS.toSeconds(millisRecherche)));
			String tempsTransmission = String.format("%d.%03d sec", TimeUnit.MILLISECONDS.toSeconds(millisTransmission), TimeUnit.MILLISECONDS.toMillis(millisTransmission) - TimeUnit.SECONDS.toSeconds(TimeUnit.MILLISECONDS.toSeconds(millisTransmission)));
			Exception exceptionRecherche = reponseRecherche.getException();

			w.l("{");
			w.tl(1, "\"numCommence\": ", numCommence);
			w.tl(1, ", \"numTrouve\": ", numTrouve);
			w.tl(1, ", \"numRetourne\": ", numRetourne);
			w.tl(1, ", \"tempsRecherche\": ", w.q(tempsRecherche));
			w.tl(1, ", \"tempsTransmission\": ", w.q(tempsTransmission));
			w.tl(1, ", \"liste\": [");
			for(int i = 0; i < documentsSolr.size(); i++) {
				SolrDocument documentSolr = documentsSolr.get(i);
				Object entiteValeur;
				Integer entiteNumero = 0;

				w.t(2);
				if(i > 0)
					w.s(", ");
				w.s("{");

			entiteValeur = Optional.ofNullable(documentSolr.getFieldValues("pk_stored_long")).map(Collection<Object>::stream).orElseGet(Stream::empty).findFirst().orElse(null);
			if(entiteValeur != null)
				w.l(entiteNumero++ == 0 ? "" : ", ", "\"pk\": ", entiteValeur);

			entiteValeur = Optional.ofNullable(documentSolr.getFieldValues("utilisateurId_stored_string")).map(Collection<Object>::stream).orElseGet(Stream::empty).findFirst().orElse(null);
			if(entiteValeur != null)
				w.l(entiteNumero++ == 0 ? "" : ", ", "\"utilisateurId\": ", w.q(entiteValeur));

			entiteValeur = Optional.ofNullable(documentSolr.getFieldValues("cree_stored_date")).map(Collection<Object>::stream).orElseGet(Stream::empty).findFirst().orElse(null);
			if(entiteValeur != null)
				w.l(entiteNumero++ == 0 ? "" : ", ", "\"cree\": ", w.q(entiteValeur));

			entiteValeur = Optional.ofNullable(documentSolr.getFieldValues("modifie_stored_date")).map(Collection<Object>::stream).orElseGet(Stream::empty).findFirst().orElse(null);
			if(entiteValeur != null)
				w.l(entiteNumero++ == 0 ? "" : ", ", "\"modifie\": ", w.q(entiteValeur));

			entiteValeur = Optional.ofNullable(documentSolr.getFieldValues("clusterNomCanonique_stored_string")).map(Collection<Object>::stream).orElseGet(Stream::empty).findFirst().orElse(null);
			if(entiteValeur != null)
				w.l(entiteNumero++ == 0 ? "" : ", ", "\"clusterNomCanonique\": ", w.q(entiteValeur));

			entiteValeur = Optional.ofNullable(documentSolr.getFieldValues("clusterNomSimple_stored_string")).map(Collection<Object>::stream).orElseGet(Stream::empty).findFirst().orElse(null);
			if(entiteValeur != null)
				w.l(entiteNumero++ == 0 ? "" : ", ", "\"clusterNomSimple\": ", w.q(entiteValeur));

				w.tl(2, "}");
			}
			w.tl(1, "]");
			if(exceptionRecherche != null) {
				w.tl(1, ", \"exceptionRecherche\": ", w.q(exceptionRecherche.getMessage()));
			}
			w.l("}");
			return Future.succeededFuture(OperationResponse.completedWithJson(buffer));
		} catch(Exception e) {
			ExceptionUtils.printRootCauseStackTrace(e);
			return Future.failedFuture(e);
		}
	}

	// POST //

	@Override
	public void postCluster(JsonObject objetJson, OperationRequest operationRequete, Handler<AsyncResult<OperationResponse>> gestionnaireEvenements) {
		RequeteSite requeteSite = genererRequeteSitePourCluster(siteContexte, operationRequete, objetJson);
		Future<OperationResponse> etapesFutures = sqlCluster(requeteSite).compose(a -> 
			creerPOSTCluster(requeteSite).compose(cluster -> 
				sqlPOSTCluster(cluster).compose(c -> 
					definirCluster(cluster).compose(d -> 
						attribuerCluster(cluster).compose(e -> 
							indexerCluster(cluster).compose(f -> 
								reponse200POSTCluster(cluster)
							)
						)
					)
				)
			)
		);
		etapesFutures.setHandler(gestionnaireEvenements);
	}

	public Future<Cluster> creerPOSTCluster(RequeteSite requeteSite) {
		Future<Cluster> future = Future.future();
		try {
			SQLConnection connexionSql = requeteSite.getConnexionSql();
			String utilisateurId = requeteSite.getUtilisateurId();

			connexionSql.queryWithParams(
					SiteContexte.SQL_creer
					, new JsonArray(Arrays.asList(Cluster.class.getCanonicalName(), utilisateurId))
					, creerAsync
			-> {
				JsonArray patchLigne = creerAsync.result().getResults().stream().findFirst().orElseGet(() -> null);
				Long pk = patchLigne.getLong(0);
				Cluster o = new Cluster();
				o.setPk(pk);
				o.initLoinCluster(requeteSite);
				future.complete(o);
			});
			return future;
		} catch(Exception e) {
			ExceptionUtils.printRootCauseStackTrace(e);
			return Future.failedFuture(e);
		}
	}

	public Future<Void> sqlPOSTCluster(Cluster o) {
		Future<Void> future = Future.future();
		try {
			RequeteSite requeteSite = o.getRequeteSite_();
			SQLConnection connexionSql = requeteSite.getConnexionSql();
			Long pk = o.getPk();
			JsonObject jsonObject = requeteSite.getObjetJson();
			StringBuilder postSql = new StringBuilder();
			List<Object> postSqlParams = new ArrayList<Object>();

			if(jsonObject != null) {
				Set<String> entiteVars = jsonObject.fieldNames();
				for(String entiteVar : entiteVars) {
					switch(entiteVar) {
					case "pk":
						postSql.append(SiteContexte.SQL_setP);
						postSqlParams.addAll(Arrays.asList("pk", jsonObject.getLong(entiteVar), pk));
						break;
					case "id":
						postSql.append(SiteContexte.SQL_setP);
						postSqlParams.addAll(Arrays.asList("id", jsonObject.getString(entiteVar), pk));
						break;
					case "supprime":
						postSql.append(SiteContexte.SQL_setP);
						postSqlParams.addAll(Arrays.asList("supprime", jsonObject.getBoolean(entiteVar), pk));
						break;
					case "utilisateurId":
						postSql.append(SiteContexte.SQL_setP);
						postSqlParams.addAll(Arrays.asList("utilisateurId", jsonObject.getString(entiteVar), pk));
						break;
					case "cree":
						postSql.append(SiteContexte.SQL_setP);
						postSqlParams.addAll(Arrays.asList("cree", jsonObject.getInstant(entiteVar), pk));
						break;
					case "modifie":
						postSql.append(SiteContexte.SQL_setP);
						postSqlParams.addAll(Arrays.asList("modifie", jsonObject.getInstant(entiteVar), pk));
						break;
					case "clusterNomCanonique":
						postSql.append(SiteContexte.SQL_setP);
						postSqlParams.addAll(Arrays.asList("clusterNomCanonique", jsonObject.getString(entiteVar), pk));
						break;
					case "clusterNomSimple":
						postSql.append(SiteContexte.SQL_setP);
						postSqlParams.addAll(Arrays.asList("clusterNomSimple", jsonObject.getString(entiteVar), pk));
						break;
					}
				}
			}
			connexionSql.queryWithParams(
					postSql.toString()
					, new JsonArray(postSqlParams)
					, postAsync
			-> {
				future.complete();
			});
			return future;
		} catch(Exception e) {
			ExceptionUtils.printRootCauseStackTrace(e);
			return Future.failedFuture(e);
		}
	}

	public Future<OperationResponse> reponse200POSTCluster(Cluster o) {
		try {
			Buffer buffer = Buffer.buffer();
			RequeteSite requeteSite = o.getRequeteSite_();
			ToutEcrivain w = ToutEcrivain.creer(o.getRequeteSite_(), buffer);
			return Future.succeededFuture(OperationResponse.completedWithJson(buffer));
		} catch(Exception e) {
			ExceptionUtils.printRootCauseStackTrace(e);
			return Future.failedFuture(e);
		}
	}

	// PATCH //

	@Override
	public void patchCluster(JsonObject objetJson, OperationRequest operationRequete, Handler<AsyncResult<OperationResponse>> gestionnaireEvenements) {
		RequeteSite requeteSite = genererRequeteSitePourCluster(siteContexte, operationRequete, objetJson);
		Future<OperationResponse> etapesFutures = sqlCluster(requeteSite).compose(a -> 
			rechercheCluster(requeteSite).compose(listeCluster-> 
				listePATCHCluster(listeCluster)
			)
		);
		etapesFutures.setHandler(gestionnaireEvenements);
	}

	public Future<OperationResponse> listePATCHCluster(ListeRecherche<Cluster> listeCluster) {
		List<Future> futures = new ArrayList<>();
		listeCluster.getList().forEach(o -> {
			futures.add(
				sqlPATCHCluster(o).compose(
					b -> indexerCluster(o)
				)
			);
		});
		Future<OperationResponse> future = CompositeFuture.all(futures).compose( a -> 
			reponse200PATCHCluster(listeCluster)
		);
		return future;
	}

	public Future<Void> sqlPATCHCluster(Cluster o) {
		Future<Void> future = Future.future();
		try {
			RequeteSite requeteSite = o.getRequeteSite_();
			SQLConnection connexionSql = requeteSite.getConnexionSql();
			Long pk = o.getPk();
			JsonObject requeteJson = requeteSite.getObjetJson();
			StringBuilder patchSql = new StringBuilder();
			List<Object> patchSqlParams = new ArrayList<Object>();
			Set<String> methodeNoms = requeteJson.fieldNames();

			for(String methodeNom : methodeNoms) {
				switch(methodeNom) {
					case "setPk":
						patchSql.append(SiteContexte.SQL_setP);
						patchSqlParams.addAll(Arrays.asList("pk", requeteJson.getLong(methodeNom), pk));
						break;
					case "setId":
						patchSql.append(SiteContexte.SQL_setP);
						patchSqlParams.addAll(Arrays.asList("id", requeteJson.getString(methodeNom), pk));
						break;
					case "setSupprime":
						patchSql.append(SiteContexte.SQL_setP);
						patchSqlParams.addAll(Arrays.asList("supprime", requeteJson.getBoolean(methodeNom), pk));
						break;
					case "setUtilisateurId":
						patchSql.append(SiteContexte.SQL_setP);
						patchSqlParams.addAll(Arrays.asList("utilisateurId", requeteJson.getString(methodeNom), pk));
						break;
					case "setCree":
						patchSql.append(SiteContexte.SQL_setP);
						patchSqlParams.addAll(Arrays.asList("cree", requeteJson.getInstant(methodeNom), pk));
						break;
					case "setModifie":
						patchSql.append(SiteContexte.SQL_setP);
						patchSqlParams.addAll(Arrays.asList("modifie", requeteJson.getInstant(methodeNom), pk));
						break;
					case "setClusterNomCanonique":
						patchSql.append(SiteContexte.SQL_setP);
						patchSqlParams.addAll(Arrays.asList("clusterNomCanonique", requeteJson.getString(methodeNom), pk));
						break;
					case "setClusterNomSimple":
						patchSql.append(SiteContexte.SQL_setP);
						patchSqlParams.addAll(Arrays.asList("clusterNomSimple", requeteJson.getString(methodeNom), pk));
						break;
				}
			}
			connexionSql.queryWithParams(
					patchSql.toString()
					, new JsonArray(patchSqlParams)
					, patchAsync
			-> {
				future.complete();
			});
			return future;
		} catch(Exception e) {
			ExceptionUtils.printRootCauseStackTrace(e);
			return Future.failedFuture(e);
		}
	}

	public Future<OperationResponse> reponse200PATCHCluster(ListeRecherche<Cluster> listeCluster) {
		try {
			Buffer buffer = Buffer.buffer();
			ToutEcrivain w = ToutEcrivain.creer(listeCluster.getRequeteSite_(), buffer);
			return Future.succeededFuture(OperationResponse.completedWithJson(buffer));
		} catch(Exception e) {
			ExceptionUtils.printRootCauseStackTrace(e);
			return Future.failedFuture(e);
		}
	}

	// GET //

	@Override
	public void getCluster(OperationRequest operationRequete, Handler<AsyncResult<OperationResponse>> gestionnaireEvenements) {
		RequeteSite requeteSite = genererRequeteSitePourCluster(siteContexte, operationRequete);
		Future<OperationResponse> etapesFutures = rechercheCluster(requeteSite).compose(listeCluster -> 
			reponse200GETCluster(listeCluster)
		);
		etapesFutures.setHandler(gestionnaireEvenements);
	}

	public Future<OperationResponse> reponse200GETCluster(ListeRecherche<Cluster> listeCluster) {
		try {
			Buffer buffer = Buffer.buffer();
			ToutEcrivain w = ToutEcrivain.creer(listeCluster.getRequeteSite_(), buffer);
			SolrDocumentList documentsSolr = listeCluster.getSolrDocumentList();

			if(documentsSolr.size() > 0) {
				SolrDocument documentSolr = documentsSolr.get(0);
				Object entiteValeur;
				Integer entiteNumero = 0;

				w.l("{");

			entiteValeur = Optional.ofNullable(documentSolr.getFieldValues("pk_stored_long")).map(Collection<Object>::stream).orElseGet(Stream::empty).findFirst().orElse(null);
			if(entiteValeur != null)
				w.l(entiteNumero++ == 0 ? "" : ", ", "\"pk\": ", entiteValeur);

			entiteValeur = Optional.ofNullable(documentSolr.getFieldValues("utilisateurId_stored_string")).map(Collection<Object>::stream).orElseGet(Stream::empty).findFirst().orElse(null);
			if(entiteValeur != null)
				w.l(entiteNumero++ == 0 ? "" : ", ", "\"utilisateurId\": ", w.q(entiteValeur));

			entiteValeur = Optional.ofNullable(documentSolr.getFieldValues("cree_stored_date")).map(Collection<Object>::stream).orElseGet(Stream::empty).findFirst().orElse(null);
			if(entiteValeur != null)
				w.l(entiteNumero++ == 0 ? "" : ", ", "\"cree\": ", w.q(entiteValeur));

			entiteValeur = Optional.ofNullable(documentSolr.getFieldValues("modifie_stored_date")).map(Collection<Object>::stream).orElseGet(Stream::empty).findFirst().orElse(null);
			if(entiteValeur != null)
				w.l(entiteNumero++ == 0 ? "" : ", ", "\"modifie\": ", w.q(entiteValeur));

			entiteValeur = Optional.ofNullable(documentSolr.getFieldValues("clusterNomCanonique_stored_string")).map(Collection<Object>::stream).orElseGet(Stream::empty).findFirst().orElse(null);
			if(entiteValeur != null)
				w.l(entiteNumero++ == 0 ? "" : ", ", "\"clusterNomCanonique\": ", w.q(entiteValeur));

			entiteValeur = Optional.ofNullable(documentSolr.getFieldValues("clusterNomSimple_stored_string")).map(Collection<Object>::stream).orElseGet(Stream::empty).findFirst().orElse(null);
			if(entiteValeur != null)
				w.l(entiteNumero++ == 0 ? "" : ", ", "\"clusterNomSimple\": ", w.q(entiteValeur));

				w.l("}");
			}
			return Future.succeededFuture(OperationResponse.completedWithJson(buffer));
		} catch(Exception e) {
			ExceptionUtils.printRootCauseStackTrace(e);
			return Future.failedFuture(e);
		}
	}

	// PUT //

	@Override
	public void putCluster(JsonObject objetJson, OperationRequest operationRequete, Handler<AsyncResult<OperationResponse>> gestionnaireEvenements) {
		RequeteSite requeteSite = genererRequeteSitePourCluster(siteContexte, operationRequete, objetJson);
		Future<OperationResponse> etapesFutures = sqlCluster(requeteSite).compose(a -> 
			remplacerPUTCluster(requeteSite).compose(cluster -> 
				sqlPUTCluster(cluster).compose(c -> 
					definirCluster(cluster).compose(d -> 
						attribuerCluster(cluster).compose(e -> 
						indexerCluster(cluster).compose(f -> 
							reponse200PUTCluster(cluster)
							)
						)
					)
				)
			)
		);
		etapesFutures.setHandler(gestionnaireEvenements);
	}

	public Future<Cluster> remplacerPUTCluster(RequeteSite requeteSite) {
		Future<Cluster> future = Future.future();
		try {
			SQLConnection connexionSql = requeteSite.getConnexionSql();
			String utilisateurId = requeteSite.getUtilisateurId();
			Long pk = requeteSite.getRequetePk();

			connexionSql.queryWithParams(
					SiteContexte.SQL_vider
					, new JsonArray(Arrays.asList(pk, Cluster.class.getCanonicalName(), pk, pk, pk))
					, remplacerAsync
			-> {
				Cluster o = new Cluster();
				o.setPk(pk);
				future.complete(o);
			});
			return future;
		} catch(Exception e) {
			ExceptionUtils.printRootCauseStackTrace(e);
			return Future.failedFuture(e);
		}
	}

	public Future<Void> sqlPUTCluster(Cluster o) {
		Future<Void> future = Future.future();
		try {
			RequeteSite requeteSite = o.getRequeteSite_();
			SQLConnection connexionSql = requeteSite.getConnexionSql();
			Long pk = o.getPk();
			JsonObject jsonObject = requeteSite.getObjetJson();
			StringBuilder postSql = new StringBuilder();
			List<Object> postSqlParams = new ArrayList<Object>();

			if(jsonObject != null) {
				Set<String> entiteVars = jsonObject.fieldNames();
				for(String entiteVar : entiteVars) {
					switch(entiteVar) {
					case "pk":
						postSql.append(SiteContexte.SQL_setP);
						postSqlParams.addAll(Arrays.asList("pk", jsonObject.getLong(entiteVar), pk));
						break;
					case "id":
						postSql.append(SiteContexte.SQL_setP);
						postSqlParams.addAll(Arrays.asList("id", jsonObject.getString(entiteVar), pk));
						break;
					case "supprime":
						postSql.append(SiteContexte.SQL_setP);
						postSqlParams.addAll(Arrays.asList("supprime", jsonObject.getBoolean(entiteVar), pk));
						break;
					case "utilisateurId":
						postSql.append(SiteContexte.SQL_setP);
						postSqlParams.addAll(Arrays.asList("utilisateurId", jsonObject.getString(entiteVar), pk));
						break;
					case "cree":
						postSql.append(SiteContexte.SQL_setP);
						postSqlParams.addAll(Arrays.asList("cree", jsonObject.getInstant(entiteVar), pk));
						break;
					case "modifie":
						postSql.append(SiteContexte.SQL_setP);
						postSqlParams.addAll(Arrays.asList("modifie", jsonObject.getInstant(entiteVar), pk));
						break;
					case "clusterNomCanonique":
						postSql.append(SiteContexte.SQL_setP);
						postSqlParams.addAll(Arrays.asList("clusterNomCanonique", jsonObject.getString(entiteVar), pk));
						break;
					case "clusterNomSimple":
						postSql.append(SiteContexte.SQL_setP);
						postSqlParams.addAll(Arrays.asList("clusterNomSimple", jsonObject.getString(entiteVar), pk));
						break;
					}
				}
			}
			connexionSql.queryWithParams(
					postSql.toString()
					, new JsonArray(postSqlParams)
					, postAsync
			-> {
				future.complete();
			});
			return future;
		} catch(Exception e) {
			ExceptionUtils.printRootCauseStackTrace(e);
			return Future.failedFuture(e);
		}
	}

	public Future<OperationResponse> reponse200PUTCluster(Cluster o) {
		try {
			Buffer buffer = Buffer.buffer();
			RequeteSite requeteSite = o.getRequeteSite_();
			ToutEcrivain w = ToutEcrivain.creer(o.getRequeteSite_(), buffer);
			return Future.succeededFuture(OperationResponse.completedWithJson(buffer));
		} catch(Exception e) {
			ExceptionUtils.printRootCauseStackTrace(e);
			return Future.failedFuture(e);
		}
	}

	// DELETE //

	@Override
	public void deleteCluster(OperationRequest operationRequete, Handler<AsyncResult<OperationResponse>> gestionnaireEvenements) {
		RequeteSite requeteSite = genererRequeteSitePourCluster(siteContexte, operationRequete);
		Future<OperationResponse> etapesFutures = sqlCluster(requeteSite).compose(a -> 
			rechercheCluster(requeteSite).compose(cluster -> 
				supprimerDELETECluster(requeteSite).compose(c -> 
					reponse200DELETECluster(requeteSite)
				)
			)
		);
		etapesFutures.setHandler(gestionnaireEvenements);
	}

	public Future<Void> supprimerDELETECluster(RequeteSite requeteSite) {
		Future<Void> future = Future.future();
		try {
			SQLConnection connexionSql = requeteSite.getConnexionSql();
			String utilisateurId = requeteSite.getUtilisateurId();
			Long pk = requeteSite.getRequetePk();

			connexionSql.queryWithParams(
					SiteContexte.SQL_supprimer
					, new JsonArray(Arrays.asList(pk, Cluster.class.getCanonicalName(), pk, pk, pk, pk))
					, supprimerAsync
			-> {
				future.complete();
			});
			return future;
		} catch(Exception e) {
			ExceptionUtils.printRootCauseStackTrace(e);
			return Future.failedFuture(e);
		}
	}

	public Future<OperationResponse> reponse200DELETECluster(RequeteSite requeteSite) {
		try {
			Buffer buffer = Buffer.buffer();
			ToutEcrivain w = ToutEcrivain.creer(requeteSite, buffer);
			return Future.succeededFuture(OperationResponse.completedWithJson(buffer));
		} catch(Exception e) {
			ExceptionUtils.printRootCauseStackTrace(e);
			return Future.failedFuture(e);
		}
	}

	public String varIndexeCluster(String entiteVar) {
		switch(entiteVar) {
			case "pk":
				return "pk_indexed_long";
			case "utilisateurId":
				return "utilisateurId_indexed_string";
			case "cree":
				return "cree_indexed_date";
			case "modifie":
				return "modifie_indexed_date";
			case "clusterNomCanonique":
				return "clusterNomCanonique_indexed_string";
			case "clusterNomSimple":
				return "clusterNomSimple_indexed_string";
			default:
				throw new RuntimeException(String.format("\"%s\" n'est pas une entité indexé. ", entiteVar));
		}
	}

	public Future<Void> sqlCluster(RequeteSite requeteSite) {
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

	public RequeteSite genererRequeteSitePourCluster(SiteContexte siteContexte, OperationRequest operationRequete) {
		return genererRequeteSitePourCluster(siteContexte, operationRequete, null);
	}

	public RequeteSite genererRequeteSitePourCluster(SiteContexte siteContexte, OperationRequest operationRequete, JsonObject objetJson) {
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

	public Future<Void> definirCluster(Cluster o) {
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

	public Future<Void> attribuerCluster(Cluster o) {
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

	public Future<Void> indexerCluster(Cluster o) {
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
