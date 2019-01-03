package org.computate.frFR.cardiaque.page.parti;

import org.computate.frFR.cardiaque.page.parti.PageParti;
import org.computate.frFR.cardiaque.chaine.Chaine;
import org.computate.frFR.cardiaque.couverture.Couverture;
import io.vertx.core.http.HttpServerResponse;
import org.computate.frFR.cardiaque.cluster.Cluster;
import org.computate.frFR.cardiaque.requete.RequeteSite;
import org.apache.commons.text.StringEscapeUtils;
import java.lang.String;
import org.computate.frFR.cardiaque.page.MiseEnPage;
import org.apache.commons.lang3.StringUtils;

/**	
 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.frFR.cardiaque.page.parti.Icone&fq=classeEtendGen_indexed_boolean:true">Trouver la classe  dans Solr</a>
 * <br/>
 **/
public abstract class IconeGen<DEV> extends PageParti {

	//////////
	// type //
	//////////

	/**	L'entité « type »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 */
	protected Chaine type = new Chaine();
	public Couverture<Chaine> typeCouverture = new Couverture<Chaine>().p(this).c(Chaine.class).var("type").o(type);

	/**	<br/>L'entité « type »
	 * Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.frFR.cardiaque.page.parti.Icone&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:type">Trouver l'entité type dans Solr</a>
	 * <br/>
	 * @param type est l'entité déjà construit. 
	 **/
	protected abstract void _type(Chaine o) throws Exception;

	public Chaine getType() {
		return type;
	}

	public void setType(Chaine o) {
		this.type = o;
		this.typeCouverture.dejaInitialise = true;
	}
	public Icone setType(String o) throws Exception {
		type.tout(o);
		this.typeCouverture.dejaInitialise = true;
		return (Icone)this;
	}
	protected Icone typeInit() throws Exception {
		if(!typeCouverture.dejaInitialise) {
			_type(type);
		}
		type.initLoinPourClasse(requeteSite_);
		typeCouverture.dejaInitialise(true);
		return (Icone)this;
	}

	public String solrType() {
		return type == null ? null : type.toString();
	}

	public String strType() {
		return type == null ? "" : type.toString();
	}

	public String nomAffichageType() {
		return null;
	}

	public String htmlTooltipType() {
		return null;
	}

	public String htmlType() {
		return type == null ? "" : StringEscapeUtils.escapeHtml4(strType());
	}

	/////////
	// nom //
	/////////

	/**	L'entité « nom »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 */
	protected Chaine nom = new Chaine();
	public Couverture<Chaine> nomCouverture = new Couverture<Chaine>().p(this).c(Chaine.class).var("nom").o(nom);

	/**	<br/>L'entité « nom »
	 * Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.frFR.cardiaque.page.parti.Icone&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:nom">Trouver l'entité nom dans Solr</a>
	 * <br/>
	 * @param nom est l'entité déjà construit. 
	 **/
	protected abstract void _nom(Chaine o) throws Exception;

	public Chaine getNom() {
		return nom;
	}

	public void setNom(Chaine o) {
		this.nom = o;
		this.nomCouverture.dejaInitialise = true;
	}
	public Icone setNom(String o) throws Exception {
		nom.tout(o);
		this.nomCouverture.dejaInitialise = true;
		return (Icone)this;
	}
	protected Icone nomInit() throws Exception {
		if(!nomCouverture.dejaInitialise) {
			_nom(nom);
		}
		nom.initLoinPourClasse(requeteSite_);
		nomCouverture.dejaInitialise(true);
		return (Icone)this;
	}

	public String solrNom() {
		return nom == null ? null : nom.toString();
	}

	public String strNom() {
		return nom == null ? "" : nom.toString();
	}

	public String nomAffichageNom() {
		return null;
	}

	public String htmlTooltipNom() {
		return null;
	}

	public String htmlNom() {
		return nom == null ? "" : StringEscapeUtils.escapeHtml4(strNom());
	}

	///////////
	// page_ //
	///////////

	/**	L'entité « page_ »
	 *	 is defined as null before being initialized. 
	 */
	protected MiseEnPage page_;
	public Couverture<MiseEnPage> page_Couverture = new Couverture<MiseEnPage>().p(this).c(MiseEnPage.class).var("page_").o(page_);

	/**	<br/>L'entité « page_ »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.frFR.cardiaque.page.parti.Icone&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:page_">Trouver l'entité page_ dans Solr</a>
	 * <br/>
	 * @param o est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _page_(Couverture<MiseEnPage> o) throws Exception;

	public MiseEnPage getPage_() {
		return page_;
	}

	public void setPage_(MiseEnPage o) {
		this.page_ = o;
		this.page_Couverture.dejaInitialise = true;
	}
	protected Icone page_Init() throws Exception {
		if(!page_Couverture.dejaInitialise) {
			_page_(page_Couverture);
			if(page_ == null)
				setPage_(page_Couverture.o);
		}
		page_Couverture.dejaInitialise(true);
		return (Icone)this;
	}

	//////////////
	// initLoin //
	//////////////

	protected boolean dejaInitialiseIcone = false;

	public Icone initLoinIcone(RequeteSite requeteSite) throws Exception {
		setRequeteSite_(requeteSite);
		initLoinIcone();
		return (Icone)this;
	}

	public Icone initLoinIcone() throws Exception {
		if(!dejaInitialiseIcone) {
			dejaInitialiseIcone = true;
			super.initLoinPageParti(requeteSite_);
			typeInit();
			nomInit();
			page_Init();
		}
		return (Icone)this;
	}

	public void initLoinPourClasse(RequeteSite requeteSite) throws Exception {
		initLoinIcone(requeteSite);
	}

	/////////////////
	// requeteSite //
	/////////////////

	public void requeteSiteIcone(RequeteSite requeteSite) throws Exception {
			super.requeteSitePageParti(requeteSite);
		type.setRequeteSite_(requeteSite);
		nom.setRequeteSite_(requeteSite);
	}

	public void requeteSitePourClasse(RequeteSite requeteSite) throws Exception {
		requeteSiteIcone(requeteSite);
	}

	/////////////
	// obtenir //
	/////////////

	@Override public Object obtenirPourClasse(String var) throws Exception {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtenirIcone(v);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.obtenirPourClasse(v);
			}
		}
		return o;
	}
	public Object obtenirIcone(String var) throws Exception {
		Icone oIcone = (Icone)this;
		switch(var) {
			case "type":
				return oIcone.type;
			case "nom":
				return oIcone.nom;
			case "page_":
				return oIcone.page_;
			default:
				return super.obtenirPageParti(var);
		}
	}

	///////////////
	// attribuer //
	///////////////

	@Override public boolean attribuerPourClasse(String var, Object val) throws Exception {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = attribuerIcone(v, val);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.attribuerPourClasse(v, val);
			}
		}
		return o != null;
	}
	public Object attribuerIcone(String var, Object val) throws Exception {
		Icone oIcone = (Icone)this;
		switch(var) {
			default:
				return super.attribuerPageParti(var, val);
		}
	}
}
