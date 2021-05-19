package com.isa.pharmacy.controller.mapping;

import com.isa.pharmacy.controller.dto.PharmacyDto;
import com.isa.pharmacy.controller.dto.PharmacyFromMedicinePharmacyDto;
import com.isa.pharmacy.domain.Pharmacy;
import com.isa.pharmacy.controller.dto.GetAllPharmaciesDto;

import java.util.ArrayList;
import java.util.List;

public class PharmacyMapper {

    public static Pharmacy mapPharmacyDtoToPharmacy(PharmacyDto pharmacyDto){
        Pharmacy pharmacy = new Pharmacy();
        pharmacy.setId(pharmacyDto.getId());
        pharmacy.setName(pharmacyDto.getName());
        pharmacy.setAddress(pharmacyDto.getAddress());
        pharmacy.setMedicinePharmacy(null);
        return pharmacy;
    }

    public static PharmacyDto mapPharmacyToPharmacyDto(Pharmacy pharmacy) {
        return new PharmacyDto(pharmacy.getId(), pharmacy.getName(),
                pharmacy.getAddress(),
                pharmacy.getCounselingPrice());
    }

    public static List<PharmacyDto> mapListPharmacyToPharmacyDto(List<Pharmacy> pharmacies){
        List<PharmacyDto> mappedPharmacies = new ArrayList<>();
        for(Pharmacy pharmacy : pharmacies)
            mappedPharmacies.add(mapPharmacyToPharmacyDto(pharmacy));
        return mappedPharmacies;
    }

    public static GetAllPharmaciesDto mapPharmacyToGetAllPharmaciesDto(Pharmacy pharmacy) {
        GetAllPharmaciesDto dto = new GetAllPharmaciesDto();
        dto.setId(pharmacy.getId());
        dto.setName(pharmacy.getName());
        dto.setAddress(pharmacy.getAddress());

        return dto;
    }

    public static PharmacyFromMedicinePharmacyDto mapPharmacyToPharmacyFromMedicinePharmacyDto(Pharmacy pharmacy){
        PharmacyFromMedicinePharmacyDto pharmacyFromMedicinePharmacyDto = new PharmacyFromMedicinePharmacyDto();

        pharmacyFromMedicinePharmacyDto.setId(pharmacy.getId());
        pharmacyFromMedicinePharmacyDto.setAddress(pharmacy.getAddress());
        pharmacyFromMedicinePharmacyDto.setName(pharmacy.getName());
        return  pharmacyFromMedicinePharmacyDto;
    }

    public static Pharmacy mapPharmacyFromMedicinePharmacyDtoToPharmacy(PharmacyFromMedicinePharmacyDto pharmacyFromMedicinePharmacyDto){
        Pharmacy pharmacy = new Pharmacy();
        pharmacy.setAddress(pharmacyFromMedicinePharmacyDto.getAddress());
        pharmacy.setName(pharmacyFromMedicinePharmacyDto.getName());
        pharmacy.setId(pharmacyFromMedicinePharmacyDto.getId());
        return  pharmacy;
    }
}
