package org.computate.frFR.cardiaque.contexte;

import org.computate.frFR.cardiaque.couverture.Couverture;
import org.computate.frFR.cardiaque.config.ConfigSite;
import org.computate.frFR.cardiaque.cluster.Cluster;
import io.vertx.core.Vertx;
import org.apache.commons.text.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import java.lang.Integer;
import io.vertx.core.http.HttpServerResponse;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.computate.frFR.cardiaque.requete.RequeteSite;
import java.lang.Object;
import io.vertx.ext.web.api.contract.openapi3.OpenAPI3RouterFactory;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.auth.oauth2.OAuth2Auth;
import java.lang.String;
import io.vertx.ext.sql.SQLClient;

/**	
 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.frFR.cardiaque.contexte.SiteContexte&fq=classeEtendGen_indexed_boolean:true">Trouver la classe  dans Solr</a>
 * <br/>
 **/
public abstract class SiteContexteGen<DEV> extends Object {

	////////////
	// vertx_ //
	////////////

	/**	L'entité « vertx_ »
	 *	 is defined as null before being initialized. 
	 */
	protected Vertx vertx_;
	public Couverture<Vertx> vertx_Couverture = new Couverture<Vertx>().p(this).c(Vertx.class).var("vertx_").o(vertx_);

	/**	<br/>L'entité « vertx_ »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.frFR.cardiaque.contexte.SiteContexte&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:vertx_">Trouver l'entité vertx_ dans Solr</a>
	 * <br/>
	 * @param o est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _vertx_(Couverture<Vertx> o) throws Exception;

	public Vertx getVertx_() {
		return vertx_;
	}

	public void setVertx_(Vertx o) {
		this.vertx_ = o;
		this.vertx_Couverture.dejaInitialise = true;
	}
	protected SiteContexte vertx_Init() throws Exception {
		if(!vertx_Couverture.dejaInitialise) {
			_vertx_(vertx_Couverture);
			if(vertx_ == null)
				setVertx_(vertx_Couverture.o);
		}
		vertx_Couverture.dejaInitialise(true);
		return (SiteContexte)this;
	}

	///////////////
	// siteAuth_ //
	///////////////

	/**	L'entité « siteAuth_ »
	 *	 is defined as null before being initialized. 
	 */
	protected OAuth2Auth siteAuth_;
	public Couverture<OAuth2Auth> siteAuth_Couverture = new Couverture<OAuth2Auth>().p(this).c(OAuth2Auth.class).var("siteAuth_").o(siteAuth_);

	/**	<br/>L'entité « siteAuth_ »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.frFR.cardiaque.contexte.SiteContexte&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:siteAuth_">Trouver l'entité siteAuth_ dans Solr</a>
	 * <br/>
	 * @param o est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _siteAuth_(Couverture<OAuth2Auth> o) throws Exception;

	public OAuth2Auth getSiteAuth_() {
		return siteAuth_;
	}

	public void setSiteAuth_(OAuth2Auth o) {
		this.siteAuth_ = o;
		this.siteAuth_Couverture.dejaInitialise = true;
	}
	protected SiteContexte siteAuth_Init() throws Exception {
		if(!siteAuth_Couverture.dejaInitialise) {
			_siteAuth_(siteAuth_Couverture);
			if(siteAuth_ == null)
				setSiteAuth_(siteAuth_Couverture.o);
		}
		siteAuth_Couverture.dejaInitialise(true);
		return (SiteContexte)this;
	}

	///////////////////
	// usineRouteur_ //
	///////////////////

	/**	L'entité « usineRouteur_ »
	 *	 is defined as null before being initialized. 
	 */
	protected OpenAPI3RouterFactory usineRouteur_;
	public Couverture<OpenAPI3RouterFactory> usineRouteur_Couverture = new Couverture<OpenAPI3RouterFactory>().p(this).c(OpenAPI3RouterFactory.class).var("usineRouteur_").o(usineRouteur_);

