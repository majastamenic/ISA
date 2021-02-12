package com.isa.pharmacy.service.interfaces;

import com.isa.pharmacy.controller.dto.ExamDermatologistDto;
import com.isa.pharmacy.domain.*;
import com.isa.pharmacy.users.domain.Dermatologist;
import com.isa.pharmacy.users.domain.Patient;

import java.util.List;

public interface IExaminationService {

     Examination save(Examination examination);

     List<Examination> getAllFreeExaminationTerms();

     List<Examination> getFreeExaminationTermsByPharmacy(String pharmacyName);

     List<Examination> getExaminationByPatient(String email);

     void scheduleExamination(String patientEmail, Long examinationId);

     void cancelExamination(Long examinationId);

     List<ExamDermatologistDto> getAllByDermatologist(Dermatologist dermatologist);

     ExamDermatologistDto getById(long id);

     List<String> getDermatologistNameByPatient(Patient patient);

     ExamDermatologistDto updateExamination(ExamDermatologistDto updateExamination);

     List<Examination> getFreeExaminationsByDermatologist(String email);
}
