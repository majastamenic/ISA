package com.isa.pharmacy.users.controller.dto;

import com.isa.pharmacy.controller.dto.PharmacyDto;
import com.isa.pharmacy.controller.dto.WorkScheduleDto;
import com.isa.pharmacy.scheduling.domain.VacationSchedule;

import java.util.List;

public class PharmacistDto {
    private UserDto user;
    private PharmacyDto pharmacy;
    private WorkScheduleDto workSchedule;
    private List<VacationSchedule> vacationSchedules;

    public PharmacistDto() {}

    public PharmacistDto(UserDto user, PharmacyDto pharmacy, WorkScheduleDto workSchedule,
                         List<VacationSchedule> vacationSchedules) {
        this.user = user;
        this.pharmacy = pharmacy;
        this.workSchedule = workSchedule;
        this.vacationSchedules = vacationSchedules;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public PharmacyDto getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(PharmacyDto pharmacy) {
        this.pharmacy = pharmacy;
    }

    public WorkScheduleDto getWorkSchedule() {
        return workSchedule;
    }

    public void setWorkSchedule(WorkScheduleDto workSchedule) {
        this.workSchedule = workSchedule;
    }

    public List<VacationSchedule> getVacationSchedules() {
        return vacationSchedules;
    }

    public void setVacationSchedules(List<VacationSchedule> vacationSchedules) {
        this.vacationSchedules = vacationSchedules;
    }
}
