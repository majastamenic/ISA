package com.isa.pharmacy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isa.pharmacy.domain.ePrescription;
import com.isa.pharmacy.repository.ePrescriptionRepository;

@Service
public class ePrescriptionService {
	
	@Autowired
	private ePrescriptionRepository ePrescriptionRepository;
	
	public List<ePrescription> getAll(){
		return ePrescriptionRepository.getAll();
	}
	
	public ePrescription getById(Long id){
		return ePrescriptionRepository.findePrescriptionById(id);
	}

}
