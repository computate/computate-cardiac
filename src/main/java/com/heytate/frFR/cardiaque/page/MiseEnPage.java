package com.heytate.frFR.cardiaque.page;

import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.reflect.MethodUtils;

import com.heytate.frFR.cardiac.chaine.Chaine;
import com.heytate.frFR.cardiaque.couverture.Couverture;
import com.heytate.frFR.cardiaque.page.parti.PageParti;
import com.heytate.frFR.cardiaque.requete.RequeteSite;
import com.heytate.frFR.cardiaque.xml.OutilXml;

public class MiseEnPage extends MiseEnPageGen<Object> {

	/**
	 * var.enUS: HTML_CLOSED_ELEMENTS
	 */
	public static List<String> HTML_ELEMENTS_FERMES = Arrays.asList("area", "base", "br", "col", "command", "embed", "hr", "img", "input", "keygen", "link", "meta", "param", "source", "track", "wbr");
	public static List<String> HTML_ELEMENTS_NO_WRAP = Arrays.asList("script", "span", "a", "b", "i", "u", "title", "use", "h1", "h2", "h3", "h4", "h5", "h6", "pre", "p");

	/**
	 * r: d MMM yyyy H'h'mm
	 * r.enUS: MMM d yyyy h:mm a
	 * r: Locale.FRANCE
	 * r.enUS: Locale.US
	 */
	public static DateTimeFormatter formatDateHeureCourt = DateTimeFormatter.ofPattern("d MMM yyyy H'h'mm", Locale.FRANCE);

	/**
	 * r: EEE d MMM yyyy
	 * r.enUS: EEE MMM d yyyy
	 * r: Locale.FRANCE
	 * r.enUS: Locale.US
	 */
	public static DateTimeFormatter formatDateCourt = DateTimeFormatter.ofPattern("EEE d MMM yyyy", Locale.FRANCE);

	/**
	 * r: EEEE d MMMM yyyy H'h'mm
	 * r.enUS: EEEE MMMM d yyyy h:mm a
	 * r: Locale.FRANCE
	 * r.enUS: Locale.US
	 */
	public static DateTimeFormatter formatAffichage = DateTimeFormatter.ofPattern("EEEE d MMMM yyyy H'h'mm", Locale.FRANCE);

	protected void _pagePartis(ArrayList<PageParti> l) throws Exception {}

	protected void _requeteSite(Couverture<RequeteSite> c) {}

	/**
	 * var.enUS: _writer
	 * frFR: L'écrivain pour écrirer le résultat du réponse. 
	 * remplacer.enUS: requeteSite
	 * siteRequest
	 * remplacer.enUS: ecrivain
	 * writer
	 */
	protected void _ecrivain(Couverture<PrintWriter> c) throws Exception {
		c.o(requeteSite.ecrivain);
	}

	/**
	 * var.enUS: _pageCanonicalName
	 * frFR: Le nom canonique de cette classe Java pour la page. 
	 * frFR: Le servlet va rechercher l'URL et construire une nouvelle page de ce type. 
	 * indexe: true
	 * stocke: true
	 */
	protected void _pageNomCanonique(Couverture<String> c) throws Exception {
		c.o(getClass().getCanonicalName());
	}

	/**
	 * var.enUS: _pageSimpleName
	 * frFR: Le nom simple de cette classe Java pour la page. 
	 * frFR: Le servlet va rechercher l'URL et construire une nouvelle page de ce type. 
	 * indexe: true
	 * stocke: true
	 */
	protected void _pageNomSimple(Couverture<String> c) throws Exception {
		c.o(getClass().getSimpleName());
	}

	/**
	 * frFR: Choisir si cette page est trouvée dans le /sitemap.xml.
	 * frFR: Si true, les bots de Google, Bing, Yahoo peuvent trouver la page. 
	 * indexe: true
	 * stocke: true
	 */
	protected void _pageVisibleAuxBots(Couverture<Boolean> c) throws Exception {
		c.o(true);
	}

	/**
	 * indexe: true
	 * stocke: true
	 */
	protected void _pageH1Cours(Chaine o) throws Exception {
	}

	/**
	 * indexe: true
	 * stocke: true
	 */
	protected void _pageH2Cours(Chaine o) throws Exception {
	}

	/**
	 * indexe: true
	 * stocke: true
	 */
	protected void _pageH1(Chaine o) throws Exception {
		o.tout(pageH1Cours);
	}

	/**
	 * var.enUS: _pageH1Short
	 */
	protected void _pageH1Court(Chaine o) throws Exception {
		o.tout(pageH1);
	}

