package com.isa.pharmacy.controller.mapping;

import com.isa.pharmacy.controller.dto.ExamDermatologistDto;
import com.isa.pharmacy.controller.dto.FreeExaminationDto;
import com.isa.pharmacy.domain.Examination;
import com.isa.pharmacy.domain.Pharmacy;
import com.isa.pharmacy.domain.Prescription;
import com.isa.pharmacy.users.controller.dto.PatientDto;
import com.isa.pharmacy.users.controller.mapping.UserMapper;
import com.isa.pharmacy.users.domain.Dermatologist;
import com.isa.pharmacy.users.domain.Patient;

public class ExaminationMapper {

    public static FreeExaminationDto mapExaminationToFreeExaminationDto(Examination exam){
        FreeExaminationDto freeExam = new FreeExaminationDto();
        freeExam.setId(exam.getId());
        freeExam.setPrice(exam.getPrice());
        freeExam.setPharmacy(PharmacyMapper.mapPharmacyToPharmacyDto(exam.getPharmacy()));
        freeExam.setDermatologist(UserMapper.mapUserToUserDto(exam.getDermatologist().getUser()));
        freeExam.setSchedule(WorkScheduleMapper.mapScheduleToWorkScheduleDto(exam.getSchedule()));
        return freeExam;
    }

    public static ExamDermatologistDto mapExaminationToExaminationDto(Examination examination, PatientDto patientDto){
        ExamDermatologistDto examDermatologistDto = new ExamDermatologistDto();
        examDermatologistDto.setId(examination.getId());
        examDermatologistDto.setEmail(examination.getDermatologist().getUser().getEmail());
        examDermatologistDto.setPatientDto(patientDto);
        examDermatologistDto.setSchedule(examination.getSchedule());
        //examDermatologistDto.setPrescription(PrescriptionMapper.mapPrescriptionToPrescriptionDto(examination.getPrescription()));
        examDermatologistDto.setPharmacyName(examination.getPharmacy().getName());
        examDermatologistDto.setPrice(examination.getPrice());
        examDermatologistDto.setPatientCame(examination.getPatientCame());
        return examDermatologistDto;
    }

    public static Examination mapExaminationDtoToExamination(ExamDermatologistDto examinationDto, Dermatologist dermatologist, Patient patient, Pharmacy pharmacy, Prescription prescription){
        Examination examination = new Examination();
        examination.setId(examinationDto.getId());
        examination.setDermatologist(dermatologist);
        examination.setPatient(patient);
        examination.setSchedule(examinationDto.getSchedule());
        examination.setPrescription(PrescriptionMapper.mapPrescriptionDtoToPrescription(examinationDto.getPrescription(), pharmacy, prescription));
        examination.setPharmacy(pharmacy);
        examination.setPrice(examinationDto.getPrice());
        examination.setPatientCame(examinationDto.getPatientCame());
        return examination;
    }
}
