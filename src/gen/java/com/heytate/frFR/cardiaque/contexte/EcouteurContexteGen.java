package com.heytate.frFR.cardiaque.contexte;

import com.heytate.frFR.cardiaque.config.ConfigSite;
import javax.naming.InitialContext;
import com.heytate.frFR.cardiaque.requete.RequeteSite;
import com.heytate.frFR.cardiaque.cluster.Cluster;
import java.lang.Integer;
import com.heytate.frFR.cardiaque.fil.DaemonFabriqueFil;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import javax.sql.DataSource;
import javax.mail.Session;
import java.lang.Object;
import java.lang.String;
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

	public void setCheminConfig(String o) throws Exception {
		this.cheminConfig = o;
	}

	public String getCheminConfig() throws Exception {
		return cheminConfig;
	}
	protected void cheminConfigInit() throws Exception {
		if(!cheminConfigCouverture.dejaInitialise) {
			_cheminConfig(cheminConfigCouverture);
			if(cheminConfig == null)
				setCheminConfig(cheminConfigCouverture.o);
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

	public void setConfigSite(ConfigSite o) throws Exception {
		this.configSite = o;
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

	public void setContexteInitiale(InitialContext o) throws Exception {
		this.contexteInitiale = o;
	}

	public InitialContext getContexteInitiale() throws Exception {
		return contexteInitiale;
	}
	protected void contexteInitialeInit() throws Exception {
		if(!contexteInitialeCouverture.dejaInitialise) {
			_contexteInitiale(contexteInitialeCouverture);
			if(contexteInitiale == null)
				setContexteInitiale(contexteInitialeCouverture.o);
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

	public void setUrlSourceDonnees(String o) throws Exception {
		this.urlSourceDonnees = o;
	}

	public String getUrlSourceDonnees() throws Exception {
		return urlSourceDonnees;
	}
	protected void urlSourceDonneesInit() throws Exception {
		if(!urlSourceDonneesCouverture.dejaInitialise) {
			_urlSourceDonnees(urlSourceDonneesCouverture);
			if(urlSourceDonnees == null)
				setUrlSourceDonnees(urlSourceDonneesCouverture.o);
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

	public void setUrlSourceDonneesSimple(String o) throws Exception {
		this.urlSourceDonneesSimple = o;
	}

	public String getUrlSourceDonneesSimple() throws Exception {
		return urlSourceDonneesSimple;
	}
	protected void urlSourceDonneesSimpleInit() throws Exception {
		if(!urlSourceDonneesSimpleCouverture.dejaInitialise) {
			_urlSourceDonneesSimple(urlSourceDonneesSimpleCouverture);
			if(urlSourceDonneesSimple == null)
				setUrlSourceDonneesSimple(urlSourceDonneesSimpleCouverture.o);
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

	public void setSourceDonnees(DataSource o) throws Exception {
		this.sourceDonnees = o;
	}

	public DataSource getSourceDonnees() throws Exception {
		return sourceDonnees;
	}
	protected void sourceDonneesInit() throws Exception {
		if(!sourceDonneesCouverture.dejaInitialise) {
			_sourceDonnees(sourceDonneesCouverture);
			if(sourceDonnees == null)
				setSourceDonnees(sourceDonneesCouverture.o);
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

	public void setUrlSourceMail(String o) throws Exception {
		this.urlSourceMail = o;
	}

	public String getUrlSourceMail() throws Exception {
		return urlSourceMail;
	}
	protected void urlSourceMailInit() throws Exception {
		if(!urlSourceMailCouverture.dejaInitialise) {
			_urlSourceMail(urlSourceMailCouverture);
			if(urlSourceMail == null)
				setUrlSourceMail(urlSourceMailCouverture.o);
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

	public void setSessionCourriel(Session o) throws Exception {
		this.sessionCourriel = o;
	}

	public Session getSessionCourriel() throws Exception {
		return sessionCourriel;
	}
	protected void sessionCourrielInit() throws Exception {
		if(!sessionCourrielCouverture.dejaInitialise) {
			_sessionCourriel(sessionCourrielCouverture);
			if(sessionCourriel == null)
				setSessionCourriel(sessionCourrielCouverture.o);
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

	public void setClientSolr(HttpSolrClient o) throws Exception {
		this.clientSolr = o;
	}

	public HttpSolrClient getClientSolr() throws Exception {
		return clientSolr;
	}
	protected void clientSolrInit() throws Exception {
		if(!clientSolrCouverture.dejaInitialise) {
			_clientSolr(clientSolrCouverture);
			if(clientSolr == null)
				setClientSolr(clientSolrCouverture.o);
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

	public void setSelCryptage(String o) throws Exception {
		this.selCryptage = o;
	}

	public String getSelCryptage() throws Exception {
		return selCryptage;
	}
	protected void selCryptageInit() throws Exception {
		if(!selCryptageCouverture.dejaInitialise) {
			_selCryptage(selCryptageCouverture);
			if(selCryptage == null)
				setSelCryptage(selCryptageCouverture.o);
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

	public void setMotDePasseCryptage(String o) throws Exception {
		this.motDePasseCryptage = o;
	}

	public String getMotDePasseCryptage() throws Exception {
		return motDePasseCryptage;
	}
	protected void motDePasseCryptageInit() throws Exception {
		if(!motDePasseCryptageCouverture.dejaInitialise) {
			_motDePasseCryptage(motDePasseCryptageCouverture);
			if(motDePasseCryptage == null)
				setMotDePasseCryptage(motDePasseCryptageCouverture.o);
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

	public void setJetonIdentitePaypal(String o) throws Exception {
		this.jetonIdentitePaypal = o;
	}

	public String getJetonIdentitePaypal() throws Exception {
		return jetonIdentitePaypal;
	}
	protected void jetonIdentitePaypalInit() throws Exception {
		if(!jetonIdentitePaypalCouverture.dejaInitialise) {
			_jetonIdentitePaypal(jetonIdentitePaypalCouverture);
			if(jetonIdentitePaypal == null)
				setJetonIdentitePaypal(jetonIdentitePaypalCouverture.o);
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

	public void setNombreExecuteurs(Integer o) throws Exception {
		this.nombreExecuteurs = o;
	}

	public Integer getNombreExecuteurs() throws Exception {
		return nombreExecuteurs;
	}
	public EcouteurContexte setNombreExecuteurs(String o) throws Exception {
		if(org.apache.commons.lang3.math.NumberUtils.isNumber(o))
			this.nombreExecuteurs = Integer.parseInt(o);
		return (EcouteurContexte)this;
	}
	protected void nombreExecuteursInit() throws Exception {
		if(!nombreExecuteursCouverture.dejaInitialise) {
			_nombreExecuteurs(nombreExecuteursCouverture);
			if(nombreExecuteurs == null)
				setNombreExecuteurs(nombreExecuteursCouverture.o);
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

	public void setDaemonFabriqueFil(DaemonFabriqueFil o) throws Exception {
		this.daemonFabriqueFil = o;
	}

	public DaemonFabriqueFil getDaemonFabriqueFil() throws Exception {
		return daemonFabriqueFil;
	}
	protected void daemonFabriqueFilInit() throws Exception {
		if(!daemonFabriqueFilCouverture.dejaInitialise) {
			_daemonFabriqueFil(daemonFabriqueFilCouverture);
			if(daemonFabriqueFil == null)
				setDaemonFabriqueFil(daemonFabriqueFilCouverture.o);
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

	public void setServiceExecuteur(ExecutorService o) throws Exception {
		this.serviceExecuteur = o;
	}

	public ExecutorService getServiceExecuteur() throws Exception {
		return serviceExecuteur;
	}
	protected void serviceExecuteurInit() throws Exception {
		if(!serviceExecuteurCouverture.dejaInitialise) {
			_serviceExecuteur(serviceExecuteurCouverture);
			if(serviceExecuteur == null)
				setServiceExecuteur(serviceExecuteurCouverture.o);
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

	public void setRequeteSite(RequeteSite o) throws Exception {
		this.requeteSite = o;
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

	/////////////////////
	// initialiserLoin //
	/////////////////////

	protected boolean dejaInitialiseEcouteurContexte = false;

	public void initLoinEcouteurContexte(RequeteSite requeteSite) throws Exception {
		setRequeteSite(requeteSite);
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

	/////////////////
	// requeteSite //
	/////////////////

	public void requeteSiteEcouteurContexte(RequeteSite requeteSite) throws Exception {
		configSite.setRequeteSite(requeteSite);
		requeteSite.setRequeteSite(requeteSite);
	}

	public void requeteSitePourClasse(RequeteSite requeteSite) throws Exception {
		requeteSiteEcouteurContexte(requeteSite);
	}

	/////////////
	// obtenir //
	/////////////

	public Object obtenirPourClasse(String var) throws Exception {
		String[] vars = org.apache.commons.lang3.StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtenirEcouteurContexte(v);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.obtenirPourClasse(v);
			}
		}
		return o;
	}
	public Object obtenirEcouteurContexte(String var) throws Exception {
		EcouteurContexte oEcouteurContexte = (EcouteurContexte)this;
		switch(var) {
		case "cheminConfig":
			return oEcouteurContexte.cheminConfig;
		case "configSite":
			return oEcouteurContexte.configSite;
		case "contexteInitiale":
			return oEcouteurContexte.contexteInitiale;
		case "urlSourceDonnees":
			return oEcouteurContexte.urlSourceDonnees;
		case "urlSourceDonneesSimple":
			return oEcouteurContexte.urlSourceDonneesSimple;
		case "sourceDonnees":
			return oEcouteurContexte.sourceDonnees;
		case "urlSourceMail":
			return oEcouteurContexte.urlSourceMail;
		case "sessionCourriel":
			return oEcouteurContexte.sessionCourriel;
		case "clientSolr":
			return oEcouteurContexte.clientSolr;
		case "selCryptage":
			return oEcouteurContexte.selCryptage;
		case "motDePasseCryptage":
			return oEcouteurContexte.motDePasseCryptage;
		case "jetonIdentitePaypal":
			return oEcouteurContexte.jetonIdentitePaypal;
		case "nombreExecuteurs":
			return oEcouteurContexte.nombreExecuteurs;
		case "daemonFabriqueFil":
			return oEcouteurContexte.daemonFabriqueFil;
		case "serviceExecuteur":
			return oEcouteurContexte.serviceExecuteur;
		case "requeteSite":
			return oEcouteurContexte.requeteSite;
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
				o = attribuerEcouteurContexte(v, val);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.attribuerPourClasse(v, val);
			}
		}
		return o != null;
	}
	public Object attribuerEcouteurContexte(String var, Object val) throws Exception {
		EcouteurContexte oEcouteurContexte = (EcouteurContexte)this;		switch(var) {
		case "cheminConfig":
			oEcouteurContexte.setCheminConfig((String)val);
			return val;
		case "configSite":
			oEcouteurContexte.setConfigSite((ConfigSite)val);
			return val;
		case "contexteInitiale":
			oEcouteurContexte.setContexteInitiale((InitialContext)val);
			return val;
		case "urlSourceDonnees":
			oEcouteurContexte.setUrlSourceDonnees((String)val);
			return val;
		case "urlSourceDonneesSimple":
			oEcouteurContexte.setUrlSourceDonneesSimple((String)val);
			return val;
		case "sourceDonnees":
			oEcouteurContexte.setSourceDonnees((DataSource)val);
			return val;
		case "urlSourceMail":
			oEcouteurContexte.setUrlSourceMail((String)val);
			return val;
		case "sessionCourriel":
			oEcouteurContexte.setSessionCourriel((Session)val);
			return val;
		case "clientSolr":
			oEcouteurContexte.setClientSolr((HttpSolrClient)val);
			return val;
		case "selCryptage":
			oEcouteurContexte.setSelCryptage((String)val);
			return val;
		case "motDePasseCryptage":
			oEcouteurContexte.setMotDePasseCryptage((String)val);
			return val;
		case "jetonIdentitePaypal":
			oEcouteurContexte.setJetonIdentitePaypal((String)val);
			return val;
		case "nombreExecuteurs":
			oEcouteurContexte.setNombreExecuteurs((Integer)val);
			return val;
		case "daemonFabriqueFil":
			oEcouteurContexte.setDaemonFabriqueFil((DaemonFabriqueFil)val);
			return val;
		case "serviceExecuteur":
			oEcouteurContexte.setServiceExecuteur((ExecutorService)val);
			return val;
		case "requeteSite":
			oEcouteurContexte.setRequeteSite((RequeteSite)val);
			return val;
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
					o = definirEcouteurContexte(v, val);
				else if(o instanceof Cluster) {
					Cluster cluster = (Cluster)o;
					o = cluster.definirPourClasse(v, val);
				}
			}
		}
		return o != null;
	}
	public Object definirEcouteurContexte(String var, String val) throws Exception {
		EcouteurContexte oEcouteurContexte = (EcouteurContexte)this;
		switch(var) {
		case "cheminConfig":
			oEcouteurContexte.setCheminConfig(val);
			return val;
		case "urlSourceDonnees":
			oEcouteurContexte.setUrlSourceDonnees(val);
			return val;
		case "urlSourceDonneesSimple":
			oEcouteurContexte.setUrlSourceDonneesSimple(val);
			return val;
		case "urlSourceMail":
			oEcouteurContexte.setUrlSourceMail(val);
			return val;
		case "selCryptage":
			oEcouteurContexte.setSelCryptage(val);
			return val;
		case "motDePasseCryptage":
			oEcouteurContexte.setMotDePasseCryptage(val);
			return val;
		case "jetonIdentitePaypal":
			oEcouteurContexte.setJetonIdentitePaypal(val);
			return val;
		case "nombreExecuteurs":
			oEcouteurContexte.setNombreExecuteurs(val);
			return val;
		default:
			return null;
		}
	}
}
