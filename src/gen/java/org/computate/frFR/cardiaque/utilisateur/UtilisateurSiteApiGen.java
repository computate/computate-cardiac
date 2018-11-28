package org.computate.frFR.cardiaque.utilisateur;

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


public class UtilisateurSiteApiGen {

	private static final Logger LOGGER = LoggerFactory.getLogger(UtilisateurSiteApiGen.class);

	public static final String VAL_nomCanoniqueUtilisateurSite = "org.computate.frFR.cardiaque.utilisateur.UtilisateurSite";
	public static final String VAL_virguleEspace = ", ";
	public static final String VAL_citation = "\"";
	public static final String VAL_citationDeuxPointsEspaceCitation = "\": \"";
	public static final String VAL_citationDeuxPointsEspace = "\": ";
	public static final String VAL_citationLigne = "\"\n";
	public static final String VAL_ligne = "\n";
	public static final String VAL_citationVirguleEspaceCitation = "\", \"";
	public static final String VAL_citationDeuxPointsEspaceGuillmets = "\": [";
	public static final String VAL_guillmetsFin = "]";

	public static final String ENTITE_VAR_calculInrPks = "calculInrPks";
	public static final String ENTITE_VAR_INDEXE_calculInrPks = "calculInrPks_indexe_longs";
	public static final String ENTITE_VAR_STOCKE_calculInrPks = "calculInrPks_stocke_longs";
	public static final String ENTITE_VAR_calculInrPks_ATTRIBUER_CalculInr_utilisateurPk = "utilisateurPk";

	public static final String ENTITE_VAR_requeteSite_ = "requeteSite_";

	public static final String ENTITE_VAR_utilisateurNom = "utilisateurNom";
	public static final String ENTITE_VAR_INDEXE_utilisateurNom = "utilisateurNom_indexe_string";
	public static final String ENTITE_VAR_STOCKE_utilisateurNom = "utilisateurNom_stocke_string";

	public static final String ENTITE_VAR_utilisateurMail = "utilisateurMail";
	public static final String ENTITE_VAR_INDEXE_utilisateurMail = "utilisateurMail_indexe_string";
	public static final String ENTITE_VAR_STOCKE_utilisateurMail = "utilisateurMail_stocke_string";

	public static final String ENTITE_VAR_utilisateurId = "utilisateurId";
	public static final String ENTITE_VAR_INDEXE_utilisateurId = "utilisateurId_indexe_string";
	public static final String ENTITE_VAR_STOCKE_utilisateurId = "utilisateurId_stocke_string";

	public static final String ENTITE_VAR_utilisateurPrenom = "utilisateurPrenom";
	public static final String ENTITE_VAR_INDEXE_utilisateurPrenom = "utilisateurPrenom_indexe_string";
	public static final String ENTITE_VAR_STOCKE_utilisateurPrenom = "utilisateurPrenom_stocke_string";

	public static final String ENTITE_VAR_utilisateurNomFamille = "utilisateurNomFamille";
	public static final String ENTITE_VAR_INDEXE_utilisateurNomFamille = "utilisateurNomFamille_indexe_string";
	public static final String ENTITE_VAR_STOCKE_utilisateurNomFamille = "utilisateurNomFamille_stocke_string";

	public static final String ENTITE_VAR_utilisateurNomComplet = "utilisateurNomComplet";
	public static final String ENTITE_VAR_INDEXE_utilisateurNomComplet = "utilisateurNomComplet_indexe_string";
	public static final String ENTITE_VAR_STOCKE_utilisateurNomComplet = "utilisateurNomComplet_stocke_string";

	public static final String ENTITE_VAR_utilisateurSite = "utilisateurSite";
	public static final String ENTITE_VAR_INDEXE_utilisateurSite = "utilisateurSite_indexe_string";
	public static final String ENTITE_VAR_STOCKE_utilisateurSite = "utilisateurSite_stocke_string";

	public static final String ENTITE_VAR_utilisateurRecevoirCourriels = "utilisateurRecevoirCourriels";
	public static final String ENTITE_VAR_INDEXE_utilisateurRecevoirCourriels = "utilisateurRecevoirCourriels_indexe_boolean";
	public static final String ENTITE_VAR_STOCKE_utilisateurRecevoirCourriels = "utilisateurRecevoirCourriels_stocke_boolean";

