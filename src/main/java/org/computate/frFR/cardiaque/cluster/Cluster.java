package org.computate.frFR.cardiaque.cluster;   

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.computate.frFR.cardiaque.couverture.Couverture;
import org.computate.frFR.cardiaque.page.MiseEnPage;
import org.computate.frFR.cardiaque.requete.RequeteSite;



/**
 * nomCanonique.enUS: org.computate.site.course.c000.cluster.Cluster
 * modele: true
 * apiUri.frFR: /api/v1/warfarin/cluster
 */  
public class Cluster extends ClusterGen<Object> {        

	public static DateTimeFormatter FORMAT_dateMedicalCourt = DateTimeFormatter.ofPattern("M/d/yyyy", Locale.FRANCE);

//	/**
//	 * ignorer: true
//	 * var.enUS: siteRequestCluster
//	 * param1.var.enUS: siteRequest
//	 * remplacer.enUS: requeteSite
//	 * siteRequest
//	 */
//	@Override public void requeteSiteCluster(RequeteSite requeteSite) throws Exception {  
//		super.requeteSiteCluster(requeteSite);
//		requeteSite(requeteSite);
//	}

	/**
	 * var.enUS: _siteRequest
	 */
	protected void _requeteSite_(Couverture<RequeteSite> c) throws Exception {}
	protected void _page_(Couverture<MiseEnPage> c) throws Exception {}

	/**
	 * indexe: true
	 * stocke: true
	 */
	protected void _pk(Couverture<Long> c) throws Exception {}

	/**
	 * cleUnique: true
	 */
	protected void _id(Couverture<String> c) throws Exception {
		if(pk != null)
			c.o(pk.toString());
	}

	/**
	 * indexe: true
	 * stocke: true
	 * var.enUS: _created
	 */
	protected void _cree(Couverture<LocalDateTime> c) throws Exception {}

	/**
	 * indexe: true
	 * stocke: true
	 * var.enUS: _modified
	 */
	protected void _modifie(Couverture<LocalDateTime> c) throws Exception {}

	/**
	 * indexe: true
	 * stocke: true
	 * var.enUS: _userId
	 */
	protected void _utilisateurId(Couverture<String> c) throws Exception {}

	/**
	 * indexe: true
	 * stocke: true
	 * var.enUS: _clusterCanonicalName
	 */
	protected void _clusterNomCanonique(Couverture<String> c) throws Exception {
		String o = getClass().getCanonicalName();
		c.o(o);
	}

	/**
	 * indexe: true
	 * stocke: true
	 * var.enUS: _clusterSimpleName
	 */
	protected void _clusterNomSimple(Couverture<String> c) throws Exception {
		String o = getClass().getSimpleName();
		c.o(o);
	}

	/** 
	 * var.enUS: _deleted
	 */
	protected void _supprime(Couverture<Boolean> c) throws Exception {
		Boolean o = false;
		c.o(o);
	}
//
//	/**
//	 * genInclure: true
//	 */
//	public MiseEnPage e(String nomLocal) {
//		if(page_ != null)
//			page_.e(nomLocal);
//		return page_;
//	}
//
//	/**
//	 * genInclure: true
//	 * param1.var.enUS: attributeName
//	 * param2.var.enUS: objects
//	 * remplacer.enUS: nomAttribut
//	 * attributeName
//	 * remplacer.enUS: objets
//	 * objects
//	 */
//	public MiseEnPage a(String nomAttribut, Object...objets) {
//		if(page_ != null)
//			page_.a(nomAttribut, objets);
//		return page_;
//	}
//
//	/**
//	 * genInclure: true
//	 */
//	public MiseEnPage f() {
//		if(page_ != null)
//			page_.f();
//		return page_;
//	}
//
//	public MiseEnPage toutShApos(Object...objets) {
//		if(page_ != null)
//			page_.toutShApos(objets);
//		return page_;
//	}
//
//	public MiseEnPage toutLigne(Object...objets) {
//		if(page_ != null)
//			page_.toutLigne(objets);
//		return page_;
//	}
//
//	public MiseEnPage tout(Object...objets) {
//		if(page_ != null)
//			page_.tout(objets);
//		return page_;
//	}
//
//	public MiseEnPage enUS(Object...objets) {
//		if(page_ != null)
//			page_.enUS(objets);
//		return page_;
//	}
//
//	public MiseEnPage frFR(Object...objets) {
//		if(page_ != null)
//			page_.frFR(objets);
//		return page_;
//	}
//
//	public MiseEnPage enUSLigne(Object...objets) {
//		if(page_ != null)
//			page_.enUSLigne(objets);
//		return page_;
//	}
//
//	public MiseEnPage frFRLigne(Object...objets) {
//		if(page_ != null)
//			page_.frFRLigne(objets);
//		return page_;
//	}
//
//	public MiseEnPage toutShAposXml(Object...objets) {
//		if(page_ != null)
//			page_.toutShAposXml(objets);
//		return page_;
//	}
//
//	/**
//	 * genInclure: true
//	 * param1.var.enUS: objects
//	 * remplacer.enUS: objets
//	 * objects
//	 * remplacer.enUS: toutXml
//	 * allXml
//	 */
//	public MiseEnPage toutXml(Object...objets) {
//		if(page_ != null)
//			page_.toutXml(objets);
//		return page_;
//	}
//
//	public MiseEnPage enUSXml(Object...objets) {
//		if(page_ != null)
//			page_.enUSXml(objets);
//		return page_;
//	}
//
//	public MiseEnPage frFRXml(Object...objets) {
//		if(page_ != null)
//			page_.frFRXml(objets);
//		return page_;
//	}
//
//	/**
//	 * genInclure: true
//	 */
//	public MiseEnPage fg() {
//		if(page_ != null)
//			page_.fg();
//		return page_;
//	}
//
//	/**
//	 * genInclure: true
//	 * param1.var.enUS: localName
//	 * remplacer.enUS: nomLocal
//	 * localName
//	 */
//	public MiseEnPage g(String nomLocal) {
//		if(page_ != null)
//			page_.g(nomLocal);
//		return page_;
//	}
//
//	public MiseEnPage icone(String href) {
//		if(page_ != null)
//			page_.g(href);
//		return page_;
//	}
//
//	public MiseEnPage iconeLight(String nom) {
//		if(page_ != null)
//			page_.g(nom);
//		return page_;
//	}
//
//	public MiseEnPage iconeRegular(String nom) {
//		if(page_ != null)
//			page_.g(nom);
//		return page_;
//	}
//
//	public MiseEnPage iconeSolid(String nom) {
//		if(page_ != null)
//			page_.g(nom);
//		return page_;
//	}
//
//	public MiseEnPage iconeBrands(String nom) {
//		if(page_ != null)
//			page_.g(nom);
//		return page_;
//	}
//
//	public MiseEnPage iconeComputate(String nom) {
//		if(page_ != null)
//			page_.g(nom);
//		return page_;
//	}
}
