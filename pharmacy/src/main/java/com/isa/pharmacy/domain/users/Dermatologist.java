package com.isa.pharmacy.domain.users;

import com.isa.pharmacy.domain.Pharmacy;
import com.isa.pharmacy.domain.VacationSchedule;
import com.isa.pharmacy.domain.WorkSchedule;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table
public class Dermatologist implements Serializable {
    private static final long serialVersionUID = 6484283988040527252L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private User user;
    @OneToMany      // TODO: @ManyToMany?
    private List<Pharmacy> pharmacy;
    @ManyToMany
    private List<WorkSchedule> workSchedule;
    @ManyToMany
    private List<VacationSchedule> vacationSchedules;

    public Dermatologist(){}

    public Dermatologist(Long id, User user, List<Pharmacy> pharmacy, List <WorkSchedule> workSchedule,
                         List<VacationSchedule> vacationSchedules) {
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

    public List<WorkSchedule> getWorkSchedule() {
        return workSchedule;
    }

    public void setWorkSchedule(List<WorkSchedule> workSchedule) {
        this.workSchedule = workSchedule;
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
