package com.isa.pharmacy.service.interfaces;

import com.isa.pharmacy.controller.dto.CounselingCreateDto;
import com.isa.pharmacy.controller.dto.CounselingDto;
import com.isa.pharmacy.domain.Counseling;
import com.isa.pharmacy.users.domain.Patient;
import com.isa.pharmacy.users.domain.Pharmacist;

import java.util.Date;
import java.util.List;

public interface ICounselingService {

     List<Counseling> getAll();

     Counseling getCounselingById(long id);

     List<Counseling> getCounselingByPharmacist(Pharmacist pharmacist);

     List<Counseling> getAllPatientsCounselings(String patientEmail);

     Counseling createCounseling(Counseling counseling);

     void cancelCounseling(Long counselingId);

     List<String> getPharmacistNameByPatient(Patient patient);

     boolean isPharmacistOccupied(Pharmacist pharmacist, Date eagerDate);

     CounselingDto updateCounseling(CounselingDto updateCounseling);

     boolean createCounselingByPharmacist(CounselingCreateDto counselingDto);

     boolean compareDateWithCounselingTerm(List<CounselingDto> pharmacistCounseling, Date requiredStartDate, Date requiredEndDate);

     List<CounselingDto> findCounselingByPatient(String email, String name, String surname);

}
