package com.isa.pharmacy.controller;

import com.isa.pharmacy.controller.dto.ExamDermatologistDto;
import com.isa.pharmacy.controller.dto.FreeExaminationDto;
import com.isa.pharmacy.users.domain.Dermatologist;
import com.isa.pharmacy.service.ExaminationService;
import com.isa.pharmacy.users.service.DermatologistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/examination")
@CrossOrigin(value = "http://localhost:4200")
public class ExaminationController {

    @Autowired
    private ExaminationService examService;
    @Autowired
    private DermatologistService dermatologistService;

    @GetMapping("/freeTerms")       // Za sada se ne koristi nigde
    public List<FreeExaminationDto> getFreeExaminationTerms(){
        return examService.getAllFreeExaminationTerms();
    }

    @GetMapping("/freeTerms/{pharmacyName}")
    public List<FreeExaminationDto> getExaminationTermsByPharmacy(@PathVariable String pharmacyName){
        return examService.getFreeExaminationTermsByPharmacy(pharmacyName);
    }

//    @PutMapping
//    public void scheduleExamination(Patient patient, Examination examination){
//        examService.scheduleExamination(patient,examination);
//    }

    @GetMapping("/{email}")
    public List<ExamDermatologistDto> getAllByDermatologist(@PathVariable("email") String email) {
        Dermatologist dermatologist = dermatologistService.findUserByEmail(email);
        return examService.getAllByDermatologist(dermatologist);
    }
}
