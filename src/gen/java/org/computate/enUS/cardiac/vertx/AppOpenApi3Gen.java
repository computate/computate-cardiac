package org.computate.enUS.cardiac.vertx;

import java.util.Objects;
import org.computate.frFR.cardiaque.contexte.SiteContexte;
import org.computate.frFR.cardiaque.couverture.Couverture;
import org.computate.enUS.java.SiteConfig;
import org.computate.site.course.c000.cluster.Cluster;
import org.computate.frFR.cardiaque.requete.RequeteSite;
import org.computate.enUS.cardiac.writer.AllWriter;
import org.apache.commons.text.StringEscapeUtils;
import java.lang.Object;
import org.apache.commons.lang3.StringUtils;
import java.lang.Exception;

/**	
 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.enUS.cardiac.vertx.AppOpenApi3&fq=classeEtendGen_indexed_boolean:true">Trouver la classe  dans Solr</a>
 * <br/>
 **/
public abstract class AppOpenApi3Gen<DEV> extends Object {

	//////////////
	// initLoin //
	//////////////

	protected boolean dejaInitialiseAppOpenApi3 = false;

	public AppOpenApi3 initLoinAppOpenApi3(RequeteSite requeteSite) throws Exception {
		setRequeteSite_(requeteSite);
		if(!dejaInitialiseAppOpenApi3) {
			dejaInitialiseAppOpenApi3 = true;
			initLoinAppOpenApi3();
		}
		return (AppOpenApi3)this;
	}

	public void initLoinAppOpenApi3() throws Exception {
		initAppOpenApi3();
	}

	public void initAppOpenApi3() throws Exception {
	}

	public void initLoinPourClasse(RequeteSite requeteSite) throws Exception {
		initLoinAppOpenApi3(requeteSite);
	}

	/////////////////
	// requeteSite //
	/////////////////

	public void requeteSiteAppOpenApi3(RequeteSite requeteSite) {
	}

	public void requeteSitePourClasse(RequeteSite requeteSite) {
		requeteSiteAppOpenApi3(requeteSite);
	}

	/////////////
	// obtenir //
	/////////////

	public Object obtenirPourClasse(String var) throws Exception {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtenirAppOpenApi3(v);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.obtenirPourClasse(v);
			}
		}
		return o;
	}
	public Object obtenirAppOpenApi3(String var) throws Exception {
		AppOpenApi3 oAppOpenApi3 = (AppOpenApi3)this;
		switch(var) {
			default:
				return null;
		}
	}

	///////////////
	// attribuer //
	///////////////

	public boolean attribuerPourClasse(String var, Object val) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = attribuerAppOpenApi3(v, val);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.attribuerPourClasse(v, val);
			}
		}
		return o != null;
	}
	public Object attribuerAppOpenApi3(String var, Object val) {
		AppOpenApi3 oAppOpenApi3 = (AppOpenApi3)this;
		switch(var) {
			default:
				return null;
		}
	}

	/////////////
	// definir //
	/////////////

	public boolean definirPourClasse(String var, String val) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		if(val != null) {
			for(String v : vars) {
				if(o == null)
					o = definirAppOpenApi3(v, val);
				else if(o instanceof Cluster) {
					Cluster cluster = (Cluster)o;
					o = cluster.definirPourClasse(v, val);
				}
			}
		}
		return o != null;
	}
	public Object definirAppOpenApi3(String var, String val) {
		switch(var) {
			default:
				return null;
		}
	}

	//////////////
	// hashCode //
	//////////////

	@Override public int hashCode() {
		return Objects.hash();
	}

	////////////
	// equals //
	////////////

	@Override public boolean equals(Object o) {
		if(this == o)
			return true;
		if(!(o instanceof AppOpenApi3))
			return false;
		AppOpenApi3 that = (AppOpenApi3)o;
		return true;
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("AppOpenApi3 {");
		sb.append(" }");
		return sb.toString();
	}
}
