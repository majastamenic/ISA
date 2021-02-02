package com.isa.pharmacy.service;

import com.isa.pharmacy.domain.Examination;
import com.isa.pharmacy.domain.Profile.Patient;
import com.isa.pharmacy.repository.ExaminationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExaminationService {

    @Autowired
    private ExaminationRepository examRepository;

    @Autowired
    private EmailService emailService;

    public Examination scheduleExamination(Patient patient, Examination examination){
        examination.setPatient(patient);
        return examRepository.save(examination);
    }
}
