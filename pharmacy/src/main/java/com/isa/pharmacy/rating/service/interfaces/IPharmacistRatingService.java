package com.isa.pharmacy.rating.service.interfaces;

import com.isa.pharmacy.rating.domain.PharmacistRating;

public interface IPharmacistRatingService {

    PharmacistRating ratePharmacist(PharmacistRating rating);

    void updateRating(PharmacistRating rating);

    Double getAverageRatingByPharmacist(String pharmacistEmail);
}
