package com.isa.pharmacy.rating.repository;

import com.isa.pharmacy.rating.domain.DermatologistRating;
import com.isa.pharmacy.rating.domain.PharmacistRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DermatologistRatingRepository extends JpaRepository<DermatologistRating, Long> {
    List<DermatologistRating> findDermatologistRatingsByDermatologist_User_Email(String pharmacistEmail);
}
