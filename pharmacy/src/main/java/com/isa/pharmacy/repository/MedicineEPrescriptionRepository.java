package com.isa.pharmacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.isa.pharmacy.domain.MedicineEPrescription;

public interface MedicineEPrescriptionRepository extends JpaRepository<MedicineEPrescription, Long> {

}
