package com.isa.pharmacy.controller;

import com.isa.pharmacy.controller.dto.RatingDto;
import com.isa.pharmacy.controller.mapping.RatingMapper;
import com.isa.pharmacy.rating.domain.MedicineRating;
import com.isa.pharmacy.rating.service.interfaces.IMedicineRatingService;
import com.isa.pharmacy.service.interfaces.IMedicineService;
import com.isa.pharmacy.users.service.interfaces.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicineRating")
@CrossOrigin(origins ={ "http://localhost:4200", "https://pharmacy-25-frontend.herokuapp.com"})
public class MedicineRatingController {

    @Autowired
    private IMedicineRatingService medicineRatingService;
    @Autowired
    private IPatientService patientService;
    @Autowired
    private IMedicineService medicineService;

    @GetMapping("/{email}")
    public Double getAverageRatingByMedicine(@PathVariable String email){
        return medicineRatingService.getAverageRatingByMedicine(email);
    }

    @PostMapping
    public RatingDto rateMedicine(@RequestBody RatingDto ratingDto){
        MedicineRating rating = RatingMapper.mapRatingDtoToMedicineRating(ratingDto);
        rating.setPatient(patientService.getPatient(ratingDto.getPatientEmail()));
        rating.setMedicine(medicineService.findByName(ratingDto.getRatedEntityId()));
        return RatingMapper.mapRatingToRatingDto(medicineRatingService.rateMedicine(rating));
    }

    @PutMapping
    public void updateRating(@RequestBody RatingDto ratingDto){
        MedicineRating rating = RatingMapper.mapRatingDtoToMedicineRating(ratingDto);
        rating.setPatient(patientService.getPatient(ratingDto.getPatientEmail()));
        rating.setMedicine(medicineService.findByName(ratingDto.getRatedEntityId()));
        medicineRatingService.updateRating(rating);
    }
}
