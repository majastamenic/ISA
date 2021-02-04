package com.isa.pharmacy.controller.dto;

public class GetAllMedicinePharmacyDto {
    private Long id;

    private double price;

    private int quantity;

    private MedicineFromPharmacyDto medicine;

    private PharmacyFromMedicinePharmacyDto pharmacy;

    public GetAllMedicinePharmacyDto() {
    }

    public GetAllMedicinePharmacyDto(Long id, double price, int quantity, MedicineFromPharmacyDto medicine, PharmacyFromMedicinePharmacyDto pharmacy) {
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

    public MedicineFromPharmacyDto getMedicine() {
        return medicine;
    }

    public void setMedicine(MedicineFromPharmacyDto medicine) {
        this.medicine = medicine;
    }

    public PharmacyFromMedicinePharmacyDto getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(PharmacyFromMedicinePharmacyDto pharmacy) {
        this.pharmacy = pharmacy;
    }
}
