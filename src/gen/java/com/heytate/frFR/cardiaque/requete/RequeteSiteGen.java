package com.heytate.frFR.cardiaque.requete;

import java.io.PrintWriter;
import com.heytate.frFR.cardiaque.config.ConfigSite;
import com.heytate.frFR.cardiaque.contexte.EcouteurContexte;
import java.security.MessageDigest;
import com.heytate.frFR.cardiaque.requete.RequeteSite;
import javax.servlet.http.HttpServletResponse;
import javax.crypto.spec.SecretKeySpec;
import com.heytate.frFR.cardiaque.cluster.Cluster;
import javax.crypto.Cipher;
import java.util.Stack;
import java.util.HashSet;
import java.security.SecureRandom;
import org.apache.solr.common.SolrDocument;
import javax.servlet.http.HttpServletRequest;
import com.heytate.frFR.cardiaque.utilisateur.UtilisateurSite;
import org.keycloak.representations.AccessToken;
import java.lang.Boolean;
import java.lang.Object;
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

	public void setRequeteSite(RequeteSite o) throws Exception {
		this.requeteSite = o;
	}

	public RequeteSite getRequeteSite() throws Exception {
		return requeteSite;
	}
	protected void requeteSiteInit() throws Exception {
		if(!requeteSiteCouverture.dejaInitialise) {
			_requeteSite(requeteSiteCouverture);
			if(requeteSite == null)
				setRequeteSite(requeteSiteCouverture.o);
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

	public void setConfigSite(ConfigSite o) throws Exception {
		this.configSite = o;
	}

	public ConfigSite getConfigSite() throws Exception {
		return configSite;
	}
	protected void configSiteInit() throws Exception {
		if(!configSiteCouverture.dejaInitialise) {
			_configSite(configSiteCouverture);
			if(configSite == null)
				setConfigSite(configSiteCouverture.o);
		}
		if(configSite != null)
			configSite.initLoinPourClasse(requeteSite);
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

	public void setEcouteurContexte(EcouteurContexte o) throws Exception {
		this.ecouteurContexte = o;
	}

	public EcouteurContexte getEcouteurContexte() throws Exception {
		return ecouteurContexte;
	}
	protected void ecouteurContexteInit() throws Exception {
		if(!ecouteurContexteCouverture.dejaInitialise) {
			_ecouteurContexte(ecouteurContexteCouverture);
			if(ecouteurContexte == null)
				setEcouteurContexte(ecouteurContexteCouverture.o);
		}
		if(ecouteurContexte != null)
			ecouteurContexte.initLoinPourClasse(requeteSite);
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

	public void setJetonAcces(AccessToken o) throws Exception {
		this.jetonAcces = o;
	}

	public AccessToken getJetonAcces() throws Exception {
		return jetonAcces;
	}
	protected void jetonAccesInit() throws Exception {
		if(!jetonAccesCouverture.dejaInitialise) {
			_jetonAcces(jetonAccesCouverture);
			if(jetonAcces == null)
				setJetonAcces(jetonAccesCouverture.o);
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

	public void setUtilisateurNomDomaine(String o) throws Exception {
		this.utilisateurNomDomaine = o;
	}

	public String getUtilisateurNomDomaine() throws Exception {
		return utilisateurNomDomaine;
	}
	protected void utilisateurNomDomaineInit() throws Exception {
		if(!utilisateurNomDomaineCouverture.dejaInitialise) {
			_utilisateurNomDomaine(utilisateurNomDomaineCouverture);
			if(utilisateurNomDomaine == null)
				setUtilisateurNomDomaine(utilisateurNomDomaineCouverture.o);
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

	public void setUtilisateurNomEnsemble(String o) throws Exception {
		this.utilisateurNomEnsemble = o;
	}

	public String getUtilisateurNomEnsemble() throws Exception {
		return utilisateurNomEnsemble;
	}
	protected void utilisateurNomEnsembleInit() throws Exception {
		if(!utilisateurNomEnsembleCouverture.dejaInitialise) {
			_utilisateurNomEnsemble(utilisateurNomEnsembleCouverture);
			if(utilisateurNomEnsemble == null)
				setUtilisateurNomEnsemble(utilisateurNomEnsembleCouverture.o);
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

	public void setUtilisateurSite(UtilisateurSite o) throws Exception {
		this.utilisateurSite = o;
	}

	public UtilisateurSite getUtilisateurSite() throws Exception {
		return utilisateurSite;
	}
	protected void utilisateurSiteInit() throws Exception {
		if(!utilisateurSiteCouverture.dejaInitialise) {
			_utilisateurSite(utilisateurSiteCouverture);
			if(utilisateurSite == null)
				setUtilisateurSite(utilisateurSiteCouverture.o);
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

	public void setUtilisateurId(String o) throws Exception {
		this.utilisateurId = o;
	}

	public String getUtilisateurId() throws Exception {
		return utilisateurId;
	}
	protected void utilisateurIdInit() throws Exception {
		if(!utilisateurIdCouverture.dejaInitialise) {
			_utilisateurId(utilisateurIdCouverture);
			if(utilisateurId == null)
				setUtilisateurId(utilisateurIdCouverture.o);
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

	public void setUtilisateurNom(String o) throws Exception {
		this.utilisateurNom = o;
	}

	public String getUtilisateurNom() throws Exception {
		return utilisateurNom;
	}
	protected void utilisateurNomInit() throws Exception {
		if(!utilisateurNomCouverture.dejaInitialise) {
			_utilisateurNom(utilisateurNomCouverture);
			if(utilisateurNom == null)
				setUtilisateurNom(utilisateurNomCouverture.o);
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

	public void setUtilisateurNomFamille(String o) throws Exception {
		this.utilisateurNomFamille = o;
	}

	public String getUtilisateurNomFamille() throws Exception {
		return utilisateurNomFamille;
	}
	protected void utilisateurNomFamilleInit() throws Exception {
		if(!utilisateurNomFamilleCouverture.dejaInitialise) {
			_utilisateurNomFamille(utilisateurNomFamilleCouverture);
			if(utilisateurNomFamille == null)
				setUtilisateurNomFamille(utilisateurNomFamilleCouverture.o);
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

	public void setUtilisateurPrenom(String o) throws Exception {
		this.utilisateurPrenom = o;
	}

	public String getUtilisateurPrenom() throws Exception {
		return utilisateurPrenom;
	}
	protected void utilisateurPrenomInit() throws Exception {
		if(!utilisateurPrenomCouverture.dejaInitialise) {
			_utilisateurPrenom(utilisateurPrenomCouverture);
			if(utilisateurPrenom == null)
				setUtilisateurPrenom(utilisateurPrenomCouverture.o);
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

	public void setUtilisateurNomComplet(String o) throws Exception {
		this.utilisateurNomComplet = o;
	}

	public String getUtilisateurNomComplet() throws Exception {
		return utilisateurNomComplet;
	}
	protected void utilisateurNomCompletInit() throws Exception {
		if(!utilisateurNomCompletCouverture.dejaInitialise) {
			_utilisateurNomComplet(utilisateurNomCompletCouverture);
			if(utilisateurNomComplet == null)
				setUtilisateurNomComplet(utilisateurNomCompletCouverture.o);
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

	public void setUtilisateurRolesRoyaume(HashSet<String> o) throws Exception {
		this.utilisateurRolesRoyaume = o;
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

	public void setUtilisateurRolesRessource(HashSet<String> o) throws Exception {
		this.utilisateurRolesRessource = o;
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

	public void setXmlPile(Stack<String> o) throws Exception {
		this.xmlPile = o;
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

	public void setRequete(HttpServletRequest o) throws Exception {
		this.requete = o;
	}

	public HttpServletRequest getRequete() throws Exception {
		return requete;
	}
	protected void requeteInit() throws Exception {
		if(!requeteCouverture.dejaInitialise) {
			_requete(requeteCouverture);
			if(requete == null)
				setRequete(requeteCouverture.o);
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

	public void setReponse(HttpServletResponse o) throws Exception {
		this.reponse = o;
	}

	public HttpServletResponse getReponse() throws Exception {
		return reponse;
	}
	protected void reponseInit() throws Exception {
		if(!reponseCouverture.dejaInitialise) {
			_reponse(reponseCouverture);
			if(reponse == null)
				setReponse(reponseCouverture.o);
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

	public void setSolrDocument(SolrDocument o) throws Exception {
		this.solrDocument = o;
	}

	public SolrDocument getSolrDocument() throws Exception {
		return solrDocument;
	}
	protected void solrDocumentInit() throws Exception {
		if(!solrDocumentCouverture.dejaInitialise) {
			_solrDocument(solrDocumentCouverture);
			if(solrDocument == null)
				setSolrDocument(solrDocumentCouverture.o);
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

	public void setEcrivain(PrintWriter o) throws Exception {
		this.ecrivain = o;
	}

	public PrintWriter getEcrivain() throws Exception {
		return ecrivain;
	}
	protected void ecrivainInit() throws Exception {
		if(!ecrivainCouverture.dejaInitialise) {
			_ecrivain(ecrivainCouverture);
			if(ecrivain == null)
				setEcrivain(ecrivainCouverture.o);
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

	public void setPageAchete(Boolean o) throws Exception {
		this.pageAchete = o;
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
				setPageAchete(pageAcheteCouverture.o);
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

	public void setPageAdmin(Boolean o) throws Exception {
		this.pageAdmin = o;
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
				setPageAdmin(pageAdminCouverture.o);
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

	public void setH(String o) throws Exception {
		this.h = o;
	}

	public String getH() throws Exception {
		return h;
	}
	protected void hInit() throws Exception {
		if(!hCouverture.dejaInitialise) {
			_h(hCouverture);
			if(h == null)
				setH(hCouverture.o);
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

	public void setChiffrementCrypter(Cipher o) throws Exception {
		this.chiffrementCrypter = o;
	}

	public Cipher getChiffrementCrypter() throws Exception {
		return chiffrementCrypter;
	}
	protected void chiffrementCrypterInit() throws Exception {
		if(!chiffrementCrypterCouverture.dejaInitialise) {
			_chiffrementCrypter(chiffrementCrypterCouverture);
			if(chiffrementCrypter == null)
				setChiffrementCrypter(chiffrementCrypterCouverture.o);
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

	public void setChiffrementDecrypter(Cipher o) throws Exception {
		this.chiffrementDecrypter = o;
	}

	public Cipher getChiffrementDecrypter() throws Exception {
		return chiffrementDecrypter;
	}
	protected void chiffrementDecrypterInit() throws Exception {
		if(!chiffrementDecrypterCouverture.dejaInitialise) {
			_chiffrementDecrypter(chiffrementDecrypterCouverture);
			if(chiffrementDecrypter == null)
				setChiffrementDecrypter(chiffrementDecrypterCouverture.o);
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

	public void setDigestMessage(MessageDigest o) throws Exception {
		this.digestMessage = o;
	}

	public MessageDigest getDigestMessage() throws Exception {
		return digestMessage;
	}
	protected void digestMessageInit() throws Exception {
		if(!digestMessageCouverture.dejaInitialise) {
			_digestMessage(digestMessageCouverture);
			if(digestMessage == null)
				setDigestMessage(digestMessageCouverture.o);
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

	public void setSel(String o) throws Exception {
		this.sel = o;
	}

	public String getSel() throws Exception {
		return sel;
	}
	protected void selInit() throws Exception {
		if(!selCouverture.dejaInitialise) {
			_sel(selCouverture);
			if(sel == null)
				setSel(selCouverture.o);
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

	public void setCle(byte[] o) throws Exception {
		this.cle = o;
	}

	public byte[] getCle() throws Exception {
		return cle;
	}
	protected void cleInit() throws Exception {
		if(!cleCouverture.dejaInitialise) {
			_cle(cleCouverture);
			if(cle == null)
				setCle(cleCouverture.o);
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

	public void setAleatoireSecurise(SecureRandom o) throws Exception {
		this.aleatoireSecurise = o;
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

	public void setSpecCleSecrete(SecretKeySpec o) throws Exception {
		this.specCleSecrete = o;
	}

	public SecretKeySpec getSpecCleSecrete() throws Exception {
		return specCleSecrete;
	}
	protected void specCleSecreteInit() throws Exception {
		if(!specCleSecreteCouverture.dejaInitialise) {
			_specCleSecrete(specCleSecreteCouverture);
			if(specCleSecrete == null)
				setSpecCleSecrete(specCleSecreteCouverture.o);
		}
		specCleSecreteCouverture.dejaInitialise(true);
	}

	/////////////////////
	// initialiserLoin //
	/////////////////////

	protected boolean dejaInitialiseRequeteSite = false;

	public void initLoinRequeteSite(RequeteSite requeteSite) throws Exception {
		setRequeteSite(requeteSite);
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

	/////////////////
	// requeteSite //
	/////////////////

	public void requeteSiteRequeteSite(RequeteSite requeteSite) throws Exception {
		requeteSite.setRequeteSite(requeteSite);
		configSite.setRequeteSite(requeteSite);
		ecouteurContexte.setRequeteSite(requeteSite);
		utilisateurSite.setRequeteSite(requeteSite);
	}

	public void requeteSitePourClasse(RequeteSite requeteSite) throws Exception {
		requeteSiteRequeteSite(requeteSite);
	}

	/////////////
	// obtenir //
	/////////////

	public Object obtenirPourClasse(String var) throws Exception {
		String[] vars = org.apache.commons.lang3.StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtenirRequeteSite(v);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.obtenirPourClasse(v);
			}
		}
		return o;
	}
	public Object obtenirRequeteSite(String var) throws Exception {
		RequeteSite oRequeteSite = (RequeteSite)this;
		switch(var) {
		case "requeteSite": return oRequeteSite.requeteSite;
		case "configSite": return oRequeteSite.configSite;
		case "ecouteurContexte": return oRequeteSite.ecouteurContexte;
		case "jetonAcces": return oRequeteSite.jetonAcces;
		case "utilisateurNomDomaine": return oRequeteSite.utilisateurNomDomaine;
		case "utilisateurNomEnsemble": return oRequeteSite.utilisateurNomEnsemble;
		case "utilisateurSite": return oRequeteSite.utilisateurSite;
		case "utilisateurId": return oRequeteSite.utilisateurId;
		case "utilisateurNom": return oRequeteSite.utilisateurNom;
		case "utilisateurNomFamille": return oRequeteSite.utilisateurNomFamille;
		case "utilisateurPrenom": return oRequeteSite.utilisateurPrenom;
		case "utilisateurNomComplet": return oRequeteSite.utilisateurNomComplet;
		case "utilisateurRolesRoyaume": return oRequeteSite.utilisateurRolesRoyaume;
		case "utilisateurRolesRessource": return oRequeteSite.utilisateurRolesRessource;
		case "xmlPile": return oRequeteSite.xmlPile;
		case "requete": return oRequeteSite.requete;
		case "reponse": return oRequeteSite.reponse;
		case "solrDocument": return oRequeteSite.solrDocument;
		case "ecrivain": return oRequeteSite.ecrivain;
		case "pageAchete": return oRequeteSite.pageAchete;
		case "pageAdmin": return oRequeteSite.pageAdmin;
		case "h": return oRequeteSite.h;
		case "chiffrementCrypter": return oRequeteSite.chiffrementCrypter;
		case "chiffrementDecrypter": return oRequeteSite.chiffrementDecrypter;
		case "digestMessage": return oRequeteSite.digestMessage;
		case "sel": return oRequeteSite.sel;
		case "cle": return oRequeteSite.cle;
		case "aleatoireSecurise": return oRequeteSite.aleatoireSecurise;
		case "specCleSecrete": return oRequeteSite.specCleSecrete;
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
				o = attribuerRequeteSite(v, val);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.attribuerPourClasse(v, val);
			}
		}
		return o != null;
	}
	public Object attribuerRequeteSite(String var, Object val) throws Exception {
		RequeteSite oRequeteSite = (RequeteSite)this;		switch(var) {
		case "requeteSite": oRequeteSite.setRequeteSite((RequeteSite)val); return val;
		case "configSite": oRequeteSite.setConfigSite((ConfigSite)val); return val;
		case "ecouteurContexte": oRequeteSite.setEcouteurContexte((EcouteurContexte)val); return val;
		case "jetonAcces": oRequeteSite.setJetonAcces((AccessToken)val); return val;
		case "utilisateurNomDomaine": oRequeteSite.setUtilisateurNomDomaine((String)val); return val;
		case "utilisateurNomEnsemble": oRequeteSite.setUtilisateurNomEnsemble((String)val); return val;
		case "utilisateurSite": oRequeteSite.setUtilisateurSite((UtilisateurSite)val); return val;
		case "utilisateurId": oRequeteSite.setUtilisateurId((String)val); return val;
		case "utilisateurNom": oRequeteSite.setUtilisateurNom((String)val); return val;
		case "utilisateurNomFamille": oRequeteSite.setUtilisateurNomFamille((String)val); return val;
		case "utilisateurPrenom": oRequeteSite.setUtilisateurPrenom((String)val); return val;
		case "utilisateurNomComplet": oRequeteSite.setUtilisateurNomComplet((String)val); return val;
		case "utilisateurRolesRoyaume": oRequeteSite.setUtilisateurRolesRoyaume((HashSet<String>)val); return val;
		case "utilisateurRolesRessource": oRequeteSite.setUtilisateurRolesRessource((HashSet<String>)val); return val;
		case "xmlPile": oRequeteSite.setXmlPile((Stack<String>)val); return val;
		case "requete": oRequeteSite.setRequete((HttpServletRequest)val); return val;
		case "reponse": oRequeteSite.setReponse((HttpServletResponse)val); return val;
		case "solrDocument": oRequeteSite.setSolrDocument((SolrDocument)val); return val;
		case "ecrivain": oRequeteSite.setEcrivain((PrintWriter)val); return val;
		case "pageAchete": oRequeteSite.setPageAchete((Boolean)val); return val;
		case "pageAdmin": oRequeteSite.setPageAdmin((Boolean)val); return val;
		case "h": oRequeteSite.setH((String)val); return val;
		case "chiffrementCrypter": oRequeteSite.setChiffrementCrypter((Cipher)val); return val;
		case "chiffrementDecrypter": oRequeteSite.setChiffrementDecrypter((Cipher)val); return val;
		case "digestMessage": oRequeteSite.setDigestMessage((MessageDigest)val); return val;
		case "sel": oRequeteSite.setSel((String)val); return val;
		case "cle": oRequeteSite.setCle((byte[])val); return val;
		case "aleatoireSecurise": oRequeteSite.setAleatoireSecurise((SecureRandom)val); return val;
		case "specCleSecrete": oRequeteSite.setSpecCleSecrete((SecretKeySpec)val); return val;
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
					o = definirRequeteSite(v, val);
				else if(o instanceof Cluster) {
					Cluster cluster = (Cluster)o;
					o = cluster.definirPourClasse(v, val);
				}
			}
		}
		return o != null;
	}
	public Object definirRequeteSite(String var, String val) throws Exception {
		RequeteSite oRequeteSite = (RequeteSite)this;
		switch(var) {
		case "utilisateurNomDomaine":
			oRequeteSite.setUtilisateurNomDomaine(val);
			return val;
		case "utilisateurNomEnsemble":
			oRequeteSite.setUtilisateurNomEnsemble(val);
			return val;
		case "utilisateurId":
			oRequeteSite.setUtilisateurId(val);
			return val;
		case "utilisateurNom":
			oRequeteSite.setUtilisateurNom(val);
			return val;
		case "utilisateurNomFamille":
			oRequeteSite.setUtilisateurNomFamille(val);
			return val;
		case "utilisateurPrenom":
			oRequeteSite.setUtilisateurPrenom(val);
			return val;
		case "utilisateurNomComplet":
			oRequeteSite.setUtilisateurNomComplet(val);
			return val;
		case "h":
			oRequeteSite.setH(val);
			return val;
		case "sel":
			oRequeteSite.setSel(val);
			return val;
		default:
			return null;
		}
	}
}
