package com.isa.pharmacy.users.controller.dto;

import com.isa.pharmacy.users.domain.User;

import java.util.List;

public class PatientDto {
    private User user;
    private List<String> allergicMedicines;
    private Integer loyaltyPoints;

    public PatientDto(){}

    public PatientDto(User user, List<String> allergicMedicines, Integer loyaltyPoints) {
        this.user = user;
        this.allergicMedicines = allergicMedicines;
        this.loyaltyPoints = loyaltyPoints;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<String> getAllergicMedicines() {
        return allergicMedicines;
    }

    public void setAllergicMedicines(List<String> allergicMedicines) {
        this.allergicMedicines = allergicMedicines;
    }

    public Integer getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(Integer loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }
}
