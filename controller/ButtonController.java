package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import model.BookingList;
import model.FieldMan;
import view.AddBooking;
import view.MainContainer;
import view.RemoveBooking;

public class ButtonController implements ActionListener{
	private MainContainer screen;
	
	public ButtonController(MainContainer screen){
		super();
		this.screen = screen;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		int indexField = -1;
		JButton temp = null;
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 12; j++){
				if(this.screen.getButtonGrid()[j][i] == e.getSource()){
					temp = this.screen.getButtonGrid()[j][i];
					indexField = i;
					break;
				}
			}
		}
		
		int fieldID = this.screen.getFm().getFields().get(indexField).getfID();
		int time = Integer.parseInt(temp.getText().substring(0, temp.getText().length()-1));
		if(temp.getBackground() == Color.green){
			new AddBooking(screen, time, fieldID).setVisible(true);
		}else{
			new RemoveBooking(screen, time, fieldID);
		}
	}
}
