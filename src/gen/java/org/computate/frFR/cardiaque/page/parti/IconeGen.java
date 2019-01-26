package org.computate.frFR.cardiaque.page.parti;

import java.util.Objects;
import org.computate.frFR.cardiaque.page.parti.PageParti;
import org.computate.frFR.cardiaque.chaine.Chaine;
import org.computate.frFR.cardiaque.couverture.Couverture;
import org.computate.frFR.cardiaque.cluster.Cluster;
import org.computate.frFR.cardiaque.requete.RequeteSite;
import org.computate.frFR.cardiaque.ecrivain.ToutEcrivain;
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
	protected abstract void _type(Chaine o);

	public Chaine getType() {
		return type;
	}

	public void setType(Chaine type) {
		this.type = type;
		this.typeCouverture.dejaInitialise = true;
	}
	public Icone setType(String o) {
		type.s(o);
		this.typeCouverture.dejaInitialise = true;
		return (Icone)this;
	}
	protected Icone typeInit() {
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

	public String htmTooltipType() {
		return null;
	}

	public String htmType() {
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
	protected abstract void _nom(Chaine o);

	public Chaine getNom() {
		return nom;
	}

	public void setNom(Chaine nom) {
		this.nom = nom;
		this.nomCouverture.dejaInitialise = true;
	}
	public Icone setNom(String o) {
		nom.s(o);
		this.nomCouverture.dejaInitialise = true;
		return (Icone)this;
	}
	protected Icone nomInit() {
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

	public String htmTooltipNom() {
		return null;
	}

	public String htmNom() {
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
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _page_(Couverture<MiseEnPage> c);

	public MiseEnPage getPage_() {
		return page_;
	}

	public void setPage_(MiseEnPage page_) {
		this.page_ = page_;
		this.page_Couverture.dejaInitialise = true;
	}
	protected Icone page_Init() {
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

	public Icone initLoinIcone(RequeteSite requeteSite_) {
		setRequeteSite_(requeteSite_);
		if(!dejaInitialiseIcone) {
			dejaInitialiseIcone = true;
			initLoinIcone();
		}
		return (Icone)this;
	}

	public void initLoinIcone() {
		super.initLoinPageParti(requeteSite_);
		initIcone();
	}

	public void initIcone() {
		typeInit();
		nomInit();
		page_Init();
	}

	@Override public void initLoinPourClasse(RequeteSite requeteSite_) {
		initLoinIcone(requeteSite_);
	}

	/////////////////
	// requeteSite //
	/////////////////

	public void requeteSiteIcone(RequeteSite requeteSite_) {
			super.requeteSitePageParti(requeteSite_);
		type.setRequeteSite_(requeteSite_);
		nom.setRequeteSite_(requeteSite_);
	}

	public void requeteSitePourClasse(RequeteSite requeteSite_) {
		requeteSiteIcone(requeteSite_);
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

	@Override public boolean attribuerPourClasse(String var, Object val) {
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
	public Object attribuerIcone(String var, Object val) {
		Icone oIcone = (Icone)this;
		switch(var) {
			default:
				return super.attribuerPageParti(var, val);
		}
	}

	/////////////
	// definir //
	/////////////

	@Override public boolean definirPourClasse(String var, String val) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		if(val != null) {
			for(String v : vars) {
				if(o == null)
					o = definirIcone(v, val);
				else if(o instanceof Cluster) {
					Cluster cluster = (Cluster)o;
					o = cluster.definirPourClasse(v, val);
				}
			}
		}
		return o != null;
	}
	public Object definirIcone(String var, String val) {
		switch(var) {
			default:
				return super.definirPageParti(var, val);
		}
	}

	//////////////
	// hashCode //
	//////////////

	@Override public int hashCode() {
		return Objects.hash(super.hashCode(), type, nom);
	}

	////////////
	// equals //
	////////////

	@Override public boolean equals(Object o) {
		if(this == o)
			return true;
		if(!(o instanceof Icone))
			return false;
		Icone that = (Icone)o;
		return super.equals(o)
				&& Objects.equals( type, that.type )
				&& Objects.equals( nom, that.nom );
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString() + "\n");
		sb.append("Icone {");
		sb.append( "type: " ).append(type);
		sb.append( ", nom: " ).append(nom);
		sb.append(" }");
		return sb.toString();
	}
}
