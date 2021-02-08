package com.isa.pharmacy.repository;

import com.isa.pharmacy.domain.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {
    Prescription save(Prescription prescription);
}
