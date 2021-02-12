package com.isa.pharmacy.service;

import com.isa.pharmacy.controller.exception.BadRequestException;
import com.isa.pharmacy.controller.exception.InvalidActionException;
import com.isa.pharmacy.domain.MedicineReservation;
import com.isa.pharmacy.repository.MedicineReservationRepository;
import com.isa.pharmacy.service.interfaces.IMedicineReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MedicineReservationService implements IMedicineReservationService {

    @Autowired
    private MedicineReservationRepository medicineReservationRepository;
    @Autowired
    private EmailService emailService;


    public List<MedicineReservation> getAllReservationsByPatient(String patientEmail){
        return medicineReservationRepository.findMedicineReservationByPatient_User_Email(patientEmail);
    }

    public MedicineReservation createReservation(MedicineReservation reservation){
        if(reservation.getDueDate().compareTo(new Date()) <= 0)
            throw new InvalidActionException("Due date should be future date!");
        if(reservation.getAmount() <= 0)
            throw new InvalidActionException("Invalid medicine amount");
        MedicineReservation reservedMedicine = medicineReservationRepository.save(reservation);
        try{emailService.successfulMedicineReservation(reservedMedicine);
        }catch (Exception e){
            throw new BadRequestException("Email feature not available on heroku");
        }
        return medicineReservationRepository.save(reservation);
    }
}
