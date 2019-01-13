package org.computate.enUS.cardiac.warfarin;

import org.computate.frFR.cardiaque.couverture.Couverture;
import java.util.Date;
import org.apache.commons.lang3.StringUtils;
import io.vertx.core.logging.LoggerFactory;
import java.util.ArrayList;
import java.lang.Long;
import org.computate.frFR.cardiaque.requete.RequeteSite;
import org.computate.enUS.cardiac.writer.AllWriter;
import io.vertx.core.json.JsonObject;
import java.lang.String;
import io.vertx.core.logging.Logger;
import org.computate.enUS.cardiac.chain.Chain;
import org.computate.frFR.cardiaque.cluster.Cluster;
import java.util.Set;
import org.apache.commons.text.StringEscapeUtils;
import java.time.Instant;
import java.time.ZoneId;
import org.apache.solr.client.solrj.SolrClient;
import org.computate.frFR.cardiaque.contexte.SiteContexte;
import java.util.Objects;
import org.apache.solr.common.SolrDocument;
import io.vertx.core.json.JsonArray;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import io.vertx.ext.sql.SQLConnection;
import io.vertx.ext.sql.SQLClient;
import org.apache.solr.common.SolrInputDocument;

/**	
 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.enUS.cardiac.warfarin.InrEntry&fq=classeEtendGen_indexed_boolean:true">Trouver la classe  dans Solr</a>
 * <br/>
 **/
public abstract class InrEntryGen<DEV> extends Cluster {
	private static final Logger LOGGER = LoggerFactory.getLogger(InrEntry.class);

	///////////////////
	// utilisateurPk //
	///////////////////

	/**	L'entité « utilisateurPk »
User primary key.
	 *	 is defined as null before being initialized. 
	 */
	protected Long utilisateurPk;
	public Couverture<Long> utilisateurPkCouverture = new Couverture<Long>().p(this).c(Long.class).var("utilisateurPk").o(utilisateurPk);

	/**	<br/>L'entité « utilisateurPk »
User primary key.
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.enUS.cardiac.warfarin.InrEntry&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:utilisateurPk">Trouver l'entité utilisateurPk dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _utilisateurPk(Couverture<Long> c);

	public Long get() {
		return utilisateurPk;
	}

	public void set(Long c) {
		this.utilisateurPk = c;
		this.utilisateurPkCouverture.dejaInitialise = true;
	}
	public InrEntry set(String o) {
		if(org.apache.commons.lang3.math.NumberUtils.isCreatable(o))
			this.utilisateurPk = Long.parseLong(o);
		this.utilisateurPkCouverture.dejaInitialise = true;
		return (InrEntry)this;
	}
	protected InrEntry utilisateurPkInit() {
		if(!utilisateurPkCouverture.dejaInitialise) {
			_utilisateurPk(utilisateurPkCouverture);
			if(utilisateurPk == null)
				set(utilisateurPkCouverture.o);
		}
		utilisateurPkCouverture.dejaInitialise(true);
		return (InrEntry)this;
	}

	public Long solr() {
		return utilisateurPk;
	}

	public String str() {
		return utilisateurPk == null ? "" : utilisateurPk.toString();
	}

	public String nomAffichage() {
		return null;
	}

	public String htmTooltip() {
		return null;
	}

	public String htm() {
		return utilisateurPk == null ? "" : StringEscapeUtils.escapeHtml4(str());
	}

	/////////////
	// dateInr //
	/////////////

	/**	L'entité « dateInr »
	 *	 is defined as null before being initialized. 
	 */
	protected LocalDate dateInr;
	public Couverture<LocalDate> dateInrCouverture = new Couverture<LocalDate>().p(this).c(LocalDate.class).var("dateInr").o(dateInr);

	/**	<br/>L'entité « dateInr »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.enUS.cardiac.warfarin.InrEntry&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:dateInr">Trouver l'entité dateInr dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _dateInr(Couverture<LocalDate> c);

	public LocalDate get() {
		return dateInr;
	}

	public void set(LocalDate c) {
		this.dateInr = c;
		this.dateInrCouverture.dejaInitialise = true;
	}
	public InrEntry set(Instant o) {
		this.dateInr = LocalDate.from(o);
		this.dateInrCouverture.dejaInitialise = true;
		return (InrEntry)this;
	}
	/** Example: 2011-12-03+01:00 **/
	public InrEntry set(String o) {
		this.dateInr = LocalDate.parse(o, DateTimeFormatter.ISO_OFFSET_DATE);
		this.dateInrCouverture.dejaInitialise = true;
		return (InrEntry)this;
	}
	public InrEntry set(Date o) {
		this.dateInr = o.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		this.dateInrCouverture.dejaInitialise = true;
		return (InrEntry)this;
	}
	protected InrEntry dateInrInit() {
		if(!dateInrCouverture.dejaInitialise) {
			_dateInr(dateInrCouverture);
			if(dateInr == null)
				set(dateInrCouverture.o);
		}
		dateInrCouverture.dejaInitialise(true);
		return (InrEntry)this;
	}

