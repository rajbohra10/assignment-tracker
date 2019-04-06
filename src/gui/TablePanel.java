package gui;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.Task;

public class TablePanel extends JPanel{
	
	private JTable table;
	private TaskTableModel tableModel;
	
	public TablePanel() {
		tableModel = new TaskTableModel();
		table = new JTable(tableModel); 
		
		
		setLayout(new BorderLayout());
		add(new JScrollPane(table), BorderLayout.CENTER);
	}
	
	public void setData(List<Task> list) {
		tableModel.setData(list);
	}
	
	public void refresh() {
		tableModel.fireTableDataChanged();
	}
}
