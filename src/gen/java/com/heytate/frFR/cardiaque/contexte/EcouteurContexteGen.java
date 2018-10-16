package com.heytate.frFR.cardiaque.contexte;

import com.heytate.frFR.cardiaque.config.ConfigSite;
import javax.naming.InitialContext;
import com.heytate.frFR.cardiaque.fil.DaemonFabriqueFil;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import javax.sql.DataSource;
import com.heytate.frFR.cardiaque.requete.RequeteSite;
import javax.mail.Session;
import java.lang.String;
import java.lang.Integer;
import java.util.concurrent.ExecutorService;
import com.heytate.frFR.cardiaque.couverture.Couverture;

public abstract class EcouteurContexteGen<DEV> extends Object {

	//////////////////
	// cheminConfig //
	//////////////////

	/**	L'entité « cheminConfig »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public String cheminConfig;
	public Couverture<String> cheminConfigCouverture = new Couverture<String>().p(this).c(String.class).var("cheminConfig").o(cheminConfig);

	/**	L'entité « cheminConfig »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _cheminConfig(Couverture<String> o) throws Exception;

	public EcouteurContexte cheminConfig(String o) throws Exception {
		setCheminConfig(o);
		return (EcouteurContexte)this;
	}

	public void setCheminConfig(String o) throws Exception {
		this.cheminConfig = o;
	}

	public String cheminConfig() throws Exception {
		return getCheminConfig();
	}

	public String getCheminConfig() throws Exception {
		return cheminConfig;
	}
	protected void cheminConfigInit() throws Exception {
		if(!cheminConfigCouverture.dejaInitialise) {
			_cheminConfig(cheminConfigCouverture);
			if(cheminConfig == null)
				cheminConfig(cheminConfigCouverture.o);
		}
		cheminConfigCouverture.dejaInitialise(true);
	}

	////////////////
	// configSite //
	////////////////

	/**	L'entité « configSite »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut ConfigSite(). 
	 */
	public ConfigSite configSite = new ConfigSite();
	public Couverture<ConfigSite> configSiteCouverture = new Couverture<ConfigSite>().p(this).c(ConfigSite.class).var("configSite").o(configSite);

