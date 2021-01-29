package com.isa.pharmacy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isa.pharmacy.domain.EPrescription;

@Repository
public interface EPrescriptionRepository extends JpaRepository<EPrescription, Long> {

    EPrescription findEPrescriptionById(Long id);

    List<EPrescription> findAll();
}
