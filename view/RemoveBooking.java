package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class RemoveBooking extends JDialog{
	private String sName;
	public RemoveBooking(){
		super();
		setBounds(100, 100, 296, 175);
	
		setTitle("Remove a booking");
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		// Create Input
		JLabel lab = new JLabel("Enter your phone number ");
		getContentPane().add(lab);
		final JTextField name = new JTextField();
		name.setBounds(57, 36, 175, 20);
		getContentPane().add(name);
		 
		// Button OK
		JButton btnOK = new JButton("OK");
		btnOK.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sName = name.getText();
				dispose();
			}
		});

		btnOK.setBounds(70, 93, 78, 23);

		getContentPane().add(btnOK);

		// Button Cancel
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sName = "";
				dispose();
			}
		});
		btnCancel.setBounds(158, 93, 74, 23);
		getContentPane().add(btnCancel);
		this.setVisible(true);
	}
}
