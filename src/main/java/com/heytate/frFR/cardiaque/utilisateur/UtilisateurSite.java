package com.heytate.frFR.cardiaque.utilisateur;

import java.time.ZonedDateTime;
import java.util.ArrayList;

import com.heytate.frFR.cardiac.utilisateur.UtilisateurSiteGen;
import com.heytate.frFR.cardiaque.couverture.Couverture;
import com.heytate.frFR.cardiaque.requete.RequeteSite;

public class UtilisateurSite extends UtilisateurSiteGen<Object> { 

	/**
	 * var.enUS: _siteRequest
	 */
	protected void _requeteSite(Couverture<RequeteSite> c) throws Exception {}

	/**	
	 * var.enUS: _teamKeys
	 * description.frFR: Les clés primaires qui liennent cet utilisateur à des équipes. 
	 * indexe: true
	 * stocke: true
	 */
	protected void _equipeCles(ArrayList<Long> o) throws Exception {
	}

	/**	
	 * var.enUS: _userName
	 * description.frFR: Le nom d'utilisateur pour se connecter au site. 
	 * indexe: true
	 * stocke: true
	 */
	protected void _utilisateurNom(Couverture<String> c) throws Exception {
	}

	/**	
	 * var.enUS: _userEmail
	 * description.frFR: Le mail pour recevoir des courriels. 
	 * indexe: true
	 * stocke: true
	 */
	protected void _utilisateurMail(Couverture<String> c) throws Exception {
	}

	/**	
	 * var.enUS: _userId
	 * description.frFR: L'identifiant Keycloak pour cet utilisateur. 
	 * indexe: true
	 * stocke: true
	 */
	protected void _utilisateurId(Couverture<String> c) throws Exception {
	}

	/**	
	 * var.enUS: _userFirstName
	 * description.frFR: Le prénom pour cet utilisateur. 
	 * indexe: true
	 * stocke: true
	 */
	protected void _utilisateurPrenom(Couverture<String> c) throws Exception {
	}

	/**	
	 * var.enUS: _userLastName
	 * description.frFR: Le nom de famille pour cet utilisateur. 
	 * indexe: true
	 * stocke: true
	 */
	protected void _utilisateurNomFamille(Couverture<String> c) throws Exception {
	}

	/**	
	 * var.enUS: _userFullName
	 * description.frFR: Le prénom et nom de famille pour cet utilisateur. 
	 * indexe: true
	 * stocke: true
	 * r: utilisateurPrenom
	 * r.enUS: userFirstName
	 * r: utilisateurNomFamille
	 * r.enUS: userLastName
	 */
	protected void _utilisateurNomComplet(Couverture<String> c) throws Exception {
		c.o(utilisateurPrenom + utilisateurNomFamille);
	}

	/**	
	 * var.enUS: _userSite
	 * description.frFR: L'URL du site Web pour cet utilisateur. 
	 * indexe: true
	 * stocke: true
	 */
	protected void _utilisateurSite(Couverture<String> c) throws Exception {
	}

	/**	
	 * var.enUS: _userReceiveEmails
	 * description.frFR: Le nom de famille pour cet utilisateur. 
	 * indexe: true
	 * stocke: true
	 */
	protected void _utilisateurRecevoirCourriels(Couverture<Boolean> c) throws Exception {
		c.o(false);
	}

	/**	
	 * var.enUS: _modelDeleted
	 * description.frFR: Marquer le modèle comme supprimé. 
	 * On ne devrait jamais actuellement supprimer de la base de données. 
	 * indexe: true
	 * stocke: true
	 */
	protected void _modeleSupprime(Couverture<Boolean> c) throws Exception {
		c.o(false);
	}

	/**	
	 * var.enUS: _modelCreated
	 * description.frFR: La date créée pour le modèle. 
	 * indexe: true
	 * stocke: true
	 */
	protected void _modeleCree(Couverture<ZonedDateTime> c) throws Exception {
		ZonedDateTime o = ZonedDateTime.now();
		c.o(o);
	}

	/**	
	 * var.enUS: _modelModified
	 * description.frFR: La date modifiée pour le modele. 
	 * indexe: true
	 * stocke: true
	 */
	protected void _modeleModifie(Couverture<ZonedDateTime> c) throws Exception {
		ZonedDateTime o = ZonedDateTime.now();
		c.o(o);
	}

	/**	
	 * var.enUS: _modelClassCanonicalName
	 * description.frFR: Le nom canonique de cette classe Java pour le modèle. 
	 * indexe: true
	 * stocke: true
	 */
	protected void _modeleClasseNomCanonique(Couverture<String> c) throws Exception {
		c.o(getClass().getCanonicalName());
	}

	/**	
	 * var.enUS: _modelKey
	 * description.frFR: Le clé primaire pour ce modèle dans la base de données. 
	 * indexe: true
	 * stocke: true
	 */
	protected void _modeleCle(Couverture<Long> c) throws Exception {
	}

	/**	
	 * var.enUS: _modelSuggestionStored
	 * description.frFR: Le texte de suggérée qui est affichée mais pas indexée dans le moteur de recherche. 
	 * indexe: true
	 * stocke: true
	 * r: utilisateurPrenom
	 * r.enUS: userFirstName
	 * r: utilisateurNomFamille
	 * r.enUS: userLastName
	 * r: utilisateurNom
	 * r.enUS: userName
	 */
	protected void _modeleSuggestionStocke(Couverture<String> c) throws Exception {
		c.o(utilisateurPrenom + " " + utilisateurNomFamille + " " + utilisateurNom);
	}

	/**	
	 * var.enUS: _modelSuggestionIndexed
	 * description.frFR: Le texte de suggérée qui est indexée dans le moteur de recherche. 
	 * Ça peut contenir plus qui est affiché dans le suggestion. 
	 * indexe: true
	 * stocke: true
	 * r: utilisateurPrenom
	 * r.enUS: userFirstName
	 * r: utilisateurNomFamille
	 * r.enUS: userLastName
	 * r: utilisateurNom
	 * r.enUS: userName
	 */
	protected void _modeleSuggestionIndexe(Couverture<String> c) throws Exception {
		c.o(utilisateurPrenom + " " + utilisateurNomFamille + " " + utilisateurNom);
	}
}
