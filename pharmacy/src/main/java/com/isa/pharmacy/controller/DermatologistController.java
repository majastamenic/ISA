package com.isa.pharmacy.controller;

import com.isa.pharmacy.domain.Dermatologist;
import com.isa.pharmacy.domain.Diagnosis;
import com.isa.pharmacy.domain.Pharmacist;
import com.isa.pharmacy.service.DermatologistService;
import com.isa.pharmacy.service.DiagnosisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dermatologist")
public class DermatologistController {

    @Autowired
    private DermatologistService dermatologistService;

    @PostMapping("/registration")
    public Dermatologist save(@RequestBody Dermatologist d) {
        return dermatologistService.save(d);
    }

    @GetMapping
    public List<Dermatologist> getAll() { return dermatologistService.getAll(); }

    @PostMapping("/update")
    public Dermatologist update(@RequestBody Dermatologist d) { return dermatologistService.update(d); }
}
