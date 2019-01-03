package org.computate.frFR.cardiaque.recherche;

import java.util.Objects;
import java.util.List;
import org.computate.frFR.cardiaque.couverture.Couverture;
import org.apache.solr.common.SolrDocumentList;
import org.computate.frFR.cardiaque.cluster.Cluster;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.computate.frFR.cardiaque.requete.RequeteSite;
import org.computate.frFR.cardiaque.ecrivain.ToutEcrivain;
import org.apache.commons.text.StringEscapeUtils;
import java.lang.Class;
import org.apache.commons.lang3.StringUtils;

/**	
 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.frFR.cardiaque.recherche.ListeRecherche&fq=classeEtendGen_indexed_boolean:true">Trouver la classe  dans Solr</a>
 * <br/>
 **/
public abstract class ListeRechercheGen<DEV> {

	///////
	// c //
	///////

	/**	L'entité « c »
	 *	 is defined as null before being initialized. 
	 */
	protected Class<DEV> c;
	public Couverture<Class<DEV>> cCouverture = new Couverture<Class<DEV>>().p(this).c(Class.class).var("c").o(c);

	/**	<br/>L'entité « c »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.frFR.cardiaque.recherche.ListeRecherche&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:c">Trouver l'entité c dans Solr</a>
	 * <br/>
	 * @param o est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _c(Couverture<Class<DEV>> o);

	public Class<DEV> getC() {
		return c;
	}

	public void setC(Class<DEV> o) {
		this.c = o;
		this.cCouverture.dejaInitialise = true;
	}
	protected ListeRecherche cInit()
 {
		if(!cCouverture.dejaInitialise) {
			_c(cCouverture);
			if(c == null)
				setC(cCouverture.o);
		}
		cCouverture.dejaInitialise(true);
		return (ListeRecherche)this;
	}

	//////////////////
	// requeteSite_ //
	//////////////////

	/**	L'entité « requeteSite_ »
	 *	 is defined as null before being initialized. 
	 */
	protected RequeteSite requeteSite_;
	public Couverture<RequeteSite> requeteSite_Couverture = new Couverture<RequeteSite>().p(this).c(RequeteSite.class).var("requeteSite_").o(requeteSite_);

	/**	<br/>L'entité « requeteSite_ »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.frFR.cardiaque.recherche.ListeRecherche&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:requeteSite_">Trouver l'entité requeteSite_ dans Solr</a>
	 * <br/>
	 * @param o est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _requeteSite_(Couverture<RequeteSite> o);

	public RequeteSite getRequeteSite_() {
		return requeteSite_;
	}

	public void setRequeteSite_(RequeteSite o) {
		this.requeteSite_ = o;
		this.requeteSite_Couverture.dejaInitialise = true;
	}
	protected ListeRecherche requeteSite_Init()
 {
		if(!requeteSite_Couverture.dejaInitialise) {
			_requeteSite_(requeteSite_Couverture);
			if(requeteSite_ == null)
				setRequeteSite_(requeteSite_Couverture.o);
		}
		requeteSite_Couverture.dejaInitialise(true);
		return (ListeRecherche)this;
	}

	///////////////
	// solrQuery //
	///////////////

	/**	L'entité « solrQuery »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut SolrQuery(). 
	 */
	protected SolrQuery solrQuery = new SolrQuery();
	public Couverture<SolrQuery> solrQueryCouverture = new Couverture<SolrQuery>().p(this).c(SolrQuery.class).var("solrQuery").o(solrQuery);

	/**	<br/>L'entité « solrQuery »
	 * Il est construit avant d'être initialisé avec le constructeur par défaut SolrQuery(). 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.frFR.cardiaque.recherche.ListeRecherche&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:solrQuery">Trouver l'entité solrQuery dans Solr</a>
	 * <br/>
	 * @param solrQuery est l'entité déjà construit. 
	 **/
	protected abstract void _solrQuery(SolrQuery o);

	public SolrQuery getSolrQuery() {
		return solrQuery;
	}

	public void setSolrQuery(SolrQuery o) {
		this.solrQuery = o;
		this.solrQueryCouverture.dejaInitialise = true;
	}
	protected ListeRecherche solrQueryInit()
 {
		if(!solrQueryCouverture.dejaInitialise) {
			_solrQuery(solrQuery);
		}
		solrQueryCouverture.dejaInitialise(true);
		return (ListeRecherche)this;
	}

	///////////////////
	// queryResponse //
	///////////////////

	/**	L'entité « queryResponse »
	 *	 is defined as null before being initialized. 
	 */
	protected QueryResponse queryResponse;
	public Couverture<QueryResponse> queryResponseCouverture = new Couverture<QueryResponse>().p(this).c(QueryResponse.class).var("queryResponse").o(queryResponse);

	/**	<br/>L'entité « queryResponse »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.frFR.cardiaque.recherche.ListeRecherche&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:queryResponse">Trouver l'entité queryResponse dans Solr</a>
	 * <br/>
	 * @param o est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _queryResponse(Couverture<QueryResponse> o);

	public QueryResponse getQueryResponse() {
		return queryResponse;
	}

	public void setQueryResponse(QueryResponse o) {
		this.queryResponse = o;
		this.queryResponseCouverture.dejaInitialise = true;
	}
	protected ListeRecherche queryResponseInit()
 {
		if(!queryResponseCouverture.dejaInitialise) {
			_queryResponse(queryResponseCouverture);
			if(queryResponse == null)
				setQueryResponse(queryResponseCouverture.o);
		}
		queryResponseCouverture.dejaInitialise(true);
		return (ListeRecherche)this;
	}

	//////////////////////
	// solrDocumentList //
	//////////////////////

	/**	L'entité « solrDocumentList »
	 *	 is defined as null before being initialized. 
	 */
	protected SolrDocumentList solrDocumentList;
	public Couverture<SolrDocumentList> solrDocumentListCouverture = new Couverture<SolrDocumentList>().p(this).c(SolrDocumentList.class).var("solrDocumentList").o(solrDocumentList);

