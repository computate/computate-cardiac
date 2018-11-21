package com.heytate.frFR.cardiaque.page.parti;

import com.heytate.frFR.cardiac.chaine.Chaine;
import com.heytate.frFR.cardiac.page.parti.PagePartiGen;
import com.heytate.frFR.cardiaque.cluster.Cluster;
import com.heytate.frFR.cardiaque.couverture.Couverture;
import com.heytate.frFR.cardiaque.requete.RequeteSite;

public abstract class PageParti extends PagePartiGen<Cluster> {  

	/**	Tous les infos importants à propos de la requête actuelle. **/
	protected void _requeteSite(Couverture<RequeteSite> c) throws Exception {}  

	public abstract Chaine partiH3();
	public abstract Chaine partiH3Court();

	public abstract Chaine partiH4();
	public abstract Chaine partiH4Court();

	public abstract void html() throws Exception;
	public abstract void htmlCourt() throws Exception;

	protected void _partiVar(Couverture<String> c) {}

	public void shAvantClasseJavaChamp() throws Exception {
	}

	public void shAvantPageParti() throws Exception {}
	public void shApresPageParti() throws Exception {}
	public void shHtmlAvantPageParti() throws Exception {}
	public void shHtmlApresPageParti() throws Exception {}
	public void htmlAvantPageParti() throws Exception {}
	public void htmlApresPageParti() throws Exception {}

	public void shCmd() {
		if(requeteSite.pageAchete) {
			page_.tabLigne(0, "if [ \"$1\" == \"p\" ]; then");
//			page.tabLigne(1, "figlet -f smmono9 '", nomSimple.toString().replace("'", "'\"'\"'"), "'; read");
			page_.tabLigne(0, "else");
			page_.tabLigne(1, "if [ \"$1\" == \"p\" ]; then");
			page_.tabLigne(0, "fi");
		}
	}
}