	/**
	 * indexe: true
	 * stocke: true
	 */
	protected void _pageH2(Chaine o) throws Exception {
		o.tout(pageH2Cours);
	}

	/**
	 * var.enUS: _pageH2Short
	 */
	protected void _pageH2Court(Chaine o) throws Exception {
		o.tout(pageH2);
	}

	/**
	 * indexe: true
	 * stocke: true
	 */
	protected void _pageTitre(Chaine o) throws Exception {
		o.tout(pageH1, pageH2);
	}

	protected void _coursIdentifiantUri(Chaine o) throws Exception {}

	protected void _leconIdentifiantUri(Chaine o) throws Exception {}

	/**	la version plus courte de l'URL qui commence avec « / » 
	 * indexe: true
		stocke: true
	 * **/
	protected void _pageUri(Couverture<String> c) throws Exception {
	}

	/**
	 * var.enUS: _key
	 * frFR: la version plus courte de l'URL en français qui commence avec « / » 
	 * cleUnique: true
	 * remplacer.enUS: pageNomCanonique
	 * pageCanonicalName
	 */
	protected void _cle(Couverture<String> c) throws Exception {
		c.o(pageNomCanonique);
	}

	/**	Tous les URIs ensemble pour toutes les langues dans cette liste. 
	 * indexe: true
	 * stocke: true
	 * **/
	protected void _pageUris(ArrayList<String> l) throws Exception {
		l.add(pageUri.toString());
		l.add(pageUri + "/");
		l.add(pageUri + ".recapituler.html");
		l.add(pageUri + ".sh");
		l.add(pageUri + ".sh.html");
	}

	/**
	 * frFR: la version plus courte de l'URL. 
	 * indexe: true
	 * stocke: true
	 */
	protected void _pageUri(Chaine o) throws Exception {
		if(o.estVide())
			o.tout(pageUri);
	}

	/**
	 * frFR: l'URL complet. 
	 * indexe: true
	 * stocke: true
	 * remplacer.enUS: requeteSite
	 * siteRequest
	 * remplacer.enUS: configSite
	 * siteConfig
	 * remplacer.enUS: nomHoteSite
	 * siteHostName
	 * remplacer.enUS: requete
	 * request
	 */ 
	protected void _pageUrl(Chaine o) throws Exception {
		if(requeteSite.requete != null) {
			String q = requeteSite.requete.getQueryString();
			if(o.estVide())
				o.tout("https://", requeteSite.configSite.nomHoteSite, pageUri, (StringUtils.isEmpty(q) ? "" : "?" + q));
		}
	}

	/**
	 * frFR: l'URI courte vers l'image. 
	 * indexe: true
	 * stocke: true
	 */
	protected void _pageImageUri(Chaine o) throws Exception {
	}

	/**
	 * frFR: l'URL complet vers l'image. 
	 * indexe: true
	 * stocke: true
	 * remplacer.enUS: requeteSite
	 * siteRequest
	 * remplacer.enUS: configSite
	 * siteConfig
	 * remplacer.enUS: nomHoteSite
	 * siteHostName
	 */
	protected void _pageImageUrl(Chaine o) throws Exception {
		if(o.estVide())
			o.tout("https://", requeteSite.configSite.nomHoteSite, pageImageUri);
	}

	/**
	 * frFR: l'ID Youtube du video. 
	 * indexe: true
	 * stocke: true
	 * remplacer.enUS: requeteSite
	 * siteRequest
	 * remplacer.enUS: configSite
	 * siteConfig
	 * remplacer.enUS: nomHoteSite
	 * siteHostName
	 */
	protected void _pageVideoId(Chaine o) throws Exception {
	}

	/**
	 * frFR: l'URL complet vers le video. 
	 * indexe: true
	 * stocke: true
	 * remplacer.enUS: requeteSite
	 * siteRequest
	 * remplacer.enUS: configSite
	 * siteConfig
	 * remplacer.enUS: nomHoteSite
	 * siteHostName
	 */
	protected void _pageVideoUrl(Chaine o) throws Exception {
		if(pageVideoId.pasVide()) {
			o.tout("https://youtu.be/", pageVideoId);
		}
	}

	/**
	 * frFR: l'URL embed vers le video. 
	 * indexe: true
	 * stocke: true
	 * remplacer.enUS: requeteSite
	 * siteRequest
	 * remplacer.enUS: configSite
	 * siteConfig
	 * remplacer.enUS: nomHoteSite
	 * siteHostName
	 */
	protected void _pageVideoUrlEmbed(Chaine o) throws Exception {
		if(pageVideoId.pasVide()) {
			o.tout("https://www.youtube.com/embed/", pageVideoId);
		}
	}

