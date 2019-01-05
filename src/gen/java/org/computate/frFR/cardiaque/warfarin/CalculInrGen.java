package org.computate.frFR.cardiaque.warfarin;

import org.computate.frFR.cardiaque.couverture.Couverture;
import java.util.Date;
import org.apache.commons.lang3.StringUtils;
import io.vertx.core.logging.LoggerFactory;
import java.util.ArrayList;
import java.lang.Long;
import org.computate.frFR.cardiaque.requete.RequeteSite;
import org.computate.frFR.cardiaque.ecrivain.ToutEcrivain;
import io.vertx.core.json.JsonObject;
import java.lang.String;
import io.vertx.core.logging.Logger;
import org.computate.frFR.cardiaque.chaine.Chaine;
import org.computate.frFR.cardiaque.cluster.Cluster;
import java.util.Set;
import org.apache.commons.text.StringEscapeUtils;
import java.time.Instant;
import java.time.ZoneId;
import org.apache.solr.client.solrj.SolrClient;
import org.computate.frFR.cardiaque.contexte.SiteContexte;
import java.util.Objects;
import org.apache.solr.common.SolrDocument;
import io.vertx.core.json.JsonArray;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import io.vertx.ext.sql.SQLConnection;
import io.vertx.ext.sql.SQLClient;
import org.apache.solr.common.SolrInputDocument;

/**	
 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.frFR.cardiaque.warfarin.CalculInr&fq=classeEtendGen_indexed_boolean:true">Trouver la classe  dans Solr</a>
 * <br/>
 **/
public abstract class CalculInrGen<DEV> extends Cluster {
	private static final Logger LOGGER = LoggerFactory.getLogger(CalculInr.class);
	public static final String VAL_patientPrendCoumadinOui = "Yes";
	public static final String VAL_patientPrendCoumadinNon = "No";
	public static final String VAL_patientPrendCoumadinOuiDosageInitial = "Yes, initial dosing";
	public static final String VAL_patientPrendCoumadinOuiRecommence = "Yes, restarted";

	///////////////////
	// utilisateurPk //
	///////////////////

	/**	L'entité « utilisateurPk »
	 *	 is defined as null before being initialized. 
	 */
	protected Long utilisateurPk;
	public Couverture<Long> utilisateurPkCouverture = new Couverture<Long>().p(this).c(Long.class).var("utilisateurPk").o(utilisateurPk);

	/**	<br/>L'entité « utilisateurPk »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.frFR.cardiaque.warfarin.CalculInr&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:utilisateurPk">Trouver l'entité utilisateurPk dans Solr</a>
	 * <br/>
	 * @param o est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _utilisateurPk(Couverture<Long> o);

	public Long getUtilisateurPk() {
		return utilisateurPk;
	}

	public void setUtilisateurPk(Long o) {
		this.utilisateurPk = o;
		this.utilisateurPkCouverture.dejaInitialise = true;
	}
	public CalculInr setUtilisateurPk(String o) {
		if(org.apache.commons.lang3.math.NumberUtils.isCreatable(o))
			this.utilisateurPk = Long.parseLong(o);
		this.utilisateurPkCouverture.dejaInitialise = true;
		return (CalculInr)this;
	}
	protected CalculInr utilisateurPkInit()
 {
		if(!utilisateurPkCouverture.dejaInitialise) {
			_utilisateurPk(utilisateurPkCouverture);
			if(utilisateurPk == null)
				setUtilisateurPk(utilisateurPkCouverture.o);
		}
		utilisateurPkCouverture.dejaInitialise(true);
		return (CalculInr)this;
	}

	public Long solrUtilisateurPk() {
		return utilisateurPk;
	}

	public String strUtilisateurPk() {
		return utilisateurPk == null ? "" : utilisateurPk.toString();
	}

	public String nomAffichageUtilisateurPk() {
		return null;
	}

	public String htmTooltipUtilisateurPk() {
		return null;
	}

	public String htmUtilisateurPk() {
		return utilisateurPk == null ? "" : StringEscapeUtils.escapeHtml4(strUtilisateurPk());
	}

	public void htmUtilisateurPk(ToutEcrivain r, Boolean patchDroits) {
		if(pk!= null) {
			r.s("<div id=\"patchCalculInr", strPk(), "UtilisateurPk\">");
			if(patchDroits) {
				r.l();
				r.l("	<script>//<![CDATA[");
				r.l("		function patchCalculInr", strPk(), "UtilisateurPk() {");
				r.l("			$.ajax({");
				r.l("				url: '/api/v1/warfarin/calcul-inr?fq=pk:", strPk(), "',");
				r.l("				dataType: 'json',");
				r.l("				type: 'patch',");
				r.l("				contentType: 'application/json',");
				r.l("				processData: false,");
				r.l("				success: function( data, textStatus, jQxhr ) {");
				r.l("					");
				r.l("				},");
				r.l("				error: function( jqXhr, textStatus, errorThrown ) {");
				r.l("					");
				r.l("				},");
				r.l("				data: {\"setUtilisateurPk\": this.value },");
				r.l("				");
				r.l("			});");
				r.l("		}");
				r.l("	//]]></script>");
				r.l("	<div class=\"\">");
				r.l("		<label class=\"w3-tooltip \">");
				r.l("			<span>", StringEscapeUtils.escapeHtml4(nomAffichageUtilisateurPk()), "</span>");
				r.s("			<input");
							r.s(" name=\"utilisateurPk\"");
							r.s(" value=\"", htmUtilisateurPk(), "\");");
							r.s(" onchange=\"\"");
							r.l("/>");
				r.l("		</label>");
				r.l("	</div>");
			} else {
				r.s(htmUtilisateurPk());
			}
			r.l("</div>");
		}
	}

	/////////////
	// dateInr //
	/////////////

	/**	L'entité « dateInr »
	 *	 is defined as null before being initialized. 
	 */
	protected LocalDate dateInr;
	public Couverture<LocalDate> dateInrCouverture = new Couverture<LocalDate>().p(this).c(LocalDate.class).var("dateInr").o(dateInr);

