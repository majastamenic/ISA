package com.isa.pharmacy.controller;


import com.isa.pharmacy.controller.dto.FreeExaminationDto;
import com.isa.pharmacy.domain.Examination;
import com.isa.pharmacy.service.ExaminationService;
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

    @GetMapping("/loyalty")
    public int getLoyaltyPoints(){
        return examinationService.getLoyaltyPoints();
    }

    @PutMapping("/loyalty")
    public ResponseEntity<String> updateLoyaltyPoints(@RequestBody Integer loyaltyPoints){
        examinationService.updateLoyaltyPoints(loyaltyPoints);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    @GetMapping("/freeTerms")       // Za sada se ne koristi nigde
    public List<FreeExaminationDto> getFreeExaminationTerms(){
        return examinationService.getAllFreeExaminationTerms();
    }

    @GetMapping("/freeTerms/{pharmacyName}")
    public List<FreeExaminationDto> getExaminationTermsByPharmacy(@PathVariable String pharmacyName){
        return examinationService.getFreeExaminationTermsByPharmacy(pharmacyName);
    }

//    @PutMapping
//    public void scheduleExamination(Patient patient, Examination examination){
//        examService.scheduleExamination(patient,examination);
//    }
}
