package com.isa.pharmacy.service;

import com.isa.pharmacy.domain.Complaint;
import com.isa.pharmacy.domain.Counseling;
import com.isa.pharmacy.domain.EPrescription;
import com.isa.pharmacy.domain.Examination;
import com.isa.pharmacy.rabbitmq.ActionsAndBenefits;
import com.isa.pharmacy.service.interfaces.IEmailService;
import com.isa.pharmacy.users.domain.Patient;
import com.isa.pharmacy.users.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailService implements IEmailService {

    private static final String GREETING = "Dear ";
    private static final String CLOSE_PHASE = "Best regards,\nPharmacy system";
    private static final String BACK_ENDPOINT = "https://pharmacy-25-backend.herokuapp.com/";

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
                "Your password is: " + user.getPassword()+"\n\n"+ CLOSE_PHASE);
        javaMailSender.send(simpleMailMessage);
    }

    @Async
    public void verificationEmailPatient(Patient patient) throws MailException {

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(mailSender);
        simpleMailMessage.setTo(patient.getUser().getEmail());
        simpleMailMessage.setSubject("Registration");
        String mailText = GREETING + patient.getUser().getName() + ",\n\n" +
                               "Welcome to pharmacy system." + "\n\n" +
                               "Please verify your account.\n"+"link"+"\n\n"+ CLOSE_PHASE;
        String link = BACK_ENDPOINT+"/patient/valid/" + patient.getUser().getEmail()+"/" + patient.getVerificationCode();
        mailText = mailText.replace("link", link);
        simpleMailMessage.setText(mailText);
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
                            "- Date: " + examiantion.getSchedule().getStartDate() + "\n" +
                            "- Time: " + examiantion.getSchedule().getStartTime() + "\n" +
                            "- Price: " + examiantion.getPrice() + "€\n\n" +
                            CLOSE_PHASE);
        javaMailSender.send(mailMessage);
    }

    @Async
    public void successfulCounselingSchedule(Counseling counseling) throws  MailException{
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(mailSender);
        mailMessage.setTo(counseling.getPatient().getUser().getEmail());
        mailMessage.setSubject("Counseling");
        mailMessage.setText(GREETING + counseling.getPatient().getUser().getName() + ",\n\n" +
                "You have successfully scheduled a counseling with pharmacist.\n" +
                "Details: \n" +
                "- Pharmacist: " + counseling.getPharmacist().getUser().getName() + " " + counseling.getPharmacist().getUser().getSurname() + "\n" +
                "- Date: " + counseling.getSchedule().getStartDate() + "\n" +
                "- Time: " + counseling.getSchedule().getStartTime() + "\n" +
                "- Price: " + counseling.getPharmacist().getPharmacy().getCounselingPrice() + "€\n\n" +
                CLOSE_PHASE);
        javaMailSender.send(mailMessage);
    }

    @Async
    public void sendApiKey(String hospitalEmail, String apiKey) throws MailException {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(mailSender);
        simpleMailMessage.setTo(hospitalEmail);
        simpleMailMessage.setSubject("Hospital registration");
        simpleMailMessage.setText(GREETING + ",\nWelcome to pharmacy system.\n" +
                "Our Api key: " + apiKey +
                "\nOur endpoint address is: http://localhost:8081/pharmacy/" +
                "\nFeel free to contact any pharmacy from our system!\n\n" + CLOSE_PHASE);

        javaMailSender.send(simpleMailMessage);
    }

    @Async
    public void notifyHospitalSftp(String hospitalEmail, String patientName) throws MailException {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(mailSender);
        simpleMailMessage.setTo(hospitalEmail);
        simpleMailMessage.setSubject("Prescription is received");
        simpleMailMessage.setText(GREETING + "Hospital,\n" +
                "Pharmacy received prescription with name: " + patientName + "\n\n" + CLOSE_PHASE);

        javaMailSender.send(simpleMailMessage);
    }

    @Async
    public void notifyPharmacySftp(String pharmacyEmail) throws MailException {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(mailSender);
        simpleMailMessage.setTo(pharmacyEmail);
        simpleMailMessage.setSubject("Generated PDF");
        simpleMailMessage.setText(GREETING+ "Pharmacy,\n" +
                "PDF is generated:\n\n"+ CLOSE_PHASE);

        javaMailSender.send(simpleMailMessage);
    }

    @Async
    public void notifyAdminPharmacyAboutMedicine(String adminEmail, String pharmacyAdmin, String medName)throws MailException{
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(mailSender);
        simpleMailMessage.setTo(adminEmail);
        simpleMailMessage.setSubject("Medicine is out of stock!");
        simpleMailMessage.setText(GREETING + pharmacyAdmin + ",\n" +
                "Pharmacy don't have " + medName + " on stock. Please order it.\n\n" +
                CLOSE_PHASE);

        javaMailSender.send(simpleMailMessage);
    }

    @Async
    public void sendAction(ActionsAndBenefits action, String email, String phName) throws MailException{
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(mailSender);
        simpleMailMessage.setTo(email);
        simpleMailMessage.setSubject("New action");
        simpleMailMessage.setText(GREETING + email + ",\n" +
                "Pharmacy "+ phName +" has new action: " + action.getMessageAboutAction() + ". Which is valid from "+
                action.getStartDate()+" to "+action.getEndDate()+" .\n\n" + CLOSE_PHASE);
        javaMailSender.send(simpleMailMessage);
    }

    @Async
    public void sendEmailEPrescription(EPrescription ePrescription) throws MailException{
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(mailSender);
        simpleMailMessage.setTo(ePrescription.getPatient().getUser().getEmail());
        simpleMailMessage.setSubject("Order is completed");
        simpleMailMessage.setText(GREETING + ePrescription.getPatient().getUser().getName() + ",\n" +
                "Your order with ePrescription code: " + ePrescription.getCode() + " is completed."+
                ".\n\n" + CLOSE_PHASE);
        javaMailSender.send(simpleMailMessage);
    }

    @Async
    public void sendComplaintResponse(Complaint complaint) throws MailException{
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(mailSender);
        simpleMailMessage.setTo(complaint.getPatient().getUser().getEmail());
        simpleMailMessage.setSubject("Complaint response");
        simpleMailMessage.setText(GREETING + complaint.getPatient().getUser().getName() + ",\n" +
                "Complaint: " + complaint.getComplaintMessage() + ".\n Response: " + complaint.getResponseComplaint() +
                ".\n\n" + CLOSE_PHASE);
        javaMailSender.send(simpleMailMessage);
    }
}
