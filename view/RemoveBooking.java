package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.RemoveController;

public class RemoveBooking extends JDialog{
	private MainContainer mainCont;
	private int time;
	private int fieldID;
	private JTextField phone;
	
	public RemoveBooking(MainContainer m, int time, int fieldID){
		super();
		setBounds(100, 100, 296, 175);
	
		setTitle("Remove a booking");
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		this.phone = new JTextField();
		phone.setBounds(57, 36, 175, 20);
		getContentPane().add(phone);
		 
		// Button OK
		JButton btnOK = new JButton("OK");
		btnOK.addActionListener(new RemoveController(this));

		btnOK.setBounds(70, 93, 78, 23);

		getContentPane().add(btnOK);

		// Button Cancel
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new RemoveController(this));
		btnCancel.setBounds(158, 93, 74, 23);
		getContentPane().add(btnCancel);
		this.setVisible(true);
	}

	public MainContainer getMainCont() {
		return mainCont;
	}

	public int getTime() {
		return time;
	}

	public int getFieldID() {
		return fieldID;
	}

	public JTextField getPhone() {
		return phone;
	}
	
	
}
