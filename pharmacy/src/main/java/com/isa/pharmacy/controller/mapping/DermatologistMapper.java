package com.isa.pharmacy.controller.mapping;

import com.isa.pharmacy.controller.dto.DermatologistDto;
import com.isa.pharmacy.users.domain.Dermatologist;

public class DermatologistMapper {

    public static DermatologistDto mapDermatologistToDermatologistDto(Dermatologist dermatologist){
        DermatologistDto dermatologistDto = new DermatologistDto();
        dermatologistDto.setId(dermatologist.getId());
        dermatologistDto.setUser(dermatologist.getUser());
        return dermatologistDto;
    }

    public static Dermatologist mapDermatologistToDermatologistDto(DermatologistDto dermatologistDto){
        Dermatologist dermatologist = new Dermatologist();
        dermatologist.setId(dermatologistDto.getId());
        dermatologist.setUser(dermatologistDto.getUser());
        return dermatologist;
    }
}
