package com.isa.pharmacy.rating.repository;

import com.isa.pharmacy.rating.domain.PharmacistRating;
import com.isa.pharmacy.users.domain.Patient;
import com.isa.pharmacy.users.domain.Pharmacist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PharmacistRatingRepository extends JpaRepository<PharmacistRating, Long> {

    PharmacistRating findPharmacistRatingByPatientAndPharmacist(Patient patient, Pharmacist pharmacist);

    List<PharmacistRating> findPharmacistRatingsByPharmacist_User_Email(String pharmacistEmail);
}
