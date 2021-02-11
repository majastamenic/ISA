package com.isa.pharmacy.users.controller;

import com.isa.pharmacy.service.EmailService;
import com.isa.pharmacy.users.controller.dto.PatientDto;
import com.isa.pharmacy.users.controller.dto.RegistrationDto;
import com.isa.pharmacy.users.controller.mapping.PatientMapper;
import com.isa.pharmacy.users.controller.mapping.UserMapper;
import com.isa.pharmacy.users.domain.Patient;
import com.isa.pharmacy.users.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
@CrossOrigin(value = "http://localhost:4200")
public class PatientController {

    @Autowired
    private PatientService patientService;
    @Autowired
    private EmailService emailService;

    @GetMapping("/valid/{email}/{code}")
    public String activeProfile(@PathVariable String email, @PathVariable String code){
        return patientService.activateProfile(email, code);
    }

    @PostMapping
    public Patient registration(@RequestBody RegistrationDto registrationDto) {
        Patient patient = patientService.registration(UserMapper.mapRegistrationDtoToPatient(registrationDto));
        emailService.verificationEmailPatient(patient);
        return patient;
    }

    @GetMapping("/{email}")
    public PatientDto getPatientByEmail(@PathVariable("email") String email){
        return PatientMapper.mapPatientToPatientDto(patientService.getPatient(email));
    }

    @GetMapping
    public List<Patient> getAllPatients(){return patientService.getAllPatients();}

    @PutMapping("/updateAllergy/{patientEmail}")
    public void updateAllergy(@RequestBody List<String> allergies, @PathVariable String patientEmail){
        patientService.updateAllergies(patientEmail, allergies);
    }
}
