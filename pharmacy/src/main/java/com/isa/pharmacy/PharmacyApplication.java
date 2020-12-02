package com.isa.pharmacy;


import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.isa.pharmacy.service.SftpService;


@SpringBootApplication
public class PharmacyApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(PharmacyApplication.class, args);
//		SftpService sftp = new SftpService();
//		sftp.downloadFile();
	}

}
