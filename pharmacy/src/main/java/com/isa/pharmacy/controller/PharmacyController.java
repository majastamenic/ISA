package com.isa.pharmacy.controller;

import com.isa.pharmacy.controller.dto.GetAllPharmaciesDto;
import com.isa.pharmacy.controller.dto.MedicineDto;
import com.isa.pharmacy.controller.dto.MedicineOrderDto;
import com.isa.pharmacy.controller.exception.NotFoundException;
import com.isa.pharmacy.controller.mapping.MedicineMapper;
import com.isa.pharmacy.domain.Medicine;
import com.isa.pharmacy.domain.Pharmacy;
import com.isa.pharmacy.service.PharmacyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/pharmacy")
public class PharmacyController {

    @Autowired
    private PharmacyService pharmacyService;
    @Value("${apiKey}")
    private String apiKey;

    @GetMapping
    public List<GetAllPharmaciesDto> getAll() {
        return pharmacyService.getAll();
    }

    @GetMapping("/{name}")
    public ResponseEntity<String> sendResponse(@RequestHeader("apiKey") String apiKey) {
        if (apiKey.equals(""))
            return new ResponseEntity<>("", HttpStatus.FORBIDDEN);
        if (!(this.apiKey).equals(apiKey))
            return new ResponseEntity<>("Wrong apiKey", HttpStatus.BAD_REQUEST);
        else
            return new ResponseEntity<>("Welcome", HttpStatus.OK);
    }

    @GetMapping("/getAllMedicines/{pharmacyName}")
    public List<Medicine> getMedicinesFromPharmacy(@PathVariable("pharmacyName") String pharmacyName, @RequestHeader("apiKey") String apiKey) {
        pharmacyService.checkApiKey(apiKey);
        List<Medicine> listMedicines = pharmacyService.getMedicinesFromPharmacy(pharmacyName);
        if (listMedicines.isEmpty()) {
            throw new NotFoundException(String.format("Pharmacy %s doesn't have any medicine", pharmacyName));
        }
        return listMedicines;
    }

    @GetMapping("/getMedicines/{pharmacyName}")
    public List<MedicineDto> getMedicineFromPharmacy(@PathVariable("pharmacyName") String pharmacyName,
                                                     @RequestHeader("apiKey") String apiKey) {
        pharmacyService.checkApiKey(apiKey);
        List<MedicineDto> medicineDtoList = pharmacyService.getMedicineListFromPharmacy(pharmacyName);
        if (medicineDtoList.isEmpty()) {
            throw new NotFoundException(String.format("Pharmacy %s doesn't have any medicine", pharmacyName));
        }
        return medicineDtoList;
    }

    @GetMapping("/checkAvailability/{medicineName}/{pharmacyName}")
    public MedicineDto checkAvailability(@PathVariable("medicineName") String medicineName,
                                         @PathVariable("pharmacyName") String pharmacyName, @RequestHeader("apiKey") String apiKey) {
        pharmacyService.checkApiKey(apiKey);
        Medicine medicine = pharmacyService.checkAvailability(medicineName, pharmacyName);
        if (medicine != null)
            return MedicineMapper.mapMedicineToMedicineDto(medicine, pharmacyName);
        throw new NotFoundException(String.format("Pharmacy %s doesn't have %s medicine", pharmacyName, medicineName));
    }

    @PostMapping("/checkAvailability/{pharmacyName}")
    public List<MedicineDto> checkAvailability(@RequestBody List<String> medicinesName,
                                               @PathVariable("pharmacyName") String pharmacyName, @RequestHeader("apiKey") String apiKey) {
        pharmacyService.checkApiKey(apiKey);
        List<MedicineDto> medicineDtoList = pharmacyService.checkAvailabilities(medicinesName, pharmacyName);
        if (!medicineDtoList.isEmpty())
            return medicineDtoList;
        throw new NotFoundException(String.format("Pharmacy %s doesn't have medicines", pharmacyName));
    }

    @GetMapping("/orderMedicine/{pharmacyName}")
    public MedicineDto orderMedicine(@RequestParam String medicineName, @RequestParam int amount,
                                     @PathVariable String pharmacyName, @RequestHeader("apiKey") String apiKey) {
        pharmacyService.checkApiKey(apiKey);
        return pharmacyService.orderMedicine(medicineName, amount, pharmacyName);
    }

    @PostMapping("/orderMedicines/{pharmacyName}")
    public List<MedicineDto> orderMedicines(@RequestBody List<MedicineOrderDto> medicineOrderDtoList,
                                            @PathVariable String pharmacyName, @RequestHeader("apiKey") String apiKey) {
        pharmacyService.checkApiKey(apiKey);
        return pharmacyService.orderMedicines(medicineOrderDtoList, pharmacyName);
    }

    @PostMapping
    public Pharmacy save(Pharmacy p) {
        return pharmacyService.save(p);
    }

    @PostMapping("/hasPharmacyMedication/{pharmacyName}")
    public int hasPharmacyMedication(@PathVariable("pharmacyName") String pharmacyName,
                                     @RequestBody String medicineName, @RequestHeader("apiKey") String apiKey) {
        pharmacyService.checkApiKey(apiKey);
        return pharmacyService.hasPharmacyMedication(pharmacyName, medicineName);
    }
}
