package com.isa.pharmacy.controller.mapping;

import com.isa.pharmacy.controller.dto.MedicineReservationDto;
import com.isa.pharmacy.domain.Medicine;
import com.isa.pharmacy.domain.MedicineReservation;

import java.util.ArrayList;
import java.util.List;

public class MedicineReservationMapper {

    public static MedicineReservationDto mapReservationToReservationDto(MedicineReservation reservation){
        MedicineReservationDto mappedReservation = new MedicineReservationDto();
        mappedReservation.setId(reservation.getId());
        mappedReservation.setPatientEmail(reservation.getPatient().getUser().getEmail());
        mappedReservation.setPharmacyName(reservation.getMedicinePharmacy().getPharmacy().getName());
        mappedReservation.setMedicineName(reservation.getMedicinePharmacy().getMedicine().getName());
        mappedReservation.setDueDate(reservation.getDueDate());
        mappedReservation.setAmount(reservation.getAmount());
        return mappedReservation;
    }

    public static MedicineReservation mapReservationDtoToReservation(MedicineReservationDto reservationDto){
        MedicineReservation mappedReservation = new MedicineReservation();
        mappedReservation.setId(reservationDto.getId());
        mappedReservation.setDueDate(reservationDto.getDueDate());
        mappedReservation.setAmount(reservationDto.getAmount());
        return mappedReservation;
    }

    public static List<MedicineReservationDto> mapListReservationToReservationDto(List<MedicineReservation> reservations){
        List<MedicineReservationDto> mappedReservations = new ArrayList<>();
        for(MedicineReservation res : reservations)
            mappedReservations.add(mapReservationToReservationDto(res));
        return mappedReservations;
    }
}
