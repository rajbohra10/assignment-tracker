package gui;

import java.util.EventObject;

public class FormEvent{
	
	private String subject;
	private String topic;
	private String deadline;
	
	
	public FormEvent(String subject, String topic, String deadline) {
		this.subject = subject;
		this.topic = topic;
		this.deadline = deadline;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getDeadline() {
		return deadline;
	}
	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}
	
}