	public static final String ENTITE_VAR_modeleSupprime = "modeleSupprime";
	public static final String ENTITE_VAR_INDEXE_modeleSupprime = "modeleSupprime_indexe_boolean";
	public static final String ENTITE_VAR_STOCKE_modeleSupprime = "modeleSupprime_stocke_boolean";

	public static final String ENTITE_VAR_modeleCree = "modeleCree";
	public static final String ENTITE_VAR_INDEXE_modeleCree = "modeleCree_indexenull";
	public static final String ENTITE_VAR_STOCKE_modeleCree = "modeleCree_stockenull";

	public static final String ENTITE_VAR_modeleModifie = "modeleModifie";
	public static final String ENTITE_VAR_INDEXE_modeleModifie = "modeleModifie_indexenull";
	public static final String ENTITE_VAR_STOCKE_modeleModifie = "modeleModifie_stockenull";

	public static final String ENTITE_VAR_modeleClasseNomCanonique = "modeleClasseNomCanonique";
	public static final String ENTITE_VAR_INDEXE_modeleClasseNomCanonique = "modeleClasseNomCanonique_indexe_string";
	public static final String ENTITE_VAR_STOCKE_modeleClasseNomCanonique = "modeleClasseNomCanonique_stocke_string";

	public static final String ENTITE_VAR_modeleCle = "modeleCle";
	public static final String ENTITE_VAR_INDEXE_modeleCle = "modeleCle_indexe_long";
	public static final String ENTITE_VAR_STOCKE_modeleCle = "modeleCle_stocke_long";

	public static final String ENTITE_VAR_modeleSuggestionStocke = "modeleSuggestionStocke";
	public static final String ENTITE_VAR_INDEXE_modeleSuggestionStocke = "modeleSuggestionStocke_indexe_string";
	public static final String ENTITE_VAR_STOCKE_modeleSuggestionStocke = "modeleSuggestionStocke_stocke_string";

	public static final String ENTITE_VAR_modeleSuggestionIndexe = "modeleSuggestionIndexe";
	public static final String ENTITE_VAR_INDEXE_modeleSuggestionIndexe = "modeleSuggestionIndexe_indexe_string";
	public static final String ENTITE_VAR_STOCKE_modeleSuggestionIndexe = "modeleSuggestionIndexe_stocke_string";

	public void handleGetUtilisateurSite(SiteContexte siteContexte) {
		OpenAPI3RouterFactory usineRouteur = siteContexte.getUsineRouteur_();

		usineRouteur.addHandlerByOperationId("getUtilisateurSite", contexteRoutage -> {
			try {

				contexteRoutage.response().putHeader("content-type", "application/json").setChunked(true);
				RequeteSite requeteSite = genererRequeteSitePourUtilisateurSite(siteContexte, contexteRoutage);
				SolrQuery rechercheSolr = requeteSite.getRechercheSolr_();
				SolrDocumentList resultatsRecherche = requeteSite.getReponseRecherche().getResults();
				Integer rechercheLignes = rechercheSolr.getRows();

				genererGetDebutUtilisateurSite(requeteSite);
				for(long i = resultatsRecherche.getStart(); i < resultatsRecherche.getNumFound(); i+=rechercheLignes) {
					for(int j = 0; j < resultatsRecherche.size(); j++) {
						long resultatIndice = i + j;
						SolrDocument documentSolr = resultatsRecherche.get(j);
						ResultatRecherche resultatRecherche = new ResultatRecherche();
						resultatRecherche.setRequeteSite_(requeteSite);
						resultatRecherche.setDocumentSolr(documentSolr);
						resultatRecherche.setResultatIndice(resultatIndice);
						genererGetIndividuelUtilisateurSite(resultatRecherche);
					}
				}
				genererGetFinUtilisateurSite(requeteSite);
				requeteSite.getReponseServeur().end();
			} catch(Exception e) {
				LOGGER.error("Error: ", e.getMessage());
				contexteRoutage.fail(e);
			}
		});
		usineRouteur.addFailureHandlerByOperationId("getUtilisateurSite", contexteRoutage -> {
			Throwable failure = contexteRoutage.failure();
			if (failure instanceof ValidationException) {
				String validationErrorMessage = failure.getMessage();
				LOGGER.error("Error: ", validationErrorMessage);
				contexteRoutage.fail(failure);
			}
		});
	}

