package com.isa.pharmacy.controller.dto;

import com.isa.pharmacy.domain.Diagnosis;
import java.util.List;

public class PrescriptionDto {
    private Long id;
    private Integer days;
    private List<Long> diagnosis;
    private List<Long> medicines;

    public PrescriptionDto(){}

    public PrescriptionDto(Long id, Integer days, List<Long> diagnosis, List<Long> medicines) {
        this.id = id;
        this.days = days;
        this.diagnosis = diagnosis;
        this.medicines = medicines;
    }

    public List<Long> getMedicines() {
        return medicines;
    }

    public void setMedicines(List<Long> medicines) {
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

    public List<Long> getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(List<Long> diagnosis) {
        this.diagnosis = diagnosis;
    }
}
