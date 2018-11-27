package org.computate.frFR.cardiaque.requete;

import io.vertx.core.http.HttpServerRequest;
import org.computate.frFR.cardiaque.couverture.Couverture;
import org.computate.frFR.cardiaque.config.ConfigSite;
import org.apache.solr.common.SolrDocumentList;
import java.security.MessageDigest;
import org.computate.frFR.cardiaque.utilisateur.UtilisateurSite;
import javax.crypto.spec.SecretKeySpec;
import io.vertx.ext.web.RoutingContext;
import javax.crypto.Cipher;
import java.util.Stack;
import java.security.SecureRandom;
import java.lang.Long;
import org.computate.frFR.cardiaque.requete.RequeteSite;
import java.lang.Boolean;
import io.vertx.core.json.JsonObject;
import java.lang.String;
import org.computate.frFR.cardiaque.cluster.Cluster;
import org.apache.solr.client.solrj.response.QueryResponse;
import io.vertx.core.Vertx;
import org.computate.frFR.cardiaque.contexte.SiteContexte;
import org.apache.solr.common.SolrDocument;
import io.vertx.ext.auth.User;
import io.vertx.core.http.HttpServerResponse;
import org.apache.solr.client.solrj.SolrQuery;
import java.lang.Object;

public abstract class RequeteSiteGen<DEV> extends Object {

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

	public void setSiteContexte_(SiteContexte o) {
		this.siteContexte_ = o;
	}
	protected RequeteSite siteContexte_Init() throws Exception {
		if(!siteContexte_Couverture.dejaInitialise) {
			_siteContexte_(siteContexte_Couverture);
			if(siteContexte_ == null)
				setSiteContexte_(siteContexte_Couverture.o);
		}
		siteContexte_Couverture.dejaInitialise(true);
		return (RequeteSite)this;
	}

	////////////
	// vertx_ //
	////////////