	/**
	 * var.enUS: _pageImageWidth
	 * frFR: Le longeur de l'image. 
	 * indexe: true
	 * stocke: true
	 */
	protected void _pageImageLargeur(Couverture<Integer> c) throws Exception {
	}

	/**
	 * var.enUS: _pageImageHeight
	 * frFR: Le hauteur de l'image. 
	 * indexe: true
	 * stocke: true
	 */
	protected void _pageImageHauteur(Couverture<Integer> c) throws Exception {
	}

	/**
	 * var.enUS: _pageImageContentType
	 * frFR: Le type de contenu de l'image. 
	 * indexe: true
	 * stocke: true
	 */
	protected void _pageImageTypeContenu(Couverture<String> c) throws Exception {
	}

	/**
	 * remplacer.enUS: requeteSite
	 * siteRequest
	 * remplacer.enUS: utilisateurRolesContient
	 * userRolesContain
	 */
	protected void _pageAdmin(Couverture<Boolean> c) throws Exception {  
		Boolean o = requeteSite.utilisateurRolesContient("SiteAdmin");
		c.o(o);
		requeteSite.pageAdmin(o);
	}

	/** 
	 * var.enUS: _pageMethod
	 * remplacer.enUS: requeteSite.requete
	 * siteRequest.request
	 * Le nom du méthode à appeler pour charger la page. 
	 * indexe: true
	 * stocke: true
	 */
	protected void _pageMethode(Couverture<String> c) throws Exception {
		if(requeteSite.requete != null) {
			String uri = requeteSite.requete.getRequestURI();
			if(uri.endsWith(".recapituler.html"))
				c.o("htmlRecapituler");
			else if(uri.endsWith(".sh.html"))
				c.o("shHtml" + getClass().getSimpleName());
			else if(uri.endsWith(".sh"))
				c.o("sh" + getClass().getSimpleName());
			else
				c.o("html" + getClass().getSimpleName());
		}
		else
			c.o("html" + getClass().getSimpleName());
	}

	/**
	 * var.enUS: _pageContentType
	 * frFR: Le type de contenu de la page. 
	 * indexe: true
	 * stocke: true
	 * remplacer.enUS: requeteSite
	 * siteRequest
	 * remplacer.enUS: requete
	 * request
	 */
	protected void _pageTypeContenu(Couverture<String> c) throws Exception {
		if(requeteSite.requete != null && requeteSite.requete.getRequestURI().endsWith(".svg"))
			c.o("image/svg+xml");
		if(requeteSite.requete != null && requeteSite.requete.getRequestURI().endsWith(".sh.html"))
			c.o("text/html;charset=UTF-8");
		if(requeteSite.requete != null && requeteSite.requete.getRequestURI().endsWith(".sh"))
			c.o("text/x-shellscript");
		else
			c.o("text/html;charset=UTF-8");
	}

	/**
	 * frFR: l'ID unique pour SOLR. 
	 */
	protected void _id(Couverture<String> c) throws Exception {
		c.o(pageUri.toString());
	}

	protected void _pageCreeCours(Couverture<LocalDateTime> c) throws Exception {   
		LocalDateTime o = LocalDateTime.now();
		c.o(o);
	}

	/**
	 * var.enUS: _pageCreated
	 * indexe: true
	 * stocke: true
	 */
	protected void _pageCree(Couverture<LocalDateTime> c) throws Exception {   
		c.o(pageCreeCours);
	}

	/**
	 * var.enUS: _pageModified
	 * remplacer.enUS: pageCree
	 * pageCreated
	 */
	protected void _pageModifiee(Couverture<LocalDateTime> c) throws Exception {
		LocalDateTime o = pageCree;
		c.o(o);
	}

	/**
	 * incremente: true
	 */
	protected void _pageAime(Couverture<Long> c) throws Exception {}

	protected void _pageAimee(Couverture<Boolean> c) throws Exception {
		if(requeteSite.requete != null) {
			HttpSession session = requeteSite.requete.getSession();
			if(session != null) {
				String attribut = "aime_" + getClass().getCanonicalName();
				Object valeurSession = session.getAttribute(attribut);
				c.o(valeurSession != null);
			}
		}
	}

	/**
	 * var.enUS: _pageKeywords
	 * indexe: true
	 * stocke: true
	 */
	protected void _pageMotsCles(Chaine o) throws Exception {
	}

	/**
	 * indexe: true
	 * stocke: true
	 */
	protected void _pageDescription(Chaine o) throws Exception {
	}

	/**
	 * var.enUS: _homePageUri
	 */
	protected void _pageAccueilUri(Chaine o) throws Exception {
		o.tout("");
	}

