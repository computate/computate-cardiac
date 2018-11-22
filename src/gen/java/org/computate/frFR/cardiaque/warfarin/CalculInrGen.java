package org.computate.frFR.cardiaque.warfarin;

import org.computate.frFR.cardiaque.contexte.SiteContexte;
import org.computate.frFR.cardiaque.chaine.Chaine;
import org.computate.frFR.cardiaque.couverture.Couverture;
import org.computate.frFR.cardiaque.cluster.Cluster;
import java.time.LocalDate;
import org.computate.frFR.cardiaque.requete.RequeteSite;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.client.solrj.SolrClient;

public abstract class CalculInrGen<DEV> extends Cluster {
	public static final String VAL_patientPrendCoumadinOui = "Yes";
	public static final String VAL_patientPrendCoumadinNon = "No";
	public static final String VAL_patientPrendCoumadinOuiDosageInitial = "Yes, initial dosing";
	public static final String VAL_patientPrendCoumadinOuiRecommence = "Yes, restarted";

	/////////////
	// dateInr //
	/////////////

	/**	L'entité « dateInr »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected LocalDate dateInr;
	public Couverture<LocalDate> dateInrCouverture = new Couverture<LocalDate>().p(this).c(LocalDate.class).var("dateInr").o(dateInr);

	/**	L'entité « dateInr »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _dateInr(Couverture<LocalDate> o) throws Exception;

	public LocalDate getDateInr() {
		return dateInr;
	}

	public void setDateInr(LocalDate o) {
		this.dateInr = o;
	}
	/** Example: 2011-12-03+01:00 **/
	public CalculInr setDateInr(String o) throws Exception {
		this.dateInr = java.time.LocalDate.parse(o, java.time.format.DateTimeFormatter.ISO_OFFSET_DATE);
		return (CalculInr)this;
	}
	public CalculInr setDateInr(java.util.Date o) throws Exception {
		this.dateInr = o.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
		return (CalculInr)this;
	}
	protected CalculInr dateInrInit() throws Exception {
		if(!dateInrCouverture.dejaInitialise) {
			_dateInr(dateInrCouverture);
			if(dateInr == null)
				setDateInr(dateInrCouverture.o);
		}
		dateInrCouverture.dejaInitialise(true);
		return (CalculInr)this;
	}

	////////////////////
	// dateReverifier //
	////////////////////

	/**	L'entité « dateReverifier »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected LocalDate dateReverifier;
	public Couverture<LocalDate> dateReverifierCouverture = new Couverture<LocalDate>().p(this).c(LocalDate.class).var("dateReverifier").o(dateReverifier);

	/**	L'entité « dateReverifier »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _dateReverifier(Couverture<LocalDate> o) throws Exception;

	public LocalDate getDateReverifier() {
		return dateReverifier;
	}

	public void setDateReverifier(LocalDate o) {
		this.dateReverifier = o;
	}
	/** Example: 2011-12-03+01:00 **/
	public CalculInr setDateReverifier(String o) throws Exception {
		this.dateReverifier = java.time.LocalDate.parse(o, java.time.format.DateTimeFormatter.ISO_OFFSET_DATE);
		return (CalculInr)this;
	}
	public CalculInr setDateReverifier(java.util.Date o) throws Exception {
		this.dateReverifier = o.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
		return (CalculInr)this;
	}
	protected CalculInr dateReverifierInit() throws Exception {
		if(!dateReverifierCouverture.dejaInitialise) {
			_dateReverifier(dateReverifierCouverture);
			if(dateReverifier == null)
				setDateReverifier(dateReverifierCouverture.o);
		}
		dateReverifierCouverture.dejaInitialise(true);
		return (CalculInr)this;
	}

	//////////////////////////
	// patientPrendCoumadin //
	//////////////////////////

	/**	L'entité « patientPrendCoumadin »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 */
	protected Chaine patientPrendCoumadin = new Chaine();
	public Couverture<Chaine> patientPrendCoumadinCouverture = new Couverture<Chaine>().p(this).c(Chaine.class).var("patientPrendCoumadin").o(patientPrendCoumadin);

