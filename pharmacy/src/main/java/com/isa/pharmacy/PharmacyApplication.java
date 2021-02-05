package com.isa.pharmacy;

import com.isa.pharmacy.service.CommunicationService;
import com.isa.pharmacy.service.SftpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@Import(CommunicationService.class)
public class PharmacyApplication {

    private static final Logger logger = LoggerFactory.getLogger(PharmacyApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(PharmacyApplication.class, args);
        try {
            SftpService sftp = new SftpService();
            sftp.downloadFile();
        } catch (Exception e) {
            logger.warn("Rebex server isn't available. Try again later.");
        }
    }
}
