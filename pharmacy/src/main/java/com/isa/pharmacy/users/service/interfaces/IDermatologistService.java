package com.isa.pharmacy.users.service.interfaces;

import com.isa.pharmacy.controller.dto.VacationScheduleDto;
import com.isa.pharmacy.users.domain.Dermatologist;

import java.util.List;

public interface IDermatologistService {
     void delete(Dermatologist dermatologist);

     Dermatologist save(Dermatologist dermatologist);

     List<Dermatologist> getAll();

     Dermatologist update(Dermatologist d);

     Dermatologist registration(Dermatologist dermatologist);

     Dermatologist findUserByEmail(String email);

     boolean checkVacationTerm(VacationScheduleDto vacationScheduleDto, String email);
}
