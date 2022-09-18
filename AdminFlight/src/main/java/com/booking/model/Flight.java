package com.booking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Flight {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int flightId;
	private String arrivalLoc;
	private String departureLoc;
	private String fleetName;
	private String model;
	private Integer remainingSeats;
	private String date;

	public Flight() {
		super();
	}

	@Override
	public String toString() {
		return "Flight [flightId=" + flightId + ", arrivalLoc=" + arrivalLoc + ", departureLoc=" + departureLoc
				+ ", fleetName=" + fleetName + ", model=" + model + ", remainingSeats=" + remainingSeats + ", date="
				+ date + "]";
	}

	public Flight(int flightId, String arrivalLoc, String departureLoc, String fleetName, String model,
			Integer remainingSeats,String date) {
		super();
		this.flightId = flightId;
		this.arrivalLoc = arrivalLoc;
		this.departureLoc = departureLoc;
		this.fleetName = fleetName;
		this.model = model;
		this.remainingSeats = remainingSeats;
		this.date = date;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public String getArrivalLoc() {
		return arrivalLoc;
	}

	public void setArrivalLoc(String arrivalLoc) {
		this.arrivalLoc = arrivalLoc;
	}

	public String getDepartureLoc() {
		return departureLoc;
	}

	public void setDepartureLoc(String departureLoc) {
		this.departureLoc = departureLoc;
	}

	public String getFleetName() {
		return fleetName;
	}

	public void setFleetName(String fleetName) {
		this.fleetName = fleetName;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Integer getRemainingSeats() {
		return remainingSeats;
	}

	public void setRemainingSeats(Integer remainingSeats) {
		this.remainingSeats = remainingSeats;
	}
	
}
