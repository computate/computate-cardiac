
// Recherche //

/**
 */
function rechercheCalculInr() {
	$.ajax({
		url: '/api/v1/warfarin/calcul-inr' + (!params || params.length == 0 ? '' : '?' + params.join('&'))
		, dataType: 'json'
		, type: 'GET'
		, contentType: 'application/json; charset=utf-8'
		, success: function( data, textStatus, jQxhr ) {
		}
		, error: function( jqXhr, textStatus, errorThrown ) {
		}
	});
}

// POST //

/**
 */
function postCalculInr($formulaireValeurs) {
	var valeurs = {};

	var valeurPk = $formulaireValeurs.find('.valeurPk').val();
	if(valeurPk)
		valeurs['pk'] = valeurPk;

	var valeurSupprime = $formulaireValeurs.find('.valeurSupprime').val();
	if(valeurSupprime)
		valeurs['supprime'] = valeurSupprime;

	var valeurCree = $formulaireValeurs.find('.valeurCree').val();
	if(valeurCree)
		valeurs['cree'] = valeurCree;

	var valeurModifie = $formulaireValeurs.find('.valeurModifie').val();
	if(valeurModifie)
		valeurs['modifie'] = valeurModifie;

	var valeurDateInr = $formulaireValeurs.find('.valeurDateInr').val();
	if(valeurDateInr)
		valeurs['dateInr'] = valeurDateInr;

	var valeurDateReverifier = $formulaireValeurs.find('.valeurDateReverifier').val();
	if(valeurDateReverifier)
		valeurs['dateReverifier'] = valeurDateReverifier;

	var valeurPatientPrendCoumadin = $formulaireValeurs.find('.valeurPatientPrendCoumadin').val();
	if(valeurPatientPrendCoumadin)
		valeurs['patientPrendCoumadin'] = valeurPatientPrendCoumadin;

	var valeurDosageInitial = $formulaireValeurs.find('.valeurDosageInitial').val();
	if(valeurDosageInitial)
		valeurs['dosageInitial'] = valeurDosageInitial;

	var valeurDosageRecommence = $formulaireValeurs.find('.valeurDosageRecommence').val();
	if(valeurDosageRecommence)
		valeurs['dosageRecommence'] = valeurDosageRecommence;

	var valeurButActuel = $formulaireValeurs.find('.valeurButActuel').val();
	if(valeurButActuel)
		valeurs['butActuel'] = valeurButActuel;

	var valeurDoseActuel = $formulaireValeurs.find('.valeurDoseActuel').val();
	if(valeurDoseActuel)
		valeurs['doseActuel'] = valeurDoseActuel;

	var valeurMedicamentActuel = $formulaireValeurs.find('.valeurMedicamentActuel').val();
	if(valeurMedicamentActuel)
		valeurs['medicamentActuel'] = valeurMedicamentActuel;

	var valeurChangementDose = $formulaireValeurs.find('.valeurChangementDose').val();
	if(valeurChangementDose)
		valeurs['changementDose'] = valeurChangementDose;

	var valeurNotesComplementaires = $formulaireValeurs.find('.valeurNotesComplementaires').val();
	if(valeurNotesComplementaires)
		valeurs['notesComplementaires'] = valeurNotesComplementaires;

	var valeurInfoContact = $formulaireValeurs.find('.valeurInfoContact').val();
	if(valeurInfoContact)
		valeurs['infoContact'] = valeurInfoContact;

	$.ajax({
		url: '/api/v1/warfarin/calcul-inr'
		, dataType: 'json'
		, type: 'POST'
		, contentType: 'application/json; charset=utf-8'
		, data: JSON.stringify(valeurs)
		, success: function( data, textStatus, jQxhr ) {
		}
		, error: function( jqXhr, textStatus, errorThrown ) {
		}
	});
}

// PATCH //

