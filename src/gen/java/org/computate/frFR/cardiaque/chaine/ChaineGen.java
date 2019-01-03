package org.computate.frFR.cardiaque.chaine;

import org.computate.frFR.cardiaque.page.parti.Icone;
import org.computate.frFR.cardiaque.couverture.Couverture;
import java.lang.Double;
import org.computate.frFR.cardiaque.cluster.Cluster;
import org.apache.commons.text.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import java.util.ArrayList;
import java.util.Objects;
import io.vertx.core.http.HttpServerResponse;
import org.computate.frFR.cardiaque.requete.RequeteSite;
import java.lang.Boolean;
import java.lang.Object;
import java.lang.String;

/**	
 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.frFR.cardiaque.chaine.Chaine&fq=classeEtendGen_indexed_boolean:true">Trouver la classe  dans Solr</a>
 * <br/>
 **/
public abstract class ChaineGen<DEV> extends Object {

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
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.frFR.cardiaque.chaine.Chaine&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:requeteSite_">Trouver l'entité requeteSite_ dans Solr</a>
	 * <br/>
	 * @param o est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _requeteSite_(Couverture<RequeteSite> o);

	public RequeteSite getRequeteSite_() {
		return requeteSite_;
	}

	public void setRequeteSite_(RequeteSite o) {
		this.requeteSite_ = o;
		this.requeteSite_Couverture.dejaInitialise = true;
	}
	protected Chaine requeteSite_Init()
 {
		if(!requeteSite_Couverture.dejaInitialise) {
			_requeteSite_(requeteSite_Couverture);
			if(requeteSite_ == null)
				setRequeteSite_(requeteSite_Couverture.o);
		}
		requeteSite_Couverture.dejaInitialise(true);
		return (Chaine)this;
	}

	////////////
	// police //
	////////////

	/**	L'entité « police »
	 *	 is defined as null before being initialized. 
	 */
	protected String police;
	public Couverture<String> policeCouverture = new Couverture<String>().p(this).c(String.class).var("police").o(police);

	/**	<br/>L'entité « police »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.frFR.cardiaque.chaine.Chaine&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:police">Trouver l'entité police dans Solr</a>
	 * <br/>
	 * @param o est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _police(Couverture<String> o);

	public String getPolice() {
		return police;
	}

	public void setPolice(String o) {
		this.police = o;
		this.policeCouverture.dejaInitialise = true;
	}
	protected Chaine policeInit()
 {
		if(!policeCouverture.dejaInitialise) {
			_police(policeCouverture);
			if(police == null)
				setPolice(policeCouverture.o);
		}
		policeCouverture.dejaInitialise(true);
		return (Chaine)this;
	}

	public String solrPolice() {
		return police;
	}

	public String strPolice() {
		return police == null ? "" : police;
	}

	public String nomAffichagePolice() {
		return null;
	}

	public String htmlTooltipPolice() {
		return null;
	}

	public String htmlPolice() {
		return police == null ? "" : StringEscapeUtils.escapeHtml4(strPolice());
	}

	///////////////////
	// alignerCentre //
	///////////////////

	/**	L'entité « alignerCentre »
	 *	 is defined as null before being initialized. 
	 */
	protected Boolean alignerCentre;
	public Couverture<Boolean> alignerCentreCouverture = new Couverture<Boolean>().p(this).c(Boolean.class).var("alignerCentre").o(alignerCentre);

