package com.isa.pharmacy.controller;

import com.isa.pharmacy.rating.service.interfaces.IDermatologistRatingService;
import com.isa.pharmacy.rating.service.interfaces.IPharmacyRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pharmacyRating")
@CrossOrigin(origins ={ "http://localhost:4200", "https://pharmacy-25-frontend.herokuapp.com"})
public class PharmacyRatingController {
    @Autowired
    private IPharmacyRatingService pharmacyRatingService;

    @GetMapping("/{pharmacyName}")
    public Double getAverageRatingByPharmacy(@PathVariable String pharmacyName){
        return pharmacyRatingService.getAverageRatingByPharmacy(pharmacyName);
    }
}
