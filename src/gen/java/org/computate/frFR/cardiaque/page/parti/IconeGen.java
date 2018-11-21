package org.computate.frFR.cardiaque.page.parti;

import org.computate.frFR.cardiaque.page.parti.PageParti;
import org.computate.frFR.cardiaque.chaine.Chaine;
import org.computate.frFR.cardiaque.couverture.Couverture;
import org.computate.frFR.cardiaque.cluster.Cluster;
import org.computate.frFR.cardiaque.requete.RequeteSite;
import org.computate.frFR.cardiaque.page.MiseEnPage;

public abstract class IconeGen<DEV> extends PageParti {

	//////////
	// type //
	//////////

	/**	L'entité « type »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 */
	protected Chaine type = new Chaine();
	public Couverture<Chaine> typeCouverture = new Couverture<Chaine>().p(this).c(Chaine.class).var("type").o(type);

	/**	L'entité « type »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 *	@param type est le champ déjà construit. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _type(Chaine o) throws Exception;

	public Chaine getType() {
		return type;
	}

	public void setType(Chaine o) throws Exception {
		this.type = o;
	}
	public Icone setType(String o) throws Exception {
		type.tout(o);
		return (Icone)this;
	}
	protected void typeInit() throws Exception {
		if(!typeCouverture.dejaInitialise) {
			_type(type);
		}
		type.initLoinPourClasse(requeteSite_);
		typeCouverture.dejaInitialise(true);
	}

	/////////
	// nom //
	/////////

	/**	L'entité « nom »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 */
	protected Chaine nom = new Chaine();
	public Couverture<Chaine> nomCouverture = new Couverture<Chaine>().p(this).c(Chaine.class).var("nom").o(nom);

	/**	L'entité « nom »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 *	@param nom est le champ déjà construit. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _nom(Chaine o) throws Exception;

	public Chaine getNom() {
		return nom;
	}

	public void setNom(Chaine o) throws Exception {
		this.nom = o;
	}
	public Icone setNom(String o) throws Exception {
		nom.tout(o);
		return (Icone)this;
	}
	protected void nomInit() throws Exception {
		if(!nomCouverture.dejaInitialise) {
			_nom(nom);
		}
		nom.initLoinPourClasse(requeteSite_);
		nomCouverture.dejaInitialise(true);
	}

	///////////
	// page_ //
	///////////

	/**	L'entité « page_ »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	protected MiseEnPage page_;
	public Couverture<MiseEnPage> page_Couverture = new Couverture<MiseEnPage>().p(this).c(MiseEnPage.class).var("page_").o(page_);

	/**	L'entité « page_ »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _page_(Couverture<MiseEnPage> o) throws Exception;

	public MiseEnPage getPage_() {
		return page_;
	}

	public void setPage_(MiseEnPage o) throws Exception {
		this.page_ = o;
	}
	protected void page_Init() throws Exception {
		if(!page_Couverture.dejaInitialise) {
			_page_(page_Couverture);
			if(page_ == null)
				setPage_(page_Couverture.o);
		}
		page_Couverture.dejaInitialise(true);
	}

	/////////////////////
	// initialiserLoin //
	/////////////////////

	protected boolean dejaInitialiseIcone = false;

	public void initLoinIcone(RequeteSite requeteSite) throws Exception {
		setRequeteSite_(requeteSite);
		initLoinIcone();
	}

	public void initLoinIcone() throws Exception {
		if(!dejaInitialiseIcone) {
			super.initLoinPageParti(requeteSite_);
			typeInit();
			nomInit();
			page_Init();
			dejaInitialiseIcone = true;
		}
	}

	public void initLoinPourClasse(RequeteSite requeteSite) throws Exception {
		initLoinIcone(requeteSite);
	}

	/////////////////
	// requeteSite //
	/////////////////

	public void requeteSiteIcone(RequeteSite requeteSite) throws Exception {
			super.requeteSitePageParti(requeteSite);
		type.setRequeteSite_(requeteSite);
		nom.setRequeteSite_(requeteSite);
	}

	public void requeteSitePourClasse(RequeteSite requeteSite) throws Exception {
		requeteSiteIcone(requeteSite);
	}

	/////////////
	// obtenir //
	/////////////

	@Override public Object obtenirPourClasse(String var) throws Exception {
		String[] vars = org.apache.commons.lang3.StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtenirIcone(v);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.obtenirPourClasse(v);
			}
		}
		return o;
	}
	public Object obtenirIcone(String var) throws Exception {
		Icone oIcone = (Icone)this;
		switch(var) {
			case "type":
				return oIcone.type;
			case "nom":
				return oIcone.nom;
			case "page_":
				return oIcone.page_;
			default:
				return super.obtenirPageParti(var);
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
				o = attribuerIcone(v, val);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.attribuerPourClasse(v, val);
			}
		}
		return o != null;
	}
	public Object attribuerIcone(String var, Object val) throws Exception {
		Icone oIcone = (Icone)this;
		switch(var) {
			default:
				return super.attribuerPageParti(var, val);
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
					o = definirIcone(v, val);
				else if(o instanceof Cluster) {
					Cluster cluster = (Cluster)o;
					o = cluster.definirPourClasse(v, val);
				}
			}
		}
		return o != null;
	}
	public Object definirIcone(String var, String val) throws Exception {
		Icone oIcone = (Icone)this;
		switch(var) {
			case "type":
				oIcone.setType(val);
				return val;
			case "nom":
				oIcone.setNom(val);
				return val;
			default:
				return super.definirPageParti(var, val);
		}
	}
}
