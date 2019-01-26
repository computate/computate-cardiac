package org.computate.frFR.cardiaque.vertx;

import org.computate.frFR.cardiaque.couverture.Couverture;
import org.computate.frFR.cardiaque.config.ConfigSite;
import org.computate.frFR.cardiaque.cluster.Cluster;
import org.apache.commons.text.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import java.lang.Integer;
import java.io.File;
import java.util.Objects;
import org.computate.frFR.cardiaque.contexte.SiteContexte;
import org.computate.frFR.cardiaque.requete.RequeteSite;
import org.computate.frFR.cardiaque.ecrivain.ToutEcrivain;
import java.lang.Object;
import java.lang.String;

/**	
 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.frFR.cardiaque.vertx.AppSwagger2&fq=classeEtendGen_indexed_boolean:true">Trouver la classe  dans Solr</a>
 * <br/>
 **/
public abstract class AppSwagger2Gen<DEV> extends Object {

	//////////////////
	// requeteSite_ //
	//////////////////

	/**	L'entité « requeteSite_ »
	 *	 is defined as null before being initialized. 
	 */
	protected RequeteSite requeteSite_;
	public Couverture<RequeteSite> requeteSite_Couverture = new Couverture<RequeteSite>().p(this).c(RequeteSite.class).var("requeteSite_").o(requeteSite_);

	/**	<br/>L'entité « requeteSite_ »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.frFR.cardiaque.vertx.AppSwagger2&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:requeteSite_">Trouver l'entité requeteSite_ dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _requeteSite_(Couverture<RequeteSite> c);

	public RequeteSite getRequeteSite_() {
		return requeteSite_;
	}

	public void setRequeteSite_(RequeteSite requeteSite_) {
		this.requeteSite_ = requeteSite_;
		this.requeteSite_Couverture.dejaInitialise = true;
	}
	protected AppSwagger2 requeteSite_Init() {
		if(!requeteSite_Couverture.dejaInitialise) {
			_requeteSite_(requeteSite_Couverture);
			if(requeteSite_ == null)
				setRequeteSite_(requeteSite_Couverture.o);
		}
		requeteSite_Couverture.dejaInitialise(true);
		return (AppSwagger2)this;
	}

	//////////////////
	// siteContexte //
	//////////////////

	/**	L'entité « siteContexte »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut SiteContexte(). 
	 */
	protected SiteContexte siteContexte = new SiteContexte();
	public Couverture<SiteContexte> siteContexteCouverture = new Couverture<SiteContexte>().p(this).c(SiteContexte.class).var("siteContexte").o(siteContexte);

	/**	<br/>L'entité « siteContexte »
	 * Il est construit avant d'être initialisé avec le constructeur par défaut SiteContexte(). 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.frFR.cardiaque.vertx.AppSwagger2&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:siteContexte">Trouver l'entité siteContexte dans Solr</a>
	 * <br/>
	 * @param siteContexte est l'entité déjà construit. 
	 **/
	protected abstract void _siteContexte(SiteContexte o);

	public SiteContexte getSiteContexte() {
		return siteContexte;
	}

	public void setSiteContexte(SiteContexte siteContexte) {
		this.siteContexte = siteContexte;
		this.siteContexteCouverture.dejaInitialise = true;
	}
	protected AppSwagger2 siteContexteInit() {
		if(!siteContexteCouverture.dejaInitialise) {
			_siteContexte(siteContexte);
		}
		siteContexte.initLoinPourClasse(requeteSite_);
		siteContexteCouverture.dejaInitialise(true);
		return (AppSwagger2)this;
	}

	////////////////
	// configSite //
	////////////////

	/**	L'entité « configSite »
	 *	 is defined as null before being initialized. 
	 */
	protected ConfigSite configSite;
	public Couverture<ConfigSite> configSiteCouverture = new Couverture<ConfigSite>().p(this).c(ConfigSite.class).var("configSite").o(configSite);

