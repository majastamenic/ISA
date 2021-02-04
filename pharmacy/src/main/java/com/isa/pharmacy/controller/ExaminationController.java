package com.isa.pharmacy.controller;


import com.isa.pharmacy.domain.Examination;
import com.isa.pharmacy.service.ExaminationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/examination")
public class ExaminationController {
    @Autowired
    private ExaminationService examinationService;

    @PutMapping("/loyalty")
    public ResponseEntity<String> updateLoyaltyPoints(@RequestParam int loyaltyPoints){
        examinationService.updateLoyaltyPoints(loyaltyPoints);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }
}