	/**	L'entité « configSite »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut ConfigSite(). 
	 *	@param configSite est le champ déjà construit. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _configSite(ConfigSite o) throws Exception;

	public EcouteurContexte configSite(ConfigSite o) throws Exception {
		setConfigSite(o);
		return (EcouteurContexte)this;
	}

	public void setConfigSite(ConfigSite o) throws Exception {
		this.configSite = o;
	}

	public ConfigSite configSite() throws Exception {
		return getConfigSite();
	}

	public ConfigSite getConfigSite() throws Exception {
		return configSite;
	}
	protected void configSiteInit() throws Exception {
		if(!configSiteCouverture.dejaInitialise) {
			_configSite(configSite);
		}
		configSite.initLoinPourClasse(requeteSite);
		configSiteCouverture.dejaInitialise(true);
	}

	//////////////////////
	// contexteInitiale //
	//////////////////////

	/**	L'entité « contexteInitiale »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public InitialContext contexteInitiale;
	public Couverture<InitialContext> contexteInitialeCouverture = new Couverture<InitialContext>().p(this).c(InitialContext.class).var("contexteInitiale").o(contexteInitiale);

	/**	L'entité « contexteInitiale »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _contexteInitiale(Couverture<InitialContext> o) throws Exception;

	public EcouteurContexte contexteInitiale(InitialContext o) throws Exception {
		setContexteInitiale(o);
		return (EcouteurContexte)this;
	}

	public void setContexteInitiale(InitialContext o) throws Exception {
		this.contexteInitiale = o;
	}

	public InitialContext contexteInitiale() throws Exception {
		return getContexteInitiale();
	}

	public InitialContext getContexteInitiale() throws Exception {
		return contexteInitiale;
	}
	protected void contexteInitialeInit() throws Exception {
		if(!contexteInitialeCouverture.dejaInitialise) {
			_contexteInitiale(contexteInitialeCouverture);
			if(contexteInitiale == null)
				contexteInitiale(contexteInitialeCouverture.o);
		}
		contexteInitialeCouverture.dejaInitialise(true);
	}

	//////////////////////
	// urlSourceDonnees //
	//////////////////////

	/**	L'entité « urlSourceDonnees »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public String urlSourceDonnees;
	public Couverture<String> urlSourceDonneesCouverture = new Couverture<String>().p(this).c(String.class).var("urlSourceDonnees").o(urlSourceDonnees);

	/**	L'entité « urlSourceDonnees »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _urlSourceDonnees(Couverture<String> o) throws Exception;

	public EcouteurContexte urlSourceDonnees(String o) throws Exception {
		setUrlSourceDonnees(o);
		return (EcouteurContexte)this;
	}

	public void setUrlSourceDonnees(String o) throws Exception {
		this.urlSourceDonnees = o;
	}

	public String urlSourceDonnees() throws Exception {
		return getUrlSourceDonnees();
	}

	public String getUrlSourceDonnees() throws Exception {
		return urlSourceDonnees;
	}
	protected void urlSourceDonneesInit() throws Exception {
		if(!urlSourceDonneesCouverture.dejaInitialise) {
			_urlSourceDonnees(urlSourceDonneesCouverture);
			if(urlSourceDonnees == null)
				urlSourceDonnees(urlSourceDonneesCouverture.o);
		}
		urlSourceDonneesCouverture.dejaInitialise(true);
	}

	////////////////////////////
	// urlSourceDonneesSimple //
	////////////////////////////

	/**	L'entité « urlSourceDonneesSimple »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public String urlSourceDonneesSimple;
	public Couverture<String> urlSourceDonneesSimpleCouverture = new Couverture<String>().p(this).c(String.class).var("urlSourceDonneesSimple").o(urlSourceDonneesSimple);

	/**	L'entité « urlSourceDonneesSimple »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _urlSourceDonneesSimple(Couverture<String> o) throws Exception;

	public EcouteurContexte urlSourceDonneesSimple(String o) throws Exception {
		setUrlSourceDonneesSimple(o);
		return (EcouteurContexte)this;
	}

	public void setUrlSourceDonneesSimple(String o) throws Exception {
		this.urlSourceDonneesSimple = o;
	}

	public String urlSourceDonneesSimple() throws Exception {
		return getUrlSourceDonneesSimple();
	}

	public String getUrlSourceDonneesSimple() throws Exception {
		return urlSourceDonneesSimple;
	}
	protected void urlSourceDonneesSimpleInit() throws Exception {
		if(!urlSourceDonneesSimpleCouverture.dejaInitialise) {
			_urlSourceDonneesSimple(urlSourceDonneesSimpleCouverture);
			if(urlSourceDonneesSimple == null)
				urlSourceDonneesSimple(urlSourceDonneesSimpleCouverture.o);
		}
		urlSourceDonneesSimpleCouverture.dejaInitialise(true);
	}

	///////////////////
	// sourceDonnees //
	///////////////////

	/**	L'entité « sourceDonnees »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public DataSource sourceDonnees;
	public Couverture<DataSource> sourceDonneesCouverture = new Couverture<DataSource>().p(this).c(DataSource.class).var("sourceDonnees").o(sourceDonnees);

	/**	L'entité « sourceDonnees »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _sourceDonnees(Couverture<DataSource> o) throws Exception;

	public EcouteurContexte sourceDonnees(DataSource o) throws Exception {
		setSourceDonnees(o);
		return (EcouteurContexte)this;
	}

	public void setSourceDonnees(DataSource o) throws Exception {
		this.sourceDonnees = o;
	}

	public DataSource sourceDonnees() throws Exception {
		return getSourceDonnees();
	}

	public DataSource getSourceDonnees() throws Exception {
		return sourceDonnees;
	}
	protected void sourceDonneesInit() throws Exception {
		if(!sourceDonneesCouverture.dejaInitialise) {
			_sourceDonnees(sourceDonneesCouverture);
			if(sourceDonnees == null)
				sourceDonnees(sourceDonneesCouverture.o);
		}
		sourceDonneesCouverture.dejaInitialise(true);
	}

	///////////////////
	// urlSourceMail //
	///////////////////

	/**	L'entité « urlSourceMail »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public String urlSourceMail;
	public Couverture<String> urlSourceMailCouverture = new Couverture<String>().p(this).c(String.class).var("urlSourceMail").o(urlSourceMail);

	/**	L'entité « urlSourceMail »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _urlSourceMail(Couverture<String> o) throws Exception;

	public EcouteurContexte urlSourceMail(String o) throws Exception {
		setUrlSourceMail(o);
		return (EcouteurContexte)this;
	}

	public void setUrlSourceMail(String o) throws Exception {
		this.urlSourceMail = o;
	}

	public String urlSourceMail() throws Exception {
		return getUrlSourceMail();
	}

	public String getUrlSourceMail() throws Exception {
		return urlSourceMail;
	}
	protected void urlSourceMailInit() throws Exception {
		if(!urlSourceMailCouverture.dejaInitialise) {
			_urlSourceMail(urlSourceMailCouverture);
			if(urlSourceMail == null)
				urlSourceMail(urlSourceMailCouverture.o);
		}
		urlSourceMailCouverture.dejaInitialise(true);
	}

	/////////////////////
	// sessionCourriel //
	/////////////////////

	/**	L'entité « sessionCourriel »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public Session sessionCourriel;
	public Couverture<Session> sessionCourrielCouverture = new Couverture<Session>().p(this).c(Session.class).var("sessionCourriel").o(sessionCourriel);

	/**	L'entité « sessionCourriel »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _sessionCourriel(Couverture<Session> o) throws Exception;

	public EcouteurContexte sessionCourriel(Session o) throws Exception {
		setSessionCourriel(o);
		return (EcouteurContexte)this;
	}

	public void setSessionCourriel(Session o) throws Exception {
		this.sessionCourriel = o;
	}

	public Session sessionCourriel() throws Exception {
		return getSessionCourriel();
	}

	public Session getSessionCourriel() throws Exception {
		return sessionCourriel;
	}
	protected void sessionCourrielInit() throws Exception {
		if(!sessionCourrielCouverture.dejaInitialise) {
			_sessionCourriel(sessionCourrielCouverture);
			if(sessionCourriel == null)
				sessionCourriel(sessionCourrielCouverture.o);
		}
		sessionCourrielCouverture.dejaInitialise(true);
	}

	////////////////
	// clientSolr //
	////////////////

	/**	L'entité « clientSolr »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public HttpSolrClient clientSolr;
	public Couverture<HttpSolrClient> clientSolrCouverture = new Couverture<HttpSolrClient>().p(this).c(HttpSolrClient.class).var("clientSolr").o(clientSolr);

	/**	L'entité « clientSolr »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _clientSolr(Couverture<HttpSolrClient> o) throws Exception;

	public EcouteurContexte clientSolr(HttpSolrClient o) throws Exception {
		setClientSolr(o);
		return (EcouteurContexte)this;
	}

	public void setClientSolr(HttpSolrClient o) throws Exception {
		this.clientSolr = o;
	}

	public HttpSolrClient clientSolr() throws Exception {
		return getClientSolr();
	}

	public HttpSolrClient getClientSolr() throws Exception {
		return clientSolr;
	}
	protected void clientSolrInit() throws Exception {
		if(!clientSolrCouverture.dejaInitialise) {
			_clientSolr(clientSolrCouverture);
			if(clientSolr == null)
				clientSolr(clientSolrCouverture.o);
		}
		clientSolrCouverture.dejaInitialise(true);
	}

	/////////////////
	// selCryptage //
	/////////////////

	/**	L'entité « selCryptage »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public String selCryptage;
	public Couverture<String> selCryptageCouverture = new Couverture<String>().p(this).c(String.class).var("selCryptage").o(selCryptage);

	/**	L'entité « selCryptage »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _selCryptage(Couverture<String> o) throws Exception;

	public EcouteurContexte selCryptage(String o) throws Exception {
		setSelCryptage(o);
		return (EcouteurContexte)this;
	}

	public void setSelCryptage(String o) throws Exception {
		this.selCryptage = o;
	}

	public String selCryptage() throws Exception {
		return getSelCryptage();
	}

	public String getSelCryptage() throws Exception {
		return selCryptage;
	}
	protected void selCryptageInit() throws Exception {
		if(!selCryptageCouverture.dejaInitialise) {
			_selCryptage(selCryptageCouverture);
			if(selCryptage == null)
				selCryptage(selCryptageCouverture.o);
		}
		selCryptageCouverture.dejaInitialise(true);
	}

	////////////////////////
	// motDePasseCryptage //
	////////////////////////

	/**	L'entité « motDePasseCryptage »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public String motDePasseCryptage;
	public Couverture<String> motDePasseCryptageCouverture = new Couverture<String>().p(this).c(String.class).var("motDePasseCryptage").o(motDePasseCryptage);

	/**	L'entité « motDePasseCryptage »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _motDePasseCryptage(Couverture<String> o) throws Exception;

	public EcouteurContexte motDePasseCryptage(String o) throws Exception {
		setMotDePasseCryptage(o);
		return (EcouteurContexte)this;
	}

	public void setMotDePasseCryptage(String o) throws Exception {
		this.motDePasseCryptage = o;
	}

	public String motDePasseCryptage() throws Exception {
		return getMotDePasseCryptage();
	}

	public String getMotDePasseCryptage() throws Exception {
		return motDePasseCryptage;
	}
	protected void motDePasseCryptageInit() throws Exception {
		if(!motDePasseCryptageCouverture.dejaInitialise) {
			_motDePasseCryptage(motDePasseCryptageCouverture);
			if(motDePasseCryptage == null)
				motDePasseCryptage(motDePasseCryptageCouverture.o);
		}
		motDePasseCryptageCouverture.dejaInitialise(true);
	}

	/////////////////////////
	// jetonIdentitePaypal //
	/////////////////////////

	/**	L'entité « jetonIdentitePaypal »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public String jetonIdentitePaypal;
	public Couverture<String> jetonIdentitePaypalCouverture = new Couverture<String>().p(this).c(String.class).var("jetonIdentitePaypal").o(jetonIdentitePaypal);

	/**	L'entité « jetonIdentitePaypal »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _jetonIdentitePaypal(Couverture<String> o) throws Exception;

	public EcouteurContexte jetonIdentitePaypal(String o) throws Exception {
		setJetonIdentitePaypal(o);
		return (EcouteurContexte)this;
	}

	public void setJetonIdentitePaypal(String o) throws Exception {
		this.jetonIdentitePaypal = o;
	}

	public String jetonIdentitePaypal() throws Exception {
		return getJetonIdentitePaypal();
	}

	public String getJetonIdentitePaypal() throws Exception {
		return jetonIdentitePaypal;
	}
	protected void jetonIdentitePaypalInit() throws Exception {
		if(!jetonIdentitePaypalCouverture.dejaInitialise) {
			_jetonIdentitePaypal(jetonIdentitePaypalCouverture);
			if(jetonIdentitePaypal == null)
				jetonIdentitePaypal(jetonIdentitePaypalCouverture.o);
		}
		jetonIdentitePaypalCouverture.dejaInitialise(true);
	}

	//////////////////////
	// nombreExecuteurs //
	//////////////////////

	/**	L'entité « nombreExecuteurs »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public Integer nombreExecuteurs;
	public Couverture<Integer> nombreExecuteursCouverture = new Couverture<Integer>().p(this).c(Integer.class).var("nombreExecuteurs").o(nombreExecuteurs);

	/**	L'entité « nombreExecuteurs »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _nombreExecuteurs(Couverture<Integer> o) throws Exception;

	public EcouteurContexte nombreExecuteurs(Integer o) throws Exception {
		setNombreExecuteurs(o);
		return (EcouteurContexte)this;
	}

	public void setNombreExecuteurs(Integer o) throws Exception {
		this.nombreExecuteurs = o;
	}

	public Integer nombreExecuteurs() throws Exception {
		return getNombreExecuteurs();
	}

	public Integer getNombreExecuteurs() throws Exception {
		return nombreExecuteurs;
	}
	public EcouteurContexte nombreExecuteurs(String o) throws Exception {
		if(org.apache.commons.lang3.math.NumberUtils.isNumber(o))
			this.nombreExecuteurs = Integer.parseInt(o);
		return (EcouteurContexte)this;
	}
	protected void nombreExecuteursInit() throws Exception {
		if(!nombreExecuteursCouverture.dejaInitialise) {
			_nombreExecuteurs(nombreExecuteursCouverture);
			if(nombreExecuteurs == null)
				nombreExecuteurs(nombreExecuteursCouverture.o);
		}
		nombreExecuteursCouverture.dejaInitialise(true);
	}

	///////////////////////
	// daemonFabriqueFil //
	///////////////////////

	/**	L'entité « daemonFabriqueFil »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public DaemonFabriqueFil daemonFabriqueFil;
	public Couverture<DaemonFabriqueFil> daemonFabriqueFilCouverture = new Couverture<DaemonFabriqueFil>().p(this).c(DaemonFabriqueFil.class).var("daemonFabriqueFil").o(daemonFabriqueFil);

	/**	L'entité « daemonFabriqueFil »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _daemonFabriqueFil(Couverture<DaemonFabriqueFil> o) throws Exception;

	public EcouteurContexte daemonFabriqueFil(DaemonFabriqueFil o) throws Exception {
		setDaemonFabriqueFil(o);
		return (EcouteurContexte)this;
	}

	public void setDaemonFabriqueFil(DaemonFabriqueFil o) throws Exception {
		this.daemonFabriqueFil = o;
	}

	public DaemonFabriqueFil daemonFabriqueFil() throws Exception {
		return getDaemonFabriqueFil();
	}

	public DaemonFabriqueFil getDaemonFabriqueFil() throws Exception {
		return daemonFabriqueFil;
	}
	protected void daemonFabriqueFilInit() throws Exception {
		if(!daemonFabriqueFilCouverture.dejaInitialise) {
			_daemonFabriqueFil(daemonFabriqueFilCouverture);
			if(daemonFabriqueFil == null)
				daemonFabriqueFil(daemonFabriqueFilCouverture.o);
		}
		daemonFabriqueFilCouverture.dejaInitialise(true);
	}

	//////////////////////
	// serviceExecuteur //
	//////////////////////

	/**	L'entité « serviceExecuteur »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public ExecutorService serviceExecuteur;
	public Couverture<ExecutorService> serviceExecuteurCouverture = new Couverture<ExecutorService>().p(this).c(ExecutorService.class).var("serviceExecuteur").o(serviceExecuteur);

	/**	L'entité « serviceExecuteur »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _serviceExecuteur(Couverture<ExecutorService> o) throws Exception;

	public EcouteurContexte serviceExecuteur(ExecutorService o) throws Exception {
		setServiceExecuteur(o);
		return (EcouteurContexte)this;
	}

	public void setServiceExecuteur(ExecutorService o) throws Exception {
		this.serviceExecuteur = o;
	}

	public ExecutorService serviceExecuteur() throws Exception {
		return getServiceExecuteur();
	}

	public ExecutorService getServiceExecuteur() throws Exception {
		return serviceExecuteur;
	}
	protected void serviceExecuteurInit() throws Exception {
		if(!serviceExecuteurCouverture.dejaInitialise) {
			_serviceExecuteur(serviceExecuteurCouverture);
			if(serviceExecuteur == null)
				serviceExecuteur(serviceExecuteurCouverture.o);
		}
		serviceExecuteurCouverture.dejaInitialise(true);
	}

	/////////////////
	// requeteSite //
	/////////////////

	/**	L'entité « requeteSite »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut RequeteSite(). 
	 */
	public RequeteSite requeteSite = new RequeteSite();
	public Couverture<RequeteSite> requeteSiteCouverture = new Couverture<RequeteSite>().p(this).c(RequeteSite.class).var("requeteSite").o(requeteSite);

