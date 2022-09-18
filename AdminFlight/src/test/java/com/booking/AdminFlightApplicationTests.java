package com.booking;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.booking.model.Flight;
import com.booking.repository.FlightRepository;
import com.booking.service.FlightService;

@SpringBootTest
class AdminFlightApplicationTests {
	
	@Autowired
	private FlightService service;
	@MockBean
	private FlightRepository repo;

	@Test
	void testsetFlightId() {
	Flight flight = new Flight();
		flight.setFlightId(25);
		assertEquals(25, flight.getFlightId());
	}
	
	@Test
	void testsetArrivalLoc() {
	Flight flight = new Flight();
		flight.setArrivalLoc("Bangalore");
		assertEquals("Bangalore", flight.getArrivalLoc());	
	}
	
	@Test
	void testsetDepartureLoc() {
	Flight flight = new Flight();
		flight.setDepartureLoc("Bangalore");
		assertEquals("Bangalore", flight.getDepartureLoc());
	}
	
	@Test
	void testsetFleetName() {
	Flight flight = new Flight();
		flight.setFleetName("Indigo");
		assertEquals("Indigo", flight.getFleetName());
	}
	
	@Test
	void testsetModel() {
	Flight flight = new Flight();
		flight.setModel("In32");
		assertEquals("In32", flight.getModel());
	}
	

	@Test
	void testsetRemainingSeats() {
	Flight flight = new Flight();
		flight.setRemainingSeats(35);
		assertEquals(35, flight.getRemainingSeats());
	}
	
	@Test
	void testsetDate() {
	Flight flight = new Flight();
	flight.setDate("23-MAY-22");
		assertEquals("23-MAY-22" , flight.getDate());
	
	}

	@Test
	void testGetAllFlightDetails() {
		Mockito.when(repo.findAll()).thenReturn(Stream.of(
				 new Flight(1,"Delhi","Bangalore","Indigo","I11",120, "28-AUG-22"),
				 new Flight(2,"Delhi","Goa","KF","KF10",50,"01-JUL-22" ),
				 new Flight(3,"Mumbai","Bangalore","KF","KF11",10,"26-JAN-21"),
				 new Flight(4,"Delhi","Hyderabad","Indigo","I20",70,"23-MAY-22"))
				 .collect(Collectors.toList()));
		assertEquals(4,service.getAllFlightDetails().size());
	}
	
	
	@Test
	void testGetFlightByFlightId() {
		Flight flight = new Flight(1,"Delhi","Bangalore","Indigo","I11",120, "23-MAY-22");
		Mockito.when(repo.findByFlightId(1)).thenReturn(flight);
		assertEquals(flight,service.getFlightByFlightId(1));
	}
	
	
	@Test
	void testAddFlight() {
		Flight flight = new Flight(1,"Bangalore","Delhi","Indigo","I11",120,"23-MAY-22");
		Mockito.when(repo.save(flight)).thenReturn(flight);
		assertEquals("Flight with ID "+flight.getFlightId()+" has been added.",
					service.addOneFlight(flight));
	}
	
	@Test
	void testgetFlightByDate() {
		Mockito.when(repo.findByDate("23-MAY-22")).thenReturn(Stream.of(
				 new Flight(1,"Delhi","Bangalore","Indigo","I11",120, "23-MAY-22"),
				 new Flight(2,"Delhi","Goa","KF","KF10",50, "22-MAY-22"),
				 new Flight(3,"Mumbai","Bangalore","KF","KF11",10,"21-MAY-20"),
				 new Flight(4,"Delhi","Hyderabad","Indigo","I20",70,"24-MAY-19"))
				 .collect(Collectors.toList()));
		assertEquals("23-MAY-22",service.findByDate("23-MAY-22"));
	}
	
	@Test
	void testUpdateFlight() {
		Flight flight = new Flight(1,"Bangalore","Delhi","Indigo","I11",120,"23-MAY-22");
		Flight flight2 = new Flight(1,"Mumbai","Delhi","Indigo","I21",120,"20-JUL-22");
		Mockito.when(repo.saveAndFlush(flight)).thenReturn(flight);
		repo.save(flight2);
		assertEquals(repo.saveAndFlush(flight),
					 service.updateFlightDetail(flight));
	}
	
	@Test
	void testDeleteByFlightId() {
		Flight flight = new Flight(1,"Bangalore","Delhi","Indigo","I11",120,"23-MAY-22");
		int flightId=flight.getFlightId();
		assertEquals("Flight with ID "+flightId+" has been deleted.",
					 service.deleteByFlightId(1));
	}
	
	@Test
	void testDeleteAllflightDetails() {
		assertEquals("All the flight details are deleted.",
					 service.deleteAllFlightDetails());
	}
	
}
