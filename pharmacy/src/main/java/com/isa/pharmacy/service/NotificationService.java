package com.isa.pharmacy.service;

import net.bytebuddy.matcher.ElementMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.io.*;
import com.isa.pharmacy.service.EmailService;

import javax.mail.MessagingException;


@EnableScheduling
@SpringBootApplication
@Component
public class NotificationService {
    private String pharmacyEmail = "ppharmacy056@gmail.com";
    private String hospitalEmail = "bolnica218@yahoo.com";
    @Autowired
    private EmailService emailsService;

    @Scheduled(fixedRate = 20000)
    public void checkFile() throws IOException, MessagingException, InterruptedException {
        File file = new File("src/main/resources/example.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        String line = br.readLine();
        if(line == null){
            System.out.println("File is empty.");
        }else{
            System.out.println("File isn't empty.");
            try {
                System.out.println(line);
                emailsService.notifyHospitalSftp(hospitalEmail, line);
                emailsService.notifyPharmacySftp(pharmacyEmail);
                while ((line = br.readLine()) != null){
                    System.out.println(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            fileDisposer(file);
            System.out.println("File is now empty.");
            br.close();

        }
    }

    public void downloadFromSftp() throws IOException {
        SftpService sftp = new SftpService();
        sftp.downloadFile();
    }

    public void fileDisposer(File file) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(file);
        writer.print("");
        writer.close();
    }
}