	public Date solr() {
		return dateInr == null ? null : Date.from(dateInr.atStartOfDay(ZoneId.systemDefault()).toInstant());
	}

	public String str() {
		return dateInr == null ? "" : dateInr.toString();
	}

	public String nomAffichage() {
		return null;
	}

	public String htmTooltip() {
		return null;
	}

	public String htm() {
		return dateInr == null ? "" : StringEscapeUtils.escapeHtml4(str());
	}

	////////////////////
	// dateReverifier //
	////////////////////

	/**	L'entité « dateReverifier »
	 *	 is defined as null before being initialized. 
	 */
	protected LocalDate dateReverifier;
	public Couverture<LocalDate> dateReverifierCouverture = new Couverture<LocalDate>().p(this).c(LocalDate.class).var("dateReverifier").o(dateReverifier);

	/**	<br/>L'entité « dateReverifier »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.enUS.cardiac.warfarin.InrEntry&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:dateReverifier">Trouver l'entité dateReverifier dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _dateReverifier(Couverture<LocalDate> c);

	public LocalDate get() {
		return dateReverifier;
	}

	public void set(LocalDate c) {
		this.dateReverifier = c;
		this.dateReverifierCouverture.dejaInitialise = true;
	}
	public InrEntry set(Instant o) {
		this.dateReverifier = LocalDate.from(o);
		this.dateReverifierCouverture.dejaInitialise = true;
		return (InrEntry)this;
	}
	/** Example: 2011-12-03+01:00 **/
	public InrEntry set(String o) {
		this.dateReverifier = LocalDate.parse(o, DateTimeFormatter.ISO_OFFSET_DATE);
		this.dateReverifierCouverture.dejaInitialise = true;
		return (InrEntry)this;
	}
	public InrEntry set(Date o) {
		this.dateReverifier = o.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		this.dateReverifierCouverture.dejaInitialise = true;
		return (InrEntry)this;
	}
	protected InrEntry dateReverifierInit() {
		if(!dateReverifierCouverture.dejaInitialise) {
			_dateReverifier(dateReverifierCouverture);
			if(dateReverifier == null)
				set(dateReverifierCouverture.o);
		}
		dateReverifierCouverture.dejaInitialise(true);
		return (InrEntry)this;
	}

	public Date solr() {
		return dateReverifier == null ? null : Date.from(dateReverifier.atStartOfDay(ZoneId.systemDefault()).toInstant());
	}

	public String str() {
		return dateReverifier == null ? "" : dateReverifier.toString();
	}

	public String nomAffichage() {
		return null;
	}

	public String htmTooltip() {
		return null;
	}

	public String htm() {
		return dateReverifier == null ? "" : StringEscapeUtils.escapeHtml4(str());
	}

	///////////////////////
	// currentDosageText //
	///////////////////////

	/**	L'entité « currentDosageText »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chain(). 
	 */
	protected Chain currentDosageText = new Chain();
	public Couverture<Chain> currentDosageTextCouverture = new Couverture<Chain>().p(this).c(Chain.class).var("currentDosageText").o(currentDosageText);

	/**	<br/>L'entité « currentDosageText »
	 * Il est construit avant d'être initialisé avec le constructeur par défaut Chain(). 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.enUS.cardiac.warfarin.InrEntry&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:currentDosageText">Trouver l'entité currentDosageText dans Solr</a>
	 * <br/>
	 * @param currentDosageText est l'entité déjà construit. 
	 **/
	protected abstract void _currentDosageText(Chain o);

	public Chain get() {
		return currentDosageText;
	}