	/**	L'entité « vertx_ »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected Vertx vertx_;
	public Couverture<Vertx> vertx_Couverture = new Couverture<Vertx>().p(this).c(Vertx.class).var("vertx_").o(vertx_);

	/**	L'entité « vertx_ »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _vertx_(Couverture<Vertx> o) throws Exception;

	public Vertx getVertx_() {
		return vertx_;
	}

	public void setVertx_(Vertx o) {
		this.vertx_ = o;
	}
	protected RequeteSite vertx_Init() throws Exception {
		if(!vertx_Couverture.dejaInitialise) {
			_vertx_(vertx_Couverture);
			if(vertx_ == null)
				setVertx_(vertx_Couverture.o);
		}
		vertx_Couverture.dejaInitialise(true);
		return (RequeteSite)this;
	}

	/////////////////////////
	// contexteItineraire_ //
	/////////////////////////

	/**	L'entité « contexteItineraire_ »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected RoutingContext contexteItineraire_;
	public Couverture<RoutingContext> contexteItineraire_Couverture = new Couverture<RoutingContext>().p(this).c(RoutingContext.class).var("contexteItineraire_").o(contexteItineraire_);

	/**	L'entité « contexteItineraire_ »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _contexteItineraire_(Couverture<RoutingContext> o) throws Exception;

	public RoutingContext getContexteItineraire_() {
		return contexteItineraire_;
	}

	public void setContexteItineraire_(RoutingContext o) {
		this.contexteItineraire_ = o;
	}
	protected RequeteSite contexteItineraire_Init() throws Exception {
		if(!contexteItineraire_Couverture.dejaInitialise) {
			_contexteItineraire_(contexteItineraire_Couverture);
			if(contexteItineraire_ == null)
				setContexteItineraire_(contexteItineraire_Couverture.o);
		}
		contexteItineraire_Couverture.dejaInitialise(true);
		return (RequeteSite)this;
	}

	////////////////////
	// rechercheSolr_ //
	////////////////////

	/**	L'entité « rechercheSolr_ »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected SolrQuery rechercheSolr_;
	public Couverture<SolrQuery> rechercheSolr_Couverture = new Couverture<SolrQuery>().p(this).c(SolrQuery.class).var("rechercheSolr_").o(rechercheSolr_);

	/**	L'entité « rechercheSolr_ »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _rechercheSolr_(Couverture<SolrQuery> o) throws Exception;

	public SolrQuery getRechercheSolr_() {
		return rechercheSolr_;
	}

	public void setRechercheSolr_(SolrQuery o) {
		this.rechercheSolr_ = o;
	}
	protected RequeteSite rechercheSolr_Init() throws Exception {
		if(!rechercheSolr_Couverture.dejaInitialise) {
			_rechercheSolr_(rechercheSolr_Couverture);
			if(rechercheSolr_ == null)
				setRechercheSolr_(rechercheSolr_Couverture.o);
		}
		rechercheSolr_Couverture.dejaInitialise(true);
		return (RequeteSite)this;
	}

	/////////////////
	// configSite_ //
	/////////////////

	/**	L'entité « configSite_ »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected ConfigSite configSite_;
	public Couverture<ConfigSite> configSite_Couverture = new Couverture<ConfigSite>().p(this).c(ConfigSite.class).var("configSite_").o(configSite_);

	/**	L'entité « configSite_ »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _configSite_(Couverture<ConfigSite> o) throws Exception;

	public ConfigSite getConfigSite_() {
		return configSite_;
	}

	public void setConfigSite_(ConfigSite o) {
		this.configSite_ = o;
	}
	protected RequeteSite configSite_Init() throws Exception {
		if(!configSite_Couverture.dejaInitialise) {
			_configSite_(configSite_Couverture);
			if(configSite_ == null)
				setConfigSite_(configSite_Couverture.o);
		}
		configSite_Couverture.dejaInitialise(true);
		return (RequeteSite)this;
	}

	//////////////////////
	// reponseRecherche //
	//////////////////////

	/**	L'entité « reponseRecherche »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected QueryResponse reponseRecherche;
	public Couverture<QueryResponse> reponseRechercheCouverture = new Couverture<QueryResponse>().p(this).c(QueryResponse.class).var("reponseRecherche").o(reponseRecherche);

	/**	L'entité « reponseRecherche »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _reponseRecherche(Couverture<QueryResponse> o) throws Exception;

	public QueryResponse getReponseRecherche() {
		return reponseRecherche;
	}

	public void setReponseRecherche(QueryResponse o) {
		this.reponseRecherche = o;
	}
	protected RequeteSite reponseRechercheInit() throws Exception {
		if(!reponseRechercheCouverture.dejaInitialise) {
			_reponseRecherche(reponseRechercheCouverture);
			if(reponseRecherche == null)
				setReponseRecherche(reponseRechercheCouverture.o);
		}
		reponseRechercheCouverture.dejaInitialise(true);
		return (RequeteSite)this;
	}

	////////////////////////
	// resultatsRecherche //
	////////////////////////

	/**	L'entité « resultatsRecherche »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected SolrDocumentList resultatsRecherche;
	public Couverture<SolrDocumentList> resultatsRechercheCouverture = new Couverture<SolrDocumentList>().p(this).c(SolrDocumentList.class).var("resultatsRecherche").o(resultatsRecherche);

	/**	L'entité « resultatsRecherche »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _resultatsRecherche(Couverture<SolrDocumentList> o) throws Exception;

	public SolrDocumentList getResultatsRecherche() {
		return resultatsRecherche;
	}

	public void setResultatsRecherche(SolrDocumentList o) {
		this.resultatsRecherche = o;
	}
	protected RequeteSite resultatsRechercheInit() throws Exception {
		if(!resultatsRechercheCouverture.dejaInitialise) {
			_resultatsRecherche(resultatsRechercheCouverture);
			if(resultatsRecherche == null)
				setResultatsRecherche(resultatsRechercheCouverture.o);
		}
		resultatsRechercheCouverture.dejaInitialise(true);
		return (RequeteSite)this;
	}

	//////////////////
	// requeteSite_ //
	//////////////////

	/**	L'entité « requeteSite_ »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected RequeteSite requeteSite_;
	public Couverture<RequeteSite> requeteSite_Couverture = new Couverture<RequeteSite>().p(this).c(RequeteSite.class).var("requeteSite_").o(requeteSite_);

	/**	L'entité « requeteSite_ »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _requeteSite_(Couverture<RequeteSite> o) throws Exception;

	public RequeteSite getRequeteSite_() {
		return requeteSite_;
	}

	public void setRequeteSite_(RequeteSite o) {
		this.requeteSite_ = o;
	}
	protected RequeteSite requeteSite_Init() throws Exception {
		if(!requeteSite_Couverture.dejaInitialise) {
			_requeteSite_(requeteSite_Couverture);
			if(requeteSite_ == null)
				setRequeteSite_(requeteSite_Couverture.o);
		}
		requeteSite_Couverture.dejaInitialise(true);
		return (RequeteSite)this;
	}

	////////////////////
	// requeteServeur //
	////////////////////

	/**	L'entité « requeteServeur »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected HttpServerRequest requeteServeur;
	public Couverture<HttpServerRequest> requeteServeurCouverture = new Couverture<HttpServerRequest>().p(this).c(HttpServerRequest.class).var("requeteServeur").o(requeteServeur);

	/**	L'entité « requeteServeur »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _requeteServeur(Couverture<HttpServerRequest> o) throws Exception;

	public HttpServerRequest getRequeteServeur() {
		return requeteServeur;
	}

	public void setRequeteServeur(HttpServerRequest o) {
		this.requeteServeur = o;
	}
	protected RequeteSite requeteServeurInit() throws Exception {
		if(!requeteServeurCouverture.dejaInitialise) {
			_requeteServeur(requeteServeurCouverture);
			if(requeteServeur == null)
				setRequeteServeur(requeteServeurCouverture.o);
		}
		requeteServeurCouverture.dejaInitialise(true);
		return (RequeteSite)this;
	}

	////////////////////
	// reponseServeur //
	////////////////////

	/**	L'entité « reponseServeur »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected HttpServerResponse reponseServeur;
	public Couverture<HttpServerResponse> reponseServeurCouverture = new Couverture<HttpServerResponse>().p(this).c(HttpServerResponse.class).var("reponseServeur").o(reponseServeur);

	/**	L'entité « reponseServeur »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _reponseServeur(Couverture<HttpServerResponse> o) throws Exception;

	public HttpServerResponse getReponseServeur() {
		return reponseServeur;
	}

	public void setReponseServeur(HttpServerResponse o) {
		this.reponseServeur = o;
	}
	protected RequeteSite reponseServeurInit() throws Exception {
		if(!reponseServeurCouverture.dejaInitialise) {
			_reponseServeur(reponseServeurCouverture);
			if(reponseServeur == null)
				setReponseServeur(reponseServeurCouverture.o);
		}
		reponseServeurCouverture.dejaInitialise(true);
		return (RequeteSite)this;
	}

	//////////////////////
	// utilisateurVertx //
	//////////////////////

	/**	L'entité « utilisateurVertx »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected User utilisateurVertx;
	public Couverture<User> utilisateurVertxCouverture = new Couverture<User>().p(this).c(User.class).var("utilisateurVertx").o(utilisateurVertx);

	/**	L'entité « utilisateurVertx »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _utilisateurVertx(Couverture<User> o) throws Exception;

	public User getUtilisateurVertx() {
		return utilisateurVertx;
	}

	public void setUtilisateurVertx(User o) {
		this.utilisateurVertx = o;
	}
	protected RequeteSite utilisateurVertxInit() throws Exception {
		if(!utilisateurVertxCouverture.dejaInitialise) {
			_utilisateurVertx(utilisateurVertxCouverture);
			if(utilisateurVertx == null)
				setUtilisateurVertx(utilisateurVertxCouverture.o);
		}
		utilisateurVertxCouverture.dejaInitialise(true);
		return (RequeteSite)this;
	}

	///////////////////
	// principalJson //
	///////////////////

	/**	L'entité « principalJson »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected JsonObject principalJson;
	public Couverture<JsonObject> principalJsonCouverture = new Couverture<JsonObject>().p(this).c(JsonObject.class).var("principalJson").o(principalJson);

	/**	L'entité « principalJson »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _principalJson(Couverture<JsonObject> o) throws Exception;

	public JsonObject getPrincipalJson() {
		return principalJson;
	}

	public void setPrincipalJson(JsonObject o) {
		this.principalJson = o;
	}
	protected RequeteSite principalJsonInit() throws Exception {
		if(!principalJsonCouverture.dejaInitialise) {
			_principalJson(principalJsonCouverture);
			if(principalJson == null)
				setPrincipalJson(principalJsonCouverture.o);
		}
		principalJsonCouverture.dejaInitialise(true);
		return (RequeteSite)this;
	}

	///////////////////////////
	// utilisateurNomDomaine //
	///////////////////////////

	/**	L'entité « utilisateurNomDomaine »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected String utilisateurNomDomaine;
	public Couverture<String> utilisateurNomDomaineCouverture = new Couverture<String>().p(this).c(String.class).var("utilisateurNomDomaine").o(utilisateurNomDomaine);

	/**	L'entité « utilisateurNomDomaine »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _utilisateurNomDomaine(Couverture<String> o) throws Exception;

	public String getUtilisateurNomDomaine() {
		return utilisateurNomDomaine;
	}

	public void setUtilisateurNomDomaine(String o) {
		this.utilisateurNomDomaine = o;
	}
	protected RequeteSite utilisateurNomDomaineInit() throws Exception {
		if(!utilisateurNomDomaineCouverture.dejaInitialise) {
			_utilisateurNomDomaine(utilisateurNomDomaineCouverture);
			if(utilisateurNomDomaine == null)
				setUtilisateurNomDomaine(utilisateurNomDomaineCouverture.o);
		}
		utilisateurNomDomaineCouverture.dejaInitialise(true);
		return (RequeteSite)this;
	}

	////////////////////////////
	// utilisateurNomEnsemble //
	////////////////////////////

	/**	L'entité « utilisateurNomEnsemble »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected String utilisateurNomEnsemble;
	public Couverture<String> utilisateurNomEnsembleCouverture = new Couverture<String>().p(this).c(String.class).var("utilisateurNomEnsemble").o(utilisateurNomEnsemble);

	/**	L'entité « utilisateurNomEnsemble »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _utilisateurNomEnsemble(Couverture<String> o) throws Exception;

	public String getUtilisateurNomEnsemble() {
		return utilisateurNomEnsemble;
	}

	public void setUtilisateurNomEnsemble(String o) {
		this.utilisateurNomEnsemble = o;
	}
	protected RequeteSite utilisateurNomEnsembleInit() throws Exception {
		if(!utilisateurNomEnsembleCouverture.dejaInitialise) {
			_utilisateurNomEnsemble(utilisateurNomEnsembleCouverture);
			if(utilisateurNomEnsemble == null)
				setUtilisateurNomEnsemble(utilisateurNomEnsembleCouverture.o);
		}
		utilisateurNomEnsembleCouverture.dejaInitialise(true);
		return (RequeteSite)this;
	}

	/////////////////////
	// utilisateurSite //
	/////////////////////

	/**	L'entité « utilisateurSite »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected UtilisateurSite utilisateurSite;
	public Couverture<UtilisateurSite> utilisateurSiteCouverture = new Couverture<UtilisateurSite>().p(this).c(UtilisateurSite.class).var("utilisateurSite").o(utilisateurSite);

	/**	L'entité « utilisateurSite »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _utilisateurSite(Couverture<UtilisateurSite> o) throws Exception;

	public UtilisateurSite getUtilisateurSite() {
		return utilisateurSite;
	}

	public void setUtilisateurSite(UtilisateurSite o) {
		this.utilisateurSite = o;
	}
	protected RequeteSite utilisateurSiteInit() throws Exception {
		if(!utilisateurSiteCouverture.dejaInitialise) {
			_utilisateurSite(utilisateurSiteCouverture);
			if(utilisateurSite == null)
				setUtilisateurSite(utilisateurSiteCouverture.o);
		}
		if(utilisateurSite != null)
			utilisateurSite.initLoinPourClasse(requeteSite_);
		utilisateurSiteCouverture.dejaInitialise(true);
		return (RequeteSite)this;
	}

	///////////////////
	// utilisateurId //
	///////////////////

	/**	L'entité « utilisateurId »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected String utilisateurId;
	public Couverture<String> utilisateurIdCouverture = new Couverture<String>().p(this).c(String.class).var("utilisateurId").o(utilisateurId);

	/**	L'entité « utilisateurId »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _utilisateurId(Couverture<String> o) throws Exception;

	public String getUtilisateurId() {
		return utilisateurId;
	}

	public void setUtilisateurId(String o) {
		this.utilisateurId = o;
	}
	protected RequeteSite utilisateurIdInit() throws Exception {
		if(!utilisateurIdCouverture.dejaInitialise) {
			_utilisateurId(utilisateurIdCouverture);
			if(utilisateurId == null)
				setUtilisateurId(utilisateurIdCouverture.o);
		}
		utilisateurIdCouverture.dejaInitialise(true);
		return (RequeteSite)this;
	}

	////////////////////
	// utilisateurNom //
	////////////////////

	/**	L'entité « utilisateurNom »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected String utilisateurNom;
	public Couverture<String> utilisateurNomCouverture = new Couverture<String>().p(this).c(String.class).var("utilisateurNom").o(utilisateurNom);

	/**	L'entité « utilisateurNom »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _utilisateurNom(Couverture<String> o) throws Exception;

	public String getUtilisateurNom() {
		return utilisateurNom;
	}

	public void setUtilisateurNom(String o) {
		this.utilisateurNom = o;
	}
	protected RequeteSite utilisateurNomInit() throws Exception {
		if(!utilisateurNomCouverture.dejaInitialise) {
			_utilisateurNom(utilisateurNomCouverture);
			if(utilisateurNom == null)
				setUtilisateurNom(utilisateurNomCouverture.o);
		}
		utilisateurNomCouverture.dejaInitialise(true);
		return (RequeteSite)this;
	}

	///////////////////////////
	// utilisateurNomFamille //
	///////////////////////////

	/**	L'entité « utilisateurNomFamille »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected String utilisateurNomFamille;
	public Couverture<String> utilisateurNomFamilleCouverture = new Couverture<String>().p(this).c(String.class).var("utilisateurNomFamille").o(utilisateurNomFamille);

	/**	L'entité « utilisateurNomFamille »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _utilisateurNomFamille(Couverture<String> o) throws Exception;

	public String getUtilisateurNomFamille() {
		return utilisateurNomFamille;
	}

	public void setUtilisateurNomFamille(String o) {
		this.utilisateurNomFamille = o;
	}
	protected RequeteSite utilisateurNomFamilleInit() throws Exception {
		if(!utilisateurNomFamilleCouverture.dejaInitialise) {
			_utilisateurNomFamille(utilisateurNomFamilleCouverture);
			if(utilisateurNomFamille == null)
				setUtilisateurNomFamille(utilisateurNomFamilleCouverture.o);
		}
		utilisateurNomFamilleCouverture.dejaInitialise(true);
		return (RequeteSite)this;
	}

	///////////////////////
	// utilisateurPrenom //
	///////////////////////

	/**	L'entité « utilisateurPrenom »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected String utilisateurPrenom;
	public Couverture<String> utilisateurPrenomCouverture = new Couverture<String>().p(this).c(String.class).var("utilisateurPrenom").o(utilisateurPrenom);

	/**	L'entité « utilisateurPrenom »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _utilisateurPrenom(Couverture<String> o) throws Exception;

	public String getUtilisateurPrenom() {
		return utilisateurPrenom;
	}

	public void setUtilisateurPrenom(String o) {
		this.utilisateurPrenom = o;
	}
	protected RequeteSite utilisateurPrenomInit() throws Exception {
		if(!utilisateurPrenomCouverture.dejaInitialise) {
			_utilisateurPrenom(utilisateurPrenomCouverture);
			if(utilisateurPrenom == null)
				setUtilisateurPrenom(utilisateurPrenomCouverture.o);
		}
		utilisateurPrenomCouverture.dejaInitialise(true);
		return (RequeteSite)this;
	}

	///////////////////////////
	// utilisateurNomComplet //
	///////////////////////////

	/**	L'entité « utilisateurNomComplet »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected String utilisateurNomComplet;
	public Couverture<String> utilisateurNomCompletCouverture = new Couverture<String>().p(this).c(String.class).var("utilisateurNomComplet").o(utilisateurNomComplet);

	/**	L'entité « utilisateurNomComplet »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _utilisateurNomComplet(Couverture<String> o) throws Exception;

	public String getUtilisateurNomComplet() {
		return utilisateurNomComplet;
	}

	public void setUtilisateurNomComplet(String o) {
		this.utilisateurNomComplet = o;
	}
	protected RequeteSite utilisateurNomCompletInit() throws Exception {
		if(!utilisateurNomCompletCouverture.dejaInitialise) {
			_utilisateurNomComplet(utilisateurNomCompletCouverture);
			if(utilisateurNomComplet == null)
				setUtilisateurNomComplet(utilisateurNomCompletCouverture.o);
		}
		utilisateurNomCompletCouverture.dejaInitialise(true);
		return (RequeteSite)this;
	}

	/////////////
	// xmlPile //
	/////////////

	/**	L'entité « xmlPile »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Stack<String>(). 
	 */
	protected Stack<String> xmlPile = new Stack<String>();
	public Couverture<Stack<String>> xmlPileCouverture = new Couverture<Stack<String>>().p(this).c(Stack.class).var("xmlPile").o(xmlPile);

