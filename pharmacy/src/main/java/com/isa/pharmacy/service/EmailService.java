package com.isa.pharmacy.service;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;


import com.isa.pharmacy.controller.dto.HospitalManagerRegistrationDto;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender javaMailSender;
		
	@Async
	public void sendNotificaitionsAsync(HospitalManagerRegistrationDto hospital) throws MailException, InterruptedException, MessagingException{
		System.out.println("sending email");
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setFrom("stamenicmaja5@gmail.com");
		simpleMailMessage.setTo(hospital.getEmail());
		simpleMailMessage.setSubject("APIKEY");
		simpleMailMessage.setText("Postovani,\nVas ApiKey je: lalalalal" );
		//+ hospital.getPharmacy().getApiKey());
		
		
		javaMailSender.send(simpleMailMessage);
		System.out.println("send email");
	}
	
	
	
}
