package com.isa.pharmacy.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table
public class VacationSchedule {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
    @OneToMany
    private List<Pharmacist> pharmacists;
    @OneToMany
    private List<Dermatologist> dermatologists;

    public VacationSchedule(){}

    public VacationSchedule(Long id, Date startDate, Date endDate, List<Pharmacist> pharmacists, List<Dermatologist> dermatologists) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.pharmacists = pharmacists;
        this.dermatologists = dermatologists;
    }

    public List<Dermatologist> getDermatologists() {
        return dermatologists;
    }

    public void setDermatologists(List<Dermatologist> dermatologists) {
        this.dermatologists = dermatologists;
    }

    public List<Pharmacist> getPharmacists() {
        return pharmacists;
    }

    public void setPharmacists(List<Pharmacist> pharmacists) {
        this.pharmacists = pharmacists;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
