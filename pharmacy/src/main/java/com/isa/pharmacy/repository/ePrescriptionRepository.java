package com.isa.pharmacy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isa.pharmacy.domain.ePrescription;

@Repository
public interface ePrescriptionRepository extends JpaRepository<ePrescription, Long> {
	
	List<ePrescription> getAll();
	ePrescription findePrescriptionById(Long id);

}
