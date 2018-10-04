package com.heytate.frFR.cardiaque.page;

import java.io.PrintWriter;
import java.lang.Long;
import com.heytate.frFR.cardiaque.requete.RequeteSite;
import com.heytate.frFR.cardiac.chaine.Chaine;
import java.time.LocalDateTime;
import com.heytate.frFR.cardiaque.page.parti.PageParti;
import java.lang.Boolean;
import java.lang.String;
import java.lang.Integer;
import com.heytate.frFR.cardiaque.couverture.Couverture;
import java.util.ArrayList;

public abstract class MiseEnPageGen<DEV> extends Object {

	////////////////
	// pagePartis //
	////////////////

	/**	L'entité « pagePartis »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut ArrayList<PageParti>(). 
	 */
	public ArrayList<PageParti> pagePartis = new ArrayList<PageParti>();
	public Couverture<ArrayList<PageParti>> pagePartisCouverture = new Couverture<ArrayList<PageParti>>().p(this).c(ArrayList.class).var("pagePartis").o(pagePartis);

	/**	L'entité « pagePartis »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut ArrayList<PageParti>(). 
	 *	@param pagePartis est le champ déjà construit. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _pagePartis(ArrayList<PageParti> l) throws Exception;

	public MiseEnPage pagePartis(ArrayList<PageParti> l) throws Exception {
		setPagePartis(l);
		return (MiseEnPage)this;
	}

	public void setPagePartis(ArrayList<PageParti> l) throws Exception {
		this.pagePartis = l;
	}

	public ArrayList<PageParti> pagePartis() throws Exception {
		return getPagePartis();
	}

	public ArrayList<PageParti> getPagePartis() throws Exception {
		return pagePartis;
	}
	public MiseEnPage pagePartisAjouter(PageParti...objets) throws Exception {
		for(PageParti o : objets) {
			pagePartisAjouter(o);
		}
		return (MiseEnPage)this;
	}
	public MiseEnPage pagePartisAjouter(PageParti o) throws Exception {
		if(o != null && !pagePartis.contains(o))
			this.pagePartis.add(o);
		return (MiseEnPage)this;
	}
	protected void pagePartisInit() throws Exception {
		if(!pagePartisCouverture.dejaInitialise) {
			_pagePartis(pagePartis);
		}
		pagePartisCouverture.dejaInitialise(true);
	}

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

	public MiseEnPage requeteSite(RequeteSite o) throws Exception {
		setRequeteSite(o);
		return (MiseEnPage)this;
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

	//////////////
	// ecrivain //
	//////////////

	/**	L'entité « ecrivain »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public PrintWriter ecrivain;
	public Couverture<PrintWriter> ecrivainCouverture = new Couverture<PrintWriter>().p(this).c(PrintWriter.class).var("ecrivain").o(ecrivain);

	/**	L'entité « ecrivain »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _ecrivain(Couverture<PrintWriter> o) throws Exception;

	public MiseEnPage ecrivain(PrintWriter o) throws Exception {
		setEcrivain(o);
		return (MiseEnPage)this;
	}

	public void setEcrivain(PrintWriter o) throws Exception {
		this.ecrivain = o;
	}

	public PrintWriter ecrivain() throws Exception {
		return getEcrivain();
	}

	public PrintWriter getEcrivain() throws Exception {
		return ecrivain;
	}
	protected void ecrivainInit() throws Exception {
		if(!ecrivainCouverture.dejaInitialise) {
			_ecrivain(ecrivainCouverture);
			if(ecrivain == null)
				ecrivain(ecrivainCouverture.o);
		}
		ecrivainCouverture.dejaInitialise(true);
	}

	//////////////////////
	// pageNomCanonique //
	//////////////////////

	/**	L'entité « pageNomCanonique »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public String pageNomCanonique;
	public Couverture<String> pageNomCanoniqueCouverture = new Couverture<String>().p(this).c(String.class).var("pageNomCanonique").o(pageNomCanonique);

	/**	L'entité « pageNomCanonique »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _pageNomCanonique(Couverture<String> o) throws Exception;

	public MiseEnPage pageNomCanonique(String o) throws Exception {
		setPageNomCanonique(o);
		return (MiseEnPage)this;
	}

	public void setPageNomCanonique(String o) throws Exception {
		this.pageNomCanonique = o;
	}

	public String pageNomCanonique() throws Exception {
		return getPageNomCanonique();
	}

	public String getPageNomCanonique() throws Exception {
		return pageNomCanonique;
	}
	protected void pageNomCanoniqueInit() throws Exception {
		if(!pageNomCanoniqueCouverture.dejaInitialise) {
			_pageNomCanonique(pageNomCanoniqueCouverture);
			if(pageNomCanonique == null)
				pageNomCanonique(pageNomCanoniqueCouverture.o);
		}
		pageNomCanoniqueCouverture.dejaInitialise(true);
	}

	///////////////////
	// pageNomSimple //
	///////////////////

	/**	L'entité « pageNomSimple »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public String pageNomSimple;
	public Couverture<String> pageNomSimpleCouverture = new Couverture<String>().p(this).c(String.class).var("pageNomSimple").o(pageNomSimple);

	/**	L'entité « pageNomSimple »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _pageNomSimple(Couverture<String> o) throws Exception;

	public MiseEnPage pageNomSimple(String o) throws Exception {
		setPageNomSimple(o);
		return (MiseEnPage)this;
	}

	public void setPageNomSimple(String o) throws Exception {
		this.pageNomSimple = o;
	}

	public String pageNomSimple() throws Exception {
		return getPageNomSimple();
	}

	public String getPageNomSimple() throws Exception {
		return pageNomSimple;
	}
	protected void pageNomSimpleInit() throws Exception {
		if(!pageNomSimpleCouverture.dejaInitialise) {
			_pageNomSimple(pageNomSimpleCouverture);
			if(pageNomSimple == null)
				pageNomSimple(pageNomSimpleCouverture.o);
		}
		pageNomSimpleCouverture.dejaInitialise(true);
	}

	////////////////////////
	// pageVisibleAuxBots //
	////////////////////////

	/**	L'entité « pageVisibleAuxBots »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public Boolean pageVisibleAuxBots;
	public Couverture<Boolean> pageVisibleAuxBotsCouverture = new Couverture<Boolean>().p(this).c(Boolean.class).var("pageVisibleAuxBots").o(pageVisibleAuxBots);

	/**	L'entité « pageVisibleAuxBots »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _pageVisibleAuxBots(Couverture<Boolean> o) throws Exception;

	public MiseEnPage pageVisibleAuxBots(Boolean o) throws Exception {
		setPageVisibleAuxBots(o);
		return (MiseEnPage)this;
	}

	public void setPageVisibleAuxBots(Boolean o) throws Exception {
		this.pageVisibleAuxBots = o;
	}

	public Boolean pageVisibleAuxBots() throws Exception {
		return getPageVisibleAuxBots();
	}

	public Boolean getPageVisibleAuxBots() throws Exception {
		return pageVisibleAuxBots;
	}
	public MiseEnPage pageVisibleAuxBots(String o) throws Exception {
		if(org.apache.commons.lang3.BooleanUtils.isTrue(org.apache.commons.lang3.BooleanUtils.toBoolean(o)))
			this.pageVisibleAuxBots = Boolean.parseBoolean(o);
		return (MiseEnPage)this;
	}
	protected void pageVisibleAuxBotsInit() throws Exception {
		if(!pageVisibleAuxBotsCouverture.dejaInitialise) {
			_pageVisibleAuxBots(pageVisibleAuxBotsCouverture);
			if(pageVisibleAuxBots == null)
				pageVisibleAuxBots(pageVisibleAuxBotsCouverture.o);
		}
		pageVisibleAuxBotsCouverture.dejaInitialise(true);
	}

	/////////////////
	// pageH1Cours //
	/////////////////

	/**	L'entité « pageH1Cours »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 */
	public Chaine pageH1Cours = new Chaine();
	public Couverture<Chaine> pageH1CoursCouverture = new Couverture<Chaine>().p(this).c(Chaine.class).var("pageH1Cours").o(pageH1Cours);

