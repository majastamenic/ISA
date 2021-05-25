package com.isa.pharmacy.rating.service;

import com.isa.pharmacy.controller.exception.InvalidActionException;
import com.isa.pharmacy.controller.exception.NotFoundException;
import com.isa.pharmacy.domain.MedicineReservation;
import com.isa.pharmacy.rating.domain.MedicineRating;
import com.isa.pharmacy.rating.repository.MedicineRatingRepository;
import com.isa.pharmacy.rating.service.interfaces.IMedicineRatingService;
import com.isa.pharmacy.service.interfaces.IMedicineReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicineRatingService implements IMedicineRatingService {

    @Autowired
    private MedicineRatingRepository medicineRatingRepository;
    @Autowired
    private IMedicineReservationService reservationService;

    public MedicineRating rateMedicine(MedicineRating rating){
        if(rating.getRate() < 1 || rating.getRate() > 5)
            throw new InvalidActionException("Invalid rate");
        for(MedicineReservation r : reservationService.getAllReservationsByPatient(rating.getPatient().getUser().getEmail()))
            if(r.getMedicinePharmacy().getMedicine().getName().equalsIgnoreCase(rating.getMedicine().getName()))
                return medicineRatingRepository.save(rating);
        throw new InvalidActionException("Cannot rate medicine that has not been reserved!");
    }

    public void updateRating(MedicineRating rating){
        if(rating.getRate() < 1 || rating.getRate() > 5)
            throw new InvalidActionException("Invalid rate");
        if(medicineRatingRepository.findMedicineRatingByPatientAndMedicine(rating.getPatient(), rating.getMedicine()) == null)
            throw new NotFoundException("Cannot rat medicine that has not been reserved!");
        medicineRatingRepository.save(rating);
    }

    public Double getAverageRatingByMedicine(String medName){
        Double ratingSum = 0.0;
        Double i = 0.0;
        for(MedicineRating rating : medicineRatingRepository.findMedicineRatingsByMedicine_Name(medName)){
            ratingSum += rating.getRate();
            i++;
        }
        if(i == 0)
            throw new NotFoundException("Medicine has no ratings yet");
        return ratingSum/i;
    }
}
