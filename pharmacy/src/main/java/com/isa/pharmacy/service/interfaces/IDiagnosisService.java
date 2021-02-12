package com.isa.pharmacy.service.interfaces;

import com.isa.pharmacy.domain.Diagnosis;

import java.util.List;

public interface IDiagnosisService {

     Diagnosis save(Diagnosis d);

     List<Diagnosis> getAll();

     List<Diagnosis> getAllDiagnosisById(List<Long> id);
}
