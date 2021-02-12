package com.isa.pharmacy.controller.dto;

public class ExaminationCreateDto {
    private Long id;
    private Long oldExaminationId;
    private WorkScheduleDto schedule;

    public ExaminationCreateDto(){}

    public ExaminationCreateDto(Long id, Long oldExaminationId, WorkScheduleDto schedule) {
        this.id = id;
        this.oldExaminationId = oldExaminationId;
        this.schedule = schedule;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOldExaminationId() {
        return oldExaminationId;
    }

    public void setOldExaminationId(Long oldExaminationId) {
        this.oldExaminationId = oldExaminationId;
    }

    public WorkScheduleDto getSchedule() {
        return schedule;
    }

    public void setSchedule(WorkScheduleDto schedule) {
        this.schedule = schedule;
    }
}
