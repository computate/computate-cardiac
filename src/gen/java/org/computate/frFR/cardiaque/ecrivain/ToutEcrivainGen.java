package org.computate.frFR.cardiaque.ecrivain;

import java.io.PrintWriter;
import org.computate.frFR.cardiaque.couverture.Couverture;
import org.computate.frFR.cardiaque.cluster.Cluster;
import java.io.StringWriter;
import org.apache.commons.text.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import java.io.File;
import java.lang.Exception;
import java.util.Objects;
import io.vertx.core.http.HttpServerResponse;
import org.computate.frFR.cardiaque.requete.RequeteSite;
import java.lang.Boolean;
import org.computate.frFR.cardiaque.ecrivain.ToutEcrivain;
import java.lang.Object;

/**	
 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.frFR.cardiaque.ecrivain.ToutEcrivain&fq=classeEtendGen_indexed_boolean:true">Trouver la classe  dans Solr</a>
 * <br/>
 **/
public abstract class ToutEcrivainGen<DEV> extends Object {

	//////////////////
	// requeteSite_ //
	//////////////////

	/**	L'entité « requeteSite_ »
	 *	 is defined as null before being initialized. 
	 */
	protected RequeteSite requeteSite_;
	public Couverture<RequeteSite> requeteSite_Couverture = new Couverture<RequeteSite>().p(this).c(RequeteSite.class).var("requeteSite_").o(requeteSite_);

	/**	<br/>L'entité « requeteSite_ »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.frFR.cardiaque.ecrivain.ToutEcrivain&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:requeteSite_">Trouver l'entité requeteSite_ dans Solr</a>
	 * <br/>
	 * @param o est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _requeteSite_(Couverture<RequeteSite> o);

	public RequeteSite getRequeteSite_() {
		return requeteSite_;
	}

	public void setRequeteSite_(RequeteSite o) {
		this.requeteSite_ = o;
		this.requeteSite_Couverture.dejaInitialise = true;
	}
	protected ToutEcrivain requeteSite_Init() throws Exception {
		if(!requeteSite_Couverture.dejaInitialise) {
			_requeteSite_(requeteSite_Couverture);
			if(requeteSite_ == null)
				setRequeteSite_(requeteSite_Couverture.o);
		}
		requeteSite_Couverture.dejaInitialise(true);
		return (ToutEcrivain)this;
	}

	/////////////
	// fichier //
	/////////////

	/**	L'entité « fichier »
	 *	 is defined as null before being initialized. 
	 */
	protected File fichier;
	public Couverture<File> fichierCouverture = new Couverture<File>().p(this).c(File.class).var("fichier").o(fichier);

	/**	<br/>L'entité « fichier »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.frFR.cardiaque.ecrivain.ToutEcrivain&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:fichier">Trouver l'entité fichier dans Solr</a>
	 * <br/>
	 * @param o est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _fichier(Couverture<File> o);

	public File getFichier() {
		return fichier;
	}

	public void setFichier(File o) {
		this.fichier = o;
		this.fichierCouverture.dejaInitialise = true;
	}
	protected ToutEcrivain fichierInit() throws Exception {
		if(!fichierCouverture.dejaInitialise) {
			_fichier(fichierCouverture);
			if(fichier == null)
				setFichier(fichierCouverture.o);
		}
		fichierCouverture.dejaInitialise(true);
		return (ToutEcrivain)this;
	}

	////////////////////
	// ecrivainString //
	////////////////////

	/**	L'entité « ecrivainString »
	 *	 is defined as null before being initialized. 
	 */
	protected StringWriter ecrivainString;
	public Couverture<StringWriter> ecrivainStringCouverture = new Couverture<StringWriter>().p(this).c(StringWriter.class).var("ecrivainString").o(ecrivainString);

