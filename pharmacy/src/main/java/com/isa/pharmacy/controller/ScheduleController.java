package com.isa.pharmacy.controller;

import com.isa.pharmacy.domain.Schedule;
import com.isa.pharmacy.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @PostMapping("/add")
    public Schedule save(@RequestBody Schedule schedule) { return scheduleService.save(schedule); }

    @GetMapping
    public List<Schedule> getAll() { return scheduleService.getAll(); }
}