	/**	<br/>L'entité « alignerCentre »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.frFR.cardiaque.chaine.Chaine&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:alignerCentre">Trouver l'entité alignerCentre dans Solr</a>
	 * <br/>
	 * @param o est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _alignerCentre(Couverture<Boolean> o);

	public Boolean getAlignerCentre() {
		return alignerCentre;
	}

	public void setAlignerCentre(Boolean o) {
		this.alignerCentre = o;
		this.alignerCentreCouverture.dejaInitialise = true;
	}
	public Chaine setAlignerCentre(String o) throws Exception {
		if(org.apache.commons.lang3.BooleanUtils.isTrue(org.apache.commons.lang3.BooleanUtils.toBoolean(o)))
			this.alignerCentre = Boolean.parseBoolean(o);
		this.alignerCentreCouverture.dejaInitialise = true;
		return (Chaine)this;
	}
	protected Chaine alignerCentreInit()
 {
		if(!alignerCentreCouverture.dejaInitialise) {
			_alignerCentre(alignerCentreCouverture);
			if(alignerCentre == null)
				setAlignerCentre(alignerCentreCouverture.o);
		}
		alignerCentreCouverture.dejaInitialise(true);
		return (Chaine)this;
	}

	public Boolean solrAlignerCentre() {
		return alignerCentre;
	}

	public String strAlignerCentre() {
		return alignerCentre == null ? "" : alignerCentre.toString();
	}

	public String nomAffichageAlignerCentre() {
		return null;
	}

	public String htmlTooltipAlignerCentre() {
		return null;
	}

	public String htmlAlignerCentre() {
		return alignerCentre == null ? "" : StringEscapeUtils.escapeHtml4(strAlignerCentre());
	}

	///////////////////
	// alignerGauche //
	///////////////////

	/**	L'entité « alignerGauche »
	 *	 is defined as null before being initialized. 
	 */
	protected Boolean alignerGauche;
	public Couverture<Boolean> alignerGaucheCouverture = new Couverture<Boolean>().p(this).c(Boolean.class).var("alignerGauche").o(alignerGauche);

	/**	<br/>L'entité « alignerGauche »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.frFR.cardiaque.chaine.Chaine&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:alignerGauche">Trouver l'entité alignerGauche dans Solr</a>
	 * <br/>
	 * @param o est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _alignerGauche(Couverture<Boolean> o);

	public Boolean getAlignerGauche() {
		return alignerGauche;
	}

	public void setAlignerGauche(Boolean o) {
		this.alignerGauche = o;
		this.alignerGaucheCouverture.dejaInitialise = true;
	}
	public Chaine setAlignerGauche(String o) throws Exception {
		if(org.apache.commons.lang3.BooleanUtils.isTrue(org.apache.commons.lang3.BooleanUtils.toBoolean(o)))
			this.alignerGauche = Boolean.parseBoolean(o);
		this.alignerGaucheCouverture.dejaInitialise = true;
		return (Chaine)this;
	}
	protected Chaine alignerGaucheInit()
 {
		if(!alignerGaucheCouverture.dejaInitialise) {
			_alignerGauche(alignerGaucheCouverture);
			if(alignerGauche == null)
				setAlignerGauche(alignerGaucheCouverture.o);
		}
		alignerGaucheCouverture.dejaInitialise(true);
		return (Chaine)this;
	}

	public Boolean solrAlignerGauche() {
		return alignerGauche;
	}

	public String strAlignerGauche() {
		return alignerGauche == null ? "" : alignerGauche.toString();
	}

	public String nomAffichageAlignerGauche() {
		return null;
	}

	public String htmlTooltipAlignerGauche() {
		return null;
	}

	public String htmlAlignerGauche() {
		return alignerGauche == null ? "" : StringEscapeUtils.escapeHtml4(strAlignerGauche());
	}

	//////////////////
	// alignerDroit //
	//////////////////

	/**	L'entité « alignerDroit »
	 *	 is defined as null before being initialized. 
	 */
	protected Boolean alignerDroit;
	public Couverture<Boolean> alignerDroitCouverture = new Couverture<Boolean>().p(this).c(Boolean.class).var("alignerDroit").o(alignerDroit);

