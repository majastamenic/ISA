package com.isa.pharmacy.controller.mapping;

import com.isa.pharmacy.controller.dto.ExamDermatologistDto;
import com.isa.pharmacy.controller.dto.FreeExaminationDto;
import com.isa.pharmacy.controller.dto.PatientDto;
import com.isa.pharmacy.domain.Examination;

public class ExaminationMapper {

    public static FreeExaminationDto mapExaminationToFreeExaminationDto(Examination exam){
        FreeExaminationDto freeExam = new FreeExaminationDto();
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
        examDermatologistDto.setPrescription(PrescriptionMapper.mapPrescriptionToPrescriptionDto(examination.getPrescription()));
        examDermatologistDto.setPharmacyName(examination.getPharmacy().getName());
        examDermatologistDto.setPrice(examination.getPrice());
        examDermatologistDto.setPatientCame(examination.getPatientCame());
        return examDermatologistDto;
    }
}
