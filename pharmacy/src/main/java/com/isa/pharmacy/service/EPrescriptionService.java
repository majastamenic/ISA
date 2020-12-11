package com.isa.pharmacy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isa.pharmacy.domain.EPrescription;
import com.isa.pharmacy.repository.EPrescriptionRepository;

@Service
public class EPrescriptionService {
	
	@Autowired
	private EPrescriptionRepository ePrescriptionRepository;
	
	public List<EPrescription> getAll(){
		return ePrescriptionRepository.findAll();
	}
	
	public EPrescription getById(Long id){
		return ePrescriptionRepository.findEPrescriptionById(id);
	}
	


}
