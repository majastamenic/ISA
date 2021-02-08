package com.isa.pharmacy.domain;

import com.isa.pharmacy.users.domain.PharmacyAdmin;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class WorkSchedule implements Serializable {
    private static final long serialVersionUID = 7284040064117627747L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Schedule schedule;
    @OneToOne
    private PharmacyAdmin admin;

    public WorkSchedule() { }

    public WorkSchedule(Long id, Schedule schedule, PharmacyAdmin admin) {
        this.id = id;
        this.schedule = schedule;
        this.admin = admin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public PharmacyAdmin getAdmin() {
        return admin;
    }

    public void setAdmin(PharmacyAdmin admin) {
        this.admin = admin;
    }
}