	/**	L'entité « pageH1Cours »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 *	@param pageH1Cours est le champ déjà construit. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _pageH1Cours(Chaine o) throws Exception;

	public MiseEnPage pageH1Cours(Chaine o) throws Exception {
		setPageH1Cours(o);
		return (MiseEnPage)this;
	}

	public void setPageH1Cours(Chaine o) throws Exception {
		this.pageH1Cours = o;
	}

	public Chaine pageH1Cours() throws Exception {
		return getPageH1Cours();
	}

	public Chaine getPageH1Cours() throws Exception {
		return pageH1Cours;
	}
	protected void pageH1CoursInit() throws Exception {
		if(!pageH1CoursCouverture.dejaInitialise) {
			_pageH1Cours(pageH1Cours);
		}
		pageH1CoursCouverture.dejaInitialise(true);
	}

	/////////////////
	// pageH2Cours //
	/////////////////

	/**	L'entité « pageH2Cours »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 */
	public Chaine pageH2Cours = new Chaine();
	public Couverture<Chaine> pageH2CoursCouverture = new Couverture<Chaine>().p(this).c(Chaine.class).var("pageH2Cours").o(pageH2Cours);

	/**	L'entité « pageH2Cours »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 *	@param pageH2Cours est le champ déjà construit. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _pageH2Cours(Chaine o) throws Exception;

	public MiseEnPage pageH2Cours(Chaine o) throws Exception {
		setPageH2Cours(o);
		return (MiseEnPage)this;
	}

	public void setPageH2Cours(Chaine o) throws Exception {
		this.pageH2Cours = o;
	}

	public Chaine pageH2Cours() throws Exception {
		return getPageH2Cours();
	}

	public Chaine getPageH2Cours() throws Exception {
		return pageH2Cours;
	}
	protected void pageH2CoursInit() throws Exception {
		if(!pageH2CoursCouverture.dejaInitialise) {
			_pageH2Cours(pageH2Cours);
		}
		pageH2CoursCouverture.dejaInitialise(true);
	}

	////////////
	// pageH1 //
	////////////

	/**	L'entité « pageH1 »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 */
	public Chaine pageH1 = new Chaine();
	public Couverture<Chaine> pageH1Couverture = new Couverture<Chaine>().p(this).c(Chaine.class).var("pageH1").o(pageH1);

	/**	L'entité « pageH1 »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 *	@param pageH1 est le champ déjà construit. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _pageH1(Chaine o) throws Exception;

	public MiseEnPage pageH1(Chaine o) throws Exception {
		setPageH1(o);
		return (MiseEnPage)this;
	}

	public void setPageH1(Chaine o) throws Exception {
		this.pageH1 = o;
	}

	public Chaine pageH1() throws Exception {
		return getPageH1();
	}

	public Chaine getPageH1() throws Exception {
		return pageH1;
	}
	protected void pageH1Init() throws Exception {
		if(!pageH1Couverture.dejaInitialise) {
			_pageH1(pageH1);
		}
		pageH1Couverture.dejaInitialise(true);
	}

	/////////////////
	// pageH1Court //
	/////////////////

	/**	L'entité « pageH1Court »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 */
	public Chaine pageH1Court = new Chaine();
	public Couverture<Chaine> pageH1CourtCouverture = new Couverture<Chaine>().p(this).c(Chaine.class).var("pageH1Court").o(pageH1Court);

	/**	L'entité « pageH1Court »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 *	@param pageH1Court est le champ déjà construit. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _pageH1Court(Chaine o) throws Exception;

	public MiseEnPage pageH1Court(Chaine o) throws Exception {
		setPageH1Court(o);
		return (MiseEnPage)this;
	}

	public void setPageH1Court(Chaine o) throws Exception {
		this.pageH1Court = o;
	}

	public Chaine pageH1Court() throws Exception {
		return getPageH1Court();
	}

	public Chaine getPageH1Court() throws Exception {
		return pageH1Court;
	}
	protected void pageH1CourtInit() throws Exception {
		if(!pageH1CourtCouverture.dejaInitialise) {
			_pageH1Court(pageH1Court);
		}
		pageH1CourtCouverture.dejaInitialise(true);
	}

	////////////
	// pageH2 //
	////////////

	/**	L'entité « pageH2 »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 */
	public Chaine pageH2 = new Chaine();
	public Couverture<Chaine> pageH2Couverture = new Couverture<Chaine>().p(this).c(Chaine.class).var("pageH2").o(pageH2);

	/**	L'entité « pageH2 »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 *	@param pageH2 est le champ déjà construit. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _pageH2(Chaine o) throws Exception;

	public MiseEnPage pageH2(Chaine o) throws Exception {
		setPageH2(o);
		return (MiseEnPage)this;
	}

	public void setPageH2(Chaine o) throws Exception {
		this.pageH2 = o;
	}

	public Chaine pageH2() throws Exception {
		return getPageH2();
	}

	public Chaine getPageH2() throws Exception {
		return pageH2;
	}
	protected void pageH2Init() throws Exception {
		if(!pageH2Couverture.dejaInitialise) {
			_pageH2(pageH2);
		}
		pageH2Couverture.dejaInitialise(true);
	}

	/////////////////
	// pageH2Court //
	/////////////////

	/**	L'entité « pageH2Court »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 */
	public Chaine pageH2Court = new Chaine();
	public Couverture<Chaine> pageH2CourtCouverture = new Couverture<Chaine>().p(this).c(Chaine.class).var("pageH2Court").o(pageH2Court);

	/**	L'entité « pageH2Court »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 *	@param pageH2Court est le champ déjà construit. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _pageH2Court(Chaine o) throws Exception;

	public MiseEnPage pageH2Court(Chaine o) throws Exception {
		setPageH2Court(o);
		return (MiseEnPage)this;
	}

	public void setPageH2Court(Chaine o) throws Exception {
		this.pageH2Court = o;
	}

	public Chaine pageH2Court() throws Exception {
		return getPageH2Court();
	}

	public Chaine getPageH2Court() throws Exception {
		return pageH2Court;
	}
	protected void pageH2CourtInit() throws Exception {
		if(!pageH2CourtCouverture.dejaInitialise) {
			_pageH2Court(pageH2Court);
		}
		pageH2CourtCouverture.dejaInitialise(true);
	}

	///////////////
	// pageTitre //
	///////////////

	/**	L'entité « pageTitre »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 */
	public Chaine pageTitre = new Chaine();
	public Couverture<Chaine> pageTitreCouverture = new Couverture<Chaine>().p(this).c(Chaine.class).var("pageTitre").o(pageTitre);

	/**	L'entité « pageTitre »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 *	@param pageTitre est le champ déjà construit. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _pageTitre(Chaine o) throws Exception;

	public MiseEnPage pageTitre(Chaine o) throws Exception {
		setPageTitre(o);
		return (MiseEnPage)this;
	}

	public void setPageTitre(Chaine o) throws Exception {
		this.pageTitre = o;
	}

	public Chaine pageTitre() throws Exception {
		return getPageTitre();
	}

	public Chaine getPageTitre() throws Exception {
		return pageTitre;
	}
	protected void pageTitreInit() throws Exception {
		if(!pageTitreCouverture.dejaInitialise) {
			_pageTitre(pageTitre);
		}
		pageTitreCouverture.dejaInitialise(true);
	}

	/////////////////////////
	// coursIdentifiantUri //
	/////////////////////////

	/**	L'entité « coursIdentifiantUri »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 */
	public Chaine coursIdentifiantUri = new Chaine();
	public Couverture<Chaine> coursIdentifiantUriCouverture = new Couverture<Chaine>().p(this).c(Chaine.class).var("coursIdentifiantUri").o(coursIdentifiantUri);

