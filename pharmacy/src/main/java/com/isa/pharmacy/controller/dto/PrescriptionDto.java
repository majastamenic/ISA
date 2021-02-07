package com.isa.pharmacy.controller.dto;

import com.isa.pharmacy.domain.Diagnosis;
import java.util.List;

public class PrescriptionDto {
    private Long id;
    private Integer days;
    private List<Diagnosis> diagnoses;
    private List<MedicinePharmacyDto> medicines;

    public PrescriptionDto(){}

    public PrescriptionDto(Long id, Integer days, List<Diagnosis> diagnoses, List<MedicinePharmacyDto> medicines) {
        this.id = id;
        this.days = days;
        this.diagnoses = diagnoses;
        this.medicines = medicines;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public List<Diagnosis> getDiagnoses() {
        return diagnoses;
    }

    public void setDiagnoses(List<Diagnosis> diagnoses) {
        this.diagnoses = diagnoses;
    }

    public List<MedicinePharmacyDto> getMedicines() {
        return medicines;
    }

    public void setMedicines(List<MedicinePharmacyDto> medicines) {
        this.medicines = medicines;
    }
}
