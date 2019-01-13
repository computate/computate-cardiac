package org.computate.enUS.cardiac.vertx;

import java.io.File;
import java.io.ToutEcrivain;
import java.io.StringWriter;
import java.util.List;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.StringEscapeUtils;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrQuery.ORDER;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.util.ClientUtils;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.computate.enUS.java.SiteConfig;
import org.computate.frFR.cardiaque.contexte.SiteContexte;
import org.computate.frFR.cardiaque.couverture.Couverture;
import org.computate.enUS.cardiac.writer.AllWriter;
import org.computate.frFR.cardiaque.requete.RequeteSite;

public class AppOpenApi3 extends AppOpenApi3Gen<Object> {

	public static void  main(String[] args) throws Exception, Exception {
		AppOpenApi3 api = new AppOpenApi3();
		api.initDeepAppOpenApi3();
		api.generateOpenApi();
	}

	public void  generateOpenApi() throws Exception, Exception {
		SiteConfig siteConfig = siteContext.getSiteConfig();
		String appPath = siteConfig.getAppliChemin();
		String openapiYamlPath = appPath + "/src/main/resources/openapi3.yaml";
		File openapiYamlFichier = new File(openapiYamlPath);
		AllWriter w = AllWriter.create(requeteSite_, openapiYamlFichier);

		generatePaths(w);
		generateRequeteBodies(w);
		generateSchemas(w);

		w.flushClose();
	}

