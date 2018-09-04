package com.heytate.fuse.art.page;

import java.io.PrintWriter;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;

import com.heytate.fuse.art.escape.EscapeTool;
import com.heytate.fuse.art.request.SiteRequest;

public class PageLayout {

	public static List<String> HTML_CLOSED_ELEMENTS = Arrays.asList("area", "base", "br", "col", "command", "embed", "hr", "img", "input", "keygen", "link", "meta", "param", "source", "track", "wbr");

	public static List<String> HTML_ELEMENTS_NO_WRAP = Arrays.asList("script", "span", "a", "b", "i", "u", "title", "use", "h1", "h2", "h3", "h4", "h5", "h6", "pre", "textarea");

	public static DateTimeFormatter dateShortFormat = DateTimeFormatter.ofPattern("d MMM yyyy H'h'mm", Locale.US);

	public static DateTimeFormatter dateDisplayFormat = DateTimeFormatter.ofPattern("EEEE d MMMM yyyy H'h'mm", Locale.US);

	public String formatShortDate(Date date) {
		String o = "";
		if(date != null && siteRequest.request != null) {
			o = dateShortFormat.format(date.toInstant().atZone(ZoneId.systemDefault()));
		}
		return o;
	}

	public String formatDisplayDate(Date date) {
		String resultat = "";
		if(date != null && siteRequest.request != null) {
			resultat = dateDisplayFormat.format(date.toInstant());
		}
		return resultat;
	}

	/////////////////
	// siteRequest //
	/////////////////

	/**	The "siteRequest" attribute 	 *	It is set to null before it is initialized. 
	 *	@param c is for wrapping a value to be assigned to this field during initialization. 
	 *	@throws java.lang.Exception so that any exception during initialization is handled by the servlet. 
	 */
	public SiteRequest siteRequest;
	protected void siteRequestInitialize() throws Exception {
	}

	////////////
	// writer //
	////////////

	/**	The "writer" attribute 	 *	It is set to null before it is initialized. 
	 *	@param c is for wrapping a value to be assigned to this field during initialization. 
	 *	@throws java.lang.Exception so that any exception during initialization is handled by the servlet. 
	 */
	public PrintWriter writer;
	protected void writerInitialize() throws Exception {
		this.writer = siteRequest.writer;
	}

	/////////////////////
	// pageContentType //
	/////////////////////
	public String pageContentType;
	protected void pageContentTypeInitialize() throws Exception {
		if(siteRequest.request != null && siteRequest.request.getRequestURI().endsWith(".xml"))
			this.pageContentType = "text/xml;charset=UTF-8";
		else
			this.pageContentType = "text/html;charset=UTF-8";
	}

	///////////////
	// pageTitle //
	///////////////
	public String pageTitle;
	protected void pageTitleInitialize() throws Exception {
	}

	public void menu() throws Exception {
		e("div").a("class", "w3-bar w3-black w3-opacity w3-hover-opacity-off ").f();
			e("a").a("href", "/").a("class", "w3-bar-item w3-button ").f();
				allXml("Accueil ");
			g("a");
		g("div");
	}

