package org.computate.frFR.cardiaque.warfarin;

import java.util.List;

import org.computate.frFR.cardiaque.couverture.Couverture;
import org.computate.frFR.cardiaque.page.MiseEnPage;
import org.computate.frFR.cardiaque.recherche.ListeRecherche;
import org.computate.frFR.cardiaque.utilisateur.UtilisateurSite;

public class CalculInrPage extends CalculInrPageGen<MiseEnPage> { 

	@Override public void initLoinCalculInrPage() {
		initCalculInrPage();
		super.initLoinMiseEnPage(requeteSite_);
	}

	/** 
	 * {@inheritDoc}
	 * 
	 **/      
	protected void _utilisateurSiteRecherche(ListeRecherche<UtilisateurSite> o) {
		o.setC(UtilisateurSite.class);
		o.setQuery("*:*");
		o.setRows(1);
		o.addFilterQuery("classeNomCanonique_indexed_strings:" + getClass().getCanonicalName());
	}

	/**
	 * {@inheritDoc}
	 * recherche: utilisateurSiteRecherche
	 **/
	protected void _utilisateurSite(Couverture<UtilisateurSite> c) {
		if(utilisateurSiteRecherche.size() > 0)
			c.o(utilisateurSiteRecherche.first());
	}

	/**
	 * {@inheritDoc}
	 * 
	 **/    
	protected void _calculsInrRecherche(ListeRecherche<CalculInr> o) {
		o.setC(CalculInr.class);
		o.setQuery("*:*");
		o.setRows(10);
		o.addFilterQuery("classeNomCanonique_indexed_strings:" + getClass().getCanonicalName());
	}

	/**
	 * {@inheritDoc}
	 * 
	 **/
	protected void _calculsInr(List<CalculInr> c) {
		calculsInr.addAll(calculsInrRecherche.getList());
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 **/
	protected void _calculInr(Couverture<CalculInr> c) {
		if(calculsInr.size() == 1)
			c.o(calculsInr.get(0));
	}

	@Override protected void _pageH1(Couverture<String> c) {  
		if(calculInr == null)
			c.o("Calculs INR");
		else
			c.o("Calcul INR pour " + utilisateurSite.getUtilisateurNomComplet());
	}
}
