package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import view.MainContainer;

public class DatePickerController implements ActionListener{
	private MainContainer mc;
	
	public DatePickerController(MainContainer mc){
		this.mc = mc;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int day =this.mc.getDatePicker().getJDateInstantPanel().getModel().getDay();
		int month =this.mc.getDatePicker().getJDateInstantPanel().getModel().getMonth();
		int year = this.mc.getDatePicker().getJDateInstantPanel().getModel().getYear();
		this.mc.getBm().setDate(LocalDate.of(year, month+1, day));
		this.mc.updateButton();
	}
}