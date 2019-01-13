package org.computate.enUS.cardiac.writer;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.computate.frFR.cardiaque.couverture.Couverture;
import org.computate.frFR.cardiaque.requete.RequeteSite;
import io.vertx.core.http.HttpServerResponse;

public class AllWriter extends AllWriterGen<Object> {

	public static AllWriter create(RequeteSite siteRequest) throws Exception, Exception {
		AllWriter o = new AllWriter();
		o.initDeepForClass(siteRequest);
		return o;
	}

	public static AllWriter create(RequeteSite siteRequest, File fichier) throws Exception, Exception {
		AllWriter o = new AllWriter();
		o.setFile(file);
		o.initDeepForClass(siteRequest);
		return o;
	}

	public AllWriter t(int tabNumber, Object...objects) {
		for(int i = 0; i < tabNumber; i++)
			s("\t");
		s(objects);
		return this;
	}

	public AllWriter tl(int tabNumber, Object...objects) {
		for(int i = 0; i < tabNumber; i++)
			s("\t");
		s(objects);
		s("\n");
		return this;
	}

	public AllWriter l(Object...objects) {
		s(objects);
		s("\n");
		return this;
	}

	public AllWriter s(Object...objets) { 
		for(Object object : objects) {
			if(object != null) {
				if(object instanceof List) {
					List<?> chain = (List<?>)object;
					for(Object object2 : chain) {
						String str = object2.toString();
						if(object2 != null && !StringUtils.isEmpty(str)) {
							if(httpServerResponse == null)
								printWriter.write(str);
							else
								httpServerResponse.write(str);
						}
					}
				}
				else {
					String str = object.toString();
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

	public void  flushClose() throws IOException, IOException {

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

	@Override()
	public String toString() {
		if(httpServerResponse != null)
			return stringWriter.toString();
		else if(fichier != null)
			return printWriter.toString();
		else
			return stringWriter.toString();
	}
}
