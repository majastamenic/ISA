package com.isa.pharmacy.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class OrderOffer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Medicine medicine;
    @Column
    private Integer quantity;
    @Column
    private double price;

    public OrderOffer(){}

    public OrderOffer(Long id, Medicine medicine, Integer quantity, double price) {
        this.id = id;
        this.medicine = medicine;
        this.quantity = quantity;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
