
	// Recherche //

function rechercheCalculInr() {
	$.ajax({
		url: '/api/v1/warfarin/calcul-inr'
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

function postCalculInr() {
	$.ajax({
		url: '/api/v1/warfarin/calcul-inr'
		, dataType: 'json'
		, type: 'POST'
		, contentType: 'application/json; charset=utf-8'
		, data: JSON.stringify({})
		, success: function( data, textStatus, jQxhr ) {
		}
		, error: function( jqXhr, textStatus, errorThrown ) {
		}
	});
}

	// PATCH //

function patchCalculInr() {
	$.ajax({
		url: '/api/v1/warfarin/calcul-inr'
		, dataType: 'json'
		, type: 'PATCH'
		, contentType: 'application/json; charset=utf-8'
		, data: JSON.stringify({})
		, success: function( data, textStatus, jQxhr ) {
		}
		, error: function( jqXhr, textStatus, errorThrown ) {
		}
	});
}

	// GET //

function getCalculInr() {
	$.ajax({
		url: '/api/v1/warfarin/calcul-inr/{pk}'
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

function putCalculInr() {
	$.ajax({
		url: '/api/v1/warfarin/calcul-inr/{pk}'
		, dataType: 'json'
		, type: 'PUT'
		, contentType: 'application/json; charset=utf-8'
		, data: JSON.stringify({})
		, success: function( data, textStatus, jQxhr ) {
		}
		, error: function( jqXhr, textStatus, errorThrown ) {
		}
	});
}

	// DELETE //

function deleteCalculInr() {
	$.ajax({
		url: '/api/v1/warfarin/calcul-inr/{pk}'
		, dataType: 'json'
		, type: 'DELETE'
		, contentType: 'application/json; charset=utf-8'
		, data: JSON.stringify({})
		, success: function( data, textStatus, jQxhr ) {
		}
		, error: function( jqXhr, textStatus, errorThrown ) {
		}
	});
}