	public void genererGetDebutUtilisateurSite(RequeteSite requeteSite) {
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

	public void genererGetIndividuelUtilisateurSite(ResultatRecherche resultatRecherche) throws Exception {
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
			j = genererGetUtilisateurSite(j, resultatRecherche, champNomStocke, champValeurs);
		}
		reponseServeur.write("\t\t}\n");
	}

	public void genererGetFinUtilisateurSite(RequeteSite requeteSite) {
		HttpServerResponse reponseServeur = requeteSite.getReponseServeur();
		reponseServeur.write("\t]\n");
		reponseServeur.write("}\n");
	}

	public String varIndexeUtilisateurSite(String entiteVar) throws Exception {
		switch(entiteVar) {
			case ENTITE_VAR_calculInrPks:
				return ENTITE_VAR_INDEXE_calculInrPks;
			case ENTITE_VAR_utilisateurNom:
				return ENTITE_VAR_INDEXE_utilisateurNom;
			case ENTITE_VAR_utilisateurMail:
				return ENTITE_VAR_INDEXE_utilisateurMail;
			case ENTITE_VAR_utilisateurId:
				return ENTITE_VAR_INDEXE_utilisateurId;
			case ENTITE_VAR_utilisateurPrenom:
				return ENTITE_VAR_INDEXE_utilisateurPrenom;
			case ENTITE_VAR_utilisateurNomFamille:
				return ENTITE_VAR_INDEXE_utilisateurNomFamille;
			case ENTITE_VAR_utilisateurNomComplet:
				return ENTITE_VAR_INDEXE_utilisateurNomComplet;
			case ENTITE_VAR_utilisateurSite:
				return ENTITE_VAR_INDEXE_utilisateurSite;
			case ENTITE_VAR_utilisateurRecevoirCourriels:
				return ENTITE_VAR_INDEXE_utilisateurRecevoirCourriels;
			case ENTITE_VAR_modeleSupprime:
				return ENTITE_VAR_INDEXE_modeleSupprime;
			case ENTITE_VAR_modeleCree:
				return ENTITE_VAR_INDEXE_modeleCree;
			case ENTITE_VAR_modeleModifie:
				return ENTITE_VAR_INDEXE_modeleModifie;
			case ENTITE_VAR_modeleClasseNomCanonique:
				return ENTITE_VAR_INDEXE_modeleClasseNomCanonique;
			case ENTITE_VAR_modeleCle:
				return ENTITE_VAR_INDEXE_modeleCle;
			case ENTITE_VAR_modeleSuggestionStocke:
				return ENTITE_VAR_INDEXE_modeleSuggestionStocke;
			case ENTITE_VAR_modeleSuggestionIndexe:
				return ENTITE_VAR_INDEXE_modeleSuggestionIndexe;
			default:
				throw new Exception(String.format("\"%s\" n'est pas une entité indexé. ", entiteVar));
		}
	}

