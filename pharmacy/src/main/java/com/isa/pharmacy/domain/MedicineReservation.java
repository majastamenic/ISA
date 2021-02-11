package com.isa.pharmacy.domain;

import com.isa.pharmacy.users.domain.Patient;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class MedicineReservation implements Serializable {
    private static final long serialVersionUID = 606717301026198629L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Patient patient;
    @ManyToOne
    private MedicinePharmacy medicinePharmacy;
    @Column
    private Integer amount;

    public MedicineReservation(){}

    public MedicineReservation(Long id, Patient patient, MedicinePharmacy medicinePharmacy, Integer amount) {
        this.id = id;
        this.patient = patient;
        this.medicinePharmacy = medicinePharmacy;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public MedicinePharmacy getMedicinePharmacy() {
        return medicinePharmacy;
    }

    public void setMedicinePharmacy(MedicinePharmacy medicinePharmacy) {
        this.medicinePharmacy = medicinePharmacy;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
