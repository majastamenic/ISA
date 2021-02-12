package com.isa.pharmacy.controller.dto;

public class OrderOfferDto {

    private String medicineName;
    private Integer quantity;
    private double price;

    public OrderOfferDto(){}

    public OrderOfferDto(String medicineName, Integer quantity, double price) {
        this.medicineName = medicineName;
        this.quantity = quantity;
        this.price = price;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
