package com.isa.pharmacy.rating.service;

import com.isa.pharmacy.controller.exception.NotFoundException;
import com.isa.pharmacy.rating.domain.DermatologistRating;
import com.isa.pharmacy.rating.domain.PharmacyRating;
import com.isa.pharmacy.rating.repository.PharmacyRatingRepository;
import com.isa.pharmacy.rating.service.interfaces.IPharmacyRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PharmacyRatingService implements IPharmacyRatingService {

    @Autowired
    private PharmacyRatingRepository pharmacyRatingRepository;

    @Override
    public Double getAverageRatingByPharmacy(String name) {
        Double ratingSum = 0.0;
        Double i = 0.0;
        for(PharmacyRating rating : pharmacyRatingRepository.findPharmacyRatingsByPharmacy_Name(name)){
            ratingSum += rating.getRate();
            i++;
        }
        if(i == 0)
            throw new NotFoundException("Pharmacy has no ratings yet");
        return ratingSum/i;
    }
}
