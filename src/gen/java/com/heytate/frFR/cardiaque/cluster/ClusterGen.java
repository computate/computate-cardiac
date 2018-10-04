package com.heytate.frFR.cardiaque.cluster;

import java.lang.Long;
import com.heytate.frFR.cardiaque.page.MiseEnPage;
import com.heytate.frFR.cardiaque.requete.RequeteSite;
import java.time.LocalDateTime;
import java.lang.Boolean;
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

	public Cluster requeteSite(RequeteSite o) throws Exception {
		setRequeteSite(o);
		return (Cluster)this;
	}

	public void setRequeteSite(RequeteSite o) throws Exception {
		this.requeteSite = o;
	}

	public RequeteSite requeteSite() throws Exception {
		return getRequeteSite();
	}

	public RequeteSite getRequeteSite() throws Exception {
		return requeteSite;
	}
	protected void requeteSiteInit() throws Exception {
		if(!requeteSiteCouverture.dejaInitialise) {
			_requeteSite(requeteSiteCouverture);
			if(requeteSite == null)
				requeteSite(requeteSiteCouverture.o);
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

	public Cluster page_(MiseEnPage o) throws Exception {
		setPage_(o);
		return (Cluster)this;
	}

	public void setPage_(MiseEnPage o) throws Exception {
		this.page_ = o;
	}

	public MiseEnPage page_() throws Exception {
		return getPage_();
	}

	public MiseEnPage getPage_() throws Exception {
		return page_;
	}
	protected void page_Init() throws Exception {
		if(!page_Couverture.dejaInitialise) {
			_page_(page_Couverture);
			if(page_ == null)
				page_(page_Couverture.o);
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

	public Cluster cle(Long o) throws Exception {
		setCle(o);
		return (Cluster)this;
	}

	public void setCle(Long o) throws Exception {
		this.cle = o;
	}

	public Long cle() throws Exception {
		return getCle();
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
				cle(cleCouverture.o);
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

	public Cluster cree(LocalDateTime o) throws Exception {
		setCree(o);
		return (Cluster)this;
	}

	public void setCree(LocalDateTime o) throws Exception {
		this.cree = o;
	}

	public LocalDateTime cree() throws Exception {
		return getCree();
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
				cree(creeCouverture.o);
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

	public Cluster modifie(LocalDateTime o) throws Exception {
		setModifie(o);
		return (Cluster)this;
	}

	public void setModifie(LocalDateTime o) throws Exception {
		this.modifie = o;
	}

	public LocalDateTime modifie() throws Exception {
		return getModifie();
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
				modifie(modifieCouverture.o);
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

	public Cluster utilisateurId(String o) throws Exception {
		setUtilisateurId(o);
		return (Cluster)this;
	}

	public void setUtilisateurId(String o) throws Exception {
		this.utilisateurId = o;
	}

	public String utilisateurId() throws Exception {
		return getUtilisateurId();
	}

	public String getUtilisateurId() throws Exception {
		return utilisateurId;
	}
	protected void utilisateurIdInit() throws Exception {
		if(!utilisateurIdCouverture.dejaInitialise) {
			_utilisateurId(utilisateurIdCouverture);
			if(utilisateurId == null)
				utilisateurId(utilisateurIdCouverture.o);
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

	public Cluster clusterNomCanonique(String o) throws Exception {
		setClusterNomCanonique(o);
		return (Cluster)this;
	}

	public void setClusterNomCanonique(String o) throws Exception {
		this.clusterNomCanonique = o;
	}

	public String clusterNomCanonique() throws Exception {
		return getClusterNomCanonique();
	}

	public String getClusterNomCanonique() throws Exception {
		return clusterNomCanonique;
	}
	protected void clusterNomCanoniqueInit() throws Exception {
		if(!clusterNomCanoniqueCouverture.dejaInitialise) {
			_clusterNomCanonique(clusterNomCanoniqueCouverture);
			if(clusterNomCanonique == null)
				clusterNomCanonique(clusterNomCanoniqueCouverture.o);
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

	public Cluster clusterNomSimple(String o) throws Exception {
		setClusterNomSimple(o);
		return (Cluster)this;
	}

	public void setClusterNomSimple(String o) throws Exception {
		this.clusterNomSimple = o;
	}

	public String clusterNomSimple() throws Exception {
		return getClusterNomSimple();
	}

	public String getClusterNomSimple() throws Exception {
		return clusterNomSimple;
	}
	protected void clusterNomSimpleInit() throws Exception {
		if(!clusterNomSimpleCouverture.dejaInitialise) {
			_clusterNomSimple(clusterNomSimpleCouverture);
			if(clusterNomSimple == null)
				clusterNomSimple(clusterNomSimpleCouverture.o);
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

	public Cluster supprime(Boolean o) throws Exception {
		setSupprime(o);
		return (Cluster)this;
	}

	public void setSupprime(Boolean o) throws Exception {
		this.supprime = o;
	}

	public Boolean supprime() throws Exception {
		return getSupprime();
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
				supprime(supprimeCouverture.o);
		}
		supprimeCouverture.dejaInitialise(true);
	}

	protected boolean dejaInitialiseCluster = false;

	public void initLoinCluster(RequeteSite requeteSite) throws Exception {
		((Cluster)this).requeteSite(requeteSite);
		requeteSite(requeteSite);
		initLoinCluster();
	}

	public void initLoinCluster() throws Exception {
		if(!dejaInitialiseCluster) {
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
}
