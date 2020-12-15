package com.isa.pharmacy.service;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;


@Service
public class EmailService {

	@Autowired
	private JavaMailSender javaMailSender;

	@Value("${spring.mail.username}")
	private String mailSender;

	@Async
	public void sendApiKey(String hospitalEmail, String apiKey)
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
	
	@Async
	public void sendEmail(String email)
			throws MailException, InterruptedException, MessagingException{
		System.out.println("Sending email");
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setFrom(mailSender);
		simpleMailMessage.setTo(email);
		simpleMailMessage.setSubject("APIKEY");
		simpleMailMessage.setText("");

		javaMailSender.send(simpleMailMessage);
		System.out.println("Send email");
	}

	@Async
	public void notifyHospitalSftp(String hospitalEmail, String patientName)
			throws MailException, InterruptedException, MessagingException {
		System.out.println("sending email");
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setFrom(mailSender);
		simpleMailMessage.setTo(hospitalEmail);
		simpleMailMessage.setSubject("Prescription is received");
		simpleMailMessage.setText("Dear Hospital,\nPharmacy received prescription with name: " + patientName);

		javaMailSender.send(simpleMailMessage);
		System.out.println("send email");
	}

	@Async
	public void notifyPharmacySftp(String pharmacyEmail)
			throws MailException, InterruptedException, MessagingException {
		System.out.println("sending email");
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setFrom(mailSender);
		simpleMailMessage.setTo(pharmacyEmail);
		simpleMailMessage.setSubject("Generated PDF");
		simpleMailMessage.setText("Dear Pharmacy,\nPDF is generated:");

		javaMailSender.send(simpleMailMessage);
		System.out.println("send email");
	}
}