	public void set(Chain o) {
		this.currentDosageText = o;
		this.currentDosageTextCouverture.dejaInitialise = true;
	}
	protected InrEntry currentDosageTextInit() {
		if(!currentDosageTextCouverture.dejaInitialise) {
			_currentDosageText(currentDosageText);
		}
		currentDosageText.initLoinPourClasse(requeteSite_);
		currentDosageTextCouverture.dejaInitialise(true);
		return (InrEntry)this;
	}

	public String solr() {
		return currentDosageText;
	}

	public String str() {
		return currentDosageText == null ? "" : currentDosageText.toString();
	}

	public String nomAffichage() {
		return null;
	}

	public String htmTooltip() {
		return null;
	}

	public String htm() {
		return currentDosageText == null ? "" : StringEscapeUtils.escapeHtml4(str());
	}

	/////////////////
	// currentGoal //
	/////////////////

	/**	L'entité « currentGoal »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chain(). 
	 */
	protected Chain currentGoal = new Chain();
	public Couverture<Chain> currentGoalCouverture = new Couverture<Chain>().p(this).c(Chain.class).var("currentGoal").o(currentGoal);

	/**	<br/>L'entité « currentGoal »
	 * Il est construit avant d'être initialisé avec le constructeur par défaut Chain(). 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.enUS.cardiac.warfarin.InrEntry&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:currentGoal">Trouver l'entité currentGoal dans Solr</a>
	 * <br/>
	 * @param currentGoal est l'entité déjà construit. 
	 **/
	protected abstract void _currentGoal(Chain o);

	public Chain get() {
		return currentGoal;
	}

	public void set(Chain o) {
		this.currentGoal = o;
		this.currentGoalCouverture.dejaInitialise = true;
	}
	protected InrEntry currentGoalInit() {
		if(!currentGoalCouverture.dejaInitialise) {
			_currentGoal(currentGoal);
		}
		currentGoal.initLoinPourClasse(requeteSite_);
		currentGoalCouverture.dejaInitialise(true);
		return (InrEntry)this;
	}

	public String solr() {
		return currentGoal;
	}

	public String str() {
		return currentGoal == null ? "" : currentGoal.toString();
	}

	public String nomAffichage() {
		return null;
	}

	public String htmTooltip() {
		return null;
	}

	public String htm() {
		return currentGoal == null ? "" : StringEscapeUtils.escapeHtml4(str());
	}

	///////////////////
	// currentDosage //
	///////////////////

	/**	L'entité « currentDosage »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chain(). 
	 */
	protected Chain currentDosage = new Chain();
	public Couverture<Chain> currentDosageCouverture = new Couverture<Chain>().p(this).c(Chain.class).var("currentDosage").o(currentDosage);

	/**	<br/>L'entité « currentDosage »
	 * Il est construit avant d'être initialisé avec le constructeur par défaut Chain(). 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.enUS.cardiac.warfarin.InrEntry&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:currentDosage">Trouver l'entité currentDosage dans Solr</a>
	 * <br/>
	 * @param currentDosage est l'entité déjà construit. 
	 **/
	protected abstract void _currentDosage(Chain o);

	public Chain get() {
		return currentDosage;
	}

	public void set(Chain o) {
		this.currentDosage = o;
		this.currentDosageCouverture.dejaInitialise = true;
	}
	protected InrEntry currentDosageInit() {
		if(!currentDosageCouverture.dejaInitialise) {
			_currentDosage(currentDosage);
		}
		currentDosage.initLoinPourClasse(requeteSite_);
		currentDosageCouverture.dejaInitialise(true);
		return (InrEntry)this;
	}

	public String solr() {
		return currentDosage;
	}

	public String str() {
		return currentDosage == null ? "" : currentDosage.toString();
	}

	public String nomAffichage() {
		return null;
	}

	public String htmTooltip() {
		return null;
	}

	public String htm() {
		return currentDosage == null ? "" : StringEscapeUtils.escapeHtml4(str());
	}

	///////////////////////
	// currentMedication //
	///////////////////////

	/**	L'entité « currentMedication »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chain(). 
	 */
	protected Chain currentMedication = new Chain();
	public Couverture<Chain> currentMedicationCouverture = new Couverture<Chain>().p(this).c(Chain.class).var("currentMedication").o(currentMedication);

	/**	<br/>L'entité « currentMedication »
	 * Il est construit avant d'être initialisé avec le constructeur par défaut Chain(). 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.enUS.cardiac.warfarin.InrEntry&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:currentMedication">Trouver l'entité currentMedication dans Solr</a>
	 * <br/>
	 * @param currentMedication est l'entité déjà construit. 
	 **/
	protected abstract void _currentMedication(Chain o);

