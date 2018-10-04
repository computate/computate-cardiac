package com.heytate.frFR.cardiaque.requete;

import java.io.PrintWriter;
import com.heytate.frFR.cardiaque.config.ConfigSite;
import com.heytate.frFR.cardiaque.contexte.EcouteurContexte;
import java.security.MessageDigest;
import com.heytate.frFR.cardiaque.requete.RequeteSite;
import javax.servlet.http.HttpServletResponse;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.Cipher;
import java.util.Stack;
import java.util.HashSet;
import java.security.SecureRandom;
import org.apache.solr.common.SolrDocument;
import javax.servlet.http.HttpServletRequest;
import com.heytate.frFR.cardiaque.utilisateur.UtilisateurSite;
import org.keycloak.representations.AccessToken;
import java.lang.Boolean;
import java.lang.String;
import com.heytate.frFR.cardiaque.couverture.Couverture;

public abstract class RequeteSiteGen<DEV> extends Object {

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

	public RequeteSite requeteSite(RequeteSite o) throws Exception {
		setRequeteSite(o);
		return (RequeteSite)this;
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

	////////////////
	// configSite //
	////////////////

	/**	L'entité « configSite »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public ConfigSite configSite;
	public Couverture<ConfigSite> configSiteCouverture = new Couverture<ConfigSite>().p(this).c(ConfigSite.class).var("configSite").o(configSite);

	/**	L'entité « configSite »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _configSite(Couverture<ConfigSite> o) throws Exception;

	public RequeteSite configSite(ConfigSite o) throws Exception {
		setConfigSite(o);
		return (RequeteSite)this;
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
			_configSite(configSiteCouverture);
			if(configSite == null)
				configSite(configSiteCouverture.o);
		}
		configSiteCouverture.dejaInitialise(true);
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

	public RequeteSite ecouteurContexte(EcouteurContexte o) throws Exception {
		setEcouteurContexte(o);
		return (RequeteSite)this;
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
		ecouteurContexteCouverture.dejaInitialise(true);
	}

	////////////////
	// jetonAcces //
	////////////////

	/**	L'entité « jetonAcces »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public AccessToken jetonAcces;
	public Couverture<AccessToken> jetonAccesCouverture = new Couverture<AccessToken>().p(this).c(AccessToken.class).var("jetonAcces").o(jetonAcces);

	/**	L'entité « jetonAcces »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _jetonAcces(Couverture<AccessToken> o) throws Exception;

	public RequeteSite jetonAcces(AccessToken o) throws Exception {
		setJetonAcces(o);
		return (RequeteSite)this;
	}

	public void setJetonAcces(AccessToken o) throws Exception {
		this.jetonAcces = o;
	}

	public AccessToken jetonAcces() throws Exception {
		return getJetonAcces();
	}

	public AccessToken getJetonAcces() throws Exception {
		return jetonAcces;
	}
	protected void jetonAccesInit() throws Exception {
		if(!jetonAccesCouverture.dejaInitialise) {
			_jetonAcces(jetonAccesCouverture);
			if(jetonAcces == null)
				jetonAcces(jetonAccesCouverture.o);
		}
		jetonAccesCouverture.dejaInitialise(true);
	}

	///////////////////////////
	// utilisateurNomDomaine //
	///////////////////////////

	/**	L'entité « utilisateurNomDomaine »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public String utilisateurNomDomaine;
	public Couverture<String> utilisateurNomDomaineCouverture = new Couverture<String>().p(this).c(String.class).var("utilisateurNomDomaine").o(utilisateurNomDomaine);

	/**	L'entité « utilisateurNomDomaine »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _utilisateurNomDomaine(Couverture<String> o) throws Exception;

	public RequeteSite utilisateurNomDomaine(String o) throws Exception {
		setUtilisateurNomDomaine(o);
		return (RequeteSite)this;
	}

	public void setUtilisateurNomDomaine(String o) throws Exception {
		this.utilisateurNomDomaine = o;
	}

	public String utilisateurNomDomaine() throws Exception {
		return getUtilisateurNomDomaine();
	}

	public String getUtilisateurNomDomaine() throws Exception {
		return utilisateurNomDomaine;
	}
	protected void utilisateurNomDomaineInit() throws Exception {
		if(!utilisateurNomDomaineCouverture.dejaInitialise) {
			_utilisateurNomDomaine(utilisateurNomDomaineCouverture);
			if(utilisateurNomDomaine == null)
				utilisateurNomDomaine(utilisateurNomDomaineCouverture.o);
		}
		utilisateurNomDomaineCouverture.dejaInitialise(true);
	}

	////////////////////////////
	// utilisateurNomEnsemble //
	////////////////////////////

	/**	L'entité « utilisateurNomEnsemble »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public String utilisateurNomEnsemble;
	public Couverture<String> utilisateurNomEnsembleCouverture = new Couverture<String>().p(this).c(String.class).var("utilisateurNomEnsemble").o(utilisateurNomEnsemble);

	/**	L'entité « utilisateurNomEnsemble »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _utilisateurNomEnsemble(Couverture<String> o) throws Exception;

	public RequeteSite utilisateurNomEnsemble(String o) throws Exception {
		setUtilisateurNomEnsemble(o);
		return (RequeteSite)this;
	}

	public void setUtilisateurNomEnsemble(String o) throws Exception {
		this.utilisateurNomEnsemble = o;
	}

	public String utilisateurNomEnsemble() throws Exception {
		return getUtilisateurNomEnsemble();
	}

	public String getUtilisateurNomEnsemble() throws Exception {
		return utilisateurNomEnsemble;
	}
	protected void utilisateurNomEnsembleInit() throws Exception {
		if(!utilisateurNomEnsembleCouverture.dejaInitialise) {
			_utilisateurNomEnsemble(utilisateurNomEnsembleCouverture);
			if(utilisateurNomEnsemble == null)
				utilisateurNomEnsemble(utilisateurNomEnsembleCouverture.o);
		}
		utilisateurNomEnsembleCouverture.dejaInitialise(true);
	}

	/////////////////////
	// utilisateurSite //
	/////////////////////

	/**	L'entité « utilisateurSite »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public UtilisateurSite utilisateurSite;
	public Couverture<UtilisateurSite> utilisateurSiteCouverture = new Couverture<UtilisateurSite>().p(this).c(UtilisateurSite.class).var("utilisateurSite").o(utilisateurSite);

	/**	L'entité « utilisateurSite »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _utilisateurSite(Couverture<UtilisateurSite> o) throws Exception;

	public RequeteSite utilisateurSite(UtilisateurSite o) throws Exception {
		setUtilisateurSite(o);
		return (RequeteSite)this;
	}

	public void setUtilisateurSite(UtilisateurSite o) throws Exception {
		this.utilisateurSite = o;
	}

	public UtilisateurSite utilisateurSite() throws Exception {
		return getUtilisateurSite();
	}

	public UtilisateurSite getUtilisateurSite() throws Exception {
		return utilisateurSite;
	}
	protected void utilisateurSiteInit() throws Exception {
		if(!utilisateurSiteCouverture.dejaInitialise) {
			_utilisateurSite(utilisateurSiteCouverture);
			if(utilisateurSite == null)
				utilisateurSite(utilisateurSiteCouverture.o);
		}
		if(utilisateurSite != null)
			utilisateurSite.initLoinPourClasse(requeteSite);
		utilisateurSiteCouverture.dejaInitialise(true);
	}

	///////////////////
	// utilisateurId //
	///////////////////

	/**	L'entité « utilisateurId »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public String utilisateurId;
	public Couverture<String> utilisateurIdCouverture = new Couverture<String>().p(this).c(String.class).var("utilisateurId").o(utilisateurId);

	/**	L'entité « utilisateurId »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _utilisateurId(Couverture<String> o) throws Exception;

	public RequeteSite utilisateurId(String o) throws Exception {
		setUtilisateurId(o);
		return (RequeteSite)this;
	}

	public void setUtilisateurId(String o) throws Exception {
		this.utilisateurId = o;
	}

	public String utilisateurId() throws Exception {
		return getUtilisateurId();
	}

	public String getUtilisateurId() throws Exception {
		return utilisateurId;
	}
	protected void utilisateurIdInit() throws Exception {
		if(!utilisateurIdCouverture.dejaInitialise) {
			_utilisateurId(utilisateurIdCouverture);
			if(utilisateurId == null)
				utilisateurId(utilisateurIdCouverture.o);
		}
		utilisateurIdCouverture.dejaInitialise(true);
	}

	////////////////////
	// utilisateurNom //
	////////////////////

	/**	L'entité « utilisateurNom »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public String utilisateurNom;
	public Couverture<String> utilisateurNomCouverture = new Couverture<String>().p(this).c(String.class).var("utilisateurNom").o(utilisateurNom);

	/**	L'entité « utilisateurNom »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _utilisateurNom(Couverture<String> o) throws Exception;

	public RequeteSite utilisateurNom(String o) throws Exception {
		setUtilisateurNom(o);
		return (RequeteSite)this;
	}

	public void setUtilisateurNom(String o) throws Exception {
		this.utilisateurNom = o;
	}

	public String utilisateurNom() throws Exception {
		return getUtilisateurNom();
	}

	public String getUtilisateurNom() throws Exception {
		return utilisateurNom;
	}
	protected void utilisateurNomInit() throws Exception {
		if(!utilisateurNomCouverture.dejaInitialise) {
			_utilisateurNom(utilisateurNomCouverture);
			if(utilisateurNom == null)
				utilisateurNom(utilisateurNomCouverture.o);
		}
		utilisateurNomCouverture.dejaInitialise(true);
	}

	///////////////////////////
	// utilisateurNomFamille //
	///////////////////////////

	/**	L'entité « utilisateurNomFamille »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public String utilisateurNomFamille;
	public Couverture<String> utilisateurNomFamilleCouverture = new Couverture<String>().p(this).c(String.class).var("utilisateurNomFamille").o(utilisateurNomFamille);

	/**	L'entité « utilisateurNomFamille »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _utilisateurNomFamille(Couverture<String> o) throws Exception;

	public RequeteSite utilisateurNomFamille(String o) throws Exception {
		setUtilisateurNomFamille(o);
		return (RequeteSite)this;
	}

	public void setUtilisateurNomFamille(String o) throws Exception {
		this.utilisateurNomFamille = o;
	}

	public String utilisateurNomFamille() throws Exception {
		return getUtilisateurNomFamille();
	}

	public String getUtilisateurNomFamille() throws Exception {
		return utilisateurNomFamille;
	}
	protected void utilisateurNomFamilleInit() throws Exception {
		if(!utilisateurNomFamilleCouverture.dejaInitialise) {
			_utilisateurNomFamille(utilisateurNomFamilleCouverture);
			if(utilisateurNomFamille == null)
				utilisateurNomFamille(utilisateurNomFamilleCouverture.o);
		}
		utilisateurNomFamilleCouverture.dejaInitialise(true);
	}

	///////////////////////
	// utilisateurPrenom //
	///////////////////////

	/**	L'entité « utilisateurPrenom »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public String utilisateurPrenom;
	public Couverture<String> utilisateurPrenomCouverture = new Couverture<String>().p(this).c(String.class).var("utilisateurPrenom").o(utilisateurPrenom);

	/**	L'entité « utilisateurPrenom »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _utilisateurPrenom(Couverture<String> o) throws Exception;

	public RequeteSite utilisateurPrenom(String o) throws Exception {
		setUtilisateurPrenom(o);
		return (RequeteSite)this;
	}

	public void setUtilisateurPrenom(String o) throws Exception {
		this.utilisateurPrenom = o;
	}

	public String utilisateurPrenom() throws Exception {
		return getUtilisateurPrenom();
	}

	public String getUtilisateurPrenom() throws Exception {
		return utilisateurPrenom;
	}
	protected void utilisateurPrenomInit() throws Exception {
		if(!utilisateurPrenomCouverture.dejaInitialise) {
			_utilisateurPrenom(utilisateurPrenomCouverture);
			if(utilisateurPrenom == null)
				utilisateurPrenom(utilisateurPrenomCouverture.o);
		}
		utilisateurPrenomCouverture.dejaInitialise(true);
	}

	///////////////////////////
	// utilisateurNomComplet //
	///////////////////////////

	/**	L'entité « utilisateurNomComplet »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public String utilisateurNomComplet;
	public Couverture<String> utilisateurNomCompletCouverture = new Couverture<String>().p(this).c(String.class).var("utilisateurNomComplet").o(utilisateurNomComplet);

	/**	L'entité « utilisateurNomComplet »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _utilisateurNomComplet(Couverture<String> o) throws Exception;

	public RequeteSite utilisateurNomComplet(String o) throws Exception {
		setUtilisateurNomComplet(o);
		return (RequeteSite)this;
	}

	public void setUtilisateurNomComplet(String o) throws Exception {
		this.utilisateurNomComplet = o;
	}

	public String utilisateurNomComplet() throws Exception {
		return getUtilisateurNomComplet();
	}

	public String getUtilisateurNomComplet() throws Exception {
		return utilisateurNomComplet;
	}
	protected void utilisateurNomCompletInit() throws Exception {
		if(!utilisateurNomCompletCouverture.dejaInitialise) {
			_utilisateurNomComplet(utilisateurNomCompletCouverture);
			if(utilisateurNomComplet == null)
				utilisateurNomComplet(utilisateurNomCompletCouverture.o);
		}
		utilisateurNomCompletCouverture.dejaInitialise(true);
	}

	/////////////////////////////
	// utilisateurRolesRoyaume //
	/////////////////////////////

	/**	L'entité « utilisateurRolesRoyaume »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut HashSet<String>(). 
	 */
	public HashSet<String> utilisateurRolesRoyaume = new HashSet<String>();
	public Couverture<HashSet<String>> utilisateurRolesRoyaumeCouverture = new Couverture<HashSet<String>>().p(this).c(HashSet.class).var("utilisateurRolesRoyaume").o(utilisateurRolesRoyaume);

	/**	L'entité « utilisateurRolesRoyaume »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut HashSet<String>(). 
	 *	@param utilisateurRolesRoyaume est le champ déjà construit. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _utilisateurRolesRoyaume(HashSet<String> o) throws Exception;

	public RequeteSite utilisateurRolesRoyaume(HashSet<String> o) throws Exception {
		setUtilisateurRolesRoyaume(o);
		return (RequeteSite)this;
	}

	public void setUtilisateurRolesRoyaume(HashSet<String> o) throws Exception {
		this.utilisateurRolesRoyaume = o;
	}

	public HashSet<String> utilisateurRolesRoyaume() throws Exception {
		return getUtilisateurRolesRoyaume();
	}

	public HashSet<String> getUtilisateurRolesRoyaume() throws Exception {
		return utilisateurRolesRoyaume;
	}
	protected void utilisateurRolesRoyaumeInit() throws Exception {
		if(!utilisateurRolesRoyaumeCouverture.dejaInitialise) {
			_utilisateurRolesRoyaume(utilisateurRolesRoyaume);
		}
		utilisateurRolesRoyaumeCouverture.dejaInitialise(true);
	}

	///////////////////////////////
	// utilisateurRolesRessource //
	///////////////////////////////

	/**	L'entité « utilisateurRolesRessource »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut HashSet<String>(). 
	 */
	public HashSet<String> utilisateurRolesRessource = new HashSet<String>();
	public Couverture<HashSet<String>> utilisateurRolesRessourceCouverture = new Couverture<HashSet<String>>().p(this).c(HashSet.class).var("utilisateurRolesRessource").o(utilisateurRolesRessource);

	/**	L'entité « utilisateurRolesRessource »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut HashSet<String>(). 
	 *	@param utilisateurRolesRessource est le champ déjà construit. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _utilisateurRolesRessource(HashSet<String> o) throws Exception;

	public RequeteSite utilisateurRolesRessource(HashSet<String> o) throws Exception {
		setUtilisateurRolesRessource(o);
		return (RequeteSite)this;
	}

	public void setUtilisateurRolesRessource(HashSet<String> o) throws Exception {
		this.utilisateurRolesRessource = o;
	}

	public HashSet<String> utilisateurRolesRessource() throws Exception {
		return getUtilisateurRolesRessource();
	}

	public HashSet<String> getUtilisateurRolesRessource() throws Exception {
		return utilisateurRolesRessource;
	}
	protected void utilisateurRolesRessourceInit() throws Exception {
		if(!utilisateurRolesRessourceCouverture.dejaInitialise) {
			_utilisateurRolesRessource(utilisateurRolesRessource);
		}
		utilisateurRolesRessourceCouverture.dejaInitialise(true);
	}

	/////////////
	// xmlPile //
	/////////////

	/**	L'entité « xmlPile »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Stack<String>(). 
	 */
	public Stack<String> xmlPile = new Stack<String>();
	public Couverture<Stack<String>> xmlPileCouverture = new Couverture<Stack<String>>().p(this).c(Stack.class).var("xmlPile").o(xmlPile);

	/**	L'entité « xmlPile »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Stack<String>(). 
	 *	@param xmlPile est le champ déjà construit. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _xmlPile(Stack<String> o) throws Exception;

	public RequeteSite xmlPile(Stack<String> o) throws Exception {
		setXmlPile(o);
		return (RequeteSite)this;
	}

	public void setXmlPile(Stack<String> o) throws Exception {
		this.xmlPile = o;
	}

	public Stack<String> xmlPile() throws Exception {
		return getXmlPile();
	}

	public Stack<String> getXmlPile() throws Exception {
		return xmlPile;
	}
	protected void xmlPileInit() throws Exception {
		if(!xmlPileCouverture.dejaInitialise) {
			_xmlPile(xmlPile);
		}
		xmlPileCouverture.dejaInitialise(true);
	}

	/////////////
	// requete //
	/////////////

	/**	L'entité « requete »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public HttpServletRequest requete;
	public Couverture<HttpServletRequest> requeteCouverture = new Couverture<HttpServletRequest>().p(this).c(HttpServletRequest.class).var("requete").o(requete);

	/**	L'entité « requete »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _requete(Couverture<HttpServletRequest> o) throws Exception;

	public RequeteSite requete(HttpServletRequest o) throws Exception {
		setRequete(o);
		return (RequeteSite)this;
	}

	public void setRequete(HttpServletRequest o) throws Exception {
		this.requete = o;
	}

	public HttpServletRequest requete() throws Exception {
		return getRequete();
	}

	public HttpServletRequest getRequete() throws Exception {
		return requete;
	}
	protected void requeteInit() throws Exception {
		if(!requeteCouverture.dejaInitialise) {
			_requete(requeteCouverture);
			if(requete == null)
				requete(requeteCouverture.o);
		}
		requeteCouverture.dejaInitialise(true);
	}

	/////////////
	// reponse //
	/////////////

	/**	L'entité « reponse »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public HttpServletResponse reponse;
	public Couverture<HttpServletResponse> reponseCouverture = new Couverture<HttpServletResponse>().p(this).c(HttpServletResponse.class).var("reponse").o(reponse);

	/**	L'entité « reponse »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _reponse(Couverture<HttpServletResponse> o) throws Exception;

	public RequeteSite reponse(HttpServletResponse o) throws Exception {
		setReponse(o);
		return (RequeteSite)this;
	}

	public void setReponse(HttpServletResponse o) throws Exception {
		this.reponse = o;
	}

	public HttpServletResponse reponse() throws Exception {
		return getReponse();
	}

	public HttpServletResponse getReponse() throws Exception {
		return reponse;
	}
	protected void reponseInit() throws Exception {
		if(!reponseCouverture.dejaInitialise) {
			_reponse(reponseCouverture);
			if(reponse == null)
				reponse(reponseCouverture.o);
		}
		reponseCouverture.dejaInitialise(true);
	}

	//////////////////
	// solrDocument //
	//////////////////

	/**	L'entité « solrDocument »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public SolrDocument solrDocument;
	public Couverture<SolrDocument> solrDocumentCouverture = new Couverture<SolrDocument>().p(this).c(SolrDocument.class).var("solrDocument").o(solrDocument);

	/**	L'entité « solrDocument »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _solrDocument(Couverture<SolrDocument> o) throws Exception;

	public RequeteSite solrDocument(SolrDocument o) throws Exception {
		setSolrDocument(o);
		return (RequeteSite)this;
	}

	public void setSolrDocument(SolrDocument o) throws Exception {
		this.solrDocument = o;
	}

	public SolrDocument solrDocument() throws Exception {
		return getSolrDocument();
	}

	public SolrDocument getSolrDocument() throws Exception {
		return solrDocument;
	}
	protected void solrDocumentInit() throws Exception {
		if(!solrDocumentCouverture.dejaInitialise) {
			_solrDocument(solrDocumentCouverture);
			if(solrDocument == null)
				solrDocument(solrDocumentCouverture.o);
		}
		solrDocumentCouverture.dejaInitialise(true);
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

	public RequeteSite ecrivain(PrintWriter o) throws Exception {
		setEcrivain(o);
		return (RequeteSite)this;
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

	////////////////
	// pageAchete //
	////////////////

	/**	L'entité « pageAchete »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public Boolean pageAchete;
	public Couverture<Boolean> pageAcheteCouverture = new Couverture<Boolean>().p(this).c(Boolean.class).var("pageAchete").o(pageAchete);

	/**	L'entité « pageAchete »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _pageAchete(Couverture<Boolean> o) throws Exception;

	public RequeteSite pageAchete(Boolean o) throws Exception {
		setPageAchete(o);
		return (RequeteSite)this;
	}

	public void setPageAchete(Boolean o) throws Exception {
		this.pageAchete = o;
	}

	public Boolean pageAchete() throws Exception {
		return getPageAchete();
	}

	public Boolean getPageAchete() throws Exception {
		return pageAchete;
	}
	public RequeteSite pageAchete(String o) throws Exception {
		if(org.apache.commons.lang3.BooleanUtils.isTrue(org.apache.commons.lang3.BooleanUtils.toBoolean(o)))
			this.pageAchete = Boolean.parseBoolean(o);
		return (RequeteSite)this;
	}
	protected void pageAcheteInit() throws Exception {
		if(!pageAcheteCouverture.dejaInitialise) {
			_pageAchete(pageAcheteCouverture);
			if(pageAchete == null)
				pageAchete(pageAcheteCouverture.o);
		}
		pageAcheteCouverture.dejaInitialise(true);
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

	public RequeteSite pageAdmin(Boolean o) throws Exception {
		setPageAdmin(o);
		return (RequeteSite)this;
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
	public RequeteSite pageAdmin(String o) throws Exception {
		if(org.apache.commons.lang3.BooleanUtils.isTrue(org.apache.commons.lang3.BooleanUtils.toBoolean(o)))
			this.pageAdmin = Boolean.parseBoolean(o);
		return (RequeteSite)this;
	}
	protected void pageAdminInit() throws Exception {
		if(!pageAdminCouverture.dejaInitialise) {
			_pageAdmin(pageAdminCouverture);
			if(pageAdmin == null)
				pageAdmin(pageAdminCouverture.o);
		}
		pageAdminCouverture.dejaInitialise(true);
	}

	///////
	// h //
	///////

	/**	L'entité « h »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public String h;
	public Couverture<String> hCouverture = new Couverture<String>().p(this).c(String.class).var("h").o(h);

	/**	L'entité « h »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _h(Couverture<String> o) throws Exception;

	public RequeteSite h(String o) throws Exception {
		setH(o);
		return (RequeteSite)this;
	}

	public void setH(String o) throws Exception {
		this.h = o;
	}

	public String h() throws Exception {
		return getH();
	}

	public String getH() throws Exception {
		return h;
	}
	protected void hInit() throws Exception {
		if(!hCouverture.dejaInitialise) {
			_h(hCouverture);
			if(h == null)
				h(hCouverture.o);
		}
		hCouverture.dejaInitialise(true);
	}

	////////////////////////
	// chiffrementCrypter //
	////////////////////////

	/**	L'entité « chiffrementCrypter »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public Cipher chiffrementCrypter;
	public Couverture<Cipher> chiffrementCrypterCouverture = new Couverture<Cipher>().p(this).c(Cipher.class).var("chiffrementCrypter").o(chiffrementCrypter);

	/**	L'entité « chiffrementCrypter »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _chiffrementCrypter(Couverture<Cipher> o) throws Exception;

	public RequeteSite chiffrementCrypter(Cipher o) throws Exception {
		setChiffrementCrypter(o);
		return (RequeteSite)this;
	}

	public void setChiffrementCrypter(Cipher o) throws Exception {
		this.chiffrementCrypter = o;
	}

	public Cipher chiffrementCrypter() throws Exception {
		return getChiffrementCrypter();
	}

	public Cipher getChiffrementCrypter() throws Exception {
		return chiffrementCrypter;
	}
	protected void chiffrementCrypterInit() throws Exception {
		if(!chiffrementCrypterCouverture.dejaInitialise) {
			_chiffrementCrypter(chiffrementCrypterCouverture);
			if(chiffrementCrypter == null)
				chiffrementCrypter(chiffrementCrypterCouverture.o);
		}
		chiffrementCrypterCouverture.dejaInitialise(true);
	}

	//////////////////////////
	// chiffrementDecrypter //
	//////////////////////////

	/**	L'entité « chiffrementDecrypter »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public Cipher chiffrementDecrypter;
	public Couverture<Cipher> chiffrementDecrypterCouverture = new Couverture<Cipher>().p(this).c(Cipher.class).var("chiffrementDecrypter").o(chiffrementDecrypter);

	/**	L'entité « chiffrementDecrypter »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _chiffrementDecrypter(Couverture<Cipher> o) throws Exception;

	public RequeteSite chiffrementDecrypter(Cipher o) throws Exception {
		setChiffrementDecrypter(o);
		return (RequeteSite)this;
	}

	public void setChiffrementDecrypter(Cipher o) throws Exception {
		this.chiffrementDecrypter = o;
	}

	public Cipher chiffrementDecrypter() throws Exception {
		return getChiffrementDecrypter();
	}

	public Cipher getChiffrementDecrypter() throws Exception {
		return chiffrementDecrypter;
	}
	protected void chiffrementDecrypterInit() throws Exception {
		if(!chiffrementDecrypterCouverture.dejaInitialise) {
			_chiffrementDecrypter(chiffrementDecrypterCouverture);
			if(chiffrementDecrypter == null)
				chiffrementDecrypter(chiffrementDecrypterCouverture.o);
		}
		chiffrementDecrypterCouverture.dejaInitialise(true);
	}

	///////////////////
	// digestMessage //
	///////////////////

	/**	L'entité « digestMessage »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public MessageDigest digestMessage;
	public Couverture<MessageDigest> digestMessageCouverture = new Couverture<MessageDigest>().p(this).c(MessageDigest.class).var("digestMessage").o(digestMessage);

	/**	L'entité « digestMessage »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _digestMessage(Couverture<MessageDigest> o) throws Exception;

	public RequeteSite digestMessage(MessageDigest o) throws Exception {
		setDigestMessage(o);
		return (RequeteSite)this;
	}

	public void setDigestMessage(MessageDigest o) throws Exception {
		this.digestMessage = o;
	}

	public MessageDigest digestMessage() throws Exception {
		return getDigestMessage();
	}

	public MessageDigest getDigestMessage() throws Exception {
		return digestMessage;
	}
	protected void digestMessageInit() throws Exception {
		if(!digestMessageCouverture.dejaInitialise) {
			_digestMessage(digestMessageCouverture);
			if(digestMessage == null)
				digestMessage(digestMessageCouverture.o);
		}
		digestMessageCouverture.dejaInitialise(true);
	}

	/////////
	// sel //
	/////////

	/**	L'entité « sel »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public String sel;
	public Couverture<String> selCouverture = new Couverture<String>().p(this).c(String.class).var("sel").o(sel);

	/**	L'entité « sel »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _sel(Couverture<String> o) throws Exception;

	public RequeteSite sel(String o) throws Exception {
		setSel(o);
		return (RequeteSite)this;
	}

	public void setSel(String o) throws Exception {
		this.sel = o;
	}

	public String sel() throws Exception {
		return getSel();
	}

	public String getSel() throws Exception {
		return sel;
	}
	protected void selInit() throws Exception {
		if(!selCouverture.dejaInitialise) {
			_sel(selCouverture);
			if(sel == null)
				sel(selCouverture.o);
		}
		selCouverture.dejaInitialise(true);
	}

	/////////
	// cle //
	/////////

	/**	L'entité « cle »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public byte[] cle;
	public Couverture<byte[]> cleCouverture = new Couverture<byte[]>().p(this).c(byte[].class).var("cle").o(cle);

	/**	L'entité « cle »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _cle(Couverture<byte[]> o) throws Exception;

	public RequeteSite cle(byte[] o) throws Exception {
		setCle(o);
		return (RequeteSite)this;
	}

	public void setCle(byte[] o) throws Exception {
		this.cle = o;
	}

	public byte[] cle() throws Exception {
		return getCle();
	}

	public byte[] getCle() throws Exception {
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

	///////////////////////
	// aleatoireSecurise //
	///////////////////////

	/**	L'entité « aleatoireSecurise »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut SecureRandom(). 
	 */
	public SecureRandom aleatoireSecurise = new SecureRandom();
	public Couverture<SecureRandom> aleatoireSecuriseCouverture = new Couverture<SecureRandom>().p(this).c(SecureRandom.class).var("aleatoireSecurise").o(aleatoireSecurise);

	/**	L'entité « aleatoireSecurise »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut SecureRandom(). 
	 *	@param aleatoireSecurise est le champ déjà construit. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _aleatoireSecurise(SecureRandom o) throws Exception;

	public RequeteSite aleatoireSecurise(SecureRandom o) throws Exception {
		setAleatoireSecurise(o);
		return (RequeteSite)this;
	}

	public void setAleatoireSecurise(SecureRandom o) throws Exception {
		this.aleatoireSecurise = o;
	}

	public SecureRandom aleatoireSecurise() throws Exception {
		return getAleatoireSecurise();
	}

	public SecureRandom getAleatoireSecurise() throws Exception {
		return aleatoireSecurise;
	}
	protected void aleatoireSecuriseInit() throws Exception {
		if(!aleatoireSecuriseCouverture.dejaInitialise) {
			_aleatoireSecurise(aleatoireSecurise);
		}
		aleatoireSecuriseCouverture.dejaInitialise(true);
	}

	////////////////////
	// specCleSecrete //
	////////////////////

	/**	L'entité « specCleSecrete »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public SecretKeySpec specCleSecrete;
	public Couverture<SecretKeySpec> specCleSecreteCouverture = new Couverture<SecretKeySpec>().p(this).c(SecretKeySpec.class).var("specCleSecrete").o(specCleSecrete);

	/**	L'entité « specCleSecrete »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _specCleSecrete(Couverture<SecretKeySpec> o) throws Exception;

	public RequeteSite specCleSecrete(SecretKeySpec o) throws Exception {
		setSpecCleSecrete(o);
		return (RequeteSite)this;
	}

	public void setSpecCleSecrete(SecretKeySpec o) throws Exception {
		this.specCleSecrete = o;
	}

	public SecretKeySpec specCleSecrete() throws Exception {
		return getSpecCleSecrete();
	}

	public SecretKeySpec getSpecCleSecrete() throws Exception {
		return specCleSecrete;
	}
	protected void specCleSecreteInit() throws Exception {
		if(!specCleSecreteCouverture.dejaInitialise) {
			_specCleSecrete(specCleSecreteCouverture);
			if(specCleSecrete == null)
				specCleSecrete(specCleSecreteCouverture.o);
		}
		specCleSecreteCouverture.dejaInitialise(true);
	}

	protected boolean dejaInitialiseRequeteSite = false;

	public void initLoinRequeteSite(RequeteSite requeteSite) throws Exception {
		((RequeteSite)this).requeteSite(requeteSite);
		requeteSite(requeteSite);
		initLoinRequeteSite();
	}

	public void initLoinRequeteSite() throws Exception {
		if(!dejaInitialiseRequeteSite) {
			requeteSiteInit();
			configSiteInit();
			ecouteurContexteInit();
			jetonAccesInit();
			utilisateurNomDomaineInit();
			utilisateurNomEnsembleInit();
			utilisateurSiteInit();
			utilisateurIdInit();
			utilisateurNomInit();
			utilisateurNomFamilleInit();
			utilisateurPrenomInit();
			utilisateurNomCompletInit();
			utilisateurRolesRoyaumeInit();
			utilisateurRolesRessourceInit();
			xmlPileInit();
			requeteInit();
			reponseInit();
			solrDocumentInit();
			ecrivainInit();
			pageAcheteInit();
			pageAdminInit();
			hInit();
			chiffrementCrypterInit();
			chiffrementDecrypterInit();
			digestMessageInit();
			selInit();
			cleInit();
			aleatoireSecuriseInit();
			specCleSecreteInit();
			dejaInitialiseRequeteSite = true;
		}
	}

	public void initLoinPourClasse(RequeteSite requeteSite) throws Exception {
		initLoinRequeteSite(requeteSite);
	}
}
