package org.computate.frFR.cardiaque.warfarin;

import java.util.Objects;
import org.computate.frFR.cardiaque.recherche.ListeRecherche;
import org.computate.frFR.cardiaque.couverture.Couverture;
import org.computate.frFR.cardiaque.warfarin.CalculInr;
import org.computate.frFR.cardiaque.cluster.Cluster;
import org.computate.frFR.cardiaque.requete.RequeteSite;
import org.computate.frFR.cardiaque.ecrivain.ToutEcrivain;
import org.apache.commons.text.StringEscapeUtils;
import org.computate.frFR.cardiaque.page.MiseEnPage;
import org.apache.commons.lang3.StringUtils;

/**	
 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.frFR.cardiaque.warfarin.CalculInrGenPage&fq=classeEtendGen_indexed_boolean:true">Trouver la classe  dans Solr</a>
 * <br/>
 **/
public abstract class CalculInrGenPageGen<DEV> extends MiseEnPage {

	////////////////////
	// listeCalculInr //
	////////////////////

	/**	L'entité « listeCalculInr »
	 *	 is defined as null before being initialized. 
	 */
	protected ListeRecherche<CalculInr> listeCalculInr;
	public Couverture<ListeRecherche<CalculInr>> listeCalculInrCouverture = new Couverture<ListeRecherche<CalculInr>>().p(this).c(ListeRecherche.class).var("listeCalculInr").o(listeCalculInr);

	/**	<br/>L'entité « listeCalculInr »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.frFR.cardiaque.warfarin.CalculInrGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:listeCalculInr">Trouver l'entité listeCalculInr dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _listeCalculInr(Couverture<ListeRecherche<CalculInr>> c);

	public ListeRecherche<CalculInr> getListeCalculInr() {
		return listeCalculInr;
	}

	public void setListeCalculInr(ListeRecherche<CalculInr> listeCalculInr) {
		this.listeCalculInr = listeCalculInr;
		this.listeCalculInrCouverture.dejaInitialise = true;
	}
	protected CalculInrGenPage listeCalculInrInit() {
		if(!listeCalculInrCouverture.dejaInitialise) {
			_listeCalculInr(listeCalculInrCouverture);
			if(listeCalculInr == null)
				setListeCalculInr(listeCalculInrCouverture.o);
		}
		if(listeCalculInr != null)
			listeCalculInr.initLoinPourClasse(requeteSite_);
		listeCalculInrCouverture.dejaInitialise(true);
		return (CalculInrGenPage)this;
	}

	//////////////
	// initLoin //
	//////////////

	protected boolean dejaInitialiseCalculInrGenPage = false;

	public CalculInrGenPage initLoinCalculInrGenPage(RequeteSite requeteSite_) {
		setRequeteSite_(requeteSite_);
		if(!dejaInitialiseCalculInrGenPage) {
			dejaInitialiseCalculInrGenPage = true;
			initLoinCalculInrGenPage();
		}
		return (CalculInrGenPage)this;
	}

	public void initLoinCalculInrGenPage() {
		super.initLoinMiseEnPage(requeteSite_);
		initCalculInrGenPage();
	}

	public void initCalculInrGenPage() {
		listeCalculInrInit();
	}

	@Override public void initLoinPourClasse(RequeteSite requeteSite_) {
		initLoinCalculInrGenPage(requeteSite_);
	}

	/////////////////
	// requeteSite //
	/////////////////

	public void requeteSiteCalculInrGenPage(RequeteSite requeteSite_) {
			super.requeteSiteMiseEnPage(requeteSite_);
		listeCalculInr.setRequeteSite_(requeteSite_);
	}

	public void requeteSitePourClasse(RequeteSite requeteSite_) {
		requeteSiteCalculInrGenPage(requeteSite_);
	}

	/////////////
	// obtenir //
	/////////////

	@Override public Object obtenirPourClasse(String var) throws Exception {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtenirCalculInrGenPage(v);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.obtenirPourClasse(v);
			}
		}
		return o;
	}
	public Object obtenirCalculInrGenPage(String var) throws Exception {
		CalculInrGenPage oCalculInrGenPage = (CalculInrGenPage)this;
		switch(var) {
			case "listeCalculInr":
				return oCalculInrGenPage.listeCalculInr;
			default:
				return super.obtenirMiseEnPage(var);
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
				o = attribuerCalculInrGenPage(v, val);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.attribuerPourClasse(v, val);
			}
		}
		return o != null;
	}
	public Object attribuerCalculInrGenPage(String var, Object val) {
		CalculInrGenPage oCalculInrGenPage = (CalculInrGenPage)this;
		switch(var) {
			default:
				return super.attribuerMiseEnPage(var, val);
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
					o = definirCalculInrGenPage(v, val);
				else if(o instanceof Cluster) {
					Cluster cluster = (Cluster)o;
					o = cluster.definirPourClasse(v, val);
				}
			}
		}
		return o != null;
	}
	public Object definirCalculInrGenPage(String var, String val) {
		switch(var) {
			default:
				return super.definirMiseEnPage(var, val);
		}
	}

	//////////////
	// hashCode //
	//////////////

	@Override public int hashCode() {
		return Objects.hash(super.hashCode());
	}

	////////////
	// equals //
	////////////

	@Override public boolean equals(Object o) {
		if(this == o)
			return true;
		if(!(o instanceof CalculInrGenPage))
			return false;
		CalculInrGenPage that = (CalculInrGenPage)o;
		return super.equals(o);
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString() + "\n");
		sb.append("CalculInrGenPage {");
		sb.append(" }");
		return sb.toString();
	}
}
