package com.isa.pharmacy.service;

import com.isa.pharmacy.controller.exception.InvalidActionException;
import com.isa.pharmacy.domain.MedicineReservation;
import com.isa.pharmacy.repository.MedicineReservationRepository;
import com.isa.pharmacy.scheduling.DateManipulation;
import com.isa.pharmacy.service.interfaces.IEmailService;
import com.isa.pharmacy.service.interfaces.IMedicineReservationService;
import com.isa.pharmacy.service.interfaces.IMedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MedicineReservationService implements IMedicineReservationService {

    @Autowired
    private MedicineReservationRepository medicineReservationRepository;
    @Autowired
    private IMedicineService medicineService;
    @Autowired
    private IEmailService emailService;


    public List<MedicineReservation> getAllReservationsByPatient(String patientEmail){
        return medicineReservationRepository.findMedicineReservationByPatient_User_Email(patientEmail);
    }

    public MedicineReservation createReservation(MedicineReservation reservation){
        if(reservation.getDueDate().compareTo(new Date()) <= 0)
            throw new InvalidActionException("Due date should be future date!");
        if(reservation.getAmount() <= 0)
            throw new InvalidActionException("Invalid medicine amount");
        MedicineReservation reservedMedicine = medicineReservationRepository.save(reservation);
        emailService.successfulMedicineReservation(reservedMedicine);
        return medicineReservationRepository.save(reservation);
    }

    public void cancelReservation(long reservationId){
        MedicineReservation reservation = medicineReservationRepository.findMedicineReservationById(reservationId);
        Date currDate = DateManipulation.addMinutes(new Date(), 60*24);
        if(currDate.after(reservation.getDueDate()))
            throw new InvalidActionException("Too late! Reservation can't be canceled");
        medicineService.changeAmount(reservation.getMedicinePharmacy().getMedicine().getName(),
                reservation.getAmount(), reservation.getMedicinePharmacy().getPharmacy().getName());
        medicineReservationRepository.delete(reservation);
    }
}
