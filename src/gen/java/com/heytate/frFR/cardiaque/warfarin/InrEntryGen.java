package com.heytate.frFR.cardiaque.warfarin;

import java.math.BigDecimal;
import java.time.LocalDate;
import com.heytate.frFR.cardiac.chaine.Chaine;
import com.heytate.frFR.cardiaque.cluster.Cluster;
import com.heytate.frFR.cardiaque.couverture.Couverture;

public abstract class InrEntryGen<DEV> extends Cluster {

	/////////////
	// inrDate //
	/////////////

	/**	L'entité « inrDate »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public LocalDate inrDate;
	public Couverture<LocalDate> inrDateCouverture = new Couverture<LocalDate>().p(this).c(LocalDate.class).var("inrDate").o(inrDate);

	/**	L'entité « inrDate »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _inrDate(Couverture<LocalDate> o) throws Exception;

	public void setInrDate(LocalDate o) throws Exception {
		this.inrDate = o;
	}

	public LocalDate getInrDate() throws Exception {
		return inrDate;
	}
	protected void inrDateInit() throws Exception {
		if(!inrDateCouverture.dejaInitialise) {
			_inrDate(inrDateCouverture);
			if(inrDate == null)
				setInrDate(inrDateCouverture.o);
		}
		inrDateCouverture.dejaInitialise(true);
	}

	//////////////////////
	// doseActuelValeur //
	//////////////////////

	/**	L'entité « doseActuelValeur »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public BigDecimal doseActuelValeur;
	public Couverture<BigDecimal> doseActuelValeurCouverture = new Couverture<BigDecimal>().p(this).c(BigDecimal.class).var("doseActuelValeur").o(doseActuelValeur);

	/**	L'entité « doseActuelValeur »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _doseActuelValeur(Couverture<BigDecimal> o) throws Exception;

	public void setDoseActuelValeur(BigDecimal o) throws Exception {
		this.doseActuelValeur = o;
	}

	public BigDecimal getDoseActuelValeur() throws Exception {
		return doseActuelValeur;
	}
	public InrEntry doseActuelValeur(String o) throws Exception {
		if(org.apache.commons.lang3.math.NumberUtils.isNumber(o))
			this.doseActuelValeur = new BigDecimal(o);
		return (InrEntry)this;
	}
	protected void doseActuelValeurInit() throws Exception {
		if(!doseActuelValeurCouverture.dejaInitialise) {
			_doseActuelValeur(doseActuelValeurCouverture);
			if(doseActuelValeur == null)
				setDoseActuelValeur(doseActuelValeurCouverture.o);
		}
		doseActuelValeurCouverture.dejaInitialise(true);
	}

	/////////////////////
	// doseActuelTexte //
	/////////////////////

	/**	L'entité « doseActuelTexte »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 */
	public Chaine doseActuelTexte = new Chaine();
	public Couverture<Chaine> doseActuelTexteCouverture = new Couverture<Chaine>().p(this).c(Chaine.class).var("doseActuelTexte").o(doseActuelTexte);

	/**	L'entité « doseActuelTexte »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 *	@param doseActuelTexte est le champ déjà construit. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _doseActuelTexte(Chaine o) throws Exception;

	public void setDoseActuelTexte(Chaine o) throws Exception {
		this.doseActuelTexte = o;
	}

	public Chaine getDoseActuelTexte() throws Exception {
		return doseActuelTexte;
	}
	protected void doseActuelTexteInit() throws Exception {
		if(!doseActuelTexteCouverture.dejaInitialise) {
			_doseActuelTexte(doseActuelTexte);
		}
		doseActuelTexteCouverture.dejaInitialise(true);
	}

	//////////////////////////
	// changementDoseValeur //
	//////////////////////////

	/**	L'entité « changementDoseValeur »
	 *	 est défini comme null avant d'être initialisé. 
	 */
	public BigDecimal changementDoseValeur;
	public Couverture<BigDecimal> changementDoseValeurCouverture = new Couverture<BigDecimal>().p(this).c(BigDecimal.class).var("changementDoseValeur").o(changementDoseValeur);

	/**	L'entité « changementDoseValeur »
	 *	 est défini comme null avant d'être initialisé. 
	 *	@param o est pour envelopper une valeur à assigner à ce champ lors de l'initialisation. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _changementDoseValeur(Couverture<BigDecimal> o) throws Exception;

	public void setChangementDoseValeur(BigDecimal o) throws Exception {
		this.changementDoseValeur = o;
	}

	public BigDecimal getChangementDoseValeur() throws Exception {
		return changementDoseValeur;
	}
	public InrEntry changementDoseValeur(String o) throws Exception {
		if(org.apache.commons.lang3.math.NumberUtils.isNumber(o))
			this.changementDoseValeur = new BigDecimal(o);
		return (InrEntry)this;
	}
	protected void changementDoseValeurInit() throws Exception {
		if(!changementDoseValeurCouverture.dejaInitialise) {
			_changementDoseValeur(changementDoseValeurCouverture);
			if(changementDoseValeur == null)
				setChangementDoseValeur(changementDoseValeurCouverture.o);
		}
		changementDoseValeurCouverture.dejaInitialise(true);
	}

	/////////////////////////
	// changementDoseTexte //
	/////////////////////////

	/**	L'entité « changementDoseTexte »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 */
	public Chaine changementDoseTexte = new Chaine();
	public Couverture<Chaine> changementDoseTexteCouverture = new Couverture<Chaine>().p(this).c(Chaine.class).var("changementDoseTexte").o(changementDoseTexte);

	/**	L'entité « changementDoseTexte »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Chaine(). 
	 *	@param changementDoseTexte est le champ déjà construit. 
	 *	@throws java.lang.Exception afin que toute exception lors de l'initialisation est gérée par le servlet. 
	 */
	protected abstract void _changementDoseTexte(Chaine o) throws Exception;

	public void setChangementDoseTexte(Chaine o) throws Exception {
		this.changementDoseTexte = o;
	}

	public Chaine getChangementDoseTexte() throws Exception {
		return changementDoseTexte;
	}
	protected void changementDoseTexteInit() throws Exception {
		if(!changementDoseTexteCouverture.dejaInitialise) {
			_changementDoseTexte(changementDoseTexte);
		}
		changementDoseTexteCouverture.dejaInitialise(true);
	}

	protected boolean dejaInitialiseInrEntry = false;

	public void initLoinInrEntry() throws Exception {
		if(!dejaInitialiseInrEntry) {
			inrDateInit();
			doseActuelValeurInit();
			doseActuelTexteInit();
			changementDoseValeurInit();
			changementDoseTexteInit();
			dejaInitialiseInrEntry = true;
		}
	}
}
