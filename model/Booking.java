package model;

import java.util.Date;

public class Booking {
	private Field field;
	private Date date;
	private String phoneNumber;
	/**
	 * @param field
	 * @param date
	 * @param phoneNumber
	 */
	public Booking(Field field, Date date, String phoneNumber) {
		super();
		this.field = field;
		this.date = date;
		this.phoneNumber = phoneNumber;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
}