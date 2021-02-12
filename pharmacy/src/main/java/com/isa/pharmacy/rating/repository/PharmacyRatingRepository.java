package com.isa.pharmacy.rating.repository;

import com.isa.pharmacy.rating.domain.PharmacyRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PharmacyRatingRepository extends JpaRepository<PharmacyRating, Long> {
}
