package com.heytate.frFR.cardiaque.config;

import org.apache.commons.configuration2.INIConfiguration;
import com.heytate.frFR.cardiaque.contexte.EcouteurContexte;
import com.heytate.frFR.cardiaque.requete.RequeteSite;
import java.lang.String;
import java.lang.Integer;
import com.heytate.frFR.cardiaque.couverture.Couverture;
import org.apache.commons.configuration2.builder.fluent.Configurations;

/**	Charge les propriétés dans le fichier de config de l'application dans des champs spécifiques.
 */
public abstract class ConfigSiteGen<DEV> extends Object {

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

	public ConfigSite requeteSite(RequeteSite o) throws Exception {
		setRequeteSite(o);
		return (ConfigSite)this;
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

	//////////////////////
	// ecouteurContexte //
	//////////////////////

	/**	L'entité « ecouteurContexte »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public EcouteurContexte ecouteurContexte;
	public Couverture<EcouteurContexte> ecouteurContexteCouverture = new Couverture<EcouteurContexte>().p(this).c(EcouteurContexte.class).var("ecouteurContexte").o(ecouteurContexte);

	/**	L'entité « ecouteurContexte »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _ecouteurContexte(Couverture<EcouteurContexte> o) throws Exception;

	public ConfigSite ecouteurContexte(EcouteurContexte o) throws Exception {
		setEcouteurContexte(o);
		return (ConfigSite)this;
	}

	public void setEcouteurContexte(EcouteurContexte o) throws Exception {
		this.ecouteurContexte = o;
	}

	public EcouteurContexte ecouteurContexte() throws Exception {
		return getEcouteurContexte();
	}

	public EcouteurContexte getEcouteurContexte() throws Exception {
		return ecouteurContexte;
	}
	protected void ecouteurContexteInit() throws Exception {
		if(!ecouteurContexteCouverture.dejaInitialise) {
			_ecouteurContexte(ecouteurContexteCouverture);
			if(ecouteurContexte == null)
				ecouteurContexte(ecouteurContexteCouverture.o);
		}
		if(ecouteurContexte != null)
			ecouteurContexte.initLoinPourClasse(requeteSite);
		ecouteurContexteCouverture.dejaInitialise(true);
	}

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

	public ConfigSite cheminConfig(String o) throws Exception {
		setCheminConfig(o);
		return (ConfigSite)this;
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

	////////////////////
	// configurations //
	////////////////////

	/**	L'entité « configurations »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public Configurations configurations;
	public Couverture<Configurations> configurationsCouverture = new Couverture<Configurations>().p(this).c(Configurations.class).var("configurations").o(configurations);

	/**	L'entité « configurations »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _configurations(Couverture<Configurations> o) throws Exception;

	public ConfigSite configurations(Configurations o) throws Exception {
		setConfigurations(o);
		return (ConfigSite)this;
	}

	public void setConfigurations(Configurations o) throws Exception {
		this.configurations = o;
	}

	public Configurations configurations() throws Exception {
		return getConfigurations();
	}

	public Configurations getConfigurations() throws Exception {
		return configurations;
	}
	protected void configurationsInit() throws Exception {
		if(!configurationsCouverture.dejaInitialise) {
			_configurations(configurationsCouverture);
			if(configurations == null)
				configurations(configurationsCouverture.o);
		}
		configurationsCouverture.dejaInitialise(true);
	}

	////////////
	// config //
	////////////

	/**	L'entité « config »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public INIConfiguration config;
	public Couverture<INIConfiguration> configCouverture = new Couverture<INIConfiguration>().p(this).c(INIConfiguration.class).var("config").o(config);

	/**	L'entité « config »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _config(Couverture<INIConfiguration> o) throws Exception;

	public ConfigSite config(INIConfiguration o) throws Exception {
		setConfig(o);
		return (ConfigSite)this;
	}

	public void setConfig(INIConfiguration o) throws Exception {
		this.config = o;
	}

	public INIConfiguration config() throws Exception {
		return getConfig();
	}

	public INIConfiguration getConfig() throws Exception {
		return config;
	}
	protected void configInit() throws Exception {
		if(!configCouverture.dejaInitialise) {
			_config(configCouverture);
			if(config == null)
				config(configCouverture.o);
		}
		configCouverture.dejaInitialise(true);
	}

	/////////////////////
	// identifiantSite //
	/////////////////////

	/**	L'entité « identifiantSite »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public String identifiantSite;
	public Couverture<String> identifiantSiteCouverture = new Couverture<String>().p(this).c(String.class).var("identifiantSite").o(identifiantSite);

	/**	L'entité « identifiantSite »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _identifiantSite(Couverture<String> o) throws Exception;

	public ConfigSite identifiantSite(String o) throws Exception {
		setIdentifiantSite(o);
		return (ConfigSite)this;
	}

	public void setIdentifiantSite(String o) throws Exception {
		this.identifiantSite = o;
	}

	public String identifiantSite() throws Exception {
		return getIdentifiantSite();
	}

	public String getIdentifiantSite() throws Exception {
		return identifiantSite;
	}
	protected void identifiantSiteInit() throws Exception {
		if(!identifiantSiteCouverture.dejaInitialise) {
			_identifiantSite(identifiantSiteCouverture);
			if(identifiantSite == null)
				identifiantSite(identifiantSiteCouverture.o);
		}
		identifiantSiteCouverture.dejaInitialise(true);
	}

	////////////////////
	// prefixeEchappe //
	////////////////////

	/**	L'entité « prefixeEchappe »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public String prefixeEchappe;
	public Couverture<String> prefixeEchappeCouverture = new Couverture<String>().p(this).c(String.class).var("prefixeEchappe").o(prefixeEchappe);

	/**	L'entité « prefixeEchappe »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _prefixeEchappe(Couverture<String> o) throws Exception;

	public ConfigSite prefixeEchappe(String o) throws Exception {
		setPrefixeEchappe(o);
		return (ConfigSite)this;
	}

	public void setPrefixeEchappe(String o) throws Exception {
		this.prefixeEchappe = o;
	}

	public String prefixeEchappe() throws Exception {
		return getPrefixeEchappe();
	}

	public String getPrefixeEchappe() throws Exception {
		return prefixeEchappe;
	}
	protected void prefixeEchappeInit() throws Exception {
		if(!prefixeEchappeCouverture.dejaInitialise) {
			_prefixeEchappe(prefixeEchappeCouverture);
			if(prefixeEchappe == null)
				prefixeEchappe(prefixeEchappeCouverture.o);
		}
		prefixeEchappeCouverture.dejaInitialise(true);
	}

	//////////////////
	// cheminProjet //
	//////////////////

	/**	L'entité « cheminProjet »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public String cheminProjet;
	public Couverture<String> cheminProjetCouverture = new Couverture<String>().p(this).c(String.class).var("cheminProjet").o(cheminProjet);

	/**	L'entité « cheminProjet »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _cheminProjet(Couverture<String> o) throws Exception;

	public ConfigSite cheminProjet(String o) throws Exception {
		setCheminProjet(o);
		return (ConfigSite)this;
	}

	public void setCheminProjet(String o) throws Exception {
		this.cheminProjet = o;
	}

	public String cheminProjet() throws Exception {
		return getCheminProjet();
	}

	public String getCheminProjet() throws Exception {
		return cheminProjet;
	}
	protected void cheminProjetInit() throws Exception {
		if(!cheminProjetCouverture.dejaInitialise) {
			_cheminProjet(cheminProjetCouverture);
			if(cheminProjet == null)
				cheminProjet(cheminProjetCouverture.o);
		}
		cheminProjetCouverture.dejaInitialise(true);
	}

	////////////////////
	// racineDocument //
	////////////////////

	/**	L'entité « racineDocument »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public String racineDocument;
	public Couverture<String> racineDocumentCouverture = new Couverture<String>().p(this).c(String.class).var("racineDocument").o(racineDocument);

	/**	L'entité « racineDocument »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _racineDocument(Couverture<String> o) throws Exception;

	public ConfigSite racineDocument(String o) throws Exception {
		setRacineDocument(o);
		return (ConfigSite)this;
	}

	public void setRacineDocument(String o) throws Exception {
		this.racineDocument = o;
	}

	public String racineDocument() throws Exception {
		return getRacineDocument();
	}

	public String getRacineDocument() throws Exception {
		return racineDocument;
	}
	protected void racineDocumentInit() throws Exception {
		if(!racineDocumentCouverture.dejaInitialise) {
			_racineDocument(racineDocumentCouverture);
			if(racineDocument == null)
				racineDocument(racineDocumentCouverture.o);
		}
		racineDocumentCouverture.dejaInitialise(true);
	}

	///////////////////
	// nomEntreprise //
	///////////////////

	/**	L'entité « nomEntreprise »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public String nomEntreprise;
	public Couverture<String> nomEntrepriseCouverture = new Couverture<String>().p(this).c(String.class).var("nomEntreprise").o(nomEntreprise);

	/**	L'entité « nomEntreprise »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _nomEntreprise(Couverture<String> o) throws Exception;

	public ConfigSite nomEntreprise(String o) throws Exception {
		setNomEntreprise(o);
		return (ConfigSite)this;
	}

	public void setNomEntreprise(String o) throws Exception {
		this.nomEntreprise = o;
	}

	public String nomEntreprise() throws Exception {
		return getNomEntreprise();
	}

	public String getNomEntreprise() throws Exception {
		return nomEntreprise;
	}
	protected void nomEntrepriseInit() throws Exception {
		if(!nomEntrepriseCouverture.dejaInitialise) {
			_nomEntreprise(nomEntrepriseCouverture);
			if(nomEntreprise == null)
				nomEntreprise(nomEntrepriseCouverture.o);
		}
		nomEntrepriseCouverture.dejaInitialise(true);
	}

	////////////////
	// nomDomaine //
	////////////////

	/**	L'entité « nomDomaine »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public String nomDomaine;
	public Couverture<String> nomDomaineCouverture = new Couverture<String>().p(this).c(String.class).var("nomDomaine").o(nomDomaine);

	/**	L'entité « nomDomaine »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _nomDomaine(Couverture<String> o) throws Exception;

	public ConfigSite nomDomaine(String o) throws Exception {
		setNomDomaine(o);
		return (ConfigSite)this;
	}

	public void setNomDomaine(String o) throws Exception {
		this.nomDomaine = o;
	}

	public String nomDomaine() throws Exception {
		return getNomDomaine();
	}

	public String getNomDomaine() throws Exception {
		return nomDomaine;
	}
	protected void nomDomaineInit() throws Exception {
		if(!nomDomaineCouverture.dejaInitialise) {
			_nomDomaine(nomDomaineCouverture);
			if(nomDomaine == null)
				nomDomaine(nomDomaineCouverture.o);
		}
		nomDomaineCouverture.dejaInitialise(true);
	}

	/////////////////
	// nomHoteSite //
	/////////////////

	/**	L'entité « nomHoteSite »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public String nomHoteSite;
	public Couverture<String> nomHoteSiteCouverture = new Couverture<String>().p(this).c(String.class).var("nomHoteSite").o(nomHoteSite);

	/**	L'entité « nomHoteSite »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _nomHoteSite(Couverture<String> o) throws Exception;

	public ConfigSite nomHoteSite(String o) throws Exception {
		setNomHoteSite(o);
		return (ConfigSite)this;
	}

	public void setNomHoteSite(String o) throws Exception {
		this.nomHoteSite = o;
	}

	public String nomHoteSite() throws Exception {
		return getNomHoteSite();
	}

	public String getNomHoteSite() throws Exception {
		return nomHoteSite;
	}
	protected void nomHoteSiteInit() throws Exception {
		if(!nomHoteSiteCouverture.dejaInitialise) {
			_nomHoteSite(nomHoteSiteCouverture);
			if(nomHoteSite == null)
				nomHoteSite(nomHoteSiteCouverture.o);
		}
		nomHoteSiteCouverture.dejaInitialise(true);
	}

	////////////////////
	// siteIdKeycloak //
	////////////////////

	/**	L'entité « siteIdKeycloak »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public String siteIdKeycloak;
	public Couverture<String> siteIdKeycloakCouverture = new Couverture<String>().p(this).c(String.class).var("siteIdKeycloak").o(siteIdKeycloak);

	/**	L'entité « siteIdKeycloak »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _siteIdKeycloak(Couverture<String> o) throws Exception;

	public ConfigSite siteIdKeycloak(String o) throws Exception {
		setSiteIdKeycloak(o);
		return (ConfigSite)this;
	}

	public void setSiteIdKeycloak(String o) throws Exception {
		this.siteIdKeycloak = o;
	}

	public String siteIdKeycloak() throws Exception {
		return getSiteIdKeycloak();
	}

	public String getSiteIdKeycloak() throws Exception {
		return siteIdKeycloak;
	}
	protected void siteIdKeycloakInit() throws Exception {
		if(!siteIdKeycloakCouverture.dejaInitialise) {
			_siteIdKeycloak(siteIdKeycloakCouverture);
			if(siteIdKeycloak == null)
				siteIdKeycloak(siteIdKeycloakCouverture.o);
		}
		siteIdKeycloakCouverture.dejaInitialise(true);
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

	public ConfigSite selCryptage(String o) throws Exception {
		setSelCryptage(o);
		return (ConfigSite)this;
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

	public ConfigSite motDePasseCryptage(String o) throws Exception {
		setMotDePasseCryptage(o);
		return (ConfigSite)this;
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

	////////////////////
	// urlDomaineBase //
	////////////////////

	/**	L'entité « urlDomaineBase »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public String urlDomaineBase;
	public Couverture<String> urlDomaineBaseCouverture = new Couverture<String>().p(this).c(String.class).var("urlDomaineBase").o(urlDomaineBase);

	/**	L'entité « urlDomaineBase »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _urlDomaineBase(Couverture<String> o) throws Exception;

	public ConfigSite urlDomaineBase(String o) throws Exception {
		setUrlDomaineBase(o);
		return (ConfigSite)this;
	}

	public void setUrlDomaineBase(String o) throws Exception {
		this.urlDomaineBase = o;
	}

	public String urlDomaineBase() throws Exception {
		return getUrlDomaineBase();
	}

	public String getUrlDomaineBase() throws Exception {
		return urlDomaineBase;
	}
	protected void urlDomaineBaseInit() throws Exception {
		if(!urlDomaineBaseCouverture.dejaInitialise) {
			_urlDomaineBase(urlDomaineBaseCouverture);
			if(urlDomaineBase == null)
				urlDomaineBase(urlDomaineBaseCouverture.o);
		}
		urlDomaineBaseCouverture.dejaInitialise(true);
	}

	//////////////////////
	// nomAffichageSite //
	//////////////////////

	/**	L'entité « nomAffichageSite »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public String nomAffichageSite;
	public Couverture<String> nomAffichageSiteCouverture = new Couverture<String>().p(this).c(String.class).var("nomAffichageSite").o(nomAffichageSite);

	/**	L'entité « nomAffichageSite »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _nomAffichageSite(Couverture<String> o) throws Exception;

	public ConfigSite nomAffichageSite(String o) throws Exception {
		setNomAffichageSite(o);
		return (ConfigSite)this;
	}

	public void setNomAffichageSite(String o) throws Exception {
		this.nomAffichageSite = o;
	}

	public String nomAffichageSite() throws Exception {
		return getNomAffichageSite();
	}

	public String getNomAffichageSite() throws Exception {
		return nomAffichageSite;
	}
	protected void nomAffichageSiteInit() throws Exception {
		if(!nomAffichageSiteCouverture.dejaInitialise) {
			_nomAffichageSite(nomAffichageSiteCouverture);
			if(nomAffichageSite == null)
				nomAffichageSite(nomAffichageSiteCouverture.o);
		}
		nomAffichageSiteCouverture.dejaInitialise(true);
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

	public ConfigSite urlSourceDonneesSimple(String o) throws Exception {
		setUrlSourceDonneesSimple(o);
		return (ConfigSite)this;
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

	/////////////
	// urlSolr //
	/////////////

	/**	L'entité « urlSolr »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public String urlSolr;
	public Couverture<String> urlSolrCouverture = new Couverture<String>().p(this).c(String.class).var("urlSolr").o(urlSolr);

	/**	L'entité « urlSolr »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _urlSolr(Couverture<String> o) throws Exception;

	public ConfigSite urlSolr(String o) throws Exception {
		setUrlSolr(o);
		return (ConfigSite)this;
	}

	public void setUrlSolr(String o) throws Exception {
		this.urlSolr = o;
	}

	public String urlSolr() throws Exception {
		return getUrlSolr();
	}

	public String getUrlSolr() throws Exception {
		return urlSolr;
	}
	protected void urlSolrInit() throws Exception {
		if(!urlSolrCouverture.dejaInitialise) {
			_urlSolr(urlSolrCouverture);
			if(urlSolr == null)
				urlSolr(urlSolrCouverture.o);
		}
		urlSolrCouverture.dejaInitialise(true);
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

	public ConfigSite jetonIdentitePaypal(String o) throws Exception {
		setJetonIdentitePaypal(o);
		return (ConfigSite)this;
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

	////////////////////
	// compteFacebook //
	////////////////////

	/**	L'entité « compteFacebook »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public String compteFacebook;
	public Couverture<String> compteFacebookCouverture = new Couverture<String>().p(this).c(String.class).var("compteFacebook").o(compteFacebook);

	/**	L'entité « compteFacebook »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _compteFacebook(Couverture<String> o) throws Exception;

	public ConfigSite compteFacebook(String o) throws Exception {
		setCompteFacebook(o);
		return (ConfigSite)this;
	}

	public void setCompteFacebook(String o) throws Exception {
		this.compteFacebook = o;
	}

	public String compteFacebook() throws Exception {
		return getCompteFacebook();
	}

	public String getCompteFacebook() throws Exception {
		return compteFacebook;
	}
	protected void compteFacebookInit() throws Exception {
		if(!compteFacebookCouverture.dejaInitialise) {
			_compteFacebook(compteFacebookCouverture);
			if(compteFacebook == null)
				compteFacebook(compteFacebookCouverture.o);
		}
		compteFacebookCouverture.dejaInitialise(true);
	}

	///////////////////
	// compteTwitter //
	///////////////////

	/**	L'entité « compteTwitter »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public String compteTwitter;
	public Couverture<String> compteTwitterCouverture = new Couverture<String>().p(this).c(String.class).var("compteTwitter").o(compteTwitter);

	/**	L'entité « compteTwitter »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _compteTwitter(Couverture<String> o) throws Exception;

	public ConfigSite compteTwitter(String o) throws Exception {
		setCompteTwitter(o);
		return (ConfigSite)this;
	}

	public void setCompteTwitter(String o) throws Exception {
		this.compteTwitter = o;
	}

	public String compteTwitter() throws Exception {
		return getCompteTwitter();
	}

	public String getCompteTwitter() throws Exception {
		return compteTwitter;
	}
	protected void compteTwitterInit() throws Exception {
		if(!compteTwitterCouverture.dejaInitialise) {
			_compteTwitter(compteTwitterCouverture);
			if(compteTwitter == null)
				compteTwitter(compteTwitterCouverture.o);
		}
		compteTwitterCouverture.dejaInitialise(true);
	}

	//////////////////////
	// compteGooglePlus //
	//////////////////////

	/**	L'entité « compteGooglePlus »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public String compteGooglePlus;
	public Couverture<String> compteGooglePlusCouverture = new Couverture<String>().p(this).c(String.class).var("compteGooglePlus").o(compteGooglePlus);

	/**	L'entité « compteGooglePlus »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _compteGooglePlus(Couverture<String> o) throws Exception;

	public ConfigSite compteGooglePlus(String o) throws Exception {
		setCompteGooglePlus(o);
		return (ConfigSite)this;
	}

	public void setCompteGooglePlus(String o) throws Exception {
		this.compteGooglePlus = o;
	}

	public String compteGooglePlus() throws Exception {
		return getCompteGooglePlus();
	}

	public String getCompteGooglePlus() throws Exception {
		return compteGooglePlus;
	}
	protected void compteGooglePlusInit() throws Exception {
		if(!compteGooglePlusCouverture.dejaInitialise) {
			_compteGooglePlus(compteGooglePlusCouverture);
			if(compteGooglePlus == null)
				compteGooglePlus(compteGooglePlusCouverture.o);
		}
		compteGooglePlusCouverture.dejaInitialise(true);
	}

	/////////////////////
	// compteInstagram //
	/////////////////////

	/**	L'entité « compteInstagram »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public String compteInstagram;
	public Couverture<String> compteInstagramCouverture = new Couverture<String>().p(this).c(String.class).var("compteInstagram").o(compteInstagram);

	/**	L'entité « compteInstagram »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _compteInstagram(Couverture<String> o) throws Exception;

	public ConfigSite compteInstagram(String o) throws Exception {
		setCompteInstagram(o);
		return (ConfigSite)this;
	}

	public void setCompteInstagram(String o) throws Exception {
		this.compteInstagram = o;
	}

	public String compteInstagram() throws Exception {
		return getCompteInstagram();
	}

	public String getCompteInstagram() throws Exception {
		return compteInstagram;
	}
	protected void compteInstagramInit() throws Exception {
		if(!compteInstagramCouverture.dejaInitialise) {
			_compteInstagram(compteInstagramCouverture);
			if(compteInstagram == null)
				compteInstagram(compteInstagramCouverture.o);
		}
		compteInstagramCouverture.dejaInitialise(true);
	}

	///////////////////
	// compteYoutube //
	///////////////////

	/**	L'entité « compteYoutube »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public String compteYoutube;
	public Couverture<String> compteYoutubeCouverture = new Couverture<String>().p(this).c(String.class).var("compteYoutube").o(compteYoutube);

	/**	L'entité « compteYoutube »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _compteYoutube(Couverture<String> o) throws Exception;

	public ConfigSite compteYoutube(String o) throws Exception {
		setCompteYoutube(o);
		return (ConfigSite)this;
	}

	public void setCompteYoutube(String o) throws Exception {
		this.compteYoutube = o;
	}

	public String compteYoutube() throws Exception {
		return getCompteYoutube();
	}

	public String getCompteYoutube() throws Exception {
		return compteYoutube;
	}
	protected void compteYoutubeInit() throws Exception {
		if(!compteYoutubeCouverture.dejaInitialise) {
			_compteYoutube(compteYoutubeCouverture);
			if(compteYoutube == null)
				compteYoutube(compteYoutubeCouverture.o);
		}
		compteYoutubeCouverture.dejaInitialise(true);
	}

	/////////////////////////////
	// identifiantCanalYoutube //
	/////////////////////////////

	/**	L'entité « identifiantCanalYoutube »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public String identifiantCanalYoutube;
	public Couverture<String> identifiantCanalYoutubeCouverture = new Couverture<String>().p(this).c(String.class).var("identifiantCanalYoutube").o(identifiantCanalYoutube);

	/**	L'entité « identifiantCanalYoutube »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _identifiantCanalYoutube(Couverture<String> o) throws Exception;

	public ConfigSite identifiantCanalYoutube(String o) throws Exception {
		setIdentifiantCanalYoutube(o);
		return (ConfigSite)this;
	}

	public void setIdentifiantCanalYoutube(String o) throws Exception {
		this.identifiantCanalYoutube = o;
	}

	public String identifiantCanalYoutube() throws Exception {
		return getIdentifiantCanalYoutube();
	}

	public String getIdentifiantCanalYoutube() throws Exception {
		return identifiantCanalYoutube;
	}
	protected void identifiantCanalYoutubeInit() throws Exception {
		if(!identifiantCanalYoutubeCouverture.dejaInitialise) {
			_identifiantCanalYoutube(identifiantCanalYoutubeCouverture);
			if(identifiantCanalYoutube == null)
				identifiantCanalYoutube(identifiantCanalYoutubeCouverture.o);
		}
		identifiantCanalYoutubeCouverture.dejaInitialise(true);
	}

	/////////////////////
	// comptePinterest //
	/////////////////////

	/**	L'entité « comptePinterest »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public String comptePinterest;
	public Couverture<String> comptePinterestCouverture = new Couverture<String>().p(this).c(String.class).var("comptePinterest").o(comptePinterest);

	/**	L'entité « comptePinterest »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _comptePinterest(Couverture<String> o) throws Exception;

	public ConfigSite comptePinterest(String o) throws Exception {
		setComptePinterest(o);
		return (ConfigSite)this;
	}

	public void setComptePinterest(String o) throws Exception {
		this.comptePinterest = o;
	}

	public String comptePinterest() throws Exception {
		return getComptePinterest();
	}

	public String getComptePinterest() throws Exception {
		return comptePinterest;
	}
	protected void comptePinterestInit() throws Exception {
		if(!comptePinterestCouverture.dejaInitialise) {
			_comptePinterest(comptePinterestCouverture);
			if(comptePinterest == null)
				comptePinterest(comptePinterestCouverture.o);
		}
		comptePinterestCouverture.dejaInitialise(true);
	}

	///////////////////////
	// compteOpenclipart //
	///////////////////////

	/**	L'entité « compteOpenclipart »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public String compteOpenclipart;
	public Couverture<String> compteOpenclipartCouverture = new Couverture<String>().p(this).c(String.class).var("compteOpenclipart").o(compteOpenclipart);

	/**	L'entité « compteOpenclipart »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _compteOpenclipart(Couverture<String> o) throws Exception;

	public ConfigSite compteOpenclipart(String o) throws Exception {
		setCompteOpenclipart(o);
		return (ConfigSite)this;
	}

	public void setCompteOpenclipart(String o) throws Exception {
		this.compteOpenclipart = o;
	}

	public String compteOpenclipart() throws Exception {
		return getCompteOpenclipart();
	}

	public String getCompteOpenclipart() throws Exception {
		return compteOpenclipart;
	}
	protected void compteOpenclipartInit() throws Exception {
		if(!compteOpenclipartCouverture.dejaInitialise) {
			_compteOpenclipart(compteOpenclipartCouverture);
			if(compteOpenclipart == null)
				compteOpenclipart(compteOpenclipartCouverture.o);
		}
		compteOpenclipartCouverture.dejaInitialise(true);
	}

	////////////////
	// compteMail //
	////////////////

	/**	L'entité « compteMail »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public String compteMail;
	public Couverture<String> compteMailCouverture = new Couverture<String>().p(this).c(String.class).var("compteMail").o(compteMail);

	/**	L'entité « compteMail »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _compteMail(Couverture<String> o) throws Exception;

	public ConfigSite compteMail(String o) throws Exception {
		setCompteMail(o);
		return (ConfigSite)this;
	}

	public void setCompteMail(String o) throws Exception {
		this.compteMail = o;
	}

	public String compteMail() throws Exception {
		return getCompteMail();
	}

	public String getCompteMail() throws Exception {
		return compteMail;
	}
	protected void compteMailInit() throws Exception {
		if(!compteMailCouverture.dejaInitialise) {
			_compteMail(compteMailCouverture);
			if(compteMail == null)
				compteMail(compteMailCouverture.o);
		}
		compteMailCouverture.dejaInitialise(true);
	}

	///////////////
	// mailAdmin //
	///////////////

	/**	L'entité « mailAdmin »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public String mailAdmin;
	public Couverture<String> mailAdminCouverture = new Couverture<String>().p(this).c(String.class).var("mailAdmin").o(mailAdmin);

	/**	L'entité « mailAdmin »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _mailAdmin(Couverture<String> o) throws Exception;

	public ConfigSite mailAdmin(String o) throws Exception {
		setMailAdmin(o);
		return (ConfigSite)this;
	}

	public void setMailAdmin(String o) throws Exception {
		this.mailAdmin = o;
	}

	public String mailAdmin() throws Exception {
		return getMailAdmin();
	}

	public String getMailAdmin() throws Exception {
		return mailAdmin;
	}
	protected void mailAdminInit() throws Exception {
		if(!mailAdminCouverture.dejaInitialise) {
			_mailAdmin(mailAdminCouverture);
			if(mailAdmin == null)
				mailAdmin(mailAdminCouverture.o);
		}
		mailAdminCouverture.dejaInitialise(true);
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

	public ConfigSite nombreExecuteurs(Integer o) throws Exception {
		setNombreExecuteurs(o);
		return (ConfigSite)this;
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
	public ConfigSite nombreExecuteurs(String o) throws Exception {
		if(org.apache.commons.lang3.math.NumberUtils.isNumber(o))
			this.nombreExecuteurs = Integer.parseInt(o);
		return (ConfigSite)this;
	}
	protected void nombreExecuteursInit() throws Exception {
		if(!nombreExecuteursCouverture.dejaInitialise) {
			_nombreExecuteurs(nombreExecuteursCouverture);
			if(nombreExecuteurs == null)
				nombreExecuteurs(nombreExecuteursCouverture.o);
		}
		nombreExecuteursCouverture.dejaInitialise(true);
	}

	protected boolean dejaInitialiseConfigSite = false;

	public void initLoinConfigSite(RequeteSite requeteSite) throws Exception {
		((ConfigSite)this).requeteSite(requeteSite);
		requeteSite(requeteSite);
		initLoinConfigSite();
	}

	public void initLoinConfigSite() throws Exception {
		if(!dejaInitialiseConfigSite) {
			requeteSiteInit();
			ecouteurContexteInit();
			cheminConfigInit();
			configurationsInit();
			configInit();
			identifiantSiteInit();
			prefixeEchappeInit();
			cheminProjetInit();
			racineDocumentInit();
			nomEntrepriseInit();
			nomDomaineInit();
			nomHoteSiteInit();
			siteIdKeycloakInit();
			selCryptageInit();
			motDePasseCryptageInit();
			urlDomaineBaseInit();
			nomAffichageSiteInit();
			urlSourceDonneesSimpleInit();
			urlSolrInit();
			jetonIdentitePaypalInit();
			compteFacebookInit();
			compteTwitterInit();
			compteGooglePlusInit();
			compteInstagramInit();
			compteYoutubeInit();
			identifiantCanalYoutubeInit();
			comptePinterestInit();
			compteOpenclipartInit();
			compteMailInit();
			mailAdminInit();
			nombreExecuteursInit();
			dejaInitialiseConfigSite = true;
		}
	}

	public void initLoinPourClasse(RequeteSite requeteSite) throws Exception {
		initLoinConfigSite(requeteSite);
	}
}
