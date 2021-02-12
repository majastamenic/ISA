package com.isa.pharmacy.users.controller.mapping;

import com.isa.pharmacy.controller.dto.PharmacistByPharmacyDto;
import com.isa.pharmacy.controller.mapping.PharmacyMapper;
import com.isa.pharmacy.users.controller.dto.CreatePharmacistDto;
import com.isa.pharmacy.users.controller.dto.PharmacistDto;
import com.isa.pharmacy.users.domain.Pharmacist;

import java.util.ArrayList;
import java.util.List;

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

    public  static PharmacistByPharmacyDto mapPharmacistToPharmacistByPharmacyDto(Pharmacist pharmacist){
        PharmacistByPharmacyDto pharmacistByPharmacyDto = new PharmacistByPharmacyDto();
        pharmacistByPharmacyDto.setUser(pharmacist.getUser());
        return pharmacistByPharmacyDto;
    }

    public static PharmacistDto mapPharmacistToPharmacistDto(Pharmacist pharmacist){
        PharmacistDto ph = new PharmacistDto();
        ph.setPharmacy(PharmacyMapper.mapPharmacyToPharmacyDto(pharmacist.getPharmacy()));
        ph.setUser(UserMapper.mapUserToUserDto(pharmacist.getUser()));
        return ph;
    }

    public static Pharmacist mapPharmacistDtoToPharmacist(PharmacistDto pharmacistDto){
        Pharmacist pharmacist = new Pharmacist();
        pharmacist.setPharmacy(PharmacyMapper.mapPharmacyDtoToPharmacy(pharmacistDto.getPharmacy()));
        pharmacist.setUser(UserMapper.mapUserDtoToUser(pharmacistDto.getUser()));
        return pharmacist;
    }

    public static List<PharmacistDto> mapListPharmacistToPharmacistDto(List<Pharmacist> pharmacists){
        List<PharmacistDto> mappedPharmacists = new ArrayList<>();
        for(Pharmacist pharmacist : pharmacists)
            mappedPharmacists.add(mapPharmacistToPharmacistDto(pharmacist));
        return mappedPharmacists;
    }
}
