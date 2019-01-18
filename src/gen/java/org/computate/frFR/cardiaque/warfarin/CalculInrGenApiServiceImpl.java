package org.computate.frFR.cardiaque.warfarin;

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


public class CalculInrGenApiServiceImpl implements CalculInrGenApiService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CalculInrGenApiServiceImpl.class);

	private static final String SERVICE_ADDRESS = "CalculInrApiServiceImpl";

	protected SiteContexte siteContexte;

	public CalculInrGenApiServiceImpl(SiteContexte siteContexte) {
		this.siteContexte = siteContexte;
		CalculInrGenApiService service = CalculInrGenApiService.creerProxy(siteContexte.getVertx(), SERVICE_ADDRESS);
	}

	// Recherche //

	@Override
	public void gererRechercheCalculInr(OperationRequest operationRequete, Handler<AsyncResult<OperationResponse>> gestionnaireEvenements) {
		try {
			RequeteSite requeteSite = genererRequeteSitePourCalculInr(siteContexte);
			Future<OperationResponse> etapesFutures = rechercheCalculInr(requeteSite).compose(listeCalculInr -> 
				listeRechercheCalculInr(listeCalculInr)
			);
			etapesFutures.setHandler(gestionnaireEvenements);
		} catch(Exception e) {
			gestionnaireEvenements.handle(Future.failedFuture(e));
		}
	}

	public Future<ListeRecherche<CalculInr>> rechercheCalculInr(RequeteSite requeteSite) {
		String entiteVar = null;
		String valeurIndexe = null;
		String varIndexe = null;
		String valeurTri = null;
		Integer rechercheDebut = null;
		Integer rechercheNum = null;
		ListeRecherche<CalculInr> listeRecherche = new ListeRecherche<CalculInr>();
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
						varIndexe = varIndexeCalculInr(entiteVar);
						listeRecherche.setQuery(varIndexe + ":" + ClientUtils.escapeQueryChars(valeurIndexe));
						break;
					case "fq":
						entiteVar = StringUtils.trim(StringUtils.substringBefore(paireValeur, ":"));
						valeurIndexe = StringUtils.trim(StringUtils.substringAfter(paireValeur, ":"));
						varIndexe = varIndexeCalculInr(entiteVar);
						listeRecherche.addFilterQuery(varIndexe + ":" + ClientUtils.escapeQueryChars(valeurIndexe));
						break;
					case "sort":
						entiteVar = StringUtils.trim(StringUtils.substringBefore(paireValeur, " "));
						valeurTri = StringUtils.trim(StringUtils.substringAfter(paireValeur, " "));
						varIndexe = varIndexeCalculInr(entiteVar);
						listeRecherche.addSort(varIndexe, ORDER.valueOf(valeurTri));
						break;
					case "fl":
						entiteVar = StringUtils.trim(paireValeur);
						varIndexe = varIndexeCalculInr(entiteVar);
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

	public Future<OperationResponse> jsonRechercheCalculInr(ListeRecherche<CalculInr> listeCalculInr) {
		Buffer buffer = Buffer.buffer();
		return Future.succeededFuture(OperationResponse.completedWithJson(buffer));
	}

	// POST //

	@Override
	public void gererPOSTCalculInr(JsonObject document, OperationRequest operationRequete, Handler<AsyncResult<OperationResponse>> gestionnaireEvenements) {
		try {
			RequeteSite requeteSite = genererRequeteSitePourCalculInr(siteContexte);
			Future<OperationResponse> etapesFutures = sqlCalculInr(requeteSite).compose(a -> 
				creerPOSTCalculInr(requeteSite).compose(calculInr -> 
					sqlPOSTCalculInr(calculInr).compose(c -> 
						definirCalculInr(calculInr).compose(d -> 
							attribuerCalculInr(calculInr).compose(e -> 
								indexerCalculInr(calculInr).compose(f -> 
									jsonPOSTCalculInr(calculInr)
								)
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

	public Future<CalculInr> creerPOSTCalculInr(RequeteSite requeteSite) {
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

	public Future<Void> sqlPOSTCalculInr(CalculInr o) {
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

	public Future<OperationResponse> jsonPOSTCalculInr(CalculInr o) {
		Buffer buffer = Buffer.buffer();
		RequeteSite requeteSite = o.getRequeteSite_();
		return Future.succeededFuture(OperationResponse.completedWithJson(buffer));
	}

	// PATCH //

	@Override
	public void gererPATCHCalculInr(JsonObject document, OperationRequest operationRequete, Handler<AsyncResult<OperationResponse>> gestionnaireEvenements) {
		try {
			RequeteSite requeteSite = genererRequeteSitePourCalculInr(siteContexte);
			Future<OperationResponse> etapesFutures = sqlCalculInr(requeteSite).compose(a -> 
				rechercheCalculInr(requeteSite).compose(listeCalculInr-> 
					listePATCHCalculInr(listeCalculInr)
				)
			);
			etapesFutures.setHandler(gestionnaireEvenements);
		} catch(Exception e) {
			gestionnaireEvenements.handle(Future.failedFuture(e));
		}
	}

	public Future<OperationResponse> listePATCHCalculInr(ListeRecherche<CalculInr> listeCalculInr) {
		List<Future> futures = new ArrayList<>();
		listeCalculInr.getList().forEach(o -> {
			futures.add(
				sqlPATCHCalculInr(o).compose(
					b -> indexerCalculInr(o)
				)
			);
		});
		Future<OperationResponse> future = CompositeFuture.all(futures).compose( a -> 
			jsonPATCHCalculInr(listeCalculInr)
		);
		return future;
	}

	public Future<Void> sqlPATCHCalculInr(CalculInr o) {
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
					patchSqlParams.addAll(Arrays.asList("dateInr", requeteJson.getInstant(methodeNom), pk));
					break;
				case "setDateReverifier":
					patchSql.append(SiteContexte.SQL_setP);
					patchSqlParams.addAll(Arrays.asList("dateReverifier", requeteJson.getInstant(methodeNom), pk));
					break;
				case "setPatientPrendCoumadin":
					patchSql.append(SiteContexte.SQL_setP);
					patchSqlParams.addAll(Arrays.asList("patientPrendCoumadin", requeteJson.getString(methodeNom), pk));
					break;
				case "setButActuel":
					patchSql.append(SiteContexte.SQL_setP);
					patchSqlParams.addAll(Arrays.asList("butActuel", requeteJson.getString(methodeNom), pk));
					break;
				case "setDoseActuel":
					patchSql.append(SiteContexte.SQL_setP);
					patchSqlParams.addAll(Arrays.asList("doseActuel", requeteJson.getString(methodeNom), pk));
					break;
				case "setMedicamentActuel":
					patchSql.append(SiteContexte.SQL_setP);
					patchSqlParams.addAll(Arrays.asList("medicamentActuel", requeteJson.getString(methodeNom), pk));
					break;
				case "setChangementDose":
					patchSql.append(SiteContexte.SQL_setP);
					patchSqlParams.addAll(Arrays.asList("changementDose", requeteJson.getString(methodeNom), pk));
					break;
				case "setNotesComplementaires":
					patchSql.append(SiteContexte.SQL_setP);
					patchSqlParams.addAll(Arrays.asList("notesComplementaires", requeteJson.getString(methodeNom), pk));
					break;
				case "setInfoContact":
					patchSql.append(SiteContexte.SQL_setP);
					patchSqlParams.addAll(Arrays.asList("infoContact", requeteJson.getString(methodeNom), pk));
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

	public Future<OperationResponse> jsonPATCHCalculInr(ListeRecherche<CalculInr> listeCalculInr) {
		Buffer buffer = Buffer.buffer();
		return Future.succeededFuture(OperationResponse.completedWithJson(buffer));
	}

	// GET //

	@Override
	public void gererGETCalculInr(OperationRequest operationRequete, Handler<AsyncResult<OperationResponse>> gestionnaireEvenements) {
		try {
			RequeteSite requeteSite = genererRequeteSitePourCalculInr(siteContexte);
			Future<OperationResponse> etapesFutures = rechercheCalculInr(requeteSite).compose(listeCalculInr -> 
				jsonGETCalculInr(listeCalculInr)
			);
			etapesFutures.setHandler(gestionnaireEvenements);
		} catch(Exception e) {
			gestionnaireEvenements.handle(Future.failedFuture(e));
		}
	}

	public Integer genererGetCalculInr(Integer j, ResultatRecherche resultatRecherche, String entiteVarStocke, Collection<Object> champValeurs) throws Exception {
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
				if("patientPrendCoumadin".equals(entiteVarStocke)) {
					if(j > 0)
						reponseServeur.write(", ");
					reponseServeur.write("\"patientPrendCoumadin\": \"");
					reponseServeur.write(Json.encode((String)champValeurs.iterator().next()));
					reponseServeur.write("\"\n");
					j++;
					return j;
				}
				if("butActuel".equals(entiteVarStocke)) {
					if(j > 0)
						reponseServeur.write(", ");
					reponseServeur.write("\"butActuel\": \"");
					reponseServeur.write(Json.encode((String)champValeurs.iterator().next()));
					reponseServeur.write("\"\n");
					j++;
					return j;
				}
				if("doseActuel".equals(entiteVarStocke)) {
					if(j > 0)
						reponseServeur.write(", ");
					reponseServeur.write("\"doseActuel\": \"");
					reponseServeur.write(Json.encode((String)champValeurs.iterator().next()));
					reponseServeur.write("\"\n");
					j++;
					return j;
				}
				if("medicamentActuel".equals(entiteVarStocke)) {
					if(j > 0)
						reponseServeur.write(", ");
					reponseServeur.write("\"medicamentActuel\": \"");
					reponseServeur.write(Json.encode((String)champValeurs.iterator().next()));
					reponseServeur.write("\"\n");
					j++;
					return j;
				}
				if("changementDose".equals(entiteVarStocke)) {
					if(j > 0)
						reponseServeur.write(", ");
					reponseServeur.write("\"changementDose\": \"");
					reponseServeur.write(Json.encode((String)champValeurs.iterator().next()));
					reponseServeur.write("\"\n");
					j++;
					return j;
				}
				if("notesComplementaires".equals(entiteVarStocke)) {
					if(j > 0)
						reponseServeur.write(", ");
					reponseServeur.write("\"notesComplementaires\": \"");
					reponseServeur.write(Json.encode((String)champValeurs.iterator().next()));
					reponseServeur.write("\"\n");
					j++;
					return j;
				}
				if("infoContact".equals(entiteVarStocke)) {
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

	public Future<OperationResponse> jsonGETCalculInr(ListeRecherche<CalculInr> listeCalculInr) {
		Buffer buffer = Buffer.buffer();
		return Future.succeededFuture(OperationResponse.completedWithJson(buffer));
	}

	// PUT //

	@Override
	public void gererPUTCalculInr(JsonObject document, OperationRequest operationRequete, Handler<AsyncResult<OperationResponse>> gestionnaireEvenements) {
		try {
			RequeteSite requeteSite = genererRequeteSitePourCalculInr(siteContexte);
			Future<OperationResponse> etapesFutures = sqlCalculInr(requeteSite).compose(a -> 
				remplacerPUTCalculInr(requeteSite).compose(calculInr -> 
					sqlPUTCalculInr(calculInr).compose(c -> 
						definirCalculInr(calculInr).compose(d -> 
							attribuerCalculInr(calculInr).compose(e -> 
								indexerCalculInr(calculInr).compose(f -> 
									jsonPUTCalculInr(calculInr)
								)
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

	public Future<CalculInr> remplacerPUTCalculInr(RequeteSite requeteSite) {
		Future<CalculInr> future = Future.future();
		SQLConnection connexionSql = requeteSite.getConnexionSql();
		String utilisateurId = requeteSite.getUtilisateurId();

		connexionSql.queryWithParams(
				SiteContexte.SQL_vider
				, new JsonArray(Arrays.asList(pk, CalculInr.class.getCanonicalName(), pk, pk, pk))
				, creerAsync
		-> {
			JsonArray ligne = creerAsync.result().getResults().stream().findFirst().orElseGet(() -> null);
			Long pk = ligne.getLong(0);
			CalculInr o = new CalculInr();
			o.setPk(pk);
			future.complete(o);
		});
		return future;
	}

	public Future<Void> sqlPUTCalculInr(CalculInr o) {
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

	public Future<OperationResponse> jsonPUTCalculInr(CalculInr o) {
		Buffer buffer = Buffer.buffer();
		RequeteSite requeteSite = o.getRequeteSite_();
		return Future.succeededFuture(OperationResponse.completedWithJson(buffer));
	}

	// DELETE //

	@Override
	public void gererDELETECalculInr(OperationRequest operationRequete, Handler<AsyncResult<OperationResponse>> gestionnaireEvenements) {
		try {
			RequeteSite requeteSite = genererRequeteSitePourCalculInr(siteContexte);
			Future<OperationResponse> etapesFutures = sqlCalculInr(requeteSite).compose(a -> 
				rechercheCalculInr(requeteSite).compose(calculInr -> 
					methodeDELETECalculInr(calculInr)
				)
			);
			etapesFutures.setHandler(gestionnaireEvenements);
		} catch(Exception e) {
			gestionnaireEvenements.handle(Future.failedFuture(e));
		}
	}

	public Future<OperationResponse> jsonDELETECalculInr(ListeRecherche<CalculInr> listeCalculInr) {
		Buffer buffer = Buffer.buffer();
		return Future.succeededFuture(OperationResponse.completedWithJson(buffer));
	}

	public Future<OperationResponse> listeRechercheCalculInr(ListeRecherche<CalculInr> listeCalculInr) {
		List<Future> futures = new ArrayList<>();
		listeCalculInr.getList().forEach(o -> {
			futures.add(
				sqlPATCHCalculInr(o).compose(
					b -> indexerCalculInr(o)
				)
			);
		});
		Future<OperationResponse> future = CompositeFuture.all(futures).compose( a -> 
			jsonRechercheCalculInr(listeCalculInr)
		);
		return future;
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

	// Partagé //

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

	public Future<Void> definirCalculInr(CalculInr o) {
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

	public Future<Void> attribuerCalculInr(CalculInr o) {
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

	public Future<Void> indexerCalculInr(CalculInr o) {
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
}
