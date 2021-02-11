package com.isa.pharmacy.controller.mapping;

import com.isa.pharmacy.controller.dto.CounselingCreateDto;
import com.isa.pharmacy.controller.dto.CounselingDto;
import com.isa.pharmacy.controller.dto.CounselingFullDto;
import com.isa.pharmacy.domain.Counseling;
import com.isa.pharmacy.users.controller.mapping.PatientMapper;
import com.isa.pharmacy.users.controller.mapping.PharmacistMapper;

import java.util.ArrayList;
import java.util.List;

public class CounselingMapper {

    public static Counseling mapCounselingDtoToCounseling(CounselingDto counselingDto) {
        Counseling counseling = new Counseling();
        counseling.setId(counselingDto.getId());
        counseling.setPatientCame(counselingDto.getPatientCame());
        counseling.setSchedule(counselingDto.getSchedule());
        counseling.setPatient(PatientMapper.mapPatientDtoToPatient(counselingDto.getPatientDto()));
        return counseling;
    }

    public static CounselingDto mapCounselingToCounselingDto(Counseling counseling) {
        CounselingDto counselingDto = new CounselingDto();
        counselingDto.setId(counseling.getId());
        counselingDto.setPatientCame(counseling.getPatientCame());
        counselingDto.setSchedule(counseling.getSchedule());
        counselingDto.setPatientDto(PatientMapper.mapPatientToPatientDto(counseling.getPatient()));
        counselingDto.setEmail(counseling.getPharmacist().getUser().getEmail());
        return counselingDto;
    }

    public static List<CounselingDto> mapListCounselingToCounselingDto(List<Counseling> counselings){
        List<CounselingDto> mappedCounselings = new ArrayList<>();
        for(Counseling c : counselings)
            mappedCounselings.add(mapCounselingToCounselingDto(c));
        return mappedCounselings;
    }

    public static CounselingFullDto mapCounselingToCounselingFullDto(Counseling counseling){
        return new CounselingFullDto(counseling.getId(),
                PharmacistMapper.mapPharmacistToPharmacistDto(counseling.getPharmacist()),
                PatientMapper.mapPatientToPatientDto(counseling.getPatient()),
                WorkScheduleMapper.mapScheduleToWorkScheduleDto(counseling.getSchedule()),
                counseling.getReport(),
                counseling.getPatientCame());
    }

    public static Counseling mapCounselingFullDtoToCounseling(CounselingFullDto counselingDto){
        return new Counseling(
                counselingDto.getId(),
                PharmacistMapper.mapPharmacistDtoToPharmacist(counselingDto.getPharmacist()),
                PatientMapper.mapPatientDtoToPatient(counselingDto.getPatient()),
                WorkScheduleMapper.mapWorkScheduleDtoToSchedule(counselingDto.getSchedule()),
                counselingDto.getReport(),
                counselingDto.getPatientCame());
    }

    public static List<CounselingFullDto> mapListCounselingToCounsellingFullDto(List<Counseling> counselings){
        List<CounselingFullDto> mappedCounselings = new ArrayList<>();
        for(Counseling c : counselings)
            mappedCounselings.add(mapCounselingToCounselingFullDto(c));
        return  mappedCounselings;
    }

    public static Counseling mapCounselingCreateDtoToCounseling(CounselingCreateDto counselingCreateDto){
        Counseling counseling = new Counseling();
        counseling.setId(counselingCreateDto.getId());
        counseling.setSchedule(WorkScheduleMapper.mapWorkScheduleDtoToSchedule(counselingCreateDto.getSchedule()));
        return counseling;
    }
}