package com.booking.repository;

//import java.time.LocalDate; 
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.booking.model.Flight;
@EnableJpaRepositories
@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {
	
	List<Flight> findByDate(String date);

	Flight findByFlightId(int flghtId);
	
	Flight findByModelAndDate(String model,String date);

	List<Flight> findByDateAndArrivalLocAndDepartureLoc(String date, String arrivalLoc, String departureLoc);
}
