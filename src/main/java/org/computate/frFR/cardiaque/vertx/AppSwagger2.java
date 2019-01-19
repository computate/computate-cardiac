package org.computate.frFR.cardiaque.vertx;

import java.io.File;
import java.util.List;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrQuery.ORDER;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.util.ClientUtils;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.computate.frFR.cardiaque.config.ConfigSite;
import org.computate.frFR.cardiaque.contexte.SiteContexte;
import org.computate.frFR.cardiaque.couverture.Couverture;
import org.computate.frFR.cardiaque.ecrivain.ToutEcrivain;
import org.computate.frFR.cardiaque.requete.RequeteSite;

public class AppSwagger2 extends AppSwagger2Gen<Object> {

	/**
	 * r: initLoin
	 * r.enUS: initDeep
	 * r: ecrire
	 * r.enUS: write
	 */
	public static void main(String[] args) {
		AppSwagger2 api = new AppSwagger2();
		api.initLoinAppSwagger2();
		api.ecrireOpenApi();
	}

	/**
	 * var.enUS: siteRequest_
	 */
	protected void _requeteSite_(Couverture<RequeteSite> c) {
	}

	/**
	 * var.enUS: siteContext
	 */
	protected void _siteContexte(SiteContexte o) {
	}

	/**
	 * var.enUS: siteConfig
	 * r: siteContexte
	 * r.enUS: siteContext
	 * r: ConfigSite
	 * r.enUS: SiteConfig
	 */
	protected void _configSite(Couverture<ConfigSite> c) {
		c.o(siteContexte.getConfigSite());
	}

	/**
	 * {@inheritDoc}
	 * var.enUS: appPath
	 * r: configSite
	 * r.enUS: siteConfig
	 * r: AppliChemin
	 * r.enUS: AppPath
	 **/
	protected void _appliChemin(Couverture<String> c) {
		c.o(configSite.getAppliChemin());
	}

	/**
	 * {@inheritDoc}
	 **/
	protected void _apiVersion(Couverture<String> c) {
		c.o("2.0");
	}

	/**
	 * {@inheritDoc}
	 * var.enUS: openApiYamlPath
	 * r: appliChemin
	 * r.enUS: appPath
	 **/
	protected void _openApiYamlChemin(Couverture<String> c) {
		c.o(appliChemin + "/src/main/resources/swagger2.yaml");
	}

	/**
	 * {@inheritDoc}
	 * var.enUS: openApiYamlFile
	 * r: openApiYamlChemin
	 * r.enUS: openApiYamlPath
	 **/
	protected void _openApiYamlFichier(Couverture<File> c) {
		c.o(new File(openApiYamlChemin));
	}

	/**
	 * {@inheritDoc}
	 * r: creer
	 * r.enUS: create
	 * r: ToutEcrivain
	 * r.enUS: AllWriter
	 * r: requeteSite
	 * r.enUS: siteRequest
	 * r: openApiYamlFichier
	 * r.enUS: openApiYamlFile
	 **/
	protected void _w(Couverture<ToutEcrivain> c) {
		c.o(ToutEcrivain.creer(requeteSite_, openApiYamlFichier));
	}

	/**
	 * {@inheritDoc}
	 * var.enUS: wPaths
	 * r: creer
	 * r.enUS: create
	 * r: ToutEcrivain
	 * r.enUS: AllWriter
	 * r: requeteSite
	 * r.enUS: siteRequest
	 **/
	protected void _wChemins(Couverture<ToutEcrivain> c) {
		c.o(ToutEcrivain.creer(requeteSite_));
	}

	/**
	 * {@inheritDoc}
	 * var.enUS: wRequestBodies
	 * r: creer
	 * r.enUS: create
	 * r: ToutEcrivain
	 * r.enUS: AllWriter
	 * r: requeteSite
	 * r.enUS: siteRequest
	 **/
	protected void _wCorpsRequetes(Couverture<ToutEcrivain> c) {
		c.o(ToutEcrivain.creer(requeteSite_));
	}

	/**
	 * {@inheritDoc}
	 * r: creer
	 * r.enUS: create
	 * r: ToutEcrivain
	 * r.enUS: AllWriter
	 * r: requeteSite
	 * r.enUS: siteRequest
	 **/
	protected void _wSchemas(Couverture<ToutEcrivain> c) {
		c.o(ToutEcrivain.creer(requeteSite_));
	}

	/**
	 * var.enUS: writeOpenApi
	 */
	public void ecrireOpenApi() {

		ecrireInfo();
		ecrireApi();

		w.s(wChemins.toString());
		w.s(wCorpsRequetes.toString());
		w.s(wSchemas.toString());

		w.flushClose();
	}

	public void ecrireInfo() {

		if("2.0".equals(apiVersion))
			wChemins.l("swagger: \"", apiVersion, "\"");
		else
			wChemins.l("openapi: \"", apiVersion, "\"");

		wChemins.l("info:");

		wChemins.t(1, "title: ").string(configSite.getApiTitre()).l();
		wChemins.t(1, "description: ").yamlStr(2, configSite.getApiDescription());
		wChemins.t(1, "version: ").string(apiVersion).l();
		wChemins.t(0, "host: ").js(configSite.getApiNomHote()).l();
		if("2.0".equals(apiVersion)) {
			wChemins.tl(0, "schemes:");
			wChemins.tl(1, "- \"https\"");
		}
	}

