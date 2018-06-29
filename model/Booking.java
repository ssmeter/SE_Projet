package model;

import java.time.LocalDate;
import java.util.Date;

public class Booking {
	private int bID;
	private int field;
	private LocalDate date;
	private String phoneNumber;
	private int time;
	
	/**
	 * @param field
	 * @param date
	 * @param phoneNumber
	 */
	public Booking(int field, LocalDate date, String phoneNumber, int time) {
		super();
		this.field = field;
		this.date = date;
		this.phoneNumber = phoneNumber;
		this.time = time;
	}
	public int getbID() {
		return bID;
	}

	public void setbID(int bID) {
		this.bID = bID;
	}

	public int getField() {
		return field;
	}
	public LocalDate getDate() {
		return date;
	}
	public int getTime() {
		return time;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public static boolean isPhoneNumber(String input) {
		String pattern = "0\\d{8,9}";
		return input.matches(pattern);
	}
}