	/**	<br/>L'entité « usineRouteur_ »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.frFR.cardiaque.contexte.SiteContexte&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:usineRouteur_">Trouver l'entité usineRouteur_ dans Solr</a>
	 * <br/>
	 * @param o est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _usineRouteur_(Couverture<OpenAPI3RouterFactory> o) throws Exception;

	public OpenAPI3RouterFactory getUsineRouteur_() {
		return usineRouteur_;
	}

	public void setUsineRouteur_(OpenAPI3RouterFactory o) {
		this.usineRouteur_ = o;
		this.usineRouteur_Couverture.dejaInitialise = true;
	}
	protected SiteContexte usineRouteur_Init() throws Exception {
		if(!usineRouteur_Couverture.dejaInitialise) {
			_usineRouteur_(usineRouteur_Couverture);
			if(usineRouteur_ == null)
				setUsineRouteur_(usineRouteur_Couverture.o);
		}
		usineRouteur_Couverture.dejaInitialise(true);
		return (SiteContexte)this;
	}

	////////////////
	// configSite //
	////////////////

	/**	L'entité « configSite »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut ConfigSite(). 
	 */
	protected ConfigSite configSite = new ConfigSite();
	public Couverture<ConfigSite> configSiteCouverture = new Couverture<ConfigSite>().p(this).c(ConfigSite.class).var("configSite").o(configSite);

	/**	<br/>L'entité « configSite »
	 * Il est construit avant d'être initialisé avec le constructeur par défaut ConfigSite(). 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.frFR.cardiaque.contexte.SiteContexte&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:configSite">Trouver l'entité configSite dans Solr</a>
	 * <br/>
	 * @param configSite est l'entité déjà construit. 
	 **/
	protected abstract void _configSite(ConfigSite o) throws Exception;

	public ConfigSite getConfigSite() {
		return configSite;
	}

	public void setConfigSite(ConfigSite o) {
		this.configSite = o;
		this.configSiteCouverture.dejaInitialise = true;
	}
	protected SiteContexte configSiteInit() throws Exception {
		if(!configSiteCouverture.dejaInitialise) {
			_configSite(configSite);
		}
		configSite.initLoinPourClasse(requeteSite_);
		configSiteCouverture.dejaInitialise(true);
		return (SiteContexte)this;
	}

	////////////////
	// jdbcConfig //
	////////////////

	/**	L'entité « jdbcConfig »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut JsonObject(). 
	 */
	protected JsonObject jdbcConfig = new JsonObject();
	public Couverture<JsonObject> jdbcConfigCouverture = new Couverture<JsonObject>().p(this).c(JsonObject.class).var("jdbcConfig").o(jdbcConfig);

	/**	<br/>L'entité « jdbcConfig »
	 * Il est construit avant d'être initialisé avec le constructeur par défaut JsonObject(). 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.frFR.cardiaque.contexte.SiteContexte&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:jdbcConfig">Trouver l'entité jdbcConfig dans Solr</a>
	 * <br/>
	 * @param jdbcConfig est l'entité déjà construit. 
	 **/
	protected abstract void _jdbcConfig(JsonObject o) throws Exception;

	public JsonObject getJdbcConfig() {
		return jdbcConfig;
	}

	public void setJdbcConfig(JsonObject o) {
		this.jdbcConfig = o;
		this.jdbcConfigCouverture.dejaInitialise = true;
	}
	protected SiteContexte jdbcConfigInit() throws Exception {
		if(!jdbcConfigCouverture.dejaInitialise) {
			_jdbcConfig(jdbcConfig);
		}
		jdbcConfigCouverture.dejaInitialise(true);
		return (SiteContexte)this;
	}

	///////////////
	// clientSql //
	///////////////

	/**	L'entité « clientSql »
	 *	 is defined as null before being initialized. 
	 */
	protected SQLClient clientSql;
	public Couverture<SQLClient> clientSqlCouverture = new Couverture<SQLClient>().p(this).c(SQLClient.class).var("clientSql").o(clientSql);

