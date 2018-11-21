package org.computate.frFR.cardiaque.warfarin;

import java.math.BigDecimal;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrQuery.ORDER;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.util.ClientUtils;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.computate.frFR.cardiaque.contexte.SiteContexte;
import org.computate.frFR.cardiaque.recherche.ResultatRecherche;
import org.computate.frFR.cardiaque.requete.RequeteSite;
import org.computate.frFR.cardiaque.utilisateur.UtilisateurSite;

import io.vertx.core.MultiMap;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.Json;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.api.contract.openapi3.OpenAPI3RouterFactory;
import io.vertx.ext.web.api.validation.HTTPRequestValidationHandler;
import io.vertx.ext.web.api.validation.ParameterTypeValidator;
import io.vertx.ext.web.api.validation.ValidationException;


public class CalculInrApiGen {

	private static final Logger LOGGER = LoggerFactory.getLogger(CalculInrApiGen.class);

	public static final String VAL_virguleEspace = ", ";
	public static final String VAL_citation = "\"";
	public static final String VAL_citationDeuxPointsEspaceCitation = "\": \"";
	public static final String VAL_citationDeuxPointsEspace = "\": ";
	public static final String VAL_citationLigne = "\"\n";
	public static final String VAL_ligne = "\n";
	public static final String VAL_citationVirguleEspaceCitation = "\", \"";
	public static final String VAL_citationDeuxPointsEspaceGuillmets = "\": [";
	public static final String VAL_guillmetsFin = "]";

	public static final String ENTITE_VAR_inrDate = "inrDate";
	public static final String ENTITE_VAR_INDEXE_inrDate = "inrDate_indexe_date";
	public static final String ENTITE_VAR_STOCKE_inrDate = "inrDate_stocke_date";

	public static final String ENTITE_VAR_doseActuelValeur = "doseActuelValeur";
	public static final String ENTITE_VAR_INDEXE_doseActuelValeur = "doseActuelValeur_indexe_double";
	public static final String ENTITE_VAR_STOCKE_doseActuelValeur = "doseActuelValeur_stocke_double";

	public static final String ENTITE_VAR_doseActuelTexte = "doseActuelTexte";
	public static final String ENTITE_VAR_INDEXE_doseActuelTexte = "doseActuelTexte_indexe_string";
	public static final String ENTITE_VAR_STOCKE_doseActuelTexte = "doseActuelTexte_stocke_string";

	public static final String ENTITE_VAR_changementDoseValeur = "changementDoseValeur";
	public static final String ENTITE_VAR_INDEXE_changementDoseValeur = "changementDoseValeur_indexe_double";
	public static final String ENTITE_VAR_STOCKE_changementDoseValeur = "changementDoseValeur_stocke_double";

	public static final String ENTITE_VAR_changementDoseTexte = "changementDoseTexte";
	public static final String ENTITE_VAR_INDEXE_changementDoseTexte = "changementDoseTexte_indexe_string";
	public static final String ENTITE_VAR_STOCKE_changementDoseTexte = "changementDoseTexte_stocke_string";

