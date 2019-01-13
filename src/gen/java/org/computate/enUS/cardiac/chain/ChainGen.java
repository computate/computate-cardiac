package org.computate.enUS.cardiac.chain;

import java.util.Objects;
import org.computate.frFR.cardiaque.page.parti.Icone;
import org.computate.frFR.cardiaque.couverture.Couverture;
import java.lang.Double;
import org.computate.frFR.cardiaque.requete.RequeteSite;
import java.lang.Boolean;
import org.computate.enUS.cardiac.writer.AllWriter;
import org.apache.commons.text.StringEscapeUtils;
import java.lang.Object;
import java.lang.String;
import org.apache.commons.lang3.StringUtils;
import java.util.ArrayList;

/**	
 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.enUS.cardiac.chain.Chain&fq=classeEtendGen_indexed_boolean:true">Trouver la classe  dans Solr</a>
 * <br/>
 **/
public abstract class ChainGen<DEV> extends Object {

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
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.enUS.cardiac.chain.Chain&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:requeteSite_">Trouver l'entité requeteSite_ dans Solr</a>
	 * <br/>
	 * @param  est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _requeteSite_(Couverture<RequeteSite> );

	public RequeteSite get() {
		return requeteSite_;
	}

	public void set(RequeteSite ) {
		this.requeteSite_ = ;
		this.requeteSite_Couverture.dejaInitialise = true;
	}
	protected Chain requeteSite_Init() {
		if(!requeteSite_Couverture.dejaInitialise) {
			_requeteSite_(requeteSite_Couverture);
			if(requeteSite_ == null)
				set(requeteSite_Couverture.o);
		}
		requeteSite_Couverture.dejaInitialise(true);
		return (Chain)this;
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
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.enUS.cardiac.chain.Chain&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:police">Trouver l'entité police dans Solr</a>
	 * <br/>
	 * @param  est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _police(Couverture<String> );

	public String get() {
		return police;
	}

	public void set(String ) {
		this.police = ;
		this.policeCouverture.dejaInitialise = true;
	}
	protected Chain policeInit() {
		if(!policeCouverture.dejaInitialise) {
			_police(policeCouverture);
			if(police == null)
				set(policeCouverture.o);
		}
		policeCouverture.dejaInitialise(true);
		return (Chain)this;
	}

	public String solr() {
		return police;
	}

	public String str() {
		return police == null ? "" : police;
	}

	public String nomAffichage() {
		return null;
	}

	public String htmTooltip() {
		return null;
	}

	public String htm() {
		return police == null ? "" : StringEscapeUtils.escapeHtml4(str());
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
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.enUS.cardiac.chain.Chain&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:alignerCentre">Trouver l'entité alignerCentre dans Solr</a>
	 * <br/>
	 * @param  est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _alignerCentre(Couverture<Boolean> );

	public Boolean get() {
		return alignerCentre;
	}

	public void set(Boolean ) {
		this.alignerCentre = ;
		this.alignerCentreCouverture.dejaInitialise = true;
	}
	public Chain set(String o) {
		if(org.apache.commons.lang3.BooleanUtils.isTrue(org.apache.commons.lang3.BooleanUtils.toBoolean(o)))
			this.alignerCentre = Boolean.parseBoolean(o);
		this.alignerCentreCouverture.dejaInitialise = true;
		return (Chain)this;
	}
	protected Chain alignerCentreInit() {
		if(!alignerCentreCouverture.dejaInitialise) {
			_alignerCentre(alignerCentreCouverture);
			if(alignerCentre == null)
				set(alignerCentreCouverture.o);
		}
		alignerCentreCouverture.dejaInitialise(true);
		return (Chain)this;
	}

	public Boolean solr() {
		return alignerCentre;
	}

	public String str() {
		return alignerCentre == null ? "" : alignerCentre.toString();
	}

	public String nomAffichage() {
		return null;
	}

	public String htmTooltip() {
		return null;
	}

	public String htm() {
		return alignerCentre == null ? "" : StringEscapeUtils.escapeHtml4(str());
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
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.enUS.cardiac.chain.Chain&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:alignerGauche">Trouver l'entité alignerGauche dans Solr</a>
	 * <br/>
	 * @param  est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _alignerGauche(Couverture<Boolean> );

	public Boolean get() {
		return alignerGauche;
	}

	public void set(Boolean ) {
		this.alignerGauche = ;
		this.alignerGaucheCouverture.dejaInitialise = true;
	}
	public Chain set(String o) {
		if(org.apache.commons.lang3.BooleanUtils.isTrue(org.apache.commons.lang3.BooleanUtils.toBoolean(o)))
			this.alignerGauche = Boolean.parseBoolean(o);
		this.alignerGaucheCouverture.dejaInitialise = true;
		return (Chain)this;
	}
	protected Chain alignerGaucheInit() {
		if(!alignerGaucheCouverture.dejaInitialise) {
			_alignerGauche(alignerGaucheCouverture);
			if(alignerGauche == null)
				set(alignerGaucheCouverture.o);
		}
		alignerGaucheCouverture.dejaInitialise(true);
		return (Chain)this;
	}

	public Boolean solr() {
		return alignerGauche;
	}

	public String str() {
		return alignerGauche == null ? "" : alignerGauche.toString();
	}

	public String nomAffichage() {
		return null;
	}

	public String htmTooltip() {
		return null;
	}

	public String htm() {
		return alignerGauche == null ? "" : StringEscapeUtils.escapeHtml4(str());
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
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.enUS.cardiac.chain.Chain&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:alignerDroit">Trouver l'entité alignerDroit dans Solr</a>
	 * <br/>
	 * @param  est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _alignerDroit(Couverture<Boolean> );

	public Boolean get() {
		return alignerDroit;
	}

	public void set(Boolean ) {
		this.alignerDroit = ;
		this.alignerDroitCouverture.dejaInitialise = true;
	}
	public Chain set(String o) {
		if(org.apache.commons.lang3.BooleanUtils.isTrue(org.apache.commons.lang3.BooleanUtils.toBoolean(o)))
			this.alignerDroit = Boolean.parseBoolean(o);
		this.alignerDroitCouverture.dejaInitialise = true;
		return (Chain)this;
	}
	protected Chain alignerDroitInit() {
		if(!alignerDroitCouverture.dejaInitialise) {
			_alignerDroit(alignerDroitCouverture);
			if(alignerDroit == null)
				set(alignerDroitCouverture.o);
		}
		alignerDroitCouverture.dejaInitialise(true);
		return (Chain)this;
	}

	public Boolean solr() {
		return alignerDroit;
	}

	public String str() {
		return alignerDroit == null ? "" : alignerDroit.toString();
	}

	public String nomAffichage() {
		return null;
	}

	public String htmTooltip() {
		return null;
	}

	public String htm() {
		return alignerDroit == null ? "" : StringEscapeUtils.escapeHtml4(str());
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
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.enUS.cardiac.chain.Chain&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:iconesAvant">Trouver l'entité iconesAvant dans Solr</a>
	 * <br/>
	 * @param iconesAvant est l'entité déjà construit. 
	 **/
	protected abstract void _iconesAvant(ArrayList<Icone> );

	public ArrayList<Icone> get() {
		return iconesAvant;
	}

	public void set(ArrayList<Icone> ) {
		this.iconesAvant = ;
		this.iconesAvantCouverture.dejaInitialise = true;
	}
	public Chain add(...objets) {
		for( o : objets) {
			add(o);
		}
		return (Chain)this;
	}
	public Chain add( o) {
		if(o != null && !iconesAvant.contains(o))
			this.iconesAvant.add(o);
		return (Chain)this;
	}
	protected Chain iconesAvantInit() {
		if(!iconesAvantCouverture.dejaInitialise) {
			_iconesAvant(iconesAvant);
		}
		iconesAvantCouverture.dejaInitialise(true);
		return (Chain)this;
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
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.enUS.cardiac.chain.Chain&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:iconesApres">Trouver l'entité iconesApres dans Solr</a>
	 * <br/>
	 * @param iconesApres est l'entité déjà construit. 
	 **/
	protected abstract void _iconesApres(ArrayList<Icone> );

	public ArrayList<Icone> get() {
		return iconesApres;
	}

	public void set(ArrayList<Icone> ) {
		this.iconesApres = ;
		this.iconesApresCouverture.dejaInitialise = true;
	}
	public Chain add(...objets) {
		for( o : objets) {
			add(o);
		}
		return (Chain)this;
	}
	public Chain add( o) {
		if(o != null && !iconesApres.contains(o))
			this.iconesApres.add(o);
		return (Chain)this;
	}
	protected Chain iconesApresInit() {
		if(!iconesApresCouverture.dejaInitialise) {
			_iconesApres(iconesApres);
		}
		iconesApresCouverture.dejaInitialise(true);
		return (Chain)this;
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
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.enUS.cardiac.chain.Chain&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:xDecalage">Trouver l'entité xDecalage dans Solr</a>
	 * <br/>
	 * @param  est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _xDecalage(Couverture<Double> );

	public Double get() {
		return xDecalage;
	}

	public void set(Double ) {
		this.xDecalage = ;
		this.xDecalageCouverture.dejaInitialise = true;
	}
	public Chain set(String o) {
		if(org.apache.commons.lang3.math.NumberUtils.isCreatable(o))
			this.xDecalage = Double.parseDouble(o);
		this.xDecalageCouverture.dejaInitialise = true;
		return (Chain)this;
	}
	protected Chain xDecalageInit() {
		if(!xDecalageCouverture.dejaInitialise) {
			_xDecalage(xDecalageCouverture);
			if(xDecalage == null)
				set(xDecalageCouverture.o);
		}
		xDecalageCouverture.dejaInitialise(true);
		return (Chain)this;
	}

	public Double solr() {
		return xDecalage;
	}

	public String str() {
		return xDecalage == null ? "" : xDecalage.toString();
	}

	public String nomAffichage() {
		return null;
	}

	public String htmTooltip() {
		return null;
	}

	public String htm() {
		return xDecalage == null ? "" : StringEscapeUtils.escapeHtml4(str());
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
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.enUS.cardiac.chain.Chain&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:yDecalage">Trouver l'entité yDecalage dans Solr</a>
	 * <br/>
	 * @param  est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _yDecalage(Couverture<Double> );

	public Double get() {
		return yDecalage;
	}

	public void set(Double ) {
		this.yDecalage = ;
		this.yDecalageCouverture.dejaInitialise = true;
	}
	public Chain set(String o) {
		if(org.apache.commons.lang3.math.NumberUtils.isCreatable(o))
			this.yDecalage = Double.parseDouble(o);
		this.yDecalageCouverture.dejaInitialise = true;
		return (Chain)this;
	}
	protected Chain yDecalageInit() {
		if(!yDecalageCouverture.dejaInitialise) {
			_yDecalage(yDecalageCouverture);
			if(yDecalage == null)
				set(yDecalageCouverture.o);
		}
		yDecalageCouverture.dejaInitialise(true);
		return (Chain)this;
	}

	public Double solr() {
		return yDecalage;
	}

	public String str() {
		return yDecalage == null ? "" : yDecalage.toString();
	}

	public String nomAffichage() {
		return null;
	}

	public String htmTooltip() {
		return null;
	}

	public String htm() {
		return yDecalage == null ? "" : StringEscapeUtils.escapeHtml4(str());
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
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.enUS.cardiac.chain.Chain&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:hLigne">Trouver l'entité hLigne dans Solr</a>
	 * <br/>
	 * @param  est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _hLigne(Couverture<Double> );

	public Double get() {
		return hLigne;
	}

	public void set(Double ) {
		this.hLigne = ;
		this.hLigneCouverture.dejaInitialise = true;
	}
	public Chain set(String o) {
		if(org.apache.commons.lang3.math.NumberUtils.isCreatable(o))
			this.hLigne = Double.parseDouble(o);
		this.hLigneCouverture.dejaInitialise = true;
		return (Chain)this;
	}
	protected Chain hLigneInit() {
		if(!hLigneCouverture.dejaInitialise) {
			_hLigne(hLigneCouverture);
			if(hLigne == null)
				set(hLigneCouverture.o);
		}
		hLigneCouverture.dejaInitialise(true);
		return (Chain)this;
	}

	public Double solr() {
		return hLigne;
	}

	public String str() {
		return hLigne == null ? "" : hLigne.toString();
	}

	public String nomAffichage() {
		return null;
	}

	public String htmTooltip() {
		return null;
	}

	public String htm() {
		return hLigne == null ? "" : StringEscapeUtils.escapeHtml4(str());
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
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.enUS.cardiac.chain.Chain&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:hEspace">Trouver l'entité hEspace dans Solr</a>
	 * <br/>
	 * @param  est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _hEspace(Couverture<Double> );

	public Double get() {
		return hEspace;
	}

	public void set(Double ) {
		this.hEspace = ;
		this.hEspaceCouverture.dejaInitialise = true;
	}
	public Chain set(String o) {
		if(org.apache.commons.lang3.math.NumberUtils.isCreatable(o))
			this.hEspace = Double.parseDouble(o);
		this.hEspaceCouverture.dejaInitialise = true;
		return (Chain)this;
	}
	protected Chain hEspaceInit() {
		if(!hEspaceCouverture.dejaInitialise) {
			_hEspace(hEspaceCouverture);
			if(hEspace == null)
				set(hEspaceCouverture.o);
		}
		hEspaceCouverture.dejaInitialise(true);
		return (Chain)this;
	}

	public Double solr() {
		return hEspace;
	}

	public String str() {
		return hEspace == null ? "" : hEspace.toString();
	}

	public String nomAffichage() {
		return null;
	}

	public String htmTooltip() {
		return null;
	}

	public String htm() {
		return hEspace == null ? "" : StringEscapeUtils.escapeHtml4(str());
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
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.enUS.cardiac.chain.Chain&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:tout">Trouver l'entité tout dans Solr</a>
	 * <br/>
	 * @param tout est l'entité déjà construit. 
	 **/
	protected abstract void _tout(ArrayList<Object> );

	public ArrayList<Object> get() {
		return tout;
	}

	public void set(ArrayList<Object> ) {
		this.tout = ;
		this.toutCouverture.dejaInitialise = true;
	}
	public Chain add(...objets) {
		for( o : objets) {
			add(o);
		}
		return (Chain)this;
	}
	public Chain add( o) {
		if(o != null && !tout.contains(o))
			this.tout.add(o);
		return (Chain)this;
	}
	protected Chain toutInit() {
		if(!toutCouverture.dejaInitialise) {
			_tout(tout);
		}
		toutCouverture.dejaInitialise(true);
		return (Chain)this;
	}

	//////////////
	// initLoin //
	//////////////

	protected boolean dejaInitialiseChain = false;

	public Chain initLoinChain(RequeteSite requeteSite) {
		setRequeteSite_(requeteSite);
		if(!dejaInitialiseChain) {
			dejaInitialiseChain = true;
			initLoinChain();
		}
		return (Chain)this;
	}

	public void initLoinChain() {
		initChain();
	}

	public void initChain() {
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

	public void initLoinPourClasse(RequeteSite requeteSite) {
		initLoinChain(requeteSite);
	}

	/////////////////
	// requeteSite //
	/////////////////

	public void requeteSiteChain(RequeteSite requeteSite) {
	}

	public void requeteSitePourClasse(RequeteSite requeteSite) {
		requeteSiteChain(requeteSite);
	}

	/////////////
	// obtenir //
	/////////////

	public Object obtenirPourClasse(String var) throws Exception {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtenirChain(v);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.obtenirPourClasse(v);
			}
		}
		return o;
	}
	public Object obtenirChain(String var) throws Exception {
		Chain oChain = (Chain)this;
		switch(var) {
			case "requeteSite_":
				return oChain.requeteSite_;
			case "police":
				return oChain.police;
			case "alignerCentre":
				return oChain.alignerCentre;
			case "alignerGauche":
				return oChain.alignerGauche;
			case "alignerDroit":
				return oChain.alignerDroit;
			case "iconesAvant":
				return oChain.iconesAvant;
			case "iconesApres":
				return oChain.iconesApres;
			case "xDecalage":
				return oChain.xDecalage;
			case "yDecalage":
				return oChain.yDecalage;
			case "hLigne":
				return oChain.hLigne;
			case "hEspace":
				return oChain.hEspace;
			case "tout":
				return oChain.tout;
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
				o = attribuerChain(v, val);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.attribuerPourClasse(v, val);
			}
		}
		return o != null;
	}
	public Object attribuerChain(String var, Object val) {
		Chain oChain = (Chain)this;
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
					o = definirChain(v, val);
				else if(o instanceof Cluster) {
					Cluster cluster = (Cluster)o;
					o = cluster.definirPourClasse(v, val);
				}
			}
		}
		return o != null;
	}
	public Object definirChain(String var, String val) {
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
		if(!(o instanceof Chain))
			return false;
		Chain that = (Chain)o;
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
		sb.append("Chain {");
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
