package org.computate.frFR.cardiaque.warfarin;

import org.computate.frFR.cardiaque.recherche.ResultatRecherche;
import java.util.Arrays;
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
import io.vertx.ext.auth.oauth2.OAuth2Auth;
import org.apache.solr.client.solrj.util.ClientUtils;
import io.vertx.ext.sql.SQLClient;
import org.apache.commons.lang3.exception.ExceptionUtils;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.core.json.Json;
import java.time.LocalDateTime;
import io.vertx.core.logging.LoggerFactory;
import java.util.ArrayList;
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
import java.time.format.DateTimeFormatter;
import io.vertx.ext.sql.SQLConnection;
import org.apache.solr.client.solrj.SolrQuery.ORDER;
import io.vertx.core.Handler;
import java.util.Collections;


public class CalculInrApiGen implements CalculInrApiService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CalculInrApiGen.class);

	private static final String SERVICE_ADDRESS = "CalculInrApi";

	protected SiteContexte siteContexte;

	public CalculInrApiGen(SiteContexte siteContexte) {
		this.siteContexte = siteContexte;
		CalculInrApiService service = CalculInrApiService.createProxy(siteContexte.getVertx(), SERVICE_ADDRESS);
	}

	public void handleGetCalculInr(SiteContexte siteContexte) {
		OpenAPI3RouterFactory usineRouteur = siteContexte.getUsineRouteur();

		usineRouteur.addHandlerByOperationId("getCalculInr", contexteItineraire -> {
			contexteItineraire.user().isAuthorized("Something", authRes -> {
				try {
					if (authRes.result() == Boolean.TRUE) {

						contexteItineraire.response().putHeader("content-type", "application/json").setChunked(true);
						RequeteSite requeteSite = genererRequeteSitePourCalculInr(siteContexte, contexteItineraire);
						SolrQuery rechercheSolr = requeteSite.getRechercheSolr();
						SolrDocumentList resultatsRecherche = requeteSite.getReponseRecherche().getResults();
						Integer rechercheLignes = rechercheSolr.getRows();

						genererGetDebutCalculInr(requeteSite);
						for(long i = resultatsRecherche.getStart(); i < resultatsRecherche.getNumFound(); i+=rechercheLignes) {
							for(int j = 0; j < resultatsRecherche.size(); j++) {
								long resultatIndice = i + j;
								SolrDocument documentSolr = resultatsRecherche.get(j);
								ResultatRecherche resultatRecherche = new ResultatRecherche();
								resultatRecherche.setRequeteSite_(requeteSite);
								resultatRecherche.setDocumentSolr(documentSolr);
								resultatRecherche.setResultatIndice(resultatIndice);
								genererGetIndividuelCalculInr(resultatRecherche);
							}
						}
						genererGetFinCalculInr(requeteSite);
						requeteSite.getReponseServeur().end();
					}
					else {
						contexteItineraire.response().setStatusCode(HttpResponseStatus.UNAUTHORIZED.code()).end();
					}
				} catch(Exception e) {
					LOGGER.error("Error: ", e.getMessage());
					contexteItineraire.fail(e);
				}
			});
		});
		usineRouteur.addFailureHandlerByOperationId("getCalculInr", contexteItineraire -> {
			Throwable failure = contexteItineraire.failure();
			if (failure instanceof ValidationException) {
				String validationErrorMessage = failure.getMessage();
				LOGGER.error("Error: ", validationErrorMessage);
				contexteItineraire.fail(failure);
			}
		});
	}

	public void genererGetDebutCalculInr(RequeteSite requeteSite) {
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

	public void genererGetIndividuelCalculInr(ResultatRecherche resultatRecherche) throws Exception {
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
			j = genererGetCalculInr(j, resultatRecherche, champNomStocke, champValeurs);
		}
		reponseServeur.write("\t\t}\n");
	}

	public void genererGetFinCalculInr(RequeteSite requeteSite) {
		HttpServerResponse reponseServeur = requeteSite.getReponseServeur();
		reponseServeur.write("\t]\n");
		reponseServeur.write("}\n");
	}

	public String varIndexeCalculInr(String entiteVar) throws Exception {
		switch(entiteVar) {
			case "utilisateurPk":
				return "utilisateurPk_indexed_long";
			case "dateInr":
				return "dateInr_indexed_date";
			case "dateReverifier":
				return "dateReverifier_indexed_date";
			case "patientPrendCoumadin":
				return "patientPrendCoumadin_indexed_string";
			case "butActuel":
				return "butActuel_indexed_string";
			case "doseActuel":
				return "doseActuel_indexed_string";
			case "medicamentActuel":
				return "medicamentActuel_indexed_string";
			case "changementDose":
				return "changementDose_indexed_string";
			case "notesComplementaires":
				return "notesComplementaires_indexed_string";
			case "infoContact":
				return "infoContact_indexed_string";
			default:
				throw new Exception(String.format("\"%s\" n'est pas une entité indexé. ", entiteVar));
		}
	}

	public SolrQuery genererRechercheCalculInr(RequeteSite requeteSite, HttpServerRequest requeteServeur) throws Exception {
		String entiteVar = null;
		String valeurIndexe = null;
		String varIndexe = null;
		String valeurTri = null;
		Integer rechercheDebut = null;
		Integer rechercheNum = null;
		SolrQuery rechercheSolr = new SolrQuery();
		rechercheSolr.setQuery("*:*");
		rechercheSolr.setRows(1000000);
		rechercheSolr.addSort("partNumero_indexed_int", ORDER.asc);
		MultiMap paramMap = requeteServeur.params();
		for(String paramCle : paramMap.names()) {
			List<String> paramValeurs = paramMap.getAll(paramCle);
			for(String paramValeur : paramValeurs) {
				switch(paramCle) {
					case "q":
						entiteVar = StringUtils.trim(StringUtils.substringBefore(paramValeur, ":"));
						valeurIndexe = StringUtils.trim(StringUtils.substringAfter(paramValeur, ":"));
						varIndexe = varIndexeCalculInr(paramCle);
						rechercheSolr.setQuery(varIndexe + ":" + ClientUtils.escapeQueryChars(valeurIndexe));
						break;
					case "fq":
						entiteVar = StringUtils.trim(StringUtils.substringBefore(paramValeur, ":"));
						valeurIndexe = StringUtils.trim(StringUtils.substringAfter(paramValeur, ":"));
						varIndexe = varIndexeCalculInr(paramCle);
						rechercheSolr.addFilterQuery(varIndexe + ":" + ClientUtils.escapeQueryChars(valeurIndexe));
						break;
					case "sort":
						entiteVar = StringUtils.trim(StringUtils.substringBefore(paramValeur, " "));
						valeurTri = StringUtils.trim(StringUtils.substringAfter(paramValeur, " "));
						varIndexe = varIndexeCalculInr(paramCle);
						rechercheSolr.addSort(varIndexe, ORDER.valueOf(valeurTri));
						break;
					case "fl":
						entiteVar = StringUtils.trim(paramValeur);
						varIndexe = varIndexeCalculInr(paramCle);
						rechercheSolr.addField(varIndexe);
						break;
					case "start":
						rechercheDebut = Integer.parseInt(paramValeur);
						rechercheSolr.setStart(rechercheDebut);
						break;
					case "rows":
						rechercheNum = Integer.parseInt(paramValeur);
						rechercheSolr.setRows(rechercheNum);
						break;
				}
			}
		}
		requeteSite.setRechercheSolr(rechercheSolr);
		return rechercheSolr;
	}

	public RequeteSite genererRequeteSitePourCalculInr(SiteContexte siteContexte) throws Exception {
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

	public Integer genererGetCalculInr(Integer j, ResultatRecherche resultatRecherche, String entiteVarStocke, Collection<Object> champValeurs) throws Exception {
		RequeteSite requeteSite = resultatRecherche.getRequeteSite_();
		HttpServerResponse reponseServeur = requeteSite.getReponseServeur();
		if(!champValeurs.isEmpty()) {
			Object champValeur = champValeurs.iterator().next();
			if(champValeur != null) {
				if(ENTITE_VAR_STOCKE_utilisateurPk.equals(entiteVarStocke)) {
					if(j > 0)
						reponseServeur.write(", ");
					reponseServeur.write("\"utilisateurPk\": ");
					reponseServeur.write(((Long)champValeur).toString());
					reponseServeur.write("\n");
					j++;
					return j;
				}
				if(ENTITE_VAR_STOCKE_dateInr.equals(entiteVarStocke)) {
					if(j > 0)
						reponseServeur.write(", ");
					reponseServeur.write("\"dateInr\": \"");
					reponseServeur.write(DateTimeFormatter.ISO_OFFSET_DATE.format(((Date)champValeur).toInstant().atZone(ZoneId.systemDefault()).toLocalDate()));
					reponseServeur.write("\"\n");
					j++;
					return j;
				}
				if(ENTITE_VAR_STOCKE_dateReverifier.equals(entiteVarStocke)) {
					if(j > 0)
						reponseServeur.write(", ");
					reponseServeur.write("\"dateReverifier\": \"");
					reponseServeur.write(DateTimeFormatter.ISO_OFFSET_DATE.format(((Date)champValeur).toInstant().atZone(ZoneId.systemDefault()).toLocalDate()));
					reponseServeur.write("\"\n");
					j++;
					return j;
				}
				if(ENTITE_VAR_STOCKE_patientPrendCoumadin.equals(entiteVarStocke)) {
					if(j > 0)
						reponseServeur.write(", ");
					reponseServeur.write("\"patientPrendCoumadin\": \"");
					reponseServeur.write(Json.encode((String)champValeurs.iterator().next()));
					reponseServeur.write("\"\n");
					j++;
					return j;
				}
				if(ENTITE_VAR_STOCKE_butActuel.equals(entiteVarStocke)) {
					if(j > 0)
						reponseServeur.write(", ");
					reponseServeur.write("\"butActuel\": \"");
					reponseServeur.write(Json.encode((String)champValeurs.iterator().next()));
					reponseServeur.write("\"\n");
					j++;
					return j;
				}
				if(ENTITE_VAR_STOCKE_doseActuel.equals(entiteVarStocke)) {
					if(j > 0)
						reponseServeur.write(", ");
					reponseServeur.write("\"doseActuel\": \"");
					reponseServeur.write(Json.encode((String)champValeurs.iterator().next()));
					reponseServeur.write("\"\n");
					j++;
					return j;
				}
				if(ENTITE_VAR_STOCKE_medicamentActuel.equals(entiteVarStocke)) {
					if(j > 0)
						reponseServeur.write(", ");
					reponseServeur.write("\"medicamentActuel\": \"");
					reponseServeur.write(Json.encode((String)champValeurs.iterator().next()));
					reponseServeur.write("\"\n");
					j++;
					return j;
				}
				if(ENTITE_VAR_STOCKE_changementDose.equals(entiteVarStocke)) {
					if(j > 0)
						reponseServeur.write(", ");
					reponseServeur.write("\"changementDose\": \"");
					reponseServeur.write(Json.encode((String)champValeurs.iterator().next()));
					reponseServeur.write("\"\n");
					j++;
					return j;
				}
				if(ENTITE_VAR_STOCKE_notesComplementaires.equals(entiteVarStocke)) {
					if(j > 0)
						reponseServeur.write(", ");
					reponseServeur.write("\"notesComplementaires\": \"");
					reponseServeur.write(Json.encode((String)champValeurs.iterator().next()));
					reponseServeur.write("\"\n");
					j++;
					return j;
				}
				if(ENTITE_VAR_STOCKE_infoContact.equals(entiteVarStocke)) {
					if(j > 0)
						reponseServeur.write(", ");
					reponseServeur.write("\"infoContact\": \"");
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
	public void postCalculInr(JsonObject document, Handler<AsyncResult<OperationResponse>> resultHandler) {
		contexteItineraire.user().isAuthorized("Something", authRes -> {
			if (authRes.result() == Boolean.TRUE) {
				RequeteSite requeteSite = genererRequeteSitePourCalculInr(siteContexte);
				Future<OperationResponse> etapesFutures = sqlCalculInr(requeteSite).compose(
					a -> creerCalculInr(requeteSite).compose(
						cluster -> definirCalculInr(calculInr).compose(
							c -> attribuerCalculInr(calculInr).compose(
								d -> indexerCalculInr(calculInr).compose(
									operationResponse -> postJsonCalculInr(calculInr)
								)
							)
						)
					)
				);
				etapesFutures.setHandler(resultHandler);
			}
			else {
				contexteItineraire.response().setStatusCode(HttpResponseStatus.UNAUTHORIZED.code()).end();
			}
		});
	}
		usineRouteur.addHandlerByOperationId("patchCalculInr", contexteItineraire -> {
		});
	}

	@Override
	public void patchCalculInr(JsonObject document, Handler<AsyncResult<OperationResponse>> resultHandler) {
		contexteItineraire.user().isAuthorized("Something", authRes -> {
			if (authRes.result() == Boolean.TRUE) {
				RequeteSite requeteSite = genererRequeteSitePourCalculInr(siteContexte);
				Future<OperationResponse> etapesFutures = sqlCalculInr(requeteSite).compose(
					a -> patchCalculInr(requeteSite).compose(
						b -> definirCalculInr(requeteSite).compose(
							c -> attribuerCalculInr(requeteSite).compose(
								d -> indexerCalculInr(requeteSite).compose(
									operationResponse -> patchJsonCalculInr(requeteSite)
								)
							)
						)
					)
				);
				etapesFutures.setHandler(resultHandler);
			}
			else {
				contexteItineraire.response().setStatusCode(HttpResponseStatus.UNAUTHORIZED.code()).end();
			}
		});
	}

	public Future<Void> sqlCalculInr(RequeteSite requeteSite) {
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

	public Future<CalculInr> creerCalculInr(RequeteSite requeteSite) {
		Future<CalculInr> future = Future.future();
		SQLConnection connexionSql = requeteSite.getConnexionSql();
		String utilisateurId = requeteSite.getUtilisateurId();

		connexionSql.queryWithParams(
				SiteContexte.SQL_creer
				, new JsonArray(Arrays.asList(CalculInr.class.getCanonicalName(), utilisateurId))
				, creerAsync
		-> {
			JsonArray patchLigne = creerAsync.result().getResults().stream().findFirst().orElseGet(() -> null);
			Long pk = patchLigne.getLong(0);
			CalculInr o = new CalculInr();
			o.setPk(pk);
			future.complete(o);
		});
		return future;
	}

	public Future<Void> postCalculInr(CalculInr o) {
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
				case "utilisateurPk":
					postSql.append(SiteContexte.SQL_addA);
					postSqlParams.addAll(Arrays.asList("calculInrPks", pk, "utilisateurPk", jsonObject.getLong(entiteVar)));
					break;
				case "dateInr":
					postSql.append(SiteContexte.SQL_setP);
					postSqlParams.addAll(Arrays.asList("dateInr", jsonObject.getInstant(entiteVar), pk));
					break;
				case "dateReverifier":
					postSql.append(SiteContexte.SQL_setP);
					postSqlParams.addAll(Arrays.asList("dateReverifier", jsonObject.getInstant(entiteVar), pk));
					break;
				case "patientPrendCoumadin":
					postSql.append(SiteContexte.SQL_setP);
					postSqlParams.addAll(Arrays.asList("patientPrendCoumadin", jsonObject.getString(entiteVar), pk));
					break;
				case "butActuel":
					postSql.append(SiteContexte.SQL_setP);
					postSqlParams.addAll(Arrays.asList("butActuel", jsonObject.getString(entiteVar), pk));
					break;
				case "doseActuel":
					postSql.append(SiteContexte.SQL_setP);
					postSqlParams.addAll(Arrays.asList("doseActuel", jsonObject.getString(entiteVar), pk));
					break;
				case "medicamentActuel":
					postSql.append(SiteContexte.SQL_setP);
					postSqlParams.addAll(Arrays.asList("medicamentActuel", jsonObject.getString(entiteVar), pk));
					break;
				case "changementDose":
					postSql.append(SiteContexte.SQL_setP);
					postSqlParams.addAll(Arrays.asList("changementDose", jsonObject.getString(entiteVar), pk));
					break;
				case "notesComplementaires":
					postSql.append(SiteContexte.SQL_setP);
					postSqlParams.addAll(Arrays.asList("notesComplementaires", jsonObject.getString(entiteVar), pk));
					break;
				case "infoContact":
					postSql.append(SiteContexte.SQL_setP);
					postSqlParams.addAll(Arrays.asList("infoContact", jsonObject.getString(entiteVar), pk));
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

	public Future<Void> patchCalculInr(RequeteSite requeteSite) {
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
				case "setDateInr":
					patchSql.append(SiteContexte.SQL_setP);
					patchSqlParams.addAll(Arrays.asList(ENTITE_VAR_dateInr, requeteJson.getInstant(methodeNom), pk));
					break;
				case "setDateReverifier":
					patchSql.append(SiteContexte.SQL_setP);
					patchSqlParams.addAll(Arrays.asList(ENTITE_VAR_dateReverifier, requeteJson.getInstant(methodeNom), pk));
					break;
				case "setPatientPrendCoumadin":
					patchSql.append(SiteContexte.SQL_setP);
					patchSqlParams.addAll(Arrays.asList(ENTITE_VAR_patientPrendCoumadin, requeteJson.getString(methodeNom), pk));
					break;
				case "setButActuel":
					patchSql.append(SiteContexte.SQL_setP);
					patchSqlParams.addAll(Arrays.asList(ENTITE_VAR_butActuel, requeteJson.getString(methodeNom), pk));
					break;
				case "setDoseActuel":
					patchSql.append(SiteContexte.SQL_setP);
					patchSqlParams.addAll(Arrays.asList(ENTITE_VAR_doseActuel, requeteJson.getString(methodeNom), pk));
					break;
				case "setMedicamentActuel":
					patchSql.append(SiteContexte.SQL_setP);
					patchSqlParams.addAll(Arrays.asList(ENTITE_VAR_medicamentActuel, requeteJson.getString(methodeNom), pk));
					break;
				case "setChangementDose":
					patchSql.append(SiteContexte.SQL_setP);
					patchSqlParams.addAll(Arrays.asList(ENTITE_VAR_changementDose, requeteJson.getString(methodeNom), pk));
					break;
				case "setNotesComplementaires":
					patchSql.append(SiteContexte.SQL_setP);
					patchSqlParams.addAll(Arrays.asList(ENTITE_VAR_notesComplementaires, requeteJson.getString(methodeNom), pk));
					break;
				case "setInfoContact":
					patchSql.append(SiteContexte.SQL_setP);
					patchSqlParams.addAll(Arrays.asList(ENTITE_VAR_infoContact, requeteJson.getString(methodeNom), pk));
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

	public Future<CalculInr> definirCalculInr(CalculInr o) {
		Future<CalculInr> future = Future.future();
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

	public Future<CalculInr> attribuerCalculInr(CalculInr o) {
		Future<CalculInr> future = Future.future();
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

	public Future<CalculInr> indexerCalculInr(CalculInr o) {
		Future<CalculInr> future = Future.future();
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

	public Future<OperationResponse> postJsonCalculInr(CalculInr o) {
		Buffer buffer = Buffer.buffer();
		RequeteSite requeteSite = o.getRequeteSite_();
		return Future.succeededFuture(OperationResponse.completedWithJson(buffer));
	}

	public Future<OperationResponse> patchJsonCalculInr(RequeteSite requeteSite) {
		Buffer buffer = Buffer.buffer();
		return Future.succeededFuture(OperationResponse.completedWithJson(buffer));
	}
}
