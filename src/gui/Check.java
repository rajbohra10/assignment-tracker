	package gui;
import java.util.Date;

import javax.swing.JOptionPane;
public class Check {
	private int hh;
	private int mm;
	private String s;
	private int dd;
	private int MM;
	private int yy;
	private String subject, topic, deadline;
	public void CheckAlarm(int hh, int mm, String s, String subject, String topic, String deadline)
	{
		this.hh = hh;
		this.mm = mm;
		this.s = s;
		this.subject = subject;
		this.topic = topic;
		this.deadline = deadline;
		dd = Integer.parseInt(s.substring(0, 2));
		MM = Integer.parseInt(s.substring(3, 5));
		yy = Integer.parseInt(s.substring(6));
	
		Thread t = new Thread() {
			public void run() {
				
				int wl =0;
				while(wl == 0) {
					Date date = new Date();
					int hour = date.getHours();
					int min = date.getMinutes();
					int day = date.getDate();
					int month = date.getMonth();
					int year = date.getYear();
					
					if(hh == hour && mm == min && dd == day && MM == (month+1))
					{
						JOptionPane.showMessageDialog(null, "YOU  GOT  AN  ASSIGNMENT  TO  DO\n"+"Subject: "+subject+"\nTopic: "+topic+"\nDeadline: "+deadline, "Reminder", JOptionPane.INFORMATION_MESSAGE);
						break;
					}
				}
			}
		};
		t.setPriority(Thread.MIN_PRIORITY);
		t.start();
	}	
}
	