package com.isa.pharmacy.controller.dto;

public class MedicineEPrescriptionDto {
    private String medicineName;
    private int quantity;

    public MedicineEPrescriptionDto(){}

    public MedicineEPrescriptionDto(String medicineName, int quantity) {
        this.medicineName = medicineName;
        this.quantity = quantity;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