/**
 * Modifier un ou plusiers calculs INR sans valuers qui change, 
 * ou changer des valeurs pour un ou plusiers le calcul INR. 
 * @param params: [ "q=*:*", "fq=pk:1", "sort=pk asc", "rows=1", "fl=pk" ]
 *        Une liste des opérations de recherche sur des calculs INR 
 *        pour rechercher "q=*:*", filtrer "fq=pk:1", trier "sort=pk desc", 
 *        limiter les résultats "rows=1", ou limiter les valeurs "fl=pk". 
 * @param valeurs Noms des champs et valeurs à changer selon les filtres fq. 
 *           Example: { pk: 1 }
 */
function patchCalculInr($formulaireFiltres, $formulaireValeurs) {
	var filtres = {};

	var filtrePk = $formulaireFiltres.find('.valeurPk').val();
	if(filtrePk)
		filtres['pk'] = valeurPk;

	var filtreSupprime = $formulaireFiltres.find('.valeurSupprime').val();
	if(filtreSupprime)
		filtres['supprime'] = valeurSupprime;

	var filtreCree = $formulaireFiltres.find('.valeurCree').val();
	if(filtreCree)
		filtres['cree'] = valeurCree;

	var filtreModifie = $formulaireFiltres.find('.valeurModifie').val();
	if(filtreModifie)
		filtres['modifie'] = valeurModifie;

	var filtreDateInr = $formulaireFiltres.find('.valeurDateInr').val();
	if(filtreDateInr)
		filtres['dateInr'] = valeurDateInr;

	var filtreDateReverifier = $formulaireFiltres.find('.valeurDateReverifier').val();
	if(filtreDateReverifier)
		filtres['dateReverifier'] = valeurDateReverifier;

	var filtrePatientPrendCoumadin = $formulaireFiltres.find('.valeurPatientPrendCoumadin').val();
	if(filtrePatientPrendCoumadin)
		filtres['patientPrendCoumadin'] = valeurPatientPrendCoumadin;

	var filtreDosageInitial = $formulaireFiltres.find('.valeurDosageInitial').val();
	if(filtreDosageInitial)
		filtres['dosageInitial'] = valeurDosageInitial;

	var filtreDosageRecommence = $formulaireFiltres.find('.valeurDosageRecommence').val();
	if(filtreDosageRecommence)
		filtres['dosageRecommence'] = valeurDosageRecommence;

	var filtreButActuel = $formulaireFiltres.find('.valeurButActuel').val();
	if(filtreButActuel)
		filtres['butActuel'] = valeurButActuel;

	var filtreDoseActuel = $formulaireFiltres.find('.valeurDoseActuel').val();
	if(filtreDoseActuel)
		filtres['doseActuel'] = valeurDoseActuel;

	var filtreMedicamentActuel = $formulaireFiltres.find('.valeurMedicamentActuel').val();
	if(filtreMedicamentActuel)
		filtres['medicamentActuel'] = valeurMedicamentActuel;

	var filtreChangementDose = $formulaireFiltres.find('.valeurChangementDose').val();
	if(filtreChangementDose)
		filtres['changementDose'] = valeurChangementDose;

	var filtreNotesComplementaires = $formulaireFiltres.find('.valeurNotesComplementaires').val();
	if(filtreNotesComplementaires)
		filtres['notesComplementaires'] = valeurNotesComplementaires;

	var filtreInfoContact = $formulaireFiltres.find('.valeurInfoContact').val();
	if(filtreInfoContact)
		filtres['infoContact'] = valeurInfoContact;

	var patchs = {};

	var setPk = $formulaireValeurs.find('.setPk').val();
	if(setPk)
		patchs['setPk'] = setPk;
	var addPk = $formulaireValeurs.find('.addPk').val();
	if(addPk)
		patchs['addPk'] = addPk;
	var removePk = $formulaireValeurs.find('.removePk').val();
	if(removePk)
		patchs['removePk'] = removePk;

	var setSupprime = $formulaireValeurs.find('.setSupprime').val();
	if(setSupprime)
		patchs['setSupprime'] = setSupprime;
	var addSupprime = $formulaireValeurs.find('.addSupprime').val();
	if(addSupprime)
		patchs['addSupprime'] = addSupprime;
	var removeSupprime = $formulaireValeurs.find('.removeSupprime').val();
	if(removeSupprime)
		patchs['removeSupprime'] = removeSupprime;

	var setCree = $formulaireValeurs.find('.setCree').val();
	if(setCree)
		patchs['setCree'] = setCree;
	var addCree = $formulaireValeurs.find('.addCree').val();
	if(addCree)
		patchs['addCree'] = addCree;
	var removeCree = $formulaireValeurs.find('.removeCree').val();
	if(removeCree)
		patchs['removeCree'] = removeCree;

	var setModifie = $formulaireValeurs.find('.setModifie').val();
	if(setModifie)
		patchs['setModifie'] = setModifie;
	var addModifie = $formulaireValeurs.find('.addModifie').val();
	if(addModifie)
		patchs['addModifie'] = addModifie;
	var removeModifie = $formulaireValeurs.find('.removeModifie').val();
	if(removeModifie)
		patchs['removeModifie'] = removeModifie;

	var setDateInr = $formulaireValeurs.find('.setDateInr').val();
	if(setDateInr)
		patchs['setDateInr'] = setDateInr;
	var addDateInr = $formulaireValeurs.find('.addDateInr').val();
	if(addDateInr)
		patchs['addDateInr'] = addDateInr;
	var removeDateInr = $formulaireValeurs.find('.removeDateInr').val();
	if(removeDateInr)
		patchs['removeDateInr'] = removeDateInr;

	var setDateReverifier = $formulaireValeurs.find('.setDateReverifier').val();
	if(setDateReverifier)
		patchs['setDateReverifier'] = setDateReverifier;
	var addDateReverifier = $formulaireValeurs.find('.addDateReverifier').val();
	if(addDateReverifier)
		patchs['addDateReverifier'] = addDateReverifier;
	var removeDateReverifier = $formulaireValeurs.find('.removeDateReverifier').val();
	if(removeDateReverifier)
		patchs['removeDateReverifier'] = removeDateReverifier;

	var setPatientPrendCoumadin = $formulaireValeurs.find('.setPatientPrendCoumadin').val();
	if(setPatientPrendCoumadin)
		patchs['setPatientPrendCoumadin'] = setPatientPrendCoumadin;
	var addPatientPrendCoumadin = $formulaireValeurs.find('.addPatientPrendCoumadin').val();
	if(addPatientPrendCoumadin)
		patchs['addPatientPrendCoumadin'] = addPatientPrendCoumadin;
	var removePatientPrendCoumadin = $formulaireValeurs.find('.removePatientPrendCoumadin').val();
	if(removePatientPrendCoumadin)
		patchs['removePatientPrendCoumadin'] = removePatientPrendCoumadin;

	var setDosageInitial = $formulaireValeurs.find('.setDosageInitial').val();
	if(setDosageInitial)
		patchs['setDosageInitial'] = setDosageInitial;
	var addDosageInitial = $formulaireValeurs.find('.addDosageInitial').val();
	if(addDosageInitial)
		patchs['addDosageInitial'] = addDosageInitial;
	var removeDosageInitial = $formulaireValeurs.find('.removeDosageInitial').val();
	if(removeDosageInitial)
		patchs['removeDosageInitial'] = removeDosageInitial;

	var setDosageRecommence = $formulaireValeurs.find('.setDosageRecommence').val();
	if(setDosageRecommence)
		patchs['setDosageRecommence'] = setDosageRecommence;
	var addDosageRecommence = $formulaireValeurs.find('.addDosageRecommence').val();
	if(addDosageRecommence)
		patchs['addDosageRecommence'] = addDosageRecommence;
	var removeDosageRecommence = $formulaireValeurs.find('.removeDosageRecommence').val();
	if(removeDosageRecommence)
		patchs['removeDosageRecommence'] = removeDosageRecommence;

	var setButActuel = $formulaireValeurs.find('.setButActuel').val();
	if(setButActuel)
		patchs['setButActuel'] = setButActuel;
	var addButActuel = $formulaireValeurs.find('.addButActuel').val();
	if(addButActuel)
		patchs['addButActuel'] = addButActuel;
	var removeButActuel = $formulaireValeurs.find('.removeButActuel').val();
	if(removeButActuel)
		patchs['removeButActuel'] = removeButActuel;

	var setDoseActuel = $formulaireValeurs.find('.setDoseActuel').val();
	if(setDoseActuel)
		patchs['setDoseActuel'] = setDoseActuel;
	var addDoseActuel = $formulaireValeurs.find('.addDoseActuel').val();
	if(addDoseActuel)
		patchs['addDoseActuel'] = addDoseActuel;
	var removeDoseActuel = $formulaireValeurs.find('.removeDoseActuel').val();
	if(removeDoseActuel)
		patchs['removeDoseActuel'] = removeDoseActuel;

	var setMedicamentActuel = $formulaireValeurs.find('.setMedicamentActuel').val();
	if(setMedicamentActuel)
		patchs['setMedicamentActuel'] = setMedicamentActuel;
	var addMedicamentActuel = $formulaireValeurs.find('.addMedicamentActuel').val();
	if(addMedicamentActuel)
		patchs['addMedicamentActuel'] = addMedicamentActuel;
	var removeMedicamentActuel = $formulaireValeurs.find('.removeMedicamentActuel').val();
	if(removeMedicamentActuel)
		patchs['removeMedicamentActuel'] = removeMedicamentActuel;

	var setChangementDose = $formulaireValeurs.find('.setChangementDose').val();
	if(setChangementDose)
		patchs['setChangementDose'] = setChangementDose;
	var addChangementDose = $formulaireValeurs.find('.addChangementDose').val();
	if(addChangementDose)
		patchs['addChangementDose'] = addChangementDose;
	var removeChangementDose = $formulaireValeurs.find('.removeChangementDose').val();
	if(removeChangementDose)
		patchs['removeChangementDose'] = removeChangementDose;

	var setNotesComplementaires = $formulaireValeurs.find('.setNotesComplementaires').val();
	if(setNotesComplementaires)
		patchs['setNotesComplementaires'] = setNotesComplementaires;
	var addNotesComplementaires = $formulaireValeurs.find('.addNotesComplementaires').val();
	if(addNotesComplementaires)
		patchs['addNotesComplementaires'] = addNotesComplementaires;
	var removeNotesComplementaires = $formulaireValeurs.find('.removeNotesComplementaires').val();
	if(removeNotesComplementaires)
		patchs['removeNotesComplementaires'] = removeNotesComplementaires;

	var setInfoContact = $formulaireValeurs.find('.setInfoContact').val();
	if(setInfoContact)
		patchs['setInfoContact'] = setInfoContact;
	var addInfoContact = $formulaireValeurs.find('.addInfoContact').val();
	if(addInfoContact)
		patchs['addInfoContact'] = addInfoContact;
	var removeInfoContact = $formulaireValeurs.find('.removeInfoContact').val();
	if(removeInfoContact)
		patchs['removeInfoContact'] = removeInfoContact;

	$.ajax({
		url: '/api/v1/warfarin/calcul-inr' + (!params || params.length == 0 ? '' : '?' + params.join('&'))
		, dataType: 'json'
		, type: 'PATCH'
		, contentType: 'application/json; charset=utf-8'
		, data: JSON.stringify(valeurs)
		, success: function( data, textStatus, jQxhr ) {
		}
		, error: function( jqXhr, textStatus, errorThrown ) {
		}
	});
}

