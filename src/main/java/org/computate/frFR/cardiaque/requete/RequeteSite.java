package org.computate.frFR.cardiaque.requete;  

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;
import java.util.Stack;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.computate.frFR.cardiaque.config.ConfigSite;
import org.computate.frFR.cardiaque.contexte.SiteContexte;
import org.computate.frFR.cardiaque.couverture.Couverture;
import org.computate.frFR.cardiaque.utilisateur.UtilisateurSite;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.auth.User;
import io.vertx.ext.auth.oauth2.KeycloakHelper;
import io.vertx.ext.web.RoutingContext;

public class RequeteSite extends RequeteSiteGen<Object> implements Serializable {    
	private static final long serialVersionUID = -6737494107881513257L;

	/**	L'ecouteur de contexte du site pour obtenir des objets globals du contexte. **/
	protected void _siteContexte_(Couverture<SiteContexte> c) throws Exception {
	}

	protected void _vertx_(Couverture<Vertx> c) throws Exception {
		c.o(siteContexte_.getVertx_());
	}

	protected void _contexteItineraire_(Couverture<RoutingContext> c) throws Exception {
	}

	protected void _rechercheSolr_(Couverture<SolrQuery> c) throws Exception {
	}

	/**	L'objet de configuration du site. **/
	protected void _configSite_(Couverture<ConfigSite> c) throws Exception {
		ConfigSite o = siteContexte_.getConfigSite();
		c.o(o);
	}

	protected void _reponseRecherche(Couverture<QueryResponse> c) throws Exception {
		if(rechercheSolr_ != null) {
			QueryResponse o = siteContexte_.getClientSolr().query(rechercheSolr_);
			c.o(o);
		}
	}

	protected void _resultatsRecherche(Couverture<SolrDocumentList> c) throws Exception {
		if(reponseRecherche != null) {
			SolrDocumentList o = reponseRecherche.getResults();
			c.o(o);
		}
	}

	protected void _requeteSite_(Couverture<RequeteSite> c) throws Exception { 
		c.o(this);
	}

	/**	Le HttpServletRequest du requête. **/
	protected void _requeteServeur(Couverture<HttpServerRequest> c) throws Exception {
		if(contexteItineraire_ != null) {
			HttpServerRequest o = contexteItineraire_.request();
			c.o(o);
		}
	}

	/**	Le HttpServletResponse du requête. **/
	protected void _reponseServeur(Couverture<HttpServerResponse> c) throws Exception { 
		if(contexteItineraire_ != null) {
			HttpServerResponse o = contexteItineraire_.response();
			c.o(o);
		}
	}
//
//	protected void _siteIdKeycloak(Couverture<String> c) throws Exception {
//		String o = configSite_.siteIdKeycloak;
//		c.o(o);
//	}
//
//	/**	Le jeton d'acces Keycloak pour l'utilisateur. **/
//	protected void _jetonAcces(Couverture<AccessToken> c) throws Exception {
//	}

	protected void _utilisateurVertx(Couverture<User> c) throws Exception {
		if(contexteItineraire_ != null) {
			User o = contexteItineraire_.user();
			c.o(o);
		}

	}

	protected void _principalJson(Couverture<JsonObject> c) throws Exception {
//		if(jetonAcces != null) {
//			JsonObject o = jetonAcces.principal();
//			c.o(o);
//		}
		if(utilisateurVertx != null) {
			JsonObject o = utilisateurVertx.principal();
			c.o(o);
		}
	}
	
	protected void _utilisateurNomDomaine(Couverture<String> c) {
		String o = principalJson == null ? "example.com" : null;
		c.o(o);
	}
	
	protected void _utilisateurNomEnsemble(Couverture<String> c) {
		String[] partis = StringUtils.split(utilisateurNomDomaine, ".");
		ArrayUtils.reverse(partis);
		String o = StringUtils.join(partis, ".");
		c.o(o);
	}

	/**	L'utilisateur de la requête. **/
	protected void _utilisateurSite(Couverture<UtilisateurSite> c) throws Exception { 
	}

