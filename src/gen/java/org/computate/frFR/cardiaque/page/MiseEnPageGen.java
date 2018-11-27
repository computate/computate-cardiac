package org.computate.frFR.cardiaque.page;

import org.computate.frFR.cardiaque.couverture.Couverture;
import org.computate.frFR.cardiaque.cluster.Cluster;
import org.computate.frFR.cardiaque.requete.RequeteSite;
import java.lang.Object;

public abstract class MiseEnPageGen<DEV> extends Object {

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
	protected MiseEnPage requeteSite_Init() throws Exception {
		if(!requeteSite_Couverture.dejaInitialise) {
			_requeteSite_(requeteSite_Couverture);
			if(requeteSite_ == null)
				setRequeteSite_(requeteSite_Couverture.o);
		}
		requeteSite_Couverture.dejaInitialise(true);
		return (MiseEnPage)this;
	}

	/////////////////////
	// initialiserLoin //
	/////////////////////

	protected boolean dejaInitialiseMiseEnPage = false;

	public MiseEnPage initLoinMiseEnPage(RequeteSite requeteSite) throws Exception {
		setRequeteSite_(requeteSite);
		initLoinMiseEnPage();
		return (MiseEnPage)this;
	}

	public MiseEnPage initLoinMiseEnPage() throws Exception {
		if(!dejaInitialiseMiseEnPage) {
			requeteSite_Init();
			dejaInitialiseMiseEnPage = true;
		}
		return (MiseEnPage)this;
	}

	public void initLoinPourClasse(RequeteSite requeteSite) throws Exception {
		initLoinMiseEnPage(requeteSite);
	}

	/////////////////
	// requeteSite //
	/////////////////

	public void requeteSiteMiseEnPage(RequeteSite requeteSite) throws Exception {
	}

	public void requeteSitePourClasse(RequeteSite requeteSite) throws Exception {
		requeteSiteMiseEnPage(requeteSite);
	}

	/////////////
	// obtenir //
	/////////////

	public Object obtenirPourClasse(String var) throws Exception {
		String[] vars = org.apache.commons.lang3.StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtenirMiseEnPage(v);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.obtenirPourClasse(v);
			}
		}
		return o;
	}
	public Object obtenirMiseEnPage(String var) throws Exception {
		MiseEnPage oMiseEnPage = (MiseEnPage)this;
		switch(var) {
			case "requeteSite_":
				return oMiseEnPage.requeteSite_;
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
				o = attribuerMiseEnPage(v, val);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.attribuerPourClasse(v, val);
			}
		}
		return o != null;
	}
	public Object attribuerMiseEnPage(String var, Object val) throws Exception {
		MiseEnPage oMiseEnPage = (MiseEnPage)this;
		switch(var) {
			default:
				return null;
		}
	}
}
