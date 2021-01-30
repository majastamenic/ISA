package com.isa.pharmacy.controller;

import com.isa.pharmacy.domain.Pharmacist;
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
}