	/**	Le sujet d'acces Keycloak pour l'utilisateur. 
	 \*	Aussi l'ID d'utilisateur cle primaire dans la base de donnees Keycloak. **/
	protected void _utilisateurId(Couverture<String> c) throws Exception {
		if(principalJson != null) {
			String o = KeycloakHelper.rawIdToken(principalJson);
//			String o = jetonAcces.getSubject();
			c.o(o);
		}
	}

	/**	Le nom d'utilisateur prefere de l'utilisateur. **/
	protected void _utilisateurNom(Couverture<String> c) throws Exception {
		if(principalJson != null) {
			String o = KeycloakHelper.preferredUsername(principalJson);
//			String o = jetonAcces.getPreferredUsername();
			c.o(o);
		}
	}

	/**	Le nom de famille de l'utilisateur. **/
	protected void _utilisateurNomFamille(Couverture<String> c) throws Exception {
		if(principalJson != null) {
			String o = KeycloakHelper.name(principalJson);
//			String o = jetonAcces.getFamilyName();
			c.o(o);
		}
	}

	/**	Le prenom de l'utilisateur. **/
	protected void _utilisateurPrenom(Couverture<String> c) throws Exception { 
		if(principalJson != null) {
			String o = KeycloakHelper.name(principalJson);
			c.o(o);
		}
	}

	/**	Le nom complet de l'utilisateur. **/
	protected void _utilisateurNomComplet(Couverture<String> c) throws Exception {
		if(principalJson != null) {
			String o = KeycloakHelper.name(principalJson);
			c.o(o);
		}
	}
//
//	/**	Les rôles du royaume de l'utilisateur. **/ 
//	protected void _utilisateurRolesRoyaume(HashSet<String> o) throws Exception {  
//		if(jetonAcces != null) {
//			Set<String> s = jetonAcces.getRealmAccess().getRoles();
//			o.addAll(s);
//		}
//	}
//	public boolean utilisateurRolesRoyaumeContient(String role) {
//		boolean o = false;
//		if(utilisateurRolesRoyaume != null) { 
//			o = utilisateurRolesRoyaume.contains(role);
//		}
//		return o;
//	}
//
//	/**	Les rôles de la ressource de l'utilisateur. **/
//	protected void _utilisateurRolesRessource(HashSet<String> o) throws Exception {
//		if(configSite_ != null) {
//			if(siteIdKeycloak != null && jetonAcces != null) {
//				Access utilisateurAccesRessource = jetonAcces.getResourceAccess(siteIdKeycloak);
//				if(utilisateurAccesRessource != null && jetonAcces != null) {
//					Set<String> s = utilisateurAccesRessource.getRoles();
//					o.addAll(s);
//				}
//			}
//		}
//	}
//	public boolean utilisateurRolesRessourceContient(String role) {
//		boolean o = false;
//		if(utilisateurRolesRessource != null) {
//			o = utilisateurRolesRessource.contains(role);
//		}
//		return o;
//	}
//
//	public boolean utilisateurRolesContient(String role) {
//		boolean o = 
//			utilisateurRolesRoyaume != null && utilisateurRolesRoyaume.contains(role)
//			|| utilisateurRolesRessource != null && utilisateurRolesRessource.contains(role)
//		;
//		return o;
//	}

	protected void _xmlPile(Stack<String> o) {}
//
//	protected void _xmlElementParent(Couverture<String> c) {}
//
//	protected void _xmlElement(Couverture<String> c) {}

	protected void _solrDocument(Couverture<SolrDocument> c) throws Exception {  
	}

	/**	Si la page vu etait achete par l'utilisateur. **/
	protected void _pageAchete(Couverture<Boolean> c) throws Exception { 
		c.o(false);
	}

	/**	Si la page vu etait achete par l'utilisateur. **/
	protected void _pageAdmin(Couverture<Boolean> c) throws Exception { 
		c.o(false);
	}
	
	protected void _h(Couverture<String> c) throws Exception {}
	
	protected void _chiffrementCrypter(Couverture<Cipher> c) throws Exception {
		if(!StringUtils.isEmpty(h)) {
			c.o(Cipher.getInstance("AES"));
		}
	}
	
