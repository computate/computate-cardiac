package com.heytate.frFR.cardiac.contexte;

import java.net.InetAddress;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.mail.Session;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;

import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.postgresql.ds.PGSimpleDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.heytate.frFR.cardiac.config.ConfigSite;
import com.heytate.frFR.cardiac.fil.DaemonFabriqueFil;
import com.heytate.frFR.cardiac.requete.RequeteSite;
import com.heytate.frFR.cardiaque.couverture.Couverture;

public class EcouteurContexte extends EcouteurContexteGen<Object> implements ServletContextListener { 

	protected Logger log = LoggerFactory.getLogger(getClass());

	public EcouteurContexte() { 
	}

	/**	Le chemin vers le config du site. **/
	protected void _cheminConfig(Couverture<String> c) throws Exception {
		try {
			String nomHoteSite = InetAddress.getLocalHost().getHostName();
			String o = "/srv/" + nomHoteSite + "/config/computate.org.config";
			c.o(o);
		} catch(Exception e) {
			throw new Exception("Impossible de trouver le nom d'hôte. ", e);
		}
	}

	/**	Le config du site. **/
	protected void _configSite(ConfigSite o) throws Exception { 
			o.cheminConfig(cheminConfig);
			o.ecouteurContexte(this);
	}

	/**	Le config du site. **/
	protected void _contexteInitiale(Couverture<InitialContext> c) throws Exception {
		try {
			InitialContext o = new InitialContext();
			c.o(o);
		} catch(NamingException e) {
			throw new Exception("Impossible de trouver le contexte initiale. ", e);
		}
	}

	/**	L'URL JNDI vers le source de données dans Tomcat. **/
	protected void _urlSourceDonnees(Couverture<String> c) throws Exception {
		String o = "java:comp/env/jdbc/computate.org";
		c.o(o);
	}

	/**	L'URL JDBC vers le soruce de données pour les tests unitaires. **/
	protected void _urlSourceDonneesSimple(Couverture<String> c) throws Exception {
		String o = configSite.urlSourceDonneesSimple;
		c.o(o);
	}

	/**	Le source de données du site. **/
	protected void _sourceDonnees(Couverture<DataSource> c) throws Exception {
		try {
			DataSource o = (DataSource)contexteInitiale.lookup(urlSourceDonnees);
			c.o(o);
		} catch(NamingException e) {
			PGSimpleDataSource o = new PGSimpleDataSource();
			o.setUrl(urlSourceDonneesSimple);
			c.o(o);
		}
	}

	/**	L'URL JNDI vers le source de courriels dans Tomcat. **/
	protected void _urlSourceMail(Couverture<String> c) throws Exception {
		String o = "java:comp/env/mail/Session";
		c.o(o);
	}

	/**	Le source de courriels du site. **/
	protected void _sessionCourriel(Couverture<Session> c) throws Exception {
		try {
			Session o = (Session)contexteInitiale.lookup(urlSourceMail);
			c.o(o);
		} catch(NamingException e) {
			Properties proprietes = new Properties();
			proprietes.setProperty("mail.smtp.host", urlSourceDonneesSimple);
			Session o = Session.getInstance(proprietes);
			c.o(o);
		}
	}

	/**	Le client du moteur de recherche SOLR. **/
	protected void _clientSolr(Couverture<HttpSolrClient> c) throws Exception {
		HttpSolrClient o = new HttpSolrClient.Builder(configSite.urlSolr).build();
		c.o(o);
	}

	/**	Le sel de cryptage à utiliser pour tout cryptage. **/
	protected void _selCryptage(Couverture<String> c) throws Exception {
		String o = configSite.selCryptage;
		c.o(o);
	}

	/**	Le mot de passe de cryptage à utiliser pour tout cryptage. **/
	protected void _motDePasseCryptage(Couverture<String> c) throws Exception {
		String o = configSite.motDePasseCryptage;
		c.o(o);
	}

	/**	Le jeton d'identité Paypal pour valider des transactions Paypal. **/
	protected void _jetonIdentitePaypal(Couverture<String> c) throws Exception {
		String o = configSite.jetonIdentitePaypal;
		c.o(o);
	}

	/**	Le nombre de fils pour executer des tâches daemon dans le site. **/
	protected void _nombreExecuteurs(Couverture<Integer> c) throws Exception {
		Integer o = configSite.nombreExecuteurs;
		c.o(o);
	}

	/**	Une fabrique daemon pour éxécuter des fis de fond. **/
	protected void _daemonFabriqueFil(Couverture<DaemonFabriqueFil> c) throws Exception {
		DaemonFabriqueFil o = new DaemonFabriqueFil();
		c.o(o);
	}

	/**	Un daemon pour éxécuter des fis de fond. **/
	protected void _serviceExecuteur(Couverture<ExecutorService> c) throws Exception {
		ExecutorService o;
		if (nombreExecuteurs <= 1)
			o = Executors.newSingleThreadExecutor(daemonFabriqueFil);
		else
			o = Executors.newFixedThreadPool(nombreExecuteurs, daemonFabriqueFil);
		c.o(o);
	}

	/**	Tous les infos importants à propos de la requête actuelle. **/
	protected void _requeteSite(RequeteSite o) throws Exception {
		o.configSite = configSite;
		o.ecouteurContexte = this;
	}

	@Override public void contextInitialized(ServletContextEvent evenement) { 
		try {
			EcouteurContexte c001EcouteurContexte = new EcouteurContexte();
			c001EcouteurContexte.initLoinEcouteurContexte();

			RequeteSite requeteSite = new RequeteSite();
			requeteSite.configSite(configSite);
			requeteSite.ecouteurContexte(this);
			requeteSite.initLoinRequeteSite();
			initLoinEcouteurContexte();
			ServletContext contexteServlet = evenement.getServletContext();
			contexteServlet.setAttribute("configSite", configSite);
			contexteServlet.setAttribute("jetonIdentitePaypal", jetonIdentitePaypal);
			contexteServlet.setAttribute("ecouteurContexte", this);
			contexteServlet.setAttribute("c000EcouteurContexte", this);
			contexteServlet.setAttribute("c001EcouteurContexte", c001EcouteurContexte);
			contexteServlet.setAttribute("contexteInitiale", contexteInitiale);
			contexteServlet.setAttribute("sourceDonnees", sourceDonnees);
			contexteServlet.setAttribute("sessionCourriel", sessionCourriel);
			contexteServlet.setAttribute("clientSolr", clientSolr);
			contexteServlet.setAttribute("nombreExecuteurs", nombreExecuteurs);
			contexteServlet.setAttribute("daemonFabriqueFil", daemonFabriqueFil);
			contexteServlet.setAttribute("serviceExecuteur", serviceExecuteur);
		} catch(Exception e) {
			throw new RuntimeException("Impossible de créer l'écouteur de contexte. ", e);
		}
	}

	@Override public void contextDestroyed(ServletContextEvent evenement) {
		if(serviceExecuteur != null)
			serviceExecuteur.shutdownNow();
	}
}
