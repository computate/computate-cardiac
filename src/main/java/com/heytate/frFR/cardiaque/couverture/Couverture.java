package com.heytate.frFR.cardiaque.couverture; 

import java.util.ArrayList;

/**
 * 
 * nomCanonique.enUS: org.computate.enUS.wrap.Wrap
 */ 
public class Couverture<DEV> { 

	/**	
	 * frFR: Le nom du champ qui est couvert par cette couverture. 
	 **/  
	public String var;
	public Couverture<DEV> var(String o) {
		var = o;
		return this;
	}

	/**
	 * frFR: L'objet qui est couvert par cette couverture. 
	 **/
	public DEV o;
	public Couverture<DEV> o(DEV o) {
		this.o = o;
		return this;
	}

	/**
	 * frFR: La classe de l'objet qui est couvert par cette couverture. 
	 **/
	public Class<?> c;
	public Couverture<DEV> c(Class<?> o) {
		c = o;
		return this;
	}

	/**
	 * frFR: L'objet parent de l'objet qui est couvert par cette couverture. 
	 **/
	public Object p;
	public Couverture<DEV> p(Object o) {
		p = o;
		return this;
	}

	/**
	 * var.enUS: cChild
	 */
	public Class<?> cEnfant;

	/**
	 * var.enUS: cChild
	 * r: cEnfant
	 * r.enUS: cChild
	 */
	public Couverture<DEV> cEnfant(Class<?> o) {
		cEnfant = o;
		return this;
	}

	/**
	 * var.enUS: alreadyInitialized
	 * frFR: Vrai si cette couverture a était déjà initialisée. 
	 */
	public Boolean dejaInitialise = false;
	/**
	 * var.enUS: alreadyInitialized
	 * r: dejaInitialise
	 * r.enUS: alreadyInitialized
	 * frFR: Vrai si cette couverture a était déjà initialisée. 
	 */
	public Couverture<DEV> dejaInitialise(Boolean o) {
		dejaInitialise = o;
		return this;
	}

	/**
	 * var.enUS: siteRequestObject
	 * **/
	public Object requeteSiteObjet;
	/**
	 * var.enUS: siteRequestObject
	 * r: requeteSiteObjet
	 * r.enUS: siteRequestObject
	 * frFR: Tous les infos importants à propos de la requête actuelle. 
	 */
	public Couverture<DEV> requeteSiteObjet(Object o) {
		requeteSiteObjet = o;
		return this;
	}

	/**  
	 * **/
	public ArrayList<String> pageVars = new ArrayList<String>();

	/** 
	 * var.enUS: pageVarsAdd
	 */
	public void pageVarsAjouter(String...pageVars) {
		for(String pageVar : pageVars)
			this.pageVars.add(pageVar);
	}
}
