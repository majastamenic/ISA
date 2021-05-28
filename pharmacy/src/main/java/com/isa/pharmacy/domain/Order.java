package com.isa.pharmacy.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.isa.pharmacy.domain.enums.OrderState;
import com.isa.pharmacy.users.domain.PharmacyAdmin;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity(name = "app_order")
@Table
public class Order implements Serializable {
    private static final long serialVersionUID = -2552181062633782965L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Medicine medicine;
    @Column
    private Integer quantity;
    @Column
    private double price;
    @Column
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+01:00")
    private Date endDate;
    @Column
    private Long winnerId;
    @ManyToOne
    private PharmacyAdmin pharmacyAdmin;
    @Column
    private OrderState orderState;

    public Order() {
    }

    public Order(Long id,Medicine medicine,Integer quantity,double price, Date endDate, PharmacyAdmin pharmacyAdmin,Long winnerId) {
        this.id = id;
        this.endDate = endDate;
        this.pharmacyAdmin = pharmacyAdmin;
        this.medicine = medicine;
        this.quantity = quantity;
        this.price = price;
        this.winnerId = winnerId;
        this.orderState = OrderState.WAITING_FOR_OFFERS;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public PharmacyAdmin getPharmacyAdmin() {
        return pharmacyAdmin;
    }

    public void setPharmacyAdmin(PharmacyAdmin pharmacyAdmin) {
        this.pharmacyAdmin = pharmacyAdmin;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
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

    public Long getWinnerId() {
        return winnerId;
    }

    public void setWinnerId(Long winnerId) {
        this.winnerId = winnerId;
    }

    public OrderState getOrderState() {
        return orderState;
    }

    public void setOrderState(OrderState orderState) {
        this.orderState = orderState;
    }
}
