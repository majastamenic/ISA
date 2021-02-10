package com.isa.pharmacy.controller.mapping;

import com.isa.pharmacy.controller.dto.WorkScheduleDto;
import com.isa.pharmacy.controller.dto.WorkSchedulePharmacyDto;
import com.isa.pharmacy.scheduling.domain.Schedule;
import com.isa.pharmacy.scheduling.domain.WorkSchedule;

public class WorkScheduleMapper {
    public static WorkScheduleDto mapWorkScheduleToWorkScheduleDto (WorkSchedule workSchedule){
        WorkScheduleDto workScheduleDto = new WorkScheduleDto();
        workScheduleDto.setId(workSchedule.getId());
        workScheduleDto.setEndDate(workSchedule.getSchedule().getEndDate());
        workScheduleDto.setEndTime(workSchedule.getSchedule().getEndTime());
        workScheduleDto.setStartDate(workSchedule.getSchedule().getStartDate());
        workScheduleDto.setStartTime(workSchedule.getSchedule().getStartTime());
        return workScheduleDto;
    }

    public static WorkScheduleDto mapScheduleToWorkScheduleDto(Schedule schedule){
        WorkScheduleDto workScheduleDto = new WorkScheduleDto();
        workScheduleDto.setEndDate(schedule.getEndDate());
        workScheduleDto.setEndTime(schedule.getEndTime());
        workScheduleDto.setStartDate(schedule.getStartDate());
        workScheduleDto.setStartTime(schedule.getStartTime());
        return workScheduleDto;
    }

    public static Schedule mapWorkScheduleDtoToSchedule(WorkScheduleDto workScheduleDto) {
        Schedule schedule = new Schedule();
        schedule.setStartDate(workScheduleDto.getStartDate());
        schedule.setEndDate(workScheduleDto.getEndDate());
        schedule.setStartTime(workScheduleDto.getStartTime());
        schedule.setEndTime(workScheduleDto.getEndTime());
        return schedule;
    }

    public static WorkSchedulePharmacyDto mapWorkScheduleToWorkSchedulePharmacyDto(WorkSchedule workSchedule, String pharmacyName){
        WorkSchedulePharmacyDto workSchedulePharmacyDto = new WorkSchedulePharmacyDto();
        workSchedulePharmacyDto.setWorkScheduleDto(mapWorkScheduleToWorkScheduleDto(workSchedule));
        workSchedulePharmacyDto.setPharmacyName(pharmacyName);
        return workSchedulePharmacyDto;

    }
}
