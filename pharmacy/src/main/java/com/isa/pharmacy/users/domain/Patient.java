package com.isa.pharmacy.users.domain;

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
    @ElementCollection
    private List<String> allergicMedicines;
    @Column
    private String verificationCode;
    @Column
    private int loyaltyPoints;

    public Patient(){}

    public Patient(long id, User user, List<String> allergicMedicines, String verificationCode, int loyaltyPoints) {
        this.id = id;
        this.user = user;
        this.allergicMedicines = allergicMedicines;
        this.verificationCode = verificationCode;
        this.loyaltyPoints = loyaltyPoints;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<String> getAllergicMedicines() {
        return allergicMedicines;
    }

    public void setAllergicMedicines(List<String> allergicMedicines) {
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

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(int loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }

    public void addAllergy(String medicine){
        if(!allergicMedicines.contains(medicine))
            allergicMedicines.add(medicine);
    }
}