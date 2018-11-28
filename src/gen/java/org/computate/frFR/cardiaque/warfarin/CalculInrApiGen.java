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
import java.time.ZoneId;
import org.computate.frFR.cardiaque.contexte.SiteContexte;
import java.util.List;
import java.security.Principal;
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


public class CalculInrApiGen {

	private static final Logger LOGGER = LoggerFactory.getLogger(CalculInrApiGen.class);

	public static final String VAL_nomCanoniqueCalculInr = "org.computate.frFR.cardiaque.warfarin.CalculInr";
	public static final String VAL_virguleEspace = ", ";
	public static final String VAL_citation = "\"";
	public static final String VAL_citationDeuxPointsEspaceCitation = "\": \"";
	public static final String VAL_citationDeuxPointsEspace = "\": ";
	public static final String VAL_citationLigne = "\"\n";
	public static final String VAL_ligne = "\n";
	public static final String VAL_citationVirguleEspaceCitation = "\", \"";
	public static final String VAL_citationDeuxPointsEspaceGuillmets = "\": [";
	public static final String VAL_guillmetsFin = "]";

	public static final String ENTITE_VAR_utilisateurPk = "utilisateurPk";
	public static final String ENTITE_VAR_INDEXE_utilisateurPk = "utilisateurPk_indexe_long";
	public static final String ENTITE_VAR_STOCKE_utilisateurPk = "utilisateurPk_stocke_long";
	public static final String ENTITE_VAR_utilisateurPk_ATTRIBUER_UtilisateurSite_calculInrPks = "calculInrPks";

	public static final String ENTITE_VAR_dateInr = "dateInr";
	public static final String ENTITE_VAR_INDEXE_dateInr = "dateInr_indexe_date";
	public static final String ENTITE_VAR_STOCKE_dateInr = "dateInr_stocke_date";

	public static final String ENTITE_VAR_dateReverifier = "dateReverifier";
	public static final String ENTITE_VAR_INDEXE_dateReverifier = "dateReverifier_indexe_date";
	public static final String ENTITE_VAR_STOCKE_dateReverifier = "dateReverifier_stocke_date";

	public static final String ENTITE_VAR_patientPrendCoumadin = "patientPrendCoumadin";
	public static final String ENTITE_VAR_INDEXE_patientPrendCoumadin = "patientPrendCoumadin_indexe_string";
	public static final String ENTITE_VAR_STOCKE_patientPrendCoumadin = "patientPrendCoumadin_stocke_string";

	public static final String ENTITE_VAR_butActuel = "butActuel";
	public static final String ENTITE_VAR_INDEXE_butActuel = "butActuel_indexe_string";
	public static final String ENTITE_VAR_STOCKE_butActuel = "butActuel_stocke_string";

	public static final String ENTITE_VAR_doseActuel = "doseActuel";
	public static final String ENTITE_VAR_INDEXE_doseActuel = "doseActuel_indexe_string";
	public static final String ENTITE_VAR_STOCKE_doseActuel = "doseActuel_stocke_string";

	public static final String ENTITE_VAR_medicamentActuel = "medicamentActuel";
	public static final String ENTITE_VAR_INDEXE_medicamentActuel = "medicamentActuel_indexe_string";
	public static final String ENTITE_VAR_STOCKE_medicamentActuel = "medicamentActuel_stocke_string";

	public static final String ENTITE_VAR_changementDose = "changementDose";
	public static final String ENTITE_VAR_INDEXE_changementDose = "changementDose_indexe_string";
	public static final String ENTITE_VAR_STOCKE_changementDose = "changementDose_stocke_string";

	public static final String ENTITE_VAR_notesComplementaires = "notesComplementaires";
	public static final String ENTITE_VAR_INDEXE_notesComplementaires = "notesComplementaires_indexe_string";
	public static final String ENTITE_VAR_STOCKE_notesComplementaires = "notesComplementaires_stocke_string";

	public static final String ENTITE_VAR_infoContact = "infoContact";
	public static final String ENTITE_VAR_INDEXE_infoContact = "infoContact_indexe_string";
	public static final String ENTITE_VAR_STOCKE_infoContact = "infoContact_stocke_string";

