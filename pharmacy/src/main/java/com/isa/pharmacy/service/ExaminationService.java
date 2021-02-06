package com.isa.pharmacy.service;

import com.isa.pharmacy.controller.dto.FreeExaminationDto;
import com.isa.pharmacy.controller.exception.NotFoundException;
import com.isa.pharmacy.controller.mapping.ExaminationMapper;
import com.isa.pharmacy.domain.Examination;
import com.isa.pharmacy.repository.ExaminationRepository;
import com.isa.pharmacy.domain.users.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class ExaminationService {

    @Autowired
    private ExaminationRepository examinationRepository;

    @Autowired
    private EmailService emailService;

    public List<FreeExaminationDto> getAllFreeExaminationTerms(){
        List<FreeExaminationDto> freeExaminations = new ArrayList<>();
        for(Examination exam : examinationRepository.findAll())
            if(exam.getPatient() == null && exam.getSchedule().getStartDate().after(Calendar.getInstance().getTime()))
                freeExaminations.add(ExaminationMapper.mapExaminationToFreeExaminationDto(exam));
        return freeExaminations;
    }

    public List<FreeExaminationDto> getFreeExaminationTermsByPharmacy(String pharmacyName){
        List<FreeExaminationDto> freeExaminations = new ArrayList<>();
        for(Examination exam : examinationRepository.findAll())
            if(exam.getPharmacy().getName().equals(pharmacyName) &&
               exam.getPatient() == null &&
               exam.getSchedule().getStartDate().after(Calendar.getInstance().getTime()))
                freeExaminations.add(ExaminationMapper.mapExaminationToFreeExaminationDto(exam));
        return freeExaminations;
    }


    public Examination scheduleExamination(Patient patient, Examination examination){
        examination.setPatient(patient);
        Examination scheduledExam = examinationRepository.save(examination);
        if(scheduledExam != null)
            emailService.successfulExamSchedule(scheduledExam);
        return scheduledExam;
    }
}
