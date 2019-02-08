package org.computate.frFR.cardiaque.warfarin; 

import java.time.LocalDate;

import org.computate.frFR.cardiaque.chaine.Chaine;
import org.computate.frFR.cardiaque.cluster.Cluster;
import org.computate.frFR.cardiaque.couverture.Couverture;



/**    
 * Modele: true
 * NomCanonique.enUS: org.computate.enUS.cardiac.warfarin.InrEntry
 * ApiUri.enUS: /api/v1/warfarin/inr-entry
 * ApiUri.frFR: /api/v1/warfarin/calcul-inr
 * ApiMethode: Recherche
 * ApiMethode: POST
 * ApiMethode: PATCH
 * ApiMethode: GET
 * ApiMethode: PUT
 * ApiMethode: DELETE
 * ApiMethode: RecherchePage
 * ApiMotCleRecherchePage.frFR: page
 * ApiMotCleRecherchePage.enUS: page
 * ApiUriRecherchePage.frFR: /calcul-inr
 * ApiUriRecherchePage.enUS: /inr-entry
 * ApiTypeMedia200GETPage: text/html
 * PageRecherchePage: CalculInrPage
 * 
 * Val.VAL_patientPrendCoumadinOui.frFR:Yes
 * Val.VAL_patientPrendCoumadinNon.frFR:No
 * Val.VAL_patientPrendCoumadinOuiDosageInitial.frFR:Yes, initial dosing
 * Val.VAL_patientPrendCoumadinOuiRecommence.frFR:Yes, restarted
 * Role.frFR: SiteAdmin
 * Map.this.Integer: 1
 * ApiTag.enUS: InrEntry
 * ApiTag.frFR: CalculInr
*/         
public class CalculInr extends CalculInrGen<Cluster> {  

	/**
	 * {@inheritDoc}
	 * Indexe: true
	 * Stocke: true
	 * attribuer: UtilisateurSite.calculInrPks
	 * enUS: User primary key. 
	 */         
	protected void _utilisateurPk(Couverture<Long> c) {
	}

	/**
	 * {@inheritDoc}
	 * Indexe: true
	 * Stocke: true
	 */
	protected void _dateInr(Couverture<LocalDate> c) {
		c.o(LocalDate.now());
	}

	/**
	 * {@inheritDoc}
	 * Indexe: true
	 * Stocke: true
	 */
	protected void _dateReverifier(Couverture<LocalDate> c) {

	}

	/**
	 * {@inheritDoc}
	 * Var.enUS: currentDosageText
	 * Indexe: true
	 * Stocke: true
	 * Option.frFR.vide:""
	 * Option.frFR.oui:CalculInr.VAL_patientPrendCoumadinOui
	 * Option.frFR.non:CalculInr.VAL_patientPrendCoumadinNon
	 * Option.frFR.ouiDosageInitial:CalculInr.VAL_patientPrendCoumadinOuiDosageInitial
	 * Option.frFR.ouiRecommence:CalculInr.VAL_patientPrendCoumadinOuiRecommence
	 */ 
	protected void _patientPrendCoumadin(Chaine o) {
	}

	/**
	 * {@inheritDoc}
	 * Var.enUS: currentGoal
	 * Indexe: true
	 * Stocke: true
	 */ 
	protected void _butActuel(Chaine o) {
	}

	/**
	 * {@inheritDoc}
	 * Var.enUS: currentDosage
	 * Indexe: true
	 * Stocke: true
	 */ 
	protected void _doseActuel(Chaine o) {
	}

	/**
	 * {@inheritDoc}
	 * Var.enUS: currentMedication
	 * Indexe: true
	 * Stocke: true
	 */ 
	protected void _medicamentActuel(Chaine o) {
	}

	/**
	 * {@inheritDoc}
	 * Var.enUS: dosageChange
	 * Indexe: true
	 * Stocke: true
	 * r: FORMAT_dateMedicalCourt
	 * r.enUS: FORMAT_dateMedicalShort
	 */
	protected void _changementDose(Chaine o) {
		o.s(dateInr.format(FORMAT_dateMedicalCourt), " INR @ ");
	}

	/**
	 * {@inheritDoc}
	 * Var.enUS: additionalNotes
	 * Indexe: true
	 * Stocke: true
	 */
	protected void _notesComplementaires(Chaine o) {
	}

	/**
	 * {@inheritDoc}
	 * Var.enUS: contactInfo
	 * Indexe: true
	 * Stocke: true
	 */ 
	protected void _infoContact(Chaine o) {
	}
}
