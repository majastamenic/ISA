package com.isa.pharmacy.service;

import com.isa.pharmacy.domain.Diagnosis;
import com.isa.pharmacy.repository.DiagnosisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DiagnosisService {
    @Autowired
    private DiagnosisRepository diagnosisRepository;

    public Diagnosis save(Diagnosis d) {
        return diagnosisRepository.save(d);
    }

    public List<Diagnosis> getAll(){ return diagnosisRepository.findAll(); }

    public List<Diagnosis> getAllDiagnosisById(List<Long> id){
        List<Diagnosis> diagnosis = new ArrayList<>();
        for(Long i: id){
            for(Diagnosis d: getAll()){
                if(d.getId().equals(i))
                    diagnosis.add(d);
            }
        }
        return diagnosis;
    }

}
