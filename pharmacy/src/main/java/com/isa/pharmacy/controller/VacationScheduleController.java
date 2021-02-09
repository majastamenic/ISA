package com.isa.pharmacy.controller;

import com.isa.pharmacy.scheduling.domain.VacationSchedule;
import com.isa.pharmacy.scheduling.service.VacationScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vacationschedule")
public class VacationScheduleController {
    @Autowired
    private VacationScheduleService vacationScheduleService;

    @GetMapping
    public List<VacationSchedule> getAll() { return vacationScheduleService.getAll(); }

    @PostMapping("/add")
    public VacationSchedule save(@RequestBody VacationSchedule vacationSchedule) {
        return vacationScheduleService.save(vacationSchedule);
    }
}
