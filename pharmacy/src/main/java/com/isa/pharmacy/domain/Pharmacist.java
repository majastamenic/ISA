package com.isa.pharmacy.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Pharmacist extends User{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Pharmacy pharmacy;
    @OneToMany
    private List<Counseling> counselings;
    @OneToOne
    private WorkSchedule workSchedule;
    @OneToMany
    private List<VacationSchedule> vacationSchedules;

    public Pharmacist(){}

    public Pharmacist(Long id, String email, String password, String name, String surname, String address, String city, String country, String phone, Long id1, Pharmacy pharmacy, List<Counseling> counselings, WorkSchedule workSchedule, List<VacationSchedule> vacationSchedules) {
        super(id, email, password, name, surname, address, city, country, phone);
        this.id = id1;
        this.pharmacy = pharmacy;
        this.counselings = counselings;
        this.workSchedule = workSchedule;
        this.vacationSchedules = vacationSchedules;
    }

    public List<VacationSchedule> getVacationSchedules() {
        return vacationSchedules;
    }

    public void setVacationSchedules(List<VacationSchedule> vacationSchedules) {
        this.vacationSchedules = vacationSchedules;
    }

    public WorkSchedule getWorkSchedule() {
        return workSchedule;
    }

    public void setWorkSchedule(WorkSchedule workSchedule) {
        this.workSchedule = workSchedule;
    }

    public List<Counseling> getCounselings() {
        return counselings;
    }

    public void setCounselings(List<Counseling> counselings) {
        this.counselings = counselings;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }
}
