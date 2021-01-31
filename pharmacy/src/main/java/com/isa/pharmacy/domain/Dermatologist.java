package com.isa.pharmacy.domain;

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

    @Column
    private String email;
    @Column
    private String password;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private String address;
    @Column
    private String city;
    @Column
    private String country;
    @Column
    private String phone;

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

    public Dermatologist(Long id, String email, String password, String name, String surname, String address, String city, String country, String phone, boolean isFirstLog, List<Pharmacy> pharmacy, List<Examination> examinations, WorkSchedule workSchedule, List<VacationSchedule> vacationSchedules) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.city = city;
        this.country = country;
        this.phone = phone;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