	public void ecrireApi() {

		wChemins.tl(0, "paths:");

		if("2.0".equals(apiVersion)) {
			wSchemas.tl(0, "definitions:");
		}
		else {
			wCorpsRequetes.tl(0, "components:");
			wCorpsRequetes.tl(1, "requestBodies:");
			wSchemas.tl(1, "schemas:");
		}

		SolrQuery rechercheClasses = new SolrQuery();
		rechercheClasses.setQuery("*:*");
		rechercheClasses.setRows(1000000);
		rechercheClasses.addFilterQuery("appliChemin_indexed_string:" + ClientUtils.escapeQueryChars(appliChemin));
		rechercheClasses.addFilterQuery("classeApi_indexed_boolean:true");
		rechercheClasses.addFilterQuery("partEstClasse_indexed_boolean:true");
		rechercheClasses.addSort("partNumero_indexed_int", ORDER.asc);
		QueryResponse searchClassesResponse = siteContexte.getClientSolrComputate().query(rechercheClasses);
		SolrDocumentList rechercheClassesResultats = searchClassesResponse.getResults();
		Integer rechercheClassesLignes = rechercheClasses.getRows();
		for(Long i = rechercheClassesResultats.getStart(); i < rechercheClassesResultats.getNumFound(); i+=rechercheClassesLignes) {
			for(Integer j = 0; j < rechercheClassesResultats.size(); j++) {
				SolrDocument classeSolrDocument = rechercheClassesResultats.get(j);

				classApiTag = StringUtils.defaultIfBlank((String)classeSolrDocument.get("classApiTag_stored_string"), classSimpleName + " API");
				classApiUri = (String)classeSolrDocument.get("classApiUri_stored_string");
				classIsBase = (Boolean)classeSolrDocument.get("classIsBase_stored_boolean");

				classApiUriSearch = (String)classeSolrDocument.get("classApiUriSearch_stored_string");
				classApiUriPOST = (String)classeSolrDocument.get("classApiUriPOST_stored_string");
				classApiUriPATCH = (String)classeSolrDocument.get("classApiUriPATCH_stored_string");
				classApiUriGET = (String)classeSolrDocument.get("classApiUriGET_stored_string");
				classApiUriPUT = (String)classeSolrDocument.get("classApiUriPUT_stored_string");
				classApiUriDELETE = (String)classeSolrDocument.get("classApiUriDELETE_stored_string");

				classApiOperationIdSearch = (String)classeSolrDocument.get("classApiOperationIdSearch_stored_string");
				classApiOperationIdPOST = (String)classeSolrDocument.get("classApiOperationIdPOST_stored_string");
				classApiOperationIdPATCH = (String)classeSolrDocument.get("classApiOperationIdPATCH_stored_string");
				classApiOperationIdGET = (String)classeSolrDocument.get("classApiOperationIdGET_stored_string");
				classApiOperationIdPUT = (String)classeSolrDocument.get("classApiOperationIdPUT_stored_string");
				classApiOperationIdDELETE = (String)classeSolrDocument.get("classApiOperationIdDELETE_stored_string");

				classApiOperationIdSearchRequest = (String)classeSolrDocument.get("classApiOperationIdSearchRequest_stored_string");
				classApiOperationIdPOSTRequest = (String)classeSolrDocument.get("classApiOperationIdPOSTRequest_stored_string");
				classApiOperationIdPATCHRequest = (String)classeSolrDocument.get("classApiOperationIdPATCHRequest_stored_string");
				classApiOperationIdGETRequest = (String)classeSolrDocument.get("classApiOperationIdGETRequest_stored_string");
				classApiOperationIdPUTRequest = (String)classeSolrDocument.get("classApiOperationIdPUTRequest_stored_string");
				classApiOperationIdDELETERequest = (String)classeSolrDocument.get("classApiOperationIdDELETERequest_stored_string");

				classApiOperationIdSearchResponse = (String)classeSolrDocument.get("classApiOperationIdSearchResponse_stored_string");
				classApiOperationIdPOSTResponse = (String)classeSolrDocument.get("classApiOperationIdPOSTResponse_stored_string");
				classApiOperationIdPATCHResponse = (String)classeSolrDocument.get("classApiOperationIdPATCHResponse_stored_string");
				classApiOperationIdGETResponse = (String)classeSolrDocument.get("classApiOperationIdGETResponse_stored_string");
				classApiOperationIdPUTResponse = (String)classeSolrDocument.get("classApiOperationIdPUTResponse_stored_string");
				classApiOperationIdDELETEResponse = (String)classeSolrDocument.get("classApiOperationIdDELETEResponse_stored_string");

				classSuperApiOperationIdSearchRequest = (String)classeSolrDocument.get("classSuperApiOperationIdSearchRequest_stored_string");
				classSuperApiOperationIdPOSTRequest = (String)classeSolrDocument.get("classSuperApiOperationIdPOSTRequest_stored_string");
				classSuperApiOperationIdPATCHRequest = (String)classeSolrDocument.get("classSuperApiOperationIdPATCHRequest_stored_string");
				classSuperApiOperationIdGETRequest = (String)classeSolrDocument.get("classSuperApiOperationIdGETRequest_stored_string");
				classSuperApiOperationIdPUTRequest = (String)classeSolrDocument.get("classSuperApiOperationIdPUTRequest_stored_string");
				classSuperApiOperationIdDELETERequest = (String)classeSolrDocument.get("classSuperApiOperationIdDELETERequest_stored_string");

				classSuperApiOperationIdSearchResponse = (String)classeSolrDocument.get("classSuperApiOperationIdSearchResponse_stored_string");
				classSuperApiOperationIdPOSTResponse = (String)classeSolrDocument.get("classSuperApiOperationIdPOSTResponse_stored_string");
				classSuperApiOperationIdPATCHResponse = (String)classeSolrDocument.get("classSuperApiOperationIdPATCHResponse_stored_string");
				classSuperApiOperationIdGETResponse = (String)classeSolrDocument.get("classSuperApiOperationIdGETResponse_stored_string");
				classSuperApiOperationIdPUTResponse = (String)classeSolrDocument.get("classSuperApiOperationIdPUTResponse_stored_string");
				classSuperApiOperationIdDELETEResponse = (String)classeSolrDocument.get("classSuperApiOperationIdDELETEResponse_stored_string");

				classSimpleName = (String)classeSolrDocument.get("classSimpleName_enUS_stored_string");
				classAbsolutePath = (String)classeSolrDocument.get("classAbsolutePath_stored_string");

				classKeywordsFound = BooleanUtils.isTrue((Boolean)classeSolrDocument.get("classKeywordsFound_stored_boolean"));
				classKeywords = (List<String>)classeSolrDocument.get("classKeywords_stored_strings");

				ToutEcrivain wSearchRequestHeaders = ToutEcrivain.create(siteRequest_, "  ");
				ToutEcrivain wSearchRequestDescription = ToutEcrivain.create(siteRequest_, "  ");
				ToutEcrivain wSearchResponseDescription = ToutEcrivain.create(siteRequest_, "  ");
				ToutEcrivain wSearchRequestSchema = ToutEcrivain.create(siteRequest_, "  ");
				ToutEcrivain wSearchResponseSchema = ToutEcrivain.create(siteRequest_, "  ");
				ToutEcrivains wSearchWriters = ToutEcrivains.create(siteRequest_, wSearchRequestHeaders, wSearchRequestDescription, wSearchResponseDescription, wSearchRequestSchema, wSearchResponseSchema);

				ToutEcrivain wPOSTRequestHeaders = ToutEcrivain.create(siteRequest_, "  ");
				ToutEcrivain wPOSTRequestDescription = ToutEcrivain.create(siteRequest_, "  ");
				ToutEcrivain wPOSTResponseDescription = ToutEcrivain.create(siteRequest_, "  ");
				ToutEcrivain wPOSTRequestSchema = ToutEcrivain.create(siteRequest_, "  ");
				ToutEcrivain wPOSTResponseSchema = ToutEcrivain.create(siteRequest_, "  ");
				ToutEcrivains wPOSTWriters = ToutEcrivains.create(siteRequest_, wPOSTRequestHeaders, wPOSTRequestDescription, wPOSTResponseDescription, wPOSTRequestSchema, wPOSTResponseSchema);

				ToutEcrivain wPATCHRequestHeaders = ToutEcrivain.create(siteRequest_, "  ");
				ToutEcrivain wPATCHRequestDescription = ToutEcrivain.create(siteRequest_, "  ");
				ToutEcrivain wPATCHResponseDescription = ToutEcrivain.create(siteRequest_, "  ");
				ToutEcrivain wPATCHRequestSchema = ToutEcrivain.create(siteRequest_, "  ");
				ToutEcrivain wPATCHResponseSchema = ToutEcrivain.create(siteRequest_, "  ");
				ToutEcrivains wPATCHWriters = ToutEcrivains.create(siteRequest_, wPATCHRequestHeaders, wPATCHRequestDescription, wPATCHResponseDescription, wPATCHRequestSchema, wPATCHResponseSchema);

				ToutEcrivain wGETRequestHeaders = ToutEcrivain.create(siteRequest_, "  ");
				ToutEcrivain wGETRequestDescription = ToutEcrivain.create(siteRequest_, "  ");
				ToutEcrivain wGETResponseDescription = ToutEcrivain.create(siteRequest_, "  ");
				ToutEcrivain wGETRequestSchema = ToutEcrivain.create(siteRequest_, "  ");
				ToutEcrivain wGETResponseSchema = ToutEcrivain.create(siteRequest_, "  ");
				ToutEcrivains wGETWriters = ToutEcrivains.create(siteRequest_, wGETRequestHeaders, wGETRequestDescription, wGETResponseDescription, wGETRequestSchema, wGETResponseSchema);

				ToutEcrivain wPUTRequestHeaders = ToutEcrivain.create(siteRequest_, "  ");
				ToutEcrivain wPUTRequestDescription = ToutEcrivain.create(siteRequest_, "  ");
				ToutEcrivain wPUTResponseDescription = ToutEcrivain.create(siteRequest_, "  ");
				ToutEcrivain wPUTRequestSchema = ToutEcrivain.create(siteRequest_, "  ");
				ToutEcrivain wPUTResponseSchema = ToutEcrivain.create(siteRequest_, "  ");
				ToutEcrivains wPUTWriters = ToutEcrivains.create(siteRequest_, wPUTRequestHeaders, wPUTRequestDescription, wPUTResponseDescription, wPUTRequestSchema, wPUTResponseSchema);

				ToutEcrivain wDELETERequestHeaders = ToutEcrivain.create(siteRequest_, "  ");
				ToutEcrivain wDELETERequestDescription = ToutEcrivain.create(siteRequest_, "  ");
				ToutEcrivain wDELETEResponseDescription = ToutEcrivain.create(siteRequest_, "  ");
				ToutEcrivain wDELETERequestSchema = ToutEcrivain.create(siteRequest_, "  ");
				ToutEcrivain wDELETEResponseSchema = ToutEcrivain.create(siteRequest_, "  ");
				ToutEcrivains wDELETEWriters = ToutEcrivains.create(siteRequest_, wDELETERequestHeaders, wDELETERequestDescription, wDELETEResponseDescription, wDELETERequestSchema, wDELETEResponseSchema);

				if(classApiUri != null) {
	
					SolrQuery searchEntities = new SolrQuery();
					searchEntities.setQuery("*:*");
					searchEntities.setRows(1000000);
					searchEntities.addFilterQuery("appPath_indexed_string:" + ClientUtils.escapeQueryChars(siteConfig.getAppPath()));
					searchEntities.addFilterQuery("classAbsolutePath_indexed_string:" + ClientUtils.escapeQueryChars(classAbsolutePath));
					searchEntities.addFilterQuery("partIsEntity_indexed_boolean:true");
					searchEntities.addSort("partNumber_indexed_int", ORDER.asc);
					QueryResponse searchEntitiesResponse = siteContext.getSolrClientComputate().query(searchEntities);
					SolrDocumentList searchEntitiesResults = searchEntitiesResponse.getResults();
					Integer searchEntitiesLignes = searchEntities.getRows();
	
					for(Long k = searchEntitiesResults.getStart(); k < searchEntitiesResults.getNumFound(); k+=searchEntitiesLignes) {
						for(Integer l = 0; l < searchEntitiesResults.size(); l++) {
							entitySolrDocument = searchEntitiesResults.get(l);
							entityVar = (String)entitySolrDocument.get("entityVar_enUS_stored_string");
							entityCanonicalName = (String)entitySolrDocument.get("entityCanonicalName_enUS_stored_string");
							entityCanonicalNameGeneric = (String)entitySolrDocument.get("entityCanonicalNameGeneric_enUS_stored_string");
							entityVarApi = StringUtils.defaultIfBlank((String)entitySolrDocument.get("entityVarApi_stored_string"), entityVar);
							entityDescription = (String)entitySolrDocument.get("entityDescription_stored_string");
							entityDisplayName = (String)entitySolrDocument.get("entityDisplayName_stored_string");
							entityMinLength = (Integer)entitySolrDocument.get("entityMinLength_stored_int");
							entityMaxLength = (Integer)entitySolrDocument.get("entityMaxLength_stored_int");
							entityMin = (Double)entitySolrDocument.get("entityMin_stored_double");
							entityMax = (Double)entitySolrDocument.get("entityMax_stored_double");
							entityOptional = (Boolean)entitySolrDocument.get("entityOptional_stored_boolean");
							entityVarCapitalized = (String)entitySolrDocument.get("entityVarCapitalized_enUS_stored_string");
							entityJsonType = (String)entitySolrDocument.get("entityJsonType_stored_string");
							entityListJsonType = (String)entitySolrDocument.get("entityListJsonType_stored_string");
							entityJsonFormat = (String)entitySolrDocument.get("entityJsonFormat_stored_string");
							entityPrimaryKey = BooleanUtils.isTrue((Boolean)entitySolrDocument.get("entityPrimaryKey_stored_boolean"));
							entityStored = BooleanUtils.isTrue((Boolean)entitySolrDocument.get("entityStored_stored_boolean"));
							entityIndexed = BooleanUtils.isTrue((Boolean)entitySolrDocument.get("entityIndexed_stored_boolean"));
							entityKeywordsFound = BooleanUtils.isTrue((Boolean)entitySolrDocument.get("entityKeywordsFound_stored_boolean"));
							entityKeywords = (List<String>)entitySolrDocument.get("entityKeywords_stored_strings");
							entityOptionsVar = (List<String>)entitySolrDocument.get("entityOptionsVar_stored_strings");
							entityOptionsValue = (List<String>)entitySolrDocument.get("entityOptionsValue_stored_strings");
	
//								if(entityJsonType != null) {
		
								///////////////////////
								// GET Liste Request //
								///////////////////////
		
								writeEntityHeader(wSearchRequestHeaders, "Search");
//									writeEntityDescription(null, wSearchRequestDescription, "Search", "request");
//									writeEntityDescription(null, wSearchResponseDescription, "Search", "response");
								writeEntitySchema(null, wSearchRequestSchema, "Search", "request");
								writeEntitySchema(null, wSearchResponseSchema, "Search", "response");
		
								writeEntityHeader(wGETRequestHeaders, "GET");
//									writeEntityDescription(null, wGETRequestDescription, "GET", "request");
//									writeEntityDescription(null, wGETResponseDescription, "GET", "response");
								writeEntitySchema(null, wGETRequestSchema, "GET", "request");
								writeEntitySchema(null, wGETResponseSchema, "GET", "response");
		
								writeEntityHeader(wPOSTRequestHeaders, "POST");
//									writeEntityDescription(null, wPOSTRequestDescription, "POST", "request");
//									writeEntityDescription(null, wPOSTResponseDescription, "POST", "response");
								writeEntitySchema(null, wPOSTRequestSchema, "POST", "request");
								writeEntitySchema(null, wPOSTResponseSchema, "POST", "response");
//								}
						}
					}
					writeApi(wPaths, wSchemas, wPOSTWriters, "POST", classApiUriPOST, classApiOperationIdPOST, classApiOperationIdPOSTRequest, classApiOperationIdPOSTResponse, classSuperApiOperationIdPOSTRequest, classSuperApiOperationIdPOSTResponse);
					writeApi(wPaths, wSchemas, wSearchWriters, "Search", classApiUriSearch, classApiOperationIdSearch, classApiOperationIdSearchRequest, classApiOperationIdSearchResponse, classSuperApiOperationIdSearchRequest, classSuperApiOperationIdSearchResponse);
					writeApi(wPaths, wSchemas, wPATCHWriters, "PATCH", classApiUriPATCH, classApiOperationIdPATCH, classApiOperationIdPATCHRequest, classApiOperationIdPATCHResponse, classSuperApiOperationIdPATCHRequest, classSuperApiOperationIdPATCHResponse);
					writeApi(wPaths, wSchemas, wGETWriters, "GET", classApiUriGET, classApiOperationIdGET, classApiOperationIdGETRequest, classApiOperationIdGETResponse, classSuperApiOperationIdGETRequest, classSuperApiOperationIdGETResponse);
					writeApi(wPaths, wSchemas, wPUTWriters, "PUT", classApiUriPUT, classApiOperationIdPUT, classApiOperationIdPUTRequest, classApiOperationIdPUTResponse, classSuperApiOperationIdPUTRequest, classSuperApiOperationIdPUTResponse);
					writeApi(wPaths, wSchemas, wDELETEWriters, "DELETE", classApiUriDELETE, classApiOperationIdDELETE, classApiOperationIdDELETERequest, classApiOperationIdDELETEResponse, classSuperApiOperationIdDELETERequest, classSuperApiOperationIdDELETEResponse);
				}

				wSearchRequestDescription.flushClose();
				wGETRequestDescription.flushClose();
				wPOSTRequestDescription.flushClose();
				wPUTRequestDescription.flushClose();
				wPATCHRequestDescription.flushClose();
				wSearchResponseDescription.flushClose();
				wGETResponseDescription.flushClose();
				wPOSTResponseDescription.flushClose();
				wPUTResponseDescription.flushClose();
				wPATCHResponseDescription.flushClose();
			}
			rechercheClasses.setStart(i.intValue() + rechercheClassesLignes);
			searchClassesResponse = siteContext.getSolrClientComputate().query(rechercheClasses);
			rechercheClassesResultats = searchClassesResponse.getResults();
			rechercheClassesLignes = rechercheClasses.getRows();
		}
		wSchemas.tl(1, "ErrorResponse:");
		wSchemas.tl(2, "required:");
		wSchemas.tl(3, "- type");
		wSchemas.tl(3, "- code");
		wSchemas.tl(2, "properties:");
		wSchemas.tl(3, "type:");
		wSchemas.tl(4, "type: string");
		wSchemas.tl(4, "enum:");
		wSchemas.tl(5, "- ERROR");
		wSchemas.tl(5, "- WARN");
		wSchemas.tl(5, "- INVALID");
		wSchemas.tl(5, "- FATAL");
		wSchemas.t(4, "description: ").yamlStr(5, "<br>invalid - Request did not confirm to the specification and was unprocessed & rejected. Please fix the value and try again</br>                         <br>warn - Request was partially processed.  E.g. some of the fields are missing in response to the system issues,  request was accepted successfully but will be processed asynchronously</br>                                                          <br>error - The request was accepted but could not be processed successfully</br>            <br>fatal - There was an internal system error while processing the request. These are technical errors and will be resolved by Citi, and the consumer should retry after some time. Business errors will not be categorized as fatal </br>");
		wSchemas.tl(3, "code:");
		wSchemas.tl(4, "type: string");
		wSchemas.tl(4, "description: Error code which qualifies the error. ");
		wSchemas.tl(3, "details:");
		wSchemas.tl(4, "type: string");
		wSchemas.tl(4, "description: Human readable explanation specific to the occurrence of the problem. ");
		wSchemas.tl(3, "location:");
		wSchemas.tl(4, "type: string");
		wSchemas.tl(4, "description: The name of the field that resulted in the error. ");
		wSchemas.tl(3, "moreInfo:");
		wSchemas.tl(4, "type: string");
		wSchemas.tl(4, "description: URI to human readable documentation of the error. ");
	}

