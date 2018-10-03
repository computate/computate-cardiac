package com.heytate.frFR.cardiac.page.accueil;

import org.apache.commons.lang3.StringUtils;
import org.computate.dév.java.Chaine;
import org.computate.dév.java.UneListe;
import org.computate.dév.xml.Html;
import org.computate.dév.xml.É;
import org.computate.site.blog.BlogComputate2;
import org.computate.site.blog.ListeBlog2;
import org.computate.site.miseenpage.UniversComputate;
import com.heytate.frFR.cardiac.requete.RequeteSite;
import com.heytate.frFR.cardiaque.couverture.Couverture;

public abstract class PageAccueilGen<DEV> extends Object {

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

	public PageAccueil requeteSite(RequeteSite o) throws Exception {
		setRequeteSite(o);
		return (PageAccueil)this;
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
		requeteSiteCouverture.dejaInitialise(true);
	}

	///////////////
	// pageTitre //
	///////////////

	/**	L'entité « pageTitre »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public String pageTitre;
	public Couverture<String> pageTitreCouverture = new Couverture<String>().p(this).c(String.class).var("pageTitre").o(pageTitre);

	/**	L'entité « pageTitre »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _pageTitre(Couverture<String> o) throws Exception;

	public PageAccueil pageTitre(String o) throws Exception {
		setPageTitre(o);
		return (PageAccueil)this;
	}

	public void setPageTitre(String o) throws Exception {
		this.pageTitre = o;
	}

	public String pageTitre() throws Exception {
		return getPageTitre();
	}

	public String getPageTitre() throws Exception {
		return pageTitre;
	}
	protected void pageTitreInit() throws Exception {
		if(!pageTitreCouverture.dejaInitialise) {
			_pageTitre(pageTitreCouverture);
			if(pageTitre == null)
				pageTitre(pageTitreCouverture.o);
		}
		pageTitreCouverture.dejaInitialise(true);
	}

	/////////////
	// pageUri //
	/////////////

	/**	L'entité « pageUri »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public String pageUri;
	public Couverture<String> pageUriCouverture = new Couverture<String>().p(this).c(String.class).var("pageUri").o(pageUri);

	/**	L'entité « pageUri »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _pageUri(Couverture<String> o) throws Exception;

	public PageAccueil pageUri(String o) throws Exception {
		setPageUri(o);
		return (PageAccueil)this;
	}

	public void setPageUri(String o) throws Exception {
		this.pageUri = o;
	}

	public String pageUri() throws Exception {
		return getPageUri();
	}

	public String getPageUri() throws Exception {
		return pageUri;
	}
	protected void pageUriInit() throws Exception {
		if(!pageUriCouverture.dejaInitialise) {
			_pageUri(pageUriCouverture);
			if(pageUri == null)
				pageUri(pageUriCouverture.o);
		}
		pageUriCouverture.dejaInitialise(true);
	}

	//////////////
	// cluster_ //
	//////////////

	/**	L'entité « cluster_ »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut UniversComputate(). 
	 */
	public UniversComputate cluster_ = new UniversComputate();
	public Couverture<UniversComputate> cluster_Couverture = new Couverture<UniversComputate>().p(this).c(UniversComputate.class).var("cluster_").o(cluster_);

	/**	L'entité « cluster_ »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut UniversComputate(). 
	 *	@param cluster_ est le champ déjà construit. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _cluster_(UniversComputate o) throws Exception;

	public PageAccueil cluster_(UniversComputate o) throws Exception {
		setCluster_(o);
		return (PageAccueil)this;
	}

	public void setCluster_(UniversComputate o) throws Exception {
		this.cluster_ = o;
	}

	public UniversComputate cluster_() throws Exception {
		return getCluster_();
	}

	public UniversComputate getCluster_() throws Exception {
		return cluster_;
	}
	protected void cluster_Init() throws Exception {
		if(!cluster_Couverture.dejaInitialise) {
			_cluster_(cluster_);
		}
		cluster_Couverture.dejaInitialise(true);
	}

	/////////////
	// pageUrl //
	/////////////

	/**	L'entité « pageUrl »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 */
	public Chaine pageUrl = new Chaine();
	public Couverture<Chaine> pageUrlCouverture = new Couverture<Chaine>().p(this).c(Chaine.class).var("pageUrl").o(pageUrl);

