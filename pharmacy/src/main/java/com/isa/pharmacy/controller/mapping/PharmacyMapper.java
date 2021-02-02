package com.isa.pharmacy.controller.mapping;

import com.isa.pharmacy.controller.dto.PharmacyDto;
import com.isa.pharmacy.domain.Pharmacy;

import java.util.ArrayList;

public class PharmacyMapper {
    public static Pharmacy mapPharmacyDtoToPharmacy(PharmacyDto pharmacyDto){
        Pharmacy pharmacy = new Pharmacy();
        pharmacy.setName(pharmacyDto.getName());
        pharmacy.setAddress(pharmacyDto.getAddress());
        pharmacy.setMedicinePharmacy(null);
        pharmacy.setPharmacists(null);
        pharmacy.setAdmins(null);
        return pharmacy;
    }
}
