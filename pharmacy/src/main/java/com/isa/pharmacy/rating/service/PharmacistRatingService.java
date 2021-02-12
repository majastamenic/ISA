package com.isa.pharmacy.rating.service;

import com.isa.pharmacy.controller.exception.InvalidActionException;
import com.isa.pharmacy.controller.exception.NotFoundException;
import com.isa.pharmacy.domain.Counseling;
import com.isa.pharmacy.rating.domain.PharmacistRating;
import com.isa.pharmacy.rating.repository.PharmacistRatingRepository;
import com.isa.pharmacy.rating.service.interfaces.IPharmacistRatingService;
import com.isa.pharmacy.service.interfaces.ICounselingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PharmacistRatingService implements IPharmacistRatingService {

    @Autowired
    private PharmacistRatingRepository pharmacistRatingRepository;
    @Autowired
    private ICounselingService counselingService;

    public PharmacistRating ratePharmacist(PharmacistRating rating){
        if(rating.getRate() < 1 || rating.getRate() > 5)
            throw new InvalidActionException("Invalid rate");
        for(Counseling c : counselingService.getAllPatientsCounselings(rating.getPatient().getUser().getEmail()))
            if(c.getPatient().getUser().getEmail().equals(rating.getPatient().getUser().getEmail()) &&
                c.getPatientCame() == true)
                return pharmacistRatingRepository.save(rating);
        throw new InvalidActionException("Can't rate pharmacist that has not counsel you");
    }

    public void updateRating(PharmacistRating rating){
        if(rating.getRate() < 1 || rating.getRate() > 5)
            throw new InvalidActionException("Invalid rate");
        if(pharmacistRatingRepository.findPharmacistRatingByPatientAndPharmacist(
                rating.getPatient(), rating.getPharmacist()) == null)
            throw new InvalidActionException("Can't rate pharmacist that has not counsel you");
        pharmacistRatingRepository.save(rating);
    }

    public Double getAverageRatingByPharmacist(String pharmacistEmail){
        Double ratingSum = 0.0;
        Double i = 0.0;
        for(PharmacistRating rating : pharmacistRatingRepository.findPharmacistRatingsByPharmacist_User_Email(pharmacistEmail)){
            ratingSum += rating.getRate();
            i++;
        }
        if(i == 0)
            throw new NotFoundException("Pharmacist has no ratings yet");
        return ratingSum/i;
    }
}