	/**	<br/>L'entité « dateInr »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.frFR.cardiaque.warfarin.CalculInr&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:dateInr">Trouver l'entité dateInr dans Solr</a>
	 * <br/>
	 * @param o est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _dateInr(Couverture<LocalDate> o);

	public LocalDate getDateInr() {
		return dateInr;
	}

	public void setDateInr(LocalDate o) {
		this.dateInr = o;
		this.dateInrCouverture.dejaInitialise = true;
	}
	public CalculInr setDateInr(Instant o) {
		this.dateInr = LocalDate.from(o);
		this.dateInrCouverture.dejaInitialise = true;
		return (CalculInr)this;
	}
	/** Example: 2011-12-03+01:00 **/
	public CalculInr setDateInr(String o) {
		this.dateInr = LocalDate.parse(o, DateTimeFormatter.ISO_OFFSET_DATE);
		this.dateInrCouverture.dejaInitialise = true;
		return (CalculInr)this;
	}
	public CalculInr setDateInr(Date o) {
		this.dateInr = o.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		this.dateInrCouverture.dejaInitialise = true;
		return (CalculInr)this;
	}
	protected CalculInr dateInrInit()
 {
		if(!dateInrCouverture.dejaInitialise) {
			_dateInr(dateInrCouverture);
			if(dateInr == null)
				setDateInr(dateInrCouverture.o);
		}
		dateInrCouverture.dejaInitialise(true);
		return (CalculInr)this;
	}

	public Date solrDateInr() {
		return dateInr == null ? null : Date.from(dateInr.atStartOfDay(ZoneId.systemDefault()).toInstant());
	}

	public String strDateInr() {
		return dateInr == null ? "" : dateInr.toString();
	}

	public String nomAffichageDateInr() {
		return null;
	}

	public String htmTooltipDateInr() {
		return null;
	}

	public String htmDateInr() {
		return dateInr == null ? "" : StringEscapeUtils.escapeHtml4(strDateInr());
	}

	public void htmDateInr(ToutEcrivain r, Boolean patchDroits) {
		if(pk!= null) {
			r.s("<div id=\"patchCalculInr", strPk(), "DateInr\">");
			if(patchDroits) {
				r.l();
				r.l("	<script>//<![CDATA[");
				r.l("		function patchCalculInr", strPk(), "DateInr() {");
				r.l("			$.ajax({");
				r.l("				url: '/api/v1/warfarin/calcul-inr?fq=pk:", strPk(), "',");
				r.l("				dataType: 'json',");
				r.l("				type: 'patch',");
				r.l("				contentType: 'application/json',");
				r.l("				processData: false,");
				r.l("				success: function( data, textStatus, jQxhr ) {");
				r.l("					");
				r.l("				},");
				r.l("				error: function( jqXhr, textStatus, errorThrown ) {");
				r.l("					");
				r.l("				},");
				r.l("				data: {\"setDateInr\": this.value },");
				r.l("				");
				r.l("			});");
				r.l("		}");
				r.l("	//]]></script>");
				r.l("	<div class=\"\">");
				r.l("		<label class=\"w3-tooltip \">");
				r.l("			<span>", StringEscapeUtils.escapeHtml4(nomAffichageDateInr()), "</span>");
				r.s("			<input");
							r.s(" name=\"dateInr\"");
							r.s(" value=\"", htmDateInr(), "\");");
							r.s(" onchange=\"\"");
							r.l("/>");
				r.l("		</label>");
				r.l("	</div>");
			} else {
				r.s(htmDateInr());
			}
			r.l("</div>");
		}
	}

	////////////////////
	// dateReverifier //
	////////////////////

	/**	L'entité « dateReverifier »
	 *	 is defined as null before being initialized. 
	 */
	protected LocalDate dateReverifier;
	public Couverture<LocalDate> dateReverifierCouverture = new Couverture<LocalDate>().p(this).c(LocalDate.class).var("dateReverifier").o(dateReverifier);

	/**	<br/>L'entité « dateReverifier »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.frFR.cardiaque.warfarin.CalculInr&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:dateReverifier">Trouver l'entité dateReverifier dans Solr</a>
	 * <br/>
	 * @param o est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _dateReverifier(Couverture<LocalDate> o);

	public LocalDate getDateReverifier() {
		return dateReverifier;
	}

	public void setDateReverifier(LocalDate o) {
		this.dateReverifier = o;
		this.dateReverifierCouverture.dejaInitialise = true;
	}
	public CalculInr setDateReverifier(Instant o) {
		this.dateReverifier = LocalDate.from(o);
		this.dateReverifierCouverture.dejaInitialise = true;
		return (CalculInr)this;
	}
	/** Example: 2011-12-03+01:00 **/
	public CalculInr setDateReverifier(String o) {
		this.dateReverifier = LocalDate.parse(o, DateTimeFormatter.ISO_OFFSET_DATE);
		this.dateReverifierCouverture.dejaInitialise = true;
		return (CalculInr)this;
	}
	public CalculInr setDateReverifier(Date o) {
		this.dateReverifier = o.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		this.dateReverifierCouverture.dejaInitialise = true;
		return (CalculInr)this;
	}
	protected CalculInr dateReverifierInit()
 {
		if(!dateReverifierCouverture.dejaInitialise) {
			_dateReverifier(dateReverifierCouverture);
			if(dateReverifier == null)
				setDateReverifier(dateReverifierCouverture.o);
		}
		dateReverifierCouverture.dejaInitialise(true);
		return (CalculInr)this;
	}

	public Date solrDateReverifier() {
		return dateReverifier == null ? null : Date.from(dateReverifier.atStartOfDay(ZoneId.systemDefault()).toInstant());
	}

	public String strDateReverifier() {
		return dateReverifier == null ? "" : dateReverifier.toString();
	}

	public String nomAffichageDateReverifier() {
		return null;
	}

	public String htmTooltipDateReverifier() {
		return null;
	}

	public String htmDateReverifier() {
		return dateReverifier == null ? "" : StringEscapeUtils.escapeHtml4(strDateReverifier());
	}

