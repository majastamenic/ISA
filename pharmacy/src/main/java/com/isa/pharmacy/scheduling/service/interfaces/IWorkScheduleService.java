package com.isa.pharmacy.scheduling.service.interfaces;

import com.isa.pharmacy.controller.dto.*;
import com.isa.pharmacy.scheduling.domain.WorkSchedule;
import com.isa.pharmacy.users.domain.Dermatologist;
import com.isa.pharmacy.users.domain.Pharmacist;

import java.util.Date;
import java.util.List;

public interface IWorkScheduleService {
     List<WorkScheduleDto> getAll();

     WorkSchedule getById(Long id);

     WorkSchedule save(WorkSchedule ws);

     boolean isEmployeeWorking(List<WorkSchedule> wsList, Date eagerDate);

     List<WorkSchedulePharmacyDto> getWorkScheduleByDermatologist(String email);

     List<WorkSchedulePharmacyDto> getWorkScheduleByPharmacist(String email);

     boolean pharmacistIsWorking(Pharmacist pharmacist, CounselingCreateDto counselingDto);

     boolean compareDateWithWorkTime(List<WorkSchedulePharmacyDto> pharmacistWork, Date requiredStartDate, Date requiredEndDate);

     boolean dermatologistIsWorking(ExaminationCreateDto examinationCreateDto, Dermatologist dermatologist, String pharmacyName);
}
