package com.isa.pharmacy.controller;

import com.isa.pharmacy.domain.Diagnosis;
import com.isa.pharmacy.service.DiagnosisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/diagnosis")
@CrossOrigin(value = "http://localhost:4200")
public class DiagnosisController {
    @Autowired
    private DiagnosisService diagnosisService;

    @PostMapping("/add")
    public Diagnosis save(@RequestBody Diagnosis d) {
        return diagnosisService.save(d);
    }

    @GetMapping
    public List<Diagnosis> getAll() { return diagnosisService.getAll(); }
}
