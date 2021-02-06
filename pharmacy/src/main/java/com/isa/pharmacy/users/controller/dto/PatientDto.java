package com.isa.pharmacy.users.controller.dto;

import com.isa.pharmacy.controller.dto.AllergyDto;
import com.isa.pharmacy.users.domain.User;

import java.util.List;

public class PatientDto {
    private User user;
    private List<AllergyDto> allergicMedicines;

    public PatientDto(){}

    public PatientDto(User user, List<AllergyDto> allergicMedicines) {
        this.user = user;
        this.allergicMedicines = allergicMedicines;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<AllergyDto> getAllergicMedicines() {
        return allergicMedicines;
    }

    public void setAllergicMedicines(List<AllergyDto> allergicMedicines) {
        this.allergicMedicines = allergicMedicines;
    }
}
