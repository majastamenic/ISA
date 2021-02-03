package com.isa.pharmacy.domain;

import com.isa.pharmacy.domain.Profile.Dermatologist;
import com.isa.pharmacy.domain.Profile.Pharmacist;
import com.isa.pharmacy.domain.Profile.PharmacyAdmin;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table
public class WorkSchedule implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Schedule schedule;
    @OneToMany
    private List<Pharmacist> pharmacists;
    @OneToMany
    private List<Dermatologist> dermatologists;
    @OneToOne
    private PharmacyAdmin admin;


    public WorkSchedule() {
    }

    public WorkSchedule(Long id, Schedule schedule, List<Pharmacist> pharmacists, List<Dermatologist> dermatologists, PharmacyAdmin admin) {
        this.id = id;
        this.schedule = schedule;
        this.pharmacists = pharmacists;
        this.dermatologists = dermatologists;
        this.admin = admin;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
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

    public PharmacyAdmin getAdmin() {
        return admin;
    }

    public void setAdmin(PharmacyAdmin admin) {
        this.admin = admin;
    }

}

