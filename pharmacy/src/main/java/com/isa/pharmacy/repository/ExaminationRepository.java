package com.isa.pharmacy.repository;

import com.isa.pharmacy.domain.Examination;
import com.isa.pharmacy.users.domain.Patient;
import com.isa.pharmacy.users.domain.Dermatologist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExaminationRepository extends JpaRepository<Examination, Long> {

    List<Examination> findAll();

    Examination findExaminationById(Long id);

    List<Examination> findByDermatologist(Dermatologist dermatologist);

    List<Examination> findByPatient(Patient patient);

    Examination save(Examination examination);

    List<Examination> findExaminationByPatient_User_Email(String email);
    List<Examination> findExaminationByPharmacy_Id(Long id);
}
