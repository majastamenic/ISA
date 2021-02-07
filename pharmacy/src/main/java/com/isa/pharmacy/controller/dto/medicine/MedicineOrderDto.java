package com.isa.pharmacy.controller.dto.medicine;

public class MedicineOrderDto {
    private String medicineName;
    private int amount;

    public MedicineOrderDto() { }

    public MedicineOrderDto(String medicineName, int amount){
        this.medicineName = medicineName;
        this.amount = amount;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
