package com.isa.pharmacy.users.service.interfaces;

import com.isa.pharmacy.controller.dto.DermatologistDto;
import com.isa.pharmacy.controller.dto.VacationScheduleDto;
import com.isa.pharmacy.users.controller.dto.DermatologistExaminationDto;
import com.isa.pharmacy.users.domain.Dermatologist;

import java.util.List;

public interface IDermatologistService {
     void delete(Dermatologist dermatologist);

     Dermatologist save(Dermatologist dermatologist);

     List<Dermatologist> getAll();

     Dermatologist update(Dermatologist d);

     Dermatologist registration(Dermatologist dermatologist);

     List<DermatologistDto> dermatologistListByPharmacyName(String name);

     Dermatologist findUserByEmail(String email);

     boolean checkVacationTerm(VacationScheduleDto vacationScheduleDto, String email);

     void deleteFromPharmacy(String email, String adminEmail);

    List<DermatologistDto> dermatologistListByNameAndSurname(String name, String surname, String pharmacyName);

    List<DermatologistDto> dermatologistListByPharmacyAdmin(String adminEmail);

     void defineExamination(DermatologistExaminationDto dermatologistExaminationDto);
}
