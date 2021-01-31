package com.isa.pharmacy.service;

import com.isa.pharmacy.domain.Counseling;
import com.isa.pharmacy.repository.CounselingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CounselingService {
    @Autowired
    private CounselingRepository counselingRepository;

    public Counseling save(Counseling counseling) { return counselingRepository.save(counseling); }

    public List<Counseling> getAll(){ return counselingRepository.findAll(); }

    public Counseling update(Counseling c) {
        Counseling counseling = counselingRepository.findCounselingById(c.getId());
        counseling.setReport(c.getReport());
        counselingRepository.save(counseling);
        return counseling;
    }
}
