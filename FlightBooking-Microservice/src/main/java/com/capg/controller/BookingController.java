package com.capg.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.capg.model.Flight;
import com.capg.model.FlightData;
import com.capg.model.Passenger;
import com.capg.repository.BookingRepository;
import com.capg.service.BookingService;
import com.capg.service.EmailSenderService;

import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/booking")
public class BookingController {
	
	@Autowired
	BookingService bs;
	
	@Autowired
	EmailSenderService ess;
	
	@Autowired
	BookingRepository repo;
	
	@Autowired
	RestTemplate restTemplate;
	
	private static final String FLIGHT_URL="http://ADMIN-MICROSERVICE/flight/findbyData";
	
	@PostMapping("/createbooking")
	@ApiOperation(value="Creates a booking with PNR number",response=FlightData.class)
	public String addBookingDetails(@RequestBody FlightData f) {
		//ResponseEntity<FlightData> fd=restTemplate.getForEntity(FLIGHT_URL+"/"+f.getBookingDate()+"/"+f.getOrigin()+"/"+f.getDestination(), FlightData.class);
		return  bs.addBooking(f);
	}

	@GetMapping("/findbyData/{date}/{arrivalLoc}/{departureLoc}")
	public Flight[] getFlightByDateAndArrivalLocAndDepartureLoc(
			@PathVariable String date,@PathVariable String arrivalLoc,@PathVariable String departureLoc){
		Flight[] flight=restTemplate.getForObject(FLIGHT_URL+"/"+date+"/"+arrivalLoc+"/"+departureLoc, Flight[].class);
		
		return flight;
	}
	
	@GetMapping("/getbooking")
	@ApiOperation(value="Gets all booking details",response=FlightData.class)
	public List<FlightData> getBooking(){
		return bs.getBooking();
	}
	
	@GetMapping("/getbyId/{pid}")
	@ApiOperation(value="Gets the Passenger details by an Id",response=Passenger.class)
	public Optional<Passenger> getById(@PathVariable int pid) {
		return bs.getbyId(pid);
	}
	
	@GetMapping("/getbypnr/{pnr}")
	@ApiOperation(value="Gets the Passenger details by an Id",response=FlightData.class)
	public Optional<FlightData> getBypnr(@PathVariable int pnr) {
		return bs.getbypnr(pnr);
	}

	@ApiOperation(value="Gets the Booking details by an pnr",response=FlightData.class)
	@GetMapping("/getBooking/{pnr}")
	public ResponseEntity<FlightData> getbookingObj(@RequestBody FlightData f,@PathVariable("pnr") int pnr) {
		java.util.Optional<FlightData> p = bs.getBookingByPnr(pnr);
		if (p.isPresent()) {
			f.setCheckin(true);
			return new ResponseEntity<FlightData>(p.get(), HttpStatus.OK);
		}
		return null;
	}
	
	@PutMapping("/updateBooking")
	@ApiOperation(value="Update the Booking Details",response=FlightData.class)
	public FlightData updateflights(@RequestBody FlightData f) {
		return bs.updateBooking(f);
	}
	
	@DeleteMapping("/deletebooking")
	@ApiOperation(value="Deletes the details by an id",response=FlightData.class)
    public ResponseEntity<String> deleteById(@RequestParam("pnr") int pnr) {
        String response = bs.deleteId(pnr);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
	
	@DeleteMapping("/deleteall")
	@ApiOperation(value="Deletes all details",response=FlightData.class)
	public String deleteall() {
		return bs.deleteAll();
	}
	
}