	/**	L'entité « pageUrl »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 *	@param pageUrl est le champ déjà construit. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _pageUrl(Chaine o) throws Exception;

	public PageAccueil pageUrl(Chaine o) throws Exception {
		setPageUrl(o);
		return (PageAccueil)this;
	}

	public void setPageUrl(Chaine o) throws Exception {
		this.pageUrl = o;
	}

	public Chaine pageUrl() throws Exception {
		return getPageUrl();
	}

	public Chaine getPageUrl() throws Exception {
		return pageUrl;
	}
	protected void pageUrlInit() throws Exception {
		if(!pageUrlCouverture.dejaInitialise) {
			_pageUrl(pageUrl);
		}
		pageUrlCouverture.dejaInitialise(true);
	}

	//////////////
	// pageUrls //
	//////////////

	/**	L'entité « pageUrls »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut UneListe<Chaine>(). 
	 */
	public UneListe<Chaine> pageUrls = new UneListe<Chaine>();
	public Couverture<UneListe<Chaine>> pageUrlsCouverture = new Couverture<UneListe<Chaine>>().p(this).c(UneListe.class).var("pageUrls").o(pageUrls);

	/**	L'entité « pageUrls »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut UneListe<Chaine>(). 
	 *	@param pageUrls est le champ déjà construit. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _pageUrls(UneListe<Chaine> o) throws Exception;

	public PageAccueil pageUrls(UneListe<Chaine> o) throws Exception {
		setPageUrls(o);
		return (PageAccueil)this;
	}

	public void setPageUrls(UneListe<Chaine> o) throws Exception {
		this.pageUrls = o;
	}

	public UneListe<Chaine> pageUrls() throws Exception {
		return getPageUrls();
	}

	public UneListe<Chaine> getPageUrls() throws Exception {
		return pageUrls;
	}
	protected void pageUrlsInit() throws Exception {
		if(!pageUrlsCouverture.dejaInitialise) {
			_pageUrls(pageUrls);
		}
		pageUrlsCouverture.dejaInitialise(true);
	}

	///////////////////////
	// pageBlogRecherche //
	///////////////////////

	/**	L'entité « pageBlogRecherche »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public String pageBlogRecherche;
	public Couverture<String> pageBlogRechercheCouverture = new Couverture<String>().p(this).c(String.class).var("pageBlogRecherche").o(pageBlogRecherche);

	/**	L'entité « pageBlogRecherche »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _pageBlogRecherche(Couverture<String> o) throws Exception;

	public PageAccueil pageBlogRecherche(String o) throws Exception {
		setPageBlogRecherche(o);
		return (PageAccueil)this;
	}

	public void setPageBlogRecherche(String o) throws Exception {
		this.pageBlogRecherche = o;
	}

	public String pageBlogRecherche() throws Exception {
		return getPageBlogRecherche();
	}

	public String getPageBlogRecherche() throws Exception {
		return pageBlogRecherche;
	}
	protected void pageBlogRechercheInit() throws Exception {
		if(!pageBlogRechercheCouverture.dejaInitialise) {
			_pageBlogRecherche(pageBlogRechercheCouverture);
			if(pageBlogRecherche == null)
				pageBlogRecherche(pageBlogRechercheCouverture.o);
		}
		pageBlogRechercheCouverture.dejaInitialise(true);
	}

	///////////
	// blogs //
	///////////

	/**	L'entité « blogs »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut ListeBlog2(). 
	 */
	public ListeBlog2 blogs = new ListeBlog2();
	public Couverture<ListeBlog2> blogsCouverture = new Couverture<ListeBlog2>().p(this).c(ListeBlog2.class).var("blogs").o(blogs);

