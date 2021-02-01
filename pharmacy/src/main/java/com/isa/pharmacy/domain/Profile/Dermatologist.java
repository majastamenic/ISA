package com.isa.pharmacy.domain.Profile;

import com.isa.pharmacy.domain.Examination;
import com.isa.pharmacy.domain.Pharmacy;
import com.isa.pharmacy.domain.VacationSchedule;
import com.isa.pharmacy.domain.WorkSchedule;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table
public class Dermatologist implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private User user;

    @Column
    private boolean isFirstLog = true;
    @OneToMany
    private List<Pharmacy> pharmacy;
    @OneToMany
    private List<Examination> examinations;
    @OneToOne
    private WorkSchedule workSchedule;
    @OneToMany
    private List<VacationSchedule> vacationSchedules;

    public Dermatologist(){}

    public Dermatologist(Long id, User user, boolean isFirstLog, List<Pharmacy> pharmacy, List<Examination> examinations, WorkSchedule workSchedule, List<VacationSchedule> vacationSchedules) {
        this.id = id;
        this.user = user;
        this.isFirstLog = isFirstLog;
        this.pharmacy = pharmacy;
        this.examinations = examinations;
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

    public WorkSchedule getWorkSchedule() {
        return workSchedule;
    }

    public void setWorkSchedule(WorkSchedule workSchedule) {
        this.workSchedule = workSchedule;
    }

    public List<Examination> getExaminations() {
        return examinations;
    }

    public void setExaminations(List<Examination> examinations) {
        this.examinations = examinations;
    }

    public List<Pharmacy> getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(List<Pharmacy> pharmacy) {
        this.pharmacy = pharmacy;
    }

    public List<VacationSchedule> getVacationSchedules() {
        return vacationSchedules;
    }

    public void setVacationSchedules(List<VacationSchedule> vacationSchedules) {
        this.vacationSchedules = vacationSchedules;
    }
}
