package com.isa.pharmacy.users.controller;

import com.isa.pharmacy.controller.dto.DateTimeDto;
import com.isa.pharmacy.controller.dto.PharmacistByPharmacyDto;
import com.isa.pharmacy.controller.dto.VacationScheduleDto;
import com.isa.pharmacy.controller.exception.NotFoundException;
import com.isa.pharmacy.scheduling.domain.VacationSchedule;
import com.isa.pharmacy.users.controller.dto.CreatePharmacistDto;
import com.isa.pharmacy.users.controller.dto.PharmacistDto;
import com.isa.pharmacy.users.controller.mapping.PharmacistMapper;
import com.isa.pharmacy.users.domain.Pharmacist;
import com.isa.pharmacy.users.service.interfaces.IPharmacistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins ={ "http://localhost:4200", "https://pharmacy-25-frontend.herokuapp.com"})
@RequestMapping("/pharmacist")
public class PharmacistController {

    @Autowired
    private IPharmacistService pharmacistService;
    
    

    @GetMapping
    public List<Pharmacist> getAll() { return pharmacistService.getAll(); }

    @PostMapping("/registration/{adminEmail}")
    public CreatePharmacistDto save(@RequestBody CreatePharmacistDto p, @PathVariable("adminEmail") String adminEmail) { return pharmacistService.save(p,adminEmail); }

    @GetMapping("/vacationschedule/{id}")
    public List<VacationSchedule> getVacationScheduleByPharmacist(@PathVariable("id") Long id){
        return pharmacistService.getVacationScheduleByPharmacist(id);
    }

    @GetMapping("/pharmacists/{id}")
    public List<PharmacistByPharmacyDto> getPharmacistByPharmacyId(@PathVariable("id") Long id){
        List<PharmacistByPharmacyDto> pharmacistByPharmacyDtos = pharmacistService.findPharmacistsByPharmacyId(id);
        if (pharmacistByPharmacyDtos.isEmpty()) {
            throw new NotFoundException("Pharmacy doesn't have pharmacist");
        }
        return pharmacistByPharmacyDtos;
    }

    @GetMapping("/pharmacist/{name}")
    public List<PharmacistByPharmacyDto> getPharmacistByPharmacyName(@PathVariable("name") String name){
        List<PharmacistByPharmacyDto> pharmacistByPharmacyDtos = pharmacistService.getPharmacistByPharmacyName(name);
        if (pharmacistByPharmacyDtos.isEmpty()) {
            throw new NotFoundException("Pharmacy doesn't have pharmacist");
        }
        return pharmacistByPharmacyDtos;
    }

    @GetMapping("/pharmacist/{name}/{surname}/{pharmacyName}")
    public List<PharmacistByPharmacyDto> getPharmacistByNameAndSurname(@PathVariable("name") String name,@PathVariable("surname") String surname,@PathVariable("pharmacyName") String pharmacyName){
        List<PharmacistByPharmacyDto> pharmacistByPharmacyDtos = pharmacistService.getPharmacistByNameAndSurname(name,surname,pharmacyName);
        if (pharmacistByPharmacyDtos.isEmpty()) {
            throw new NotFoundException("Pharmacy doesn't have pharmacist");
        }
        return pharmacistByPharmacyDtos;
    }

    @PutMapping("/free")
    public List<PharmacistDto> getFreePharmacist(@RequestParam("pharmacy") String pharmacy, @RequestBody DateTimeDto date){
        return PharmacistMapper.mapListPharmacistToPharmacistDto(
                pharmacistService.getFreePharmacistByPharmacyAndDate(pharmacy, date));
    }

    @PutMapping("/delete/{PharmacistEmail}/{adminEmail}")
    public void deletePharmacist(@PathVariable String PharmacistEmail, @PathVariable String adminEmail){
        pharmacistService.deletePharmacistByUser_email(PharmacistEmail, adminEmail);
    }

    @PostMapping("/check/vacation/{email}")
    public boolean checkVacationTerm(@RequestBody VacationScheduleDto vacationScheduleDto, @PathVariable("email") String email){
        return pharmacistService.checkVacationTerm(vacationScheduleDto, email);
    }

}
