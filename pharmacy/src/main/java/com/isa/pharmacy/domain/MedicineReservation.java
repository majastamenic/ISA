package com.isa.pharmacy.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.isa.pharmacy.users.domain.Patient;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

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
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+01:00")
    private Date dueDate;
    @Column
    private Integer amount;
    @Column
    private Boolean isTaken;
    @Column(unique = true)
    private Long code;

    public MedicineReservation(){}

    public MedicineReservation(Long id, Patient patient, MedicinePharmacy medicinePharmacy, Date dueDate, Integer amount, Boolean isTaken, Long code) {
        this.id = id;
        this.patient = patient;
        this.medicinePharmacy = medicinePharmacy;
        this.dueDate = dueDate;
        this.amount = amount;
        this.isTaken = isTaken;
        this.code = code;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
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

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Boolean getTaken() {
        return isTaken;
    }

    public void setTaken(Boolean taken) {
        isTaken = taken;
    }
}
