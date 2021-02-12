package com.isa.pharmacy.service;

import com.isa.pharmacy.controller.exception.InvalidActionException;
import com.isa.pharmacy.controller.exception.NotFoundException;
import com.isa.pharmacy.domain.MedicineReservation;
import com.isa.pharmacy.repository.MedicineReservationRepository;
import com.isa.pharmacy.scheduling.DateManipulation;
import com.isa.pharmacy.service.interfaces.IMedicinePharmacyService;
import com.isa.pharmacy.service.interfaces.IMedicineReservationService;
import com.isa.pharmacy.users.service.interfaces.IPatientService;
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
    private EmailService emailService;
    @Autowired
    private IPatientService patientService;
    @Autowired
    private IMedicinePharmacyService medicinePharmacyService;


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
        medicinePharmacyService.save(reservedMedicine.getMedicinePharmacy());
        patientService.save(reservedMedicine.getPatient());
        emailService.successfulMedicineReservation(reservedMedicine);
        return medicineReservationRepository.save(reservation);
    }

    public boolean acceptReservation(String email, Long code){
        MedicineReservation medicineReservation = medicineReservationRepository.findMedicineReservationByCode(code);
        DateManipulation dm = new DateManipulation();
        int minutes = 60*24;
        Date currentDate = dm.addMinutes(new Date(), minutes);
        if(medicineReservation != null && medicineReservation.getTaken() == null && currentDate.before(medicineReservation.getDueDate())){
            medicineReservation.setTaken(true);
            medicineReservationRepository.save(medicineReservation);
            patientService.save(medicineReservation.getPatient());
            medicinePharmacyService.save(medicineReservation.getMedicinePharmacy());
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

}
