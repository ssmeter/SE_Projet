package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import model.Booking;
import model.BookingList;
import view.MainContainer;
import view.RemoveBooking;

public class RemoveController implements ActionListener{
	private RemoveBooking rb;
	
	public RemoveController(RemoveBooking rb){
		this.rb = rb;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String str = ((JButton)e.getSource()).getText();
		if(str.equals("OK")){
			if(Booking.isPhoneNumber(this.rb.getPhone().getText())) {
				Booking b = this.rb.getMainCont().getBm().isGoodNumber(this.rb.getFieldID(), this.rb.getTime(), this.rb.getPhone().getText());
				if(b != null){
					this.rb.getMainCont().getBm().removeBooking(b);
					this.rb.getMainCont().updateButton();
					rb.setVisible(false);
				} else {
					this.rb.getError().setText("Phone number does not match.");
					this.rb.getError().setForeground(Color.RED);
				}
			} else {
				this.rb.getError().setForeground(Color.RED);
			}	
		} else{
			rb.setVisible(false);
		}
	}
	

}
