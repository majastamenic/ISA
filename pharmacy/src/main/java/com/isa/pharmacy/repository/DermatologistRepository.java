package com.isa.pharmacy.repository;

import com.isa.pharmacy.domain.Dermatologist;
import com.isa.pharmacy.domain.Pharmacist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DermatologistRepository extends JpaRepository<Dermatologist, Long> {

    List<Dermatologist> findAll();

    Dermatologist save(Dermatologist dermatologist);
}
