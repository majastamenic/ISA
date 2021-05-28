package com.isa.pharmacy.controller.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.isa.pharmacy.domain.Medicine;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;

public class OrderDto {

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+01:00")
    private Date endDate;
    private String pharmacyAdminEmail;
    private String medicineName;
    private Integer quantity;
    private double price;
    private Long id;

    public OrderDto(){}

    public OrderDto(String medicineName,Integer quantity,double price, Date endDate, String pharmacyAdminEmail, Long id) {
        this.endDate = endDate;
        this.pharmacyAdminEmail = pharmacyAdminEmail;
        this.medicineName = medicineName;
        this.quantity = quantity;
        this.price = price;
        this.id = id;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getPharmacyAdminEmail() {
        return pharmacyAdminEmail;
    }

    public void setPharmacyAdminEmail(String pharmacyAdminEmail) {
        this.pharmacyAdminEmail = pharmacyAdminEmail;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
