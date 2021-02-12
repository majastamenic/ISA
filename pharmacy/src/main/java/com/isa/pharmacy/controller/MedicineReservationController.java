package com.isa.pharmacy.controller;

import com.isa.pharmacy.controller.dto.MedicineReservationDto;
import com.isa.pharmacy.controller.mapping.MedicineReservationMapper;
import com.isa.pharmacy.domain.MedicineReservation;
import com.isa.pharmacy.service.interfaces.IMedicinePharmacyService;
import com.isa.pharmacy.service.interfaces.IMedicineReservationService;
import com.isa.pharmacy.users.service.interfaces.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicineReservation")
@CrossOrigin(origins ={ "http://localhost:4200", "https://pharmacy-25-frontend.herokuapp.com"})
public class MedicineReservationController {

    @Autowired
    private IMedicineReservationService medicineReservationService;

    @Autowired
    private IMedicinePharmacyService medicinePharmacyService;
    @Autowired
    private IPatientService patientService;


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

    @PutMapping("/accept/{email}/{code}")
    public boolean acceptReservation(@PathVariable("email") String email, @PathVariable("code") Long code){
        return medicineReservationService.acceptReservation(email, code);
    }

    @DeleteMapping("/{reservationId}")
    public void cancelReservation(@PathVariable long reservationId){
        medicineReservationService.cancelReservation(reservationId);
    }
}
