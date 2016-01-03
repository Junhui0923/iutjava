package edu.iut.gui.frames;

import java.awt.CardLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import edu.iut.app.ApplicationSession;
import edu.iut.gui.widget.agenda.AgendaPanelFactory;
import edu.iut.gui.widget.agenda.ControlAgendaViewPanel;
import edu.iut.gui.widget.agenda.AgendaPanelFactory.ActiveView;


public class SchedulerFrame extends JFrame implements ActionListener {
	JPanel contentPane;
	CardLayout layerLayout;
	AgendaPanelFactory agendaPanelFactory;	
	JPanel dayView;
	JPanel weekView;
	JPanel monthView;
	
	protected void setupUI() {
		
		contentPane = new JPanel();
		layerLayout = new CardLayout();
		contentPane.setLayout(layerLayout);
		ControlAgendaViewPanel agendaViewPanel = new ControlAgendaViewPanel(layerLayout,contentPane);
		agendaPanelFactory = new AgendaPanelFactory();
		dayView = agendaPanelFactory.getAgendaView(ActiveView.DAY_VIEW);
		weekView = agendaPanelFactory.getAgendaView(ActiveView.WEEK_VIEW);
		monthView = agendaPanelFactory.getAgendaView(ActiveView.MONTH_VIEW);
		
		contentPane.add(dayView,ActiveView.DAY_VIEW.name());
		contentPane.add(weekView,ActiveView.WEEK_VIEW.name());
		contentPane.add(monthView,ActiveView.MONTH_VIEW.name());
	
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,agendaViewPanel, contentPane);
		this.setContentPane(splitPane);
		
		JMenuBar menuBar = new JMenuBar();
		JMenu menuFile,menuEdit,menuView,subMenuEdit;
		JMenuItem menuItemSemaine,menuItemJour,menuItemMois, menuItemLoad,menuItemSave,menuItemNew;

		
		
		/* File Menu */
		/** EX4 : MENU : UTILISER L'AIDE FOURNIE DANS LE TP**/
		
		menuFile = new JMenu("File");
		menuEdit = new JMenu("Edit");
	
		menuView = new JMenu("View");
		
		menuEdit.add(menuView);
		menuBar.add(menuFile);
		menuBar.add(menuEdit);

	   
		menuItemJour = new JMenuItem("Days");
		menuItemSemaine = new JMenuItem("Weeks");
		menuItemMois = new JMenuItem("Months");
		menuItemLoad = new JMenuItem("Load");
		menuItemSave = new JMenuItem("Save");
		menuItemNew = new JMenuItem("New");
		
		menuView.add(menuItemJour);
		menuView.add(menuItemSemaine);		
		menuView.add(menuItemMois);
		
		menuFile.add(menuItemNew);
		menuFile.add(menuItemLoad);
		menuFile.add(menuItemSave);
	
		menuItemJour.addActionListener(this);
		menuItemSemaine.addActionListener(this);
		menuItemMois.addActionListener(this);
		menuItemLoad.addActionListener(this);
		menuItemSave.addActionListener(this);
		menuItemNew.addActionListener(this);
		
		this.setJMenuBar(menuBar);
		this.pack();
		layerLayout.next(contentPane);
		
		/*
		
		menuItemJour.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				 layerLayout.show(contentPane, ActiveView.DAY_VIEW.name());
				
			}			
		});
		menuItemSemaine.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				layerLayout.show(contentPane, ActiveView.WEEK_VIEW.name());
				
			}			
		});
		menuItemMois.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				layerLayout.show(contentPane, ActiveView.MONTH_VIEW.name());
				
			}			
		});
	
		*/
		
		
		
	}

	public SchedulerFrame() {
		super();
		
		addWindowListener (new WindowAdapter(){
			public void windowClosing (WindowEvent e){
				System.exit(0);

			}

		});
		contentPane = null;
		dayView = null;
		weekView = null;
		monthView = null;
		agendaPanelFactory = null;
		setupUI();

	}
	public SchedulerFrame(String title) {
		super(title);
		addWindowListener (new WindowAdapter(){
			public void windowClosing (WindowEvent e){			
				System.exit(0);
				
			}
		});
		setupUI();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch(e.getActionCommand())
		{
		case "Days" : 	 layerLayout.show(contentPane, ActiveView.DAY_VIEW.name()); break;
		case "Weeks" : 	layerLayout.show(contentPane, ActiveView.WEEK_VIEW.name()); break;
		case "Months" :  layerLayout.show(contentPane, ActiveView.MONTH_VIEW.name()); break;
		default :  JOptionPane.showMessageDialog(this, "La fonctionnalité n'est pas implémentée", "Erreur", JOptionPane.ERROR_MESSAGE);break;
			 
		
		}
	}


	
}