	public void htmDateReverifier(ToutEcrivain r, Boolean patchDroits) {
		if(pk!= null) {
			r.s("<div id=\"patchCalculInr", strPk(), "DateReverifier\">");
			if(patchDroits) {
				r.l();
				r.l("	<script>//<![CDATA[");
				r.l("		function patchCalculInr", strPk(), "DateReverifier() {");
				r.l("			$.ajax({");
				r.l("				url: '/api/v1/warfarin/calcul-inr?fq=pk:", strPk(), "',");
				r.l("				dataType: 'json',");
				r.l("				type: 'patch',");
				r.l("				contentType: 'application/json',");
				r.l("				processData: false,");
				r.l("				success: function( data, textStatus, jQxhr ) {");
				r.l("					");
				r.l("				},");
				r.l("				error: function( jqXhr, textStatus, errorThrown ) {");
				r.l("					");
				r.l("				},");
				r.l("				data: {\"setDateReverifier\": this.value },");
				r.l("				");
				r.l("			});");
				r.l("		}");
				r.l("	//]]></script>");
				r.l("	<div class=\"\">");
				r.l("		<label class=\"w3-tooltip \">");
				r.l("			<span>", StringEscapeUtils.escapeHtml4(nomAffichageDateReverifier()), "</span>");
				r.s("			<input");
							r.s(" name=\"dateReverifier\"");
							r.s(" value=\"", htmDateReverifier(), "\");");
							r.s(" onchange=\"\"");
							r.l("/>");
				r.l("		</label>");
				r.l("	</div>");
			} else {
				r.s(htmDateReverifier());
			}
			r.l("</div>");
		}
	}

	//////////////////////////
	// patientPrendCoumadin //
	//////////////////////////

	/**	L'entité « patientPrendCoumadin »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 */
	protected Chaine patientPrendCoumadin = new Chaine();
	public Couverture<Chaine> patientPrendCoumadinCouverture = new Couverture<Chaine>().p(this).c(Chaine.class).var("patientPrendCoumadin").o(patientPrendCoumadin);

	/**	<br/>L'entité « patientPrendCoumadin »
	 * Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.frFR.cardiaque.warfarin.CalculInr&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:patientPrendCoumadin">Trouver l'entité patientPrendCoumadin dans Solr</a>
	 * <br/>
	 * @param patientPrendCoumadin est l'entité déjà construit. 
	 **/
	protected abstract void _patientPrendCoumadin(Chaine o);

	public Chaine getPatientPrendCoumadin() {
		return patientPrendCoumadin;
	}

	public void setPatientPrendCoumadin(Chaine o) {
		this.patientPrendCoumadin = o;
		this.patientPrendCoumadinCouverture.dejaInitialise = true;
	}
	public CalculInr setPatientPrendCoumadin(String o) {
		patientPrendCoumadin.tout(o);
		this.patientPrendCoumadinCouverture.dejaInitialise = true;
		return (CalculInr)this;
	}
	protected CalculInr patientPrendCoumadinInit()
 {
		if(!patientPrendCoumadinCouverture.dejaInitialise) {
			_patientPrendCoumadin(patientPrendCoumadin);
		}
		patientPrendCoumadin.initLoinPourClasse(requeteSite_);
		patientPrendCoumadinCouverture.dejaInitialise(true);
		return (CalculInr)this;
	}

	public String solrPatientPrendCoumadin() {
		return patientPrendCoumadin == null ? null : patientPrendCoumadin.toString();
	}

	public String strPatientPrendCoumadin() {
		return patientPrendCoumadin == null ? "" : patientPrendCoumadin.toString();
	}

	public String nomAffichagePatientPrendCoumadin() {
		return null;
	}

	public String htmTooltipPatientPrendCoumadin() {
		return null;
	}

	public String htmPatientPrendCoumadin() {
		return patientPrendCoumadin == null ? "" : StringEscapeUtils.escapeHtml4(strPatientPrendCoumadin());
	}

	public void htmPatientPrendCoumadin(ToutEcrivain r, Boolean patchDroits) {
		if(pk!= null) {
			r.s("<div id=\"patchCalculInr", strPk(), "PatientPrendCoumadin\">");
			if(patchDroits) {
				r.l();
				r.l("	<script>//<![CDATA[");
				r.l("		function patchCalculInr", strPk(), "PatientPrendCoumadin() {");
				r.l("			$.ajax({");
				r.l("				url: '/api/v1/warfarin/calcul-inr?fq=pk:", strPk(), "',");
				r.l("				dataType: 'json',");
				r.l("				type: 'patch',");
				r.l("				contentType: 'application/json',");
				r.l("				processData: false,");
				r.l("				success: function( data, textStatus, jQxhr ) {");
				r.l("					");
				r.l("				},");
				r.l("				error: function( jqXhr, textStatus, errorThrown ) {");
				r.l("					");
				r.l("				},");
				r.l("				data: {\"setPatientPrendCoumadin\": this.value },");
				r.l("				");
				r.l("			});");
				r.l("		}");
				r.l("	//]]></script>");
				r.l("	<div class=\"\">");
				r.l("		<label class=\"w3-tooltip \">");
				r.l("			<span>", StringEscapeUtils.escapeHtml4(nomAffichagePatientPrendCoumadin()), "</span>");
				r.s("			<input");
							r.s(" name=\"patientPrendCoumadin\"");
							r.s(" value=\"", htmPatientPrendCoumadin(), "\");");
							r.s(" onchange=\"\"");
							r.l("/>");
				r.l("		</label>");
				r.l("	</div>");
			} else {
				r.s(htmPatientPrendCoumadin());
			}
			r.l("</div>");
		}
	}

	///////////////
	// butActuel //
	///////////////

	/**	L'entité « butActuel »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 */
	protected Chaine butActuel = new Chaine();
	public Couverture<Chaine> butActuelCouverture = new Couverture<Chaine>().p(this).c(Chaine.class).var("butActuel").o(butActuel);

	/**	<br/>L'entité « butActuel »
	 * Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.frFR.cardiaque.warfarin.CalculInr&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:butActuel">Trouver l'entité butActuel dans Solr</a>
	 * <br/>
	 * @param butActuel est l'entité déjà construit. 
	 **/
	protected abstract void _butActuel(Chaine o);

	public Chaine getButActuel() {
		return butActuel;
	}

	public void setButActuel(Chaine o) {
		this.butActuel = o;
		this.butActuelCouverture.dejaInitialise = true;
	}
	public CalculInr setButActuel(String o) {
		butActuel.tout(o);
		this.butActuelCouverture.dejaInitialise = true;
		return (CalculInr)this;
	}
	protected CalculInr butActuelInit()
 {
		if(!butActuelCouverture.dejaInitialise) {
			_butActuel(butActuel);
		}
		butActuel.initLoinPourClasse(requeteSite_);
		butActuelCouverture.dejaInitialise(true);
		return (CalculInr)this;
	}

	public String solrButActuel() {
		return butActuel == null ? null : butActuel.toString();
	}

	public String strButActuel() {
		return butActuel == null ? "" : butActuel.toString();
	}

