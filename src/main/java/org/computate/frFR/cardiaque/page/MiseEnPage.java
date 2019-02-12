package org.computate.frFR.cardiaque.page; 

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Calendar;
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
import org.computate.frFR.cardiaque.requete.RequeteSite;
import org.computate.frFR.cardiaque.xml.OutilXml;

import io.vertx.core.http.HttpServerRequest;

/**
 * NomCanonique.enUS: org.computate.enUS.cardiac.page.PageLayout
 */  
public class MiseEnPage extends MiseEnPageGen<Object> {  

	/**
	 * Var.enUS: HTML_CLOSED_ELEMENTS
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
	 * Var.enUS: pageDocumentSolr
	 **/
	protected void _pageDocumentSolr(Couverture<SolrDocument> c) {
		
	}

	/**
	 * Var.enUS: _writer
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
//	 * Var.enUS: _pageCanonicalName
//	 * frFR: Le nom canonique de cette classe Java pour la page. 
//	 * frFR: Le servlet va rechercher l'URL et construire une nouvelle page de ce type. 
//	 * Indexe: true
//	 * Stocke: true
//	 */
//	protected void _pageNomCanonique(Couverture<String> c)  {
//		c.o(getClass().getCanonicalName());
//	}
//
//	/**
//	 * Var.enUS: _pageSimpleName
//	 * frFR: Le nom simple de cette classe Java pour la page. 
//	 * frFR: Le servlet va rechercher l'URL et construire une nouvelle page de ce type. 
//	 * Indexe: true
//	 * Stocke: true
//	 */
//	protected void _pageNomSimple(Couverture<String> c)  {
//		c.o(getClass().getSimpleName());
//	}

	/**
	 * Var.enUS: pageVisibleToBots
	 * frFR: Choisir si cette page est trouvée dans le /sitemap.xml.
	 * frFR: Si true, les bots de Google, Bing, Yahoo peuvent trouver la page. 
	 * Indexe: true
	 * Stocke: true
	 */
	protected void _pageVisibleAuxBots(Couverture<Boolean> c)  {
		c.o(BooleanUtils.toBooleanDefaultIfNull((Boolean)pageDocumentSolr.get(c.var + "_stored_boolean"), false));
	}

	/**
	 * Indexe: true
	 * Stocke: true
	 */
	protected void _pageH1(Couverture<String> c)  {
		c.o(StringUtils.defaultIfBlank((String)pageDocumentSolr.get(c.var + "_stored_string"), null));
	}

	/**
	 * Indexe: true
	 * Stocke: true
	 */
	protected void _pageH2(Couverture<String> c)  {
		c.o(StringUtils.defaultIfBlank((String)pageDocumentSolr.get(c.var + "_stored_string"), null));
	}

	/**
	 * Var.enUS: _pageH1Short
	 */
	protected void _pageH1Court(Couverture<String> c)  {
		c.o(StringUtils.defaultIfBlank((String)pageDocumentSolr.get(c.var + "_stored_string"), pageH1));
	}

	/**
	 * Var.enUS: _pageH2Short
	 */
	protected void _pageH2Court(Couverture<String> c)  {
		c.o(StringUtils.defaultIfBlank((String)pageDocumentSolr.get(c.var + "_stored_string"), pageH2));
	}

	/**
	 * Var.enUS: pageTitle
	 * Indexe: true
	 * Stocke: true
	 * r: frFR
	 * r.enUS: enUS
	 */
	protected void _pageTitre(Couverture<String> c)  {
		c.o(StringUtils.defaultIfBlank((String)pageDocumentSolr.get(c.var + "_frFR_stored_string"), StringUtils.join(pageH1, pageH2)));
	}

	/**	la version plus courte de l'URL qui commence avec « / » 
	 * Indexe: true
	 * Stocke: true
	 * r: frFR
	 * r.enUS: enUS
	 * **/
	protected void _pageUri(Couverture<String> c)  {
		c.o(StringUtils.defaultIfBlank((String)pageDocumentSolr.get(c.var + "_frFR_stored_string"), null));
	}
//
//	/**
//	 * Var.enUS: _key
//	 * frFR: la version plus courte de l'URL en français qui commence avec « / » 
//	 * ClePrimaire: true
//	 * r.enUS: pageNomCanonique
//	 * PageCanonicalName
//	 */
//	protected void _cle(Couverture<String> c)  {
//		c.o(pageNomCanonique);
//	}

