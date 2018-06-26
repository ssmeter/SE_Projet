package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import controller.RemoveController;

public class RemoveBooking extends JDialog{
	private MainContainer mainCont;
	private int time;
	private int fieldID;
	private JTextField phone;
	
	public RemoveBooking(MainContainer m, int time, int fieldID){
		super();
		setBounds(100, 100, 440, 300);

		setTitle("Remove a booking");
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JLabel desc = new JLabel("Enter your phone number to confirm");
	    desc.setFont(new Font("Arial", Font.PLAIN, 20));
	    desc.setHorizontalAlignment(JLabel.CENTER);
	    desc.setBounds(10,40,400,20);
	    getContentPane().add(desc);
		
		this.phone = new JTextField();
		phone.setBounds(54, 82, 313, 40);
		phone.setBorder(new EmptyBorder(10,10,10,10));
	    Font inputFont = new Font("Arial", Font.PLAIN, 16);
	    phone.setFont(inputFont);
		getContentPane().add(phone);
		 
		
		Border emptyBorder = BorderFactory.createEmptyBorder();
		// Button OK
		JButton btnOK = new JButton("OK");
		btnOK.setBorder(emptyBorder);
	    btnOK.setBackground(Color.decode("#13FF76"));
		btnOK.addActionListener(new RemoveController(this));
		btnOK.setBounds(55, 143, 153, 50);

		getContentPane().add(btnOK);

		// Button Cancel
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new RemoveController(this));
		btnCancel.setBounds(213, 143, 153, 50);
		btnCancel.setBorder(emptyBorder);
		btnCancel.setBackground(Color.decode("#13FF76"));
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