	/**	<br/>L'entité « alignerDroit »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.frFR.cardiaque.chaine.Chaine&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:alignerDroit">Trouver l'entité alignerDroit dans Solr</a>
	 * <br/>
	 * @param o est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _alignerDroit(Couverture<Boolean> o);

	public Boolean getAlignerDroit() {
		return alignerDroit;
	}

	public void setAlignerDroit(Boolean o) {
		this.alignerDroit = o;
		this.alignerDroitCouverture.dejaInitialise = true;
	}
	public Chaine setAlignerDroit(String o) throws Exception {
		if(org.apache.commons.lang3.BooleanUtils.isTrue(org.apache.commons.lang3.BooleanUtils.toBoolean(o)))
			this.alignerDroit = Boolean.parseBoolean(o);
		this.alignerDroitCouverture.dejaInitialise = true;
		return (Chaine)this;
	}
	protected Chaine alignerDroitInit()
 {
		if(!alignerDroitCouverture.dejaInitialise) {
			_alignerDroit(alignerDroitCouverture);
			if(alignerDroit == null)
				setAlignerDroit(alignerDroitCouverture.o);
		}
		alignerDroitCouverture.dejaInitialise(true);
		return (Chaine)this;
	}

	public Boolean solrAlignerDroit() {
		return alignerDroit;
	}

	public String strAlignerDroit() {
		return alignerDroit == null ? "" : alignerDroit.toString();
	}

	public String nomAffichageAlignerDroit() {
		return null;
	}

	public String htmlTooltipAlignerDroit() {
		return null;
	}

	public String htmlAlignerDroit() {
		return alignerDroit == null ? "" : StringEscapeUtils.escapeHtml4(strAlignerDroit());
	}

	/////////////////
	// iconesAvant //
	/////////////////

	/**	L'entité « iconesAvant »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut ArrayList<Icone>(). 
	 */
	protected ArrayList<Icone> iconesAvant = new ArrayList<Icone>();
	public Couverture<ArrayList<Icone>> iconesAvantCouverture = new Couverture<ArrayList<Icone>>().p(this).c(ArrayList.class).var("iconesAvant").o(iconesAvant);

	/**	<br/>L'entité « iconesAvant »
	 * Il est construit avant d'être initialisé avec le constructeur par défaut ArrayList<Icone>(). 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.frFR.cardiaque.chaine.Chaine&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:iconesAvant">Trouver l'entité iconesAvant dans Solr</a>
	 * <br/>
	 * @param iconesAvant est l'entité déjà construit. 
	 **/
	protected abstract void _iconesAvant(ArrayList<Icone> l);

	public ArrayList<Icone> getIconesAvant() {
		return iconesAvant;
	}

	public void setIconesAvant(ArrayList<Icone> l) {
		this.iconesAvant = l;
		this.iconesAvantCouverture.dejaInitialise = true;
	}
	public Chaine addIconesAvant(Icone...objets) {
		for(Icone o : objets) {
			addIconesAvant(o);
		}
		return (Chaine)this;
	}
	public Chaine addIconesAvant(Icone o) {
		if(o != null && !iconesAvant.contains(o))
			this.iconesAvant.add(o);
		return (Chaine)this;
	}
	protected Chaine iconesAvantInit()
 {
		if(!iconesAvantCouverture.dejaInitialise) {
			_iconesAvant(iconesAvant);
		}
		iconesAvantCouverture.dejaInitialise(true);
		return (Chaine)this;
	}

	/////////////////
	// iconesApres //
	/////////////////

	/**	L'entité « iconesApres »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut ArrayList<Icone>(). 
	 */
	protected ArrayList<Icone> iconesApres = new ArrayList<Icone>();
	public Couverture<ArrayList<Icone>> iconesApresCouverture = new Couverture<ArrayList<Icone>>().p(this).c(ArrayList.class).var("iconesApres").o(iconesApres);

	/**	<br/>L'entité « iconesApres »
	 * Il est construit avant d'être initialisé avec le constructeur par défaut ArrayList<Icone>(). 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.frFR.cardiaque.chaine.Chaine&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:iconesApres">Trouver l'entité iconesApres dans Solr</a>
	 * <br/>
	 * @param iconesApres est l'entité déjà construit. 
	 **/
	protected abstract void _iconesApres(ArrayList<Icone> l);

	public ArrayList<Icone> getIconesApres() {
		return iconesApres;
	}