	public void handleGetCalculInr(SiteContexte siteContexte) {
		Router siteRouteur = siteContexte.getSiteRouteur_();

		HTTPRequestValidationHandler gestionnaireValidation = HTTPRequestValidationHandler.create();
		gestionnaireValidation.addQueryParamWithCustomTypeValidator("q", ParameterTypeValidator.createStringTypeValidator("[^:]+:.*", "*:*"), false, false);
		gestionnaireValidation.addQueryParamWithCustomTypeValidator("fq", ParameterTypeValidator.createStringTypeValidator("[^:]+:.*", null), false, false);
		gestionnaireValidation.addQueryParamWithCustomTypeValidator("sort", ParameterTypeValidator.createStringTypeValidator("[^:]+:.*", null), false, false);
		gestionnaireValidation.addQueryParamWithCustomTypeValidator("fl", ParameterTypeValidator.createStringTypeValidator("[^:]+:.*", null), false, false);
		gestionnaireValidation.addQueryParamWithCustomTypeValidator("start", ParameterTypeValidator.createIntegerTypeValidator(null, 0D, null, 0), false, false);
		gestionnaireValidation.addQueryParamWithCustomTypeValidator("rows", ParameterTypeValidator.createIntegerTypeValidator(null, 1D, null, 10), false, false);

		OpenAPI3RouterFactory.create(siteContexte.vertx_, "src/main/resources/petstore.yaml", ar -> {
			  if (ar.succeeded()) {
			    // Spec loaded with success
			    OpenAPI3RouterFactory routerFactory = ar.result();
			  } else {
			    // Something went wrong during router factory initialization
			    Throwable exception = ar.cause();
			  }
			});

		siteRouteur.get("/api/v1/warfarin/inr-entry")
				.handler(gestionnaireValidation)
				.handler(rc -> {
			try {

				rc.response().putHeader("content-type", "application/json").setChunked(true);
				RequeteSite requeteSite = genererRequeteSitePourCalculInr(siteContexte, rc);
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
			} catch(Exception e) {
				LOGGER.error("Error: ", e.getMessage());
				rc.fail(e);
			}
		})
		.failureHandler((rc) -> {
			Throwable failure = rc.failure();
			if (failure instanceof ValidationException) {
				String validationErrorMessage = failure.getMessage();
				LOGGER.error("Error: ", validationErrorMessage);
				rc.fail(failure);
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
			case ENTITE_VAR_inrDate:
				return ENTITE_VAR_INDEXE_inrDate;
			case ENTITE_VAR_doseActuelValeur:
				return ENTITE_VAR_INDEXE_doseActuelValeur;
			case ENTITE_VAR_doseActuelTexte:
				return ENTITE_VAR_INDEXE_doseActuelTexte;
			case ENTITE_VAR_changementDoseValeur:
				return ENTITE_VAR_INDEXE_changementDoseValeur;
			case ENTITE_VAR_changementDoseTexte:
				return ENTITE_VAR_INDEXE_changementDoseTexte;
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
				if(ENTITE_VAR_STOCKE_inrDate.equals(entiteVarStocke)) {
					if(j > 0)
						reponseServeur.write(VAL_citationVirguleEspaceCitation);
					reponseServeur.write(VAL_citation);
					reponseServeur.write(ENTITE_VAR_inrDate);
					reponseServeur.write(VAL_citationDeuxPointsEspaceCitation);
					reponseServeur.write(DateTimeFormatter.ISO_OFFSET_DATE.format(((Date)champValeur).toInstant().atZone(ZoneId.systemDefault()).toLocalDate()));
					reponseServeur.write(VAL_citationLigne);
					j++;
					return j;
				}
				if(ENTITE_VAR_STOCKE_inrDate.equals(entiteVarStocke)) {
					if(j > 0)
						reponseServeur.write(VAL_citationVirguleEspaceCitation);
					reponseServeur.write(VAL_citation);
					reponseServeur.write(ENTITE_VAR_inrDate);
					reponseServeur.write(VAL_citationDeuxPointsEspaceCitation);
					reponseServeur.write(DateTimeFormatter.ISO_OFFSET_DATE.format(((Date)champValeur).toInstant().atZone(ZoneId.systemDefault()).toLocalDate()));
					reponseServeur.write(VAL_citationLigne);
					j++;
					return j;
				}
				if(ENTITE_VAR_STOCKE_doseActuelValeur.equals(entiteVarStocke)) {
					if(j > 0)
						reponseServeur.write(VAL_virguleEspace);
					reponseServeur.write(VAL_citation);
					reponseServeur.write(ENTITE_VAR_doseActuelValeur);
					reponseServeur.write(VAL_citationDeuxPointsEspace);
					reponseServeur.write(BigDecimal.valueOf((Double)champValeur).toString());
					reponseServeur.write(VAL_ligne);
					j++;
					return j;
				}
				if(ENTITE_VAR_STOCKE_doseActuelValeur.equals(entiteVarStocke)) {
					if(j > 0)
						reponseServeur.write(VAL_virguleEspace);
					reponseServeur.write(VAL_citation);
					reponseServeur.write(ENTITE_VAR_doseActuelValeur);
					reponseServeur.write(VAL_citationDeuxPointsEspace);
					reponseServeur.write(BigDecimal.valueOf((Double)champValeur).toString());
					reponseServeur.write(VAL_ligne);
					j++;
					return j;
				}
				if(ENTITE_VAR_STOCKE_doseActuelTexte.equals(entiteVarStocke)) {
					if(j > 0)
						reponseServeur.write(VAL_virguleEspace);
					reponseServeur.write(VAL_citation);
					reponseServeur.write(ENTITE_VAR_doseActuelTexte);
					reponseServeur.write(VAL_citationDeuxPointsEspaceCitation);
					reponseServeur.write(Json.encode((String)champValeurs.iterator().next()));
					reponseServeur.write(VAL_citationLigne);
					j++;
					return j;
				}
				if(ENTITE_VAR_STOCKE_doseActuelTexte.equals(entiteVarStocke)) {
					if(j > 0)
						reponseServeur.write(VAL_virguleEspace);
					reponseServeur.write(VAL_citation);
					reponseServeur.write(ENTITE_VAR_doseActuelTexte);
					reponseServeur.write(VAL_citationDeuxPointsEspaceCitation);
					reponseServeur.write(Json.encode((String)champValeurs.iterator().next()));
					reponseServeur.write(VAL_citationLigne);
					j++;
					return j;
				}
				if(ENTITE_VAR_STOCKE_changementDoseValeur.equals(entiteVarStocke)) {
					if(j > 0)
						reponseServeur.write(VAL_virguleEspace);
					reponseServeur.write(VAL_citation);
					reponseServeur.write(ENTITE_VAR_changementDoseValeur);
					reponseServeur.write(VAL_citationDeuxPointsEspace);
					reponseServeur.write(BigDecimal.valueOf((Double)champValeur).toString());
					reponseServeur.write(VAL_ligne);
					j++;
					return j;
				}
				if(ENTITE_VAR_STOCKE_changementDoseValeur.equals(entiteVarStocke)) {
					if(j > 0)
						reponseServeur.write(VAL_virguleEspace);
					reponseServeur.write(VAL_citation);
					reponseServeur.write(ENTITE_VAR_changementDoseValeur);
					reponseServeur.write(VAL_citationDeuxPointsEspace);
					reponseServeur.write(BigDecimal.valueOf((Double)champValeur).toString());
					reponseServeur.write(VAL_ligne);
					j++;
					return j;
				}
				if(ENTITE_VAR_STOCKE_changementDoseTexte.equals(entiteVarStocke)) {
					if(j > 0)
						reponseServeur.write(VAL_virguleEspace);
					reponseServeur.write(VAL_citation);
					reponseServeur.write(ENTITE_VAR_changementDoseTexte);
					reponseServeur.write(VAL_citationDeuxPointsEspaceCitation);
					reponseServeur.write(Json.encode((String)champValeurs.iterator().next()));
					reponseServeur.write(VAL_citationLigne);
					j++;
					return j;
				}
				if(ENTITE_VAR_STOCKE_changementDoseTexte.equals(entiteVarStocke)) {
					if(j > 0)
						reponseServeur.write(VAL_virguleEspace);
					reponseServeur.write(VAL_citation);
					reponseServeur.write(ENTITE_VAR_changementDoseTexte);
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

	protected void handlePostCalculInr(SiteContexte siteContexte) {
		Router siteRouteur = siteContexte.getSiteRouteur_();
		siteRouteur.get("/api/v1/warfarin/inr-entry").handler(rc -> {
			try {
				rc.response().putHeader("content-type", "application/json").setChunked(true);
				RequeteSite requeteSite = genererRequeteSitePourCalculInr(siteContexte, rc);
				SolrQuery rechercheSolr = requeteSite.getRechercheSolr_();
				SolrDocumentList resultatsRecherche = requeteSite.getReponseRecherche().getResults();
				Integer rechercheLignes = rechercheSolr.getRows();

				genererPostDebutCalculInr(requeteSite);
				for(long i = resultatsRecherche.getStart(); i < resultatsRecherche.getNumFound(); i+=rechercheLignes) {
					for(int j = 0; j < resultatsRecherche.size(); j++) {
						long resultatIndice = i + j;
						SolrDocument documentSolr = resultatsRecherche.get(j);
						ResultatRecherche resultatRecherche = new ResultatRecherche();
						resultatRecherche.setRequeteSite_(requeteSite);
						resultatRecherche.setDocumentSolr(documentSolr);
						resultatRecherche.setResultatIndice(resultatIndice);
						genererPostIndividuelCalculInr(resultatRecherche);
					}
				}
				genererPostFinCalculInr(requeteSite);
				requeteSite.getReponseServeur().end();
			} catch(Exception e) {
				LOGGER.error("Error: ", e.getMessage());
				rc.fail(e);
			}
		});
	}

	public void genererPostDebutCalculInr(RequeteSite requeteSite) {
		HttpServerResponse reponseServeur = requeteSite.getReponseServeur();
		QueryResponse reponseRecherche = requeteSite.getReponseRecherche();
		reponseServeur.write("{\n");
		Long millisRecherche = Long.valueOf(reponseRecherche.getQTime());
		Long millisTransmission = reponseRecherche.getElapsedTime();
		Long numCommence = reponseRecherche.getResults().getStart();
		Long numTrouve = reponseRecherche.getResults().getNumFound();
		Integer numRetourne = reponseRecherche.getResponse().size();
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

	public void genererPostIndividuelCalculInr(ResultatRecherche resultatRecherche) throws Exception {
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
			j = genererPostCalculInr(j, resultatRecherche, champNomStocke, champValeurs);
		}
		reponseServeur.write("\t\t}\n");
	}

	public Integer genererPostCalculInr(Integer j, ResultatRecherche resultatRecherche, String entiteVarStocke, Collection<Object> champValeurs) throws Exception {
		RequeteSite requeteSite = resultatRecherche.getRequeteSite_();
		HttpServerResponse reponseServeur = requeteSite.getReponseServeur();
		if(!champValeurs.isEmpty()) {
			Object champValeur = champValeurs.iterator().next();
			if(champValeur != null) {
				if(ENTITE_VAR_STOCKE_inrDate.equals(entiteVarStocke)) {
					if(j > 0)
						reponseServeur.write(VAL_citationVirguleEspaceCitation);
					reponseServeur.write(VAL_citation);
					reponseServeur.write(ENTITE_VAR_inrDate);
					reponseServeur.write(VAL_citationDeuxPointsEspaceCitation);
					reponseServeur.write(DateTimeFormatter.ISO_OFFSET_DATE.format(((Date)champValeur).toInstant().atZone(ZoneId.systemDefault()).toLocalDate()));
					reponseServeur.write(VAL_citationLigne);
					j++;
					return j;
				}
				if(ENTITE_VAR_STOCKE_inrDate.equals(entiteVarStocke)) {
					if(j > 0)
						reponseServeur.write(VAL_citationVirguleEspaceCitation);
					reponseServeur.write(VAL_citation);
					reponseServeur.write(ENTITE_VAR_inrDate);
					reponseServeur.write(VAL_citationDeuxPointsEspaceCitation);
					reponseServeur.write(DateTimeFormatter.ISO_OFFSET_DATE.format(((Date)champValeur).toInstant().atZone(ZoneId.systemDefault()).toLocalDate()));
					reponseServeur.write(VAL_citationLigne);
					j++;
					return j;
				}
				if(ENTITE_VAR_STOCKE_doseActuelValeur.equals(entiteVarStocke)) {
					if(j > 0)
						reponseServeur.write(VAL_virguleEspace);
					reponseServeur.write(VAL_citation);
					reponseServeur.write(ENTITE_VAR_doseActuelValeur);
					reponseServeur.write(VAL_citationDeuxPointsEspace);
					reponseServeur.write(BigDecimal.valueOf((Double)champValeur).toString());
					reponseServeur.write(VAL_ligne);
					j++;
					return j;
				}
				if(ENTITE_VAR_STOCKE_doseActuelValeur.equals(entiteVarStocke)) {
					if(j > 0)
						reponseServeur.write(VAL_virguleEspace);
					reponseServeur.write(VAL_citation);
					reponseServeur.write(ENTITE_VAR_doseActuelValeur);
					reponseServeur.write(VAL_citationDeuxPointsEspace);
					reponseServeur.write(BigDecimal.valueOf((Double)champValeur).toString());
					reponseServeur.write(VAL_ligne);
					j++;
					return j;
				}
				if(ENTITE_VAR_STOCKE_doseActuelTexte.equals(entiteVarStocke)) {
					if(j > 0)
						reponseServeur.write(VAL_virguleEspace);
					reponseServeur.write(VAL_citation);
					reponseServeur.write(ENTITE_VAR_doseActuelTexte);
					reponseServeur.write(VAL_citationDeuxPointsEspaceCitation);
					reponseServeur.write(Json.encode((String)champValeurs.iterator().next()));
					reponseServeur.write(VAL_citationLigne);
					j++;
					return j;
				}
				if(ENTITE_VAR_STOCKE_doseActuelTexte.equals(entiteVarStocke)) {
					if(j > 0)
						reponseServeur.write(VAL_virguleEspace);
					reponseServeur.write(VAL_citation);
					reponseServeur.write(ENTITE_VAR_doseActuelTexte);
					reponseServeur.write(VAL_citationDeuxPointsEspaceCitation);
					reponseServeur.write(Json.encode((String)champValeurs.iterator().next()));
					reponseServeur.write(VAL_citationLigne);
					j++;
					return j;
				}
				if(ENTITE_VAR_STOCKE_changementDoseValeur.equals(entiteVarStocke)) {
					if(j > 0)
						reponseServeur.write(VAL_virguleEspace);
					reponseServeur.write(VAL_citation);
					reponseServeur.write(ENTITE_VAR_changementDoseValeur);
					reponseServeur.write(VAL_citationDeuxPointsEspace);
					reponseServeur.write(BigDecimal.valueOf((Double)champValeur).toString());
					reponseServeur.write(VAL_ligne);
					j++;
					return j;
				}
				if(ENTITE_VAR_STOCKE_changementDoseValeur.equals(entiteVarStocke)) {
					if(j > 0)
						reponseServeur.write(VAL_virguleEspace);
					reponseServeur.write(VAL_citation);
					reponseServeur.write(ENTITE_VAR_changementDoseValeur);
					reponseServeur.write(VAL_citationDeuxPointsEspace);
					reponseServeur.write(BigDecimal.valueOf((Double)champValeur).toString());
					reponseServeur.write(VAL_ligne);
					j++;
					return j;
				}
				if(ENTITE_VAR_STOCKE_changementDoseTexte.equals(entiteVarStocke)) {
					if(j > 0)
						reponseServeur.write(VAL_virguleEspace);
					reponseServeur.write(VAL_citation);
					reponseServeur.write(ENTITE_VAR_changementDoseTexte);
					reponseServeur.write(VAL_citationDeuxPointsEspaceCitation);
					reponseServeur.write(Json.encode((String)champValeurs.iterator().next()));
					reponseServeur.write(VAL_citationLigne);
					j++;
					return j;
				}
				if(ENTITE_VAR_STOCKE_changementDoseTexte.equals(entiteVarStocke)) {
					if(j > 0)
						reponseServeur.write(VAL_virguleEspace);
					reponseServeur.write(VAL_citation);
					reponseServeur.write(ENTITE_VAR_changementDoseTexte);
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

	public void genererPostFinCalculInr(RequeteSite requeteSite) {
		HttpServerResponse reponseServeur = requeteSite.getReponseServeur();
		reponseServeur.write("\t]\n");
		reponseServeur.write("}\n");
	}
}
