package com.isa.pharmacy.controller.mapping;

import com.isa.pharmacy.controller.dto.WorkScheduleDto;
import com.isa.pharmacy.domain.WorkSchedule;

public class WorkScheduleMapper {
    public static WorkScheduleDto mapWorkScheduleToWorkScheduleDto (WorkSchedule workSchedule){
        WorkScheduleDto workScheduleDto = new WorkScheduleDto();
        workScheduleDto.setId(workSchedule.getId());
        workScheduleDto.setEndDate(workSchedule.getEndDate());
        workScheduleDto.setEndTime(workSchedule.getEndTime());
        workScheduleDto.setStartDate(workSchedule.getStartDate());
        workScheduleDto.setStartTime(workSchedule.getStartTime());
        return workScheduleDto;

    }
}
