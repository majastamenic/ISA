package com.isa.pharmacy.controller;

import com.isa.pharmacy.rating.service.interfaces.IDermatologistRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dermatologistRating")
@CrossOrigin(origins ={ "http://localhost:4200", "https://pharmacy-25-frontend.herokuapp.com"})

public class DermatologistRatingController {

    @Autowired
    private IDermatologistRatingService dermatologistRatingService;

    @GetMapping("/{dermatologistEmail}")
    public Double getAverageRatingByDermatologist(@PathVariable String dermatologistEmail){
        return dermatologistRatingService.getAverageRatingByDermatologist(dermatologistEmail);
    }
}
