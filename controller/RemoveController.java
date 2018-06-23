package controller;

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
			Booking b = this.rb.getMainCont().getBm().isGoodNumber(this.rb.getFieldID(), this.rb.getTime(), this.rb.getPhone().getText());
			if(b != null){
				this.rb.getMainCont().getBm().removeBooking(b);
				rb.setVisible(false);
			}
			//else
			
		}else{
			rb.setVisible(false);
		}
	}
	

}