	public void setIconesApres(ArrayList<Icone> l) {
		this.iconesApres = l;
		this.iconesApresCouverture.dejaInitialise = true;
	}
	public Chaine addIconesApres(Icone...objets) {
		for(Icone o : objets) {
			addIconesApres(o);
		}
		return (Chaine)this;
	}
	public Chaine addIconesApres(Icone o) {
		if(o != null && !iconesApres.contains(o))
			this.iconesApres.add(o);
		return (Chaine)this;
	}
	protected Chaine iconesApresInit()
 {
		if(!iconesApresCouverture.dejaInitialise) {
			_iconesApres(iconesApres);
		}
		iconesApresCouverture.dejaInitialise(true);
		return (Chaine)this;
	}

	///////////////
	// xDecalage //
	///////////////

	/**	L'entité « xDecalage »
	 *	 is defined as null before being initialized. 
	 */
	protected Double xDecalage;
	public Couverture<Double> xDecalageCouverture = new Couverture<Double>().p(this).c(Double.class).var("xDecalage").o(xDecalage);

	/**	<br/>L'entité « xDecalage »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.frFR.cardiaque.chaine.Chaine&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:xDecalage">Trouver l'entité xDecalage dans Solr</a>
	 * <br/>
	 * @param o est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _xDecalage(Couverture<Double> o);

	public Double getXDecalage() {
		return xDecalage;
	}

	public void setXDecalage(Double o) {
		this.xDecalage = o;
		this.xDecalageCouverture.dejaInitialise = true;
	}
	public Chaine setXDecalage(String o) throws Exception {
		if(org.apache.commons.lang3.math.NumberUtils.isCreatable(o))
			this.xDecalage = Double.parseDouble(o);
		this.xDecalageCouverture.dejaInitialise = true;
		return (Chaine)this;
	}
	protected Chaine xDecalageInit()
 {
		if(!xDecalageCouverture.dejaInitialise) {
			_xDecalage(xDecalageCouverture);
			if(xDecalage == null)
				setXDecalage(xDecalageCouverture.o);
		}
		xDecalageCouverture.dejaInitialise(true);
		return (Chaine)this;
	}

	public Double solrXDecalage() {
		return xDecalage;
	}

	public String strXDecalage() {
		return xDecalage == null ? "" : xDecalage.toString();
	}

	public String nomAffichageXDecalage() {
		return null;
	}

	public String htmlTooltipXDecalage() {
		return null;
	}

	public String htmlXDecalage() {
		return xDecalage == null ? "" : StringEscapeUtils.escapeHtml4(strXDecalage());
	}

	///////////////
	// yDecalage //
	///////////////

	/**	L'entité « yDecalage »
	 *	 is defined as null before being initialized. 
	 */
	protected Double yDecalage;
	public Couverture<Double> yDecalageCouverture = new Couverture<Double>().p(this).c(Double.class).var("yDecalage").o(yDecalage);

	/**	<br/>L'entité « yDecalage »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.frFR.cardiaque.chaine.Chaine&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:yDecalage">Trouver l'entité yDecalage dans Solr</a>
	 * <br/>
	 * @param o est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _yDecalage(Couverture<Double> o);

	public Double getYDecalage() {
		return yDecalage;
	}

	public void setYDecalage(Double o) {
		this.yDecalage = o;
		this.yDecalageCouverture.dejaInitialise = true;
	}
	public Chaine setYDecalage(String o) throws Exception {
		if(org.apache.commons.lang3.math.NumberUtils.isCreatable(o))
			this.yDecalage = Double.parseDouble(o);
		this.yDecalageCouverture.dejaInitialise = true;
		return (Chaine)this;
	}
	protected Chaine yDecalageInit()
 {
		if(!yDecalageCouverture.dejaInitialise) {
			_yDecalage(yDecalageCouverture);
			if(yDecalage == null)
				setYDecalage(yDecalageCouverture.o);
		}
		yDecalageCouverture.dejaInitialise(true);
		return (Chaine)this;
	}

	public Double solrYDecalage() {
		return yDecalage;
	}

	public String strYDecalage() {
		return yDecalage == null ? "" : yDecalage.toString();
	}

	public String nomAffichageYDecalage() {
		return null;
	}

	public String htmlTooltipYDecalage() {
		return null;
	}

	public String htmlYDecalage() {
		return yDecalage == null ? "" : StringEscapeUtils.escapeHtml4(strYDecalage());
	}

	////////////
	// hLigne //
	////////////

	/**	L'entité « hLigne »
	 *	 is defined as null before being initialized. 
	 */
	protected Double hLigne;
	public Couverture<Double> hLigneCouverture = new Couverture<Double>().p(this).c(Double.class).var("hLigne").o(hLigne);

