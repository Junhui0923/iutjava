package edu.iut.app;

import java.util.ArrayList;

public class ApplicationInfoLog extends AbstractApplicationLog {

	protected ArrayList<IApplicationLogListener> listeners;

	/** Ajouter un tableau ou profiter de l'héritage ? */
	public ApplicationInfoLog() {
		super();
	}

	@Override
	public void setMessage(String message) {
		this.message = message;
		super.fireMessage("[INFO]", this.message);
	}

}
