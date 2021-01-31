package com.isa.pharmacy.controller;

import com.isa.pharmacy.domain.Patient;
import com.isa.pharmacy.domain.Pharmacist;
import com.isa.pharmacy.domain.VacationSchedule;
import com.isa.pharmacy.domain.WorkSchedule;
import com.isa.pharmacy.service.PharmacistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pharmacist")
public class PharmacistController {
    @Autowired
    private PharmacistService pharmacistService;

    @GetMapping
    public List<Pharmacist> getAll() { return pharmacistService.getAll(); }

    @PostMapping("/registration")
    public Pharmacist save(@RequestBody Pharmacist p) { return pharmacistService.save(p); }

    @PostMapping("/update")
    public Pharmacist update(@RequestBody Pharmacist p) { return pharmacistService.update(p); }

    @GetMapping("/workschedule/{id}")
    public WorkSchedule getWorkScheduleByPharmacist(@PathVariable("id") Long id){
        return pharmacistService.getWorkScheduleByPharmacist(id);
    }

    @GetMapping("/patients/{id}")
    public List<Patient> getPatientsByPharmacist(@PathVariable("id") Long id){
        return  pharmacistService.getPatientsByPharmacist(id);
    }

    @GetMapping("/vacationschedule/{id}")
    public List<VacationSchedule> getVacationScheduleByPharmacist(@PathVariable("id") Long id){
        return pharmacistService.getVacationScheduleByPharmacist(id);
    }

}
