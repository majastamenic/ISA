package com.isa.pharmacy.controller.mapping;

import com.isa.pharmacy.controller.dto.GetAllPharmaciesPharmacyAdminDto;
import com.isa.pharmacy.controller.dto.CreatePhAdminDto;
import com.isa.pharmacy.domain.Pharmacy;
import com.isa.pharmacy.domain.Profile.PharmacyAdmin;

public class PharmacyAdminMapper {
    public static PharmacyAdmin mapPharmacyAdminDtoToPharmacyAdmin(CreatePhAdminDto createPhAdminDto, Pharmacy pharmacy){
        PharmacyAdmin pharmacyAdmin = new PharmacyAdmin();
        pharmacyAdmin.setUser(createPhAdminDto.getUser());
        pharmacyAdmin.setPharmacy(pharmacy);
        return pharmacyAdmin;
    }

    public static CreatePhAdminDto mapPharmacyAdminToPharmacyAdminDto(PharmacyAdmin pharmacyAdmin) {
        CreatePhAdminDto createPhAdminDto = new CreatePhAdminDto();
        createPhAdminDto.setPharmacyId(pharmacyAdmin.getPharmacy().getId());
        createPhAdminDto.setUser(pharmacyAdmin.getUser());
        return createPhAdminDto;
    }


    public static GetAllPharmaciesPharmacyAdminDto mapPharmacyAdminToGetAllPharmaciesPharmacyAdminDto (PharmacyAdmin
    admin){
        GetAllPharmaciesPharmacyAdminDto getAllPharmaciesPharmacyAdminDto = new GetAllPharmaciesPharmacyAdminDto();
        getAllPharmaciesPharmacyAdminDto.setFirstLog(admin.getFirstLog());
        getAllPharmaciesPharmacyAdminDto.setUser(admin.getUser());
        getAllPharmaciesPharmacyAdminDto.setSchedule(admin.getSchedule());
        return getAllPharmaciesPharmacyAdminDto;

    }
}
