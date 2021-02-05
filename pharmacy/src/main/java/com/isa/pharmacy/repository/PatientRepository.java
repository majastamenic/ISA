package com.isa.pharmacy.repository;

import com.isa.pharmacy.domain.users.Patient;
import com.isa.pharmacy.domain.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient findByUser(User user);

    Patient findByUser_email(String email);

    List<Patient> findAll();
}
