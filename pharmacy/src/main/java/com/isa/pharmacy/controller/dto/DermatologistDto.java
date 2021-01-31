package com.isa.pharmacy.controller.dto;

import com.isa.pharmacy.domain.Examination;
import com.isa.pharmacy.domain.Pharmacy;
import com.isa.pharmacy.domain.VacationSchedule;
import com.isa.pharmacy.domain.WorkSchedule;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

public class DermatologistDto {
    private String email;
    private String password;
    private String name;
    private String surname;
    private String address;
    private String city;
    private String country;
    private String phone;
    private List<Pharmacy> pharmacy;
    private List<Examination> examinations;
    private WorkSchedule workSchedule;
    private List<VacationSchedule> vacationSchedules;
}
