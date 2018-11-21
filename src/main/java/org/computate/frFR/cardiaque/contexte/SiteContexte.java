package org.computate.frFR.cardiaque.contexte;  

import org.apache.commons.lang3.StringUtils;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.computate.frFR.cardiaque.config.ConfigSite;
import org.computate.frFR.cardiaque.couverture.Couverture;
import org.computate.frFR.cardiaque.requete.RequeteSite;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.auth.oauth2.OAuth2Auth;
import io.vertx.ext.jdbc.JDBCClient;
import io.vertx.ext.sql.SQLClient;
import io.vertx.ext.web.Router;



public class SiteContexte extends SiteContexteGen<Object> { 

	protected Logger log = LoggerFactory.getLogger(getClass());

	protected void _vertx_(Couverture<Vertx> c) throws Exception {
	}

	protected void _siteAuth_(Couverture<OAuth2Auth> c) throws Exception {
	}

	protected void _siteRouteur_(Couverture<Router> c) throws Exception {
	}

	/**	Le config du site. **/
	protected void _configSite(ConfigSite o) throws Exception { 
			o.setSiteContexte_(this);
	}

	protected void _jdbcConfig(JsonObject o) throws Exception {
		if(StringUtils.isNotEmpty(configSite.getJdbcUrl()))
			o.put("url", configSite.getJdbcUrl());
		if(StringUtils.isNotEmpty(configSite.getJdbcClassePilote()))
			o.put("driver_class", configSite.getJdbcClassePilote());
		if(StringUtils.isNotEmpty(configSite.getJdbcUtilisateur()))
			o.put("user", configSite.getJdbcUtilisateur());
		if(StringUtils.isNotEmpty(configSite.getJdbcMotDePasse()))
			o.put("password", configSite.getJdbcMotDePasse());
		if(configSite.getJdbcTailleMaxPiscine() != null)
			o.put("max_pool_size", configSite.getJdbcTailleMaxPiscine());
		if(configSite.getJdbcTailleInitialePiscine() != null)
			o.put("initial_pool_size", configSite.getJdbcTailleInitialePiscine());
		if(configSite.getJdbcTailleMinPiscine() != null)
			o.put("min_pool_size", configSite.getJdbcTailleMinPiscine());
		if(configSite.getJdbcMaxDeclarations() != null)
			o.put("max_statements", configSite.getJdbcMaxDeclarations());
		if(configSite.getJdbcMaxDeclarationsParConnexion() != null)
			o.put("max_statements_per_connection", configSite.getJdbcMaxDeclarationsParConnexion());
		if(configSite.getJdbcTempsInactiviteMax() != null)
			o.put("max_idle_time", configSite.getJdbcTempsInactiviteMax());
	}

	/**	Le source de données du site. **/
	protected void _clientSql(Couverture<SQLClient> c) throws Exception {
		SQLClient o = JDBCClient.createShared(vertx_, jdbcConfig);
		c.o(o);
	}
//
//	/**	L'URL JNDI vers le source de courriels dans Tomcat. **/
//	protected void _urlSourceMail(Couverture<String> c) throws Exception {
//		String o = "java:comp/env/mail/Session";
//		c.o(o);
//	}
//
//	/**	Le source de courriels du site. **/
//	protected void _sessionCourriel(Couverture<Session> c) throws Exception {
//		try {
//			Session o = (Session)contexteInitiale.lookup(urlSourceMail);
//			c.o(o);
//		} catch(NamingException e) {
//			Properties proprietes = new Properties();
//			proprietes.setProperty("mail.smtp.host", urlSourceDonneesSimple);
//			Session o = Session.getInstance(proprietes);
//			c.o(o);
//		}
//	}

	/**	Le client du moteur de recherche SOLR. **/
	protected void _clientSolr(Couverture<HttpSolrClient> c) throws Exception {
		HttpSolrClient o = new HttpSolrClient.Builder(configSite.getSolrUrl()).build();
		c.o(o);
	}

	/**	Le sel de cryptage à utiliser pour tout cryptage. **/
	protected void _selCryptage(Couverture<String> c) throws Exception {
		String o = configSite.getSelCryptage();
		c.o(o);
	}

	/**	Le mot de passe de cryptage à utiliser pour tout cryptage. **/
	protected void _motDePasseCryptage(Couverture<String> c) throws Exception {
		String o = configSite.getMotDePasseCryptage();
		c.o(o);
	}

	/**	Le jeton d'identité Paypal pour valider des transactions Paypal. **/
	protected void _jetonIdentitePaypal(Couverture<String> c) throws Exception {
		String o = configSite.getJetonIdentitePaypal();
		c.o(o);
	}

	/**	Le nombre de fils pour executer des tâches daemon dans le site. **/
	protected void _nombreExecuteurs(Couverture<Integer> c) throws Exception {
		Integer o = configSite.getNombreExecuteurs();
		c.o(o);
	}

	/**	Tous les infos importants à propos de la requête actuelle. **/
	protected void _requeteSite_(RequeteSite o) throws Exception { 
//		o.configSite_ = configSite;
//		o.SiteContexte_ = this;
	}
}
