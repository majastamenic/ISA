package com.isa.pharmacy.users.service.interfaces;

import com.isa.pharmacy.controller.dto.DateTimeDto;
import com.isa.pharmacy.controller.dto.PharmacistByPharmacyDto;
import com.isa.pharmacy.controller.dto.VacationScheduleDto;
import com.isa.pharmacy.scheduling.domain.VacationSchedule;
import com.isa.pharmacy.scheduling.domain.WorkSchedule;
import com.isa.pharmacy.users.controller.dto.CreatePharmacistDto;
import com.isa.pharmacy.users.domain.Pharmacist;

import java.util.List;

public interface IPharmacistService {
     CreatePharmacistDto save(CreatePharmacistDto p);

     List<Pharmacist> getAll();

     Long deletePharmacistById(Long id);

     Pharmacist update(Pharmacist p);

     List<VacationSchedule> getVacationScheduleByPharmacist(Long id);

     Pharmacist findUserByEmail(String email);

     List<PharmacistByPharmacyDto> findPharmacistsByPharmacyId(Long id);

     List<Pharmacist> getFreePharmacistByPharmacyAndDate(String pharmacyName, DateTimeDto date);

     List<Pharmacist> getFreePharmacistByDate(DateTimeDto date);

     boolean checkVacationTerm(VacationScheduleDto vacationScheduleDto, String email);

      List<WorkSchedule> getWorkScheduleByPharmacistEmail(String email);

    List<PharmacistByPharmacyDto> getPharmacistByPharmacyName(String name);
}
