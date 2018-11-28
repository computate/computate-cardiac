package org.computate.frFR.cardiaque.utilisateur;

import org.computate.frFR.cardiaque.couverture.Couverture;
import java.util.Date;
import org.computate.frFR.cardiaque.cluster.Cluster;
import java.time.ZonedDateTime;
import java.util.Set;
import io.vertx.core.logging.LoggerFactory;
import org.apache.solr.client.solrj.SolrClient;
import org.computate.frFR.cardiaque.contexte.SiteContexte;
import io.vertx.core.json.JsonArray;
import java.util.List;
import java.lang.Long;
import io.vertx.ext.sql.SQLConnection;
import org.computate.frFR.cardiaque.requete.RequeteSite;
import java.lang.Boolean;
import io.vertx.core.json.JsonObject;
import java.lang.Object;
import java.lang.String;
import io.vertx.core.logging.Logger;
import io.vertx.ext.sql.SQLClient;
import org.apache.solr.common.SolrInputDocument;

public abstract class UtilisateurSiteGen<DEV> extends Object {
	private static final Logger LOGGER = LoggerFactory.getLogger(UtilisateurSite.class);

	//////////////////
	// calculInrPks //
	//////////////////

	/**	L'entité « calculInrPks »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut List<Long>(). 
	 */
	protected List<Long> calculInrPks = new java.util.ArrayList<java.lang.Long>();
	public Couverture<List<Long>> calculInrPksCouverture = new Couverture<List<Long>>().p(this).c(List.class).var("calculInrPks").o(calculInrPks);