	/**	Tous les URIs ensemble pour toutes les langues dans cette liste. 
	 * Indexe: true
	 * Stocke: true
	 * **/
	protected void _pageUris(List<String> l)  {
		l.add(pageUri.toString());
		l.add(pageUri + "/");
	}

	/**
	 * frFR: l'URL complet. 
	 * Indexe: true
	 * Stocke: true
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
		c.o(StringUtils.defaultIfBlank((String)pageDocumentSolr.get(c.var + "_stored_string"), "https://" + requeteSite_.getConfigSite_().getSiteNomHote() + pageUri + (StringUtils.isEmpty(q) ? "" : "?" + q)));
	}

	/**
	 * frFR: l'URI courte vers l'image. 
	 * Indexe: true
	 * Stocke: true
	 */
	protected void _pageImageUri(Couverture<String> c)  {
		c.o(StringUtils.defaultIfBlank((String)pageDocumentSolr.get(c.var + "_stored_string"), null));
	}

	/**
	 * frFR: l'URL complet vers l'image. 
	 * Indexe: true
	 * Stocke: true
	 * r.enUS: requeteSite_
	 * siteRequest
	 * r.enUS: configSite
	 * siteConfig
	 * r.enUS: nomHoteSite
	 * siteHostName
	 */
	protected void _pageImageUrl(Couverture<String> c)  {
		c.o(StringUtils.defaultIfBlank((String)pageDocumentSolr.get(c.var + "_stored_string"), "https://" + requeteSite_.getConfigSite_().getSiteNomHote() + pageImageUri));
	}

	/**
	 * frFR: l'ID Youtube du video. 
	 * Indexe: true
	 * Stocke: true
	 * r.enUS: requeteSite_
	 * siteRequest
	 * r.enUS: configSite
	 * siteConfig
	 * r.enUS: nomHoteSite
	 * siteHostName
	 */
	protected void _pageVideoId(Couverture<String> c)  {
		c.o(StringUtils.defaultIfBlank((String)pageDocumentSolr.get(c.var + "_stored_string"), null));
	}

	/**
	 * frFR: l'URL complet vers le video. 
	 * Indexe: true
	 * Stocke: true
	 * r.enUS: requeteSite_
	 * siteRequest
	 * r.enUS: configSite
	 * siteConfig
	 * r.enUS: nomHoteSite
	 * siteHostName
	 */
	protected void _pageVideoUrl(Couverture<String> c)  {
		if(pageVideoId != null) {
			c.o(StringUtils.defaultIfBlank((String)pageDocumentSolr.get(c.var + "_stored_string"), "https://youtu.be/" + pageVideoId));
		}
	}

	/**
	 * frFR: l'URL embed vers le video. 
	 * Indexe: true
	 * Stocke: true
	 * r.enUS: requeteSite_
	 * siteRequest
	 * r.enUS: configSite
	 * siteConfig
	 * r.enUS: nomHoteSite
	 * siteHostName
	 */
	protected void _pageVideoUrlEmbed(Couverture<String> c)  {
		if(pageVideoId != null) {
			c.o(StringUtils.defaultIfBlank((String)pageDocumentSolr.get(c.var + "_stored_string"), "https://www.youtube.com/embed/" + pageVideoId));
		}
	}

	/**
	 * Var.enUS: _pageImageWidth
	 * frFR: Le longeur de l'image. 
	 * Indexe: true
	 * Stocke: true
	 */
	protected void _pageImageLargeur(Couverture<Integer> c)  {
		c.o((Integer)pageDocumentSolr.get(c.var + "_stored_int"));
	}

	/**
	 * Var.enUS: _pageImageHeight
	 * frFR: Le hauteur de l'image. 
	 * Indexe: true
	 * Stocke: true
	 */
	protected void _pageImageHauteur(Couverture<Integer> c)  {
		c.o((Integer)pageDocumentSolr.get(c.var + "_stored_int"));
	}

