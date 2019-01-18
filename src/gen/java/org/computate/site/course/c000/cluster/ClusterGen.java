package org.computate.site.course.c000.cluster;

import org.computate.frFR.cardiaque.couverture.Couverture;
import java.util.Date;
import java.time.LocalDateTime;
import org.apache.commons.lang3.StringUtils;
import io.vertx.core.logging.LoggerFactory;
import java.util.ArrayList;
import java.lang.Long;
import org.computate.frFR.cardiaque.requete.RequeteSite;
import java.lang.Boolean;
import org.computate.enUS.cardiac.writer.AllWriter;
import io.vertx.core.json.JsonObject;
import java.lang.String;
import io.vertx.core.logging.Logger;
import org.computate.site.course.c000.cluster.Cluster;
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
import java.time.format.DateTimeFormatter;
import io.vertx.ext.sql.SQLConnection;
import java.lang.Object;
import org.computate.frFR.cardiaque.page.MiseEnPage;
import io.vertx.ext.sql.SQLClient;
import org.apache.solr.common.SolrInputDocument;

/**	
 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.site.course.c000.cluster.Cluster&fq=classeEtendGen_indexed_boolean:true">Trouver la classe  dans Solr</a>
 * <br/>
 **/
public abstract class ClusterGen<DEV> extends Object {
	private static final Logger LOGGER = LoggerFactory.getLogger(Cluster.class);

	//////////////////
	// _siteRequest //
	//////////////////

	/**	L'entité « _siteRequest »
	 *	 is defined as null before being initialized. 
	 */
	protected RequeteSite _siteRequest;
	public Couverture<RequeteSite> _siteRequestCouverture = new Couverture<RequeteSite>().p(this).c(RequeteSite.class).var("_siteRequest").o(_siteRequest);

	/**	<br/>L'entité « _siteRequest »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.site.course.c000.cluster.Cluster&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:_siteRequest">Trouver l'entité _siteRequest dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void __siteRequest(Couverture<RequeteSite> c);

	public RequeteSite get() {
		return _siteRequest;
	}

	public void set(RequeteSite c) {
		this._siteRequest = c;
		this._siteRequestCouverture.dejaInitialise = true;
	}
	protected Cluster _siteRequestInit() {
		if(!_siteRequestCouverture.dejaInitialise) {
			__siteRequest(_siteRequestCouverture);
			if(_siteRequest == null)
				set(_siteRequestCouverture.o);
		}
		_siteRequestCouverture.dejaInitialise(true);
		return (Cluster)this;
	}

	///////////
	// page_ //
	///////////

	/**	L'entité « page_ »
	 *	 is defined as null before being initialized. 
	 */
	protected MiseEnPage page_;
	public Couverture<MiseEnPage> page_Couverture = new Couverture<MiseEnPage>().p(this).c(MiseEnPage.class).var("page_").o(page_);

	/**	<br/>L'entité « page_ »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.site.course.c000.cluster.Cluster&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:page_">Trouver l'entité page_ dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _page_(Couverture<MiseEnPage> c);

	public MiseEnPage get() {
		return page_;
	}

	public void set(MiseEnPage c) {
		this.page_ = c;
		this.page_Couverture.dejaInitialise = true;
	}
	protected Cluster page_Init() {
		if(!page_Couverture.dejaInitialise) {
			_page_(page_Couverture);
			if(page_ == null)
				set(page_Couverture.o);
		}
		page_Couverture.dejaInitialise(true);
		return (Cluster)this;
	}

	////////
	// pk //
	////////

	/**	L'entité « pk »
	 *	 is defined as null before being initialized. 
	 */
	protected Long pk;
	public Couverture<Long> pkCouverture = new Couverture<Long>().p(this).c(Long.class).var("pk").o(pk);