	/**	L'entité « coursIdentifiantUri »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 *	@param coursIdentifiantUri est le champ déjà construit. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _coursIdentifiantUri(Chaine o) throws Exception;

	public MiseEnPage coursIdentifiantUri(Chaine o) throws Exception {
		setCoursIdentifiantUri(o);
		return (MiseEnPage)this;
	}

	public void setCoursIdentifiantUri(Chaine o) throws Exception {
		this.coursIdentifiantUri = o;
	}

	public Chaine coursIdentifiantUri() throws Exception {
		return getCoursIdentifiantUri();
	}

	public Chaine getCoursIdentifiantUri() throws Exception {
		return coursIdentifiantUri;
	}
	protected void coursIdentifiantUriInit() throws Exception {
		if(!coursIdentifiantUriCouverture.dejaInitialise) {
			_coursIdentifiantUri(coursIdentifiantUri);
		}
		coursIdentifiantUriCouverture.dejaInitialise(true);
	}

	/////////////////////////
	// leconIdentifiantUri //
	/////////////////////////

	/**	L'entité « leconIdentifiantUri »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 */
	public Chaine leconIdentifiantUri = new Chaine();
	public Couverture<Chaine> leconIdentifiantUriCouverture = new Couverture<Chaine>().p(this).c(Chaine.class).var("leconIdentifiantUri").o(leconIdentifiantUri);

	/**	L'entité « leconIdentifiantUri »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 *	@param leconIdentifiantUri est le champ déjà construit. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _leconIdentifiantUri(Chaine o) throws Exception;

	public MiseEnPage leconIdentifiantUri(Chaine o) throws Exception {
		setLeconIdentifiantUri(o);
		return (MiseEnPage)this;
	}

	public void setLeconIdentifiantUri(Chaine o) throws Exception {
		this.leconIdentifiantUri = o;
	}

	public Chaine leconIdentifiantUri() throws Exception {
		return getLeconIdentifiantUri();
	}

	public Chaine getLeconIdentifiantUri() throws Exception {
		return leconIdentifiantUri;
	}
	protected void leconIdentifiantUriInit() throws Exception {
		if(!leconIdentifiantUriCouverture.dejaInitialise) {
			_leconIdentifiantUri(leconIdentifiantUri);
		}
		leconIdentifiantUriCouverture.dejaInitialise(true);
	}

	/////////
	// cle //
	/////////

	/**	L'entité « cle »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public String cle;
	public Couverture<String> cleCouverture = new Couverture<String>().p(this).c(String.class).var("cle").o(cle);

	/**	L'entité « cle »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _cle(Couverture<String> o) throws Exception;

	public MiseEnPage cle(String o) throws Exception {
		setCle(o);
		return (MiseEnPage)this;
	}

	public void setCle(String o) throws Exception {
		this.cle = o;
	}

	public String cle() throws Exception {
		return getCle();
	}

	public String getCle() throws Exception {
		return cle;
	}
	protected void cleInit() throws Exception {
		if(!cleCouverture.dejaInitialise) {
			_cle(cleCouverture);
			if(cle == null)
				cle(cleCouverture.o);
		}
		cleCouverture.dejaInitialise(true);
	}

	//////////////
	// pageUris //
	//////////////

	/**	L'entité « pageUris »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut ArrayList<String>(). 
	 */
	public ArrayList<String> pageUris = new ArrayList<String>();
	public Couverture<ArrayList<String>> pageUrisCouverture = new Couverture<ArrayList<String>>().p(this).c(ArrayList.class).var("pageUris").o(pageUris);

	/**	L'entité « pageUris »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut ArrayList<String>(). 
	 *	@param pageUris est le champ déjà construit. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _pageUris(ArrayList<String> l) throws Exception;

	public MiseEnPage pageUris(ArrayList<String> l) throws Exception {
		setPageUris(l);
		return (MiseEnPage)this;
	}

	public void setPageUris(ArrayList<String> l) throws Exception {
		this.pageUris = l;
	}

	public ArrayList<String> pageUris() throws Exception {
		return getPageUris();
	}

	public ArrayList<String> getPageUris() throws Exception {
		return pageUris;
	}
	public MiseEnPage pageUrisAjouter(String...objets) throws Exception {
		for(String o : objets) {
			pageUrisAjouter(o);
		}
		return (MiseEnPage)this;
	}
	public MiseEnPage pageUrisAjouter(String o) throws Exception {
		if(o != null && !pageUris.contains(o))
			this.pageUris.add(o);
		return (MiseEnPage)this;
	}
	protected void pageUrisInit() throws Exception {
		if(!pageUrisCouverture.dejaInitialise) {
			_pageUris(pageUris);
		}
		pageUrisCouverture.dejaInitialise(true);
	}

	/////////////
	// pageUri //
	/////////////

	/**	L'entité « pageUri »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 */
	public Chaine pageUri = new Chaine();
	public Couverture<Chaine> pageUriCouverture = new Couverture<Chaine>().p(this).c(Chaine.class).var("pageUri").o(pageUri);

	/**	L'entité « pageUri »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 *	@param pageUri est le champ déjà construit. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _pageUri(Chaine o) throws Exception;

	public MiseEnPage pageUri(Chaine o) throws Exception {
		setPageUri(o);
		return (MiseEnPage)this;
	}

	public void setPageUri(Chaine o) throws Exception {
		this.pageUri = o;
	}

	public Chaine pageUri() throws Exception {
		return getPageUri();
	}

	public Chaine getPageUri() throws Exception {
		return pageUri;
	}
	protected void pageUriInit() throws Exception {
		if(!pageUriCouverture.dejaInitialise) {
			_pageUri(pageUri);
		}
		pageUriCouverture.dejaInitialise(true);
	}

	/////////////
	// pageUrl //
	/////////////

	/**	L'entité « pageUrl »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 */
	public Chaine pageUrl = new Chaine();
	public Couverture<Chaine> pageUrlCouverture = new Couverture<Chaine>().p(this).c(Chaine.class).var("pageUrl").o(pageUrl);

	/**	L'entité « pageUrl »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 *	@param pageUrl est le champ déjà construit. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _pageUrl(Chaine o) throws Exception;

	public MiseEnPage pageUrl(Chaine o) throws Exception {
		setPageUrl(o);
		return (MiseEnPage)this;
	}

	public void setPageUrl(Chaine o) throws Exception {
		this.pageUrl = o;
	}

	public Chaine pageUrl() throws Exception {
		return getPageUrl();
	}

	public Chaine getPageUrl() throws Exception {
		return pageUrl;
	}
	protected void pageUrlInit() throws Exception {
		if(!pageUrlCouverture.dejaInitialise) {
			_pageUrl(pageUrl);
		}
		pageUrlCouverture.dejaInitialise(true);
	}

	//////////////////
	// pageImageUri //
	//////////////////

	/**	L'entité « pageImageUri »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 */
	public Chaine pageImageUri = new Chaine();
	public Couverture<Chaine> pageImageUriCouverture = new Couverture<Chaine>().p(this).c(Chaine.class).var("pageImageUri").o(pageImageUri);