	/**	L'entité « patientPrendCoumadin »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 *	@param patientPrendCoumadin est le champ déjà construit. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _patientPrendCoumadin(Chaine o) throws Exception;

	public Chaine getPatientPrendCoumadin() {
		return patientPrendCoumadin;
	}

	public void setPatientPrendCoumadin(Chaine o) {
		this.patientPrendCoumadin = o;
	}
	public CalculInr setPatientPrendCoumadin(String o) throws Exception {
		patientPrendCoumadin.tout(o);
		return (CalculInr)this;
	}
	protected CalculInr patientPrendCoumadinInit() throws Exception {
		if(!patientPrendCoumadinCouverture.dejaInitialise) {
			_patientPrendCoumadin(patientPrendCoumadin);
		}
		patientPrendCoumadin.initLoinPourClasse(requeteSite_);
		patientPrendCoumadinCouverture.dejaInitialise(true);
		return (CalculInr)this;
	}

	///////////////
	// butActuel //
	///////////////

	/**	L'entité « butActuel »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 */
	protected Chaine butActuel = new Chaine();
	public Couverture<Chaine> butActuelCouverture = new Couverture<Chaine>().p(this).c(Chaine.class).var("butActuel").o(butActuel);

	/**	L'entité « butActuel »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 *	@param butActuel est le champ déjà construit. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _butActuel(Chaine o) throws Exception;

	public Chaine getButActuel() {
		return butActuel;
	}

	public void setButActuel(Chaine o) {
		this.butActuel = o;
	}
	public CalculInr setButActuel(String o) throws Exception {
		butActuel.tout(o);
		return (CalculInr)this;
	}
	protected CalculInr butActuelInit() throws Exception {
		if(!butActuelCouverture.dejaInitialise) {
			_butActuel(butActuel);
		}
		butActuel.initLoinPourClasse(requeteSite_);
		butActuelCouverture.dejaInitialise(true);
		return (CalculInr)this;
	}

	////////////////
	// doseActuel //
	////////////////

	/**	L'entité « doseActuel »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 */
	protected Chaine doseActuel = new Chaine();
	public Couverture<Chaine> doseActuelCouverture = new Couverture<Chaine>().p(this).c(Chaine.class).var("doseActuel").o(doseActuel);

	/**	L'entité « doseActuel »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 *	@param doseActuel est le champ déjà construit. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _doseActuel(Chaine o) throws Exception;

	public Chaine getDoseActuel() {
		return doseActuel;
	}

	public void setDoseActuel(Chaine o) {
		this.doseActuel = o;
	}
	public CalculInr setDoseActuel(String o) throws Exception {
		doseActuel.tout(o);
		return (CalculInr)this;
	}
	protected CalculInr doseActuelInit() throws Exception {
		if(!doseActuelCouverture.dejaInitialise) {
			_doseActuel(doseActuel);
		}
		doseActuel.initLoinPourClasse(requeteSite_);
		doseActuelCouverture.dejaInitialise(true);
		return (CalculInr)this;
	}

	//////////////////////
	// medicamentActuel //
	//////////////////////

	/**	L'entité « medicamentActuel »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 */
	protected Chaine medicamentActuel = new Chaine();
	public Couverture<Chaine> medicamentActuelCouverture = new Couverture<Chaine>().p(this).c(Chaine.class).var("medicamentActuel").o(medicamentActuel);

	/**	L'entité « medicamentActuel »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 *	@param medicamentActuel est le champ déjà construit. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _medicamentActuel(Chaine o) throws Exception;

	public Chaine getMedicamentActuel() {
		return medicamentActuel;
	}

	public void setMedicamentActuel(Chaine o) {
		this.medicamentActuel = o;
	}
	public CalculInr setMedicamentActuel(String o) throws Exception {
		medicamentActuel.tout(o);
		return (CalculInr)this;
	}
	protected CalculInr medicamentActuelInit() throws Exception {
		if(!medicamentActuelCouverture.dejaInitialise) {
			_medicamentActuel(medicamentActuel);
		}
		medicamentActuel.initLoinPourClasse(requeteSite_);
		medicamentActuelCouverture.dejaInitialise(true);
		return (CalculInr)this;
	}

	////////////////////
	// changementDose //
	////////////////////

	/**	L'entité « changementDose »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 */
	protected Chaine changementDose = new Chaine();
	public Couverture<Chaine> changementDoseCouverture = new Couverture<Chaine>().p(this).c(Chaine.class).var("changementDose").o(changementDose);

