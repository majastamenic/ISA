package com.isa.pharmacy;


import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.isa.pharmacy.service.QRService;
import com.isa.pharmacy.service.SftpService;


@SpringBootApplication
public class PharmacyApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(PharmacyApplication.class, args);
//		SftpService sftp = new SftpService();
//		sftp.downloadFile();
		QRService.generateQRCodeImage("This is my first QR Code", 350, 350, QRService.QR_CODE_IMAGE_PATH);
	}

}
