package org.computate.frFR.cardiaque.warfarin;  

import java.time.LocalDate;

import org.computate.frFR.cardiaque.chaine.Chaine;
import org.computate.frFR.cardiaque.cluster.Cluster;
import org.computate.frFR.cardiaque.couverture.Couverture;



/** 
 * modele: true
 * nomCanonique.enUS: org.computate.enUS.cardiac.warfarin.InrEntry
 * apiUri.enUS: /api/v1/warfarin/inr-entry
 * apiUri.frFR: /api/v1/warfarin/calcul-inr
 * apiMethode: Recherche
 * apiMethode: POST
 * apiMethode: PATCH
 * apiMethode: GET
 * apiMethode: PUT
 * apiMethode: DELETE
 * 
 * val.VAL_patientPrendCoumadinOui.frFR:Yes
 * val.VAL_patientPrendCoumadinNon.frFR:No
 * val.VAL_patientPrendCoumadinOuiDosageInitial.frFR:Yes, initial dosing
 * val.VAL_patientPrendCoumadinOuiRecommence.frFR:Yes, restarted
 * role.frFR: Something
 * map.this.Integer: 1
*/  
public class CalculInr extends CalculInrGen<Cluster> {  

	/**
	 * {@inheritDoc}
	 * indexe: true
	 * stocke: true
	 * attribuer: UtilisateurSite.calculInrPks
	 * enUS: User primary key. 
	 */  
	protected void _utilisateurPk(Couverture<Long> c) {
	}

	/**
	 * {@inheritDoc}
	 * indexe: true
	 * stocke: true
	 */
	protected void _dateInr(Couverture<LocalDate> c) {
		c.o(LocalDate.now());
	}

	/**
	 * {@inheritDoc}
	 * indexe: true
	 * stocke: true
	 */
	protected void _dateReverifier(Couverture<LocalDate> c) {

	}

	/**
	 * {@inheritDoc}
	 * var.enUS: currentDosageText
	 * indexe: true
	 * stocke: true
	 * option.vide.frFR:""
	 * option.oui.frFR:CalculInr.VAL_patientPrendCoumadinOui
	 * option.non.frFR:CalculInr.VAL_patientPrendCoumadinNon
	 * option.ouiDosageInitial.frFR:CalculInr.VAL_patientPrendCoumadinOuiDosageInitial
	 * option.ouiRecommence.frFR:CalculInr.VAL_patientPrendCoumadinOuiRecommence
	 */ 
	protected void _patientPrendCoumadin(Chaine o) {
	}

	/**
	 * {@inheritDoc}
	 * var.enUS: currentGoal
	 * indexe: true
	 * stocke: true
	 */ 
	protected void _butActuel(Chaine o) {
	}

	/**
	 * {@inheritDoc}
	 * var.enUS: currentDosage
	 * indexe: true
	 * stocke: true
	 */ 
	protected void _doseActuel(Chaine o) {
	}

	/**
	 * {@inheritDoc}
	 * var.enUS: currentMedication
	 * indexe: true
	 * stocke: true
	 */ 
	protected void _medicamentActuel(Chaine o) {
	}

	/**
	 * {@inheritDoc}
	 * var.enUS: dosageChange
	 * indexe: true
	 * stocke: true
	 * r: FORMAT_dateMedicalCourt
	 * r.enUS: FORMAT_dateMedicalShort
	 */
	protected void _changementDose(Chaine o) {
		o.tout(dateInr.format(FORMAT_dateMedicalCourt), " INR @ ");
	}

	/**
	 * {@inheritDoc}
	 * var.enUS: additionalNotes
	 * indexe: true
	 * stocke: true
	 */
	protected void _notesComplementaires(Chaine o) {
	}

	/**
	 * {@inheritDoc}
	 * var.enUS: contactInfo
	 * indexe: true
	 * stocke: true
	 */ 
	protected void _infoContact(Chaine o) {
	}
}
