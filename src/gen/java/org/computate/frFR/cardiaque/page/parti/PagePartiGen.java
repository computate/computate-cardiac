package org.computate.frFR.cardiaque.page.parti;

import org.computate.frFR.cardiaque.couverture.Couverture;
import org.computate.frFR.cardiaque.cluster.Cluster;
import org.computate.frFR.cardiaque.requete.RequeteSite;
import java.lang.String;

public abstract class PagePartiGen<DEV> extends Cluster {

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

	public void setRequeteSite_(RequeteSite o) throws Exception {
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

	//////////////
	// partiVar //
	//////////////

	/**	L'entité « partiVar »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected String partiVar;
	public Couverture<String> partiVarCouverture = new Couverture<String>().p(this).c(String.class).var("partiVar").o(partiVar);

	/**	L'entité « partiVar »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _partiVar(Couverture<String> o) throws Exception;

	public String getPartiVar() {
		return partiVar;
	}

	public void setPartiVar(String o) throws Exception {
		this.partiVar = o;
	}
	protected void partiVarInit() throws Exception {
		if(!partiVarCouverture.dejaInitialise) {
			_partiVar(partiVarCouverture);
			if(partiVar == null)
				setPartiVar(partiVarCouverture.o);
		}
		partiVarCouverture.dejaInitialise(true);
	}

	/////////////////////
	// initialiserLoin //
	/////////////////////

	protected boolean dejaInitialisePageParti = false;

	public void initLoinPageParti(RequeteSite requeteSite) throws Exception {
		setRequeteSite_(requeteSite);
		initLoinPageParti();
	}

	public void initLoinPageParti() throws Exception {
		if(!dejaInitialisePageParti) {
			super.initLoinCluster(requeteSite_);
			requeteSite_Init();
			partiVarInit();
			dejaInitialisePageParti = true;
		}
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
		String[] vars = org.apache.commons.lang3.StringUtils.split(var, ".");
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
		String[] vars = org.apache.commons.lang3.StringUtils.split(var, ".");
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

	/////////////
	// definir //
	/////////////

	@Override public boolean definirPourClasse(String var, String...vals) throws Exception {
		String[] vars = org.apache.commons.lang3.StringUtils.split(var, ".");
		Object o = null;
		String val = vals == null ? null : vals[vals.length - 1];
		if(val != null) {
			for(String v : vars) {
				if(o == null)
					o = definirPageParti(v, val);
				else if(o instanceof Cluster) {
					Cluster cluster = (Cluster)o;
					o = cluster.definirPourClasse(v, val);
				}
			}
		}
		return o != null;
	}
	public Object definirPageParti(String var, String val) throws Exception {
		PageParti oPageParti = (PageParti)this;
		switch(var) {
			case "partiVar":
				oPageParti.setPartiVar(val);
				return val;
			default:
				return super.definirCluster(var, val);
		}
	}
}
