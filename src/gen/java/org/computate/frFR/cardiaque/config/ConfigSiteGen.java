package org.computate.frFR.cardiaque.config;

import org.computate.frFR.cardiaque.contexte.SiteContexte;
import org.computate.frFR.cardiaque.couverture.Couverture;
import org.apache.commons.configuration2.INIConfiguration;
import org.computate.frFR.cardiaque.cluster.Cluster;
import org.computate.frFR.cardiaque.requete.RequeteSite;
import java.lang.Object;
import java.lang.String;
import java.lang.Integer;

/**	Charge les propriétés dans le fichier de config de l'application dans des champs spécifiques.
 */
public abstract class ConfigSiteGen<DEV> extends Object {

	//////////////////
	// requeteSite_ //
	//////////////////

	/**	L'entité « requeteSite_ »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut RequeteSite(). 
	 */
	protected RequeteSite requeteSite_ = new RequeteSite();
	public Couverture<RequeteSite> requeteSite_Couverture = new Couverture<RequeteSite>().p(this).c(RequeteSite.class).var("requeteSite_").o(requeteSite_);

	/**	L'entité « requeteSite_ »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut RequeteSite(). 
	 *	@param requeteSite_ est le champ déjà construit. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _requeteSite_(RequeteSite o) throws Exception;

	public RequeteSite getRequeteSite_() {
		return requeteSite_;
	}

	public void setRequeteSite_(RequeteSite o) throws Exception {
		this.requeteSite_ = o;
	}
	protected void requeteSite_Init() throws Exception {
		if(!requeteSite_Couverture.dejaInitialise) {
			_requeteSite_(requeteSite_);
		}
		requeteSite_Couverture.dejaInitialise(true);
	}

	///////////////////
	// siteContexte_ //
	///////////////////

	/**	L'entité « siteContexte_ »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected SiteContexte siteContexte_;
	public Couverture<SiteContexte> siteContexte_Couverture = new Couverture<SiteContexte>().p(this).c(SiteContexte.class).var("siteContexte_").o(siteContexte_);

	/**	L'entité « siteContexte_ »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _siteContexte_(Couverture<SiteContexte> o) throws Exception;

	public SiteContexte getSiteContexte_() {
		return siteContexte_;
	}

	public void setSiteContexte_(SiteContexte o) throws Exception {
		this.siteContexte_ = o;
	}
	protected void siteContexte_Init() throws Exception {
		if(!siteContexte_Couverture.dejaInitialise) {
			_siteContexte_(siteContexte_Couverture);
			if(siteContexte_ == null)
				setSiteContexte_(siteContexte_Couverture.o);
		}
		siteContexte_Couverture.dejaInitialise(true);
	}

	//////////////////
	// cheminConfig //
	//////////////////

	/**	L'entité « cheminConfig »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected String cheminConfig;
	public Couverture<String> cheminConfigCouverture = new Couverture<String>().p(this).c(String.class).var("cheminConfig").o(cheminConfig);

	/**	L'entité « cheminConfig »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _cheminConfig(Couverture<String> o) throws Exception;

	public String getCheminConfig() {
		return cheminConfig;
	}

	public void setCheminConfig(String o) throws Exception {
		this.cheminConfig = o;
	}
	protected void cheminConfigInit() throws Exception {
		if(!cheminConfigCouverture.dejaInitialise) {
			_cheminConfig(cheminConfigCouverture);
			if(cheminConfig == null)
				setCheminConfig(cheminConfigCouverture.o);
		}
		cheminConfigCouverture.dejaInitialise(true);
	}

	////////////
	// config //
	////////////

	/**	L'entité « config »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected INIConfiguration config;
	public Couverture<INIConfiguration> configCouverture = new Couverture<INIConfiguration>().p(this).c(INIConfiguration.class).var("config").o(config);

	/**	L'entité « config »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _config(Couverture<INIConfiguration> o) throws Exception;

	public INIConfiguration getConfig() {
		return config;
	}

	public void setConfig(INIConfiguration o) throws Exception {
		this.config = o;
	}
	protected void configInit() throws Exception {
		if(!configCouverture.dejaInitialise) {
			_config(configCouverture);
			if(config == null)
				setConfig(configCouverture.o);
		}
		configCouverture.dejaInitialise(true);
	}

	/////////////////////
	// identifiantSite //
	/////////////////////

	/**	L'entité « identifiantSite »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected String identifiantSite;
	public Couverture<String> identifiantSiteCouverture = new Couverture<String>().p(this).c(String.class).var("identifiantSite").o(identifiantSite);

	/**	L'entité « identifiantSite »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _identifiantSite(Couverture<String> o) throws Exception;

	public String getIdentifiantSite() {
		return identifiantSite;
	}

	public void setIdentifiantSite(String o) throws Exception {
		this.identifiantSite = o;
	}
	protected void identifiantSiteInit() throws Exception {
		if(!identifiantSiteCouverture.dejaInitialise) {
			_identifiantSite(identifiantSiteCouverture);
			if(identifiantSite == null)
				setIdentifiantSite(identifiantSiteCouverture.o);
		}
		identifiantSiteCouverture.dejaInitialise(true);
	}

	////////////////////
	// prefixeEchappe //
	////////////////////

	/**	L'entité « prefixeEchappe »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected String prefixeEchappe;
	public Couverture<String> prefixeEchappeCouverture = new Couverture<String>().p(this).c(String.class).var("prefixeEchappe").o(prefixeEchappe);

	/**	L'entité « prefixeEchappe »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _prefixeEchappe(Couverture<String> o) throws Exception;

	public String getPrefixeEchappe() {
		return prefixeEchappe;
	}

	public void setPrefixeEchappe(String o) throws Exception {
		this.prefixeEchappe = o;
	}
	protected void prefixeEchappeInit() throws Exception {
		if(!prefixeEchappeCouverture.dejaInitialise) {
			_prefixeEchappe(prefixeEchappeCouverture);
			if(prefixeEchappe == null)
				setPrefixeEchappe(prefixeEchappeCouverture.o);
		}
		prefixeEchappeCouverture.dejaInitialise(true);
	}

	//////////////////
	// cheminProjet //
	//////////////////

	/**	L'entité « cheminProjet »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected String cheminProjet;
	public Couverture<String> cheminProjetCouverture = new Couverture<String>().p(this).c(String.class).var("cheminProjet").o(cheminProjet);

	/**	L'entité « cheminProjet »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _cheminProjet(Couverture<String> o) throws Exception;

	public String getCheminProjet() {
		return cheminProjet;
	}

	public void setCheminProjet(String o) throws Exception {
		this.cheminProjet = o;
	}
	protected void cheminProjetInit() throws Exception {
		if(!cheminProjetCouverture.dejaInitialise) {
			_cheminProjet(cheminProjetCouverture);
			if(cheminProjet == null)
				setCheminProjet(cheminProjetCouverture.o);
		}
		cheminProjetCouverture.dejaInitialise(true);
	}

	////////////////////
	// racineDocument //
	////////////////////

	/**	L'entité « racineDocument »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected String racineDocument;
	public Couverture<String> racineDocumentCouverture = new Couverture<String>().p(this).c(String.class).var("racineDocument").o(racineDocument);

	/**	L'entité « racineDocument »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _racineDocument(Couverture<String> o) throws Exception;

	public String getRacineDocument() {
		return racineDocument;
	}

	public void setRacineDocument(String o) throws Exception {
		this.racineDocument = o;
	}
	protected void racineDocumentInit() throws Exception {
		if(!racineDocumentCouverture.dejaInitialise) {
			_racineDocument(racineDocumentCouverture);
			if(racineDocument == null)
				setRacineDocument(racineDocumentCouverture.o);
		}
		racineDocumentCouverture.dejaInitialise(true);
	}

	///////////////////
	// nomEntreprise //
	///////////////////

	/**	L'entité « nomEntreprise »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected String nomEntreprise;
	public Couverture<String> nomEntrepriseCouverture = new Couverture<String>().p(this).c(String.class).var("nomEntreprise").o(nomEntreprise);

	/**	L'entité « nomEntreprise »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _nomEntreprise(Couverture<String> o) throws Exception;

	public String getNomEntreprise() {
		return nomEntreprise;
	}

	public void setNomEntreprise(String o) throws Exception {
		this.nomEntreprise = o;
	}
	protected void nomEntrepriseInit() throws Exception {
		if(!nomEntrepriseCouverture.dejaInitialise) {
			_nomEntreprise(nomEntrepriseCouverture);
			if(nomEntreprise == null)
				setNomEntreprise(nomEntrepriseCouverture.o);
		}
		nomEntrepriseCouverture.dejaInitialise(true);
	}

	////////////////
	// nomDomaine //
	////////////////

	/**	L'entité « nomDomaine »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected String nomDomaine;
	public Couverture<String> nomDomaineCouverture = new Couverture<String>().p(this).c(String.class).var("nomDomaine").o(nomDomaine);

	/**	L'entité « nomDomaine »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _nomDomaine(Couverture<String> o) throws Exception;

	public String getNomDomaine() {
		return nomDomaine;
	}

	public void setNomDomaine(String o) throws Exception {
		this.nomDomaine = o;
	}
	protected void nomDomaineInit() throws Exception {
		if(!nomDomaineCouverture.dejaInitialise) {
			_nomDomaine(nomDomaineCouverture);
			if(nomDomaine == null)
				setNomDomaine(nomDomaineCouverture.o);
		}
		nomDomaineCouverture.dejaInitialise(true);
	}

	/////////////////
	// siteNomHote //
	/////////////////

	/**	L'entité « siteNomHote »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected String siteNomHote;
	public Couverture<String> siteNomHoteCouverture = new Couverture<String>().p(this).c(String.class).var("siteNomHote").o(siteNomHote);

	/**	L'entité « siteNomHote »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _siteNomHote(Couverture<String> o) throws Exception;

	public String getSiteNomHote() {
		return siteNomHote;
	}

	public void setSiteNomHote(String o) throws Exception {
		this.siteNomHote = o;
	}
	protected void siteNomHoteInit() throws Exception {
		if(!siteNomHoteCouverture.dejaInitialise) {
			_siteNomHote(siteNomHoteCouverture);
			if(siteNomHote == null)
				setSiteNomHote(siteNomHoteCouverture.o);
		}
		siteNomHoteCouverture.dejaInitialise(true);
	}

	//////////////
	// sitePort //
	//////////////

	/**	L'entité « sitePort »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected Integer sitePort;
	public Couverture<Integer> sitePortCouverture = new Couverture<Integer>().p(this).c(Integer.class).var("sitePort").o(sitePort);

	/**	L'entité « sitePort »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _sitePort(Couverture<Integer> o) throws Exception;

	public Integer getSitePort() {
		return sitePort;
	}

	public void setSitePort(Integer o) throws Exception {
		this.sitePort = o;
	}
	public ConfigSite setSitePort(String o) throws Exception {
		if(org.apache.commons.lang3.math.NumberUtils.isCreatable(o))
			this.sitePort = Integer.parseInt(o);
		return (ConfigSite)this;
	}
	protected void sitePortInit() throws Exception {
		if(!sitePortCouverture.dejaInitialise) {
			_sitePort(sitePortCouverture);
			if(sitePort == null)
				setSitePort(sitePortCouverture.o);
		}
		sitePortCouverture.dejaInitialise(true);
	}

	/////////////////
	// authRoyaume //
	/////////////////

	/**	L'entité « authRoyaume »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected String authRoyaume;
	public Couverture<String> authRoyaumeCouverture = new Couverture<String>().p(this).c(String.class).var("authRoyaume").o(authRoyaume);

	/**	L'entité « authRoyaume »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _authRoyaume(Couverture<String> o) throws Exception;

	public String getAuthRoyaume() {
		return authRoyaume;
	}

	public void setAuthRoyaume(String o) throws Exception {
		this.authRoyaume = o;
	}
	protected void authRoyaumeInit() throws Exception {
		if(!authRoyaumeCouverture.dejaInitialise) {
			_authRoyaume(authRoyaumeCouverture);
			if(authRoyaume == null)
				setAuthRoyaume(authRoyaumeCouverture.o);
		}
		authRoyaumeCouverture.dejaInitialise(true);
	}

	///////////////////
	// authRessource //
	///////////////////

	/**	L'entité « authRessource »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected String authRessource;
	public Couverture<String> authRessourceCouverture = new Couverture<String>().p(this).c(String.class).var("authRessource").o(authRessource);

	/**	L'entité « authRessource »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _authRessource(Couverture<String> o) throws Exception;

	public String getAuthRessource() {
		return authRessource;
	}

	public void setAuthRessource(String o) throws Exception {
		this.authRessource = o;
	}
	protected void authRessourceInit() throws Exception {
		if(!authRessourceCouverture.dejaInitialise) {
			_authRessource(authRessourceCouverture);
			if(authRessource == null)
				setAuthRessource(authRessourceCouverture.o);
		}
		authRessourceCouverture.dejaInitialise(true);
	}

	////////////////
	// authSecret //
	////////////////

	/**	L'entité « authSecret »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected String authSecret;
	public Couverture<String> authSecretCouverture = new Couverture<String>().p(this).c(String.class).var("authSecret").o(authSecret);

	/**	L'entité « authSecret »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _authSecret(Couverture<String> o) throws Exception;

	public String getAuthSecret() {
		return authSecret;
	}

	public void setAuthSecret(String o) throws Exception {
		this.authSecret = o;
	}
	protected void authSecretInit() throws Exception {
		if(!authSecretCouverture.dejaInitialise) {
			_authSecret(authSecretCouverture);
			if(authSecret == null)
				setAuthSecret(authSecretCouverture.o);
		}
		authSecretCouverture.dejaInitialise(true);
	}

	///////////////////
	// authSslRequis //
	///////////////////

	/**	L'entité « authSslRequis »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected String authSslRequis;
	public Couverture<String> authSslRequisCouverture = new Couverture<String>().p(this).c(String.class).var("authSslRequis").o(authSslRequis);

	/**	L'entité « authSslRequis »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _authSslRequis(Couverture<String> o) throws Exception;

	public String getAuthSslRequis() {
		return authSslRequis;
	}

	public void setAuthSslRequis(String o) throws Exception {
		this.authSslRequis = o;
	}
	protected void authSslRequisInit() throws Exception {
		if(!authSslRequisCouverture.dejaInitialise) {
			_authSslRequis(authSslRequisCouverture);
			if(authSslRequis == null)
				setAuthSslRequis(authSslRequisCouverture.o);
		}
		authSslRequisCouverture.dejaInitialise(true);
	}

	//////////////////
	// sslJksChemin //
	//////////////////

	/**	L'entité « sslJksChemin »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected String sslJksChemin;
	public Couverture<String> sslJksCheminCouverture = new Couverture<String>().p(this).c(String.class).var("sslJksChemin").o(sslJksChemin);

	/**	L'entité « sslJksChemin »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _sslJksChemin(Couverture<String> o) throws Exception;

	public String getSslJksChemin() {
		return sslJksChemin;
	}

	public void setSslJksChemin(String o) throws Exception {
		this.sslJksChemin = o;
	}
	protected void sslJksCheminInit() throws Exception {
		if(!sslJksCheminCouverture.dejaInitialise) {
			_sslJksChemin(sslJksCheminCouverture);
			if(sslJksChemin == null)
				setSslJksChemin(sslJksCheminCouverture.o);
		}
		sslJksCheminCouverture.dejaInitialise(true);
	}

	//////////////////////
	// sslJksMotDePasse //
	//////////////////////

	/**	L'entité « sslJksMotDePasse »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected String sslJksMotDePasse;
	public Couverture<String> sslJksMotDePasseCouverture = new Couverture<String>().p(this).c(String.class).var("sslJksMotDePasse").o(sslJksMotDePasse);

	/**	L'entité « sslJksMotDePasse »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _sslJksMotDePasse(Couverture<String> o) throws Exception;

	public String getSslJksMotDePasse() {
		return sslJksMotDePasse;
	}

	public void setSslJksMotDePasse(String o) throws Exception {
		this.sslJksMotDePasse = o;
	}
	protected void sslJksMotDePasseInit() throws Exception {
		if(!sslJksMotDePasseCouverture.dejaInitialise) {
			_sslJksMotDePasse(sslJksMotDePasseCouverture);
			if(sslJksMotDePasse == null)
				setSslJksMotDePasse(sslJksMotDePasseCouverture.o);
		}
		sslJksMotDePasseCouverture.dejaInitialise(true);
	}

	/////////////
	// authUrl //
	/////////////

	/**	L'entité « authUrl »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected String authUrl;
	public Couverture<String> authUrlCouverture = new Couverture<String>().p(this).c(String.class).var("authUrl").o(authUrl);

	/**	L'entité « authUrl »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _authUrl(Couverture<String> o) throws Exception;

	public String getAuthUrl() {
		return authUrl;
	}

	public void setAuthUrl(String o) throws Exception {
		this.authUrl = o;
	}
	protected void authUrlInit() throws Exception {
		if(!authUrlCouverture.dejaInitialise) {
			_authUrl(authUrlCouverture);
			if(authUrl == null)
				setAuthUrl(authUrlCouverture.o);
		}
		authUrlCouverture.dejaInitialise(true);
	}

	/////////////////
	// selCryptage //
	/////////////////

	/**	L'entité « selCryptage »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected String selCryptage;
	public Couverture<String> selCryptageCouverture = new Couverture<String>().p(this).c(String.class).var("selCryptage").o(selCryptage);

	/**	L'entité « selCryptage »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _selCryptage(Couverture<String> o) throws Exception;

	public String getSelCryptage() {
		return selCryptage;
	}

	public void setSelCryptage(String o) throws Exception {
		this.selCryptage = o;
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
	protected String motDePasseCryptage;
	public Couverture<String> motDePasseCryptageCouverture = new Couverture<String>().p(this).c(String.class).var("motDePasseCryptage").o(motDePasseCryptage);

	/**	L'entité « motDePasseCryptage »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _motDePasseCryptage(Couverture<String> o) throws Exception;

	public String getMotDePasseCryptage() {
		return motDePasseCryptage;
	}

	public void setMotDePasseCryptage(String o) throws Exception {
		this.motDePasseCryptage = o;
	}
	protected void motDePasseCryptageInit() throws Exception {
		if(!motDePasseCryptageCouverture.dejaInitialise) {
			_motDePasseCryptage(motDePasseCryptageCouverture);
			if(motDePasseCryptage == null)
				setMotDePasseCryptage(motDePasseCryptageCouverture.o);
		}
		motDePasseCryptageCouverture.dejaInitialise(true);
	}

	////////////////////
	// urlDomaineBase //
	////////////////////

	/**	L'entité « urlDomaineBase »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected String urlDomaineBase;
	public Couverture<String> urlDomaineBaseCouverture = new Couverture<String>().p(this).c(String.class).var("urlDomaineBase").o(urlDomaineBase);

	/**	L'entité « urlDomaineBase »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _urlDomaineBase(Couverture<String> o) throws Exception;

	public String getUrlDomaineBase() {
		return urlDomaineBase;
	}

	public void setUrlDomaineBase(String o) throws Exception {
		this.urlDomaineBase = o;
	}
	protected void urlDomaineBaseInit() throws Exception {
		if(!urlDomaineBaseCouverture.dejaInitialise) {
			_urlDomaineBase(urlDomaineBaseCouverture);
			if(urlDomaineBase == null)
				setUrlDomaineBase(urlDomaineBaseCouverture.o);
		}
		urlDomaineBaseCouverture.dejaInitialise(true);
	}

	//////////////////////
	// nomAffichageSite //
	//////////////////////

	/**	L'entité « nomAffichageSite »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected String nomAffichageSite;
	public Couverture<String> nomAffichageSiteCouverture = new Couverture<String>().p(this).c(String.class).var("nomAffichageSite").o(nomAffichageSite);

	/**	L'entité « nomAffichageSite »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _nomAffichageSite(Couverture<String> o) throws Exception;

	public String getNomAffichageSite() {
		return nomAffichageSite;
	}

	public void setNomAffichageSite(String o) throws Exception {
		this.nomAffichageSite = o;
	}
	protected void nomAffichageSiteInit() throws Exception {
		if(!nomAffichageSiteCouverture.dejaInitialise) {
			_nomAffichageSite(nomAffichageSiteCouverture);
			if(nomAffichageSite == null)
				setNomAffichageSite(nomAffichageSiteCouverture.o);
		}
		nomAffichageSiteCouverture.dejaInitialise(true);
	}

	//////////////////////
	// jdbcClassePilote //
	//////////////////////

	/**	L'entité « jdbcClassePilote »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected String jdbcClassePilote;
	public Couverture<String> jdbcClassePiloteCouverture = new Couverture<String>().p(this).c(String.class).var("jdbcClassePilote").o(jdbcClassePilote);

	/**	L'entité « jdbcClassePilote »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _jdbcClassePilote(Couverture<String> o) throws Exception;

	public String getJdbcClassePilote() {
		return jdbcClassePilote;
	}

	public void setJdbcClassePilote(String o) throws Exception {
		this.jdbcClassePilote = o;
	}
	protected void jdbcClassePiloteInit() throws Exception {
		if(!jdbcClassePiloteCouverture.dejaInitialise) {
			_jdbcClassePilote(jdbcClassePiloteCouverture);
			if(jdbcClassePilote == null)
				setJdbcClassePilote(jdbcClassePiloteCouverture.o);
		}
		jdbcClassePiloteCouverture.dejaInitialise(true);
	}

	/////////////////////
	// jdbcUtilisateur //
	/////////////////////

	/**	L'entité « jdbcUtilisateur »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected String jdbcUtilisateur;
	public Couverture<String> jdbcUtilisateurCouverture = new Couverture<String>().p(this).c(String.class).var("jdbcUtilisateur").o(jdbcUtilisateur);

	/**	L'entité « jdbcUtilisateur »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _jdbcUtilisateur(Couverture<String> o) throws Exception;

	public String getJdbcUtilisateur() {
		return jdbcUtilisateur;
	}

	public void setJdbcUtilisateur(String o) throws Exception {
		this.jdbcUtilisateur = o;
	}
	protected void jdbcUtilisateurInit() throws Exception {
		if(!jdbcUtilisateurCouverture.dejaInitialise) {
			_jdbcUtilisateur(jdbcUtilisateurCouverture);
			if(jdbcUtilisateur == null)
				setJdbcUtilisateur(jdbcUtilisateurCouverture.o);
		}
		jdbcUtilisateurCouverture.dejaInitialise(true);
	}

	////////////////////
	// jdbcMotDePasse //
	////////////////////

	/**	L'entité « jdbcMotDePasse »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected String jdbcMotDePasse;
	public Couverture<String> jdbcMotDePasseCouverture = new Couverture<String>().p(this).c(String.class).var("jdbcMotDePasse").o(jdbcMotDePasse);

	/**	L'entité « jdbcMotDePasse »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _jdbcMotDePasse(Couverture<String> o) throws Exception;

	public String getJdbcMotDePasse() {
		return jdbcMotDePasse;
	}

	public void setJdbcMotDePasse(String o) throws Exception {
		this.jdbcMotDePasse = o;
	}
	protected void jdbcMotDePasseInit() throws Exception {
		if(!jdbcMotDePasseCouverture.dejaInitialise) {
			_jdbcMotDePasse(jdbcMotDePasseCouverture);
			if(jdbcMotDePasse == null)
				setJdbcMotDePasse(jdbcMotDePasseCouverture.o);
		}
		jdbcMotDePasseCouverture.dejaInitialise(true);
	}

	//////////////////////////
	// jdbcTailleMaxPiscine //
	//////////////////////////

	/**	L'entité « jdbcTailleMaxPiscine »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected Integer jdbcTailleMaxPiscine;
	public Couverture<Integer> jdbcTailleMaxPiscineCouverture = new Couverture<Integer>().p(this).c(Integer.class).var("jdbcTailleMaxPiscine").o(jdbcTailleMaxPiscine);

	/**	L'entité « jdbcTailleMaxPiscine »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _jdbcTailleMaxPiscine(Couverture<Integer> o) throws Exception;

	public Integer getJdbcTailleMaxPiscine() {
		return jdbcTailleMaxPiscine;
	}

	public void setJdbcTailleMaxPiscine(Integer o) throws Exception {
		this.jdbcTailleMaxPiscine = o;
	}
	public ConfigSite setJdbcTailleMaxPiscine(String o) throws Exception {
		if(org.apache.commons.lang3.math.NumberUtils.isCreatable(o))
			this.jdbcTailleMaxPiscine = Integer.parseInt(o);
		return (ConfigSite)this;
	}
	protected void jdbcTailleMaxPiscineInit() throws Exception {
		if(!jdbcTailleMaxPiscineCouverture.dejaInitialise) {
			_jdbcTailleMaxPiscine(jdbcTailleMaxPiscineCouverture);
			if(jdbcTailleMaxPiscine == null)
				setJdbcTailleMaxPiscine(jdbcTailleMaxPiscineCouverture.o);
		}
		jdbcTailleMaxPiscineCouverture.dejaInitialise(true);
	}

	///////////////////////////////
	// jdbcTailleInitialePiscine //
	///////////////////////////////

	/**	L'entité « jdbcTailleInitialePiscine »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected Integer jdbcTailleInitialePiscine;
	public Couverture<Integer> jdbcTailleInitialePiscineCouverture = new Couverture<Integer>().p(this).c(Integer.class).var("jdbcTailleInitialePiscine").o(jdbcTailleInitialePiscine);

	/**	L'entité « jdbcTailleInitialePiscine »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _jdbcTailleInitialePiscine(Couverture<Integer> o) throws Exception;

	public Integer getJdbcTailleInitialePiscine() {
		return jdbcTailleInitialePiscine;
	}

	public void setJdbcTailleInitialePiscine(Integer o) throws Exception {
		this.jdbcTailleInitialePiscine = o;
	}
	public ConfigSite setJdbcTailleInitialePiscine(String o) throws Exception {
		if(org.apache.commons.lang3.math.NumberUtils.isCreatable(o))
			this.jdbcTailleInitialePiscine = Integer.parseInt(o);
		return (ConfigSite)this;
	}
	protected void jdbcTailleInitialePiscineInit() throws Exception {
		if(!jdbcTailleInitialePiscineCouverture.dejaInitialise) {
			_jdbcTailleInitialePiscine(jdbcTailleInitialePiscineCouverture);
			if(jdbcTailleInitialePiscine == null)
				setJdbcTailleInitialePiscine(jdbcTailleInitialePiscineCouverture.o);
		}
		jdbcTailleInitialePiscineCouverture.dejaInitialise(true);
	}

	//////////////////////////
	// jdbcTailleMinPiscine //
	//////////////////////////

	/**	L'entité « jdbcTailleMinPiscine »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected Integer jdbcTailleMinPiscine;
	public Couverture<Integer> jdbcTailleMinPiscineCouverture = new Couverture<Integer>().p(this).c(Integer.class).var("jdbcTailleMinPiscine").o(jdbcTailleMinPiscine);

	/**	L'entité « jdbcTailleMinPiscine »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _jdbcTailleMinPiscine(Couverture<Integer> o) throws Exception;

	public Integer getJdbcTailleMinPiscine() {
		return jdbcTailleMinPiscine;
	}

	public void setJdbcTailleMinPiscine(Integer o) throws Exception {
		this.jdbcTailleMinPiscine = o;
	}
	public ConfigSite setJdbcTailleMinPiscine(String o) throws Exception {
		if(org.apache.commons.lang3.math.NumberUtils.isCreatable(o))
			this.jdbcTailleMinPiscine = Integer.parseInt(o);
		return (ConfigSite)this;
	}
	protected void jdbcTailleMinPiscineInit() throws Exception {
		if(!jdbcTailleMinPiscineCouverture.dejaInitialise) {
			_jdbcTailleMinPiscine(jdbcTailleMinPiscineCouverture);
			if(jdbcTailleMinPiscine == null)
				setJdbcTailleMinPiscine(jdbcTailleMinPiscineCouverture.o);
		}
		jdbcTailleMinPiscineCouverture.dejaInitialise(true);
	}

	/////////////////////////
	// jdbcMaxDeclarations //
	/////////////////////////

	/**	L'entité « jdbcMaxDeclarations »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected Integer jdbcMaxDeclarations;
	public Couverture<Integer> jdbcMaxDeclarationsCouverture = new Couverture<Integer>().p(this).c(Integer.class).var("jdbcMaxDeclarations").o(jdbcMaxDeclarations);

	/**	L'entité « jdbcMaxDeclarations »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _jdbcMaxDeclarations(Couverture<Integer> o) throws Exception;

	public Integer getJdbcMaxDeclarations() {
		return jdbcMaxDeclarations;
	}

	public void setJdbcMaxDeclarations(Integer o) throws Exception {
		this.jdbcMaxDeclarations = o;
	}
	public ConfigSite setJdbcMaxDeclarations(String o) throws Exception {
		if(org.apache.commons.lang3.math.NumberUtils.isCreatable(o))
			this.jdbcMaxDeclarations = Integer.parseInt(o);
		return (ConfigSite)this;
	}
	protected void jdbcMaxDeclarationsInit() throws Exception {
		if(!jdbcMaxDeclarationsCouverture.dejaInitialise) {
			_jdbcMaxDeclarations(jdbcMaxDeclarationsCouverture);
			if(jdbcMaxDeclarations == null)
				setJdbcMaxDeclarations(jdbcMaxDeclarationsCouverture.o);
		}
		jdbcMaxDeclarationsCouverture.dejaInitialise(true);
	}

	/////////////////////////////////////
	// jdbcMaxDeclarationsParConnexion //
	/////////////////////////////////////

	/**	L'entité « jdbcMaxDeclarationsParConnexion »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected Integer jdbcMaxDeclarationsParConnexion;
	public Couverture<Integer> jdbcMaxDeclarationsParConnexionCouverture = new Couverture<Integer>().p(this).c(Integer.class).var("jdbcMaxDeclarationsParConnexion").o(jdbcMaxDeclarationsParConnexion);

	/**	L'entité « jdbcMaxDeclarationsParConnexion »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _jdbcMaxDeclarationsParConnexion(Couverture<Integer> o) throws Exception;

	public Integer getJdbcMaxDeclarationsParConnexion() {
		return jdbcMaxDeclarationsParConnexion;
	}

	public void setJdbcMaxDeclarationsParConnexion(Integer o) throws Exception {
		this.jdbcMaxDeclarationsParConnexion = o;
	}
	public ConfigSite setJdbcMaxDeclarationsParConnexion(String o) throws Exception {
		if(org.apache.commons.lang3.math.NumberUtils.isCreatable(o))
			this.jdbcMaxDeclarationsParConnexion = Integer.parseInt(o);
		return (ConfigSite)this;
	}
	protected void jdbcMaxDeclarationsParConnexionInit() throws Exception {
		if(!jdbcMaxDeclarationsParConnexionCouverture.dejaInitialise) {
			_jdbcMaxDeclarationsParConnexion(jdbcMaxDeclarationsParConnexionCouverture);
			if(jdbcMaxDeclarationsParConnexion == null)
				setJdbcMaxDeclarationsParConnexion(jdbcMaxDeclarationsParConnexionCouverture.o);
		}
		jdbcMaxDeclarationsParConnexionCouverture.dejaInitialise(true);
	}

	////////////////////////////
	// jdbcTempsInactiviteMax //
	////////////////////////////

	/**	L'entité « jdbcTempsInactiviteMax »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected Integer jdbcTempsInactiviteMax;
	public Couverture<Integer> jdbcTempsInactiviteMaxCouverture = new Couverture<Integer>().p(this).c(Integer.class).var("jdbcTempsInactiviteMax").o(jdbcTempsInactiviteMax);

	/**	L'entité « jdbcTempsInactiviteMax »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _jdbcTempsInactiviteMax(Couverture<Integer> o) throws Exception;

	public Integer getJdbcTempsInactiviteMax() {
		return jdbcTempsInactiviteMax;
	}

	public void setJdbcTempsInactiviteMax(Integer o) throws Exception {
		this.jdbcTempsInactiviteMax = o;
	}
	public ConfigSite setJdbcTempsInactiviteMax(String o) throws Exception {
		if(org.apache.commons.lang3.math.NumberUtils.isCreatable(o))
			this.jdbcTempsInactiviteMax = Integer.parseInt(o);
		return (ConfigSite)this;
	}
	protected void jdbcTempsInactiviteMaxInit() throws Exception {
		if(!jdbcTempsInactiviteMaxCouverture.dejaInitialise) {
			_jdbcTempsInactiviteMax(jdbcTempsInactiviteMaxCouverture);
			if(jdbcTempsInactiviteMax == null)
				setJdbcTempsInactiviteMax(jdbcTempsInactiviteMaxCouverture.o);
		}
		jdbcTempsInactiviteMaxCouverture.dejaInitialise(true);
	}

	/////////////
	// jdbcUrl //
	/////////////

	/**	L'entité « jdbcUrl »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected String jdbcUrl;
	public Couverture<String> jdbcUrlCouverture = new Couverture<String>().p(this).c(String.class).var("jdbcUrl").o(jdbcUrl);

	/**	L'entité « jdbcUrl »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _jdbcUrl(Couverture<String> o) throws Exception;

	public String getJdbcUrl() {
		return jdbcUrl;
	}

	public void setJdbcUrl(String o) throws Exception {
		this.jdbcUrl = o;
	}
	protected void jdbcUrlInit() throws Exception {
		if(!jdbcUrlCouverture.dejaInitialise) {
			_jdbcUrl(jdbcUrlCouverture);
			if(jdbcUrl == null)
				setJdbcUrl(jdbcUrlCouverture.o);
		}
		jdbcUrlCouverture.dejaInitialise(true);
	}

	/////////////
	// solrUrl //
	/////////////

	/**	L'entité « solrUrl »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected String solrUrl;
	public Couverture<String> solrUrlCouverture = new Couverture<String>().p(this).c(String.class).var("solrUrl").o(solrUrl);

	/**	L'entité « solrUrl »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _solrUrl(Couverture<String> o) throws Exception;

	public String getSolrUrl() {
		return solrUrl;
	}

	public void setSolrUrl(String o) throws Exception {
		this.solrUrl = o;
	}
	protected void solrUrlInit() throws Exception {
		if(!solrUrlCouverture.dejaInitialise) {
			_solrUrl(solrUrlCouverture);
			if(solrUrl == null)
				setSolrUrl(solrUrlCouverture.o);
		}
		solrUrlCouverture.dejaInitialise(true);
	}

	/////////////////////////
	// jetonIdentitePaypal //
	/////////////////////////

	/**	L'entité « jetonIdentitePaypal »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected String jetonIdentitePaypal;
	public Couverture<String> jetonIdentitePaypalCouverture = new Couverture<String>().p(this).c(String.class).var("jetonIdentitePaypal").o(jetonIdentitePaypal);

	/**	L'entité « jetonIdentitePaypal »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _jetonIdentitePaypal(Couverture<String> o) throws Exception;

	public String getJetonIdentitePaypal() {
		return jetonIdentitePaypal;
	}

	public void setJetonIdentitePaypal(String o) throws Exception {
		this.jetonIdentitePaypal = o;
	}
	protected void jetonIdentitePaypalInit() throws Exception {
		if(!jetonIdentitePaypalCouverture.dejaInitialise) {
			_jetonIdentitePaypal(jetonIdentitePaypalCouverture);
			if(jetonIdentitePaypal == null)
				setJetonIdentitePaypal(jetonIdentitePaypalCouverture.o);
		}
		jetonIdentitePaypalCouverture.dejaInitialise(true);
	}

	////////////////////
	// compteFacebook //
	////////////////////

	/**	L'entité « compteFacebook »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected String compteFacebook;
	public Couverture<String> compteFacebookCouverture = new Couverture<String>().p(this).c(String.class).var("compteFacebook").o(compteFacebook);

	/**	L'entité « compteFacebook »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _compteFacebook(Couverture<String> o) throws Exception;

	public String getCompteFacebook() {
		return compteFacebook;
	}

	public void setCompteFacebook(String o) throws Exception {
		this.compteFacebook = o;
	}
	protected void compteFacebookInit() throws Exception {
		if(!compteFacebookCouverture.dejaInitialise) {
			_compteFacebook(compteFacebookCouverture);
			if(compteFacebook == null)
				setCompteFacebook(compteFacebookCouverture.o);
		}
		compteFacebookCouverture.dejaInitialise(true);
	}

	///////////////////
	// compteTwitter //
	///////////////////

	/**	L'entité « compteTwitter »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected String compteTwitter;
	public Couverture<String> compteTwitterCouverture = new Couverture<String>().p(this).c(String.class).var("compteTwitter").o(compteTwitter);

	/**	L'entité « compteTwitter »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _compteTwitter(Couverture<String> o) throws Exception;

	public String getCompteTwitter() {
		return compteTwitter;
	}

	public void setCompteTwitter(String o) throws Exception {
		this.compteTwitter = o;
	}
	protected void compteTwitterInit() throws Exception {
		if(!compteTwitterCouverture.dejaInitialise) {
			_compteTwitter(compteTwitterCouverture);
			if(compteTwitter == null)
				setCompteTwitter(compteTwitterCouverture.o);
		}
		compteTwitterCouverture.dejaInitialise(true);
	}

	//////////////////////
	// compteGooglePlus //
	//////////////////////

	/**	L'entité « compteGooglePlus »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected String compteGooglePlus;
	public Couverture<String> compteGooglePlusCouverture = new Couverture<String>().p(this).c(String.class).var("compteGooglePlus").o(compteGooglePlus);

	/**	L'entité « compteGooglePlus »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _compteGooglePlus(Couverture<String> o) throws Exception;

	public String getCompteGooglePlus() {
		return compteGooglePlus;
	}

	public void setCompteGooglePlus(String o) throws Exception {
		this.compteGooglePlus = o;
	}
	protected void compteGooglePlusInit() throws Exception {
		if(!compteGooglePlusCouverture.dejaInitialise) {
			_compteGooglePlus(compteGooglePlusCouverture);
			if(compteGooglePlus == null)
				setCompteGooglePlus(compteGooglePlusCouverture.o);
		}
		compteGooglePlusCouverture.dejaInitialise(true);
	}

	/////////////////////
	// compteInstagram //
	/////////////////////

	/**	L'entité « compteInstagram »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected String compteInstagram;
	public Couverture<String> compteInstagramCouverture = new Couverture<String>().p(this).c(String.class).var("compteInstagram").o(compteInstagram);

	/**	L'entité « compteInstagram »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _compteInstagram(Couverture<String> o) throws Exception;

	public String getCompteInstagram() {
		return compteInstagram;
	}

	public void setCompteInstagram(String o) throws Exception {
		this.compteInstagram = o;
	}
	protected void compteInstagramInit() throws Exception {
		if(!compteInstagramCouverture.dejaInitialise) {
			_compteInstagram(compteInstagramCouverture);
			if(compteInstagram == null)
				setCompteInstagram(compteInstagramCouverture.o);
		}
		compteInstagramCouverture.dejaInitialise(true);
	}

	///////////////////
	// compteYoutube //
	///////////////////

	/**	L'entité « compteYoutube »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected String compteYoutube;
	public Couverture<String> compteYoutubeCouverture = new Couverture<String>().p(this).c(String.class).var("compteYoutube").o(compteYoutube);

	/**	L'entité « compteYoutube »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _compteYoutube(Couverture<String> o) throws Exception;

	public String getCompteYoutube() {
		return compteYoutube;
	}

	public void setCompteYoutube(String o) throws Exception {
		this.compteYoutube = o;
	}
	protected void compteYoutubeInit() throws Exception {
		if(!compteYoutubeCouverture.dejaInitialise) {
			_compteYoutube(compteYoutubeCouverture);
			if(compteYoutube == null)
				setCompteYoutube(compteYoutubeCouverture.o);
		}
		compteYoutubeCouverture.dejaInitialise(true);
	}

	/////////////////////////////
	// identifiantCanalYoutube //
	/////////////////////////////

	/**	L'entité « identifiantCanalYoutube »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected String identifiantCanalYoutube;
	public Couverture<String> identifiantCanalYoutubeCouverture = new Couverture<String>().p(this).c(String.class).var("identifiantCanalYoutube").o(identifiantCanalYoutube);

	/**	L'entité « identifiantCanalYoutube »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _identifiantCanalYoutube(Couverture<String> o) throws Exception;

	public String getIdentifiantCanalYoutube() {
		return identifiantCanalYoutube;
	}

	public void setIdentifiantCanalYoutube(String o) throws Exception {
		this.identifiantCanalYoutube = o;
	}
	protected void identifiantCanalYoutubeInit() throws Exception {
		if(!identifiantCanalYoutubeCouverture.dejaInitialise) {
			_identifiantCanalYoutube(identifiantCanalYoutubeCouverture);
			if(identifiantCanalYoutube == null)
				setIdentifiantCanalYoutube(identifiantCanalYoutubeCouverture.o);
		}
		identifiantCanalYoutubeCouverture.dejaInitialise(true);
	}

	/////////////////////
	// comptePinterest //
	/////////////////////

	/**	L'entité « comptePinterest »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected String comptePinterest;
	public Couverture<String> comptePinterestCouverture = new Couverture<String>().p(this).c(String.class).var("comptePinterest").o(comptePinterest);

	/**	L'entité « comptePinterest »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _comptePinterest(Couverture<String> o) throws Exception;

	public String getComptePinterest() {
		return comptePinterest;
	}

	public void setComptePinterest(String o) throws Exception {
		this.comptePinterest = o;
	}
	protected void comptePinterestInit() throws Exception {
		if(!comptePinterestCouverture.dejaInitialise) {
			_comptePinterest(comptePinterestCouverture);
			if(comptePinterest == null)
				setComptePinterest(comptePinterestCouverture.o);
		}
		comptePinterestCouverture.dejaInitialise(true);
	}

	///////////////////////
	// compteOpenclipart //
	///////////////////////

	/**	L'entité « compteOpenclipart »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected String compteOpenclipart;
	public Couverture<String> compteOpenclipartCouverture = new Couverture<String>().p(this).c(String.class).var("compteOpenclipart").o(compteOpenclipart);

	/**	L'entité « compteOpenclipart »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _compteOpenclipart(Couverture<String> o) throws Exception;

	public String getCompteOpenclipart() {
		return compteOpenclipart;
	}

	public void setCompteOpenclipart(String o) throws Exception {
		this.compteOpenclipart = o;
	}
	protected void compteOpenclipartInit() throws Exception {
		if(!compteOpenclipartCouverture.dejaInitialise) {
			_compteOpenclipart(compteOpenclipartCouverture);
			if(compteOpenclipart == null)
				setCompteOpenclipart(compteOpenclipartCouverture.o);
		}
		compteOpenclipartCouverture.dejaInitialise(true);
	}

	////////////////
	// compteMail //
	////////////////

	/**	L'entité « compteMail »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected String compteMail;
	public Couverture<String> compteMailCouverture = new Couverture<String>().p(this).c(String.class).var("compteMail").o(compteMail);

	/**	L'entité « compteMail »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _compteMail(Couverture<String> o) throws Exception;

	public String getCompteMail() {
		return compteMail;
	}

	public void setCompteMail(String o) throws Exception {
		this.compteMail = o;
	}
	protected void compteMailInit() throws Exception {
		if(!compteMailCouverture.dejaInitialise) {
			_compteMail(compteMailCouverture);
			if(compteMail == null)
				setCompteMail(compteMailCouverture.o);
		}
		compteMailCouverture.dejaInitialise(true);
	}

	///////////////
	// mailAdmin //
	///////////////

	/**	L'entité « mailAdmin »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected String mailAdmin;
	public Couverture<String> mailAdminCouverture = new Couverture<String>().p(this).c(String.class).var("mailAdmin").o(mailAdmin);

	/**	L'entité « mailAdmin »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _mailAdmin(Couverture<String> o) throws Exception;

	public String getMailAdmin() {
		return mailAdmin;
	}

	public void setMailAdmin(String o) throws Exception {
		this.mailAdmin = o;
	}
	protected void mailAdminInit() throws Exception {
		if(!mailAdminCouverture.dejaInitialise) {
			_mailAdmin(mailAdminCouverture);
			if(mailAdmin == null)
				setMailAdmin(mailAdminCouverture.o);
		}
		mailAdminCouverture.dejaInitialise(true);
	}

	//////////////////////
	// nombreExecuteurs //
	//////////////////////

	/**	L'entité « nombreExecuteurs »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected Integer nombreExecuteurs;
	public Couverture<Integer> nombreExecuteursCouverture = new Couverture<Integer>().p(this).c(Integer.class).var("nombreExecuteurs").o(nombreExecuteurs);

	/**	L'entité « nombreExecuteurs »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _nombreExecuteurs(Couverture<Integer> o) throws Exception;

	public Integer getNombreExecuteurs() {
		return nombreExecuteurs;
	}

	public void setNombreExecuteurs(Integer o) throws Exception {
		this.nombreExecuteurs = o;
	}
	public ConfigSite setNombreExecuteurs(String o) throws Exception {
		if(org.apache.commons.lang3.math.NumberUtils.isCreatable(o))
			this.nombreExecuteurs = Integer.parseInt(o);
		return (ConfigSite)this;
	}
	protected void nombreExecuteursInit() throws Exception {
		if(!nombreExecuteursCouverture.dejaInitialise) {
			_nombreExecuteurs(nombreExecuteursCouverture);
			if(nombreExecuteurs == null)
				setNombreExecuteurs(nombreExecuteursCouverture.o);
		}
		nombreExecuteursCouverture.dejaInitialise(true);
	}

	/////////////////////
	// initialiserLoin //
	/////////////////////

	protected boolean dejaInitialiseConfigSite = false;

	public void initLoinConfigSite(RequeteSite requeteSite) throws Exception {
		setRequeteSite_(requeteSite);
		initLoinConfigSite();
	}

	public void initLoinConfigSite() throws Exception {
		if(!dejaInitialiseConfigSite) {
			requeteSite_Init();
			siteContexte_Init();
			cheminConfigInit();
			configInit();
			identifiantSiteInit();
			prefixeEchappeInit();
			cheminProjetInit();
			racineDocumentInit();
			nomEntrepriseInit();
			nomDomaineInit();
			siteNomHoteInit();
			sitePortInit();
			authRoyaumeInit();
			authRessourceInit();
			authSecretInit();
			authSslRequisInit();
			sslJksCheminInit();
			sslJksMotDePasseInit();
			authUrlInit();
			selCryptageInit();
			motDePasseCryptageInit();
			urlDomaineBaseInit();
			nomAffichageSiteInit();
			jdbcClassePiloteInit();
			jdbcUtilisateurInit();
			jdbcMotDePasseInit();
			jdbcTailleMaxPiscineInit();
			jdbcTailleInitialePiscineInit();
			jdbcTailleMinPiscineInit();
			jdbcMaxDeclarationsInit();
			jdbcMaxDeclarationsParConnexionInit();
			jdbcTempsInactiviteMaxInit();
			jdbcUrlInit();
			solrUrlInit();
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

	/////////////////
	// requeteSite //
	/////////////////

	public void requeteSiteConfigSite(RequeteSite requeteSite) throws Exception {
	}

	public void requeteSitePourClasse(RequeteSite requeteSite) throws Exception {
		requeteSiteConfigSite(requeteSite);
	}

	/////////////
	// obtenir //
	/////////////

	public Object obtenirPourClasse(String var) throws Exception {
		String[] vars = org.apache.commons.lang3.StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtenirConfigSite(v);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.obtenirPourClasse(v);
			}
		}
		return o;
	}
	public Object obtenirConfigSite(String var) throws Exception {
		ConfigSite oConfigSite = (ConfigSite)this;
		switch(var) {
			case "requeteSite_":
				return oConfigSite.requeteSite_;
			case "siteContexte_":
				return oConfigSite.siteContexte_;
			case "cheminConfig":
				return oConfigSite.cheminConfig;
			case "config":
				return oConfigSite.config;
			case "identifiantSite":
				return oConfigSite.identifiantSite;
			case "prefixeEchappe":
				return oConfigSite.prefixeEchappe;
			case "cheminProjet":
				return oConfigSite.cheminProjet;
			case "racineDocument":
				return oConfigSite.racineDocument;
			case "nomEntreprise":
				return oConfigSite.nomEntreprise;
			case "nomDomaine":
				return oConfigSite.nomDomaine;
			case "siteNomHote":
				return oConfigSite.siteNomHote;
			case "sitePort":
				return oConfigSite.sitePort;
			case "authRoyaume":
				return oConfigSite.authRoyaume;
			case "authRessource":
				return oConfigSite.authRessource;
			case "authSecret":
				return oConfigSite.authSecret;
			case "authSslRequis":
				return oConfigSite.authSslRequis;
			case "sslJksChemin":
				return oConfigSite.sslJksChemin;
			case "sslJksMotDePasse":
				return oConfigSite.sslJksMotDePasse;
			case "authUrl":
				return oConfigSite.authUrl;
			case "selCryptage":
				return oConfigSite.selCryptage;
			case "motDePasseCryptage":
				return oConfigSite.motDePasseCryptage;
			case "urlDomaineBase":
				return oConfigSite.urlDomaineBase;
			case "nomAffichageSite":
				return oConfigSite.nomAffichageSite;
			case "jdbcClassePilote":
				return oConfigSite.jdbcClassePilote;
			case "jdbcUtilisateur":
				return oConfigSite.jdbcUtilisateur;
			case "jdbcMotDePasse":
				return oConfigSite.jdbcMotDePasse;
			case "jdbcTailleMaxPiscine":
				return oConfigSite.jdbcTailleMaxPiscine;
			case "jdbcTailleInitialePiscine":
				return oConfigSite.jdbcTailleInitialePiscine;
			case "jdbcTailleMinPiscine":
				return oConfigSite.jdbcTailleMinPiscine;
			case "jdbcMaxDeclarations":
				return oConfigSite.jdbcMaxDeclarations;
			case "jdbcMaxDeclarationsParConnexion":
				return oConfigSite.jdbcMaxDeclarationsParConnexion;
			case "jdbcTempsInactiviteMax":
				return oConfigSite.jdbcTempsInactiviteMax;
			case "jdbcUrl":
				return oConfigSite.jdbcUrl;
			case "solrUrl":
				return oConfigSite.solrUrl;
			case "jetonIdentitePaypal":
				return oConfigSite.jetonIdentitePaypal;
			case "compteFacebook":
				return oConfigSite.compteFacebook;
			case "compteTwitter":
				return oConfigSite.compteTwitter;
			case "compteGooglePlus":
				return oConfigSite.compteGooglePlus;
			case "compteInstagram":
				return oConfigSite.compteInstagram;
			case "compteYoutube":
				return oConfigSite.compteYoutube;
			case "identifiantCanalYoutube":
				return oConfigSite.identifiantCanalYoutube;
			case "comptePinterest":
				return oConfigSite.comptePinterest;
			case "compteOpenclipart":
				return oConfigSite.compteOpenclipart;
			case "compteMail":
				return oConfigSite.compteMail;
			case "mailAdmin":
				return oConfigSite.mailAdmin;
			case "nombreExecuteurs":
				return oConfigSite.nombreExecuteurs;
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
				o = attribuerConfigSite(v, val);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.attribuerPourClasse(v, val);
			}
		}
		return o != null;
	}
	public Object attribuerConfigSite(String var, Object val) throws Exception {
		ConfigSite oConfigSite = (ConfigSite)this;
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
					o = definirConfigSite(v, val);
				else if(o instanceof Cluster) {
					Cluster cluster = (Cluster)o;
					o = cluster.definirPourClasse(v, val);
				}
			}
		}
		return o != null;
	}
	public Object definirConfigSite(String var, String val) throws Exception {
		ConfigSite oConfigSite = (ConfigSite)this;
		switch(var) {
			case "cheminConfig":
				oConfigSite.setCheminConfig(val);
				return val;
			case "identifiantSite":
				oConfigSite.setIdentifiantSite(val);
				return val;
			case "prefixeEchappe":
				oConfigSite.setPrefixeEchappe(val);
				return val;
			case "cheminProjet":
				oConfigSite.setCheminProjet(val);
				return val;
			case "racineDocument":
				oConfigSite.setRacineDocument(val);
				return val;
			case "nomEntreprise":
				oConfigSite.setNomEntreprise(val);
				return val;
			case "nomDomaine":
				oConfigSite.setNomDomaine(val);
				return val;
			case "siteNomHote":
				oConfigSite.setSiteNomHote(val);
				return val;
			case "sitePort":
				oConfigSite.setSitePort(val);
				return val;
			case "authRoyaume":
				oConfigSite.setAuthRoyaume(val);
				return val;
			case "authRessource":
				oConfigSite.setAuthRessource(val);
				return val;
			case "authSecret":
				oConfigSite.setAuthSecret(val);
				return val;
			case "authSslRequis":
				oConfigSite.setAuthSslRequis(val);
				return val;
			case "sslJksChemin":
				oConfigSite.setSslJksChemin(val);
				return val;
			case "sslJksMotDePasse":
				oConfigSite.setSslJksMotDePasse(val);
				return val;
			case "authUrl":
				oConfigSite.setAuthUrl(val);
				return val;
			case "selCryptage":
				oConfigSite.setSelCryptage(val);
				return val;
			case "motDePasseCryptage":
				oConfigSite.setMotDePasseCryptage(val);
				return val;
			case "urlDomaineBase":
				oConfigSite.setUrlDomaineBase(val);
				return val;
			case "nomAffichageSite":
				oConfigSite.setNomAffichageSite(val);
				return val;
			case "jdbcClassePilote":
				oConfigSite.setJdbcClassePilote(val);
				return val;
			case "jdbcUtilisateur":
				oConfigSite.setJdbcUtilisateur(val);
				return val;
			case "jdbcMotDePasse":
				oConfigSite.setJdbcMotDePasse(val);
				return val;
			case "jdbcTailleMaxPiscine":
				oConfigSite.setJdbcTailleMaxPiscine(val);
				return val;
			case "jdbcTailleInitialePiscine":
				oConfigSite.setJdbcTailleInitialePiscine(val);
				return val;
			case "jdbcTailleMinPiscine":
				oConfigSite.setJdbcTailleMinPiscine(val);
				return val;
			case "jdbcMaxDeclarations":
				oConfigSite.setJdbcMaxDeclarations(val);
				return val;
			case "jdbcMaxDeclarationsParConnexion":
				oConfigSite.setJdbcMaxDeclarationsParConnexion(val);
				return val;
			case "jdbcTempsInactiviteMax":
				oConfigSite.setJdbcTempsInactiviteMax(val);
				return val;
			case "jdbcUrl":
				oConfigSite.setJdbcUrl(val);
				return val;
			case "solrUrl":
				oConfigSite.setSolrUrl(val);
				return val;
			case "jetonIdentitePaypal":
				oConfigSite.setJetonIdentitePaypal(val);
				return val;
			case "compteFacebook":
				oConfigSite.setCompteFacebook(val);
				return val;
			case "compteTwitter":
				oConfigSite.setCompteTwitter(val);
				return val;
			case "compteGooglePlus":
				oConfigSite.setCompteGooglePlus(val);
				return val;
			case "compteInstagram":
				oConfigSite.setCompteInstagram(val);
				return val;
			case "compteYoutube":
				oConfigSite.setCompteYoutube(val);
				return val;
			case "identifiantCanalYoutube":
				oConfigSite.setIdentifiantCanalYoutube(val);
				return val;
			case "comptePinterest":
				oConfigSite.setComptePinterest(val);
				return val;
			case "compteOpenclipart":
				oConfigSite.setCompteOpenclipart(val);
				return val;
			case "compteMail":
				oConfigSite.setCompteMail(val);
				return val;
			case "mailAdmin":
				oConfigSite.setMailAdmin(val);
				return val;
			case "nombreExecuteurs":
				oConfigSite.setNombreExecuteurs(val);
				return val;
			default:
				return null;
		}
	}
}
