package org.computate.enUS.cardiac.warfarin;

import java.time.LocalDate;
import org.computate.enUS.cardiac.chain.Chain;
import org.computate.site.course.c000.cluster.Cluster;
import org.computate.frFR.cardiaque.couverture.Couverture;

public class InrEntry extends InrEntryGen<Cluster> {

	/**	
	 *	User primary key.
	 **/
	protected void _utilisateurPk(Couverture<Long> c) {
	}

	protected void _dateInr(Couverture<LocalDate> c) {
		c.o(LocalDate.now());
	}

	protected void _dateReverifier(Couverture<LocalDate> c) {

	}

	protected void _currentDosageText(Chain o) {
	}

	protected void _currentGoal(Chain o) {
	}

	protected void _currentDosage(Chain o) {
	}

	protected void _currentMedication(Chain o) {
	}

	protected void _dosageChange(Chain o) {
		o.tout(dateInr.format(FORMAT_dateMedicalCourt), " INR @ ");
	}

	protected void _additionalNotes(Chain o) {
	}

	protected void _contactInfo(Chain o) {
	}
}
