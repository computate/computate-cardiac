package org.computate.frFR.cardiaque.warfarin;

import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.computate.frFR.cardiaque.contexte.SiteContexte;
import org.computate.frFR.cardiaque.couverture.Couverture;
import org.computate.frFR.cardiaque.ecrivain.ToutEcrivain;
import org.computate.frFR.cardiaque.recherche.ListeRecherche;
import org.computate.frFR.cardiaque.requete.RequeteSite;

import io.vertx.core.Future;
import io.vertx.core.buffer.Buffer;
import io.vertx.ext.web.api.OperationResponse;

public class CalculInrApiServiceImpl extends CalculInrApiServiceImplGen<CalculInrGenApiServiceImpl> { 

	/**
	 * 
	 * {@inheritDoc}
	 **/
	protected void _requeteSite_(Couverture<RequeteSite> c) {
	}

	public CalculInrApiServiceImpl(SiteContexte siteContexte) {
		super(siteContexte);
	}

	@Override
	public Future<OperationResponse> reponse200GETPageCalculInr(ListeRecherche<CalculInr> listeCalculInr) {
		Buffer buffer = Buffer.buffer();
		ToutEcrivain w = ToutEcrivain.creer(listeCalculInr.getRequeteSite_(), buffer);
		SolrDocumentList documentsSolr = listeCalculInr.getSolrDocumentList();

		if(documentsSolr.size() > 0) {
			SolrDocument documentSolr = documentsSolr.get(0);
			Object entiteValeur;
			Integer entiteNumero = 0;

			w.l("{");

			entiteValeur = documentSolr.getFieldValues("utilisateurPk_stored_long").stream().findFirst().orElse(null);
			if(entiteValeur != null)
				w.l(entiteNumero++ == 0 ? "" : ", ", "\"utilisateurPk\": ", entiteValeur);

			entiteValeur = documentSolr.getFieldValues("dateInr_stored_date").stream().findFirst().orElse(null);
			if(entiteValeur != null)
				w.l(entiteNumero++ == 0 ? "" : ", ", "\"dateInr\": ", w.q(entiteValeur));

			entiteValeur = documentSolr.getFieldValues("dateReverifier_stored_date").stream().findFirst().orElse(null);
			if(entiteValeur != null)
				w.l(entiteNumero++ == 0 ? "" : ", ", "\"dateReverifier\": ", w.q(entiteValeur));

			entiteValeur = documentSolr.getFieldValues("patientPrendCoumadin_stored_string").stream().findFirst().orElse(null);
			if(entiteValeur != null)
				w.l(entiteNumero++ == 0 ? "" : ", ", "\"patientPrendCoumadin\": ", w.q(entiteValeur));

			entiteValeur = documentSolr.getFieldValues("butActuel_stored_string").stream().findFirst().orElse(null);
			if(entiteValeur != null)
				w.l(entiteNumero++ == 0 ? "" : ", ", "\"butActuel\": ", w.q(entiteValeur));

			entiteValeur = documentSolr.getFieldValues("doseActuel_stored_string").stream().findFirst().orElse(null);
			if(entiteValeur != null)
				w.l(entiteNumero++ == 0 ? "" : ", ", "\"doseActuel\": ", w.q(entiteValeur));

			entiteValeur = documentSolr.getFieldValues("medicamentActuel_stored_string").stream().findFirst().orElse(null);
			if(entiteValeur != null)
				w.l(entiteNumero++ == 0 ? "" : ", ", "\"medicamentActuel\": ", w.q(entiteValeur));

			entiteValeur = documentSolr.getFieldValues("changementDose_stored_string").stream().findFirst().orElse(null);
			if(entiteValeur != null)
				w.l(entiteNumero++ == 0 ? "" : ", ", "\"changementDose\": ", w.q(entiteValeur));

			entiteValeur = documentSolr.getFieldValues("notesComplementaires_stored_string").stream().findFirst().orElse(null);
			if(entiteValeur != null)
				w.l(entiteNumero++ == 0 ? "" : ", ", "\"notesComplementaires\": ", w.q(entiteValeur));

			entiteValeur = documentSolr.getFieldValues("infoContact_stored_string").stream().findFirst().orElse(null);
			if(entiteValeur != null)
				w.l(entiteNumero++ == 0 ? "" : ", ", "\"infoContact\": ", w.q(entiteValeur));

			w.l("}");
		}
		return Future.succeededFuture(OperationResponse.completedWithJson(buffer));
	}
} 
