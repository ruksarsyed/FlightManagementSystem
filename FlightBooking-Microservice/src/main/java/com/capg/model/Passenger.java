package com.capg.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(description="Passenger details with name and gender")
public class Passenger {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@ApiModelProperty(notes="Unique id of the passenger")
	private int pid;
	@ApiModelProperty(notes="Passenger first Name")
	private String firstname;
	@ApiModelProperty(notes="Passenger last Name")
	private String lastname;
	@ApiModelProperty(notes="Passenger gender")
	private String gender;
	@ApiModelProperty(notes="seat number")
	private String seatNumber;
	
	public String getSeatNumber() {
		return seatNumber;
	}
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Passenger() {
		super();
	}
	public Passenger(int pid, String firstname, String lastname, String gender, String seatNumber) {
		super();
		this.pid = pid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.gender = gender;
		this.seatNumber = seatNumber;
	}
	@Override
	public String toString() {
		return "Passenger [pid=" + pid + ", firstname=" + firstname + ", lastname=" + lastname + ", gender=" + gender
				+ ", seatNumber=" + seatNumber + "]";
	}
	
	
	

}
