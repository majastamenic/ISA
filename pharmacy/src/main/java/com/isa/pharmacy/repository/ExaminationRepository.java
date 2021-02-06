package com.isa.pharmacy.repository;

import com.isa.pharmacy.domain.Examination;
import com.isa.pharmacy.users.domain.Dermatologist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExaminationRepository extends JpaRepository<Examination, Long> {

    List<Examination> findAll();

    List<Examination> findByDermatologist(Dermatologist dermatologist);

    Examination save(Examination examination);

    Examination findExaminationById(Long id);
}
