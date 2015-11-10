package edu.iut.app;

import java.util.ArrayList;

public class ApplicationErrorLog extends AbstractApplicationLog {

	protected ArrayList<IApplicationLogListener> listeners;

	/** Ajouter un tableau ou profiter de l'héritage ? */
	public ApplicationErrorLog() {
		super();
	}

	@Override
	// un tableau de IApplicationLogListener
	public void setMessage(String message) {
		this.message = message;
		super.fireMessage("[ERROR]", this.message);
	}

}
