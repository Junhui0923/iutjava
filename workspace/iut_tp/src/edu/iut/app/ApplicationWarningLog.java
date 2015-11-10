package edu.iut.app;

import java.util.ArrayList;

public class ApplicationWarningLog extends AbstractApplicationLog {

	protected ArrayList<IApplicationLogListener> listeners;

	/** Ajouter un tableau ou profiter de l'héritage ? */
	public ApplicationWarningLog() {
		super();
	}

	@Override
	public void setMessage(String message) {
		this.message = message;
		super.fireMessage("[WARNING]", this.message);
	}
}
