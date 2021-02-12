package com.isa.pharmacy.controller.mapping;

import com.isa.pharmacy.controller.dto.RatingDto;
import com.isa.pharmacy.rating.domain.PharmacistRating;
import com.isa.pharmacy.rating.domain.PharmacyRating;

public class RatingMapper {

    public static RatingDto mapRatingToRatingDto(PharmacistRating rating){
        return new RatingDto(
                rating.getId(),
                rating.getRate(),
                rating.getPatient().getUser().getEmail(),
                rating.getPharmacist().getUser().getEmail()
        );
    }

    public static PharmacistRating mapRatingDtoToRating(RatingDto ratingDto){
        PharmacistRating rating = new PharmacistRating();
        rating.setId(ratingDto.getId());
        rating.setRate(ratingDto.getRating());
        return rating;
    }

    public static RatingDto mapRatingToRatingDto(PharmacyRating rating){
        return new RatingDto(
                rating.getId(),
                rating.getRate(),
                rating.getPatient().getUser().getEmail(),
                rating.getPharmacy().getName()
        );
    }
}
