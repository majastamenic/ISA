package com.isa.pharmacy.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Patient extends User{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String fileCode;
    @OneToMany
    private List<Counseling> counselings;

    public Patient(){}

    public Patient(Long id, String email, String password, String name, String surname, String address, String city, String country, String phone, Long id1, String fileCode, List<Counseling> counselings) {
        super(id, email, password, name, surname, address, city, country, phone);
        this.id = id1;
        this.fileCode = fileCode;
        this.counselings = counselings;
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

    public String getFileCode() {
        return fileCode;
    }

    public void setFileCode(String fileCode) {
        this.fileCode = fileCode;
    }
}
