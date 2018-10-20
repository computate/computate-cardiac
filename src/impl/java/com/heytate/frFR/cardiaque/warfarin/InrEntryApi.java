package com.heytate.frFR.cardiaque.warfarin;

import java.io.IOException;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
}
