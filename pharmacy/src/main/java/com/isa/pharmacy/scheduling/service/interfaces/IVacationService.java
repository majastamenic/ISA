package com.isa.pharmacy.scheduling.service.interfaces;

import com.isa.pharmacy.controller.dto.VacationConfirmationDto;
import com.isa.pharmacy.controller.dto.VacationScheduleDto;
import com.isa.pharmacy.scheduling.domain.VacationSchedule;

import java.util.Date;
import java.util.List;

public interface IVacationService {
     VacationSchedule save(VacationSchedule vs);

     List<VacationSchedule> getAll();

     boolean isEmployeeOnVacation(List<VacationSchedule> vacationList, Date eagerDate);

     List<VacationScheduleDto> getVacationScheduleByDermatologist(String email);

     List<VacationScheduleDto> getVacationScheduleByPharmacist(String email);

     boolean compareDateWithVacations(List<VacationScheduleDto> pharmacistVacations, Date requiredStartDate, Date requiredEndDate);

    List<VacationScheduleDto> getVacationScheduleDermatologists();

     List<VacationScheduleDto> getVacationSchedulePharmacists(String email);

    void confirmation(VacationConfirmationDto vacationSchedule);

    void confirmationPharmacist(VacationConfirmationDto vacationSchedule);
}
