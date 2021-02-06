package com.isa.pharmacy.repository;

import com.isa.pharmacy.domain.Examination;
import com.isa.pharmacy.users.domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExaminationRepository extends JpaRepository<Examination, Long> {

    Examination findExaminationById(Long id);
    List<Examination> findAll();
    List<Examination> findByPatient(Patient patient);
}