	/**	<br/>L'entité « clientSql »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.frFR.cardiaque.contexte.SiteContexte&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:clientSql">Trouver l'entité clientSql dans Solr</a>
	 * <br/>
	 * @param o est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _clientSql(Couverture<SQLClient> o) throws Exception;

	public SQLClient getClientSql() {
		return clientSql;
	}

	public void setClientSql(SQLClient o) {
		this.clientSql = o;
		this.clientSqlCouverture.dejaInitialise = true;
	}
	protected SiteContexte clientSqlInit() throws Exception {
		if(!clientSqlCouverture.dejaInitialise) {
			_clientSql(clientSqlCouverture);
			if(clientSql == null)
				setClientSql(clientSqlCouverture.o);
		}
		clientSqlCouverture.dejaInitialise(true);
		return (SiteContexte)this;
	}

	////////////////
	// clientSolr //
	////////////////

	/**	L'entité « clientSolr »
	 *	 is defined as null before being initialized. 
	 */
	protected HttpSolrClient clientSolr;
	public Couverture<HttpSolrClient> clientSolrCouverture = new Couverture<HttpSolrClient>().p(this).c(HttpSolrClient.class).var("clientSolr").o(clientSolr);

	/**	<br/>L'entité « clientSolr »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.frFR.cardiaque.contexte.SiteContexte&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:clientSolr">Trouver l'entité clientSolr dans Solr</a>
	 * <br/>
	 * @param o est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _clientSolr(Couverture<HttpSolrClient> o) throws Exception;

	public HttpSolrClient getClientSolr() {
		return clientSolr;
	}

	public void setClientSolr(HttpSolrClient o) {
		this.clientSolr = o;
		this.clientSolrCouverture.dejaInitialise = true;
	}
	protected SiteContexte clientSolrInit() throws Exception {
		if(!clientSolrCouverture.dejaInitialise) {
			_clientSolr(clientSolrCouverture);
			if(clientSolr == null)
				setClientSolr(clientSolrCouverture.o);
		}
		clientSolrCouverture.dejaInitialise(true);
		return (SiteContexte)this;
	}

	/////////////////////////
	// clientSolrComputate //
	/////////////////////////

	/**	L'entité « clientSolrComputate »
	 *	 is defined as null before being initialized. 
	 */
	protected HttpSolrClient clientSolrComputate;
	public Couverture<HttpSolrClient> clientSolrComputateCouverture = new Couverture<HttpSolrClient>().p(this).c(HttpSolrClient.class).var("clientSolrComputate").o(clientSolrComputate);

	/**	<br/>L'entité « clientSolrComputate »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.frFR.cardiaque.contexte.SiteContexte&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:clientSolrComputate">Trouver l'entité clientSolrComputate dans Solr</a>
	 * <br/>
	 * @param o est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _clientSolrComputate(Couverture<HttpSolrClient> o) throws Exception;

	public HttpSolrClient getClientSolrComputate() {
		return clientSolrComputate;
	}

	public void setClientSolrComputate(HttpSolrClient o) {
		this.clientSolrComputate = o;
		this.clientSolrComputateCouverture.dejaInitialise = true;
	}
	protected SiteContexte clientSolrComputateInit() throws Exception {
		if(!clientSolrComputateCouverture.dejaInitialise) {
			_clientSolrComputate(clientSolrComputateCouverture);
			if(clientSolrComputate == null)
				setClientSolrComputate(clientSolrComputateCouverture.o);
		}
		clientSolrComputateCouverture.dejaInitialise(true);
		return (SiteContexte)this;
	}

	/////////////////
	// selCryptage //
	/////////////////

	/**	L'entité « selCryptage »
	 *	 is defined as null before being initialized. 
	 */
	protected String selCryptage;
	public Couverture<String> selCryptageCouverture = new Couverture<String>().p(this).c(String.class).var("selCryptage").o(selCryptage);

