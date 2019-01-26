package org.computate.frFR.cardiaque.page;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.solr.common.SolrDocument;
import org.computate.frFR.cardiaque.chaine.Chaine;
import org.computate.frFR.cardiaque.couverture.Couverture;
import org.computate.frFR.cardiaque.ecrivain.ToutEcrivain;
import org.computate.frFR.cardiaque.page.parti.PageParti;
import org.computate.frFR.cardiaque.requete.RequeteSite;
import org.computate.frFR.cardiaque.xml.OutilXml;

import io.vertx.core.http.HttpServerRequest;

/**
 * nomCanonique.enUS: org.computate.enUS.cardiac.page.PageLayout
 */   
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
//
//	protected void _pagePartis(ArrayList<PageParti> l)  {}

	/**
	 * 
	 * {@inheritDoc}
	 **/ 
	protected void _requeteSite_(Couverture<RequeteSite> c) {
	}

	/**
	 * {@inheritDoc}
	 * var.enUS: solrDocument
	 **/
	protected void _solrDocument(Couverture<SolrDocument> c) {
		
	}

	/**
	 * var.enUS: _writer
	 * frFR: L'écrivain pour écrirer le résultat du réponse. 
	 * r.enUS: requeteSite_
	 * siteRequest
	 * r.enUS: ecrivain
	 * writer
	 */ 
	protected void _w(Couverture<ToutEcrivain> c) {
		c.o(requeteSite_.getW());
	}
//
//	/**
//	 * var.enUS: _pageCanonicalName
//	 * frFR: Le nom canonique de cette classe Java pour la page. 
//	 * frFR: Le servlet va rechercher l'URL et construire une nouvelle page de ce type. 
//	 * indexe: true
//	 * stocke: true
//	 */
//	protected void _pageNomCanonique(Couverture<String> c)  {
//		c.o(getClass().getCanonicalName());
//	}
//
//	/**
//	 * var.enUS: _pageSimpleName
//	 * frFR: Le nom simple de cette classe Java pour la page. 
//	 * frFR: Le servlet va rechercher l'URL et construire une nouvelle page de ce type. 
//	 * indexe: true
//	 * stocke: true
//	 */
//	protected void _pageNomSimple(Couverture<String> c)  {
//		c.o(getClass().getSimpleName());
//	}

	/**
	 * var.enUS: pageVisibleToBots
	 * frFR: Choisir si cette page est trouvée dans le /sitemap.xml.
	 * frFR: Si true, les bots de Google, Bing, Yahoo peuvent trouver la page. 
	 * indexe: true
	 * stocke: true
	 */
	protected void _pageVisibleAuxBots(Couverture<Boolean> c)  {
		c.o(BooleanUtils.toBooleanDefaultIfNull((Boolean)solrDocument.get(c.var + "_stored_boolean"), false));
	}

	/**
	 * indexe: true
	 * stocke: true
	 */
	protected void _pageH1(Couverture<String> c)  {
		c.o(StringUtils.defaultIfBlank((String)solrDocument.get(c.var + "_stored_string"), null));
	}

	/**
	 * indexe: true
	 * stocke: true
	 */
	protected void _pageH2(Couverture<String> c)  {
		c.o(StringUtils.defaultIfBlank((String)solrDocument.get(c.var + "_stored_string"), null));
	}

	/**
	 * var.enUS: _pageH1Short
	 */
	protected void _pageH1Court(Couverture<String> c)  {
		c.o(StringUtils.defaultIfBlank((String)solrDocument.get(c.var + "_stored_string"), pageH1));
	}

	/**
	 * var.enUS: _pageH2Short
	 */
	protected void _pageH2Court(Couverture<String> c)  {
		c.o(StringUtils.defaultIfBlank((String)solrDocument.get(c.var + "_stored_string"), pageH2));
	}

	/**
	 * var.enUS: pageTitle
	 * indexe: true
	 * stocke: true
	 */
	protected void _pageTitre(Couverture<String> c)  {
		c.o(StringUtils.defaultIfBlank((String)solrDocument.get(c.var + "_stored_string"), StringUtils.join(pageH1, pageH2)));
	}

	/**	la version plus courte de l'URL qui commence avec « / » 
	 * indexe: true
		stocke: true
	 * **/
	protected void _pageUri(Couverture<String> c)  {
		c.o(StringUtils.defaultIfBlank((String)solrDocument.get(c.var + "_stored_string"), null));
	}
