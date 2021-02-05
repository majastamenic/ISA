package com.isa.pharmacy.service;

import com.isa.pharmacy.controller.dto.CounselingDto;
import com.isa.pharmacy.controller.dto.PatientDto;
import com.isa.pharmacy.controller.exception.AlreadyExistsException;
import com.isa.pharmacy.controller.mapping.CounselingMapper;
import com.isa.pharmacy.controller.mapping.PatientMapper;
import com.isa.pharmacy.domain.Counseling;
import com.isa.pharmacy.users.domain.Pharmacist;
import com.isa.pharmacy.repository.CounselingRepository;
import com.isa.pharmacy.users.service.PharmacistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CounselingService {
    @Autowired
    private CounselingRepository counselingRepository;
    @Autowired
    private ScheduleService scheduleService;
    @Autowired
    private ReportService reportService;
    @Autowired
    private PharmacistService pharmacistService;

    public Counseling save(Counseling counseling) {
        if(counseling.getSchedule().getStartDate().equals(counseling.getSchedule().getEndDate())){
            scheduleService.save(counseling.getSchedule());
            reportService.save(counseling.getReport());
            return counselingRepository.save(counseling);
        }
        throw new AlreadyExistsException("Start date and end date must be on a same date");
    }

    public List<Counseling> getAll(){ return counselingRepository.findAll(); }

    public List<CounselingDto> getAllByPharmacist(Pharmacist pharmacist) {
        List<Counseling> counselings = counselingRepository.findByPharmacist(pharmacist);
        List<CounselingDto> counselingDtos = new ArrayList<>();
        for(Counseling c : counselings){
            PatientDto patientDto = PatientMapper.mapPatientToPatientDto(c.getPatient());
            CounselingDto counselingDto = CounselingMapper.mapCounselingToCounselingDto(c, patientDto);
            counselingDtos.add(counselingDto);
        }
        return counselingDtos;
    }


    public Counseling update(Counseling c) {
        Counseling counseling = counselingRepository.findCounselingById(c.getId());
        if(counseling != null){
            counseling.setReport(reportService.update(c.getReport()));
            counseling.setPatientCame(c.isPatientCame());
            counseling.setCounselingStatus(c.getCounselingStatus());
            counselingRepository.save(counseling);
        }
        return counseling;
    }
}
