package edu.iut.gui.listeners;

import javax.swing.JOptionPane;

public class ApplicationWarningMessageDialog extends
		AbstractApplicationMessageDialog {

	@Override
	protected void showMessage(String level, String message) {
		/** UTILISER l'AIDE FORUNIR DANS L'ENNONCE */
		// les details j'ai ecrit dans la classe Error
		JOptionPane.showMessageDialog(null, message, level,
				JOptionPane.INFORMATION_MESSAGE, null);
	}

}