	/**	L'entité « pageImageUri »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 *	@param pageImageUri est le champ déjà construit. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _pageImageUri(Chaine o) throws Exception;

	public MiseEnPage pageImageUri(Chaine o) throws Exception {
		setPageImageUri(o);
		return (MiseEnPage)this;
	}

	public void setPageImageUri(Chaine o) throws Exception {
		this.pageImageUri = o;
	}

	public Chaine pageImageUri() throws Exception {
		return getPageImageUri();
	}

	public Chaine getPageImageUri() throws Exception {
		return pageImageUri;
	}
	protected void pageImageUriInit() throws Exception {
		if(!pageImageUriCouverture.dejaInitialise) {
			_pageImageUri(pageImageUri);
		}
		pageImageUriCouverture.dejaInitialise(true);
	}

	//////////////////
	// pageImageUrl //
	//////////////////

	/**	L'entité « pageImageUrl »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 */
	public Chaine pageImageUrl = new Chaine();
	public Couverture<Chaine> pageImageUrlCouverture = new Couverture<Chaine>().p(this).c(Chaine.class).var("pageImageUrl").o(pageImageUrl);

	/**	L'entité « pageImageUrl »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 *	@param pageImageUrl est le champ déjà construit. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _pageImageUrl(Chaine o) throws Exception;

	public MiseEnPage pageImageUrl(Chaine o) throws Exception {
		setPageImageUrl(o);
		return (MiseEnPage)this;
	}

	public void setPageImageUrl(Chaine o) throws Exception {
		this.pageImageUrl = o;
	}

	public Chaine pageImageUrl() throws Exception {
		return getPageImageUrl();
	}

	public Chaine getPageImageUrl() throws Exception {
		return pageImageUrl;
	}
	protected void pageImageUrlInit() throws Exception {
		if(!pageImageUrlCouverture.dejaInitialise) {
			_pageImageUrl(pageImageUrl);
		}
		pageImageUrlCouverture.dejaInitialise(true);
	}

	/////////////////
	// pageVideoId //
	/////////////////

	/**	L'entité « pageVideoId »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 */
	public Chaine pageVideoId = new Chaine();
	public Couverture<Chaine> pageVideoIdCouverture = new Couverture<Chaine>().p(this).c(Chaine.class).var("pageVideoId").o(pageVideoId);

	/**	L'entité « pageVideoId »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 *	@param pageVideoId est le champ déjà construit. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _pageVideoId(Chaine o) throws Exception;

	public MiseEnPage pageVideoId(Chaine o) throws Exception {
		setPageVideoId(o);
		return (MiseEnPage)this;
	}

	public void setPageVideoId(Chaine o) throws Exception {
		this.pageVideoId = o;
	}

	public Chaine pageVideoId() throws Exception {
		return getPageVideoId();
	}

	public Chaine getPageVideoId() throws Exception {
		return pageVideoId;
	}
	protected void pageVideoIdInit() throws Exception {
		if(!pageVideoIdCouverture.dejaInitialise) {
			_pageVideoId(pageVideoId);
		}
		pageVideoIdCouverture.dejaInitialise(true);
	}

	//////////////////
	// pageVideoUrl //
	//////////////////

	/**	L'entité « pageVideoUrl »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 */
	public Chaine pageVideoUrl = new Chaine();
	public Couverture<Chaine> pageVideoUrlCouverture = new Couverture<Chaine>().p(this).c(Chaine.class).var("pageVideoUrl").o(pageVideoUrl);

	/**	L'entité « pageVideoUrl »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 *	@param pageVideoUrl est le champ déjà construit. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _pageVideoUrl(Chaine o) throws Exception;

	public MiseEnPage pageVideoUrl(Chaine o) throws Exception {
		setPageVideoUrl(o);
		return (MiseEnPage)this;
	}

	public void setPageVideoUrl(Chaine o) throws Exception {
		this.pageVideoUrl = o;
	}

	public Chaine pageVideoUrl() throws Exception {
		return getPageVideoUrl();
	}

	public Chaine getPageVideoUrl() throws Exception {
		return pageVideoUrl;
	}
	protected void pageVideoUrlInit() throws Exception {
		if(!pageVideoUrlCouverture.dejaInitialise) {
			_pageVideoUrl(pageVideoUrl);
		}
		pageVideoUrlCouverture.dejaInitialise(true);
	}

	///////////////////////
	// pageVideoUrlEmbed //
	///////////////////////

	/**	L'entité « pageVideoUrlEmbed »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 */
	public Chaine pageVideoUrlEmbed = new Chaine();
	public Couverture<Chaine> pageVideoUrlEmbedCouverture = new Couverture<Chaine>().p(this).c(Chaine.class).var("pageVideoUrlEmbed").o(pageVideoUrlEmbed);

