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
    @Column
    private String verificationCode;

    public Patient(){}

    public Patient(long id, User user, List<Medicine> allergicMedicines, String verificationCode) {
        this.id = id;
        this.user = user;
        this.allergicMedicines = allergicMedicines;
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