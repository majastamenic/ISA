package com.isa.pharmacy.controller.dto;

public class MedicineLoyaltyDto {
    private Long code;
    private String name;
    private int loyaltyPoints;

    public MedicineLoyaltyDto(){}

    public MedicineLoyaltyDto(Long code, String name, int loyaltyPoints) {
        this.code = code;
        this.name = name;
        this.loyaltyPoints = loyaltyPoints;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(int loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }
}
