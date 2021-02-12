package com.isa.pharmacy.controller;

import com.isa.pharmacy.controller.dto.VacationScheduleDto;
import com.isa.pharmacy.scheduling.domain.VacationSchedule;
import com.isa.pharmacy.scheduling.service.interfaces.IVacationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vacation")
@CrossOrigin(origins ={ "http://localhost:4200", "https://pharmacy-25-frontend.herokuapp.com"})
public class VacationScheduleController {

    @Autowired
    private IVacationService vacationScheduleService;

    @GetMapping
    public List<VacationSchedule> getAll() { return vacationScheduleService.getAll(); }

    @PostMapping("/add")
    public VacationSchedule save(@RequestBody VacationSchedule vacationSchedule) {
        return vacationScheduleService.save(vacationSchedule);
    }

    @GetMapping("/dermatologist/{email}")
    public List<VacationScheduleDto> getVacationScheduleByDermatologist(@PathVariable("email") String email){
        return vacationScheduleService.getVacationScheduleByDermatologist(email);
    }

    @GetMapping("/pharmacist/{email}")
    public List<VacationScheduleDto> getVacationScheduleByPharmacist(@PathVariable("email") String email){
        return vacationScheduleService.getVacationScheduleByPharmacist(email);
    }
}
