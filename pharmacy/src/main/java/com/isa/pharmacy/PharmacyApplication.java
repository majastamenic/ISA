package com.isa.pharmacy;


import com.isa.pharmacy.service.CommunicationService;
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

    public static void main(String[] args) throws Exception {
        SpringApplication.run(PharmacyApplication.class, args);
        try {
            SftpService sftp = new SftpService();
            sftp.downloadFile();
        } catch (Exception e) {
            System.out.println("Rebex doesn't work. Try again later");
        }
    }

}
