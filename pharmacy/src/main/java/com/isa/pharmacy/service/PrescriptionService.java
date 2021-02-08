package com.isa.pharmacy.service;

import com.isa.pharmacy.domain.Prescription;
import com.isa.pharmacy.repository.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrescriptionService {
    @Autowired
    private PrescriptionRepository prescriptionRepository;

    public Prescription save(Prescription prescription){return prescriptionRepository.save(prescription);}
}
