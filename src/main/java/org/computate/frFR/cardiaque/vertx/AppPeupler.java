package org.computate.frFR.cardiaque.vertx;

import org.computate.frFR.cardiaque.config.ConfigSite;
import org.computate.frFR.cardiaque.contexte.SiteContexte;
import org.computate.frFR.cardiaque.couverture.Couverture;
import org.computate.frFR.cardiaque.requete.RequeteSite;
import org.computate.frFR.cardiaque.warfarin.CalculInr;

public class AppPeupler extends AppPeuplerGen<Object> {   

	protected void _requeteSite_(Couverture<RequeteSite> c) throws Exception {
	}

	protected void _siteContexte(SiteContexte o) throws Exception {
	}

	protected void _configSite(Couverture<ConfigSite> c) throws Exception {
		c.o(siteContexte.getConfigSite());
	}

	public static void main(String[] args) throws Exception {
		AppPeupler api = new AppPeupler();
		api.initLoinAppPeupler();
		api.peuplerDonnees();
	}

	public void peuplerDonnees() throws Exception {
		new CalculInr() {{
			setDoseActuelValeur(2);
			setDoseActuelTexte("2mg daily except 4mg Tues/Thur");
			setChangementDoseValeur(4);
			setChangementDoseTexte();
		}};
	}
}
