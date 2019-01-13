package org.computate.enUS.cardiac.warfarin;

import org.computate.frFR.cardiaque.recherche.ResultatRecherche;
import java.util.Arrays;
import org.computate.frFR.cardiaque.recherche.ListeRecherche;
import io.vertx.ext.web.api.validation.ParameterTypeValidator;
import org.computate.enUS.java.SiteConfig;
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
import io.vertx.core.buffer.Buffer;
import io.vertx.core.http.HttpServerResponse;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.http.client.utils.URLEncodedUtils;
import io.vertx.ext.auth.oauth2.OAuth2Auth;
import org.apache.solr.client.solrj.util.ClientUtils;
import io.vertx.ext.sql.SQLClient;
import org.apache.http.NameValuePair;
import org.apache.commons.lang3.exception.ExceptionUtils;
import io.vertx.core.http.HttpServerRequest;
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


public class InrEntryApiGen implements InrEntryApiService {

	private static final Logger LOGGER = LoggerFactory.getLogger(InrEntryApiGen.class);

	private static final String SERVICE_ADDRESS = "InrEntryApi";

	protected SiteContexte siteContexte;

	public InrEntryApiGen(SiteContexte siteContexte) {
		this.siteContexte = siteContexte;
		InrEntryApiService service = InrEntryApiService.createProxy(siteContexte.getVertx(), SERVICE_ADDRESS);
	}

	public void handleGetInrEntry(SiteContexte siteContexte) {
		OpenAPI3RouterFactory usineRouteur = siteContexte.getUsineRouteur();

		usineRouteur.addHandlerByOperationId("getInrEntry", contexteItineraire -> {
			try {

				contexteItineraire.response().putHeader("content-type", "application/json").setChunked(true);
				RequeteSite requeteSite = genererRequeteSitePourInrEntry(siteContexte);
				SolrQuery rechercheSolr = requeteSite.getRechercheSolr();
				SolrDocumentList resultatsRecherche = requeteSite.getReponseRecherche().getResults();
				Integer rechercheLignes = rechercheSolr.getRows();

				genererGetDebutInrEntry(requeteSite);
				for(long i = resultatsRecherche.getStart(); i < resultatsRecherche.getNumFound(); i+=rechercheLignes) {
					for(int j = 0; j < resultatsRecherche.size(); j++) {
						long resultatIndice = i + j;
						SolrDocument documentSolr = resultatsRecherche.get(j);
						ResultatRecherche resultatRecherche = new ResultatRecherche();
						resultatRecherche.setRequeteSite_(requeteSite);
						resultatRecherche.setDocumentSolr(documentSolr);
						resultatRecherche.setResultatIndice(resultatIndice);
						genererGetIndividuelInrEntry(resultatRecherche);
					}
				}
				genererGetFinInrEntry(requeteSite);
				requeteSite.getReponseServeur().end();
			} catch(Exception e) {
				LOGGER.error("Error: ", e.getMessage());
				contexteItineraire.fail(e);
			}
		});
		usineRouteur.addFailureHandlerByOperationId("getInrEntry", contexteItineraire -> {
			Throwable failure = contexteItineraire.failure();
			if (failure instanceof ValidationException) {
				String validationErrorMessage = failure.getMessage();
				LOGGER.error("Error: ", validationErrorMessage);
				contexteItineraire.fail(failure);
			}
		});
	}

	public void genererGetDebutInrEntry(RequeteSite requeteSite) {
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

	public void genererGetIndividuelInrEntry(ResultatRecherche resultatRecherche) throws Exception {
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
			j = genererGetInrEntry(j, resultatRecherche, champNomStocke, champValeurs);
		}
		reponseServeur.write("\t\t}\n");
	}

	public void genererGetFinInrEntry(RequeteSite requeteSite) {
		HttpServerResponse reponseServeur = requeteSite.getReponseServeur();
		reponseServeur.write("\t]\n");
		reponseServeur.write("}\n");
	}

