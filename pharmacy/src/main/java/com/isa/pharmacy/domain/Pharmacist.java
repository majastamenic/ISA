package com.isa.pharmacy.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Pharmacist extends User{
    private static final long serialVersionUID = 1L;
    @OneToOne
    private Pharmacy pharmacy;
    @OneToMany
    private List<Counseling> counselings;
    @OneToOne
    private WorkSchedule workSchedule;
    @OneToMany
    private List<VacationSchedule> vacationSchedules;

    public Pharmacist(){}

    public Pharmacist(Long id, String email, String password, String name, String surname, String address, String city, String country, String phone, Pharmacy pharmacy, List<Counseling> counselings, WorkSchedule workSchedule, List<VacationSchedule> vacationSchedules) {
        super(id, email, password, name, surname, address, city, country, phone);
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

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }
}
