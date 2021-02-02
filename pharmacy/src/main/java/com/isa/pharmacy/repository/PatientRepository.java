package com.isa.pharmacy.repository;

import com.isa.pharmacy.domain.Profile.Patient;
import com.isa.pharmacy.domain.Profile.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient findByUser(User user);

    Patient findByUser_email(String email);
}
