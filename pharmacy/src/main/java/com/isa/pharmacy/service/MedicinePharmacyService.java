package com.isa.pharmacy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isa.pharmacy.domain.MedicinePharmacy;
import com.isa.pharmacy.repository.MedicinePharmacyRepository;

@Service
public class MedicinePharmacyService {
	@Autowired
	private MedicinePharmacyRepository medicinePharmacyRepository;
	
	public List<MedicinePharmacy> getAll(){
		return medicinePharmacyRepository.findAll();
	}
	
	public MedicinePharmacy create(MedicinePharmacy medicinePharmacy) {
		return medicinePharmacyRepository.save(medicinePharmacy);
	}
}
