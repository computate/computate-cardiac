package com.heytate.frFR.cardiaque.warfarin;

import java.io.IOException;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.lucene.search.Query;
import org.apache.solr.common.params.MultiMapSolrParams;
import org.apache.solr.common.params.SolrParams;
import org.apache.solr.common.util.NamedList;
import org.apache.solr.parser.QueryParser;
import org.apache.solr.search.QParser;
import org.apache.solr.search.SolrQueryParser;
import org.apache.solr.search.SyntaxError;
import org.apache.solr.servlet.SolrRequestParsers;
import org.junit.Test;

public class InrEntryApi extends InrEntryApiGen {

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		JsonReader lecteurJson = Json.createReader(req.getInputStream());
		JsonObject obj = lecteurJson.readObject();
		JsonArray results = obj.getJsonArray("data");
		for (JsonObject result : results.getValuesAs(JsonObject.class)) {
			System.out.print(result.getJsonObject("from").getString("name"));
		}

	}
	@Test public void testStuff() throws Exception {
		MultiMapSolrParams paramsSolr = SolrRequestParsers.parseQueryString("fq=-ecoleCle_indexe_long:[* TO *]&fq=classeNomSimple_frFR_indexed_string:EcouteurContexte&fq=partNumero_indexed_int:1&q=*:*&rows=10000&sort=classeNomSimple_frFR_indexed_string asc&start=1");
		NamedList<Object> namedList = paramsSolr.toNamedList();
		SolrParams paramsSolr2 = paramsSolr.toSolrParams(namedList);
		paramsSolr2.toString();
	}
}
