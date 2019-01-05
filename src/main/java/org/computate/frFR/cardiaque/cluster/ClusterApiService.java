package org.computate.frFR.cardiaque.cluster;

import org.computate.frFR.cardiaque.contexte.SiteContexte;
import org.computate.frFR.cardiaque.service.ClusterApiServiceVertxEBProxy;

import io.vertx.codegen.annotations.ProxyGen;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.api.OperationResponse;

@ProxyGen
public interface ClusterApiService {

	// A couple of factory methods to create an instance and a proxy
	static ClusterApiService create(SiteContexte siteContexte, Vertx vertx) {
		return new ClusterApiServiceImpl(siteContexte);
	}

	static ClusterApiService createProxy(Vertx vertx, String address) {
		return new ClusterApiServiceVertxEBProxy(vertx, address);
	}

	public void patchCluster(JsonObject document, Handler<AsyncResult<OperationResponse>> resultHandler);
	public void postCluster(JsonObject document, Handler<AsyncResult<OperationResponse>> resultHandler);

}
