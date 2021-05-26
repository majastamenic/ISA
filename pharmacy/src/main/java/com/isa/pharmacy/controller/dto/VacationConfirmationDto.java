package com.isa.pharmacy.controller.dto;

public class VacationConfirmationDto {
    private String confirmed;
    private String message;
    private Long vacationScheduleId;

    public VacationConfirmationDto(String confirmed, String message, Long vacationScheduleId) {
        this.confirmed = confirmed;
        this.message = message;
        this.vacationScheduleId = vacationScheduleId;
    }

    public VacationConfirmationDto() {
    }

    public String getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(String confirmed) {
        this.confirmed = confirmed;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getVacationScheduleId() {
        return vacationScheduleId;
    }

    public void setVacationScheduleId(Long vacationScheduleId) {
        this.vacationScheduleId = vacationScheduleId;
    }
}
