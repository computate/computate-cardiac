package org.computate.frFR.cardiaque.ecrivain;   

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.computate.frFR.cardiaque.couverture.Couverture;
import org.computate.frFR.cardiaque.requete.RequeteSite;

import io.vertx.core.http.HttpServerResponse;


/**  
 * nomCanonique.enUS: org.computate.enUS.cardiac.writer.AllWriter
 **/
public class ToutEcrivain extends ToutEcrivainGen<Object> {    

	/**
	 * 
	 * {@inheritDoc}
	 **/ 
	protected void _requeteSite_(Couverture<RequeteSite> c) {
	}

	/**
	 * {@inheritDoc}
	 * var.enUS: create
	 * param1.var.enUS: siteRequest
	 * r: initLoinPourClasse
	 * r.enUS: initDeepForClass
	 * r: requeteSite
	 * r.enUS: siteRequest
	 * r: ToutEcrivain
	 * r.enUS: AllWriter
	 */
	public static ToutEcrivain creer(RequeteSite requeteSite) throws Exception {
		ToutEcrivain o = new ToutEcrivain();
		o.initLoinPourClasse(requeteSite);
		return o;
	}

	/**
	 * {@inheritDoc}
	 * var.enUS: create
	 * param1.var.enUS: siteRequest
	 * param2.var.enUS: fichier
	 * r: Fichier
	 * r.enUS: File
	 * r: fichier
	 * r.enUS: file
	 * r: initLoinPourClasse
	 * r.enUS: initDeepForClass
	 * r: requeteSite
	 * r.enUS: siteRequest
	 * r: ToutEcrivain
	 * r.enUS: AllWriter
	 */
	public static ToutEcrivain creer(RequeteSite requeteSite, File fichier) throws Exception {
		ToutEcrivain o = new ToutEcrivain();
		o.setFichier(fichier);
		o.initLoinPourClasse(requeteSite);
		return o;
	}

	/**
	 * {@inheritDoc}
	 * var.enUS: fichier
	 **/
	protected void _fichier(Couverture<File> c) {
	}

	/**
	 * var.enUS: stringWriter
	 * r: fichier
	 * r.enUS: file
	 * r: ecrivainString
	 * r.enUS: stringWriter
	 */
	protected void _ecrivainString(Couverture<StringWriter> c) {
		if(fichier == null && reponseServeurHttp == null)
			c.o(new StringWriter());
	}

	/**
	 * {@inheritDoc}
	 * var.enUS: httpServerResponse
	 **/
	protected void _reponseServeurHttp(Couverture<HttpServerResponse> c) {
	}

	/**
	 * var.enUS: printWriter
	 * r: ecrivainString
	 * r.enUS: stringWriter
	 * r: fichier
	 * r.enUS: file
	 * r: reponseServeurHttp
	 * r.enUS: httpServerResponse
	 */
	protected void _ecrivainImpression(Couverture<PrintWriter> c) throws Exception {
		if(reponseServeurHttp == null) {
			if(fichier == null)
				c.o(new PrintWriter(ecrivainString));
			else
				c.o(new PrintWriter(fichier));
		}
	}

	/**
	 * {@inheritDoc}
	 * var.enUS: empty
	 **/
	protected void _vide(Couverture<Boolean> c) {
		c.o(true);
	}

	/**
	 * param1.var.enUS: tabNumber
	 * param2.var.enUS: objects
	 * r: objets
	 * r.enUS: objects
	 * r: nombreTabulations
	 * r.enUS: tabNumber
	 */
	public ToutEcrivain t(int nombreTabulations, Object...objets) {
		for(int i = 0; i < nombreTabulations; i++)
			s("\t");
		s(objets);
		return this;
	}

	/**
	 * param1.var.enUS: tabNumber
	 * param2.var.enUS: objects
	 * r: objets
	 * r.enUS: objects
	 * r: nombreTabulations
	 * r.enUS: tabNumber
	 */
	public ToutEcrivain tl(int nombreTabulations, Object...objets) {
		for(int i = 0; i < nombreTabulations; i++)
			s("\t");
		s(objets);
		s("\n");
		return this;
	}

	/**
	 * param1.var.enUS: objects
	 * r: objets
	 * r.enUS: objects
	 */
	public ToutEcrivain l(Object...objets) {
		s(objets);
		s("\n");
		return this;
	}

	/**
	 * r: objets
	 * r.enUS: objects
	 * r: objet
	 * r.enUS: object
	 * r: chaine
	 * r.enUS: chain
	 * r: ecrivainImpression
	 * r.enUS: printWriter
	 * r: reponseServeurHttp
	 * r.enUS: httpServerResponse
	 * r: vide
	 * r.enUS: empty
	 */
	public ToutEcrivain s(Object...objets) { 
		for(Object objet : objets) {
			if(objet != null) {
				if(objet instanceof List) {
					List<?> chaine = (List<?>)objet;
					for(Object objet2 : chaine) {
						String str = objet2.toString();
						if(objet2 != null && !StringUtils.isEmpty(str)) {
							if(reponseServeurHttp == null)
								ecrivainImpression.write(str);
							else
								reponseServeurHttp.write(str);
						}
					}
				}
				else {
					String str = objet.toString();
					if(!StringUtils.isEmpty(str)) {
						if(reponseServeurHttp == null)
							ecrivainImpression.write(str);
						else
							reponseServeurHttp.write(str);
					}
				}
			}
		}
		vide = false;
		return this;
	}

	/**
	 * r: ecrivainString
	 * r.enUS: stringWriter
	 * r: ecrivainImpression
	 * r.enUS: printWriter
	 * r: reponseServeurHttp
	 * r.enUS: httpServerResponse
	 */
	public void flushClose() throws IOException {

		if(ecrivainImpression != null)
			ecrivainImpression.flush();
		if(ecrivainString != null)
			ecrivainString.flush();

		if(ecrivainImpression != null)
			ecrivainImpression.close();
		if(ecrivainString != null)
			ecrivainString.close();

		if(reponseServeurHttp != null)
			reponseServeurHttp.close();
	}

	/**
	 * r: ecrivainString
	 * r.enUS: stringWriter
	 * r: ecrivainImpression
	 * r.enUS: printWriter
	 * r: reponseServeurHttp
	 * r.enUS: httpServerResponse
	 */
	@Override public String toString() {
		if(reponseServeurHttp != null)
			return ecrivainString.toString();
		else if(fichier != null)
			return ecrivainImpression.toString();
		else
			return ecrivainString.toString();
	}
}
