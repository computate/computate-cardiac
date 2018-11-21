package org.computate.frFR.cardiaque.warfarin;  

import java.math.BigDecimal;
import java.time.LocalDate;

import org.computate.frFR.cardiaque.chaine.Chaine;
import org.computate.frFR.cardiaque.cluster.Cluster;
import org.computate.frFR.cardiaque.couverture.Couverture;



/**
 * modele: true
 * apiUri.frFR: /api/v1/warfarin/inr-entry
 */          
public class CalculInr extends CalculInrGen<Cluster> { 

	/**
	 * indexe: true
	 * stocke: true
	 */
	protected void _inrDate(Couverture<LocalDate> c) throws Exception {
		c.o(LocalDate.now());
	}

	/**
	 * var.enUS: currentDosageValue
	 * indexe: true
	 * stocke: true
	 */
	protected void _doseActuelValeur(Couverture<BigDecimal> c) throws Exception {
	}

	/**
	 * var.enUS: currentDosageText
	 * indexe: true
	 * stocke: true
	 */ 
	protected void _doseActuelTexte(Chaine o) throws Exception {
		o.tout(doseActuelValeur, "mg daily");
	}

	/**
	 * var.enUS: dosageChangeValue
	 * indexe: true
	 * stocke: true
	 */
	protected void _changementDoseValeur(Couverture<BigDecimal> c) throws Exception {
	}

	/**
	 * var.enUS: dosageChangeText
	 * indexe: true
	 * stocke: true
	 */
	protected void _changementDoseTexte(Chaine o) throws Exception {
		o.tout(inrDate.format(FORMAT_dateMedicalCourt), " INR @ ", changementDoseValeur, "- ");
	}
}