	public void ecrireApi(ToutEcrivain w) throws Exception {

		w.write("swagger: \"2.0\"\n");

		w.write("info:\n");

		w.write("  description: \"");
		w.write(StringEscapeUtils.escapeJava(configSite.getApiDescription()));
		w.write("\"\n");

		w.write("  version: \"");
		w.write(StringEscapeUtils.escapeJava(configSite.getApiVersion()));
		w.write("\"\n");

		w.write("  title: \"");
		w.write(StringEscapeUtils.escapeJava(configSite.getSiteNomAffichage()));
		w.write("\"\n");

		w.write("host: \"");
		w.write(StringEscapeUtils.escapeJava(configSite.getApiNomHote()));
		w.write("\"\n");

		if(configSite.getApiCheminBase() != null) {
			w.write("basePath: \"");
			w.write(StringEscapeUtils.escapeJava(configSite.getApiCheminBase()));
			w.write("\"\n");
		}
//
//			w.write("servers:\n");
//
//			w.write("  - url: \"");
//			w.write(StringEscapeUtils.escapeJava(configSite.getUrlDomaineBase()));
//			w.write("\"\n");
//			w.write("    description: \"");
//			w.write("\"\n");

		w.write("schemes:\n");
		w.write("- \"https\"\n");
		w.write("paths:\n");

		SolrQuery rechercheClasses = new SolrQuery();
		rechercheClasses.setQuery("*:*");
		rechercheClasses.setRows(1000000);
		rechercheClasses.addFilterQuery("appliChemin_indexed_string:" + ClientUtils.escapeQueryChars(configSite.getAppliChemin()));
		rechercheClasses.addFilterQuery("classeApi_indexed_boolean:true");
		rechercheClasses.addFilterQuery("partEstClasse_indexed_boolean:true");
		rechercheClasses.addSort("partNumero_indexed_int", ORDER.asc);
		QueryResponse rechercheClassesReponse = siteContexte.getClientSolrComputate().query(rechercheClasses);
		SolrDocumentList rechercheClassesResultats = rechercheClassesReponse.getResults();
		Integer rechercheClassesLignes = rechercheClasses.getRows();
		for(Long i = rechercheClassesResultats.getStart(); i < rechercheClassesResultats.getNumFound(); i+=rechercheClassesLignes) {
			for(Integer j = 0; j < rechercheClassesResultats.size(); j++) {
				SolrDocument documentSolrClasse = rechercheClassesResultats.get(j);
				String classeApiUri = (String)documentSolrClasse.get("classeApiUri_frFR_stored_string");
				String classeNomSimple = (String)documentSolrClasse.get("classeNomSimple_frFR_stored_string");
				String operationIdGet = "get" + classeNomSimple;
				String operationIdPost = "post" + classeNomSimple;
				String operationIdPut = "put" + classeNomSimple;
				String operationIdPatch = "patch" + classeNomSimple;

				if(classeApiUri != null) {
					w.write("  ");
					w.write(classeApiUri);
					w.write(":\n");
	
					/////////
					// GET //
					/////////
					w.write("    get:\n");
					w.write("      operationId: \"");
					w.write(operationIdGet);
					w.write("\"\n");
	
					w.write("      summary: \"");
					w.write("\"\n");
					w.write("      tags:\n");
					w.write("        - \"");
					w.write(classeNomSimple);
					w.write(" model");
					w.write("\"\n");
	
					w.write("      description: \"");
					w.write("\"\n");
	
					w.write("      produces:\n");
					w.write("      - \"application/json\"\n");
	
	//		tl(2, "  (\"q\",   (\"[^:]+:.*\", \"*:*\"), false, false);");
	//		tl(2, "  (\"fq\",   (\"[^:]+:.*\", null), false, false);");
	//		tl(2, "  (\"sort\",   (\"[^:]+:.*\", null), false, false);");
	//		tl(2, "  (\"fl\",   (\"[^:]+:.*\", null), false, false);");
	//		tl(2, "  (\"start\",   (null, 0D, null, 0), false, false);");
	//		tl(2, "  (\"rows\",   (null, 1D, null, 10), false, false);");
					w.write("      parameters:\n");
					w.write("      - in: \"query\"\n");
					w.write("        name: \"q\"\n");
					w.write("        description: \"\"\n");
					w.write("        required: false\n");
					w.write("        type: string\n");
					w.write("        default: \"**:**\"\n");
					w.write("      - in: \"query\"\n");
					w.write("        name: \"fq\"\n");
					w.write("        description: \"\"\n");
					w.write("        required: false\n");
					w.write("        type: array\n");
					w.write("        items:\n");
					w.write("          type: string\n");
					w.write("      - in: \"query\"\n");
					w.write("        name: \"fl\"\n");
					w.write("        description: \"\"\n");
					w.write("        required: false\n");
					w.write("        type: string\n");
					w.write("      - in: \"query\"\n");
					w.write("        name: \"start\"\n");
					w.write("        description: \"\"\n");
					w.write("        required: false\n");
					w.write("        type: integer\n");
					w.write("        default: 0\n");
					w.write("        minimum: 0\n");
					w.write("      - in: \"query\"\n");
					w.write("        name: \"rows\"\n");
					w.write("        description: \"\"\n");
					w.write("        required: false\n");
					w.write("        type: integer\n");
					w.write("        default: 10\n");
					w.write("        minimum: 1\n");
					w.write("      responses:\n");
					w.write("        '200':\n");
					w.write("          description: \"");
					w.write("\"\n");
					w.write("          schema:\n");
	
					w.write("            $ref: '#/definitions/");
					w.write(operationIdGet);
					w.write("'\n");
	
					//////////
					// POST //
					//////////
					w.write("    post:\n");
					w.write("      operationId: \"");
					w.write(operationIdPost);
					w.write("\"\n");
	
					w.write("      summary: \"");
					w.write("\"\n");
					w.write("      tags:\n");
					w.write("        - \"");
					w.write(classeNomSimple);
					w.write(" model");
					w.write("\"\n");
	
					w.write("      description: \"");
					w.write("\"\n");
	
					w.write("      produces:\n");
					w.write("      - \"application/json\"\n");
	
					w.write("      parameters:\n");
					w.write("      - in: body\n");
					w.write("        name: \"body\"\n");
					w.write("        description: \"\"\n");
					w.write("        required: true\n");
					w.write("        schema:\n");
	
					w.write("          $ref: '#/definitions/");
					w.write(operationIdPost);
					w.write("'\n");
	
					w.write("      responses:\n");
					w.write("        '201':\n");
					w.write("          description: \"");
					w.write("\"\n");
					w.write("          schema:\n");
	
					w.write("            $ref: '#/definitions/");
					w.write(operationIdGet);
					w.write("'\n");
	
					///////////
					// PATCH //
					///////////
					w.write("    patch:\n");
					w.write("      operationId: \"");
					w.write(operationIdPatch);
					w.write("\"\n");
	
					w.write("      summary: \"");
					w.write("\"\n");
					w.write("      tags:\n");
					w.write("        - \"");
					w.write(classeNomSimple);
					w.write(" model");
					w.write("\"\n");
	
					w.write("      description: \"");
					w.write("\"\n");
	
					w.write("      produces:\n");
					w.write("      - \"application/json\"\n");
	
					w.write("      parameters:\n");
					w.write("      - in: \"query\"\n");
					w.write("        name: \"q\"\n");
					w.write("        description: \"\"\n");
					w.write("        required: false\n");
					w.write("        type: string\n");
					w.write("        default: \"**:**\"\n");
					w.write("      - in: \"query\"\n");
					w.write("        name: \"fq\"\n");
					w.write("        description: \"\"\n");
					w.write("        required: false\n");
					w.write("        type: string\n");
					w.write("      - in: \"query\"\n");
					w.write("        name: \"fl\"\n");
					w.write("        description: \"\"\n");
					w.write("        required: false\n");
					w.write("        type: string\n");
					w.write("      - in: \"query\"\n");
					w.write("        name: \"start\"\n");
					w.write("        description: \"\"\n");
					w.write("        required: false\n");
					w.write("        type: integer\n");
					w.write("        minimum: 0\n");
					w.write("      - in: \"query\"\n");
					w.write("        name: \"rows\"\n");
					w.write("        description: \"\"\n");
					w.write("        required: false\n");
					w.write("        type: integer\n");
					w.write("        minimum: 1\n");
	
					w.write("      - in: body\n");
					w.write("        name: \"body\"\n");
					w.write("        description: \"\"\n");
					w.write("        required: true\n");
					w.write("        schema:\n");
	
					w.write("          $ref: '#/definitions/");
					w.write(operationIdPatch);
					w.write("'\n");
	
					w.write("      responses:\n");
					w.write("        '200':\n");
					w.write("          description: \"");
					w.write("\"\n");
					w.write("          schema:\n");
	
					w.write("            $ref: '#/definitions/");
					w.write(operationIdGet);
					w.write("'\n");
	
					/////////
					// PUT //
					/////////
					w.write("  ");
					w.write(classeApiUri);
					w.write("/{pk}");
					w.write(":\n");

					w.write("    put:\n");
					w.write("      operationId: \"");
					w.write(operationIdPut);
					w.write("\"\n");
	
					w.write("      summary: \"");
					w.write("\"\n");
					w.write("      tags:\n");
					w.write("        - \"");
					w.write(classeNomSimple);
					w.write(" model");
					w.write("\"\n");
	
					w.write("      description: \"");
					w.write("\"\n");
	
					w.write("      produces:\n");
					w.write("      - \"application/json\"\n");
	
					w.write("      parameters:\n");
					w.write("      - in: path\n");
					w.write("        name: \"pk\"\n");
					w.write("        description: \"\"\n");
					w.write("        required: true\n");
					w.write("        type: number\n");
					w.write("      - in: body\n");
					w.write("        name: \"body\"\n");
					w.write("        description: \"\"\n");
					w.write("        required: true\n");
					w.write("        schema:\n");
	
					w.write("          $ref: '#/definitions/");
					w.write(operationIdPut);
					w.write("'\n");
	
					w.write("      responses:\n");
					w.write("        '200':\n");
					w.write("          description: \"");
					w.write("\"\n");
					w.write("          schema:\n");
	
					w.write("            $ref: '#/definitions/");
					w.write(operationIdGet);
					w.write("'\n");
				}
			}
			rechercheClasses.setStart(i.intValue() + rechercheClassesLignes);
			rechercheClassesReponse = siteContexte.getClientSolrComputate().query(rechercheClasses);
			rechercheClassesResultats = rechercheClassesReponse.getResults();
			rechercheClassesLignes = rechercheClasses.getRows();
		}
	}

