package com.isa.pharmacy.rating.service.interfaces;

import com.isa.pharmacy.rating.domain.MedicineRating;

public interface IMedicineRatingService {
    MedicineRating rateMedicine(MedicineRating rating);

    void updateRating(MedicineRating rating);

    Double getAverageRatingByMedicine(String medName);
}