	public Chain get() {
		return currentMedication;
	}

	public void set(Chain o) {
		this.currentMedication = o;
		this.currentMedicationCouverture.dejaInitialise = true;
	}
	protected InrEntry currentMedicationInit() {
		if(!currentMedicationCouverture.dejaInitialise) {
			_currentMedication(currentMedication);
		}
		currentMedication.initLoinPourClasse(requeteSite_);
		currentMedicationCouverture.dejaInitialise(true);
		return (InrEntry)this;
	}

	public String solr() {
		return currentMedication;
	}

	public String str() {
		return currentMedication == null ? "" : currentMedication.toString();
	}

	public String nomAffichage() {
		return null;
	}

	public String htmTooltip() {
		return null;
	}

	public String htm() {
		return currentMedication == null ? "" : StringEscapeUtils.escapeHtml4(str());
	}

	//////////////////
	// dosageChange //
	//////////////////

	/**	L'entité « dosageChange »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chain(). 
	 */
	protected Chain dosageChange = new Chain();
	public Couverture<Chain> dosageChangeCouverture = new Couverture<Chain>().p(this).c(Chain.class).var("dosageChange").o(dosageChange);

	/**	<br/>L'entité « dosageChange »
	 * Il est construit avant d'être initialisé avec le constructeur par défaut Chain(). 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.enUS.cardiac.warfarin.InrEntry&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:dosageChange">Trouver l'entité dosageChange dans Solr</a>
	 * <br/>
	 * @param dosageChange est l'entité déjà construit. 
	 **/
	protected abstract void _dosageChange(Chain o);

	public Chain get() {
		return dosageChange;
	}

	public void set(Chain o) {
		this.dosageChange = o;
		this.dosageChangeCouverture.dejaInitialise = true;
	}
	protected InrEntry dosageChangeInit() {
		if(!dosageChangeCouverture.dejaInitialise) {
			_dosageChange(dosageChange);
		}
		dosageChange.initLoinPourClasse(requeteSite_);
		dosageChangeCouverture.dejaInitialise(true);
		return (InrEntry)this;
	}

	public String solr() {
		return dosageChange;
	}

	public String str() {
		return dosageChange == null ? "" : dosageChange.toString();
	}

	public String nomAffichage() {
		return null;
	}

	public String htmTooltip() {
		return null;
	}

	public String htm() {
		return dosageChange == null ? "" : StringEscapeUtils.escapeHtml4(str());
	}

	/////////////////////
	// additionalNotes //
	/////////////////////

	/**	L'entité « additionalNotes »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chain(). 
	 */
	protected Chain additionalNotes = new Chain();
	public Couverture<Chain> additionalNotesCouverture = new Couverture<Chain>().p(this).c(Chain.class).var("additionalNotes").o(additionalNotes);

	/**	<br/>L'entité « additionalNotes »
	 * Il est construit avant d'être initialisé avec le constructeur par défaut Chain(). 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.enUS.cardiac.warfarin.InrEntry&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:additionalNotes">Trouver l'entité additionalNotes dans Solr</a>
	 * <br/>
	 * @param additionalNotes est l'entité déjà construit. 
	 **/
	protected abstract void _additionalNotes(Chain o);

	public Chain get() {
		return additionalNotes;
	}

	public void set(Chain o) {
		this.additionalNotes = o;
		this.additionalNotesCouverture.dejaInitialise = true;
	}
	protected InrEntry additionalNotesInit() {
		if(!additionalNotesCouverture.dejaInitialise) {
			_additionalNotes(additionalNotes);
		}
		additionalNotes.initLoinPourClasse(requeteSite_);
		additionalNotesCouverture.dejaInitialise(true);
		return (InrEntry)this;
	}

	public String solr() {
		return additionalNotes;
	}

	public String str() {
		return additionalNotes == null ? "" : additionalNotes.toString();
	}

	public String nomAffichage() {
		return null;
	}

	public String htmTooltip() {
		return null;
	}

	public String htm() {
		return additionalNotes == null ? "" : StringEscapeUtils.escapeHtml4(str());
	}

	/////////////////
	// contactInfo //
	/////////////////

	/**	L'entité « contactInfo »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chain(). 
	 */
	protected Chain contactInfo = new Chain();
	public Couverture<Chain> contactInfoCouverture = new Couverture<Chain>().p(this).c(Chain.class).var("contactInfo").o(contactInfo);

