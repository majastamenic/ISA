package com.isa.pharmacy.controller.dto;

public class PharmacyPriceDto {
    private String phName;
    private double price;

    public PharmacyPriceDto(){}

    public PharmacyPriceDto(String phName, double price) {
        this.phName = phName;
        this.price = price;
    }

    public String getPhName() {
        return phName;
    }

    public void setPhName(String phName) {
        this.phName = phName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
