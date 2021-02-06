package com.isa.pharmacy.service;

import com.isa.pharmacy.controller.dto.ExamDermatologistDto;
import com.isa.pharmacy.controller.dto.FreeExaminationDto;
import com.isa.pharmacy.controller.dto.PatientDto;
import com.isa.pharmacy.controller.mapping.ExaminationMapper;
import com.isa.pharmacy.controller.mapping.PatientMapper;
import com.isa.pharmacy.domain.Examination;
import com.isa.pharmacy.users.domain.Dermatologist;
import com.isa.pharmacy.users.domain.Patient;
import com.isa.pharmacy.repository.ExaminationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class ExaminationService {

    @Autowired
    private ExaminationRepository examRepository;
    @Autowired
    private EmailService emailService;

    public List<FreeExaminationDto> getAllFreeExaminationTerms(){
        List<FreeExaminationDto> freeExaminations = new ArrayList<>();
        for(Examination exam : examRepository.findAll())
            if(exam.getPatient() == null && exam.getSchedule().getStartDate().after(Calendar.getInstance().getTime()))
                freeExaminations.add(ExaminationMapper.mapExaminationToFreeExaminationDto(exam));
        return freeExaminations;
    }

    public List<FreeExaminationDto> getFreeExaminationTermsByPharmacy(String pharmacyName){
        List<FreeExaminationDto> freeExaminations = new ArrayList<>();
        for(Examination exam : examRepository.findAll())
            if(exam.getPharmacy().getName().equals(pharmacyName) &&
               exam.getPatient() == null &&
               exam.getSchedule().getStartDate().after(Calendar.getInstance().getTime()))
                freeExaminations.add(ExaminationMapper.mapExaminationToFreeExaminationDto(exam));
        return freeExaminations;
    }


    public Examination scheduleExamination(Patient patient, Examination examination){
        examination.setPatient(patient);
        Examination scheduledExam = examRepository.save(examination);
        if(scheduledExam != null)
            emailService.successfulExamSchedule(scheduledExam);
        return scheduledExam;
    }

    public List<ExamDermatologistDto> getAllByDermatologist(Dermatologist dermatologist) {
        List<Examination> examinations = examRepository.findByDermatologist(dermatologist);
        List<ExamDermatologistDto> examDermatologistDtos = new ArrayList<>();
        if(examinations.isEmpty() == false){
            for(Examination e : examinations){
                if(e.getPatient() != null && e.getPrescription() != null){
                    PatientDto patientDto = PatientMapper.mapPatientToPatientDto(e.getPatient());
                    ExamDermatologistDto examDermatologistDto = ExaminationMapper.mapExaminationToExaminationDto(e, patientDto);
                    examDermatologistDtos.add(examDermatologistDto);
                }
            }
        }

        return examDermatologistDtos;
    }
}