	/**	<br/>L'entité « configSite »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.frFR.cardiaque.vertx.AppSwagger2&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:configSite">Trouver l'entité configSite dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _configSite(Couverture<ConfigSite> c);

	public ConfigSite getConfigSite() {
		return configSite;
	}

	public void setConfigSite(ConfigSite configSite) {
		this.configSite = configSite;
		this.configSiteCouverture.dejaInitialise = true;
	}
	protected AppSwagger2 configSiteInit() {
		if(!configSiteCouverture.dejaInitialise) {
			_configSite(configSiteCouverture);
			if(configSite == null)
				setConfigSite(configSiteCouverture.o);
		}
		if(configSite != null)
			configSite.initLoinPourClasse(requeteSite_);
		configSiteCouverture.dejaInitialise(true);
		return (AppSwagger2)this;
	}

	/////////////////
	// appliChemin //
	/////////////////

	/**	L'entité « appliChemin »
	 *	 is defined as null before being initialized. 
	 */
	protected String appliChemin;
	public Couverture<String> appliCheminCouverture = new Couverture<String>().p(this).c(String.class).var("appliChemin").o(appliChemin);

	/**	<br/>L'entité « appliChemin »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.frFR.cardiaque.vertx.AppSwagger2&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:appliChemin">Trouver l'entité appliChemin dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _appliChemin(Couverture<String> c);

	public String getAppliChemin() {
		return appliChemin;
	}

	public void setAppliChemin(String appliChemin) {
		this.appliChemin = appliChemin;
		this.appliCheminCouverture.dejaInitialise = true;
	}
	protected AppSwagger2 appliCheminInit() {
		if(!appliCheminCouverture.dejaInitialise) {
			_appliChemin(appliCheminCouverture);
			if(appliChemin == null)
				setAppliChemin(appliCheminCouverture.o);
		}
		appliCheminCouverture.dejaInitialise(true);
		return (AppSwagger2)this;
	}

	public String solrAppliChemin() {
		return appliChemin;
	}

	public String strAppliChemin() {
		return appliChemin == null ? "" : appliChemin;
	}

	public String nomAffichageAppliChemin() {
		return null;
	}

	public String htmTooltipAppliChemin() {
		return null;
	}

	public String htmAppliChemin() {
		return appliChemin == null ? "" : StringEscapeUtils.escapeHtml4(strAppliChemin());
	}

	////////////////////
	// openApiVersion //
	////////////////////

	/**	L'entité « openApiVersion »
	 *	 is defined as null before being initialized. 
	 */
	protected String openApiVersion;
	public Couverture<String> openApiVersionCouverture = new Couverture<String>().p(this).c(String.class).var("openApiVersion").o(openApiVersion);

	/**	<br/>L'entité « openApiVersion »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.frFR.cardiaque.vertx.AppSwagger2&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:openApiVersion">Trouver l'entité openApiVersion dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _openApiVersion(Couverture<String> c);

	public String getOpenApiVersion() {
		return openApiVersion;
	}

	public void setOpenApiVersion(String openApiVersion) {
		this.openApiVersion = openApiVersion;
		this.openApiVersionCouverture.dejaInitialise = true;
	}
	protected AppSwagger2 openApiVersionInit() {
		if(!openApiVersionCouverture.dejaInitialise) {
			_openApiVersion(openApiVersionCouverture);
			if(openApiVersion == null)
				setOpenApiVersion(openApiVersionCouverture.o);
		}
		openApiVersionCouverture.dejaInitialise(true);
		return (AppSwagger2)this;
	}

	public String solrOpenApiVersion() {
		return openApiVersion;
	}

	public String strOpenApiVersion() {
		return openApiVersion == null ? "" : openApiVersion;
	}

	public String nomAffichageOpenApiVersion() {
		return null;
	}

	public String htmTooltipOpenApiVersion() {
		return null;
	}

	public String htmOpenApiVersion() {
		return openApiVersion == null ? "" : StringEscapeUtils.escapeHtml4(strOpenApiVersion());
	}

	//////////////////////////
	// openApiVersionNumero //
	//////////////////////////

	/**	L'entité « openApiVersionNumero »
	 *	 is defined as null before being initialized. 
	 */
	protected Integer openApiVersionNumero;
	public Couverture<Integer> openApiVersionNumeroCouverture = new Couverture<Integer>().p(this).c(Integer.class).var("openApiVersionNumero").o(openApiVersionNumero);