	/**	<br/>L'entité « selCryptage »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.frFR.cardiaque.contexte.SiteContexte&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:selCryptage">Trouver l'entité selCryptage dans Solr</a>
	 * <br/>
	 * @param o est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _selCryptage(Couverture<String> o) throws Exception;

	public String getSelCryptage() {
		return selCryptage;
	}

	public void setSelCryptage(String o) {
		this.selCryptage = o;
		this.selCryptageCouverture.dejaInitialise = true;
	}
	protected SiteContexte selCryptageInit() throws Exception {
		if(!selCryptageCouverture.dejaInitialise) {
			_selCryptage(selCryptageCouverture);
			if(selCryptage == null)
				setSelCryptage(selCryptageCouverture.o);
		}
		selCryptageCouverture.dejaInitialise(true);
		return (SiteContexte)this;
	}

	public String solrSelCryptage() {
		return selCryptage;
	}

	public String strSelCryptage() {
		return selCryptage == null ? "" : selCryptage;
	}

	public String nomAffichageSelCryptage() {
		return null;
	}

	public String htmlTooltipSelCryptage() {
		return null;
	}

	public String htmlSelCryptage() {
		return selCryptage == null ? "" : StringEscapeUtils.escapeHtml4(strSelCryptage());
	}

	////////////////////////
	// motDePasseCryptage //
	////////////////////////

	/**	L'entité « motDePasseCryptage »
	 *	 is defined as null before being initialized. 
	 */
	protected String motDePasseCryptage;
	public Couverture<String> motDePasseCryptageCouverture = new Couverture<String>().p(this).c(String.class).var("motDePasseCryptage").o(motDePasseCryptage);

	/**	<br/>L'entité « motDePasseCryptage »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.frFR.cardiaque.contexte.SiteContexte&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:motDePasseCryptage">Trouver l'entité motDePasseCryptage dans Solr</a>
	 * <br/>
	 * @param o est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _motDePasseCryptage(Couverture<String> o) throws Exception;

	public String getMotDePasseCryptage() {
		return motDePasseCryptage;
	}

	public void setMotDePasseCryptage(String o) {
		this.motDePasseCryptage = o;
		this.motDePasseCryptageCouverture.dejaInitialise = true;
	}
	protected SiteContexte motDePasseCryptageInit() throws Exception {
		if(!motDePasseCryptageCouverture.dejaInitialise) {
			_motDePasseCryptage(motDePasseCryptageCouverture);
			if(motDePasseCryptage == null)
				setMotDePasseCryptage(motDePasseCryptageCouverture.o);
		}
		motDePasseCryptageCouverture.dejaInitialise(true);
		return (SiteContexte)this;
	}

	public String solrMotDePasseCryptage() {
		return motDePasseCryptage;
	}

	public String strMotDePasseCryptage() {
		return motDePasseCryptage == null ? "" : motDePasseCryptage;
	}

	public String nomAffichageMotDePasseCryptage() {
		return null;
	}

	public String htmlTooltipMotDePasseCryptage() {
		return null;
	}

	public String htmlMotDePasseCryptage() {
		return motDePasseCryptage == null ? "" : StringEscapeUtils.escapeHtml4(strMotDePasseCryptage());
	}

	/////////////////////////
	// jetonIdentitePaypal //
	/////////////////////////

	/**	L'entité « jetonIdentitePaypal »
	 *	 is defined as null before being initialized. 
	 */
	protected String jetonIdentitePaypal;
	public Couverture<String> jetonIdentitePaypalCouverture = new Couverture<String>().p(this).c(String.class).var("jetonIdentitePaypal").o(jetonIdentitePaypal);

