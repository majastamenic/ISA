package com.isa.pharmacy.service;

import com.isa.pharmacy.domain.Diagnosis;
import com.isa.pharmacy.repository.DiagnosisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiagnosisService {
    @Autowired
    private DiagnosisRepository diagnosisRepository;

    public Diagnosis save(Diagnosis d) {
        return diagnosisRepository.save(d);
    }

    public List<Diagnosis> getAll(){ return diagnosisRepository.findAll(); }
}
