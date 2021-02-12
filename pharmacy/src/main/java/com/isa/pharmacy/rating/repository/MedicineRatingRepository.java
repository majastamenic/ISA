package com.isa.pharmacy.rating.repository;

import com.isa.pharmacy.rating.domain.MedicineRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicineRatingRepository extends JpaRepository<MedicineRating, Long> {
}
