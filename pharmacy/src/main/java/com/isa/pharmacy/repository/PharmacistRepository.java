package com.isa.pharmacy.repository;

import java.util.List;
import com.isa.pharmacy.domain.Pharmacist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PharmacistRepository extends JpaRepository<Pharmacist, Long> {

    List<Pharmacist> findAll();

    Pharmacist save(Pharmacist p);
}