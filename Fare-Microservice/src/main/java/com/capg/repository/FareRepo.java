package com.capg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.model.Fare;

@Repository
public interface FareRepo extends JpaRepository<Fare,Integer>{

	public Fare getFareByFlightNumberAndFlightDate(String flightNumber, String flightDate);

}
