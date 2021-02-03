package com.isa.pharmacy.service;

import java.util.ArrayList;
import java.util.List;
import com.isa.pharmacy.controller.dto.MedicineDto;
import com.isa.pharmacy.controller.dto.MedicineOrderDto;
import com.isa.pharmacy.controller.dto.PharmacyDto;
import com.isa.pharmacy.controller.exception.AlreadyExistsException;
import com.isa.pharmacy.controller.exception.NotFoundException;
import com.isa.pharmacy.controller.mapping.MedicineMapper;
import com.isa.pharmacy.controller.mapping.PharmacyMapper;
import com.isa.pharmacy.domain.Medicine;
import com.isa.pharmacy.domain.MedicinePharmacy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import com.isa.pharmacy.domain.Pharmacy;
import com.isa.pharmacy.repository.PharmacyRepository;
import org.springframework.web.server.ResponseStatusException;

@Repository
public class PharmacyService {
    @Autowired
    private PharmacyRepository pharmacyRepository;
    @Value("${apiKey}")
    private String apiKey;

    public Pharmacy save(Pharmacy p) {
        return pharmacyRepository.save(p);
    }

    public Pharmacy getByName(String name) {
        return pharmacyRepository.findPharmacyByName(name);
    }
    public List<Pharmacy> getAll() {
        return pharmacyRepository.findAll();
    }

    public List<Medicine> getMedicinesFromPharmacy(String pharmacyName) {
        Pharmacy pharmacy = pharmacyRepository.findPharmacyByName(pharmacyName);
        List<Medicine> medicineList = new ArrayList<>();
        for (MedicinePharmacy medicinePharmacy : pharmacy.getMedicinePharmacies()) {
            medicineList.add(medicinePharmacy.getMedicine());
        }
        return medicineList;
        }

    public int hasPharmacyMedication(String pharmacyName, String medicineName) {
        Pharmacy pharmacy = pharmacyRepository.findPharmacyByName(pharmacyName);
        for (MedicinePharmacy medicinePharmacy : pharmacy.getMedicinePharmacies()) {
            if (medicinePharmacy.getMedicine().getName().equalsIgnoreCase(medicineName))
                return medicinePharmacy.getQuantity();
        }
        throw new NotFoundException(String.format("Pharmacy %s doesn't have %s medicine", pharmacyName, medicineName));
    }

    public Medicine checkAvailability(String medicineName, String pharmacyName) {
        Pharmacy pharmacy = pharmacyRepository.findPharmacyByName(pharmacyName);
        for (MedicinePharmacy medicinePharmacy : pharmacy.getMedicinePharmacies()) {
            if (medicinePharmacy.getMedicine().getName().equalsIgnoreCase(medicineName))
                return medicinePharmacy.getMedicine();
        }
        return null;
    }

    public List<MedicineDto> checkAvailabilities(List<String> medicinesName, String pharmacyName) {
        Pharmacy pharmacy = pharmacyRepository.findPharmacyByName(pharmacyName);
        List<MedicineDto> medicineDtoList = new ArrayList<>();
        for (MedicinePharmacy medicinePharmacy : pharmacy.getMedicinePharmacies()) {
            for(String medicineName : medicinesName) {
                if (medicinePharmacy.getMedicine().getName().equalsIgnoreCase(medicineName))
                    medicineDtoList.add(MedicineMapper.mapMedicineToMedicineDto(medicinePharmacy.getMedicine(), pharmacyName));
            }
        }
        return medicineDtoList;
    }

    public MedicineDto orderMedicine(String medicineName, int amount, String pharmacyName) {
        Pharmacy pharmacy = pharmacyRepository.findPharmacyByName(pharmacyName);
        for (MedicinePharmacy medicinePharmacy : pharmacy.getMedicinePharmacies()) {
            if (medicinePharmacy.getMedicine().getName().equalsIgnoreCase(medicineName)
                    && medicinePharmacy.getQuantity() >= amount) {
                medicinePharmacy.setQuantity(medicinePharmacy.getQuantity() - amount);
                pharmacyRepository.save(pharmacy);
                medicinePharmacy.setQuantity(amount);
                return MedicineMapper.mapMedicineToMedicineDto(medicinePharmacy.getMedicine(), pharmacyName);
            }
        }
        return null;
    }

    public List<MedicineDto> orderMedicines(List<MedicineOrderDto> medicineOrderDtoList,String pharmacyName) {
        List<MedicineDto> medicineDtoList = new ArrayList<>();
        for(MedicineOrderDto medicineOrderDto: medicineOrderDtoList){
            MedicineDto medicineDto = orderMedicine(medicineOrderDto.getMedicineName(), medicineOrderDto.getAmount(), pharmacyName);
            if(medicineDto != null)
                medicineDtoList.add(medicineDto);
        }
        return medicineDtoList;
    }

    public List<MedicineDto> getMedicineListFromPharmacy(String pharmacyName) {
        Pharmacy pharmacy = pharmacyRepository.findPharmacyByName(pharmacyName);
        List<MedicineDto> medicineDtoList = new ArrayList<>();
        for (MedicinePharmacy medicinePharmacy : pharmacy.getMedicinePharmacies()) {
            medicineDtoList.add(MedicineMapper.mapMedicineToMedicineDto(medicinePharmacy.getMedicine(), pharmacyName));
        }
        return medicineDtoList;
    }

    public void checkApiKey(String apiKey){
        if (!(this.apiKey).equals(apiKey))
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
    }
}