	protected void _pageBlogUri(Chaine o) throws Exception {
		o.tout("/blog");
	}

	/**
	 * var.enUS: _aboutPageUri
	 * remplacer.enUS: apropos
	 * about
	 */
	protected void _pageAProposUri(Chaine o) throws Exception {
		o.tout("/apropos");
	}

	protected void _pageFaqUri(Chaine o) throws Exception {
		o.tout("/faq");
	}

	/**
	 * var.enUS: _userPageUri
	 * remplacer.enUS: utilisateur
	 * user
	 */
	protected void _pageUtilisateurUri(Chaine o) throws Exception {
		o.tout("/utilisateur");
	}

	/**
	 * var.enUS: _logoutPageUri
	 * remplacer.enUS: deconnexion
	 * logout
	 */
	protected void _pageDeconnexionUri(Chaine o) throws Exception {
		o.tout("/deconnexion");
	}

	protected void _pageCoursUri(Chaine o) throws Exception {
		o.tout("/cours");
	}

	/** 
	 * remplacer.enUS: requeteSite
	 * siteRequest
	 * remplacer.enUS: configSite
	 * siteConfig
	 * remplacer.enUS: identifiantCanalYoutube
	 * youtubeChannelIdentifier
	 */
	protected void _pageYoutubeUrl(Chaine o) throws Exception {
		o.tout("https://www.youtube.com/channel/UC3ryOB2snhO7fItkx6dGx2Q");
	}

	/** 
	 * remplacer.enUS: requeteSite
	 * siteRequest
	 * remplacer.enUS: configSite
	 * siteConfig
	 * remplacer.enUS: comptePinterest
	 * pinterestAccount
	 */
	protected void _pagePinterestUrl(Chaine o) throws Exception {
		o.tout("https://www.pinterest.com/computateorg/computate-en-fran%C3%A7ais/");
	}

	/**
	 * var.enUS: _requestKey
	 * remplacer.enUS: requeteSite
	 * siteRequest
	 * remplacer.enUS: requete
	 * request
	 */
	protected void _cleRequete(Couverture<Long> c) {
		if(requeteSite.requete != null) {
			Long o = NumberUtils.toLong(requeteSite.requete.getParameter("key"));
			if(o > 0L)
				c.o(o);
		}
	}

	/**
	 * var.enUS: _requestKey
	 * remplacer.enUS: requeteSite
	 * siteRequest
	 * remplacer.enUS: requete
	 * request
	 */
	public void pagePartisHtml() throws Exception {
		e("h1").f().toutXml(pageH1).g("h1");
		e("h2").f().toutXml(pageH2).g("h2");
		for(int i = 0; i < pagePartis.size(); i++) {
			PageParti parti = pagePartis.get(i);
			parti.html();
//			e("h1").f().tout(parti.partiH3Court()).g("h1");
//			e("h2").f().tout(parti.partiH4Court()).g("h2");
		}
	}

	public void pageRecapituler() throws Exception {
		e("fieldset").a("class", "htmlCourt-fieldset ").f();
			e("legend").a("class", "htmlCourt-legend ").f();
				e("h2").a("class", "htmlCourt-h2 ").f();
					enUSXml("To review: ");
					frFRXml("À récapituler : ");
				g("h2");
			g("legend");
			pageRecapitulerDedans();
		g("fieldset");
	}

	public void pageRecapitulerDedans() throws Exception {
			String var = requeteSite.requete.getParameter("var");
			if(!StringUtils.isEmpty(var)) {
				try {
					PageParti parti = (PageParti)obtenirPourClasse(var);
					e("div").a("class", "w3-container ").a("style", "font-size: 1.5em; ").f();
						MethodUtils.invokeExactMethod(this, var + "Html");
					g("div");
				} catch(Exception e) {
					e.toString();
				}
			}
			else {
				e("h1").f().toutXml(pageH1Court).g("h1");
				e("h2").f().toutXml(pageH2Court).g("h2");
				e("div").a("class", "w3-row ").f();
					int j = 0;
					for(int i = 0; i < pagePartis.size(); i++) {
						PageParti parti = pagePartis.get(i);
						Chaine h3 = null;
						if(parti instanceof Cmd)
							h3 = ((Cmd)parti).h3;
						if(parti instanceof QuestionReponse)
							h3 = ((QuestionReponse)parti).question;
						if(h3 != null && h3.pasVide()) {
							if(j > 0 && j % 2 == 0) {
								g("div");
								e("div").a("class", "w3-row ").f();
							}
							e("div").a("class", "w3-half ").f();
								parti.htmlCourt();
							g("div");
							j++;
						}
			//			e("h1").f().tout(parti.partiH3Court()).g("h1");
			//			e("h2").f().tout(parti.partiH4Court()).g("h2");
					}
				g("div");
				abondonnezPas();
			}
	}