	/**	L'entité « blogs »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut ListeBlog2(). 
	 *	@param blogs est le champ déjà construit. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _blogs(ListeBlog2 o) throws Exception;

	public PageAccueil blogs(ListeBlog2 o) throws Exception {
		setBlogs(o);
		return (PageAccueil)this;
	}

	public void setBlogs(ListeBlog2 o) throws Exception {
		this.blogs = o;
	}

	public ListeBlog2 blogs() throws Exception {
		return getBlogs();
	}

	public ListeBlog2 getBlogs() throws Exception {
		return blogs;
	}
	protected void blogsInit() throws Exception {
		if(!blogsCouverture.dejaInitialise) {
			_blogs(blogs);
		}
		blogsCouverture.dejaInitialise(true);
	}

	///////////////////////////
	// pageBlogRechercheHtml //
	///////////////////////////

	/**	L'entité « pageBlogRechercheHtml »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public É pageBlogRechercheHtml;
	public Couverture<É> pageBlogRechercheHtmlCouverture = new Couverture<É>().p(this).c(É.class).var("pageBlogRechercheHtml").o(pageBlogRechercheHtml);

	/**	L'entité « pageBlogRechercheHtml »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _pageBlogRechercheHtml(Couverture<É> o) throws Exception;

	public PageAccueil pageBlogRechercheHtml(É o) throws Exception {
		setPageBlogRechercheHtml(o);
		return (PageAccueil)this;
	}

	public void setPageBlogRechercheHtml(É o) throws Exception {
		this.pageBlogRechercheHtml = o;
	}

	public É pageBlogRechercheHtml() throws Exception {
		return getPageBlogRechercheHtml();
	}

	public É getPageBlogRechercheHtml() throws Exception {
		return pageBlogRechercheHtml;
	}
	protected void pageBlogRechercheHtmlInit() throws Exception {
		if(!pageBlogRechercheHtmlCouverture.dejaInitialise) {
			_pageBlogRechercheHtml(pageBlogRechercheHtmlCouverture);
			if(pageBlogRechercheHtml == null)
				pageBlogRechercheHtml(pageBlogRechercheHtmlCouverture.o);
		}
		pageBlogRechercheHtmlCouverture.dejaInitialise(true);
	}

	///////////
	// blog_ //
	///////////

	/**	L'entité « blog_ »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public BlogComputate2 blog_;
	public Couverture<BlogComputate2> blog_Couverture = new Couverture<BlogComputate2>().p(this).c(BlogComputate2.class).var("blog_").o(blog_);

	/**	L'entité « blog_ »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _blog_(Couverture<BlogComputate2> o) throws Exception;

	public PageAccueil blog_(BlogComputate2 o) throws Exception {
		setBlog_(o);
		return (PageAccueil)this;
	}

	public void setBlog_(BlogComputate2 o) throws Exception {
		this.blog_ = o;
	}

	public BlogComputate2 blog_() throws Exception {
		return getBlog_();
	}

	public BlogComputate2 getBlog_() throws Exception {
		return blog_;
	}
	protected void blog_Init() throws Exception {
		if(!blog_Couverture.dejaInitialise) {
			_blog_(blog_Couverture);
			if(blog_ == null)
				blog_(blog_Couverture.o);
		}
		blog_Couverture.dejaInitialise(true);
	}

	/////////////
	// blogCle //
	/////////////

	/**	L'entité « blogCle »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public Long blogCle;
	public Couverture<Long> blogCleCouverture = new Couverture<Long>().p(this).c(Long.class).var("blogCle").o(blogCle);

	/**	L'entité « blogCle »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _blogCle(Couverture<Long> o) throws Exception;

	public PageAccueil blogCle(Long o) throws Exception {
		setBlogCle(o);
		return (PageAccueil)this;
	}

	public void setBlogCle(Long o) throws Exception {
		this.blogCle = o;
	}

	public Long blogCle() throws Exception {
		return getBlogCle();
	}

	public Long getBlogCle() throws Exception {
		return blogCle;
	}
	public PageAccueil blogCle(String o) throws Exception {
		if(org.apache.commons.lang3.math.NumberUtils.isNumber(o))
			this.blogCle = Long.parseLong(o);
		return (PageAccueil)this;
	}
	protected void blogCleInit() throws Exception {
		if(!blogCleCouverture.dejaInitialise) {
			_blogCle(blogCleCouverture);
			if(blogCle == null)
				blogCle(blogCleCouverture.o);
		}
		blogCleCouverture.dejaInitialise(true);
	}

	//////////
	// page //
	//////////

	/**	L'entité « page »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Html(). 
	 */
	public Html page = new Html();
	public Couverture<Html> pageCouverture = new Couverture<Html>().p(this).c(Html.class).var("page").o(page);