	public String nomAffichageButActuel() {
		return null;
	}

	public String htmTooltipButActuel() {
		return null;
	}

	public String htmButActuel() {
		return butActuel == null ? "" : StringEscapeUtils.escapeHtml4(strButActuel());
	}

	public void htmButActuel(ToutEcrivain r, Boolean patchDroits) {
		if(pk!= null) {
			r.s("<div id=\"patchCalculInr", strPk(), "ButActuel\">");
			if(patchDroits) {
				r.l();
				r.l("	<script>//<![CDATA[");
				r.l("		function patchCalculInr", strPk(), "ButActuel() {");
				r.l("			$.ajax({");
				r.l("				url: '/api/v1/warfarin/calcul-inr?fq=pk:", strPk(), "',");
				r.l("				dataType: 'json',");
				r.l("				type: 'patch',");
				r.l("				contentType: 'application/json',");
				r.l("				processData: false,");
				r.l("				success: function( data, textStatus, jQxhr ) {");
				r.l("					");
				r.l("				},");
				r.l("				error: function( jqXhr, textStatus, errorThrown ) {");
				r.l("					");
				r.l("				},");
				r.l("				data: {\"setButActuel\": this.value },");
				r.l("				");
				r.l("			});");
				r.l("		}");
				r.l("	//]]></script>");
				r.l("	<div class=\"\">");
				r.l("		<label class=\"w3-tooltip \">");
				r.l("			<span>", StringEscapeUtils.escapeHtml4(nomAffichageButActuel()), "</span>");
				r.s("			<input");
							r.s(" name=\"butActuel\"");
							r.s(" value=\"", htmButActuel(), "\");");
							r.s(" onchange=\"\"");
							r.l("/>");
				r.l("		</label>");
				r.l("	</div>");
			} else {
				r.s(htmButActuel());
			}
			r.l("</div>");
		}
	}

	////////////////
	// doseActuel //
	////////////////

	/**	L'entité « doseActuel »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 */
	protected Chaine doseActuel = new Chaine();
	public Couverture<Chaine> doseActuelCouverture = new Couverture<Chaine>().p(this).c(Chaine.class).var("doseActuel").o(doseActuel);

	/**	<br/>L'entité « doseActuel »
	 * Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.frFR.cardiaque.warfarin.CalculInr&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:doseActuel">Trouver l'entité doseActuel dans Solr</a>
	 * <br/>
	 * @param doseActuel est l'entité déjà construit. 
	 **/
	protected abstract void _doseActuel(Chaine o);

	public Chaine getDoseActuel() {
		return doseActuel;
	}

	public void setDoseActuel(Chaine o) {
		this.doseActuel = o;
		this.doseActuelCouverture.dejaInitialise = true;
	}
	public CalculInr setDoseActuel(String o) {
		doseActuel.tout(o);
		this.doseActuelCouverture.dejaInitialise = true;
		return (CalculInr)this;
	}
	protected CalculInr doseActuelInit()
 {
		if(!doseActuelCouverture.dejaInitialise) {
			_doseActuel(doseActuel);
		}
		doseActuel.initLoinPourClasse(requeteSite_);
		doseActuelCouverture.dejaInitialise(true);
		return (CalculInr)this;
	}

	public String solrDoseActuel() {
		return doseActuel == null ? null : doseActuel.toString();
	}

	public String strDoseActuel() {
		return doseActuel == null ? "" : doseActuel.toString();
	}

	public String nomAffichageDoseActuel() {
		return null;
	}

	public String htmTooltipDoseActuel() {
		return null;
	}

	public String htmDoseActuel() {
		return doseActuel == null ? "" : StringEscapeUtils.escapeHtml4(strDoseActuel());
	}

	public void htmDoseActuel(ToutEcrivain r, Boolean patchDroits) {
		if(pk!= null) {
			r.s("<div id=\"patchCalculInr", strPk(), "DoseActuel\">");
			if(patchDroits) {
				r.l();
				r.l("	<script>//<![CDATA[");
				r.l("		function patchCalculInr", strPk(), "DoseActuel() {");
				r.l("			$.ajax({");
				r.l("				url: '/api/v1/warfarin/calcul-inr?fq=pk:", strPk(), "',");
				r.l("				dataType: 'json',");
				r.l("				type: 'patch',");
				r.l("				contentType: 'application/json',");
				r.l("				processData: false,");
				r.l("				success: function( data, textStatus, jQxhr ) {");
				r.l("					");
				r.l("				},");
				r.l("				error: function( jqXhr, textStatus, errorThrown ) {");
				r.l("					");
				r.l("				},");
				r.l("				data: {\"setDoseActuel\": this.value },");
				r.l("				");
				r.l("			});");
				r.l("		}");
				r.l("	//]]></script>");
				r.l("	<div class=\"\">");
				r.l("		<label class=\"w3-tooltip \">");
				r.l("			<span>", StringEscapeUtils.escapeHtml4(nomAffichageDoseActuel()), "</span>");
				r.s("			<input");
							r.s(" name=\"doseActuel\"");
							r.s(" value=\"", htmDoseActuel(), "\");");
							r.s(" onchange=\"\"");
							r.l("/>");
				r.l("		</label>");
				r.l("	</div>");
			} else {
				r.s(htmDoseActuel());
			}
			r.l("</div>");
		}
	}

	//////////////////////
	// medicamentActuel //
	//////////////////////

	/**	L'entité « medicamentActuel »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 */
	protected Chaine medicamentActuel = new Chaine();
	public Couverture<Chaine> medicamentActuelCouverture = new Couverture<Chaine>().p(this).c(Chaine.class).var("medicamentActuel").o(medicamentActuel);

	/**	<br/>L'entité « medicamentActuel »
	 * Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.frFR.cardiaque.warfarin.CalculInr&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:medicamentActuel">Trouver l'entité medicamentActuel dans Solr</a>
	 * <br/>
	 * @param medicamentActuel est l'entité déjà construit. 
	 **/
	protected abstract void _medicamentActuel(Chaine o);

	public Chaine getMedicamentActuel() {
		return medicamentActuel;
	}