	/**	<br/>L'entité « pk »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.site.course.c000.cluster.Cluster&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pk">Trouver l'entité pk dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _pk(Couverture<Long> c);

	public Long get() {
		return pk;
	}

	public void set(Long c) {
		this.pk = c;
		this.pkCouverture.dejaInitialise = true;
	}
	public Cluster set(String o) {
		if(org.apache.commons.lang3.math.NumberUtils.isCreatable(o))
			this.pk = Long.parseLong(o);
		this.pkCouverture.dejaInitialise = true;
		return (Cluster)this;
	}
	protected Cluster pkInit() {
		if(!pkCouverture.dejaInitialise) {
			_pk(pkCouverture);
			if(pk == null)
				set(pkCouverture.o);
		}
		pkCouverture.dejaInitialise(true);
		return (Cluster)this;
	}

	public Long solr() {
		return pk;
	}

	public String str() {
		return pk == null ? "" : pk.toString();
	}

	public String nomAffichage() {
		return null;
	}

	public String htmTooltip() {
		return null;
	}

	public String htm() {
		return pk == null ? "" : StringEscapeUtils.escapeHtml4(str());
	}

	////////
	// id //
	////////

	/**	L'entité « id »
	 *	 is defined as null before being initialized. 
	 */
	protected String id;
	public Couverture<String> idCouverture = new Couverture<String>().p(this).c(String.class).var("id").o(id);

	/**	<br/>L'entité « id »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.site.course.c000.cluster.Cluster&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:id">Trouver l'entité id dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _id(Couverture<String> c);

	public String get() {
		return id;
	}

	public void set(String c) {
		this.id = c;
		this.idCouverture.dejaInitialise = true;
	}
	protected Cluster idInit() {
		if(!idCouverture.dejaInitialise) {
			_id(idCouverture);
			if(id == null)
				set(idCouverture.o);
		}
		idCouverture.dejaInitialise(true);
		return (Cluster)this;
	}

	public String solr() {
		return id;
	}

	public String str() {
		return id == null ? "" : id;
	}

	public String nomAffichage() {
		return null;
	}

	public String htmTooltip() {
		return null;
	}

	public String htm() {
		return id == null ? "" : StringEscapeUtils.escapeHtml4(str());
	}

	//////////////
	// _created //
	//////////////

	/**	L'entité « _created »
	 *	 is defined as null before being initialized. 
	 */
	protected LocalDateTime _created;
	public Couverture<LocalDateTime> _createdCouverture = new Couverture<LocalDateTime>().p(this).c(LocalDateTime.class).var("_created").o(_created);

