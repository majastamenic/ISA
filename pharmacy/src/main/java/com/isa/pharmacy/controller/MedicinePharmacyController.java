package com.isa.pharmacy.controller;

import com.isa.pharmacy.controller.exception.NotFoundException;
import com.isa.pharmacy.domain.EPrescription;
import com.isa.pharmacy.domain.Medicine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.isa.pharmacy.service.MedicinePharmacyService;

import javax.swing.text.StyledEditorKit;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/medicinePharmacy")
@CrossOrigin(value = "http://localhost:4200")
public class MedicinePharmacyController {
	@Autowired
	private MedicinePharmacyService medicinePharmacyService;

	@GetMapping("/getAllMedicines/{pharmacyName}")
	public List<String> getMedicinesFromPharmacy(@PathVariable("pharmacyName") String pharmacyName) {
		List<String> listMedicines = medicinePharmacyService.getMedicinesFromPharmacy(pharmacyName);
		if (listMedicines.isEmpty()) {
			throw new NotFoundException(String.format("Pharmacy %s doesn't have any medicine", pharmacyName));
		}
		return listMedicines;
	}

	@PostMapping("/hasPharmacyMedication/{pharmacyName}")
	public Boolean hasPharmacyMedication(@PathVariable("pharmacyName") String pharmacyName, @RequestBody String medicineName){
		return  medicinePharmacyService.hasPharmacyMedication(pharmacyName, medicineName);
	}


}
