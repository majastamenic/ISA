package com.isa.pharmacy.controller;

import com.isa.pharmacy.controller.dto.*;
import com.isa.pharmacy.controller.exception.NotFoundException;
import com.isa.pharmacy.controller.mapping.MedicineMapper;
import com.isa.pharmacy.controller.mapping.PharmacyMapper;
import com.isa.pharmacy.domain.Medicine;
import com.isa.pharmacy.domain.Pharmacy;
import com.isa.pharmacy.service.interfaces.IPharmacyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins ={ "http://localhost:4200", "https://pharmacy-25-frontend.herokuapp.com"})
@RequestMapping("/pharmacy")
public class PharmacyController {

    @Autowired
    private IPharmacyService pharmacyService;
    @Value("${apiKey}")
    private String apiKey;

    @GetMapping
    public List<GetAllPharmaciesDto> getAll() {
        return pharmacyService.getAll();
    }

    @PostMapping
    public Pharmacy save(@RequestBody PharmacyDto pharmacyDto) {
        return pharmacyService.save(PharmacyMapper.mapPharmacyDtoToPharmacy(pharmacyDto));
    }

    @GetMapping("/profit")
    public Integer getProfit(@RequestBody ProfitDto profitDto){
        return pharmacyService.pharmacyProfit(profitDto.getStartDate(),profitDto.getEndDate(),profitDto.getAdminEmail());
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

    @PostMapping("/hasPharmacyMedication/{pharmacyName}")
    public int hasPharmacyMedication(@PathVariable("pharmacyName") String pharmacyName,
                                     @RequestBody String medicineName, @RequestHeader("apiKey") String apiKey) {
        pharmacyService.checkApiKey(apiKey);
        return pharmacyService.hasPharmacyMedication(pharmacyName, medicineName);
    }
    @GetMapping("/ph/{name}")
    public PharmacyDto getPharmacyByName(@PathVariable String name){
        return PharmacyMapper.mapPharmacyToPharmacyDto(pharmacyService.getPharmacyByName(name));
    }


    @PutMapping("/availablePharmacies")
    public List<PharmacyDto> getPharmaciesForCounseling(@RequestBody DateTimeDto date) {
        return PharmacyMapper.mapListPharmacyToPharmacyDto(pharmacyService.getPharmaciesForCounseling(date));
    }

    @PutMapping("/subscribe/{phName}/{email}")
    public void subscribe(@PathVariable String phName, @PathVariable String email){
        pharmacyService.addSubscribe(email, phName);
    }

    @PutMapping("/unsubscribe/{phName}/{email}")
    public void unsubscribe(@PathVariable String phName, @PathVariable String email){
        pharmacyService.unsubscribe(email, phName);
    }

    @GetMapping("/sub_pharmacy/{email}")
    public List<String> getSubPharmacies(@PathVariable String email){
        List<String> phNames = new ArrayList<>();
        for(Pharmacy p: pharmacyService.findPharmaciesBySubEmail(email))
            phNames.add(p.getName());
        return phNames;

    }
}
