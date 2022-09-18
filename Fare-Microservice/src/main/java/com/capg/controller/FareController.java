package com.capg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capg.model.Fare;
import com.capg.service.FareService;

@RestController
@RequestMapping("/fare")
public class FareController {
	
	@Autowired
	FareService fs;
	
	@PostMapping("/addLoc")
	public ResponseEntity<String> addDetails(@RequestBody Fare fare) {
		fs.addFare(fare);
		return new ResponseEntity<String>("inserted..",HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Fare>> fetchAllFareDetails() {
		List<Fare> Obj = fs.getFare();
		return new ResponseEntity<List<Fare>>(Obj, HttpStatus.OK);
	}
	
	@RequestMapping("/get")
	public Fare getFareModel(@RequestParam(value = "flightNumber") String flightNumber,
	                 @RequestParam(value = "flightDate") String flightDate) {
		return fs.getFare(flightNumber, flightDate);
	}
	
	/*@GetMapping("/get/{flightNumber}/{flightDate}")
	public Fare getFareModel(@PathVariable("flightNumber") String flightNumber,
			@PathVariable("flightDate") String flightDate) {
		return fs.getFare(flightNumber, flightDate);
	}*/
	

}