	/** 
	 * remplacer.enUS: Home 
	 * Accueil 
	 * remplacer.enUS: toutXml
	 * allXml
	 */
	public void menu() throws Exception {
		e("div").a("class", "w3-bar w3-text-white w3-card-2 w3-padding-bottom-8 w3-padding-top-8 ").a("style", "padding-left: 16px; padding-right: 16px; ").f();
			e("div").a("class", "").f();
				e("span").a("class", "").f();
					e("span").a("class", "header-icon-a grow-30 w3-center ").f();
						e("a").a("class", "w3-hover-opacity").a("title", "English").a("href", pageUri.enUS()).f();
							e("img").a("src", "/svg/flag-US.svg").a("style", "height: 50px; ").fg();
						g("a");
						e("a").a("class", "w3-hover-opacity").a("title", "French").a("href", pageUri.frFR()).f();
							e("img").a("src", "/svg/flag-FR.svg").a("style", "height: 50px; ").fg();
						g("a");
						e("br").fg();
						e("span").a("class", "computate-menu-item").f();
							enUSXml("Language");
							frFRXml("Langue");
						g("span");
					g("span");
					e("a").a("class", "header-icon-a grow-30 w3-hover-opacity w3-center ").a("href", pageAccueilUri).f();
						e("img").a("src", "/svg/computate.org.svg").a("style", "height: 50px; ").fg();
						e("br").fg();
						e("span").a("class", "computate-menu-item").a("id", "computate_org_span").f();
							enUSXml("Home");
							frFRXml("Accueil");
						g("span");
					g("a");
					e("a").a("class", "header-icon-a grow-30 w3-hover-opacity w3-center ").a("href", pageBlogUri).f();
						e("img").a("src", "/svg/full-moon.svg").a("style", "height: 50px; ").fg();
						e("br").fg();
						e("span").a("class", "computate-menu-item").a("id", "computate_org_span").f();
							enUSXml("Blog");
							frFRXml("Blog");
						g("span");
					g("a");
					e("a").a("class", "header-icon-a grow-30 w3-hover-opacity w3-center ").a("href", pageCoursUri).f();
						e("img").a("src", "/svg/cluster.svg").a("style", "height: 50px; ").fg();
						e("br").fg();
						e("span").a("class", "computate-menu-item").a("id", "computate_org_span").f();
							enUSXml("Courses");
							frFRXml("Cours");
						g("span");
					g("a");
					e("a").a("class", "header-icon-a grow-30 w3-hover-opacity w3-center ").a("href", pageAProposUri).f();
						e("img").a("src", "/png/computate.png").a("style", "height: 50px; ").fg();
						e("br").fg();
						e("span").a("class", "computate-menu-item").a("id", "computate_org_span").f();
							enUSXml("About");
							frFRXml("À propos");
						g("span");
					g("a");
					e("a").a("class", "header-icon-a grow-30 w3-hover-opacity w3-center ").a("href", pageFaqUri).f();
						e("img").a("src", "/svg/ufo.svg").a("style", "height: 50px; ").fg();
						e("br").fg();
						e("span").a("class", "computate-menu-item").a("id", "computate_org_span").f();
							enUSXml("FAQ");
							frFRXml("FAQ");
						g("span");
					g("a");
					if(requeteSite.jetonAcces == null) {
						e("a").a("class", "header-icon-a grow-30 w3-hover-opacity w3-center ").a("href", pageUtilisateurUri).f(); 
							e("img").a("src", "/svg/astronaut-helmet.svg").a("style", "height: 50px; ").fg();
							e("br").fg();
							e("span").a("class", "computate-menu-item").a("id", "computate_org_span").f();
								enUSXml("Login");
								frFRXml("Se connecter");
							g("span");
						g("a");
					}
					if(requeteSite.jetonAcces != null) {
						e("a").a("class", "header-icon-a grow-30 w3-hover-opacity w3-center ").a("href", pageDeconnexionUri).f();
							e("img").a("src", "/svg/light-speed.svg").a("style", "height: 50px; ").fg();
							e("br").fg();
							e("span").a("class", "computate-menu-item").a("id", "computate_org_span").f();
								enUSXml("Logout");
								frFRXml("Se déconnecter");
							g("span");
						g("a");
					}
				g("span");
			g("div");
		g("div");
	}

