package com.isa.pharmacy.service;

import com.isa.pharmacy.controller.exception.InvalidActionException;
import com.isa.pharmacy.domain.MedicineReservation;
import com.isa.pharmacy.repository.MedicineReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MedicineReservationService {

    @Autowired
    private MedicineReservationRepository medicineReservationRepository;
    @Autowired
    private EmailService emailService;

    public MedicineReservation createReservation(MedicineReservation reservation){
        if(reservation.getDueDate().compareTo(new Date()) <= 0)
            throw new InvalidActionException("Due date should be future date!");
        if(reservation.getAmount() <= 0)
            throw new InvalidActionException("Invalid medicine amount");
        MedicineReservation reservedMedicine = medicineReservationRepository.save(reservation);
        emailService.successfulMedicineReservation(reservedMedicine);
        return medicineReservationRepository.save(reservation);
    }
}