	/**	L'entité « pageVideoUrlEmbed »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 *	@param pageVideoUrlEmbed est le champ déjà construit. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _pageVideoUrlEmbed(Chaine o) throws Exception;

	public MiseEnPage pageVideoUrlEmbed(Chaine o) throws Exception {
		setPageVideoUrlEmbed(o);
		return (MiseEnPage)this;
	}

	public void setPageVideoUrlEmbed(Chaine o) throws Exception {
		this.pageVideoUrlEmbed = o;
	}

	public Chaine pageVideoUrlEmbed() throws Exception {
		return getPageVideoUrlEmbed();
	}

	public Chaine getPageVideoUrlEmbed() throws Exception {
		return pageVideoUrlEmbed;
	}
	protected void pageVideoUrlEmbedInit() throws Exception {
		if(!pageVideoUrlEmbedCouverture.dejaInitialise) {
			_pageVideoUrlEmbed(pageVideoUrlEmbed);
		}
		pageVideoUrlEmbedCouverture.dejaInitialise(true);
	}

	//////////////////////
	// pageImageLargeur //
	//////////////////////

	/**	L'entité « pageImageLargeur »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public Integer pageImageLargeur;
	public Couverture<Integer> pageImageLargeurCouverture = new Couverture<Integer>().p(this).c(Integer.class).var("pageImageLargeur").o(pageImageLargeur);

	/**	L'entité « pageImageLargeur »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _pageImageLargeur(Couverture<Integer> o) throws Exception;

	public MiseEnPage pageImageLargeur(Integer o) throws Exception {
		setPageImageLargeur(o);
		return (MiseEnPage)this;
	}

	public void setPageImageLargeur(Integer o) throws Exception {
		this.pageImageLargeur = o;
	}

	public Integer pageImageLargeur() throws Exception {
		return getPageImageLargeur();
	}

	public Integer getPageImageLargeur() throws Exception {
		return pageImageLargeur;
	}
	public MiseEnPage pageImageLargeur(String o) throws Exception {
		if(org.apache.commons.lang3.math.NumberUtils.isNumber(o))
			this.pageImageLargeur = Integer.parseInt(o);
		return (MiseEnPage)this;
	}
	protected void pageImageLargeurInit() throws Exception {
		if(!pageImageLargeurCouverture.dejaInitialise) {
			_pageImageLargeur(pageImageLargeurCouverture);
			if(pageImageLargeur == null)
				pageImageLargeur(pageImageLargeurCouverture.o);
		}
		pageImageLargeurCouverture.dejaInitialise(true);
	}

	//////////////////////
	// pageImageHauteur //
	//////////////////////

	/**	L'entité « pageImageHauteur »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public Integer pageImageHauteur;
	public Couverture<Integer> pageImageHauteurCouverture = new Couverture<Integer>().p(this).c(Integer.class).var("pageImageHauteur").o(pageImageHauteur);

	/**	L'entité « pageImageHauteur »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _pageImageHauteur(Couverture<Integer> o) throws Exception;

	public MiseEnPage pageImageHauteur(Integer o) throws Exception {
		setPageImageHauteur(o);
		return (MiseEnPage)this;
	}

	public void setPageImageHauteur(Integer o) throws Exception {
		this.pageImageHauteur = o;
	}

	public Integer pageImageHauteur() throws Exception {
		return getPageImageHauteur();
	}

	public Integer getPageImageHauteur() throws Exception {
		return pageImageHauteur;
	}
	public MiseEnPage pageImageHauteur(String o) throws Exception {
		if(org.apache.commons.lang3.math.NumberUtils.isNumber(o))
			this.pageImageHauteur = Integer.parseInt(o);
		return (MiseEnPage)this;
	}
	protected void pageImageHauteurInit() throws Exception {
		if(!pageImageHauteurCouverture.dejaInitialise) {
			_pageImageHauteur(pageImageHauteurCouverture);
			if(pageImageHauteur == null)
				pageImageHauteur(pageImageHauteurCouverture.o);
		}
		pageImageHauteurCouverture.dejaInitialise(true);
	}

	//////////////////////////
	// pageImageTypeContenu //
	//////////////////////////

	/**	L'entité « pageImageTypeContenu »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public String pageImageTypeContenu;
	public Couverture<String> pageImageTypeContenuCouverture = new Couverture<String>().p(this).c(String.class).var("pageImageTypeContenu").o(pageImageTypeContenu);

	/**	L'entité « pageImageTypeContenu »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _pageImageTypeContenu(Couverture<String> o) throws Exception;

	public MiseEnPage pageImageTypeContenu(String o) throws Exception {
		setPageImageTypeContenu(o);
		return (MiseEnPage)this;
	}

	public void setPageImageTypeContenu(String o) throws Exception {
		this.pageImageTypeContenu = o;
	}

	public String pageImageTypeContenu() throws Exception {
		return getPageImageTypeContenu();
	}

	public String getPageImageTypeContenu() throws Exception {
		return pageImageTypeContenu;
	}
	protected void pageImageTypeContenuInit() throws Exception {
		if(!pageImageTypeContenuCouverture.dejaInitialise) {
			_pageImageTypeContenu(pageImageTypeContenuCouverture);
			if(pageImageTypeContenu == null)
				pageImageTypeContenu(pageImageTypeContenuCouverture.o);
		}
		pageImageTypeContenuCouverture.dejaInitialise(true);
	}

	///////////////
	// pageAdmin //
	///////////////

	/**	L'entité « pageAdmin »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public Boolean pageAdmin;
	public Couverture<Boolean> pageAdminCouverture = new Couverture<Boolean>().p(this).c(Boolean.class).var("pageAdmin").o(pageAdmin);

	/**	L'entité « pageAdmin »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _pageAdmin(Couverture<Boolean> o) throws Exception;

	public MiseEnPage pageAdmin(Boolean o) throws Exception {
		setPageAdmin(o);
		return (MiseEnPage)this;
	}

	public void setPageAdmin(Boolean o) throws Exception {
		this.pageAdmin = o;
	}

	public Boolean pageAdmin() throws Exception {
		return getPageAdmin();
	}

	public Boolean getPageAdmin() throws Exception {
		return pageAdmin;
	}
	public MiseEnPage pageAdmin(String o) throws Exception {
		if(org.apache.commons.lang3.BooleanUtils.isTrue(org.apache.commons.lang3.BooleanUtils.toBoolean(o)))
			this.pageAdmin = Boolean.parseBoolean(o);
		return (MiseEnPage)this;
	}
	protected void pageAdminInit() throws Exception {
		if(!pageAdminCouverture.dejaInitialise) {
			_pageAdmin(pageAdminCouverture);
			if(pageAdmin == null)
				pageAdmin(pageAdminCouverture.o);
		}
		pageAdminCouverture.dejaInitialise(true);
	}

	/////////////////
	// pageMethode //
	/////////////////

	/**	L'entité « pageMethode »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public String pageMethode;
	public Couverture<String> pageMethodeCouverture = new Couverture<String>().p(this).c(String.class).var("pageMethode").o(pageMethode);

	/**	L'entité « pageMethode »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _pageMethode(Couverture<String> o) throws Exception;

	public MiseEnPage pageMethode(String o) throws Exception {
		setPageMethode(o);
		return (MiseEnPage)this;
	}

	public void setPageMethode(String o) throws Exception {
		this.pageMethode = o;
	}

	public String pageMethode() throws Exception {
		return getPageMethode();
	}

	public String getPageMethode() throws Exception {
		return pageMethode;
	}
	protected void pageMethodeInit() throws Exception {
		if(!pageMethodeCouverture.dejaInitialise) {
			_pageMethode(pageMethodeCouverture);
			if(pageMethode == null)
				pageMethode(pageMethodeCouverture.o);
		}
		pageMethodeCouverture.dejaInitialise(true);
	}

	/////////////////////
	// pageTypeContenu //
	/////////////////////

	/**	L'entité « pageTypeContenu »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public String pageTypeContenu;
	public Couverture<String> pageTypeContenuCouverture = new Couverture<String>().p(this).c(String.class).var("pageTypeContenu").o(pageTypeContenu);

	/**	L'entité « pageTypeContenu »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _pageTypeContenu(Couverture<String> o) throws Exception;

	public MiseEnPage pageTypeContenu(String o) throws Exception {
		setPageTypeContenu(o);
		return (MiseEnPage)this;
	}

	public void setPageTypeContenu(String o) throws Exception {
		this.pageTypeContenu = o;
	}

	public String pageTypeContenu() throws Exception {
		return getPageTypeContenu();
	}

	public String getPageTypeContenu() throws Exception {
		return pageTypeContenu;
	}
	protected void pageTypeContenuInit() throws Exception {
		if(!pageTypeContenuCouverture.dejaInitialise) {
			_pageTypeContenu(pageTypeContenuCouverture);
			if(pageTypeContenu == null)
				pageTypeContenu(pageTypeContenuCouverture.o);
		}
		pageTypeContenuCouverture.dejaInitialise(true);
	}

	////////
	// id //
	////////

	/**	L'entité « id »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public String id;
	public Couverture<String> idCouverture = new Couverture<String>().p(this).c(String.class).var("id").o(id);

	/**	L'entité « id »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _id(Couverture<String> o) throws Exception;

	public MiseEnPage id(String o) throws Exception {
		setId(o);
		return (MiseEnPage)this;
	}

	public void setId(String o) throws Exception {
		this.id = o;
	}

	public String id() throws Exception {
		return getId();
	}

	public String getId() throws Exception {
		return id;
	}
	protected void idInit() throws Exception {
		if(!idCouverture.dejaInitialise) {
			_id(idCouverture);
			if(id == null)
				id(idCouverture.o);
		}
		idCouverture.dejaInitialise(true);
	}

	///////////////////
	// pageCreeCours //
	///////////////////

	/**	L'entité « pageCreeCours »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public LocalDateTime pageCreeCours;
	public Couverture<LocalDateTime> pageCreeCoursCouverture = new Couverture<LocalDateTime>().p(this).c(LocalDateTime.class).var("pageCreeCours").o(pageCreeCours);

	/**	L'entité « pageCreeCours »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _pageCreeCours(Couverture<LocalDateTime> o) throws Exception;

	public MiseEnPage pageCreeCours(LocalDateTime o) throws Exception {
		setPageCreeCours(o);
		return (MiseEnPage)this;
	}

	public void setPageCreeCours(LocalDateTime o) throws Exception {
		this.pageCreeCours = o;
	}

	public LocalDateTime pageCreeCours() throws Exception {
		return getPageCreeCours();
	}

	public LocalDateTime getPageCreeCours() throws Exception {
		return pageCreeCours;
	}
	public MiseEnPage pageCreeCours(String o) throws Exception {
		this.pageCreeCours = java.time.LocalDateTime.parse(o, java.time.format.DateTimeFormatter.ISO_OFFSET_DATE_TIME);
		return (MiseEnPage)this;
	}
	public MiseEnPage pageCreeCours(java.util.Date o) throws Exception {
		this.pageCreeCours = java.time.LocalDateTime.ofInstant(o.toInstant(), java.time.ZoneId.systemDefault());
		return (MiseEnPage)this;
	}
	protected void pageCreeCoursInit() throws Exception {
		if(!pageCreeCoursCouverture.dejaInitialise) {
			_pageCreeCours(pageCreeCoursCouverture);
			if(pageCreeCours == null)
				pageCreeCours(pageCreeCoursCouverture.o);
		}
		pageCreeCoursCouverture.dejaInitialise(true);
	}

	//////////////
	// pageCree //
	//////////////

	/**	L'entité « pageCree »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public LocalDateTime pageCree;
	public Couverture<LocalDateTime> pageCreeCouverture = new Couverture<LocalDateTime>().p(this).c(LocalDateTime.class).var("pageCree").o(pageCree);

	/**	L'entité « pageCree »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _pageCree(Couverture<LocalDateTime> o) throws Exception;

	public MiseEnPage pageCree(LocalDateTime o) throws Exception {
		setPageCree(o);
		return (MiseEnPage)this;
	}

	public void setPageCree(LocalDateTime o) throws Exception {
		this.pageCree = o;
	}

	public LocalDateTime pageCree() throws Exception {
		return getPageCree();
	}

	public LocalDateTime getPageCree() throws Exception {
		return pageCree;
	}
	public MiseEnPage pageCree(String o) throws Exception {
		this.pageCree = java.time.LocalDateTime.parse(o, java.time.format.DateTimeFormatter.ISO_OFFSET_DATE_TIME);
		return (MiseEnPage)this;
	}
	public MiseEnPage pageCree(java.util.Date o) throws Exception {
		this.pageCree = java.time.LocalDateTime.ofInstant(o.toInstant(), java.time.ZoneId.systemDefault());
		return (MiseEnPage)this;
	}
	protected void pageCreeInit() throws Exception {
		if(!pageCreeCouverture.dejaInitialise) {
			_pageCree(pageCreeCouverture);
			if(pageCree == null)
				pageCree(pageCreeCouverture.o);
		}
		pageCreeCouverture.dejaInitialise(true);
	}

	//////////////////
	// pageModifiee //
	//////////////////

	/**	L'entité « pageModifiee »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public LocalDateTime pageModifiee;
	public Couverture<LocalDateTime> pageModifieeCouverture = new Couverture<LocalDateTime>().p(this).c(LocalDateTime.class).var("pageModifiee").o(pageModifiee);

	/**	L'entité « pageModifiee »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _pageModifiee(Couverture<LocalDateTime> o) throws Exception;

	public MiseEnPage pageModifiee(LocalDateTime o) throws Exception {
		setPageModifiee(o);
		return (MiseEnPage)this;
	}

	public void setPageModifiee(LocalDateTime o) throws Exception {
		this.pageModifiee = o;
	}

	public LocalDateTime pageModifiee() throws Exception {
		return getPageModifiee();
	}

	public LocalDateTime getPageModifiee() throws Exception {
		return pageModifiee;
	}
	public MiseEnPage pageModifiee(String o) throws Exception {
		this.pageModifiee = java.time.LocalDateTime.parse(o, java.time.format.DateTimeFormatter.ISO_OFFSET_DATE_TIME);
		return (MiseEnPage)this;
	}
	public MiseEnPage pageModifiee(java.util.Date o) throws Exception {
		this.pageModifiee = java.time.LocalDateTime.ofInstant(o.toInstant(), java.time.ZoneId.systemDefault());
		return (MiseEnPage)this;
	}
	protected void pageModifieeInit() throws Exception {
		if(!pageModifieeCouverture.dejaInitialise) {
			_pageModifiee(pageModifieeCouverture);
			if(pageModifiee == null)
				pageModifiee(pageModifieeCouverture.o);
		}
		pageModifieeCouverture.dejaInitialise(true);
	}

	//////////////
	// pageAime //
	//////////////

	/**	L'entité « pageAime »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public Long pageAime;
	public Couverture<Long> pageAimeCouverture = new Couverture<Long>().p(this).c(Long.class).var("pageAime").o(pageAime);

	/**	L'entité « pageAime »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _pageAime(Couverture<Long> o) throws Exception;

	public MiseEnPage pageAime(Long o) throws Exception {
		setPageAime(o);
		return (MiseEnPage)this;
	}

	public void setPageAime(Long o) throws Exception {
		this.pageAime = o;
	}

	public Long pageAime() throws Exception {
		return getPageAime();
	}

	public Long getPageAime() throws Exception {
		return pageAime;
	}
	public MiseEnPage pageAime(String o) throws Exception {
		if(org.apache.commons.lang3.math.NumberUtils.isNumber(o))
			this.pageAime = Long.parseLong(o);
		return (MiseEnPage)this;
	}
	protected void pageAimeInit() throws Exception {
		if(!pageAimeCouverture.dejaInitialise) {
			_pageAime(pageAimeCouverture);
			if(pageAime == null)
				pageAime(pageAimeCouverture.o);
		}
		pageAimeCouverture.dejaInitialise(true);
	}

	///////////////
	// pageAimee //
	///////////////

	/**	L'entité « pageAimee »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public Boolean pageAimee;
	public Couverture<Boolean> pageAimeeCouverture = new Couverture<Boolean>().p(this).c(Boolean.class).var("pageAimee").o(pageAimee);

	/**	L'entité « pageAimee »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _pageAimee(Couverture<Boolean> o) throws Exception;

	public MiseEnPage pageAimee(Boolean o) throws Exception {
		setPageAimee(o);
		return (MiseEnPage)this;
	}

	public void setPageAimee(Boolean o) throws Exception {
		this.pageAimee = o;
	}

	public Boolean pageAimee() throws Exception {
		return getPageAimee();
	}

	public Boolean getPageAimee() throws Exception {
		return pageAimee;
	}
	public MiseEnPage pageAimee(String o) throws Exception {
		if(org.apache.commons.lang3.BooleanUtils.isTrue(org.apache.commons.lang3.BooleanUtils.toBoolean(o)))
			this.pageAimee = Boolean.parseBoolean(o);
		return (MiseEnPage)this;
	}
	protected void pageAimeeInit() throws Exception {
		if(!pageAimeeCouverture.dejaInitialise) {
			_pageAimee(pageAimeeCouverture);
			if(pageAimee == null)
				pageAimee(pageAimeeCouverture.o);
		}
		pageAimeeCouverture.dejaInitialise(true);
	}

	//////////////////
	// pageMotsCles //
	//////////////////

	/**	L'entité « pageMotsCles »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 */
	public Chaine pageMotsCles = new Chaine();
	public Couverture<Chaine> pageMotsClesCouverture = new Couverture<Chaine>().p(this).c(Chaine.class).var("pageMotsCles").o(pageMotsCles);

