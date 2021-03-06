package com.isa.pharmacy.users.controller;

import com.isa.pharmacy.controller.dto.DermatologistDto;
import com.isa.pharmacy.controller.dto.VacationScheduleDto;
import com.isa.pharmacy.controller.exception.BadRequestException;
import com.isa.pharmacy.controller.exception.NotFoundException;
import com.isa.pharmacy.controller.mapping.DermatologistMapper;
import com.isa.pharmacy.service.interfaces.IEmailService;
import com.isa.pharmacy.users.controller.dto.AddDermatologistDto;
import com.isa.pharmacy.users.controller.dto.DermatologistExaminationDto;
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
    public List<DermatologistDto> getAll() {
        List<Dermatologist> dermatologistList =dermatologistService.getAll();
        List<DermatologistDto> dermatologistDtos = new ArrayList<>();
        for(Dermatologist d: dermatologistList){
            dermatologistDtos.add(DermatologistMapper.mapDermatologistToDermatologistDto(d));
        }
        return dermatologistDtos;
    }

    @PostMapping("/addDermatologist")
    public void addDermatologist(@RequestBody AddDermatologistDto addDermatologistDto){
        dermatologistService.addDermatologistToPharmacy(addDermatologistDto);
    }

    @GetMapping("/findByPharmacy/{adminEmail}")
    public List<DermatologistDto> dermatologistsByAdmin(@PathVariable("adminEmail") String adminEmail){
        List<DermatologistDto> dermatologistDtos = dermatologistService.dermatologistListByPharmacyAdmin(adminEmail);
        if(dermatologistDtos.isEmpty()){
            throw new NotFoundException("Pharmacy doesn't have dermatologist");
        }
        return dermatologistDtos;
    }
    @PostMapping("/examination")
    public void defineExamination(@RequestBody DermatologistExaminationDto dermatologistExaminationDto){
        dermatologistService.defineExamination(dermatologistExaminationDto);
    }

    @GetMapping("/dermatologists/{name}")
    public List<DermatologistDto> dermatologistListByPharmacy(@PathVariable("name") String name){
        List<DermatologistDto> dermatologistDtos = dermatologistService.dermatologistListByPharmacyName(name);
        if(dermatologistDtos.isEmpty()){
            throw new NotFoundException("Pharmacy doesn't have dermatologist");
        }
        return dermatologistDtos;
    }

    @GetMapping("/dermatologists/{name}/{surname}/{pharmacyName}")
    public List<DermatologistDto> dermatologistListByNameAndSurname(@PathVariable("name") String name,@PathVariable("surname") String surname,@PathVariable("pharmacyName") String pharmacyName){
        List<DermatologistDto> dermatologistDtos = dermatologistService.dermatologistListByNameAndSurname(name, surname, pharmacyName);
        if(dermatologistDtos.isEmpty()){
            throw new NotFoundException("Pharmacy doesn't have dermatologist with this name and surname");
        }
        return dermatologistDtos;
    }

    @PutMapping("/{dermatologistEmail}/{adminEmail}")
    public void deleteDermatologist(@PathVariable String dermatologistEmail, @PathVariable String adminEmail){
        dermatologistService.deleteFromPharmacy(dermatologistEmail,adminEmail);
    }


    @PostMapping("/check/vacation/{email}")
    public boolean checkVacationTerm(@RequestBody VacationScheduleDto vacationScheduleDto, @PathVariable("email") String email){
        return dermatologistService.checkVacationTerm(vacationScheduleDto, email);
    }
}
