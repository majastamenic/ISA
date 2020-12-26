package com.isa.pharmacy.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.isa.pharmacy.domain.Pharmacy;
import com.isa.pharmacy.repository.PharmacyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isa.pharmacy.domain.MedicinePharmacy;
import com.isa.pharmacy.repository.MedicinePharmacyRepository;

@Service
public class MedicinePharmacyService {
	@Autowired
	private MedicinePharmacyRepository medicinePharmacyRepository;
	@Autowired
	private PharmacyRepository pharmacyRepository;
	
	public List<MedicinePharmacy> getAll(){
		return medicinePharmacyRepository.findAll();
	}
	
	public MedicinePharmacy create(MedicinePharmacy medicinePharmacy) {
		return medicinePharmacyRepository.save(medicinePharmacy);
	}

	public List<MedicinePharmacy> getMedicinesFromPharmacy(String pharmacyName){
		List<MedicinePharmacy> medicationNames = new ArrayList<MedicinePharmacy>();
		List<MedicinePharmacy> medicinePharmacyList = medicinePharmacyRepository.findMedicinePharmacyByPharmacy(pharmacyRepository.findPharmacyByName(pharmacyName));
		MedicinePharmacy med = new MedicinePharmacy();
		if(!medicinePharmacyList.isEmpty()){
			for (MedicinePharmacy medication : medicinePharmacyRepository.findAll()) {
				if(medication.getPharmacy().getName().equals(pharmacyName)){
					medicationNames.add(medication);
				}
			}
			return medicationNames;
		}
		return null;
	}

	public int hasPharmacyMedication(String pharmacyName, String nameOfMedication){
		for (MedicinePharmacy medication : medicinePharmacyRepository.findAll()) {
			if (medication.getMedicine().getName().toLowerCase().equals(nameOfMedication.toLowerCase()) && medication.getPharmacy().getName().equals(pharmacyName)) {
				return medication.getQuantity();
			}
		}
		return -1;
	}
}