	/**	L'entité « page »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Html(). 
	 *	@param page est le champ déjà construit. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _page(Html o) throws Exception;

	public PageAccueil page(Html o) throws Exception {
		setPage(o);
		return (PageAccueil)this;
	}

	public void setPage(Html o) throws Exception {
		this.page = o;
	}

	public Html page() throws Exception {
		return getPage();
	}

	public Html getPage() throws Exception {
		return page;
	}
	protected void pageInit() throws Exception {
		if(!pageCouverture.dejaInitialise) {
			_page(page);
		}
		pageCouverture.dejaInitialise(true);
	}

	//////////
	// html //
	//////////

	/**	L'entité « html »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public É html;
	public Couverture<É> htmlCouverture = new Couverture<É>().p(this).c(É.class).var("html").o(html);

	/**	L'entité « html »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _html(Couverture<É> o) throws Exception;

	public PageAccueil html(É o) throws Exception {
		setHtml(o);
		return (PageAccueil)this;
	}

	public void setHtml(É o) throws Exception {
		this.html = o;
	}

	public É html() throws Exception {
		return getHtml();
	}

	public É getHtml() throws Exception {
		return html;
	}
	protected void htmlInit() throws Exception {
		if(!htmlCouverture.dejaInitialise) {
			_html(htmlCouverture);
			if(html == null)
				html(htmlCouverture.o);
		}
		htmlCouverture.dejaInitialise(true);
	}

	//////////
	// head //
	//////////

	/**	L'entité « head »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public É head;
	public Couverture<É> headCouverture = new Couverture<É>().p(this).c(É.class).var("head").o(head);

	/**	L'entité « head »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _head(Couverture<É> o) throws Exception;

	public PageAccueil head(É o) throws Exception {
		setHead(o);
		return (PageAccueil)this;
	}

	public void setHead(É o) throws Exception {
		this.head = o;
	}

	public É head() throws Exception {
		return getHead();
	}

	public É getHead() throws Exception {
		return head;
	}
	protected void headInit() throws Exception {
		if(!headCouverture.dejaInitialise) {
			_head(headCouverture);
			if(head == null)
				head(headCouverture.o);
		}
		headCouverture.dejaInitialise(true);
	}

	//////////
	// body //
	//////////

	/**	L'entité « body »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public É body;
	public Couverture<É> bodyCouverture = new Couverture<É>().p(this).c(É.class).var("body").o(body);

	/**	L'entité « body »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _body(Couverture<É> o) throws Exception;

	public PageAccueil body(É o) throws Exception {
		setBody(o);
		return (PageAccueil)this;
	}

	public void setBody(É o) throws Exception {
		this.body = o;
	}

	public É body() throws Exception {
		return getBody();
	}

	public É getBody() throws Exception {
		return body;
	}
	protected void bodyInit() throws Exception {
		if(!bodyCouverture.dejaInitialise) {
			_body(bodyCouverture);
			if(body == null)
				body(bodyCouverture.o);
		}
		bodyCouverture.dejaInitialise(true);
	}

	protected boolean dejaInitialisePageAccueil = false;

	public void initLoinPageAccueil(RequeteSite requeteSite) throws Exception {
		((PageAccueil)this).requeteSite(requeteSite);
		requeteSite(requeteSite);
		initLoinPageAccueil();
	}

	public void initLoinPageAccueil() throws Exception {
		if(!dejaInitialisePageAccueil) {
			requeteSiteInit();
			pageTitreInit();
			pageUriInit();
			cluster_Init();
			pageUrlInit();
			pageUrlsInit();
			pageBlogRechercheInit();
			blogsInit();
			pageBlogRechercheHtmlInit();
			blog_Init();
			blogCleInit();
			pageInit();
			htmlInit();
			headInit();
			bodyInit();
			dejaInitialisePageAccueil = true;
		}
	}

	public void initLoinPourClasse(RequeteSite requeteSite) throws Exception {
		initLoinPageAccueil(requeteSite);
	}
}
