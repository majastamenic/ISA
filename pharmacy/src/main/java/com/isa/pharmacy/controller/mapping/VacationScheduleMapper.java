package com.isa.pharmacy.controller.mapping;

import com.isa.pharmacy.controller.dto.VacationScheduleDto;
import com.isa.pharmacy.scheduling.domain.VacationSchedule;

public class VacationScheduleMapper {

    public static VacationScheduleDto mapVacationScheduleToVacationScheduleDto(VacationSchedule vacationSchedule){
        VacationScheduleDto vacationScheduleDto = new VacationScheduleDto();
        vacationScheduleDto.setId(vacationSchedule.getId());
        vacationScheduleDto.setStartDate(vacationSchedule.getStartDate());
        vacationScheduleDto.setEndDate(vacationSchedule.getEndDate());
        return vacationScheduleDto;
    }
}
