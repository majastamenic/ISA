package com.isa.pharmacy.service;

import com.isa.pharmacy.domain.Patient;
import com.isa.pharmacy.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public Patient createPatient(Patient patient){
        return patientRepository.save(patient);
    }

    public Patient updatePatient(Patient patient){
        Patient dbPatient = patientRepository.getOne(patient.getId());
        if(!dbPatient.getUser().getEmail().equals(patient.getUser().getEmail()))
            return null;
        // TODO G: Ne menjati konsultacije i preglede, ne radi bas kako treba
        return patientRepository.save(patient);
    }

    public void deletePatient(long id){
        patientRepository.deleteById(id);
    }
}
