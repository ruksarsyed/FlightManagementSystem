package com.booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booking.model.Flight;
import com.booking.service.FlightService;

@RestController
@RequestMapping("/flight")
public class FlightController {

	@Autowired
	FlightService flightService;
	
	@GetMapping("/get-all-flights")
	public List<Flight> getAllFlights(){
		//System.out.println("Hello");
		return flightService.getAllFlightDetails();
	}
	
	@GetMapping("/get-flight-by-id/{flightId}")
	public Flight getFlightById(
			@PathVariable("flightId") int flightId){
		return flightService.getFlightByFlightId(flightId);
	}
	
	@PostMapping("/add-one-flight")
	public String addOneFlight(
			@RequestBody Flight flight){
		return flightService.addOneFlight(flight);
	}
	
	@GetMapping("/find/{model}/{date}")
	public Flight getFlight(@PathVariable String model,@PathVariable String date) {
		return flightService.findByModelandDate(model,date);
	}
	
	@GetMapping("/findbyData/{date}/{arrivalLoc}/{departureLoc}")
	public List<Flight> getFlightByDateAndArrivalLocAndDepartureLoc(
			@PathVariable String date,@PathVariable String arrivalLoc,@PathVariable String departureLoc){
		return flightService.findByDateAndArrivalLocAndDepartureLoc(date,arrivalLoc,departureLoc);	
	}
	
	
	@GetMapping("/findbyDate/{date}")
	public List<Flight> getFlightByDate(
			@PathVariable String date){
		return flightService.findByDate(date);	
	}
	
	@PutMapping("/update-flight")
	public Flight updateFlight(
			@RequestBody Flight flight){
		return flightService.updateFlightDetail(flight);
	}
	
	
	@DeleteMapping("/delete-flight-by-id/{flightId}")
	public String deleteFlightByid(
			@PathVariable("flightId") int flightId){
		return flightService.deleteByFlightId(flightId);
	}
	
	@DeleteMapping("/delete-all-flights")
	public String deleteAllFlights(){
		return flightService.deleteAllFlightDetails();
	}
	
	
}
