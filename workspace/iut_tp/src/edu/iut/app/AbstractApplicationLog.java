package edu.iut.app;

import java.util.ArrayList;

public abstract class AbstractApplicationLog implements IApplicationLog {

	protected String message;
	/** TP1 : Tableau au sens des collections **/
	protected ArrayList<IApplicationLogListener> listeners;// utiliser arraylist

	public AbstractApplicationLog() {
		message = null;
		listeners = new ArrayList<IApplicationLogListener>();// Type Tableau
																// (ArrayList)
	}

	/** TP1 : Fonction venant de l'interface par héritage */

	@Override
	public abstract void setMessage(String message);

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addListener(IApplicationLogListener listener) {
		// TODO Auto-generated method stub
		listeners.add(listener);
	}

	@Override
	public IApplicationLogListener[] getApplicationLogListeners() {
		// TODO Auto-generated method stub
		return (IApplicationLogListener[]) listeners.toArray();
	}

	/** Listener action */
	protected void fireMessage(String level, String message) {
		for (IApplicationLogListener listener_i : listeners) {
			listener_i.newMessage(level, message);
		}
	}
}
