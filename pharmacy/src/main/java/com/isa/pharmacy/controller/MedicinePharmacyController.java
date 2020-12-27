package com.isa.pharmacy.controller;

import com.isa.pharmacy.controller.exception.NotFoundException;
import com.isa.pharmacy.domain.MedicinePharmacy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.isa.pharmacy.service.MedicinePharmacyService;

import java.util.List;

@RestController
@RequestMapping("/medicinePharmacy")
@CrossOrigin(value = "http://localhost:4200")
public class MedicinePharmacyController {
	@Autowired
	private MedicinePharmacyService medicinePharmacyService;

	@GetMapping("/getAllMedicines/{pharmacyName}")
	public List<MedicinePharmacy> getMedicinesFromPharmacy(@PathVariable("pharmacyName") String pharmacyName) {
		List<MedicinePharmacy> listMedicines = medicinePharmacyService.getMedicinesFromPharmacy(pharmacyName);
		if (listMedicines.isEmpty()) {
			throw new NotFoundException(String.format("Pharmacy %s doesn't have any medicine", pharmacyName));
		}
		return listMedicines;
	}

	@PostMapping("/hasPharmacyMedication/{pharmacyName}")
	public int hasPharmacyMedication(@PathVariable("pharmacyName") String pharmacyName, @RequestBody String medicineName){
		return  medicinePharmacyService.hasPharmacyMedication(pharmacyName, medicineName);
	}


}
