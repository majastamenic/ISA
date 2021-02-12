package com.isa.pharmacy.rating.repository;

import com.isa.pharmacy.domain.Medicine;
import com.isa.pharmacy.rating.domain.MedicineRating;
import com.isa.pharmacy.users.domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicineRatingRepository extends JpaRepository<MedicineRating, Long> {

    MedicineRating findMedicineRatingByPatientAndMedicine(Patient patient, Medicine medicine);

    List<MedicineRating> findMedicineRatingsByMedicine_Name(String name);
}
