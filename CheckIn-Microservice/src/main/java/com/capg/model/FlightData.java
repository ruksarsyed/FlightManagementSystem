package com.capg.model;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(description="Flight Details For Booking")
public class FlightData {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@ApiModelProperty(notes="Unique id of the passenger")
	private int pnr;
	
	@ApiModelProperty(notes="Number of the Flight")
	private String flightNumber;
	
	@ApiModelProperty(notes="Origin of the Flight")
    private String origin;
	
	@ApiModelProperty(notes="Destination of the Flight")
    private String destination;
	
	@ApiModelProperty(notes="BookingDate of the Flight")
    private String bookingDate;
	
	@ApiModelProperty(notes="fare for the Flight")
	private int fare;
	
	@ApiModelProperty(notes="Status of the booking confirmation")
	private String status;
	
	@ApiModelProperty(notes="checkin")
	private boolean checkin;
	@ApiModelProperty(notes="Passenger Details for the Booking")
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="pid")
	@MapsId
    private Passenger p;
	
	public boolean isCheckin() {
		return checkin;
	}
	public void setCheckin(boolean checkin) {
		this.checkin = checkin;
	}
	public int getPnr() {
		return pnr;
	}

	public void setPnr(int pnr) {
		this.pnr = pnr;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}

	public int getFare() {
		return fare;
	}

	public void setFare(int fare) {
		this.fare = fare;
	}

	public Passenger getP() {
		return p;
	}

	public void setP(Passenger p) {
		this.p = p;
	}

	public FlightData() {
		super();
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public FlightData(int pnr, String flightNumber, String origin, String destination, String bookingDate, int fare,
			String status, boolean checkin, Passenger p) {
		super();
		this.pnr = pnr;
		this.flightNumber = flightNumber;
		this.origin = origin;
		this.destination = destination;
		this.bookingDate = bookingDate;
		this.fare = fare;
		this.status = status;
		this.checkin = checkin;
		this.p = p;
	}
	@Override
	public String toString() {
		return "FlightData [pnr=" + pnr + ", flightNumber=" + flightNumber + ", origin=" + origin + ", destination="
				+ destination + ", bookingDate=" + bookingDate + ", fare=" + fare + ", Status=" + status + ", checkin="
				+ checkin + ", p=" + p + "]";
	}

	
	
	
}
