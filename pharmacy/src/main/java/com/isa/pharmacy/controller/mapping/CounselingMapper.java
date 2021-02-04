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
}
