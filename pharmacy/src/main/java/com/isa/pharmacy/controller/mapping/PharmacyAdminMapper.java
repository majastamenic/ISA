package com.isa.pharmacy.controller.mapping;

import com.isa.pharmacy.controller.dto.GetAllPharmaciesPharmacyAdminDto;
import com.isa.pharmacy.domain.Profile.PharmacyAdmin;

public class PharmacyAdminMapper {

    public static GetAllPharmaciesPharmacyAdminDto mapPharmacyAdminToGetAllPharmaciesPharmacyAdminDto(PharmacyAdmin admin) {
        GetAllPharmaciesPharmacyAdminDto getAllPharmaciesPharmacyAdminDto = new GetAllPharmaciesPharmacyAdminDto();
        getAllPharmaciesPharmacyAdminDto.setFirstLog(admin.getFirstLog());
        getAllPharmaciesPharmacyAdminDto.setUser(admin.getUser());
        getAllPharmaciesPharmacyAdminDto.setSchedule(admin.getSchedule());
        return getAllPharmaciesPharmacyAdminDto;
    }
}
