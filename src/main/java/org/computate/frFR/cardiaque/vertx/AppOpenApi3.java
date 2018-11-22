package org.computate.frFR.cardiaque.vertx;

import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.StringEscapeUtils;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrQuery.ORDER;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.util.ClientUtils;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.computate.frFR.cardiaque.config.ConfigSite;
import org.computate.frFR.cardiaque.contexte.SiteContexte;
import org.computate.frFR.cardiaque.couverture.Couverture;
import org.computate.frFR.cardiaque.recherche.ResultatRecherche;
import org.computate.frFR.cardiaque.requete.RequeteSite;

public class AppOpenApi3 extends AppOpenApiGen<Object> {

	protected void _requeteSite_(Couverture<RequeteSite> c) throws Exception {
	}

	protected void _siteContexte(SiteContexte o) throws Exception {
	}

	protected void _configSite(Couverture<ConfigSite> c) throws Exception {
		c.o(siteContexte.getConfigSite());
	}

	public static void main(String[] args) throws Exception {
		AppOpenApi3 api = new AppOpenApi3();
		api.initLoinAppOpenApi();
		api.genererOpenApi();
	}

	public void genererOpenApi() throws Exception {
		ConfigSite configSite = siteContexte.getConfigSite();
		String appliChemin = configSite.getAppliChemin();
		String swaggerYamlChemin = appliChemin + "/src/main/resources/openapi3.yaml";
		File swaggerYamlFichier = new File(swaggerYamlChemin);
		PrintWriter w = new PrintWriter(swaggerYamlFichier);

		genererChemins(w);
		genererCorpsRequetes(w);
		genererSchemas(w);

		w.flush();
		w.close();
	}

