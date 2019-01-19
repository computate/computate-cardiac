package org.computate.frFR.cardiaque.warfarin;

import java.util.Objects;
import org.computate.frFR.cardiaque.couverture.Couverture;
import org.computate.frFR.cardiaque.cluster.Cluster;
import org.computate.frFR.cardiaque.requete.RequeteSite;
import org.computate.frFR.cardiaque.ecrivain.ToutEcrivain;
import org.apache.commons.text.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;

/**	
 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.frFR.cardiaque.warfarin.CalculInrApiServiceImpl&fq=classeEtendGen_indexed_boolean:true">Trouver la classe  dans Solr</a>
 * <br/>
 **/
public abstract class CalculInrApiServiceImplGen<DEV> {

	//////////////
	// initLoin //
	//////////////

	protected boolean dejaInitialiseCalculInrApiServiceImpl = false;

	public CalculInrApiServiceImpl initLoinCalculInrApiServiceImpl(RequeteSite requeteSite_) {
		setRequeteSite_(requeteSite_);
		if(!dejaInitialiseCalculInrApiServiceImpl) {
			dejaInitialiseCalculInrApiServiceImpl = true;
			initLoinCalculInrApiServiceImpl();
		}
		return (CalculInrApiServiceImpl)this;
	}

	public void initLoinCalculInrApiServiceImpl() {
		initCalculInrApiServiceImpl();
	}

	public void initCalculInrApiServiceImpl() {
	}

	public void initLoinPourClasse(RequeteSite requeteSite_) {
		initLoinCalculInrApiServiceImpl(requeteSite_);
	}

	/////////////////
	// requeteSite //
	/////////////////

	public void requeteSiteCalculInrApiServiceImpl(RequeteSite requeteSite_) {
	}

	public void requeteSitePourClasse(RequeteSite requeteSite_) {
		requeteSiteCalculInrApiServiceImpl(requeteSite_);
	}

	/////////////
	// obtenir //
	/////////////

	public Object obtenirPourClasse(String var) throws Exception {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtenirCalculInrApiServiceImpl(v);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.obtenirPourClasse(v);
			}
		}
		return o;
	}
	public Object obtenirCalculInrApiServiceImpl(String var) throws Exception {
		CalculInrApiServiceImpl oCalculInrApiServiceImpl = (CalculInrApiServiceImpl)this;
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
				o = attribuerCalculInrApiServiceImpl(v, val);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.attribuerPourClasse(v, val);
			}
		}
		return o != null;
	}
	public Object attribuerCalculInrApiServiceImpl(String var, Object val) {
		CalculInrApiServiceImpl oCalculInrApiServiceImpl = (CalculInrApiServiceImpl)this;
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
					o = definirCalculInrApiServiceImpl(v, val);
				else if(o instanceof Cluster) {
					Cluster cluster = (Cluster)o;
					o = cluster.definirPourClasse(v, val);
				}
			}
		}
		return o != null;
	}
	public Object definirCalculInrApiServiceImpl(String var, String val) {
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
		if(!(o instanceof CalculInrApiServiceImpl))
			return false;
		CalculInrApiServiceImpl that = (CalculInrApiServiceImpl)o;
		return true;
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("CalculInrApiServiceImpl {");
		sb.append(" }");
		return sb.toString();
	}
}
