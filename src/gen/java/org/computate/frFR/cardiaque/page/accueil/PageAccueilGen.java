package org.computate.frFR.cardiaque.page.accueil;

import org.computate.frFR.cardiaque.couverture.Couverture;
import io.vertx.core.http.HttpServerResponse;
import org.computate.frFR.cardiaque.cluster.Cluster;
import org.computate.frFR.cardiaque.requete.RequeteSite;
import org.apache.commons.text.StringEscapeUtils;
import org.computate.frFR.cardiaque.page.MiseEnPage;
import java.lang.String;
import org.apache.commons.lang3.StringUtils;

/**	
 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.frFR.cardiaque.page.accueil.PageAccueil&fq=classeEtendGen_indexed_boolean:true">Trouver la classe  dans Solr</a>
 * <br/>
 **/
public abstract class PageAccueilGen<DEV> extends MiseEnPage {

	///////////////
	// pageTitre //
	///////////////

	/**	L'entité « pageTitre »
	 *	 is defined as null before being initialized. 
	 */
	protected String pageTitre;
	public Couverture<String> pageTitreCouverture = new Couverture<String>().p(this).c(String.class).var("pageTitre").o(pageTitre);

	/**	<br/>L'entité « pageTitre »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.frFR.cardiaque.page.accueil.PageAccueil&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:pageTitre">Trouver l'entité pageTitre dans Solr</a>
	 * <br/>
	 * @param o est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _pageTitre(Couverture<String> o) throws Exception;

	public String getPageTitre() {
		return pageTitre;
	}

	public void setPageTitre(String o) {
		this.pageTitre = o;
		this.pageTitreCouverture.dejaInitialise = true;
	}
	protected PageAccueil pageTitreInit() throws Exception {
		if(!pageTitreCouverture.dejaInitialise) {
			_pageTitre(pageTitreCouverture);
			if(pageTitre == null)
				setPageTitre(pageTitreCouverture.o);
		}
		pageTitreCouverture.dejaInitialise(true);
		return (PageAccueil)this;
	}

	public String solrPageTitre() {
		return pageTitre;
	}

	public String strPageTitre() {
		return pageTitre == null ? "" : pageTitre;
	}

	public String nomAffichagePageTitre() {
		return null;
	}

	public String htmlTooltipPageTitre() {
		return null;
	}

	public String htmlPageTitre() {
		return pageTitre == null ? "" : StringEscapeUtils.escapeHtml4(strPageTitre());
	}

	/////////////
	// pageUri //
	/////////////

	/**	L'entité « pageUri »
	 *	 is defined as null before being initialized. 
	 */
	protected String pageUri;
	public Couverture<String> pageUriCouverture = new Couverture<String>().p(this).c(String.class).var("pageUri").o(pageUri);

	/**	<br/>L'entité « pageUri »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.frFR.cardiaque.page.accueil.PageAccueil&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:pageUri">Trouver l'entité pageUri dans Solr</a>
	 * <br/>
	 * @param o est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _pageUri(Couverture<String> o) throws Exception;

	public String getPageUri() {
		return pageUri;
	}

	public void setPageUri(String o) {
		this.pageUri = o;
		this.pageUriCouverture.dejaInitialise = true;
	}
	protected PageAccueil pageUriInit() throws Exception {
		if(!pageUriCouverture.dejaInitialise) {
			_pageUri(pageUriCouverture);
			if(pageUri == null)
				setPageUri(pageUriCouverture.o);
		}
		pageUriCouverture.dejaInitialise(true);
		return (PageAccueil)this;
	}

	public String solrPageUri() {
		return pageUri;
	}

	public String strPageUri() {
		return pageUri == null ? "" : pageUri;
	}

	public String nomAffichagePageUri() {
		return null;
	}

	public String htmlTooltipPageUri() {
		return null;
	}

	public String htmlPageUri() {
		return pageUri == null ? "" : StringEscapeUtils.escapeHtml4(strPageUri());
	}

	//////////////
	// initLoin //
	//////////////

	protected boolean dejaInitialisePageAccueil = false;

	public PageAccueil initLoinPageAccueil(RequeteSite requeteSite) throws Exception {
		setRequeteSite_(requeteSite);
		initLoinPageAccueil();
		return (PageAccueil)this;
	}

	public PageAccueil initLoinPageAccueil() throws Exception {
		if(!dejaInitialisePageAccueil) {
			dejaInitialisePageAccueil = true;
			super.initLoinMiseEnPage(requeteSite_);
			pageTitreInit();
			pageUriInit();
		}
		return (PageAccueil)this;
	}

	public void initLoinPourClasse(RequeteSite requeteSite) throws Exception {
		initLoinPageAccueil(requeteSite);
	}

	/////////////////
	// requeteSite //
	/////////////////

	public void requeteSitePageAccueil(RequeteSite requeteSite) throws Exception {
			super.requeteSiteMiseEnPage(requeteSite);
	}

	public void requeteSitePourClasse(RequeteSite requeteSite) throws Exception {
		requeteSitePageAccueil(requeteSite);
	}

	/////////////
	// obtenir //
	/////////////

	@Override public Object obtenirPourClasse(String var) throws Exception {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtenirPageAccueil(v);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.obtenirPourClasse(v);
			}
		}
		return o;
	}
	public Object obtenirPageAccueil(String var) throws Exception {
		PageAccueil oPageAccueil = (PageAccueil)this;
		switch(var) {
			case "pageTitre":
				return oPageAccueil.pageTitre;
			case "pageUri":
				return oPageAccueil.pageUri;
			default:
				return super.obtenirMiseEnPage(var);
		}
	}

	///////////////
	// attribuer //
	///////////////

	@Override public boolean attribuerPourClasse(String var, Object val) throws Exception {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = attribuerPageAccueil(v, val);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.attribuerPourClasse(v, val);
			}
		}
		return o != null;
	}
	public Object attribuerPageAccueil(String var, Object val) throws Exception {
		PageAccueil oPageAccueil = (PageAccueil)this;
		switch(var) {
			default:
				return super.attribuerMiseEnPage(var, val);
		}
	}
}