	protected void _chiffrementDecrypter(Couverture<Cipher> c) throws Exception {
		if(!StringUtils.isEmpty(h)) {
			c.o(Cipher.getInstance("AES"));
		}
	}
	
	protected void _digestMessage(Couverture<MessageDigest> c) throws Exception {    
		if(!StringUtils.isEmpty(h)) {
			c.o(MessageDigest.getInstance("SHA-1"));
		}
	}
	
	protected void _crypterSel(Couverture<String> c) throws Exception {
	}
	
	protected void _requetePk(Couverture<Long> c) throws Exception {
	}
	
	protected void _crypterCle(Couverture<byte[]> c) throws Exception {
		if(!StringUtils.isEmpty(h)) {
			c.o(Arrays.copyOf(digestMessage.digest((crypterSel + h).getBytes("UTF-8")), 16));
		}
	}
	
	protected void _aleatoireSecurise(SecureRandom o) throws Exception {}  
	
	protected void _specCleSecrete(Couverture<SecretKeySpec> c) throws Exception {
		if(!StringUtils.isEmpty(h)) {
			SecretKeySpec specCleSecrete = new SecretKeySpec(crypterCle, "AES");
			chiffrementCrypter.init(Cipher.ENCRYPT_MODE, specCleSecrete);
			chiffrementDecrypter.init(Cipher.DECRYPT_MODE, specCleSecrete);
			c.o(specCleSecrete);
		}
	}
	
	public byte[] crypterOctets(String o) throws Exception {
		byte[] octetsNonCrypte = o.getBytes();
		byte[] encryptedByte = null;
		encryptedByte = chiffrementCrypter.doFinal(octetsNonCrypte);
		return encryptedByte;
	}
	
	public String decrypterOctets(byte[] octetsCrypte) throws Exception {
		String texteNonCrypte = null;
		byte[] decryptedByte = chiffrementDecrypter.doFinal(octetsCrypte);
		texteNonCrypte = new String(decryptedByte);
		return texteNonCrypte;
	}
	
	public String crypterStr(String o) throws Exception {
		String texteCrypte = null;     
		if(chiffrementCrypter != null) {
			byte[] octetsNonCrypte = o.getBytes();
			byte[] encryptedByte = chiffrementCrypter.doFinal(octetsNonCrypte);
			Base64.Encoder codeur = Base64.getEncoder();
			texteCrypte = codeur.encodeToString(encryptedByte);
		}
		return texteCrypte;
	}
	
	public String decrypterStr(String o) throws Exception {
		String texteNonCrypte = null;
		if(o != null && chiffrementDecrypter != null) {
			Base64.Decoder decodeur = Base64.getDecoder();
			byte[] octetsCrypte = decodeur.decode(o);
			byte[] decryptedByte = chiffrementDecrypter.doFinal(octetsCrypte);
			texteNonCrypte = new String(decryptedByte);
		}
		return texteNonCrypte;
	}
//
//	@org.junit.Test public void genererClasseChaine() throws Exception {
//		SiteContexte SiteContexte = new SiteContexte();
//		SiteContexte.initialiserLoinSiteContexte();
//
//		LangueSite langue = new LangueSite();
//		langue.identifiant("frFR");
//		langue.initialiserLoinLangueSite();
//
//		RequeteSite requeteSite = new RequeteSite();
//		requeteSite.langue(langue);
//		requeteSite.initialiserLoinRequeteSite();
//
//		GenerateurClasse generateurClasse = new GenerateurClasse();
//		generateurClasse.configCheminuration(SiteContexte.configChemin);
//		String cheminRessource = SiteContexte.configSite.appliChemin + "/src/main/java/" + getClass().getCanonicalName().replace(".", "/") + ".java";
//		generateurClasse.requeteSite(requeteSite);
//		generateurClasse.cheminRessource(cheminRessource);
//		generateurClasse.initialiserLoinGenerateurClasse(requeteSite);
//		System.out.println(generateurClasse.texteClasse.toString());
//	}
}
