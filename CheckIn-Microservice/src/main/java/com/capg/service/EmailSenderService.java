package com.capg.service;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.model.EmailDetails;
import com.capg.model.FlightData;
import com.capg.model.Passenger;

@RestController
@RequestMapping("/email")
public class EmailSenderService {
	
	@Autowired
	private JavaMailSender javamailSender;
	
	public void sendEmail(String toEmail,String body,String subject) {
		SimpleMailMessage message = new SimpleMailMessage();

		message.setFrom("ruksarsyed159@gmail.com");
		message.setTo(toEmail);
		message.setText(body);	
		message.setSubject(subject);

		javamailSender.send(message);
		System.out.println("Mail Send....");
	}
	
	@PostMapping("/send-mail")
	public String sendMail(@RequestBody EmailDetails emailBody) {
		
		sendEmail(emailBody.getToEmail(), emailBody.getBody(), emailBody.getSubject());
		
		return "Confirmation email sent successfully to "+emailBody.getToEmail();
	}

	public FlightData sendEmail(FlightData p,String mailId) {
		SimpleMailMessage message = new SimpleMailMessage();
		
		message.setFrom("ruksarsyed159@gmail.com");
		message.setTo(mailId);
		message.setSubject("CheckIn Confirmation Mail");
		message.setText("CheckIn Successful to "+p.getPnr()+" Seat Number is "+p.getP().getSeatNumber()+"CheckinId is " );
		
		javamailSender.send(message);
		
		return p;
	}



}
