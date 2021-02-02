package com.isa.pharmacy.controller;

import com.isa.pharmacy.domain.Examination;
import com.isa.pharmacy.domain.Profile.Patient;
import com.isa.pharmacy.service.ExaminationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/examination")
@CrossOrigin(value = "http://localhost:4200")
public class ExaminationController {

    @Autowired
    private ExaminationService examService;

    @PutMapping
    public void scheduleExamination(Patient patient, Examination examination){
        examService.scheduleExamination(patient,examination);
    }
}
