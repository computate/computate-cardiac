package org.computate.frFR.cardiaque.contexte;

import org.computate.frFR.cardiaque.couverture.Couverture;
import org.computate.frFR.cardiaque.config.ConfigSite;
import org.computate.frFR.cardiaque.cluster.Cluster;
import io.vertx.core.Vertx;
import java.lang.Integer;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.computate.frFR.cardiaque.requete.RequeteSite;
import java.lang.Object;
import io.vertx.ext.web.api.contract.openapi3.OpenAPI3RouterFactory;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.auth.oauth2.OAuth2Auth;
import java.lang.String;
import io.vertx.ext.sql.SQLClient;

public abstract class SiteContexteGen<DEV> extends Object {

	////////////
	// vertx_ //
	////////////

	/**	L'entité « vertx_ »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected Vertx vertx_;
	public Couverture<Vertx> vertx_Couverture = new Couverture<Vertx>().p(this).c(Vertx.class).var("vertx_").o(vertx_);

	/**	L'entité « vertx_ »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _vertx_(Couverture<Vertx> o) throws Exception;

	public Vertx getVertx_() {
		return vertx_;
	}

	public void setVertx_(Vertx o) {
		this.vertx_ = o;
	}
	protected void vertx_Init() throws Exception {
		if(!vertx_Couverture.dejaInitialise) {
			_vertx_(vertx_Couverture);
			if(vertx_ == null)
				setVertx_(vertx_Couverture.o);
		}
		vertx_Couverture.dejaInitialise(true);
	}

	///////////////
	// siteAuth_ //
	///////////////

	/**	L'entité « siteAuth_ »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected OAuth2Auth siteAuth_;
	public Couverture<OAuth2Auth> siteAuth_Couverture = new Couverture<OAuth2Auth>().p(this).c(OAuth2Auth.class).var("siteAuth_").o(siteAuth_);

	/**	L'entité « siteAuth_ »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _siteAuth_(Couverture<OAuth2Auth> o) throws Exception;

	public OAuth2Auth getSiteAuth_() {
		return siteAuth_;
	}

	public void setSiteAuth_(OAuth2Auth o) {
		this.siteAuth_ = o;
	}
	protected void siteAuth_Init() throws Exception {
		if(!siteAuth_Couverture.dejaInitialise) {
			_siteAuth_(siteAuth_Couverture);
			if(siteAuth_ == null)
				setSiteAuth_(siteAuth_Couverture.o);
		}
		siteAuth_Couverture.dejaInitialise(true);
	}

	///////////////////
	// usineRouteur_ //
	///////////////////

	/**	L'entité « usineRouteur_ »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected OpenAPI3RouterFactory usineRouteur_;
	public Couverture<OpenAPI3RouterFactory> usineRouteur_Couverture = new Couverture<OpenAPI3RouterFactory>().p(this).c(OpenAPI3RouterFactory.class).var("usineRouteur_").o(usineRouteur_);

	/**	L'entité « usineRouteur_ »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _usineRouteur_(Couverture<OpenAPI3RouterFactory> o) throws Exception;

	public OpenAPI3RouterFactory getUsineRouteur_() {
		return usineRouteur_;
	}

	public void setUsineRouteur_(OpenAPI3RouterFactory o) {
		this.usineRouteur_ = o;
	}
	protected void usineRouteur_Init() throws Exception {
		if(!usineRouteur_Couverture.dejaInitialise) {
			_usineRouteur_(usineRouteur_Couverture);
			if(usineRouteur_ == null)
				setUsineRouteur_(usineRouteur_Couverture.o);
		}
		usineRouteur_Couverture.dejaInitialise(true);
	}

	////////////////
	// configSite //
	////////////////

	/**	L'entité « configSite »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut ConfigSite(). 
	 */
	protected ConfigSite configSite = new ConfigSite();
	public Couverture<ConfigSite> configSiteCouverture = new Couverture<ConfigSite>().p(this).c(ConfigSite.class).var("configSite").o(configSite);

	/**	L'entité « configSite »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut ConfigSite(). 
	 *	@param configSite est le champ déjà construit. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _configSite(ConfigSite o) throws Exception;

	public ConfigSite getConfigSite() {
		return configSite;
	}

	public void setConfigSite(ConfigSite o) {
		this.configSite = o;
	}
	protected void configSiteInit() throws Exception {
		if(!configSiteCouverture.dejaInitialise) {
			_configSite(configSite);
		}
		configSite.initLoinPourClasse(requeteSite_);
		configSiteCouverture.dejaInitialise(true);
	}

	////////////////
	// jdbcConfig //
	////////////////

	/**	L'entité « jdbcConfig »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut JsonObject(). 
	 */
	protected JsonObject jdbcConfig = new JsonObject();
	public Couverture<JsonObject> jdbcConfigCouverture = new Couverture<JsonObject>().p(this).c(JsonObject.class).var("jdbcConfig").o(jdbcConfig);

