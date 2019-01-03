package org.computate.frFR.cardiaque.warfarin;

import java.util.Objects;
import org.computate.frFR.cardiaque.recherche.ListeRecherche;
import java.util.List;
import org.computate.frFR.cardiaque.couverture.Couverture;
import org.computate.frFR.cardiaque.warfarin.CalculInr;
import org.computate.frFR.cardiaque.cluster.Cluster;
import org.computate.frFR.cardiaque.utilisateur.UtilisateurSite;
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

	//////////////////////////////
	// utilisateurSiteRecherche //
	//////////////////////////////

	/**	L'entité « utilisateurSiteRecherche »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut ListeRecherche<UtilisateurSite>(). 
	 */
	protected ListeRecherche<UtilisateurSite> utilisateurSiteRecherche = new ListeRecherche<UtilisateurSite>();
	public Couverture<ListeRecherche<UtilisateurSite>> utilisateurSiteRechercheCouverture = new Couverture<ListeRecherche<UtilisateurSite>>().p(this).c(ListeRecherche.class).var("utilisateurSiteRecherche").o(utilisateurSiteRecherche);

	/**	<br/>L'entité « utilisateurSiteRecherche »
	 * Il est construit avant d'être initialisé avec le constructeur par défaut ListeRecherche<UtilisateurSite>(). 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.frFR.cardiaque.warfarin.CalculInrPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:utilisateurSiteRecherche">Trouver l'entité utilisateurSiteRecherche dans Solr</a>
	 * <br/>
	 * @param utilisateurSiteRecherche est l'entité déjà construit. 
	 **/
	protected abstract void _utilisateurSiteRecherche(ListeRecherche<UtilisateurSite> o);

	public ListeRecherche<UtilisateurSite> getUtilisateurSiteRecherche() {
		return utilisateurSiteRecherche;
	}

	public void setUtilisateurSiteRecherche(ListeRecherche<UtilisateurSite> o) {
		this.utilisateurSiteRecherche = o;
		this.utilisateurSiteRechercheCouverture.dejaInitialise = true;
	}
	protected CalculInrPage utilisateurSiteRechercheInit()
 {
		if(!utilisateurSiteRechercheCouverture.dejaInitialise) {
			_utilisateurSiteRecherche(utilisateurSiteRecherche);
		}
		utilisateurSiteRecherche.initLoinPourClasse(requeteSite_);
		utilisateurSiteRechercheCouverture.dejaInitialise(true);
		return (CalculInrPage)this;
	}

	/////////////////////
	// utilisateurSite //
	/////////////////////

	/**	L'entité « utilisateurSite »
	 *	 is defined as null before being initialized. 
	 */
	protected UtilisateurSite utilisateurSite;
	public Couverture<UtilisateurSite> utilisateurSiteCouverture = new Couverture<UtilisateurSite>().p(this).c(UtilisateurSite.class).var("utilisateurSite").o(utilisateurSite);

	/**	<br/>L'entité « utilisateurSite »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.frFR.cardiaque.warfarin.CalculInrPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:utilisateurSite">Trouver l'entité utilisateurSite dans Solr</a>
	 * <br/>
	 * @param o est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _utilisateurSite(Couverture<UtilisateurSite> o);

	public UtilisateurSite getUtilisateurSite() {
		return utilisateurSite;
	}

	public void setUtilisateurSite(UtilisateurSite o) {
		this.utilisateurSite = o;
		this.utilisateurSiteCouverture.dejaInitialise = true;
	}
	protected CalculInrPage utilisateurSiteInit()
 {
		if(!utilisateurSiteCouverture.dejaInitialise) {
			_utilisateurSite(utilisateurSiteCouverture);
			if(utilisateurSite == null)
				setUtilisateurSite(utilisateurSiteCouverture.o);
		}
		if(utilisateurSite != null)
			utilisateurSite.initLoinPourClasse(requeteSite_);
		utilisateurSiteCouverture.dejaInitialise(true);
		return (CalculInrPage)this;
	}

	/////////////////////////
	// calculsInrRecherche //
	/////////////////////////

	/**	L'entité « calculsInrRecherche »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut ListeRecherche<CalculInr>(). 
	 */
	protected ListeRecherche<CalculInr> calculsInrRecherche = new ListeRecherche<CalculInr>();
	public Couverture<ListeRecherche<CalculInr>> calculsInrRechercheCouverture = new Couverture<ListeRecherche<CalculInr>>().p(this).c(ListeRecherche.class).var("calculsInrRecherche").o(calculsInrRecherche);

	/**	<br/>L'entité « calculsInrRecherche »
	 * Il est construit avant d'être initialisé avec le constructeur par défaut ListeRecherche<CalculInr>(). 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.frFR.cardiaque.warfarin.CalculInrPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:calculsInrRecherche">Trouver l'entité calculsInrRecherche dans Solr</a>
	 * <br/>
	 * @param calculsInrRecherche est l'entité déjà construit. 
	 **/
	protected abstract void _calculsInrRecherche(ListeRecherche<CalculInr> o);

	public ListeRecherche<CalculInr> getCalculsInrRecherche() {
		return calculsInrRecherche;
	}

	public void setCalculsInrRecherche(ListeRecherche<CalculInr> o) {
		this.calculsInrRecherche = o;
		this.calculsInrRechercheCouverture.dejaInitialise = true;
	}
	protected CalculInrPage calculsInrRechercheInit()
 {
		if(!calculsInrRechercheCouverture.dejaInitialise) {
			_calculsInrRecherche(calculsInrRecherche);
		}
		calculsInrRecherche.initLoinPourClasse(requeteSite_);
		calculsInrRechercheCouverture.dejaInitialise(true);
		return (CalculInrPage)this;
	}

	////////////////
	// calculsInr //
	////////////////

	/**	L'entité « calculsInr »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut List<CalculInr>(). 
	 */
	protected List<CalculInr> calculsInr = new java.util.ArrayList<org.computate.frFR.cardiaque.warfarin.CalculInr>();
	public Couverture<List<CalculInr>> calculsInrCouverture = new Couverture<List<CalculInr>>().p(this).c(List.class).var("calculsInr").o(calculsInr);

	/**	<br/>L'entité « calculsInr »
	 * Il est construit avant d'être initialisé avec le constructeur par défaut List<CalculInr>(). 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.frFR.cardiaque.warfarin.CalculInrPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:calculsInr">Trouver l'entité calculsInr dans Solr</a>
	 * <br/>
	 * @param calculsInr est l'entité déjà construit. 
	 **/
	protected abstract void _calculsInr(List<CalculInr> l);

	public List<CalculInr> getCalculsInr() {
		return calculsInr;
	}

	public void setCalculsInr(List<CalculInr> l) {
		this.calculsInr = l;
		this.calculsInrCouverture.dejaInitialise = true;
	}
	public CalculInrPage addCalculsInr(CalculInr...objets) {
		for(CalculInr o : objets) {
			addCalculsInr(o);
		}
		return (CalculInrPage)this;
	}
	public CalculInrPage addCalculsInr(CalculInr o) {
		if(o != null && !calculsInr.contains(o))
			this.calculsInr.add(o);
		return (CalculInrPage)this;
	}
	protected CalculInrPage calculsInrInit()
 {
		if(!calculsInrCouverture.dejaInitialise) {
			_calculsInr(calculsInr);
		}
		calculsInrCouverture.dejaInitialise(true);
		return (CalculInrPage)this;
	}

	///////////////
	// calculInr //
	///////////////

	/**	L'entité « calculInr »
	 *	 is defined as null before being initialized. 
	 */
	protected CalculInr calculInr;
	public Couverture<CalculInr> calculInrCouverture = new Couverture<CalculInr>().p(this).c(CalculInr.class).var("calculInr").o(calculInr);

	/**	<br/>L'entité « calculInr »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.frFR.cardiaque.warfarin.CalculInrPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:calculInr">Trouver l'entité calculInr dans Solr</a>
	 * <br/>
	 * @param o est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _calculInr(Couverture<CalculInr> o);

	public CalculInr getCalculInr() {
		return calculInr;
	}

	public void setCalculInr(CalculInr o) {
		this.calculInr = o;
		this.calculInrCouverture.dejaInitialise = true;
	}
	protected CalculInrPage calculInrInit()
 {
		if(!calculInrCouverture.dejaInitialise) {
			_calculInr(calculInrCouverture);
			if(calculInr == null)
				setCalculInr(calculInrCouverture.o);
		}
		if(calculInr != null)
			calculInr.initLoinPourClasse(requeteSite_);
		calculInrCouverture.dejaInitialise(true);
		return (CalculInrPage)this;
	}

	//////////////
	// initLoin //
	//////////////

	protected boolean dejaInitialiseCalculInrPage = false;

	public CalculInrPage initLoinCalculInrPage(RequeteSite requeteSite) {
		setRequeteSite_(requeteSite);
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
		utilisateurSiteRechercheInit();
		utilisateurSiteInit();
		calculsInrRechercheInit();
		calculsInrInit();
		calculInrInit();
	}

	@Override public void initLoinPourClasse(RequeteSite requeteSite) {
		initLoinCalculInrPage(requeteSite);
	}

	/////////////////
	// requeteSite //
	/////////////////

	public void requeteSiteCalculInrPage(RequeteSite requeteSite) {
			super.requeteSiteMiseEnPage(requeteSite);
		utilisateurSiteRecherche.setRequeteSite_(requeteSite);
		utilisateurSite.setRequeteSite_(requeteSite);
		calculsInrRecherche.setRequeteSite_(requeteSite);
		calculInr.setRequeteSite_(requeteSite);
	}

	public void requeteSitePourClasse(RequeteSite requeteSite) {
		requeteSiteCalculInrPage(requeteSite);
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
			case "utilisateurSiteRecherche":
				return oCalculInrPage.utilisateurSiteRecherche;
			case "utilisateurSite":
				return oCalculInrPage.utilisateurSite;
			case "calculsInrRecherche":
				return oCalculInrPage.calculsInrRecherche;
			case "calculsInr":
				return oCalculInrPage.calculsInr;
			case "calculInr":
				return oCalculInrPage.calculInr;
			default:
				return super.obtenirMiseEnPage(var);
		}
	}

	///////////////
	// attribuer //
	///////////////

	@Override public boolean attribuerPourClasse(String var, Object val) throws Exception {
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
	public Object attribuerCalculInrPage(String var, Object val) throws Exception {
		CalculInrPage oCalculInrPage = (CalculInrPage)this;
		switch(var) {
			default:
				return super.attribuerMiseEnPage(var, val);
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
