package com.isa.pharmacy.rating.service;

import com.isa.pharmacy.rating.repository.MedicineRatingRepository;
import com.isa.pharmacy.rating.service.interfaces.IMedicineRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicineRatingService implements IMedicineRatingService {

    @Autowired
    private MedicineRatingRepository medicineRatingRepository;
}
