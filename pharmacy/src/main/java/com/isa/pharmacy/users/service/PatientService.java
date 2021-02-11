package com.isa.pharmacy.users.service;

import com.isa.pharmacy.controller.exception.AlreadyExistsException;
import com.isa.pharmacy.controller.exception.NotFoundException;
import com.isa.pharmacy.users.domain.Patient;
import com.isa.pharmacy.users.domain.User;
import com.isa.pharmacy.users.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private UserService userService;

    public Patient registration(Patient patient) {
        Patient existingUser = patientRepository.findByUser_email(patient.getUser().getEmail());
        if (existingUser == null) {
            userService.create(patient.getUser());
            return patientRepository.save(patient);
        }
        throw new AlreadyExistsException(String.format("Patient with email %s, already exists", patient.getUser().getEmail()));
    }

    public String activateProfile(String email, String code){
        User user = userService.getByEmail(email);
        Patient patient = patientRepository.findByUser(user);
        if(patient != null && !patient.getUser().getActive() && patient.getVerificationCode().equals(code)){
            patient.getUser().setActive(true);
            patientRepository.save(patient);
            return "Successfully verified account";
        }
        return "Error while activating account";
    }

    public void updateAllergies(String patientEmail, List<String> allergies){
        Patient patient = patientRepository.findByUser_email(patientEmail);
        patient.setAllergicMedicines(new ArrayList<>());
        for(String allergy : allergies)
            patient.addAllergy(allergy);
        patientRepository.save(patient);
    }

    public Patient getPatient(String email){
        Patient patient = patientRepository.findByUser_email(email);
        if(patient == null)
            throw new NotFoundException("Patient with email "+ email + " doesn't exists.");
        return patient;
    }

    public List<Patient> getAllPatients(){return patientRepository.findAll();}

    public void deletePatient(long id){
        patientRepository.deleteById(id);
    }
}
