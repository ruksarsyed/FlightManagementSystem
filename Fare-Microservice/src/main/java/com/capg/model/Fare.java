package com.capg.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Fare {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int fareid;
	private int fare;
	private String flightNumber;
	private String flightDate;
	
	public int getFare() {
		return fare;
	}
	
	public int getFareid() {
		return fareid;
	}

	public void setFareid(int fareid) {
		this.fareid = fareid;
	}

	public void setFare(int fare) {
		this.fare = fare;
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
	public Fare() {
		super();
	}

	public Fare(int fareid, int fare, String flightNumber, String flightDate) {
		super();
		this.fareid = fareid;
		this.fare = fare;
		this.flightNumber = flightNumber;
		this.flightDate = flightDate;
	}

	@Override
	public String toString() {
		return "Fare [fareid=" + fareid + ", fare=" + fare + ", flightNumber=" + flightNumber + ", flightDate="
				+ flightDate + "]";
	}
	
	
	

}