// GET //

/**
 */
function getCalculInr(pk) {
	$.ajax({
		url: '/api/v1/warfarin/calcul-inr/' + pk
		, dataType: 'json'
		, type: 'GET'
		, contentType: 'application/json; charset=utf-8'
		, success: function( data, textStatus, jQxhr ) {
		}
		, error: function( jqXhr, textStatus, errorThrown ) {
		}
	});
}

// PUT //

/**
 */
function putCalculInr(pk, $formulaireValeurs) {
	var valeurs = {};

	var valeurPk = $formulaireValeurs.find('.valeurPk').val();
	if(valeurPk)
		valeurs['pk'] = valeurPk;

	var valeurSupprime = $formulaireValeurs.find('.valeurSupprime').val();
	if(valeurSupprime)
		valeurs['supprime'] = valeurSupprime;

	var valeurCree = $formulaireValeurs.find('.valeurCree').val();
	if(valeurCree)
		valeurs['cree'] = valeurCree;

	var valeurModifie = $formulaireValeurs.find('.valeurModifie').val();
	if(valeurModifie)
		valeurs['modifie'] = valeurModifie;

	var valeurDateInr = $formulaireValeurs.find('.valeurDateInr').val();
	if(valeurDateInr)
		valeurs['dateInr'] = valeurDateInr;

	var valeurDateReverifier = $formulaireValeurs.find('.valeurDateReverifier').val();
	if(valeurDateReverifier)
		valeurs['dateReverifier'] = valeurDateReverifier;

	var valeurPatientPrendCoumadin = $formulaireValeurs.find('.valeurPatientPrendCoumadin').val();
	if(valeurPatientPrendCoumadin)
		valeurs['patientPrendCoumadin'] = valeurPatientPrendCoumadin;

	var valeurDosageInitial = $formulaireValeurs.find('.valeurDosageInitial').val();
	if(valeurDosageInitial)
		valeurs['dosageInitial'] = valeurDosageInitial;

	var valeurDosageRecommence = $formulaireValeurs.find('.valeurDosageRecommence').val();
	if(valeurDosageRecommence)
		valeurs['dosageRecommence'] = valeurDosageRecommence;

	var valeurButActuel = $formulaireValeurs.find('.valeurButActuel').val();
	if(valeurButActuel)
		valeurs['butActuel'] = valeurButActuel;

	var valeurDoseActuel = $formulaireValeurs.find('.valeurDoseActuel').val();
	if(valeurDoseActuel)
		valeurs['doseActuel'] = valeurDoseActuel;

	var valeurMedicamentActuel = $formulaireValeurs.find('.valeurMedicamentActuel').val();
	if(valeurMedicamentActuel)
		valeurs['medicamentActuel'] = valeurMedicamentActuel;

	var valeurChangementDose = $formulaireValeurs.find('.valeurChangementDose').val();
	if(valeurChangementDose)
		valeurs['changementDose'] = valeurChangementDose;

	var valeurNotesComplementaires = $formulaireValeurs.find('.valeurNotesComplementaires').val();
	if(valeurNotesComplementaires)
		valeurs['notesComplementaires'] = valeurNotesComplementaires;

	var valeurInfoContact = $formulaireValeurs.find('.valeurInfoContact').val();
	if(valeurInfoContact)
		valeurs['infoContact'] = valeurInfoContact;

	$.ajax({
		url: '/api/v1/warfarin/calcul-inr/' + pk
		, dataType: 'json'
		, type: 'PUT'
		, contentType: 'application/json; charset=utf-8'
		, data: JSON.stringify(valeurs)
		, success: function( data, textStatus, jQxhr ) {
		}
		, error: function( jqXhr, textStatus, errorThrown ) {
		}
	});
}

// DELETE //

/**
 */
function deleteCalculInr(pk) {
	$.ajax({
		url: '/api/v1/warfarin/calcul-inr/' + pk
		, dataType: 'json'
		, type: 'DELETE'
		, contentType: 'application/json; charset=utf-8'
		, data: JSON.stringify(valeurs)
		, success: function( data, textStatus, jQxhr ) {
		}
		, error: function( jqXhr, textStatus, errorThrown ) {
		}
	});
}
