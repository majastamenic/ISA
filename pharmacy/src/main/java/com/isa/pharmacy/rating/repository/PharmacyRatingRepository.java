package com.isa.pharmacy.rating.repository;

import com.isa.pharmacy.rating.domain.DermatologistRating;
import com.isa.pharmacy.rating.domain.PharmacyRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PharmacyRatingRepository extends JpaRepository<PharmacyRating, Long> {

    List<PharmacyRating> findPharmacyRatingsByPharmacy_Name(String name);
}
