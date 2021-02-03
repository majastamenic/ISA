package com.isa.pharmacy.controller.mapping;

import com.isa.pharmacy.controller.dto.GetAllPharmaciesDto;
import com.isa.pharmacy.domain.Pharmacy;
import com.isa.pharmacy.domain.Profile.PharmacyAdmin;

import java.util.ArrayList;

public class PharmacyMapper {

    public static GetAllPharmaciesDto mapPharmacyToGetAllPharmaciesDto(Pharmacy pharmacy) {
        GetAllPharmaciesDto dto = new GetAllPharmaciesDto();
        dto.setId(pharmacy.getId());
        dto.setName(pharmacy.getName());
        dto.setAddress(pharmacy.getAddress());
        dto.setPharmacists(pharmacy.getPharmacists());
        dto.setAdmins(new ArrayList<>());
        for (PharmacyAdmin pharmacyAdmin:pharmacy.getAdmins()) {
            dto.getAdmins().add(PharmacyAdminMapper.mapPharmacyAdminToGetAllPharmaciesPharmacyAdminDto(pharmacyAdmin));
        }
        return dto;
    }
}
