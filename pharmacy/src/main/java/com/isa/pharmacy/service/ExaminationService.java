package com.isa.pharmacy.service;

import com.isa.pharmacy.controller.dto.ExamDermatologistDto;
import com.isa.pharmacy.controller.dto.FreeExaminationDto;
import com.isa.pharmacy.controller.exception.InvalidActionException;
import com.isa.pharmacy.controller.mapping.ExaminationMapper;
import com.isa.pharmacy.domain.Counseling;
import com.isa.pharmacy.domain.Examination;
import com.isa.pharmacy.domain.Prescription;
import com.isa.pharmacy.users.controller.dto.PatientDto;
import com.isa.pharmacy.users.controller.mapping.PatientMapper;
import com.isa.pharmacy.users.domain.Dermatologist;
import com.isa.pharmacy.repository.ExaminationRepository;
import com.isa.pharmacy.users.domain.Patient;
import com.isa.pharmacy.users.repository.PatientRepository;
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
    private PatientRepository patientRepository;
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

    public void scheduleExamination(String patientEmail, Long examinationId){
        Examination examination = examinationRepository.findExaminationById(examinationId);
        if(examination.getPatient() != null || examination.getSchedule().getStartDate().before(Calendar.getInstance().getTime()))
            throw new InvalidActionException("Examination cannot be scheduled!");
        examination.setPatient(patientRepository.findByUser_email(patientEmail));
        Examination scheduledExam = examinationRepository.save(examination);
        emailService.successfulExamSchedule(scheduledExam);
    }

    public List<ExamDermatologistDto> getAllByDermatologist(Dermatologist dermatologist) {
        List<Examination> examinations = examinationRepository.findByDermatologist(dermatologist);
        List<ExamDermatologistDto> examDermatologistDtos = new ArrayList<>();
        if(examinations.isEmpty() == false){
            for(Examination e : examinations){
                if(e.getPrescription() == null){
                    e.setPrescription(new Prescription());
                }
                if(e.getPatient() != null){
                    PatientDto patientDto = PatientMapper.mapPatientToPatientDto(e.getPatient());
                    ExamDermatologistDto examDermatologistDto = ExaminationMapper.mapExaminationToExaminationDto(e, patientDto);
                    examDermatologistDtos.add(examDermatologistDto);
                }
            }
        }

        return examDermatologistDtos;
    }

    public List<String> getDermatologistNameByPatient(Patient patient){
        String dermatologistName;
        List<String> dermatologistNames = new ArrayList<>();
        List<Examination> examinationList = examinationRepository.findByPatient(patient);
        for(Examination examination: examinationList){
            if(examination.getPatientCame()){
                dermatologistName = examination.getDermatologist().getUser().getRole().toString() + ": " + examination.getDermatologist().getUser().getName()+" "+ examination.getDermatologist().getUser().getSurname();
                dermatologistNames.add(dermatologistName);
            }
        }
        return dermatologistNames;
    }
}
