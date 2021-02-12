package com.isa.pharmacy.users.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isa.pharmacy.users.domain.Hospital;


@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Long> {

    Hospital findByEmail(String email);

    List<Hospital> findAll();

}
