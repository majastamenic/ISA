package com.isa.pharmacy.controller.mapping;

import com.isa.pharmacy.controller.dto.WorkScheduleDto;
import com.isa.pharmacy.scheduling.domain.Schedule;

public class ScheduleMapper {

    public static Schedule mapWorkScheduleDtoToSchedule(WorkScheduleDto workScheduleDto) {
        Schedule schedule = new Schedule();
        schedule.setStartDate(workScheduleDto.getStartDate());
        schedule.setEndDate(workScheduleDto.getEndDate());
        schedule.setStartTime(workScheduleDto.getStartTime());
        schedule.setEndTime(workScheduleDto.getEndTime());
        return schedule;
    }
}
