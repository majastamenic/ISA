package com.isa.pharmacy.users.controller.mapping;

import com.isa.pharmacy.controller.dto.PharmacistByPharmacyDto;
import com.isa.pharmacy.users.controller.dto.CreatePharmacistDto;
import com.isa.pharmacy.users.domain.Pharmacist;

import java.util.ArrayList;

public class PharmacistMapper {
    public static Pharmacist mapCreatePharmacistDtoToPharmacist(CreatePharmacistDto createPharmacistDto){
        Pharmacist pharmacist = new Pharmacist();
        pharmacist.setWorkSchedule(new ArrayList<>());
        return pharmacist;
    }

    public static CreatePharmacistDto mapPharmacistToCreatePharmacistDto(Pharmacist pharmacist){
        CreatePharmacistDto dto = new CreatePharmacistDto();
        dto.setUser(pharmacist.getUser());
        return dto;
    }

    public static Pharmacist mapPharmacistByPharmacyDtoToPharmacist(PharmacistByPharmacyDto pharmacistByPharmacyDto){
        Pharmacist pharmacist = new Pharmacist();
        pharmacist.setUser(pharmacistByPharmacyDto.getUser());
        return pharmacist;
    }

    public  static PharmacistByPharmacyDto mapPharmacistToPharmacistByPharmacyDto(Pharmacist pharmacist){
        PharmacistByPharmacyDto pharmacistByPharmacyDto = new PharmacistByPharmacyDto();
        pharmacistByPharmacyDto.setUser(pharmacist.getUser());
        return pharmacistByPharmacyDto;
    }
}
