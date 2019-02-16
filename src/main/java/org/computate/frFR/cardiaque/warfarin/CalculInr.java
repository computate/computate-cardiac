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
 * UnNomMinuscule.frFR: un calcul INR
 * NomPluriel.frFR: calculs INR
 * Couleur: green
 * IconeGroupe: regular
 * IconeNom: clinic-medical
 * Page: true
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
	 * HtmlLigne: 3
	 * Description.frFR: Date du calcul INR. 
	 * Description.enUS: INR Entry Date. 
	 * NomAffichage.frFR: Date INR
	 * NomAffichage.enUS: INR Date
	 */
	protected void _dateInr(Couverture<LocalDate> c) {
		c.o(LocalDate.now());
	}

	/**
	 * {@inheritDoc}
	 * Indexe: true
	 * Stocke: true
	 * HtmlLigne: 3
	 * Description.frFR: Date à reverifier. 
	 * Description.enUS: Date to reverify. 
	 * NomAffichage.frFR: Date à reverifier
	 * NomAffichage.enUS: Date to reverify
	 */
	protected void _dateReverifier(Couverture<LocalDate> c) {

	}

	/**
	 * {@inheritDoc}
	 * Var.enUS: currentDosageText
	 * Indexe: true
	 * Stocke: true
	 * Description.frFR: Le patient prend coumadin. 
	 * Description.enUS: The patient takes coumadin. 
	 * NomAffichage.frFR: Patient prend coumadin
	 * NomAffichage.enUS: Patient takes coumadin
	 * HtmlLigne: 4
	 */ 
	protected void _patientPrendCoumadin(Couverture<Boolean> c) {
	}

	/**
	 * {@inheritDoc}
	 * Var.enUS: currentDosageText
	 * Indexe: true
	 * Stocke: true
	 * Description.frFR: Dosage initial. 
	 * Description.enUS: Initial dosage. 
	 * NomAffichage.frFR: dosage initial
	 * NomAffichage.enUS: initial dose
	 * HtmlLigne: 4
	 */ 
	protected void _dosageInitial(Couverture<Boolean> c) {
	}

	/**
	 * {@inheritDoc}
	 * Var.enUS: doseRestarted
	 * Indexe: true
	 * Stocke: true
	 * Description.frFR: Dosage recommencé. 
	 * Description.enUS: Dose restarted. 
	 * NomAffichage.frFR: Dosage recommencé
	 * NomAffichage.enUS: Dose restarted
	 * HtmlLigne: 4
	 */ 
	protected void _dosageRecommence(Couverture<Boolean> c) {
	}

	/**
	 * {@inheritDoc}
	 * Var.enUS: currentGoal
	 * Indexe: true
	 * Stocke: true
	 * HtmlLigne: 4
	 * Description.frFR: But actuel. 
	 * Description.enUS: Actual goal. 
	 * NomAffichage.frFR: But actuel
	 * NomAffichage.enUS: Actual goal
	 */ 
	protected void _butActuel(Chaine o) {
	}

	/**
	 * {@inheritDoc}
	 * Var.enUS: currentDosage
	 * Indexe: true
	 * Stocke: true
	 * HtmlLigne: 5
	 * Description.frFR: Dose actuel. 
	 * Description.enUS: Actual dosage. 
	 * NomAffichage.frFR: Dose actuel
	 * NomAffichage.enUS: Actual dosage
	 */ 
	protected void _doseActuel(Chaine o) {
	}

	/**
	 * {@inheritDoc}
	 * Var.enUS: currentMedication
	 * Indexe: true
	 * Stocke: true
	 * HtmlLigne: 5
	 * Description.frFR: Medicament actuel. 
	 * Description.enUS: Current medication. 
	 * NomAffichage.frFR: Dose actuel
	 * NomAffichage.enUS: Actual dose
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
	 * HtmlLigne: 6
	 * Description.frFR: Changement de dose. 
	 * Description.enUS: Dosage change. 
	 * NomAffichage.frFR: Changement de dose
	 * NomAffichage.enUS: Dosage change
	 */
	protected void _changementDose(Chaine o) {
		o.s(dateInr.format(FORMAT_dateMedicalCourt), " INR @ ");
	}    

	/**
	 * {@inheritDoc}
	 * Var.enUS: additionalNotes
	 * Indexe: true
	 * Stocke: true
	 * HtmlLigne: 6
	 * Description.frFR: Notes complémentaires. 
	 * Description.enUS: Additional notes. 
	 * NomAffichage.frFR: Notes complémentaires
	 * NomAffichage.enUS: Additional notes
	 */
	protected void _notesComplementaires(Chaine o) {
	}

	/**
	 * {@inheritDoc}
	 * Var.enUS: contactInfo
	 * Indexe: true
	 * Stocke: true
	 * HtmlLigne: 7
	 * Description.frFR: Info contact. 
	 * Description.enUS: Contact info. 
	 * NomAffichage.frFR: Info contact
	 * NomAffichage.enUS: Contact info
	 */ 
	protected void _infoContact(Chaine o) {
	}

	/**
	 * {@inheritDoc}
	 * 
	 **/
	protected void _pageH2(Chaine o) {
		o.s(strDateInr());
	}
}
