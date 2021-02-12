package com.isa.pharmacy.rating.service;

import com.isa.pharmacy.rating.repository.DermatologistRatingRepository;
import com.isa.pharmacy.rating.service.interfaces.IDermatologistRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DermatologistRatingService implements IDermatologistRatingService {

    @Autowired
    private DermatologistRatingRepository dermatologistRatingRepository;
}