	/**	L'entité « xmlPile »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Stack<String>(). 
	 *	@param xmlPile est le champ déjà construit. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _xmlPile(Stack<String> o) throws Exception;

	public Stack<String> getXmlPile() {
		return xmlPile;
	}

	public void setXmlPile(Stack<String> o) {
		this.xmlPile = o;
	}
	protected RequeteSite xmlPileInit() throws Exception {
		if(!xmlPileCouverture.dejaInitialise) {
			_xmlPile(xmlPile);
		}
		xmlPileCouverture.dejaInitialise(true);
		return (RequeteSite)this;
	}

	//////////////////
	// solrDocument //
	//////////////////

	/**	L'entité « solrDocument »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected SolrDocument solrDocument;
	public Couverture<SolrDocument> solrDocumentCouverture = new Couverture<SolrDocument>().p(this).c(SolrDocument.class).var("solrDocument").o(solrDocument);

	/**	L'entité « solrDocument »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _solrDocument(Couverture<SolrDocument> o) throws Exception;

	public SolrDocument getSolrDocument() {
		return solrDocument;
	}

	public void setSolrDocument(SolrDocument o) {
		this.solrDocument = o;
	}
	protected RequeteSite solrDocumentInit() throws Exception {
		if(!solrDocumentCouverture.dejaInitialise) {
			_solrDocument(solrDocumentCouverture);
			if(solrDocument == null)
				setSolrDocument(solrDocumentCouverture.o);
		}
		solrDocumentCouverture.dejaInitialise(true);
		return (RequeteSite)this;
	}

	////////////////
	// pageAchete //
	////////////////

	/**	L'entité « pageAchete »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected Boolean pageAchete;
	public Couverture<Boolean> pageAcheteCouverture = new Couverture<Boolean>().p(this).c(Boolean.class).var("pageAchete").o(pageAchete);

	/**	L'entité « pageAchete »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _pageAchete(Couverture<Boolean> o) throws Exception;

	public Boolean getPageAchete() {
		return pageAchete;
	}

	public void setPageAchete(Boolean o) {
		this.pageAchete = o;
	}
	public RequeteSite setPageAchete(String o) throws Exception {
		if(org.apache.commons.lang3.BooleanUtils.isTrue(org.apache.commons.lang3.BooleanUtils.toBoolean(o)))
			this.pageAchete = Boolean.parseBoolean(o);
		return (RequeteSite)this;
	}
	protected RequeteSite pageAcheteInit() throws Exception {
		if(!pageAcheteCouverture.dejaInitialise) {
			_pageAchete(pageAcheteCouverture);
			if(pageAchete == null)
				setPageAchete(pageAcheteCouverture.o);
		}
		pageAcheteCouverture.dejaInitialise(true);
		return (RequeteSite)this;
	}

	///////////////
	// pageAdmin //
	///////////////

	/**	L'entité « pageAdmin »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected Boolean pageAdmin;
	public Couverture<Boolean> pageAdminCouverture = new Couverture<Boolean>().p(this).c(Boolean.class).var("pageAdmin").o(pageAdmin);

	/**	L'entité « pageAdmin »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _pageAdmin(Couverture<Boolean> o) throws Exception;

	public Boolean getPageAdmin() {
		return pageAdmin;
	}

	public void setPageAdmin(Boolean o) {
		this.pageAdmin = o;
	}
	public RequeteSite setPageAdmin(String o) throws Exception {
		if(org.apache.commons.lang3.BooleanUtils.isTrue(org.apache.commons.lang3.BooleanUtils.toBoolean(o)))
			this.pageAdmin = Boolean.parseBoolean(o);
		return (RequeteSite)this;
	}
	protected RequeteSite pageAdminInit() throws Exception {
		if(!pageAdminCouverture.dejaInitialise) {
			_pageAdmin(pageAdminCouverture);
			if(pageAdmin == null)
				setPageAdmin(pageAdminCouverture.o);
		}
		pageAdminCouverture.dejaInitialise(true);
		return (RequeteSite)this;
	}

	///////
	// h //
	///////

	/**	L'entité « h »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected String h;
	public Couverture<String> hCouverture = new Couverture<String>().p(this).c(String.class).var("h").o(h);

	/**	L'entité « h »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _h(Couverture<String> o) throws Exception;

	public String getH() {
		return h;
	}

	public void setH(String o) {
		this.h = o;
	}
	protected RequeteSite hInit() throws Exception {
		if(!hCouverture.dejaInitialise) {
			_h(hCouverture);
			if(h == null)
				setH(hCouverture.o);
		}
		hCouverture.dejaInitialise(true);
		return (RequeteSite)this;
	}

	////////////////////////
	// chiffrementCrypter //
	////////////////////////

	/**	L'entité « chiffrementCrypter »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected Cipher chiffrementCrypter;
	public Couverture<Cipher> chiffrementCrypterCouverture = new Couverture<Cipher>().p(this).c(Cipher.class).var("chiffrementCrypter").o(chiffrementCrypter);

	/**	L'entité « chiffrementCrypter »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _chiffrementCrypter(Couverture<Cipher> o) throws Exception;

	public Cipher getChiffrementCrypter() {
		return chiffrementCrypter;
	}

	public void setChiffrementCrypter(Cipher o) {
		this.chiffrementCrypter = o;
	}
	protected RequeteSite chiffrementCrypterInit() throws Exception {
		if(!chiffrementCrypterCouverture.dejaInitialise) {
			_chiffrementCrypter(chiffrementCrypterCouverture);
			if(chiffrementCrypter == null)
				setChiffrementCrypter(chiffrementCrypterCouverture.o);
		}
		chiffrementCrypterCouverture.dejaInitialise(true);
		return (RequeteSite)this;
	}

	//////////////////////////
	// chiffrementDecrypter //
	//////////////////////////

	/**	L'entité « chiffrementDecrypter »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected Cipher chiffrementDecrypter;
	public Couverture<Cipher> chiffrementDecrypterCouverture = new Couverture<Cipher>().p(this).c(Cipher.class).var("chiffrementDecrypter").o(chiffrementDecrypter);

	/**	L'entité « chiffrementDecrypter »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _chiffrementDecrypter(Couverture<Cipher> o) throws Exception;

	public Cipher getChiffrementDecrypter() {
		return chiffrementDecrypter;
	}

	public void setChiffrementDecrypter(Cipher o) {
		this.chiffrementDecrypter = o;
	}
	protected RequeteSite chiffrementDecrypterInit() throws Exception {
		if(!chiffrementDecrypterCouverture.dejaInitialise) {
			_chiffrementDecrypter(chiffrementDecrypterCouverture);
			if(chiffrementDecrypter == null)
				setChiffrementDecrypter(chiffrementDecrypterCouverture.o);
		}
		chiffrementDecrypterCouverture.dejaInitialise(true);
		return (RequeteSite)this;
	}

	///////////////////
	// digestMessage //
	///////////////////

	/**	L'entité « digestMessage »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected MessageDigest digestMessage;
	public Couverture<MessageDigest> digestMessageCouverture = new Couverture<MessageDigest>().p(this).c(MessageDigest.class).var("digestMessage").o(digestMessage);

	/**	L'entité « digestMessage »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _digestMessage(Couverture<MessageDigest> o) throws Exception;

	public MessageDigest getDigestMessage() {
		return digestMessage;
	}

	public void setDigestMessage(MessageDigest o) {
		this.digestMessage = o;
	}
	protected RequeteSite digestMessageInit() throws Exception {
		if(!digestMessageCouverture.dejaInitialise) {
			_digestMessage(digestMessageCouverture);
			if(digestMessage == null)
				setDigestMessage(digestMessageCouverture.o);
		}
		digestMessageCouverture.dejaInitialise(true);
		return (RequeteSite)this;
	}

	////////////////
	// crypterSel //
	////////////////

	/**	L'entité « crypterSel »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected String crypterSel;
	public Couverture<String> crypterSelCouverture = new Couverture<String>().p(this).c(String.class).var("crypterSel").o(crypterSel);

	/**	L'entité « crypterSel »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _crypterSel(Couverture<String> o) throws Exception;

	public String getCrypterSel() {
		return crypterSel;
	}

	public void setCrypterSel(String o) {
		this.crypterSel = o;
	}
	protected RequeteSite crypterSelInit() throws Exception {
		if(!crypterSelCouverture.dejaInitialise) {
			_crypterSel(crypterSelCouverture);
			if(crypterSel == null)
				setCrypterSel(crypterSelCouverture.o);
		}
		crypterSelCouverture.dejaInitialise(true);
		return (RequeteSite)this;
	}

	///////////////
	// requetePk //
	///////////////

	/**	L'entité « requetePk »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected Long requetePk;
	public Couverture<Long> requetePkCouverture = new Couverture<Long>().p(this).c(Long.class).var("requetePk").o(requetePk);

	/**	L'entité « requetePk »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _requetePk(Couverture<Long> o) throws Exception;

	public Long getRequetePk() {
		return requetePk;
	}

	public void setRequetePk(Long o) {
		this.requetePk = o;
	}
	public RequeteSite setRequetePk(String o) throws Exception {
		if(org.apache.commons.lang3.math.NumberUtils.isCreatable(o))
			this.requetePk = Long.parseLong(o);
		return (RequeteSite)this;
	}
	protected RequeteSite requetePkInit() throws Exception {
		if(!requetePkCouverture.dejaInitialise) {
			_requetePk(requetePkCouverture);
			if(requetePk == null)
				setRequetePk(requetePkCouverture.o);
		}
		requetePkCouverture.dejaInitialise(true);
		return (RequeteSite)this;
	}

	////////////////
	// crypterCle //
	////////////////

	/**	L'entité « crypterCle »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected byte[] crypterCle;
	public Couverture<byte[]> crypterCleCouverture = new Couverture<byte[]>().p(this).c(byte[].class).var("crypterCle").o(crypterCle);

	/**	L'entité « crypterCle »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _crypterCle(Couverture<byte[]> o) throws Exception;

	public byte[] getCrypterCle() {
		return crypterCle;
	}

	public void setCrypterCle(byte[] o) {
		this.crypterCle = o;
	}
	protected RequeteSite crypterCleInit() throws Exception {
		if(!crypterCleCouverture.dejaInitialise) {
			_crypterCle(crypterCleCouverture);
			if(crypterCle == null)
				setCrypterCle(crypterCleCouverture.o);
		}
		crypterCleCouverture.dejaInitialise(true);
		return (RequeteSite)this;
	}

	///////////////////////
	// aleatoireSecurise //
	///////////////////////

	/**	L'entité « aleatoireSecurise »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut SecureRandom(). 
	 */
	protected SecureRandom aleatoireSecurise = new SecureRandom();
	public Couverture<SecureRandom> aleatoireSecuriseCouverture = new Couverture<SecureRandom>().p(this).c(SecureRandom.class).var("aleatoireSecurise").o(aleatoireSecurise);

