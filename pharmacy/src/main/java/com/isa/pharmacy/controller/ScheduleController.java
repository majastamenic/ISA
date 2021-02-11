package com.isa.pharmacy.controller;

import com.isa.pharmacy.scheduling.domain.Schedule;
import com.isa.pharmacy.scheduling.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins ={ "http://localhost:4200", "https://pharmacy-25-frontend.herokuapp.com"})
@RequestMapping("/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @PostMapping("/add")
    public Schedule save(@RequestBody Schedule schedule) { return scheduleService.save(schedule); }

    @GetMapping
    public List<Schedule> getAll() { return scheduleService.getAll(); }
}
