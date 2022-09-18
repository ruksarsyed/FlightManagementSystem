package com.example.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.EmailBody;


@RestController
@RequestMapping("/email")
public class EmailSenderController {
	
//	@Value("${spring.mail.username}")
//	private String fromMail;
	
	@Autowired
	private JavaMailSender mailSender;
	
	public void sendEmail(String toEmail,
			  String body,
			  String subject) {
		SimpleMailMessage message = new SimpleMailMessage();

		message.setFrom("ruksarsyed159@gmail.com");
		message.setTo(toEmail);
		message.setText(body);	
		message.setSubject(subject);

		mailSender.send(message);
	}

	@PostMapping("/send-mail")
	public String sendMail(@RequestBody EmailBody emailBody) {
		
		sendEmail(emailBody.getToMail(), emailBody.getBody(), emailBody.getSubject());
		
		return "Confirmation email sent successfully to "+emailBody.getToMail();
	}
	
}