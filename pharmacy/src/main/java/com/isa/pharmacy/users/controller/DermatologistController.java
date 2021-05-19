package com.isa.pharmacy.users.controller;

import com.isa.pharmacy.controller.dto.DermatologistDto;
import com.isa.pharmacy.controller.dto.VacationScheduleDto;
import com.isa.pharmacy.controller.exception.BadRequestException;
import com.isa.pharmacy.controller.exception.NotFoundException;
import com.isa.pharmacy.service.interfaces.IEmailService;
import com.isa.pharmacy.users.controller.dto.RegistrationDto;
import com.isa.pharmacy.users.controller.mapping.UserMapper;
import com.isa.pharmacy.users.domain.Dermatologist;
import com.isa.pharmacy.users.service.interfaces.IDermatologistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/dermatologist")
@CrossOrigin(origins ={ "http://localhost:4200", "https://pharmacy-25-frontend.herokuapp.com"})
public class DermatologistController {

    @Autowired
    private IDermatologistService dermatologistService;
    @Autowired
    private IEmailService emailService;

    @PostMapping
    public Dermatologist registration(@RequestBody RegistrationDto registrationDto) {
        Dermatologist dermatologist = dermatologistService.registration(UserMapper.mapRegistrationDtoToDermatologist(registrationDto));
        try {
            emailService.activationEmail(dermatologist.getUser());
        }catch (Exception e){
            throw new BadRequestException("Email feature not available on heroku");
        }
        return dermatologist;
    }

    @GetMapping
    public List<Dermatologist> getAll() { return dermatologistService.getAll(); }

    @GetMapping("/dermatologists/{name}")
    public List<DermatologistDto> dermatologistListByPharmacy(@PathVariable("name") String name){
        List<DermatologistDto> dermatologistDtos = dermatologistService.dermatologistListByPharmacyName(name);
        if(dermatologistDtos.isEmpty()){
            throw new NotFoundException("Pharmacy doesn't have dermatologist");
        }
        return dermatologistDtos;
    }

    @PostMapping("/check/vacation/{email}")
    public boolean checkVacationTerm(@RequestBody VacationScheduleDto vacationScheduleDto, @PathVariable("email") String email){
        return dermatologistService.checkVacationTerm(vacationScheduleDto, email);
    }
}