	public String varIndexeInrEntry(String entiteVar) throws Exception {
		switch(entiteVar) {
			case "utilisateurPk":
				return "utilisateurPk_indexed_long";
			case "dateInr":
				return "dateInr_indexed_date";
			case "dateReverifier":
				return "dateReverifier_indexed_date";
			case "currentDosageText":
				return "currentDosageText_indexed_string";
			case "currentGoal":
				return "currentGoal_indexed_string";
			case "currentDosage":
				return "currentDosage_indexed_string";
			case "currentMedication":
				return "currentMedication_indexed_string";
			case "dosageChange":
				return "dosageChange_indexed_string";
			case "additionalNotes":
				return "additionalNotes_indexed_string";
			case "contactInfo":
				return "contactInfo_indexed_string";
			default:
				throw new Exception(String.format("\"%s\" n'est pas une entité indexé. ", entiteVar));
		}
	}

	public Future<ListeRecherche<InrEntry>> rechercheInrEntry(RequeteSite requeteSite) {
		String entiteVar = null;
		String valeurIndexe = null;
		String varIndexe = null;
		String valeurTri = null;
		Integer rechercheDebut = null;
		Integer rechercheNum = null;
		ListeRecherche<InrEntry> listeRecherche = new ListeRecherche<InrEntry>();
		listeRecherche.setQuery("*:*");
		listeRecherche.setRows(1000000);
		listeRecherche.addSort("partNumero_indexed_int", ORDER.asc);
		List<NameValuePair> pairesNomValeur = URLEncodedUtils.parse(requeteSite.getRequeteServeur().query(), Charset.forName("UTF-8"));
		for(NameValuePair paireNomValeur : pairesNomValeur) {
			String paireNom = paireNomValeur.getName();
			String paireValeur = paireNomValeur.getValue();
			try {
				switch(paireNom) {
					case "q":
						entiteVar = StringUtils.trim(StringUtils.substringBefore(paireValeur, ":"));
						valeurIndexe = StringUtils.trim(StringUtils.substringAfter(paireValeur, ":"));
						varIndexe = varIndexeInrEntry(entiteVar);
						listeRecherche.setQuery(varIndexe + ":" + ClientUtils.escapeQueryChars(valeurIndexe));
						break;
					case "fq":
						entiteVar = StringUtils.trim(StringUtils.substringBefore(paireValeur, ":"));
						valeurIndexe = StringUtils.trim(StringUtils.substringAfter(paireValeur, ":"));
						varIndexe = varIndexeInrEntry(entiteVar);
						listeRecherche.addFilterQuery(varIndexe + ":" + ClientUtils.escapeQueryChars(valeurIndexe));
						break;
					case "sort":
						entiteVar = StringUtils.trim(StringUtils.substringBefore(paireValeur, " "));
						valeurTri = StringUtils.trim(StringUtils.substringAfter(paireValeur, " "));
						varIndexe = varIndexeInrEntry(entiteVar);
						listeRecherche.addSort(varIndexe, ORDER.valueOf(valeurTri));
						break;
					case "fl":
						entiteVar = StringUtils.trim(paireValeur);
						varIndexe = varIndexeInrEntry(entiteVar);
						listeRecherche.addField(varIndexe);
						break;
					case "start":
						rechercheDebut = Integer.parseInt(paireValeur);
						listeRecherche.setStart(rechercheDebut);
						break;
					case "rows":
						rechercheNum = Integer.parseInt(paireValeur);
						listeRecherche.setRows(rechercheNum);
						break;
				}
			} catch(Exception e) {
				return Future.failedFuture(e);
			}
		}
		listeRecherche.initLoinPourClasse(requeteSite);
		return Future.succeededFuture(listeRecherche);
	}

