package com.isa.pharmacy.controller;

import com.isa.pharmacy.domain.Diagnosis;
import com.isa.pharmacy.service.DiagnosisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/diagnosis")
@CrossOrigin(origins ={ "http://localhost:4200", "https://pharmacy-25-frontend.herokuapp.com"})
public class DiagnosisController {
    @Autowired
    private DiagnosisService diagnosisService;

    @PostMapping("/add")
    public Diagnosis save(@RequestBody Diagnosis diag) {
        if(!diag.getName().equals("") && diag != null){
            for(Diagnosis d: diagnosisService.getAll()){
                if(d.getName().equals(diag.getName()))
                    return null;
            }
            return diagnosisService.save(diag);
        }
        return null;
    }

    @GetMapping
    public List<Diagnosis> getAll() { return diagnosisService.getAll(); }
}
