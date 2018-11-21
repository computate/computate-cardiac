package org.computate.frFR.cardiaque.page.accueil;

import org.computate.frFR.cardiaque.couverture.Couverture;
import org.computate.frFR.cardiaque.cluster.Cluster;
import org.computate.frFR.cardiaque.requete.RequeteSite;
import org.computate.frFR.cardiaque.page.MiseEnPage;
import java.lang.String;

public abstract class PageAccueilGen<DEV> extends MiseEnPage {

	///////////////
	// pageTitre //
	///////////////

	/**	L'entité « pageTitre »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected String pageTitre;
	public Couverture<String> pageTitreCouverture = new Couverture<String>().p(this).c(String.class).var("pageTitre").o(pageTitre);

	/**	L'entité « pageTitre »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _pageTitre(Couverture<String> o) throws Exception;

	public String getPageTitre() {
		return pageTitre;
	}

	public void setPageTitre(String o) throws Exception {
		this.pageTitre = o;
	}
	protected void pageTitreInit() throws Exception {
		if(!pageTitreCouverture.dejaInitialise) {
			_pageTitre(pageTitreCouverture);
			if(pageTitre == null)
				setPageTitre(pageTitreCouverture.o);
		}
		pageTitreCouverture.dejaInitialise(true);
	}

	/////////////
	// pageUri //
	/////////////

	/**	L'entité « pageUri »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected String pageUri;
	public Couverture<String> pageUriCouverture = new Couverture<String>().p(this).c(String.class).var("pageUri").o(pageUri);

	/**	L'entité « pageUri »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _pageUri(Couverture<String> o) throws Exception;

	public String getPageUri() {
		return pageUri;
	}

	public void setPageUri(String o) throws Exception {
		this.pageUri = o;
	}
	protected void pageUriInit() throws Exception {
		if(!pageUriCouverture.dejaInitialise) {
			_pageUri(pageUriCouverture);
			if(pageUri == null)
				setPageUri(pageUriCouverture.o);
		}
		pageUriCouverture.dejaInitialise(true);
	}

	/////////////////////
	// initialiserLoin //
	/////////////////////

	protected boolean dejaInitialisePageAccueil = false;

	public void initLoinPageAccueil(RequeteSite requeteSite) throws Exception {
		setRequeteSite_(requeteSite);
		initLoinPageAccueil();
	}

	public void initLoinPageAccueil() throws Exception {
		if(!dejaInitialisePageAccueil) {
			super.initLoinMiseEnPage(requeteSite_);
			pageTitreInit();
			pageUriInit();
			dejaInitialisePageAccueil = true;
		}
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
		String[] vars = org.apache.commons.lang3.StringUtils.split(var, ".");
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
		String[] vars = org.apache.commons.lang3.StringUtils.split(var, ".");
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
					o = definirPageAccueil(v, val);
				else if(o instanceof Cluster) {
					Cluster cluster = (Cluster)o;
					o = cluster.definirPourClasse(v, val);
				}
			}
		}
		return o != null;
	}
	public Object definirPageAccueil(String var, String val) throws Exception {
		PageAccueil oPageAccueil = (PageAccueil)this;
		switch(var) {
			case "pageTitre":
				oPageAccueil.setPageTitre(val);
				return val;
			case "pageUri":
				oPageAccueil.setPageUri(val);
				return val;
			default:
				return super.definirMiseEnPage(var, val);
		}
	}
}