	public String formaterDateHeureCourt(Date date) {
		String resultat = "";
		if(date != null && requeteSite.requete != null) {
			resultat = formatDateHeureCourt.format(date.toInstant().atZone(ZoneId.systemDefault()));
		}
		return resultat;
	}

	public String formaterDateCourt(Date date) {
		String resultat = "";
		if(date != null && requeteSite.requete != null) {
			resultat = formatDateCourt.format(date.toInstant().atZone(ZoneId.systemDefault()));
		}
		return resultat;
	}

	public String formaterDateAffichage(Date date) {
		String resultat = "";
		if(date != null && requeteSite.requete != null) {
			resultat = formatAffichage.format(date.toInstant());
		}
		return resultat;
	}

	public String formaterDateAffichage(LocalDateTime date) {
		String resultat = "";
		if(date != null && requeteSite.requete != null) {
			resultat = formatAffichage.format(date);
		}
		return resultat;
	}

	/**
	 * param1.var.enUS: localName
	 * r.enUS: nomLocal
	 * localName
	 * r.enUS: xmlPile
	 * xmlStack
	 * r.enUS: requeteSite
	 * siteRequest
	 * r.enUS: tabulation
	 * tab
	 * r.enUS: Echappes
	 * Escaped
	 * r.enUS: ecrivain
	 * writer
	 */
	public MiseEnPage e(String nomLocal) {
		String nomLocalParent = requeteSite.xmlPile.isEmpty() ? null : requeteSite.xmlPile.peek();

		boolean eNoWrapParent = nomLocalParent == null || HTML_ELEMENTS_NO_WRAP.contains(nomLocalParent);
		String tabulations = String.join("", Collections.nCopies(requeteSite.xmlPile.size(), "\t"));
		String tabulationsEchappes = String.join("", Collections.nCopies(requeteSite.xmlPile.size(), "\\t"));

		requeteSite.xmlPile.push(nomLocal);
		if(StringUtils.equals(nomLocal, "html"))
			ecrivain.write("<!DOCTYPE html>\n");
		if(!eNoWrapParent && !tabulationsEchappes.isEmpty()) {
			ecrivain.write("\n");
			ecrivain.write(tabulations);
		}
		ecrivain.write("<");
		ecrivain.write(nomLocal);
		
		return this;
	}

	public MiseEnPage aDebut(String nomAttribut, Object...objets) {
		ecrivain.write(" ");
		ecrivain.write(nomAttribut);
		ecrivain.write("=\"");
		for(Object objet : objets) {
			if(objet != null) {
				String s = objet.toString();
				ecrivain.write(OutilXml.echapperDansCitatations(s));
			}
		}
		
		return this;
	}

	/**  
	 * param1.var.enUS: attributeName
	 * param2.var.enUS: objects
	 * r.enUS: nomAttribut
	 * attributeName
	 * r.enUS: objets
	 * objects
	 * r.enUS: ecrivain
	 * writer
	 * r.enUS: echapperXmlDansCitations
	 * escapeXmlInQuotes
	 * r.enUS: OutilEchapper
	 * EscapeTool
	 */
	public MiseEnPage a(String nomAttribut, Object...objets) {
		ecrivain.write(" ");
		ecrivain.write(nomAttribut);
		ecrivain.write("=\"");
		for(Object objet : objets) {
			if(objet != null) {
				String s = objet.toString();
				ecrivain.write(OutilXml.echapperDansCitatations(s));
			}
		}
		ecrivain.write("\"");
		
		return this;
	}

	public MiseEnPage aFin() {
		ecrivain.write("\"");
		
		return this;
	}

	/** 
	 * r.enUS: ecrivain
	 * writer
	 */
	public MiseEnPage f() {
		ecrivain.write(">");
		
		return this;
	}

	/**
	 * var.enUS: all
	 * param1.var.enUS: objects
	 * r.enUS: objet
	 * object
	 * r.enUS: ecrivain
	 * writer
	 */
	public MiseEnPage tout(Object...objets) {
		for(Object objet : objets) {
			if(objet != null) {
				if(objet instanceof Chaine) {
					Chaine chaine = (Chaine)objet;
					String s = chaine.s();
					ecrivain.write(s);
				}
				else {
					String s = objet.toString();
					ecrivain.write(s);
				}
			}
		}
		
		return this;
	}

	/**
	 * param1.var.enUS: numberTabs
	 * param2.var.enUS: objects
	 * r.enUS: nombreTabulations
	 * numberTabs
	 * r.enUS: objets
	 * objects
	 * r.enUS: tout
	 * all
	 */
	public MiseEnPage tab(int nombreTabulations, Object...objets) {
		for(int i = 0; i < nombreTabulations; i++)
			tout("\t");
		tout(objets);
		return this;
	}

