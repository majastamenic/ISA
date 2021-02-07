package com.isa.pharmacy.controller.dto;

public class AvailabilityMedicineDto {
    private String name;
    private Boolean available;

    public AvailabilityMedicineDto(){}

    public AvailabilityMedicineDto(String name, Boolean available) {
        this.name = name;
        this.available = available;
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
