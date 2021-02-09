package com.isa.pharmacy.users.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.isa.pharmacy.controller.dto.DateTimeDto;
import com.isa.pharmacy.controller.dto.PharmacistByPharmacyDto;
import com.isa.pharmacy.controller.exception.NotFoundException;
import com.isa.pharmacy.users.controller.dto.CreatePharmacistDto;
import com.isa.pharmacy.users.controller.dto.PharmacistDto;
import com.isa.pharmacy.users.controller.mapping.PharmacistMapper;
import com.isa.pharmacy.users.domain.Pharmacist;
import com.isa.pharmacy.scheduling.domain.VacationSchedule;
import com.isa.pharmacy.scheduling.domain.WorkSchedule;
import com.isa.pharmacy.users.service.PharmacistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(value = "http://localhost:4200")
@RequestMapping("/pharmacist")
public class PharmacistController {
    @Autowired
    private PharmacistService pharmacistService;

    @GetMapping
    public List<Pharmacist> getAll() { return pharmacistService.getAll(); }

    @PostMapping("/registration")
    public CreatePharmacistDto save(@RequestBody CreatePharmacistDto p) { return pharmacistService.save(p); }
    //TODO: Farmaceut
    /*
    @PostMapping("/update")
    public Pharmacist update(@RequestBody Pharmacist p) { return pharmacistService.update(p); }
    */
    @GetMapping("/workschedule/{id}")
    public List<WorkSchedule> getWorkScheduleByPharmacistId(@PathVariable("id") Long id){
        return pharmacistService.getWorkScheduleByPharmacist(id);
    }

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

    @PutMapping("/free")
    public List<PharmacistDto> getFreePharmacist(@RequestBody DateTimeDto date){
        return PharmacistMapper.mapPharmacistListToPharmacistDto(pharmacistService.getFreePharmacistByDate(date));
    }

}
