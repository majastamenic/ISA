package com.isa.pharmacy.service;

import com.isa.pharmacy.domain.Counseling;
import com.isa.pharmacy.domain.Report;
import com.isa.pharmacy.repository.CounselingRepository;
import com.isa.pharmacy.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CounselingService {
    @Autowired
    private CounselingRepository counselingRepository;
    @Autowired
    private ScheduleService scheduleService;
    @Autowired
    private ReportService reportService;

    public Counseling save(Counseling counseling) {
        if(counseling.isDone() != true){ counseling.setDone(false);}
        scheduleService.save(counseling.getSchedule());
        reportService.save(counseling.getReport());
        return counselingRepository.save(counseling);
    }

    public List<Counseling> getAll(){ return counselingRepository.findAll(); }

    public Counseling update(Counseling c) {
        Counseling counseling = counselingRepository.findCounselingById(c.getId());
        counseling.setReport(reportService.update(c.getReport()));
        counseling.setDone(c.isDone());
        counselingRepository.save(counseling);
        return counseling;
    }
}
