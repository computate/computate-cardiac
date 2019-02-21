package org.computate.frFR.cardiaque.warfarin;

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
	public void rechercheCalculInr(OperationRequest operationRequete, Handler<AsyncResult<OperationResponse>> gestionnaireEvenements) {
		RequeteSite requeteSite = genererRequeteSitePourCalculInr(siteContexte, operationRequete);
		rechercheCalculInr(requeteSite, a -> {
			if(a.succeeded()) {
				ListeRecherche<CalculInr> listeCalculInr = a.result();
				reponse200RechercheCalculInr(listeCalculInr, b -> {
					if(b.succeeded()) {
						gestionnaireEvenements.handle(Future.succeededFuture(b.result()));
					} else {
						erreurCalculInr(requeteSite, gestionnaireEvenements, b);
					}
				});
			} else {
				erreurCalculInr(requeteSite, gestionnaireEvenements, a);
			}
		});
	}

	public void rechercheCalculInr(RequeteSite requeteSite, Handler<AsyncResult<ListeRecherche<CalculInr>>> gestionnaireEvenements) {
		try {
			OperationRequest operationRequete = requeteSite.getOperationRequete();
			String entiteListeStr = requeteSite.getOperationRequete().getParams().getJsonObject("query").getString("fl");
			String[] entiteListe = entiteListeStr == null ? null : entiteListeStr.split(",\\s*");
			ListeRecherche<CalculInr> listeRecherche = new ListeRecherche<CalculInr>();
			listeRecherche.setQuery("*:*");
			listeRecherche.setC(CalculInr.class);
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
							varIndexe = "*".equals(entiteVar) ? entiteVar : varIndexeCalculInr(entiteVar);
							listeRecherche.setQuery(varIndexe + ":" + ("*".equals(valeurIndexe) ? valeurIndexe : ClientUtils.escapeQueryChars(valeurIndexe)));
							break;
						case "fq":
							entiteVar = StringUtils.trim(StringUtils.substringBefore((String)paramObjet, ":"));
							valeurIndexe = StringUtils.trim(StringUtils.substringAfter((String)paramObjet, ":"));
							varIndexe = varIndexeCalculInr(entiteVar);
							listeRecherche.addFilterQuery(varIndexe + ":" + ClientUtils.escapeQueryChars(valeurIndexe));
							break;
						case "sort":
							entiteVar = StringUtils.trim(StringUtils.substringBefore((String)paramObjet, " "));
							valeurTri = StringUtils.trim(StringUtils.substringAfter((String)paramObjet, " "));
							varIndexe = varIndexeCalculInr(entiteVar);
							listeRecherche.addSort(varIndexe, ORDER.valueOf(valeurTri));
							break;
						case "fl":
							entiteVar = StringUtils.trim((String)paramObjet);
							varIndexe = varIndexeCalculInr(entiteVar);
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
			gestionnaireEvenements.handle(Future.succeededFuture(listeRecherche));
		} catch(Exception e) {
			gestionnaireEvenements.handle(Future.failedFuture(e));
		}
	}

	public void reponse200RechercheCalculInr(ListeRecherche<CalculInr> listeCalculInr, Handler<AsyncResult<OperationResponse>> gestionnaireEvenements) {
		try {
			Buffer buffer = Buffer.buffer();
			RequeteSite requeteSite = listeCalculInr.getRequeteSite_();
			ToutEcrivain w = ToutEcrivain.creer(listeCalculInr.getRequeteSite_(), buffer);
			QueryResponse reponseRecherche = listeCalculInr.getQueryResponse();
			SolrDocumentList documentsSolr = listeCalculInr.getSolrDocumentList();
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

			entiteValeur = Optional.ofNullable(documentSolr.getFieldValues("utilisateurPk_stored_long")).map(Collection<Object>::stream).orElseGet(Stream::empty).findFirst().orElse(null);
			if(entiteValeur != null)
				w.l(entiteNumero++ == 0 ? "" : ", ", "\"utilisateurPk\": ", entiteValeur);

			entiteValeur = Optional.ofNullable(documentSolr.getFieldValues("dateInr_stored_date")).map(Collection<Object>::stream).orElseGet(Stream::empty).findFirst().orElse(null);
			if(entiteValeur != null)
				w.l(entiteNumero++ == 0 ? "" : ", ", "\"dateInr\": ", w.q(entiteValeur));

			entiteValeur = Optional.ofNullable(documentSolr.getFieldValues("dateReverifier_stored_date")).map(Collection<Object>::stream).orElseGet(Stream::empty).findFirst().orElse(null);
			if(entiteValeur != null)
				w.l(entiteNumero++ == 0 ? "" : ", ", "\"dateReverifier\": ", w.q(entiteValeur));

			entiteValeur = Optional.ofNullable(documentSolr.getFieldValues("patientPrendCoumadin_stored_boolean")).map(Collection<Object>::stream).orElseGet(Stream::empty).findFirst().orElse(null);
			if(entiteValeur != null)
				w.l(entiteNumero++ == 0 ? "" : ", ", "\"patientPrendCoumadin\": ", entiteValeur);

			entiteValeur = Optional.ofNullable(documentSolr.getFieldValues("dosageInitial_stored_boolean")).map(Collection<Object>::stream).orElseGet(Stream::empty).findFirst().orElse(null);
			if(entiteValeur != null)
				w.l(entiteNumero++ == 0 ? "" : ", ", "\"dosageInitial\": ", entiteValeur);

			entiteValeur = Optional.ofNullable(documentSolr.getFieldValues("dosageRecommence_stored_boolean")).map(Collection<Object>::stream).orElseGet(Stream::empty).findFirst().orElse(null);
			if(entiteValeur != null)
				w.l(entiteNumero++ == 0 ? "" : ", ", "\"dosageRecommence\": ", entiteValeur);

			entiteValeur = Optional.ofNullable(documentSolr.getFieldValues("butActuel_stored_string")).map(Collection<Object>::stream).orElseGet(Stream::empty).findFirst().orElse(null);
			if(entiteValeur != null)
				w.l(entiteNumero++ == 0 ? "" : ", ", "\"butActuel\": ", w.q(entiteValeur));

			entiteValeur = Optional.ofNullable(documentSolr.getFieldValues("doseActuel_stored_string")).map(Collection<Object>::stream).orElseGet(Stream::empty).findFirst().orElse(null);
			if(entiteValeur != null)
				w.l(entiteNumero++ == 0 ? "" : ", ", "\"doseActuel\": ", w.q(entiteValeur));

			entiteValeur = Optional.ofNullable(documentSolr.getFieldValues("medicamentActuel_stored_string")).map(Collection<Object>::stream).orElseGet(Stream::empty).findFirst().orElse(null);
			if(entiteValeur != null)
				w.l(entiteNumero++ == 0 ? "" : ", ", "\"medicamentActuel\": ", w.q(entiteValeur));

			entiteValeur = Optional.ofNullable(documentSolr.getFieldValues("changementDose_stored_string")).map(Collection<Object>::stream).orElseGet(Stream::empty).findFirst().orElse(null);
			if(entiteValeur != null)
				w.l(entiteNumero++ == 0 ? "" : ", ", "\"changementDose\": ", w.q(entiteValeur));

			entiteValeur = Optional.ofNullable(documentSolr.getFieldValues("notesComplementaires_stored_string")).map(Collection<Object>::stream).orElseGet(Stream::empty).findFirst().orElse(null);
			if(entiteValeur != null)
				w.l(entiteNumero++ == 0 ? "" : ", ", "\"notesComplementaires\": ", w.q(entiteValeur));

			entiteValeur = Optional.ofNullable(documentSolr.getFieldValues("infoContact_stored_string")).map(Collection<Object>::stream).orElseGet(Stream::empty).findFirst().orElse(null);
			if(entiteValeur != null)
				w.l(entiteNumero++ == 0 ? "" : ", ", "\"infoContact\": ", w.q(entiteValeur));

				w.tl(2, "}");
			}
			w.tl(1, "]");
			if(exceptionRecherche != null) {
				w.tl(1, ", \"exceptionRecherche\": ", w.q(exceptionRecherche.getMessage()));
			}
			w.l("}");
			gestionnaireEvenements.handle(Future.succeededFuture(OperationResponse.completedWithJson(buffer)));
		} catch(Exception e) {
			gestionnaireEvenements.handle(Future.failedFuture(e));
		}
	}

	// POST //

	@Override
	public void postCalculInr(JsonObject body, OperationRequest operationRequete, Handler<AsyncResult<OperationResponse>> gestionnaireEvenements) {
		RequeteSite requeteSite = genererRequeteSitePourCalculInr(siteContexte, operationRequete, body);
		sqlCalculInr(requeteSite, a -> {
			if(a.succeeded()) {
				creerPOSTCalculInr(requeteSite, b -> {
					if(b.succeeded()) {
						CalculInr calculInr = b.result();
						sqlPOSTCalculInr(calculInr, c -> {
							if(c.succeeded()) {
								definirCalculInr(calculInr, d -> {
									if(d.succeeded()) {
										attribuerCalculInr(calculInr, e -> {
											if(e.succeeded()) {
												indexerCalculInr(calculInr, f -> {
													if(f.succeeded()) {
														reponse200POSTCalculInr(calculInr, g -> {
															if(f.succeeded()) {
																SQLConnection connexionSql = requeteSite.getConnexionSql();
																connexionSql.commit(h -> {
																	if(a.succeeded()) {
																		connexionSql.close(i -> {
																			if(a.succeeded()) {
																				gestionnaireEvenements.handle(Future.succeededFuture(g.result()));
																			} else {
																				erreurCalculInr(requeteSite, gestionnaireEvenements, i);
																			}
																		});
																	} else {
																		erreurCalculInr(requeteSite, gestionnaireEvenements, h);
																	}
																});
															} else {
																erreurCalculInr(requeteSite, gestionnaireEvenements, g);
															}
														});
													} else {
														erreurCalculInr(requeteSite, gestionnaireEvenements, f);
													}
												});
											} else {
												erreurCalculInr(requeteSite, gestionnaireEvenements, e);
											}
										});
									} else {
										erreurCalculInr(requeteSite, gestionnaireEvenements, d);
									}
								});
							} else {
								erreurCalculInr(requeteSite, gestionnaireEvenements, c);
							}
						});
					} else {
						erreurCalculInr(requeteSite, gestionnaireEvenements, b);
					}
				});
			} else {
				erreurCalculInr(requeteSite, gestionnaireEvenements, a);
			}
		});
	}

	public void creerPOSTCalculInr(RequeteSite requeteSite, Handler<AsyncResult<CalculInr>> gestionnaireEvenements) {
		try {
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
				o.initLoinCalculInr(requeteSite);
				gestionnaireEvenements.handle(Future.succeededFuture(o));
			});
		} catch(Exception e) {
			gestionnaireEvenements.handle(Future.failedFuture(e));
		}
	}

	public void sqlPOSTCalculInr(CalculInr o, Handler<AsyncResult<OperationResponse>> gestionnaireEvenements) {
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
					case "utilisateurPk":
						postSql.append(SiteContexte.SQL_setP);
						postSqlParams.addAll(Arrays.asList("utilisateurPk", jsonObject.getLong(entiteVar), pk));
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
						postSqlParams.addAll(Arrays.asList("patientPrendCoumadin", jsonObject.getBoolean(entiteVar), pk));
						break;
					case "dosageInitial":
						postSql.append(SiteContexte.SQL_setP);
						postSqlParams.addAll(Arrays.asList("dosageInitial", jsonObject.getBoolean(entiteVar), pk));
						break;
					case "dosageRecommence":
						postSql.append(SiteContexte.SQL_setP);
						postSqlParams.addAll(Arrays.asList("dosageRecommence", jsonObject.getBoolean(entiteVar), pk));
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
					case "pageH2":
						postSql.append(SiteContexte.SQL_setP);
						postSqlParams.addAll(Arrays.asList("pageH2", jsonObject.getString(entiteVar), pk));
						break;
					}
				}
			}
			connexionSql.queryWithParams(
					postSql.toString()
					, new JsonArray(postSqlParams)
					, postAsync
			-> {
				gestionnaireEvenements.handle(Future.succeededFuture());
			});
		} catch(Exception e) {
			gestionnaireEvenements.handle(Future.failedFuture(e));
		}
	}

	public void reponse200POSTCalculInr(CalculInr o, Handler<AsyncResult<OperationResponse>> gestionnaireEvenements) {
		try {
			Buffer buffer = Buffer.buffer();
			RequeteSite requeteSite = o.getRequeteSite_();
			ToutEcrivain w = ToutEcrivain.creer(o.getRequeteSite_(), buffer);
			gestionnaireEvenements.handle(Future.succeededFuture(OperationResponse.completedWithJson(buffer)));
		} catch(Exception e) {
			gestionnaireEvenements.handle(Future.failedFuture(e));
		}
	}

	// PATCH //

	@Override
	public void patchCalculInr(JsonObject body, OperationRequest operationRequete, Handler<AsyncResult<OperationResponse>> gestionnaireEvenements) {
		RequeteSite requeteSite = genererRequeteSitePourCalculInr(siteContexte, operationRequete, body);
		sqlCalculInr(requeteSite, a -> {
			if(a.succeeded()) {
				rechercheCalculInr(requeteSite, b -> {
					if(b.succeeded()) {
						ListeRecherche<CalculInr> listeCalculInr = b.result();
						listePATCHCalculInr(listeCalculInr, c -> {
							if(c.succeeded()) {
								SQLConnection connexionSql = requeteSite.getConnexionSql();
								connexionSql.commit(d -> {
									if(a.succeeded()) {
										connexionSql.close(e -> {
											if(a.succeeded()) {
												gestionnaireEvenements.handle(Future.succeededFuture(c.result()));
											} else {
												erreurCalculInr(requeteSite, gestionnaireEvenements, e);
											}
										});
									} else {
										erreurCalculInr(requeteSite, gestionnaireEvenements, d);
									}
								});
							} else {
								erreurCalculInr(requeteSite, gestionnaireEvenements, c);
							}
						});
					} else {
						erreurCalculInr(requeteSite, gestionnaireEvenements, b);
					}
				});
			} else {
				erreurCalculInr(requeteSite, gestionnaireEvenements, a);
			}
		});
	}

	public Future<OperationResponse> listePATCHCalculInr(ListeRecherche<CalculInr> listeCalculInr, Handler<AsyncResult<OperationResponse>> gestionnaireEvenements) {
		return null;
	}

	public void sqlPATCHCalculInr(CalculInr o, Handler<AsyncResult<OperationResponse>> gestionnaireEvenements) {
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
					case "setUtilisateurPk":
						patchSql.append(SiteContexte.SQL_setP);
						patchSqlParams.addAll(Arrays.asList("utilisateurPk", requeteJson.getLong(methodeNom), pk));
						break;
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
						patchSqlParams.addAll(Arrays.asList("patientPrendCoumadin", requeteJson.getBoolean(methodeNom), pk));
						break;
					case "setDosageInitial":
						patchSql.append(SiteContexte.SQL_setP);
						patchSqlParams.addAll(Arrays.asList("dosageInitial", requeteJson.getBoolean(methodeNom), pk));
						break;
					case "setDosageRecommence":
						patchSql.append(SiteContexte.SQL_setP);
						patchSqlParams.addAll(Arrays.asList("dosageRecommence", requeteJson.getBoolean(methodeNom), pk));
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
					case "setPageH2":
						patchSql.append(SiteContexte.SQL_setP);
						patchSqlParams.addAll(Arrays.asList("pageH2", requeteJson.getString(methodeNom), pk));
						break;
				}
			}
			connexionSql.queryWithParams(
					patchSql.toString()
					, new JsonArray(patchSqlParams)
					, patchAsync
			-> {
				gestionnaireEvenements.handle(Future.succeededFuture());
			});
		} catch(Exception e) {
			gestionnaireEvenements.handle(Future.failedFuture(e));
		}
	}

	public void reponse200PATCHCalculInr(ListeRecherche<CalculInr> listeCalculInr, Handler<AsyncResult<OperationResponse>> gestionnaireEvenements) {
		try {
			Buffer buffer = Buffer.buffer();
			ToutEcrivain w = ToutEcrivain.creer(listeCalculInr.getRequeteSite_(), buffer);
			gestionnaireEvenements.handle(Future.succeededFuture(OperationResponse.completedWithJson(buffer)));
		} catch(Exception e) {
			gestionnaireEvenements.handle(Future.failedFuture(e));
		}
	}

	// GET //

	@Override
	public void getCalculInr(OperationRequest operationRequete, Handler<AsyncResult<OperationResponse>> gestionnaireEvenements) {
		RequeteSite requeteSite = genererRequeteSitePourCalculInr(siteContexte, operationRequete);
		rechercheCalculInr(requeteSite, a -> {
			if(a.succeeded()) {
				ListeRecherche<CalculInr> listeCalculInr = a.result();
				reponse200GETCalculInr(listeCalculInr, b -> {
					if(b.succeeded()) {
						gestionnaireEvenements.handle(Future.succeededFuture(b.result()));
					} else {
						erreurCalculInr(requeteSite, gestionnaireEvenements, b);
					}
				});
			} else {
				erreurCalculInr(requeteSite, gestionnaireEvenements, a);
			}
		});
	}

	public void reponse200GETCalculInr(ListeRecherche<CalculInr> listeCalculInr, Handler<AsyncResult<OperationResponse>> gestionnaireEvenements) {
		try {
			Buffer buffer = Buffer.buffer();
			ToutEcrivain w = ToutEcrivain.creer(listeCalculInr.getRequeteSite_(), buffer);
			SolrDocumentList documentsSolr = listeCalculInr.getSolrDocumentList();

			if(documentsSolr.size() > 0) {
				SolrDocument documentSolr = documentsSolr.get(0);
				Object entiteValeur;
				Integer entiteNumero = 0;

				w.l("{");

			entiteValeur = Optional.ofNullable(documentSolr.getFieldValues("utilisateurPk_stored_long")).map(Collection<Object>::stream).orElseGet(Stream::empty).findFirst().orElse(null);
			if(entiteValeur != null)
				w.l(entiteNumero++ == 0 ? "" : ", ", "\"utilisateurPk\": ", entiteValeur);

			entiteValeur = Optional.ofNullable(documentSolr.getFieldValues("dateInr_stored_date")).map(Collection<Object>::stream).orElseGet(Stream::empty).findFirst().orElse(null);
			if(entiteValeur != null)
				w.l(entiteNumero++ == 0 ? "" : ", ", "\"dateInr\": ", w.q(entiteValeur));

			entiteValeur = Optional.ofNullable(documentSolr.getFieldValues("dateReverifier_stored_date")).map(Collection<Object>::stream).orElseGet(Stream::empty).findFirst().orElse(null);
			if(entiteValeur != null)
				w.l(entiteNumero++ == 0 ? "" : ", ", "\"dateReverifier\": ", w.q(entiteValeur));

			entiteValeur = Optional.ofNullable(documentSolr.getFieldValues("patientPrendCoumadin_stored_boolean")).map(Collection<Object>::stream).orElseGet(Stream::empty).findFirst().orElse(null);
			if(entiteValeur != null)
				w.l(entiteNumero++ == 0 ? "" : ", ", "\"patientPrendCoumadin\": ", entiteValeur);

			entiteValeur = Optional.ofNullable(documentSolr.getFieldValues("dosageInitial_stored_boolean")).map(Collection<Object>::stream).orElseGet(Stream::empty).findFirst().orElse(null);
			if(entiteValeur != null)
				w.l(entiteNumero++ == 0 ? "" : ", ", "\"dosageInitial\": ", entiteValeur);

			entiteValeur = Optional.ofNullable(documentSolr.getFieldValues("dosageRecommence_stored_boolean")).map(Collection<Object>::stream).orElseGet(Stream::empty).findFirst().orElse(null);
			if(entiteValeur != null)
				w.l(entiteNumero++ == 0 ? "" : ", ", "\"dosageRecommence\": ", entiteValeur);

			entiteValeur = Optional.ofNullable(documentSolr.getFieldValues("butActuel_stored_string")).map(Collection<Object>::stream).orElseGet(Stream::empty).findFirst().orElse(null);
			if(entiteValeur != null)
				w.l(entiteNumero++ == 0 ? "" : ", ", "\"butActuel\": ", w.q(entiteValeur));

			entiteValeur = Optional.ofNullable(documentSolr.getFieldValues("doseActuel_stored_string")).map(Collection<Object>::stream).orElseGet(Stream::empty).findFirst().orElse(null);
			if(entiteValeur != null)
				w.l(entiteNumero++ == 0 ? "" : ", ", "\"doseActuel\": ", w.q(entiteValeur));

			entiteValeur = Optional.ofNullable(documentSolr.getFieldValues("medicamentActuel_stored_string")).map(Collection<Object>::stream).orElseGet(Stream::empty).findFirst().orElse(null);
			if(entiteValeur != null)
				w.l(entiteNumero++ == 0 ? "" : ", ", "\"medicamentActuel\": ", w.q(entiteValeur));

			entiteValeur = Optional.ofNullable(documentSolr.getFieldValues("changementDose_stored_string")).map(Collection<Object>::stream).orElseGet(Stream::empty).findFirst().orElse(null);
			if(entiteValeur != null)
				w.l(entiteNumero++ == 0 ? "" : ", ", "\"changementDose\": ", w.q(entiteValeur));

			entiteValeur = Optional.ofNullable(documentSolr.getFieldValues("notesComplementaires_stored_string")).map(Collection<Object>::stream).orElseGet(Stream::empty).findFirst().orElse(null);
			if(entiteValeur != null)
				w.l(entiteNumero++ == 0 ? "" : ", ", "\"notesComplementaires\": ", w.q(entiteValeur));

			entiteValeur = Optional.ofNullable(documentSolr.getFieldValues("infoContact_stored_string")).map(Collection<Object>::stream).orElseGet(Stream::empty).findFirst().orElse(null);
			if(entiteValeur != null)
				w.l(entiteNumero++ == 0 ? "" : ", ", "\"infoContact\": ", w.q(entiteValeur));

				w.l("}");
			}
			gestionnaireEvenements.handle(Future.succeededFuture(OperationResponse.completedWithJson(buffer)));
		} catch(Exception e) {
			gestionnaireEvenements.handle(Future.failedFuture(e));
		}
	}

	// PUT //

	@Override
	public void putCalculInr(JsonObject body, OperationRequest operationRequete, Handler<AsyncResult<OperationResponse>> gestionnaireEvenements) {
		RequeteSite requeteSite = genererRequeteSitePourCalculInr(siteContexte, operationRequete, body);
		sqlCalculInr(requeteSite, a -> {
			if(a.succeeded()) {
				remplacerPUTCalculInr(requeteSite, b -> {
					if(b.succeeded()) {
						CalculInr calculInr = b.result();
						sqlPUTCalculInr(calculInr, c -> {
							if(c.succeeded()) {
								definirCalculInr(calculInr, d -> {
									if(d.succeeded()) {
										attribuerCalculInr(calculInr, e -> {
											if(e.succeeded()) {
												indexerCalculInr(calculInr, f -> {
													if(f.succeeded()) {
														reponse200PUTCalculInr(calculInr, g -> {
															if(g.succeeded()) {
																SQLConnection connexionSql = requeteSite.getConnexionSql();
																connexionSql.commit(h -> {
																	if(a.succeeded()) {
																		connexionSql.close(i -> {
																			if(a.succeeded()) {
																				gestionnaireEvenements.handle(Future.succeededFuture(g.result()));
																			} else {
																				erreurCalculInr(requeteSite, gestionnaireEvenements, i);
																			}
																		});
																	} else {
																		erreurCalculInr(requeteSite, gestionnaireEvenements, h);
																	}
																});
															} else {
																erreurCalculInr(requeteSite, gestionnaireEvenements, g);
															}
														});
													} else {
														erreurCalculInr(requeteSite, gestionnaireEvenements, f);
													}
												});
											} else {
												erreurCalculInr(requeteSite, gestionnaireEvenements, e);
											}
										});
									} else {
										erreurCalculInr(requeteSite, gestionnaireEvenements, d);
									}
								});
							} else {
								erreurCalculInr(requeteSite, gestionnaireEvenements, c);
							}
						});
					} else {
						erreurCalculInr(requeteSite, gestionnaireEvenements, b);
					}
				});
			} else {
				erreurCalculInr(requeteSite, gestionnaireEvenements, a);
			}
		});
	}

	public void remplacerPUTCalculInr(RequeteSite requeteSite, Handler<AsyncResult<CalculInr>> gestionnaireEvenements) {
		try {
			SQLConnection connexionSql = requeteSite.getConnexionSql();
			String utilisateurId = requeteSite.getUtilisateurId();
			Long pk = requeteSite.getRequetePk();

			connexionSql.queryWithParams(
					SiteContexte.SQL_vider
					, new JsonArray(Arrays.asList(pk, CalculInr.class.getCanonicalName(), pk, pk, pk))
					, remplacerAsync
			-> {
				CalculInr o = new CalculInr();
				o.setPk(pk);
				gestionnaireEvenements.handle(Future.succeededFuture(o));
			});
		} catch(Exception e) {
			gestionnaireEvenements.handle(Future.failedFuture(e));
		}
	}

	public void sqlPUTCalculInr(CalculInr o, Handler<AsyncResult<OperationResponse>> gestionnaireEvenements) {
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
					case "utilisateurPk":
						postSql.append(SiteContexte.SQL_setP);
						postSqlParams.addAll(Arrays.asList("utilisateurPk", jsonObject.getLong(entiteVar), pk));
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
						postSqlParams.addAll(Arrays.asList("patientPrendCoumadin", jsonObject.getBoolean(entiteVar), pk));
						break;
					case "dosageInitial":
						postSql.append(SiteContexte.SQL_setP);
						postSqlParams.addAll(Arrays.asList("dosageInitial", jsonObject.getBoolean(entiteVar), pk));
						break;
					case "dosageRecommence":
						postSql.append(SiteContexte.SQL_setP);
						postSqlParams.addAll(Arrays.asList("dosageRecommence", jsonObject.getBoolean(entiteVar), pk));
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
					case "pageH2":
						postSql.append(SiteContexte.SQL_setP);
						postSqlParams.addAll(Arrays.asList("pageH2", jsonObject.getString(entiteVar), pk));
						break;
					}
				}
			}
			connexionSql.queryWithParams(
					postSql.toString()
					, new JsonArray(postSqlParams)
					, postAsync
			-> {
				gestionnaireEvenements.handle(Future.succeededFuture());
			});
		} catch(Exception e) {
			gestionnaireEvenements.handle(Future.failedFuture(e));
		}
	}

	public void reponse200PUTCalculInr(CalculInr o, Handler<AsyncResult<OperationResponse>> gestionnaireEvenements) {
		try {
			Buffer buffer = Buffer.buffer();
			RequeteSite requeteSite = o.getRequeteSite_();
			ToutEcrivain w = ToutEcrivain.creer(o.getRequeteSite_(), buffer);
			gestionnaireEvenements.handle(Future.succeededFuture(OperationResponse.completedWithJson(buffer)));
		} catch(Exception e) {
			gestionnaireEvenements.handle(Future.failedFuture(e));
		}
	}

	// DELETE //

	@Override
	public void deleteCalculInr(OperationRequest operationRequete, Handler<AsyncResult<OperationResponse>> gestionnaireEvenements) {
		RequeteSite requeteSite = genererRequeteSitePourCalculInr(siteContexte, operationRequete);
		sqlCalculInr(requeteSite, a -> {
			if(a.succeeded()) {
				rechercheCalculInr(requeteSite, b -> {
					if(b.succeeded()) {
						ListeRecherche<CalculInr> listeCalculInr = b.result();
						supprimerDELETECalculInr(requeteSite, c -> {
							if(c.succeeded()) {
								reponse200DELETECalculInr(requeteSite, d -> {
									if(d.succeeded()) {
										SQLConnection connexionSql = requeteSite.getConnexionSql();
										connexionSql.commit(e -> {
											if(a.succeeded()) {
												connexionSql.close(f -> {
													if(a.succeeded()) {
														gestionnaireEvenements.handle(Future.succeededFuture(d.result()));
													} else {
														erreurCalculInr(requeteSite, gestionnaireEvenements, f);
													}
												});
											} else {
												erreurCalculInr(requeteSite, gestionnaireEvenements, e);
											}
										});
									} else {
										erreurCalculInr(requeteSite, gestionnaireEvenements, d);
									}
								});
							} else {
								erreurCalculInr(requeteSite, gestionnaireEvenements, c);
							}
						});
					} else {
						erreurCalculInr(requeteSite, gestionnaireEvenements, b);
					}
				});
			} else {
				erreurCalculInr(requeteSite, gestionnaireEvenements, a);
			}
		});
	}

	public void supprimerDELETECalculInr(RequeteSite requeteSite, Handler<AsyncResult<OperationResponse>> gestionnaireEvenements) {
		try {
			SQLConnection connexionSql = requeteSite.getConnexionSql();
			String utilisateurId = requeteSite.getUtilisateurId();
			Long pk = requeteSite.getRequetePk();

			connexionSql.queryWithParams(
					SiteContexte.SQL_supprimer
					, new JsonArray(Arrays.asList(pk, CalculInr.class.getCanonicalName(), pk, pk, pk, pk))
					, supprimerAsync
			-> {
				gestionnaireEvenements.handle(Future.succeededFuture());
			});
		} catch(Exception e) {
			gestionnaireEvenements.handle(Future.failedFuture(e));
		}
	}

	public void reponse200DELETECalculInr(RequeteSite requeteSite, Handler<AsyncResult<OperationResponse>> gestionnaireEvenements) {
		try {
			Buffer buffer = Buffer.buffer();
			ToutEcrivain w = ToutEcrivain.creer(requeteSite, buffer);
			gestionnaireEvenements.handle(Future.succeededFuture(OperationResponse.completedWithJson(buffer)));
		} catch(Exception e) {
			gestionnaireEvenements.handle(Future.failedFuture(e));
		}
	}

	// RecherchePage //

	@Override
	public void recherchepageCalculInr(OperationRequest operationRequete, Handler<AsyncResult<OperationResponse>> gestionnaireEvenements) {
		RequeteSite requeteSite = genererRequeteSitePourCalculInr(siteContexte, operationRequete);
		recherchepageCalculInr(requeteSite, a -> {
			if(a.succeeded()) {
				ListeRecherche<CalculInr> listeCalculInr = a.result();
				reponse200RecherchePageCalculInr(listeCalculInr, b -> {
					if(b.succeeded()) {
						gestionnaireEvenements.handle(Future.succeededFuture(b.result()));
					} else {
						erreurCalculInr(requeteSite, gestionnaireEvenements, b);
					}
				});
			} else {
				erreurCalculInr(requeteSite, gestionnaireEvenements, a);
			}
		});
	}

	public void recherchepageCalculInr(RequeteSite requeteSite, Handler<AsyncResult<ListeRecherche<CalculInr>>> gestionnaireEvenements) {
		try {
			OperationRequest operationRequete = requeteSite.getOperationRequete();
			String entiteListeStr = requeteSite.getOperationRequete().getParams().getJsonObject("query").getString("fl");
			String[] entiteListe = entiteListeStr == null ? null : entiteListeStr.split(",\\s*");
			ListeRecherche<CalculInr> listeRecherche = new ListeRecherche<CalculInr>();
			listeRecherche.setQuery("*:*");
			listeRecherche.setC(CalculInr.class);
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
							varIndexe = "*".equals(entiteVar) ? entiteVar : varIndexeCalculInr(entiteVar);
							listeRecherche.setQuery(varIndexe + ":" + ("*".equals(valeurIndexe) ? valeurIndexe : ClientUtils.escapeQueryChars(valeurIndexe)));
							break;
						case "fq":
							entiteVar = StringUtils.trim(StringUtils.substringBefore((String)paramObjet, ":"));
							valeurIndexe = StringUtils.trim(StringUtils.substringAfter((String)paramObjet, ":"));
							varIndexe = varIndexeCalculInr(entiteVar);
							listeRecherche.addFilterQuery(varIndexe + ":" + ClientUtils.escapeQueryChars(valeurIndexe));
							break;
						case "sort":
							entiteVar = StringUtils.trim(StringUtils.substringBefore((String)paramObjet, " "));
							valeurTri = StringUtils.trim(StringUtils.substringAfter((String)paramObjet, " "));
							varIndexe = varIndexeCalculInr(entiteVar);
							listeRecherche.addSort(varIndexe, ORDER.valueOf(valeurTri));
							break;
						case "fl":
							entiteVar = StringUtils.trim((String)paramObjet);
							varIndexe = varIndexeCalculInr(entiteVar);
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
			gestionnaireEvenements.handle(Future.succeededFuture(listeRecherche));
		} catch(Exception e) {
			gestionnaireEvenements.handle(Future.failedFuture(e));
		}
	}

	public void reponse200RecherchePageCalculInr(ListeRecherche<CalculInr> listeCalculInr, Handler<AsyncResult<OperationResponse>> gestionnaireEvenements) {
		try {
			Buffer buffer = Buffer.buffer();
			RequeteSite requeteSite = listeCalculInr.getRequeteSite_();
			ToutEcrivain w = ToutEcrivain.creer(listeCalculInr.getRequeteSite_(), buffer);
			CalculInrPage page = new CalculInrPage();
			page.setPageUrl("/api/v1/warfarin/calcul-inr");
			SolrDocument pageDocumentSolr = new SolrDocument();

			pageDocumentSolr.setField("pageUri_frFR_stored_string", "/calcul-inr");
			page.setPageDocumentSolr(pageDocumentSolr);
			page.setW(w);
			page.setListeCalculInr(listeCalculInr);
			page.initLoinCalculInrPage(requeteSite);
			page.html();
			gestionnaireEvenements.handle(Future.succeededFuture(new OperationResponse(200, "OK", buffer, new CaseInsensitiveHeaders())));
		} catch(Exception e) {
			gestionnaireEvenements.handle(Future.failedFuture(e));
		}
	}

	public String varIndexeCalculInr(String entiteVar) {
		switch(entiteVar) {
			case "utilisateurPk":
				return "utilisateurPk_indexed_long";
			case "dateInr":
				return "dateInr_indexed_date";
			case "dateReverifier":
				return "dateReverifier_indexed_date";
			case "patientPrendCoumadin":
				return "patientPrendCoumadin_indexed_boolean";
			case "dosageInitial":
				return "dosageInitial_indexed_boolean";
			case "dosageRecommence":
				return "dosageRecommence_indexed_boolean";
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
				throw new RuntimeException(String.format("\"%s\" n'est pas une entité indexé. ", entiteVar));
		}
	}

	// Partagé //

	public void erreurCalculInr(RequeteSite requeteSite, Handler<AsyncResult<OperationResponse>> gestionnaireEvenements, AsyncResult<?> resultatAsync) {
		Throwable e = resultatAsync.cause();
		ExceptionUtils.printRootCauseStackTrace(e);
		OperationResponse reponseOperation = new OperationResponse(400, "BAD REQUEST", 
			Buffer.buffer().appendString(
				new JsonObject() {{
					put("erreur", new JsonObject() {{
					put("message", e.getMessage());
					}});
				}}.encodePrettily()
			)
			, new CaseInsensitiveHeaders()
		);
		SQLConnection connexionSql = requeteSite.getConnexionSql();
		if(connexionSql != null) {
			connexionSql.rollback(a -> {
				if(a.succeeded()) {
					connexionSql.close(b -> {
						if(a.succeeded()) {
							gestionnaireEvenements.handle(Future.succeededFuture(reponseOperation));
						} else {
							gestionnaireEvenements.handle(Future.succeededFuture(reponseOperation));
						}
					});
				} else {
					gestionnaireEvenements.handle(Future.succeededFuture(reponseOperation));
				}
			});
		} else {
			gestionnaireEvenements.handle(Future.succeededFuture(reponseOperation));
		}
	}

	public void sqlCalculInr(RequeteSite requeteSite, Handler<AsyncResult<OperationResponse>> gestionnaireEvenements) {
		try {
			SQLClient clientSql = requeteSite.getSiteContexte_().getClientSql();

			clientSql.getConnection(sqlAsync -> {
				if(sqlAsync.succeeded()) {
					SQLConnection connexionSql = sqlAsync.result();
					connexionSql.setAutoCommit(false, a -> {
						if(a.succeeded()) {
							requeteSite.setConnexionSql(connexionSql);
							gestionnaireEvenements.handle(Future.succeededFuture());
						} else {
							gestionnaireEvenements.handle(Future.failedFuture(a.cause()));
						}
					});
				} else {
					gestionnaireEvenements.handle(Future.failedFuture(sqlAsync.cause()));
				}
			});
		} catch(Exception e) {
			gestionnaireEvenements.handle(Future.failedFuture(e));
		}
	}

	public RequeteSite genererRequeteSitePourCalculInr(SiteContexte siteContexte, OperationRequest operationRequete) {
		return genererRequeteSitePourCalculInr(siteContexte, operationRequete, null);
	}

	public RequeteSite genererRequeteSitePourCalculInr(SiteContexte siteContexte, OperationRequest operationRequete, JsonObject body) {
		Vertx vertx = siteContexte.getVertx();
		RequeteSite requeteSite = new RequeteSite();
		requeteSite.setObjetJson(body);
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

	public void definirCalculInr(CalculInr o, Handler<AsyncResult<OperationResponse>> gestionnaireEvenements) {
		try {
			RequeteSite requeteSite = o.getRequeteSite_();
			SQLConnection connexionSql = requeteSite.getConnexionSql();
			Long pk = o.getPk();
			connexionSql.queryWithParams(
					SiteContexte.SQL_definir
					, new JsonArray(Arrays.asList(pk))
					, definirAsync
			-> {
				if(definirAsync.succeeded()) {
					for(JsonArray definition : definirAsync.result().getResults()) {
						o.definirPourClasse(definition.getString(0), definition.getString(1));
					}
					gestionnaireEvenements.handle(Future.succeededFuture());
				} else {
					gestionnaireEvenements.handle(Future.failedFuture(definirAsync.cause()));
				}
			});
		} catch(Exception e) {
			gestionnaireEvenements.handle(Future.failedFuture(e));
		}
	}

	public void attribuerCalculInr(CalculInr o, Handler<AsyncResult<OperationResponse>> gestionnaireEvenements) {
		try {
			RequeteSite requeteSite = o.getRequeteSite_();
			SQLConnection connexionSql = requeteSite.getConnexionSql();
			Long pk = o.getPk();
			connexionSql.queryWithParams(
					SiteContexte.SQL_attribuer
					, new JsonArray(Arrays.asList(pk, pk))
					, attribuerAsync
			-> {
				if(attribuerAsync.succeeded()) {
					if(attribuerAsync.result() != null) {
						for(JsonArray definition : attribuerAsync.result().getResults()) {
							o.attribuerPourClasse(definition.getString(0), definition.getString(1));
						}
					}
					gestionnaireEvenements.handle(Future.succeededFuture());
				} else {
					gestionnaireEvenements.handle(Future.failedFuture(attribuerAsync.cause()));
				}
			});
		} catch(Exception e) {
			gestionnaireEvenements.handle(Future.failedFuture(e));
		}
	}

	public void indexerCalculInr(CalculInr o, Handler<AsyncResult<OperationResponse>> gestionnaireEvenements) {
		RequeteSite requeteSite = o.getRequeteSite_();
		try {
			o.initLoinPourClasse(requeteSite);
			o.indexerPourClasse();
			gestionnaireEvenements.handle(Future.succeededFuture());
		} catch(Exception e) {
			gestionnaireEvenements.handle(Future.failedFuture(e));
		}
	}
}
