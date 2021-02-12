package com.isa.pharmacy.controller.dto;

import com.isa.pharmacy.domain.enums.OrderOfferType;

import java.util.Date;

public class SupplierOfferDto {
    private Long orderId;
    private OrderOfferType type;
    private String supplierEmail;
    private double totalPrice;
    private Date deliveryDate;

    public SupplierOfferDto(){}

    public SupplierOfferDto(Long orderId, OrderOfferType type, String supplierEmail, double totalPrice, Date deliveryDate) {
        this.orderId = orderId;
        this.type = type;
        this.supplierEmail = supplierEmail;
        this.totalPrice = totalPrice;
        this.deliveryDate = deliveryDate;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public OrderOfferType getType() {
        return type;
    }

    public void setType(OrderOfferType type) {
        this.type = type;
    }

    public String getSupplierEmail() {
        return supplierEmail;
    }

    public void setSupplierEmail(String supplierEmail) {
        this.supplierEmail = supplierEmail;
    }
}
