package com.isa.pharmacy.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.isa.pharmacy.domain.Pharmacy;
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

	public List<String> getMedicinesFromPharmacy(Long idPharmacy){
		List<MedicinePharmacy> medicines = medicinePharmacyRepository.findAll();
		List<String> medicationNames = new ArrayList<String>();
		for (MedicinePharmacy medication : medicines) {
			if(medication.getPharmacy().getId().equals(idPharmacy)){
				medicationNames.add(medication.getMedicine().getName());
			}
		}
		return medicationNames;
	}

	public boolean hasPharmacyMedication(String nameOfMedication){
		List<MedicinePharmacy> medicines = medicinePharmacyRepository.findAll();
		for (MedicinePharmacy medication : medicines) {
			if (medication.getMedicine().getName().equals(nameOfMedication)) {
				if (medication.getQuantity() > 0)
					return true;
			}
		}
		return false;
	}
}
