package com.isa.pharmacy.controller;

import com.isa.pharmacy.controller.dto.WorkScheduleDto;
import com.isa.pharmacy.scheduling.domain.WorkSchedule;
import com.isa.pharmacy.scheduling.service.WorkScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(value = "http://localhost:4200")
@RequestMapping("/workschedule")
public class WorkScheduleController {
    @Autowired
    private WorkScheduleService workScheduleService;

    @GetMapping
    public List<WorkScheduleDto> getAll() { return workScheduleService.getAll(); }

    @PostMapping("/add")
    public WorkSchedule save(@RequestBody WorkSchedule ws) { return workScheduleService.save(ws); }
}
