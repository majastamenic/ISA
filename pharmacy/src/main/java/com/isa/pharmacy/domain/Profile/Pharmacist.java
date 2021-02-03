package com.isa.pharmacy.domain.Profile;

import com.isa.pharmacy.domain.Counseling;
import com.isa.pharmacy.domain.Pharmacy;
import com.isa.pharmacy.domain.VacationSchedule;
import com.isa.pharmacy.domain.WorkSchedule;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table
public class Pharmacist implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private User user;
    @Column
    private boolean isFirstLog = true;
    @ManyToOne
    @JoinColumn(name = "pharmacy_id")
    private Pharmacy pharmacy;
    @ManyToMany
    private List<WorkSchedule> workSchedule;
    @OneToMany
    private List<VacationSchedule> vacationSchedules;

    public Pharmacist(){}


    public Pharmacist(Long id, User user, boolean isFirstLog, Pharmacy pharmacy, List<WorkSchedule> workSchedule, List<VacationSchedule> vacationSchedules) {
        this.id = id;
        this.user = user;
        this.isFirstLog = isFirstLog;
        this.pharmacy = pharmacy;
        this.workSchedule = workSchedule;
        this.vacationSchedules = vacationSchedules;
    }

    public boolean isFirstLog() {
        return isFirstLog;
    }

    public void setFirstLog(boolean firstLog) {
        isFirstLog = firstLog;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<VacationSchedule> getVacationSchedules() {
        return vacationSchedules;
    }

    public void setVacationSchedules(List<VacationSchedule> vacationSchedules) {
        this.vacationSchedules = vacationSchedules;
    }

    public List<WorkSchedule> getWorkSchedule() {
        return workSchedule;
    }

    public void setWorkSchedule(List<WorkSchedule> workSchedule) {
        this.workSchedule = workSchedule;
    }


    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }
}
