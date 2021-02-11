package com.isa.pharmacy.repository;

import com.isa.pharmacy.domain.MedicineReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicineReservationRepository extends JpaRepository<MedicineReservation, Long> {
}
