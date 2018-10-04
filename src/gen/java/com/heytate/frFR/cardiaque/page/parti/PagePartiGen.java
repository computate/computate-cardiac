package com.heytate.frFR.cardiaque.page.parti;

import com.heytate.frFR.cardiaque.requete.RequeteSite;
import java.lang.String;
import com.heytate.frFR.cardiaque.couverture.Couverture;

public abstract class PagePartiGen<DEV> extends Cluster {

	/////////////////
	// requeteSite //
	/////////////////

	/**	L'entité « requeteSite »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public RequeteSite requeteSite;
	public Couverture<RequeteSite> requeteSiteCouverture = new Couverture<RequeteSite>().p(this).c(RequeteSite.class).var("requeteSite").o(requeteSite);

	/**	L'entité « requeteSite »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _requeteSite(Couverture<RequeteSite> o) throws Exception;

	public PageParti requeteSite(RequeteSite o) throws Exception {
		setRequeteSite(o);
		return (PageParti)this;
	}

	public void setRequeteSite(RequeteSite o) throws Exception {
		this.requeteSite = o;
	}

	public RequeteSite requeteSite() throws Exception {
		return getRequeteSite();
	}

	public RequeteSite getRequeteSite() throws Exception {
		return requeteSite;
	}
	protected void requeteSiteInit() throws Exception {
		if(!requeteSiteCouverture.dejaInitialise) {
			_requeteSite(requeteSiteCouverture);
			if(requeteSite == null)
				requeteSite(requeteSiteCouverture.o);
		}
		if(requeteSite != null)
			requeteSite.initLoinPourClasse(requeteSite);
		requeteSiteCouverture.dejaInitialise(true);
	}

	//////////////
	// partiVar //
	//////////////

	/**	L'entité « partiVar »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public String partiVar;
	public Couverture<String> partiVarCouverture = new Couverture<String>().p(this).c(String.class).var("partiVar").o(partiVar);

	/**	L'entité « partiVar »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _partiVar(Couverture<String> o) throws Exception;

	public PageParti partiVar(String o) throws Exception {
		setPartiVar(o);
		return (PageParti)this;
	}

	public void setPartiVar(String o) throws Exception {
		this.partiVar = o;
	}

	public String partiVar() throws Exception {
		return getPartiVar();
	}

	public String getPartiVar() throws Exception {
		return partiVar;
	}
	protected void partiVarInit() throws Exception {
		if(!partiVarCouverture.dejaInitialise) {
			_partiVar(partiVarCouverture);
			if(partiVar == null)
				partiVar(partiVarCouverture.o);
		}
		partiVarCouverture.dejaInitialise(true);
	}

	protected boolean dejaInitialisePageParti = false;

	public void initLoinPageParti(RequeteSite requeteSite) throws Exception {
		((PageParti)this).requeteSite(requeteSite);
		requeteSite(requeteSite);
		initLoinPageParti();
	}

	public void initLoinPageParti() throws Exception {
		if(!dejaInitialisePageParti) {
			requeteSiteInit();
			partiVarInit();
			dejaInitialisePageParti = true;
		}
	}

	public void initLoinPourClasse(RequeteSite requeteSite) throws Exception {
		initLoinPageParti(requeteSite);
	}
}
