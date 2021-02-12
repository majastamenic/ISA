package com.isa.pharmacy.controller;

import com.isa.pharmacy.controller.dto.RatingDto;
import com.isa.pharmacy.controller.mapping.RatingMapper;
import com.isa.pharmacy.rating.domain.PharmacistRating;
import com.isa.pharmacy.rating.service.interfaces.IPharmacistRatingService;
import com.isa.pharmacy.users.service.interfaces.IPatientService;
import com.isa.pharmacy.users.service.interfaces.IPharmacistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pharmacistRating")
@CrossOrigin(origins ={ "http://localhost:4200", "https://pharmacy-25-frontend.herokuapp.com"})
public class PharmacistRatingController {

    @Autowired
    private IPharmacistRatingService pharmacistRatingService;
    @Autowired
    private IPatientService patientService;
    @Autowired
    private IPharmacistService pharmacistService;

    @GetMapping("/{pharmacistEmail}")
    public Double getAverageRatingByPharmacist(@PathVariable String pharmacistEmail){
        return pharmacistRatingService.getAverageRatingByPharmacist(pharmacistEmail);
    }

    @PostMapping
    public RatingDto ratePharmacist(@RequestBody RatingDto ratingDto){
        PharmacistRating rating = RatingMapper.mapRatingDtoToRating(ratingDto);
        rating.setPatient(patientService.getPatient(ratingDto.getPatientEmail()));
        rating.setPharmacist(pharmacistService.findUserByEmail(ratingDto.getRatedEntityId()));
        return RatingMapper.mapRatingToRatingDto(pharmacistRatingService.ratePharmacist(rating));
    }

    @PutMapping
    public void updateRate(@RequestBody RatingDto ratingDto){
        PharmacistRating rating = RatingMapper.mapRatingDtoToRating(ratingDto);
        rating.setPatient(patientService.getPatient(ratingDto.getPatientEmail()));
        rating.setPharmacist(pharmacistService.findUserByEmail(ratingDto.getRatedEntityId()));
        pharmacistRatingService.updateRating(rating);
    }
}
