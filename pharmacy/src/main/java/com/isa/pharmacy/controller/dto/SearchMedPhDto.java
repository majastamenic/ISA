package com.isa.pharmacy.controller.dto;

public class SearchMedPhDto {
    private String pharmacyName;
    private double price;

    public SearchMedPhDto(){}

    public SearchMedPhDto(String pharmacyName, double price) {
        this.pharmacyName = pharmacyName;
        this.price = price;
    }

    public String getPharmacyName() {
        return pharmacyName;
    }

    public void setPharmacyName(String pharmacyName) {
        this.pharmacyName = pharmacyName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
