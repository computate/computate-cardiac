package org.computate.frFR.cardiaque.utilisateur;

import org.computate.frFR.cardiaque.contexte.SiteContexte;
import io.vertx.codegen.annotations.ProxyGen;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.api.OperationRequest;
import io.vertx.ext.web.api.OperationResponse;

@ProxyGen
public interface UtilisateurSiteGenApiService {
	// Une méthode d'usine pour créer une instance et un proxy. 
	static UtilisateurSiteGenApiService creer(SiteContexte siteContexte, Vertx vertx) {
		return new UtilisateurSiteApiServiceImpl(siteContexte);
	}

	// Une méthode d'usine pour créer une instance et un proxy. 
	static UtilisateurSiteGenApiService creerProxy(Vertx vertx, String addresse) {
		return new UtilisateurSiteGenApiServiceVertxEBProxy(vertx, addresse);
	}

}
