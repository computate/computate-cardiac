package org.computate.frFR.cardiaque.vertx;

import org.computate.frFR.cardiaque.contexte.SiteContexte;
import org.computate.frFR.cardiaque.couverture.Couverture;
import org.computate.frFR.cardiaque.config.ConfigSite;
import org.computate.frFR.cardiaque.cluster.Cluster;
import org.computate.frFR.cardiaque.requete.RequeteSite;
import java.lang.Object;

public abstract class AppOpenApiGen<DEV> extends Object {

	//////////////////
	// requeteSite_ //
	//////////////////

	/**	L'entité « requeteSite_ »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected RequeteSite requeteSite_;
	public Couverture<RequeteSite> requeteSite_Couverture = new Couverture<RequeteSite>().p(this).c(RequeteSite.class).var("requeteSite_").o(requeteSite_);

	/**	L'entité « requeteSite_ »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _requeteSite_(Couverture<RequeteSite> o) throws Exception;

	public RequeteSite getRequeteSite_() {
		return requeteSite_;
	}

	public void setRequeteSite_(RequeteSite o) {
		this.requeteSite_ = o;
	}
	protected void requeteSite_Init() throws Exception {
		if(!requeteSite_Couverture.dejaInitialise) {
			_requeteSite_(requeteSite_Couverture);
			if(requeteSite_ == null)
				setRequeteSite_(requeteSite_Couverture.o);
		}
		requeteSite_Couverture.dejaInitialise(true);
	}

	//////////////////
	// siteContexte //
	//////////////////

	/**	L'entité « siteContexte »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut SiteContexte(). 
	 */
	protected SiteContexte siteContexte = new SiteContexte();
	public Couverture<SiteContexte> siteContexteCouverture = new Couverture<SiteContexte>().p(this).c(SiteContexte.class).var("siteContexte").o(siteContexte);

	/**	L'entité « siteContexte »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut SiteContexte(). 
	 *	@param siteContexte est le champ déjà construit. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _siteContexte(SiteContexte o) throws Exception;

	public SiteContexte getSiteContexte() {
		return siteContexte;
	}

	public void setSiteContexte(SiteContexte o) {
		this.siteContexte = o;
	}
	protected void siteContexteInit() throws Exception {
		if(!siteContexteCouverture.dejaInitialise) {
			_siteContexte(siteContexte);
		}
		siteContexte.initLoinPourClasse(requeteSite_);
		siteContexteCouverture.dejaInitialise(true);
	}

	////////////////
	// configSite //
	////////////////

	/**	L'entité « configSite »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected ConfigSite configSite;
	public Couverture<ConfigSite> configSiteCouverture = new Couverture<ConfigSite>().p(this).c(ConfigSite.class).var("configSite").o(configSite);

	/**	L'entité « configSite »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _configSite(Couverture<ConfigSite> o) throws Exception;

	public ConfigSite getConfigSite() {
		return configSite;
	}

	public void setConfigSite(ConfigSite o) {
		this.configSite = o;
	}
	protected void configSiteInit() throws Exception {
		if(!configSiteCouverture.dejaInitialise) {
			_configSite(configSiteCouverture);
			if(configSite == null)
				setConfigSite(configSiteCouverture.o);
		}
		if(configSite != null)
			configSite.initLoinPourClasse(requeteSite_);
		configSiteCouverture.dejaInitialise(true);
	}

	/////////////////////
	// initialiserLoin //
	/////////////////////

	protected boolean dejaInitialiseAppOpenApi = false;

	public void initLoinAppOpenApi(RequeteSite requeteSite) throws Exception {
		setRequeteSite_(requeteSite);
		initLoinAppOpenApi();
	}

	public void initLoinAppOpenApi() throws Exception {
		if(!dejaInitialiseAppOpenApi) {
			requeteSite_Init();
			siteContexteInit();
			configSiteInit();
			dejaInitialiseAppOpenApi = true;
		}
	}

	public void initLoinPourClasse(RequeteSite requeteSite) throws Exception {
		initLoinAppOpenApi(requeteSite);
	}

	/////////////////
	// requeteSite //
	/////////////////

	public void requeteSiteAppOpenApi(RequeteSite requeteSite) throws Exception {
		siteContexte.setRequeteSite_(requeteSite);
		configSite.setRequeteSite_(requeteSite);
	}

	public void requeteSitePourClasse(RequeteSite requeteSite) throws Exception {
		requeteSiteAppOpenApi(requeteSite);
	}

	/////////////
	// obtenir //
	/////////////

	public Object obtenirPourClasse(String var) throws Exception {
		String[] vars = org.apache.commons.lang3.StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtenirAppOpenApi(v);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.obtenirPourClasse(v);
			}
		}
		return o;
	}
	public Object obtenirAppOpenApi(String var) throws Exception {
		AppOpenApi3 oAppOpenApi = (AppOpenApi3)this;
		switch(var) {
			case "requeteSite_":
				return oAppOpenApi.requeteSite_;
			case "siteContexte":
				return oAppOpenApi.siteContexte;
			case "configSite":
				return oAppOpenApi.configSite;
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
				o = attribuerAppOpenApi(v, val);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.attribuerPourClasse(v, val);
			}
		}
		return o != null;
	}
	public Object attribuerAppOpenApi(String var, Object val) throws Exception {
		AppOpenApi3 oAppOpenApi = (AppOpenApi3)this;
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
					o = definirAppOpenApi(v, val);
				else if(o instanceof Cluster) {
					Cluster cluster = (Cluster)o;
					o = cluster.definirPourClasse(v, val);
				}
			}
		}
		return o != null;
	}
	public Object definirAppOpenApi(String var, String val) throws Exception {
		AppOpenApi3 oAppOpenApi = (AppOpenApi3)this;
		switch(var) {
			default:
				return null;
		}
	}
}
