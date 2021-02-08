package com.isa.pharmacy.controller;

import com.isa.pharmacy.controller.dto.ExamDermatologistDto;
import com.isa.pharmacy.controller.dto.FreeExaminationDto;
import com.isa.pharmacy.controller.mapping.ExaminationMapper;
import com.isa.pharmacy.domain.Examination;
import com.isa.pharmacy.service.ExaminationService;
import com.isa.pharmacy.users.domain.Dermatologist;
import com.isa.pharmacy.users.service.DermatologistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/examination")
@CrossOrigin(value = "http://localhost:4200")
public class ExaminationController {

    @Autowired
    private ExaminationService examinationService;
    @Autowired
    private DermatologistService dermatologistService;


    @GetMapping("/start/{id}")
    public ExamDermatologistDto getById(@PathVariable("id") long id) {
        return examinationService.getById(id);
    }

    @GetMapping("/freeTerms")       // Za sada se ne koristi nigde
    public List<FreeExaminationDto> getFreeExaminationTerms(){
        return ExaminationMapper.mapExaminationListToFreeExaminationDto(examinationService.getAllFreeExaminationTerms());
    }

    @GetMapping("/freeTerms/{pharmacyName}")
    public List<FreeExaminationDto> getExaminationTermsByPharmacy(@PathVariable String pharmacyName){
        return ExaminationMapper.mapExaminationListToFreeExaminationDto(
                examinationService.getFreeExaminationTermsByPharmacy(pharmacyName));
    }

    @GetMapping("/{email}")
    public List<ExamDermatologistDto> getAllByDermatologist(@PathVariable("email") String email) {
        Dermatologist dermatologist = dermatologistService.findUserByEmail(email);
        return examinationService.getAllByDermatologist(dermatologist);
    }

    @GetMapping("/scheduled/{email}")
    public List<FreeExaminationDto> getExaminationByPatient(@PathVariable String email){
        return ExaminationMapper.mapExaminationListToFreeExaminationDto(
                examinationService.getExaminationByPatient(email));
    }

    @PutMapping("/schedule/{patientEmail}/{examinationId}")
    public void scheduleExamination(@PathVariable String patientEmail, @PathVariable Long examinationId){
        examinationService.scheduleExamination(patientEmail, examinationId);
    }

    @PutMapping("/cancel/{examinationId}")
    public void cancelExamination(@PathVariable Long examinationId){
        examinationService.cancelExamination(examinationId);
    }
}
