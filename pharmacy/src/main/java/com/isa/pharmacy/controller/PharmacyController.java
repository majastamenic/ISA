package com.isa.pharmacy.controller;

import java.util.List;

import com.isa.pharmacy.controller.dto.MedicineDto;
import com.isa.pharmacy.controller.exception.NotFoundException;
import com.isa.pharmacy.controller.mapping.MedicineMapper;
import com.isa.pharmacy.domain.Medicine;
import com.isa.pharmacy.domain.MedicinePharmacy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.isa.pharmacy.domain.Pharmacy;
import com.isa.pharmacy.service.PharmacyService;

@RestController
@RequestMapping("/pharmacy")
public class PharmacyController {

    @Autowired
    private PharmacyService pharmacyService;

    @GetMapping
    public List<Pharmacy> getAll() {
        return pharmacyService.getAll();
    }


    @GetMapping("/getAllMedicines/{pharmacyName}")
    public List<Medicine> getMedicinesFromPharmacy(@PathVariable("pharmacyName") String pharmacyName) {
        List<Medicine> listMedicines = pharmacyService.getMedicinesFromPharmacy(pharmacyName);
        if (listMedicines.isEmpty()) {
            throw new NotFoundException(String.format("Pharmacy %s doesn't have any medicine", pharmacyName));
        }
        return listMedicines;
    }

    @GetMapping("/checkAvailability/{medicineName}/{pharmacyName}")
    public MedicineDto checkAvailability(@PathVariable("medicineName") String medicineName, @PathVariable("pharmacyName") String pharmacyName) {
        Medicine medicine = pharmacyService.checkAvailability(medicineName, pharmacyName);
        if (medicine != null)
            return MedicineMapper.mapMedicineToMedicineDto(medicine, pharmacyName);
        return null;
    }

    @GetMapping("/orderMedicine/{pharmacyName}")
    public MedicineDto orderMedicine(@RequestParam String medicineName, @RequestParam int amount, @PathVariable String pharmacyName) {
        return pharmacyService.orderMedicine(medicineName, amount, pharmacyName);
    }

    @PostMapping
    public Pharmacy save(Pharmacy p) {
        return pharmacyService.save(p);
    }

    @PostMapping("/hasPharmacyMedication/{pharmacyName}")
    public int hasPharmacyMedication(@PathVariable("pharmacyName") String pharmacyName, @RequestBody String medicineName) {
        return pharmacyService.hasPharmacyMedication(pharmacyName, medicineName);
    }
}
