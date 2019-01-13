package org.computate.frFR.cardiaque.vertx;

import java.util.Objects;
import org.computate.frFR.cardiaque.contexte.SiteContexte;
import org.computate.frFR.cardiaque.couverture.Couverture;
import org.computate.frFR.cardiaque.config.ConfigSite;
import org.computate.frFR.cardiaque.cluster.Cluster;
import org.computate.frFR.cardiaque.requete.RequeteSite;
import org.computate.frFR.cardiaque.ecrivain.ToutEcrivain;
import org.apache.commons.text.StringEscapeUtils;
import java.lang.Object;
import org.apache.commons.lang3.StringUtils;
import java.lang.Exception;

/**	
 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.frFR.cardiaque.vertx.AppOpenApi3&fq=classeEtendGen_indexed_boolean:true">Trouver la classe  dans Solr</a>
 * <br/>
 **/
public abstract class AppOpenApi3Gen<DEV> extends Object {

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
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.frFR.cardiaque.vertx.AppOpenApi3&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:requeteSite_">Trouver l'entité requeteSite_ dans Solr</a>
	 * <br/>
	 * @param o est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _requeteSite_(Couverture<RequeteSite> o) throws Exception, Exception;

	public RequeteSite getRequeteSite_() {
		return requeteSite_;
	}

	public void setRequeteSite_(RequeteSite o) {
		this.requeteSite_ = o;
		this.requeteSite_Couverture.dejaInitialise = true;
	}
	protected AppOpenApi3 requeteSite_Init()
 throws Exception, Exception {
		if(!requeteSite_Couverture.dejaInitialise) {
			_requeteSite_(requeteSite_Couverture);
			if(requeteSite_ == null)
				setRequeteSite_(requeteSite_Couverture.o);
		}
		requeteSite_Couverture.dejaInitialise(true);
		return (AppOpenApi3)this;
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
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.frFR.cardiaque.vertx.AppOpenApi3&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:siteContexte">Trouver l'entité siteContexte dans Solr</a>
	 * <br/>
	 * @param siteContexte est l'entité déjà construit. 
	 **/
	protected abstract void _siteContexte(SiteContexte o) throws Exception, Exception;

	public SiteContexte getSiteContexte() {
		return siteContexte;
	}

	public void setSiteContexte(SiteContexte o) {
		this.siteContexte = o;
		this.siteContexteCouverture.dejaInitialise = true;
	}
	protected AppOpenApi3 siteContexteInit()
 throws Exception, Exception {
		if(!siteContexteCouverture.dejaInitialise) {
			_siteContexte(siteContexte);
		}
		siteContexte.initLoinPourClasse(requeteSite_);
		siteContexteCouverture.dejaInitialise(true);
		return (AppOpenApi3)this;
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
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.frFR.cardiaque.vertx.AppOpenApi3&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:configSite">Trouver l'entité configSite dans Solr</a>
	 * <br/>
	 * @param o est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _configSite(Couverture<ConfigSite> o) throws Exception, Exception;

	public ConfigSite getConfigSite() {
		return configSite;
	}

	public void setConfigSite(ConfigSite o) {
		this.configSite = o;
		this.configSiteCouverture.dejaInitialise = true;
	}
	protected AppOpenApi3 configSiteInit()
 throws Exception, Exception {
		if(!configSiteCouverture.dejaInitialise) {
			_configSite(configSiteCouverture);
			if(configSite == null)
				setConfigSite(configSiteCouverture.o);
		}
		if(configSite != null)
			configSite.initLoinPourClasse(requeteSite_);
		configSiteCouverture.dejaInitialise(true);
		return (AppOpenApi3)this;
	}

	//////////////
	// initLoin //
	//////////////

	protected boolean dejaInitialiseAppOpenApi3 = false;

	public AppOpenApi3 initLoinAppOpenApi3(RequeteSite requeteSite) throws Exception {
		setRequeteSite_(requeteSite);
		if(!dejaInitialiseAppOpenApi3) {
			dejaInitialiseAppOpenApi3 = true;
			initLoinAppOpenApi3();
		}
		return (AppOpenApi3)this;
	}

	public void initLoinAppOpenApi3() throws Exception {
		initAppOpenApi3();
	}

	public void initAppOpenApi3() throws Exception {
		requeteSite_Init();
		siteContexteInit();
		configSiteInit();
	}

	public void initLoinPourClasse(RequeteSite requeteSite) throws Exception {
		initLoinAppOpenApi3(requeteSite);
	}

	/////////////////
	// requeteSite //
	/////////////////

	public void requeteSiteAppOpenApi3(RequeteSite requeteSite) {
		siteContexte.setRequeteSite_(requeteSite);
		configSite.setRequeteSite_(requeteSite);
	}

	public void requeteSitePourClasse(RequeteSite requeteSite) {
		requeteSiteAppOpenApi3(requeteSite);
	}

	/////////////
	// obtenir //
	/////////////

	public Object obtenirPourClasse(String var) throws Exception {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtenirAppOpenApi3(v);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.obtenirPourClasse(v);
			}
		}
		return o;
	}
	public Object obtenirAppOpenApi3(String var) throws Exception {
		AppOpenApi3 oAppOpenApi3 = (AppOpenApi3)this;
		switch(var) {
			case "requeteSite_":
				return oAppOpenApi3.requeteSite_;
			case "siteContexte":
				return oAppOpenApi3.siteContexte;
			case "configSite":
				return oAppOpenApi3.configSite;
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
				o = attribuerAppOpenApi3(v, val);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.attribuerPourClasse(v, val);
			}
		}
		return o != null;
	}
	public Object attribuerAppOpenApi3(String var, Object val) {
		AppOpenApi3 oAppOpenApi3 = (AppOpenApi3)this;
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
					o = definirAppOpenApi3(v, val);
				else if(o instanceof Cluster) {
					Cluster cluster = (Cluster)o;
					o = cluster.definirPourClasse(v, val);
				}
			}
		}
		return o != null;
	}
	public Object definirAppOpenApi3(String var, String val) {
		switch(var) {
			default:
				return null;
		}
	}

	//////////////
	// hashCode //
	//////////////

	@Override public int hashCode() {
		return Objects.hash();
	}

	////////////
	// equals //
	////////////

	@Override public boolean equals(Object o) {
		if(this == o)
			return true;
		if(!(o instanceof AppOpenApi3))
			return false;
		AppOpenApi3 that = (AppOpenApi3)o;
		return true;
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("AppOpenApi3 {");
		sb.append(" }");
		return sb.toString();
	}
}
