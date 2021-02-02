package com.isa.pharmacy.service;

import com.isa.pharmacy.controller.exception.AlreadyExistsException;
import com.isa.pharmacy.domain.Counseling;
import com.isa.pharmacy.domain.Profile.Pharmacist;
import com.isa.pharmacy.domain.Report;
import com.isa.pharmacy.domain.Schedule;
import com.isa.pharmacy.domain.WorkSchedule;
import com.isa.pharmacy.domain.enums.ExaminationAndCounselingStatus;
import com.isa.pharmacy.repository.CounselingRepository;
import com.isa.pharmacy.repository.ScheduleRepository;
import org.hibernate.dialect.Sybase11Dialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
        throw new AlreadyExistsException(String.format("Start date and end date must be on same date"));
    }

    public List<Counseling> getAll(){ return counselingRepository.findAll(); }

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

    /*public Pharmacist compareWorkScheduleAndCounseling(Counseling counseling){
        WorkSchedule workSchedule = pharmacistService.getWorkScheduleByPharmacist(counseling.getPharmacist().getId());
        Schedule counselingSchedule = counseling.getSchedule();
        if(workSchedule.getSchedule().getStartDate().before(counselingSchedule.getStartDate()) && workSchedule.getSchedule().)
        return null;
    }*/
}
