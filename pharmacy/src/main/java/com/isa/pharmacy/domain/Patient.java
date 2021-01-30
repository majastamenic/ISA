package com.isa.pharmacy.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Patient extends User{
    private static final long serialVersionUID = 1L;
    @OneToMany
    private List<Counseling> counselings;
    @OneToMany
    private List<Examination> examinations;

    public Patient(){}

    public Patient(Long id, String email, String password, String name, String surname, String address, String city, String country, String phone, List<Counseling> counselings, List<Examination> examinations) {
        super(id, email, password, name, surname, address, city, country, phone);
        this.counselings = counselings;
        this.examinations = examinations;
    }

    public List<Examination> getExaminations() {
        return examinations;
    }

    public void setExaminations(List<Examination> examinations) {
        this.examinations = examinations;
    }

    public List<Counseling> getCounselings() {
        return counselings;
    }

    public void setCounselings(List<Counseling> counselings) {
        this.counselings = counselings;
    }

}
