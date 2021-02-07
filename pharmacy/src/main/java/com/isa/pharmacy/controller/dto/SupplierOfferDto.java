package com.isa.pharmacy.controller.dto;

import com.isa.pharmacy.domain.Order;
import com.isa.pharmacy.domain.OrderOffer;
import com.isa.pharmacy.domain.enums.OrderOfferType;
import com.isa.pharmacy.users.domain.Supplier;

import java.util.List;

public class SupplierOfferDto {
    private Long orderId;
    private List<OrderOffer> orderOffers;
    private OrderOfferType type;
    private String supplierEmail;

    public SupplierOfferDto(){}

    public SupplierOfferDto(Long orderId, List<OrderOffer> orderOffers, OrderOfferType type, String supplierEmail) {
        this.orderId = orderId;
        this.orderOffers = orderOffers;
        this.type = type;
        this.supplierEmail = supplierEmail;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public List<OrderOffer> getOrderOffers() {
        return orderOffers;
    }

    public void setOrderOffers(List<OrderOffer> orderOffers) {
        this.orderOffers = orderOffers;
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
