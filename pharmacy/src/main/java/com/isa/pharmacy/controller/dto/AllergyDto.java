package com.isa.pharmacy.controller.dto;

public class AllergyDto {
    private String name;

    public AllergyDto(){}

    public AllergyDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
