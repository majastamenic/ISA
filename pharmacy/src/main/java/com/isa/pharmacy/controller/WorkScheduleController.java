package com.isa.pharmacy.controller;

import com.isa.pharmacy.domain.Pharmacist;
import com.isa.pharmacy.domain.WorkSchedule;
import com.isa.pharmacy.service.PharmacistService;
import com.isa.pharmacy.service.WorkScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workschedule")
public class WorkScheduleController {
    @Autowired
    private WorkScheduleService workScheduleService;

    @GetMapping
    public List<WorkSchedule> getAll() { return workScheduleService.getAll(); }

    @PostMapping("/add")
    public WorkSchedule save(@RequestBody WorkSchedule ws) { return workScheduleService.save(ws); }
}