	/**	L'entité « jdbcConfig »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut JsonObject(). 
	 *	@param jdbcConfig est le champ déjà construit. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _jdbcConfig(JsonObject o) throws Exception;

	public JsonObject getJdbcConfig() {
		return jdbcConfig;
	}

	public void setJdbcConfig(JsonObject o) {
		this.jdbcConfig = o;
	}
	protected void jdbcConfigInit() throws Exception {
		if(!jdbcConfigCouverture.dejaInitialise) {
			_jdbcConfig(jdbcConfig);
		}
		jdbcConfigCouverture.dejaInitialise(true);
	}

	///////////////
	// clientSql //
	///////////////

	/**	L'entité « clientSql »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected SQLClient clientSql;
	public Couverture<SQLClient> clientSqlCouverture = new Couverture<SQLClient>().p(this).c(SQLClient.class).var("clientSql").o(clientSql);

	/**	L'entité « clientSql »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _clientSql(Couverture<SQLClient> o) throws Exception;

	public SQLClient getClientSql() {
		return clientSql;
	}

	public void setClientSql(SQLClient o) {
		this.clientSql = o;
	}
	protected void clientSqlInit() throws Exception {
		if(!clientSqlCouverture.dejaInitialise) {
			_clientSql(clientSqlCouverture);
			if(clientSql == null)
				setClientSql(clientSqlCouverture.o);
		}
		clientSqlCouverture.dejaInitialise(true);
	}

	////////////////
	// clientSolr //
	////////////////

	/**	L'entité « clientSolr »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected HttpSolrClient clientSolr;
	public Couverture<HttpSolrClient> clientSolrCouverture = new Couverture<HttpSolrClient>().p(this).c(HttpSolrClient.class).var("clientSolr").o(clientSolr);

	/**	L'entité « clientSolr »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _clientSolr(Couverture<HttpSolrClient> o) throws Exception;

	public HttpSolrClient getClientSolr() {
		return clientSolr;
	}

	public void setClientSolr(HttpSolrClient o) {
		this.clientSolr = o;
	}
	protected void clientSolrInit() throws Exception {
		if(!clientSolrCouverture.dejaInitialise) {
			_clientSolr(clientSolrCouverture);
			if(clientSolr == null)
				setClientSolr(clientSolrCouverture.o);
		}
		clientSolrCouverture.dejaInitialise(true);
	}

	/////////////////////////
	// clientSolrComputate //
	/////////////////////////

	/**	L'entité « clientSolrComputate »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected HttpSolrClient clientSolrComputate;
	public Couverture<HttpSolrClient> clientSolrComputateCouverture = new Couverture<HttpSolrClient>().p(this).c(HttpSolrClient.class).var("clientSolrComputate").o(clientSolrComputate);

	/**	L'entité « clientSolrComputate »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _clientSolrComputate(Couverture<HttpSolrClient> o) throws Exception;

	public HttpSolrClient getClientSolrComputate() {
		return clientSolrComputate;
	}

	public void setClientSolrComputate(HttpSolrClient o) {
		this.clientSolrComputate = o;
	}
	protected void clientSolrComputateInit() throws Exception {
		if(!clientSolrComputateCouverture.dejaInitialise) {
			_clientSolrComputate(clientSolrComputateCouverture);
			if(clientSolrComputate == null)
				setClientSolrComputate(clientSolrComputateCouverture.o);
		}
		clientSolrComputateCouverture.dejaInitialise(true);
	}

	/////////////////
	// selCryptage //
	/////////////////

	/**	L'entité « selCryptage »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected String selCryptage;
	public Couverture<String> selCryptageCouverture = new Couverture<String>().p(this).c(String.class).var("selCryptage").o(selCryptage);

	/**	L'entité « selCryptage »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _selCryptage(Couverture<String> o) throws Exception;

	public String getSelCryptage() {
		return selCryptage;
	}

	public void setSelCryptage(String o) {
		this.selCryptage = o;
	}
	protected void selCryptageInit() throws Exception {
		if(!selCryptageCouverture.dejaInitialise) {
			_selCryptage(selCryptageCouverture);
			if(selCryptage == null)
				setSelCryptage(selCryptageCouverture.o);
		}
		selCryptageCouverture.dejaInitialise(true);
	}

	////////////////////////
	// motDePasseCryptage //
	////////////////////////

	/**	L'entité « motDePasseCryptage »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected String motDePasseCryptage;
	public Couverture<String> motDePasseCryptageCouverture = new Couverture<String>().p(this).c(String.class).var("motDePasseCryptage").o(motDePasseCryptage);

	/**	L'entité « motDePasseCryptage »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _motDePasseCryptage(Couverture<String> o) throws Exception;

	public String getMotDePasseCryptage() {
		return motDePasseCryptage;
	}

	public void setMotDePasseCryptage(String o) {
		this.motDePasseCryptage = o;
	}
	protected void motDePasseCryptageInit() throws Exception {
		if(!motDePasseCryptageCouverture.dejaInitialise) {
			_motDePasseCryptage(motDePasseCryptageCouverture);
			if(motDePasseCryptage == null)
				setMotDePasseCryptage(motDePasseCryptageCouverture.o);
		}
		motDePasseCryptageCouverture.dejaInitialise(true);
	}

	/////////////////////////
	// jetonIdentitePaypal //
	/////////////////////////

	/**	L'entité « jetonIdentitePaypal »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected String jetonIdentitePaypal;
	public Couverture<String> jetonIdentitePaypalCouverture = new Couverture<String>().p(this).c(String.class).var("jetonIdentitePaypal").o(jetonIdentitePaypal);

	/**	L'entité « jetonIdentitePaypal »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _jetonIdentitePaypal(Couverture<String> o) throws Exception;

	public String getJetonIdentitePaypal() {
		return jetonIdentitePaypal;
	}

	public void setJetonIdentitePaypal(String o) {
		this.jetonIdentitePaypal = o;
	}
	protected void jetonIdentitePaypalInit() throws Exception {
		if(!jetonIdentitePaypalCouverture.dejaInitialise) {
			_jetonIdentitePaypal(jetonIdentitePaypalCouverture);
			if(jetonIdentitePaypal == null)
				setJetonIdentitePaypal(jetonIdentitePaypalCouverture.o);
		}
		jetonIdentitePaypalCouverture.dejaInitialise(true);
	}

	//////////////////////
	// nombreExecuteurs //
	//////////////////////

	/**	L'entité « nombreExecuteurs »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected Integer nombreExecuteurs;
	public Couverture<Integer> nombreExecuteursCouverture = new Couverture<Integer>().p(this).c(Integer.class).var("nombreExecuteurs").o(nombreExecuteurs);

	/**	L'entité « nombreExecuteurs »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _nombreExecuteurs(Couverture<Integer> o) throws Exception;

	public Integer getNombreExecuteurs() {
		return nombreExecuteurs;
	}

	public void setNombreExecuteurs(Integer o) {
		this.nombreExecuteurs = o;
	}
	public SiteContexte setNombreExecuteurs(String o) throws Exception {
		if(org.apache.commons.lang3.math.NumberUtils.isCreatable(o))
			this.nombreExecuteurs = Integer.parseInt(o);
		return (SiteContexte)this;
	}
	protected void nombreExecuteursInit() throws Exception {
		if(!nombreExecuteursCouverture.dejaInitialise) {
			_nombreExecuteurs(nombreExecuteursCouverture);
			if(nombreExecuteurs == null)
				setNombreExecuteurs(nombreExecuteursCouverture.o);
		}
		nombreExecuteursCouverture.dejaInitialise(true);
	}

	//////////////////
	// requeteSite_ //
	//////////////////

	/**	L'entité « requeteSite_ »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut RequeteSite(). 
	 */
	protected RequeteSite requeteSite_ = new RequeteSite();
	public Couverture<RequeteSite> requeteSite_Couverture = new Couverture<RequeteSite>().p(this).c(RequeteSite.class).var("requeteSite_").o(requeteSite_);

