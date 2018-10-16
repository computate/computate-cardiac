package com.heytate.frFR.cardiaque.page.parti;

import com.heytate.frFR.cardiaque.page.MiseEnPage;
import com.heytate.frFR.cardiac.chaine.Chaine;
import com.heytate.frFR.cardiaque.couverture.Couverture;

public abstract class IconeGen<DEV> extends PageParti {

	//////////
	// type //
	//////////

	/**	L'entité « type »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 */
	public Chaine type = new Chaine();
	public Couverture<Chaine> typeCouverture = new Couverture<Chaine>().p(this).c(Chaine.class).var("type").o(type);

	/**	L'entité « type »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 *	@param type est le champ déjà construit. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _type(Chaine o) throws Exception;

	public Icone type(Chaine o) throws Exception {
		setType(o);
		return (Icone)this;
	}

	public void setType(Chaine o) throws Exception {
		this.type = o;
	}

	public Chaine type() throws Exception {
		return getType();
	}

	public Chaine getType() throws Exception {
		return type;
	}
	protected void typeInit() throws Exception {
		if(!typeCouverture.dejaInitialise) {
			_type(type);
		}
		typeCouverture.dejaInitialise(true);
	}

	/////////
	// nom //
	/////////

	/**	L'entité « nom »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 */
	public Chaine nom = new Chaine();
	public Couverture<Chaine> nomCouverture = new Couverture<Chaine>().p(this).c(Chaine.class).var("nom").o(nom);

	/**	L'entité « nom »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 *	@param nom est le champ déjà construit. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _nom(Chaine o) throws Exception;

	public Icone nom(Chaine o) throws Exception {
		setNom(o);
		return (Icone)this;
	}

	public void setNom(Chaine o) throws Exception {
		this.nom = o;
	}

	public Chaine nom() throws Exception {
		return getNom();
	}

	public Chaine getNom() throws Exception {
		return nom;
	}
	protected void nomInit() throws Exception {
		if(!nomCouverture.dejaInitialise) {
			_nom(nom);
		}
		nomCouverture.dejaInitialise(true);
	}

	///////////
	// page_ //
	///////////

	/**	L'entité « page_ »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public MiseEnPage page_;
	public Couverture<MiseEnPage> page_Couverture = new Couverture<MiseEnPage>().p(this).c(MiseEnPage.class).var("page_").o(page_);

	/**	L'entité « page_ »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _page_(Couverture<MiseEnPage> o) throws Exception;

	public Icone page_(MiseEnPage o) throws Exception {
		setPage_(o);
		return (Icone)this;
	}

	public void setPage_(MiseEnPage o) throws Exception {
		this.page_ = o;
	}

	public MiseEnPage page_() throws Exception {
		return getPage_();
	}

	public MiseEnPage getPage_() throws Exception {
		return page_;
	}
	protected void page_Init() throws Exception {
		if(!page_Couverture.dejaInitialise) {
			_page_(page_Couverture);
			if(page_ == null)
				page_(page_Couverture.o);
		}
		page_Couverture.dejaInitialise(true);
	}

	protected boolean dejaInitialiseIcone = false;

	public void initLoinIcone() throws Exception {
		if(!dejaInitialiseIcone) {
			super.initLoinPageParti(requeteSite);
			typeInit();
			nomInit();
			page_Init();
			dejaInitialiseIcone = true;
		}
	}
}
