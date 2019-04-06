package gui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Task;

public class TaskTableModel extends AbstractTableModel{
	
	private List<Task> list;
	private  String[] colNames = {"Subject", "Topic", "Deadline"};
	public TaskTableModel() {
	}
	
	public String getColumnName(int col) {
		return colNames[col];
	}

	public void setData(List<Task> list) {
		this.list = list;
	}

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public int getRowCount() {
		return list.size();
	}
	@Override
	public String getValueAt(int row, int col) {
		Task task = list.get(row);
		
		switch(col) {
		case 0:
			return task.getSubject();
		case 1:
			return task.getTopic();
		case 2:
			return task.getDeadline();
		}
		return null;
	}

}
