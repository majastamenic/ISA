package com.isa.pharmacy.controller;

import com.isa.pharmacy.controller.dto.ExamDermatologistDto;
import com.isa.pharmacy.controller.dto.ExaminationUpcomingDto;
import com.isa.pharmacy.controller.mapping.ExaminationMapper;

import com.isa.pharmacy.domain.Examination;
import com.isa.pharmacy.users.domain.Dermatologist;
import com.isa.pharmacy.service.ExaminationService;
import com.isa.pharmacy.users.service.DermatologistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    @GetMapping("/freeTerms")       // TODO: Obrisati ako niko ne koristi
    public List<ExaminationUpcomingDto> getFreeExaminationTerms(){
        return ExaminationMapper.mapExaminationListToExaminationUpcomingDto(examinationService.getAllFreeExaminationTerms());
    }

    @GetMapping("/freeTerms/{pharmacyName}")
    public List<ExaminationUpcomingDto> getExaminationTermsByPharmacy(@PathVariable String pharmacyName){
        return ExaminationMapper.mapExaminationListToExaminationUpcomingDto(
                examinationService.getFreeExaminationTermsByPharmacy(pharmacyName));
    }

    @GetMapping("/{email}")
    public List<ExamDermatologistDto> getAllByDermatologist(@PathVariable("email") String email) {
        Dermatologist dermatologist = dermatologistService.findUserByEmail(email);
        return examinationService.getAllByDermatologist(dermatologist);
    }

    @GetMapping("/scheduled/{email}")
    public List<ExaminationUpcomingDto> getExaminationByPatient(@PathVariable String email){
        return ExaminationMapper.mapExaminationListToExaminationUpcomingDto(
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

    @PostMapping("/update")
    public ExamDermatologistDto updateExamination(@RequestBody ExamDermatologistDto examination){return examinationService.updateExamination(examination);}

    @GetMapping("/free/{email}")
    public List<ExaminationUpcomingDto> getFreeExaminationsByDermatologist(@PathVariable("email") String email){
        List<ExaminationUpcomingDto> examinationUpcomingDtos = new ArrayList<>();
        List<Examination> examinations = examinationService.getFreeExaminationsByDermatologist(email);
        examinationUpcomingDtos = ExaminationMapper.mapExaminationListToExaminationUpcomingDto(examinations);
        return examinationUpcomingDtos;
    }

}
