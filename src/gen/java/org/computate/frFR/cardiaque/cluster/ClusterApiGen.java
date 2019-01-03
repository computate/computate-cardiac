package org.computate.frFR.cardiaque.cluster;

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


public class ClusterApiGen {

	private static final Logger LOGGER = LoggerFactory.getLogger(ClusterApiGen.class);

	public static final String VAL_nomCanoniqueCluster = "org.computate.frFR.cardiaque.cluster.Cluster";
	public static final String VAL_virguleEspace = ", ";
	public static final String VAL_citation = "\"";
	public static final String VAL_citationDeuxPointsEspaceCitation = "\": \"";
	public static final String VAL_citationDeuxPointsEspace = "\": ";
	public static final String VAL_citationLigne = "\"\n";
	public static final String VAL_ligne = "\n";
	public static final String VAL_citationVirguleEspaceCitation = "\", \"";
	public static final String VAL_citationDeuxPointsEspaceGuillmets = "\": [";
	public static final String VAL_guillmetsFin = "]";

	public static final String ENTITE_VAR_requeteSite_ = "requeteSite_";

	public static final String ENTITE_VAR_page_ = "page_";

	public static final String ENTITE_VAR_pk = "pk";
	public static final String ENTITE_VAR_INDEXE_pk = "pk_indexed_long";
	public static final String ENTITE_VAR_STOCKE_pk = "pk_stored_long";

	public static final String ENTITE_VAR_id = "id";

	public static final String ENTITE_VAR_cree = "cree";
	public static final String ENTITE_VAR_INDEXE_cree = "cree_indexed_date";
	public static final String ENTITE_VAR_STOCKE_cree = "cree_stored_date";

	public static final String ENTITE_VAR_modifie = "modifie";
	public static final String ENTITE_VAR_INDEXE_modifie = "modifie_indexed_date";
	public static final String ENTITE_VAR_STOCKE_modifie = "modifie_stored_date";

	public static final String ENTITE_VAR_utilisateurId = "utilisateurId";
	public static final String ENTITE_VAR_INDEXE_utilisateurId = "utilisateurId_indexed_string";
	public static final String ENTITE_VAR_STOCKE_utilisateurId = "utilisateurId_stored_string";

	public static final String ENTITE_VAR_clusterNomCanonique = "clusterNomCanonique";
	public static final String ENTITE_VAR_INDEXE_clusterNomCanonique = "clusterNomCanonique_indexed_string";
	public static final String ENTITE_VAR_STOCKE_clusterNomCanonique = "clusterNomCanonique_stored_string";

	public static final String ENTITE_VAR_clusterNomSimple = "clusterNomSimple";
	public static final String ENTITE_VAR_INDEXE_clusterNomSimple = "clusterNomSimple_indexed_string";
	public static final String ENTITE_VAR_STOCKE_clusterNomSimple = "clusterNomSimple_stored_string";

	public static final String ENTITE_VAR_supprime = "supprime";

