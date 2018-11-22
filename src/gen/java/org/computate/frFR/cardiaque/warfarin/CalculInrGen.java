package org.computate.frFR.cardiaque.warfarin;

import org.computate.frFR.cardiaque.contexte.SiteContexte;
import java.math.BigDecimal;
import org.computate.frFR.cardiaque.chaine.Chaine;
import org.computate.frFR.cardiaque.couverture.Couverture;
import org.computate.frFR.cardiaque.cluster.Cluster;
import java.time.LocalDate;
import org.computate.frFR.cardiaque.requete.RequeteSite;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.client.solrj.SolrClient;

public abstract class CalculInrGen<DEV> extends Cluster {

	/////////////
	// inrDate //
	/////////////

	/**	L'entité « inrDate »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected LocalDate inrDate;
	public Couverture<LocalDate> inrDateCouverture = new Couverture<LocalDate>().p(this).c(LocalDate.class).var("inrDate").o(inrDate);

	/**	L'entité « inrDate »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _inrDate(Couverture<LocalDate> o) throws Exception;

	public LocalDate getInrDate() {
		return inrDate;
	}

	public void setInrDate(LocalDate o) {
		this.inrDate = o;
	}
	/** Example: 2011-12-03+01:00 **/
	public CalculInr setInrDate(String o) throws Exception {
		this.inrDate = java.time.LocalDate.parse(o, java.time.format.DateTimeFormatter.ISO_OFFSET_DATE);
		return (CalculInr)this;
	}
	public CalculInr setInrDate(java.util.Date o) throws Exception {
		this.inrDate = o.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
		return (CalculInr)this;
	}
	protected void inrDateInit() throws Exception {
		if(!inrDateCouverture.dejaInitialise) {
			_inrDate(inrDateCouverture);
			if(inrDate == null)
				setInrDate(inrDateCouverture.o);
		}
		inrDateCouverture.dejaInitialise(true);
	}

	//////////////////////
	// doseActuelValeur //
	//////////////////////

	/**	L'entité « doseActuelValeur »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected BigDecimal doseActuelValeur;
	public Couverture<BigDecimal> doseActuelValeurCouverture = new Couverture<BigDecimal>().p(this).c(BigDecimal.class).var("doseActuelValeur").o(doseActuelValeur);

	/**	L'entité « doseActuelValeur »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _doseActuelValeur(Couverture<BigDecimal> o) throws Exception;

	public BigDecimal getDoseActuelValeur() {
		return doseActuelValeur;
	}

	public void setDoseActuelValeur(BigDecimal o) {
		this.doseActuelValeur = o;
	}
	public CalculInr setDoseActuelValeur(String o) throws Exception {
		if(org.apache.commons.lang3.math.NumberUtils.isCreatable(o))
			this.doseActuelValeur = new BigDecimal(o);
		return (CalculInr)this;
	}
	public CalculInr setDoseActuelValeur(Double o) throws Exception {
			this.doseActuelValeur = new BigDecimal(o);
		return (CalculInr)this;
	}
	public CalculInr setDoseActuelValeur(Integer o) throws Exception {
			this.doseActuelValeur = new BigDecimal(o);
		return (CalculInr)this;
	}
	protected void doseActuelValeurInit() throws Exception {
		if(!doseActuelValeurCouverture.dejaInitialise) {
			_doseActuelValeur(doseActuelValeurCouverture);
			if(doseActuelValeur == null)
				setDoseActuelValeur(doseActuelValeurCouverture.o);
		}
		doseActuelValeurCouverture.dejaInitialise(true);
	}

	/////////////////////
	// doseActuelTexte //
	/////////////////////

	/**	L'entité « doseActuelTexte »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 */
	protected Chaine doseActuelTexte = new Chaine();
	public Couverture<Chaine> doseActuelTexteCouverture = new Couverture<Chaine>().p(this).c(Chaine.class).var("doseActuelTexte").o(doseActuelTexte);

	/**	L'entité « doseActuelTexte »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 *	@param doseActuelTexte est le champ déjà construit. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _doseActuelTexte(Chaine o) throws Exception;

	public Chaine getDoseActuelTexte() {
		return doseActuelTexte;
	}

	public void setDoseActuelTexte(Chaine o) {
		this.doseActuelTexte = o;
	}
	public CalculInr setDoseActuelTexte(String o) throws Exception {
		doseActuelTexte.tout(o);
		return (CalculInr)this;
	}
	protected void doseActuelTexteInit() throws Exception {
		if(!doseActuelTexteCouverture.dejaInitialise) {
			_doseActuelTexte(doseActuelTexte);
		}
		doseActuelTexte.initLoinPourClasse(requeteSite_);
		doseActuelTexteCouverture.dejaInitialise(true);
	}

	//////////////////////////
	// changementDoseValeur //
	//////////////////////////

	/**	L'entité « changementDoseValeur »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected BigDecimal changementDoseValeur;
	public Couverture<BigDecimal> changementDoseValeurCouverture = new Couverture<BigDecimal>().p(this).c(BigDecimal.class).var("changementDoseValeur").o(changementDoseValeur);

	/**	L'entité « changementDoseValeur »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _changementDoseValeur(Couverture<BigDecimal> o) throws Exception;

	public BigDecimal getChangementDoseValeur() {
		return changementDoseValeur;
	}

	public void setChangementDoseValeur(BigDecimal o) {
		this.changementDoseValeur = o;
	}
	public CalculInr setChangementDoseValeur(String o) throws Exception {
		if(org.apache.commons.lang3.math.NumberUtils.isCreatable(o))
			this.changementDoseValeur = new BigDecimal(o);
		return (CalculInr)this;
	}
	public CalculInr setChangementDoseValeur(Double o) throws Exception {
			this.changementDoseValeur = new BigDecimal(o);
		return (CalculInr)this;
	}
	public CalculInr setChangementDoseValeur(Integer o) throws Exception {
			this.changementDoseValeur = new BigDecimal(o);
		return (CalculInr)this;
	}
	protected void changementDoseValeurInit() throws Exception {
		if(!changementDoseValeurCouverture.dejaInitialise) {
			_changementDoseValeur(changementDoseValeurCouverture);
			if(changementDoseValeur == null)
				setChangementDoseValeur(changementDoseValeurCouverture.o);
		}
		changementDoseValeurCouverture.dejaInitialise(true);
	}

	/////////////////////////
	// changementDoseTexte //
	/////////////////////////

	/**	L'entité « changementDoseTexte »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 */
	protected Chaine changementDoseTexte = new Chaine();
	public Couverture<Chaine> changementDoseTexteCouverture = new Couverture<Chaine>().p(this).c(Chaine.class).var("changementDoseTexte").o(changementDoseTexte);

