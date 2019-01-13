package org.computate.enUS.cardiac.chain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.computate.frFR.cardiaque.couverture.Couverture;
import org.computate.frFR.cardiaque.page.parti.Icone;
import org.computate.frFR.cardiaque.requete.RequeteSite;

public class Chain extends ChainGen<Object> {

	public static List<String> HTML_ELEMENTS_FERMES = Arrays.asList("area", "base", "br", "col", "command", "embed", "hr", "img", "input", "keygen", "link", "meta", "param", "source", "track", "wbr");

	public static List<String> HTML_ELEMENTS_NO_WRAP = Arrays.asList("script", "span", "a", "b", "i", "u", "title", "use", "h1", "h2", "h3", "h4", "h5", "h6");

	protected void _requeteSite_(Couverture<RequeteSite> ) {}

	protected void _police(Couverture<String> ) {}

	protected void _alignerCentre(Couverture<Boolean> ) {}

	protected void _alignerGauche(Couverture<Boolean> ) {}

	protected void _alignerDroit(Couverture<Boolean> ) {}

	protected void _iconesAvant(ArrayList<Icone> ) {}

	protected void _iconesApres(ArrayList<Icone> ) {}

	protected void _xDecalage(Couverture<Double> ) {}

	protected void _yDecalage(Couverture<Double> ) {}

	protected void _hLigne(Couverture<Double> ) {}

	protected void _hEspace(Couverture<Double> ) {}

	protected void _tout(ArrayList<Object> ) {}

	public String s() {
		String o = "";
			o = StringUtils.join(tout.toArray());
		return o;
	}

	public String toString(String langue) {
		String o = StringUtils.join(tout.toArray());
		return o;
	}

	@Override()
	public String toString() { 
		StringBuilder o = new StringBuilder();
		if(requeteSite_ != null) {
			for(Object p : tout) {
				if(p != null && !(p instanceof Chaine))
					o.append(p.toString());
			}
		}
		else {
			for(Object p : tout) {
				if(p != null)
					o.append(p.toString());
			}
		}
		return o.toString();
	}

	public Chain tab(int nombreTabulations, Object...objets) {
		for(int i = 0; i < nombreTabulations; i++)
			tout("\t");
		tout(objets);
		return this;
	}

	public Chain tabLigne(int nombreTabulations, Object...objets) {
		for(int i = 0; i < nombreTabulations; i++)
			tout("\t");
		tout(objets);
		tout("\n");
		return this;
	}

	public Chain toutLigne(Object...objets) {
		tout(objets);
		tout("\n");
		return this;
	}

	public Chain tout(Object...objets) { 
		for(Object objet : objets) {
			if(objet != null) {
				if(objet instanceof Chaine) {
					Chaine chaine = (Chaine)objet;
					for(Object objet2 : chaine.tout) {
						if(objet2 != null && !StringUtils.isEmpty(objet2.toString()))
							tout.add(objet2);
					}
				}
				else if(objet instanceof List) {
					List<?> chaine = (List<?>)objet;
					for(Object objet2 : chaine) {
						if(objet2 != null && !StringUtils.isEmpty(objet2.toString()))
							tout.add(objet2);
					}
				}
				else {
					if(!StringUtils.isEmpty(objet.toString()))
						tout.add(objet);
				}
			}
		}
		return this;
	}

	public boolean estVide() {
		Boolean résultat = tout.size() == 0 && tout.size() == 0;
		return résultat;
	}

	public boolean pasVide() {
		Boolean résultat = !(tout.size() == 0 && tout.size() == 0);
		return résultat;
	}

	public String minuscules() {
		String résultat = StringUtils.lowerCase(toString());
		return résultat;
	}

	public String majuscules() {
		String résultat = StringUtils.upperCase(toString());
		return résultat;
	}

	public String capitaliser() {
		String résultat = StringUtils.capitalize(toString());
		return résultat;
	}

	public String noncapitaliser() {
		String résultat = StringUtils.uncapitalize(toString());
		return résultat;
	}

	public String sousChaineApres(String separator) {
		String résultat = StringUtils.substringAfter(toString(), separator);
		return résultat;
	}

	public String sousChaineApres(Chain separator) {
		String résultat = StringUtils.substringAfter(toString(), separator.toString());
		return résultat;
	}

	public String sousChaineApresDernier(String separator) {
		String résultat = StringUtils.substringAfterLast(toString(), separator);
		return résultat;
	}

	public String sousChaineApresDernier(Chain separator) {
		String résultat = StringUtils.substringAfterLast(toString(), separator.toString());
		return résultat;
	}