	/**	<br/>L'entité « openApiVersionNumero »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.frFR.cardiaque.vertx.AppSwagger2&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:openApiVersionNumero">Trouver l'entité openApiVersionNumero dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _openApiVersionNumero(Couverture<Integer> c);

	public Integer getOpenApiVersionNumero() {
		return openApiVersionNumero;
	}

	public void setOpenApiVersionNumero(Integer openApiVersionNumero) {
		this.openApiVersionNumero = openApiVersionNumero;
		this.openApiVersionNumeroCouverture.dejaInitialise = true;
	}
	public AppSwagger2 setOpenApiVersionNumero(String o) {
		if(org.apache.commons.lang3.math.NumberUtils.isCreatable(o))
			this.openApiVersionNumero = Integer.parseInt(o);
		this.openApiVersionNumeroCouverture.dejaInitialise = true;
		return (AppSwagger2)this;
	}
	protected AppSwagger2 openApiVersionNumeroInit() {
		if(!openApiVersionNumeroCouverture.dejaInitialise) {
			_openApiVersionNumero(openApiVersionNumeroCouverture);
			if(openApiVersionNumero == null)
				setOpenApiVersionNumero(openApiVersionNumeroCouverture.o);
		}
		openApiVersionNumeroCouverture.dejaInitialise(true);
		return (AppSwagger2)this;
	}

	public Integer solrOpenApiVersionNumero() {
		return openApiVersionNumero;
	}

	public String strOpenApiVersionNumero() {
		return openApiVersionNumero == null ? "" : openApiVersionNumero.toString();
	}

	public String nomAffichageOpenApiVersionNumero() {
		return null;
	}

	public String htmTooltipOpenApiVersionNumero() {
		return null;
	}

	public String htmOpenApiVersionNumero() {
		return openApiVersionNumero == null ? "" : StringEscapeUtils.escapeHtml4(strOpenApiVersionNumero());
	}

	////////////////
	// tabsSchema //
	////////////////

	/**	L'entité « tabsSchema »
	 *	 is defined as null before being initialized. 
	 */
	protected Integer tabsSchema;
	public Couverture<Integer> tabsSchemaCouverture = new Couverture<Integer>().p(this).c(Integer.class).var("tabsSchema").o(tabsSchema);

	/**	<br/>L'entité « tabsSchema »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.frFR.cardiaque.vertx.AppSwagger2&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:tabsSchema">Trouver l'entité tabsSchema dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _tabsSchema(Couverture<Integer> c);

	public Integer getTabsSchema() {
		return tabsSchema;
	}

	public void setTabsSchema(Integer tabsSchema) {
		this.tabsSchema = tabsSchema;
		this.tabsSchemaCouverture.dejaInitialise = true;
	}
	public AppSwagger2 setTabsSchema(String o) {
		if(org.apache.commons.lang3.math.NumberUtils.isCreatable(o))
			this.tabsSchema = Integer.parseInt(o);
		this.tabsSchemaCouverture.dejaInitialise = true;
		return (AppSwagger2)this;
	}
	protected AppSwagger2 tabsSchemaInit() {
		if(!tabsSchemaCouverture.dejaInitialise) {
			_tabsSchema(tabsSchemaCouverture);
			if(tabsSchema == null)
				setTabsSchema(tabsSchemaCouverture.o);
		}
		tabsSchemaCouverture.dejaInitialise(true);
		return (AppSwagger2)this;
	}

	public Integer solrTabsSchema() {
		return tabsSchema;
	}

	public String strTabsSchema() {
		return tabsSchema == null ? "" : tabsSchema.toString();
	}

	public String nomAffichageTabsSchema() {
		return null;
	}

	public String htmTooltipTabsSchema() {
		return null;
	}

	public String htmTabsSchema() {
		return tabsSchema == null ? "" : StringEscapeUtils.escapeHtml4(strTabsSchema());
	}

	////////////////
	// apiVersion //
	////////////////

	/**	L'entité « apiVersion »
	 *	 is defined as null before being initialized. 
	 */
	protected String apiVersion;
	public Couverture<String> apiVersionCouverture = new Couverture<String>().p(this).c(String.class).var("apiVersion").o(apiVersion);

