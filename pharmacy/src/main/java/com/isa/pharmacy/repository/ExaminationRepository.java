package com.isa.pharmacy.repository;

import com.isa.pharmacy.domain.Examination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExaminationRepository extends JpaRepository<Examination, Long> {

    Examination findExaminationById(Long id);
}
