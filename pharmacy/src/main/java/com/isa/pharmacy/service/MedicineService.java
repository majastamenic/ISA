package com.isa.pharmacy.service;

import java.util.ArrayList;
import java.util.List;

import com.isa.pharmacy.controller.dto.MedicineDto;
import com.isa.pharmacy.domain.MedicinePharmacy;
import com.isa.pharmacy.domain.Pharmacy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.isa.pharmacy.domain.Medicine;
import com.isa.pharmacy.repository.MedicineRepository;

@Repository
public class MedicineService {
    @Autowired
    private MedicineRepository medicineRepository;
    @Autowired
    private PharmacyService pharmacyService;

    public Medicine create(Medicine medicine) {
        return medicineRepository.save(medicine);
    }

    public void delete(Medicine medicine) {
        medicineRepository.delete(medicine);

    }

    public Medicine findById(Long id) {
        return medicineRepository.findMedicineById(id);
    }

    public List<Medicine> getAll() {
        return medicineRepository.findAll();
    }
}
