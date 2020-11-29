package com.isa.pharmacy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isa.pharmacy.controller.dto.HospitalManagerRegistrationDto;
import com.isa.pharmacy.controller.mapping.HospitalMapper;
import com.isa.pharmacy.domain.Hospital;
import com.isa.pharmacy.service.EmailService;
import com.isa.pharmacy.service.HospitalService;


@RestController
@RequestMapping("/hospital")
@CrossOrigin(value = "http://localhost:4200")
public class HospitalController {
	
	@Autowired
	private HospitalService hospitalService;
	
	private Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private EmailService emailService;
	
	@PostMapping
	public Hospital registration(@RequestBody HospitalManagerRegistrationDto registrationHospitalDto) {
		Hospital hospital = this.hospitalService.getByEmail(registrationHospitalDto.getEmail());
		try {
			emailService.sendNotificaitionsAsync(registrationHospitalDto, null);
		}catch( Exception e ){
			logger.info("Greska prilikom slanja emaila: " + e.getMessage());
		}
		hospital = HospitalMapper.mapRegistrationDtoToHospital(registrationHospitalDto, hospital);
		return hospitalService.create(hospital);
	}
	
	
}
