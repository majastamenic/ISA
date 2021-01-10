package com.isa.pharmacy.controller;

import java.util.List;

import com.isa.pharmacy.controller.dto.MedicineDto;
import com.isa.pharmacy.controller.dto.MedicineOrderDto;
import com.isa.pharmacy.controller.exception.NotFoundException;
import com.isa.pharmacy.controller.mapping.MedicineMapper;
import com.isa.pharmacy.domain.Medicine;
import com.isa.pharmacy.domain.MedicinePharmacy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
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

    @GetMapping("/{name}")
    public ResponseEntity<String> sendResponse(@RequestHeader("apiKey") String apiKey) {
        if (apiKey.equals(""))
            return new ResponseEntity<String>("",
                    HttpStatus.FORBIDDEN);
        if ((pharmacyService.getByApiKey(apiKey)).equals(""))
            return new ResponseEntity<String>("Wrong apiKey",
                    HttpStatus.BAD_REQUEST);
        else
            return new ResponseEntity<String>(
                    "Welcome",
                    HttpStatus.OK);
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

    @PostMapping("/checkAvailability/{pharmacyName}")
    public List<MedicineDto> checkAvailability(@RequestBody List<String> medicinesName, @PathVariable("pharmacyName") String pharmacyName) {
        List<MedicineDto> medicineDtoList = pharmacyService.checkAvailabilities(medicinesName, pharmacyName);
        if (!medicineDtoList.isEmpty())
            return medicineDtoList;
        return null;
    }

    @GetMapping("/orderMedicine/{pharmacyName}")
    public MedicineDto orderMedicine(@RequestParam String medicineName, @RequestParam int amount, @PathVariable String pharmacyName) {
        return pharmacyService.orderMedicine(medicineName, amount, pharmacyName);
    }

    @PostMapping("/orderMedicines/{pharmacyName}")
    public List<MedicineDto> orderMedicines(@RequestBody List<MedicineOrderDto> medicineOrderDtoList, @PathVariable String pharmacyName) {
        return pharmacyService.orderMedicines(medicineOrderDtoList, pharmacyName);
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
