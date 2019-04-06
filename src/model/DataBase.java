package model;

import java.util.ArrayList;
import java.util.List;

public class DataBase {
	
	private ArrayList<Task> assignment;
	
	public DataBase() {
		assignment = new ArrayList<Task>();
	}
	
	public void addTask(Task task) {
		assignment.add(task);
	}
	
	public List<Task> getAssignment(){
		return assignment;
	}
}
