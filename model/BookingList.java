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

	public List<Booking> getBookings() {
		return bookings;
	}
	
	public void addBooking(int field, LocalDate date, String phoneNumber, int time) {
		Booking b = new Booking(field, date, phoneNumber, time);
		try {
			//Add the booking to the database
			db.addBooking(b);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//Add the booking to the current ArrayList
		bookings.add(b);
	}	
}