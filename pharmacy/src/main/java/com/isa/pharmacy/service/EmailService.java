package com.isa.pharmacy.service;

import com.isa.pharmacy.domain.Profile.Patient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;


@Service
public class EmailService {
    private static final String SENDING_EMAIL = "Sending email...";
    private static final String EMAIL_SENT = "Email sent";

    private final Logger logger = LoggerFactory.getLogger(EmailService.class);

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String mailSender;

    @Async
    public void verificationEmailPatient(Patient patient) throws MailException {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(mailSender);
        simpleMailMessage.setTo(patient.getUser().getEmail());
        simpleMailMessage.setSubject("Registration");
        simpleMailMessage.setText("Hello,"+patient.getUser().getName()+"\nWelcome to pharmacy system.\n" +
                "Your verification code is: " + patient.getVerificationCode());
        javaMailSender.send(simpleMailMessage);
    }

    @Async
    public void sendApiKey(String hospitalEmail, String apiKey)
            throws MailException {
        logger.info(SENDING_EMAIL);
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(mailSender);
        simpleMailMessage.setTo(hospitalEmail);
        simpleMailMessage.setSubject("Hospital registration");
        simpleMailMessage.setText("Hello,\nWelcome to pharmacy system.\n" +
                "Our Api key: " + apiKey +
                "\nOur endpoint address is: http://localhost:8081/pharmacy/" +
                "\nFeel free to contact any pharmacy from our system!");

        javaMailSender.send(simpleMailMessage);
        logger.info(EMAIL_SENT);
    }


    @Async
    public void notifyHospitalSftp(String hospitalEmail, String patientName)
            throws MailException {
        logger.info(SENDING_EMAIL);
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(mailSender);
        simpleMailMessage.setTo(hospitalEmail);
        simpleMailMessage.setSubject("Prescription is received");
        simpleMailMessage.setText("Dear Hospital,\nPharmacy received prescription with name: " + patientName);

        javaMailSender.send(simpleMailMessage);
        logger.info(EMAIL_SENT);
    }

    @Async
    public void notifyPharmacySftp(String pharmacyEmail)
            throws MailException {
        logger.info(SENDING_EMAIL);
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(mailSender);
        simpleMailMessage.setTo(pharmacyEmail);
        simpleMailMessage.setSubject("Generated PDF");
        simpleMailMessage.setText("Dear Pharmacy,\nPDF is generated:");

        javaMailSender.send(simpleMailMessage);
        logger.info(EMAIL_SENT);
    }
}