	/**	<br/>L'entité « solrDocumentList »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.frFR.cardiaque.recherche.ListeRecherche&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:solrDocumentList">Trouver l'entité solrDocumentList dans Solr</a>
	 * <br/>
	 * @param o est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _solrDocumentList(Couverture<SolrDocumentList> o);

	public SolrDocumentList getSolrDocumentList() {
		return solrDocumentList;
	}

	public void setSolrDocumentList(SolrDocumentList o) {
		this.solrDocumentList = o;
		this.solrDocumentListCouverture.dejaInitialise = true;
	}
	protected ListeRecherche solrDocumentListInit()
 {
		if(!solrDocumentListCouverture.dejaInitialise) {
			_solrDocumentList(solrDocumentListCouverture);
			if(solrDocumentList == null)
				setSolrDocumentList(solrDocumentListCouverture.o);
		}
		solrDocumentListCouverture.dejaInitialise(true);
		return (ListeRecherche)this;
	}

	//////////
	// list //
	//////////

	/**	L'entité « list »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut List<DEV>(). 
	 */
	protected List<DEV> list = new java.util.ArrayList<DEV>();
	public Couverture<List<DEV>> listCouverture = new Couverture<List<DEV>>().p(this).c(List.class).var("list").o(list);

	/**	<br/>L'entité « list »
	 * Il est construit avant d'être initialisé avec le constructeur par défaut List<DEV>(). 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.frFR.cardiaque.recherche.ListeRecherche&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:list">Trouver l'entité list dans Solr</a>
	 * <br/>
	 * @param list est l'entité déjà construit. 
	 **/
	protected abstract void _list(List<DEV> l);

	public List<DEV> getList() {
		return list;
	}

	public void setList(List<DEV> l) {
		this.list = l;
		this.listCouverture.dejaInitialise = true;
	}
	public ListeRecherche addList(DEV...objets) {
		for(DEV o : objets) {
			addList(o);
		}
		return (ListeRecherche)this;
	}
	public ListeRecherche addList(DEV o) {
		if(o != null && !list.contains(o))
			this.list.add(o);
		return (ListeRecherche)this;
	}
	protected ListeRecherche listInit()
 {
		if(!listCouverture.dejaInitialise) {
			_list(list);
		}
		listCouverture.dejaInitialise(true);
		return (ListeRecherche)this;
	}

	//////////////
	// initLoin //
	//////////////

	protected boolean dejaInitialiseListeRecherche = false;

	public ListeRecherche initLoinListeRecherche(RequeteSite requeteSite) {
		setRequeteSite_(requeteSite);
		initLoinListeRecherche();
		return (ListeRecherche)this;
	}

	public ListeRecherche initLoinListeRecherche() {
		if(!dejaInitialiseListeRecherche) {
			dejaInitialiseListeRecherche = true;
			cInit();
			requeteSite_Init();
			solrQueryInit();
			queryResponseInit();
			solrDocumentListInit();
			listInit();
		}
		return (ListeRecherche)this;
	}

	public void initLoinPourClasse(RequeteSite requeteSite) {
		initLoinListeRecherche(requeteSite);
	}

	/////////////////
	// requeteSite //
	/////////////////

	public void requeteSiteListeRecherche(RequeteSite requeteSite) {
	}

	public void requeteSitePourClasse(RequeteSite requeteSite) {
		requeteSiteListeRecherche(requeteSite);
	}

	/////////////
	// obtenir //
	/////////////

	public Object obtenirPourClasse(String var) throws Exception {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtenirListeRecherche(v);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.obtenirPourClasse(v);
			}
		}
		return o;
	}
	public Object obtenirListeRecherche(String var) throws Exception {
		ListeRecherche oListeRecherche = (ListeRecherche)this;
		switch(var) {
			case "c":
				return oListeRecherche.c;
			case "requeteSite_":
				return oListeRecherche.requeteSite_;
			case "solrQuery":
				return oListeRecherche.solrQuery;
			case "queryResponse":
				return oListeRecherche.queryResponse;
			case "solrDocumentList":
				return oListeRecherche.solrDocumentList;
			case "list":
				return oListeRecherche.list;
			default:
				return null;
		}
	}

	///////////////
	// attribuer //
	///////////////

	public boolean attribuerPourClasse(String var, Object val) throws Exception {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = attribuerListeRecherche(v, val);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.attribuerPourClasse(v, val);
			}
		}
		return o != null;
	}
	public Object attribuerListeRecherche(String var, Object val) throws Exception {
		ListeRecherche oListeRecherche = (ListeRecherche)this;
		switch(var) {
			default:
				return null;
		}
	}

	//////////////
	// hashCode //
	//////////////

	@Override public int hashCode() {
		return Objects.hash();
	}

	////////////
	// equals //
	////////////

	@Override public boolean equals(Object o) {
		if(this == o)
			return true;
		if(!(o instanceof ListeRecherche))
			return false;
		ListeRecherche that = (ListeRecherche)o;
		return true;
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ListeRecherche {");
		sb.append(" }");
		return sb.toString();
	}
}
