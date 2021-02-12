package com.isa.pharmacy.repository;

import com.isa.pharmacy.domain.MedicineReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicineReservationRepository extends JpaRepository<MedicineReservation, Long> {

    MedicineReservation findMedicineReservationById(long id);

    List<MedicineReservation> findMedicineReservationByPatient_User_Email(String email);
}