	public void setMedicamentActuel(Chaine o) {
		this.medicamentActuel = o;
		this.medicamentActuelCouverture.dejaInitialise = true;
	}
	public CalculInr setMedicamentActuel(String o) {
		medicamentActuel.tout(o);
		this.medicamentActuelCouverture.dejaInitialise = true;
		return (CalculInr)this;
	}
	protected CalculInr medicamentActuelInit()
 {
		if(!medicamentActuelCouverture.dejaInitialise) {
			_medicamentActuel(medicamentActuel);
		}
		medicamentActuel.initLoinPourClasse(requeteSite_);
		medicamentActuelCouverture.dejaInitialise(true);
		return (CalculInr)this;
	}

	public String solrMedicamentActuel() {
		return medicamentActuel == null ? null : medicamentActuel.toString();
	}

	public String strMedicamentActuel() {
		return medicamentActuel == null ? "" : medicamentActuel.toString();
	}

	public String nomAffichageMedicamentActuel() {
		return null;
	}

	public String htmTooltipMedicamentActuel() {
		return null;
	}

	public String htmMedicamentActuel() {
		return medicamentActuel == null ? "" : StringEscapeUtils.escapeHtml4(strMedicamentActuel());
	}

	public void htmMedicamentActuel(ToutEcrivain r, Boolean patchDroits) {
		if(pk!= null) {
			r.s("<div id=\"patchCalculInr", strPk(), "MedicamentActuel\">");
			if(patchDroits) {
				r.l();
				r.l("	<script>//<![CDATA[");
				r.l("		function patchCalculInr", strPk(), "MedicamentActuel() {");
				r.l("			$.ajax({");
				r.l("				url: '/api/v1/warfarin/calcul-inr?fq=pk:", strPk(), "',");
				r.l("				dataType: 'json',");
				r.l("				type: 'patch',");
				r.l("				contentType: 'application/json',");
				r.l("				processData: false,");
				r.l("				success: function( data, textStatus, jQxhr ) {");
				r.l("					");
				r.l("				},");
				r.l("				error: function( jqXhr, textStatus, errorThrown ) {");
				r.l("					");
				r.l("				},");
				r.l("				data: {\"setMedicamentActuel\": this.value },");
				r.l("				");
				r.l("			});");
				r.l("		}");
				r.l("	//]]></script>");
				r.l("	<div class=\"\">");
				r.l("		<label class=\"w3-tooltip \">");
				r.l("			<span>", StringEscapeUtils.escapeHtml4(nomAffichageMedicamentActuel()), "</span>");
				r.s("			<input");
							r.s(" name=\"medicamentActuel\"");
							r.s(" value=\"", htmMedicamentActuel(), "\");");
							r.s(" onchange=\"\"");
							r.l("/>");
				r.l("		</label>");
				r.l("	</div>");
			} else {
				r.s(htmMedicamentActuel());
			}
			r.l("</div>");
		}
	}

	////////////////////
	// changementDose //
	////////////////////

	/**	L'entité « changementDose »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 */
	protected Chaine changementDose = new Chaine();
	public Couverture<Chaine> changementDoseCouverture = new Couverture<Chaine>().p(this).c(Chaine.class).var("changementDose").o(changementDose);

	/**	<br/>L'entité « changementDose »
	 * Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.frFR.cardiaque.warfarin.CalculInr&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:changementDose">Trouver l'entité changementDose dans Solr</a>
	 * <br/>
	 * @param changementDose est l'entité déjà construit. 
	 **/
	protected abstract void _changementDose(Chaine o);

	public Chaine getChangementDose() {
		return changementDose;
	}

	public void setChangementDose(Chaine o) {
		this.changementDose = o;
		this.changementDoseCouverture.dejaInitialise = true;
	}
	public CalculInr setChangementDose(String o) {
		changementDose.tout(o);
		this.changementDoseCouverture.dejaInitialise = true;
		return (CalculInr)this;
	}
	protected CalculInr changementDoseInit()
 {
		if(!changementDoseCouverture.dejaInitialise) {
			_changementDose(changementDose);
		}
		changementDose.initLoinPourClasse(requeteSite_);
		changementDoseCouverture.dejaInitialise(true);
		return (CalculInr)this;
	}

	public String solrChangementDose() {
		return changementDose == null ? null : changementDose.toString();
	}

	public String strChangementDose() {
		return changementDose == null ? "" : changementDose.toString();
	}

	public String nomAffichageChangementDose() {
		return null;
	}

	public String htmTooltipChangementDose() {
		return null;
	}

	public String htmChangementDose() {
		return changementDose == null ? "" : StringEscapeUtils.escapeHtml4(strChangementDose());
	}

	public void htmChangementDose(ToutEcrivain r, Boolean patchDroits) {
		if(pk!= null) {
			r.s("<div id=\"patchCalculInr", strPk(), "ChangementDose\">");
			if(patchDroits) {
				r.l();
				r.l("	<script>//<![CDATA[");
				r.l("		function patchCalculInr", strPk(), "ChangementDose() {");
				r.l("			$.ajax({");
				r.l("				url: '/api/v1/warfarin/calcul-inr?fq=pk:", strPk(), "',");
				r.l("				dataType: 'json',");
				r.l("				type: 'patch',");
				r.l("				contentType: 'application/json',");
				r.l("				processData: false,");
				r.l("				success: function( data, textStatus, jQxhr ) {");
				r.l("					");
				r.l("				},");
				r.l("				error: function( jqXhr, textStatus, errorThrown ) {");
				r.l("					");
				r.l("				},");
				r.l("				data: {\"setChangementDose\": this.value },");
				r.l("				");
				r.l("			});");
				r.l("		}");
				r.l("	//]]></script>");
				r.l("	<div class=\"\">");
				r.l("		<label class=\"w3-tooltip \">");
				r.l("			<span>", StringEscapeUtils.escapeHtml4(nomAffichageChangementDose()), "</span>");
				r.s("			<input");
							r.s(" name=\"changementDose\"");
							r.s(" value=\"", htmChangementDose(), "\");");
							r.s(" onchange=\"\"");
							r.l("/>");
				r.l("		</label>");
				r.l("	</div>");
			} else {
				r.s(htmChangementDose());
			}
			r.l("</div>");
		}
	}

	//////////////////////////
	// notesComplementaires //
	//////////////////////////

	/**	L'entité « notesComplementaires »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 */
	protected Chaine notesComplementaires = new Chaine();
	public Couverture<Chaine> notesComplementairesCouverture = new Couverture<Chaine>().p(this).c(Chaine.class).var("notesComplementaires").o(notesComplementaires);

