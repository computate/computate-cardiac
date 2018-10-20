package com.heytate.frFR.cardiaque.utilisateur;

import java.lang.Long;
import java.time.ZonedDateTime;
import com.heytate.frFR.cardiaque.requete.RequeteSite;
import java.lang.Boolean;
import java.lang.Object;
import java.lang.String;
import com.heytate.frFR.cardiaque.cluster.Cluster;
import com.heytate.frFR.cardiaque.couverture.Couverture;
import java.util.ArrayList;

public abstract class UtilisateurSiteGen<DEV> extends Object {

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

	////////////////
	// equipeCles //
	////////////////

	/**	L'entité « equipeCles »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut ArrayList<Long>(). 
	 */
	public ArrayList<Long> equipeCles = new ArrayList<Long>();
	public Couverture<ArrayList<Long>> equipeClesCouverture = new Couverture<ArrayList<Long>>().p(this).c(ArrayList.class).var("equipeCles").o(equipeCles);

	/**	L'entité « equipeCles »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut ArrayList<Long>(). 
	 *	@param equipeCles est le champ déjà construit. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _equipeCles(ArrayList<Long> l) throws Exception;

	public void setEquipeCles(ArrayList<Long> l) throws Exception {
		this.equipeCles = l;
	}

	public ArrayList<Long> getEquipeCles() throws Exception {
		return equipeCles;
	}
	public UtilisateurSite equipeCles(String o) throws Exception {
		if(org.apache.commons.lang3.math.NumberUtils.isNumber(o)) {
			Long l = Long.parseLong(o);
			equipeClesAjouter(l);
		}
		return (UtilisateurSite)this;
	}
	public UtilisateurSite equipeClesAjouter(Long...objets) throws Exception {
		for(Long o : objets) {
			equipeClesAjouter(o);
		}
		return (UtilisateurSite)this;
	}
	public UtilisateurSite equipeClesAjouter(Long o) throws Exception {
		if(o != null && !equipeCles.contains(o))
			this.equipeCles.add(o);
		return (UtilisateurSite)this;
	}
	protected void equipeClesInit() throws Exception {
		if(!equipeClesCouverture.dejaInitialise) {
			_equipeCles(equipeCles);
		}
		equipeClesCouverture.dejaInitialise(true);
	}

	////////////////////
	// utilisateurNom //
	////////////////////

	/**	L'entité « utilisateurNom »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public String utilisateurNom;
	public Couverture<String> utilisateurNomCouverture = new Couverture<String>().p(this).c(String.class).var("utilisateurNom").o(utilisateurNom);

	/**	L'entité « utilisateurNom »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _utilisateurNom(Couverture<String> o) throws Exception;

	public void setUtilisateurNom(String o) throws Exception {
		this.utilisateurNom = o;
	}

	public String getUtilisateurNom() throws Exception {
		return utilisateurNom;
	}
	protected void utilisateurNomInit() throws Exception {
		if(!utilisateurNomCouverture.dejaInitialise) {
			_utilisateurNom(utilisateurNomCouverture);
			if(utilisateurNom == null)
				setUtilisateurNom(utilisateurNomCouverture.o);
		}
		utilisateurNomCouverture.dejaInitialise(true);
	}

	/////////////////////
	// utilisateurMail //
	/////////////////////

	/**	L'entité « utilisateurMail »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public String utilisateurMail;
	public Couverture<String> utilisateurMailCouverture = new Couverture<String>().p(this).c(String.class).var("utilisateurMail").o(utilisateurMail);

	/**	L'entité « utilisateurMail »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _utilisateurMail(Couverture<String> o) throws Exception;

	public void setUtilisateurMail(String o) throws Exception {
		this.utilisateurMail = o;
	}

	public String getUtilisateurMail() throws Exception {
		return utilisateurMail;
	}
	protected void utilisateurMailInit() throws Exception {
		if(!utilisateurMailCouverture.dejaInitialise) {
			_utilisateurMail(utilisateurMailCouverture);
			if(utilisateurMail == null)
				setUtilisateurMail(utilisateurMailCouverture.o);
		}
		utilisateurMailCouverture.dejaInitialise(true);
	}

	///////////////////
	// utilisateurId //
	///////////////////

	/**	L'entité « utilisateurId »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public String utilisateurId;
	public Couverture<String> utilisateurIdCouverture = new Couverture<String>().p(this).c(String.class).var("utilisateurId").o(utilisateurId);

	/**	L'entité « utilisateurId »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _utilisateurId(Couverture<String> o) throws Exception;

	public void setUtilisateurId(String o) throws Exception {
		this.utilisateurId = o;
	}

	public String getUtilisateurId() throws Exception {
		return utilisateurId;
	}
	protected void utilisateurIdInit() throws Exception {
		if(!utilisateurIdCouverture.dejaInitialise) {
			_utilisateurId(utilisateurIdCouverture);
			if(utilisateurId == null)
				setUtilisateurId(utilisateurIdCouverture.o);
		}
		utilisateurIdCouverture.dejaInitialise(true);
	}

	///////////////////////
	// utilisateurPrenom //
	///////////////////////

	/**	L'entité « utilisateurPrenom »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public String utilisateurPrenom;
	public Couverture<String> utilisateurPrenomCouverture = new Couverture<String>().p(this).c(String.class).var("utilisateurPrenom").o(utilisateurPrenom);

	/**	L'entité « utilisateurPrenom »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _utilisateurPrenom(Couverture<String> o) throws Exception;

	public void setUtilisateurPrenom(String o) throws Exception {
		this.utilisateurPrenom = o;
	}

	public String getUtilisateurPrenom() throws Exception {
		return utilisateurPrenom;
	}
	protected void utilisateurPrenomInit() throws Exception {
		if(!utilisateurPrenomCouverture.dejaInitialise) {
			_utilisateurPrenom(utilisateurPrenomCouverture);
			if(utilisateurPrenom == null)
				setUtilisateurPrenom(utilisateurPrenomCouverture.o);
		}
		utilisateurPrenomCouverture.dejaInitialise(true);
	}

	///////////////////////////
	// utilisateurNomFamille //
	///////////////////////////

	/**	L'entité « utilisateurNomFamille »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public String utilisateurNomFamille;
	public Couverture<String> utilisateurNomFamilleCouverture = new Couverture<String>().p(this).c(String.class).var("utilisateurNomFamille").o(utilisateurNomFamille);

	/**	L'entité « utilisateurNomFamille »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _utilisateurNomFamille(Couverture<String> o) throws Exception;

	public void setUtilisateurNomFamille(String o) throws Exception {
		this.utilisateurNomFamille = o;
	}

	public String getUtilisateurNomFamille() throws Exception {
		return utilisateurNomFamille;
	}
	protected void utilisateurNomFamilleInit() throws Exception {
		if(!utilisateurNomFamilleCouverture.dejaInitialise) {
			_utilisateurNomFamille(utilisateurNomFamilleCouverture);
			if(utilisateurNomFamille == null)
				setUtilisateurNomFamille(utilisateurNomFamilleCouverture.o);
		}
		utilisateurNomFamilleCouverture.dejaInitialise(true);
	}

	///////////////////////////
	// utilisateurNomComplet //
	///////////////////////////

	/**	L'entité « utilisateurNomComplet »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public String utilisateurNomComplet;
	public Couverture<String> utilisateurNomCompletCouverture = new Couverture<String>().p(this).c(String.class).var("utilisateurNomComplet").o(utilisateurNomComplet);

	/**	L'entité « utilisateurNomComplet »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _utilisateurNomComplet(Couverture<String> o) throws Exception;

	public void setUtilisateurNomComplet(String o) throws Exception {
		this.utilisateurNomComplet = o;
	}

	public String getUtilisateurNomComplet() throws Exception {
		return utilisateurNomComplet;
	}
	protected void utilisateurNomCompletInit() throws Exception {
		if(!utilisateurNomCompletCouverture.dejaInitialise) {
			_utilisateurNomComplet(utilisateurNomCompletCouverture);
			if(utilisateurNomComplet == null)
				setUtilisateurNomComplet(utilisateurNomCompletCouverture.o);
		}
		utilisateurNomCompletCouverture.dejaInitialise(true);
	}

	/////////////////////
	// utilisateurSite //
	/////////////////////

	/**	L'entité « utilisateurSite »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public String utilisateurSite;
	public Couverture<String> utilisateurSiteCouverture = new Couverture<String>().p(this).c(String.class).var("utilisateurSite").o(utilisateurSite);

	/**	L'entité « utilisateurSite »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _utilisateurSite(Couverture<String> o) throws Exception;

	public void setUtilisateurSite(String o) throws Exception {
		this.utilisateurSite = o;
	}

	public String getUtilisateurSite() throws Exception {
		return utilisateurSite;
	}
	protected void utilisateurSiteInit() throws Exception {
		if(!utilisateurSiteCouverture.dejaInitialise) {
			_utilisateurSite(utilisateurSiteCouverture);
			if(utilisateurSite == null)
				setUtilisateurSite(utilisateurSiteCouverture.o);
		}
		utilisateurSiteCouverture.dejaInitialise(true);
	}

	//////////////////////////////////
	// utilisateurRecevoirCourriels //
	//////////////////////////////////

	/**	L'entité « utilisateurRecevoirCourriels »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public Boolean utilisateurRecevoirCourriels;
	public Couverture<Boolean> utilisateurRecevoirCourrielsCouverture = new Couverture<Boolean>().p(this).c(Boolean.class).var("utilisateurRecevoirCourriels").o(utilisateurRecevoirCourriels);

	/**	L'entité « utilisateurRecevoirCourriels »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _utilisateurRecevoirCourriels(Couverture<Boolean> o) throws Exception;

	public void setUtilisateurRecevoirCourriels(Boolean o) throws Exception {
		this.utilisateurRecevoirCourriels = o;
	}

	public Boolean getUtilisateurRecevoirCourriels() throws Exception {
		return utilisateurRecevoirCourriels;
	}
	public UtilisateurSite utilisateurRecevoirCourriels(String o) throws Exception {
		if(org.apache.commons.lang3.BooleanUtils.isTrue(org.apache.commons.lang3.BooleanUtils.toBoolean(o)))
			this.utilisateurRecevoirCourriels = Boolean.parseBoolean(o);
		return (UtilisateurSite)this;
	}
	protected void utilisateurRecevoirCourrielsInit() throws Exception {
		if(!utilisateurRecevoirCourrielsCouverture.dejaInitialise) {
			_utilisateurRecevoirCourriels(utilisateurRecevoirCourrielsCouverture);
			if(utilisateurRecevoirCourriels == null)
				setUtilisateurRecevoirCourriels(utilisateurRecevoirCourrielsCouverture.o);
		}
		utilisateurRecevoirCourrielsCouverture.dejaInitialise(true);
	}

	////////////////////
	// modeleSupprime //
	////////////////////

	/**	L'entité « modeleSupprime »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public Boolean modeleSupprime;
	public Couverture<Boolean> modeleSupprimeCouverture = new Couverture<Boolean>().p(this).c(Boolean.class).var("modeleSupprime").o(modeleSupprime);

	/**	L'entité « modeleSupprime »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _modeleSupprime(Couverture<Boolean> o) throws Exception;

	public void setModeleSupprime(Boolean o) throws Exception {
		this.modeleSupprime = o;
	}

	public Boolean getModeleSupprime() throws Exception {
		return modeleSupprime;
	}
	public UtilisateurSite modeleSupprime(String o) throws Exception {
		if(org.apache.commons.lang3.BooleanUtils.isTrue(org.apache.commons.lang3.BooleanUtils.toBoolean(o)))
			this.modeleSupprime = Boolean.parseBoolean(o);
		return (UtilisateurSite)this;
	}
	protected void modeleSupprimeInit() throws Exception {
		if(!modeleSupprimeCouverture.dejaInitialise) {
			_modeleSupprime(modeleSupprimeCouverture);
			if(modeleSupprime == null)
				setModeleSupprime(modeleSupprimeCouverture.o);
		}
		modeleSupprimeCouverture.dejaInitialise(true);
	}

	////////////////
	// modeleCree //
	////////////////

	/**	L'entité « modeleCree »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public ZonedDateTime modeleCree;
	public Couverture<ZonedDateTime> modeleCreeCouverture = new Couverture<ZonedDateTime>().p(this).c(ZonedDateTime.class).var("modeleCree").o(modeleCree);

	/**	L'entité « modeleCree »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _modeleCree(Couverture<ZonedDateTime> o) throws Exception;

	public void setModeleCree(ZonedDateTime o) throws Exception {
		this.modeleCree = o;
	}

	public ZonedDateTime getModeleCree() throws Exception {
		return modeleCree;
	}
	protected void modeleCreeInit() throws Exception {
		if(!modeleCreeCouverture.dejaInitialise) {
			_modeleCree(modeleCreeCouverture);
			if(modeleCree == null)
				setModeleCree(modeleCreeCouverture.o);
		}
		modeleCreeCouverture.dejaInitialise(true);
	}

	///////////////////
	// modeleModifie //
	///////////////////

	/**	L'entité « modeleModifie »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public ZonedDateTime modeleModifie;
	public Couverture<ZonedDateTime> modeleModifieCouverture = new Couverture<ZonedDateTime>().p(this).c(ZonedDateTime.class).var("modeleModifie").o(modeleModifie);

	/**	L'entité « modeleModifie »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _modeleModifie(Couverture<ZonedDateTime> o) throws Exception;

	public void setModeleModifie(ZonedDateTime o) throws Exception {
		this.modeleModifie = o;
	}

	public ZonedDateTime getModeleModifie() throws Exception {
		return modeleModifie;
	}
	protected void modeleModifieInit() throws Exception {
		if(!modeleModifieCouverture.dejaInitialise) {
			_modeleModifie(modeleModifieCouverture);
			if(modeleModifie == null)
				setModeleModifie(modeleModifieCouverture.o);
		}
		modeleModifieCouverture.dejaInitialise(true);
	}

	//////////////////////////////
	// modeleClasseNomCanonique //
	//////////////////////////////

	/**	L'entité « modeleClasseNomCanonique »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public String modeleClasseNomCanonique;
	public Couverture<String> modeleClasseNomCanoniqueCouverture = new Couverture<String>().p(this).c(String.class).var("modeleClasseNomCanonique").o(modeleClasseNomCanonique);

	/**	L'entité « modeleClasseNomCanonique »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _modeleClasseNomCanonique(Couverture<String> o) throws Exception;

	public void setModeleClasseNomCanonique(String o) throws Exception {
		this.modeleClasseNomCanonique = o;
	}

	public String getModeleClasseNomCanonique() throws Exception {
		return modeleClasseNomCanonique;
	}
	protected void modeleClasseNomCanoniqueInit() throws Exception {
		if(!modeleClasseNomCanoniqueCouverture.dejaInitialise) {
			_modeleClasseNomCanonique(modeleClasseNomCanoniqueCouverture);
			if(modeleClasseNomCanonique == null)
				setModeleClasseNomCanonique(modeleClasseNomCanoniqueCouverture.o);
		}
		modeleClasseNomCanoniqueCouverture.dejaInitialise(true);
	}

	///////////////
	// modeleCle //
	///////////////

	/**	L'entité « modeleCle »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public Long modeleCle;
	public Couverture<Long> modeleCleCouverture = new Couverture<Long>().p(this).c(Long.class).var("modeleCle").o(modeleCle);

	/**	L'entité « modeleCle »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _modeleCle(Couverture<Long> o) throws Exception;

	public void setModeleCle(Long o) throws Exception {
		this.modeleCle = o;
	}

	public Long getModeleCle() throws Exception {
		return modeleCle;
	}
	public UtilisateurSite modeleCle(String o) throws Exception {
		if(org.apache.commons.lang3.math.NumberUtils.isNumber(o))
			this.modeleCle = Long.parseLong(o);
		return (UtilisateurSite)this;
	}
	protected void modeleCleInit() throws Exception {
		if(!modeleCleCouverture.dejaInitialise) {
			_modeleCle(modeleCleCouverture);
			if(modeleCle == null)
				setModeleCle(modeleCleCouverture.o);
		}
		modeleCleCouverture.dejaInitialise(true);
	}

	////////////////////////////
	// modeleSuggestionStocke //
	////////////////////////////

	/**	L'entité « modeleSuggestionStocke »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public String modeleSuggestionStocke;
	public Couverture<String> modeleSuggestionStockeCouverture = new Couverture<String>().p(this).c(String.class).var("modeleSuggestionStocke").o(modeleSuggestionStocke);

	/**	L'entité « modeleSuggestionStocke »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _modeleSuggestionStocke(Couverture<String> o) throws Exception;

	public void setModeleSuggestionStocke(String o) throws Exception {
		this.modeleSuggestionStocke = o;
	}

	public String getModeleSuggestionStocke() throws Exception {
		return modeleSuggestionStocke;
	}
	protected void modeleSuggestionStockeInit() throws Exception {
		if(!modeleSuggestionStockeCouverture.dejaInitialise) {
			_modeleSuggestionStocke(modeleSuggestionStockeCouverture);
			if(modeleSuggestionStocke == null)
				setModeleSuggestionStocke(modeleSuggestionStockeCouverture.o);
		}
		modeleSuggestionStockeCouverture.dejaInitialise(true);
	}

	////////////////////////////
	// modeleSuggestionIndexe //
	////////////////////////////

	/**	L'entité « modeleSuggestionIndexe »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public String modeleSuggestionIndexe;
	public Couverture<String> modeleSuggestionIndexeCouverture = new Couverture<String>().p(this).c(String.class).var("modeleSuggestionIndexe").o(modeleSuggestionIndexe);

	/**	L'entité « modeleSuggestionIndexe »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _modeleSuggestionIndexe(Couverture<String> o) throws Exception;

	public void setModeleSuggestionIndexe(String o) throws Exception {
		this.modeleSuggestionIndexe = o;
	}

	public String getModeleSuggestionIndexe() throws Exception {
		return modeleSuggestionIndexe;
	}
	protected void modeleSuggestionIndexeInit() throws Exception {
		if(!modeleSuggestionIndexeCouverture.dejaInitialise) {
			_modeleSuggestionIndexe(modeleSuggestionIndexeCouverture);
			if(modeleSuggestionIndexe == null)
				setModeleSuggestionIndexe(modeleSuggestionIndexeCouverture.o);
		}
		modeleSuggestionIndexeCouverture.dejaInitialise(true);
	}

	protected boolean dejaInitialiseUtilisateurSite = false;

	public void initLoinUtilisateurSite(RequeteSite requeteSite) throws Exception {
		setRequeteSite(requeteSite);
		initLoinUtilisateurSite();
	}

	public void initLoinUtilisateurSite() throws Exception {
		if(!dejaInitialiseUtilisateurSite) {
			requeteSiteInit();
			equipeClesInit();
			utilisateurNomInit();
			utilisateurMailInit();
			utilisateurIdInit();
			utilisateurPrenomInit();
			utilisateurNomFamilleInit();
			utilisateurNomCompletInit();
			utilisateurSiteInit();
			utilisateurRecevoirCourrielsInit();
			modeleSupprimeInit();
			modeleCreeInit();
			modeleModifieInit();
			modeleClasseNomCanoniqueInit();
			modeleCleInit();
			modeleSuggestionStockeInit();
			modeleSuggestionIndexeInit();
			dejaInitialiseUtilisateurSite = true;
		}
	}

	public void initLoinPourClasse(RequeteSite requeteSite) throws Exception {
		initLoinUtilisateurSite(requeteSite);
	}


	public void requeteSiteUtilisateurSite(RequeteSite requeteSite) throws Exception {
		requeteSite.setRequeteSite(requeteSite);
	}

	public void requeteSitePourClasse(RequeteSite requeteSite) throws Exception {
		requeteSiteUtilisateurSite(requeteSite);
	}

	public Object obtenirPourClasse(String var) throws Exception {
		String[] vars = org.apache.commons.lang3.StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtenirUtilisateurSite(v);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.obtenirPourClasse(v);
			}
		}
		return o;
	}
	public Object obtenirUtilisateurSite(String var) throws Exception {
		UtilisateurSite oUtilisateurSite = (UtilisateurSite)this;
		switch(var) {
		case "requeteSite": return oUtilisateurSite.requeteSite;
		case "equipeCles": return oUtilisateurSite.equipeCles;
		case "utilisateurNom": return oUtilisateurSite.utilisateurNom;
		case "utilisateurMail": return oUtilisateurSite.utilisateurMail;
		case "utilisateurId": return oUtilisateurSite.utilisateurId;
		case "utilisateurPrenom": return oUtilisateurSite.utilisateurPrenom;
		case "utilisateurNomFamille": return oUtilisateurSite.utilisateurNomFamille;
		case "utilisateurNomComplet": return oUtilisateurSite.utilisateurNomComplet;
		case "utilisateurSite": return oUtilisateurSite.utilisateurSite;
		case "utilisateurRecevoirCourriels": return oUtilisateurSite.utilisateurRecevoirCourriels;
		case "modeleSupprime": return oUtilisateurSite.modeleSupprime;
		case "modeleCree": return oUtilisateurSite.modeleCree;
		case "modeleModifie": return oUtilisateurSite.modeleModifie;
		case "modeleClasseNomCanonique": return oUtilisateurSite.modeleClasseNomCanonique;
		case "modeleCle": return oUtilisateurSite.modeleCle;
		case "modeleSuggestionStocke": return oUtilisateurSite.modeleSuggestionStocke;
		case "modeleSuggestionIndexe": return oUtilisateurSite.modeleSuggestionIndexe;
		default:
			return null;
		}
	}

	public boolean attribuerPourClasse(String var, Object val) throws Exception {
		String[] vars = org.apache.commons.lang3.StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = attribuerUtilisateurSite(v, val);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.attribuerPourClasse(v, val);
			}
		}
		return o != null;
	}
	public Object attribuerUtilisateurSite(String var, Object val) throws Exception {
		UtilisateurSite oUtilisateurSite = (UtilisateurSite)this;		switch(var) {
		case "requeteSite": oUtilisateurSite.setRequeteSite((RequeteSite)val); return val;
		case "equipeCles": oUtilisateurSite.setEquipeCles((ArrayList<Long>)val); return val;
		case "utilisateurNom": oUtilisateurSite.setUtilisateurNom((String)val); return val;
		case "utilisateurMail": oUtilisateurSite.setUtilisateurMail((String)val); return val;
		case "utilisateurId": oUtilisateurSite.setUtilisateurId((String)val); return val;
		case "utilisateurPrenom": oUtilisateurSite.setUtilisateurPrenom((String)val); return val;
		case "utilisateurNomFamille": oUtilisateurSite.setUtilisateurNomFamille((String)val); return val;
		case "utilisateurNomComplet": oUtilisateurSite.setUtilisateurNomComplet((String)val); return val;
		case "utilisateurSite": oUtilisateurSite.setUtilisateurSite((String)val); return val;
		case "utilisateurRecevoirCourriels": oUtilisateurSite.setUtilisateurRecevoirCourriels((Boolean)val); return val;
		case "modeleSupprime": oUtilisateurSite.setModeleSupprime((Boolean)val); return val;
		case "modeleCree": oUtilisateurSite.setModeleCree((ZonedDateTime)val); return val;
		case "modeleModifie": oUtilisateurSite.setModeleModifie((ZonedDateTime)val); return val;
		case "modeleClasseNomCanonique": oUtilisateurSite.setModeleClasseNomCanonique((String)val); return val;
		case "modeleCle": oUtilisateurSite.setModeleCle((Long)val); return val;
		case "modeleSuggestionStocke": oUtilisateurSite.setModeleSuggestionStocke((String)val); return val;
		case "modeleSuggestionIndexe": oUtilisateurSite.setModeleSuggestionIndexe((String)val); return val;
		default:
			return null;
		}
	}

	public boolean definirPourClasse(String var, String...vals) throws Exception {
		String[] vars = org.apache.commons.lang3.StringUtils.split(var, ".");
		Object o = null;
		String val = vals == null ? null : vals[vals.length - 1];
		if(val != null) {
			for(String v : vars) {
				if(o == null)
					o = definirUtilisateurSite(v, val);
				else if(o instanceof Cluster) {
					Cluster cluster = (Cluster)o;
					o = cluster.definirPourClasse(v, val);
				}
			}
		}
		return o != null;
	}
	public Object definirUtilisateurSite(String var, String val) throws Exception {
		UtilisateurSite oUtilisateurSite = (UtilisateurSite)this;
		switch(var) {
		case "utilisateurNom":
			oUtilisateurSite.setUtilisateurNom(val);
			return val;
		case "utilisateurMail":
			oUtilisateurSite.setUtilisateurMail(val);
			return val;
		case "utilisateurId":
			oUtilisateurSite.setUtilisateurId(val);
			return val;
		case "utilisateurPrenom":
			oUtilisateurSite.setUtilisateurPrenom(val);
			return val;
		case "utilisateurNomFamille":
			oUtilisateurSite.setUtilisateurNomFamille(val);
			return val;
		case "utilisateurNomComplet":
			oUtilisateurSite.setUtilisateurNomComplet(val);
			return val;
		case "utilisateurSite":
			oUtilisateurSite.setUtilisateurSite(val);
			return val;
		case "modeleClasseNomCanonique":
			oUtilisateurSite.setModeleClasseNomCanonique(val);
			return val;
		case "modeleSuggestionStocke":
			oUtilisateurSite.setModeleSuggestionStocke(val);
			return val;
		case "modeleSuggestionIndexe":
			oUtilisateurSite.setModeleSuggestionIndexe(val);
			return val;
		default:
			return null;
		}
	}
}