	/**	<br/>L'entité « contactInfo »
	 * Il est construit avant d'être initialisé avec le constructeur par défaut Chain(). 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.enUS.cardiac.warfarin.InrEntry&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:contactInfo">Trouver l'entité contactInfo dans Solr</a>
	 * <br/>
	 * @param contactInfo est l'entité déjà construit. 
	 **/
	protected abstract void _contactInfo(Chain o);

	public Chain get() {
		return contactInfo;
	}

	public void set(Chain o) {
		this.contactInfo = o;
		this.contactInfoCouverture.dejaInitialise = true;
	}
	protected InrEntry contactInfoInit() {
		if(!contactInfoCouverture.dejaInitialise) {
			_contactInfo(contactInfo);
		}
		contactInfo.initLoinPourClasse(requeteSite_);
		contactInfoCouverture.dejaInitialise(true);
		return (InrEntry)this;
	}

	public String solr() {
		return contactInfo;
	}

	public String str() {
		return contactInfo == null ? "" : contactInfo.toString();
	}

	public String nomAffichage() {
		return null;
	}

	public String htmTooltip() {
		return null;
	}

	public String htm() {
		return contactInfo == null ? "" : StringEscapeUtils.escapeHtml4(str());
	}

	//////////////
	// initLoin //
	//////////////

	protected boolean dejaInitialiseInrEntry = false;

	public InrEntry initLoinInrEntry(RequeteSite requeteSite) {
		setRequeteSite_(requeteSite);
		if(!dejaInitialiseInrEntry) {
			dejaInitialiseInrEntry = true;
			initLoinInrEntry();
		}
		return (InrEntry)this;
	}

	public void initLoinInrEntry() {
		initInrEntry();
	}

	public void initInrEntry() {
		utilisateurPkInit();
		dateInrInit();
		dateReverifierInit();
		currentDosageTextInit();
		currentGoalInit();
		currentDosageInit();
		currentMedicationInit();
		dosageChangeInit();
		additionalNotesInit();
		contactInfoInit();
	}

	public void initLoinPourClasse(RequeteSite requeteSite) {
		initLoinInrEntry(requeteSite);
	}

	/////////////////
	// requeteSite //
	/////////////////

	public void requeteSiteInrEntry(RequeteSite requeteSite) {
		currentDosageText.setRequeteSite_(requeteSite);
		currentGoal.setRequeteSite_(requeteSite);
		currentDosage.setRequeteSite_(requeteSite);
		currentMedication.setRequeteSite_(requeteSite);
		dosageChange.setRequeteSite_(requeteSite);
		additionalNotes.setRequeteSite_(requeteSite);
		contactInfo.setRequeteSite_(requeteSite);
	}

	public void requeteSitePourClasse(RequeteSite requeteSite) {
		requeteSiteInrEntry(requeteSite);
	}

	/////////////
	// indexer //
	/////////////

	//public void indexerInrEntry() throws Exception {
		//RequeteSite requeteSite = new RequeteSite();
		//requeteSite.initLoinRequeteSite();
		//SiteContexte siteContexte = new SiteContexte();
		//siteContexte.initLoinSiteContexte();
		//siteContexte.setRequeteSite_(requeteSite);
		//requeteSite.setSiteContexte_(siteContexte);
		//requeteSiteInrEntry(requeteSite);
		//initLoinInrEntry(requeteSite);
		//indexerInrEntry();
	//}


	public void indexerPourClasse() throws Exception {
		indexerInrEntry();
	}

	public void indexerPourClasse(SolrInputDocument document) throws Exception {
		indexerInrEntry(document);
	}
	public void indexerInrEntry() throws Exception {
		SolrInputDocument document = new SolrInputDocument();
		indexerInrEntry(document);
		SolrClient clientSolr = requeteSite_.getSiteContexte_().getClientSolr();
		clientSolr.add(document);
		clientSolr.commit();
	}

