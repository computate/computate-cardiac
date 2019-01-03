package org.computate.frFR.cardiaque.ecrivain;

import java.io.PrintWriter;
import org.computate.frFR.cardiaque.couverture.Couverture;
import org.computate.frFR.cardiaque.cluster.Cluster;
import java.io.StringWriter;
import org.apache.commons.text.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import io.vertx.core.http.HttpServerResponse;
import org.computate.frFR.cardiaque.requete.RequeteSite;
import java.lang.Boolean;
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
	protected ToutEcrivain requeteSite_Init()
 {
		if(!requeteSite_Couverture.dejaInitialise) {
			_requeteSite_(requeteSite_Couverture);
			if(requeteSite_ == null)
				setRequeteSite_(requeteSite_Couverture.o);
		}
		requeteSite_Couverture.dejaInitialise(true);
		return (ToutEcrivain)this;
	}

	//////////
	// file //
	//////////

	/**	L'entité « file »
	 *	 is defined as null before being initialized. 
	 */
	protected File file;
	public Couverture<File> fileCouverture = new Couverture<File>().p(this).c(File.class).var("file").o(file);

	/**	<br/>L'entité « file »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.frFR.cardiaque.ecrivain.ToutEcrivain&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:file">Trouver l'entité file dans Solr</a>
	 * <br/>
	 * @param o est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _file(Couverture<File> o);

	public File getFile() {
		return file;
	}

	public void setFile(File o) {
		this.file = o;
		this.fileCouverture.dejaInitialise = true;
	}
	protected ToutEcrivain fileInit()
 {
		if(!fileCouverture.dejaInitialise) {
			_file(fileCouverture);
			if(file == null)
				setFile(fileCouverture.o);
		}
		fileCouverture.dejaInitialise(true);
		return (ToutEcrivain)this;
	}

	//////////////////
	// stringWriter //
	//////////////////

	/**	L'entité « stringWriter »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut StringWriter(). 
	 */
	protected StringWriter stringWriter = new StringWriter();
	public Couverture<StringWriter> stringWriterCouverture = new Couverture<StringWriter>().p(this).c(StringWriter.class).var("stringWriter").o(stringWriter);

	/**	<br/>L'entité « stringWriter »
	 * Il est construit avant d'être initialisé avec le constructeur par défaut StringWriter(). 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.frFR.cardiaque.ecrivain.ToutEcrivain&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:stringWriter">Trouver l'entité stringWriter dans Solr</a>
	 * <br/>
	 * @param stringWriter est l'entité déjà construit. 
	 **/
	protected abstract void _stringWriter(StringWriter o);

	public StringWriter getStringWriter() {
		return stringWriter;
	}

	public void setStringWriter(StringWriter o) {
		this.stringWriter = o;
		this.stringWriterCouverture.dejaInitialise = true;
	}
	protected ToutEcrivain stringWriterInit()
 {
		if(!stringWriterCouverture.dejaInitialise) {
			_stringWriter(stringWriter);
		}
		stringWriterCouverture.dejaInitialise(true);
		return (ToutEcrivain)this;
	}

	////////////////////////
	// httpServerResponse //
	////////////////////////

	/**	L'entité « httpServerResponse »
	 *	 is defined as null before being initialized. 
	 */
	protected HttpServerResponse httpServerResponse;
	public Couverture<HttpServerResponse> httpServerResponseCouverture = new Couverture<HttpServerResponse>().p(this).c(HttpServerResponse.class).var("httpServerResponse").o(httpServerResponse);

	/**	<br/>L'entité « httpServerResponse »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.frFR.cardiaque.ecrivain.ToutEcrivain&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:httpServerResponse">Trouver l'entité httpServerResponse dans Solr</a>
	 * <br/>
	 * @param o est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _httpServerResponse(Couverture<HttpServerResponse> o);

	public HttpServerResponse getHttpServerResponse() {
		return httpServerResponse;
	}

	public void setHttpServerResponse(HttpServerResponse o) {
		this.httpServerResponse = o;
		this.httpServerResponseCouverture.dejaInitialise = true;
	}
	protected ToutEcrivain httpServerResponseInit()
 {
		if(!httpServerResponseCouverture.dejaInitialise) {
			_httpServerResponse(httpServerResponseCouverture);
			if(httpServerResponse == null)
				setHttpServerResponse(httpServerResponseCouverture.o);
		}
		httpServerResponseCouverture.dejaInitialise(true);
		return (ToutEcrivain)this;
	}

	/////////////////
	// printWriter //
	/////////////////

	/**	L'entité « printWriter »
	 *	 is defined as null before being initialized. 
	 */
	protected PrintWriter printWriter;
	public Couverture<PrintWriter> printWriterCouverture = new Couverture<PrintWriter>().p(this).c(PrintWriter.class).var("printWriter").o(printWriter);

	/**	<br/>L'entité « printWriter »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.frFR.cardiaque.ecrivain.ToutEcrivain&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:printWriter">Trouver l'entité printWriter dans Solr</a>
	 * <br/>
	 * @param o est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _printWriter(Couverture<PrintWriter> o) throws FileNotFoundException;

	public PrintWriter getPrintWriter() {
		return printWriter;
	}

	public void setPrintWriter(PrintWriter o) {
		this.printWriter = o;
		this.printWriterCouverture.dejaInitialise = true;
	}
	protected ToutEcrivain printWriterInit()
 throws FileNotFoundException {
		if(!printWriterCouverture.dejaInitialise) {
			_printWriter(printWriterCouverture);
			if(printWriter == null)
				setPrintWriter(printWriterCouverture.o);
		}
		printWriterCouverture.dejaInitialise(true);
		return (ToutEcrivain)this;
	}

	///////////
	// empty //
	///////////

	/**	L'entité « empty »
	 *	 is defined as null before being initialized. 
	 */
	protected Boolean empty;
	public Couverture<Boolean> emptyCouverture = new Couverture<Boolean>().p(this).c(Boolean.class).var("empty").o(empty);

	/**	<br/>L'entité « empty »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.frFR.cardiaque.ecrivain.ToutEcrivain&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:empty">Trouver l'entité empty dans Solr</a>
	 * <br/>
	 * @param o est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _empty(Couverture<Boolean> o);

	public Boolean getEmpty() {
		return empty;
	}

	public void setEmpty(Boolean o) {
		this.empty = o;
		this.emptyCouverture.dejaInitialise = true;
	}
	public ToutEcrivain setEmpty(String o) throws Exception {
		if(org.apache.commons.lang3.BooleanUtils.isTrue(org.apache.commons.lang3.BooleanUtils.toBoolean(o)))
			this.empty = Boolean.parseBoolean(o);
		this.emptyCouverture.dejaInitialise = true;
		return (ToutEcrivain)this;
	}
	protected ToutEcrivain emptyInit()
 {
		if(!emptyCouverture.dejaInitialise) {
			_empty(emptyCouverture);
			if(empty == null)
				setEmpty(emptyCouverture.o);
		}
		emptyCouverture.dejaInitialise(true);
		return (ToutEcrivain)this;
	}

	public Boolean solrEmpty() {
		return empty;
	}

	public String strEmpty() {
		return empty == null ? "" : empty.toString();
	}

	public String nomAffichageEmpty() {
		return null;
	}

	public String htmlTooltipEmpty() {
		return null;
	}

	public String htmlEmpty() {
		return empty == null ? "" : StringEscapeUtils.escapeHtml4(strEmpty());
	}

	//////////////
	// initLoin //
	//////////////

	protected boolean dejaInitialiseToutEcrivain = false;

	public ToutEcrivain initLoinToutEcrivain(RequeteSite requeteSite) throws FileNotFoundException {
		setRequeteSite_(requeteSite);
		initLoinToutEcrivain();
		return (ToutEcrivain)this;
	}

	public ToutEcrivain initLoinToutEcrivain() throws FileNotFoundException {
		if(!dejaInitialiseToutEcrivain) {
			dejaInitialiseToutEcrivain = true;
			requeteSite_Init();
			fileInit();
			stringWriterInit();
			httpServerResponseInit();
			printWriterInit();
			emptyInit();
		}
		return (ToutEcrivain)this;
	}

	public void initLoinPourClasse(RequeteSite requeteSite) throws FileNotFoundException {
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
			case "file":
				return oToutEcrivain.file;
			case "stringWriter":
				return oToutEcrivain.stringWriter;
			case "httpServerResponse":
				return oToutEcrivain.httpServerResponse;
			case "printWriter":
				return oToutEcrivain.printWriter;
			case "empty":
				return oToutEcrivain.empty;
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
	public Object attribuerToutEcrivain(String var, Object val) throws Exception {
		ToutEcrivain oToutEcrivain = (ToutEcrivain)this;
		switch(var) {
			default:
				return null;
		}
	}

	//////////////
	// hashCode //
	//////////////

	@Override public int hashCode() {
		return Objects.hash(empty);
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
		return Objects.equals( empty, that.empty );
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ToutEcrivain {");
		sb.append( "empty: " ).append(empty);
		sb.append(" }");
		return sb.toString();
	}
}