	/**	L'entité « pageMotsCles »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 *	@param pageMotsCles est le champ déjà construit. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _pageMotsCles(Chaine o) throws Exception;

	public MiseEnPage pageMotsCles(Chaine o) throws Exception {
		setPageMotsCles(o);
		return (MiseEnPage)this;
	}

	public void setPageMotsCles(Chaine o) throws Exception {
		this.pageMotsCles = o;
	}

	public Chaine pageMotsCles() throws Exception {
		return getPageMotsCles();
	}

	public Chaine getPageMotsCles() throws Exception {
		return pageMotsCles;
	}
	protected void pageMotsClesInit() throws Exception {
		if(!pageMotsClesCouverture.dejaInitialise) {
			_pageMotsCles(pageMotsCles);
		}
		pageMotsClesCouverture.dejaInitialise(true);
	}

	/////////////////////
	// pageDescription //
	/////////////////////

	/**	L'entité « pageDescription »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 */
	public Chaine pageDescription = new Chaine();
	public Couverture<Chaine> pageDescriptionCouverture = new Couverture<Chaine>().p(this).c(Chaine.class).var("pageDescription").o(pageDescription);

	/**	L'entité « pageDescription »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 *	@param pageDescription est le champ déjà construit. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _pageDescription(Chaine o) throws Exception;

	public MiseEnPage pageDescription(Chaine o) throws Exception {
		setPageDescription(o);
		return (MiseEnPage)this;
	}

	public void setPageDescription(Chaine o) throws Exception {
		this.pageDescription = o;
	}

	public Chaine pageDescription() throws Exception {
		return getPageDescription();
	}

	public Chaine getPageDescription() throws Exception {
		return pageDescription;
	}
	protected void pageDescriptionInit() throws Exception {
		if(!pageDescriptionCouverture.dejaInitialise) {
			_pageDescription(pageDescription);
		}
		pageDescriptionCouverture.dejaInitialise(true);
	}

	////////////////////
	// pageAccueilUri //
	////////////////////

	/**	L'entité « pageAccueilUri »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 */
	public Chaine pageAccueilUri = new Chaine();
	public Couverture<Chaine> pageAccueilUriCouverture = new Couverture<Chaine>().p(this).c(Chaine.class).var("pageAccueilUri").o(pageAccueilUri);

