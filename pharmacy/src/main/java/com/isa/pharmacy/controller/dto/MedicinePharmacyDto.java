package com.isa.pharmacy.controller.dto;

public class MedicinePharmacyDto {
    private double price;
    private Integer quantity;
    private MedicineDto medicine;
    private String pharmacyName;

    public MedicinePharmacyDto(){}

    public MedicinePharmacyDto(double price, Integer quantity, MedicineDto medicine, String pharmacyName) {
        this.price = price;
        this.quantity = quantity;
        this.medicine = medicine;
        this.pharmacyName = pharmacyName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public MedicineDto getMedicine() {
        return medicine;
    }

    public void setMedicine(MedicineDto medicine) {
        this.medicine = medicine;
    }

    public String getPharmacyName() {
        return pharmacyName;
    }

    public void setPharmacyName(String pharmacyName) {
        this.pharmacyName = pharmacyName;
    }
}
