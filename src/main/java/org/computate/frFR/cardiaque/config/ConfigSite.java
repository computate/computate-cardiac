package com.heytate.frFR.cardiaque.config;  

import org.apache.commons.configuration2.INIConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.heytate.frFR.cardiaque.contexte.EcouteurContexte;
import com.heytate.frFR.cardiaque.couverture.Couverture;
import com.heytate.frFR.cardiaque.requete.RequeteSite;

/**
 * nomCanonique.enUS: org.computate.enUS.java.SiteConfig
 * enUS: Loads the properties in the application config file into specific fields. 
 * frFR: Charge les propriétés dans le fichier de config de l'application dans des champs spécifiques. 
 */    
public class ConfigSite extends ConfigSiteGen<Object> {  

	/** do stuff **/
	protected Logger log = LoggerFactory.getLogger(getClass());


	/**	Tous les infos importants à propos de la requête actuelle. **/
	protected void _requeteSite(RequeteSite o) throws Exception {
	}
	@Override protected void requeteSiteInit() throws Exception {
	}

	/**	L'écouteur de contexte du site pour obtenir des objets globals du contexte. **/
	protected void _ecouteurContexte(Couverture<EcouteurContexte> c) throws Exception {
	}
	@Override protected void ecouteurContexteInit() throws Exception {
	} 

	/**	Le chemin vers le fichier de config du site. **/
	protected void _cheminConfig(Couverture<String> c) throws Exception {   
	}

	/**
	 * enUS: The Apache Commons Configurations object for reading config files. 
	 */
	protected void _configurations(Couverture<Configurations> c) throws Exception {  
		configurations = new Configurations();
	} 

	/**
	/**	
	 * r: fichierConfig
	 * r.enUS: configFile
	 * enUS: The INI Configuration Object for the config file. 
	 **/ 
	protected void _config(Couverture<INIConfiguration> c) throws Exception {
		config = configurations.ini(cheminConfig);
	}

	/**	Le nom du groupe principal du config pour ce site Web. **/
	protected void _identifiantSite(Couverture<String> c) throws Exception {
		String o = config.getString("appli");
		c.o(o);
	}

	/**	Le préfixe déjà échappé pour trouver des propriétés du site. **/
	protected void _prefixeEchappe(Couverture<String> c) throws Exception {
		String o = StringUtils.replace(identifiantSite, ".", "..") + ".";
		c.o(o);
	}

	/**	Le chemin vers le projet du site cloné de git. **/
	protected void _cheminProjet(Couverture<String> c) throws Exception {
		String o = config.getString(prefixeEchappe + "cheminProjet");
		c.o(o);
	}

	/**	Le chemin vers la racine de document pour le projet. **/
	protected void _racineDocument(Couverture<String> c) throws Exception {
		String o = config.getString(prefixeEchappe + "racineDocument");
		c.o(o);
	}

	/**	Le nom de l'entreprise. **/
	protected void _nomEntreprise(Couverture<String> c) throws Exception {
		String o = config.getString(prefixeEchappe + c.var);
		c.o(o);
	}

	/**	Le nom de domaine du site. **/
	protected void _nomDomaine(Couverture<String> c) throws Exception {
		String o = config.getString(prefixeEchappe + "nomDomaine");
		c.o(o);
	}

	/**	Le nom d'hôte du site. **/
	protected void _nomHoteSite(Couverture<String> c) throws Exception {
		String o = config.getString(prefixeEchappe + "nomHoteSite");
		c.o(o);
	}

	/**	L'ID client Keycloak du site. **/
	protected void _siteIdKeycloak(Couverture<String> c) throws Exception {
		String o = config.getString(prefixeEchappe + "siteIdKeycloak");
		c.o(o);
	}

	/**	Le sel de cryptage à utiliser pour tout cryptage. **/
	protected void _selCryptage(Couverture<String> c) throws Exception {
		String o = config.getString(prefixeEchappe + "selCryptage");
		c.o(o);
	}

