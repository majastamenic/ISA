package com.isa.pharmacy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isa.pharmacy.controller.exception.AlreadyExistsException;
import com.isa.pharmacy.domain.Hospital;
import com.isa.pharmacy.repository.HospitalRepository;

@Service
public class HospitalService {
	@Autowired
	private HospitalRepository hospitalRepository;
	
	//Query za promalazak apoteke	
	
	public Hospital create(Hospital hospital) {
		Hospital existingHospital = hospitalRepository.findByEmail(hospital.getEmail());
		if (existingHospital == null) {
			return hospitalRepository.save(hospital);
		}
		throw new AlreadyExistsException(String.format("Hospital with email %s, already registered", hospital.getEmail()));
	}

	public Hospital getById(Long id) {
		Hospital hospital = hospitalRepository.findHospitalById(id);
		return hospital;
	}	
	
	public Hospital getByEmail(String email) {
		Hospital hospital = hospitalRepository.findByEmail(email);
		return hospital;
	}
	
	public List<Hospital> getAll(){
		return hospitalRepository.findAll();
	}

}