	/**	<br/>L'entité « notesComplementaires »
	 * Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.frFR.cardiaque.warfarin.CalculInr&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:notesComplementaires">Trouver l'entité notesComplementaires dans Solr</a>
	 * <br/>
	 * @param notesComplementaires est l'entité déjà construit. 
	 **/
	protected abstract void _notesComplementaires(Chaine o);

	public Chaine getNotesComplementaires() {
		return notesComplementaires;
	}

	public void setNotesComplementaires(Chaine o) {
		this.notesComplementaires = o;
		this.notesComplementairesCouverture.dejaInitialise = true;
	}
	public CalculInr setNotesComplementaires(String o) {
		notesComplementaires.tout(o);
		this.notesComplementairesCouverture.dejaInitialise = true;
		return (CalculInr)this;
	}
	protected CalculInr notesComplementairesInit()
 {
		if(!notesComplementairesCouverture.dejaInitialise) {
			_notesComplementaires(notesComplementaires);
		}
		notesComplementaires.initLoinPourClasse(requeteSite_);
		notesComplementairesCouverture.dejaInitialise(true);
		return (CalculInr)this;
	}

	public String solrNotesComplementaires() {
		return notesComplementaires == null ? null : notesComplementaires.toString();
	}

	public String strNotesComplementaires() {
		return notesComplementaires == null ? "" : notesComplementaires.toString();
	}

	public String nomAffichageNotesComplementaires() {
		return null;
	}

	public String htmTooltipNotesComplementaires() {
		return null;
	}

	public String htmNotesComplementaires() {
		return notesComplementaires == null ? "" : StringEscapeUtils.escapeHtml4(strNotesComplementaires());
	}

	public void htmNotesComplementaires(ToutEcrivain r, Boolean patchDroits) {
		if(pk!= null) {
			r.s("<div id=\"patchCalculInr", strPk(), "NotesComplementaires\">");
			if(patchDroits) {
				r.l();
				r.l("	<script>//<![CDATA[");
				r.l("		function patchCalculInr", strPk(), "NotesComplementaires() {");
				r.l("			$.ajax({");
				r.l("				url: '/api/v1/warfarin/calcul-inr?fq=pk:", strPk(), "',");
				r.l("				dataType: 'json',");
				r.l("				type: 'patch',");
				r.l("				contentType: 'application/json',");
				r.l("				processData: false,");
				r.l("				success: function( data, textStatus, jQxhr ) {");
				r.l("					");
				r.l("				},");
				r.l("				error: function( jqXhr, textStatus, errorThrown ) {");
				r.l("					");
				r.l("				},");
				r.l("				data: {\"setNotesComplementaires\": this.value },");
				r.l("				");
				r.l("			});");
				r.l("		}");
				r.l("	//]]></script>");
				r.l("	<div class=\"\">");
				r.l("		<label class=\"w3-tooltip \">");
				r.l("			<span>", StringEscapeUtils.escapeHtml4(nomAffichageNotesComplementaires()), "</span>");
				r.s("			<input");
							r.s(" name=\"notesComplementaires\"");
							r.s(" value=\"", htmNotesComplementaires(), "\");");
							r.s(" onchange=\"\"");
							r.l("/>");
				r.l("		</label>");
				r.l("	</div>");
			} else {
				r.s(htmNotesComplementaires());
			}
			r.l("</div>");
		}
	}

	/////////////////
	// infoContact //
	/////////////////

	/**	L'entité « infoContact »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 */
	protected Chaine infoContact = new Chaine();
	public Couverture<Chaine> infoContactCouverture = new Couverture<Chaine>().p(this).c(Chaine.class).var("infoContact").o(infoContact);

	/**	<br/>L'entité « infoContact »
	 * Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.frFR.cardiaque.warfarin.CalculInr&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:infoContact">Trouver l'entité infoContact dans Solr</a>
	 * <br/>
	 * @param infoContact est l'entité déjà construit. 
	 **/
	protected abstract void _infoContact(Chaine o);

	public Chaine getInfoContact() {
		return infoContact;
	}

	public void setInfoContact(Chaine o) {
		this.infoContact = o;
		this.infoContactCouverture.dejaInitialise = true;
	}
	public CalculInr setInfoContact(String o) {
		infoContact.tout(o);
		this.infoContactCouverture.dejaInitialise = true;
		return (CalculInr)this;
	}
	protected CalculInr infoContactInit()
 {
		if(!infoContactCouverture.dejaInitialise) {
			_infoContact(infoContact);
		}
		infoContact.initLoinPourClasse(requeteSite_);
		infoContactCouverture.dejaInitialise(true);
		return (CalculInr)this;
	}

	public String solrInfoContact() {
		return infoContact == null ? null : infoContact.toString();
	}

	public String strInfoContact() {
		return infoContact == null ? "" : infoContact.toString();
	}

	public String nomAffichageInfoContact() {
		return null;
	}

	public String htmTooltipInfoContact() {
		return null;
	}

	public String htmInfoContact() {
		return infoContact == null ? "" : StringEscapeUtils.escapeHtml4(strInfoContact());
	}

	public void htmInfoContact(ToutEcrivain r, Boolean patchDroits) {
		if(pk!= null) {
			r.s("<div id=\"patchCalculInr", strPk(), "InfoContact\">");
			if(patchDroits) {
				r.l();
				r.l("	<script>//<![CDATA[");
				r.l("		function patchCalculInr", strPk(), "InfoContact() {");
				r.l("			$.ajax({");
				r.l("				url: '/api/v1/warfarin/calcul-inr?fq=pk:", strPk(), "',");
				r.l("				dataType: 'json',");
				r.l("				type: 'patch',");
				r.l("				contentType: 'application/json',");
				r.l("				processData: false,");
				r.l("				success: function( data, textStatus, jQxhr ) {");
				r.l("					");
				r.l("				},");
				r.l("				error: function( jqXhr, textStatus, errorThrown ) {");
				r.l("					");
				r.l("				},");
				r.l("				data: {\"setInfoContact\": this.value },");
				r.l("				");
				r.l("			});");
				r.l("		}");
				r.l("	//]]></script>");
				r.l("	<div class=\"\">");
				r.l("		<label class=\"w3-tooltip \">");
				r.l("			<span>", StringEscapeUtils.escapeHtml4(nomAffichageInfoContact()), "</span>");
				r.s("			<input");
							r.s(" name=\"infoContact\"");
							r.s(" value=\"", htmInfoContact(), "\");");
							r.s(" onchange=\"\"");
							r.l("/>");
				r.l("		</label>");
				r.l("	</div>");
			} else {
				r.s(htmInfoContact());
			}
			r.l("</div>");
		}
	}