	/**	L'entité « changementDose »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 *	@param changementDose est le champ déjà construit. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _changementDose(Chaine o) throws Exception;

	public Chaine getChangementDose() {
		return changementDose;
	}

	public void setChangementDose(Chaine o) {
		this.changementDose = o;
	}
	public CalculInr setChangementDose(String o) throws Exception {
		changementDose.tout(o);
		return (CalculInr)this;
	}
	protected CalculInr changementDoseInit() throws Exception {
		if(!changementDoseCouverture.dejaInitialise) {
			_changementDose(changementDose);
		}
		changementDose.initLoinPourClasse(requeteSite_);
		changementDoseCouverture.dejaInitialise(true);
		return (CalculInr)this;
	}

	//////////////////////////
	// notesComplementaires //
	//////////////////////////

	/**	L'entité « notesComplementaires »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 */
	protected Chaine notesComplementaires = new Chaine();
	public Couverture<Chaine> notesComplementairesCouverture = new Couverture<Chaine>().p(this).c(Chaine.class).var("notesComplementaires").o(notesComplementaires);

	/**	L'entité « notesComplementaires »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 *	@param notesComplementaires est le champ déjà construit. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _notesComplementaires(Chaine o) throws Exception;

	public Chaine getNotesComplementaires() {
		return notesComplementaires;
	}

	public void setNotesComplementaires(Chaine o) {
		this.notesComplementaires = o;
	}
	public CalculInr setNotesComplementaires(String o) throws Exception {
		notesComplementaires.tout(o);
		return (CalculInr)this;
	}
	protected CalculInr notesComplementairesInit() throws Exception {
		if(!notesComplementairesCouverture.dejaInitialise) {
			_notesComplementaires(notesComplementaires);
		}
		notesComplementaires.initLoinPourClasse(requeteSite_);
		notesComplementairesCouverture.dejaInitialise(true);
		return (CalculInr)this;
	}

	/////////////////
	// infoContact //
	/////////////////

	/**	L'entité « infoContact »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 */
	protected Chaine infoContact = new Chaine();
	public Couverture<Chaine> infoContactCouverture = new Couverture<Chaine>().p(this).c(Chaine.class).var("infoContact").o(infoContact);

