package com.isa.pharmacy.rating.service;

import com.isa.pharmacy.rating.domain.PharmacyRating;
import com.isa.pharmacy.rating.repository.PharmacyRatingRepository;
import com.isa.pharmacy.rating.service.interfaces.IPharmacyRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PharmacyRatingService implements IPharmacyRatingService {

    @Autowired
    private PharmacyRatingRepository pharmacyRatingRepository;

}