	/**	L'entité « calculInrPks »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut List<Long>(). 
	 *	@param calculInrPks est le champ déjà construit. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _calculInrPks(List<Long> l) throws Exception;

	public List<Long> getCalculInrPks() {
		return calculInrPks;
	}

	public void setCalculInrPks(List<Long> l) {
		this.calculInrPks = l;
	}
	public UtilisateurSite addCalculInrPks(Long...objets) throws Exception {
		for(Long o : objets) {
			addCalculInrPks(o);
		}
		return (UtilisateurSite)this;
	}
	public UtilisateurSite addCalculInrPks(Long o) throws Exception {
		if(o != null && !calculInrPks.contains(o))
			this.calculInrPks.add(o);
		return (UtilisateurSite)this;
	}
	public UtilisateurSite addCalculInrPks(String o) throws Exception {
		if(org.apache.commons.lang3.math.NumberUtils.isCreatable(o)) {
			Long p = Long.parseLong(o);
			addCalculInrPks(p);
		}
		return (UtilisateurSite)this;
	}
	protected UtilisateurSite calculInrPksInit() throws Exception {
		if(!calculInrPksCouverture.dejaInitialise) {
			_calculInrPks(calculInrPks);
		}
		calculInrPksCouverture.dejaInitialise(true);
		return (UtilisateurSite)this;
	}

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
	protected UtilisateurSite requeteSite_Init() throws Exception {
		if(!requeteSite_Couverture.dejaInitialise) {
			_requeteSite_(requeteSite_Couverture);
			if(requeteSite_ == null)
				setRequeteSite_(requeteSite_Couverture.o);
		}
		requeteSite_Couverture.dejaInitialise(true);
		return (UtilisateurSite)this;
	}

	////////////////////
	// utilisateurNom //
	////////////////////

	/**	L'entité « utilisateurNom »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected String utilisateurNom;
	public Couverture<String> utilisateurNomCouverture = new Couverture<String>().p(this).c(String.class).var("utilisateurNom").o(utilisateurNom);

	/**	L'entité « utilisateurNom »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _utilisateurNom(Couverture<String> o) throws Exception;

	public String getUtilisateurNom() {
		return utilisateurNom;
	}

	public void setUtilisateurNom(String o) {
		this.utilisateurNom = o;
	}
	protected UtilisateurSite utilisateurNomInit() throws Exception {
		if(!utilisateurNomCouverture.dejaInitialise) {
			_utilisateurNom(utilisateurNomCouverture);
			if(utilisateurNom == null)
				setUtilisateurNom(utilisateurNomCouverture.o);
		}
		utilisateurNomCouverture.dejaInitialise(true);
		return (UtilisateurSite)this;
	}

	/////////////////////
	// utilisateurMail //
	/////////////////////

	/**	L'entité « utilisateurMail »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected String utilisateurMail;
	public Couverture<String> utilisateurMailCouverture = new Couverture<String>().p(this).c(String.class).var("utilisateurMail").o(utilisateurMail);

	/**	L'entité « utilisateurMail »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _utilisateurMail(Couverture<String> o) throws Exception;

	public String getUtilisateurMail() {
		return utilisateurMail;
	}

	public void setUtilisateurMail(String o) {
		this.utilisateurMail = o;
	}
	protected UtilisateurSite utilisateurMailInit() throws Exception {
		if(!utilisateurMailCouverture.dejaInitialise) {
			_utilisateurMail(utilisateurMailCouverture);
			if(utilisateurMail == null)
				setUtilisateurMail(utilisateurMailCouverture.o);
		}
		utilisateurMailCouverture.dejaInitialise(true);
		return (UtilisateurSite)this;
	}

	///////////////////
	// utilisateurId //
	///////////////////

	/**	L'entité « utilisateurId »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected String utilisateurId;
	public Couverture<String> utilisateurIdCouverture = new Couverture<String>().p(this).c(String.class).var("utilisateurId").o(utilisateurId);

	/**	L'entité « utilisateurId »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _utilisateurId(Couverture<String> o) throws Exception;

	public String getUtilisateurId() {
		return utilisateurId;
	}

	public void setUtilisateurId(String o) {
		this.utilisateurId = o;
	}
	protected UtilisateurSite utilisateurIdInit() throws Exception {
		if(!utilisateurIdCouverture.dejaInitialise) {
			_utilisateurId(utilisateurIdCouverture);
			if(utilisateurId == null)
				setUtilisateurId(utilisateurIdCouverture.o);
		}
		utilisateurIdCouverture.dejaInitialise(true);
		return (UtilisateurSite)this;
	}

	///////////////////////
	// utilisateurPrenom //
	///////////////////////

	/**	L'entité « utilisateurPrenom »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected String utilisateurPrenom;
	public Couverture<String> utilisateurPrenomCouverture = new Couverture<String>().p(this).c(String.class).var("utilisateurPrenom").o(utilisateurPrenom);

	/**	L'entité « utilisateurPrenom »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _utilisateurPrenom(Couverture<String> o) throws Exception;

	public String getUtilisateurPrenom() {
		return utilisateurPrenom;
	}

	public void setUtilisateurPrenom(String o) {
		this.utilisateurPrenom = o;
	}
	protected UtilisateurSite utilisateurPrenomInit() throws Exception {
		if(!utilisateurPrenomCouverture.dejaInitialise) {
			_utilisateurPrenom(utilisateurPrenomCouverture);
			if(utilisateurPrenom == null)
				setUtilisateurPrenom(utilisateurPrenomCouverture.o);
		}
		utilisateurPrenomCouverture.dejaInitialise(true);
		return (UtilisateurSite)this;
	}

	///////////////////////////
	// utilisateurNomFamille //
	///////////////////////////

	/**	L'entité « utilisateurNomFamille »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected String utilisateurNomFamille;
	public Couverture<String> utilisateurNomFamilleCouverture = new Couverture<String>().p(this).c(String.class).var("utilisateurNomFamille").o(utilisateurNomFamille);

	/**	L'entité « utilisateurNomFamille »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _utilisateurNomFamille(Couverture<String> o) throws Exception;

	public String getUtilisateurNomFamille() {
		return utilisateurNomFamille;
	}

	public void setUtilisateurNomFamille(String o) {
		this.utilisateurNomFamille = o;
	}
	protected UtilisateurSite utilisateurNomFamilleInit() throws Exception {
		if(!utilisateurNomFamilleCouverture.dejaInitialise) {
			_utilisateurNomFamille(utilisateurNomFamilleCouverture);
			if(utilisateurNomFamille == null)
				setUtilisateurNomFamille(utilisateurNomFamilleCouverture.o);
		}
		utilisateurNomFamilleCouverture.dejaInitialise(true);
		return (UtilisateurSite)this;
	}

	///////////////////////////
	// utilisateurNomComplet //
	///////////////////////////

	/**	L'entité « utilisateurNomComplet »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected String utilisateurNomComplet;
	public Couverture<String> utilisateurNomCompletCouverture = new Couverture<String>().p(this).c(String.class).var("utilisateurNomComplet").o(utilisateurNomComplet);

	/**	L'entité « utilisateurNomComplet »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _utilisateurNomComplet(Couverture<String> o) throws Exception;

	public String getUtilisateurNomComplet() {
		return utilisateurNomComplet;
	}

	public void setUtilisateurNomComplet(String o) {
		this.utilisateurNomComplet = o;
	}
	protected UtilisateurSite utilisateurNomCompletInit() throws Exception {
		if(!utilisateurNomCompletCouverture.dejaInitialise) {
			_utilisateurNomComplet(utilisateurNomCompletCouverture);
			if(utilisateurNomComplet == null)
				setUtilisateurNomComplet(utilisateurNomCompletCouverture.o);
		}
		utilisateurNomCompletCouverture.dejaInitialise(true);
		return (UtilisateurSite)this;
	}

	/////////////////////
	// utilisateurSite //
	/////////////////////

	/**	L'entité « utilisateurSite »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected String utilisateurSite;
	public Couverture<String> utilisateurSiteCouverture = new Couverture<String>().p(this).c(String.class).var("utilisateurSite").o(utilisateurSite);

	/**	L'entité « utilisateurSite »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _utilisateurSite(Couverture<String> o) throws Exception;

	public String getUtilisateurSite() {
		return utilisateurSite;
	}

	public void setUtilisateurSite(String o) {
		this.utilisateurSite = o;
	}
	protected UtilisateurSite utilisateurSiteInit() throws Exception {
		if(!utilisateurSiteCouverture.dejaInitialise) {
			_utilisateurSite(utilisateurSiteCouverture);
			if(utilisateurSite == null)
				setUtilisateurSite(utilisateurSiteCouverture.o);
		}
		utilisateurSiteCouverture.dejaInitialise(true);
		return (UtilisateurSite)this;
	}

	//////////////////////////////////
	// utilisateurRecevoirCourriels //
	//////////////////////////////////

	/**	L'entité « utilisateurRecevoirCourriels »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected Boolean utilisateurRecevoirCourriels;
	public Couverture<Boolean> utilisateurRecevoirCourrielsCouverture = new Couverture<Boolean>().p(this).c(Boolean.class).var("utilisateurRecevoirCourriels").o(utilisateurRecevoirCourriels);

	/**	L'entité « utilisateurRecevoirCourriels »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _utilisateurRecevoirCourriels(Couverture<Boolean> o) throws Exception;

	public Boolean getUtilisateurRecevoirCourriels() {
		return utilisateurRecevoirCourriels;
	}

	public void setUtilisateurRecevoirCourriels(Boolean o) {
		this.utilisateurRecevoirCourriels = o;
	}
	public UtilisateurSite setUtilisateurRecevoirCourriels(String o) throws Exception {
		if(org.apache.commons.lang3.BooleanUtils.isTrue(org.apache.commons.lang3.BooleanUtils.toBoolean(o)))
			this.utilisateurRecevoirCourriels = Boolean.parseBoolean(o);
		return (UtilisateurSite)this;
	}
	protected UtilisateurSite utilisateurRecevoirCourrielsInit() throws Exception {
		if(!utilisateurRecevoirCourrielsCouverture.dejaInitialise) {
			_utilisateurRecevoirCourriels(utilisateurRecevoirCourrielsCouverture);
			if(utilisateurRecevoirCourriels == null)
				setUtilisateurRecevoirCourriels(utilisateurRecevoirCourrielsCouverture.o);
		}
		utilisateurRecevoirCourrielsCouverture.dejaInitialise(true);
		return (UtilisateurSite)this;
	}

	////////////////////
	// modeleSupprime //
	////////////////////

	/**	L'entité « modeleSupprime »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected Boolean modeleSupprime;
	public Couverture<Boolean> modeleSupprimeCouverture = new Couverture<Boolean>().p(this).c(Boolean.class).var("modeleSupprime").o(modeleSupprime);

	/**	L'entité « modeleSupprime »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _modeleSupprime(Couverture<Boolean> o) throws Exception;

	public Boolean getModeleSupprime() {
		return modeleSupprime;
	}

	public void setModeleSupprime(Boolean o) {
		this.modeleSupprime = o;
	}
	public UtilisateurSite setModeleSupprime(String o) throws Exception {
		if(org.apache.commons.lang3.BooleanUtils.isTrue(org.apache.commons.lang3.BooleanUtils.toBoolean(o)))
			this.modeleSupprime = Boolean.parseBoolean(o);
		return (UtilisateurSite)this;
	}
	protected UtilisateurSite modeleSupprimeInit() throws Exception {
		if(!modeleSupprimeCouverture.dejaInitialise) {
			_modeleSupprime(modeleSupprimeCouverture);
			if(modeleSupprime == null)
				setModeleSupprime(modeleSupprimeCouverture.o);
		}
		modeleSupprimeCouverture.dejaInitialise(true);
		return (UtilisateurSite)this;
	}

	////////////////
	// modeleCree //
	////////////////

	/**	L'entité « modeleCree »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected ZonedDateTime modeleCree;
	public Couverture<ZonedDateTime> modeleCreeCouverture = new Couverture<ZonedDateTime>().p(this).c(ZonedDateTime.class).var("modeleCree").o(modeleCree);

	/**	L'entité « modeleCree »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _modeleCree(Couverture<ZonedDateTime> o) throws Exception;

	public ZonedDateTime getModeleCree() {
		return modeleCree;
	}

	public void setModeleCree(ZonedDateTime o) {
		this.modeleCree = o;
	}
	protected UtilisateurSite modeleCreeInit() throws Exception {
		if(!modeleCreeCouverture.dejaInitialise) {
			_modeleCree(modeleCreeCouverture);
			if(modeleCree == null)
				setModeleCree(modeleCreeCouverture.o);
		}
		modeleCreeCouverture.dejaInitialise(true);
		return (UtilisateurSite)this;
	}

	///////////////////
	// modeleModifie //
	///////////////////

	/**	L'entité « modeleModifie »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected ZonedDateTime modeleModifie;
	public Couverture<ZonedDateTime> modeleModifieCouverture = new Couverture<ZonedDateTime>().p(this).c(ZonedDateTime.class).var("modeleModifie").o(modeleModifie);

	/**	L'entité « modeleModifie »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _modeleModifie(Couverture<ZonedDateTime> o) throws Exception;

	public ZonedDateTime getModeleModifie() {
		return modeleModifie;
	}

	public void setModeleModifie(ZonedDateTime o) {
		this.modeleModifie = o;
	}
	protected UtilisateurSite modeleModifieInit() throws Exception {
		if(!modeleModifieCouverture.dejaInitialise) {
			_modeleModifie(modeleModifieCouverture);
			if(modeleModifie == null)
				setModeleModifie(modeleModifieCouverture.o);
		}
		modeleModifieCouverture.dejaInitialise(true);
		return (UtilisateurSite)this;
	}

	//////////////////////////////
	// modeleClasseNomCanonique //
	//////////////////////////////

	/**	L'entité « modeleClasseNomCanonique »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected String modeleClasseNomCanonique;
	public Couverture<String> modeleClasseNomCanoniqueCouverture = new Couverture<String>().p(this).c(String.class).var("modeleClasseNomCanonique").o(modeleClasseNomCanonique);

	/**	L'entité « modeleClasseNomCanonique »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _modeleClasseNomCanonique(Couverture<String> o) throws Exception;

	public String getModeleClasseNomCanonique() {
		return modeleClasseNomCanonique;
	}

	public void setModeleClasseNomCanonique(String o) {
		this.modeleClasseNomCanonique = o;
	}
	protected UtilisateurSite modeleClasseNomCanoniqueInit() throws Exception {
		if(!modeleClasseNomCanoniqueCouverture.dejaInitialise) {
			_modeleClasseNomCanonique(modeleClasseNomCanoniqueCouverture);
			if(modeleClasseNomCanonique == null)
				setModeleClasseNomCanonique(modeleClasseNomCanoniqueCouverture.o);
		}
		modeleClasseNomCanoniqueCouverture.dejaInitialise(true);
		return (UtilisateurSite)this;
	}

	///////////////
	// modeleCle //
	///////////////

	/**	L'entité « modeleCle »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected Long modeleCle;
	public Couverture<Long> modeleCleCouverture = new Couverture<Long>().p(this).c(Long.class).var("modeleCle").o(modeleCle);

	/**	L'entité « modeleCle »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _modeleCle(Couverture<Long> o) throws Exception;

	public Long getModeleCle() {
		return modeleCle;
	}

	public void setModeleCle(Long o) {
		this.modeleCle = o;
	}
	public UtilisateurSite setModeleCle(String o) throws Exception {
		if(org.apache.commons.lang3.math.NumberUtils.isCreatable(o))
			this.modeleCle = Long.parseLong(o);
		return (UtilisateurSite)this;
	}
	protected UtilisateurSite modeleCleInit() throws Exception {
		if(!modeleCleCouverture.dejaInitialise) {
			_modeleCle(modeleCleCouverture);
			if(modeleCle == null)
				setModeleCle(modeleCleCouverture.o);
		}
		modeleCleCouverture.dejaInitialise(true);
		return (UtilisateurSite)this;
	}

	////////////////////////////
	// modeleSuggestionStocke //
	////////////////////////////

	/**	L'entité « modeleSuggestionStocke »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected String modeleSuggestionStocke;
	public Couverture<String> modeleSuggestionStockeCouverture = new Couverture<String>().p(this).c(String.class).var("modeleSuggestionStocke").o(modeleSuggestionStocke);

	/**	L'entité « modeleSuggestionStocke »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _modeleSuggestionStocke(Couverture<String> o) throws Exception;

	public String getModeleSuggestionStocke() {
		return modeleSuggestionStocke;
	}

	public void setModeleSuggestionStocke(String o) {
		this.modeleSuggestionStocke = o;
	}
	protected UtilisateurSite modeleSuggestionStockeInit() throws Exception {
		if(!modeleSuggestionStockeCouverture.dejaInitialise) {
			_modeleSuggestionStocke(modeleSuggestionStockeCouverture);
			if(modeleSuggestionStocke == null)
				setModeleSuggestionStocke(modeleSuggestionStockeCouverture.o);
		}
		modeleSuggestionStockeCouverture.dejaInitialise(true);
		return (UtilisateurSite)this;
	}

	////////////////////////////
	// modeleSuggestionIndexe //
	////////////////////////////

	/**	L'entité « modeleSuggestionIndexe »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected String modeleSuggestionIndexe;
	public Couverture<String> modeleSuggestionIndexeCouverture = new Couverture<String>().p(this).c(String.class).var("modeleSuggestionIndexe").o(modeleSuggestionIndexe);

	/**	L'entité « modeleSuggestionIndexe »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _modeleSuggestionIndexe(Couverture<String> o) throws Exception;

	public String getModeleSuggestionIndexe() {
		return modeleSuggestionIndexe;
	}

	public void setModeleSuggestionIndexe(String o) {
		this.modeleSuggestionIndexe = o;
	}
	protected UtilisateurSite modeleSuggestionIndexeInit() throws Exception {
		if(!modeleSuggestionIndexeCouverture.dejaInitialise) {
			_modeleSuggestionIndexe(modeleSuggestionIndexeCouverture);
			if(modeleSuggestionIndexe == null)
				setModeleSuggestionIndexe(modeleSuggestionIndexeCouverture.o);
		}
		modeleSuggestionIndexeCouverture.dejaInitialise(true);
		return (UtilisateurSite)this;
	}

	/////////////////////
	// initialiserLoin //
	/////////////////////

	protected boolean dejaInitialiseUtilisateurSite = false;

	public UtilisateurSite initLoinUtilisateurSite(RequeteSite requeteSite) throws Exception {
		setRequeteSite_(requeteSite);
		initLoinUtilisateurSite();
		return (UtilisateurSite)this;
	}

	public UtilisateurSite initLoinUtilisateurSite() throws Exception {
		if(!dejaInitialiseUtilisateurSite) {
			calculInrPksInit();
			requeteSite_Init();
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
		return (UtilisateurSite)this;
	}

	public void initLoinPourClasse(RequeteSite requeteSite) throws Exception {
		initLoinUtilisateurSite(requeteSite);
	}

	/////////////////
	// requeteSite //
	/////////////////

	public void requeteSiteUtilisateurSite(RequeteSite requeteSite) throws Exception {
	}

	public void requeteSitePourClasse(RequeteSite requeteSite) throws Exception {
		requeteSiteUtilisateurSite(requeteSite);
	}

	/////////////
	// indexer //
	/////////////

	public void indexerUtilisateurSite() throws Exception {
		RequeteSite requeteSite = new RequeteSite();
		requeteSite.initLoinRequeteSite();
		SiteContexte SiteContexte = new SiteContexte();
		SiteContexte.initLoinSiteContexte();
		SiteContexte.setRequeteSite_(requeteSite);
		requeteSite.setSiteContexte_(SiteContexte);
		requeteSiteUtilisateurSite(requeteSite);
		initLoinUtilisateurSite(requeteSite);
		indexerUtilisateurSite(requeteSite);
	}


	public void indexerPourClasse(RequeteSite requeteSite) throws Exception {
		indexerUtilisateurSite(requeteSite_);
	}

	public void indexerPourClasse(SolrInputDocument document) throws Exception {
		indexerUtilisateurSite(document);
	}
	public void indexerUtilisateurSite(RequeteSite requeteSite) throws Exception {
		SolrInputDocument document = new SolrInputDocument();
		indexerUtilisateurSite(document);
		document.addField("sauvegardesUtilisateurSite_stored_strings", sauvegardesUtilisateurSite);
		SolrClient clientSolr = requeteSite_.getSiteContexte_().getClientSolr();
		clientSolr.add(document);
		clientSolr.commit();
	}

	public void indexerUtilisateurSite(SolrInputDocument document) throws Exception {
		if(calculInrPks != null) {
			for(java.lang.Long o : calculInrPks) {
				document.addField("calculInrPks_indexe_longs", o);
			}
			for(java.lang.Long o : calculInrPks) {
				document.addField("calculInrPks_stocke_longs", o);
			}
		}
		if(utilisateurNom != null) {
			document.addField("utilisateurNom_indexe_string", utilisateurNom);
			document.addField("utilisateurNom_stocke_string", utilisateurNom);
		}
		if(utilisateurMail != null) {
			document.addField("utilisateurMail_indexe_string", utilisateurMail);
			document.addField("utilisateurMail_stocke_string", utilisateurMail);
		}
		if(utilisateurId != null) {
			document.addField("utilisateurId_indexe_string", utilisateurId);
			document.addField("utilisateurId_stocke_string", utilisateurId);
		}
		if(utilisateurPrenom != null) {
			document.addField("utilisateurPrenom_indexe_string", utilisateurPrenom);
			document.addField("utilisateurPrenom_stocke_string", utilisateurPrenom);
		}
		if(utilisateurNomFamille != null) {
			document.addField("utilisateurNomFamille_indexe_string", utilisateurNomFamille);
			document.addField("utilisateurNomFamille_stocke_string", utilisateurNomFamille);
		}
		if(utilisateurNomComplet != null) {
			document.addField("utilisateurNomComplet_indexe_string", utilisateurNomComplet);
			document.addField("utilisateurNomComplet_stocke_string", utilisateurNomComplet);
		}
		if(utilisateurSite != null) {
			document.addField("utilisateurSite_indexe_string", utilisateurSite);
			document.addField("utilisateurSite_stocke_string", utilisateurSite);
		}
		if(utilisateurRecevoirCourriels != null) {
			document.addField("utilisateurRecevoirCourriels_indexe_boolean", utilisateurRecevoirCourriels);
			document.addField("utilisateurRecevoirCourriels_stocke_boolean", utilisateurRecevoirCourriels);
		}
		if(modeleSupprime != null) {
			document.addField("modeleSupprime_indexe_boolean", modeleSupprime);
			document.addField("modeleSupprime_stocke_boolean", modeleSupprime);
		}
		if(modeleCree != null) {
			document.addField("modeleCree_indexenull", modeleCree);
			document.addField("modeleCree_stockenull", modeleCree);
		}
		if(modeleModifie != null) {
			document.addField("modeleModifie_indexenull", modeleModifie);
			document.addField("modeleModifie_stockenull", modeleModifie);
		}
		if(modeleClasseNomCanonique != null) {
			document.addField("modeleClasseNomCanonique_indexe_string", modeleClasseNomCanonique);
			document.addField("modeleClasseNomCanonique_stocke_string", modeleClasseNomCanonique);
		}
		if(modeleCle != null) {
			document.addField("modeleCle_indexe_long", modeleCle);
			document.addField("modeleCle_stocke_long", modeleCle);
		}
		if(modeleSuggestionStocke != null) {
			document.addField("modeleSuggestionStocke_indexe_string", modeleSuggestionStocke);
			document.addField("modeleSuggestionStocke_stocke_string", modeleSuggestionStocke);
		}
		if(modeleSuggestionIndexe != null) {
			document.addField("modeleSuggestionIndexe_indexe_string", modeleSuggestionIndexe);
			document.addField("modeleSuggestionIndexe_stocke_string", modeleSuggestionIndexe);
		}
	}

	/////////////
	// obtenir //
	/////////////

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
			case "calculInrPks":
				return oUtilisateurSite.calculInrPks;
			case "requeteSite_":
				return oUtilisateurSite.requeteSite_;
			case "utilisateurNom":
				return oUtilisateurSite.utilisateurNom;
			case "utilisateurMail":
				return oUtilisateurSite.utilisateurMail;
			case "utilisateurId":
				return oUtilisateurSite.utilisateurId;
			case "utilisateurPrenom":
				return oUtilisateurSite.utilisateurPrenom;
			case "utilisateurNomFamille":
				return oUtilisateurSite.utilisateurNomFamille;
			case "utilisateurNomComplet":
				return oUtilisateurSite.utilisateurNomComplet;
			case "utilisateurSite":
				return oUtilisateurSite.utilisateurSite;
			case "utilisateurRecevoirCourriels":
				return oUtilisateurSite.utilisateurRecevoirCourriels;
			case "modeleSupprime":
				return oUtilisateurSite.modeleSupprime;
			case "modeleCree":
				return oUtilisateurSite.modeleCree;
			case "modeleModifie":
				return oUtilisateurSite.modeleModifie;
			case "modeleClasseNomCanonique":
				return oUtilisateurSite.modeleClasseNomCanonique;
			case "modeleCle":
				return oUtilisateurSite.modeleCle;
			case "modeleSuggestionStocke":
				return oUtilisateurSite.modeleSuggestionStocke;
			case "modeleSuggestionIndexe":
				return oUtilisateurSite.modeleSuggestionIndexe;
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
				o = attribuerUtilisateurSite(v, val);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.attribuerPourClasse(v, val);
			}
		}
		return o != null;
	}
	public Object attribuerUtilisateurSite(String var, Object val) throws Exception {
		UtilisateurSite oUtilisateurSite = (UtilisateurSite)this;
		switch(var) {
			case "calculInrPks":
				oUtilisateurSite.addCalculInrPks((Long)val);
				return val;
			default:
				return null;
		}
	}

	/////////
	// put //
	/////////

	public boolean putPourClasse(JsonObject requeteJson) throws Exception {
		Set<String> vars = requeteJson.fieldNames();
		for(String var : vars) {
			putUtilisateurSite(requeteJson, var);
		}
	}

	public boolean putUtilisateurSite(JsonObject requeteJson, String var) throws Exception {
		switch(var) {
			case "calculInrPks":
				addCalculInrPks(requeteJson.getJsonArray(var));
				return true;
			case "utilisateurNom":
				setUtilisateurNom(requeteJson.getString(var));
				return true;
			case "utilisateurMail":
				setUtilisateurMail(requeteJson.getString(var));
				return true;
			case "utilisateurId":
				setUtilisateurId(requeteJson.getString(var));
				return true;
			case "utilisateurPrenom":
				setUtilisateurPrenom(requeteJson.getString(var));
				return true;
			case "utilisateurNomFamille":
				setUtilisateurNomFamille(requeteJson.getString(var));
				return true;
			case "utilisateurNomComplet":
				setUtilisateurNomComplet(requeteJson.getString(var));
				return true;
			case "utilisateurSite":
				setUtilisateurSite(requeteJson.getString(var));
				return true;
			case "utilisateurRecevoirCourriels":
				setUtilisateurRecevoirCourriels(requeteJson.getBoolean(var));
				return true;
			case "modeleSupprime":
				setModeleSupprime(requeteJson.getBoolean(var));
				return true;
			case "modeleClasseNomCanonique":
				setModeleClasseNomCanonique(requeteJson.getString(var));
				return true;
			case "modeleCle":
				setModeleCle(requeteJson.getLong(var));
				return true;
			case "modeleSuggestionStocke":
				setModeleSuggestionStocke(requeteJson.getString(var));
				return true;
			case "modeleSuggestionIndexe":
				setModeleSuggestionIndexe(requeteJson.getString(var));
				return true;
			default:
				return false;
		}
	}

	/////////////
	// peupler //
	/////////////

	@Override public void peuplerPourClasse(org.apache.solr.common.SolrDocument documentSolr) throws Exception {
		sauvegardesUtilisateurSite = (java.util.ArrayList<String>)documentSolr.get("sauvegardesUtilisateurSite_stored_strings");
		peuplerUtilisateurSite(documentSolr);
	}
	public void peuplerUtilisateurSite(org.apache.solr.common.SolrDocument documentSolr) throws Exception {
		UtilisateurSite oUtilisateurSite = (UtilisateurSite)this;

				java.util.List<java.lang.Long> calculInrPks = (java.util.List<java.lang.Long>)documentSolr.get("calculInrPks_stocke_longs");
				if(calculInrPks != null)
					oUtilisateurSite.calculInrPks.addAll(calculInrPks);

				java.lang.String utilisateurNom = (java.lang.String)documentSolr.get("utilisateurNom_stocke_string");
				if(utilisateurNom != null)
					oUtilisateurSite.setUtilisateurNom(utilisateurNom);

				java.lang.String utilisateurMail = (java.lang.String)documentSolr.get("utilisateurMail_stocke_string");
				if(utilisateurMail != null)
					oUtilisateurSite.setUtilisateurMail(utilisateurMail);

				java.lang.String utilisateurId = (java.lang.String)documentSolr.get("utilisateurId_stocke_string");
				if(utilisateurId != null)
					oUtilisateurSite.setUtilisateurId(utilisateurId);

				java.lang.String utilisateurPrenom = (java.lang.String)documentSolr.get("utilisateurPrenom_stocke_string");
				if(utilisateurPrenom != null)
					oUtilisateurSite.setUtilisateurPrenom(utilisateurPrenom);

				java.lang.String utilisateurNomFamille = (java.lang.String)documentSolr.get("utilisateurNomFamille_stocke_string");
				if(utilisateurNomFamille != null)
					oUtilisateurSite.setUtilisateurNomFamille(utilisateurNomFamille);

				java.lang.String utilisateurNomComplet = (java.lang.String)documentSolr.get("utilisateurNomComplet_stocke_string");
				if(utilisateurNomComplet != null)
					oUtilisateurSite.setUtilisateurNomComplet(utilisateurNomComplet);

				java.lang.String utilisateurSite = (java.lang.String)documentSolr.get("utilisateurSite_stocke_string");
				if(utilisateurSite != null)
					oUtilisateurSite.setUtilisateurSite(utilisateurSite);

				java.lang.Boolean utilisateurRecevoirCourriels = (java.lang.Boolean)documentSolr.get("utilisateurRecevoirCourriels_stocke_boolean");
				if(utilisateurRecevoirCourriels != null)
					oUtilisateurSite.setUtilisateurRecevoirCourriels(utilisateurRecevoirCourriels);

				java.lang.Boolean modeleSupprime = (java.lang.Boolean)documentSolr.get("modeleSupprime_stocke_boolean");
				if(modeleSupprime != null)
					oUtilisateurSite.setModeleSupprime(modeleSupprime);

				 modeleCree = ()documentSolr.get("modeleCree_stockenull");
				if(modeleCree != null)
					oUtilisateurSite.setModeleCree(modeleCree);

				 modeleModifie = ()documentSolr.get("modeleModifie_stockenull");
				if(modeleModifie != null)
					oUtilisateurSite.setModeleModifie(modeleModifie);

				java.lang.String modeleClasseNomCanonique = (java.lang.String)documentSolr.get("modeleClasseNomCanonique_stocke_string");
				if(modeleClasseNomCanonique != null)
					oUtilisateurSite.setModeleClasseNomCanonique(modeleClasseNomCanonique);

				java.lang.Long modeleCle = (java.lang.Long)documentSolr.get("modeleCle_stocke_long");
				if(modeleCle != null)
					oUtilisateurSite.setModeleCle(modeleCle);

				java.lang.String modeleSuggestionStocke = (java.lang.String)documentSolr.get("modeleSuggestionStocke_stocke_string");
				if(modeleSuggestionStocke != null)
					oUtilisateurSite.setModeleSuggestionStocke(modeleSuggestionStocke);

				java.lang.String modeleSuggestionIndexe = (java.lang.String)documentSolr.get("modeleSuggestionIndexe_stocke_string");
				if(modeleSuggestionIndexe != null)
					oUtilisateurSite.setModeleSuggestionIndexe(modeleSuggestionIndexe);

		super.peuplerObject(documentSolr);
	}

	////////////
	// existe //
	////////////

	@Override public Boolean existePourClasse() throws Exception {
		String pkStr = requeteSite_.getRequeteServeur().getParam("pk");
		Long pk = org.apache.commons.lang3.StringUtils.isNumeric(pkStr) ? Long.parseLong(pkStr) : null;
		Boolean existe = existePourClasse(pk);
		return existe;
	}
	@Override public Boolean existePourClasse(Long pk) throws Exception {
		org.apache.commons.dbutils.QueryRunner coureur = new org.apache.commons.dbutils.QueryRunner(requeteSite_.SiteContexte.sourceDonnees);
		org.apache.commons.dbutils.handlers.ArrayListHandler gestionnaireListe = new org.apache.commons.dbutils.handlers.ArrayListHandler();
		utilisateurId = requeteSite_.utilisateurId;
		this.pk = pk;
		String nomCanonique = getClass().getCanonicalName();
		Boolean existe = false;
		
		if(pk == null) {
			String sql = "select pk from objet where objet.id_utilisateur=? and objet.nom_canonique=?";
			SQLClient clientSql = requeteSite_.getSiteContexte_().getClientSql();
			clientSql.getConnection(ar -> {
				if(ar.failed()) {
					LOGGER.error("Impossible d'ouvrir une connexion à la base de données. ", ar.cause());
					future.fail(ar.cause());
				} else {
					SQLConnection connexionSql = ar.result();
					connectionSql.queryWithParams(SiteContexte.SQL_existe, new JsonArray().add(pk)), chercher -> {
						connexionSql.close();
						if(chercher.succeeded()) {
							JsonArray ligneDonnees = chercher.result().getResults().stream().findFirst().orElseGet(() -> null);
							if(ligneDonnees != null) {
								Long pkDonnees = ligneDonnees.getLong(0);
								if(ligneDonnees != null && ligne) {
									
								}
							}
						}
					});
				}
			});
							existe = resultats.size() > 0;
							if(existe) {
								pk = (Long)resultats.get(0)[0];
								setPk(pk);
							}
		}
		else {
			String sql = "select count(*) from objet where objet.pk=? and objet.id_utilisateur=? and objet.nom_canonique=?";
			java.util.List<Object[]> resultats = coureur.query(sql, gestionnaireListe /*select count(*) from objet where objet.pk=*/, pk /* and objet.id_utilisateur=*/, requeteSite_.utilisateurId /* and objet.nom_canonique=*/, nomCanonique);
			existe = ((Long)resultats.get(0)[0]) > 0L;
		}
		return existe;
	}

	/////////////////
	// sauvegardes //
	/////////////////

	protected java.util.ArrayList<String> sauvegardesUtilisateurSite = new java.util.ArrayList<String>();
	@Override public void sauvegardesPourClasse(RequeteSite requeteSite) throws Exception {
		org.apache.commons.dbutils.QueryRunner coureur = new org.apache.commons.dbutils.QueryRunner(requeteSite.SiteContexte.sourceDonnees);
		org.apache.commons.dbutils.handlers.ArrayListHandler gestionnaireListe = new org.apache.commons.dbutils.handlers.ArrayListHandler();
		
		if(pk != null) {
			String sql = "select cree, modifie from objet where objet.pk=?";
			java.util.List<Object[]> resultats = coureur.query(sql, gestionnaireListe /*select cree, modifie from objet where objet.pk=*/, pk);
			if(resultats.size() > 0) {
				cree((Date)resultats.get(0)[0]);
				modifie((Date)resultats.get(0)[1]);
			}
			sql = "select chemin, valeur from p where p.pk_objet=? union select champ2, pk2::text from a where a.pk1=? union select champ1, pk1::text from a where a.pk2=? ";
			resultats = coureur.query(sql, gestionnaireListe /*select chemin, valeur from p where p.pk_objet=*/, pk, pk, pk);
			for(Object[] objets : resultats) {
				String chemin = (String)objets[0];
				String valeur = requeteSite.decrypterStr((String)objets[1]);
				definirPourClasse(chemin, valeur);
				sauvegardesUtilisateurSite.add(chemin);
			}
		}
	}

	/////////////////
	// sauvegarder //
	/////////////////

	@Override public void sauvegarderPourClasse(RequeteSite requeteSite) throws Exception {
		org.apache.commons.dbutils.QueryRunner coureur = new org.apache.commons.dbutils.QueryRunner(requeteSite.SiteContexte.sourceDonnees);
		org.apache.commons.dbutils.handlers.ArrayListHandler gestionnaireListe = new org.apache.commons.dbutils.handlers.ArrayListHandler();
		String pkStr = requeteSite_.getRequeteServeur().getParam("pk");
		pk = org.apache.commons.lang3.StringUtils.isNumeric(pkStr) ? Long.parseLong(pkStr) : null;
		utilisateurId = requeteSite.utilisateurId;
		String nomCanonique = getClass().getCanonicalName();
		modifie = java.time.LocalDateTime.now();
		java.sql.Timestamp horodatage = java.sql.Timestamp.valueOf(modifie);
		
		if(pk == null) {
			String sql = "insert into objet(nom_canonique, id_utilisateur, cree, modifie) values(?, ?, ?, ?) returning pk";
			java.util.List<Object[]> resultats = coureur.insert(sql, gestionnaireListe /*insert into objet(nom_canonique, id_utilisateur, cree, modifie) values(*/, nomCanonique, requeteSite.utilisateurId, horodatage, horodatage /*) returning pk, cree*/);
			pk = (Long)resultats.get(0)[0];
			cree = modifie;
		}
		else {
			String sql = "update objet set modifie=? where objet.pk=? and objet.id_utilisateur=? and objet.nom_canonique=? returning cree";
			java.util.List<Object[]> resultats = coureur.query(sql, gestionnaireListe /*update objet set modifie=*/, horodatage /* where objet.pk=*/, pk /* and objet.id_utilisateur=*/, requeteSite.utilisateurId /* and objet.nom_canonique=*/, nomCanonique /* returning cree*/);
			if(resultats.size() == 0)
				throw new Exception("L'objet avec le pk " + pk + " et nom canonique " + pk + " pour utilisateur " + requeteSite.utilisateurId + " " + requeteSite.utilisateurNom + " n'existe pas dejà. ");
			horodatage = (java.sql.Timestamp)resultats.get(0)[0];
			cree = java.time.LocalDateTime.from(horodatage.toLocalDateTime());
		}

		String sqlInsertP = "insert into p(chemin, valeur, pk_objet) values(?, ?, ?) on conflict(chemin, pk_objet) do update set valeur=? where p.chemin=? and p.pk_objet=?";
		String sqlInsertA = "insert into a(champ1, pk1, champ2, pk2) values(?, ?, ?, ?) on conflict  do nothing";
		String sqlDeleteP = "delete from p where chemin=? and pk_objet=?";
		String sqlDeleteA = "delete from a where champ1=? and pk1=? and champ2=? and pk2=?";
		sauvegarderUtilisateurSite(requeteSite, sqlInsertP, sqlInsertA, sqlDeleteP, sqlDeleteA, gestionnaireListe, coureur);
	}
	public void sauvegarderUtilisateurSite(RequeteSite requeteSite, String sqlInsertP, String sqlInsertA, String sqlDeleteP, String sqlDeleteA, org.apache.commons.dbutils.handlers.ArrayListHandler gestionnaireListe, org.apache.commons.dbutils.QueryRunner coureur) throws Exception {

		super.sauvegarderObject(requeteSite, sqlInsertP, sqlInsertA, sqlDeleteP, sqlDeleteA, gestionnaireListe, coureur);
	}
}
