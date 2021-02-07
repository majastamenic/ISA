package com.isa.pharmacy.users.controller.dto;

import com.isa.pharmacy.domain.Counseling;
import com.isa.pharmacy.domain.Pharmacy;
import com.isa.pharmacy.domain.VacationSchedule;
import com.isa.pharmacy.domain.WorkSchedule;

import java.util.List;

public class PharmacistDto {
    private String email;
    private String password;
    private String name;
    private String surname;
    private String address;
    private String city;
    private String country;
    private String phone;
    private Pharmacy pharmacy;
    private List<Counseling> counselings;
    private WorkSchedule workSchedule;
    private List<VacationSchedule> vacationSchedules;

    public PharmacistDto() {
    }

    public PharmacistDto(String email, String password, String name, String surname, String address, String city, String country, String phone, Pharmacy pharmacy, List<Counseling> counselings, WorkSchedule workSchedule, List<VacationSchedule> vacationSchedules) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.city = city;
        this.country = country;
        this.phone = phone;
        this.pharmacy = pharmacy;
        this.counselings = counselings;
        this.workSchedule = workSchedule;
        this.vacationSchedules = vacationSchedules;
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

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }

    public List<Counseling> getCounselings() {
        return counselings;
    }

    public void setCounselings(List<Counseling> counselings) {
        this.counselings = counselings;
    }

    public WorkSchedule getWorkSchedule() {
        return workSchedule;
    }

    public void setWorkSchedule(WorkSchedule workSchedule) {
        this.workSchedule = workSchedule;
    }

    public List<VacationSchedule> getVacationSchedules() {
        return vacationSchedules;
    }

    public void setVacationSchedules(List<VacationSchedule> vacationSchedules) {
        this.vacationSchedules = vacationSchedules;
    }
}
