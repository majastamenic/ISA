package com.isa.pharmacy.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Dermatologist extends User{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany
    private List<Pharmacy> pharmacy;
    @OneToMany
    private List<Examination> examinations;
    @OneToOne
    private WorkSchedule workSchedule;
    @OneToMany
    private List<VacationSchedule> vacationSchedules;

    public Dermatologist(){}

    public Dermatologist(Long id, String email, String password, String name, String surname, String address, String city, String country, String phone, Long id1, List<Pharmacy> pharmacy, List<Examination> examinations, WorkSchedule workSchedule, List<VacationSchedule> vacationSchedules) {
        super(id, email, password, name, surname, address, city, country, phone);
        this.id = id1;
        this.pharmacy = pharmacy;
        this.examinations = examinations;
        this.workSchedule = workSchedule;
        this.vacationSchedules = vacationSchedules;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
