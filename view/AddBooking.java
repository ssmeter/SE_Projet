package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import controller.AddBookingController;
import model.Field;

public class AddBooking extends JFrame{
	private JTextField inputPhone;
	private MainContainer mainCont;
	private int time;
	private int fid;
	private JButton crenau;
	private JLabel error;

	public AddBooking(MainContainer m, int time, int fid){
		super();
		this.mainCont = m;
		this.inputPhone = new JTextField(10);
		this.time = time;
		this.fid = fid;
		
	    this.setTitle("Add booking");
//	    this.setSize(400, 600);
	   
	    JPanel container = new JPanel();
	    container.setLayout(new BorderLayout(10,20));
	    container.setBorder(new EmptyBorder(30,50,30,50));
	   
	    JLabel desc = new JLabel("Enter your phone number to confirm");
	    desc.setFont(new Font("Arial", Font.PLAIN, 20));
	    desc.setHorizontalAlignment(JLabel.CENTER);
	    container.add(desc, BorderLayout.NORTH);

	    inputPhone.setBorder(new EmptyBorder(10,10,10,10));
	    Font inputFont = new Font("Arial", Font.PLAIN, 16);
	    inputPhone.setFont(inputFont);
	    inputPhone.setHorizontalAlignment(JTextField.CENTER);
	    container.add(inputPhone, BorderLayout.CENTER);
	    
	    error = new JLabel("Invalid phone number.");
	    error.setForeground(container.getBackground());
	    error.setPreferredSize(new Dimension(20,20));
	    
	    Border emptyBorder = BorderFactory.createEmptyBorder();
	    JButton confirm = new JButton("Confirm");
	    confirm.setPreferredSize(new Dimension(10,50));
	    confirm.setBackground(Color.decode("#13FF76"));
	    confirm.setBorder(emptyBorder);
	    confirm.addActionListener(new AddBookingController(this));
	    
	    JPanel panel = new JPanel();
	    panel.setLayout(new BorderLayout());
	    
	    panel.add(error, BorderLayout.SOUTH);
	    panel.add(confirm, BorderLayout.NORTH);

	    container.add(panel, BorderLayout.SOUTH);
	    
	    this.add(container);
	    this.pack();
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

	public JLabel getError() {
		return error;
	}
	
	
}