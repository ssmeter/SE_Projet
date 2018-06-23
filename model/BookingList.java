package model;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javafx.util.converter.LocalDateStringConverter;

public class BookingList {
	private List<Booking> bookings;
	private LocalDate date;
	private DbMan db;
	
	public BookingList(){
		this.date = LocalDate.now();
		this.db = new DbMan();
		this.updateBookings();
	}
	
	private void updateBookings(){
		try {
			this.bookings = db.getBookings(date);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void setDate(LocalDate date) {
		this.date = date;
		this.updateBookings();
	}
	
	public LocalDate getDate(){
		return this.date;
	}

	public List<Booking> getBookings() {
		return bookings;
	}
	
	public void addBooking(int field, String phoneNumber, int time) {
		Booking b = new Booking(field, this.date, phoneNumber, time);
		try {
			//Add the booking to the database
			db.addBooking(b);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//Add the booking to the current ArrayList
		bookings.add(b);
	}	
	
	public boolean isBooked(int fid, int time){
		for(Booking temp : bookings){
			if(temp.getField() == fid && temp.getTime() == time)
				return true;
		}
		return false;
	}
	
	public Booking isGoodNumber(int fid, int time, String phone){
		for(Booking temp : bookings){
			if(temp.getField() == fid && temp.getTime() == time && temp.getPhoneNumber().equals(phone))
				return temp;
		}
		return null;
	}
	
	public void removeBooking(Booking b){
		this.bookings.remove(b);
	}
}