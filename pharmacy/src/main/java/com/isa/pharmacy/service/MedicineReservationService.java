package com.isa.pharmacy.service;

import com.isa.pharmacy.domain.MedicineReservation;
import com.isa.pharmacy.repository.MedicineReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicineReservationService {

    @Autowired
    private MedicineReservationRepository medicineReservationRepository;

    public MedicineReservation createReservation(MedicineReservation reservation){
        return medicineReservationRepository.save(reservation);
    }
}
