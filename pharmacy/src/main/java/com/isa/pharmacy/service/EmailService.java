package com.isa.pharmacy.service;

import com.isa.pharmacy.domain.Examination;
import com.isa.pharmacy.users.domain.Patient;
import com.isa.pharmacy.users.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private static final String GREETING = "Hello ";

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String mailSender;

    @Async
    public void activationEmail(User user) throws MailException {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(mailSender);
        simpleMailMessage.setTo(user.getEmail());
        simpleMailMessage.setSubject("Activation profile");
        simpleMailMessage.setText(GREETING + user.getName() + ",\n" +
                "Welcome to pharmacy system.\n" +
                "Your password is: " + user.getPassword());
        javaMailSender.send(simpleMailMessage);
    }

    @Async
    public void verificationEmailPatient(Patient patient) throws MailException {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(mailSender);
        simpleMailMessage.setTo(patient.getUser().getEmail());
        simpleMailMessage.setSubject("Registration");
        simpleMailMessage.setText(GREETING + patient.getUser().getName() + ",\n" +
                "Welcome to pharmacy system.\n" +
                "Your verification code is: " + patient.getVerificationCode());
        javaMailSender.send(simpleMailMessage);
    }

    @Async
    public void successfulExamSchedule(Examination examiantion) throws  MailException{
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(mailSender);
        mailMessage.setTo(examiantion.getPatient().getUser().getEmail());
        mailMessage.setSubject("Examination");
        mailMessage.setText(GREETING + examiantion.getPatient().getUser().getName() + ",\n\n" +
                            "You have successfully scheduled an appointment with dermatologist.\n" +
                            "Details: \n" +
                            "- Dermatologist: " + examiantion.getDermatologist().getUser().getName() + " " + examiantion.getDermatologist().getUser().getSurname() + "\n" +
                            "- Time: " + examiantion.getSchedule().getStartTime() + "\n" +
                            "- Price: " + examiantion.getPrice() + "€\n\n" +
                            "Best regards,\n" +
                            "ISA Pharmacy");
        javaMailSender.send(mailMessage);
    }

    @Async
    public void sendApiKey(String hospitalEmail, String apiKey)
            throws MailException {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(mailSender);
        simpleMailMessage.setTo(hospitalEmail);
        simpleMailMessage.setSubject("Hospital registration");
        simpleMailMessage.setText(GREETING + ",\nWelcome to pharmacy system.\n" +
                "Our Api key: " + apiKey +
                "\nOur endpoint address is: http://localhost:8081/pharmacy/" +
                "\nFeel free to contact any pharmacy from our system!");

        javaMailSender.send(simpleMailMessage);
    }


    @Async
    public void notifyHospitalSftp(String hospitalEmail, String patientName)
            throws MailException {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(mailSender);
        simpleMailMessage.setTo(hospitalEmail);
        simpleMailMessage.setSubject("Prescription is received");
        simpleMailMessage.setText("Dear Hospital,\n" +
                "Pharmacy received prescription with name: " + patientName);

        javaMailSender.send(simpleMailMessage);
    }

    @Async
    public void notifyPharmacySftp(String pharmacyEmail)
            throws MailException {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(mailSender);
        simpleMailMessage.setTo(pharmacyEmail);
        simpleMailMessage.setSubject("Generated PDF");
        simpleMailMessage.setText("Dear Pharmacy,\n" +
                "PDF is generated:");

        javaMailSender.send(simpleMailMessage);
    }

    public void notifyAdminPharmacyAboutMedicine(String adminEmail, String pharmacyAdmin, String medName)throws MailException{
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(mailSender);
        simpleMailMessage.setTo(adminEmail);
        simpleMailMessage.setSubject("Medicine is out of stock!");
        simpleMailMessage.setText("Dear " + pharmacyAdmin + ",\n" +
                "Pharmacy don't have " + medName + " on stock. Please order it.\n\n" +
                "Best regards,\n" +
                "Health Worker.");

        javaMailSender.send(simpleMailMessage);
    }
}
