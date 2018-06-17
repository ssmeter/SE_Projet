package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BookingList {
	private List<Booking> bookings = new ArrayList<>();
	private Date date;
	
	public void setDate(Date date) {
		this.date = date;
	}

	public List<Booking> getBookings() {
		return bookings;
	}
	
	public boolean addBooking(Field field, Date date, String phoneNumber) {
		Booking b = new Booking(field, date, phoneNumber);
		return bookings.add(b);
	}	
}