	public RequeteSite genererRequeteSitePourInrEntry(SiteContexte siteContexte) throws Exception {
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

	public Integer genererGetInrEntry(Integer j, ResultatRecherche resultatRecherche, String entiteVarStocke, Collection<Object> champValeurs) throws Exception {
		RequeteSite requeteSite = resultatRecherche.getRequeteSite_();
		HttpServerResponse reponseServeur = requeteSite.getReponseServeur();
		if(!champValeurs.isEmpty()) {
			Object champValeur = champValeurs.iterator().next();
			if(champValeur != null) {
				if("utilisateurPk".equals(entiteVarStocke)) {
					if(j > 0)
						reponseServeur.write(", ");
					reponseServeur.write("\"utilisateurPk\": ");
					reponseServeur.write(((Long)champValeur).toString());
					reponseServeur.write("\n");
					j++;
					return j;
				}
				if("dateInr".equals(entiteVarStocke)) {
					if(j > 0)
						reponseServeur.write(", ");
					reponseServeur.write("\"dateInr\": \"");
					reponseServeur.write(DateTimeFormatter.ISO_OFFSET_DATE.format(((Date)champValeur).toInstant().atZone(ZoneId.systemDefault()).toLocalDate()));
					reponseServeur.write("\"\n");
					j++;
					return j;
				}
				if("dateReverifier".equals(entiteVarStocke)) {
					if(j > 0)
						reponseServeur.write(", ");
					reponseServeur.write("\"dateReverifier\": \"");
					reponseServeur.write(DateTimeFormatter.ISO_OFFSET_DATE.format(((Date)champValeur).toInstant().atZone(ZoneId.systemDefault()).toLocalDate()));
					reponseServeur.write("\"\n");
					j++;
					return j;
				}
				if("currentDosageText".equals(entiteVarStocke)) {
					if(j > 0)
						reponseServeur.write(", ");
					reponseServeur.write("\"currentDosageText\": \"");
					reponseServeur.write(Json.encode((String)champValeurs.iterator().next()));
					reponseServeur.write("\"\n");
					j++;
					return j;
				}
				if("currentGoal".equals(entiteVarStocke)) {
					if(j > 0)
						reponseServeur.write(", ");
					reponseServeur.write("\"currentGoal\": \"");
					reponseServeur.write(Json.encode((String)champValeurs.iterator().next()));
					reponseServeur.write("\"\n");
					j++;
					return j;
				}
				if("currentDosage".equals(entiteVarStocke)) {
					if(j > 0)
						reponseServeur.write(", ");
					reponseServeur.write("\"currentDosage\": \"");
					reponseServeur.write(Json.encode((String)champValeurs.iterator().next()));
					reponseServeur.write("\"\n");
					j++;
					return j;
				}
				if("currentMedication".equals(entiteVarStocke)) {
					if(j > 0)
						reponseServeur.write(", ");
					reponseServeur.write("\"currentMedication\": \"");
					reponseServeur.write(Json.encode((String)champValeurs.iterator().next()));
					reponseServeur.write("\"\n");
					j++;
					return j;
				}
				if("dosageChange".equals(entiteVarStocke)) {
					if(j > 0)
						reponseServeur.write(", ");
					reponseServeur.write("\"dosageChange\": \"");
					reponseServeur.write(Json.encode((String)champValeurs.iterator().next()));
					reponseServeur.write("\"\n");
					j++;
					return j;
				}
				if("additionalNotes".equals(entiteVarStocke)) {
					if(j > 0)
						reponseServeur.write(", ");
					reponseServeur.write("\"additionalNotes\": \"");
					reponseServeur.write(Json.encode((String)champValeurs.iterator().next()));
					reponseServeur.write("\"\n");
					j++;
					return j;
				}
				if("contactInfo".equals(entiteVarStocke)) {
					if(j > 0)
						reponseServeur.write(", ");
					reponseServeur.write("\"contactInfo\": \"");
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
	public void postInrEntry(JsonObject document, OperationRequest operationRequete, Handler<AsyncResult<OperationResponse>> gestionnaireEvenements) {
		try {
			RequeteSite requeteSite = genererRequeteSitePourInrEntry(siteContexte);
			Future<OperationResponse> etapesFutures = sqlInrEntry(requeteSite).compose(
				a -> creerInrEntry(requeteSite).compose(
					cluster -> definirInrEntry(inrEntry).compose(
						c -> attribuerInrEntry(inrEntry).compose(
							d -> indexerInrEntry(inrEntry).compose(
								operationResponse -> postJsonInrEntry(inrEntry)
							)
						)
					)
				)
			);
			etapesFutures.setHandler(gestionnaireEvenements);
		} catch(Exception e) {
			gestionnaireEvenements.handle(Future.failedFuture(e));
		}
	}

	@Override
	public void patchInrEntry(JsonObject document, OperationRequest operationRequete, Handler<AsyncResult<OperationResponse>> gestionnaireEvenements) {
		try {
			RequeteSite requeteSite = genererRequeteSitePourInrEntry(siteContexte);
			Future<OperationResponse> etapesFutures = sqlInrEntry(requeteSite).compose(
				a -> rechercheInrEntry(requeteSite).compose(
					listeInrEntry -> patchListeInrEntry(listeInrEntry)
				)
			);
			etapesFutures.setHandler(gestionnaireEvenements);
		} catch(Exception e) {
			gestionnaireEvenements.handle(Future.failedFuture(e));
		}
	}

	public Future<Void> sqlInrEntry(RequeteSite requeteSite) {
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

	public Future<InrEntry> creerInrEntry(RequeteSite requeteSite) {
		Future<InrEntry> future = Future.future();
		SQLConnection connexionSql = requeteSite.getConnexionSql();
		String utilisateurId = requeteSite.getUtilisateurId();

		connexionSql.queryWithParams(
				SiteContexte.SQL_creer
				, new JsonArray(Arrays.asList(InrEntry.class.getCanonicalName(), utilisateurId))
				, creerAsync
		-> {
			JsonArray patchLigne = creerAsync.result().getResults().stream().findFirst().orElseGet(() -> null);
			Long  = patchLigne.getLong(0);
			InrEntry o = new InrEntry();
			o.set();
			future.complete(o);
		});
		return future;
	}

	public Future<Void> postInrEntry(InrEntry o) {
		Future<Void> future = Future.future();
		RequeteSite requeteSite = o.getRequeteSite_();
		SQLConnection connexionSql = requeteSite.getConnexionSql();
		Long  = o.get();
		RoutingContext contexteItineraire = requeteSite.getContexteItineraire();
		JsonObject jsonObject = contexteItineraire.getBodyAsJson();
		StringBuilder postSql = new StringBuilder();
		List<Object> postSqlParams = new ArrayList<Object>();
		Set<String> entiteVars = jsonObject.fieldNames();

		for(String entiteVar : entiteVars) {
			switch(entiteVar) {
				case "utilisateurPk":
					postSql.append(SiteContexte.SQL_addA);
					postSqlParams.addAll(Arrays.asList("", , "utilisateurPk", jsonObject.getLong(entiteVar)));
					break;
				case "dateInr":
					postSql.append(SiteContexte.SQL_setP);
					postSqlParams.addAll(Arrays.asList("dateInr", jsonObject.getInstant(entiteVar), ));
					break;
				case "dateReverifier":
					postSql.append(SiteContexte.SQL_setP);
					postSqlParams.addAll(Arrays.asList("dateReverifier", jsonObject.getInstant(entiteVar), ));
					break;
				case "currentDosageText":
					postSql.append(SiteContexte.SQL_setP);
					postSqlParams.addAll(Arrays.asList("currentDosageText", jsonObject.getString(entiteVar), ));
					break;
				case "currentGoal":
					postSql.append(SiteContexte.SQL_setP);
					postSqlParams.addAll(Arrays.asList("currentGoal", jsonObject.getString(entiteVar), ));
					break;
				case "currentDosage":
					postSql.append(SiteContexte.SQL_setP);
					postSqlParams.addAll(Arrays.asList("currentDosage", jsonObject.getString(entiteVar), ));
					break;
				case "currentMedication":
					postSql.append(SiteContexte.SQL_setP);
					postSqlParams.addAll(Arrays.asList("currentMedication", jsonObject.getString(entiteVar), ));
					break;
				case "dosageChange":
					postSql.append(SiteContexte.SQL_setP);
					postSqlParams.addAll(Arrays.asList("dosageChange", jsonObject.getString(entiteVar), ));
					break;
				case "additionalNotes":
					postSql.append(SiteContexte.SQL_setP);
					postSqlParams.addAll(Arrays.asList("additionalNotes", jsonObject.getString(entiteVar), ));
					break;
				case "contactInfo":
					postSql.append(SiteContexte.SQL_setP);
					postSqlParams.addAll(Arrays.asList("contactInfo", jsonObject.getString(entiteVar), ));
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

	public Future<OperationResponse> patchListeInrEntry(ListeRecherche<InrEntry> listeInrEntry) {
		List<Future> futures = new ArrayList<>();
		listeInrEntry.getList().forEach(o -> {
			futures.add(
				patchInrEntry(o).compose(
					b -> indexerInrEntry(o)
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

	public Future<Void> patchInrEntry(InrEntry o) {
		Future<Void> future = Future.future();
		RequeteSite requeteSite = o.getRequeteSite_();
		SQLConnection connexionSql = requeteSite.getConnexionSql();
		Long  = o.get();
		RoutingContext contexteItineraire = requeteSite.getContexteItineraire();
		JsonObject requeteJson = contexteItineraire.getBodyAsJson();
		StringBuilder patchSql = new StringBuilder();
		List<Object> patchSqlParams = new ArrayList<Object>();
		Set<String> methodeNoms = requeteJson.fieldNames();

		for(String methodeNom : methodeNoms) {
			switch(methodeNom) {
				case "set":
					patchSql.append(SiteContexte.SQL_setP);
					patchSqlParams.addAll(Arrays.asList("dateInr", requeteJson.getInstant(methodeNom), ));
					break;
				case "set":
					patchSql.append(SiteContexte.SQL_setP);
					patchSqlParams.addAll(Arrays.asList("dateReverifier", requeteJson.getInstant(methodeNom), ));
					break;
				case "set":
					patchSql.append(SiteContexte.SQL_setP);
					patchSqlParams.addAll(Arrays.asList("currentDosageText", requeteJson.getString(methodeNom), ));
					break;
				case "set":
					patchSql.append(SiteContexte.SQL_setP);
					patchSqlParams.addAll(Arrays.asList("currentGoal", requeteJson.getString(methodeNom), ));
					break;
				case "set":
					patchSql.append(SiteContexte.SQL_setP);
					patchSqlParams.addAll(Arrays.asList("currentDosage", requeteJson.getString(methodeNom), ));
					break;
				case "set":
					patchSql.append(SiteContexte.SQL_setP);
					patchSqlParams.addAll(Arrays.asList("currentMedication", requeteJson.getString(methodeNom), ));
					break;
				case "set":
					patchSql.append(SiteContexte.SQL_setP);
					patchSqlParams.addAll(Arrays.asList("dosageChange", requeteJson.getString(methodeNom), ));
					break;
				case "set":
					patchSql.append(SiteContexte.SQL_setP);
					patchSqlParams.addAll(Arrays.asList("additionalNotes", requeteJson.getString(methodeNom), ));
					break;
				case "set":
					patchSql.append(SiteContexte.SQL_setP);
					patchSqlParams.addAll(Arrays.asList("contactInfo", requeteJson.getString(methodeNom), ));
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

	public Future<Void> definirInrEntry(InrEntry o) {
		Future<Void> future = Future.future();
		RequeteSite requeteSite = o.getRequeteSite_();
		SQLConnection connexionSql = requeteSite.getConnexionSql();
		Long  = o.get();
		connexionSql.queryWithParams(
				SiteContexte.SQL_definir
				, new JsonArray(Arrays.asList())
				, definirAsync
		-> {
			for(JsonArray definition : definirAsync.result().getResults()) {
				o.definirPourClasse(definition.getString(0), definition.getString(1));
			}
			future.complete();
		});
		return future;
	}

	public Future<Void> attribuerInrEntry(InrEntry o) {
		Future<Void> future = Future.future();
		RequeteSite requeteSite = o.getRequeteSite_();
		SQLConnection connexionSql = requeteSite.getConnexionSql();
		Long  = o.get();
		connexionSql.queryWithParams(
				SiteContexte.SQL_attribuer
				, new JsonArray(Arrays.asList())
				, attribuerAsync
		-> {
			for(JsonArray definition : attribuerAsync.result().getResults()) {
				o.attribuerPourClasse(definition.getString(0), definition.getString(1));
			}
			future.complete();
		});
		return future;
	}

	public Future<Void> indexerInrEntry(InrEntry o) {
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

	public Future<OperationResponse> postJsonInrEntry(InrEntry o) {
		Buffer buffer = Buffer.buffer();
		RequeteSite requeteSite = o.getRequeteSite_();
		return Future.succeededFuture(OperationResponse.completedWithJson(buffer));
	}

	public Future<OperationResponse> patchJsonInrEntry(ListeRecherche<InrEntry> listeInrEntry) {
		Buffer buffer = Buffer.buffer();
		return Future.succeededFuture(OperationResponse.completedWithJson(buffer));
	}
}
