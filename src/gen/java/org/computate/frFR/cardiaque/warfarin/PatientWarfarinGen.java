package org.computate.frFR.cardiaque.warfarin;

import org.computate.frFR.cardiaque.contexte.SiteContexte;
import org.computate.frFR.cardiaque.chaine.Chaine;
import org.computate.frFR.cardiaque.couverture.Couverture;
import org.computate.frFR.cardiaque.cluster.Cluster;
import org.computate.frFR.cardiaque.requete.RequeteSite;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.client.solrj.SolrClient;

public abstract class PatientWarfarinGen<DEV> extends Cluster {

	////////////
	// prenom //
	////////////

	/**	L'entité « prenom »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 */
	protected Chaine prenom = new Chaine();
	public Couverture<Chaine> prenomCouverture = new Couverture<Chaine>().p(this).c(Chaine.class).var("prenom").o(prenom);

	/**	L'entité « prenom »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 *	@param prenom est le champ déjà construit. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _prenom(Chaine o) throws Exception;

	public Chaine getPrenom() {
		return prenom;
	}

	public void setPrenom(Chaine o) {
		this.prenom = o;
	}
	public PatientWarfarin setPrenom(String o) throws Exception {
		prenom.tout(o);
		return (PatientWarfarin)this;
	}
	protected void prenomInit() throws Exception {
		if(!prenomCouverture.dejaInitialise) {
			_prenom(prenom);
		}
		prenom.initLoinPourClasse(requeteSite_);
		prenomCouverture.dejaInitialise(true);
	}

	////////////////
	// nomFamille //
	////////////////

	/**	L'entité « nomFamille »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 */
	protected Chaine nomFamille = new Chaine();
	public Couverture<Chaine> nomFamilleCouverture = new Couverture<Chaine>().p(this).c(Chaine.class).var("nomFamille").o(nomFamille);

	/**	L'entité « nomFamille »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 *	@param nomFamille est le champ déjà construit. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _nomFamille(Chaine o) throws Exception;

	public Chaine getNomFamille() {
		return nomFamille;
	}

	public void setNomFamille(Chaine o) {
		this.nomFamille = o;
	}
	public PatientWarfarin setNomFamille(String o) throws Exception {
		nomFamille.tout(o);
		return (PatientWarfarin)this;
	}
	protected void nomFamilleInit() throws Exception {
		if(!nomFamilleCouverture.dejaInitialise) {
			_nomFamille(nomFamille);
		}
		nomFamille.initLoinPourClasse(requeteSite_);
		nomFamilleCouverture.dejaInitialise(true);
	}

	/////////////////////
	// initialiserLoin //
	/////////////////////

	protected boolean dejaInitialisePatientWarfarin = false;

	public void initLoinPatientWarfarin(RequeteSite requeteSite) throws Exception {
		setRequeteSite_(requeteSite);
		initLoinPatientWarfarin();
	}

	public void initLoinPatientWarfarin() throws Exception {
		if(!dejaInitialisePatientWarfarin) {
			super.initLoinCluster(requeteSite_);
			prenomInit();
			nomFamilleInit();
			dejaInitialisePatientWarfarin = true;
		}
	}

	public void initLoinPourClasse(RequeteSite requeteSite) throws Exception {
		initLoinPatientWarfarin(requeteSite);
	}

	/////////////////
	// requeteSite //
	/////////////////

	public void requeteSitePatientWarfarin(RequeteSite requeteSite) throws Exception {
			super.requeteSiteCluster(requeteSite);
		prenom.setRequeteSite_(requeteSite);
		nomFamille.setRequeteSite_(requeteSite);
	}

	public void requeteSitePourClasse(RequeteSite requeteSite) throws Exception {
		requeteSitePatientWarfarin(requeteSite);
	}

	/////////////
	// indexer //
	/////////////

	public void indexerPatientWarfarin() throws Exception {
		RequeteSite requeteSite = new RequeteSite();
		requeteSite.initLoinRequeteSite();
		SiteContexte SiteContexte = new SiteContexte();
		SiteContexte.initLoinSiteContexte();
		SiteContexte.setRequeteSite_(requeteSite);
		requeteSite.setSiteContexte_(SiteContexte);
		requeteSitePatientWarfarin(requeteSite);
		initLoinPatientWarfarin(requeteSite);
		indexerPatientWarfarin(requeteSite);
	}


	@Override public void indexerPourClasse(RequeteSite requeteSite) throws Exception {
		indexerPatientWarfarin(requeteSite_);
	}

	@Override public void indexerPourClasse(SolrInputDocument document) throws Exception {
		indexerPatientWarfarin(document);
	}
	public void indexerPatientWarfarin(RequeteSite requeteSite) throws Exception {
		SolrInputDocument document = new SolrInputDocument();
		indexerPatientWarfarin(document);
		SolrClient clientSolr = requeteSite_.getSiteContexte_().getClientSolr();
		clientSolr.add(document);
		clientSolr.commit();
	}

	public void indexerPatientWarfarin(SolrInputDocument document) throws Exception {
		if(prenom != null) {
			String valCrypte = requeteSite.crypterStr(prenom);
			document.addField("prenom_crypte"valCrypte);
		}
		if(nomFamille != null) {
			String valCrypte = requeteSite.crypterStr(nomFamille);
			document.addField("nomFamille_crypte"valCrypte);
		}
		super.indexerCluster(document);

	}

	/////////////
	// obtenir //
	/////////////

	@Override public Object obtenirPourClasse(String var) throws Exception {
		String[] vars = org.apache.commons.lang3.StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtenirPatientWarfarin(v);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.obtenirPourClasse(v);
			}
		}
		return o;
	}
	public Object obtenirPatientWarfarin(String var) throws Exception {
		PatientWarfarin oPatientWarfarin = (PatientWarfarin)this;
		switch(var) {
			case "prenom":
				return oPatientWarfarin.prenom;
			case "nomFamille":
				return oPatientWarfarin.nomFamille;
			default:
				return super.obtenirCluster(var);
		}
	}

	///////////////
	// attribuer //
	///////////////

	@Override public boolean attribuerPourClasse(String var, Object val) throws Exception {
		String[] vars = org.apache.commons.lang3.StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = attribuerPatientWarfarin(v, val);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.attribuerPourClasse(v, val);
			}
		}
		return o != null;
	}
	public Object attribuerPatientWarfarin(String var, Object val) throws Exception {
		PatientWarfarin oPatientWarfarin = (PatientWarfarin)this;
		switch(var) {
			default:
				return super.attribuerCluster(var, val);
		}
	}

	/////////////
	// definir //
	/////////////

	@Override public boolean definirPourClasse(String var, String...vals) throws Exception {
		String[] vars = org.apache.commons.lang3.StringUtils.split(var, ".");
		Object o = null;
		String val = vals == null ? null : vals[vals.length - 1];
		if(val != null) {
			for(String v : vars) {
				if(o == null)
					o = definirPatientWarfarin(v, val);
				else if(o instanceof Cluster) {
					Cluster cluster = (Cluster)o;
					o = cluster.definirPourClasse(v, val);
				}
			}
		}
		return o != null;
	}
	public Object definirPatientWarfarin(String var, String val) throws Exception {
		PatientWarfarin oPatientWarfarin = (PatientWarfarin)this;
		switch(var) {
			default:
				return super.definirCluster(var, val);
		}
	}
}
