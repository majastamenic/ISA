package com.isa.pharmacy.controller.mapping;

import com.isa.pharmacy.controller.dto.CounselingDto;
import com.isa.pharmacy.domain.Counseling;
import com.isa.pharmacy.domain.Profile.Pharmacist;

public class CounselingMapper {

    public static Counseling mapCounselingDtoToCounseling(CounselingDto counselingDto, Pharmacist pharmacist) {
        Counseling counseling = new Counseling();
        counseling.setCounselingStatus(counselingDto.getCounselingStatus());
        counseling.setPatientCame(counselingDto.isPatientCame());
        counseling.setReport(counselingDto.getReport());
        counseling.setSchedule(counselingDto.getSchedule());
        counseling.setPatient(counselingDto.getPatient());
        counseling.setPharmacist(pharmacist);
        return counseling;
    }

    public static CounselingDto mapCounselingToCounselingDto(Counseling counseling) {
        CounselingDto counselingDto = new CounselingDto();
        counselingDto.setCounselingStatus(counseling.getCounselingStatus());
        counselingDto.setPatientCame(counseling.isPatientCame());
        counselingDto.setReport(counseling.getReport());
        counselingDto.setSchedule(counseling.getSchedule());
        counselingDto.setPatient(counseling.getPatient());
        counselingDto.setEmail(counseling.getPharmacist().getUser().getEmail());
        return counselingDto;
    }
}
