package com.isa.pharmacy.users.service.interfaces;

import com.isa.pharmacy.controller.dto.DateTimeDto;
import com.isa.pharmacy.controller.dto.PharmacistByPharmacyDto;
import com.isa.pharmacy.controller.exception.NotFoundException;
import com.isa.pharmacy.scheduling.DateManipulation;
import com.isa.pharmacy.scheduling.domain.VacationSchedule;
import com.isa.pharmacy.scheduling.domain.WorkSchedule;
import com.isa.pharmacy.users.controller.dto.CreatePharmacistDto;
import com.isa.pharmacy.users.controller.mapping.PharmacistMapper;
import com.isa.pharmacy.users.domain.Pharmacist;
import com.isa.pharmacy.users.domain.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

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
}