	/**	<br/>L'entité « hLigne »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.frFR.cardiaque.chaine.Chaine&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:hLigne">Trouver l'entité hLigne dans Solr</a>
	 * <br/>
	 * @param o est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _hLigne(Couverture<Double> o);

	public Double getHLigne() {
		return hLigne;
	}

	public void setHLigne(Double o) {
		this.hLigne = o;
		this.hLigneCouverture.dejaInitialise = true;
	}
	public Chaine setHLigne(String o) throws Exception {
		if(org.apache.commons.lang3.math.NumberUtils.isCreatable(o))
			this.hLigne = Double.parseDouble(o);
		this.hLigneCouverture.dejaInitialise = true;
		return (Chaine)this;
	}
	protected Chaine hLigneInit()
 {
		if(!hLigneCouverture.dejaInitialise) {
			_hLigne(hLigneCouverture);
			if(hLigne == null)
				setHLigne(hLigneCouverture.o);
		}
		hLigneCouverture.dejaInitialise(true);
		return (Chaine)this;
	}

	public Double solrHLigne() {
		return hLigne;
	}

	public String strHLigne() {
		return hLigne == null ? "" : hLigne.toString();
	}

	public String nomAffichageHLigne() {
		return null;
	}

	public String htmlTooltipHLigne() {
		return null;
	}

	public String htmlHLigne() {
		return hLigne == null ? "" : StringEscapeUtils.escapeHtml4(strHLigne());
	}

	/////////////
	// hEspace //
	/////////////

	/**	L'entité « hEspace »
	 *	 is defined as null before being initialized. 
	 */
	protected Double hEspace;
	public Couverture<Double> hEspaceCouverture = new Couverture<Double>().p(this).c(Double.class).var("hEspace").o(hEspace);

	/**	<br/>L'entité « hEspace »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.frFR.cardiaque.chaine.Chaine&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:hEspace">Trouver l'entité hEspace dans Solr</a>
	 * <br/>
	 * @param o est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _hEspace(Couverture<Double> o);

	public Double getHEspace() {
		return hEspace;
	}

	public void setHEspace(Double o) {
		this.hEspace = o;
		this.hEspaceCouverture.dejaInitialise = true;
	}
	public Chaine setHEspace(String o) throws Exception {
		if(org.apache.commons.lang3.math.NumberUtils.isCreatable(o))
			this.hEspace = Double.parseDouble(o);
		this.hEspaceCouverture.dejaInitialise = true;
		return (Chaine)this;
	}
	protected Chaine hEspaceInit()
 {
		if(!hEspaceCouverture.dejaInitialise) {
			_hEspace(hEspaceCouverture);
			if(hEspace == null)
				setHEspace(hEspaceCouverture.o);
		}
		hEspaceCouverture.dejaInitialise(true);
		return (Chaine)this;
	}

	public Double solrHEspace() {
		return hEspace;
	}

	public String strHEspace() {
		return hEspace == null ? "" : hEspace.toString();
	}

	public String nomAffichageHEspace() {
		return null;
	}

	public String htmlTooltipHEspace() {
		return null;
	}

	public String htmlHEspace() {
		return hEspace == null ? "" : StringEscapeUtils.escapeHtml4(strHEspace());
	}

	//////////
	// tout //
	//////////

	/**	L'entité « tout »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut ArrayList<Object>(). 
	 */
	protected ArrayList<Object> tout = new ArrayList<Object>();
	public Couverture<ArrayList<Object>> toutCouverture = new Couverture<ArrayList<Object>>().p(this).c(ArrayList.class).var("tout").o(tout);

