package com.isa.pharmacy.users.controller;

import com.isa.pharmacy.users.controller.dto.HospitalManagerRegistrationDto;
import com.isa.pharmacy.users.controller.mapping.HospitalMapper;
import com.isa.pharmacy.users.domain.Hospital;
import com.isa.pharmacy.service.EmailService;
import com.isa.pharmacy.users.service.HospitalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/hospital")
@CrossOrigin(value = "http://localhost:4200")
public class HospitalController {

    @Autowired
    private HospitalService hospitalService;

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private EmailService emailService;

    @GetMapping
    public List<Hospital> getAll() {
        return hospitalService.getAll();
    }

    @PostMapping
    public Hospital registration(@RequestBody HospitalManagerRegistrationDto registrationHospitalDto) {
        Hospital hospital = this.hospitalService.getByEmail(registrationHospitalDto.getEmail());
        hospital = HospitalMapper.mapRegistrationDtoToHospital(registrationHospitalDto, hospital);
        hospital = hospitalService.create(hospital);
        try {
            emailService.sendApiKey(hospital.getEmail(), "1dfre-astfc-hfe5g-a65Sd");
        } catch (Exception e) {
            logger.info(String.format("Error has occurred while sending email: %s", e.getMessage()));
        }
        return hospital;
    }


}
