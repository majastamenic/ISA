package com.isa.pharmacy.repository;

import com.isa.pharmacy.domain.Diagnosis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiagnosisRepository extends JpaRepository<Diagnosis, Long> {

    List<Diagnosis> findAll();
    
    Diagnosis save(Diagnosis u);

}
