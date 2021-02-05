package com.isa.pharmacy.controller.mapping;

import com.isa.pharmacy.controller.dto.CounselingDto;
import com.isa.pharmacy.controller.dto.PatientDto;
import com.isa.pharmacy.domain.Counseling;
import com.isa.pharmacy.domain.Profile.Patient;
import com.isa.pharmacy.domain.Profile.Pharmacist;

public class CounselingMapper {

    public static Counseling mapCounselingDtoToCounseling(CounselingDto counselingDto, Pharmacist pharmacist, Patient patient) {
        Counseling counseling = new Counseling();
        counseling.setId(counselingDto.getId());
        counseling.setCounselingStatus(counselingDto.getCounselingStatus());
        counseling.setPatientCame(counselingDto.isPatientCame());
        counseling.setReport(counselingDto.getReport());
        counseling.setSchedule(counselingDto.getSchedule());
        counseling.setPatient(patient);
        counseling.setPharmacist(pharmacist);
        return counseling;
    }

    public static CounselingDto mapCounselingToCounselingDto(Counseling counseling, PatientDto patientDto) {
        CounselingDto counselingDto = new CounselingDto();
        counselingDto.setId(counseling.getId());
        counselingDto.setCounselingStatus(counseling.getCounselingStatus());
        counselingDto.setPatientCame(counseling.isPatientCame());
        counselingDto.setReport(counseling.getReport());
        counselingDto.setSchedule(counseling.getSchedule());
        counselingDto.setPatientDto(patientDto);
        counselingDto.setEmail(counseling.getPharmacist().getUser().getEmail());
        return counselingDto;
    }
}
