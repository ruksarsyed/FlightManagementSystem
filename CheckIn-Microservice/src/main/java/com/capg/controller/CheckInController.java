package com.capg.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capg.model.CheckinRecord;
import com.capg.model.FlightData;
import com.capg.service.CheckinService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/checkin")
public class CheckInController {
	
	@Autowired
	CheckinService service;
	
	@PostMapping("/hello")
	public String print() {
		return "Welcome to checkin";
	}
	
	@GetMapping("/CheckinByPnr/{pnr}/{mail}")
	public String Checkin(@RequestBody FlightData f,@PathVariable int pnr,@PathVariable String mail) {
		return service.Checkinflight(f,pnr,mail);
	}	
	
	@GetMapping("/CheckinById/{checkinId}")
	public Optional<CheckinRecord> checkinbyid(@PathVariable int checkinId){
		return service.getById(checkinId);
	}
	
	@DeleteMapping("/deleteCheckin")
	@ApiOperation(value="Deletes the details by an id",response=CheckinRecord.class)
    public ResponseEntity<String> deleteById(@RequestParam("pnr") int id) {
        String response = service.deleteId(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
	
	@DeleteMapping("/deleteall")
	@ApiOperation(value="Deletes all details",response=CheckinRecord.class)
	public String deleteall() {
		return service.deleteAll();
	}
}