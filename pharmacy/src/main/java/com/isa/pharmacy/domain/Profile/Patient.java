package com.isa.pharmacy.domain.Profile;

import com.isa.pharmacy.domain.Counseling;
import com.isa.pharmacy.domain.Examination;
import com.isa.pharmacy.domain.Medicine;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table
public class Patient implements Serializable {
    private static final long serialVersionUID = -6792194469986787879L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne
    private User user;
    @OneToMany
    private List<Medicine> allergicMedicines;
    @OneToMany
    private List<Counseling> counselings;
    @OneToMany
    private List<Examination> examinations;
    @Column
    private String verificationCode;

    public Patient(){}

    public Patient(long id, User user, List<Medicine> allergicMedicines, List<Counseling> counselings, List<Examination> examinations, String verificationCode) {
        this.id = id;
        this.user = user;
        this.allergicMedicines = allergicMedicines;
        this.counselings = counselings;
        this.examinations = examinations;
        this.verificationCode = verificationCode;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Medicine> getAllergicMedicines() {
        return allergicMedicines;
    }

    public void setAllergicMedicines(List<Medicine> allergicMedicines) {
        this.allergicMedicines = allergicMedicines;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Counseling> getCounselings() {
        return counselings;
    }

    public void setCounselings(List<Counseling> counselings) {
        this.counselings = counselings;
    }

    public List<Examination> getExaminations() {
        return examinations;
    }

    public void setExaminations(List<Examination> examinations) {
        this.examinations = examinations;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public void addAllergy(Medicine medicine){
        if(!allergicMedicines.contains(medicine))
            allergicMedicines.add(medicine);
    }
}