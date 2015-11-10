package edu.iut.app;

public interface IApplicationLog {
	/* TP1 : Creerr les methodes : */
	/* - setMessage */
	public void setMessage(String message);

	/* - getMessage */
	public String getMessage();

	/* - addListener */
	public void addListener(IApplicationLogListener listener);

	/* - getApplicationLogListeners(); */
	public IApplicationLogListener[] getApplicationLogListeners();// soit
																	// arraylist

}
