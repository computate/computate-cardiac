
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
function postCalculInr(valeurs) {
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
 * Actualiser un ou plusiers calculs INR sans valuers qui change, 
 * ou changer des valeurs pour un ou plusiers le calcul INR. 
 * @param params: [ "q=*:*", "fq=pk:1", "sort=pk asc", "rows=1", "fl=pk" ]
 *        Une liste des opérations de recherche sur des calculs INR 
 *        pour rechercher "q=*:*", filtrer "fq=pk:1", trier "sort=pk desc", 
 *        limiter les résultats "rows=1", ou limiter les valeurs "fl=pk". 
 * @param valeurs Noms des champs et valeurs à changer selon les filtres fq. 
 *           Example: { pk: 1 }
 */
function patchCalculInr(params=[], valeurs={}) {
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
function putCalculInr(pk, valeurs) {
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
