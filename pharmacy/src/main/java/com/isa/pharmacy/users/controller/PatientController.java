package com.isa.pharmacy.users.controller;

import com.isa.pharmacy.users.controller.dto.RegistrationDto;
import com.isa.pharmacy.users.controller.mapping.UserMapper;
import com.isa.pharmacy.domain.Medicine;
import com.isa.pharmacy.users.domain.Patient;
import com.isa.pharmacy.service.EmailService;
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

    @GetMapping("/valid")
    public Patient activeProfile(@RequestParam String email, @RequestParam String code){
        return patientService.activateProfile(email, code);
    }

    @PostMapping
    public Patient registration(@RequestBody RegistrationDto registrationDto) {
        Patient patient = patientService.registration(UserMapper.mapRegistrationDtoToPatient(registrationDto));
        emailService.verificationEmailPatient(patient);
        return patient;
    }
    //TODO: Patient - Mislim i da je nepotrebna
    /*
    @PostMapping("/create")
    public Patient createPatient(@RequestBody Patient patient){
        return patientService.createPatient(patient);
    }
    */
    @GetMapping("/{email}")
    public Patient getPatientByEmail(@PathVariable("email") String email){
        return patientService.getPatient(email);
    }

    @PutMapping("/updateAllergy")
    public void updateAllergy(@RequestBody List<Medicine> allergies, @RequestParam Long patientId){
        patientService.updateAllergies(patientId, allergies);
    }

    @GetMapping
    public List<Patient> getPatients(){return patientService.getPatients();}
}