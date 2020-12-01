package com.isa.pharmacy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.isa.pharmacy.domain.Pharmacy;
import com.isa.pharmacy.repository.PharmacyRepository;

@Repository
public class PharmacyService {
	@Autowired
	private PharmacyRepository pharmacyRepository;
	
	
	public Pharmacy save(Pharmacy p) {
		return pharmacyRepository.save(p);
	}
	
	public Pharmacy getByApiKey(String apiKey) {
		if(pharmacyRepository.findPharmacyByApiKey(apiKey).equals(null))
			return null;
		else
			return pharmacyRepository.findPharmacyByApiKey(apiKey);
	}
	
	public Pharmacy getByName(String name) {
		return pharmacyRepository.findPharmacyByName(name);
	}
	
	
	public List<Pharmacy> getAll(){
		return pharmacyRepository.findAll();
	}
}