	/**	<br/>L'entité « ecrivainString »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.frFR.cardiaque.ecrivain.ToutEcrivain&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:ecrivainString">Trouver l'entité ecrivainString dans Solr</a>
	 * <br/>
	 * @param o est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _ecrivainString(Couverture<StringWriter> o);

	public StringWriter getEcrivainString() {
		return ecrivainString;
	}

	public void setEcrivainString(StringWriter o) {
		this.ecrivainString = o;
		this.ecrivainStringCouverture.dejaInitialise = true;
	}
	protected ToutEcrivain ecrivainStringInit() throws Exception {
		if(!ecrivainStringCouverture.dejaInitialise) {
			_ecrivainString(ecrivainStringCouverture);
			if(ecrivainString == null)
				setEcrivainString(ecrivainStringCouverture.o);
		}
		ecrivainStringCouverture.dejaInitialise(true);
		return (ToutEcrivain)this;
	}

	////////////////////////
	// reponseServeurHttp //
	////////////////////////

	/**	L'entité « reponseServeurHttp »
	 *	 is defined as null before being initialized. 
	 */
	protected HttpServerResponse reponseServeurHttp;
	public Couverture<HttpServerResponse> reponseServeurHttpCouverture = new Couverture<HttpServerResponse>().p(this).c(HttpServerResponse.class).var("reponseServeurHttp").o(reponseServeurHttp);

	/**	<br/>L'entité « reponseServeurHttp »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.frFR.cardiaque.ecrivain.ToutEcrivain&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:reponseServeurHttp">Trouver l'entité reponseServeurHttp dans Solr</a>
	 * <br/>
	 * @param o est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _reponseServeurHttp(Couverture<HttpServerResponse> o);

	public HttpServerResponse getReponseServeurHttp() {
		return reponseServeurHttp;
	}

	public void setReponseServeurHttp(HttpServerResponse o) {
		this.reponseServeurHttp = o;
		this.reponseServeurHttpCouverture.dejaInitialise = true;
	}
	protected ToutEcrivain reponseServeurHttpInit() throws Exception {
		if(!reponseServeurHttpCouverture.dejaInitialise) {
			_reponseServeurHttp(reponseServeurHttpCouverture);
			if(reponseServeurHttp == null)
				setReponseServeurHttp(reponseServeurHttpCouverture.o);
		}
		reponseServeurHttpCouverture.dejaInitialise(true);
		return (ToutEcrivain)this;
	}

	////////////////////////
	// ecrivainImpression //
	////////////////////////

	/**	L'entité « ecrivainImpression »
	 *	 is defined as null before being initialized. 
	 */
	protected PrintWriter ecrivainImpression;
	public Couverture<PrintWriter> ecrivainImpressionCouverture = new Couverture<PrintWriter>().p(this).c(PrintWriter.class).var("ecrivainImpression").o(ecrivainImpression);

	/**	<br/>L'entité « ecrivainImpression »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.frFR.cardiaque.ecrivain.ToutEcrivain&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:ecrivainImpression">Trouver l'entité ecrivainImpression dans Solr</a>
	 * <br/>
	 * @param o est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _ecrivainImpression(Couverture<PrintWriter> o) throws Exception, Exception;

	public PrintWriter getEcrivainImpression() {
		return ecrivainImpression;
	}

	public void setEcrivainImpression(PrintWriter o) {
		this.ecrivainImpression = o;
		this.ecrivainImpressionCouverture.dejaInitialise = true;
	}
	protected ToutEcrivain ecrivainImpressionInit() throws Exception {
		if(!ecrivainImpressionCouverture.dejaInitialise) {
			_ecrivainImpression(ecrivainImpressionCouverture);
			if(ecrivainImpression == null)
				setEcrivainImpression(ecrivainImpressionCouverture.o);
		}
		ecrivainImpressionCouverture.dejaInitialise(true);
		return (ToutEcrivain)this;
	}

	//////////
	// vide //
	//////////

	/**	L'entité « vide »
	 *	 is defined as null before being initialized. 
	 */
	protected Boolean vide;
	public Couverture<Boolean> videCouverture = new Couverture<Boolean>().p(this).c(Boolean.class).var("vide").o(vide);