	/**	<br/>L'entité « jetonIdentitePaypal »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.frFR.cardiaque.contexte.SiteContexte&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:jetonIdentitePaypal">Trouver l'entité jetonIdentitePaypal dans Solr</a>
	 * <br/>
	 * @param o est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _jetonIdentitePaypal(Couverture<String> o) throws Exception;

	public String getJetonIdentitePaypal() {
		return jetonIdentitePaypal;
	}

	public void setJetonIdentitePaypal(String o) {
		this.jetonIdentitePaypal = o;
		this.jetonIdentitePaypalCouverture.dejaInitialise = true;
	}
	protected SiteContexte jetonIdentitePaypalInit() throws Exception {
		if(!jetonIdentitePaypalCouverture.dejaInitialise) {
			_jetonIdentitePaypal(jetonIdentitePaypalCouverture);
			if(jetonIdentitePaypal == null)
				setJetonIdentitePaypal(jetonIdentitePaypalCouverture.o);
		}
		jetonIdentitePaypalCouverture.dejaInitialise(true);
		return (SiteContexte)this;
	}

	public String solrJetonIdentitePaypal() {
		return jetonIdentitePaypal;
	}

	public String strJetonIdentitePaypal() {
		return jetonIdentitePaypal == null ? "" : jetonIdentitePaypal;
	}

	public String nomAffichageJetonIdentitePaypal() {
		return null;
	}

	public String htmlTooltipJetonIdentitePaypal() {
		return null;
	}

	public String htmlJetonIdentitePaypal() {
		return jetonIdentitePaypal == null ? "" : StringEscapeUtils.escapeHtml4(strJetonIdentitePaypal());
	}

	//////////////////////
	// nombreExecuteurs //
	//////////////////////

	/**	L'entité « nombreExecuteurs »
	 *	 is defined as null before being initialized. 
	 */
	protected Integer nombreExecuteurs;
	public Couverture<Integer> nombreExecuteursCouverture = new Couverture<Integer>().p(this).c(Integer.class).var("nombreExecuteurs").o(nombreExecuteurs);

	/**	<br/>L'entité « nombreExecuteurs »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.frFR.cardiaque.contexte.SiteContexte&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:nombreExecuteurs">Trouver l'entité nombreExecuteurs dans Solr</a>
	 * <br/>
	 * @param o est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _nombreExecuteurs(Couverture<Integer> o) throws Exception;

	public Integer getNombreExecuteurs() {
		return nombreExecuteurs;
	}

	public void setNombreExecuteurs(Integer o) {
		this.nombreExecuteurs = o;
		this.nombreExecuteursCouverture.dejaInitialise = true;
	}
	public SiteContexte setNombreExecuteurs(String o) throws Exception {
		if(org.apache.commons.lang3.math.NumberUtils.isCreatable(o))
			this.nombreExecuteurs = Integer.parseInt(o);
		this.nombreExecuteursCouverture.dejaInitialise = true;
		return (SiteContexte)this;
	}
	protected SiteContexte nombreExecuteursInit() throws Exception {
		if(!nombreExecuteursCouverture.dejaInitialise) {
			_nombreExecuteurs(nombreExecuteursCouverture);
			if(nombreExecuteurs == null)
				setNombreExecuteurs(nombreExecuteursCouverture.o);
		}
		nombreExecuteursCouverture.dejaInitialise(true);
		return (SiteContexte)this;
	}

	public Integer solrNombreExecuteurs() {
		return nombreExecuteurs;
	}

	public String strNombreExecuteurs() {
		return nombreExecuteurs == null ? "" : nombreExecuteurs.toString();
	}

	public String nomAffichageNombreExecuteurs() {
		return null;
	}

	public String htmlTooltipNombreExecuteurs() {
		return null;
	}

	public String htmlNombreExecuteurs() {
		return nombreExecuteurs == null ? "" : StringEscapeUtils.escapeHtml4(strNombreExecuteurs());
	}

	//////////////////
	// requeteSite_ //
	//////////////////

	/**	L'entité « requeteSite_ »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut RequeteSite(). 
	 */
	protected RequeteSite requeteSite_ = new RequeteSite();
	public Couverture<RequeteSite> requeteSite_Couverture = new Couverture<RequeteSite>().p(this).c(RequeteSite.class).var("requeteSite_").o(requeteSite_);

