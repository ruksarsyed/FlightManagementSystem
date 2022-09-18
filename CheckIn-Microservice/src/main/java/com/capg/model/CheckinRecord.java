package com.capg.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CheckinRecord {
	
	 @Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 private int checkinId;
	 private String lastName;
	 private String firstName;
	 private String seatNumber;
	 private String flightNumber;
	 private String flightDate;
	 private int pnr;
	public int getCheckinId() {
		return checkinId;
	}
	public void setCheckinId(int checkinId) {
		this.checkinId = checkinId;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSeatNumber() {
		return seatNumber;
	}
	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getFlightDate() {
		return flightDate;
	}
	public void setFlightDate(String flightDate) {
		this.flightDate = flightDate;
	}
	public int getPnr() {
		return pnr;
	}
	public void setPnr(int pnr) {
		this.pnr = pnr;
	}
	public CheckinRecord(int checkinId, String lastName, String firstName, String seatNumber, String flightNumber,
			String flightDate, int pnr) {
		super();
		this.checkinId = checkinId;
		this.lastName = lastName;
		this.firstName = firstName;
		this.seatNumber = seatNumber;
		this.flightNumber = flightNumber;
		this.flightDate = flightDate;
		this.pnr = pnr;
	}
	public CheckinRecord() {
		super();
	}
	@Override
	public String toString() {
		return "CheckinRecord [checkinId=" + checkinId + ", lastName=" + lastName + ", firstName=" + firstName
				+ ", seatNumber=" + seatNumber + ", flightNumber=" + flightNumber + ", flightDate=" + flightDate
				+ ", pnr=" + pnr + "]";
	}
	
	 

}
