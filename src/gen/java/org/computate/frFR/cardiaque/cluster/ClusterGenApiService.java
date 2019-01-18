package org.computate.frFR.cardiaque.cluster;

import org.computate.frFR.cardiaque.contexte.SiteContexte;
import io.vertx.codegen.annotations.ProxyGen;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.api.OperationRequest;
import io.vertx.ext.web.api.OperationResponse;

@ProxyGen
public interface ClusterGenApiService {
	// Une méthode d'usine pour créer une instance et un proxy. 
	static ClusterGenApiService creer(SiteContexte siteContexte, Vertx vertx) {
		return new ClusterApiServiceImpl(siteContexte);
	}

	// Une méthode d'usine pour créer une instance et un proxy. 
	static ClusterGenApiService creerProxy(Vertx vertx, String addresse) {
		return new ClusterGenApiServiceVertxEBProxy(vertx, addresse);
	}

	public void gererRechercheCluster(OperationRequest operationRequete, Handler<AsyncResult<OperationResponse>> gestionnaireEvenements);
	public void gererPOSTCluster(JsonObject document, OperationRequest operationRequete, Handler<AsyncResult<OperationResponse>> gestionnaireEvenements);
	public void gererPATCHCluster(JsonObject document, OperationRequest operationRequete, Handler<AsyncResult<OperationResponse>> gestionnaireEvenements);
	public void gererGETCluster(OperationRequest operationRequete, Handler<AsyncResult<OperationResponse>> gestionnaireEvenements);
	public void gererPUTCluster(JsonObject document, OperationRequest operationRequete, Handler<AsyncResult<OperationResponse>> gestionnaireEvenements);
	public void gererDELETECluster(OperationRequest operationRequete, Handler<AsyncResult<OperationResponse>> gestionnaireEvenements);
}
