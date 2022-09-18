package com.capg.service;


import java.util.Optional; 

//import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.capg.model.BookingStatus;
//import com.capg.config.MQConfig;
import com.capg.model.CheckinRecord;
import com.capg.model.EmailDetails;
import com.capg.model.FlightData;
import com.capg.repository.FlightRepository;
import com.capg.repository.checkinrepo;

@Service
public class CheckinService {
	
	@Autowired
	checkinrepo repo;
	
	@Autowired
	FlightRepository repo1;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	EmailSenderService email;
	
	private static final String EMAIL_URL="http://localhost:8080/email/send-mail";

	public String Checkinflight(FlightData f, int pnr,String mail) {
		CheckinRecord c=new CheckinRecord();
		FlightData f1=restTemplate.getForObject("http://localhost:8003/booking/getbypnr/"+pnr,FlightData.class);
		f1.setCheckin(true);
		f1.setStatus(BookingStatus.CHECKED_IN);
		repo1.save(f1);
		c.setFirstName(f1.getP().getFirstname());
		c.setLastName(f1.getP().getLastname());
		c.setFlightNumber(f1.getFlightNumber());
		c.setFlightDate(f1.getBookingDate());
		c.setSeatNumber(f1.getP().getSeatNumber());
		c.setPnr(pnr);
		repo.save(c);
		String emailBody="Checked In,"+" Seat Number is "+c.getSeatNumber()+", CheckinId is "+c.getCheckinId();
		String emailSubject = "Checkin Confirmation";
		EmailDetails mail1 = new EmailDetails(mail,emailBody,emailSubject);
		restTemplate.postForObject(EMAIL_URL, mail1, String.class);
		return "Checked In,"+" Seat Number is "+c.getSeatNumber()+", CheckinId is "+c.getCheckinId();
	}

	public Optional<CheckinRecord> getById(int id) {
		return repo.findById(id);
	}

	public String deleteId(int id) {
		repo.deleteById(id);
		return "deleted";
	}
	
	public String deleteAll() {
		repo.deleteAll();
		return "All Checkins deleted";
	}
	
	

}