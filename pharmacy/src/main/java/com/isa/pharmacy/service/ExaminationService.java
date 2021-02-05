package com.isa.pharmacy.service;

import com.isa.pharmacy.controller.exception.NotFoundException;
import com.isa.pharmacy.domain.Counseling;
import com.isa.pharmacy.domain.Examination;
import com.isa.pharmacy.repository.ExaminationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExaminationService {

    @Autowired
    private ExaminationRepository examinationRepository;

    public void updateLoyaltyPoints(int loyaltyPoints){
        List<Examination> examinationList = examinationRepository.findAll();
        if(examinationList == null)
            throw new NotFoundException("There is no any counseling");
        for(Examination examination: examinationList){
            examination.setLoyaltyPoints(loyaltyPoints);
            examinationRepository.save(examination);
        }
    }

    public int getLoyaltyPoints(){
        //TODO: Kako uzeti 1 kad su svi isti?
       return examinationRepository.getOne(1l).getLoyaltyPoints();
    }
}
