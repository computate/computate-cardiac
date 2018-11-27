package org.computate.frFR.cardiaque.warfarin;  

import java.math.BigDecimal;
import java.time.LocalDate;

import org.computate.frFR.cardiaque.chaine.Chaine;
import org.computate.frFR.cardiaque.cluster.Cluster;
import org.computate.frFR.cardiaque.couverture.Couverture;



/** 
 * modele: true
 * apiUri.enUS: /api/v1/warfarin/inr-entry
 * apiUri.frFR: /api/v1/warfarin/calcul-inr
 * 
 * val.VAL_patientPrendCoumadinOui.frFR:Yes
 * val.VAL_patientPrendCoumadinNon.frFR:No
 * val.VAL_patientPrendCoumadinOuiDosageInitial.frFR:Yes, initial dosing
 * val.VAL_patientPrendCoumadinOuiRecommence.frFR:Yes, restarted
 * role.frFR: Doof
 */                   
public class CalculInr extends CalculInrGen<Cluster> {           

	/**
	 * indexe: true
	 * stocke: true
	 * attribuer.nomSimple: UtilisateurSite
	 */
	protected void _utilisateurPk(Couverture<Long> c) throws Exception {
	}

	/**
	 * indexe: true
	 * stocke: true
	 */
	protected void _dateInr(Couverture<LocalDate> c) throws Exception {
		c.o(LocalDate.now());
	}

	/**
	 * indexe: true
	 * stocke: true
	 */
	protected void _dateReverifier(Couverture<LocalDate> c) throws Exception {

	}

	/**
	 * var.enUS: currentDosageText
	 * indexe: true
	 * stocke: true
	 * option.vide.frFR:""
	 * option.oui.frFR:CalculInr.VAL_patientPrendCoumadinOui
	 * option.non.frFR:CalculInr.VAL_patientPrendCoumadinNon
	 * option.ouiDosageInitial.frFR:CalculInr.VAL_patientPrendCoumadinOuiDosageInitial
	 * option.ouiRecommence.frFR:CalculInr.VAL_patientPrendCoumadinOuiRecommence
	 */ 
	protected void _patientPrendCoumadin(Chaine o) throws Exception {
	}

	/**
	 * var.enUS: currentGoal
	 * indexe: true
	 * stocke: true
	 */ 
	protected void _butActuel(Chaine o) throws Exception {
	}

	/**
	 * var.enUS: currentDosage
	 * indexe: true
	 * stocke: true
	 */ 
	protected void _doseActuel(Chaine o) throws Exception {
	}

	/**
	 * var.enUS: currentMedication
	 * indexe: true
	 * stocke: true
	 */ 
	protected void _medicamentActuel(Chaine o) throws Exception {
	}

	/**
	 * var.enUS: dosageChange
	 * indexe: true
	 * stocke: true
	 */
	protected void _changementDose(Chaine o) throws Exception {
		o.tout(dateInr.format(FORMAT_dateMedicalCourt), " INR @ ");
	}

	/**
	 * var.enUS: additionalNotes
	 * indexe: true
	 * stocke: true
	 */
	protected void _notesComplementaires(Chaine o) throws Exception {
	}

	/**
	 * var.enUS: contactInfo
	 * indexe: true
	 * stocke: true
	 */
	protected void _infoContact(Chaine o) throws Exception {
	}
}
