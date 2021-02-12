package com.isa.pharmacy.users.service;

import java.util.List;

import com.isa.pharmacy.controller.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.isa.pharmacy.controller.exception.AlreadyExistsException;
import com.isa.pharmacy.users.domain.Hospital;
import com.isa.pharmacy.users.repository.HospitalRepository;

@Service
public class HospitalService {

    @Autowired
    private HospitalRepository hospitalRepository;

    public Hospital create(Hospital hospital) {
        Hospital existingHospital = hospitalRepository.findByEmail(hospital.getEmail());
        if (existingHospital == null) {
            return hospitalRepository.save(hospital);
        }
        throw new AlreadyExistsException(String.format("Hospital with email %s, already registered", hospital.getEmail()));
    }

    public Hospital getByEmail(String email) {
        Hospital hospital = hospitalRepository.findByEmail(email);
        if(hospital == null)
            throw new NotFoundException("Hospital with email: "+ email+" doesn't exists.");
        return hospital;
    }

    public List<Hospital> getAll() {
        List<Hospital> hospitals = hospitalRepository.findAll();
        if(hospitals.isEmpty())
            throw new NotFoundException("There is no hospital in pharmacy system.");
        return hospitals;
    }

}