	public SolrQuery genererRechercheUtilisateurSite(HttpServerRequest requeteServeur) throws Exception {
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
						varIndexe = varIndexeUtilisateurSite(paramCle);
						rechercheSolr.setQuery(varIndexe + ":" + ClientUtils.escapeQueryChars(valeurIndexe));
						break;
					case "fq":
						entiteVar = StringUtils.trim(StringUtils.substringBefore(paramValeur, ":"));
						valeurIndexe = StringUtils.trim(StringUtils.substringAfter(paramValeur, ":"));
						varIndexe = varIndexeUtilisateurSite(paramCle);
						rechercheSolr.addFilterQuery(varIndexe + ":" + ClientUtils.escapeQueryChars(valeurIndexe));
						break;
					case "sort":
						entiteVar = StringUtils.trim(StringUtils.substringBefore(paramValeur, " "));
						valeurTri = StringUtils.trim(StringUtils.substringAfter(paramValeur, " "));
						varIndexe = varIndexeUtilisateurSite(paramCle);
						rechercheSolr.addSort(varIndexe, ORDER.valueOf(valeurTri));
						break;
					case "fl":
						entiteVar = StringUtils.trim(paramValeur);
						varIndexe = varIndexeUtilisateurSite(paramCle);
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

	public RequeteSite genererRequeteSitePourUtilisateurSite(SiteContexte siteContexte, RoutingContext contexteItineraire) throws Exception {
		Vertx vertx = siteContexte.getVertx_();
		SolrQuery rechercheSolr = genererRechercheUtilisateurSite(contexteItineraire.request());

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

	public Integer genererGetUtilisateurSite(Integer j, ResultatRecherche resultatRecherche, String entiteVarStocke, Collection<Object> champValeurs) throws Exception {
		RequeteSite requeteSite = resultatRecherche.getRequeteSite_();
		HttpServerResponse reponseServeur = requeteSite.getReponseServeur();
		if(!champValeurs.isEmpty()) {
			Object champValeur = champValeurs.iterator().next();
			if(champValeur != null) {
				if(ENTITE_VAR_STOCKE_calculInrPks.equals(entiteVarStocke)) {
					if(j > 0)
						reponseServeur.write(VAL_citationVirguleEspaceCitation);
					reponseServeur.write(VAL_citation);
					reponseServeur.write(ENTITE_VAR_calculInrPks);
					reponseServeur.write(VAL_citationDeuxPointsEspaceGuillmets);
					int k = 0;
					while(champValeur != null) {
						if(k > 0)
							reponseServeur.write(VAL_virguleEspace);
						reponseServeur.write(((Long)champValeur).toString());
						champValeur = champValeurs.iterator().next();
					}
					reponseServeur.write(VAL_guillmetsFin);
					j++;
					return j;
				}
				if(ENTITE_VAR_STOCKE_utilisateurNom.equals(entiteVarStocke)) {
					if(j > 0)
						reponseServeur.write(VAL_virguleEspace);
					reponseServeur.write(VAL_citation);
					reponseServeur.write(ENTITE_VAR_utilisateurNom);
					reponseServeur.write(VAL_citationDeuxPointsEspaceCitation);
					reponseServeur.write(Json.encode((String)champValeurs.iterator().next()));
					reponseServeur.write(VAL_citationLigne);
					j++;
					return j;
				}
				if(ENTITE_VAR_STOCKE_utilisateurMail.equals(entiteVarStocke)) {
					if(j > 0)
						reponseServeur.write(VAL_virguleEspace);
					reponseServeur.write(VAL_citation);
					reponseServeur.write(ENTITE_VAR_utilisateurMail);
					reponseServeur.write(VAL_citationDeuxPointsEspaceCitation);
					reponseServeur.write(Json.encode((String)champValeurs.iterator().next()));
					reponseServeur.write(VAL_citationLigne);
					j++;
					return j;
				}
				if(ENTITE_VAR_STOCKE_utilisateurId.equals(entiteVarStocke)) {
					if(j > 0)
						reponseServeur.write(VAL_virguleEspace);
					reponseServeur.write(VAL_citation);
					reponseServeur.write(ENTITE_VAR_utilisateurId);
					reponseServeur.write(VAL_citationDeuxPointsEspaceCitation);
					reponseServeur.write(Json.encode((String)champValeurs.iterator().next()));
					reponseServeur.write(VAL_citationLigne);
					j++;
					return j;
				}
				if(ENTITE_VAR_STOCKE_utilisateurPrenom.equals(entiteVarStocke)) {
					if(j > 0)
						reponseServeur.write(VAL_virguleEspace);
					reponseServeur.write(VAL_citation);
					reponseServeur.write(ENTITE_VAR_utilisateurPrenom);
					reponseServeur.write(VAL_citationDeuxPointsEspaceCitation);
					reponseServeur.write(Json.encode((String)champValeurs.iterator().next()));
					reponseServeur.write(VAL_citationLigne);
					j++;
					return j;
				}
				if(ENTITE_VAR_STOCKE_utilisateurNomFamille.equals(entiteVarStocke)) {
					if(j > 0)
						reponseServeur.write(VAL_virguleEspace);
					reponseServeur.write(VAL_citation);
					reponseServeur.write(ENTITE_VAR_utilisateurNomFamille);
					reponseServeur.write(VAL_citationDeuxPointsEspaceCitation);
					reponseServeur.write(Json.encode((String)champValeurs.iterator().next()));
					reponseServeur.write(VAL_citationLigne);
					j++;
					return j;
				}
				if(ENTITE_VAR_STOCKE_utilisateurNomComplet.equals(entiteVarStocke)) {
					if(j > 0)
						reponseServeur.write(VAL_virguleEspace);
					reponseServeur.write(VAL_citation);
					reponseServeur.write(ENTITE_VAR_utilisateurNomComplet);
					reponseServeur.write(VAL_citationDeuxPointsEspaceCitation);
					reponseServeur.write(Json.encode((String)champValeurs.iterator().next()));
					reponseServeur.write(VAL_citationLigne);
					j++;
					return j;
				}
				if(ENTITE_VAR_STOCKE_utilisateurSite.equals(entiteVarStocke)) {
					if(j > 0)
						reponseServeur.write(VAL_virguleEspace);
					reponseServeur.write(VAL_citation);
					reponseServeur.write(ENTITE_VAR_utilisateurSite);
					reponseServeur.write(VAL_citationDeuxPointsEspaceCitation);
					reponseServeur.write(Json.encode((String)champValeurs.iterator().next()));
					reponseServeur.write(VAL_citationLigne);
					j++;
					return j;
				}
				if(ENTITE_VAR_STOCKE_utilisateurRecevoirCourriels.equals(entiteVarStocke)) {
					if(j > 0)
						reponseServeur.write(VAL_virguleEspace);
					reponseServeur.write(VAL_citation);
					reponseServeur.write(ENTITE_VAR_utilisateurRecevoirCourriels);
					reponseServeur.write(VAL_citationDeuxPointsEspace);
					reponseServeur.write(((Boolean)champValeur).toString());
					reponseServeur.write(VAL_ligne);
					j++;
					return j;
				}
				if(ENTITE_VAR_STOCKE_modeleSupprime.equals(entiteVarStocke)) {
					if(j > 0)
						reponseServeur.write(VAL_virguleEspace);
					reponseServeur.write(VAL_citation);
					reponseServeur.write(ENTITE_VAR_modeleSupprime);
					reponseServeur.write(VAL_citationDeuxPointsEspace);
					reponseServeur.write(((Boolean)champValeur).toString());
					reponseServeur.write(VAL_ligne);
					j++;
					return j;
				}
				if(ENTITE_VAR_STOCKE_modeleCree.equals(entiteVarStocke)) {
					if(j > 0)
						reponseServeur.write(VAL_virguleEspace);
					reponseServeur.write(VAL_citation);
					reponseServeur.write(ENTITE_VAR_modeleCree);
					reponseServeur.write(VAL_citationDeuxPointsEspaceCitation);
					reponseServeur.write(Json.encode((String)champValeurs.iterator().next()));
					reponseServeur.write(VAL_citationLigne);
					j++;
					return j;
				}
				if(ENTITE_VAR_STOCKE_modeleModifie.equals(entiteVarStocke)) {
					if(j > 0)
						reponseServeur.write(VAL_virguleEspace);
					reponseServeur.write(VAL_citation);
					reponseServeur.write(ENTITE_VAR_modeleModifie);
					reponseServeur.write(VAL_citationDeuxPointsEspaceCitation);
					reponseServeur.write(Json.encode((String)champValeurs.iterator().next()));
					reponseServeur.write(VAL_citationLigne);
					j++;
					return j;
				}
				if(ENTITE_VAR_STOCKE_modeleClasseNomCanonique.equals(entiteVarStocke)) {
					if(j > 0)
						reponseServeur.write(VAL_virguleEspace);
					reponseServeur.write(VAL_citation);
					reponseServeur.write(ENTITE_VAR_modeleClasseNomCanonique);
					reponseServeur.write(VAL_citationDeuxPointsEspaceCitation);
					reponseServeur.write(Json.encode((String)champValeurs.iterator().next()));
					reponseServeur.write(VAL_citationLigne);
					j++;
					return j;
				}
				if(ENTITE_VAR_STOCKE_modeleCle.equals(entiteVarStocke)) {
					if(j > 0)
						reponseServeur.write(VAL_virguleEspace);
					reponseServeur.write(VAL_citation);
					reponseServeur.write(ENTITE_VAR_modeleCle);
					reponseServeur.write(VAL_citationDeuxPointsEspace);
					reponseServeur.write(((Long)champValeur).toString());
					reponseServeur.write(VAL_ligne);
					j++;
					return j;
				}
				if(ENTITE_VAR_STOCKE_modeleSuggestionStocke.equals(entiteVarStocke)) {
					if(j > 0)
						reponseServeur.write(VAL_virguleEspace);
					reponseServeur.write(VAL_citation);
					reponseServeur.write(ENTITE_VAR_modeleSuggestionStocke);
					reponseServeur.write(VAL_citationDeuxPointsEspaceCitation);
					reponseServeur.write(Json.encode((String)champValeurs.iterator().next()));
					reponseServeur.write(VAL_citationLigne);
					j++;
					return j;
				}
				if(ENTITE_VAR_STOCKE_modeleSuggestionIndexe.equals(entiteVarStocke)) {
					if(j > 0)
						reponseServeur.write(VAL_virguleEspace);
					reponseServeur.write(VAL_citation);
					reponseServeur.write(ENTITE_VAR_modeleSuggestionIndexe);
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

	protected void postUtilisateurSite(SiteContexte siteContexte) {
		OpenAPI3RouterFactory usineRouteur = siteContexte.getUsineRouteur_();
		usineRouteur.addHandlerByOperationId("postUtilisateurSite", contexteRoutage -> {
			try {
				RequeteSite requeteSite = genererRequeteSitePourUtilisateurSite(siteContexte, contexteRoutage);
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
								, new JsonArray(Arrays.asList(VAL_nomCanoniqueUtilisateurSite, utilisateurId))
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
										case "calculInrPks":
											postSql.append(SiteContexte.SQL_setP);
											postSqlParams.addAll(Arrays.asList(ENTITE_VAR_calculInrPks, requeteJson.getJsonArray(entiteVar), postPk));
											break;
										case "utilisateurNom":
											postSql.append(SiteContexte.SQL_setP);
											postSqlParams.addAll(Arrays.asList(ENTITE_VAR_utilisateurNom, requeteJson.getString(entiteVar), postPk));
											break;
										case "utilisateurMail":
											postSql.append(SiteContexte.SQL_setP);
											postSqlParams.addAll(Arrays.asList(ENTITE_VAR_utilisateurMail, requeteJson.getString(entiteVar), postPk));
											break;
										case "utilisateurId":
											postSql.append(SiteContexte.SQL_setP);
											postSqlParams.addAll(Arrays.asList(ENTITE_VAR_utilisateurId, requeteJson.getString(entiteVar), postPk));
											break;
										case "utilisateurPrenom":
											postSql.append(SiteContexte.SQL_setP);
											postSqlParams.addAll(Arrays.asList(ENTITE_VAR_utilisateurPrenom, requeteJson.getString(entiteVar), postPk));
											break;
										case "utilisateurNomFamille":
											postSql.append(SiteContexte.SQL_setP);
											postSqlParams.addAll(Arrays.asList(ENTITE_VAR_utilisateurNomFamille, requeteJson.getString(entiteVar), postPk));
											break;
										case "utilisateurNomComplet":
											postSql.append(SiteContexte.SQL_setP);
											postSqlParams.addAll(Arrays.asList(ENTITE_VAR_utilisateurNomComplet, requeteJson.getString(entiteVar), postPk));
											break;
										case "utilisateurSite":
											postSql.append(SiteContexte.SQL_setP);
											postSqlParams.addAll(Arrays.asList(ENTITE_VAR_utilisateurSite, requeteJson.getString(entiteVar), postPk));
											break;
										case "utilisateurRecevoirCourriels":
											postSql.append(SiteContexte.SQL_setP);
											postSqlParams.addAll(Arrays.asList(ENTITE_VAR_utilisateurRecevoirCourriels, requeteJson.getBoolean(entiteVar), postPk));
											break;
										case "modeleSupprime":
											postSql.append(SiteContexte.SQL_setP);
											postSqlParams.addAll(Arrays.asList(ENTITE_VAR_modeleSupprime, requeteJson.getBoolean(entiteVar), postPk));
											break;
										case "modeleClasseNomCanonique":
											postSql.append(SiteContexte.SQL_setP);
											postSqlParams.addAll(Arrays.asList(ENTITE_VAR_modeleClasseNomCanonique, requeteJson.getString(entiteVar), postPk));
											break;
										case "modeleCle":
											postSql.append(SiteContexte.SQL_setP);
											postSqlParams.addAll(Arrays.asList(ENTITE_VAR_modeleCle, requeteJson.getLong(entiteVar), postPk));
											break;
										case "modeleSuggestionStocke":
											postSql.append(SiteContexte.SQL_setP);
											postSqlParams.addAll(Arrays.asList(ENTITE_VAR_modeleSuggestionStocke, requeteJson.getString(entiteVar), postPk));
											break;
										case "modeleSuggestionIndexe":
											postSql.append(SiteContexte.SQL_setP);
											postSqlParams.addAll(Arrays.asList(ENTITE_VAR_modeleSuggestionIndexe, requeteJson.getString(entiteVar), postPk));
											break;
									}
								}
								connexionSql.queryWithParams(postSql.toString(), new JsonArray(postSqlParams), asyncParams -> {
									connexionSql.close();
									if(asyncParams.succeeded()) {
										UtilisateurSite o = new UtilisateurSite();
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

				genererPostDebutUtilisateurSite(requeteSite);
				UtilisateurSite nouveauUtilisateurSite = new UtilisateurSite();
				nouveauUtilisateurSite.initLoinUtilisateurSite(requeteSite);
				nouveauUtilisateurSite.peuplerUtilisateurSite();
				postUtilisateurSite();
				genererPostFinUtilisateurSite(requeteSite);
				requeteSite.getReponseServeur().end();


				reponseServeur.write("\t]\n");
				reponseServeur.write("}\n");
			} catch(Exception e) {
				LOGGER.error("Error: ", e.getMessage());
				contexteRoutage.fail(e);
			}
		});
	}

	protected void patchUtilisateurSite(SiteContexte siteContexte) {
		OpenAPI3RouterFactory usineRouteur = siteContexte.getUsineRouteur_();
		usineRouteur.addHandlerByOperationId("patchUtilisateurSite", contexteRoutage -> {
			try {
				RequeteSite requeteSite = genererRequeteSitePourUtilisateurSite(siteContexte, contexteRoutage);
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
								, new JsonArray(Arrays.asList(VAL_nomCanoniqueUtilisateurSite, utilisateurId))
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
										case "addCalculInrPks":
											patchSql.append(SiteContexte.SQL_addA);
											patchSqlParams.addAll(Arrays.asList(
													ENTITE_VAR_calculInrPks
													, patchPk
													, ENTITE_VAR_calculInrPks_ATTRIBUER_CalculInr_utilisateurPk
													, requeteJson.getLong(methodeNom)
													));
										case "addAllCalculInrPks":
											JsonArray addAllCalculInrPksValeurs = requeteJson.getJsonArray(methodeNom);
											for(Integer i = 0; i <  addAllCalculInrPksValeurs.size(); i++) {
												patchSql.append(SiteContexte.SQL_addA);
												patchSqlParams.addAll(Arrays.asList(
														ENTITE_VAR_calculInrPks
														, patchPk
														, ENTITE_VAR_calculInrPks_ATTRIBUER_CalculInr_utilisateurPk
														, addAllCalculInrPksValeurs.getLong(i)
														));
											}
										case "setCalculInrPks":
											JsonArray setCalculInrPksValeurs = requeteJson.getJsonArray(methodeNom);
											patchSql.append(SiteContexte.SQL_clearA1);
											patchSqlParams.addAll(Arrays.asList(
													ENTITE_VAR_calculInrPks
													, patchPk
													, ENTITE_VAR_calculInrPks_ATTRIBUER_CalculInr_utilisateurPk
													, requeteJson.getJsonArray(methodeNom)
													));
											for(Integer i = 0; i <  setCalculInrPksValeurs.size(); i++) {
												patchSql.append(SiteContexte.SQL_addA);
												patchSqlParams.addAll(Arrays.asList(
														ENTITE_VAR_calculInrPks
														, patchPk
														, ENTITE_VAR_calculInrPks_ATTRIBUER_CalculInr_utilisateurPk
														, setCalculInrPksValeurs.getLong(i)
														));
											}
											break;
										case "setUtilisateurNom":
											patchSql.append(SiteContexte.SQL_setP);
											patchSqlParams.addAll(Arrays.asList(ENTITE_VAR_utilisateurNom, requeteJson.getString(methodeNom), patchPk));
											break;
										case "setUtilisateurMail":
											patchSql.append(SiteContexte.SQL_setP);
											patchSqlParams.addAll(Arrays.asList(ENTITE_VAR_utilisateurMail, requeteJson.getString(methodeNom), patchPk));
											break;
										case "setUtilisateurId":
											patchSql.append(SiteContexte.SQL_setP);
											patchSqlParams.addAll(Arrays.asList(ENTITE_VAR_utilisateurId, requeteJson.getString(methodeNom), patchPk));
											break;
										case "setUtilisateurPrenom":
											patchSql.append(SiteContexte.SQL_setP);
											patchSqlParams.addAll(Arrays.asList(ENTITE_VAR_utilisateurPrenom, requeteJson.getString(methodeNom), patchPk));
											break;
										case "setUtilisateurNomFamille":
											patchSql.append(SiteContexte.SQL_setP);
											patchSqlParams.addAll(Arrays.asList(ENTITE_VAR_utilisateurNomFamille, requeteJson.getString(methodeNom), patchPk));
											break;
										case "setUtilisateurNomComplet":
											patchSql.append(SiteContexte.SQL_setP);
											patchSqlParams.addAll(Arrays.asList(ENTITE_VAR_utilisateurNomComplet, requeteJson.getString(methodeNom), patchPk));
											break;
										case "setUtilisateurSite":
											patchSql.append(SiteContexte.SQL_setP);
											patchSqlParams.addAll(Arrays.asList(ENTITE_VAR_utilisateurSite, requeteJson.getString(methodeNom), patchPk));
											break;
										case "setUtilisateurRecevoirCourriels":
											patchSql.append(SiteContexte.SQL_setP);
											patchSqlParams.addAll(Arrays.asList(ENTITE_VAR_utilisateurRecevoirCourriels, requeteJson.getBoolean(methodeNom), patchPk));
											break;
										case "setModeleSupprime":
											patchSql.append(SiteContexte.SQL_setP);
											patchSqlParams.addAll(Arrays.asList(ENTITE_VAR_modeleSupprime, requeteJson.getBoolean(methodeNom), patchPk));
											break;
										case "setModeleClasseNomCanonique":
											patchSql.append(SiteContexte.SQL_setP);
											patchSqlParams.addAll(Arrays.asList(ENTITE_VAR_modeleClasseNomCanonique, requeteJson.getString(methodeNom), patchPk));
											break;
										case "setModeleCle":
											patchSql.append(SiteContexte.SQL_setP);
											patchSqlParams.addAll(Arrays.asList(ENTITE_VAR_modeleCle, requeteJson.getLong(methodeNom), patchPk));
											break;
										case "setModeleSuggestionStocke":
											patchSql.append(SiteContexte.SQL_setP);
											patchSqlParams.addAll(Arrays.asList(ENTITE_VAR_modeleSuggestionStocke, requeteJson.getString(methodeNom), patchPk));
											break;
										case "setModeleSuggestionIndexe":
											patchSql.append(SiteContexte.SQL_setP);
											patchSqlParams.addAll(Arrays.asList(ENTITE_VAR_modeleSuggestionIndexe, requeteJson.getString(methodeNom), patchPk));
											break;
									}
								}
								connexionSql.queryWithParams(patchSql.toString(), new JsonArray(patchSqlParams), asyncParams -> {
									connexionSql.close();
									if(asyncParams.succeeded()) {
										UtilisateurSite o = new UtilisateurSite();
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

				genererPatchDebutUtilisateurSite(requeteSite);
				UtilisateurSite nouveauUtilisateurSite = new UtilisateurSite();
				nouveauUtilisateurSite.initLoinUtilisateurSite(requeteSite);
				nouveauUtilisateurSite.peuplerUtilisateurSite();
				patchUtilisateurSite();
				genererPatchFinUtilisateurSite(requeteSite);
				requeteSite.getReponseServeur().end();


				reponseServeur.write("\t]\n");
				reponseServeur.write("}\n");
			} catch(Exception e) {
				LOGGER.error("Error: ", e.getMessage());
				contexteRoutage.fail(e);
			}
		});
	}
}
