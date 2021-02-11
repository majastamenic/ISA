package com.isa.pharmacy.service;

import com.isa.pharmacy.controller.exception.NotFoundException;
import com.isa.pharmacy.domain.LoyaltyGroup;
import com.isa.pharmacy.domain.enums.LoyaltyGroupType;
import com.isa.pharmacy.repository.LoyaltyGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public String getLoyaltyGroupByPoints(int points){
        LoyaltyGroup eagerGroup = new LoyaltyGroup();
        boolean firstPass = true;
        for(LoyaltyGroup group : getUserLoyaltyCategories()){
            if(firstPass){
                firstPass = false;
                eagerGroup = group;
            }
            if(group.getPoints() <= points && group.getPoints() <= eagerGroup.getPoints())
                eagerGroup = group;
        }
        if(eagerGroup == null)
            return "Not categorised";
        return eagerGroup.getType().name();
    }

    public List<LoyaltyGroup> getUserLoyaltyCategories(){
        List<LoyaltyGroup> categories = new ArrayList<>();
        for(LoyaltyGroup group : loyaltyGroupRepository.findAll()){
            if(group.getType() != LoyaltyGroupType.EXAMINATION && group.getType() != LoyaltyGroupType.COUNSELING)
                categories.add(group);
        }
        return categories;
    }
}
