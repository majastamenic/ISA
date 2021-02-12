package com.isa.pharmacy.controller.mapping;

import com.isa.pharmacy.controller.dto.ExamDermatologistDto;
import com.isa.pharmacy.controller.dto.ExaminationCreateDto;
import com.isa.pharmacy.controller.dto.ExaminationUpcomingDto;
import com.isa.pharmacy.domain.Examination;
import com.isa.pharmacy.domain.Pharmacy;
import com.isa.pharmacy.domain.Prescription;
import com.isa.pharmacy.scheduling.domain.Schedule;
import com.isa.pharmacy.users.controller.dto.PatientDto;
import com.isa.pharmacy.users.controller.mapping.UserMapper;
import com.isa.pharmacy.users.domain.Dermatologist;
import com.isa.pharmacy.users.domain.Patient;

import java.util.ArrayList;
import java.util.List;

public class ExaminationMapper {

    public static ExaminationUpcomingDto mapExaminationToExaminationUpcomingDto(Examination exam){
        ExaminationUpcomingDto freeExam = new ExaminationUpcomingDto();
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
        examDermatologistDto.setPharmacyName(examination.getPharmacy().getName());
        examDermatologistDto.setPrice(examination.getPrice());
        examDermatologistDto.setPatientCame(examination.getPatientCame());
        return examDermatologistDto;
    }

    public static Examination mapExaminationDtoToExamination(ExamDermatologistDto examinationDto, Dermatologist dermatologist, Patient patient, Pharmacy pharmacy, Prescription prescription, Schedule schedule){
        Examination examination = new Examination();
        examination.setId(examinationDto.getId());
        examination.setDermatologist(dermatologist);
        examination.setPatient(patient);
        examination.setSchedule(schedule);
        examination.setPrescription(PrescriptionMapper.mapPrescriptionDtoToPrescription(examinationDto.getPrescription(), prescription));
        examination.setPharmacy(pharmacy);
        examination.setPrice(examinationDto.getPrice());
        examination.setPatientCame(examinationDto.getPatientCame());
        return examination;
    }

    public static List<ExaminationUpcomingDto> mapExaminationListToExaminationUpcomingDto(List<Examination> examinations) {
        List<ExaminationUpcomingDto> freeExaminations = new ArrayList<>();
        for (Examination exam : examinations)
            freeExaminations.add(mapExaminationToExaminationUpcomingDto(exam));
        return freeExaminations;
    }


}
