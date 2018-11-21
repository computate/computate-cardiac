package org.computate.frFR.cardiaque.chaine;

import org.computate.frFR.cardiaque.page.parti.Icone;
import org.computate.frFR.cardiaque.couverture.Couverture;
import java.lang.Double;
import org.computate.frFR.cardiaque.cluster.Cluster;
import org.computate.frFR.cardiaque.requete.RequeteSite;
import java.lang.Boolean;
import java.lang.Object;
import java.lang.String;
import java.util.ArrayList;

public abstract class ChaineGen<DEV> extends Object {

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

	////////////
	// police //
	////////////

	/**	L'entité « police »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected String police;
	public Couverture<String> policeCouverture = new Couverture<String>().p(this).c(String.class).var("police").o(police);

	/**	L'entité « police »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _police(Couverture<String> o) throws Exception;

	public String getPolice() {
		return police;
	}

	public void setPolice(String o) throws Exception {
		this.police = o;
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
	protected Boolean alignerCentre;
	public Couverture<Boolean> alignerCentreCouverture = new Couverture<Boolean>().p(this).c(Boolean.class).var("alignerCentre").o(alignerCentre);

	/**	L'entité « alignerCentre »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _alignerCentre(Couverture<Boolean> o) throws Exception;

	public Boolean getAlignerCentre() {
		return alignerCentre;
	}

	public void setAlignerCentre(Boolean o) throws Exception {
		this.alignerCentre = o;
	}
	public Chaine setAlignerCentre(String o) throws Exception {
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
	protected Boolean alignerGauche;
	public Couverture<Boolean> alignerGaucheCouverture = new Couverture<Boolean>().p(this).c(Boolean.class).var("alignerGauche").o(alignerGauche);

	/**	L'entité « alignerGauche »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _alignerGauche(Couverture<Boolean> o) throws Exception;

	public Boolean getAlignerGauche() {
		return alignerGauche;
	}

	public void setAlignerGauche(Boolean o) throws Exception {
		this.alignerGauche = o;
	}
	public Chaine setAlignerGauche(String o) throws Exception {
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
	protected Boolean alignerDroit;
	public Couverture<Boolean> alignerDroitCouverture = new Couverture<Boolean>().p(this).c(Boolean.class).var("alignerDroit").o(alignerDroit);

	/**	L'entité « alignerDroit »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _alignerDroit(Couverture<Boolean> o) throws Exception;

	public Boolean getAlignerDroit() {
		return alignerDroit;
	}

	public void setAlignerDroit(Boolean o) throws Exception {
		this.alignerDroit = o;
	}
	public Chaine setAlignerDroit(String o) throws Exception {
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
	protected ArrayList<Icone> iconesAvant = new ArrayList<Icone>();
	public Couverture<ArrayList<Icone>> iconesAvantCouverture = new Couverture<ArrayList<Icone>>().p(this).c(ArrayList.class).var("iconesAvant").o(iconesAvant);

	/**	L'entité « iconesAvant »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut ArrayList<Icone>(). 
	 *	@param iconesAvant est le champ déjà construit. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _iconesAvant(ArrayList<Icone> l) throws Exception;

	public ArrayList<Icone> getIconesAvant() {
		return iconesAvant;
	}

	public void setIconesAvant(ArrayList<Icone> l) throws Exception {
		this.iconesAvant = l;
	}
	public Chaine addIconesAvant(Icone...objets) throws Exception {
		for(Icone o : objets) {
			addIconesAvant(o);
		}
		return (Chaine)this;
	}
	public Chaine addIconesAvant(Icone o) throws Exception {
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
	protected ArrayList<Icone> iconesApres = new ArrayList<Icone>();
	public Couverture<ArrayList<Icone>> iconesApresCouverture = new Couverture<ArrayList<Icone>>().p(this).c(ArrayList.class).var("iconesApres").o(iconesApres);

	/**	L'entité « iconesApres »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut ArrayList<Icone>(). 
	 *	@param iconesApres est le champ déjà construit. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _iconesApres(ArrayList<Icone> l) throws Exception;

	public ArrayList<Icone> getIconesApres() {
		return iconesApres;
	}

	public void setIconesApres(ArrayList<Icone> l) throws Exception {
		this.iconesApres = l;
	}
	public Chaine addIconesApres(Icone...objets) throws Exception {
		for(Icone o : objets) {
			addIconesApres(o);
		}
		return (Chaine)this;
	}
	public Chaine addIconesApres(Icone o) throws Exception {
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
	protected Double xDecalage;
	public Couverture<Double> xDecalageCouverture = new Couverture<Double>().p(this).c(Double.class).var("xDecalage").o(xDecalage);

	/**	L'entité « xDecalage »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _xDecalage(Couverture<Double> o) throws Exception;

	public Double getXDecalage() {
		return xDecalage;
	}

	public void setXDecalage(Double o) throws Exception {
		this.xDecalage = o;
	}
	public Chaine setXDecalage(String o) throws Exception {
		if(org.apache.commons.lang3.math.NumberUtils.isCreatable(o))
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
	protected Double yDecalage;
	public Couverture<Double> yDecalageCouverture = new Couverture<Double>().p(this).c(Double.class).var("yDecalage").o(yDecalage);

	/**	L'entité « yDecalage »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _yDecalage(Couverture<Double> o) throws Exception;

	public Double getYDecalage() {
		return yDecalage;
	}

	public void setYDecalage(Double o) throws Exception {
		this.yDecalage = o;
	}
	public Chaine setYDecalage(String o) throws Exception {
		if(org.apache.commons.lang3.math.NumberUtils.isCreatable(o))
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
	protected Double hLigne;
	public Couverture<Double> hLigneCouverture = new Couverture<Double>().p(this).c(Double.class).var("hLigne").o(hLigne);

	/**	L'entité « hLigne »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _hLigne(Couverture<Double> o) throws Exception;

	public Double getHLigne() {
		return hLigne;
	}

	public void setHLigne(Double o) throws Exception {
		this.hLigne = o;
	}
	public Chaine setHLigne(String o) throws Exception {
		if(org.apache.commons.lang3.math.NumberUtils.isCreatable(o))
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
	protected Double hEspace;
	public Couverture<Double> hEspaceCouverture = new Couverture<Double>().p(this).c(Double.class).var("hEspace").o(hEspace);

	/**	L'entité « hEspace »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _hEspace(Couverture<Double> o) throws Exception;

	public Double getHEspace() {
		return hEspace;
	}

	public void setHEspace(Double o) throws Exception {
		this.hEspace = o;
	}
	public Chaine setHEspace(String o) throws Exception {
		if(org.apache.commons.lang3.math.NumberUtils.isCreatable(o))
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
	protected ArrayList<Object> tout = new ArrayList<Object>();
	public Couverture<ArrayList<Object>> toutCouverture = new Couverture<ArrayList<Object>>().p(this).c(ArrayList.class).var("tout").o(tout);

	/**	L'entité « tout »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut ArrayList<Object>(). 
	 *	@param tout est le champ déjà construit. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _tout(ArrayList<Object> l) throws Exception;

	public ArrayList<Object> getTout() {
		return tout;
	}

	public void setTout(ArrayList<Object> l) throws Exception {
		this.tout = l;
	}
	public Chaine addTout(Object...objets) throws Exception {
		for(Object o : objets) {
			addTout(o);
		}
		return (Chaine)this;
	}
	public Chaine addTout(Object o) throws Exception {
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

	/////////////////////
	// initialiserLoin //
	/////////////////////

	protected boolean dejaInitialiseChaine = false;

	public void initLoinChaine(RequeteSite requeteSite) throws Exception {
		setRequeteSite_(requeteSite);
		initLoinChaine();
	}

	public void initLoinChaine() throws Exception {
		if(!dejaInitialiseChaine) {
			requeteSite_Init();
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

	public void initLoinPourClasse(RequeteSite requeteSite) throws Exception {
		initLoinChaine(requeteSite);
	}

	/////////////////
	// requeteSite //
	/////////////////

	public void requeteSiteChaine(RequeteSite requeteSite) throws Exception {
	}

	public void requeteSitePourClasse(RequeteSite requeteSite) throws Exception {
		requeteSiteChaine(requeteSite);
	}

	/////////////
	// obtenir //
	/////////////

	public Object obtenirPourClasse(String var) throws Exception {
		String[] vars = org.apache.commons.lang3.StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtenirChaine(v);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.obtenirPourClasse(v);
			}
		}
		return o;
	}
	public Object obtenirChaine(String var) throws Exception {
		Chaine oChaine = (Chaine)this;
		switch(var) {
			case "requeteSite_":
				return oChaine.requeteSite_;
			case "police":
				return oChaine.police;
			case "alignerCentre":
				return oChaine.alignerCentre;
			case "alignerGauche":
				return oChaine.alignerGauche;
			case "alignerDroit":
				return oChaine.alignerDroit;
			case "iconesAvant":
				return oChaine.iconesAvant;
			case "iconesApres":
				return oChaine.iconesApres;
			case "xDecalage":
				return oChaine.xDecalage;
			case "yDecalage":
				return oChaine.yDecalage;
			case "hLigne":
				return oChaine.hLigne;
			case "hEspace":
				return oChaine.hEspace;
			case "tout":
				return oChaine.tout;
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
				o = attribuerChaine(v, val);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.attribuerPourClasse(v, val);
			}
		}
		return o != null;
	}
	public Object attribuerChaine(String var, Object val) throws Exception {
		Chaine oChaine = (Chaine)this;
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
					o = definirChaine(v, val);
				else if(o instanceof Cluster) {
					Cluster cluster = (Cluster)o;
					o = cluster.definirPourClasse(v, val);
				}
			}
		}
		return o != null;
	}
	public Object definirChaine(String var, String val) throws Exception {
		Chaine oChaine = (Chaine)this;
		switch(var) {
			case "police":
				oChaine.setPolice(val);
				return val;
			case "alignerCentre":
				oChaine.setAlignerCentre(val);
				return val;
			case "alignerGauche":
				oChaine.setAlignerGauche(val);
				return val;
			case "alignerDroit":
				oChaine.setAlignerDroit(val);
				return val;
			case "xDecalage":
				oChaine.setXDecalage(val);
				return val;
			case "yDecalage":
				oChaine.setYDecalage(val);
				return val;
			case "hLigne":
				oChaine.setHLigne(val);
				return val;
			case "hEspace":
				oChaine.setHEspace(val);
				return val;
			default:
				return null;
		}
	}
}