	/**	<br/>L'entité « _created »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.site.course.c000.cluster.Cluster&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:_created">Trouver l'entité _created dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void __created(Couverture<LocalDateTime> c);

	public LocalDateTime get() {
		return _created;
	}

	public void set(LocalDateTime c) {
		this._created = c;
		this._createdCouverture.dejaInitialise = true;
	}
	public Cluster set(Instant o) {
		this._created = LocalDateTime.from(o);
		this._createdCouverture.dejaInitialise = true;
		return (Cluster)this;
	}
	/** Example: 2011-12-03T10:15:30+01:00 **/
	public Cluster set(String o) {
		this._created = LocalDateTime.parse(o, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
		this._createdCouverture.dejaInitialise = true;
		return (Cluster)this;
	}
	public Cluster set(Date o) {
		this._created = LocalDateTime.ofInstant(o.toInstant(), ZoneId.systemDefault());
		this._createdCouverture.dejaInitialise = true;
		return (Cluster)this;
	}
	protected Cluster _createdInit() {
		if(!_createdCouverture.dejaInitialise) {
			__created(_createdCouverture);
			if(_created == null)
				set(_createdCouverture.o);
		}
		_createdCouverture.dejaInitialise(true);
		return (Cluster)this;
	}

	public Date solr() {
		return _created == null ? null : Date.from(_created.atZone(ZoneId.systemDefault()).toInstant());
	}

	public String str() {
		return _created == null ? "" : _created.toString();
	}

	public String nomAffichage() {
		return null;
	}

	public String htmTooltip() {
		return null;
	}

	public String htm() {
		return _created == null ? "" : StringEscapeUtils.escapeHtml4(str());
	}

	///////////////
	// _modified //
	///////////////

	/**	L'entité « _modified »
	 *	 is defined as null before being initialized. 
	 */
	protected LocalDateTime _modified;
	public Couverture<LocalDateTime> _modifiedCouverture = new Couverture<LocalDateTime>().p(this).c(LocalDateTime.class).var("_modified").o(_modified);

	/**	<br/>L'entité « _modified »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.site.course.c000.cluster.Cluster&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:_modified">Trouver l'entité _modified dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void __modified(Couverture<LocalDateTime> c);

	public LocalDateTime get() {
		return _modified;
	}

	public void set(LocalDateTime c) {
		this._modified = c;
		this._modifiedCouverture.dejaInitialise = true;
	}
	public Cluster set(Instant o) {
		this._modified = LocalDateTime.from(o);
		this._modifiedCouverture.dejaInitialise = true;
		return (Cluster)this;
	}
	/** Example: 2011-12-03T10:15:30+01:00 **/
	public Cluster set(String o) {
		this._modified = LocalDateTime.parse(o, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
		this._modifiedCouverture.dejaInitialise = true;
		return (Cluster)this;
	}
	public Cluster set(Date o) {
		this._modified = LocalDateTime.ofInstant(o.toInstant(), ZoneId.systemDefault());
		this._modifiedCouverture.dejaInitialise = true;
		return (Cluster)this;
	}
	protected Cluster _modifiedInit() {
		if(!_modifiedCouverture.dejaInitialise) {
			__modified(_modifiedCouverture);
			if(_modified == null)
				set(_modifiedCouverture.o);
		}
		_modifiedCouverture.dejaInitialise(true);
		return (Cluster)this;
	}

	public Date solr() {
		return _modified == null ? null : Date.from(_modified.atZone(ZoneId.systemDefault()).toInstant());
	}

	public String str() {
		return _modified == null ? "" : _modified.toString();
	}

	public String nomAffichage() {
		return null;
	}

	public String htmTooltip() {
		return null;
	}

	public String htm() {
		return _modified == null ? "" : StringEscapeUtils.escapeHtml4(str());
	}

	/////////////
	// _userId //
	/////////////

	/**	L'entité « _userId »
	 *	 is defined as null before being initialized. 
	 */
	protected String _userId;
	public Couverture<String> _userIdCouverture = new Couverture<String>().p(this).c(String.class).var("_userId").o(_userId);

	/**	<br/>L'entité « _userId »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.site.course.c000.cluster.Cluster&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:_userId">Trouver l'entité _userId dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void __userId(Couverture<String> c);

	public String get() {
		return _userId;
	}

	public void set(String c) {
		this._userId = c;
		this._userIdCouverture.dejaInitialise = true;
	}
	protected Cluster _userIdInit() {
		if(!_userIdCouverture.dejaInitialise) {
			__userId(_userIdCouverture);
			if(_userId == null)
				set(_userIdCouverture.o);
		}
		_userIdCouverture.dejaInitialise(true);
		return (Cluster)this;
	}

	public String solr() {
		return _userId;
	}

	public String str() {
		return _userId == null ? "" : _userId;
	}

	public String nomAffichage() {
		return null;
	}

	public String htmTooltip() {
		return null;
	}

	public String htm() {
		return _userId == null ? "" : StringEscapeUtils.escapeHtml4(str());
	}

	///////////////////////////
	// _clusterCanonicalName //
	///////////////////////////

	/**	L'entité « _clusterCanonicalName »
	 *	 is defined as null before being initialized. 
	 */
	protected String _clusterCanonicalName;
	public Couverture<String> _clusterCanonicalNameCouverture = new Couverture<String>().p(this).c(String.class).var("_clusterCanonicalName").o(_clusterCanonicalName);

	/**	<br/>L'entité « _clusterCanonicalName »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.site.course.c000.cluster.Cluster&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:_clusterCanonicalName">Trouver l'entité _clusterCanonicalName dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void __clusterCanonicalName(Couverture<String> c);

	public String get() {
		return _clusterCanonicalName;
	}

	public void set(String c) {
		this._clusterCanonicalName = c;
		this._clusterCanonicalNameCouverture.dejaInitialise = true;
	}
	protected Cluster _clusterCanonicalNameInit() {
		if(!_clusterCanonicalNameCouverture.dejaInitialise) {
			__clusterCanonicalName(_clusterCanonicalNameCouverture);
			if(_clusterCanonicalName == null)
				set(_clusterCanonicalNameCouverture.o);
		}
		_clusterCanonicalNameCouverture.dejaInitialise(true);
		return (Cluster)this;
	}

	public String solr() {
		return _clusterCanonicalName;
	}

	public String str() {
		return _clusterCanonicalName == null ? "" : _clusterCanonicalName;
	}

	public String nomAffichage() {
		return null;
	}

	public String htmTooltip() {
		return null;
	}

	public String htm() {
		return _clusterCanonicalName == null ? "" : StringEscapeUtils.escapeHtml4(str());
	}

	////////////////////////
	// _clusterSimpleName //
	////////////////////////

	/**	L'entité « _clusterSimpleName »
	 *	 is defined as null before being initialized. 
	 */
	protected String _clusterSimpleName;
	public Couverture<String> _clusterSimpleNameCouverture = new Couverture<String>().p(this).c(String.class).var("_clusterSimpleName").o(_clusterSimpleName);

	/**	<br/>L'entité « _clusterSimpleName »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.site.course.c000.cluster.Cluster&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:_clusterSimpleName">Trouver l'entité _clusterSimpleName dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void __clusterSimpleName(Couverture<String> c);

	public String get() {
		return _clusterSimpleName;
	}

	public void set(String c) {
		this._clusterSimpleName = c;
		this._clusterSimpleNameCouverture.dejaInitialise = true;
	}
	protected Cluster _clusterSimpleNameInit() {
		if(!_clusterSimpleNameCouverture.dejaInitialise) {
			__clusterSimpleName(_clusterSimpleNameCouverture);
			if(_clusterSimpleName == null)
				set(_clusterSimpleNameCouverture.o);
		}
		_clusterSimpleNameCouverture.dejaInitialise(true);
		return (Cluster)this;
	}

	public String solr() {
		return _clusterSimpleName;
	}

	public String str() {
		return _clusterSimpleName == null ? "" : _clusterSimpleName;
	}

	public String nomAffichage() {
		return null;
	}

	public String htmTooltip() {
		return null;
	}

	public String htm() {
		return _clusterSimpleName == null ? "" : StringEscapeUtils.escapeHtml4(str());
	}

	//////////////
	// _deleted //
	//////////////

	/**	L'entité « _deleted »
	 *	 is defined as null before being initialized. 
	 */
	protected Boolean _deleted;
	public Couverture<Boolean> _deletedCouverture = new Couverture<Boolean>().p(this).c(Boolean.class).var("_deleted").o(_deleted);

	/**	<br/>L'entité « _deleted »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.site.course.c000.cluster.Cluster&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:_deleted">Trouver l'entité _deleted dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void __deleted(Couverture<Boolean> c);

	public Boolean get() {
		return _deleted;
	}

	public void set(Boolean c) {
		this._deleted = c;
		this._deletedCouverture.dejaInitialise = true;
	}
	public Cluster set(String o) {
		if(org.apache.commons.lang3.BooleanUtils.isTrue(org.apache.commons.lang3.BooleanUtils.toBoolean(o)))
			this._deleted = Boolean.parseBoolean(o);
		this._deletedCouverture.dejaInitialise = true;
		return (Cluster)this;
	}
	protected Cluster _deletedInit() {
		if(!_deletedCouverture.dejaInitialise) {
			__deleted(_deletedCouverture);
			if(_deleted == null)
				set(_deletedCouverture.o);
		}
		_deletedCouverture.dejaInitialise(true);
		return (Cluster)this;
	}

	public Boolean solr() {
		return _deleted;
	}

	public String str() {
		return _deleted == null ? "" : _deleted.toString();
	}

	public String nomAffichage() {
		return null;
	}

	public String htmTooltip() {
		return null;
	}

	public String htm() {
		return _deleted == null ? "" : StringEscapeUtils.escapeHtml4(str());
	}

	//////////////
	// initLoin //
	//////////////

	protected boolean dejaInitialiseCluster = false;

	public Cluster initLoinCluster(RequeteSite requeteSite) {
		setRequeteSite_(requeteSite);
		if(!dejaInitialiseCluster) {
			dejaInitialiseCluster = true;
			initLoinCluster();
		}
		return (Cluster)this;
	}

	public void initLoinCluster() {
		initCluster();
	}

	public void initCluster() {
		_siteRequestInit();
		page_Init();
		pkInit();
		idInit();
		_createdInit();
		_modifiedInit();
		_userIdInit();
		_clusterCanonicalNameInit();
		_clusterSimpleNameInit();
		_deletedInit();
	}

	public void initLoinPourClasse(RequeteSite requeteSite) {
		initLoinCluster(requeteSite);
	}

	/////////////////
	// requeteSite //
	/////////////////

	public void requeteSiteCluster(RequeteSite requeteSite) {
	}

	public void requeteSitePourClasse(RequeteSite requeteSite) {
		requeteSiteCluster(requeteSite);
	}

	/////////////
	// indexer //
	/////////////

	//public void indexerCluster() throws Exception {
		//RequeteSite requeteSite = new RequeteSite();
		//requeteSite.initLoinRequeteSite();
		//SiteContexte siteContexte = new SiteContexte();
		//siteContexte.initLoinSiteContexte();
		//siteContexte.setRequeteSite_(requeteSite);
		//requeteSite.setSiteContexte_(siteContexte);
		//requeteSiteCluster(requeteSite);
		//initLoinCluster(requeteSite);
		//indexerCluster();
	//}


	public void indexerPourClasse() throws Exception {
		indexerCluster();
	}

	public void indexerPourClasse(SolrInputDocument document) throws Exception {
		indexerCluster(document);
	}
	public void indexerCluster() throws Exception {
		SolrInputDocument document = new SolrInputDocument();
		indexerCluster(document);
		SolrClient clientSolr = requeteSite_.getSiteContexte_().getClientSolr();
		clientSolr.add(document);
		clientSolr.commit();
	}

	public void indexerCluster(SolrInputDocument document) throws Exception {
		if(pk != null) {
			document.addField("pk_indexed_long", pk);
			document.addField("pk_stored_long", pk);
		}
		if(id != null) {
		}
		if(_created != null) {
			document.addField("_created_indexed_date", DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(java.time.ZonedDateTime.ofInstant(_created, java.time.OffsetDateTime.now().getOffset(), ZoneId.systemDefault())));
			document.addField("_created_stored_date", DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(java.time.ZonedDateTime.ofInstant(_created, java.time.OffsetDateTime.now().getOffset(), ZoneId.systemDefault())));
		}
		if(_modified != null) {
			document.addField("_modified_indexed_date", DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(java.time.ZonedDateTime.ofInstant(_modified, java.time.OffsetDateTime.now().getOffset(), ZoneId.systemDefault())));
			document.addField("_modified_stored_date", DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(java.time.ZonedDateTime.ofInstant(_modified, java.time.OffsetDateTime.now().getOffset(), ZoneId.systemDefault())));
		}
		if(_userId != null) {
			document.addField("_userId_indexed_string", _userId);
			document.addField("_userId_stored_string", _userId);
		}
		if(_clusterCanonicalName != null) {
			document.addField("_clusterCanonicalName_indexed_string", _clusterCanonicalName);
			document.addField("_clusterCanonicalName_stored_string", _clusterCanonicalName);
		}
		if(_clusterSimpleName != null) {
			document.addField("_clusterSimpleName_indexed_string", _clusterSimpleName);
			document.addField("_clusterSimpleName_stored_string", _clusterSimpleName);
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
			case "_siteRequest":
				return oCluster._siteRequest;
			case "page_":
				return oCluster.page_;
			case "pk":
				return oCluster.pk;
			case "id":
				return oCluster.id;
			case "_created":
				return oCluster._created;
			case "_modified":
				return oCluster._modified;
			case "_userId":
				return oCluster._userId;
			case "_clusterCanonicalName":
				return oCluster._clusterCanonicalName;
			case "_clusterSimpleName":
				return oCluster._clusterSimpleName;
			case "_deleted":
				return oCluster._deleted;
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
				o = attribuerCluster(v, val);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.attribuerPourClasse(v, val);
			}
		}
		return o != null;
	}
	public Object attribuerCluster(String var, Object val) {
		Cluster oCluster = (Cluster)this;
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
					o = definirCluster(v, val);
				else if(o instanceof Cluster) {
					Cluster cluster = (Cluster)o;
					o = cluster.definirPourClasse(v, val);
				}
			}
		}
		return o != null;
	}
	public Object definirCluster(String var, String val) {
		switch(var) {
			case "pk":
				set(val);
				sauvegardesCluster.add(var);
				return val;
			case "id":
				set(val);
				sauvegardesCluster.add(var);
				return val;
			case "_created":
				set(val);
				sauvegardesCluster.add(var);
				return val;
			case "_modified":
				set(val);
				sauvegardesCluster.add(var);
				return val;
			case "_userId":
				set(val);
				sauvegardesCluster.add(var);
				return val;
			case "_clusterCanonicalName":
				set(val);
				sauvegardesCluster.add(var);
				return val;
			case "_clusterSimpleName":
				set(val);
				sauvegardesCluster.add(var);
				return val;
			case "_deleted":
				set(val);
				sauvegardesCluster.add(var);
				return val;
			default:
				return null;
		}
	}

	/////////////////
	// sauvegardes //
	/////////////////

	protected List<String> sauvegardesCluster = new ArrayList<String>();

	/////////////
	// peupler //
	/////////////

	public void peuplerPourClasse(SolrDocument solrDocument) {
		peuplerCluster(solrDocument);
	}
	public void peuplerCluster(SolrDocument solrDocument) {
		Cluster oCluster = (Cluster)this;
		sauvegardesCluster = (List<String>)solrDocument.get("sauvegardesCluster_stored_strings");

		if(sauvegardesCluster.contains("pk")) {
			Long pk = (Long)solrDocument.get("pk_stored_long");
			if(pk != null)
				oCluster.set(pk);
		}

		if(sauvegardesCluster.contains("id")) {
			String id = (String)solrDocument.get("id_stored_string");
			oCluster.set(id);
		}

		if(sauvegardesCluster.contains("_created")) {
			Date _created = (Date)solrDocument.get("_created_stored_date");
			if(_created != null)
				oCluster.set(_created);
		}

		if(sauvegardesCluster.contains("_modified")) {
			Date _modified = (Date)solrDocument.get("_modified_stored_date");
			if(_modified != null)
				oCluster.set(_modified);
		}

		if(sauvegardesCluster.contains("_userId")) {
			String _userId = (String)solrDocument.get("_userId_stored_string");
			if(_userId != null)
				oCluster.set(_userId);
		}

		if(sauvegardesCluster.contains("_clusterCanonicalName")) {
			String _clusterCanonicalName = (String)solrDocument.get("_clusterCanonicalName_stored_string");
			if(_clusterCanonicalName != null)
				oCluster.set(_clusterCanonicalName);
		}

		if(sauvegardesCluster.contains("_clusterSimpleName")) {
			String _clusterSimpleName = (String)solrDocument.get("_clusterSimpleName_stored_string");
			if(_clusterSimpleName != null)
				oCluster.set(_clusterSimpleName);
		}
	}

	//////////////
	// hashCode //
	//////////////

	@Override public int hashCode() {
		return Objects.hash(pk, id, _created, _modified, _userId, _clusterCanonicalName, _clusterSimpleName, _deleted);
	}

	////////////
	// equals //
	////////////

	@Override public boolean equals(Object o) {
		if(this == o)
			return true;
		if(!(o instanceof Cluster))
			return false;
		Cluster that = (Cluster)o;
		return Objects.equals( pk, that.pk )
				&& Objects.equals( id, that.id )
				&& Objects.equals( _created, that._created )
				&& Objects.equals( _modified, that._modified )
				&& Objects.equals( _userId, that._userId )
				&& Objects.equals( _clusterCanonicalName, that._clusterCanonicalName )
				&& Objects.equals( _clusterSimpleName, that._clusterSimpleName )
				&& Objects.equals( _deleted, that._deleted );
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Cluster {");
		sb.append( "pk: " ).append(pk);
		sb.append( ", id: \"" ).append(id).append( "\"" );
		sb.append( ", _created: " ).append(_created);
		sb.append( ", _modified: " ).append(_modified);
		sb.append( ", _userId: \"" ).append(_userId).append( "\"" );
		sb.append( ", _clusterCanonicalName: \"" ).append(_clusterCanonicalName).append( "\"" );
		sb.append( ", _clusterSimpleName: \"" ).append(_clusterSimpleName).append( "\"" );
		sb.append( ", _deleted: " ).append(_deleted);
		sb.append(" }");
		return sb.toString();
	}
}
