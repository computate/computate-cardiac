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
 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.frFR.cardiaque.warfarin.CalculInrPage&fq=classeEtendGen_indexed_boolean:true">Trouver la classe  dans Solr</a>
 * <br/>
 **/
public abstract class CalculInrPageGen<DEV> extends MiseEnPage {

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
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.frFR.cardiaque.warfarin.CalculInrPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:listeCalculInr">Trouver l'entité listeCalculInr dans Solr</a>
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
	protected CalculInrPage listeCalculInrInit() {
		if(!listeCalculInrCouverture.dejaInitialise) {
			_listeCalculInr(listeCalculInrCouverture);
			if(listeCalculInr == null)
				setListeCalculInr(listeCalculInrCouverture.o);
		}
		if(listeCalculInr != null)
			listeCalculInr.initLoinPourClasse(requeteSite_);
		listeCalculInrCouverture.dejaInitialise(true);
		return (CalculInrPage)this;
	}

	//////////////
	// initLoin //
	//////////////

	protected boolean dejaInitialiseCalculInrPage = false;

	public CalculInrPage initLoinCalculInrPage(RequeteSite requeteSite_) {
		setRequeteSite_(requeteSite_);
		if(!dejaInitialiseCalculInrPage) {
			dejaInitialiseCalculInrPage = true;
			initLoinCalculInrPage();
		}
		return (CalculInrPage)this;
	}

	public void initLoinCalculInrPage() {
		super.initLoinMiseEnPage(requeteSite_);
		initCalculInrPage();
	}

	public void initCalculInrPage() {
		listeCalculInrInit();
	}

	@Override public void initLoinPourClasse(RequeteSite requeteSite_) {
		initLoinCalculInrPage(requeteSite_);
	}

	/////////////////
	// requeteSite //
	/////////////////

	public void requeteSiteCalculInrPage(RequeteSite requeteSite_) {
			super.requeteSiteMiseEnPage(requeteSite_);
		listeCalculInr.setRequeteSite_(requeteSite_);
	}

	public void requeteSitePourClasse(RequeteSite requeteSite_) {
		requeteSiteCalculInrPage(requeteSite_);
	}

	/////////////
	// obtenir //
	/////////////

	@Override public Object obtenirPourClasse(String var) throws Exception {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtenirCalculInrPage(v);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.obtenirPourClasse(v);
			}
		}
		return o;
	}
	public Object obtenirCalculInrPage(String var) throws Exception {
		CalculInrPage oCalculInrPage = (CalculInrPage)this;
		switch(var) {
			case "listeCalculInr":
				return oCalculInrPage.listeCalculInr;
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
				o = attribuerCalculInrPage(v, val);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.attribuerPourClasse(v, val);
			}
		}
		return o != null;
	}
	public Object attribuerCalculInrPage(String var, Object val) {
		CalculInrPage oCalculInrPage = (CalculInrPage)this;
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
					o = definirCalculInrPage(v, val);
				else if(o instanceof Cluster) {
					Cluster cluster = (Cluster)o;
					o = cluster.definirPourClasse(v, val);
				}
			}
		}
		return o != null;
	}
	public Object definirCalculInrPage(String var, String val) {
		switch(var) {
			default:
				return super.definirMiseEnPage(var, val);
		}
	}

	//////////
	// html //
	//////////

	@Override public void html() {
		htmlAvant();
		htmlMilieu();
		htmlApres();
	}
	public void htmlAvant() {
		htmlCalculInrPageAvant();
		super.htmlMiseEnPageAvant();
	}
	public void htmlMilieu() {
		htmlCalculInrPageMilieu();
		super.htmlMiseEnPageMilieu();
	}
	public void htmlApres() {
		htmlCalculInrPageApres();
		super.htmlMiseEnPageApres();
	}
	public void htmlCalculInrPageAvant() {
	}
	public void htmlCalculInrPageMilieu() {
	}
	public void htmlCalculInrPageApres() {
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
		if(!(o instanceof CalculInrPage))
			return false;
		CalculInrPage that = (CalculInrPage)o;
		return super.equals(o);
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString() + "\n");
		sb.append("CalculInrPage {");
		sb.append(" }");
		return sb.toString();
	}
}