	public void htmlBeforePageLayout() throws Exception {
		siteRequest.response.setContentType(pageContentType);
		e("html").a("xmlns:xlink", "http://www.w3.org/1999/xlink").a("xmlns", "http://www.w3.org/1999/xhtml").a("xmlns:fb", "http://ogp.me/ns/fb#").f();
			e("head").f();
				e("meta").a("charset", "UTF-8").fg();
				e("meta").a("name", "viewport").a("content", "width=device-width, initial-scale=1").fg();
				e("link").a("rel", "stylesheet").a("href", "https://www.w3schools.com/w3css/4/w3.css").fg();
				e("link").a("rel", "stylesheet").a("href", "https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css").fg();
				e("link").a("rel", "stylesheet").a("href", "/css/site.css").fg();
				e("link").a("rel", "stylesheet").a("href", "https://fonts.googleapis.com/css?family=Khand").fg();
				e("script").a("src", "https://code.jquery.com/jquery-1.12.4.min.js").f().g("script");
				e("script").a("async", "").a("defer", "").a("src", "https://apis.google.com/js/platform.js").f().g("script");
				e("script").a("src", "/js/site.js").f().g("script");

//				e("meta").a("name", "description").a("content", pageDescription).fg();
				e("title").f();
					allXml(pageTitle);
				g("title");
			g("head");
			e("body").f();
				e("a").a("name", "top").f().g("a");
				
				e("div").a("id", "errorModal").a("class", "w3-modal").a("onclick", "this.style.display = 'none';").f();
					e("div").a("class", "w3-modal-content w3-animate-zoom").f();
						e("header").a("class", "w3-container w3-center w3-red ").f();
							e("h3").f();
								allXml("An error occured. ");
							g("h3");
						g("header");
					g("div");
					e("div").a("id", "errorModalMessage").a("class", "w3-container w3-center").f().g("div");
					e("header").a("class", "w3-container w3-center w3-padding-16 ").f();
						allXml("Error. ");
					g("header");
				g("div");
				e("div").a("class", "computate-section-tout").f();
					e("div").a("class", "computate-section-en-haut ").f();
						e("div").a("class", "w3-content w3-center w3-text-black ").f();
							e("div").a("class", "w3-top w3-hide-small ").f();
								menu();
							g("div");
						g("div");
						e("div").a("id", "sectionPrimaire").a("class", "computate-section-primaire w3-text-black w3-padding-bottom-32 ").f();
							e("div").a("class", "w3-content ").f();
	}

	public void htmlAfterPageLayout() throws Exception {
				
								e("footer").a("class", "w3-center w3-black w3-padding-48 w3-xxlarge ").f();
									e("p").f();
										allXml("Copyright © ", Calendar.getInstance().get(Calendar.YEAR), ", All rights reserved. ");
									g("p");
								g("footer");
							g("div");
						g("div");
					g("div");
					e("div").a("class", "w3-row computate-section-contact ").f();
						e("div").a("class", "w3-content w3-center  w3-cell-row w3-margin-bottom-32 ").f();
							menu();
							e("div").a("class", "w3-container ").f();
								e("div").a("class", "w3-container w3-text-black w3-margin-top ").f();
									e("h6").a("id", "h2-contactez-nous").a("class",  "w3-xlarge ").f();
										allXml("Let's get connected. ");
									g("h6");
									e("div").a("style", "").f();
										e("a").a("data-ajax", "false").a("href", "https://www.facebook.com/computateorg/").f();
											e("img").a("class", "grow-30 ").a("style", "display: inline-block; width: 50px; height: 50px; margin: 0 10px;").a("src", "https://www.computate.org/svg/facebook.svg").fg();
										g("a");
									g("div");
									e("h6").f();
										e("a").a("href", "#top").f();
											allXml("Up to the top. ");
										g("a");
									g("h6");
								g("div");
							g("div");
						g("div");
					g("div");
				g("div");
			g("body");
		g("html");
	}

	public void sharePage() throws Exception {
							e("div").a("class", "w3-content w3-center w3-padding-top-32 ").f();
								e("h3").f();
									allXml("Partagez cet article. ");
								g("h3");
								e("div").a("class", "w3-cell-row ").f();
									e("div").a("class", "blog-publication-social-div w3-cell ").f();
										e("img").a("class", "blog-publication-social-img").a("src", "https://www.computate.org/svg/facebook.svg").fg();
										e("div").f();
//											e("div").a("class", "fb-like").a("data-href", pageUrl).a("data-layout", "box_count").a("data-action", "like").a("data-size", "small").a("data-show-faces", "true").a("data-share", "true").f().g("div");
										g("div");
									g("div");
								g("div");
							g("div");
	}

