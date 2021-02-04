package com.isa.pharmacy.controller.dto;

import com.isa.pharmacy.domain.Medicine;
import com.isa.pharmacy.domain.Pharmacy;



public class GetAllMedicinePharmacyDto {
    private Long id;

    private double price;

    private int quantity;

    private Medicine medicine;

    private Pharmacy pharmacy;

    public GetAllMedicinePharmacyDto() {
    }

    public GetAllMedicinePharmacyDto(Long id, double price, int quantity, Medicine medicine, Pharmacy pharmacy) {
        this.id = id;
        this.price = price;
        this.quantity = quantity;
        this.medicine = medicine;
        this.pharmacy = pharmacy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }
}