	/**
	 * var.enUS: tabLine
	 * param1.var.enUS: numberTabs
	 * param2.var.enUS: objects
	 * r.enUS: nombreTabulations
	 * numberTabs
	 * r.enUS: objets
	 * objects
	 * r.enUS: tout
	 * all
	 */
	public MiseEnPage tabLigne(int nombreTabulations, Object...objets) {
		for(int i = 0; i < nombreTabulations; i++)
			tout("\t");
		tout(objets);
		tout("\n");
		return this;
	}

	/** 
	 * var.enUS: allLine
	 * param1.var.enUS: objects
	 * r.enUS: objets
	 * objects
	 * r.enUS: tout
	 * all
	 */
	public MiseEnPage toutLigne(Object...objets) {
		tout(objets);
		tout("\n");
		return this;
	}

	public MiseEnPage enUS(Object...objets) {
		if(requeteSite.enUS) {
			for(Object objet : objets) {
				if(objet != null) {
					if(objet instanceof Chaine) {
						Chaine chaine = (Chaine)objet;
						String s = chaine.enUS();
						ecrivain.write(s);
					}
					else {
						String s = objet.toString();
						ecrivain.write(s);
					}
				}
			}
		}
		
		return this;
	}

	public MiseEnPage frFR(Object...objets) {
		if(requeteSite.frFR) {
			for(Object objet : objets) {
				if(objet != null) {
					if(objet instanceof Chaine) {
						Chaine chaine = (Chaine)objet;
						String s = chaine.frFR();
						ecrivain.write(s);
					}
					else {
						String s = objet.toString();
						ecrivain.write(s);
					}
				}
			}
		}
		
		return this;
	}

	public MiseEnPage enUSLigne(Object...objets) {
		enUS(objets);
		toutXml("\n");
		return this;
	}

	public MiseEnPage frFRLigne(Object...objets) {
		frFR(objets);
		toutXml("\n");
		return this;
	}

	public MiseEnPage toutShApos(Object...objets) {
		if(requeteSite.frFR) {
			for(Object objet : objets) {
				if(objet != null) {
					if(objet instanceof Chaine) {
						Chaine chaine = (Chaine)objet;
						String s = chaine.frFR();
						ecrivain.write(OutilXml.echapperShApos(s));
					}
					else {
						String s = objet.toString();
						ecrivain.write(OutilXml.echapperShApos(s));
					}
				}
			}
		}
		else if(requeteSite.enUS) {
			for(Object objet : objets) {
				if(objet != null) {
					if(objet instanceof Chaine) {
						Chaine chaine = (Chaine)objet;
						String s = chaine.enUS();
						ecrivain.write(OutilXml.echapperShAposXml(s));
					}
					else {
						String s = objet.toString();
						ecrivain.write(OutilXml.echapperShAposXml(s));
					}
				}
			}
		}
		
		return this;
	}

	public MiseEnPage toutShAposXml(Object...objets) {
		if(requeteSite.frFR) {
			for(Object objet : objets) {
				if(objet != null) {
					if(objet instanceof Chaine) {
						Chaine chaine = (Chaine)objet;
						String s = chaine.frFR();
						ecrivain.write(OutilXml.echapperShAposXml(s));
					}
					else {
						String s = objet.toString();
						ecrivain.write(OutilXml.echapperShAposXml(s));
					}
				}
			}
		}
		else if(requeteSite.enUS) {
			for(Object objet : objets) {
				if(objet != null) {
					if(objet instanceof Chaine) {
						Chaine chaine = (Chaine)objet;
						String s = chaine.enUS();
						ecrivain.write(OutilXml.echapperShAposXml(s));
					}
					else {
						String s = objet.toString();
						ecrivain.write(OutilXml.echapperShAposXml(s));
					}
				}
			}
		}
		
		return this;
	}

	/** 
	 * var.enUS: allXml
	 * param1.var.enUS: objects
	 * r.enUS: objet
	 * object
	 * r.enUS: ecrivain
	 * writer
	 * r.enUS: OutilEchapper
	 * EscapeTool
	 * r.enUS: echapperXml
	 * escapeXml
	 */
	public MiseEnPage toutXml(Object...objets) {
		if(requeteSite.frFR) {
			for(Object objet : objets) {
				if(objet != null) {
					if(objet instanceof Chaine) {
						Chaine chaine = (Chaine)objet;
						String s = chaine.frFR();
						ecrivain.write(OutilXml.echapper(s));
					}
					else {
						String s = objet.toString();
						ecrivain.write(OutilXml.echapper(s));
					}
				}
			}
		}
		else if(requeteSite.enUS) {
			for(Object objet : objets) {
				if(objet != null) {
					if(objet instanceof Chaine) {
						Chaine chaine = (Chaine)objet;
						String s = chaine.enUS();
						ecrivain.write(OutilXml.echapper(s));
					}
					else {
						String s = objet.toString();
						ecrivain.write(OutilXml.echapper(s));
					}
				}
			}
		}
		
		return this;
	}