	/**	<br/>L'entité « tout »
	 * Il est construit avant d'être initialisé avec le constructeur par défaut ArrayList<Object>(). 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.frFR.cardiaque.chaine.Chaine&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:tout">Trouver l'entité tout dans Solr</a>
	 * <br/>
	 * @param tout est l'entité déjà construit. 
	 **/
	protected abstract void _tout(ArrayList<Object> l);

	public ArrayList<Object> getTout() {
		return tout;
	}

	public void setTout(ArrayList<Object> l) {
		this.tout = l;
		this.toutCouverture.dejaInitialise = true;
	}
	public Chaine addTout(Object...objets) {
		for(Object o : objets) {
			addTout(o);
		}
		return (Chaine)this;
	}
	public Chaine addTout(Object o) {
		if(o != null && !tout.contains(o))
			this.tout.add(o);
		return (Chaine)this;
	}
	protected Chaine toutInit()
 {
		if(!toutCouverture.dejaInitialise) {
			_tout(tout);
		}
		toutCouverture.dejaInitialise(true);
		return (Chaine)this;
	}

	//////////////
	// initLoin //
	//////////////

	protected boolean dejaInitialiseChaine = false;

	public Chaine initLoinChaine(RequeteSite requeteSite) {
		setRequeteSite_(requeteSite);
		initLoinChaine();
		return (Chaine)this;
	}

	public Chaine initLoinChaine() {
		if(!dejaInitialiseChaine) {
			dejaInitialiseChaine = true;
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
		}
		return (Chaine)this;
	}

	public void initLoinPourClasse(RequeteSite requeteSite) {
		initLoinChaine(requeteSite);
	}

	/////////////////
	// requeteSite //
	/////////////////

	public void requeteSiteChaine(RequeteSite requeteSite) {
	}

	public void requeteSitePourClasse(RequeteSite requeteSite) {
		requeteSiteChaine(requeteSite);
	}

	/////////////
	// obtenir //
	/////////////

	public Object obtenirPourClasse(String var) throws Exception {
		String[] vars = StringUtils.split(var, ".");
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
		String[] vars = StringUtils.split(var, ".");
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

	//////////////
	// hashCode //
	//////////////

	@Override public int hashCode() {
		return Objects.hash(police, alignerCentre, alignerGauche, alignerDroit, xDecalage, yDecalage, hLigne, hEspace);
	}

	////////////
	// equals //
	////////////

	@Override public boolean equals(Object o) {
		if(this == o)
			return true;
		if(!(o instanceof Chaine))
			return false;
		Chaine that = (Chaine)o;
		return Objects.equals( police, that.police )
				&& Objects.equals( alignerCentre, that.alignerCentre )
				&& Objects.equals( alignerGauche, that.alignerGauche )
				&& Objects.equals( alignerDroit, that.alignerDroit )
				&& Objects.equals( xDecalage, that.xDecalage )
				&& Objects.equals( yDecalage, that.yDecalage )
				&& Objects.equals( hLigne, that.hLigne )
				&& Objects.equals( hEspace, that.hEspace );
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Chaine {");
		sb.append( "police: \"" ).append(police).append( "\"" );
		sb.append( ", alignerCentre: " ).append(alignerCentre);
		sb.append( ", alignerGauche: " ).append(alignerGauche);
		sb.append( ", alignerDroit: " ).append(alignerDroit);
		sb.append( ", xDecalage: " ).append(xDecalage);
		sb.append( ", yDecalage: " ).append(yDecalage);
		sb.append( ", hLigne: " ).append(hLigne);
		sb.append( ", hEspace: " ).append(hEspace);
		sb.append(" }");
		return sb.toString();
	}
}