	/**	L'entité « aleatoireSecurise »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut SecureRandom(). 
	 *	@param aleatoireSecurise est le champ déjà construit. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _aleatoireSecurise(SecureRandom o) throws Exception;

	public SecureRandom getAleatoireSecurise() {
		return aleatoireSecurise;
	}

	public void setAleatoireSecurise(SecureRandom o) {
		this.aleatoireSecurise = o;
	}
	protected RequeteSite aleatoireSecuriseInit() throws Exception {
		if(!aleatoireSecuriseCouverture.dejaInitialise) {
			_aleatoireSecurise(aleatoireSecurise);
		}
		aleatoireSecuriseCouverture.dejaInitialise(true);
		return (RequeteSite)this;
	}

	////////////////////
	// specCleSecrete //
	////////////////////

	/**	L'entité « specCleSecrete »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected SecretKeySpec specCleSecrete;
	public Couverture<SecretKeySpec> specCleSecreteCouverture = new Couverture<SecretKeySpec>().p(this).c(SecretKeySpec.class).var("specCleSecrete").o(specCleSecrete);

	/**	L'entité « specCleSecrete »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _specCleSecrete(Couverture<SecretKeySpec> o) throws Exception;

	public SecretKeySpec getSpecCleSecrete() {
		return specCleSecrete;
	}

	public void setSpecCleSecrete(SecretKeySpec o) {
		this.specCleSecrete = o;
	}
	protected RequeteSite specCleSecreteInit() throws Exception {
		if(!specCleSecreteCouverture.dejaInitialise) {
			_specCleSecrete(specCleSecreteCouverture);
			if(specCleSecrete == null)
				setSpecCleSecrete(specCleSecreteCouverture.o);
		}
		specCleSecreteCouverture.dejaInitialise(true);
		return (RequeteSite)this;
	}

	/////////////////////
	// initialiserLoin //
	/////////////////////

	protected boolean dejaInitialiseRequeteSite = false;

	public RequeteSite initLoinRequeteSite(RequeteSite requeteSite) throws Exception {
		setRequeteSite_(requeteSite);
		initLoinRequeteSite();
		return (RequeteSite)this;
	}

	public RequeteSite initLoinRequeteSite() throws Exception {
		if(!dejaInitialiseRequeteSite) {
			siteContexte_Init();
			vertx_Init();
			contexteItineraire_Init();
			rechercheSolr_Init();
			configSite_Init();
			reponseRechercheInit();
			resultatsRechercheInit();
			requeteSite_Init();
			requeteServeurInit();
			reponseServeurInit();
			utilisateurVertxInit();
			principalJsonInit();
			utilisateurNomDomaineInit();
			utilisateurNomEnsembleInit();
			utilisateurSiteInit();
			utilisateurIdInit();
			utilisateurNomInit();
			utilisateurNomFamilleInit();
			utilisateurPrenomInit();
			utilisateurNomCompletInit();
			xmlPileInit();
			solrDocumentInit();
			pageAcheteInit();
			pageAdminInit();
			hInit();
			chiffrementCrypterInit();
			chiffrementDecrypterInit();
			digestMessageInit();
			crypterSelInit();
			requetePkInit();
			crypterCleInit();
			aleatoireSecuriseInit();
			specCleSecreteInit();
			dejaInitialiseRequeteSite = true;
		}
		return (RequeteSite)this;
	}

	public void initLoinPourClasse(RequeteSite requeteSite) throws Exception {
		initLoinRequeteSite(requeteSite);
	}

	/////////////////
	// requeteSite //
	/////////////////

	public void requeteSiteRequeteSite(RequeteSite requeteSite) throws Exception {
		utilisateurSite.setRequeteSite_(requeteSite);
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
			case "siteContexte_":
				return oRequeteSite.siteContexte_;
			case "vertx_":
				return oRequeteSite.vertx_;
			case "contexteItineraire_":
				return oRequeteSite.contexteItineraire_;
			case "rechercheSolr_":
				return oRequeteSite.rechercheSolr_;
			case "configSite_":
				return oRequeteSite.configSite_;
			case "reponseRecherche":
				return oRequeteSite.reponseRecherche;
			case "resultatsRecherche":
				return oRequeteSite.resultatsRecherche;
			case "requeteSite_":
				return oRequeteSite.requeteSite_;
			case "requeteServeur":
				return oRequeteSite.requeteServeur;
			case "reponseServeur":
				return oRequeteSite.reponseServeur;
			case "utilisateurVertx":
				return oRequeteSite.utilisateurVertx;
			case "principalJson":
				return oRequeteSite.principalJson;
			case "utilisateurNomDomaine":
				return oRequeteSite.utilisateurNomDomaine;
			case "utilisateurNomEnsemble":
				return oRequeteSite.utilisateurNomEnsemble;
			case "utilisateurSite":
				return oRequeteSite.utilisateurSite;
			case "utilisateurId":
				return oRequeteSite.utilisateurId;
			case "utilisateurNom":
				return oRequeteSite.utilisateurNom;
			case "utilisateurNomFamille":
				return oRequeteSite.utilisateurNomFamille;
			case "utilisateurPrenom":
				return oRequeteSite.utilisateurPrenom;
			case "utilisateurNomComplet":
				return oRequeteSite.utilisateurNomComplet;
			case "xmlPile":
				return oRequeteSite.xmlPile;
			case "solrDocument":
				return oRequeteSite.solrDocument;
			case "pageAchete":
				return oRequeteSite.pageAchete;
			case "pageAdmin":
				return oRequeteSite.pageAdmin;
			case "h":
				return oRequeteSite.h;
			case "chiffrementCrypter":
				return oRequeteSite.chiffrementCrypter;
			case "chiffrementDecrypter":
				return oRequeteSite.chiffrementDecrypter;
			case "digestMessage":
				return oRequeteSite.digestMessage;
			case "crypterSel":
				return oRequeteSite.crypterSel;
			case "requetePk":
				return oRequeteSite.requetePk;
			case "crypterCle":
				return oRequeteSite.crypterCle;
			case "aleatoireSecurise":
				return oRequeteSite.aleatoireSecurise;
			case "specCleSecrete":
				return oRequeteSite.specCleSecrete;
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
		RequeteSite oRequeteSite = (RequeteSite)this;
		switch(var) {
			default:
				return null;
		}
	}
}
