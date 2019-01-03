package org.computate.frFR.cardiaque.page.parti;

import org.computate.frFR.cardiaque.couverture.Couverture;
import io.vertx.core.http.HttpServerResponse;
import org.computate.frFR.cardiaque.cluster.Cluster;
import org.computate.frFR.cardiaque.requete.RequeteSite;
import org.apache.commons.text.StringEscapeUtils;
import java.lang.String;
import org.apache.commons.lang3.StringUtils;

/**	
 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.frFR.cardiaque.page.parti.PageParti&fq=classeEtendGen_indexed_boolean:true">Trouver la classe  dans Solr</a>
 * <br/>
 **/
public abstract class PagePartiGen<DEV> extends Cluster {

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
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.frFR.cardiaque.page.parti.PageParti&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:requeteSite_">Trouver l'entité requeteSite_ dans Solr</a>
	 * <br/>
	 * @param o est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _requeteSite_(Couverture<RequeteSite> o) throws Exception;

	public RequeteSite getRequeteSite_() {
		return requeteSite_;
	}

	public void setRequeteSite_(RequeteSite o) {
		this.requeteSite_ = o;
		this.requeteSite_Couverture.dejaInitialise = true;
	}
	protected PageParti requeteSite_Init() throws Exception {
		if(!requeteSite_Couverture.dejaInitialise) {
			_requeteSite_(requeteSite_Couverture);
			if(requeteSite_ == null)
				setRequeteSite_(requeteSite_Couverture.o);
		}
		requeteSite_Couverture.dejaInitialise(true);
		return (PageParti)this;
	}

	//////////////
	// partiVar //
	//////////////

	/**	L'entité « partiVar »
	 *	 is defined as null before being initialized. 
	 */
	protected String partiVar;
	public Couverture<String> partiVarCouverture = new Couverture<String>().p(this).c(String.class).var("partiVar").o(partiVar);

	/**	<br/>L'entité « partiVar »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.frFR.cardiaque.page.parti.PageParti&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:partiVar">Trouver l'entité partiVar dans Solr</a>
	 * <br/>
	 * @param o est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _partiVar(Couverture<String> o);

	public String getPartiVar() {
		return partiVar;
	}

	public void setPartiVar(String o) {
		this.partiVar = o;
		this.partiVarCouverture.dejaInitialise = true;
	}
	protected PageParti partiVarInit() throws Exception {
		if(!partiVarCouverture.dejaInitialise) {
			_partiVar(partiVarCouverture);
			if(partiVar == null)
				setPartiVar(partiVarCouverture.o);
		}
		partiVarCouverture.dejaInitialise(true);
		return (PageParti)this;
	}

	public String solrPartiVar() {
		return partiVar;
	}

	public String strPartiVar() {
		return partiVar == null ? "" : partiVar;
	}

	public String nomAffichagePartiVar() {
		return null;
	}

	public String htmlTooltipPartiVar() {
		return null;
	}

	public String htmlPartiVar() {
		return partiVar == null ? "" : StringEscapeUtils.escapeHtml4(strPartiVar());
	}

	//////////////
	// initLoin //
	//////////////

	protected boolean dejaInitialisePageParti = false;

	public PageParti initLoinPageParti(RequeteSite requeteSite) throws Exception {
		setRequeteSite_(requeteSite);
		initLoinPageParti();
		return (PageParti)this;
	}

	public PageParti initLoinPageParti() throws Exception {
		if(!dejaInitialisePageParti) {
			dejaInitialisePageParti = true;
			super.initLoinCluster(requeteSite_);
			requeteSite_Init();
			partiVarInit();
		}
		return (PageParti)this;
	}

	public void initLoinPourClasse(RequeteSite requeteSite) throws Exception {
		initLoinPageParti(requeteSite);
	}

	/////////////////
	// requeteSite //
	/////////////////

	public void requeteSitePageParti(RequeteSite requeteSite) throws Exception {
			super.requeteSiteCluster(requeteSite);
	}

	public void requeteSitePourClasse(RequeteSite requeteSite) throws Exception {
		requeteSitePageParti(requeteSite);
	}

	/////////////
	// obtenir //
	/////////////

	@Override public Object obtenirPourClasse(String var) throws Exception {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtenirPageParti(v);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.obtenirPourClasse(v);
			}
		}
		return o;
	}
	public Object obtenirPageParti(String var) throws Exception {
		PageParti oPageParti = (PageParti)this;
		switch(var) {
			case "requeteSite_":
				return oPageParti.requeteSite_;
			case "partiVar":
				return oPageParti.partiVar;
			default:
				return super.obtenirCluster(var);
		}
	}

	///////////////
	// attribuer //
	///////////////

	@Override public boolean attribuerPourClasse(String var, Object val) throws Exception {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = attribuerPageParti(v, val);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.attribuerPourClasse(v, val);
			}
		}
		return o != null;
	}
	public Object attribuerPageParti(String var, Object val) throws Exception {
		PageParti oPageParti = (PageParti)this;
		switch(var) {
			default:
				return super.attribuerCluster(var, val);
		}
	}
}
