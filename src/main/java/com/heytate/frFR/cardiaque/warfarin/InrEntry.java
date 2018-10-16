package com.heytate.frFR.cardiaque.warfarin; 

import java.math.BigDecimal;
import java.time.LocalDate;

import com.heytate.frFR.cardiac.chaine.Chaine;
import com.heytate.frFR.cardiaque.cluster.Cluster;
import com.heytate.frFR.cardiaque.couverture.Couverture;

/**
 * modele: true
 */
public class InrEntry extends InrEntryGen<Cluster> { 

	protected void _inrDate(Couverture<LocalDate> c) throws Exception {
		c.o(LocalDate.now());
	}

	/**
	 * var.enUS: currentDosageValue
	 */
	protected void _doseActuelValeur(Couverture<BigDecimal> c) throws Exception {
	}

	/**
	 * var.enUS: currentDosageText
	 */
	protected void _doseActuelTexte(Chaine o) throws Exception {
		o.tout(doseActuelValeur, "mg daily");
	}

	/**
	 * var.enUS: dosageChangeValue
	 */
	protected void _changementDoseValeur(Couverture<BigDecimal> c) throws Exception {
	}

	/**
	 * var.enUS: dosageChangeText
	 */
	protected void _changementDoseTexte(Chaine o) throws Exception {
		o.tout(inrDate.format(FORMAT_dateMedicalCourt), " INR @ ", changementDoseValeur, "- ");
	}
}
