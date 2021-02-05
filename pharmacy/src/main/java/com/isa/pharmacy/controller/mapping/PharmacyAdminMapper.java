package com.isa.pharmacy.controller.mapping;

import com.isa.pharmacy.controller.dto.GetAllPharmaciesPharmacyAdminDto;
import com.isa.pharmacy.controller.dto.CreatePhAdminDto;
import com.isa.pharmacy.domain.Pharmacy;
import com.isa.pharmacy.users.domain.PharmacyAdmin;
import com.isa.pharmacy.users.domain.User;
import net.bytebuddy.utility.RandomString;

public class PharmacyAdminMapper {
    public static PharmacyAdmin mapPharmacyAdminDtoToPharmacyAdmin(CreatePhAdminDto createPhAdminDto, Pharmacy pharmacy){
        PharmacyAdmin pharmacyAdmin = new PharmacyAdmin();
        User user = new User();
        user.setEmail(createPhAdminDto.getEmail());
        user.setPassword(RandomString.make(10));
        user.setCountry(createPhAdminDto.getCountry());
        user.setCity(createPhAdminDto.getCity());
        user.setAddress(createPhAdminDto.getAddress());
        user.setPhone(createPhAdminDto.getPhone());
        user.setName(createPhAdminDto.getName());
        user.setSurname(createPhAdminDto.getSurname());
        user.setRole(createPhAdminDto.getRole());
        user.setActive(false);
        pharmacyAdmin.setUser(user);
        pharmacyAdmin.setPharmacy(pharmacy);
        return pharmacyAdmin;
    }

    public static CreatePhAdminDto mapPharmacyAdminToPharmacyAdminDto(PharmacyAdmin pharmacyAdmin) {
        CreatePhAdminDto createPhAdminDto = new CreatePhAdminDto();
        createPhAdminDto.setPharmacyId(pharmacyAdmin.getPharmacy().getId());
        createPhAdminDto.setEmail(pharmacyAdmin.getUser().getEmail());
        createPhAdminDto.setCountry(pharmacyAdmin.getUser().getCountry());
        createPhAdminDto.setCity(pharmacyAdmin.getUser().getCity());
        createPhAdminDto.setAddress(pharmacyAdmin.getUser().getAddress());
        createPhAdminDto.setName(pharmacyAdmin.getUser().getName());
        createPhAdminDto.setSurname(pharmacyAdmin.getUser().getSurname());
        createPhAdminDto.setActive(pharmacyAdmin.getUser().getActive());
        return createPhAdminDto;
    }


    public static GetAllPharmaciesPharmacyAdminDto mapPharmacyAdminToGetAllPharmaciesPharmacyAdminDto (PharmacyAdmin
    admin){
        GetAllPharmaciesPharmacyAdminDto getAllPharmaciesPharmacyAdminDto = new GetAllPharmaciesPharmacyAdminDto();
        getAllPharmaciesPharmacyAdminDto.setUser(admin.getUser());
        getAllPharmaciesPharmacyAdminDto.setSchedule(admin.getSchedule());
        return getAllPharmaciesPharmacyAdminDto;

    }
}
