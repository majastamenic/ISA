package com.isa.pharmacy.controller.dto;

import com.isa.pharmacy.domain.enums.OrderOfferType;

import java.util.Date;
import java.util.List;

public class ViewOrderOfferDto {
    private Long id;
    private List<OrderOfferDto> orderOffers;
    private Date endDate;
    private Date endTime;
    private String pharmacyAdminEmail;
    private OrderOfferType type;
    private String supplierEmail;
    private double totalPrice;
    private Date deliveryDate;

    public ViewOrderOfferDto(){}

    public ViewOrderOfferDto(Long id, List<OrderOfferDto> orderOffers, Date endDate, Date endTime, String pharmacyAdminEmail, OrderOfferType type, String supplierEmail, double totalPrice, Date deliveryDate) {
        this.id = id;
        this.orderOffers = orderOffers;
        this.endDate = endDate;
        this.endTime = endTime;
        this.pharmacyAdminEmail = pharmacyAdminEmail;
        this.type = type;
        this.supplierEmail = supplierEmail;
        this.totalPrice = totalPrice;
        this.deliveryDate = deliveryDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<OrderOfferDto> getOrderOffers() {
        return orderOffers;
    }

    public void setOrderOffers(List<OrderOfferDto> orderOffers) {
        this.orderOffers = orderOffers;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getPharmacyAdminEmail() {
        return pharmacyAdminEmail;
    }

    public void setPharmacyAdminEmail(String pharmacyAdminEmail) {
        this.pharmacyAdminEmail = pharmacyAdminEmail;
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
}
