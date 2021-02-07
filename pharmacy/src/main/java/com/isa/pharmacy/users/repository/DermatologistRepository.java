package com.isa.pharmacy.users.repository;

import com.isa.pharmacy.users.domain.Dermatologist;
import com.isa.pharmacy.users.domain.Pharmacist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DermatologistRepository extends JpaRepository<Dermatologist, Long> {

    List<Dermatologist> findAll();

    Dermatologist save(Dermatologist dermatologist);

    Dermatologist findDermatologistById(Long id);

    Dermatologist findDermatologistByUser_email(String email);
}
