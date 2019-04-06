package gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;

import com.toedter.calendar.JDateChooser;

public class FormPanel extends JPanel{
	private JLabel subjectLabel;
	private JLabel topicLabel;
	private JLabel deadlineLabel;
	private JLabel reminderLabel;
	private JTextField topicField;
	private JComboBox subjectCombo;
	private JButton doneButton;
	private JButton exitButton;
	private JDateChooser deadlineSet;
	private JDateChooser reminderSet;
	private Date date;
	private JSpinner hourSpinner;
	private JSpinner minuteSpinner;
	private SpinnerNumberModel hourModel;
	private SpinnerNumberModel minuteModel;
	private DateFormat reminderFormat;
	private DateFormat deadlineFormat;
	private Check d;
	private FormListener formListener;
	
	public FormPanel()
	{
		
		subjectLabel = new JLabel("Subject : ");
		topicLabel = new JLabel("Topic : ");
		deadlineLabel = new JLabel("Deadline : ");
		reminderLabel = new JLabel("Set Reminder ");
		doneButton = new JButton("Done");
		exitButton = new JButton("EXIT");
		topicField = new JTextField(10);	
		subjectCombo = new JComboBox();
		
		DefaultComboBoxModel subjectModel = new DefaultComboBoxModel();
		subjectModel.addElement("Data Structure");
		subjectModel.addElement("DIS");
		subjectModel.addElement("DLDA");
		subjectModel.addElement("ECCF");
		subjectModel.addElement("OOPM");
		subjectModel.addElement("Maths-III");
		
		subjectCombo.setModel(subjectModel);
		subjectCombo.setSelectedIndex(4);
		subjectCombo.setEditable(true);
		Dimension dsub = getPreferredSize();
		dsub.width = 113;
		dsub.height = 20;
		subjectCombo.setPreferredSize(dsub);
		
		doneButton.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent arg0) {
			
			int hh = (int)hourSpinner.getValue();
			int mm = (int)minuteSpinner.getValue();
			try {
				d = new Check();
				
				Date date = reminderSet.getDate();
				reminderFormat = new SimpleDateFormat("dd-MM-yy");
				String reminder = reminderFormat.format(date);
				String subject = (String)subjectCombo.getSelectedItem();
				String topic = topicField.getText();
				Date date1 = deadlineSet.getDate();
				deadlineFormat = new SimpleDateFormat("MMM dd, yyyy");
				String deadline = deadlineFormat.format(date1);
				
				d.CheckAlarm(hh, mm, reminder, subject, topic, deadline);
				FormEvent ev = new FormEvent(subject, topic, deadline);
				if(formListener != null) {
					formListener.formEventOccurred(ev);
					JOptionPane.showMessageDialog(null, "Reminder is added successfully!");
				}
				subjectCombo.setSelectedIndex(4);
				topicField.setText("");
				reminderSet.setDate(null);
				deadlineSet.setDate(null);
				
				
			}catch(Exception e) {
				
				JOptionPane jdp = new JOptionPane();
				jdp.showMessageDialog(null, "Fill in all the required Details");
				
			}
			
			}
		
	});
		
		exitButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		Dimension dim = getPreferredSize();
		dim.width = 113;
		dim.height = 20;
		
		
		deadlineSet = new JDateChooser();
		deadlineSet.setPreferredSize(dim);
		deadlineSet.getJCalendar().setMinSelectableDate(new Date());
		
		
		reminderSet = new JDateChooser();
		reminderSet.setPreferredSize(dim);
		reminderSet.getJCalendar().setMinSelectableDate(new Date());
		
		date = new Date();
		
		hourModel = new SpinnerNumberModel(date.getHours(), 0, 24, 1);
		hourSpinner = new JSpinner(hourModel);
		
		
		minuteModel = new SpinnerNumberModel(date.getMinutes(), 00, 59, 1);
		minuteSpinner = new JSpinner(minuteModel);
		
		Dimension d1 = getPreferredSize();
		d1.width = 300;
		setLayout(new GridBagLayout());
		setPreferredSize(d1);
		Border innerBorder = BorderFactory.createTitledBorder("Add new Assignment");
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
		GridBagConstraints gc = new GridBagConstraints();
		gc.gridx = 0;
		gc.gridy = 0;
		gc.weightx = 1;
		gc.weighty = 1;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 10);
		add(subjectLabel, gc);
		
		gc.gridx = 1;
		gc.gridy = 0;	
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 10, 0, 0);
		add(subjectCombo, gc);
		
		gc.gridx = 0;
		gc.gridy = 1;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 10, 0, 10);
		add(topicLabel, gc);
		
		gc.gridx = 1;
		gc.gridy = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		add(topicField, gc);
		
		gc.gridx = 0;
		gc.gridy = 2;
		gc.anchor = GridBagConstraints.LINE_END;
		add(deadlineLabel, gc);
		
		gc.gridx = 1;
		gc.gridy = 2;
		gc.anchor = GridBagConstraints.LINE_START;
		add(deadlineSet, gc);
		
		gc.gridx = 0;
		gc.gridy = 3;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 30, 0, 0);
		add(reminderLabel, gc);
		
		gc.gridx = 0;
		gc.gridy = 4;
		gc.insets = new Insets(0, 10, 0, 10);
		gc.anchor = GridBagConstraints.LINE_END;
		add(new JLabel("Date : "), gc);
		
		gc.gridx = 1;
		gc.gridy = 4;
		gc.anchor = GridBagConstraints.LINE_START;
		add(reminderSet, gc);
		
		gc.gridx = 0;
		gc.gridy = 5;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 10, 0, 10);
		add(new JLabel("Time : "), gc);
		
		gc.gridx = 1;
		gc.gridy = 5;
		gc.weightx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		add(hourSpinner, gc);
		
		gc.gridx = 2;
		gc.gridy = 5;
		gc.insets = new Insets(0, -70, 0, 0);
		add(new JLabel(":"), gc);
		
		gc.gridx = 3;
		gc.gridy = 5;
		gc.weightx = 1;
		gc.insets = new Insets(0, -70, 0, 0);
		gc.anchor = GridBagConstraints.LINE_START;
		add(minuteSpinner, gc);

		gc.gridx = 1;
		gc.gridy = 6;
		gc.weighty = 3;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		gc.insets = new Insets(30, 30, 0, 15);
		add(doneButton, gc);
		
		gc.gridx = 0;
		gc.gridy = 6;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(30, 50, 0, 15);
		add(exitButton, gc);
		

	}	
	
	
	public void setFormListener(FormListener listener) {
		this.formListener = listener;
	}
}
	