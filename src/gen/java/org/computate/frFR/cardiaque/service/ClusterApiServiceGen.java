package org.computate.frFR.cardiaque.service;

import java.util.Objects;
import org.computate.frFR.cardiaque.couverture.Couverture;
import org.computate.frFR.cardiaque.cluster.Cluster;
import org.computate.frFR.cardiaque.cluster.ClusterApiService;
import org.computate.frFR.cardiaque.requete.RequeteSite;
import org.computate.frFR.cardiaque.ecrivain.ToutEcrivain;
import org.apache.commons.text.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;

/**	
 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.frFR.cardiaque.service.ClusterApiService&fq=classeEtendGen_indexed_boolean:true">Trouver la classe  dans Solr</a>
 * <br/>
 **/
public abstract class ClusterApiServiceGen<DEV> {

	//////////////
	// initLoin //
	//////////////

	protected boolean dejaInitialiseClusterApiService = false;

	public ClusterApiService initLoinClusterApiService(RequeteSite requeteSite) {
		setRequeteSite_(requeteSite);
		if(!dejaInitialiseClusterApiService) {
			dejaInitialiseClusterApiService = true;
			initLoinClusterApiService();
		}
		return (ClusterApiService)this;
	}

	public void initLoinClusterApiService() {
		initClusterApiService();
	}

	public void initClusterApiService() {
	}

	public void initLoinPourClasse(RequeteSite requeteSite) {
		initLoinClusterApiService(requeteSite);
	}

	/////////////////
	// requeteSite //
	/////////////////

	public void requeteSiteClusterApiService(RequeteSite requeteSite) {
	}

	public void requeteSitePourClasse(RequeteSite requeteSite) {
		requeteSiteClusterApiService(requeteSite);
	}

	/////////////
	// obtenir //
	/////////////

	public Object obtenirPourClasse(String var) throws Exception {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtenirClusterApiService(v);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.obtenirPourClasse(v);
			}
		}
		return o;
	}
	public Object obtenirClusterApiService(String var) throws Exception {
		ClusterApiService oClusterApiService = (ClusterApiService)this;
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
				o = attribuerClusterApiService(v, val);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.attribuerPourClasse(v, val);
			}
		}
		return o != null;
	}
	public Object attribuerClusterApiService(String var, Object val) {
		ClusterApiService oClusterApiService = (ClusterApiService)this;
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
					o = definirClusterApiService(v, val);
				else if(o instanceof Cluster) {
					Cluster cluster = (Cluster)o;
					o = cluster.definirPourClasse(v, val);
				}
			}
		}
		return o != null;
	}
	public Object definirClusterApiService(String var, String val) {
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
		if(!(o instanceof ClusterApiService))
			return false;
		ClusterApiService that = (ClusterApiService)o;
		return true;
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ClusterApiService {");
		sb.append(" }");
		return sb.toString();
	}
}
