package edu.iut.gui.listeners;

import javax.swing.JOptionPane;

public class ApplicationErrorMessageDialog extends
		AbstractApplicationMessageDialog {

	@Override
	protected void showMessage(String level, String message) {
		/* UTILISER l'AIDE FORUNIR DANS L'ENNONCE */
		/*
		 * pour afficher il faut utiliser JOptionPane.showMessageDialog Vous
		 * avez deja import en haut. Afficher erreur,c'est
		 * JOptionPane.ERROR_MESSAGE
		 * https://openclassrooms.com/courses/apprenez-
		 * a-programmer-en-java/les-menus-et-boites-de-dialogue
		 * http://docs.oracle.com/javase/tutorial/uiswing/components/dialog.html
		 */
		JOptionPane.showMessageDialog(null, message, level,
				JOptionPane.ERROR_MESSAGE, null);
	}

}
