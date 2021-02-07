package com.isa.pharmacy.users.service;

import com.isa.pharmacy.controller.exception.AlreadyExistsException;
import com.isa.pharmacy.controller.exception.NotFoundException;
import com.isa.pharmacy.domain.Medicine;
import com.isa.pharmacy.users.domain.Patient;
import com.isa.pharmacy.users.domain.User;
import com.isa.pharmacy.users.repository.PatientRepository;
import com.isa.pharmacy.users.service.UserService;
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

    public void updateAllergies(Long patientId, List<Medicine> medicines){
        Patient patient = patientRepository.getOne(patientId);
        for(Medicine med : medicines)
            if(!patient.getAllergicMedicines().contains(med))
                patient.addAllergy(med);
        patientRepository.save(patient);
    }

    public Patient getPatient(String email){
        Patient patient = patientRepository.findByUser_email(email);
        if(patient == null)
            throw new NotFoundException("Patient with email "+ email + " doesn't exists.");
        return patient;
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
