package com.isa.pharmacy.controller.dto;

import com.isa.pharmacy.domain.Diagnosis;
import java.util.List;

public class PrescriptionDto {
    private Long id;
    private String note;
    private List<Diagnosis> diagnoses;
    private List<MedicinePharmacyDto> medicines;

    public PrescriptionDto(){}

    public PrescriptionDto(Long id, String note, List<Diagnosis> diagnoses, List<MedicinePharmacyDto> medicines) {
        this.id = id;
        this.note = note;
        this.diagnoses = diagnoses;
        this.medicines = medicines;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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