	/**	<br/>L'entité « apiVersion »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.frFR.cardiaque.vertx.AppSwagger2&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:apiVersion">Trouver l'entité apiVersion dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _apiVersion(Couverture<String> c);

	public String getApiVersion() {
		return apiVersion;
	}

	public void setApiVersion(String apiVersion) {
		this.apiVersion = apiVersion;
		this.apiVersionCouverture.dejaInitialise = true;
	}
	protected AppSwagger2 apiVersionInit() {
		if(!apiVersionCouverture.dejaInitialise) {
			_apiVersion(apiVersionCouverture);
			if(apiVersion == null)
				setApiVersion(apiVersionCouverture.o);
		}
		apiVersionCouverture.dejaInitialise(true);
		return (AppSwagger2)this;
	}

	public String solrApiVersion() {
		return apiVersion;
	}

	public String strApiVersion() {
		return apiVersion == null ? "" : apiVersion;
	}

	public String nomAffichageApiVersion() {
		return null;
	}

	public String htmTooltipApiVersion() {
		return null;
	}

	public String htmApiVersion() {
		return apiVersion == null ? "" : StringEscapeUtils.escapeHtml4(strApiVersion());
	}

	///////////////////////
	// openApiYamlChemin //
	///////////////////////

	/**	L'entité « openApiYamlChemin »
	 *	 is defined as null before being initialized. 
	 */
	protected String openApiYamlChemin;
	public Couverture<String> openApiYamlCheminCouverture = new Couverture<String>().p(this).c(String.class).var("openApiYamlChemin").o(openApiYamlChemin);

	/**	<br/>L'entité « openApiYamlChemin »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.frFR.cardiaque.vertx.AppSwagger2&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:openApiYamlChemin">Trouver l'entité openApiYamlChemin dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _openApiYamlChemin(Couverture<String> c);

	public String getOpenApiYamlChemin() {
		return openApiYamlChemin;
	}

	public void setOpenApiYamlChemin(String openApiYamlChemin) {
		this.openApiYamlChemin = openApiYamlChemin;
		this.openApiYamlCheminCouverture.dejaInitialise = true;
	}
	protected AppSwagger2 openApiYamlCheminInit() {
		if(!openApiYamlCheminCouverture.dejaInitialise) {
			_openApiYamlChemin(openApiYamlCheminCouverture);
			if(openApiYamlChemin == null)
				setOpenApiYamlChemin(openApiYamlCheminCouverture.o);
		}
		openApiYamlCheminCouverture.dejaInitialise(true);
		return (AppSwagger2)this;
	}

	public String solrOpenApiYamlChemin() {
		return openApiYamlChemin;
	}

	public String strOpenApiYamlChemin() {
		return openApiYamlChemin == null ? "" : openApiYamlChemin;
	}

	public String nomAffichageOpenApiYamlChemin() {
		return null;
	}

	public String htmTooltipOpenApiYamlChemin() {
		return null;
	}

	public String htmOpenApiYamlChemin() {
		return openApiYamlChemin == null ? "" : StringEscapeUtils.escapeHtml4(strOpenApiYamlChemin());
	}

	////////////////////////
	// openApiYamlFichier //
	////////////////////////

	/**	L'entité « openApiYamlFichier »
	 *	 is defined as null before being initialized. 
	 */
	protected File openApiYamlFichier;
	public Couverture<File> openApiYamlFichierCouverture = new Couverture<File>().p(this).c(File.class).var("openApiYamlFichier").o(openApiYamlFichier);

