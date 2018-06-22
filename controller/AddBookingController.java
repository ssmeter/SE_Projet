package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import view.AddBooking;

public class AddBookingController implements ActionListener{
	private AddBooking screen;
	
	public AddBookingController(AddBooking screen){
		this.screen = screen;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String str = ((JButton)e.getSource()).getText();
		if(str.equals("Confirm")){
			this.screen.getMainCont().getBm().addBooking(this.screen.getFid(), this.screen.getInputPhone().getText(), this.screen.getTime());
			this.screen.getCrenau().setBackground(Color.RED);
			screen.setVisible(false);
		}
	}
}