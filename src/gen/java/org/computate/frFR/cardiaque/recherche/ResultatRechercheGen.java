package org.computate.frFR.cardiaque.recherche;

import org.apache.solr.common.SolrDocument;
import org.computate.frFR.cardiaque.couverture.Couverture;
import java.lang.Long;
import org.computate.frFR.cardiaque.cluster.Cluster;
import org.computate.frFR.cardiaque.requete.RequeteSite;
import java.lang.Object;

public abstract class ResultatRechercheGen<DEV> extends Object {

	//////////////////
	// requeteSite_ //
	//////////////////

	/**	L'entité « requeteSite_ »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected RequeteSite requeteSite_;
	public Couverture<RequeteSite> requeteSite_Couverture = new Couverture<RequeteSite>().p(this).c(RequeteSite.class).var("requeteSite_").o(requeteSite_);

	/**	L'entité « requeteSite_ »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _requeteSite_(Couverture<RequeteSite> o) throws Exception;

	public RequeteSite getRequeteSite_() {
		return requeteSite_;
	}

	public void setRequeteSite_(RequeteSite o) throws Exception {
		this.requeteSite_ = o;
	}
	protected void requeteSite_Init() throws Exception {
		if(!requeteSite_Couverture.dejaInitialise) {
			_requeteSite_(requeteSite_Couverture);
			if(requeteSite_ == null)
				setRequeteSite_(requeteSite_Couverture.o);
		}
		requeteSite_Couverture.dejaInitialise(true);
	}

	//////////////////
	// documentSolr //
	//////////////////

	/**	L'entité « documentSolr »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected SolrDocument documentSolr;
	public Couverture<SolrDocument> documentSolrCouverture = new Couverture<SolrDocument>().p(this).c(SolrDocument.class).var("documentSolr").o(documentSolr);

	/**	L'entité « documentSolr »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _documentSolr(Couverture<SolrDocument> o) throws Exception;

	public SolrDocument getDocumentSolr() {
		return documentSolr;
	}

	public void setDocumentSolr(SolrDocument o) throws Exception {
		this.documentSolr = o;
	}
	protected void documentSolrInit() throws Exception {
		if(!documentSolrCouverture.dejaInitialise) {
			_documentSolr(documentSolrCouverture);
			if(documentSolr == null)
				setDocumentSolr(documentSolrCouverture.o);
		}
		documentSolrCouverture.dejaInitialise(true);
	}

	////////////////////
	// resultatIndice //
	////////////////////

	/**	L'entité « resultatIndice »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected Long resultatIndice;
	public Couverture<Long> resultatIndiceCouverture = new Couverture<Long>().p(this).c(Long.class).var("resultatIndice").o(resultatIndice);

	/**	L'entité « resultatIndice »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _resultatIndice(Couverture<Long> o) throws Exception;

	public Long getResultatIndice() {
		return resultatIndice;
	}

	public void setResultatIndice(Long o) throws Exception {
		this.resultatIndice = o;
	}
	public ResultatRecherche setResultatIndice(String o) throws Exception {
		if(org.apache.commons.lang3.math.NumberUtils.isCreatable(o))
			this.resultatIndice = Long.parseLong(o);
		return (ResultatRecherche)this;
	}
	protected void resultatIndiceInit() throws Exception {
		if(!resultatIndiceCouverture.dejaInitialise) {
			_resultatIndice(resultatIndiceCouverture);
			if(resultatIndice == null)
				setResultatIndice(resultatIndiceCouverture.o);
		}
		resultatIndiceCouverture.dejaInitialise(true);
	}

	/////////////////////
	// initialiserLoin //
	/////////////////////

	protected boolean dejaInitialiseResultatRecherche = false;

	public void initLoinResultatRecherche(RequeteSite requeteSite) throws Exception {
		setRequeteSite_(requeteSite);
		initLoinResultatRecherche();
	}

	public void initLoinResultatRecherche() throws Exception {
		if(!dejaInitialiseResultatRecherche) {
			requeteSite_Init();
			documentSolrInit();
			resultatIndiceInit();
			dejaInitialiseResultatRecherche = true;
		}
	}

	public void initLoinPourClasse(RequeteSite requeteSite) throws Exception {
		initLoinResultatRecherche(requeteSite);
	}

	/////////////////
	// requeteSite //
	/////////////////

	public void requeteSiteResultatRecherche(RequeteSite requeteSite) throws Exception {
	}

	public void requeteSitePourClasse(RequeteSite requeteSite) throws Exception {
		requeteSiteResultatRecherche(requeteSite);
	}

	/////////////
	// obtenir //
	/////////////

	public Object obtenirPourClasse(String var) throws Exception {
		String[] vars = org.apache.commons.lang3.StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtenirResultatRecherche(v);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.obtenirPourClasse(v);
			}
		}
		return o;
	}
	public Object obtenirResultatRecherche(String var) throws Exception {
		ResultatRecherche oResultatRecherche = (ResultatRecherche)this;
		switch(var) {
			case "requeteSite_":
				return oResultatRecherche.requeteSite_;
			case "documentSolr":
				return oResultatRecherche.documentSolr;
			case "resultatIndice":
				return oResultatRecherche.resultatIndice;
			default:
				return null;
		}
	}

	///////////////
	// attribuer //
	///////////////

	public boolean attribuerPourClasse(String var, Object val) throws Exception {
		String[] vars = org.apache.commons.lang3.StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = attribuerResultatRecherche(v, val);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.attribuerPourClasse(v, val);
			}
		}
		return o != null;
	}
	public Object attribuerResultatRecherche(String var, Object val) throws Exception {
		ResultatRecherche oResultatRecherche = (ResultatRecherche)this;
		switch(var) {
			default:
				return null;
		}
	}

	/////////////
	// definir //
	/////////////

	public boolean definirPourClasse(String var, String...vals) throws Exception {
		String[] vars = org.apache.commons.lang3.StringUtils.split(var, ".");
		Object o = null;
		String val = vals == null ? null : vals[vals.length - 1];
		if(val != null) {
			for(String v : vars) {
				if(o == null)
					o = definirResultatRecherche(v, val);
				else if(o instanceof Cluster) {
					Cluster cluster = (Cluster)o;
					o = cluster.definirPourClasse(v, val);
				}
			}
		}
		return o != null;
	}
	public Object definirResultatRecherche(String var, String val) throws Exception {
		ResultatRecherche oResultatRecherche = (ResultatRecherche)this;
		switch(var) {
			case "resultatIndice":
				oResultatRecherche.setResultatIndice(val);
				return val;
			default:
				return null;
		}
	}
}