	//////////////
	// initLoin //
	//////////////

	protected boolean dejaInitialiseCalculInr = false;

	public CalculInr initLoinCalculInr(RequeteSite requeteSite) {
		setRequeteSite_(requeteSite);
		if(!dejaInitialiseCalculInr) {
			dejaInitialiseCalculInr = true;
			initLoinCalculInr();
		}
		return (CalculInr)this;
	}

	public void initLoinCalculInr() {
		super.initLoinCluster(requeteSite_);
		initCalculInr();
	}

	public void initCalculInr() {
		utilisateurPkInit();
		dateInrInit();
		dateReverifierInit();
		patientPrendCoumadinInit();
		butActuelInit();
		doseActuelInit();
		medicamentActuelInit();
		changementDoseInit();
		notesComplementairesInit();
		infoContactInit();
	}

	@Override public void initLoinPourClasse(RequeteSite requeteSite) {
		initLoinCalculInr(requeteSite);
	}

	/////////////////
	// requeteSite //
	/////////////////

	public void requeteSiteCalculInr(RequeteSite requeteSite) {
			super.requeteSiteCluster(requeteSite);
		patientPrendCoumadin.setRequeteSite_(requeteSite);
		butActuel.setRequeteSite_(requeteSite);
		doseActuel.setRequeteSite_(requeteSite);
		medicamentActuel.setRequeteSite_(requeteSite);
		changementDose.setRequeteSite_(requeteSite);
		notesComplementaires.setRequeteSite_(requeteSite);
		infoContact.setRequeteSite_(requeteSite);
	}

	public void requeteSitePourClasse(RequeteSite requeteSite) {
		requeteSiteCalculInr(requeteSite);
	}

	/////////////
	// indexer //
	/////////////

	//public void indexerCalculInr() throws Exception {
		//RequeteSite requeteSite = new RequeteSite();
		//requeteSite.initLoinRequeteSite();
		//SiteContexte siteContexte = new SiteContexte();
		//siteContexte.initLoinSiteContexte();
		//siteContexte.setRequeteSite_(requeteSite);
		//requeteSite.setSiteContexte_(siteContexte);
		//requeteSiteCalculInr(requeteSite);
		//initLoinCalculInr(requeteSite);
		//indexerCalculInr();
	//}


	@Override public void indexerPourClasse() throws Exception {
		indexerCalculInr();
	}

	@Override public void indexerPourClasse(SolrInputDocument document) throws Exception {
		indexerCalculInr(document);
	}
	public void indexerCalculInr() throws Exception {
		SolrInputDocument document = new SolrInputDocument();
		indexerCalculInr(document);
		SolrClient clientSolr = requeteSite_.getSiteContexte_().getClientSolr();
		clientSolr.add(document);
		clientSolr.commit();
	}

	public void indexerCalculInr(SolrInputDocument document) throws Exception {
		if(utilisateurPk != null) {
			document.addField("utilisateurPk_indexed_long", utilisateurPk);
			document.addField("utilisateurPk_stored_long", utilisateurPk);
		}
		if(dateInr != null) {
			document.addField("dateInr_indexed_date", DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(dateInr.atStartOfDay(ZoneId.systemDefault())));
			document.addField("dateInr_stored_date", DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(dateInr.atStartOfDay(ZoneId.systemDefault())));
		}
		if(dateReverifier != null) {
			document.addField("dateReverifier_indexed_date", DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(dateReverifier.atStartOfDay(ZoneId.systemDefault())));
			document.addField("dateReverifier_stored_date", DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(dateReverifier.atStartOfDay(ZoneId.systemDefault())));
		}
		if(patientPrendCoumadin != null) {
			document.addField("patientPrendCoumadin_indexed_string", patientPrendCoumadin);
			document.addField("patientPrendCoumadin_stored_string", patientPrendCoumadin);
		}
		if(butActuel != null) {
			document.addField("butActuel_indexed_string", butActuel);
			document.addField("butActuel_stored_string", butActuel);
		}
		if(doseActuel != null) {
			document.addField("doseActuel_indexed_string", doseActuel);
			document.addField("doseActuel_stored_string", doseActuel);
		}
		if(medicamentActuel != null) {
			document.addField("medicamentActuel_indexed_string", medicamentActuel);
			document.addField("medicamentActuel_stored_string", medicamentActuel);
		}
		if(changementDose != null) {
			document.addField("changementDose_indexed_string", changementDose);
			document.addField("changementDose_stored_string", changementDose);
		}
		if(notesComplementaires != null) {
			document.addField("notesComplementaires_indexed_string", notesComplementaires);
			document.addField("notesComplementaires_stored_string", notesComplementaires);
		}
		if(infoContact != null) {
			document.addField("infoContact_indexed_string", infoContact);
			document.addField("infoContact_stored_string", infoContact);
		}
		super.indexerCluster(document);

	}

	/////////////
	// obtenir //
	/////////////

