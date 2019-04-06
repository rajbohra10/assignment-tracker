package controller;

import java.util.List;

import gui.FormEvent;
import model.DataBase;
import model.Task;

public class Controller {
	DataBase db = new DataBase();
	
	public List<Task> getAssignment(){
		return db.getAssignment();
	}
	public void addTask(FormEvent ev) {
		String subject = ev.getSubject();
		String topic = ev.getTopic();
		String deadline = ev.getDeadline();
		
		Task task = new Task(subject, topic, deadline);
		db.addTask(task);
	}
}
