package com.isa.pharmacy.controller.mapping;


import com.isa.pharmacy.controller.dto.*;
import com.isa.pharmacy.domain.Medicine;
import com.isa.pharmacy.domain.MedicinePharmacy;

import java.util.ArrayList;
import java.util.List;

public class MedicineMapper {

    public static Medicine mapMedicineDtoToMedicine(MedicineDto medicineDto) {
        Medicine medicine = new Medicine();
        medicine.setCode(medicineDto.getCode());
        medicine.setComposition(medicineDto.getComposition());
        medicine.setFormOfMedicine(medicineDto.getFormOfMedicine());
        medicine.setManufactured(medicineDto.getManufactured());
        medicine.setName(medicineDto.getName());
        medicine.setNote(medicineDto.getNote());
        medicine.setPublishingType(medicineDto.getPublishingType());
        medicine.setReplacementMedicines(medicineDto.getAlternative());
        return medicine;
    }

    public static MedicineDto mapMedicineToMedicineDto(Medicine medicine, String pharmacyName) {
        MedicineDto medicineDto = new MedicineDto();
        medicineDto.setCode(medicine.getCode());
        medicineDto.setName(medicine.getName());
        medicineDto.setTypeOfMedicine(medicine.getTypeOfMedicine());
        medicineDto.setFormOfMedicine(medicine.getFormOfMedicine());
        medicineDto.setComposition(medicine.getComposition());
        medicineDto.setManufactured(medicine.getManufactured());
        medicineDto.setPublishingType(medicine.getPublishingType());
        medicineDto.setAlternative(medicine.getReplacementMedicines());
        medicineDto.setNote(medicine.getNote());
        for (MedicinePharmacy medicinePharmacy : medicine.getMedicinePharmacy()) {
            if (medicinePharmacy.getPharmacy().getName().equalsIgnoreCase(pharmacyName)) {
                medicineDto.setPharmacyName(medicinePharmacy.getPharmacy().getName());
                medicineDto.setPrice(medicinePharmacy.getPrice());
                medicineDto.setAmount(medicinePharmacy.getQuantity());
                break;
            }
        }
        return medicineDto;
    }

    public static Medicine mapAddMedicineDtoToMedicine(AddMedicineDto medicineDto) {
        Medicine medicine = new Medicine();
        medicine.setCode(medicineDto.getCode());
        medicine.setName(medicineDto.getName());
        medicine.setTypeOfMedicine(medicineDto.getTypeOfMedicine());
        medicine.setFormOfMedicine(medicineDto.getFormOfMedicine());
        medicine.setComposition(medicineDto.getComposition());
        medicine.setManufactured(medicineDto.getManufactured());
        medicine.setPublishingType(medicineDto.getPublishingType());
        medicine.setReplacementMedicines(medicineDto.getReplacementMedicine());
        medicine.setNote(medicineDto.getNote());
        medicine.setLoyaltyPoints(medicineDto.getLoyaltyPoints());
        return medicine;
    }

    public static MedicineLoyaltyDto mapMedicineToMedicineLoyalityDto(Medicine medicine){
        MedicineLoyaltyDto medicineLoyaltyDto = new MedicineLoyaltyDto();
        medicineLoyaltyDto.setCode(medicine.getCode());
        medicineLoyaltyDto.setName(medicine.getName());
        medicineLoyaltyDto.setLoyaltyPoints(medicine.getLoyaltyPoints());

        return medicineLoyaltyDto;
    }

    public static Medicine mapMedicineLoyalityDtoToMedicine(MedicineLoyaltyDto medicineLoyaltyDto){
        Medicine medicine = new Medicine();
        medicine.setCode(medicineLoyaltyDto.getCode());
        medicine.setName(medicineLoyaltyDto.getName());
        medicine.setLoyaltyPoints(medicineLoyaltyDto.getLoyaltyPoints());

        return medicine;
    }

    public static Medicine mapMedicineFromPharmacyToMedicine(MedicineFromPharmacyDto medicineFromPharmacyDto) {
        Medicine medicine = new Medicine();
        medicine.setId(medicineFromPharmacyDto.getId());
        medicine.setName(medicineFromPharmacyDto.getName());
        return medicine;
    }

    public static MedicineFromPharmacyDto mapMedicineToMedicineFromPharmacyDto(Medicine medicine) {
        MedicineFromPharmacyDto medicineFromPharmacyDto = new MedicineFromPharmacyDto();
        medicineFromPharmacyDto.setName(medicine.getName());
        medicineFromPharmacyDto.setId(medicine.getId());
        return medicineFromPharmacyDto;
    }

    public static AllergyDto mapAllergyToAllergyDto (Medicine medicine){
        AllergyDto allergyDto = new AllergyDto();
        allergyDto.setName(medicine.getName());
        return allergyDto;
    }

    public static Medicine mapAllergyDtoToAllergy (AllergyDto allergyDto){
        Medicine med = new Medicine();
        med.setName(allergyDto.getName());
        return med;
    }

    public static List<SearchMedicineDto> mapMedicinesToSearchMedicinesDto(List<Medicine> medicines){
        List<SearchMedicineDto> searchMedicineDtos = new ArrayList<>();
        for(Medicine medicine: medicines){
            searchMedicineDtos.add(mapMedicineToSearchMedicineDto(medicine));
        }
        return searchMedicineDtos;
    }

    public static SearchMedicineDto mapMedicineToSearchMedicineDto(Medicine medicine){
        SearchMedicineDto searchMedicineDto = new SearchMedicineDto();
        searchMedicineDto.setCode(medicine.getCode());
        searchMedicineDto.setName(medicine.getName());
        searchMedicineDto.setComposition(medicine.getComposition());
        searchMedicineDto.setManufactured(medicine.getManufactured());
        searchMedicineDto.setFormOfMedicine(medicine.getFormOfMedicine());
        searchMedicineDto.setTypeOfMedicine(medicine.getTypeOfMedicine());
        searchMedicineDto.setPublishingType(medicine.getPublishingType());
        List<SearchMedPhDto> searchMedPhDtos = new ArrayList<>();
        SearchMedPhDto searchMedPhDto = new SearchMedPhDto();
        for(MedicinePharmacy medicinePharmacy: medicine.getMedicinePharmacy()){
            searchMedPhDto.setPharmacyName(medicinePharmacy.getPharmacy().getName());
            searchMedPhDto.setPrice(medicinePharmacy.getPrice());
            searchMedPhDtos.add(searchMedPhDto);
        }
        searchMedicineDto.setPharmacyPriceDtos(searchMedPhDtos);
        return searchMedicineDto;
    }
}