	public void genererChemins(PrintWriter w) throws Exception {

		w.write("openapi: \"");
		w.write(StringEscapeUtils.escapeJava(configSite.getOpenApiVersion()));
		w.write("\"\n");

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

		w.write("  termsOfService: \"");
		w.write(StringEscapeUtils.escapeJava(configSite.getApiTermsService()));
		w.write("\"\n");

		w.write("  contact:\n");

		w.write("    email: \"");
		w.write(StringEscapeUtils.escapeJava(configSite.getApiContactMail()));
		w.write("\"\n");

		w.write("  license:\n");

		w.write("    name: \"");
		w.write(StringEscapeUtils.escapeJava(configSite.getApiLicenceNom()));
		w.write("\"\n");

		w.write("    url: \"");
		w.write(StringEscapeUtils.escapeJava(configSite.getApiLicenceUrl()));
		w.write("\"\n");

		w.write("servers:\n");

		w.write("  - url: \"");
		w.write(StringEscapeUtils.escapeJava(configSite.getUrlDomaineBase()));
		w.write("\"\n");
		w.write("    description: \"");
		w.write("\"\n");

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
				String operationIdPatch = "patch" + classeNomSimple;

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

				w.write("      description: \"");
				w.write("\"\n");

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
				w.write("        schema:\n");
				w.write("          type: string\n");
				w.write("          default: \"**:**\"\n");
				w.write("        examples:\n");
				w.write("          default:\n");
				w.write("            value: \"&ast;:&ast;\"\n");
				w.write("            summary: \"This is the default solr query. \"\n");
				w.write("      - in: \"query\"\n");
				w.write("        name: \"fq\"\n");
				w.write("        description: \"\"\n");
				w.write("        required: false\n");
				w.write("        schema:\n");
				w.write("          type: array\n");
				w.write("          items:\n");
				w.write("            type: string\n");
				w.write("      - in: \"query\"\n");
				w.write("        name: \"fl\"\n");
				w.write("        description: \"\"\n");
				w.write("        required: false\n");
				w.write("        schema:\n");
				w.write("          type: string\n");
				w.write("      - in: \"query\"\n");
				w.write("        name: \"start\"\n");
				w.write("        description: \"\"\n");
				w.write("        required: false\n");
				w.write("        schema:\n");
				w.write("          type: integer\n");
				w.write("          default: 0\n");
				w.write("          minimum: 0\n");
				w.write("      - in: \"query\"\n");
				w.write("        name: \"rows\"\n");
				w.write("        description: \"\"\n");
				w.write("        required: false\n");
				w.write("        schema:\n");
				w.write("          type: integer\n");
				w.write("          default: 10\n");
				w.write("          minimum: 1\n");
				w.write("      responses:\n");
				w.write("        '200':\n");
				w.write("          description: \"");
				w.write("\"\n");
				w.write("          content:\n");
				w.write("            application/json:\n");
				w.write("              schema:\n");

				w.write("                $ref: '#/components/schemas/");
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

				w.write("      description: \"");
				w.write("\"\n");

				w.write("      requestBody:\n");
				w.write("        description: \"\"\n");
				w.write("        required: true\n");
				w.write("        content:\n");
				w.write("          application/json:\n");
				w.write("            schema:\n");

				w.write("              $ref: '#/components/schemas/");
				w.write(operationIdPost);
				w.write("'\n");

				w.write("      responses:\n");
				w.write("        '201':\n");
				w.write("          description: \"");
				w.write("\"\n");
				w.write("          content:\n");
				w.write("            application/json:\n");
				w.write("              schema:\n");

				w.write("                $ref: '#/components/schemas/");
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

				w.write("      description: \"");
				w.write("\"\n");

				w.write("      parameters:\n");
				w.write("      - in: \"query\"\n");
				w.write("        name: \"q\"\n");
				w.write("        description: \"\"\n");
				w.write("        required: false\n");
				w.write("        schema:\n");
				w.write("          type: string\n");
				w.write("        examples:\n");
				w.write("          default:\n");
				w.write("            value: \"*:*\"\n");
				w.write("            summary: \"This is the default solr query. \"\n");
				w.write("      - in: \"query\"\n");
				w.write("        name: \"fq\"\n");
				w.write("        description: \"\"\n");
				w.write("        required: false\n");
				w.write("        schema:\n");
				w.write("          type: string\n");
				w.write("      - in: \"query\"\n");
				w.write("        name: \"fl\"\n");
				w.write("        description: \"\"\n");
				w.write("        required: false\n");
				w.write("        schema:\n");
				w.write("          type: string\n");
				w.write("      - in: \"query\"\n");
				w.write("        name: \"start\"\n");
				w.write("        description: \"\"\n");
				w.write("        required: false\n");
				w.write("        schema:\n");
				w.write("          type: integer\n");
				w.write("          minimum: 0\n");
				w.write("      - in: \"query\"\n");
				w.write("        name: \"rows\"\n");
				w.write("        description: \"\"\n");
				w.write("        required: false\n");
				w.write("        schema:\n");
				w.write("          type: integer\n");
				w.write("          minimum: 1\n");

				w.write("      requestBody:\n");
				w.write("        description: \"\"\n");
				w.write("        required: true\n");
				w.write("        content:\n");
				w.write("          application/json:\n");
				w.write("            schema:\n");

				w.write("              $ref: '#/components/schemas/");
				w.write(operationIdPatch);
				w.write("'\n");

				w.write("      responses:\n");
				w.write("        '200':\n");
				w.write("          description: \"");
				w.write("\"\n");
				w.write("          content:\n");
				w.write("            application/json:\n");
				w.write("              schema:\n");

				w.write("                $ref: '#/components/schemas/");
				w.write(operationIdGet);
				w.write("'\n");
			}
			rechercheClasses.setStart(i.intValue() + rechercheClassesLignes);
			rechercheClassesReponse = siteContexte.getClientSolrComputate().query(rechercheClasses);
			rechercheClassesResultats = rechercheClassesReponse.getResults();
			rechercheClassesLignes = rechercheClasses.getRows();
		}
	}

	public void genererCorpsRequetes(PrintWriter w) throws Exception {

		w.write("components:\n");

		w.write("  requestBodies:\n");

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
				String classeNomSimple = (String)documentSolr.get("classeNomSimple_frFR_stored_string");
				String operationIdGet = "get" + classeNomSimple;
				String operationIdPost = "post" + classeNomSimple;
				String operationIdPatch = "patch" + classeNomSimple;

				/////////
				// GET //
				/////////
				w.write("    ");
				w.write(operationIdGet);
				w.write(":\n");

				w.write("      required: true\n");

				w.write("      description: \"");
				w.write("\"\n");

				w.write("      content:\n");
				w.write("        application/json:\n");
				w.write("          schema:\n");

				w.write("            $ref: '#/components/schemas/");
				w.write(operationIdGet);
				w.write("'\n");

				//////////
				// POST //
				//////////
				w.write("    ");
				w.write(operationIdPost);
				w.write(":\n");

				w.write("      required: true\n");

				w.write("      description: \"");
				w.write("\"\n");

				w.write("      content:\n");
				w.write("        application/json:\n");
				w.write("          schema:\n");

				w.write("            $ref: '#/components/schemas/");
				w.write(operationIdPost);
				w.write("'\n");

				///////////
				// PATCH //
				///////////
				w.write("    ");
				w.write(operationIdPatch);
				w.write(":\n");

				w.write("      required: true\n");

				w.write("      description: \"");
				w.write("\"\n");

				w.write("      content:\n");
				w.write("        application/json:\n");
				w.write("          schema:\n");

				w.write("            $ref: '#/components/schemas/");
				w.write(operationIdPatch);
				w.write("'\n");
			}
			rechercheClasses.setStart(i.intValue() + rechercheClassesLignes);
			rechercheClassesReponse = siteContexte.getClientSolrComputate().query(rechercheClasses);
			rechercheClassesResultats = rechercheClassesReponse.getResults();
			rechercheClassesLignes = rechercheClasses.getRows();
		}
	}

	public void genererSchemas(PrintWriter w) throws Exception {

		w.write("  schemas:\n");

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
				PrintWriter wGet = new PrintWriter(sGet);

				StringWriter sPost = new StringWriter();
				PrintWriter wPost = new PrintWriter(sPost);

				StringWriter sPatch = new StringWriter();
				PrintWriter wPatch = new PrintWriter(sPatch);

				wGet.write("    ");
				wGet.write(operationIdGet);
				wGet.write(":\n");
				wGet.write("      allOf:\n");
				if(BooleanUtils.isFalse(classeEstBase)) {
					wGet.write("      - $ref: \"#/components/schemas/get");
					wGet.write(classeNomSimpleSuperGenerique);
					wGet.write("\"\n");
				}
				wGet.write("      - type: object\n");
				wGet.write("        properties:\n");
				wGet.write("          numFound:\n");
				wGet.write("            type: number\n");
				wGet.write("            default: 1\n");
				wGet.write("          start:\n");
				wGet.write("            type: number\n");
				wGet.write("            default: 0\n");
				wGet.write("          rows:\n");
				wGet.write("            type: number\n");
				wGet.write("            default: 10\n");
				wGet.write("          docs:\n");
				wGet.write("            type: array\n");
				wGet.write("            items:\n");
				wGet.write("              type: object\n");
				wGet.write("              properties:\n");

				wPost.write("    ");
				wPost.write(operationIdPost);
				wPost.write(":\n");
				wPost.write("      allOf:\n");
				if(BooleanUtils.isFalse(classeEstBase)) {
					wPost.write("      - $ref: \"#/components/schemas/post");
					wPost.write(classeNomSimpleSuperGenerique);
					wPost.write("\"\n");
				}
				wPost.write("      - type: object\n");
				wPost.write("        properties:\n");

				wPatch.write("    ");
				wPatch.write(operationIdPatch);
				wPatch.write(":\n");
				wPatch.write("      allOf:\n");
				if(BooleanUtils.isFalse(classeEstBase)) {
					wPatch.write("      - $ref: \"#/components/schemas/patch");
					wPatch.write(classeNomSimpleSuperGenerique);
					wPatch.write("\"\n");
				}
				wPatch.write("      - type: object\n");
				wPatch.write("        properties:\n");

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
	
							wGet.write("                ");
							wGet.write(entiteVar);
							wGet.write(":\n");
	
							wGet.write("                  type: ");
							wGet.write(entiteTypeJson);
							wGet.write("\n");
	
							if(entiteFormatJson != null) {
								wGet.write("                  format: ");
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
		
								wPost.write("          ");
								wPost.write(entiteVar);
								wPost.write(":\n");
		
								wPost.write("            type: ");
								wPost.write(entiteTypeJson);
								wPost.write("\n");
		
								if(entiteFormatJson != null) {
									wPost.write("            format: ");
									wPost.write(entiteFormatJson);
									wPost.write("\n");
								}
		
								if(entiteListeTypeJson != null) {
			
									wPost.write("            items:\n");
			
									wPost.write("              type: ");
									wPost.write(entiteListeTypeJson);
									wPost.write("\n");
								}
		
								///////////
								// PATCH //
								///////////
		
								wPatch.write("          ");
								wPatch.write("set");
								wPatch.write(entiteVarCapitalise);
								wPatch.write(":\n");
		
								wPatch.write("            type: ");
								wPatch.write(entiteTypeJson);
								wPatch.write("\n");

								wPatch.write("            nullable: true\n");
		
								if(entiteFormatJson != null) {
									wPatch.write("            format: ");
									wPatch.write(entiteFormatJson);
									wPatch.write("\n");
								}
		
								if(entiteListeTypeJson != null) {
			
									wPatch.write("            items:\n");
			
									wPatch.write("              type: ");
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

				wPatch.flush();
				sPatch.flush();
				wPatch.close();
				sPatch.close();

				w.write(sGet.toString());
				w.write(sPost.toString());
				w.write(sPatch.toString());
			}
			rechercheClasses.setStart(i.intValue() + rechercheClassesLignes);
			rechercheClassesReponse = siteContexte.getClientSolrComputate().query(rechercheClasses);
			rechercheClassesResultats = rechercheClassesReponse.getResults();
			rechercheClassesLignes = rechercheClasses.getRows();
		}
	}
}
