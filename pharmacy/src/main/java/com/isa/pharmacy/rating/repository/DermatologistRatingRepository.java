package com.isa.pharmacy.rating.repository;

import com.isa.pharmacy.rating.domain.DermatologistRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DermatologistRatingRepository extends JpaRepository<DermatologistRating, Long> {
}