	public PageLayout e(String localName) {
		String localNameParent = siteRequest.xmlStack.isEmpty() ? null : siteRequest.xmlStack.peek();

		boolean eNoWrapParent = localNameParent == null || HTML_ELEMENTS_NO_WRAP.contains(localNameParent);
		String tabs = String.join("", Collections.nCopies(siteRequest.xmlStack.size(), "\t"));
		String tabsEscaped = String.join("", Collections.nCopies(siteRequest.xmlStack.size(), "\\t"));

		siteRequest.xmlStack.push(localName);
		if(StringUtils.equals(localName, "html"))
			writer.write("<!DOCTYPE html>\n");
		if(!eNoWrapParent && !tabsEscaped.isEmpty()) {
			writer.write("\n");
			writer.write(tabs);
		}
		writer.write("<");
		writer.write(localName);
		
		return this;
	}

	public PageLayout a(String attributeName, Object...objects) {
		writer.write(" ");
		writer.write(attributeName);
		writer.write("=\"");
		for(Object objet : objects) {
			if(objet != null) {
				String s = objet.toString();
				writer.write(EscapeTool.escapeXmlInQuotes(s));
			}
		}
		writer.write("\"");
		
		return this;
	}

	public PageLayout f() {
		writer.write(">");
		
		return this;
	}

	public PageLayout all(Object...objects) {
		for(Object object : objects) {
			if(object != null) {
				String s = object.toString();
				writer.write(s);
			}
		}
		
		return this;
	}

	public PageLayout tab(int numberTabs, Object...objects) {
		for(int i = 0; i < numberTabs; i++)
			all("\t");
		all(objects);
		return this;
	}

	public PageLayout tabLine(int numberTabs, Object...objects) {
		for(int i = 0; i < numberTabs; i++)
			all("\t");
		all(objects);
		all("\n");
		return this;
	}

	public PageLayout allLine(Object...objects) {
		all(objects);
		all("\n");
		return this;
	}

	public PageLayout allXml(Object...objects) {
		for(Object object : objects) {
			if(object != null) {
				String s = object.toString();
				writer.write(EscapeTool.escapeXml(s));
			}
		}
		
		return this;
	}

	public PageLayout allXml(int numberTabs, Object...objects) {
		for(int i = 0; i < numberTabs; i++)
			allXml("\t");
		allXml(objects);
		return this;
	}

	public PageLayout tabLineXml(int numberTabs, Object...objects) {
		for(int i = 0; i < numberTabs; i++)
			allXml("\t");
		allXml(objects);
		allXml("\n");
		return this;
	}

	public PageLayout allLineXml(Object...objects) {
		allXml(objects);
		allXml("\n");
		return this;
	}

	public PageLayout fg() {
		writer.write("/>");
		siteRequest.xmlStack.pop();
		
		return this;
	}

	public PageLayout g(String localName) {
		String localNameParent = siteRequest.xmlStack.peek();

		boolean eNoWrap = localNameParent == null || HTML_ELEMENTS_NO_WRAP.contains(localName);
		String tabs = String.join("", Collections.nCopies(siteRequest.xmlStack.size() - 1, "\t"));
		String tabsEscaped = String.join("", Collections.nCopies(siteRequest.xmlStack.size(), "\\t"));

		if(!eNoWrap && !tabsEscaped.isEmpty()) {
			writer.write("\n");
			writer.write(tabs);
		}
		writer.write("</");
		writer.write(localName);
		writer.write(">");
		siteRequest.xmlStack.pop();
		
		return this;
	}

	public void siteRequestForClass(SiteRequest siteRequest) throws Exception {
		siteRequestPageLayout(siteRequest);
	}
	public void siteRequestPageLayout(SiteRequest siteRequest) throws Exception {
		this.siteRequest = siteRequest;
	}

	protected boolean alreadyInitializedPageLayout = false;
	public void initializeDeepPageLayout(SiteRequest siteRequest) throws Exception {
		((PageLayout)this).siteRequest = siteRequest;
		siteRequestPageLayout(siteRequest);
		initializeDeepPageLayout();
	}
	public void initializeDeepPageLayout() throws Exception {
		if(!alreadyInitializedPageLayout) {
			siteRequestInitialize();
			writerInitialize();
			pageContentTypeInitialize();
			pageTitleInitialize();
			alreadyInitializedPageLayout = true;
		}
	}

	public void initializeDeepForClass(SiteRequest siteRequest) throws Exception {
		initializeDeepPageLayout(siteRequest);
	}
}
