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
	// listeRecherche //
	////////////////////

	/**	L'entité « listeRecherche »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut ListeRecherche<CalculInr>(). 
	 */
	protected ListeRecherche<CalculInr> listeRecherche = new ListeRecherche<CalculInr>();
	public Couverture<ListeRecherche<CalculInr>> listeRechercheCouverture = new Couverture<ListeRecherche<CalculInr>>().p(this).c(ListeRecherche.class).var("listeRecherche").o(listeRecherche);

	/**	<br/>L'entité « listeRecherche »
	 * Il est construit avant d'être initialisé avec le constructeur par défaut ListeRecherche<CalculInr>(). 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.frFR.cardiaque.warfarin.CalculInrPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:listeRecherche">Trouver l'entité listeRecherche dans Solr</a>
	 * <br/>
	 * @param listeRecherche est l'entité déjà construit. 
	 **/
	protected abstract void _listeRecherche(ListeRecherche<CalculInr> o);

	public ListeRecherche<CalculInr> getListeRecherche() {
		return listeRecherche;
	}

	public void setListeRecherche(ListeRecherche<CalculInr> listeRecherche) {
		this.listeRecherche = listeRecherche;
		this.listeRechercheCouverture.dejaInitialise = true;
	}
	protected CalculInrPage listeRechercheInit() {
		if(!listeRechercheCouverture.dejaInitialise) {
			_listeRecherche(listeRecherche);
		}
		listeRecherche.initLoinPourClasse(requeteSite_);
		listeRechercheCouverture.dejaInitialise(true);
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
		listeRechercheInit();
	}

	@Override public void initLoinPourClasse(RequeteSite requeteSite_) {
		initLoinCalculInrPage(requeteSite_);
	}

	/////////////////
	// requeteSite //
	/////////////////

	public void requeteSiteCalculInrPage(RequeteSite requeteSite_) {
			super.requeteSiteMiseEnPage(requeteSite_);
		listeRecherche.setRequeteSite_(requeteSite_);
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
			case "listeRecherche":
				return oCalculInrPage.listeRecherche;
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