	/**	L'entité « changementDoseTexte »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 *	@param changementDoseTexte est le champ déjà construit. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _changementDoseTexte(Chaine o) throws Exception;

	public Chaine getChangementDoseTexte() {
		return changementDoseTexte;
	}

	public void setChangementDoseTexte(Chaine o) {
		this.changementDoseTexte = o;
	}
	public CalculInr setChangementDoseTexte(String o) throws Exception {
		changementDoseTexte.tout(o);
		return (CalculInr)this;
	}
	protected void changementDoseTexteInit() throws Exception {
		if(!changementDoseTexteCouverture.dejaInitialise) {
			_changementDoseTexte(changementDoseTexte);
		}
		changementDoseTexte.initLoinPourClasse(requeteSite_);
		changementDoseTexteCouverture.dejaInitialise(true);
	}

	/////////////////////
	// initialiserLoin //
	/////////////////////

	protected boolean dejaInitialiseCalculInr = false;

	public void initLoinCalculInr(RequeteSite requeteSite) throws Exception {
		setRequeteSite_(requeteSite);
		initLoinCalculInr();
	}

	public void initLoinCalculInr() throws Exception {
		if(!dejaInitialiseCalculInr) {
			super.initLoinCluster(requeteSite_);
			inrDateInit();
			doseActuelValeurInit();
			doseActuelTexteInit();
			changementDoseValeurInit();
			changementDoseTexteInit();
			dejaInitialiseCalculInr = true;
		}
	}

	public void initLoinPourClasse(RequeteSite requeteSite) throws Exception {
		initLoinCalculInr(requeteSite);
	}

	/////////////////
	// requeteSite //
	/////////////////

	public void requeteSiteCalculInr(RequeteSite requeteSite) throws Exception {
			super.requeteSiteCluster(requeteSite);
		doseActuelTexte.setRequeteSite_(requeteSite);
		changementDoseTexte.setRequeteSite_(requeteSite);
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
		SolrClient clientSolr = requeteSite_.getSiteContexte_().getClientSolr();
		clientSolr.add(document);
		clientSolr.commit();
	}

	public void indexerCalculInr(SolrInputDocument document) throws Exception {
		if(inrDate != null) {
			document.addField("inrDate_indexe_date", java.time.format.DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(inrDate.atStartOfDay(java.time.ZoneId.of("UTC"))));
			document.addField("inrDate_stocke_date", java.time.format.DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(inrDate.atStartOfDay(java.time.ZoneId.of("UTC"))));
		}
		if(doseActuelValeur != null) {
			document.addField("doseActuelValeur_indexe_double", doseActuelValeur);
			document.addField("doseActuelValeur_stocke_double", doseActuelValeur);
		}
		if(doseActuelTexte != null) {
			document.addField("doseActuelTexte_indexe_string", doseActuelTexte);
			document.addField("doseActuelTexte_stocke_string", doseActuelTexte);
		}
		if(changementDoseValeur != null) {
			document.addField("changementDoseValeur_indexe_double", changementDoseValeur);
			document.addField("changementDoseValeur_stocke_double", changementDoseValeur);
		}
		if(changementDoseTexte != null) {
			document.addField("changementDoseTexte_indexe_string", changementDoseTexte);
			document.addField("changementDoseTexte_stocke_string", changementDoseTexte);
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
			case "inrDate":
				return oCalculInr.inrDate;
			case "doseActuelValeur":
				return oCalculInr.doseActuelValeur;
			case "doseActuelTexte":
				return oCalculInr.doseActuelTexte;
			case "changementDoseValeur":
				return oCalculInr.changementDoseValeur;
			case "changementDoseTexte":
				return oCalculInr.changementDoseTexte;
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
			case "inrDate":
				oCalculInr.setInrDate(val);
				return val;
			case "doseActuelValeur":
				oCalculInr.setDoseActuelValeur(val);
				return val;
			case "doseActuelTexte":
				oCalculInr.setDoseActuelTexte(val);
				return val;
			case "changementDoseValeur":
				oCalculInr.setChangementDoseValeur(val);
				return val;
			case "changementDoseTexte":
				oCalculInr.setChangementDoseTexte(val);
				return val;
			default:
				return super.definirCluster(var, val);
		}
	}
}
