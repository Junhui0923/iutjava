package edu.iut.gui.widget.agenda;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JPanel;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpinnerModel;

import edu.iut.app.ApplicationSession;

public class ControlAgendaViewPanel extends JPanel {

	CardLayout agendaViewLayout;
	JPanel contentPane;
	
	int selectedYear;
	int selectedMonth;
	int selectedDay;
	
	public ControlAgendaViewPanel(CardLayout layerLayout, final JPanel contentPane) {

		this.agendaViewLayout = layerLayout;
		this.contentPane = contentPane;
		/** EX3: REMPLACEMENT DU BOUTON NEXT */
		
		 Calendar calendar = Calendar.getInstance();
	     int selectedYear = calendar.get(Calendar.YEAR);
	     int selectedMonth = calendar.get(Calendar.MONTH);
	     int selectedDay = calendar.get(Calendar.DAY_OF_WEEK); 

	     
	     
	        SpinnerModel yearModel = new SpinnerNumberModel(selectedYear, //initial value
	        		selectedYear - 5, //min (dans notre cas 2010)
	        		selectedYear + 5, //max (dans notre cas 2020)
                    1);                //step
	     
	        String[] mois = ApplicationSession.instance().getMonths();
	        JComboBox comboBoxMois = new JComboBox(ApplicationSession.instance().getMonths());   
	        comboBoxMois.setSelectedItem(mois[selectedMonth]);
	        
	        String[] jours = ApplicationSession.instance().getDays();
	        JComboBox comboBoxJours = new JComboBox(ApplicationSession.instance().getDays());   
	        comboBoxJours.setSelectedItem(jours[selectedDay]);
	        

		Date today = new Date();
		  JSpinner s = new JSpinner(yearModel);
		  this.add(s);
		  this.add(comboBoxMois);
		  this.add(comboBoxJours);
		  
		
	}
	
	
	
	public int getYear() {
		return selectedYear;
	}
	public int getMonth() {
		return selectedMonth;
	}
	public int getDay() {
		return selectedDay;
	}
	
}