	/**	<br/>L'entité « openApiYamlFichier »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.frFR.cardiaque.vertx.AppSwagger2&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:openApiYamlFichier">Trouver l'entité openApiYamlFichier dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _openApiYamlFichier(Couverture<File> c);

	public File getOpenApiYamlFichier() {
		return openApiYamlFichier;
	}

	public void setOpenApiYamlFichier(File openApiYamlFichier) {
		this.openApiYamlFichier = openApiYamlFichier;
		this.openApiYamlFichierCouverture.dejaInitialise = true;
	}
	protected AppSwagger2 openApiYamlFichierInit() {
		if(!openApiYamlFichierCouverture.dejaInitialise) {
			_openApiYamlFichier(openApiYamlFichierCouverture);
			if(openApiYamlFichier == null)
				setOpenApiYamlFichier(openApiYamlFichierCouverture.o);
		}
		openApiYamlFichierCouverture.dejaInitialise(true);
		return (AppSwagger2)this;
	}

	///////
	// w //
	///////

	/**	L'entité « w »
	 *	 is defined as null before being initialized. 
	 */
	protected ToutEcrivain w;
	public Couverture<ToutEcrivain> wCouverture = new Couverture<ToutEcrivain>().p(this).c(ToutEcrivain.class).var("w").o(w);

	/**	<br/>L'entité « w »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.frFR.cardiaque.vertx.AppSwagger2&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:w">Trouver l'entité w dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _w(Couverture<ToutEcrivain> c);

	public ToutEcrivain getW() {
		return w;
	}

	public void setW(ToutEcrivain w) {
		this.w = w;
		this.wCouverture.dejaInitialise = true;
	}
	protected AppSwagger2 wInit() {
		if(!wCouverture.dejaInitialise) {
			_w(wCouverture);
			if(w == null)
				setW(wCouverture.o);
		}
		if(w != null)
			w.initLoinPourClasse(requeteSite_);
		wCouverture.dejaInitialise(true);
		return (AppSwagger2)this;
	}

	//////////////
	// wChemins //
	//////////////

	/**	L'entité « wChemins »
	 *	 is defined as null before being initialized. 
	 */
	protected ToutEcrivain wChemins;
	public Couverture<ToutEcrivain> wCheminsCouverture = new Couverture<ToutEcrivain>().p(this).c(ToutEcrivain.class).var("wChemins").o(wChemins);

	/**	<br/>L'entité « wChemins »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.frFR.cardiaque.vertx.AppSwagger2&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:wChemins">Trouver l'entité wChemins dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _wChemins(Couverture<ToutEcrivain> c);

	public ToutEcrivain getWChemins() {
		return wChemins;
	}

	public void setWChemins(ToutEcrivain wChemins) {
		this.wChemins = wChemins;
		this.wCheminsCouverture.dejaInitialise = true;
	}
	protected AppSwagger2 wCheminsInit() {
		if(!wCheminsCouverture.dejaInitialise) {
			_wChemins(wCheminsCouverture);
			if(wChemins == null)
				setWChemins(wCheminsCouverture.o);
		}
		if(wChemins != null)
			wChemins.initLoinPourClasse(requeteSite_);
		wCheminsCouverture.dejaInitialise(true);
		return (AppSwagger2)this;
	}

	////////////////////
	// wCorpsRequetes //
	////////////////////

	/**	L'entité « wCorpsRequetes »
	 *	 is defined as null before being initialized. 
	 */
	protected ToutEcrivain wCorpsRequetes;
	public Couverture<ToutEcrivain> wCorpsRequetesCouverture = new Couverture<ToutEcrivain>().p(this).c(ToutEcrivain.class).var("wCorpsRequetes").o(wCorpsRequetes);

