package com.isa.pharmacy.controller.dto;

import java.util.List;

public class ReportDto {
    private Long id;
    private Integer days;
    private List<Long> medicines;

    public ReportDto(){}

    public ReportDto(Long id, Integer days, List<Long> medicines) {
        this.id = id;
        this.days = days;
        this.medicines = medicines;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public List<Long> getMedicines() {
        return medicines;
    }

    public void setMedicines(List<Long> medicines) {
        this.medicines = medicines;
    }
}
