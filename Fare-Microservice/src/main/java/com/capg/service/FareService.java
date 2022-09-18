package com.capg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.model.Fare;
import com.capg.repository.FareRepo;

@Service
public class FareService {
	
	@Autowired
	FareRepo repo;
	
	public Fare addFare(Fare fare) {
		return repo.save(fare);
	}

    public List<Fare> getFare() {
		return repo.findAll();
	}
	public Fare getFare(String flightNumber, String flightDate) {
        return repo.getFareByFlightNumberAndFlightDate(flightNumber, flightDate);
    }

}
