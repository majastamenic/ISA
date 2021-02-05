package com.isa.pharmacy.controller.mapping;

import com.isa.pharmacy.controller.dto.AllergyDto;
import com.isa.pharmacy.controller.dto.PatientDto;
import com.isa.pharmacy.domain.Medicine;
import com.isa.pharmacy.users.domain.Patient;

import java.util.ArrayList;
import java.util.List;

public class PatientMapper {
    public static PatientDto mapPatientToPatientDto(Patient patient) {
        PatientDto patientDto = new PatientDto();
        List<AllergyDto> allergies = new ArrayList<>();
        for(Medicine m : patient.getAllergicMedicines()){
            AllergyDto allergy = MedicineMapper.mapAllergyToAllergyDto(m);
            allergies.add(allergy);
        }
        patientDto.setAllergicMedicines(allergies);
        patientDto.setUser(patient.getUser());
        return patientDto;
    }

    public static Patient mapPatientDtoToPatient(PatientDto patientDto){
        Patient patient = new Patient();
        List<Medicine> medicines = new ArrayList<>();
        for(AllergyDto a : patientDto.getAllergicMedicines()){
            Medicine med = MedicineMapper.mapAllergyDtoToAllergy(a);
            medicines.add(med);
        }
        patient.setAllergicMedicines(medicines);
        patient.setUser(patient.getUser());
        return patient;
    }

}
