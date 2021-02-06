package com.isa.pharmacy.service;

import com.isa.pharmacy.controller.exception.NotFoundException;
import com.isa.pharmacy.domain.LoyaltyGroup;
import com.isa.pharmacy.domain.enums.LoyaltyGroupType;
import com.isa.pharmacy.repository.LoyaltyGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoyaltyGroupService {
    @Autowired
    private LoyaltyGroupRepository loyaltyGroupRepository;

    public int getLoyaltyPoints(LoyaltyGroupType type){
        LoyaltyGroup loyaltyGroup = loyaltyGroupRepository.findLoyaltyGroupByType(type);
        return loyaltyGroup.getPoints();
    }

    public void updateLoyaltyPoints(LoyaltyGroup loyaltyGroup){
        LoyaltyGroup dbLoyaltyGroup = loyaltyGroupRepository.findLoyaltyGroupByType(loyaltyGroup.getType());
        if(dbLoyaltyGroup == null)
            throw new NotFoundException("Loyalty group doesn't exists.");
        //Provera 
        dbLoyaltyGroup.setPoints(loyaltyGroup.getPoints());
        loyaltyGroupRepository.save(dbLoyaltyGroup);
    }
}