	public void handleGetCalculInr(SiteContexte siteContexte) {
		OpenAPI3RouterFactory usineRouteur = siteContexte.getUsineRouteur_();

		usineRouteur.addHandlerByOperationId("getCalculInr", contexteRoutage -> {
			contexteRoutage.user().isAuthorized("Doof", authRes -> {
				try {
					if (authRes.result() == Boolean.TRUE) {

						contexteRoutage.response().putHeader("content-type", "application/json").setChunked(true);
						RequeteSite requeteSite = genererRequeteSitePourCalculInr(siteContexte, contexteRoutage);
						SolrQuery rechercheSolr = requeteSite.getRechercheSolr_();
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
						contexteRoutage.response().setStatusCode(HttpResponseStatus.UNAUTHORIZED.code()).end();
					}
				} catch(Exception e) {
					LOGGER.error("Error: ", e.getMessage());
					contexteRoutage.fail(e);
				}
			});
		});
		usineRouteur.addFailureHandlerByOperationId("getCalculInr", contexteRoutage -> {
			Throwable failure = contexteRoutage.failure();
			if (failure instanceof ValidationException) {
				String validationErrorMessage = failure.getMessage();
				LOGGER.error("Error: ", validationErrorMessage);
				contexteRoutage.fail(failure);
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
			case ENTITE_VAR_utilisateurPk:
				return ENTITE_VAR_INDEXE_utilisateurPk;
			case ENTITE_VAR_dateInr:
				return ENTITE_VAR_INDEXE_dateInr;
			case ENTITE_VAR_dateReverifier:
				return ENTITE_VAR_INDEXE_dateReverifier;
			case ENTITE_VAR_patientPrendCoumadin:
				return ENTITE_VAR_INDEXE_patientPrendCoumadin;
			case ENTITE_VAR_butActuel:
				return ENTITE_VAR_INDEXE_butActuel;
			case ENTITE_VAR_doseActuel:
				return ENTITE_VAR_INDEXE_doseActuel;
			case ENTITE_VAR_medicamentActuel:
				return ENTITE_VAR_INDEXE_medicamentActuel;
			case ENTITE_VAR_changementDose:
				return ENTITE_VAR_INDEXE_changementDose;
			case ENTITE_VAR_notesComplementaires:
				return ENTITE_VAR_INDEXE_notesComplementaires;
			case ENTITE_VAR_infoContact:
				return ENTITE_VAR_INDEXE_infoContact;
			default:
				throw new Exception(String.format("\"%s\" n'est pas une entité indexé. ", entiteVar));
		}
	}

	public SolrQuery genererRechercheCalculInr(HttpServerRequest requeteServeur) throws Exception {
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
		return rechercheSolr;
	}

	public RequeteSite genererRequeteSitePourCalculInr(SiteContexte siteContexte, RoutingContext contexteItineraire) throws Exception {
		Vertx vertx = siteContexte.getVertx_();
		SolrQuery rechercheSolr = genererRechercheCalculInr(contexteItineraire.request());

		RequeteSite requeteSite = new RequeteSite();
		requeteSite.setVertx_(vertx);
		requeteSite.setContexteItineraire_(contexteItineraire);
		requeteSite.setSiteContexte_(siteContexte);
		requeteSite.setRechercheSolr_(rechercheSolr);
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
						reponseServeur.write(VAL_virguleEspace);
					reponseServeur.write(VAL_citation);
					reponseServeur.write(ENTITE_VAR_utilisateurPk);
					reponseServeur.write(VAL_citationDeuxPointsEspace);
					reponseServeur.write(((Long)champValeur).toString());
					reponseServeur.write(VAL_ligne);
					j++;
					return j;
				}
				if(ENTITE_VAR_STOCKE_dateInr.equals(entiteVarStocke)) {
					if(j > 0)
						reponseServeur.write(VAL_citationVirguleEspaceCitation);
					reponseServeur.write(VAL_citation);
					reponseServeur.write(ENTITE_VAR_dateInr);
					reponseServeur.write(VAL_citationDeuxPointsEspaceCitation);
					reponseServeur.write(DateTimeFormatter.ISO_OFFSET_DATE.format(((Date)champValeur).toInstant().atZone(ZoneId.systemDefault()).toLocalDate()));
					reponseServeur.write(VAL_citationLigne);
					j++;
					return j;
				}
				if(ENTITE_VAR_STOCKE_dateReverifier.equals(entiteVarStocke)) {
					if(j > 0)
						reponseServeur.write(VAL_citationVirguleEspaceCitation);
					reponseServeur.write(VAL_citation);
					reponseServeur.write(ENTITE_VAR_dateReverifier);
					reponseServeur.write(VAL_citationDeuxPointsEspaceCitation);
					reponseServeur.write(DateTimeFormatter.ISO_OFFSET_DATE.format(((Date)champValeur).toInstant().atZone(ZoneId.systemDefault()).toLocalDate()));
					reponseServeur.write(VAL_citationLigne);
					j++;
					return j;
				}
				if(ENTITE_VAR_STOCKE_patientPrendCoumadin.equals(entiteVarStocke)) {
					if(j > 0)
						reponseServeur.write(VAL_virguleEspace);
					reponseServeur.write(VAL_citation);
					reponseServeur.write(ENTITE_VAR_patientPrendCoumadin);
					reponseServeur.write(VAL_citationDeuxPointsEspaceCitation);
					reponseServeur.write(Json.encode((String)champValeurs.iterator().next()));
					reponseServeur.write(VAL_citationLigne);
					j++;
					return j;
				}
				if(ENTITE_VAR_STOCKE_butActuel.equals(entiteVarStocke)) {
					if(j > 0)
						reponseServeur.write(VAL_virguleEspace);
					reponseServeur.write(VAL_citation);
					reponseServeur.write(ENTITE_VAR_butActuel);
					reponseServeur.write(VAL_citationDeuxPointsEspaceCitation);
					reponseServeur.write(Json.encode((String)champValeurs.iterator().next()));
					reponseServeur.write(VAL_citationLigne);
					j++;
					return j;
				}
				if(ENTITE_VAR_STOCKE_doseActuel.equals(entiteVarStocke)) {
					if(j > 0)
						reponseServeur.write(VAL_virguleEspace);
					reponseServeur.write(VAL_citation);
					reponseServeur.write(ENTITE_VAR_doseActuel);
					reponseServeur.write(VAL_citationDeuxPointsEspaceCitation);
					reponseServeur.write(Json.encode((String)champValeurs.iterator().next()));
					reponseServeur.write(VAL_citationLigne);
					j++;
					return j;
				}
				if(ENTITE_VAR_STOCKE_medicamentActuel.equals(entiteVarStocke)) {
					if(j > 0)
						reponseServeur.write(VAL_virguleEspace);
					reponseServeur.write(VAL_citation);
					reponseServeur.write(ENTITE_VAR_medicamentActuel);
					reponseServeur.write(VAL_citationDeuxPointsEspaceCitation);
					reponseServeur.write(Json.encode((String)champValeurs.iterator().next()));
					reponseServeur.write(VAL_citationLigne);
					j++;
					return j;
				}
				if(ENTITE_VAR_STOCKE_changementDose.equals(entiteVarStocke)) {
					if(j > 0)
						reponseServeur.write(VAL_virguleEspace);
					reponseServeur.write(VAL_citation);
					reponseServeur.write(ENTITE_VAR_changementDose);
					reponseServeur.write(VAL_citationDeuxPointsEspaceCitation);
					reponseServeur.write(Json.encode((String)champValeurs.iterator().next()));
					reponseServeur.write(VAL_citationLigne);
					j++;
					return j;
				}
				if(ENTITE_VAR_STOCKE_notesComplementaires.equals(entiteVarStocke)) {
					if(j > 0)
						reponseServeur.write(VAL_virguleEspace);
					reponseServeur.write(VAL_citation);
					reponseServeur.write(ENTITE_VAR_notesComplementaires);
					reponseServeur.write(VAL_citationDeuxPointsEspaceCitation);
					reponseServeur.write(Json.encode((String)champValeurs.iterator().next()));
					reponseServeur.write(VAL_citationLigne);
					j++;
					return j;
				}
				if(ENTITE_VAR_STOCKE_infoContact.equals(entiteVarStocke)) {
					if(j > 0)
						reponseServeur.write(VAL_virguleEspace);
					reponseServeur.write(VAL_citation);
					reponseServeur.write(ENTITE_VAR_infoContact);
					reponseServeur.write(VAL_citationDeuxPointsEspaceCitation);
					reponseServeur.write(Json.encode((String)champValeurs.iterator().next()));
					reponseServeur.write(VAL_citationLigne);
					j++;
					return j;
				}
			}
		}
		return j;
	}

	protected void postCalculInr(SiteContexte siteContexte) {
		OpenAPI3RouterFactory usineRouteur = siteContexte.getUsineRouteur_();
		usineRouteur.addHandlerByOperationId("postCalculInr", contexteRoutage -> {
			contexteRoutage.user().isAuthorized("Doof", authRes -> {
				try {
					if (authRes.result() == Boolean.TRUE) {
						RequeteSite requeteSite = genererRequeteSitePourCalculInr(siteContexte, contexteRoutage);
						HttpServerResponse reponseServeur = requeteSite.getReponseServeur();
						QueryResponse reponseRecherche = requeteSite.getReponseRecherche();
						JsonObject requeteJson = contexteRoutage.getBodyAsJson();
						SQLClient clientSql = requeteSite.getSiteContexte_().getClientSql();

						clientSql.getConnection(resultatAsync -> {
							if(resultatAsync.succeeded()) {
								LocalDateTime modifie = java.time.LocalDateTime.now();
								String horodatageStr = Timestamp.valueOf(modifie).toString();
								String utilisateurId = requeteSite.getUtilisateurId();
								SQLConnection connexionSql = resultatAsync.result();

								connexionSql.queryWithParams(
										SiteContexte.SQL_creer
										, new JsonArray(Arrays.asList(VAL_nomCanoniqueCalculInr, utilisateurId))
										, asyncCreer
										-> {
									if(asyncCreer.succeeded()) {
										List<Object> postSqlParams = Arrays.asList();
										JsonArray postLigne = asyncCreer.result().getResults().stream().findFirst().orElseGet(() -> null);
										Long postPk = postLigne.getLong(0);
										StringBuilder postSql = new StringBuilder();
										postSqlParams = new ArrayList<Object>();
										Set<String> entiteVars = requeteJson.fieldNames();
										for(String entiteVar : entiteVars) {
											switch(entiteVar) {
												case "utilisateurPk":
													postSql.append(SiteContexte.SQL_setP);
													postSqlParams.addAll(Arrays.asList(ENTITE_VAR_utilisateurPk, requeteJson.getLong(entiteVar), postPk));
													break;
												case "dateInr":
													postSql.append(SiteContexte.SQL_setP);
													postSqlParams.addAll(Arrays.asList(ENTITE_VAR_dateInr, requeteJson.getInstant(entiteVar), postPk));
													break;
												case "dateReverifier":
													postSql.append(SiteContexte.SQL_setP);
													postSqlParams.addAll(Arrays.asList(ENTITE_VAR_dateReverifier, requeteJson.getInstant(entiteVar), postPk));
													break;
												case "patientPrendCoumadin":
													postSql.append(SiteContexte.SQL_setP);
													postSqlParams.addAll(Arrays.asList(ENTITE_VAR_patientPrendCoumadin, requeteJson.getString(entiteVar), postPk));
													break;
												case "butActuel":
													postSql.append(SiteContexte.SQL_setP);
													postSqlParams.addAll(Arrays.asList(ENTITE_VAR_butActuel, requeteJson.getString(entiteVar), postPk));
													break;
												case "doseActuel":
													postSql.append(SiteContexte.SQL_setP);
													postSqlParams.addAll(Arrays.asList(ENTITE_VAR_doseActuel, requeteJson.getString(entiteVar), postPk));
													break;
												case "medicamentActuel":
													postSql.append(SiteContexte.SQL_setP);
													postSqlParams.addAll(Arrays.asList(ENTITE_VAR_medicamentActuel, requeteJson.getString(entiteVar), postPk));
													break;
												case "changementDose":
													postSql.append(SiteContexte.SQL_setP);
													postSqlParams.addAll(Arrays.asList(ENTITE_VAR_changementDose, requeteJson.getString(entiteVar), postPk));
													break;
												case "notesComplementaires":
													postSql.append(SiteContexte.SQL_setP);
													postSqlParams.addAll(Arrays.asList(ENTITE_VAR_notesComplementaires, requeteJson.getString(entiteVar), postPk));
													break;
												case "infoContact":
													postSql.append(SiteContexte.SQL_setP);
													postSqlParams.addAll(Arrays.asList(ENTITE_VAR_infoContact, requeteJson.getString(entiteVar), postPk));
													break;
											}
										}
										connexionSql.queryWithParams(postSql.toString(), new JsonArray(postSqlParams), asyncParams -> {
											connexionSql.close();
											if(asyncParams.succeeded()) {
												CalculInr o = new CalculInr();
												o.putPourClasse(requeteJson);
												o.sauvegarderPourClasse();
												o.sauvegardesPourClasse();
												o.initialiserLoinPourClasse();
												o.indexerPourClasse();
												requeteSite.setRequetePk(o.getPk());

											}
										});
									} else {
										connexionSql.close();
										contexteRoutage.fail(resultatAsync.cause());
									}
								});
							} else {
								LOGGER.error("Impossible d'ouvrir une connexion à la base de données. ", resultatAsync.cause());
								contexteRoutage.fail(resultatAsync.cause());
							}
						});

						contexteRoutage.response().putHeader("content-type", "application/json").setChunked(true);

						genererPostDebutCalculInr(requeteSite);
						CalculInr nouveauCalculInr = new CalculInr();
						nouveauCalculInr.initLoinCalculInr(requeteSite);
						nouveauCalculInr.peuplerCalculInr();
						postCalculInr();
						genererPostFinCalculInr(requeteSite);
						requeteSite.getReponseServeur().end();


						reponseServeur.write("\t]\n");
						reponseServeur.write("}\n");
					}
					else {
						contexteRoutage.response().setStatusCode(HttpResponseStatus.UNAUTHORIZED.code()).end();
					}
				} catch(Exception e) {
					LOGGER.error("Error: ", e.getMessage());
					contexteRoutage.fail(e);
				}
			});
		});
	}

	protected void patchCalculInr(SiteContexte siteContexte) {
		OpenAPI3RouterFactory usineRouteur = siteContexte.getUsineRouteur_();
		usineRouteur.addHandlerByOperationId("patchCalculInr", contexteRoutage -> {
			contexteRoutage.user().isAuthorized("Doof", authRes -> {
				try {
					if (authRes.result() == Boolean.TRUE) {
						RequeteSite requeteSite = genererRequeteSitePourCalculInr(siteContexte, contexteRoutage);
						HttpServerResponse reponseServeur = requeteSite.getReponseServeur();
						QueryResponse reponseRecherche = requeteSite.getReponseRecherche();
						JsonObject requeteJson = contexteRoutage.getBodyAsJson();
						SQLClient clientSql = requeteSite.getSiteContexte_().getClientSql();

						clientSql.getConnection(resultatAsync -> {
							if(resultatAsync.succeeded()) {
								LocalDateTime modifie = java.time.LocalDateTime.now();
								String horodatageStr = Timestamp.valueOf(modifie).toString();
								String utilisateurId = requeteSite.getUtilisateurId();
								SQLConnection connexionSql = resultatAsync.result();

								connexionSql.queryWithParams(
										SiteContexte.SQL_creer
										, new JsonArray(Arrays.asList(VAL_nomCanoniqueCalculInr, utilisateurId))
										, asyncCreer
										-> {
									if(asyncCreer.succeeded()) {
										List<Object> patchSqlParams = Arrays.asList();
										JsonArray patchLigne = asyncCreer.result().getResults().stream().findFirst().orElseGet(() -> null);
										Long patchPk = patchLigne.getLong(0);
										StringBuilder patchSql = new StringBuilder();
										patchSqlParams = new ArrayList<Object>();
										Set<String> methodeNoms = requeteJson.fieldNames();
										for(String methodeNom : methodeNoms) {
											switch(methodeNom) {
												case "setUtilisateurPk":
													patchSql.append(SiteContexte.SQL_setA2);
													patchSqlParams.addAll(Arrays.asList(
															ENTITE_VAR_utilisateurPk_ATTRIBUER_UtilisateurSite_calculInrPks
															, requeteJson.getLong(methodeNom)
															, ENTITE_VAR_utilisateurPk
															, patchPk
															));
													break;
												case "setDateInr":
													patchSql.append(SiteContexte.SQL_setP);
													patchSqlParams.addAll(Arrays.asList(ENTITE_VAR_dateInr, requeteJson.getInstant(methodeNom), patchPk));
													break;
												case "setDateReverifier":
													patchSql.append(SiteContexte.SQL_setP);
													patchSqlParams.addAll(Arrays.asList(ENTITE_VAR_dateReverifier, requeteJson.getInstant(methodeNom), patchPk));
													break;
												case "setPatientPrendCoumadin":
													patchSql.append(SiteContexte.SQL_setP);
													patchSqlParams.addAll(Arrays.asList(ENTITE_VAR_patientPrendCoumadin, requeteJson.getString(methodeNom), patchPk));
													break;
												case "setButActuel":
													patchSql.append(SiteContexte.SQL_setP);
													patchSqlParams.addAll(Arrays.asList(ENTITE_VAR_butActuel, requeteJson.getString(methodeNom), patchPk));
													break;
												case "setDoseActuel":
													patchSql.append(SiteContexte.SQL_setP);
													patchSqlParams.addAll(Arrays.asList(ENTITE_VAR_doseActuel, requeteJson.getString(methodeNom), patchPk));
													break;
												case "setMedicamentActuel":
													patchSql.append(SiteContexte.SQL_setP);
													patchSqlParams.addAll(Arrays.asList(ENTITE_VAR_medicamentActuel, requeteJson.getString(methodeNom), patchPk));
													break;
												case "setChangementDose":
													patchSql.append(SiteContexte.SQL_setP);
													patchSqlParams.addAll(Arrays.asList(ENTITE_VAR_changementDose, requeteJson.getString(methodeNom), patchPk));
													break;
												case "setNotesComplementaires":
													patchSql.append(SiteContexte.SQL_setP);
													patchSqlParams.addAll(Arrays.asList(ENTITE_VAR_notesComplementaires, requeteJson.getString(methodeNom), patchPk));
													break;
												case "setInfoContact":
													patchSql.append(SiteContexte.SQL_setP);
													patchSqlParams.addAll(Arrays.asList(ENTITE_VAR_infoContact, requeteJson.getString(methodeNom), patchPk));
													break;
											}
										}
										connexionSql.queryWithParams(patchSql.toString(), new JsonArray(patchSqlParams), asyncParams -> {
											connexionSql.close();
											if(asyncParams.succeeded()) {
												CalculInr o = new CalculInr();
												o.putPourClasse(requeteJson);
												o.sauvegarderPourClasse();
												o.sauvegardesPourClasse();
												o.initialiserLoinPourClasse();
												o.indexerPourClasse();
												requeteSite.setRequetePk(o.getPk());

											}
										});
									} else {
										connexionSql.close();
										contexteRoutage.fail(resultatAsync.cause());
									}
								});
							} else {
								LOGGER.error("Impossible d'ouvrir une connexion à la base de données. ", resultatAsync.cause());
								contexteRoutage.fail(resultatAsync.cause());
							}
						});

						contexteRoutage.response().putHeader("content-type", "application/json").setChunked(true);

						genererPatchDebutCalculInr(requeteSite);
						CalculInr nouveauCalculInr = new CalculInr();
						nouveauCalculInr.initLoinCalculInr(requeteSite);
						nouveauCalculInr.peuplerCalculInr();
						patchCalculInr();
						genererPatchFinCalculInr(requeteSite);
						requeteSite.getReponseServeur().end();


						reponseServeur.write("\t]\n");
						reponseServeur.write("}\n");
					}
					else {
						contexteRoutage.response().setStatusCode(HttpResponseStatus.UNAUTHORIZED.code()).end();
					}
				} catch(Exception e) {
					LOGGER.error("Error: ", e.getMessage());
					contexteRoutage.fail(e);
				}
			});
		});
	}
}
