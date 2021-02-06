package com.isa.pharmacy.users.service;

import com.isa.pharmacy.controller.exception.AlreadyExistsException;
import com.isa.pharmacy.domain.Medicine;
import com.isa.pharmacy.service.MedicineService;
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
    @Autowired
    private MedicineService medicineService;

    public Patient registration(Patient patient) {
        User existingUser = userService.getByEmail(patient.getUser().getEmail());
        if (existingUser == null) {
            userService.create(patient.getUser());
            return patientRepository.save(patient);
        }
        throw new AlreadyExistsException(String.format("Patient with email %s, already exists", patient.getUser().getEmail()));
    }

    public Patient activateProfile(String email, String code){
        User user = userService.getByEmail(email);
        Patient patient = patientRepository.findByUser(user);
        if(patient != null && !patient.getUser().getActive() && patient.getVerificationCode().equals(code)){
            patient.getUser().setActive(true);
            patientRepository.save(patient);
        }
        return patient;
    }

    public void updateAllergies(String patientEmail, List<String> allergies){
        Patient patient = patientRepository.findByUser_email(patientEmail);
        List<Medicine> patAllergies = new ArrayList<>();
        for(String allergy : allergies)
            patAllergies.add(medicineService.findByName(allergy));
        patient.setAllergicMedicines(patAllergies);
    }

    public Patient getPatient(String email){
        return patientRepository.findByUser_email(email);
    }

    public List<Patient> getAllPatients(){return patientRepository.findAll();}

    public void deletePatient(long id){
        patientRepository.deleteById(id);
    }
}
