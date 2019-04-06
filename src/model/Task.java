package model;

public class Task {
	
	private String subject;
	private String topic;
	private String deadline;
	
	public Task(String subject, String topic, String deadline) {
		this.subject = subject;
		this.topic = topic;
		this.deadline  = deadline;
	}
	
	public String getSubject() {
		return subject;
	}
	public String getTopic() {
		return topic;
	}
	public String getDeadline() {
		return deadline;
	}
	
	
}
