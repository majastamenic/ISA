package com.isa.pharmacy.controller;

import com.isa.pharmacy.controller.dto.MedicineReservationDto;
import com.isa.pharmacy.controller.mapping.MedicineReservationMapper;
import com.isa.pharmacy.domain.MedicineReservation;
import com.isa.pharmacy.service.MedicinePharmacyService;
import com.isa.pharmacy.service.MedicineReservationService;
import com.isa.pharmacy.users.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicineReservation")
@CrossOrigin(value = "http://localhost:4200")
public class MedicineReservationController {

    @Autowired
    private MedicineReservationService medicineReservationService;

    @Autowired
    private MedicinePharmacyService medicinePharmacyService;
    @Autowired
    private PatientService patientService;


    @GetMapping("/{email}")
    public List<MedicineReservationDto> getAllReservationsByPatient(@PathVariable String email){
        return MedicineReservationMapper.mapListReservationToReservationDto(
                medicineReservationService.getAllReservationsByPatient(email));
    }

    @PostMapping
    public MedicineReservationDto createReservation(@RequestBody MedicineReservationDto reservationDto){
        MedicineReservation reservation = MedicineReservationMapper.mapReservationDtoToReservation(reservationDto);
        reservation.setPatient(patientService.getPatient(reservationDto.getPatientEmail()));
        reservation.setMedicinePharmacy(medicinePharmacyService.getByPharmacyAndMedicine(reservationDto.getPharmacyName(), reservationDto.getMedicineName()));
        return MedicineReservationMapper.mapReservationToReservationDto(
                medicineReservationService.createReservation(reservation));
    }
}
