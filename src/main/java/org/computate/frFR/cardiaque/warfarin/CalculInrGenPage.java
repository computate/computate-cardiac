package org.computate.frFR.cardiaque.warfarin;

import org.computate.frFR.cardiaque.contexte.SiteContexte;
import io.vertx.core.http.HttpServerRequest;
import org.computate.frFR.cardiaque.recherche.ListeRecherche;
import org.computate.frFR.cardiaque.couverture.Couverture;
import org.computate.frFR.cardiaque.config.ConfigSite;
import io.vertx.core.http.HttpServerResponse;
import java.util.Locale;
import org.computate.frFR.cardiaque.utilisateur.UtilisateurSite;
import java.time.format.DateTimeFormatter;
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

	@Override public void htmlBodyCalculInrGenPage() {
		if(listeCalculInr.size() == 0) {
			//aucun calcul INR trouvé

			{ e("h1").f();
				e("i").a("class", "far fa-clinic-medical w3-margin-right-4 ").f().g("i");
				e("span").a("class", " ").f().sx("aucun calcul INR trouvé").g("i");
			} g("h1");
		} else if(listeCalculInr.size() == 1) {
			// un calcul INR
			CalculInr o = listeCalculInr.first();

			{ e("h1").f();
				e("i").a("class", "far fa-clinic-medical w3-margin-right-4 ").f().g("i");
				e("span").a("class", " ").f().sx("un calcul INR").g("i");
			} g("h1");
			{ e("h2").f();
				e("span").a("class", " ").f().sx(o.getPageH2()).g("i");
			} g("h2");
			{ e("div").a("class", "w3-card w3-margin w3-padding w3-margin-top w3-show ").f();
				{ e("div").a("class", "w3-cell-row ").f();
					{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
						e("label").a("class", "").f().sx("Date INR").g("label");

						e("input")
							.a("type", "text")
							.a("class", "w3-input w3-border datepicker ")
							.a("placeholder", "DD/MM/YYYY")
							.a("data-timeformat", "DD/MM/YYYY")
							.a("onclick", "enleverLueur($(this)); ")
							.a("title", "Date du calcul INR.  (DD/MM/YYYY)")							.a("value", DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.forLanguageTag("fr-FR")).format(o.getDateInr()))
							.a("onchange", "var t = moment(this.value, 'DD/MM/YYYY'); if(t) { var s = t.format('YYYY-MM-DD'); $(this).next().val(s); $(this).next().trigger('change'); } ")
							.fg();
						e("input")
							.a("name", "dateInr")
							.a("type", "hidden")
							.a("onchange", "envoyer(); ")
							.a("value", o.strDateInr())
						.fg();
					} g("div");
					{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
						e("label").a("class", "").f().sx("Date à reverifier").g("label");

						e("input")
							.a("type", "text")
							.a("class", "w3-input w3-border datepicker ")
							.a("placeholder", "DD/MM/YYYY")
							.a("data-timeformat", "DD/MM/YYYY")
							.a("onclick", "enleverLueur($(this)); ")
							.a("title", "Date à reverifier.  (DD/MM/YYYY)")							.a("value", DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.forLanguageTag("fr-FR")).format(o.getDateReverifier()))
							.a("onchange", "var t = moment(this.value, 'DD/MM/YYYY'); if(t) { var s = t.format('YYYY-MM-DD'); $(this).next().val(s); $(this).next().trigger('change'); } ")
							.fg();
						e("input")
							.a("name", "dateReverifier")
							.a("type", "hidden")
							.a("onchange", "envoyer(); ")
							.a("value", o.strDateReverifier())
						.fg();
					} g("div");
				} g("div");
				{ e("div").a("class", "w3-cell-row ").f();
					{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
						e("input")
							.a("type", "hidden")
							.a("name", "patientPrendCoumadin")
							.a("value", "false")
						.fg();

						e("input")
							.a("type", "checkbox")
							.a("name", "patientPrendCoumadin")
							.a("value", "true")
							.a("onchange", "envoyer(); ");
							if(o.getPatientPrendCoumadin() != null && o.getPatientPrendCoumadin())
								a("checked", "checked");
						fg();

						e("label").a("class", "").f().sx("Patient prend coumadin").g("label");
					} g("div");
					{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
						e("label").a("class", "").f().sx("But actuel").g("label");

						e("input")
							.a("type", "text")
							.a("name", "butActuel")
							.a("class", "w3-input w3-border ")
							.a("placeholder", "But actuel")
							.a("title", "But actuel. ")
							.a("onchange", "envoyer(); ")
						.fg();

					} g("div");
				} g("div");
				{ e("div").a("class", "w3-cell-row ").f();
					{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
						e("label").a("class", "").f().sx("Dose actuel").g("label");

						e("input")
							.a("type", "text")
							.a("name", "doseActuel")
							.a("class", "w3-input w3-border ")
							.a("placeholder", "Dose actuel")
							.a("title", "Dose actuel. ")
							.a("onchange", "envoyer(); ")
						.fg();

					} g("div");
					{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
						e("label").a("class", "").f().sx("Dose actuel").g("label");

						e("input")
							.a("type", "text")
							.a("name", "medicamentActuel")
							.a("class", "w3-input w3-border ")
							.a("placeholder", "Dose actuel")
							.a("title", "Medicament actuel. ")
							.a("onchange", "envoyer(); ")
						.fg();

					} g("div");
				} g("div");
				{ e("div").a("class", "w3-cell-row ").f();
					{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
						e("label").a("class", "").f().sx("Changement de dose").g("label");

						e("input")
							.a("type", "text")
							.a("name", "changementDose")
							.a("class", "w3-input w3-border ")
							.a("placeholder", "Changement de dose")
							.a("title", "Changement de dose. ")
							.a("onchange", "envoyer(); ")
						.fg();

					} g("div");
					{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
						e("label").a("class", "").f().sx("Notes complémentaires").g("label");

						e("input")
							.a("type", "text")
							.a("name", "notesComplementaires")
							.a("class", "w3-input w3-border ")
							.a("placeholder", "Notes complémentaires")
							.a("title", "Notes complémentaires. ")
							.a("onchange", "envoyer(); ")
						.fg();

					} g("div");
				} g("div");
				{ e("div").a("class", "w3-cell-row ").f();
					{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
						e("label").a("class", "").f().sx("Info contact").g("label");

						e("input")
							.a("type", "text")
							.a("name", "infoContact")
							.a("class", "w3-input w3-border ")
							.a("placeholder", "Info contact")
							.a("title", "Info contact. ")
							.a("onchange", "envoyer(); ")
						.fg();

					} g("div");
				} g("div");
			} g("div");
		} else {
			// calculs INR

			{ e("h1").f();
				e("i").a("class", "far fa-clinic-medical w3-margin-right-4 ").f().g("i");
				e("span").a("class", " ").f().sx("calculs INR").g("i");
			} g("h1");
		}
	}
}
