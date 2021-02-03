package com.isa.pharmacy.controller.mapping;

import com.isa.pharmacy.controller.dto.PharmacyAdminDto;
import com.isa.pharmacy.domain.Profile.PharmacyAdmin;

public class PharmacyAdminMapper {
    public static PharmacyAdmin mapPharmacyAdminDtoToPharmacyAdmin(PharmacyAdminDto pharmacyAdminDto){
        PharmacyAdmin pharmacyAdmin = new PharmacyAdmin();
        pharmacyAdmin.setUser(UserMapper.mapRegistrationDtoToUser(pharmacyAdminDto.getRegistrationDto()));
        pharmacyAdmin.setPharmacy(PharmacyMapper.mapPharmacyDtoToPharmacy(pharmacyAdminDto.getPharmacyDto()));
        return pharmacyAdmin;
    }

    public static PharmacyAdminDto mapPharmacyAdminToPharmacyAdminDto(PharmacyAdmin pharmacyAdmin) {
        PharmacyAdminDto pharmacyAdminDto = new PharmacyAdminDto();
        pharmacyAdminDto.setPharmacyDto(PharmacyMapper.mapPharmacyToPharmacyDto(pharmacyAdmin.getPharmacy()));
        pharmacyAdminDto.setRegistrationDto(UserMapper.mapUserToRegistrationDto(pharmacyAdmin.getUser()));
        return pharmacyAdminDto;
    }
}