	public void  generatePaths(ToutEcrivain w) throws Exception, Exception {

		w.s("openapi: \"");
		w.s(StringEscapeUtils.escapeJava(siteConfig.getOpenApiVersion()));
		w.l("\"");

		w.l("info:");

		w.s("  description: \"");
		w.s(StringEscapeUtils.escapeJava(siteConfig.getApiDescription()));
		w.l("\"");

		w.s("  version: \"");
		w.s(StringEscapeUtils.escapeJava(siteConfig.getApiVersion()));
		w.l("\"");

		w.s("  title: \"");
		w.s(StringEscapeUtils.escapeJava(siteConfig.getSiteDisplayName()));
		w.l("\"");

		w.s("  termsOfService: \"");
		w.s(StringEscapeUtils.escapeJava(siteConfig.getApiTermsService()));
		w.l("\"");

		w.l("  contact:");

		w.s("    email: \"");
		w.s(StringEscapeUtils.escapeJava(siteConfig.getApiContactMail()));
		w.l("\"");

		w.l("  license:");

		w.s("    name: \"");
		w.s(StringEscapeUtils.escapeJava(siteConfig.getApiLicenceName()));
		w.l("\"");

		w.s("    url: \"");
		w.s(StringEscapeUtils.escapeJava(siteConfig.getApiLicenceUrl()));
		w.l("\"");

		w.l("servers:");

		w.s("  - url: \"");
		w.s(StringEscapeUtils.escapeJava(siteConfig.getUrlDomainBase()));
		w.l("\"");
		w.s("    description: \"");
		w.l("\"");

		w.l("paths:");

		SolrQuery searchClasses = new SolrQuery();
		searchClasses.setQuery("*:*");
		searchClasses.setRows(1000000);
		searchClasses.addFilterQuery("appliChemin_indexed_string:" + ClientUtils.escapeQueryChars(siteConfig.getAppliChemin()));
		searchClasses.addFilterQuery("classeApi_indexed_boolean:true");
		searchClasses.addFilterQuery("partEstClasse_indexed_boolean:true");
		searchClasses.addSort("partNumero_indexed_int", ORDER.asc);
		QueryResponse searchClassesReponse = siteContexte.getClientSolrComputate().query(searchClasses);
		SolrDocumentList searchClassesResultats = searchClassesReponse.getResults();
		Integer searchClassesLignes = searchClasses.getRows();
		for(Long i = searchClassesResultats.getStart(); i < searchClassesResultats.getNumFound(); i+=searchClassesLignes) {
			for(Integer j = 0; j < searchClassesResultats.size(); j++) {
				SolrDocument classeSolrDocument = searchClassesResultats.get(j);

				String classeApiUri = (String)classeSolrDocument.get("classeApiUri_frFR_stored_string");
				String classeNomSimple = (String)classeSolrDocument.get("classeNomSimple_frFR_stored_string");
				String classeCheminAbsolu = (String)classeSolrDocument.get("classeCheminAbsolu_stored_string");

				String operationIdRecherche = "recherche" + classeNomSimple;
				String operationIdRechercheRequete = "rechercheRequete" + classeNomSimple;
				String operationIdRechercheReponse = "rechercheReponse" + classeNomSimple;

				String operationIdGET = "getDetails" + classeNomSimple;
				String operationIdGETRequete = "getDetailsRequete" + classeNomSimple;
				String operationIdGETReponse = "getDetailsReponse" + classeNomSimple;

				String operationIdPOSTRequete = "submitRequete" + classeNomSimple;
				String operationIdPOSTReponse = "submitReponse" + classeNomSimple;

				String operationIdPutRequete = "putRequete" + classeNomSimple;
				String operationIdPATCHRequete = "patchRequete" + classeNomSimple;

				Boolean classKeywordsFound = BooleanUtils.isTrue((Boolean)classeSolrDocument.get("classKeywordsFound_stored_boolean"));
				List<String> classKeywords = (List<String>)classeSolrDocument.get("classKeywords_stored_strings");

				ToutEcrivain wSearchPathRequete = ToutEcrivain.creer(requeteSite_);
				ToutEcrivain wGETPathRequete = ToutEcrivain.creer(requeteSite_);
				ToutEcrivain wPOSTPathRequete = ToutEcrivain.creer(requeteSite_);
				ToutEcrivain wPutPathRequete = ToutEcrivain.creer(requeteSite_);
				ToutEcrivain wPATCHPathRequete = ToutEcrivain.creer(requeteSite_);
				ToutEcrivain wSearchPathReponse = ToutEcrivain.creer(requeteSite_);
				ToutEcrivain wGETPathReponse = ToutEcrivain.creer(requeteSite_);
				ToutEcrivain wPOSTPathReponse = ToutEcrivain.creer(requeteSite_);
				ToutEcrivain wPutPathReponse = ToutEcrivain.creer(requeteSite_);
				ToutEcrivain wPATCHPathReponse = ToutEcrivain.creer(requeteSite_);

				w.s("  ");
				w.s(classeApiUri);
				w.l(":");

				///////////////
				// Recherche //
				///////////////
				w.l("    get:");
				w.s("      operationId: \"");
				w.s(operationIdGET);
				w.l("\"");

				w.s("      summary: \"");
				w.l("\"");

				w.s("      description: \"");
				w.l("\"");

//		tl(2, "  (\"q\",   (\"[^:]+:.*\", \"*:*\"), false, false);");
//		tl(2, "  (\"fq\",   (\"[^:]+:.*\", null), false, false);");
//		tl(2, "  (\"sort\",   (\"[^:]+:.*\", null), false, false);");
//		tl(2, "  (\"fl\",   (\"[^:]+:.*\", null), false, false);");
//		tl(2, "  (\"start\",   (null, 0D, null, 0), false, false);");
//		tl(2, "  (\"rows\",   (null, 1D, null, 10), false, false);");
				w.l("      parameters:");
				w.l("      - in: \"query\"");
				w.l("        name: \"q\"");
				w.l("        description: \"\"");
				w.l("        required: false");
				w.l("        schema:");
				w.l("          type: string");
				w.l("          default: \"**:**\"");
				w.l("        examples:");
				w.l("          default:");
				w.l("            value: \"&ast;:&ast;\"");
				w.l("            summary: \"This is the default solr query. \"");
				w.l("      - in: \"query\"");
				w.l("        name: \"fq\"");
				w.l("        description: \"\"");
				w.l("        required: false");
				w.l("        schema:");
				w.l("          type: array");
				w.l("          items:");
				w.l("            type: string");
				w.l("      - in: \"query\"");
				w.l("        name: \"fl\"");
				w.l("        description: \"\"");
				w.l("        required: false");
				w.l("        schema:");
				w.l("          type: string");
				w.l("      - in: \"query\"");
				w.l("        name: \"start\"");
				w.l("        description: \"\"");
				w.l("        required: false");
				w.l("        schema:");
				w.l("          type: integer");
				w.l("          default: 0");
				w.l("          minimum: 0");
				w.l("      - in: \"query\"");
				w.l("        name: \"rows\"");
				w.l("        description: \"\"");
				w.l("        required: false");
				w.l("        schema:");
				w.l("          type: integer");
				w.l("          default: 10");
				w.l("          minimum: 1");
				w.l("      responses:");
				w.l("        '200':");
				w.s("          description: \"");
				w.l("\"");
				w.l("          content:");
				w.l("            application/json:");
				w.l("              schema:");

				w.s("                $ref: '#/components/schemas/");
				w.s(operationIdGET);
				w.l("'");

				//////////
				// POST //
				//////////
				w.l("    post:");
				w.s("      operationId: \"");
				w.s(operationIdPOST);
				w.l("\"");

				w.s("      summary: \"");
				w.l("\"");

				w.s("      description: \"");
				w.l("\"");

				w.l("      requestBody:");
				w.l("        description: \"\"");
				w.l("        required: true");
				w.l("        content:");
				w.l("          application/json:");
				w.l("            schema:");

				w.s("              $ref: '#/components/schemas/");
				w.s(operationIdPOST);
				w.l("'");

				w.l("      responses:");
				w.l("        '201':");
				w.s("          description: \"");
				w.l("\"");
				w.l("          content:");
				w.l("            application/json:");
				w.l("              schema:");

				w.s("                $ref: '#/components/schemas/");
				w.s(operationIdGET);
				w.l("'");

				///////////
				// PATCH //
				///////////
				w.l("    patch:");
				w.s("      operationId: \"");
				w.s(operationIdPATCH);
				w.l("\"");

				w.s("      summary: \"");
				w.l("\"");

				w.s("      description: \"");
				w.l("\"");

				w.l("      parameters:");
				w.l("      - in: \"query\"");
				w.l("        name: \"q\"");
				w.l("        description: \"\"");
				w.l("        required: false");
				w.l("        schema:");
				w.l("          type: string");
				w.l("        examples:");
				w.l("          default:");
				w.l("            value: \"*:*\"");
				w.l("            summary: \"This is the default solr query. \"");
				w.l("      - in: \"query\"");
				w.l("        name: \"fq\"");
				w.l("        description: \"\"");
				w.l("        required: false");
				w.l("        schema:");
				w.l("          type: string");
				w.l("      - in: \"query\"");
				w.l("        name: \"fl\"");
				w.l("        description: \"\"");
				w.l("        required: false");
				w.l("        schema:");
				w.l("          type: string");
				w.l("      - in: \"query\"");
				w.l("        name: \"start\"");
				w.l("        description: \"\"");
				w.l("        required: false");
				w.l("        schema:");
				w.l("          type: integer");
				w.l("          minimum: 0");
				w.l("      - in: \"query\"");
				w.l("        name: \"rows\"");
				w.l("        description: \"\"");
				w.l("        required: false");
				w.l("        schema:");
				w.l("          type: integer");
				w.l("          minimum: 1");

				w.l("      requestBody:");
				w.l("        description: \"\"");
				w.l("        required: true");
				w.l("        content:");
				w.l("          application/json:");
				w.l("            schema:");

				w.s("              $ref: '#/components/schemas/");
				w.s(operationIdPATCH);
				w.l("'");

				w.l("      responses:");
				w.l("        '200':");
				w.s("          description: \"");
				w.l("\"");
				w.l("          content:");
				w.l("            application/json:");
				w.l("              schema:");

				w.s("                $ref: '#/components/schemas/");
				w.s(operationIdGET);
				w.l("'");
			}
			searchClasses.setStart(i.intValue() + searchClassesLignes);
			searchClassesReponse = siteContexte.getClientSolrComputate().query(searchClasses);
			searchClassesResultats = searchClassesReponse.getResults();
			searchClassesLignes = searchClasses.getRows();
		}
	}