	public void indexerInrEntry(SolrInputDocument document) throws Exception {
		if(utilisateurPk != null) {
			document.addField("utilisateurPk_indexed_long", utilisateurPk);
			document.addField("utilisateurPk_stored_long", utilisateurPk);
		}
		if(dateInr != null) {
			document.addField("dateInr_indexed_date", DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(dateInr.atStartOfDay(ZoneId.systemDefault())));
			document.addField("dateInr_stored_date", DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(dateInr.atStartOfDay(ZoneId.systemDefault())));
		}
		if(dateReverifier != null) {
			document.addField("dateReverifier_indexed_date", DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(dateReverifier.atStartOfDay(ZoneId.systemDefault())));
			document.addField("dateReverifier_stored_date", DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(dateReverifier.atStartOfDay(ZoneId.systemDefault())));
		}
		if(currentDosageText != null) {
			document.addField("currentDosageText_indexed_string", currentDosageText);
			document.addField("currentDosageText_stored_string", currentDosageText);
		}
		if(currentGoal != null) {
			document.addField("currentGoal_indexed_string", currentGoal);
			document.addField("currentGoal_stored_string", currentGoal);
		}
		if(currentDosage != null) {
			document.addField("currentDosage_indexed_string", currentDosage);
			document.addField("currentDosage_stored_string", currentDosage);
		}
		if(currentMedication != null) {
			document.addField("currentMedication_indexed_string", currentMedication);
			document.addField("currentMedication_stored_string", currentMedication);
		}
		if(dosageChange != null) {
			document.addField("dosageChange_indexed_string", dosageChange);
			document.addField("dosageChange_stored_string", dosageChange);
		}
		if(additionalNotes != null) {
			document.addField("additionalNotes_indexed_string", additionalNotes);
			document.addField("additionalNotes_stored_string", additionalNotes);
		}
		if(contactInfo != null) {
			document.addField("contactInfo_indexed_string", contactInfo);
			document.addField("contactInfo_stored_string", contactInfo);
		}
	}

	/////////////
	// obtenir //
	/////////////

