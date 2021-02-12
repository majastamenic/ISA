package com.isa.pharmacy.service;

import com.isa.pharmacy.service.interfaces.IEmailService;
import com.isa.pharmacy.service.interfaces.INotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.*;


@EnableScheduling
@SpringBootApplication
@Component
public class NotificationService implements INotificationService {

    private final Logger logger = LoggerFactory.getLogger(NotificationService.class);

    private String pharmacyEmail = "ppharmacy056@gmail.com";
    private String hospitalEmail = "bolnica218@yahoo.com";
    @Autowired
    private IEmailService emailsService;

    @Scheduled(fixedRate = 20000)
    public void checkFile() throws IOException {
        File file = new File("src/main/resources/example.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        String line = br.readLine();
        if (line != null) {
            try {
                logger.info(line);
                emailsService.notifyHospitalSftp(hospitalEmail, line);
                emailsService.notifyPharmacySftp(pharmacyEmail);
                while ((line = br.readLine()) != null) {
                    logger.info(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            fileDisposer(file);
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