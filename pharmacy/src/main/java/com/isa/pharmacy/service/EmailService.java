package com.isa.pharmacy.service;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.isa.pharmacy.controller.dto.HospitalManagerRegistrationDto;
import com.isa.pharmacy.domain.Hospital;
import com.isa.pharmacy.domain.Pharmacy;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender javaMailSender;

	@Value("${spring.mail.username}")
	private String mailSender;

	@Async
	public void sendNotificaitionsAsync(String hospitalEmail, String apiKey)
			throws MailException, InterruptedException, MessagingException {
		System.out.println("sending email");
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setFrom(mailSender);
		simpleMailMessage.setTo(hospitalEmail);
		simpleMailMessage.setSubject("APIKEY");
		simpleMailMessage.setText("Postovani,\nVas ApiKey je:" + apiKey);

		javaMailSender.send(simpleMailMessage);
		System.out.println("send email");
	}

}
