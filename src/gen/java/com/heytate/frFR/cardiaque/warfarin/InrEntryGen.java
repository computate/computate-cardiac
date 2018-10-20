package com.heytate.frFR.cardiaque.warfarin;

import java.math.BigDecimal;
import com.heytate.frFR.cardiaque.contexte.EcouteurContexte;
import java.time.LocalDate;
import com.heytate.frFR.cardiaque.requete.RequeteSite;
import com.heytate.frFR.cardiac.chaine.Chaine;
import com.heytate.frFR.cardiaque.cluster.Cluster;
import com.heytate.frFR.cardiaque.couverture.Couverture;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.client.solrj.SolrClient;

public abstract class InrEntryGen<DEV> extends Cluster {

	/////////////
	// inrDate //
	/////////////

	/**	L'entité « inrDate »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public LocalDate inrDate;
	public Couverture<LocalDate> inrDateCouverture = new Couverture<LocalDate>().p(this).c(LocalDate.class).var("inrDate").o(inrDate);

	/**	L'entité « inrDate »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _inrDate(Couverture<LocalDate> o) throws Exception;

	public void setInrDate(LocalDate o) throws Exception {
		this.inrDate = o;
	}

	public LocalDate getInrDate() throws Exception {
		return inrDate;
	}
	public InrEntry setInrDate(String o) throws Exception {
		this.inrDate = java.time.LocalDate.parse(o, java.time.format.DateTimeFormatter.ISO_OFFSET_DATE);
		return (InrEntry)this;
	}
	public InrEntry setInrDate(java.util.Date o) throws Exception {
		this.inrDate = o.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
		return (InrEntry)this;
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
	public BigDecimal doseActuelValeur;
	public Couverture<BigDecimal> doseActuelValeurCouverture = new Couverture<BigDecimal>().p(this).c(BigDecimal.class).var("doseActuelValeur").o(doseActuelValeur);

	/**	L'entité « doseActuelValeur »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _doseActuelValeur(Couverture<BigDecimal> o) throws Exception;

	public void setDoseActuelValeur(BigDecimal o) throws Exception {
		this.doseActuelValeur = o;
	}

	public BigDecimal getDoseActuelValeur() throws Exception {
		return doseActuelValeur;
	}
	public InrEntry setDoseActuelValeur(String o) throws Exception {
		if(org.apache.commons.lang3.math.NumberUtils.isCreatable(o))
			this.doseActuelValeur = new BigDecimal(o);
		return (InrEntry)this;
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
	public Chaine doseActuelTexte = new Chaine();
	public Couverture<Chaine> doseActuelTexteCouverture = new Couverture<Chaine>().p(this).c(Chaine.class).var("doseActuelTexte").o(doseActuelTexte);

	/**	L'entité « doseActuelTexte »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 *	@param doseActuelTexte est le champ déjà construit. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _doseActuelTexte(Chaine o) throws Exception;

	public void setDoseActuelTexte(Chaine o) throws Exception {
		this.doseActuelTexte = o;
	}

	public Chaine getDoseActuelTexte() throws Exception {
		return doseActuelTexte;
	}
	public InrEntry setDoseActuelTexte(String o) throws Exception {
		doseActuelTexte.tout(o);
		return (InrEntry)this;
	}
	protected void doseActuelTexteInit() throws Exception {
		if(!doseActuelTexteCouverture.dejaInitialise) {
			_doseActuelTexte(doseActuelTexte);
		}
		doseActuelTexteCouverture.dejaInitialise(true);
	}

	//////////////////////////
	// changementDoseValeur //
	//////////////////////////

	/**	L'entité « changementDoseValeur »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public BigDecimal changementDoseValeur;
	public Couverture<BigDecimal> changementDoseValeurCouverture = new Couverture<BigDecimal>().p(this).c(BigDecimal.class).var("changementDoseValeur").o(changementDoseValeur);

	/**	L'entité « changementDoseValeur »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _changementDoseValeur(Couverture<BigDecimal> o) throws Exception;

	public void setChangementDoseValeur(BigDecimal o) throws Exception {
		this.changementDoseValeur = o;
	}

	public BigDecimal getChangementDoseValeur() throws Exception {
		return changementDoseValeur;
	}
	public InrEntry setChangementDoseValeur(String o) throws Exception {
		if(org.apache.commons.lang3.math.NumberUtils.isCreatable(o))
			this.changementDoseValeur = new BigDecimal(o);
		return (InrEntry)this;
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
	public Chaine changementDoseTexte = new Chaine();
	public Couverture<Chaine> changementDoseTexteCouverture = new Couverture<Chaine>().p(this).c(Chaine.class).var("changementDoseTexte").o(changementDoseTexte);

	/**	L'entité « changementDoseTexte »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 *	@param changementDoseTexte est le champ déjà construit. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _changementDoseTexte(Chaine o) throws Exception;

	public void setChangementDoseTexte(Chaine o) throws Exception {
		this.changementDoseTexte = o;
	}

	public Chaine getChangementDoseTexte() throws Exception {
		return changementDoseTexte;
	}
	public InrEntry setChangementDoseTexte(String o) throws Exception {
		changementDoseTexte.tout(o);
		return (InrEntry)this;
	}
	protected void changementDoseTexteInit() throws Exception {
		if(!changementDoseTexteCouverture.dejaInitialise) {
			_changementDoseTexte(changementDoseTexte);
		}
		changementDoseTexteCouverture.dejaInitialise(true);
	}

	/////////////////////
	// initialiserLoin //
	/////////////////////

	protected boolean dejaInitialiseInrEntry = false;

	public void initLoinInrEntry(RequeteSite requeteSite) throws Exception {
		setRequeteSite(requeteSite);
		initLoinInrEntry();
	}

	public void initLoinInrEntry() throws Exception {
		if(!dejaInitialiseInrEntry) {
			super.initLoinCluster(requeteSite);
			inrDateInit();
			doseActuelValeurInit();
			doseActuelTexteInit();
			changementDoseValeurInit();
			changementDoseTexteInit();
			dejaInitialiseInrEntry = true;
		}
	}

	public void initLoinPourClasse(RequeteSite requeteSite) throws Exception {
		initLoinInrEntry(requeteSite);
	}

	/////////////////
	// requeteSite //
	/////////////////

	public void requeteSiteInrEntry(RequeteSite requeteSite) throws Exception {
			super.requeteSiteCluster(requeteSite);
	}

	public void requeteSitePourClasse(RequeteSite requeteSite) throws Exception {
		requeteSiteInrEntry(requeteSite);
	}

	/////////////
	// indexer //
	/////////////

	public void indexerInrEntry() throws Exception {
		RequeteSite requeteSite = new RequeteSite();
		requeteSite.initLoinRequeteSite();
		EcouteurContexte ecouteurContexte = new EcouteurContexte();
		ecouteurContexte.initLoinEcouteurContexte();
		ecouteurContexte.setRequeteSite(requeteSite);
		requeteSite.setEcouteurContexte(ecouteurContexte);
		requeteSite.setConfigSite(ecouteurContexte.configSite);
		requeteSiteInrEntry(requeteSite);
		initLoinInrEntry(requeteSite);
		indexerInrEntry(requeteSite);
	}


	@Override public void indexerPourClasse(RequeteSite requeteSite) throws Exception {
		indexerInrEntry(requeteSite);
	}

	@Override public void indexerPourClasse(SolrInputDocument document) throws Exception {
		indexerInrEntry(document);
	}
	public void indexerInrEntry(RequeteSite requeteSite) throws Exception {
		SolrInputDocument document = new SolrInputDocument();
		indexerInrEntry(document);
		SolrClient clientSolr = requeteSite.ecouteurContexte.clientSolr;
		clientSolr.add(document);
		clientSolr.commit();
	}

	public void indexerInrEntry(SolrInputDocument document) throws Exception {
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
			case "inrDate":
				return oInrEntry.inrDate;
			case "doseActuelValeur":
				return oInrEntry.doseActuelValeur;
			case "doseActuelTexte":
				return oInrEntry.doseActuelTexte;
			case "changementDoseValeur":
				return oInrEntry.changementDoseValeur;
			case "changementDoseTexte":
				return oInrEntry.changementDoseTexte;
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
				o = attribuerInrEntry(v, val);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.attribuerPourClasse(v, val);
			}
		}
		return o != null;
	}
	public Object attribuerInrEntry(String var, Object val) throws Exception {
		InrEntry oInrEntry = (InrEntry)this;
		switch(var) {
			case "inrDate":
				oInrEntry.setInrDate((LocalDate)val);
				return val;
			case "doseActuelValeur":
				oInrEntry.setDoseActuelValeur((BigDecimal)val);
				return val;
			case "doseActuelTexte":
				oInrEntry.setDoseActuelTexte((Chaine)val);
				return val;
			case "changementDoseValeur":
				oInrEntry.setChangementDoseValeur((BigDecimal)val);
				return val;
			case "changementDoseTexte":
				oInrEntry.setChangementDoseTexte((Chaine)val);
				return val;
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
					o = definirInrEntry(v, val);
				else if(o instanceof Cluster) {
					Cluster cluster = (Cluster)o;
					o = cluster.definirPourClasse(v, val);
				}
			}
		}
		return o != null;
	}
	public Object definirInrEntry(String var, String val) throws Exception {
		InrEntry oInrEntry = (InrEntry)this;
		switch(var) {
			case "inrDate":
				oInrEntry.setInrDate(val);
				return val;
			case "doseActuelValeur":
				oInrEntry.setDoseActuelValeur(val);
				return val;
			case "doseActuelTexte":
				oInrEntry.setDoseActuelTexte(val);
				return val;
			case "changementDoseValeur":
				oInrEntry.setChangementDoseValeur(val);
				return val;
			case "changementDoseTexte":
				oInrEntry.setChangementDoseTexte(val);
				return val;
			default:
				return super.definirCluster(var, val);
		}
	}
}