	/**	L'entité « requeteSite_ »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut RequeteSite(). 
	 *	@param requeteSite_ est le champ déjà construit. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _requeteSite_(RequeteSite o) throws Exception;

	public RequeteSite getRequeteSite_() {
		return requeteSite_;
	}

	public void setRequeteSite_(RequeteSite o) {
		this.requeteSite_ = o;
	}
	protected void requeteSite_Init() throws Exception {
		if(!requeteSite_Couverture.dejaInitialise) {
			_requeteSite_(requeteSite_);
		}
		requeteSite_Couverture.dejaInitialise(true);
	}

	/////////////////////
	// initialiserLoin //
	/////////////////////

	protected boolean dejaInitialiseSiteContexte = false;

	public void initLoinSiteContexte(RequeteSite requeteSite) throws Exception {
		setRequeteSite_(requeteSite);
		initLoinSiteContexte();
	}

	public void initLoinSiteContexte() throws Exception {
		if(!dejaInitialiseSiteContexte) {
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
			dejaInitialiseSiteContexte = true;
		}
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
		String[] vars = org.apache.commons.lang3.StringUtils.split(var, ".");
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
		String[] vars = org.apache.commons.lang3.StringUtils.split(var, ".");
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

	/////////////
	// definir //
	/////////////

	public boolean definirPourClasse(String var, String...vals) throws Exception {
		String[] vars = org.apache.commons.lang3.StringUtils.split(var, ".");
		Object o = null;
		String val = vals == null ? null : vals[vals.length - 1];
		if(val != null) {
			for(String v : vars) {
				if(o == null)
					o = definirSiteContexte(v, val);
				else if(o instanceof Cluster) {
					Cluster cluster = (Cluster)o;
					o = cluster.definirPourClasse(v, val);
				}
			}
		}
		return o != null;
	}
	public Object definirSiteContexte(String var, String val) throws Exception {
		SiteContexte oSiteContexte = (SiteContexte)this;
		switch(var) {
			case "selCryptage":
				oSiteContexte.setSelCryptage(val);
				return val;
			case "motDePasseCryptage":
				oSiteContexte.setMotDePasseCryptage(val);
				return val;
			case "jetonIdentitePaypal":
				oSiteContexte.setJetonIdentitePaypal(val);
				return val;
			case "nombreExecuteurs":
				oSiteContexte.setNombreExecuteurs(val);
				return val;
			default:
				return null;
		}
	}
}
