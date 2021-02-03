package com.isa.pharmacy.controller.mapping;

import com.isa.pharmacy.controller.dto.CreatePharmacistDto;
import com.isa.pharmacy.controller.dto.PharmacistDto;
import com.isa.pharmacy.domain.Profile.Pharmacist;

import java.util.ArrayList;

public class PharmacistMapper {
    public static Pharmacist mapCreatePharmacistDtoToPharmacist(CreatePharmacistDto createPharmacistDto){
        Pharmacist pharmacist = new Pharmacist();
        pharmacist.setFirstLog(createPharmacistDto.isFirstLog());
        pharmacist.setWorkSchedule(new ArrayList<>());
        return pharmacist;
    }

    public static CreatePharmacistDto mapPharmacistToCreatePharmacistDto(Pharmacist pharmacist){
        CreatePharmacistDto dto = new CreatePharmacistDto();
        dto.setFirstLog(pharmacist.isFirstLog());
        dto.setUser(pharmacist.getUser());
        return dto;
    }
}
