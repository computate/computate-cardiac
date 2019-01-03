package org.computate.frFR.cardiaque.ecrivain;   

import java.io.File;
import java.io.FileNotFoundException;
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

	public static ToutEcrivain create(RequeteSite requeteSite) throws FileNotFoundException {
		ToutEcrivain o = new ToutEcrivain();
		o.initLoinPourClasse(requeteSite);
		return o;
	}

	public static ToutEcrivain create(RequeteSite requeteSite, File file) throws FileNotFoundException {
		ToutEcrivain o = new ToutEcrivain();
		o.setFile(file);
		o.initLoinPourClasse(requeteSite);
		return o;
	}

	/**
	 * {@inheritDoc}
	 * 
	 **/
	protected void _file(Couverture<File> c) {
	}

	protected void _stringWriter(StringWriter o) {
		if(file == null)
			this.stringWriter = new StringWriter();
	}

	/**
	 * {@inheritDoc}
	 * 
	 **/
	protected void _httpServerResponse(Couverture<HttpServerResponse> c) {
	}

	protected void _printWriter(Couverture<PrintWriter> c) throws FileNotFoundException {
		if(httpServerResponse == null) {
			if(file == null)
				this.printWriter = new PrintWriter(stringWriter);
			else
				this.printWriter = new PrintWriter(file);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 **/
	protected void _empty(Couverture<Boolean> c) {
		this.empty = true;
	}

	public ToutEcrivain t(int nombreTabulations, Object...objets) {
		for(int i = 0; i < nombreTabulations; i++)
			s("\t");
		s(objets);
		return this;
	}
	public ToutEcrivain tl(int nombreTabulations, Object...objets) {
		for(int i = 0; i < nombreTabulations; i++)
			s("\t");
		s(objets);
		s("\n");
		return this;
	}

	public ToutEcrivain l(Object...objets) {
		s(objets);
		s("\n");
		return this;
	}

	public ToutEcrivain s(Object...objets) { 
		for(Object objet : objets) {
			if(objet != null) {
				if(objet instanceof List) {
					List<?> chaine = (List<?>)objet;
					for(Object objet2 : chaine) {
						String str = objet2.toString();
						if(objet2 != null && !StringUtils.isEmpty(str)) {
							if(httpServerResponse == null)
								printWriter.write(str);
							else
								httpServerResponse.write(str);
						}
					}
				}
				else {
					String str = objet.toString();
					if(!StringUtils.isEmpty(str)) {
						if(httpServerResponse == null)
							printWriter.write(str);
						else
							httpServerResponse.write(str);
					}
				}
			}
		}
		empty = false;
		return this;
	}

	public void flushClose() throws IOException {

		if(printWriter != null)
			printWriter.flush();
		if(stringWriter != null)
			stringWriter.flush();

		if(printWriter != null)
			printWriter.close();
		if(stringWriter != null)
			stringWriter.close();

		if(httpServerResponse != null)
			httpServerResponse.close();
	}

	@Override public String toString() {
		if(httpServerResponse != null)
			return stringWriter.toString();
		else if(file != null)
			return printWriter.toString();
		else
			return stringWriter.toString();
	}
}
