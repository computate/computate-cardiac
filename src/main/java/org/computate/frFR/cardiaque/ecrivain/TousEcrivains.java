package org.computate.frFR.cardiaque.ecrivain;    

import java.io.IOException;
import java.util.List;


/**   
 * nomCanonique.enUS: org.computate.enUS.cardiac.writer.AllWriters
 **/
public class TousEcrivains {    

	public static TousEcrivains create(ToutEcrivain...writers) {
		TousEcrivains o = new TousEcrivains();
		o.initDeepForClass();
		o.addStringPrintWriters(writers);
		return o;
	}

	protected void _stringPrintWriters(List<ToutEcrivain> c) {
	}

	public TousEcrivains t(int nombreTabulations, Object...objets) {
		for(ToutEcrivain stringPrintWriter : stringPrintWriters) {
			stringPrintWriter.t(nombreTabulations, objets);
		}
		return this;
	}
	public TousEcrivains tl(int nombreTabulations, Object...objets) {
		for(ToutEcrivain stringPrintWriter : stringPrintWriters) {
			stringPrintWriter.tl(nombreTabulations, objets);
		}
		return this;
	}

	public TousEcrivains l(Object...objets) {
		for(ToutEcrivain stringPrintWriter : stringPrintWriters) {
			stringPrintWriter.l(objets);
		}
		return this;
	}

	public TousEcrivains s(Object...objets) { 
		for(ToutEcrivain stringPrintWriter : stringPrintWriters) {
			stringPrintWriter.s(objets);
		}
		return this;
	}

	public void flushClose() throws IOException {
		for(ToutEcrivain stringPrintWriter : stringPrintWriters) {
			stringPrintWriter.flushClose();
		}
	}

	@Override public String toString() {
		return stringPrintWriters.get(0).toString();
	}

	////////////////////////
	// stringPrintWriters //
	////////////////////////

	/**	The entity " stringPrintWriters "
	 *	It is constructed before being initialized with the constructor by default List<StringPrintWriter>(). 
	 */
	protected List<ToutEcrivain> stringPrintWriters = new java.util.ArrayList<ToutEcrivain>();

	public List<ToutEcrivain> getStringPrintWriters() {
		return stringPrintWriters;
	}

	public void setStringPrintWriters(List<ToutEcrivain> l) {
		this.stringPrintWriters = l;
	}
	public TousEcrivains addStringPrintWriters(ToutEcrivain...objets) {
		for(ToutEcrivain o : objets) {
			addStringPrintWriters(o);
		}
		return (TousEcrivains)this;
	}
	public TousEcrivains addStringPrintWriters(ToutEcrivain o) {
		if(o != null && !stringPrintWriters.contains(o))
			this.stringPrintWriters.add(o);
		return (TousEcrivains)this;
	}
	protected TousEcrivains stringPrintWritersInit() {
		_stringPrintWriters(stringPrintWriters);
		return (TousEcrivains)this;
	}

	//////////////
	// initDeep //
	//////////////

	protected boolean alreadyInitializedStringPrintWriters = false;

	public TousEcrivains initDeepStringPrintWriters() {
		if(!alreadyInitializedStringPrintWriters) {
			alreadyInitializedStringPrintWriters = true;
			stringPrintWritersInit();
		}
		return (TousEcrivains)this;
	}

	public void initDeepForClass() {
		initDeepStringPrintWriters();
	}
}
