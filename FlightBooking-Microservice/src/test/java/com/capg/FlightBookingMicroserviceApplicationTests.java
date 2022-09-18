package com.capg;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.capg.model.FlightData;
import com.capg.model.Passenger;
import com.capg.repository.BookingRepository;
import com.capg.repository.FlightRepository;
import com.capg.service.BookingService;


@SpringBootTest
class FlightBookingMicroserviceApplicationTests {

	@Test
	void contextLoads() {
	}

	@MockBean
	private BookingRepository br;
	
	@MockBean
	private FlightRepository fr;
	
	@Autowired
	private BookingService bs;
	
	@Autowired
	RestTemplate restTemplate;
	
	
	@Test
	void testAddPassengers1() {
		Passenger p=new Passenger(1,"keerthi","korrapati","female","28B");
		Mockito.when(br.save(p)).thenReturn(p);
		assertEquals(p,bs.addDetails(p));
	}
	
	@Test
	void testSaveBooking() {
		FlightData flight = new FlightData();
		flight.setPnr(1);
		flight.setFlightNumber("BF101");
		flight.setOrigin("NYC");
		flight.setDestination("SFO");
		//flight.setBookingDate(LocalDate.of(2008, 10, 12));
		flight.setFare(100);
		flight.setP(new Passenger(1,"Keerthi","Korrapati","Female", "21B"));
		Mockito.when(fr.save(flight)).thenReturn(flight);
		assertEquals("Booking Confirmed", bs.addBooking(flight));
	}
	
	@Test
	void testSavePassenger2() {
		Passenger p =new Passenger();
		p.setPid(1);;
		p.setFirstname("Keerthi");
		p.setLastname("Korrapati");
		p.setGender("Female");
		Mockito.when(br.save(p)).thenReturn(p);
		assertEquals(p, bs.addDetails(p));
	}
	
	@Test
	void testGetBypassengerId() {
		int id=1;
		Optional<Passenger> l=Optional.ofNullable(
				new Passenger(1,"Keerthi","Korrapati","Female","28B"));
		when(br.findById(id)).thenReturn(Optional.ofNullable(
				new Passenger(1,"Keerthi","Korrapati","Female","28B")));
		assertEquals(l.get().getPid(),bs.getbyId(id).get().getPid());
	}
	//LocalDate.of(2008,10,12)
	@Test
	void testbypnr() {
		int id=1;
		Optional<FlightData> f=Optional.ofNullable(new FlightData(1,"BF101","NYC","SFO","28-AUG-22" , 100, "Confirmed",true,
                new Passenger(1,"keerthi","korrapati","female","28C")));
		when(fr.findById(id)).thenReturn(f);
		assertEquals(f.get().getPnr(),bs.getBookingByPnr(id).get().getPnr());
	}
	
	@Test
	void testgetPassenger() {
		Passenger p=new Passenger(1,"Keerthi","Korrapati","Female","28B");
		assertEquals(1,p.getPid());
		assertEquals("Keerthi",p.getFirstname());
		assertEquals("Korrapati",p.getLastname());
		assertEquals("Female",p.getGender());
	}
	
	@Test
	void testgetFlight() {
		
		FlightData f=new FlightData(1,"BF101","NYC","SFO", "28-AUG-22", 100,"Confirmed",true, 
				                          new Passenger(1,"keerthi","korrapati","female","28C"));
		assertEquals(LocalDate.of(2008,10,12),f.getBookingDate());
		assertEquals("BF101",f.getFlightNumber());
		assertEquals("NYC",f.getOrigin());
		assertEquals("SFO",f.getDestination());
		assertEquals(1,f.getPnr());
		}

	@Test
	void testdeletebyid() {
		FlightData f=new FlightData(1,"BF101","NYC","SFO", "28-AUG-22", 100,"Confirmed",true, 
				                    new Passenger(1,"keerthi","korrapati","female","28C"));
		assertEquals("deleted", bs.deleteId(f.getPnr()));
	}
	
	@Test
	void testDeleteall() {
		assertEquals("All Bookings deleted",bs.deleteAll());
	}
	
	
	 
}
