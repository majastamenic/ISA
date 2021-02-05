package com.isa.pharmacy.service;

import com.isa.pharmacy.controller.exception.AlreadyExistsException;
import com.isa.pharmacy.domain.Medicine;
import com.isa.pharmacy.domain.users.Patient;
import com.isa.pharmacy.domain.users.User;
import com.isa.pharmacy.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private UserService userService;

    public Patient createPatient(Patient patient){
        return patientRepository.save(patient);
    }

    public Patient updatePatient(Patient patient){
        userService.updateUser(patient.getUser());
        return patient;
    }

    public void updateAllergies(Long patientId, List<Medicine> medicines){
        Patient patient = patientRepository.getOne(patientId);
        for(Medicine med : medicines)
            if(!patient.getAllergicMedicines().contains(med))
                patient.addAllergy(med);
        patientRepository.save(patient);
    }

    public Patient getPatient(String email){
        return patientRepository.findByUser_email(email);
    }

    public void deletePatient(long id){
        patientRepository.deleteById(id);
    }

    public Patient registration(Patient patient) {
        Patient existingUser = patientRepository.findByUser_email(patient.getUser().getEmail());
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

    public List<Patient> getPatients(){return patientRepository.findAll();}

}
