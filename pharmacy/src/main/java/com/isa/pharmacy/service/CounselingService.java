package com.isa.pharmacy.service;

import com.isa.pharmacy.controller.exception.AlreadyExistsException;
import com.isa.pharmacy.controller.exception.NotFoundException;
import com.isa.pharmacy.domain.Counseling;
import com.isa.pharmacy.domain.Profile.Pharmacist;
import com.isa.pharmacy.repository.CounselingRepository;
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

    public List<Counseling> getAllByPharmacist(Pharmacist pharmacist) {
        return counselingRepository.findByPharmacist(pharmacist);
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

    public void updateLoyaltyPoints(int loyaltyPoints){
        List<Counseling> counselingList = counselingRepository.findAll();
        if(counselingList == null)
            throw new NotFoundException("There is no any counseling");
        for(Counseling counseling: counselingList){
            counseling.setLoyaltyPoints(loyaltyPoints);
            counselingRepository.save(counseling);
        }
    }
}