	/**	Le mot de passe de cryptage à utiliser pour tout cryptage. **/
	protected void _motDePasseCryptage(Couverture<String> c) throws Exception {
		String o = config.getString(prefixeEchappe + "motDePasseCryptage");
		c.o(o);
	}

	/**	L'URL du domaine de base pour les URLs du site. **/
	protected void _urlDomaineBase(Couverture<String> c) throws Exception {
		String o = config.getString(prefixeEchappe + "urlDomaineBase");
		c.o(o);
	}

	/**	Le nom d'affichage du site. **/
	protected void _nomAffichageSite(Couverture<String> c) throws Exception {
		String o = config.getString(prefixeEchappe + "nomAffichageSite");
		c.o(o);
	}

	/**	L'URL JDBC vers le soruce de données pour les tests unitaires. **/
	protected void _urlSourceDonneesSimple(Couverture<String> c) throws Exception {
		String o = config.getString(prefixeEchappe + "urlSourceDonneesSimple");
		c.o(o);
	}

	/**	L'URL vers le moteur de recherche SOLR. **/
	protected void _urlSolr(Couverture<String> c) throws Exception {
		String o = config.getString(prefixeEchappe + "urlSolr");
		c.o(o);
	}

	/**	Le jeton d'identité Paypal pour valider des transactions Paypal. **/
	protected void _jetonIdentitePaypal(Couverture<String> c) throws Exception {
		String o = config.getString(prefixeEchappe + "jetonIdentitePaypal");
		c.o(o);
	}

	/**	Le compte Facebook pour le site. **/
	protected void _compteFacebook(Couverture<String> c) throws Exception {
		String o = config.getString(prefixeEchappe + "compteFacebook");
		c.o(o);
	}

	/**	Le compte Twitter pour le site. **/
	protected void _compteTwitter(Couverture<String> c) throws Exception {
		String o = config.getString(prefixeEchappe + "compteTwitter");
		c.o(o);
	}

	/**	Le compte Google Plus pour le site. **/
	protected void _compteGooglePlus(Couverture<String> c) throws Exception {
		String o = config.getString(prefixeEchappe + "compteGooglePlus");
		c.o(o);
	}

	/**	Le compte Instagram pour le site. **/
	protected void _compteInstagram(Couverture<String> c) throws Exception {
		String o = config.getString(prefixeEchappe + "compteInstagram");
		c.o(o);
	}

	/**	Le compte Youtube pour le site. **/
	protected void _compteYoutube(Couverture<String> c) throws Exception {
		String o = config.getString(prefixeEchappe + "compteYoutube");
		c.o(o);
	}

	/**	L'identifiant du canal Youtube pour le site. **/
	protected void _identifiantCanalYoutube(Couverture<String> c) throws Exception {
		String o = config.getString(prefixeEchappe + "identifiantCanalYoutube");
		c.o(o);
	}

	/**	Le compte Pinterest pour le site. **/
	protected void _comptePinterest(Couverture<String> c) throws Exception {
		String o = config.getString(prefixeEchappe + "comptePinterest");
		c.o(o);
	}

	/**	Le compte Open Clipart pour le site. **/
	protected void _compteOpenclipart(Couverture<String> c) throws Exception {
		String o = config.getString(prefixeEchappe + "compteOpenclipart");
		c.o(o);
	}

	/**	Le compte mail pour le site. **/
	protected void _compteMail(Couverture<String> c) throws Exception {
		String o = config.getString(prefixeEchappe + "compteMail");
		c.o(o);
	}

	/**	L'addresse mail pour l'administrateur du site pour les rapports d'erreur. **/
	protected void _mailAdmin(Couverture<String> c) throws Exception {
		String o = config.getString(prefixeEchappe + "mailAdmin");
		c.o(o);
	}

	/**	Le nombre de fils pour executer des tâches daemon dans le site. **/
	protected void _nombreExecuteurs(Couverture<Integer> c) throws Exception {
		Integer o = config.getInt(prefixeEchappe + "nombreExecuteurs");
		c.o(o);
	}
}
