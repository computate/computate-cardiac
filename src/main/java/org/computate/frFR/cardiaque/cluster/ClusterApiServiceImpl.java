package org.computate.frFR.cardiaque.cluster;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrQuery.ORDER;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.computate.frFR.cardiaque.contexte.SiteContexte;
import org.computate.frFR.cardiaque.requete.RequeteSite;
import org.computate.frFR.cardiaque.utilisateur.UtilisateurSite;

import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.MultiMap;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.ext.sql.SQLClient;
import io.vertx.ext.sql.SQLConnection;
import io.vertx.ext.web.RoutingContext;

public class ClusterApiServiceImpl implements ClusterApiService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ClusterApiServiceImpl.class);

	public static final String SERVICE_ADDRESS = "";

	protected SiteContexte siteContexte;

	public ClusterApiServiceImpl(SiteContexte siteContexte) {
		this.siteContexte = siteContexte;
		// Register on the service side. If using a local event bus, this is all
		// that's required, since the proxy side will share the same Vertx instance.
		ClusterApiService service = ClusterApiService.createProxy(siteContexte.getVertx(), SERVICE_ADDRESS);
//		 vertx.eventBus().registerDefaultCodec(ShoeSizeException.class,
//		 new ShoeSizeExceptionMessageCodec());
	}

	public RequeteSite genererRequeteSitePourCluster(SiteContexte siteContexte, RoutingContext contexteItineraire) throws Exception {
		RequeteSite requeteSite = new RequeteSite();
		requeteSite.initLoinRequeteSite();
		SiteContexte siteContexte = new SiteContexte();
		siteContexte.initLoinSiteContexte();
		siteContexte.setRequeteSite_(requeteSite);
		requeteSite.setSiteContexte_(siteContexte);
		requeteSiteCluster(requeteSite);
		initLoinCluster(requeteSite);
		indexerCluster();


		Vertx vertx = siteContexte.getVertx();

		RequeteSite requeteSite = new RequeteSite();
		requeteSite.setVertx(vertx);
		requeteSite.setContexteItineraire(contexteItineraire);
		requeteSite.setSiteContexte_(siteContexte);
		requeteSite.initLoinRequeteSite(requeteSite);

		UtilisateurSite utilisateurSite = new UtilisateurSite();
		utilisateurSite.initLoinUtilisateurSite(requeteSite);
		requeteSite.setUtilisateurSite(utilisateurSite);
		utilisateurSite.setRequeteSite_(requeteSite);
		return requeteSite;
	}

	@Override
	public void patchCluster(JsonObject document, Handler<AsyncResult<List<Cluster>>> resultHandler) {
		RequeteSite requeteSite = genererRequeteSitePourCluster(siteContexte, contexteItineraire);
			Future<List<Cluster>> etapesFutures = sqlCluster(requeteSite).compose(
				a -> creerCluster(requeteSite).compose(
					b -> patchCluster().compose(
						c -> definirCluster(creerCluster.result()).compose(
							d -> attribuerCluster(creerCluster.result()).compose(
								e -> indexerCluster(creerCluster.result()).compose(
									f -> htmCluster(creerCluster.result()).compose(
									)
								)
							)
						)
					)
				)
			);
			etapesFutures.setHandler(resultHandler);
//			resultHandler.handle(etapesFutures);

	}

	@Override
	public void postCluster(JsonObject document, Handler<AsyncResult<Cluster>> resultHandler) {
		SiteContexte siteContexte = new SiteContexte();
		try {
			RequeteSite requeteSite = genererRequeteSitePourCluster(siteContexte, contexteItineraire);
			HttpServerResponse reponseServeur = requeteSite.getReponseServeur();
			QueryResponse reponseRecherche = requeteSite.getReponseRecherche();
			JsonObject requeteJson = contexteItineraire.getBodyAsJson();
			SQLClient clientSql = requeteSite.getSiteContexte_().getClientSql();
			Future<Cluster> etapesFutures = sqlCluster(requeteSite).compose(
				a -> creerCluster(requeteSite).compose(
					b -> patchCluster(creerCluster.result()).compose(
						c -> definirCluster(creerCluster.result()).compose(
							d -> attribuerCluster(creerCluster.result()).compose(
								e -> indexerCluster(creerCluster.result()).compose(
									f -> htmCluster(creerCluster.result()).compose(
									)
								)
							)
						)
					)
				)
			);
			etapesFutures.setHandler(resultHandler);
			resultHandler.handle(Future.succeededFuture());

			contexteItineraire.response().putHeader("content-type", "application/json").setChunked(true);

			requeteSite.getReponseServeur().end();


			reponseServeur.write("\t]\n");
			reponseServeur.write("}\n");
		} catch(Exception e) {
			LOGGER.error("Error: ", e.getMessage());
			contexteItineraire.fail(e);
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

	public Future<Void> patchCluster(RequeteSite requeteSite) {
		Future<Void> future = Future.future();
		SQLConnection connexionSql = requeteSite.getConnexionSql();
		RoutingContext contexteItineraire = requeteSite.getContexteItineraire();
		JsonObject requeteJson = contexteItineraire.getBodyAsJson();
		StringBuilder patchSql = new StringBuilder();
		List<Object> patchSqlParams = new ArrayList<Object>();
		Set<String> methodeNoms = requeteJson.fieldNames();

		for(String methodeNom : methodeNoms) {
			switch(methodeNom) {
//				case "setPk":
//					patchSql.append(SiteContexte.SQL_setP);
//					patchSqlParams.addAll(Arrays.asList(ENTITE_VAR_pk, requeteJson.getLong(methodeNom), pk));
//					break;
//				case "setId":
//					patchSql.append(SiteContexte.SQL_setP);
//					patchSqlParams.addAll(Arrays.asList(ENTITE_VAR_id, requeteJson.getString(methodeNom), pk));
//					break;
//				case "setCree":
//					patchSql.append(SiteContexte.SQL_setP);
//					patchSqlParams.addAll(Arrays.asList(ENTITE_VAR_cree, requeteJson.getInstant(methodeNom), pk));
//					break;
//				case "setModifie":
//					patchSql.append(SiteContexte.SQL_setP);
//					patchSqlParams.addAll(Arrays.asList(ENTITE_VAR_modifie, requeteJson.getInstant(methodeNom), pk));
//					break;
//				case "setUtilisateurId":
//					patchSql.append(SiteContexte.SQL_setP);
//					patchSqlParams.addAll(Arrays.asList(ENTITE_VAR_utilisateurId, requeteJson.getString(methodeNom), pk));
//					break;
//				case "setClusterNomCanonique":
//					patchSql.append(SiteContexte.SQL_setP);
//					patchSqlParams.addAll(Arrays.asList(ENTITE_VAR_clusterNomCanonique, requeteJson.getString(methodeNom), pk));
//					break;
//				case "setClusterNomSimple":
//					patchSql.append(SiteContexte.SQL_setP);
//					patchSqlParams.addAll(Arrays.asList(ENTITE_VAR_clusterNomSimple, requeteJson.getString(methodeNom), pk));
//					break;
//				case "setSupprime":
//					patchSql.append(SiteContexte.SQL_setP);
//					patchSqlParams.addAll(Arrays.asList(ENTITE_VAR_supprime, requeteJson.getBoolean(methodeNom), pk));
//					break;
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

	public Future<Void> htmCluster(Cluster o) {
		Future<Void> future = Future.future();
		RequeteSite requeteSite = o.getRequeteSite_();
		future.complete();
		return future;
	}

	public SolrQuery genererRechercheCluster(RequeteSite requeteSite, HttpServerRequest requeteServeur) throws Exception {
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
//					case "q":
//						entiteVar = StringUtils.trim(StringUtils.substringBefore(paramValeur, ":"));
//						valeurIndexe = StringUtils.trim(StringUtils.substringAfter(paramValeur, ":"));
//						varIndexe = varIndexeCluster(paramCle);
//						rechercheSolr.setQuery(varIndexe + ":" + ClientUtils.escapeQueryChars(valeurIndexe));
//						break;
//					case "fq":
//						entiteVar = StringUtils.trim(StringUtils.substringBefore(paramValeur, ":"));
//						valeurIndexe = StringUtils.trim(StringUtils.substringAfter(paramValeur, ":"));
//						varIndexe = varIndexeCluster(paramCle);
//						rechercheSolr.addFilterQuery(varIndexe + ":" + ClientUtils.escapeQueryChars(valeurIndexe));
//						break;
//					case "sort":
//						entiteVar = StringUtils.trim(StringUtils.substringBefore(paramValeur, " "));
//						valeurTri = StringUtils.trim(StringUtils.substringAfter(paramValeur, " "));
//						varIndexe = varIndexeCluster(paramCle);
//						rechercheSolr.addSort(varIndexe, ORDER.valueOf(valeurTri));
//						break;
//					case "fl":
//						entiteVar = StringUtils.trim(paramValeur);
//						varIndexe = varIndexeCluster(paramCle);
//						rechercheSolr.addField(varIndexe);
//						break;
//					case "start":
//						rechercheDebut = Integer.parseInt(paramValeur);
//						rechercheSolr.setStart(rechercheDebut);
//						break;
//					case "rows":
//						rechercheNum = Integer.parseInt(paramValeur);
//						rechercheSolr.setRows(rechercheNum);
//						break;
				}
			}
		}
		requeteSite.setRechercheSolr(rechercheSolr);
		return rechercheSolr;
	}
}
