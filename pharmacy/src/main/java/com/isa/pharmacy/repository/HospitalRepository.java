package com.isa.pharmacy.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isa.pharmacy.domain.Hospital;


@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Long> {

	Hospital findByEmail(String email);
	Hospital findHospitalByApiKey(Long apiKey);
	
}