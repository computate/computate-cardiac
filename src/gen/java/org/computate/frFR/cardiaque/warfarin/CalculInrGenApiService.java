package org.computate.frFR.cardiaque.warfarin;

import org.computate.frFR.cardiaque.contexte.SiteContexte;
import io.vertx.codegen.annotations.ProxyGen;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.api.OperationRequest;
import io.vertx.ext.web.api.OperationResponse;

@ProxyGen
public interface CalculInrGenApiService {
	// Une méthode d'usine pour créer une instance et un proxy. 
	static CalculInrGenApiService creer(SiteContexte siteContexte, Vertx vertx) {
		return new CalculInrApiServiceImpl(siteContexte);
	}

	// Une méthode d'usine pour créer une instance et un proxy. 
	static CalculInrGenApiService creerProxy(Vertx vertx, String addresse) {
		return new CalculInrGenApiServiceVertxEBProxy(vertx, addresse);
	}

	public void gererRechercheCalculInr(OperationRequest operationRequete, Handler<AsyncResult<OperationResponse>> gestionnaireEvenements);
	public void gererPOSTCalculInr(JsonObject document, OperationRequest operationRequete, Handler<AsyncResult<OperationResponse>> gestionnaireEvenements);
	public void gererPATCHCalculInr(JsonObject document, OperationRequest operationRequete, Handler<AsyncResult<OperationResponse>> gestionnaireEvenements);
	public void gererGETCalculInr(OperationRequest operationRequete, Handler<AsyncResult<OperationResponse>> gestionnaireEvenements);
	public void gererPUTCalculInr(JsonObject document, OperationRequest operationRequete, Handler<AsyncResult<OperationResponse>> gestionnaireEvenements);
	public void gererDELETECalculInr(OperationRequest operationRequete, Handler<AsyncResult<OperationResponse>> gestionnaireEvenements);
}
