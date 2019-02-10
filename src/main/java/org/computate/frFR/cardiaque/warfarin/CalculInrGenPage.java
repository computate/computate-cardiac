package org.computate.frFR.cardiaque.warfarin;

import org.computate.frFR.cardiaque.contexte.SiteContexte;
import io.vertx.core.http.HttpServerRequest;
import org.computate.frFR.cardiaque.recherche.ListeRecherche;
import org.computate.frFR.cardiaque.couverture.Couverture;
import org.computate.frFR.cardiaque.config.ConfigSite;
import io.vertx.core.http.HttpServerResponse;
import org.computate.frFR.cardiaque.utilisateur.UtilisateurSite;
import org.computate.frFR.cardiaque.requete.RequeteSite;
import java.io.IOException;
import org.computate.frFR.cardiaque.page.MiseEnPage;


public class CalculInrGenPage extends CalculInrGenPageGen<MiseEnPage> {

	/**
	 * {@inheritDoc}
	 * 
	 **/
	protected void _listeCalculInr(Couverture<ListeRecherche<CalculInr>> c) {
	}

	@Override public void initLoinCalculInrGenPage() {
		initCalculInrGenPage();
		super.initLoinMiseEnPage();
	}

	public void htmlCalculInrGenPageMilieu() {
		if(listeCalculInr.size() == 1) {
			// un calcul INR
			CalculInr o = listeCalculInr.first();

			{ e("h1").f();
				e("i").a("class", "r fa-calculator-alt w3-margin-right-4 ").f().g("i");
				e("span").a("class", " ").f().sx("calculs INR").g("i");
			} g("h1");
			{ e("h2").f();
				e("span").a("class", " ").f().sx(o.getPageH2()).g("i");
			} g("h2");
			{ e("div").a("class", "w3-card w3-margin w3-padding w3-margin-top w3-show ").f();
				{ e("div").a("class", "w3-cell-row ").f();
					{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
						e("input").a("name", "dateInr").fg();
					} g("div");
					{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
						e("input").a("name", "dateReverifier").fg();
					} g("div");
				} g("div");
				{ e("div").a("class", "w3-cell-row ").f();
					{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
						e("input").a("name", "patientPrendCoumadin").fg();
					} g("div");
					{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
						e("input").a("name", "butActuel").fg();
					} g("div");
				} g("div");
				{ e("div").a("class", "w3-cell-row ").f();
					{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
						e("input").a("name", "doseActuel").fg();
					} g("div");
					{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
						e("input").a("name", "medicamentActuel").fg();
					} g("div");
				} g("div");
				{ e("div").a("class", "w3-cell-row ").f();
					{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
						e("input").a("name", "changementDose").fg();
					} g("div");
					{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
						e("input").a("name", "notesComplementaires").fg();
					} g("div");
				} g("div");
				{ e("div").a("class", "w3-cell-row ").f();
					{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
						e("input").a("name", "infoContact").fg();
					} g("div");
				} g("div");
			} g("div");
		} else if(listeCalculInr.size() == 1) {
			// plusiers calculs INR

		} else {
		}
	}
}
