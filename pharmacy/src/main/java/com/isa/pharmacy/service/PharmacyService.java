package com.isa.pharmacy.service;

import com.isa.pharmacy.controller.dto.*;
import com.isa.pharmacy.controller.exception.AlreadyExistsException;
import com.isa.pharmacy.controller.exception.NotFoundException;
import com.isa.pharmacy.controller.mapping.MedicineMapper;
import com.isa.pharmacy.controller.mapping.PharmacyMapper;
import com.isa.pharmacy.domain.*;
import com.isa.pharmacy.repository.PharmacyRepository;
import com.isa.pharmacy.service.interfaces.IPharmacyService;
import com.isa.pharmacy.users.domain.Pharmacist;
import com.isa.pharmacy.users.service.interfaces.IPharmacistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class PharmacyService implements IPharmacyService {

    @Autowired
    private PharmacyRepository pharmacyRepository;
    @Autowired
    private IPharmacistService pharmacistService;
    @Value("${apiKey}")
    private String apiKey;

    public Pharmacy save(Pharmacy p) {
        return pharmacyRepository.save(p);
    }

    public Pharmacy getById(Long id) {
        return pharmacyRepository.findPharmacyById(id);
    }

    public List<GetAllPharmaciesDto> getAll() {
        List<Pharmacy> pharmacies = pharmacyRepository.findAll();
        List<GetAllPharmaciesDto> pharmaciesDtos = new ArrayList<>();
        for (Pharmacy pharmacy: pharmacies) {
            pharmaciesDtos.add(PharmacyMapper.mapPharmacyToGetAllPharmaciesDto(pharmacy));
        }
        return pharmaciesDtos;
    }

    public List<Medicine> getMedicinesFromPharmacy(String pharmacyName) {
        Pharmacy pharmacy = getPharmacyByName(pharmacyName);
        List<Medicine> medicineList = new ArrayList<>();
        for (MedicinePharmacy medicinePharmacy : pharmacy.getMedicinePharmacy()) {
            medicineList.add(medicinePharmacy.getMedicine());
        }
        return medicineList;
    }

    public int hasPharmacyMedication(String pharmacyName, String medicineName) {
        Pharmacy pharmacy = getPharmacyByName(pharmacyName);
        for (MedicinePharmacy medicinePharmacy : pharmacy.getMedicinePharmacy()) {
            if (medicinePharmacy.getMedicine().getName().equalsIgnoreCase(medicineName))
                return medicinePharmacy.getQuantity();
        }
        throw new NotFoundException(String.format("Pharmacy %s doesn't have %s medicine", pharmacyName, medicineName));
    }

    public Medicine checkAvailability(String medicineName, String pharmacyName) {
        Pharmacy pharmacy = getPharmacyByName(pharmacyName);
        for (MedicinePharmacy medicinePharmacy : pharmacy.getMedicinePharmacy()) {
            if (medicinePharmacy.getMedicine().getName().equalsIgnoreCase(medicineName))
                return medicinePharmacy.getMedicine();
        }
        return null;
    }

    public List<MedicineDto> checkAvailabilities(List<String> medicinesName, String pharmacyName) {
        Pharmacy pharmacy = getPharmacyByName(pharmacyName);
        List<MedicineDto> medicineDtoList = new ArrayList<>();
        for (MedicinePharmacy medicinePharmacy : pharmacy.getMedicinePharmacy()) {
            for(String medicineName : medicinesName) {
                if (medicinePharmacy.getMedicine().getName().equalsIgnoreCase(medicineName))
                    medicineDtoList.add(MedicineMapper.mapMedicineToMedicineDto(medicinePharmacy.getMedicine(), pharmacyName));
            }
        }
        return medicineDtoList;
    }

    public MedicineDto orderMedicine(String medicineName, int amount, String pharmacyName) {
        Pharmacy pharmacy = getPharmacyByName(pharmacyName);
        for (MedicinePharmacy medicinePharmacy : pharmacy.getMedicinePharmacy()) {
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
        Pharmacy pharmacy = getPharmacyByName(pharmacyName);
        List<MedicineDto> medicineDtoList = new ArrayList<>();
        for (MedicinePharmacy medicinePharmacy : pharmacy.getMedicinePharmacy()) {
            medicineDtoList.add(MedicineMapper.mapMedicineToMedicineDto(medicinePharmacy.getMedicine(), pharmacyName));
        }
        return medicineDtoList;
    }

    public void checkApiKey(String apiKey){
        if (!(this.apiKey).equals(apiKey))
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
    }

    //TODO: Maja Samo apoteke u kojima je kupio lek
    public List<String> getPharmacyName(){
        List<String> pharmacyNames = new ArrayList<>();
        List<Pharmacy> pharmacyList = pharmacyRepository.findAll();
        if(pharmacyList.isEmpty())
            throw new NotFoundException("There is no pharmacy");
        for(Pharmacy pharmacy: pharmacyList)
            pharmacyNames.add("Pharmacy: "+ pharmacy.getName());
        return pharmacyNames;
    }

    public List<Pharmacy> getPharmaciesForCounseling(DateTimeDto eagerDate){
        List<Pharmacy> availablePharmacies = new ArrayList<>();
        List<String> addedPharmacies = new ArrayList<>();
        for(Pharmacist ph : pharmacistService.getFreePharmacistByDate(eagerDate)){
            if(!addedPharmacies.contains(ph.getPharmacy().getName())){
                availablePharmacies.add(pharmacyRepository.findPharmacyByName(ph.getPharmacy().getName()));
                addedPharmacies.add(ph.getPharmacy().getName());
            }
        }
        return availablePharmacies;
    }

    public List<Pharmacy> findPharmaciesBySubEmail(String email){
        List<Pharmacy> pharmacyList = pharmacyRepository.findPharmaciesBySubscriber(email);
        if(pharmacyList.isEmpty())
            throw new NotFoundException("User with email "+ email+" isn't subscribed to any pharmacy");
        return pharmacyList;
    }

    public void addSubscribe(String email, String phName){
        Pharmacy pharmacy = getPharmacyByName(phName);
        for(String subEmail: pharmacy.getSubscribedEmails())
            if(subEmail.equals(email))
                throw new AlreadyExistsException("You are already subscribed to "+phName+" pharmacy.");
        pharmacy.getSubscribedEmails().add(email);
        pharmacyRepository.save(pharmacy);
    }

    public void unsubscribe(String email, String phName){
        Pharmacy pharmacy = getPharmacyByName(phName);
        if(!pharmacy.getSubscribedEmails().isEmpty()) {
            pharmacy.getSubscribedEmails().remove(email);
            pharmacyRepository.save(pharmacy);
        }
    }

    public Pharmacy getPharmacyByName(String phName){
        Pharmacy pharmacy = pharmacyRepository.findPharmacyByName(phName);
        if(pharmacy == null)
            throw new NotFoundException("Pharmacy "+phName+ " doesn't exists.");
        return pharmacy;
    }

    public List<PharmacyPriceDto> getPharmacyByEPrescription(EPrescription ePrescription){
        List<Long> codes = new ArrayList<>();
        for(MedicineEPrescription med: ePrescription.getListOfMedication())
            codes.add(med.getCode());
        List<MedicinePharmacy> pharmacyList = pharmacyRepository.findPharmaciesByMedicineEprescription(codes);
        if(pharmacyList.isEmpty())
            throw new NotFoundException("Not found.");
        List<PharmacyPriceDto> pharmacyPriceDtos = new ArrayList<>();
        for(MedicinePharmacy medicinePharmacy: pharmacyList){
            PharmacyPriceDto pharmacyPriceDto = new PharmacyPriceDto();
            pharmacyPriceDto.setPhName(medicinePharmacy.getPharmacy().getName());
            pharmacyPriceDto.setPrice(medicinePharmacy.getPrice());
            pharmacyPriceDtos.add(pharmacyPriceDto);
        }
        return pharmacyPriceDtos;
    }

    public void update(Pharmacy pharmacy){
        pharmacyRepository.save(pharmacy);
    }
}
