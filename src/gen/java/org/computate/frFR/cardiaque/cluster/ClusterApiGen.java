package org.computate.frFR.cardiaque.cluster;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrQuery.ORDER;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.util.ClientUtils;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.computate.frFR.cardiaque.contexte.SiteContexte;
import org.computate.frFR.cardiaque.recherche.ListeRecherche;
import org.computate.frFR.cardiaque.recherche.ResultatRecherche;
import org.computate.frFR.cardiaque.requete.RequeteSite;
import org.computate.frFR.cardiaque.utilisateur.UtilisateurSite;

import io.vertx.core.AsyncResult;
import io.vertx.core.CompositeFuture;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.MultiMap;
import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.ext.sql.SQLClient;
import io.vertx.ext.sql.SQLConnection;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.api.OperationResponse;
import io.vertx.ext.web.api.contract.openapi3.OpenAPI3RouterFactory;
import io.vertx.ext.web.api.validation.ValidationException;


public class ClusterApiGen implements ClusterApiService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ClusterApiGen.class);

	private static final String SERVICE_ADDRESS = "ClusterApi";

	protected SiteContexte siteContexte;

	public ClusterApiGen(SiteContexte siteContexte) {
		this.siteContexte = siteContexte;
		ClusterApiService service = ClusterApiService.createProxy(siteContexte.getVertx(), SERVICE_ADDRESS);
	}

	public void handleGetCluster(SiteContexte siteContexte) {
		OpenAPI3RouterFactory usineRouteur = siteContexte.getUsineRouteur();

		usineRouteur.addHandlerByOperationId("getCluster", contexteItineraire -> {
			try {

				contexteItineraire.response().putHeader("content-type", "application/json").setChunked(true);
				RequeteSite requeteSite = genererRequeteSitePourCluster(siteContexte);
				SolrQuery rechercheSolr = requeteSite.getRechercheSolr();
				SolrDocumentList resultatsRecherche = requeteSite.getReponseRecherche().getResults();
				Integer rechercheLignes = rechercheSolr.getRows();

				genererGetDebutCluster(requeteSite);
				for(long i = resultatsRecherche.getStart(); i < resultatsRecherche.getNumFound(); i+=rechercheLignes) {
					for(int j = 0; j < resultatsRecherche.size(); j++) {
						long resultatIndice = i + j;
						SolrDocument documentSolr = resultatsRecherche.get(j);
						ResultatRecherche resultatRecherche = new ResultatRecherche();
						resultatRecherche.setRequeteSite_(requeteSite);
						resultatRecherche.setDocumentSolr(documentSolr);
						resultatRecherche.setResultatIndice(resultatIndice);
						genererGetIndividuelCluster(resultatRecherche);
					}
				}
				genererGetFinCluster(requeteSite);
				requeteSite.getReponseServeur().end();
			} catch(Exception e) {
				LOGGER.error("Error: ", e.getMessage());
				contexteItineraire.fail(e);
			}
		});
		usineRouteur.addFailureHandlerByOperationId("getCluster", contexteItineraire -> {
			Throwable failure = contexteItineraire.failure();
			if (failure instanceof ValidationException) {
				String validationErrorMessage = failure.getMessage();
				LOGGER.error("Error: ", validationErrorMessage);
				contexteItineraire.fail(failure);
			}
		});
	}

	public void genererGetDebutCluster(RequeteSite requeteSite) {
		HttpServerResponse reponseServeur = requeteSite.getReponseServeur();
		QueryResponse reponseRecherche = requeteSite.getReponseRecherche();
		reponseServeur.write("{\n");
		Long millisRecherche = Long.valueOf(reponseRecherche.getQTime());
		Long millisTransmission = reponseRecherche.getElapsedTime();
		Long numCommence = reponseRecherche.getResults().getStart();
		Long numTrouve = reponseRecherche.getResults().getNumFound();
		Integer numRetourne = reponseRecherche.getResults().size();
		String tempsRecherche = String.format("%d.%03d sec", TimeUnit.MILLISECONDS.toSeconds(millisRecherche), TimeUnit.MILLISECONDS.toMillis(millisRecherche) - TimeUnit.SECONDS.toMillis(TimeUnit.MILLISECONDS.toSeconds(millisRecherche)));
		String tempsTransmission = String.format("%d.%03d sec", TimeUnit.MILLISECONDS.toSeconds(millisTransmission), TimeUnit.MILLISECONDS.toMillis(millisTransmission) - TimeUnit.SECONDS.toSeconds(TimeUnit.MILLISECONDS.toSeconds(millisTransmission)));
		Exception exceptionRecherche = reponseRecherche.getException();

		reponseServeur.write("\t\"numCommence\": ");
		reponseServeur.write(numCommence.toString());

		reponseServeur.write(",\n\t\"numTrouve\": ");
		reponseServeur.write(numTrouve.toString());

		reponseServeur.write(",\n\t\"numRetourne\": ");
		reponseServeur.write(numRetourne.toString());

		reponseServeur.write(",\n\t\"tempsRecherche\": \"");
		reponseServeur.write(tempsRecherche);
		reponseServeur.write("\"");

		reponseServeur.write(",\n\t\"tempsTransmission\": \"");
		reponseServeur.write(tempsTransmission);
		reponseServeur.write("\"");

		if(exceptionRecherche != null) {
			reponseServeur.write(",\n\t\"exceptionRecherche\": \"");
			reponseServeur.write(exceptionRecherche.getMessage());
			reponseServeur.write("\"");
		}

		reponseServeur.write(",\n\t\"resultats\": [\n");
	}

	public void genererGetIndividuelCluster(ResultatRecherche resultatRecherche) throws Exception {
		RequeteSite requeteSite = resultatRecherche.getRequeteSite_();
		SolrDocument documentSolr = resultatRecherche.getDocumentSolr();
		Long resultatIndice = resultatRecherche.getResultatIndice();
		HttpServerResponse reponseServeur = requeteSite.getReponseServeur();
		reponseServeur.write("\t\t");
		if(resultatIndice > 0)
			reponseServeur.write(", ");
		reponseServeur.write("{\n");
		Collection<String> champNoms = documentSolr.getFieldNames();
		Integer j = 0;
		for(String champNomStocke : champNoms) {
			Collection<Object> champValeurs = documentSolr.getFieldValues(champNomStocke);
			j = genererGetCluster(j, resultatRecherche, champNomStocke, champValeurs);
		}
		reponseServeur.write("\t\t}\n");
	}

	public void genererGetFinCluster(RequeteSite requeteSite) {
		HttpServerResponse reponseServeur = requeteSite.getReponseServeur();
		reponseServeur.write("\t]\n");
		reponseServeur.write("}\n");
	}

	public String varIndexeCluster(String entiteVar) throws Exception {
		switch(entiteVar) {
			case "pk":
				return "pk_indexed_long";
			case "cree":
				return "cree_indexed_date";
			case "modifie":
				return "modifie_indexed_date";
			case "utilisateurId":
				return "utilisateurId_indexed_string";
			case "clusterNomCanonique":
				return "clusterNomCanonique_indexed_string";
			case "clusterNomSimple":
				return "clusterNomSimple_indexed_string";
			default:
				throw new Exception(String.format("\"%s\" n'est pas une entité indexé. ", entiteVar));
		}
	}

	public Future<ListeRecherche<Cluster>> rechercheCluster(RequeteSite requeteSite) {
		String entiteVar = null;
		String valeurIndexe = null;
		String varIndexe = null;
		String valeurTri = null;
		Integer rechercheDebut = null;
		Integer rechercheNum = null;
		ListeRecherche<Cluster> listeRecherche = new ListeRecherche<Cluster>();
		listeRecherche.setQuery("*:*");
		listeRecherche.setRows(1000000);
		listeRecherche.addSort("partNumero_indexed_int", ORDER.asc);
		MultiMap paramMap = requeteSite.getRequeteServeur().params();
		for(String paramCle : paramMap.names()) {
			List<String> paramValeurs = paramMap.getAll(paramCle);
			for(String paramValeur : paramValeurs) {
				try {
					switch(paramCle) {
						case "q":
							entiteVar = StringUtils.trim(StringUtils.substringBefore(paramValeur, ":"));
							valeurIndexe = StringUtils.trim(StringUtils.substringAfter(paramValeur, ":"));
							varIndexe = varIndexeCluster(paramCle);
							listeRecherche.setQuery(varIndexe + ":" + ClientUtils.escapeQueryChars(valeurIndexe));
							break;
						case "fq":
							entiteVar = StringUtils.trim(StringUtils.substringBefore(paramValeur, ":"));
							valeurIndexe = StringUtils.trim(StringUtils.substringAfter(paramValeur, ":"));
							varIndexe = varIndexeCluster(paramCle);
							listeRecherche.addFilterQuery(varIndexe + ":" + ClientUtils.escapeQueryChars(valeurIndexe));
							break;
						case "sort":
							entiteVar = StringUtils.trim(StringUtils.substringBefore(paramValeur, " "));
							valeurTri = StringUtils.trim(StringUtils.substringAfter(paramValeur, " "));
							varIndexe = varIndexeCluster(paramCle);
							listeRecherche.addSort(varIndexe, ORDER.valueOf(valeurTri));
							break;
						case "fl":
							entiteVar = StringUtils.trim(paramValeur);
							varIndexe = varIndexeCluster(paramCle);
							listeRecherche.addField(varIndexe);
							break;
						case "start":
							rechercheDebut = Integer.parseInt(paramValeur);
							listeRecherche.setStart(rechercheDebut);
							break;
						case "rows":
							rechercheNum = Integer.parseInt(paramValeur);
							listeRecherche.setRows(rechercheNum);
							break;
					}
				} catch(Exception e) {
					return Future.failedFuture(e);
				}
			}
		}
		listeRecherche.initLoinPourClasse(requeteSite);
		return Future.succeededFuture(listeRecherche);
	}

	public RequeteSite genererRequeteSitePourCluster(SiteContexte siteContexte) throws Exception {
		Vertx vertx = siteContexte.getVertx();
		RequeteSite requeteSite = new RequeteSite();
		requeteSite.setVertx(vertx);
		requeteSite.setSiteContexte_(siteContexte);
		requeteSite.initLoinRequeteSite(requeteSite);

		UtilisateurSite utilisateurSite = new UtilisateurSite();
		utilisateurSite.initLoinUtilisateurSite(requeteSite);
		requeteSite.setUtilisateurSite(utilisateurSite);
		utilisateurSite.setRequeteSite_(requeteSite);
		return requeteSite;
	}

	public Integer genererGetCluster(Integer j, ResultatRecherche resultatRecherche, String entiteVarStocke, Collection<Object> champValeurs) throws Exception {
		RequeteSite requeteSite = resultatRecherche.getRequeteSite_();
		HttpServerResponse reponseServeur = requeteSite.getReponseServeur();
		if(!champValeurs.isEmpty()) {
			Object champValeur = champValeurs.iterator().next();
			if(champValeur != null) {
				if("pk".equals(entiteVarStocke)) {
					if(j > 0)
						reponseServeur.write(", ");
					reponseServeur.write("\"pk\": ");
					reponseServeur.write(((Long)champValeur).toString());
					reponseServeur.write("\n");
					j++;
					return j;
				}
				if("cree".equals(entiteVarStocke)) {
					if(j > 0)
						reponseServeur.write(", ");
					reponseServeur.write("\"cree\": \"");
					reponseServeur.write(DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(((Date)champValeur).toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime()));
					reponseServeur.write("\"\n");
					j++;
					return j;
				}
				if("modifie".equals(entiteVarStocke)) {
					if(j > 0)
						reponseServeur.write(", ");
					reponseServeur.write("\"modifie\": \"");
					reponseServeur.write(DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(((Date)champValeur).toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime()));
					reponseServeur.write("\"\n");
					j++;
					return j;
				}
				if("utilisateurId".equals(entiteVarStocke)) {
					if(j > 0)
						reponseServeur.write(", ");
					reponseServeur.write("\"utilisateurId\": \"");
					reponseServeur.write(Json.encode((String)champValeurs.iterator().next()));
					reponseServeur.write("\"\n");
					j++;
					return j;
				}
				if("clusterNomCanonique".equals(entiteVarStocke)) {
					if(j > 0)
						reponseServeur.write(", ");
					reponseServeur.write("\"clusterNomCanonique\": \"");
					reponseServeur.write(Json.encode((String)champValeurs.iterator().next()));
					reponseServeur.write("\"\n");
					j++;
					return j;
				}
				if("clusterNomSimple".equals(entiteVarStocke)) {
					if(j > 0)
						reponseServeur.write(", ");
					reponseServeur.write("\"clusterNomSimple\": \"");
					reponseServeur.write(Json.encode((String)champValeurs.iterator().next()));
					reponseServeur.write("\"\n");
					j++;
					return j;
				}
			}
		}
		return j;
	}

	@Override
	public void postCluster(JsonObject document, Handler<AsyncResult<OperationResponse>> resultHandler) {
		try {
			RequeteSite requeteSite = genererRequeteSitePourCluster(siteContexte);
			Future<OperationResponse> etapesFutures = sqlCluster(requeteSite).compose(
				a -> creerCluster(requeteSite).compose(
					cluster -> definirCluster(cluster).compose(
						c -> attribuerCluster(cluster).compose(
							d -> indexerCluster(cluster).compose(
								operationResponse -> postJsonCluster(cluster)
							)
						)
					)
				)
			);
			etapesFutures.setHandler(resultHandler);
		} catch(Exception e) {
			resultHandler.handle(Future.failedFuture(e));
		}
	}

	@Override
	public void patchCluster(JsonObject document, Handler<AsyncResult<OperationResponse>> resultHandler) {
		try {
			RequeteSite requeteSite = genererRequeteSitePourCluster(siteContexte);
			Future<OperationResponse> etapesFutures = sqlCluster(requeteSite).compose(
				a -> rechercheCluster(requeteSite).compose(
					listeCluster -> patchListeCluster(listeCluster)
				)
			);
			etapesFutures.setHandler(resultHandler);
		} catch(Exception e) {
			resultHandler.handle(Future.failedFuture(e));
		}
	}

	public Future<Void> sqlCluster(RequeteSite requeteSite) {
		Future<Void> future = Future.future();
		SQLClient clientSql = requeteSite.getSiteContexte_().getClientSql();

		clientSql.getConnection(sqlAsync -> {
			if(sqlAsync.succeeded()) {
				requeteSite.setConnexionSql(sqlAsync.result());
				future.complete();
			}
		});
		return future;
	}

	public Future<Cluster> creerCluster(RequeteSite requeteSite) {
		Future<Cluster> future = Future.future();
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
			future.complete(o);
		});
		return future;
	}

	public Future<Void> postCluster(Cluster o) {
		Future<Void> future = Future.future();
		RequeteSite requeteSite = o.getRequeteSite_();
		SQLConnection connexionSql = requeteSite.getConnexionSql();
		Long pk = o.getPk();
		RoutingContext contexteItineraire = requeteSite.getContexteItineraire();
		JsonObject jsonObject = contexteItineraire.getBodyAsJson();
		StringBuilder postSql = new StringBuilder();
		List<Object> postSqlParams = new ArrayList<Object>();
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
				case "cree":
					postSql.append(SiteContexte.SQL_setP);
					postSqlParams.addAll(Arrays.asList("cree", jsonObject.getInstant(entiteVar), pk));
					break;
				case "modifie":
					postSql.append(SiteContexte.SQL_setP);
					postSqlParams.addAll(Arrays.asList("modifie", jsonObject.getInstant(entiteVar), pk));
					break;
				case "utilisateurId":
					postSql.append(SiteContexte.SQL_setP);
					postSqlParams.addAll(Arrays.asList("utilisateurId", jsonObject.getString(entiteVar), pk));
					break;
				case "clusterNomCanonique":
					postSql.append(SiteContexte.SQL_setP);
					postSqlParams.addAll(Arrays.asList("clusterNomCanonique", jsonObject.getString(entiteVar), pk));
					break;
				case "clusterNomSimple":
					postSql.append(SiteContexte.SQL_setP);
					postSqlParams.addAll(Arrays.asList("clusterNomSimple", jsonObject.getString(entiteVar), pk));
					break;
				case "supprime":
					postSql.append(SiteContexte.SQL_setP);
					postSqlParams.addAll(Arrays.asList("supprime", jsonObject.getBoolean(entiteVar), pk));
					break;
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
	}

	public Future<OperationResponse> patchListeCluster(ListeRecherche<Cluster> listeCluster) {
		List<Future> futures = new ArrayList<>();
		listeCluster.getList().forEach(o -> {
			futures.add(
				patchCluster(o).compose(
					b -> indexerCluster(o)
				)
			);
		});
		CompositeFuture compositeFuture = CompositeFuture.all(futures).setHandler(ar -> {
			if(ar.succeeded()) {
				patchJsonCluster(listeCluster);
			} else {
			}
		});
		Future<OperationResponse> future = Future.future().compose(
			a -> compositeFuture.compose(
				b -> patchJsonCluster(listeCluster)
			)
		);
		return future;
	}

	public Future<Void> patchCluster(Cluster o) {
		Future<Void> future = Future.future();
		RequeteSite requeteSite = o.getRequeteSite_();
		SQLConnection connexionSql = requeteSite.getConnexionSql();
		Long pk = o.getPk();
		RoutingContext contexteItineraire = requeteSite.getContexteItineraire();
		JsonObject requeteJson = contexteItineraire.getBodyAsJson();
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
				case "setCree":
					patchSql.append(SiteContexte.SQL_setP);
					patchSqlParams.addAll(Arrays.asList("cree", requeteJson.getInstant(methodeNom), pk));
					break;
				case "setModifie":
					patchSql.append(SiteContexte.SQL_setP);
					patchSqlParams.addAll(Arrays.asList("modifie", requeteJson.getInstant(methodeNom), pk));
					break;
				case "setUtilisateurId":
					patchSql.append(SiteContexte.SQL_setP);
					patchSqlParams.addAll(Arrays.asList("utilisateurId", requeteJson.getString(methodeNom), pk));
					break;
				case "setClusterNomCanonique":
					patchSql.append(SiteContexte.SQL_setP);
					patchSqlParams.addAll(Arrays.asList("clusterNomCanonique", requeteJson.getString(methodeNom), pk));
					break;
				case "setClusterNomSimple":
					patchSql.append(SiteContexte.SQL_setP);
					patchSqlParams.addAll(Arrays.asList("clusterNomSimple", requeteJson.getString(methodeNom), pk));
					break;
				case "setSupprime":
					patchSql.append(SiteContexte.SQL_setP);
					patchSqlParams.addAll(Arrays.asList("supprime", requeteJson.getBoolean(methodeNom), pk));
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
	}

	public Future<Void> definirCluster(Cluster o) {
		Future<Void> future = Future.future();
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
		return future;
	}

	public Future<Void> attribuerCluster(Cluster o) {
		Future<Void> future = Future.future();
		RequeteSite requeteSite = o.getRequeteSite_();
		SQLConnection connexionSql = requeteSite.getConnexionSql();
		Long pk = o.getPk();
		connexionSql.queryWithParams(
				SiteContexte.SQL_attribuer
				, new JsonArray(Arrays.asList(pk))
				, attribuerAsync
		-> {
			for(JsonArray definition : attribuerAsync.result().getResults()) {
				o.attribuerPourClasse(definition.getString(0), definition.getString(1));
			}
			future.complete();
		});
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
			future.fail(e.getCause());
		}
		return future;
	}

	public Future<OperationResponse> postJsonCluster(Cluster o) {
		Buffer buffer = Buffer.buffer();
		RequeteSite requeteSite = o.getRequeteSite_();
		return Future.succeededFuture(OperationResponse.completedWithJson(buffer));
	}

	public Future<OperationResponse> patchJsonCluster(ListeRecherche<Cluster> listeCluster) {
		Buffer buffer = Buffer.buffer();
		return Future.succeededFuture(OperationResponse.completedWithJson(buffer));
	}
}
