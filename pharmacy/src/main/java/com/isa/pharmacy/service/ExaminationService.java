package com.isa.pharmacy.service;

import com.isa.pharmacy.domain.Examination;
import com.isa.pharmacy.domain.Profile.Patient;
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

    public List<Examination> getAllFreeExaminationTerms(){
        List<Examination> freeExaminations = new ArrayList<>();
        for(Examination exam : examRepository.findAll())
            if(exam.getPatient() == null && exam.getSchedule().getStartDate().after(Calendar.getInstance().getTime()))
                freeExaminations.add(exam);
        return freeExaminations;
    }

    public Examination scheduleExamination(Patient patient, Examination examination){
        examination.setPatient(patient);
        return examRepository.save(examination);
    }
}
