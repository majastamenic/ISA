package com.isa.pharmacy;


import com.isa.pharmacy.service.CommunicationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.isa.pharmacy.service.SftpService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
@ComponentScan
@Import(CommunicationService.class)
public class PharmacyApplication {

    private static Logger logger = LoggerFactory.getLogger(PharmacyApplication.class);

    public static void main(String[] args) throws Exception {
        SpringApplication.run(PharmacyApplication.class, args);
        try {
            SftpService sftp = new SftpService();
            sftp.downloadFile();
        } catch (Exception e) {
            logger.warn("Rebex doesn't work. Try again later");
        }
    }

}
