package com.isa.pharmacy.controller.dto;

import java.util.List;

public class AvailabilityMedicineDto {
    private Long id;
    private String name;
    private Boolean available;
    private List<String> alternative;

    public AvailabilityMedicineDto(){}

    public AvailabilityMedicineDto(Long id, String name, Boolean available, List<String> alternative) {
        this.id = id;
        this.name = name;
        this.available = available;
        this.alternative = alternative;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<String> getAlternative() {
        return alternative;
    }

    public void setAlternative(List<String> alternative) {
        this.alternative = alternative;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}