	/**	L'entité « infoContact »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 *	@param infoContact est le champ déjà construit. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _infoContact(Chaine o) throws Exception;

	public Chaine getInfoContact() {
		return infoContact;
	}

	public void setInfoContact(Chaine o) {
		this.infoContact = o;
	}
	public CalculInr setInfoContact(String o) throws Exception {
		infoContact.tout(o);
		return (CalculInr)this;
	}
	protected CalculInr infoContactInit() throws Exception {
		if(!infoContactCouverture.dejaInitialise) {
			_infoContact(infoContact);
		}
		infoContact.initLoinPourClasse(requeteSite_);
		infoContactCouverture.dejaInitialise(true);
		return (CalculInr)this;
	}

	/////////////////////
	// initialiserLoin //
	/////////////////////

	protected boolean dejaInitialiseCalculInr = false;

	public CalculInr initLoinCalculInr(RequeteSite requeteSite) throws Exception {
		setRequeteSite_(requeteSite);
		initLoinCalculInr();
		return (CalculInr)this;
	}

	public CalculInr initLoinCalculInr() throws Exception {
		if(!dejaInitialiseCalculInr) {
			super.initLoinCluster(requeteSite_);
			dateInrInit();
			dateReverifierInit();
			patientPrendCoumadinInit();
			butActuelInit();
			doseActuelInit();
			medicamentActuelInit();
			changementDoseInit();
			notesComplementairesInit();
			infoContactInit();
			dejaInitialiseCalculInr = true;
		}
		return (CalculInr)this;
	}

	public void initLoinPourClasse(RequeteSite requeteSite) throws Exception {
		initLoinCalculInr(requeteSite);
	}

	/////////////////
	// requeteSite //
	/////////////////

	public void requeteSiteCalculInr(RequeteSite requeteSite) throws Exception {
			super.requeteSiteCluster(requeteSite);
		patientPrendCoumadin.setRequeteSite_(requeteSite);
		butActuel.setRequeteSite_(requeteSite);
		doseActuel.setRequeteSite_(requeteSite);
		medicamentActuel.setRequeteSite_(requeteSite);
		changementDose.setRequeteSite_(requeteSite);
		notesComplementaires.setRequeteSite_(requeteSite);
		infoContact.setRequeteSite_(requeteSite);
	}

	public void requeteSitePourClasse(RequeteSite requeteSite) throws Exception {
		requeteSiteCalculInr(requeteSite);
	}

	/////////////
	// indexer //
	/////////////

	public void indexerCalculInr() throws Exception {
		RequeteSite requeteSite = new RequeteSite();
		requeteSite.initLoinRequeteSite();
		SiteContexte SiteContexte = new SiteContexte();
		SiteContexte.initLoinSiteContexte();
		SiteContexte.setRequeteSite_(requeteSite);
		requeteSite.setSiteContexte_(SiteContexte);
		requeteSiteCalculInr(requeteSite);
		initLoinCalculInr(requeteSite);
		indexerCalculInr(requeteSite);
	}


	@Override public void indexerPourClasse(RequeteSite requeteSite) throws Exception {
		indexerCalculInr(requeteSite_);
	}

	@Override public void indexerPourClasse(SolrInputDocument document) throws Exception {
		indexerCalculInr(document);
	}
	public void indexerCalculInr(RequeteSite requeteSite) throws Exception {
		SolrInputDocument document = new SolrInputDocument();
		indexerCalculInr(document);
		document.addField("sauvegardesCalculInr_stored_strings", sauvegardes);
		SolrClient clientSolr = requeteSite_.getSiteContexte_().getClientSolr();
		clientSolr.add(document);
		clientSolr.commit();
	}

	public void indexerCalculInr(SolrInputDocument document) throws Exception {
		if(dateInr != null) {
			document.addField("dateInr_indexe_date", java.time.format.DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(dateInr.atStartOfDay(java.time.ZoneId.of("UTC"))));
			document.addField("dateInr_stocke_date", java.time.format.DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(dateInr.atStartOfDay(java.time.ZoneId.of("UTC"))));
		}
		if(dateReverifier != null) {
			document.addField("dateReverifier_indexe_date", java.time.format.DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(dateReverifier.atStartOfDay(java.time.ZoneId.of("UTC"))));
			document.addField("dateReverifier_stocke_date", java.time.format.DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(dateReverifier.atStartOfDay(java.time.ZoneId.of("UTC"))));
		}
		if(patientPrendCoumadin != null) {
			document.addField("patientPrendCoumadin_indexe_string", patientPrendCoumadin);
			document.addField("patientPrendCoumadin_stocke_string", patientPrendCoumadin);
		}
		if(butActuel != null) {
			document.addField("butActuel_indexe_string", butActuel);
			document.addField("butActuel_stocke_string", butActuel);
		}
		if(doseActuel != null) {
			document.addField("doseActuel_indexe_string", doseActuel);
			document.addField("doseActuel_stocke_string", doseActuel);
		}
		if(medicamentActuel != null) {
			document.addField("medicamentActuel_indexe_string", medicamentActuel);
			document.addField("medicamentActuel_stocke_string", medicamentActuel);
		}
		if(changementDose != null) {
			document.addField("changementDose_indexe_string", changementDose);
			document.addField("changementDose_stocke_string", changementDose);
		}
		if(notesComplementaires != null) {
			document.addField("notesComplementaires_indexe_string", notesComplementaires);
			document.addField("notesComplementaires_stocke_string", notesComplementaires);
		}
		if(infoContact != null) {
			document.addField("infoContact_indexe_string", infoContact);
			document.addField("infoContact_stocke_string", infoContact);
		}
		super.indexerCluster(document);

	}

	/////////////
	// obtenir //
	/////////////

	@Override public Object obtenirPourClasse(String var) throws Exception {
		String[] vars = org.apache.commons.lang3.StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtenirCalculInr(v);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.obtenirPourClasse(v);
			}
		}
		return o;
	}
	public Object obtenirCalculInr(String var) throws Exception {
		CalculInr oCalculInr = (CalculInr)this;
		switch(var) {
			case "dateInr":
				return oCalculInr.dateInr;
			case "dateReverifier":
				return oCalculInr.dateReverifier;
			case "patientPrendCoumadin":
				return oCalculInr.patientPrendCoumadin;
			case "butActuel":
				return oCalculInr.butActuel;
			case "doseActuel":
				return oCalculInr.doseActuel;
			case "medicamentActuel":
				return oCalculInr.medicamentActuel;
			case "changementDose":
				return oCalculInr.changementDose;
			case "notesComplementaires":
				return oCalculInr.notesComplementaires;
			case "infoContact":
				return oCalculInr.infoContact;
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
				o = attribuerCalculInr(v, val);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.attribuerPourClasse(v, val);
			}
		}
		return o != null;
	}
	public Object attribuerCalculInr(String var, Object val) throws Exception {
		CalculInr oCalculInr = (CalculInr)this;
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
					o = definirCalculInr(v, val);
				else if(o instanceof Cluster) {
					Cluster cluster = (Cluster)o;
					o = cluster.definirPourClasse(v, val);
				}
			}
		}
		return o != null;
	}
	public Object definirCalculInr(String var, String val) throws Exception {
		CalculInr oCalculInr = (CalculInr)this;
		switch(var) {
			case "dateInr":
				oCalculInr.setDateInr(val);
				return val;
			case "dateReverifier":
				oCalculInr.setDateReverifier(val);
				return val;
			case "patientPrendCoumadin":
				oCalculInr.setPatientPrendCoumadin(val);
				return val;
			case "butActuel":
				oCalculInr.setButActuel(val);
				return val;
			case "doseActuel":
				oCalculInr.setDoseActuel(val);
				return val;
			case "medicamentActuel":
				oCalculInr.setMedicamentActuel(val);
				return val;
			case "changementDose":
				oCalculInr.setChangementDose(val);
				return val;
			case "notesComplementaires":
				oCalculInr.setNotesComplementaires(val);
				return val;
			case "infoContact":
				oCalculInr.setInfoContact(val);
				return val;
			default:
				return super.definirCluster(var, val);
		}
	}

	/////////////
	// peupler //
	/////////////

	@Override public void peuplerPourClasse(org.apache.solr.common.SolrDocument documentSolr) throws Exception {
		sauvegardesCalculInr = (java.util.ArrayList<String>)documentSolr.get("sauvegardesCalculInr_stored_strings");
		peuplerCalculInr(documentSolr);
	}
	public void peuplerCalculInr(org.apache.solr.common.SolrDocument documentSolr) throws Exception {
		CalculInr oCalculInr = (CalculInr)this;

				java.util.Date dateInr = (java.util.Date)documentSolr.get("dateInr_stocke_date");
				if(dateInr != null)
					oCalculInr.setDateInr(dateInr);

				java.util.Date dateReverifier = (java.util.Date)documentSolr.get("dateReverifier_stocke_date");
				if(dateReverifier != null)
					oCalculInr.setDateReverifier(dateReverifier);

				java.lang.String patientPrendCoumadin = (java.lang.String)documentSolr.get("patientPrendCoumadin_stocke_string");
				if(patientPrendCoumadin != null)
					oCalculInr.setPatientPrendCoumadin(patientPrendCoumadin);

				java.lang.String butActuel = (java.lang.String)documentSolr.get("butActuel_stocke_string");
				if(butActuel != null)
					oCalculInr.setButActuel(butActuel);

				java.lang.String doseActuel = (java.lang.String)documentSolr.get("doseActuel_stocke_string");
				if(doseActuel != null)
					oCalculInr.setDoseActuel(doseActuel);

				java.lang.String medicamentActuel = (java.lang.String)documentSolr.get("medicamentActuel_stocke_string");
				if(medicamentActuel != null)
					oCalculInr.setMedicamentActuel(medicamentActuel);

				java.lang.String changementDose = (java.lang.String)documentSolr.get("changementDose_stocke_string");
				if(changementDose != null)
					oCalculInr.setChangementDose(changementDose);

				java.lang.String notesComplementaires = (java.lang.String)documentSolr.get("notesComplementaires_stocke_string");
				if(notesComplementaires != null)
					oCalculInr.setNotesComplementaires(notesComplementaires);

				java.lang.String infoContact = (java.lang.String)documentSolr.get("infoContact_stocke_string");
				if(infoContact != null)
					oCalculInr.setInfoContact(infoContact);

		super.peuplerCluster(documentSolr);
	}

	////////////
	// existe //
	////////////

	@Override public Boolean existePourClasse() throws Exception {
		String cleStr = requeteSite_.requete.getParameter("cle");
		Long cle = org.apache.commons.lang3.StringUtils.isNumeric(cleStr) ? Long.parseLong(cleStr) : null;
		Boolean existe = existePourClasse(cle);
		return existe;
	}
	@Override public Boolean existePourClasse(Long cle) throws Exception {
		org.apache.commons.dbutils.QueryRunner coureur = new org.apache.commons.dbutils.QueryRunner(requeteSite_.SiteContexte.sourceDonnees);
		org.apache.commons.dbutils.handlers.ArrayListHandler gestionnaireListe = new org.apache.commons.dbutils.handlers.ArrayListHandler();
		utilisateurId = requeteSite_.utilisateurId;
		this.cle = cle;
		String nomCanonique = getClass().getCanonicalName();
		Boolean existe = false;
		
		if(cle == null) {
			String sql = "select clep from objet where objet.id_utilisateur=? and objet.nom_canonique=?";
			java.util.List<Object[]> resultats = coureur.query(sql, gestionnaireListe /*select count(*) from objet where objet.id_utilisateur=*/, requeteSite_.utilisateurId /* and objet.nom_canonique=*/, nomCanonique);
			existe = resultats.size() > 0;
			if(existe) {
				cle = (Long)resultats.get(0)[0];
				cle(cle);
			}
		}
		else {
			String sql = "select count(*) from objet where objet.clep=? and objet.id_utilisateur=? and objet.nom_canonique=?";
			java.util.List<Object[]> resultats = coureur.query(sql, gestionnaireListe /*select count(*) from objet where objet.clep=*/, cle /* and objet.id_utilisateur=*/, requeteSite_.utilisateurId /* and objet.nom_canonique=*/, nomCanonique);
			existe = ((Long)resultats.get(0)[0]) > 0L;
		}
		return existe;
	}

	/////////////////
	// sauvegardes //
	/////////////////

	protected java.util.ArrayList<String> sauvegardesCalculInr = new java.util.ArrayList<String>();
	@Override public void sauvegardesPourClasse(RequeteSite requeteSite) throws Exception {
		org.apache.commons.dbutils.QueryRunner coureur = new org.apache.commons.dbutils.QueryRunner(requeteSite.SiteContexte.sourceDonnees);
		org.apache.commons.dbutils.handlers.ArrayListHandler gestionnaireListe = new org.apache.commons.dbutils.handlers.ArrayListHandler();
		
		if(cle != null) {
			String sql = "select cree, modifie from objet where objet.clep=?";
			java.util.List<Object[]> resultats = coureur.query(sql, gestionnaireListe /*select cree, modifie from objet where objet.clep=*/, cle);
			if(resultats.size() > 0) {
				cree((java.util.Date)resultats.get(0)[0]);
				modifie((java.util.Date)resultats.get(0)[1]);
			}
			sql = "select chemin, valeur from p where p.cle_objet=? union select champ2, cle2::text from a where a.cle1=? union select champ1, cle1::text from a where a.cle2=? ";
			resultats = coureur.query(sql, gestionnaireListe /*select chemin, valeur from p where p.cle_objet=*/, cle, cle, cle);
			for(Object[] objets : resultats) {
				String chemin = (String)objets[0];
				String valeur = requeteSite.decrypterStr((String)objets[1]);
				definirPourClasse(chemin, valeur);
				sauvegardesCalculInr.add(chemin);
			}
		}
	}

	/////////////////
	// sauvegarder //
	/////////////////

	@Override public void sauvegarderPourClasse(RequeteSite requeteSite) throws Exception {
		org.apache.commons.dbutils.QueryRunner coureur = new org.apache.commons.dbutils.QueryRunner(requeteSite.SiteContexte.sourceDonnees);
		org.apache.commons.dbutils.handlers.ArrayListHandler gestionnaireListe = new org.apache.commons.dbutils.handlers.ArrayListHandler();
		String cleStr = requeteSite.requete.getParameter("cle");
		cle = org.apache.commons.lang3.StringUtils.isNumeric(cleStr) ? Long.parseLong(cleStr) : null;
		utilisateurId = requeteSite.utilisateurId;
		String nomCanonique = getClass().getCanonicalName();
		modifie = java.time.LocalDateTime.now();
		java.sql.Timestamp horodatage = java.sql.Timestamp.valueOf(modifie);
		
		if(cle == null) {
			String sql = "insert into objet(nom_canonique, id_utilisateur, cree, modifie) values(?, ?, ?, ?) returning clep";
			java.util.List<Object[]> resultats = coureur.insert(sql, gestionnaireListe /*insert into objet(nom_canonique, id_utilisateur, cree, modifie) values(*/, nomCanonique, requeteSite.utilisateurId, horodatage, horodatage /*) returning clep, cree*/);
			cle = (Long)resultats.get(0)[0];
			cree = modifie;
		}
		else {
			String sql = "update objet set modifie=? where objet.clep=? and objet.id_utilisateur=? and objet.nom_canonique=? returning cree";
			java.util.List<Object[]> resultats = coureur.query(sql, gestionnaireListe /*update objet set modifie=*/, horodatage /* where objet.clep=*/, cle /* and objet.id_utilisateur=*/, requeteSite.utilisateurId /* and objet.nom_canonique=*/, nomCanonique /* returning cree*/);
			if(resultats.size() == 0)
				throw new Exception("L'objet avec le cle " + cle + " et nom canonique " + cle + " pour utilisateur " + requeteSite.utilisateurId + " " + requeteSite.utilisateurNom + " n'existe pas dejà. ");
			horodatage = (java.sql.Timestamp)resultats.get(0)[0];
			cree = java.time.LocalDateTime.from(horodatage.toLocalDateTime());
		}

		String sqlInsertP = "insert into p(chemin, valeur, cle_objet) values(?, ?, ?) on conflict(chemin, cle_objet) do update set valeur=? where p.chemin=? and p.cle_objet=?";
		String sqlInsertA = "insert into a(champ1, cle1, champ2, cle2) values(?, ?, ?, ?) on conflict  do nothing";
		String sqlDeleteP = "delete from p where chemin=? and cle_objet=?";
		String sqlDeleteA = "delete from a where champ1=? and cle1=? and champ2=? and cle2=?";
		sauvegarderCalculInr(requeteSite, sqlInsertP, sqlInsertA, sqlDeleteP, sqlDeleteA, gestionnaireListe, coureur);
	}
	public void sauvegarderCalculInr(RequeteSite requeteSite, String sqlInsertP, String sqlInsertA, String sqlDeleteP, String sqlDeleteA, org.apache.commons.dbutils.handlers.ArrayListHandler gestionnaireListe, org.apache.commons.dbutils.QueryRunner coureur) throws Exception {

		super.sauvegarderCluster(requeteSite, sqlInsertP, sqlInsertA, sqlDeleteP, sqlDeleteA, gestionnaireListe, coureur);
	}
}
