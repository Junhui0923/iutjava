package edu.iut.app;

import java.util.ResourceBundle;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ApplicationSession {
	
	// ______ Exercice 1 ______
	protected ResourceBundle resourceBundle;
	protected Locale locale;
	
	// ______ Exercice 2 ______
	protected Logger sessionGuiLogger;
	protected Logger sessionExceptionLogger;


	/*Qu'est ce qu'un singleton ?*/
	private static  ApplicationSession session = null;
	private ApplicationSession() {
		/* Definir US comme locale par d�faut */
		Locale.setDefault(new Locale("US"));
		
		locale = Locale.getDefault();
		resourceBundle = ResourceBundle.getBundle("edu/iut/resources/strings/res", locale);
		/* Initialiser le logger */
		sessionGuiLogger = Logger.getLogger("GuiLogger"); 
		/* Touls les message doivent �tre affich� */
		sessionGuiLogger.setLevel(Level.ALL);//pour le ALL c'est obligatoire de mettre max
		/* Logger pour exception */
		sessionExceptionLogger = Logger.getLogger("Exception");
		/* Touls les message doivent �tre affich� */
		sessionExceptionLogger.setLevel(Level.ALL);	
		
	}
	
	
	static public ApplicationSession instance() {
		if (session == null) {			
			session = new ApplicationSession();
		}
		return session;
	}
	
	public Logger getGUILogger() {
		return sessionGuiLogger;
	}
	public Logger getExceptionLogger() {
		return sessionExceptionLogger;
	}
	
	public void setLocale(Locale locale){
		this.locale = locale;
		Locale.setDefault(this.locale);
		/* r�cup�rer les resources */
		resourceBundle = ResourceBundle.getBundle("edu/iut/resources/strings/res", locale);
	}
	
	public String getString(String key) {
		return resourceBundle.getString(key);
	}

	
	
}
