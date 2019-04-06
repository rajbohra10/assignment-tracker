package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import controller.Controller;
	
	
public class MainFrame extends JFrame{
	
	private FormPanel formPanel;
	private Controller controller;
	private TablePanel tablePanel;
	public MainFrame() {
		super("Assignment Tracker");
		
		formPanel = new FormPanel();
		controller = new Controller();
		tablePanel = new TablePanel();
		setLayout(new BorderLayout());
		
		tablePanel.setData(controller.getAssignment());
		
		formPanel.setFormListener(new FormListener(){
			public void formEventOccurred(FormEvent ev) {
				
				controller.addTask(ev);
				tablePanel.refresh();
			}
		});
		
		
		add(formPanel, BorderLayout.WEST);
		add(tablePanel, BorderLayout.CENTER); 
		setVisible(true);
		setMinimumSize(new Dimension(700, 500));
		setLocation(300, 70);
		setSize(700, 500);
		
		
	}
}