//
//	/**
//	 * var.enUS: _key
//	 * frFR: la version plus courte de l'URL en français qui commence avec « / » 
//	 * clePrimaire: true
//	 * r.enUS: pageNomCanonique
//	 * pageCanonicalName
//	 */
//	protected void _cle(Couverture<String> c)  {
//		c.o(pageNomCanonique);
//	}

	/**	Tous les URIs ensemble pour toutes les langues dans cette liste. 
	 * indexe: true
	 * stocke: true
	 * **/
	protected void _pageUris(List<String> l)  {
		l.add(pageUri.toString());
		l.add(pageUri + "/");
	}

	/**
	 * frFR: l'URL complet. 
	 * indexe: true
	 * stocke: true
	 * r.enUS: requeteSite_
	 * siteRequest
	 * r.enUS: configSite
	 * siteConfig
	 * r.enUS: nomHoteSite
	 * siteHostName
	 * r.enUS: requete
	 * request
	 * r: requeteServeur
	 * r.enUS: serverRequest
	 */ 
	protected void _pageUrl(Couverture<String> c)  {
		String q = null;
		HttpServerRequest requeteServeur = requeteSite_.getRequeteServeur();
		if(requeteServeur != null) {
			q = requeteServeur.query();
		}
		c.o(StringUtils.defaultIfBlank((String)solrDocument.get(c.var + "_stored_string"), "https://" + requeteSite_.getConfigSite_().getSiteNomHote() + pageUri + (StringUtils.isEmpty(q) ? "" : "?" + q)));
	}

	/**
	 * frFR: l'URI courte vers l'image. 
	 * indexe: true
	 * stocke: true
	 */
	protected void _pageImageUri(Couverture<String> c)  {
		c.o(StringUtils.defaultIfBlank((String)solrDocument.get(c.var + "_stored_string"), null));
	}

	/**
	 * frFR: l'URL complet vers l'image. 
	 * indexe: true
	 * stocke: true
	 * r.enUS: requeteSite_
	 * siteRequest
	 * r.enUS: configSite
	 * siteConfig
	 * r.enUS: nomHoteSite
	 * siteHostName
	 */
	protected void _pageImageUrl(Couverture<String> c)  {
		c.o(StringUtils.defaultIfBlank((String)solrDocument.get(c.var + "_stored_string"), "https://" + requeteSite_.getConfigSite_().getSiteNomHote() + pageImageUri));
	}

	/**
	 * frFR: l'ID Youtube du video. 
	 * indexe: true
	 * stocke: true
	 * r.enUS: requeteSite_
	 * siteRequest
	 * r.enUS: configSite
	 * siteConfig
	 * r.enUS: nomHoteSite
	 * siteHostName
	 */
	protected void _pageVideoId(Couverture<String> c)  {
		c.o(StringUtils.defaultIfBlank((String)solrDocument.get(c.var + "_stored_string"), null));
	}

	/**
	 * frFR: l'URL complet vers le video. 
	 * indexe: true
	 * stocke: true
	 * r.enUS: requeteSite_
	 * siteRequest
	 * r.enUS: configSite
	 * siteConfig
	 * r.enUS: nomHoteSite
	 * siteHostName
	 */
	protected void _pageVideoUrl(Couverture<String> c)  {
		if(pageVideoId != null) {
			c.o(StringUtils.defaultIfBlank((String)solrDocument.get(c.var + "_stored_string"), "https://youtu.be/" + pageVideoId));
		}
	}

	/**
	 * frFR: l'URL embed vers le video. 
	 * indexe: true
	 * stocke: true
	 * r.enUS: requeteSite_
	 * siteRequest
	 * r.enUS: configSite
	 * siteConfig
	 * r.enUS: nomHoteSite
	 * siteHostName
	 */
	protected void _pageVideoUrlEmbed(Couverture<String> c)  {
		if(pageVideoId != null) {
			c.o(StringUtils.defaultIfBlank((String)solrDocument.get(c.var + "_stored_string"), "https://www.youtube.com/embed/" + pageVideoId));
		}
	}

	/**
	 * var.enUS: _pageImageWidth
	 * frFR: Le longeur de l'image. 
	 * indexe: true
	 * stocke: true
	 */
	protected void _pageImageLargeur(Couverture<Integer> c)  {
		c.o((Integer)solrDocument.get(c.var + "_stored_int"));
	}

	/**
	 * var.enUS: _pageImageHeight
	 * frFR: Le hauteur de l'image. 
	 * indexe: true
	 * stocke: true
	 */
	protected void _pageImageHauteur(Couverture<Integer> c)  {
		c.o((Integer)solrDocument.get(c.var + "_stored_int"));
	}

	/**
	 * var.enUS: _pageImageContentType
	 * frFR: Le type de contenu de l'image. 
	 * indexe: true
	 * stocke: true
	 */
	protected void _pageImageTypeContenu(Couverture<String> c)  {
		c.o(StringUtils.defaultIfBlank((String)solrDocument.get(c.var + "_stored_string"), null));
	}