	/**	<br/>L'entité « requeteSite_ »
	 * Il est construit avant d'être initialisé avec le constructeur par défaut RequeteSite(). 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.frFR.cardiaque.contexte.SiteContexte&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:requeteSite_">Trouver l'entité requeteSite_ dans Solr</a>
	 * <br/>
	 * @param requeteSite_ est l'entité déjà construit. 
	 **/
	protected abstract void _requeteSite_(RequeteSite o) throws Exception;

	public RequeteSite getRequeteSite_() {
		return requeteSite_;
	}

	public void setRequeteSite_(RequeteSite o) {
		this.requeteSite_ = o;
		this.requeteSite_Couverture.dejaInitialise = true;
	}
	protected SiteContexte requeteSite_Init() throws Exception {
		if(!requeteSite_Couverture.dejaInitialise) {
			_requeteSite_(requeteSite_);
		}
		requeteSite_Couverture.dejaInitialise(true);
		return (SiteContexte)this;
	}

	//////////////
	// initLoin //
	//////////////

	protected boolean dejaInitialiseSiteContexte = false;

	public SiteContexte initLoinSiteContexte(RequeteSite requeteSite) throws Exception {
		setRequeteSite_(requeteSite);
		initLoinSiteContexte();
		return (SiteContexte)this;
	}

	public SiteContexte initLoinSiteContexte() throws Exception {
		if(!dejaInitialiseSiteContexte) {
			dejaInitialiseSiteContexte = true;
			vertx_Init();
			siteAuth_Init();
			usineRouteur_Init();
			configSiteInit();
			jdbcConfigInit();
			clientSqlInit();
			clientSolrInit();
			clientSolrComputateInit();
			selCryptageInit();
			motDePasseCryptageInit();
			jetonIdentitePaypalInit();
			nombreExecuteursInit();
			requeteSite_Init();
		}
		return (SiteContexte)this;
	}

	public void initLoinPourClasse(RequeteSite requeteSite) throws Exception {
		initLoinSiteContexte(requeteSite);
	}

	/////////////////
	// requeteSite //
	/////////////////

	public void requeteSiteSiteContexte(RequeteSite requeteSite) throws Exception {
		configSite.setRequeteSite_(requeteSite);
	}

	public void requeteSitePourClasse(RequeteSite requeteSite) throws Exception {
		requeteSiteSiteContexte(requeteSite);
	}

	/////////////
	// obtenir //
	/////////////

	public Object obtenirPourClasse(String var) throws Exception {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtenirSiteContexte(v);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.obtenirPourClasse(v);
			}
		}
		return o;
	}
	public Object obtenirSiteContexte(String var) throws Exception {
		SiteContexte oSiteContexte = (SiteContexte)this;
		switch(var) {
			case "vertx_":
				return oSiteContexte.vertx_;
			case "siteAuth_":
				return oSiteContexte.siteAuth_;
			case "usineRouteur_":
				return oSiteContexte.usineRouteur_;
			case "configSite":
				return oSiteContexte.configSite;
			case "jdbcConfig":
				return oSiteContexte.jdbcConfig;
			case "clientSql":
				return oSiteContexte.clientSql;
			case "clientSolr":
				return oSiteContexte.clientSolr;
			case "clientSolrComputate":
				return oSiteContexte.clientSolrComputate;
			case "selCryptage":
				return oSiteContexte.selCryptage;
			case "motDePasseCryptage":
				return oSiteContexte.motDePasseCryptage;
			case "jetonIdentitePaypal":
				return oSiteContexte.jetonIdentitePaypal;
			case "nombreExecuteurs":
				return oSiteContexte.nombreExecuteurs;
			case "requeteSite_":
				return oSiteContexte.requeteSite_;
			default:
				return null;
		}
	}

	///////////////
	// attribuer //
	///////////////

	public boolean attribuerPourClasse(String var, Object val) throws Exception {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = attribuerSiteContexte(v, val);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.attribuerPourClasse(v, val);
			}
		}
		return o != null;
	}
	public Object attribuerSiteContexte(String var, Object val) throws Exception {
		SiteContexte oSiteContexte = (SiteContexte)this;
		switch(var) {
			default:
				return null;
		}
	}
}
