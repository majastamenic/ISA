package com.isa.pharmacy.users.domain;

import com.isa.pharmacy.domain.Pharmacy;
import com.isa.pharmacy.scheduling.domain.VacationSchedule;
import com.isa.pharmacy.scheduling.domain.WorkSchedule;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table
public class Pharmacist implements Serializable{
    private static final long serialVersionUID = 8975129800665804582L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private User user;
    @ManyToOne
    @JoinColumn(name = "pharmacy_id")
    private Pharmacy pharmacy;
    @ManyToMany
    private List<WorkSchedule> workSchedule;
    @OneToMany
    private List<VacationSchedule> vacationSchedules;

    public Pharmacist(){}

    public Pharmacist(Long id, User user, Pharmacy pharmacy, List<WorkSchedule> workSchedule, List<VacationSchedule> vacationSchedules) {
        this.id = id;
        this.user = user;
        this.pharmacy = pharmacy;
        this.workSchedule = workSchedule;
        this.vacationSchedules = vacationSchedules;
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
