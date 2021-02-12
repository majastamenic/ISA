package com.isa.pharmacy.rating.domain;

import com.isa.pharmacy.domain.Medicine;
import com.isa.pharmacy.users.domain.Patient;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table
public class MedicineRating implements Serializable {
    private static final long serialVersionUID = -4236270693184289388L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Integer rate;
    @ManyToOne
    private Patient patient;
    @ManyToOne
    private Medicine medicine;

    public MedicineRating(){}

    public MedicineRating(Long id, Integer rate, Patient patient, Medicine medicine) {
        this.id = id;
        this.rate = rate;
        this.patient = patient;
        this.medicine = medicine;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }
}
