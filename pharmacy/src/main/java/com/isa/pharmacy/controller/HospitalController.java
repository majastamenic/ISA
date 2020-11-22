package com.isa.pharmacy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isa.pharmacy.controller.dto.HospitalRegistrationDto;
import com.isa.pharmacy.controller.mapping.HospitalMapper;
import com.isa.pharmacy.domain.Hospital;
import com.isa.pharmacy.service.HospitalService;

@RestController
@RequestMapping("/hospital")
@CrossOrigin(value = "http://localhost:4200")
public class HospitalController {
	
	@Autowired
	private HospitalService hospitalService;
	
	@PostMapping
	public Hospital registration(@RequestBody HospitalRegistrationDto registrationHospitalDto) {
		Hospital hospital = HospitalMapper.mapRegistrationDtoToHospital(registrationHospitalDto);
		return hospitalService.create(hospital);
	}
}