	public String sousChaineAvant(String separator) {
		String résultat = StringUtils.substringBefore(toString(), separator);
		return résultat;
	}

	public String sousChaineAvant(Chain separator) {
		String résultat = StringUtils.substringBefore(toString(), separator.toString());
		return résultat;
	}

	public String sousChaineAvantDernier(String separator) {
		String résultat = StringUtils.substringBeforeLast(toString(), separator);
		return résultat;
	}

	public String sousChaineAvantDernier(Chain separator) {
		String résultat = StringUtils.substringBeforeLast(toString(), separator.toString());
		return résultat;
	}

	public void  sousChaineAvant(Chain o, String separator) {
		String s = StringUtils.substringBefore(o.s(), separator);
		tout(s);
	}

	public void  sousChaineAvantDernier(Chain o, String separator) {
		String s = StringUtils.substringBeforeLast(o.s(), separator);
		tout(s);
	}

	public void  sousChaineApres(Chain o, String separator) {
		String s = StringUtils.substringAfter(o.s(), separator);
		tout(s);
	}

	public void  sousChaineApresDernier(Chain o, String separator) {
		String s = StringUtils.substringAfterLast(o.s(), separator);
		tout(s);
	}

	public String[] diviserParCaractèreTypeChameau() {
		String résultat[] = StringUtils.splitByCharacterTypeCamelCase(toString());
		return résultat;
	}

	public String couper() {
		String résultat = StringUtils.trim(toString());
		return résultat;
	}

	public boolean contains(String s) {
		boolean résultat = StringUtils.contains(toString(), s);
		return résultat;
	}

	public boolean contains(Chain s) {
		boolean résultat = StringUtils.contains(toString(), s.toString());
		return résultat;
	}

	public boolean contient(String s) {
		boolean résultat = StringUtils.contains(toString(), s);
		return résultat;
	}

	public boolean contient(Chain s) {
		boolean résultat = StringUtils.contains(toString(), s.toString());
		return résultat;
	}

	public boolean contientPas(String s) {
		boolean résultat = !StringUtils.contains(toString(), s);
		return résultat;
	}

	public boolean contientPas(Chain s) {
		boolean résultat = !StringUtils.contains(toString(), s.toString());
		return résultat;
	}

	public boolean égal(String s) {
		boolean résultat = StringUtils.equals(toString(), s);
		return résultat;
	}

	public boolean égal(Chain s) {
		boolean résultat = StringUtils.equals(toString(), s.toString());
		return résultat;
	}

	public boolean pasÉgal(String s) {
		boolean résultat = !StringUtils.equals(toString(), s);
		return résultat;
	}

	public boolean pasÉgal(Chain s) {
		boolean résultat = !StringUtils.equals(toString(), s.toString());
		return résultat;
	}

	public boolean terminePar(String s) {
		boolean résultat = StringUtils.endsWith(toString(), s);
		return résultat;
	}

	public boolean terminePar(Chain s) {
		boolean résultat = StringUtils.endsWith(toString(), s.toString());
		return résultat;
	}

	public boolean terminePasPar(String s) {
		boolean résultat = !StringUtils.endsWith(toString(), s);
		return résultat;
	}

	public boolean terminePasPar(Chain s) {
		boolean résultat = !StringUtils.endsWith(toString(), s.toString());
		return résultat;
	}

	public boolean commencePar(String s) {
		boolean résultat = StringUtils.startsWith(toString(), s);
		return résultat;
	}

	public boolean commencePar(Chain s) {
		boolean résultat = StringUtils.startsWith(toString(), s.toString());
		return résultat;
	}

	public boolean commencePasPar(String s) {
		boolean résultat = !StringUtils.startsWith(toString(), s);
		return résultat;
	}

	public boolean commencePasPar(Chain s) {
		boolean résultat = !StringUtils.startsWith(toString(), s.toString());
		return résultat;
	}

	public Chain vider() {

		this.tout = new ArrayList<Object>();

		return this;
	}

	@Override()
	public int hashCode() {
		org.apache.commons.lang3.builder.HashCodeBuilder o = new org.apache.commons.lang3.builder.HashCodeBuilder();
		o.append(tout.toString());

		return o.toHashCode();
	}

	@Override()
	public boolean equals(Object obj) {
		if(obj instanceof Chaine) {
			final Chaine other = (Chaine)obj;
			org.apache.commons.lang3.builder.EqualsBuilder o = new org.apache.commons.lang3.builder.EqualsBuilder();
			o.append(s(), other.s());

			return o.isEquals();
		} else if(obj != null) {
			Boolean o = toString().equals(obj.toString());
			return o;
		}
		else {
			return false;
		}
	}
}
