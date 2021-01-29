package com.isa.pharmacy.domain;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "medicinePharmacy")
public class MedicinePharmacy implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private double price;
    @Column
    private int quantity;
    @ManyToOne
    private Medicine medicine;
    @ManyToOne
    private Pharmacy pharmacy;

    public MedicinePharmacy() {
    }

    public MedicinePharmacy(long id, double price, Medicine medicine, Pharmacy pharmacy, int quantity) {
        super();
        this.id = id;
        this.price = price;
        this.medicine = medicine;
        this.pharmacy = pharmacy;
        this.quantity = quantity;
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

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


}
