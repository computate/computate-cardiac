package org.computate.site.course.c000.cluster;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import org.computate.enUS.wrap.Wrap;
import org.computate.enUS.cardiac.page.PageLayout;
import org.computate.frFR.cardiaque.requete.RequeteSite;

public class Cluster extends ClusterGen<Object> {

	public static DateTimeFormatter FORMAT_dateMedicalCourt = DateTimeFormatter.ofPattern("M/d/yyyy", Locale.FRANCE);

	protected void __siteRequest(Couverture<RequeteSite> c) {}

	protected void _page_(Couverture<PageLayout> c) {}

	protected void _pk(Couverture<Long> c) {}

	protected void _id(Couverture<String> c) {
		if(pk != null)
			c.o(pk.toString());
	}

	protected void __created(Couverture<LocalDateTime> c) {}

	protected void __modified(Couverture<LocalDateTime> c) {}

	protected void __userId(Couverture<String> c) {}

	protected void __clusterCanonicalName(Couverture<String> c) {
		String o = getClass().getCanonicalName();
		c.o(o);
	}

	protected void __clusterSimpleName(Couverture<String> c) {
		String o = getClass().getSimpleName();
		c.o(o);
	}

	protected void __deleted(Couverture<Boolean> c) {
		Boolean o = false;
		c.o(o);
	}
}
