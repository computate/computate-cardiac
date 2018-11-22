package org.computate.frFR.cardiaque.cluster;

import org.computate.frFR.cardiaque.contexte.SiteContexte;
import org.computate.frFR.cardiaque.couverture.Couverture;
import java.lang.Long;
import org.computate.frFR.cardiaque.cluster.Cluster;
import java.time.LocalDateTime;
import org.computate.frFR.cardiaque.requete.RequeteSite;
import java.lang.Boolean;
import java.lang.Object;
import org.computate.frFR.cardiaque.page.MiseEnPage;
import java.lang.String;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.client.solrj.SolrClient;

public abstract class ClusterGen<DEV> extends Object {

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
	protected void requeteSite_Init() throws Exception {
		if(!requeteSite_Couverture.dejaInitialise) {
			_requeteSite_(requeteSite_Couverture);
			if(requeteSite_ == null)
				setRequeteSite_(requeteSite_Couverture.o);
		}
		requeteSite_Couverture.dejaInitialise(true);
	}

	///////////
	// page_ //
	///////////

	/**	L'entité « page_ »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected MiseEnPage page_;
	public Couverture<MiseEnPage> page_Couverture = new Couverture<MiseEnPage>().p(this).c(MiseEnPage.class).var("page_").o(page_);

	/**	L'entité « page_ »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _page_(Couverture<MiseEnPage> o) throws Exception;

	public MiseEnPage getPage_() {
		return page_;
	}

	public void setPage_(MiseEnPage o) {
		this.page_ = o;
	}
	protected void page_Init() throws Exception {
		if(!page_Couverture.dejaInitialise) {
			_page_(page_Couverture);
			if(page_ == null)
				setPage_(page_Couverture.o);
		}
		page_Couverture.dejaInitialise(true);
	}

	////////
	// pk //
	////////

	/**	L'entité « pk »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected Long pk;
	public Couverture<Long> pkCouverture = new Couverture<Long>().p(this).c(Long.class).var("pk").o(pk);

	/**	L'entité « pk »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _pk(Couverture<Long> o) throws Exception;

	public Long getPk() {
		return pk;
	}

	public void setPk(Long o) {
		this.pk = o;
	}
	public Cluster setPk(String o) throws Exception {
		if(org.apache.commons.lang3.math.NumberUtils.isCreatable(o))
			this.pk = Long.parseLong(o);
		return (Cluster)this;
	}
	protected void pkInit() throws Exception {
		if(!pkCouverture.dejaInitialise) {
			_pk(pkCouverture);
			if(pk == null)
				setPk(pkCouverture.o);
		}
		pkCouverture.dejaInitialise(true);
	}

	////////
	// id //
	////////

	/**	L'entité « id »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected String id;
	public Couverture<String> idCouverture = new Couverture<String>().p(this).c(String.class).var("id").o(id);

	/**	L'entité « id »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _id(Couverture<String> o) throws Exception;

	public String getId() {
		return id;
	}

	public void setId(String o) {
		this.id = o;
	}
	protected void idInit() throws Exception {
		if(!idCouverture.dejaInitialise) {
			_id(idCouverture);
			if(id == null)
				setId(idCouverture.o);
		}
		idCouverture.dejaInitialise(true);
	}

	//////////
	// cree //
	//////////

	/**	L'entité « cree »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected LocalDateTime cree;
	public Couverture<LocalDateTime> creeCouverture = new Couverture<LocalDateTime>().p(this).c(LocalDateTime.class).var("cree").o(cree);

	/**	L'entité « cree »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _cree(Couverture<LocalDateTime> o) throws Exception;

	public LocalDateTime getCree() {
		return cree;
	}

	public void setCree(LocalDateTime o) {
		this.cree = o;
	}
	/** Example: 2011-12-03T10:15:30+01:00 **/
	public Cluster setCree(String o) throws Exception {
		this.cree = java.time.LocalDateTime.parse(o, java.time.format.DateTimeFormatter.ISO_OFFSET_DATE_TIME);
		return (Cluster)this;
	}
	public Cluster setCree(java.util.Date o) throws Exception {
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
	protected LocalDateTime modifie;
	public Couverture<LocalDateTime> modifieCouverture = new Couverture<LocalDateTime>().p(this).c(LocalDateTime.class).var("modifie").o(modifie);

	/**	L'entité « modifie »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _modifie(Couverture<LocalDateTime> o) throws Exception;

	public LocalDateTime getModifie() {
		return modifie;
	}

	public void setModifie(LocalDateTime o) {
		this.modifie = o;
	}
	/** Example: 2011-12-03T10:15:30+01:00 **/
	public Cluster setModifie(String o) throws Exception {
		this.modifie = java.time.LocalDateTime.parse(o, java.time.format.DateTimeFormatter.ISO_OFFSET_DATE_TIME);
		return (Cluster)this;
	}
	public Cluster setModifie(java.util.Date o) throws Exception {
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
	protected String clusterNomCanonique;
	public Couverture<String> clusterNomCanoniqueCouverture = new Couverture<String>().p(this).c(String.class).var("clusterNomCanonique").o(clusterNomCanonique);

	/**	L'entité « clusterNomCanonique »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _clusterNomCanonique(Couverture<String> o) throws Exception;

	public String getClusterNomCanonique() {
		return clusterNomCanonique;
	}

	public void setClusterNomCanonique(String o) {
		this.clusterNomCanonique = o;
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
	protected String clusterNomSimple;
	public Couverture<String> clusterNomSimpleCouverture = new Couverture<String>().p(this).c(String.class).var("clusterNomSimple").o(clusterNomSimple);

	/**	L'entité « clusterNomSimple »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _clusterNomSimple(Couverture<String> o) throws Exception;

	public String getClusterNomSimple() {
		return clusterNomSimple;
	}

	public void setClusterNomSimple(String o) {
		this.clusterNomSimple = o;
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
	protected Boolean supprime;
	public Couverture<Boolean> supprimeCouverture = new Couverture<Boolean>().p(this).c(Boolean.class).var("supprime").o(supprime);

	/**	L'entité « supprime »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _supprime(Couverture<Boolean> o) throws Exception;

	public Boolean getSupprime() {
		return supprime;
	}

	public void setSupprime(Boolean o) {
		this.supprime = o;
	}
	public Cluster setSupprime(String o) throws Exception {
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

	/////////////////////
	// initialiserLoin //
	/////////////////////

	protected boolean dejaInitialiseCluster = false;

	public void initLoinCluster(RequeteSite requeteSite) throws Exception {
		setRequeteSite_(requeteSite);
		initLoinCluster();
	}

	public void initLoinCluster() throws Exception {
		if(!dejaInitialiseCluster) {
			requeteSite_Init();
			page_Init();
			pkInit();
			idInit();
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

	/////////////////
	// requeteSite //
	/////////////////

	public void requeteSiteCluster(RequeteSite requeteSite) throws Exception {
	}

	public void requeteSitePourClasse(RequeteSite requeteSite) throws Exception {
		requeteSiteCluster(requeteSite);
	}

	/////////////
	// indexer //
	/////////////

	public void indexerCluster() throws Exception {
		RequeteSite requeteSite = new RequeteSite();
		requeteSite.initLoinRequeteSite();
		SiteContexte SiteContexte = new SiteContexte();
		SiteContexte.initLoinSiteContexte();
		SiteContexte.setRequeteSite_(requeteSite);
		requeteSite.setSiteContexte_(SiteContexte);
		requeteSiteCluster(requeteSite);
		initLoinCluster(requeteSite);
		indexerCluster(requeteSite);
	}


	public void indexerPourClasse(RequeteSite requeteSite) throws Exception {
		indexerCluster(requeteSite_);
	}

	public void indexerPourClasse(SolrInputDocument document) throws Exception {
		indexerCluster(document);
	}
	public void indexerCluster(RequeteSite requeteSite) throws Exception {
		SolrInputDocument document = new SolrInputDocument();
		indexerCluster(document);
		SolrClient clientSolr = requeteSite_.getSiteContexte_().getClientSolr();
		clientSolr.add(document);
		clientSolr.commit();
	}

	public void indexerCluster(SolrInputDocument document) throws Exception {
		if(pk != null) {
			document.addField("pk_indexe_long", pk);
			document.addField("pk_stocke_long", pk);
		}
		if(id != null) {
		}
		if(cree != null) {
			document.addField("cree_indexe_date", java.time.format.DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(java.time.ZonedDateTime.ofInstant(cree, java.time.OffsetDateTime.now().getOffset(), java.time.ZoneId.of("UTC"))));
			document.addField("cree_stocke_date", java.time.format.DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(java.time.ZonedDateTime.ofInstant(cree, java.time.OffsetDateTime.now().getOffset(), java.time.ZoneId.of("UTC"))));
		}
		if(modifie != null) {
			document.addField("modifie_indexe_date", java.time.format.DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(java.time.ZonedDateTime.ofInstant(modifie, java.time.OffsetDateTime.now().getOffset(), java.time.ZoneId.of("UTC"))));
			document.addField("modifie_stocke_date", java.time.format.DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(java.time.ZonedDateTime.ofInstant(modifie, java.time.OffsetDateTime.now().getOffset(), java.time.ZoneId.of("UTC"))));
		}
		if(utilisateurId != null) {
			document.addField("utilisateurId_indexe_string", utilisateurId);
			document.addField("utilisateurId_stocke_string", utilisateurId);
		}
		if(clusterNomCanonique != null) {
			document.addField("clusterNomCanonique_indexe_string", clusterNomCanonique);
			document.addField("clusterNomCanonique_stocke_string", clusterNomCanonique);
		}
		if(clusterNomSimple != null) {
			document.addField("clusterNomSimple_indexe_string", clusterNomSimple);
			document.addField("clusterNomSimple_stocke_string", clusterNomSimple);
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
			case "requeteSite_":
				return oCluster.requeteSite_;
			case "page_":
				return oCluster.page_;
			case "pk":
				return oCluster.pk;
			case "id":
				return oCluster.id;
			case "cree":
				return oCluster.cree;
			case "modifie":
				return oCluster.modifie;
			case "utilisateurId":
				return oCluster.utilisateurId;
			case "clusterNomCanonique":
				return oCluster.clusterNomCanonique;
			case "clusterNomSimple":
				return oCluster.clusterNomSimple;
			case "supprime":
				return oCluster.supprime;
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
				o = attribuerCluster(v, val);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.attribuerPourClasse(v, val);
			}
		}
		return o != null;
	}
	public Object attribuerCluster(String var, Object val) throws Exception {
		Cluster oCluster = (Cluster)this;
		switch(var) {
			default:
				return null;
		}
	}

	/////////////
	// definir //
	/////////////

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
			case "pk":
				oCluster.setPk(val);
				return val;
			case "id":
				oCluster.setId(val);
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
