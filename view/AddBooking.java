package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.AddBookingController;
import model.Field;

public class AddBooking extends JFrame{
	private JTextField inputPhone;
	private MainContainer mainCont;
	private int time;
	private int fid;
	private JButton crenau;

	public AddBooking(MainContainer m, int time, int fid){
		super();
		this.mainCont = m;
		this.inputPhone = new JTextField(10);
		this.time = time;
		this.fid = fid;
		
	    this.setTitle("Add booking");
	    this.setSize(400, 200);
	    
	    this.add(new JLabel("Enter your phone number to confirm ?"), BorderLayout.NORTH);

	    this.add(inputPhone, BorderLayout.CENTER);
	    
	    JButton confirm = new JButton("Confirm");
	    confirm.addActionListener(new AddBookingController(this));
	    
	    this.add(confirm, BorderLayout.SOUTH);
	    this.setLocationRelativeTo(null);
    	this.setVisible(true);
	}
	
	public JTextField getInputPhone() {
		return inputPhone;
	}
	public MainContainer getMainCont() {
		return mainCont;
	}
	
	public int getTime() {
		return time;
	}

	public int getFid() {
		return fid;
	}

	public JButton getCrenau() {
		return crenau;
	}
}