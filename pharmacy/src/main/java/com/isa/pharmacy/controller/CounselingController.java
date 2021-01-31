package com.isa.pharmacy.controller;

import com.isa.pharmacy.domain.Counseling;
import com.isa.pharmacy.domain.Pharmacist;
import com.isa.pharmacy.service.CounselingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/counseling")
public class CounselingController {

    @Autowired
    private CounselingService counselingService;

    @PostMapping("/add")
    public Counseling save(@RequestBody Counseling c) { return counselingService.save(c); }

    @GetMapping
    public List<Counseling> getAll() { return counselingService.getAll(); }

    @PostMapping("/update")
    public Counseling update(@RequestBody Counseling c) { return counselingService.save(c); }
}