	public void handleGetCluster(SiteContexte siteContexte) {
		OpenAPI3RouterFactory usineRouteur = siteContexte.getUsineRouteur_();

		usineRouteur.addHandlerByOperationId("getCluster", contexteRoutage -> {
			try {

				contexteRoutage.response().putHeader("content-type", "application/json").setChunked(true);
				RequeteSite requeteSite = genererRequeteSitePourCluster(siteContexte, contexteRoutage);
				SolrQuery rechercheSolr = requeteSite.getRechercheSolr_();
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
				contexteRoutage.fail(e);
			}
		});
		usineRouteur.addFailureHandlerByOperationId("getCluster", contexteRoutage -> {
			Throwable failure = contexteRoutage.failure();
			if (failure instanceof ValidationException) {
				String validationErrorMessage = failure.getMessage();
				LOGGER.error("Error: ", validationErrorMessage);
				contexteRoutage.fail(failure);
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
			case ENTITE_VAR_pk:
				return ENTITE_VAR_INDEXE_pk;
			case ENTITE_VAR_cree:
				return ENTITE_VAR_INDEXE_cree;
			case ENTITE_VAR_modifie:
				return ENTITE_VAR_INDEXE_modifie;
			case ENTITE_VAR_utilisateurId:
				return ENTITE_VAR_INDEXE_utilisateurId;
			case ENTITE_VAR_clusterNomCanonique:
				return ENTITE_VAR_INDEXE_clusterNomCanonique;
			case ENTITE_VAR_clusterNomSimple:
				return ENTITE_VAR_INDEXE_clusterNomSimple;
			default:
				throw new Exception(String.format("\"%s\" n'est pas une entité indexé. ", entiteVar));
		}
	}

	public SolrQuery genererRechercheCluster(HttpServerRequest requeteServeur) throws Exception {
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
						varIndexe = varIndexeCluster(paramCle);
						rechercheSolr.setQuery(varIndexe + ":" + ClientUtils.escapeQueryChars(valeurIndexe));
						break;
					case "fq":
						entiteVar = StringUtils.trim(StringUtils.substringBefore(paramValeur, ":"));
						valeurIndexe = StringUtils.trim(StringUtils.substringAfter(paramValeur, ":"));
						varIndexe = varIndexeCluster(paramCle);
						rechercheSolr.addFilterQuery(varIndexe + ":" + ClientUtils.escapeQueryChars(valeurIndexe));
						break;
					case "sort":
						entiteVar = StringUtils.trim(StringUtils.substringBefore(paramValeur, " "));
						valeurTri = StringUtils.trim(StringUtils.substringAfter(paramValeur, " "));
						varIndexe = varIndexeCluster(paramCle);
						rechercheSolr.addSort(varIndexe, ORDER.valueOf(valeurTri));
						break;
					case "fl":
						entiteVar = StringUtils.trim(paramValeur);
						varIndexe = varIndexeCluster(paramCle);
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

	public RequeteSite genererRequeteSitePourCluster(SiteContexte siteContexte, RoutingContext contexteItineraire) throws Exception {
		Vertx vertx = siteContexte.getVertx_();
		SolrQuery rechercheSolr = genererRechercheCluster(contexteItineraire.request());

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

	public Integer genererGetCluster(Integer j, ResultatRecherche resultatRecherche, String entiteVarStocke, Collection<Object> champValeurs) throws Exception {
		RequeteSite requeteSite = resultatRecherche.getRequeteSite_();
		HttpServerResponse reponseServeur = requeteSite.getReponseServeur();
		if(!champValeurs.isEmpty()) {
			Object champValeur = champValeurs.iterator().next();
			if(champValeur != null) {
				if(ENTITE_VAR_STOCKE_pk.equals(entiteVarStocke)) {
					if(j > 0)
						reponseServeur.write(", ");
					reponseServeur.write("\"pk\": ");
					reponseServeur.write(((Long)champValeur).toString());
					reponseServeur.write("\n");
					j++;
					return j;
				}
				if(ENTITE_VAR_STOCKE_cree.equals(entiteVarStocke)) {
					if(j > 0)
						reponseServeur.write(", ");
					reponseServeur.write("\"cree\": \"");
					reponseServeur.write(DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(((Date)champValeur).toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime()));
					reponseServeur.write("\"\n");
					j++;
					return j;
				}
				if(ENTITE_VAR_STOCKE_modifie.equals(entiteVarStocke)) {
					if(j > 0)
						reponseServeur.write(", ");
					reponseServeur.write("\"modifie\": \"");
					reponseServeur.write(DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(((Date)champValeur).toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime()));
					reponseServeur.write("\"\n");
					j++;
					return j;
				}
				if(ENTITE_VAR_STOCKE_utilisateurId.equals(entiteVarStocke)) {
					if(j > 0)
						reponseServeur.write(", ");
					reponseServeur.write("\"utilisateurId\": \"");
					reponseServeur.write(Json.encode((String)champValeurs.iterator().next()));
					reponseServeur.write("\"\n");
					j++;
					return j;
				}
				if(ENTITE_VAR_STOCKE_clusterNomCanonique.equals(entiteVarStocke)) {
					if(j > 0)
						reponseServeur.write(", ");
					reponseServeur.write("\"clusterNomCanonique\": \"");
					reponseServeur.write(Json.encode((String)champValeurs.iterator().next()));
					reponseServeur.write("\"\n");
					j++;
					return j;
				}
				if(ENTITE_VAR_STOCKE_clusterNomSimple.equals(entiteVarStocke)) {
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

	protected void patchCluster(SiteContexte siteContexte) {
		OpenAPI3RouterFactory usineRouteur = siteContexte.getUsineRouteur_();
		usineRouteur.addHandlerByOperationId("patchCluster", contexteRoutage -> {
			try {
				RequeteSite requeteSite = genererRequeteSitePourCluster(siteContexte, contexteRoutage);
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
								, new JsonArray(Arrays.asList(VAL_nomCanoniqueCluster, utilisateurId))
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
										case "setPk":
											patchSql.append(SiteContexte.SQL_setP);
											patchSqlParams.addAll(Arrays.asList(ENTITE_VAR_pk, requeteJson.getLong(methodeNom), patchPk));
											break;
										case "setId":
											patchSql.append(SiteContexte.SQL_setP);
											patchSqlParams.addAll(Arrays.asList(ENTITE_VAR_id, requeteJson.getString(methodeNom), patchPk));
											break;
										case "setCree":
											patchSql.append(SiteContexte.SQL_setP);
											patchSqlParams.addAll(Arrays.asList(ENTITE_VAR_cree, requeteJson.getInstant(methodeNom), patchPk));
											break;
										case "setModifie":
											patchSql.append(SiteContexte.SQL_setP);
											patchSqlParams.addAll(Arrays.asList(ENTITE_VAR_modifie, requeteJson.getInstant(methodeNom), patchPk));
											break;
										case "setUtilisateurId":
											patchSql.append(SiteContexte.SQL_setP);
											patchSqlParams.addAll(Arrays.asList(ENTITE_VAR_utilisateurId, requeteJson.getString(methodeNom), patchPk));
											break;
										case "setClusterNomCanonique":
											patchSql.append(SiteContexte.SQL_setP);
											patchSqlParams.addAll(Arrays.asList(ENTITE_VAR_clusterNomCanonique, requeteJson.getString(methodeNom), patchPk));
											break;
										case "setClusterNomSimple":
											patchSql.append(SiteContexte.SQL_setP);
											patchSqlParams.addAll(Arrays.asList(ENTITE_VAR_clusterNomSimple, requeteJson.getString(methodeNom), patchPk));
											break;
										case "setSupprime":
											patchSql.append(SiteContexte.SQL_setP);
											patchSqlParams.addAll(Arrays.asList(ENTITE_VAR_supprime, requeteJson.getBoolean(methodeNom), patchPk));
											break;
									}
								}
								connexionSql.queryWithParams(patchSql.toString(), new JsonArray(patchSqlParams), asyncParams -> {
									connexionSql.close();
									if(asyncParams.succeeded()) {
										Cluster o = new Cluster();
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
