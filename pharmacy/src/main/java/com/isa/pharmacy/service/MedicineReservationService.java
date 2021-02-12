package com.isa.pharmacy.service;

import com.isa.pharmacy.controller.exception.BadRequestException;
import com.isa.pharmacy.controller.exception.InvalidActionException;
import com.isa.pharmacy.controller.exception.NotFoundException;
import com.isa.pharmacy.domain.MedicineReservation;
import com.isa.pharmacy.repository.MedicineReservationRepository;
import com.isa.pharmacy.scheduling.DateManipulation;
import com.isa.pharmacy.service.interfaces.IEmailService;
import com.isa.pharmacy.service.interfaces.IMedicinePharmacyService;
import com.isa.pharmacy.service.interfaces.IMedicineReservationService;
import com.isa.pharmacy.service.interfaces.IMedicineService;
import com.isa.pharmacy.users.domain.Pharmacist;
import com.isa.pharmacy.users.service.interfaces.IPatientService;
import com.isa.pharmacy.users.service.interfaces.IPharmacistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class MedicineReservationService implements IMedicineReservationService {

    @Autowired
    private MedicineReservationRepository medicineReservationRepository;
    @Autowired
    private IEmailService emailService;
    @Autowired
    private IPatientService patientService;
    @Autowired
    private IMedicinePharmacyService medicinePharmacyService;
    @Autowired
    private IPharmacistService pharmacistService;
    @Autowired
    private IMedicineService medicineService;


    public List<MedicineReservation> getAllReservationsByPatient(String patientEmail){
        return medicineReservationRepository.findMedicineReservationByPatient_User_Email(patientEmail);
    }

    public MedicineReservation createReservation(MedicineReservation reservation){
        if(reservation.getDueDate().compareTo(new Date()) <= 0)
            throw new InvalidActionException("Due date should be future date!");
        if(reservation.getAmount() <= 0)
            throw new InvalidActionException("Invalid medicine amount");
        MedicineReservation reservedMedicine = medicineReservationRepository.save(reservation);
        reservedMedicine.setCode(new Random().nextLong());
        medicineReservationRepository.save(reservedMedicine);
        medicineService.changeAmount(reservation.getMedicinePharmacy().getMedicine().getName(),
                -reservation.getAmount(), reservation.getMedicinePharmacy().getPharmacy().getName());
        medicinePharmacyService.save(reservedMedicine.getMedicinePharmacy());
        patientService.save(reservedMedicine.getPatient());

        emailService.successfulMedicineReservation(reservedMedicine);
        return medicineReservationRepository.save(reservation);
    }

    public boolean acceptReservation(String email, Long code){
        MedicineReservation medicineReservation = medicineReservationRepository.findMedicineReservationByCode(code);
        Pharmacist pharmacist = pharmacistService.findUserByEmail(email);
        DateManipulation dm = new DateManipulation();
        int minutes = 60*24;
        Date currentDate = dm.addMinutes(new Date(), minutes);
        if(medicineReservation != null && medicineReservation.getTaken() == null && currentDate.before(medicineReservation.getDueDate()) &&
                pharmacist != null && pharmacist.getPharmacy().getName().equals(medicineReservation.getMedicinePharmacy().getPharmacy().getName())){
            medicineReservation.setTaken(true);
            medicineReservationRepository.save(medicineReservation);
            patientService.save(medicineReservation.getPatient());
            medicinePharmacyService.save(medicineReservation.getMedicinePharmacy());
            emailService.successfulPublishingReservation(medicineReservation);
            return true;
        }else if(medicineReservation == null){
            throw new NotFoundException("Reservation doesn't exist.");
        }
        medicineReservation.setTaken(false);
        medicineReservationRepository.save(medicineReservation);
        patientService.save(medicineReservation.getPatient());
        medicinePharmacyService.save(medicineReservation.getMedicinePharmacy());
        return false;
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
