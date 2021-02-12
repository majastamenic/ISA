package com.isa.pharmacy.users.controller.mapping;

import com.isa.pharmacy.users.controller.dto.PatientDto;
import com.isa.pharmacy.users.domain.Patient;

public class PatientMapper {
    public static PatientDto mapPatientToPatientDto(Patient patient) {
        PatientDto patientDto = new PatientDto();
        patientDto.setAllergicMedicines(patient.getAllergicMedicines());
        patientDto.setUser(patient.getUser());
        patientDto.setLoyaltyPoints(patient.getLoyaltyPoints());
        return patientDto;
    }

    public static Patient mapPatientDtoToPatient(PatientDto patientDto){
        Patient patient = new Patient();
        patient.setId(patient.getId());
        patient.setAllergicMedicines(patientDto.getAllergicMedicines());
        patient.setUser(patientDto.getUser());
        patient.setLoyaltyPoints(patientDto.getLoyaltyPoints());
        return patient;
    }

}