	/**	L'entité « pageAccueilUri »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 *	@param pageAccueilUri est le champ déjà construit. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _pageAccueilUri(Chaine o) throws Exception;

	public MiseEnPage pageAccueilUri(Chaine o) throws Exception {
		setPageAccueilUri(o);
		return (MiseEnPage)this;
	}

	public void setPageAccueilUri(Chaine o) throws Exception {
		this.pageAccueilUri = o;
	}

	public Chaine pageAccueilUri() throws Exception {
		return getPageAccueilUri();
	}

	public Chaine getPageAccueilUri() throws Exception {
		return pageAccueilUri;
	}
	protected void pageAccueilUriInit() throws Exception {
		if(!pageAccueilUriCouverture.dejaInitialise) {
			_pageAccueilUri(pageAccueilUri);
		}
		pageAccueilUriCouverture.dejaInitialise(true);
	}

	/////////////////
	// pageBlogUri //
	/////////////////

	/**	L'entité « pageBlogUri »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 */
	public Chaine pageBlogUri = new Chaine();
	public Couverture<Chaine> pageBlogUriCouverture = new Couverture<Chaine>().p(this).c(Chaine.class).var("pageBlogUri").o(pageBlogUri);

	/**	L'entité « pageBlogUri »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 *	@param pageBlogUri est le champ déjà construit. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _pageBlogUri(Chaine o) throws Exception;

	public MiseEnPage pageBlogUri(Chaine o) throws Exception {
		setPageBlogUri(o);
		return (MiseEnPage)this;
	}

	public void setPageBlogUri(Chaine o) throws Exception {
		this.pageBlogUri = o;
	}

	public Chaine pageBlogUri() throws Exception {
		return getPageBlogUri();
	}

	public Chaine getPageBlogUri() throws Exception {
		return pageBlogUri;
	}
	protected void pageBlogUriInit() throws Exception {
		if(!pageBlogUriCouverture.dejaInitialise) {
			_pageBlogUri(pageBlogUri);
		}
		pageBlogUriCouverture.dejaInitialise(true);
	}

	////////////////////
	// pageAProposUri //
	////////////////////

	/**	L'entité « pageAProposUri »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 */
	public Chaine pageAProposUri = new Chaine();
	public Couverture<Chaine> pageAProposUriCouverture = new Couverture<Chaine>().p(this).c(Chaine.class).var("pageAProposUri").o(pageAProposUri);

	/**	L'entité « pageAProposUri »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 *	@param pageAProposUri est le champ déjà construit. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _pageAProposUri(Chaine o) throws Exception;

	public MiseEnPage pageAProposUri(Chaine o) throws Exception {
		setPageAProposUri(o);
		return (MiseEnPage)this;
	}

	public void setPageAProposUri(Chaine o) throws Exception {
		this.pageAProposUri = o;
	}

	public Chaine pageAProposUri() throws Exception {
		return getPageAProposUri();
	}

	public Chaine getPageAProposUri() throws Exception {
		return pageAProposUri;
	}
	protected void pageAProposUriInit() throws Exception {
		if(!pageAProposUriCouverture.dejaInitialise) {
			_pageAProposUri(pageAProposUri);
		}
		pageAProposUriCouverture.dejaInitialise(true);
	}

	////////////////
	// pageFaqUri //
	////////////////

	/**	L'entité « pageFaqUri »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 */
	public Chaine pageFaqUri = new Chaine();
	public Couverture<Chaine> pageFaqUriCouverture = new Couverture<Chaine>().p(this).c(Chaine.class).var("pageFaqUri").o(pageFaqUri);

	/**	L'entité « pageFaqUri »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 *	@param pageFaqUri est le champ déjà construit. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _pageFaqUri(Chaine o) throws Exception;

	public MiseEnPage pageFaqUri(Chaine o) throws Exception {
		setPageFaqUri(o);
		return (MiseEnPage)this;
	}

	public void setPageFaqUri(Chaine o) throws Exception {
		this.pageFaqUri = o;
	}

	public Chaine pageFaqUri() throws Exception {
		return getPageFaqUri();
	}

	public Chaine getPageFaqUri() throws Exception {
		return pageFaqUri;
	}
	protected void pageFaqUriInit() throws Exception {
		if(!pageFaqUriCouverture.dejaInitialise) {
			_pageFaqUri(pageFaqUri);
		}
		pageFaqUriCouverture.dejaInitialise(true);
	}

	////////////////////////
	// pageUtilisateurUri //
	////////////////////////

	/**	L'entité « pageUtilisateurUri »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 */
	public Chaine pageUtilisateurUri = new Chaine();
	public Couverture<Chaine> pageUtilisateurUriCouverture = new Couverture<Chaine>().p(this).c(Chaine.class).var("pageUtilisateurUri").o(pageUtilisateurUri);

	/**	L'entité « pageUtilisateurUri »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 *	@param pageUtilisateurUri est le champ déjà construit. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _pageUtilisateurUri(Chaine o) throws Exception;

	public MiseEnPage pageUtilisateurUri(Chaine o) throws Exception {
		setPageUtilisateurUri(o);
		return (MiseEnPage)this;
	}

	public void setPageUtilisateurUri(Chaine o) throws Exception {
		this.pageUtilisateurUri = o;
	}

	public Chaine pageUtilisateurUri() throws Exception {
		return getPageUtilisateurUri();
	}

	public Chaine getPageUtilisateurUri() throws Exception {
		return pageUtilisateurUri;
	}
	protected void pageUtilisateurUriInit() throws Exception {
		if(!pageUtilisateurUriCouverture.dejaInitialise) {
			_pageUtilisateurUri(pageUtilisateurUri);
		}
		pageUtilisateurUriCouverture.dejaInitialise(true);
	}

	////////////////////////
	// pageDeconnexionUri //
	////////////////////////

	/**	L'entité « pageDeconnexionUri »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 */
	public Chaine pageDeconnexionUri = new Chaine();
	public Couverture<Chaine> pageDeconnexionUriCouverture = new Couverture<Chaine>().p(this).c(Chaine.class).var("pageDeconnexionUri").o(pageDeconnexionUri);