	/**	<br/>L'entité « wCorpsRequetes »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.frFR.cardiaque.vertx.AppSwagger2&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:wCorpsRequetes">Trouver l'entité wCorpsRequetes dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _wCorpsRequetes(Couverture<ToutEcrivain> c);

	public ToutEcrivain getWCorpsRequetes() {
		return wCorpsRequetes;
	}

	public void setWCorpsRequetes(ToutEcrivain wCorpsRequetes) {
		this.wCorpsRequetes = wCorpsRequetes;
		this.wCorpsRequetesCouverture.dejaInitialise = true;
	}
	protected AppSwagger2 wCorpsRequetesInit() {
		if(!wCorpsRequetesCouverture.dejaInitialise) {
			_wCorpsRequetes(wCorpsRequetesCouverture);
			if(wCorpsRequetes == null)
				setWCorpsRequetes(wCorpsRequetesCouverture.o);
		}
		if(wCorpsRequetes != null)
			wCorpsRequetes.initLoinPourClasse(requeteSite_);
		wCorpsRequetesCouverture.dejaInitialise(true);
		return (AppSwagger2)this;
	}

	//////////////
	// wSchemas //
	//////////////

	/**	L'entité « wSchemas »
	 *	 is defined as null before being initialized. 
	 */
	protected ToutEcrivain wSchemas;
	public Couverture<ToutEcrivain> wSchemasCouverture = new Couverture<ToutEcrivain>().p(this).c(ToutEcrivain.class).var("wSchemas").o(wSchemas);

