package com.heytate.frFR.cardiaque.fil;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DaemonFabriqueFil implements ThreadFactory { 

	protected Logger log = LoggerFactory.getLogger(getClass());

	public DaemonFabriqueFil() {
		this(Executors.defaultThreadFactory());
	}

	private final ThreadFactory fabrique;

	/**	Construire une fabrique fil avec setDaemon(true) qui couvre la fabrique donnée.  **/
	public DaemonFabriqueFil(ThreadFactory fabrique) {
		if (fabrique == null)
			throw new NullPointerException("La fabrique ne peut pas être null. ");
		this.fabrique = fabrique;
	}

	@Override public Thread newThread(Runnable r) {
		final Thread t = fabrique.newThread(r);
		t.setDaemon(true);
		return t;
	}
}
