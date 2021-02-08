package com.isa.pharmacy.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.isa.pharmacy.domain.enums.OrderOfferType;
import com.isa.pharmacy.users.domain.Supplier;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class SupplierOffer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Order order;
    @ManyToOne
    private Supplier supplier;
    @Column
    private double totalPrice;
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+01:00")
    private Date deliveryDate;
    @Column
    private OrderOfferType type;

    public  SupplierOffer(){}

    public SupplierOffer(Long id, Order order, Supplier supplier, double totalPrice, Date deliveryDate, OrderOfferType type) {
        this.id = id;
        this.order = order;
        this.supplier = supplier;
        this.totalPrice = totalPrice;
        this.deliveryDate = deliveryDate;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
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

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
}