	public Object obtenirPourClasse(String var) throws Exception {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtenirInrEntry(v);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.obtenirPourClasse(v);
			}
		}
		return o;
	}
	public Object obtenirInrEntry(String var) throws Exception {
		InrEntry oInrEntry = (InrEntry)this;
		switch(var) {
			case "utilisateurPk":
				return oInrEntry.utilisateurPk;
			case "dateInr":
				return oInrEntry.dateInr;
			case "dateReverifier":
				return oInrEntry.dateReverifier;
			case "currentDosageText":
				return oInrEntry.currentDosageText;
			case "currentGoal":
				return oInrEntry.currentGoal;
			case "currentDosage":
				return oInrEntry.currentDosage;
			case "currentMedication":
				return oInrEntry.currentMedication;
			case "dosageChange":
				return oInrEntry.dosageChange;
			case "additionalNotes":
				return oInrEntry.additionalNotes;
			case "contactInfo":
				return oInrEntry.contactInfo;
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
				o = attribuerInrEntry(v, val);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.attribuerPourClasse(v, val);
			}
		}
		return o != null;
	}
	public Object attribuerInrEntry(String var, Object val) {
		InrEntry oInrEntry = (InrEntry)this;
		switch(var) {
			case "utilisateurPk":
				oInrEntry.set((Long)val);
				return val;
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
					o = definirInrEntry(v, val);
				else if(o instanceof Cluster) {
					Cluster cluster = (Cluster)o;
					o = cluster.definirPourClasse(v, val);
				}
			}
		}
		return o != null;
	}
	public Object definirInrEntry(String var, String val) {
		switch(var) {
			case "dateInr":
				set(val);
				sauvegardesInrEntry.add(var);
				return val;
			case "dateReverifier":
				set(val);
				sauvegardesInrEntry.add(var);
				return val;
			case "currentDosageText":
				set(val);
				sauvegardesInrEntry.add(var);
				return val;
			case "currentGoal":
				set(val);
				sauvegardesInrEntry.add(var);
				return val;
			case "currentDosage":
				set(val);
				sauvegardesInrEntry.add(var);
				return val;
			case "currentMedication":
				set(val);
				sauvegardesInrEntry.add(var);
				return val;
			case "dosageChange":
				set(val);
				sauvegardesInrEntry.add(var);
				return val;
			case "additionalNotes":
				set(val);
				sauvegardesInrEntry.add(var);
				return val;
			case "contactInfo":
				set(val);
				sauvegardesInrEntry.add(var);
				return val;
			default:
				return null;
		}
	}

	/////////////////
	// sauvegardes //
	/////////////////

	protected List<String> sauvegardesInrEntry = new ArrayList<String>();

	/////////////
	// peupler //
	/////////////

	public void peuplerPourClasse(SolrDocument solrDocument) {
		peuplerInrEntry(solrDocument);
	}
	public void peuplerInrEntry(SolrDocument solrDocument) {
		InrEntry oInrEntry = (InrEntry)this;
		sauvegardesInrEntry = (List<String>)solrDocument.get("sauvegardesInrEntry_stored_strings");

		if(sauvegardesInrEntry.contains("utilisateurPk")) {
			Long utilisateurPk = (Long)solrDocument.get("utilisateurPk_stored_long");
			if(utilisateurPk != null)
				oInrEntry.set(utilisateurPk);
		}

		if(sauvegardesInrEntry.contains("dateInr")) {
			Date dateInr = (Date)solrDocument.get("dateInr_stored_date");
			if(dateInr != null)
				oInrEntry.set(dateInr);
		}

		if(sauvegardesInrEntry.contains("dateReverifier")) {
			Date dateReverifier = (Date)solrDocument.get("dateReverifier_stored_date");
			if(dateReverifier != null)
				oInrEntry.set(dateReverifier);
		}

		if(sauvegardesInrEntry.contains("currentDosageText")) {
			String currentDosageText = (String)solrDocument.get("currentDosageText_stored_string");
			if(currentDosageText != null)
				oInrEntry.set(currentDosageText);
		}

		if(sauvegardesInrEntry.contains("currentGoal")) {
			String currentGoal = (String)solrDocument.get("currentGoal_stored_string");
			if(currentGoal != null)
				oInrEntry.set(currentGoal);
		}

		if(sauvegardesInrEntry.contains("currentDosage")) {
			String currentDosage = (String)solrDocument.get("currentDosage_stored_string");
			if(currentDosage != null)
				oInrEntry.set(currentDosage);
		}

		if(sauvegardesInrEntry.contains("currentMedication")) {
			String currentMedication = (String)solrDocument.get("currentMedication_stored_string");
			if(currentMedication != null)
				oInrEntry.set(currentMedication);
		}

		if(sauvegardesInrEntry.contains("dosageChange")) {
			String dosageChange = (String)solrDocument.get("dosageChange_stored_string");
			if(dosageChange != null)
				oInrEntry.set(dosageChange);
		}

		if(sauvegardesInrEntry.contains("additionalNotes")) {
			String additionalNotes = (String)solrDocument.get("additionalNotes_stored_string");
			if(additionalNotes != null)
				oInrEntry.set(additionalNotes);
		}

		if(sauvegardesInrEntry.contains("contactInfo")) {
			String contactInfo = (String)solrDocument.get("contactInfo_stored_string");
			if(contactInfo != null)
				oInrEntry.set(contactInfo);
		}
	}

	//////////////
	// hashCode //
	//////////////

	@Override public int hashCode() {
		return Objects.hash(dateInr, dateReverifier, currentDosageText, currentGoal, currentDosage, currentMedication, dosageChange, additionalNotes, contactInfo);
	}

	////////////
	// equals //
	////////////

	@Override public boolean equals(Object o) {
		if(this == o)
			return true;
		if(!(o instanceof InrEntry))
			return false;
		InrEntry that = (InrEntry)o;
		return Objects.equals( dateInr, that.dateInr )
				&& Objects.equals( dateReverifier, that.dateReverifier )
				&& Objects.equals( currentDosageText, that.currentDosageText )
				&& Objects.equals( currentGoal, that.currentGoal )
				&& Objects.equals( currentDosage, that.currentDosage )
				&& Objects.equals( currentMedication, that.currentMedication )
				&& Objects.equals( dosageChange, that.dosageChange )
				&& Objects.equals( additionalNotes, that.additionalNotes )
				&& Objects.equals( contactInfo, that.contactInfo );
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("InrEntry {");
		sb.append( "dateInr: " ).append(dateInr);
		sb.append( ", dateReverifier: " ).append(dateReverifier);
		sb.append( ", currentDosageText: " ).append(currentDosageText);
		sb.append( ", currentGoal: " ).append(currentGoal);
		sb.append( ", currentDosage: " ).append(currentDosage);
		sb.append( ", currentMedication: " ).append(currentMedication);
		sb.append( ", dosageChange: " ).append(dosageChange);
		sb.append( ", additionalNotes: " ).append(additionalNotes);
		sb.append( ", contactInfo: " ).append(contactInfo);
		sb.append(" }");
		return sb.toString();
	}
}
