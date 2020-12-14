package com.isa.pharmacy.service;

import com.isa.pharmacy.repository.MedicineEPrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isa.pharmacy.domain.MedicineEPrescription;

@Service
public class MedicineEPrescriptionService {

    @Autowired
    private MedicineEPrescriptionRepository medicineEPrescriptionRepository;

    public MedicineEPrescription create(MedicineEPrescription medicineEPrescription) {
        return medicineEPrescriptionRepository.save(medicineEPrescription);
    }

}
