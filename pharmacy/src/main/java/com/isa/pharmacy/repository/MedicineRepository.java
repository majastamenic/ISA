package com.isa.pharmacy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isa.pharmacy.domain.Medicine;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Long> {

    Medicine save(Medicine medicine);

    Medicine findMedicineById(Long id);

    Medicine findMedicineByCode(Long code);

    List<Medicine> findAll();
}
