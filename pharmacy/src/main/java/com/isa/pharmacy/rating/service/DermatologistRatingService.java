package com.isa.pharmacy.rating.service;

import com.isa.pharmacy.controller.exception.NotFoundException;
import com.isa.pharmacy.rating.domain.DermatologistRating;
import com.isa.pharmacy.rating.domain.PharmacistRating;
import com.isa.pharmacy.rating.repository.DermatologistRatingRepository;
import com.isa.pharmacy.rating.service.interfaces.IDermatologistRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DermatologistRatingService implements IDermatologistRatingService {

    @Autowired
    private DermatologistRatingRepository dermatologistRatingRepository;

    public Double getAverageRatingByDermatologist(String pharmacistEmail){
        Double ratingSum = 0.0;
        Double i = 0.0;
        for(DermatologistRating rating : dermatologistRatingRepository.findDermatologistRatingsByDermatologist_User_Email(pharmacistEmail)){
            ratingSum += rating.getRate();
            i++;
        }
        if(i == 0)
            throw new NotFoundException("Dermatologist has no ratings yet");
        return ratingSum/i;
    }
}
