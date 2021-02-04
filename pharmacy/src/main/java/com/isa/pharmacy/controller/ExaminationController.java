package com.isa.pharmacy.controller;

import com.isa.pharmacy.domain.Examination;
import com.isa.pharmacy.domain.Profile.Patient;
import com.isa.pharmacy.service.ExaminationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/examination")
@CrossOrigin(value = "http://localhost:4200")
public class ExaminationController {

    @Autowired
    private ExaminationService examService;

    @GetMapping("/freeTerms")
    public List<Examination> getFreeExaminationTerms(){
        return examService.getAllFreeExaminationTerms();
    }

    @GetMapping("/freeTerms/{pharmacyName}")
    public List<Examination> getExaminationTermsByPharmacy(@PathVariable String pharmacyName){
        return examService.getFreeExaminationTermsByPharmacy(pharmacyName);
    }

    @PutMapping
    public void scheduleExamination(Patient patient, Examination examination){
        examService.scheduleExamination(patient,examination);
    }
}
