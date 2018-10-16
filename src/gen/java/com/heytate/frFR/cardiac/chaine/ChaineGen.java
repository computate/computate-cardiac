package com.heytate.frFR.cardiac.chaine;

import java.lang.Double;
import com.heytate.frFR.cardiaque.requete.RequeteSite;
import java.lang.Boolean;
import java.lang.Object;
import com.heytate.frFR.cardiaque.page.parti.Icone;
import java.lang.String;
import com.heytate.frFR.cardiaque.couverture.Couverture;
import java.util.ArrayList;

public abstract class ChaineGen<DEV> extends Object {

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

	public void setRequeteSite(RequeteSite o) throws Exception {
		this.requeteSite = o;
	}

	public RequeteSite getRequeteSite() throws Exception {
		return requeteSite;
	}
	protected void requeteSiteInit() throws Exception {
		if(!requeteSiteCouverture.dejaInitialise) {
			_requeteSite(requeteSiteCouverture);
			if(requeteSite == null)
				setRequeteSite(requeteSiteCouverture.o);
		}
		if(requeteSite != null)
			requeteSite.initLoinPourClasse(requeteSite);
		requeteSiteCouverture.dejaInitialise(true);
	}

	////////////
	// police //
	////////////

	/**	L'entité « police »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public String police;
	public Couverture<String> policeCouverture = new Couverture<String>().p(this).c(String.class).var("police").o(police);

	/**	L'entité « police »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _police(Couverture<String> o) throws Exception;

	public void setPolice(String o) throws Exception {
		this.police = o;
	}

	public String getPolice() throws Exception {
		return police;
	}
	protected void policeInit() throws Exception {
		if(!policeCouverture.dejaInitialise) {
			_police(policeCouverture);
			if(police == null)
				setPolice(policeCouverture.o);
		}
		policeCouverture.dejaInitialise(true);
	}

	///////////////////
	// alignerCentre //
	///////////////////

	/**	L'entité « alignerCentre »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public Boolean alignerCentre;
	public Couverture<Boolean> alignerCentreCouverture = new Couverture<Boolean>().p(this).c(Boolean.class).var("alignerCentre").o(alignerCentre);

	/**	L'entité « alignerCentre »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _alignerCentre(Couverture<Boolean> o) throws Exception;

	public void setAlignerCentre(Boolean o) throws Exception {
		this.alignerCentre = o;
	}

	public Boolean getAlignerCentre() throws Exception {
		return alignerCentre;
	}
	public Chaine alignerCentre(String o) throws Exception {
		if(org.apache.commons.lang3.BooleanUtils.isTrue(org.apache.commons.lang3.BooleanUtils.toBoolean(o)))
			this.alignerCentre = Boolean.parseBoolean(o);
		return (Chaine)this;
	}
	protected void alignerCentreInit() throws Exception {
		if(!alignerCentreCouverture.dejaInitialise) {
			_alignerCentre(alignerCentreCouverture);
			if(alignerCentre == null)
				setAlignerCentre(alignerCentreCouverture.o);
		}
		alignerCentreCouverture.dejaInitialise(true);
	}

	///////////////////
	// alignerGauche //
	///////////////////

	/**	L'entité « alignerGauche »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public Boolean alignerGauche;
	public Couverture<Boolean> alignerGaucheCouverture = new Couverture<Boolean>().p(this).c(Boolean.class).var("alignerGauche").o(alignerGauche);

	/**	L'entité « alignerGauche »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _alignerGauche(Couverture<Boolean> o) throws Exception;

	public void setAlignerGauche(Boolean o) throws Exception {
		this.alignerGauche = o;
	}

	public Boolean getAlignerGauche() throws Exception {
		return alignerGauche;
	}
	public Chaine alignerGauche(String o) throws Exception {
		if(org.apache.commons.lang3.BooleanUtils.isTrue(org.apache.commons.lang3.BooleanUtils.toBoolean(o)))
			this.alignerGauche = Boolean.parseBoolean(o);
		return (Chaine)this;
	}
	protected void alignerGaucheInit() throws Exception {
		if(!alignerGaucheCouverture.dejaInitialise) {
			_alignerGauche(alignerGaucheCouverture);
			if(alignerGauche == null)
				setAlignerGauche(alignerGaucheCouverture.o);
		}
		alignerGaucheCouverture.dejaInitialise(true);
	}

	//////////////////
	// alignerDroit //
	//////////////////

	/**	L'entité « alignerDroit »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public Boolean alignerDroit;
	public Couverture<Boolean> alignerDroitCouverture = new Couverture<Boolean>().p(this).c(Boolean.class).var("alignerDroit").o(alignerDroit);

	/**	L'entité « alignerDroit »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _alignerDroit(Couverture<Boolean> o) throws Exception;

	public void setAlignerDroit(Boolean o) throws Exception {
		this.alignerDroit = o;
	}

	public Boolean getAlignerDroit() throws Exception {
		return alignerDroit;
	}
	public Chaine alignerDroit(String o) throws Exception {
		if(org.apache.commons.lang3.BooleanUtils.isTrue(org.apache.commons.lang3.BooleanUtils.toBoolean(o)))
			this.alignerDroit = Boolean.parseBoolean(o);
		return (Chaine)this;
	}
	protected void alignerDroitInit() throws Exception {
		if(!alignerDroitCouverture.dejaInitialise) {
			_alignerDroit(alignerDroitCouverture);
			if(alignerDroit == null)
				setAlignerDroit(alignerDroitCouverture.o);
		}
		alignerDroitCouverture.dejaInitialise(true);
	}

	/////////////////
	// iconesAvant //
	/////////////////

	/**	L'entité « iconesAvant »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut ArrayList<Icone>(). 
	 */
	public ArrayList<Icone> iconesAvant = new ArrayList<Icone>();
	public Couverture<ArrayList<Icone>> iconesAvantCouverture = new Couverture<ArrayList<Icone>>().p(this).c(ArrayList.class).var("iconesAvant").o(iconesAvant);