	/**	L'entité « requeteSite »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut RequeteSite(). 
	 *	@param requeteSite est le champ déjà construit. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _requeteSite(RequeteSite o) throws Exception;

	public EcouteurContexte requeteSite(RequeteSite o) throws Exception {
		setRequeteSite(o);
		return (EcouteurContexte)this;
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
			_requeteSite(requeteSite);
		}
		requeteSite.initLoinPourClasse(requeteSite);
		requeteSiteCouverture.dejaInitialise(true);
	}

	protected boolean dejaInitialiseEcouteurContexte = false;

	public void initLoinEcouteurContexte(RequeteSite requeteSite) throws Exception {
		((EcouteurContexte)this).requeteSite(requeteSite);
		requeteSite(requeteSite);
		initLoinEcouteurContexte();
	}

	public void initLoinEcouteurContexte() throws Exception {
		if(!dejaInitialiseEcouteurContexte) {
			cheminConfigInit();
			configSiteInit();
			contexteInitialeInit();
			urlSourceDonneesInit();
			urlSourceDonneesSimpleInit();
			sourceDonneesInit();
			urlSourceMailInit();
			sessionCourrielInit();
			clientSolrInit();
			selCryptageInit();
			motDePasseCryptageInit();
			jetonIdentitePaypalInit();
			nombreExecuteursInit();
			daemonFabriqueFilInit();
			serviceExecuteurInit();
			requeteSiteInit();
			dejaInitialiseEcouteurContexte = true;
		}
	}

	public void initLoinPourClasse(RequeteSite requeteSite) throws Exception {
		initLoinEcouteurContexte(requeteSite);
	}
}