	public void genererSchemas(ToutEcrivain w) throws Exception {

		w.write("definitions:\n");

		SolrQuery rechercheClasses = new SolrQuery();
		rechercheClasses.setQuery("*:*");
		rechercheClasses.setRows(1000000);
		rechercheClasses.addFilterQuery("appliChemin_indexed_string:" + ClientUtils.escapeQueryChars(configSite.getAppliChemin()));
		rechercheClasses.addFilterQuery("classeApi_indexed_boolean:true");
		rechercheClasses.addFilterQuery("partEstClasse_indexed_boolean:true");
		rechercheClasses.addSort("partNumero_indexed_int", ORDER.asc);
		QueryResponse rechercheClassesReponse = siteContexte.getClientSolrComputate().query(rechercheClasses);
		SolrDocumentList rechercheClassesResultats = rechercheClassesReponse.getResults();
		Integer rechercheClassesLignes = rechercheClasses.getRows();
		for(Long i = rechercheClassesResultats.getStart(); i < rechercheClassesResultats.getNumFound(); i+=rechercheClassesLignes) {
			for(Integer j = 0; j < rechercheClassesResultats.size(); j++) {
				Long resultatIndice = i + j;
				SolrDocument documentSolr = rechercheClassesResultats.get(j);
				String classeApiUri = (String)documentSolr.get("classeApiUri_frFR_stored_string");
				String classeCheminAbsolu = (String)documentSolr.get("classeCheminAbsolu_stored_string");
				String classeNomSimple = (String)documentSolr.get("classeNomSimple_frFR_stored_string");
				String classeNomSimpleSuperGenerique = (String)documentSolr.get("classeNomSimpleSuperGenerique_frFR_stored_string");
				Boolean classeEstBase = (Boolean)documentSolr.get("classeEstBase_stored_boolean");
				String operationIdGet = "get" + classeNomSimple;
				String operationIdPost = "post" + classeNomSimple;
				String operationIdPut = "put" + classeNomSimple;
				String operationIdPatch = "patch" + classeNomSimple;

				SolrQuery rechercheEntites = new SolrQuery();
				rechercheEntites.setQuery("*:*");
				rechercheEntites.setRows(1000000);
				rechercheEntites.addFilterQuery("appliChemin_indexed_string:" + ClientUtils.escapeQueryChars(configSite.getAppliChemin()));
				rechercheEntites.addFilterQuery("classeCheminAbsolu_indexed_string:" + ClientUtils.escapeQueryChars(classeCheminAbsolu));
				rechercheEntites.addFilterQuery("partEstEntite_indexed_boolean:true");
				rechercheEntites.addSort("partNumero_indexed_int", ORDER.asc);
				QueryResponse rechercheEntitesReponse = siteContexte.getClientSolrComputate().query(rechercheEntites);
				SolrDocumentList rechercheEntitesResultats = rechercheEntitesReponse.getResults();
				Integer rechercheEntitesLignes = rechercheEntites.getRows();

				/////////
				// GET //
				/////////

				StringWriter sGet = new StringWriter();
				ToutEcrivain wGet = new ToutEcrivain(sGet);

				StringWriter sPost = new StringWriter();
				ToutEcrivain wPost = new ToutEcrivain(sPost);

				StringWriter sPut = new StringWriter();
				ToutEcrivain wPut = new ToutEcrivain(sPut);

				StringWriter sPatch = new StringWriter();
				ToutEcrivain wPatch = new ToutEcrivain(sPatch);

				/////////
				// GET //
				/////////
				wGet.write("  ");
				wGet.write(operationIdGet);
				wGet.write(":\n");

//					wGet.write("    tags:\n");
//					wGet.write("      - \"");
//					wGet.write(classeNomSimple);
//					wGet.write(" model");
//					wGet.write("\"\n");

				wGet.write("    allOf:\n");
				if(BooleanUtils.isFalse(classeEstBase)) {
					wGet.write("    - $ref: \"#/definitions/get");
					wGet.write(classeNomSimpleSuperGenerique);
					wGet.write("\"\n");
				}
				wGet.write("    - type: object\n");
				wGet.write("      properties:\n");
				wGet.write("        numFound:\n");
				wGet.write("          type: number\n");
				wGet.write("          default: 1\n");
				wGet.write("        start:\n");
				wGet.write("          type: number\n");
				wGet.write("          default: 0\n");
				wGet.write("        rows:\n");
				wGet.write("          type: number\n");
				wGet.write("          default: 10\n");
				wGet.write("        docs:\n");
				wGet.write("          type: array\n");
				wGet.write("          items:\n");
				wGet.write("            type: object\n");
				wGet.write("            properties:\n");

				//////////
				// POST //
				//////////
				wPost.write("  ");
				wPost.write(operationIdPost);
				wPost.write(":\n");

//					wPost.write("    tags:\n");
//					wPost.write("      - \"");
//					wPost.write(classeNomSimple);
//					wPost.write(" model");
//					wPost.write("\"\n");

				wPost.write("    allOf:\n");
				if(BooleanUtils.isFalse(classeEstBase)) {
					wPost.write("    - $ref: \"#/definitions/post");
					wPost.write(classeNomSimpleSuperGenerique);
					wPost.write("\"\n");
				}
				wPost.write("    - type: object\n");
				wPost.write("      properties:\n");

				/////////
				// PUT //
				/////////
				wPut.write("  ");
				wPut.write(operationIdPut);
				wPut.write(":\n");

//					wPut.write("    tags:\n");
//					wPut.write("      - \"");
//					wPut.write(classeNomSimple);
//					wPut.write(" model");
//					wPut.write("\"\n");

				wPut.write("    allOf:\n");
				if(BooleanUtils.isFalse(classeEstBase)) {
					wPut.write("    - $ref: \"#/definitions/put");
					wPut.write(classeNomSimpleSuperGenerique);
					wPut.write("\"\n");
				}
				wPut.write("    - type: object\n");
				wPut.write("      properties:\n");

				///////////
				// PATCH //
				///////////
				wPatch.write("  ");
				wPatch.write(operationIdPatch);
				wPatch.write(":\n");

//					wPatch.write("    tags:\n");
//					wPatch.write("      - \"");
//					wPatch.write(classeNomSimple);
//					wPatch.write(" model");
//					wPatch.write("\"\n");

				wPatch.write("    allOf:\n");
				if(BooleanUtils.isFalse(classeEstBase)) {
					wPatch.write("      - $ref: \"#/definitions/patch");
					wPatch.write(classeNomSimpleSuperGenerique);
					wPatch.write("\"\n");
				}
				wPatch.write("    - type: object\n");
				wPatch.write("      properties:\n");

				for(Long k = rechercheEntitesResultats.getStart(); k < rechercheEntitesResultats.getNumFound(); k+=rechercheEntitesLignes) {
					for(Integer l = 0; l < rechercheEntitesResultats.size(); l++) {
						SolrDocument documentSolrEntite = rechercheEntitesResultats.get(l);
						String entiteVar = (String)documentSolrEntite.get("entiteVar_frFR_stored_string");
						String entiteVarCapitalise = (String)documentSolrEntite.get("entiteVarCapitalise_frFR_stored_string");
						String entiteTypeJson = (String)documentSolrEntite.get("entiteTypeJson_stored_string");
						String entiteListeTypeJson = (String)documentSolrEntite.get("entiteListeTypeJson_stored_string");
						String entiteFormatJson = (String)documentSolrEntite.get("entiteFormatJson_stored_string");

						if(entiteTypeJson != null) {
	
							/////////
							// GET //
							/////////
	
							wGet.write("              ");
							wGet.write(entiteVar);
							wGet.write(":\n");
	
							wGet.write("                type: ");
							wGet.write(entiteTypeJson);
							wGet.write("\n");
	
							if(entiteFormatJson != null) {
								wGet.write("                format: ");
								wGet.write(entiteFormatJson);
								wGet.write("\n");
							}
	
							if(entiteListeTypeJson != null) {
		
								wGet.write("                items:\n");
		
								wGet.write("                  type: ");
								wGet.write(entiteListeTypeJson);
								wGet.write("\n");
							}
	
							if(!StringUtils.equals(entiteVar, "pk")) {
		
								//////////
								// POST //
								//////////
								wPost.write("        ");
								wPost.write(entiteVar);
								wPost.write(":\n");
		
								wPost.write("          type: ");
								wPost.write(entiteTypeJson);
								wPost.write("\n");
		
								if(entiteFormatJson != null) {
									wPost.write("          format: ");
									wPost.write(entiteFormatJson);
									wPost.write("\n");
								}
		
								if(entiteListeTypeJson != null) {
			
									wPost.write("          items:\n");
			
									wPost.write("            type: ");
									wPost.write(entiteListeTypeJson);
									wPost.write("\n");
								}
		
								/////////
								// PUT //
								/////////
								wPut.write("        ");
								wPut.write(entiteVar);
								wPut.write(":\n");
		
								wPut.write("          type: ");
								wPut.write(entiteTypeJson);
								wPut.write("\n");
		
								if(entiteFormatJson != null) {
									wPut.write("          format: ");
									wPut.write(entiteFormatJson);
									wPut.write("\n");
								}
		
								if(entiteListeTypeJson != null) {
			
									wPut.write("          items:\n");
			
									wPut.write("            type: ");
									wPut.write(entiteListeTypeJson);
									wPut.write("\n");
								}
		
								///////////
								// PATCH //
								///////////
		
								wPatch.write("        ");
								wPatch.write("set");
								wPatch.write(entiteVarCapitalise);
								wPatch.write(":\n");
		
								wPatch.write("          type: ");
								wPatch.write(entiteTypeJson);
								wPatch.write("\n");
		
								if(entiteFormatJson != null) {
									wPatch.write("          format: ");
									wPatch.write(entiteFormatJson);
									wPatch.write("\n");
								}
		
								if(entiteListeTypeJson != null) {
			
									wPatch.write("          items:\n");
			
									wPatch.write("            type: ");
									wPatch.write(entiteListeTypeJson);
									wPatch.write("\n");
								}
							}
						}
					}
				}

				wGet.flush();
				sGet.flush();
				wGet.close();
				sGet.close();

				wPost.flush();
				sPost.flush();
				wPost.close();
				sPost.close();

				wPut.flush();
				sPut.flush();
				wPut.close();
				sPut.close();

				wPatch.flush();
				sPatch.flush();
				wPatch.close();
				sPatch.close();

				w.write(sGet.toString());
				w.write(sPost.toString());
				w.write(sPut.toString());
				w.write(sPatch.toString());
			}
			rechercheClasses.setStart(i.intValue() + rechercheClassesLignes);
			rechercheClassesReponse = siteContexte.getClientSolrComputate().query(rechercheClasses);
			rechercheClassesResultats = rechercheClassesReponse.getResults();
			rechercheClassesLignes = rechercheClasses.getRows();
		}
	}
}
