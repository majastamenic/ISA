package com.isa.pharmacy.scheduling.service.interfaces;

import com.isa.pharmacy.controller.dto.WorkScheduleDto;
import com.isa.pharmacy.controller.dto.WorkSchedulePharmacyDto;
import com.isa.pharmacy.scheduling.domain.WorkSchedule;

import java.util.Date;
import java.util.List;

public interface IWorkScheduleService {
     List<WorkScheduleDto> getAll();

     WorkSchedule getById(Long id);

     WorkSchedule save(WorkSchedule ws);

     boolean isEmployeeWorking(List<WorkSchedule> wsList, Date eagerDate);

     List<WorkSchedulePharmacyDto> getWorkScheduleByDermatologist(String email);

     List<WorkSchedulePharmacyDto> getWorkScheduleByPharmacist(String email);
}
