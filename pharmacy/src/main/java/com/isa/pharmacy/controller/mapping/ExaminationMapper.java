package com.isa.pharmacy.controller.mapping;

import com.isa.pharmacy.controller.dto.FreeExaminationDto;
import com.isa.pharmacy.domain.Examination;

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
}