	@Override public Object obtenirPourClasse(String var) throws Exception {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtenirCalculInr(v);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.obtenirPourClasse(v);
			}
		}
		return o;
	}
	public Object obtenirCalculInr(String var) throws Exception {
		CalculInr oCalculInr = (CalculInr)this;
		switch(var) {
			case "utilisateurPk":
				return oCalculInr.utilisateurPk;
			case "dateInr":
				return oCalculInr.dateInr;
			case "dateReverifier":
				return oCalculInr.dateReverifier;
			case "patientPrendCoumadin":
				return oCalculInr.patientPrendCoumadin;
			case "butActuel":
				return oCalculInr.butActuel;
			case "doseActuel":
				return oCalculInr.doseActuel;
			case "medicamentActuel":
				return oCalculInr.medicamentActuel;
			case "changementDose":
				return oCalculInr.changementDose;
			case "notesComplementaires":
				return oCalculInr.notesComplementaires;
			case "infoContact":
				return oCalculInr.infoContact;
			default:
				return super.obtenirCluster(var);
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
				o = attribuerCalculInr(v, val);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.attribuerPourClasse(v, val);
			}
		}
		return o != null;
	}
	public Object attribuerCalculInr(String var, Object val) {
		CalculInr oCalculInr = (CalculInr)this;
		switch(var) {
			case "utilisateurPk":
				oCalculInr.setUtilisateurPk((Long)val);
				return val;
			default:
				return super.attribuerCluster(var, val);
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
					o = definirCalculInr(v, val);
				else if(o instanceof Cluster) {
					Cluster cluster = (Cluster)o;
					o = cluster.definirPourClasse(v, val);
				}
			}
		}
		return o != null;
	}
	public Object definirCalculInr(String var, String val) {
		switch(var) {
			case "dateInr":
				setDateInr(val);
				sauvegardesCalculInr.add(var);
				return val;
			case "dateReverifier":
				setDateReverifier(val);
				sauvegardesCalculInr.add(var);
				return val;
			case "patientPrendCoumadin":
				setPatientPrendCoumadin(val);
				sauvegardesCalculInr.add(var);
				return val;
			case "butActuel":
				setButActuel(val);
				sauvegardesCalculInr.add(var);
				return val;
			case "doseActuel":
				setDoseActuel(val);
				sauvegardesCalculInr.add(var);
				return val;
			case "medicamentActuel":
				setMedicamentActuel(val);
				sauvegardesCalculInr.add(var);
				return val;
			case "changementDose":
				setChangementDose(val);
				sauvegardesCalculInr.add(var);
				return val;
			case "notesComplementaires":
				setNotesComplementaires(val);
				sauvegardesCalculInr.add(var);
				return val;
			case "infoContact":
				setInfoContact(val);
				sauvegardesCalculInr.add(var);
				return val;
			default:
				return super.definirCluster(var, val);
		}
	}

	/////////////////
	// sauvegardes //
	/////////////////

	protected List<String> sauvegardesCalculInr = new ArrayList<String>();

	/////////////
	// peupler //
	/////////////

	@Override public void peuplerPourClasse(SolrDocument solrDocument) {
		peuplerCalculInr(solrDocument);
	}
	public void peuplerCalculInr(SolrDocument solrDocument) {
		CalculInr oCalculInr = (CalculInr)this;
		sauvegardesCalculInr = (List<String>)solrDocument.get("sauvegardesCalculInr_stored_strings");

		if(sauvegardesCalculInr.contains("utilisateurPk")) {
			Long utilisateurPk = (Long)solrDocument.get("utilisateurPk_stored_long");
			if(utilisateurPk != null)
				oCalculInr.setUtilisateurPk(utilisateurPk);
		}

		if(sauvegardesCalculInr.contains("dateInr")) {
			Date dateInr = (Date)solrDocument.get("dateInr_stored_date");
			if(dateInr != null)
				oCalculInr.setDateInr(dateInr);
		}

		if(sauvegardesCalculInr.contains("dateReverifier")) {
			Date dateReverifier = (Date)solrDocument.get("dateReverifier_stored_date");
			if(dateReverifier != null)
				oCalculInr.setDateReverifier(dateReverifier);
		}

		if(sauvegardesCalculInr.contains("patientPrendCoumadin")) {
			String patientPrendCoumadin = (String)solrDocument.get("patientPrendCoumadin_stored_string");
			if(patientPrendCoumadin != null)
				oCalculInr.setPatientPrendCoumadin(patientPrendCoumadin);
		}

		if(sauvegardesCalculInr.contains("butActuel")) {
			String butActuel = (String)solrDocument.get("butActuel_stored_string");
			if(butActuel != null)
				oCalculInr.setButActuel(butActuel);
		}

		if(sauvegardesCalculInr.contains("doseActuel")) {
			String doseActuel = (String)solrDocument.get("doseActuel_stored_string");
			if(doseActuel != null)
				oCalculInr.setDoseActuel(doseActuel);
		}

		if(sauvegardesCalculInr.contains("medicamentActuel")) {
			String medicamentActuel = (String)solrDocument.get("medicamentActuel_stored_string");
			if(medicamentActuel != null)
				oCalculInr.setMedicamentActuel(medicamentActuel);
		}

		if(sauvegardesCalculInr.contains("changementDose")) {
			String changementDose = (String)solrDocument.get("changementDose_stored_string");
			if(changementDose != null)
				oCalculInr.setChangementDose(changementDose);
		}

		if(sauvegardesCalculInr.contains("notesComplementaires")) {
			String notesComplementaires = (String)solrDocument.get("notesComplementaires_stored_string");
			if(notesComplementaires != null)
				oCalculInr.setNotesComplementaires(notesComplementaires);
		}

		if(sauvegardesCalculInr.contains("infoContact")) {
			String infoContact = (String)solrDocument.get("infoContact_stored_string");
			if(infoContact != null)
				oCalculInr.setInfoContact(infoContact);
		}

		super.peuplerCluster(solrDocument);
	}

	//////////////
	// hashCode //
	//////////////

	@Override public int hashCode() {
		return Objects.hash(super.hashCode(), dateInr, dateReverifier, patientPrendCoumadin, butActuel, doseActuel, medicamentActuel, changementDose, notesComplementaires, infoContact);
	}

	////////////
	// equals //
	////////////

	@Override public boolean equals(Object o) {
		if(this == o)
			return true;
		if(!(o instanceof CalculInr))
			return false;
		CalculInr that = (CalculInr)o;
		return super.equals(o)
				&& Objects.equals( dateInr, that.dateInr )
				&& Objects.equals( dateReverifier, that.dateReverifier )
				&& Objects.equals( patientPrendCoumadin, that.patientPrendCoumadin )
				&& Objects.equals( butActuel, that.butActuel )
				&& Objects.equals( doseActuel, that.doseActuel )
				&& Objects.equals( medicamentActuel, that.medicamentActuel )
				&& Objects.equals( changementDose, that.changementDose )
				&& Objects.equals( notesComplementaires, that.notesComplementaires )
				&& Objects.equals( infoContact, that.infoContact );
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString() + "\n");
		sb.append("CalculInr {");
		sb.append( "dateInr: " ).append(dateInr);
		sb.append( ", dateReverifier: " ).append(dateReverifier);
		sb.append( ", patientPrendCoumadin: " ).append(patientPrendCoumadin);
		sb.append( ", butActuel: " ).append(butActuel);
		sb.append( ", doseActuel: " ).append(doseActuel);
		sb.append( ", medicamentActuel: " ).append(medicamentActuel);
		sb.append( ", changementDose: " ).append(changementDose);
		sb.append( ", notesComplementaires: " ).append(notesComplementaires);
		sb.append( ", infoContact: " ).append(infoContact);
		sb.append(" }");
		return sb.toString();
	}
}