	/**	L'entité « pageDeconnexionUri »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 *	@param pageDeconnexionUri est le champ déjà construit. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _pageDeconnexionUri(Chaine o) throws Exception;

	public MiseEnPage pageDeconnexionUri(Chaine o) throws Exception {
		setPageDeconnexionUri(o);
		return (MiseEnPage)this;
	}

	public void setPageDeconnexionUri(Chaine o) throws Exception {
		this.pageDeconnexionUri = o;
	}

	public Chaine pageDeconnexionUri() throws Exception {
		return getPageDeconnexionUri();
	}

	public Chaine getPageDeconnexionUri() throws Exception {
		return pageDeconnexionUri;
	}
	protected void pageDeconnexionUriInit() throws Exception {
		if(!pageDeconnexionUriCouverture.dejaInitialise) {
			_pageDeconnexionUri(pageDeconnexionUri);
		}
		pageDeconnexionUriCouverture.dejaInitialise(true);
	}

	//////////////////
	// pageCoursUri //
	//////////////////

	/**	L'entité « pageCoursUri »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 */
	public Chaine pageCoursUri = new Chaine();
	public Couverture<Chaine> pageCoursUriCouverture = new Couverture<Chaine>().p(this).c(Chaine.class).var("pageCoursUri").o(pageCoursUri);

	/**	L'entité « pageCoursUri »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 *	@param pageCoursUri est le champ déjà construit. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _pageCoursUri(Chaine o) throws Exception;

	public MiseEnPage pageCoursUri(Chaine o) throws Exception {
		setPageCoursUri(o);
		return (MiseEnPage)this;
	}

	public void setPageCoursUri(Chaine o) throws Exception {
		this.pageCoursUri = o;
	}

	public Chaine pageCoursUri() throws Exception {
		return getPageCoursUri();
	}

	public Chaine getPageCoursUri() throws Exception {
		return pageCoursUri;
	}
	protected void pageCoursUriInit() throws Exception {
		if(!pageCoursUriCouverture.dejaInitialise) {
			_pageCoursUri(pageCoursUri);
		}
		pageCoursUriCouverture.dejaInitialise(true);
	}

	////////////////////
	// pageYoutubeUrl //
	////////////////////

	/**	L'entité « pageYoutubeUrl »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 */
	public Chaine pageYoutubeUrl = new Chaine();
	public Couverture<Chaine> pageYoutubeUrlCouverture = new Couverture<Chaine>().p(this).c(Chaine.class).var("pageYoutubeUrl").o(pageYoutubeUrl);

	/**	L'entité « pageYoutubeUrl »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 *	@param pageYoutubeUrl est le champ déjà construit. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _pageYoutubeUrl(Chaine o) throws Exception;

	public MiseEnPage pageYoutubeUrl(Chaine o) throws Exception {
		setPageYoutubeUrl(o);
		return (MiseEnPage)this;
	}

	public void setPageYoutubeUrl(Chaine o) throws Exception {
		this.pageYoutubeUrl = o;
	}

	public Chaine pageYoutubeUrl() throws Exception {
		return getPageYoutubeUrl();
	}

	public Chaine getPageYoutubeUrl() throws Exception {
		return pageYoutubeUrl;
	}
	protected void pageYoutubeUrlInit() throws Exception {
		if(!pageYoutubeUrlCouverture.dejaInitialise) {
			_pageYoutubeUrl(pageYoutubeUrl);
		}
		pageYoutubeUrlCouverture.dejaInitialise(true);
	}

	//////////////////////
	// pagePinterestUrl //
	//////////////////////

	/**	L'entité « pagePinterestUrl »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 */
	public Chaine pagePinterestUrl = new Chaine();
	public Couverture<Chaine> pagePinterestUrlCouverture = new Couverture<Chaine>().p(this).c(Chaine.class).var("pagePinterestUrl").o(pagePinterestUrl);

	/**	L'entité « pagePinterestUrl »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 *	@param pagePinterestUrl est le champ déjà construit. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _pagePinterestUrl(Chaine o) throws Exception;

	public MiseEnPage pagePinterestUrl(Chaine o) throws Exception {
		setPagePinterestUrl(o);
		return (MiseEnPage)this;
	}

	public void setPagePinterestUrl(Chaine o) throws Exception {
		this.pagePinterestUrl = o;
	}

	public Chaine pagePinterestUrl() throws Exception {
		return getPagePinterestUrl();
	}

	public Chaine getPagePinterestUrl() throws Exception {
		return pagePinterestUrl;
	}
	protected void pagePinterestUrlInit() throws Exception {
		if(!pagePinterestUrlCouverture.dejaInitialise) {
			_pagePinterestUrl(pagePinterestUrl);
		}
		pagePinterestUrlCouverture.dejaInitialise(true);
	}

	////////////////
	// cleRequete //
	////////////////

	/**	L'entité « cleRequete »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public Long cleRequete;
	public Couverture<Long> cleRequeteCouverture = new Couverture<Long>().p(this).c(Long.class).var("cleRequete").o(cleRequete);

	/**	L'entité « cleRequete »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _cleRequete(Couverture<Long> o) throws Exception;

	public MiseEnPage cleRequete(Long o) throws Exception {
		setCleRequete(o);
		return (MiseEnPage)this;
	}

	public void setCleRequete(Long o) throws Exception {
		this.cleRequete = o;
	}

	public Long cleRequete() throws Exception {
		return getCleRequete();
	}

	public Long getCleRequete() throws Exception {
		return cleRequete;
	}
	public MiseEnPage cleRequete(String o) throws Exception {
		if(org.apache.commons.lang3.math.NumberUtils.isNumber(o))
			this.cleRequete = Long.parseLong(o);
		return (MiseEnPage)this;
	}
	protected void cleRequeteInit() throws Exception {
		if(!cleRequeteCouverture.dejaInitialise) {
			_cleRequete(cleRequeteCouverture);
			if(cleRequete == null)
				cleRequete(cleRequeteCouverture.o);
		}
		cleRequeteCouverture.dejaInitialise(true);
	}

	protected boolean dejaInitialiseMiseEnPage = false;

	public void initLoinMiseEnPage(RequeteSite requeteSite) throws Exception {
		((MiseEnPage)this).requeteSite(requeteSite);
		requeteSite(requeteSite);
		initLoinMiseEnPage();
	}

	public void initLoinMiseEnPage() throws Exception {
		if(!dejaInitialiseMiseEnPage) {
			pagePartisInit();
			requeteSiteInit();
			ecrivainInit();
			pageNomCanoniqueInit();
			pageNomSimpleInit();
			pageVisibleAuxBotsInit();
			pageH1CoursInit();
			pageH2CoursInit();
			pageH1Init();
			pageH1CourtInit();
			pageH2Init();
			pageH2CourtInit();
			pageTitreInit();
			coursIdentifiantUriInit();
			leconIdentifiantUriInit();
			cleInit();
			pageUrisInit();
			pageUriInit();
			pageUrlInit();
			pageImageUriInit();
			pageImageUrlInit();
			pageVideoIdInit();
			pageVideoUrlInit();
			pageVideoUrlEmbedInit();
			pageImageLargeurInit();
			pageImageHauteurInit();
			pageImageTypeContenuInit();
			pageAdminInit();
			pageMethodeInit();
			pageTypeContenuInit();
			idInit();
			pageCreeCoursInit();
			pageCreeInit();
			pageModifieeInit();
			pageAimeInit();
			pageAimeeInit();
			pageMotsClesInit();
			pageDescriptionInit();
			pageAccueilUriInit();
			pageBlogUriInit();
			pageAProposUriInit();
			pageFaqUriInit();
			pageUtilisateurUriInit();
			pageDeconnexionUriInit();
			pageCoursUriInit();
			pageYoutubeUrlInit();
			pagePinterestUrlInit();
			cleRequeteInit();
			dejaInitialiseMiseEnPage = true;
		}
	}

	public void initLoinPourClasse(RequeteSite requeteSite) throws Exception {
		initLoinMiseEnPage(requeteSite);
	}
}