	/**	L'entité « iconesAvant »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut ArrayList<Icone>(). 
	 *	@param iconesAvant est le champ déjà construit. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _iconesAvant(ArrayList<Icone> l) throws Exception;

	public void setIconesAvant(ArrayList<Icone> l) throws Exception {
		this.iconesAvant = l;
	}

	public ArrayList<Icone> getIconesAvant() throws Exception {
		return iconesAvant;
	}
	public Chaine iconesAvantAjouter(Icone...objets) throws Exception {
		for(Icone o : objets) {
			iconesAvantAjouter(o);
		}
		return (Chaine)this;
	}
	public Chaine iconesAvantAjouter(Icone o) throws Exception {
		if(o != null && !iconesAvant.contains(o))
			this.iconesAvant.add(o);
		return (Chaine)this;
	}
	protected void iconesAvantInit() throws Exception {
		if(!iconesAvantCouverture.dejaInitialise) {
			_iconesAvant(iconesAvant);
		}
		iconesAvantCouverture.dejaInitialise(true);
	}

	/////////////////
	// iconesApres //
	/////////////////

	/**	L'entité « iconesApres »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut ArrayList<Icone>(). 
	 */
	public ArrayList<Icone> iconesApres = new ArrayList<Icone>();
	public Couverture<ArrayList<Icone>> iconesApresCouverture = new Couverture<ArrayList<Icone>>().p(this).c(ArrayList.class).var("iconesApres").o(iconesApres);

