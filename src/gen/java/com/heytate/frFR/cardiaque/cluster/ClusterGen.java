package com.heytate.frFR.cardiaque.cluster;

import java.lang.Long;
import com.heytate.frFR.cardiaque.page.MiseEnPage;
import com.heytate.frFR.cardiaque.requete.RequeteSite;
import java.time.LocalDateTime;
import java.lang.Boolean;
import java.lang.Object;
import java.lang.String;
import com.heytate.frFR.cardiaque.couverture.Couverture;

public abstract class ClusterGen<DEV> extends Object {

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

	///////////
	// page_ //
	///////////

	/**	L'entité « page_ »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public MiseEnPage page_;
	public Couverture<MiseEnPage> page_Couverture = new Couverture<MiseEnPage>().p(this).c(MiseEnPage.class).var("page_").o(page_);

	/**	L'entité « page_ »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _page_(Couverture<MiseEnPage> o) throws Exception;

	public void setPage_(MiseEnPage o) throws Exception {
		this.page_ = o;
	}

	public MiseEnPage getPage_() throws Exception {
		return page_;
	}
	protected void page_Init() throws Exception {
		if(!page_Couverture.dejaInitialise) {
			_page_(page_Couverture);
			if(page_ == null)
				setPage_(page_Couverture.o);
		}
		page_Couverture.dejaInitialise(true);
	}

	/////////
	// cle //
	/////////

	/**	L'entité « cle »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public Long cle;
	public Couverture<Long> cleCouverture = new Couverture<Long>().p(this).c(Long.class).var("cle").o(cle);

	/**	L'entité « cle »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _cle(Couverture<Long> o) throws Exception;

	public void setCle(Long o) throws Exception {
		this.cle = o;
	}

	public Long getCle() throws Exception {
		return cle;
	}
	public Cluster cle(String o) throws Exception {
		if(org.apache.commons.lang3.math.NumberUtils.isNumber(o))
			this.cle = Long.parseLong(o);
		return (Cluster)this;
	}
	protected void cleInit() throws Exception {
		if(!cleCouverture.dejaInitialise) {
			_cle(cleCouverture);
			if(cle == null)
				setCle(cleCouverture.o);
		}
		cleCouverture.dejaInitialise(true);
	}

	//////////
	// cree //
	//////////

	/**	L'entité « cree »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public LocalDateTime cree;
	public Couverture<LocalDateTime> creeCouverture = new Couverture<LocalDateTime>().p(this).c(LocalDateTime.class).var("cree").o(cree);

	/**	L'entité « cree »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _cree(Couverture<LocalDateTime> o) throws Exception;

	public void setCree(LocalDateTime o) throws Exception {
		this.cree = o;
	}

	public LocalDateTime getCree() throws Exception {
		return cree;
	}
	public Cluster cree(String o) throws Exception {
		this.cree = java.time.LocalDateTime.parse(o, java.time.format.DateTimeFormatter.ISO_OFFSET_DATE_TIME);
		return (Cluster)this;
	}
	public Cluster cree(java.util.Date o) throws Exception {
		this.cree = java.time.LocalDateTime.ofInstant(o.toInstant(), java.time.ZoneId.systemDefault());
		return (Cluster)this;
	}
	protected void creeInit() throws Exception {
		if(!creeCouverture.dejaInitialise) {
			_cree(creeCouverture);
			if(cree == null)
				setCree(creeCouverture.o);
		}
		creeCouverture.dejaInitialise(true);
	}

	/////////////
	// modifie //
	/////////////

	/**	L'entité « modifie »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public LocalDateTime modifie;
	public Couverture<LocalDateTime> modifieCouverture = new Couverture<LocalDateTime>().p(this).c(LocalDateTime.class).var("modifie").o(modifie);

	/**	L'entité « modifie »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _modifie(Couverture<LocalDateTime> o) throws Exception;

	public void setModifie(LocalDateTime o) throws Exception {
		this.modifie = o;
	}

	public LocalDateTime getModifie() throws Exception {
		return modifie;
	}
	public Cluster modifie(String o) throws Exception {
		this.modifie = java.time.LocalDateTime.parse(o, java.time.format.DateTimeFormatter.ISO_OFFSET_DATE_TIME);
		return (Cluster)this;
	}
	public Cluster modifie(java.util.Date o) throws Exception {
		this.modifie = java.time.LocalDateTime.ofInstant(o.toInstant(), java.time.ZoneId.systemDefault());
		return (Cluster)this;
	}
	protected void modifieInit() throws Exception {
		if(!modifieCouverture.dejaInitialise) {
			_modifie(modifieCouverture);
			if(modifie == null)
				setModifie(modifieCouverture.o);
		}
		modifieCouverture.dejaInitialise(true);
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

	/////////////////////////
	// clusterNomCanonique //
	/////////////////////////

	/**	L'entité « clusterNomCanonique »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public String clusterNomCanonique;
	public Couverture<String> clusterNomCanoniqueCouverture = new Couverture<String>().p(this).c(String.class).var("clusterNomCanonique").o(clusterNomCanonique);

	/**	L'entité « clusterNomCanonique »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _clusterNomCanonique(Couverture<String> o) throws Exception;

	public void setClusterNomCanonique(String o) throws Exception {
		this.clusterNomCanonique = o;
	}

	public String getClusterNomCanonique() throws Exception {
		return clusterNomCanonique;
	}
	protected void clusterNomCanoniqueInit() throws Exception {
		if(!clusterNomCanoniqueCouverture.dejaInitialise) {
			_clusterNomCanonique(clusterNomCanoniqueCouverture);
			if(clusterNomCanonique == null)
				setClusterNomCanonique(clusterNomCanoniqueCouverture.o);
		}
		clusterNomCanoniqueCouverture.dejaInitialise(true);
	}

	//////////////////////
	// clusterNomSimple //
	//////////////////////

	/**	L'entité « clusterNomSimple »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public String clusterNomSimple;
	public Couverture<String> clusterNomSimpleCouverture = new Couverture<String>().p(this).c(String.class).var("clusterNomSimple").o(clusterNomSimple);

	/**	L'entité « clusterNomSimple »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _clusterNomSimple(Couverture<String> o) throws Exception;

	public void setClusterNomSimple(String o) throws Exception {
		this.clusterNomSimple = o;
	}

	public String getClusterNomSimple() throws Exception {
		return clusterNomSimple;
	}
	protected void clusterNomSimpleInit() throws Exception {
		if(!clusterNomSimpleCouverture.dejaInitialise) {
			_clusterNomSimple(clusterNomSimpleCouverture);
			if(clusterNomSimple == null)
				setClusterNomSimple(clusterNomSimpleCouverture.o);
		}
		clusterNomSimpleCouverture.dejaInitialise(true);
	}

	//////////////
	// supprime //
	//////////////

	/**	L'entité « supprime »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public Boolean supprime;
	public Couverture<Boolean> supprimeCouverture = new Couverture<Boolean>().p(this).c(Boolean.class).var("supprime").o(supprime);

	/**	L'entité « supprime »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _supprime(Couverture<Boolean> o) throws Exception;

	public void setSupprime(Boolean o) throws Exception {
		this.supprime = o;
	}

	public Boolean getSupprime() throws Exception {
		return supprime;
	}
	public Cluster supprime(String o) throws Exception {
		if(org.apache.commons.lang3.BooleanUtils.isTrue(org.apache.commons.lang3.BooleanUtils.toBoolean(o)))
			this.supprime = Boolean.parseBoolean(o);
		return (Cluster)this;
	}
	protected void supprimeInit() throws Exception {
		if(!supprimeCouverture.dejaInitialise) {
			_supprime(supprimeCouverture);
			if(supprime == null)
				setSupprime(supprimeCouverture.o);
		}
		supprimeCouverture.dejaInitialise(true);
	}

	protected boolean dejaInitialiseCluster = false;

	public void initLoinCluster(RequeteSite requeteSite) throws Exception {
		setRequeteSite(requeteSite);
		initLoinCluster();
	}

	public void initLoinCluster() throws Exception {
		if(!dejaInitialiseCluster) {
			super.initLoinObject(requeteSite);
			requeteSiteInit();
			page_Init();
			cleInit();
			creeInit();
			modifieInit();
			utilisateurIdInit();
			clusterNomCanoniqueInit();
			clusterNomSimpleInit();
			supprimeInit();
			dejaInitialiseCluster = true;
		}
	}

	public void initLoinPourClasse(RequeteSite requeteSite) throws Exception {
		initLoinCluster(requeteSite);
	}

	@Test public void indexerClusterTest() throws Exception {
		RequeteSite requeteSite = new RequeteSite();
		requeteSite.initLoinRequeteSite();
		EcouteurContexte ecouteurContexte = new EcouteurContexte();
		ecouteurContexte.initLoinEcouteurContexte();
		ecouteurContexte.requeteSite(requeteSite);
		requeteSite.ecouteurContexte(ecouteurContexte);
		requeteSite.configSite(ecouteurContexte.configSite);
		requeteSiteCluster(requeteSite);
		initLoinCluster(requeteSite);
		indexerCluster(requeteSite);
	}


	public void indexerPourClasse(RequeteSite requeteSite) throws Exception {
		indexerCluster(requeteSite);
	}

	public void indexerPourClasse(SolrInputDocument document) throws Exception {
		indexerCluster(document);
	}
	public void indexerCluster(RequeteSite requeteSite) throws Exception {
		SolrInputDocument document = new SolrInputDocument();
		indexerCluster(document);
		SolrClient clientSolr = requeteSite.ecouteurContexte.clientSolr;
		clientSolr.add(document);
		clientSolr.commit();
	}

	public void indexerCluster(SolrInputDocument document) throws Exception {
		if(cle != null) {
		}
		if(cree != null) {
		}
		if(modifie != null) {
		}
		if(utilisateurId != null) {
		}
		if(clusterNomCanonique != null) {
		}
		if(clusterNomSimple != null) {
		}
	}

	public Object obtenirPourClasse(String var) throws Exception {
		String[] vars = org.apache.commons.lang3.StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtenirCluster(v);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.obtenirPourClasse(v);
			}
		}
		return o;
	}
	public Object obtenirCluster(String var) throws Exception {
		Cluster oCluster = (Cluster)this;
		switch(var) {
		case "requeteSite": return oCluster.requeteSite;
		case "page_": return oCluster.page_;
		case "cle": return oCluster.cle;
		case "cree": return oCluster.cree;
		case "modifie": return oCluster.modifie;
		case "utilisateurId": return oCluster.utilisateurId;
		case "clusterNomCanonique": return oCluster.clusterNomCanonique;
		case "clusterNomSimple": return oCluster.clusterNomSimple;
		case "supprime": return oCluster.supprime;
		default:
			return null;
		}
	}

	public boolean attribuerPourClasse(String var, Object val) throws Exception {
		String[] vars = org.apache.commons.lang3.StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = attribuerCluster(v, val);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.attribuerPourClasse(v, val);
			}
		}
		return o != null;
	}
	public Object attribuerCluster(String var, Object val) throws Exception {
		Cluster oCluster = (Cluster)this;		switch(var) {
		case "requeteSite": oCluster.setRequeteSite((RequeteSite)val); return val;
		case "page_": oCluster.setPage_((MiseEnPage)val); return val;
		case "cle": oCluster.setCle((Long)val); return val;
		case "cree": oCluster.setCree((LocalDateTime)val); return val;
		case "modifie": oCluster.setModifie((LocalDateTime)val); return val;
		case "utilisateurId": oCluster.setUtilisateurId((String)val); return val;
		case "clusterNomCanonique": oCluster.setClusterNomCanonique((String)val); return val;
		case "clusterNomSimple": oCluster.setClusterNomSimple((String)val); return val;
		case "supprime": oCluster.setSupprime((Boolean)val); return val;
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
					o = definirCluster(v, val);
				else if(o instanceof Cluster) {
					Cluster cluster = (Cluster)o;
					o = cluster.definirPourClasse(v, val);
				}
			}
		}
		return o != null;
	}
	public Object definirCluster(String var, String val) throws Exception {
		Cluster oCluster = (Cluster)this;
		switch(var) {
		case "requeteSite":
			oCluster.setRequeteSite(val);
			return val;
		case "page_":
			oCluster.setPage_(val);
			return val;
		case "cle":
			oCluster.setCle(val);
			return val;
		case "cree":
			oCluster.setCree(val);
			return val;
		case "modifie":
			oCluster.setModifie(val);
			return val;
		case "utilisateurId":
			oCluster.setUtilisateurId(val);
			return val;
		case "clusterNomCanonique":
			oCluster.setClusterNomCanonique(val);
			return val;
		case "clusterNomSimple":
			oCluster.setClusterNomSimple(val);
			return val;
		case "supprime":
			oCluster.setSupprime(val);
			return val;
		default:
			return null;
		}
	}
}