	/**
	 * Var.enUS: _pageImageContentType
	 * frFR: Le type de contenu de l'image. 
	 * Indexe: true
	 * Stocke: true
	 */
	protected void _pageImageTypeContenu(Couverture<String> c)  {
		c.o(StringUtils.defaultIfBlank((String)pageDocumentSolr.get(c.var + "_stored_string"), null));
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
	 * Var.enUS: _pageMethod
	 * r.enUS: requeteSite_.requete
	 * siteRequest.request
	 * Le nom du méthode à appeler pour charger la page. 
	 * Indexe: true
	 * Stocke: true
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
	 * Var.enUS: _pageContentType
	 * frFR: Le type de contenu de la page. 
	 * Indexe: true
	 * Stocke: true
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
	 * Var.enUS: _pageCreated
	 * Indexe: true
	 * Stocke: true
	 */
	protected void _pageCree(Couverture<LocalDateTime> c)  {   
		Date solrVal = (Date)pageDocumentSolr.get(c.var + "_stored_date");
		if(solrVal != null)
			c.o(solrVal.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
	}

	/**
	 * Var.enUS: _pageModified
	 * r.enUS: pageCree
	 * PageCreated
	 */
	protected void _pageModifiee(Couverture<LocalDateTime> c)  {
		Date solrVal = (Date)pageDocumentSolr.get(c.var + "_stored_date");
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

	/**
	 * Var.enUS: _pageKeywords
	 * Indexe: true
	 * Stocke: true
	 */
	protected void _pageMotsCles(Couverture<String> c)  {
	}

	/**
	 * Indexe: true
	 * Stocke: true
	 */
	protected void _pageDescription(Couverture<String> c)  {
	}

	/**
	 * Var.enUS: _homePageUri
	 */
	protected void _pageAccueilUri(Couverture<String> c)  {
		c.o("");
	}

	/**
	 * Var.enUS: _pageInrEntry
	 * r: /calcul-inr
	 * r.enUS: /inr-entry
	 */
	protected void _pageCalculInr(Couverture<String> c)  {
		c.o("/calcul-inr");
	}
//
//	protected void _pageBlogUri(Couverture<String> c)  {
//		c.o("/blog");
//	}

	/**
	 * Var.enUS: _aboutPageUri
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
	 * Var.enUS: _userPageUri
	 * r.enUS: utilisateur
	 * user
	 */
	protected void _pageUtilisateurUri(Couverture<String> c)  {
		c.o("/utilisateur");
	}

	/**
	 * Var.enUS: _logoutPageUri
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
//		c.o("https://www.pinterest.com/computateorg/site-en-fran%C3%A7ais/");
//	}
//
//	/**
//	 * Var.enUS: _requestKey
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
	 * Var.enUS: _requestKey
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

	@Override public void htmlMeta() {
		e("meta").a("charset", "UTF-8").fg();
		e("meta").a("name", "viewport").a("content", "width=device-width, initial-scale=1").fg();
		e("meta").a("name", "keywords").a("content", pageMotsCles).fg();
		e("meta").a("property", "og:title").a("content", pageTitre).fg();
		e("meta").a("property", "og:description").a("content", pageDescription).fg();
		e("meta").a("property", "og:url").a("content", pageUrl).fg();
		e("meta").a("property", "og:site_name").a("content", requeteSite_.getConfigSite_().getNomDomaine()).fg();
		e("meta").a("property", "og:image").a("content", pageImageUrl).fg();
		e("meta").a("property", "og:image:width").a("content", pageImageLargeur).fg();
		e("meta").a("property", "og:image:height").a("content", pageImageHauteur).fg();
		e("meta").a("property", "og:image:type").a("content", pageImageTypeContenu).fg();
		e("meta").a("property", "og:image:alt").a("content", pageTitre).fg();
		e("meta").a("property", "og:type").a("content", "article").fg();
		e("meta").a("name", "twitter:card").a("content", "summary_large_image").fg();
		e("meta").a("name", "twitter:site").a("content", "@computateorg").fg();
		e("meta").a("name", "twitter:creator").a("content", "@computateorg").fg();
		e("meta").a("name", "twitter:title").a("content", pageTitre).fg();
		e("meta").a("name", "twitter:description").a("content", pageDescription).fg();
		e("meta").a("name", "twitter:image").a("content", pageImageUrl).fg();
		e("meta").a("name", "description").a("content", pageDescription).fg();
	}

	@Override public void html() {
		super.html();
	}

	@Override public void htmlScripts() {
		e("script").a("src", "https://code.jquery.com/jquery-1.12.4.min.js").f().g("script");
		e("script").a("src", "/static/js/site.js").f().g("script");
//		e("script").a("async", "").a("defer", "").a("src", "https://apis.google.com/js/platform.js").f().g("script");
//		e("script").a("async", "").a("src", "https://www.googletagmanager.com/gtag/js?id=UA-118970786-1").f().g("script");
//		e("script").f().l("/*<![CDATA[*/");
//			l("window.dataLayer = window.dataLayer || [];");
//			l("function gtag(){dataLayer.push(arguments);}");
//			l("gtag('js', new Date());");
//			l("gtag('config', 'UA-118970786-1');");
//		s("/*]]>*/").g("script");
	}

	@Override public void htmlScript() {
	}

	@Override public void htmlStyles() {
		e("link").a("rel", "stylesheet").a("href", "https://www.w3schools.com/w3css/4/w3.css").fg();
		e("link").a("rel", "stylesheet").a("href", "/static/css/site.css").fg();
		e("link").a("rel", "stylesheet").a("href", "https://fonts.googleapis.com/css?family=Khand").fg();
		e("link").a("rel", "stylesheet").a("href", "https://pro.fontawesome.com/releases/v5.7.1/css/all.css").a("integrity", "sha384-6jHF7Z3XI3fF4XZixAuSu0gGKrXwoX/w3uFPxC56OtjChio7wtTGJWRW53Nhx6Ev").a("crossorigin", "anonymous").fg();
//		e("link").a("rel", "stylesheet").a("href", "https://use.fontawesome.com/releases/v5.7.1/css/all.css").a("integrity", "sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr").a("crossorigin", "anonymous").fg();
	}

	@Override public void htmlStyle() {
	}

	@Override public void htmlBody() {
	}

	@Override public void htmlMiseEnPage() {
		e("html").a("xmlns:xlink", "http://www.w3.org/1999/xlink").a("xmlns", "http://www.w3.org/1999/xhtml").a("xmlns:fb", "http://ogp.me/ns/fb#").f();
			e("head").f();
				e("title").f();
					sx(pageTitre);
				g("title");
				htmlScripts();
				e("script").f().l("/*<![CDATA[*/");
				htmlScript();
				s("/*]]>*/").g("script");
				htmlStyles();
				e("style").f().l("/*<![CDATA[*/");
				htmlStyle();
				s("/*]]>*/").g("style");
	
			g("head");
			e("body").f(); 
				e("a").a("name", "top").f().g("a");
	//			e("script").a("type", "text/javascript").a("async", "").a("defer", "").a("src", "//assets.pinterest.com/js/pinit_main.js?0.8726554954646004").f().g("script");
	//			e("div").a("id", "fb-root").f().g("div");
	//			e("script").f().l("/*<![CDATA[*/");
	//				l("(function(d, s, id) {");
	//				l("var js, fjs = d.getElementsByTagName(s)[0];");
	//				l("if (d.getElementById(id)) return;");
	//				l("js = d.createElement(s); js.id = id;");
	//				s("js.src = '");
	//				s("//connect.facebook.net/en_US/sdk.js#xfbml=1&version=v2.10&appId=1871568493111919");
	//				l("';");
	//				l("fjs.parentNode.insertBefore(js, fjs);");
	//				l("}(document, 'script', 'facebook-jssdk'));");
	//			s("/*]]>*/").g("script");
	//			e("script").f().l("/*<![CDATA[*/");
	//				s("var _ctct_m = \"805a4a78c2843d257b9b05ea244b6ec7\"; ");
	//			s("/*]]>*/").g("script");
	//			e("script").a("id", "signupScript").a("src", "//static.ctctcdn.com/js/signup-form-widget/current/signup-form-widget.min.js").a("async", "").a("defer", "").f();
	//			g("script");
				e("div").a("id", "modaleErreur").a("class", "w3-modal").a("onclick", "this.style.display = 'none';").f();
					e("div").a("class", "w3-modal-content w3-animate-zoom").f();
						e("header").a("class", "w3-container w3-center w3-red ").f();
							e("h3").f();
								sx("Une erreur s'est produite. ");
							g("h3");
						g("header");
					g("div");
					e("div").a("id", "modaleErreurMessage").a("class", "w3-container w3-center").f().g("div");
					e("header").a("class", "w3-container w3-center w3-padding-16 ").f();
						sx("L'erreur a été envoyée par e-mail à l'administrateur pour analyse. ");
					g("header");
				g("div");
				e("div").a("class", "site-section-all ").f();
					e("div").a("class", "site-section-above ").f();
						e("div").a("class", "w3-content w3-center w3-text-black ").f();
							e("div").a("class", "").f();
	//							e("img").a("src", "/img/trailblaze-top.jpg").a("class", "w3-img ").a("style", "width: 100%; margin-bottom: -10px; ").fg();
								menu();
							g("div"); 
						g("div");
						e("div").a("id", "site-section-primary").a("class", "site-section-primary w3-text-black w3-padding-bottom-32 ").f();
							e("div").a("class", "w3-content ").f();

							htmlBody();

							e("footer").a("class", "w3-center w3-black w3-padding-48 ").f();
								e("div").a("class", "w3-xxlarge ").f();
									sx("This site is open-source. ");
								g("div");
								e("div").a("class", "w3-large ").f();
									e("a").a("href", "https://github.com/computate/computate-cardiac").a("target", "_new").f();
										sx("View the source code here. ");
									g("a");
								g("div");
							g("footer");
						g("div");
					g("div");
				g("div");
				e("div").a("class", "w3-row site-section-contact ").f();
					e("div").a("class", "w3-content w3-center  w3-cell-row w3-margin-bottom-32 ").f();
						menu();
						e("div").a("class", "w3-container ").f();
							e("div").a("class", "w3-container w3-text-black w3-margin-top ").f();
								e("h6").a("id", "h2-contactez-nous").a("class",  "w3-xlarge ").f();
									sx("Let's get connected. ");
								g("h6");
								e("div").a("style", "").f();
									e("a").a("data-ajax", "false").a("href", "https://www.facebook.com/Trail-Blaze-Hunting-Consultants-LLC-179217055464922/").f();
//											e("img").a("class", "grow-30 ").a("style", "display: inline-block; width: 50px; height: 50px; margin: 0 10px;").a("src", "https://www.computate.org/svg/facebook.svg").fg();
									g("a");
								g("div");
								e("h6").f();
									e("a").a("href", "#top").f();
										sx("Up to the top. ");
									g("a");
								g("h6");
							g("div");
						g("div");
					g("div");
				g("div");
			g("body");
		g("html");

	}

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
		e("div").a("class", "w3-black w3-bar w3-text-white w3-card-2 w3-padding-bottom-8 w3-padding-top-8 ").a("style", "padding-left: 16px; padding-right: 16px; ").f();
//					e("span").a("class", "header-icon-a grow-30 w3-center ").f();
//						e("a").a("class", "w3-hover-opacity").a("title", "English").a("href", pageUri.enUS()).f();
//							e("img").a("src", "/svg/flag-US.svg").a("style", "height: 50px; ").fg();
//						g("a");
//						e("a").a("class", "w3-hover-opacity").a("title", "French").a("href", pageUri.frFR()).f();
//							e("img").a("src", "/svg/flag-FR.svg").a("style", "height: 50px; ").fg();
//						g("a");
//						e("br").fg();
//						e("span").a("class", "site-menu-item").f();
//							enUSx("Language");
//							frFRx("Langue");
//						g("span");
//					g("span");
			e("div").a("class", "w3-bar-item ").f();
				e("a").a("class", "header-icon-a grow-30 w3-hover-opacity w3-center ").a("href", pageAccueilUri).f();
					e("i").a("class", "fas fa-clinic-medical site-menu-icon ").f().g("i");
					e("span").a("class", "site-menu-item").a("id", "computate_org_span").f();
						sx("Home");
					g("span");
				g("a");
			g("div");
			e("div").a("class", "w3-bar-item ").f();
				e("a").a("class", "header-icon-a grow-30 w3-hover-opacity w3-center ").a("href", pageCalculInr).f();
					e("i").a("class", "fas fa-clipboard-prescription site-menu-icon ").f().g("i");
					e("span").a("class", "site-menu-item").a("id", "computate_org_span").f();
						sx("Inr Entries");
					g("span");
				g("a");
			g("div");
			e("div").a("class", "w3-bar-item ").f();
				e("a").a("class", "header-icon-a grow-30 w3-hover-opacity w3-center ").a("href", pageAProposUri).f();
					e("i").a("class", "fas fa-book-open site-menu-icon ").f().g("i");
					e("span").a("class", "site-menu-item").a("id", "computate_org_span").f();
						sx("About");
					g("span");
				g("a");
			g("div");
			e("div").a("class", "w3-bar-item ").f();
				e("a").a("class", "header-icon-a grow-30 w3-hover-opacity w3-center ").a("href", pageFaqUri).f();
					e("i").a("class", "fas fa-question-square site-menu-icon ").f().g("i");
					e("span").a("class", "site-menu-item").a("id", "computate_org_span").f();
						sx("FAQ");
					g("span");
				g("a");
			g("div");
			if(requeteSite_.getUtilisateurId() == null) {
				e("div").a("class", "w3-bar-item ").f();
					e("a").a("class", "header-icon-a grow-30 w3-hover-opacity w3-center ").a("href", pageUtilisateurUri).f(); 
						e("i").a("class", "fas fa-sign-in site-menu-icon ").f().g("i");
						e("span").a("class", "site-menu-item").a("id", "computate_org_span").f();
							sx("Login");
						g("span");
					g("a");
				g("div");
			}
			if(requeteSite_.getUtilisateurId() != null) {
				e("div").a("class", "w3-bar-item ").f();
					e("a").a("class", "header-icon-a grow-30 w3-hover-opacity w3-center ").a("href", pageDeconnexionUri).f();
						e("i").a("class", "fas fa-sign-out site-menu-icon ").f().g("i");
						e("span").a("class", "site-menu-item").a("id", "computate_org_span").f();
							sx("Logout");
							sx("Se déconnecter");
						g("span");
					g("a");
				g("div");
			}
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
	 * Param1.var.enUS: localName
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
	 * Param1.var.enUS: attributeName
	 * Param2.var.enUS: objects
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
	 * Var.enUS: all
	 * Param1.var.enUS: objects
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
	 * Param1.var.enUS: numberTabs
	 * Param2.var.enUS: objects
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
	 * Var.enUS: tabLine
	 * Param1.var.enUS: numberTabs
	 * Param2.var.enUS: objects
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
	 * Var.enUS: allLine
	 * Param1.var.enUS: objects
	 * r.enUS: objets
	 * objects
	 * r.enUS: tout
	 * all
	 */
	public MiseEnPage l(Object...objets) {
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
	 * Var.enUS: allXml
	 * Param1.var.enUS: objects
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
	 * Var.enUS: allXml
	 * Param1.var.enUS: numberTabs
	 * Param2.var.enUS: objects
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
	 * Var.enUS: tabLineXml
	 * Param1.var.enUS: numberTabs
	 * Param2.var.enUS: objects
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
	 * Param1.var.enUS: localName
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

		requeteSite_.getXmlPile().pop();
		String tabulations = String.join("", Collections.nCopies(requeteSite_.getXmlPile().size(), "\t"));
		String tabulationsEchappes = String.join("", Collections.nCopies(requeteSite_.getXmlPile().size(), "\\t"));

		if(!eNoWrap && !tabulationsEchappes.isEmpty()) {
			w.l();
			w.s(tabulations);
		}
		w.s("</");
		w.s(nomLocal);
		w.s(">");
		
		return this;
	}
}