	/**	L'entité « iconesApres »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut ArrayList<Icone>(). 
	 *	@param iconesApres est le champ déjà construit. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _iconesApres(ArrayList<Icone> l) throws Exception;

	public void setIconesApres(ArrayList<Icone> l) throws Exception {
		this.iconesApres = l;
	}

	public ArrayList<Icone> getIconesApres() throws Exception {
		return iconesApres;
	}
	public Chaine iconesApresAjouter(Icone...objets) throws Exception {
		for(Icone o : objets) {
			iconesApresAjouter(o);
		}
		return (Chaine)this;
	}
	public Chaine iconesApresAjouter(Icone o) throws Exception {
		if(o != null && !iconesApres.contains(o))
			this.iconesApres.add(o);
		return (Chaine)this;
	}
	protected void iconesApresInit() throws Exception {
		if(!iconesApresCouverture.dejaInitialise) {
			_iconesApres(iconesApres);
		}
		iconesApresCouverture.dejaInitialise(true);
	}

	///////////////
	// xDecalage //
	///////////////

	/**	L'entité « xDecalage »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public Double xDecalage;
	public Couverture<Double> xDecalageCouverture = new Couverture<Double>().p(this).c(Double.class).var("xDecalage").o(xDecalage);

	/**	L'entité « xDecalage »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _xDecalage(Couverture<Double> o) throws Exception;

	public void setXDecalage(Double o) throws Exception {
		this.xDecalage = o;
	}

	public Double getXDecalage() throws Exception {
		return xDecalage;
	}
	public Chaine xDecalage(String o) throws Exception {
		if(org.apache.commons.lang3.math.NumberUtils.isNumber(o))
			this.xDecalage = Double.parseDouble(o);
		return (Chaine)this;
	}
	protected void xDecalageInit() throws Exception {
		if(!xDecalageCouverture.dejaInitialise) {
			_xDecalage(xDecalageCouverture);
			if(xDecalage == null)
				setXDecalage(xDecalageCouverture.o);
		}
		xDecalageCouverture.dejaInitialise(true);
	}

	///////////////
	// yDecalage //
	///////////////

	/**	L'entité « yDecalage »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public Double yDecalage;
	public Couverture<Double> yDecalageCouverture = new Couverture<Double>().p(this).c(Double.class).var("yDecalage").o(yDecalage);

	/**	L'entité « yDecalage »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _yDecalage(Couverture<Double> o) throws Exception;

	public void setYDecalage(Double o) throws Exception {
		this.yDecalage = o;
	}

	public Double getYDecalage() throws Exception {
		return yDecalage;
	}
	public Chaine yDecalage(String o) throws Exception {
		if(org.apache.commons.lang3.math.NumberUtils.isNumber(o))
			this.yDecalage = Double.parseDouble(o);
		return (Chaine)this;
	}
	protected void yDecalageInit() throws Exception {
		if(!yDecalageCouverture.dejaInitialise) {
			_yDecalage(yDecalageCouverture);
			if(yDecalage == null)
				setYDecalage(yDecalageCouverture.o);
		}
		yDecalageCouverture.dejaInitialise(true);
	}

	////////////
	// hLigne //
	////////////

	/**	L'entité « hLigne »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public Double hLigne;
	public Couverture<Double> hLigneCouverture = new Couverture<Double>().p(this).c(Double.class).var("hLigne").o(hLigne);

	/**	L'entité « hLigne »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _hLigne(Couverture<Double> o) throws Exception;

	public void setHLigne(Double o) throws Exception {
		this.hLigne = o;
	}

	public Double getHLigne() throws Exception {
		return hLigne;
	}
	public Chaine hLigne(String o) throws Exception {
		if(org.apache.commons.lang3.math.NumberUtils.isNumber(o))
			this.hLigne = Double.parseDouble(o);
		return (Chaine)this;
	}
	protected void hLigneInit() throws Exception {
		if(!hLigneCouverture.dejaInitialise) {
			_hLigne(hLigneCouverture);
			if(hLigne == null)
				setHLigne(hLigneCouverture.o);
		}
		hLigneCouverture.dejaInitialise(true);
	}

	/////////////
	// hEspace //
	/////////////

	/**	L'entité « hEspace »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public Double hEspace;
	public Couverture<Double> hEspaceCouverture = new Couverture<Double>().p(this).c(Double.class).var("hEspace").o(hEspace);

	/**	L'entité « hEspace »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _hEspace(Couverture<Double> o) throws Exception;

	public void setHEspace(Double o) throws Exception {
		this.hEspace = o;
	}

	public Double getHEspace() throws Exception {
		return hEspace;
	}
	public Chaine hEspace(String o) throws Exception {
		if(org.apache.commons.lang3.math.NumberUtils.isNumber(o))
			this.hEspace = Double.parseDouble(o);
		return (Chaine)this;
	}
	protected void hEspaceInit() throws Exception {
		if(!hEspaceCouverture.dejaInitialise) {
			_hEspace(hEspaceCouverture);
			if(hEspace == null)
				setHEspace(hEspaceCouverture.o);
		}
		hEspaceCouverture.dejaInitialise(true);
	}

	//////////
	// tout //
	//////////

	/**	L'entité « tout »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut ArrayList<Object>(). 
	 */
	public ArrayList<Object> tout = new ArrayList<Object>();
	public Couverture<ArrayList<Object>> toutCouverture = new Couverture<ArrayList<Object>>().p(this).c(ArrayList.class).var("tout").o(tout);

	/**	L'entité « tout »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut ArrayList<Object>(). 
	 *	@param tout est le champ déjà construit. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _tout(ArrayList<Object> l) throws Exception;

	public void setTout(ArrayList<Object> l) throws Exception {
		this.tout = l;
	}

	public ArrayList<Object> getTout() throws Exception {
		return tout;
	}
	public Chaine toutAjouter(Object...objets) throws Exception {
		for(Object o : objets) {
			toutAjouter(o);
		}
		return (Chaine)this;
	}
	public Chaine toutAjouter(Object o) throws Exception {
		if(o != null && !tout.contains(o))
			this.tout.add(o);
		return (Chaine)this;
	}
	protected void toutInit() throws Exception {
		if(!toutCouverture.dejaInitialise) {
			_tout(tout);
		}
		toutCouverture.dejaInitialise(true);
	}

	protected boolean dejaInitialiseChaine = false;

	public void initLoinChaine() throws Exception {
		if(!dejaInitialiseChaine) {
			requeteSiteInit();
			policeInit();
			alignerCentreInit();
			alignerGaucheInit();
			alignerDroitInit();
			iconesAvantInit();
			iconesApresInit();
			xDecalageInit();
			yDecalageInit();
			hLigneInit();
			hEspaceInit();
			toutInit();
			dejaInitialiseChaine = true;
		}
	}
}
