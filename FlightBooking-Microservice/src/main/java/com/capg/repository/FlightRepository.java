package com.capg.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.model.FlightData;

@Repository
public interface FlightRepository extends JpaRepository<FlightData,Integer> {

	Optional<FlightData> findById(int pnr);
	



}
