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
			if(isPhoneNumber(this.screen.getInputPhone().getText())) {
				if (this.screen.getError().isVisible()) {
					this.screen.getError().setVisible(false);
				}
				this.screen.getMainCont().getBm().addBooking(this.screen.getFid(), this.screen.getInputPhone().getText(), this.screen.getTime());
				this.screen.getMainCont().updateButton();
				screen.setVisible(false);
			} else {
				this.screen.getError().setVisible(true);
			}
			
		}
	}
	
	public boolean isPhoneNumber(String input) {
		String pattern = "0\\d{8,9}";
		return input.matches(pattern);
	}
}