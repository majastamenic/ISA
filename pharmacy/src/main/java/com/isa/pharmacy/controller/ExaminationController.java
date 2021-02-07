package com.isa.pharmacy.controller;

import com.isa.pharmacy.controller.dto.ExamDermatologistDto;

import com.isa.pharmacy.controller.dto.FreeExaminationDto;
import com.isa.pharmacy.domain.Examination;
import com.isa.pharmacy.users.domain.Dermatologist;
import com.isa.pharmacy.service.ExaminationService;
import com.isa.pharmacy.users.service.DermatologistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@RestController
@RequestMapping("/examination")
@CrossOrigin(value = "http://localhost:4200")
public class ExaminationController {
    @Autowired
    private ExaminationService examinationService;
    @Autowired
    private DermatologistService dermatologistService;

    @GetMapping("/freeTerms")       // Za sada se ne koristi nigde
    public List<FreeExaminationDto> getFreeExaminationTerms(){
        return examinationService.getAllFreeExaminationTerms();
    }

    @GetMapping("/freeTerms/{pharmacyName}")
    public List<FreeExaminationDto> getExaminationTermsByPharmacy(@PathVariable String pharmacyName){
        return examinationService.getFreeExaminationTermsByPharmacy(pharmacyName);
    }


    @GetMapping("/{email}")
    public List<ExamDermatologistDto> getAllByDermatologist(@PathVariable("email") String email) {
        Dermatologist dermatologist = dermatologistService.findUserByEmail(email);
        return examinationService.getAllByDermatologist(dermatologist);
    }


    @PutMapping("/schedule/{patientEmail}/{examinationId}")
    public void scheduleExamination(@PathVariable String patientEmail, @PathVariable Long examinationId){
        examinationService.scheduleExamination(patientEmail, examinationId);
    }
}