	/**
	 * var.enUS: allXml
	 * param1.var.enUS: numberTabs
	 * param2.var.enUS: objects
	 * r.enUS: nombreTabulations
	 * numberTabs
	 * r.enUS: objets
	 * objects
	 * r.enUS: tout
	 * all
	 */
	public MiseEnPage tabXml(int nombreTabulations, Object...objets) {
		for(int i = 0; i < nombreTabulations; i++)
			toutXml("\t");
		toutXml(objets);
		return this;
	}

	/**
	 * var.enUS: tabLineXml
	 * param1.var.enUS: numberTabs
	 * param2.var.enUS: objects
	 * r.enUS: nombreTabulations
	 * numberTabs
	 * r.enUS: objets
	 * objects
	 * r.enUS: tout
	 * all
	 */
	public MiseEnPage tabLigneXml(int nombreTabulations, Object...objets) {
		for(int i = 0; i < nombreTabulations; i++)
			toutXml("\t");
		toutXml(objets);
		toutXml("\n");
		return this;
	}

	/**
	 * var.enUS: allLineXml
	 * param1.var.enUS: objects
	 * r.enUS: objets
	 * objects
	 * r.enUS: tout
	 * all
	 */
	public MiseEnPage toutLigneXml(Object...objets) {
		toutXml(objets);
		toutXml("\n");
		return this;
	}

	public MiseEnPage enUSXml(Object...objets) {
		if(requeteSite.enUS) {
			for(Object objet : objets) {
				if(objet != null) {
					if(objet instanceof Chaine) {
						Chaine chaine = (Chaine)objet;
						String s = chaine.enUS();
						ecrivain.write(OutilXml.echapper(s));
					}
					else {
						String s = objet.toString();
						ecrivain.write(OutilXml.echapper(s));
					}
				}
			}
		}
		
		return this;
	}

	public MiseEnPage frFRXml(Object...objets) {
		if(requeteSite.frFR) {
			for(Object objet : objets) {
				if(objet != null) {
					if(objet instanceof Chaine) {
						Chaine chaine = (Chaine)objet;
						String s = chaine.frFR();
						ecrivain.write(OutilXml.echapper(s));
					}
					else {
						String s = objet.toString();
						ecrivain.write(OutilXml.echapper(s));
					}
				}
			}
		}
		
		return this;
	}

	public MiseEnPage enUSLigneXml(Object...objets) {
		enUSXml(objets);
		enUSXml("\n");
		return this;
	}

	public MiseEnPage frFRLigneXml(Object...objets) {
		frFRXml(objets);
		frFRXml("\n");
		return this;
	}

	/**
	 * r.enUS: ecrivain
	 * writer
	 * r.enUS: requeteSite
	 * siteRequest
	 * r.enUS: xmlPile
	 * xmlStack
	 */
	public MiseEnPage fg() {
		ecrivain.write("/>");
		requeteSite.xmlPile.pop();
		
		return this;
	}

	/**    
	 * param1.var.enUS: localName
	 * r.enUS: nomLocal
	 * localName
	 * r.enUS: nomLocalParent
	 * parentLocalName
	 * r.enUS: requeteSite
	 * siteRequest
	 * r.enUS: xmlPile
	 * xmlStack
	 * r.enUS: tabulations
	 * tabs
	 * r.enUS: Echappes
	 * Escaped
	 * r.enUS: ecrivain
	 * writer
	 */
	public MiseEnPage g(String nomLocal) {
		String nomLocalParent = requeteSite.xmlPile.peek();

		boolean eNoWrap = nomLocalParent == null || HTML_ELEMENTS_NO_WRAP.contains(nomLocal);
		String tabulations = String.join("", Collections.nCopies(requeteSite.xmlPile.size(), "\t"));
		String tabulationsEchappes = String.join("", Collections.nCopies(requeteSite.xmlPile.size(), "\\t"));

		if(!eNoWrap && !tabulationsEchappes.isEmpty()) {
			ecrivain.write("\n");
			ecrivain.write(tabulations);
		}
		ecrivain.write("</");
		ecrivain.write(nomLocal);
		ecrivain.write(">");
		requeteSite.xmlPile.pop();
		
		return this;
	}
}