	public void  genererCorpsRequetes(ToutEcrivain w) throws Exception, Exception {

		w.l("components:");

		w.l("  requestBodies:");

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
				SolrDocument classeSolrDocument = rechercheClassesResultats.get(j);
				String classeApiUri = (String)classeSolrDocument.get("classeApiUri_frFR_stored_string");
				String classeNomSimple = (String)classeSolrDocument.get("classeNomSimple_frFR_stored_string");
				String classeCheminAbsolu = (String)classeSolrDocument.get("classAbsolutePath_stored_string");

				String operationIdSearch = "getPending" + classeNomSimple;
				String operationIdSearchRequete = "getPendingRequete" + classeNomSimple;
				String operationIdSearchReponse = "getPendingReponse" + classeNomSimple;

				String operationIdGET = "getDetails" + classeNomSimple;
				String operationIdGETRequete = "getDetailsRequete" + classeNomSimple;
				String operationIdGETReponse = "getDetailsReponse" + classeNomSimple;

				String operationIdPOSTRequete = "submitRequete" + classeNomSimple;
				String operationIdPOSTReponse = "submitReponse" + classeNomSimple;

				String operationIdPutRequete = "putRequete" + classeNomSimple;
				String operationIdPATCHRequete = "patchRequete" + classeNomSimple;

				Boolean classKeywordsFound = BooleanUtils.isTrue((Boolean)classeSolrDocument.get("classKeywordsFound_stored_boolean"));
				List<String> classKeywords = (List<String>)classeSolrDocument.get("classKeywords_stored_strings");

				ToutEcrivain wSearchPathRequete = ToutEcrivain.creer(requeteSite_);
				ToutEcrivain wGETPathRequete = ToutEcrivain.creer(requeteSite_);
				ToutEcrivain wPOSTPathRequete = ToutEcrivain.creer(requeteSite_);
				ToutEcrivain wPutPathRequete = ToutEcrivain.creer(requeteSite_);
				ToutEcrivain wPATCHPathRequete = ToutEcrivain.creer(requeteSite_);
				ToutEcrivain wSearchPathReponse = ToutEcrivain.creer(requeteSite_);
				ToutEcrivain wGETPathReponse = ToutEcrivain.creer(requeteSite_);
				ToutEcrivain wPOSTPathReponse = ToutEcrivain.creer(requeteSite_);
				ToutEcrivain wPutPathReponse = ToutEcrivain.creer(requeteSite_);
				ToutEcrivain wPATCHPathReponse = ToutEcrivain.creer(requeteSite_);

				/////////
				// GET //
				/////////
				w.s("    ");
				w.s(operationIdGET);
				w.l(":");

				w.l("      required: true");

				w.s("      description: \"");
				w.l("\"");

				w.l("      content:");
				w.l("        application/json:");
				w.l("          schema:");

				w.s("            $ref: '#/components/schemas/");
				w.s(operationIdGET);
				w.l("'");

				//////////
				// POST //
				//////////
				w.s("    ");
				w.s(operationIdPOST);
				w.l(":");

				w.l("      required: true");

				w.s("      description: \"");
				w.l("\"");

				w.l("      content:");
				w.l("        application/json:");
				w.l("          schema:");

				w.s("            $ref: '#/components/schemas/");
				w.s(operationIdPOST);
				w.l("'");

				///////////
				// PATCH //
				///////////
				w.s("    ");
				w.s(operationIdPATCH);
				w.l(":");

				w.l("      required: true");

				w.s("      description: \"");
				w.l("\"");

				w.l("      content:");
				w.l("        application/json:");
				w.l("          schema:");

				w.s("            $ref: '#/components/schemas/");
				w.s(operationIdPATCH);
				w.l("'");
			}
			rechercheClasses.setStart(i.intValue() + rechercheClassesLignes);
			rechercheClassesReponse = siteContexte.getClientSolrComputate().query(rechercheClasses);
			rechercheClassesResultats = rechercheClassesReponse.getResults();
			rechercheClassesLignes = rechercheClasses.getRows();
		}
	}

	public void  genererSchemas(ToutEcrivain w) throws Exception, Exception {

		w.l("  schemas:");

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
				String operationIdGET = "get" + classeNomSimple;
				String operationIdPOST = "post" + classeNomSimple;
				String operationIdPATCH = "patch" + classeNomSimple;

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

				StringWriter sGET = new StringWriter();
				ToutEcrivain wGET = ToutEcrivain.creer(sGET);

				StringWriter sPOST = new StringWriter();
				ToutEcrivain wPOST = ToutEcrivain.creer(sPOST);

				StringWriter sPATCH = new StringWriter();
				ToutEcrivain wPATCH = ToutEcrivain.creer(sPATCH);

				wGET.write("    ");
				wGET.write(operationIdGET);
				wGET.write(":\n");
				wGET.write("      allOf:\n");
				if(BooleanUtils.isFalse(classeEstBase)) {
					wGET.write("      - $ref: \"#/components/schemas/get");
					wGET.write(classeNomSimpleSuperGenerique);
					wGET.write("\"\n");
				}
				wGET.write("      - type: object\n");
				wGET.write("        properties:\n");
				wGET.write("          numFound:\n");
				wGET.write("            type: number\n");
				wGET.write("            default: 1\n");
				wGET.write("          start:\n");
				wGET.write("            type: number\n");
				wGET.write("            default: 0\n");
				wGET.write("          rows:\n");
				wGET.write("            type: number\n");
				wGET.write("            default: 10\n");
				wGET.write("          docs:\n");
				wGET.write("            type: array\n");
				wGET.write("            items:\n");
				wGET.write("              type: object\n");
				wGET.write("              properties:\n");

				wPOST.write("    ");
				wPOST.write(operationIdPOST);
				wPOST.write(":\n");
				wPOST.write("      allOf:\n");
				if(BooleanUtils.isFalse(classeEstBase)) {
					wPOST.write("      - $ref: \"#/components/schemas/post");
					wPOST.write(classeNomSimpleSuperGenerique);
					wPOST.write("\"\n");
				}
				wPOST.write("      - type: object\n");
				wPOST.write("        properties:\n");

				wPATCH.write("    ");
				wPATCH.write(operationIdPATCH);
				wPATCH.write(":\n");
				wPATCH.write("      allOf:\n");
				if(BooleanUtils.isFalse(classeEstBase)) {
					wPATCH.write("      - $ref: \"#/components/schemas/patch");
					wPATCH.write(classeNomSimpleSuperGenerique);
					wPATCH.write("\"\n");
				}
				wPATCH.write("      - type: object\n");
				wPATCH.write("        properties:\n");

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
	
							wGET.write("                ");
							wGET.write(entiteVar);
							wGET.write(":\n");
	
							wGET.write("                  type: ");
							wGET.write(entiteTypeJson);
							wGET.write("\n");
	
							if(entiteFormatJson != null) {
								wGET.write("                  format: ");
								wGET.write(entiteFormatJson);
								wGET.write("\n");
							}
	
							if(entiteListeTypeJson != null) {
		
								wGET.write("                items:\n");
		
								wGET.write("                  type: ");
								wGET.write(entiteListeTypeJson);
								wGET.write("\n");
							}
	
							if(!StringUtils.equals(entiteVar, "pk")) {
								//////////
								// POST //
								//////////
		
								wPOST.write("          ");
								wPOST.write(entiteVar);
								wPOST.write(":\n");
		
								wPOST.write("            type: ");
								wPOST.write(entiteTypeJson);
								wPOST.write("\n");
		
								if(entiteFormatJson != null) {
									wPOST.write("            format: ");
									wPOST.write(entiteFormatJson);
									wPOST.write("\n");
								}
		
								if(entiteListeTypeJson != null) {
			
									wPOST.write("            items:\n");
			
									wPOST.write("              type: ");
									wPOST.write(entiteListeTypeJson);
									wPOST.write("\n");
								}
		
								///////////
								// PATCH //
								///////////
		
								wPATCH.write("          ");
								wPATCH.write("set");
								wPATCH.write(entiteVarCapitalise);
								wPATCH.write(":\n");
		
								wPATCH.write("            type: ");
								wPATCH.write(entiteTypeJson);
								wPATCH.write("\n");

								wPATCH.write("            nullable: true\n");
		
								if(entiteFormatJson != null) {
									wPATCH.write("            format: ");
									wPATCH.write(entiteFormatJson);
									wPATCH.write("\n");
								}
		
								if(entiteListeTypeJson != null) {
			
									wPATCH.write("            items:\n");
			
									wPATCH.write("              type: ");
									wPATCH.write(entiteListeTypeJson);
									wPATCH.write("\n");
								}
							}
						}
					}
				}

				wGET.flush();
				sGET.flush();
				wGET.close();
				sGET.close();

				wPOST.flush();
				sPOST.flush();
				wPOST.close();
				sPOST.close();

				wPATCH.flush();
				sPATCH.flush();
				wPATCH.close();
				sPATCH.close();

				w.s(sGET.toString());
				w.s(sPOST.toString());
				w.s(sPATCH.toString());
			}
			rechercheClasses.setStart(i.intValue() + rechercheClassesLignes);
			rechercheClassesReponse = siteContexte.getClientSolrComputate().query(rechercheClasses);
			rechercheClassesResultats = rechercheClassesReponse.getResults();
			rechercheClassesLignes = rechercheClasses.getRows();
		}
	}
}