	/**	<br/>L'entité « wSchemas »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.frFR.cardiaque.vertx.AppSwagger2&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:wSchemas">Trouver l'entité wSchemas dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _wSchemas(Couverture<ToutEcrivain> c);

	public ToutEcrivain getWSchemas() {
		return wSchemas;
	}

	public void setWSchemas(ToutEcrivain wSchemas) {
		this.wSchemas = wSchemas;
		this.wSchemasCouverture.dejaInitialise = true;
	}
	protected AppSwagger2 wSchemasInit() {
		if(!wSchemasCouverture.dejaInitialise) {
			_wSchemas(wSchemasCouverture);
			if(wSchemas == null)
				setWSchemas(wSchemasCouverture.o);
		}
		if(wSchemas != null)
			wSchemas.initLoinPourClasse(requeteSite_);
		wSchemasCouverture.dejaInitialise(true);
		return (AppSwagger2)this;
	}

	//////////////
	// initLoin //
	//////////////

	protected boolean dejaInitialiseAppSwagger2 = false;

	public AppSwagger2 initLoinAppSwagger2(RequeteSite requeteSite_) {
		setRequeteSite_(requeteSite_);
		if(!dejaInitialiseAppSwagger2) {
			dejaInitialiseAppSwagger2 = true;
			initLoinAppSwagger2();
		}
		return (AppSwagger2)this;
	}

	public void initLoinAppSwagger2() {
		initAppSwagger2();
	}

	public void initAppSwagger2() {
		requeteSite_Init();
		siteContexteInit();
		configSiteInit();
		appliCheminInit();
		openApiVersionInit();
		openApiVersionNumeroInit();
		tabsSchemaInit();
		apiVersionInit();
		openApiYamlCheminInit();
		openApiYamlFichierInit();
		wInit();
		wCheminsInit();
		wCorpsRequetesInit();
		wSchemasInit();
	}

	public void initLoinPourClasse(RequeteSite requeteSite_) {
		initLoinAppSwagger2(requeteSite_);
	}

	/////////////////
	// requeteSite //
	/////////////////

	public void requeteSiteAppSwagger2(RequeteSite requeteSite_) {
		siteContexte.setRequeteSite_(requeteSite_);
		configSite.setRequeteSite_(requeteSite_);
		w.setRequeteSite_(requeteSite_);
		wChemins.setRequeteSite_(requeteSite_);
		wCorpsRequetes.setRequeteSite_(requeteSite_);
		wSchemas.setRequeteSite_(requeteSite_);
	}

	public void requeteSitePourClasse(RequeteSite requeteSite_) {
		requeteSiteAppSwagger2(requeteSite_);
	}

	/////////////
	// obtenir //
	/////////////

	public Object obtenirPourClasse(String var) throws Exception {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtenirAppSwagger2(v);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.obtenirPourClasse(v);
			}
		}
		return o;
	}
	public Object obtenirAppSwagger2(String var) throws Exception {
		AppSwagger2 oAppSwagger2 = (AppSwagger2)this;
		switch(var) {
			case "requeteSite_":
				return oAppSwagger2.requeteSite_;
			case "siteContexte":
				return oAppSwagger2.siteContexte;
			case "configSite":
				return oAppSwagger2.configSite;
			case "appliChemin":
				return oAppSwagger2.appliChemin;
			case "openApiVersion":
				return oAppSwagger2.openApiVersion;
			case "openApiVersionNumero":
				return oAppSwagger2.openApiVersionNumero;
			case "tabsSchema":
				return oAppSwagger2.tabsSchema;
			case "apiVersion":
				return oAppSwagger2.apiVersion;
			case "openApiYamlChemin":
				return oAppSwagger2.openApiYamlChemin;
			case "openApiYamlFichier":
				return oAppSwagger2.openApiYamlFichier;
			case "w":
				return oAppSwagger2.w;
			case "wChemins":
				return oAppSwagger2.wChemins;
			case "wCorpsRequetes":
				return oAppSwagger2.wCorpsRequetes;
			case "wSchemas":
				return oAppSwagger2.wSchemas;
			default:
				return null;
		}
	}

	///////////////
	// attribuer //
	///////////////

	public boolean attribuerPourClasse(String var, Object val) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = attribuerAppSwagger2(v, val);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.attribuerPourClasse(v, val);
			}
		}
		return o != null;
	}
	public Object attribuerAppSwagger2(String var, Object val) {
		AppSwagger2 oAppSwagger2 = (AppSwagger2)this;
		switch(var) {
			default:
				return null;
		}
	}

	/////////////
	// definir //
	/////////////

	public boolean definirPourClasse(String var, String val) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		if(val != null) {
			for(String v : vars) {
				if(o == null)
					o = definirAppSwagger2(v, val);
				else if(o instanceof Cluster) {
					Cluster cluster = (Cluster)o;
					o = cluster.definirPourClasse(v, val);
				}
			}
		}
		return o != null;
	}
	public Object definirAppSwagger2(String var, String val) {
		switch(var) {
			default:
				return null;
		}
	}

	//////////////
	// hashCode //
	//////////////

	@Override public int hashCode() {
		return Objects.hash(appliChemin, openApiVersion, openApiVersionNumero, tabsSchema, apiVersion, openApiYamlChemin);
	}

	////////////
	// equals //
	////////////

	@Override public boolean equals(Object o) {
		if(this == o)
			return true;
		if(!(o instanceof AppSwagger2))
			return false;
		AppSwagger2 that = (AppSwagger2)o;
		return Objects.equals( appliChemin, that.appliChemin )
				&& Objects.equals( openApiVersion, that.openApiVersion )
				&& Objects.equals( openApiVersionNumero, that.openApiVersionNumero )
				&& Objects.equals( tabsSchema, that.tabsSchema )
				&& Objects.equals( apiVersion, that.apiVersion )
				&& Objects.equals( openApiYamlChemin, that.openApiYamlChemin );
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("AppSwagger2 {");
		sb.append( "appliChemin: \"" ).append(appliChemin).append( "\"" );
		sb.append( ", openApiVersion: \"" ).append(openApiVersion).append( "\"" );
		sb.append( ", openApiVersionNumero: " ).append(openApiVersionNumero);
		sb.append( ", tabsSchema: " ).append(tabsSchema);
		sb.append( ", apiVersion: \"" ).append(apiVersion).append( "\"" );
		sb.append( ", openApiYamlChemin: \"" ).append(openApiYamlChemin).append( "\"" );
		sb.append(" }");
		return sb.toString();
	}
}