	/**	<br/>L'entité « vide »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.frFR.cardiaque.ecrivain.ToutEcrivain&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:vide">Trouver l'entité vide dans Solr</a>
	 * <br/>
	 * @param o est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _vide(Couverture<Boolean> o);

	public Boolean getVide() {
		return vide;
	}

	public void setVide(Boolean o) {
		this.vide = o;
		this.videCouverture.dejaInitialise = true;
	}
	public ToutEcrivain setVide(String o) {
		if(org.apache.commons.lang3.BooleanUtils.isTrue(org.apache.commons.lang3.BooleanUtils.toBoolean(o)))
			this.vide = Boolean.parseBoolean(o);
		this.videCouverture.dejaInitialise = true;
		return (ToutEcrivain)this;
	}
	protected ToutEcrivain videInit() throws Exception {
		if(!videCouverture.dejaInitialise) {
			_vide(videCouverture);
			if(vide == null)
				setVide(videCouverture.o);
		}
		videCouverture.dejaInitialise(true);
		return (ToutEcrivain)this;
	}

	public Boolean solrVide() {
		return vide;
	}

	public String strVide() {
		return vide == null ? "" : vide.toString();
	}

	public String nomAffichageVide() {
		return null;
	}

	public String htmTooltipVide() {
		return null;
	}

	public String htmVide() {
		return vide == null ? "" : StringEscapeUtils.escapeHtml4(strVide());
	}

	//////////////
	// initLoin //
	//////////////

	protected boolean dejaInitialiseToutEcrivain = false;

	public ToutEcrivain initLoinToutEcrivain(RequeteSite requeteSite) throws Exception {
		setRequeteSite_(requeteSite);
		if(!dejaInitialiseToutEcrivain) {
			dejaInitialiseToutEcrivain = true;
			initLoinToutEcrivain();
		}
		return (ToutEcrivain)this;
	}

	public void initLoinToutEcrivain() throws Exception {
		initToutEcrivain();
	}

	public void initToutEcrivain() throws Exception {
		requeteSite_Init();
		fichierInit();
		ecrivainStringInit();
		reponseServeurHttpInit();
		ecrivainImpressionInit();
		videInit();
	}

	public void initLoinPourClasse(RequeteSite requeteSite) throws Exception {
		initLoinToutEcrivain(requeteSite);
	}

	/////////////////
	// requeteSite //
	/////////////////

	public void requeteSiteToutEcrivain(RequeteSite requeteSite) {
	}

	public void requeteSitePourClasse(RequeteSite requeteSite) {
		requeteSiteToutEcrivain(requeteSite);
	}

	/////////////
	// obtenir //
	/////////////

	public Object obtenirPourClasse(String var) throws Exception {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtenirToutEcrivain(v);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.obtenirPourClasse(v);
			}
		}
		return o;
	}
	public Object obtenirToutEcrivain(String var) throws Exception {
		ToutEcrivain oToutEcrivain = (ToutEcrivain)this;
		switch(var) {
			case "requeteSite_":
				return oToutEcrivain.requeteSite_;
			case "fichier":
				return oToutEcrivain.fichier;
			case "ecrivainString":
				return oToutEcrivain.ecrivainString;
			case "reponseServeurHttp":
				return oToutEcrivain.reponseServeurHttp;
			case "ecrivainImpression":
				return oToutEcrivain.ecrivainImpression;
			case "vide":
				return oToutEcrivain.vide;
			default:
				return null;
		}
	}

	///////////////
	// attribuer //
	///////////////

	public boolean attribuerPourClasse(String var, Object val) throws Exception {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = attribuerToutEcrivain(v, val);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.attribuerPourClasse(v, val);
			}
		}
		return o != null;
	}
	public Object attribuerToutEcrivain(String var, Object val) {
		ToutEcrivain oToutEcrivain = (ToutEcrivain)this;
		switch(var) {
			default:
				return null;
		}
	}

	/////////////
	// definir //
	/////////////

	public boolean definirPourClasse(String var, String val) throws Exception {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		if(val != null) {
			for(String v : vars) {
				if(o == null)
					o = definirToutEcrivain(v, val);
				else if(o instanceof Cluster) {
					Cluster cluster = (Cluster)o;
					o = cluster.definirPourClasse(v, val);
				}
			}
		}
		return o != null;
	}
	public Object definirToutEcrivain(String var, String val) {
		switch(var) {
			default:
				return null;
		}
	}

	//////////////
	// hashCode //
	//////////////

	@Override public int hashCode() {
		return Objects.hash(vide);
	}

	////////////
	// equals //
	////////////

	@Override public boolean equals(Object o) {
		if(this == o)
			return true;
		if(!(o instanceof ToutEcrivain))
			return false;
		ToutEcrivain that = (ToutEcrivain)o;
		return Objects.equals( vide, that.vide );
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ToutEcrivain {");
		sb.append( "vide: " ).append(vide);
		sb.append(" }");
		return sb.toString();
	}
}
