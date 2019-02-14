package org.computate.frFR.cardiaque.warfarin;

import io.vertx.core.http.HttpServerRequest;
import org.computate.frFR.cardiaque.recherche.ListeRecherche;
import org.computate.frFR.cardiaque.couverture.Couverture;
import org.computate.frFR.cardiaque.chaine.Chaine;
import org.computate.frFR.cardiaque.config.ConfigSite;
import org.computate.frFR.cardiaque.utilisateur.UtilisateurSite;
import java.io.IOException;
import org.computate.frFR.cardiaque.contexte.SiteContexte;
import java.lang.Long;
import io.vertx.core.http.HttpServerResponse;
import java.util.Locale;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.computate.frFR.cardiaque.requete.RequeteSite;
import java.lang.Boolean;
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

	@Override public void htmlScriptsCalculInrGenPage() {
		e("script").a("src", "/static/js/CalculInrPage.js").f().g("script");
	}

	@Override public void htmlScriptCalculInrGenPage() {
	}

	public void htmlFormCalculInr(CalculInr o) {
		{ e("div").a("class", "w3-cell-row ").f();
			{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
				LocalDate val = o.getDateInr();

				e("label").a("class", "").f().sx("Date INR").g("label");
				e("input")
					.a("type", "text")
					.a("class", "w3-input w3-border datepicker ")
					.a("placeholder", "DD/MM/YYYY")
					.a("data-timeformat", "DD/MM/YYYY")
					.a("onclick", "enleverLueur($(this)); ")
					.a("title", "Date du calcul INR.  (DD/MM/YYYY)")
					.a("value", val == null ? "" : DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.forLanguageTag("fr-FR")).format(val))
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
				LocalDate val = o.getDateReverifier();

				e("label").a("class", "").f().sx("Date à reverifier").g("label");
				e("input")
					.a("type", "text")
					.a("class", "w3-input w3-border datepicker ")
					.a("placeholder", "DD/MM/YYYY")
					.a("data-timeformat", "DD/MM/YYYY")
					.a("onclick", "enleverLueur($(this)); ")
					.a("title", "Date à reverifier.  (DD/MM/YYYY)")
					.a("value", val == null ? "" : DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.forLanguageTag("fr-FR")).format(val))
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

				htmlFormCalculInr(o);

			} g("div");
		} else {
			// calculs INR

			{ e("h1").f();
				e("i").a("class", "far fa-clinic-medical w3-margin-right-4 ").f().g("i");
				e("span").a("class", " ").f().sx("calculs INR").g("i");
			} g("h1");
		}
		e("div").f();


		e("button")
			.a("class", "w3-btn w3-round w3-border w3-border-black w3-section w3-ripple w3-padding w3-green ")
			.a("onclick", "$('#postCalculInrModale').show(); ")
			.f().sx("Créer un calcul INR")
		.g("button");
		{ e("div").a("id", "postCalculInrModale").a("class", "w3-modal ").f();
			{ e("div").a("class", "w3-modal-content w3-card-4 ").f();
				{ e("header").a("class", "w3-container w3-green ").f();
					e("span").a("class", "w3-button w3-display-topright ").a("onclick", "$('#postCalculInrModale').hide(); ").f().sx("×").g("span");
					e("h2").a("class", "").f().sx("Créer un calcul INR").g("h2");
				} g("header");
				{ e("div").a("class", "w3-container ").f();
					CalculInr o = new CalculInr();

					{ e("form").a("id", "postCalculInrFormulaire").f();
						htmlFormCalculInr(o);
					} g("form");
					e("button")
						.a("class", "w3-btn w3-round w3-border w3-border-black w3-section w3-ripple w3-padding w3-green ")
						.a("onclick", "postCalculInr($('#postCalculInrFormulaire').serializeObject()); ")
						.f().sx("Créer un calcul INR")
					.g("button");

				} g("div");
			} g("div");
		} g("div");


		if(listeCalculInr.size() == 1) {
			e("button")
				.a("class", "w3-btn w3-round w3-border w3-border-black w3-section w3-ripple w3-padding w3-green ")
				.a("onclick", "$('#patchCalculInrModale').show(); ")
				.f().sx("Actualiser le calcul INR")
			.g("button");
			{ e("div").a("id", "patchCalculInrModale").a("class", "w3-modal ").f();
				{ e("div").a("class", "w3-modal-content w3-card-4 ").f();
					{ e("header").a("class", "w3-container w3-green ").f();
						e("span").a("class", "w3-button w3-display-topright ").a("onclick", "$('#patchCalculInrModale').hide(); ").f().sx("×").g("span");
						e("h2").a("class", "").f().sx("Actualiser le calcul INR").g("h2");
					} g("header");
					{ e("div").a("class", "w3-container ").f();
						CalculInr o = new CalculInr();

						{ e("form").a("id", "patchCalculInrFormulaire").f();
							htmlFormCalculInr(o);
						} g("form");
						e("button")
							.a("class", "w3-btn w3-round w3-border w3-border-black w3-section w3-ripple w3-padding w3-green ")
							.a("onclick", "patchCalculInr(", o.getPk(), "); ")
							.f().sx("Actualiser le calcul INR")
						.g("button");

					} g("div");
				} g("div");
			} g("div");

		}

		if(listeCalculInr.size() == 1) {
			e("button")
				.a("class", "w3-btn w3-round w3-border w3-border-black w3-section w3-ripple w3-padding w3-green ")
				.a("onclick", "$('#putCalculInrModale').show(); ")
				.f().sx("Remplacer le calcul INR")
			.g("button");
			{ e("div").a("id", "putCalculInrModale").a("class", "w3-modal ").f();
				{ e("div").a("class", "w3-modal-content w3-card-4 ").f();
					{ e("header").a("class", "w3-container w3-green ").f();
						e("span").a("class", "w3-button w3-display-topright ").a("onclick", "$('#putCalculInrModale').hide(); ").f().sx("×").g("span");
						e("h2").a("class", "").f().sx("Remplacer le calcul INR").g("h2");
					} g("header");
					{ e("div").a("class", "w3-container ").f();
						CalculInr o = new CalculInr();

						{ e("form").a("id", "putCalculInrFormulaire").f();
							htmlFormCalculInr(o);
						} g("form");
						e("button")
							.a("class", "w3-btn w3-round w3-border w3-border-black w3-section w3-ripple w3-padding w3-green ")
							.a("onclick", "putCalculInr(", o.getPk(), ", $('#putCalculInrFormulaire').serializeObject()); ")
							.f().sx("Remplacer le calcul INR")
						.g("button");

					} g("div");
				} g("div");
			} g("div");

		}

		if(listeCalculInr.size() == 1) {
			e("button")
				.a("class", "w3-btn w3-round w3-border w3-border-black w3-section w3-ripple w3-padding w3-green ")
				.a("onclick", "$('#deleteCalculInrModale').show(); ")
				.f().sx("Supprimer le calcul INR")
			.g("button");
			{ e("div").a("id", "deleteCalculInrModale").a("class", "w3-modal ").f();
				{ e("div").a("class", "w3-modal-content w3-card-4 ").f();
					{ e("header").a("class", "w3-container w3-green ").f();
						e("span").a("class", "w3-button w3-display-topright ").a("onclick", "$('#deleteCalculInrModale').hide(); ").f().sx("×").g("span");
						e("h2").a("class", "").f().sx("Supprimer le calcul INR").g("h2");
					} g("header");
					{ e("div").a("class", "w3-container ").f();
						CalculInr o = new CalculInr();

						{ e("form").a("id", "deleteCalculInrFormulaire").f();
							htmlFormCalculInr(o);
						} g("form");
						e("button")
							.a("class", "w3-btn w3-round w3-border w3-border-black w3-section w3-ripple w3-padding w3-green ")
							.a("onclick", "deleteCalculInr(", o.getPk(), "); ")
							.f().sx("Supprimer le calcul INR")
						.g("button");

					} g("div");
				} g("div");
			} g("div");

		}
		g("div");
	}
}