//
//	/**
//	 * r.enUS: requeteSite_
//	 * siteRequest
//	 * r.enUS: utilisateurRolesContient
//	 * userRolesContain
//	 */
//	protected void _pageAdmin(Couverture<Boolean> c)  {  
//		requeteSite_.getUtilisateurVertx().isAuthorized(requeteSite_.getConfigSite_().getRoleAdmin(), res -> {
//			if (res.succeeded() && res.result()) {
//				c.o(true);
//				requeteSite_.setPageAdmin(true);
//			}
//			else {
//				c.o(true);
//				requeteSite_.setPageAdmin(true);
//			}
//		});
//	}

	/** 
	 * var.enUS: _pageMethod
	 * r.enUS: requeteSite_.requete
	 * siteRequest.request
	 * Le nom du méthode à appeler pour charger la page. 
	 * indexe: true
	 * stocke: true
	 */
	protected void _pageMethode(Couverture<String> c)  {
		HttpServerRequest requeteServeur = requeteSite_.getRequeteServeur();
		if(requeteServeur != null) {
			String uri = requeteServeur.uri();
//			if(uri.endsWith(".recapituler.html"))
//				c.o("htmlRecapituler");
//			else if(uri.endsWith(".sh.html"))
//				c.o("shHtml" + getClass().getSimpleName());
//			else if(uri.endsWith(".sh"))
//				c.o("sh" + getClass().getSimpleName());
//			else
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
	 * r.enUS: requeteSite_
	 * siteRequest
	 * r.enUS: requete
	 * request
	 */
	protected void _pageTypeContenu(Couverture<String> c)  {
//		if(requeteSite_.requete != null && requeteSite_.requete.getRequestURI().endsWith(".svg"))
//			c.o("image/svg+xml");
//		if(requeteSite_.requete != null && requeteSite_.requete.getRequestURI().endsWith(".sh.html"))
//			c.o("text/html;charset=UTF-8");
//		if(requeteSite_.requete != null && requeteSite_.requete.getRequestURI().endsWith(".sh"))
//			c.o("text/x-shellscript");
//		else
			c.o("text/html;charset=UTF-8");
	}
//
//	/**
//	 * frFR: l'ID unique pour SOLR. 
//	 */
//	protected void _id(Couverture<String> c)  {
//		c.o(pageUri.toString());
//	}
//
//	protected void _pageCreeCours(Couverture<LocalDateTime> c)  {   
//		LocalDateTime o = LocalDateTime.now();
//		c.o(o);
//	}

	/**
	 * var.enUS: _pageCreated
	 * indexe: true
	 * stocke: true
	 */
	protected void _pageCree(Couverture<LocalDateTime> c)  {   
		Date solrVal = (Date)solrDocument.get(c.var + "_stored_date");
		if(solrVal != null)
			c.o(solrVal.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
	}

	/**
	 * var.enUS: _pageModified
	 * r.enUS: pageCree
	 * pageCreated
	 */
	protected void _pageModifiee(Couverture<LocalDateTime> c)  {
		Date solrVal = (Date)solrDocument.get(c.var + "_stored_date");
		if(solrVal != null)
			c.o(solrVal.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
		else
			c.o(pageCree);
	}
//
//	/**
//	 * incremente: true
//	 */
//	protected void _pageAime(Couverture<Long> c)  {}
//
//	protected void _pageAimee(Couverture<Boolean> c)  {
//		if(requeteSite_.requete != null) {
//			HttpSession session = requeteSite_.requete.getSession();
//			if(session != null) {
//				String attribut = "aime_" + getClass().getCanonicalName();
//				Object valeurSession = session.getAttribute(attribut);
//				c.o(valeurSession != null);
//			}
//		}
//	}
//
//	/**
//	 * var.enUS: _pageKeywords
//	 * indexe: true
//	 * stocke: true
//	 */
//	protected void _pageMotsCles(Couverture<String> c)  {
//	}
//
//	/**
//	 * indexe: true
//	 * stocke: true
//	 */
//	protected void _pageDescription(Couverture<String> c)  {
//	}

	/**
	 * var.enUS: _homePageUri
	 */
	protected void _pageAccueilUri(Couverture<String> c)  {
		c.o("");
	}
//
//	protected void _pageBlogUri(Couverture<String> c)  {
//		c.o("/blog");
//	}

	/**
	 * var.enUS: _aboutPageUri
	 * r.enUS: apropos
	 * about
	 */
	protected void _pageAProposUri(Couverture<String> c)  {
		c.o("/apropos");
	}

	protected void _pageFaqUri(Couverture<String> c)  {
		c.o("/faq");
	}

	/**
	 * var.enUS: _userPageUri
	 * r.enUS: utilisateur
	 * user
	 */
	protected void _pageUtilisateurUri(Couverture<String> c)  {
		c.o("/utilisateur");
	}

	/**
	 * var.enUS: _logoutPageUri
	 * r.enUS: deconnexion
	 * logout
	 */
	protected void _pageDeconnexionUri(Couverture<String> c)  {
		c.o("/deconnexion");
	}
//
//	protected void _pageCoursUri(Couverture<String> c)  {
//		c.o("/cours");
//	}
//
//	/** 
//	 * r.enUS: requeteSite_
//	 * siteRequest
//	 * r.enUS: configSite
//	 * siteConfig
//	 * r.enUS: identifiantCanalYoutube
//	 * youtubeChannelIdentifier
//	 */
//	protected void _pageYoutubeUrl(Couverture<String> c)  {
//		c.o("https://www.youtube.com/channel/UC3ryOB2snhO7fItkx6dGx2Q");
//	}
//
//	/** 
//	 * r.enUS: requeteSite_
//	 * siteRequest
//	 * r.enUS: configSite
//	 * siteConfig
//	 * r.enUS: comptePinterest
//	 * pinterestAccount
//	 */
//	protected void _pagePinterestUrl(Couverture<String> c)  {
//		c.o("https://www.pinterest.com/computateorg/computate-en-fran%C3%A7ais/");
//	}
//
//	/**
//	 * var.enUS: _requestKey
//	 * r.enUS: requeteSite_
//	 * siteRequest
//	 * r.enUS: requete
//	 * request
//	 */
//	protected void _cleRequete(Couverture<Long> c) {
//		if(requeteSite_.requete != null) {
//			Long o = NumberUtils.toLong(requeteSite_.requete.getParameter("key"));
//			if(o > 0L)
//				c.o(o);
//		}
//	}

	/**
	 * var.enUS: _requestKey
	 * r.enUS: requeteSite_
	 * siteRequest
	 * r.enUS: requete
	 * request
	 */
//	public void pagePartisHtml()  {
//		e("h1").f().sx(pageH1).g("h1");
//		e("h2").f().sx(pageH2).g("h2");
//		for(int i = 0; i < pagePartis.size(); i++) {
//			PageParti parti = pagePartis.get(i);
//			parti.html();
////			e("h1").f().tout(parti.partiH3Court()).g("h1");
////			e("h2").f().tout(parti.partiH4Court()).g("h2");
//		}
//	}
//
//	public void pageRecapituler()  {
//		e("fieldset").a("class", "htmlCourt-fieldset ").f();
//			e("legend").a("class", "htmlCourt-legend ").f();
//				e("h2").a("class", "htmlCourt-h2 ").f();
//					enUSx("To review: ");
//					frFRx("À récapituler : ");
//				g("h2");
//			g("legend");
//			pageRecapitulerDedans();
//		g("fieldset");
//	}
//
//	public void pageRecapitulerDedans()  {
//			String var = requeteSite_.requete.getParameter("var");
//			if(!StringUtils.isEmpty(var)) {
//				try {
//					PageParti parti = (PageParti)obtenirPourClasse(var);
//					e("div").a("class", "w3-container ").a("style", "font-size: 1.5em; ").f();
//						MethodUtils.invokeExactMethod(this, var + "Html");
//					g("div");
//				} catch(Exception e) {
//					e.toString();
//				}
//			}
//			else {
//				e("h1").f().toutx(pageH1Court).g("h1");
//				e("h2").f().toutx(pageH2Court).g("h2");
//				e("div").a("class", "w3-row ").f();
//					int j = 0;
//					for(int i = 0; i < pagePartis.size(); i++) {
//						PageParti parti = pagePartis.get(i);
//						Chaine h3 = null;
//						if(parti instanceof Cmd)
//							h3 = ((Cmd)parti).h3;
//						if(parti instanceof QuestionReponse)
//							h3 = ((QuestionReponse)parti).question;
//						if(h3 != null && h3.pasVide()) {
//							if(j > 0 && j % 2 == 0) {
//								g("div");
//								e("div").a("class", "w3-row ").f();
//							}
//							e("div").a("class", "w3-half ").f();
//								parti.htmlCourt();
//							g("div");
//							j++;
//						}
//			//			e("h1").f().tout(parti.partiH3Court()).g("h1");
//			//			e("h2").f().tout(parti.partiH4Court()).g("h2");
//					}
//				g("div");
//				abondonnezPas();
//			}
//	}

	/** 
	 * r.enUS: Home 
	 * Accueil 
	 * r.enUS: toutXml
	 * allXml
	 * r: Langue
	 * r.enUS: Language
	 * r: Accueil
	 * r.enUS: Home
	 * r: À propos
	 * r.enUS: About
	 * r: Se connecter
	 * r.enUS: Login
	 * r: Se déconnecter
	 * r.enUS: Logout
	 */
	public void menu()  {
		e("div").a("class", "w3-bar w3-text-white w3-card-2 w3-padding-bottom-8 w3-padding-top-8 ").a("style", "padding-left: 16px; padding-right: 16px; ").f();
			e("div").a("class", "").f();
				e("span").a("class", "").f();
//					e("span").a("class", "header-icon-a grow-30 w3-center ").f();
//						e("a").a("class", "w3-hover-opacity").a("title", "English").a("href", pageUri.enUS()).f();
//							e("img").a("src", "/svg/flag-US.svg").a("style", "height: 50px; ").fg();
//						g("a");
//						e("a").a("class", "w3-hover-opacity").a("title", "French").a("href", pageUri.frFR()).f();
//							e("img").a("src", "/svg/flag-FR.svg").a("style", "height: 50px; ").fg();
//						g("a");
//						e("br").fg();
//						e("span").a("class", "computate-menu-item").f();
//							enUSx("Language");
//							frFRx("Langue");
//						g("span");
//					g("span");
					e("a").a("class", "header-icon-a grow-30 w3-hover-opacity w3-center ").a("href", pageAccueilUri).f();
						e("img").a("src", "/svg/computate.org.svg").a("style", "height: 50px; ").fg();
						e("br").fg();
						e("span").a("class", "computate-menu-item").a("id", "computate_org_span").f();
							sx("Home");
							sx("Accueil");
						g("span");
					g("a");
					e("a").a("class", "header-icon-a grow-30 w3-hover-opacity w3-center ").a("href", pageAProposUri).f();
						e("img").a("src", "/png/computate.png").a("style", "height: 50px; ").fg();
						e("br").fg();
						e("span").a("class", "computate-menu-item").a("id", "computate_org_span").f();
							sx("About");
							sx("À propos");
						g("span");
					g("a");
					e("a").a("class", "header-icon-a grow-30 w3-hover-opacity w3-center ").a("href", pageFaqUri).f();
						e("img").a("src", "/svg/ufo.svg").a("style", "height: 50px; ").fg();
						e("br").fg();
						e("span").a("class", "computate-menu-item").a("id", "computate_org_span").f();
							sx("FAQ");
							sx("FAQ");
						g("span");
					g("a");
					if(requeteSite_.getUtilisateurId() == null) {
						e("a").a("class", "header-icon-a grow-30 w3-hover-opacity w3-center ").a("href", pageUtilisateurUri).f(); 
							e("img").a("src", "/svg/astronaut-helmet.svg").a("style", "height: 50px; ").fg();
							e("br").fg();
							e("span").a("class", "computate-menu-item").a("id", "computate_org_span").f();
								sx("Login");
								sx("Se connecter");
							g("span");
						g("a");
					}
					if(requeteSite_.getUtilisateurId() != null) {
						e("a").a("class", "header-icon-a grow-30 w3-hover-opacity w3-center ").a("href", pageDeconnexionUri).f();
							e("img").a("src", "/svg/light-speed.svg").a("style", "height: 50px; ").fg();
							e("br").fg();
							e("span").a("class", "computate-menu-item").a("id", "computate_org_span").f();
								sx("Logout");
								sx("Se déconnecter");
							g("span");
						g("a");
					}
				g("span");
			g("div");
		g("div");
	}

	public String formaterDateHeureCourt(Date date) {
		String resultat = "";
		if(date != null) {
			resultat = formatDateHeureCourt.format(date.toInstant().atZone(ZoneId.systemDefault()));
		}
		return resultat;
	}

	public String formaterDateCourt(Date date) {
		String resultat = "";
		if(date != null) {
			resultat = formatDateCourt.format(date.toInstant().atZone(ZoneId.systemDefault()));
		}
		return resultat;
	}

	public String formaterDateAffichage(Date date) {
		String resultat = "";
		if(date != null) {
			resultat = formatAffichage.format(date.toInstant());
		}
		return resultat;
	}

	public String formaterDateAffichage(LocalDateTime date) {
		String resultat = "";
		if(date != null) {
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
	 * r.enUS: requeteSite_
	 * siteRequest
	 * r.enUS: tabulation
	 * tab
	 * r.enUS: Echappes
	 * Escaped
	 * r.enUS: ecrivain
	 * writer
	 */
	public MiseEnPage e(String nomLocal) {
		String nomLocalParent = requeteSite_.getXmlPile().isEmpty() ? null : requeteSite_.getXmlPile().peek();

		boolean eNoWrapParent = nomLocalParent == null || HTML_ELEMENTS_NO_WRAP.contains(nomLocalParent);
		String tabulations = String.join("", Collections.nCopies(requeteSite_.getXmlPile().size(), "\t"));
		String tabulationsEchappes = String.join("", Collections.nCopies(requeteSite_.getXmlPile().size(), "\\t"));

		requeteSite_.getXmlPile().push(nomLocal);
		if(StringUtils.equals(nomLocal, "html"))
			w.s("<!DOCTYPE html>\n");
		if(!eNoWrapParent && !tabulationsEchappes.isEmpty()) {
			w.l();
			w.s(tabulations);
		}
		w.s("<");
		w.s(nomLocal);
		
		return this;
	}

	public MiseEnPage a1(String nomAttribut, Object...objets) {
		w.s(" ");
		w.s(nomAttribut);
		w.s("=\"");
		for(Object objet : objets) {
			if(objet != null) {
				String s = objet.toString();
				w.s(OutilXml.echapperDansCitatations(s));
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
		w.s(" ");
		w.s(nomAttribut);
		w.s("=\"");
		for(Object objet : objets) {
			if(objet != null) {
				String s = objet.toString();
				w.s(OutilXml.echapperDansCitatations(s));
			}
		}
		w.s("\"");
		
		return this;
	}

	public MiseEnPage a2() {
		w.s("\"");
		
		return this;
	}

	/** 
	 * r.enUS: ecrivain
	 * writer
	 */
	public MiseEnPage f() {
		w.s(">");
		
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
	public MiseEnPage s(Object...objets) {
		for(Object objet : objets) {
			if(objet != null) {
				if(objet instanceof Chaine) {
					Chaine chaine = (Chaine)objet;
					String s = chaine.s();
					w.s(s);
				}
				else {
					String s = objet.toString();
					w.s(s);
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
	public MiseEnPage t(int nombreTabulations, Object...objets) {
		for(int i = 0; i < nombreTabulations; i++)
			s("\t");
		s(objets);
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
	public MiseEnPage tl(int nombreTabulations, Object...objets) {
		for(int i = 0; i < nombreTabulations; i++)
			s("\t");
		s(objets);
		s("\n");
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
	public MiseEnPage tl(Object...objets) {
		s(objets);
		s("\n");
		return this;
	}

	public MiseEnPage lx(Object...objets) {
		s(objets);
		sx("\n");
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
	public MiseEnPage sx(Object...objets) {
		for(Object objet : objets) {
			if(objet != null) {
				if(objet instanceof Chaine) {
					Chaine chaine = (Chaine)objet;
					String s = chaine.toString();
					w.s(OutilXml.echapper(s));
				}
				else {
					String s = objet.toString();
					w.s(OutilXml.echapper(s));
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
	public MiseEnPage tx(int nombreTabulations, Object...objets) {
		for(int i = 0; i < nombreTabulations; i++)
			sx("\t");
		sx(objets);
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
	public MiseEnPage tlx(int nombreTabulations, Object...objets) {
		for(int i = 0; i < nombreTabulations; i++)
			sx("\t");
		sx(objets);
		sx("\n");
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
	public MiseEnPage tlx(Object...objets) {
		sx(objets);
		sx("\n");
		return this;
	}

	/**
	 * r.enUS: ecrivain
	 * writer
	 * r.enUS: requeteSite_
	 * siteRequest
	 * r.enUS: xmlPile
	 * xmlStack
	 */
	public MiseEnPage fg() {
		w.s("/>");
		requeteSite_.getXmlPile().pop();
		
		return this;
	}

	/**    
	 * param1.var.enUS: localName
	 * r.enUS: nomLocal
	 * localName
	 * r.enUS: nomLocalParent
	 * parentLocalName
	 * r.enUS: requeteSite_
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
		String nomLocalParent = requeteSite_.getXmlPile().peek();

		boolean eNoWrap = nomLocalParent == null || HTML_ELEMENTS_NO_WRAP.contains(nomLocal);
		String tabulations = String.join("", Collections.nCopies(requeteSite_.getXmlPile().size(), "\t"));
		String tabulationsEchappes = String.join("", Collections.nCopies(requeteSite_.getXmlPile().size(), "\\t"));

		if(!eNoWrap && !tabulationsEchappes.isEmpty()) {
			w.l();
			w.s(tabulations);
		}
		w.s("</");
		w.s(nomLocal);
		w.s(">");
		requeteSite_.getXmlPile().pop();
		
		return this;
	}
}
