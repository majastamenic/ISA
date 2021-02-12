package com.isa.pharmacy.service;

import com.isa.pharmacy.controller.exception.BadRequestException;
import com.isa.pharmacy.controller.exception.NotFoundException;
import com.isa.pharmacy.domain.LoyaltyGroup;
import com.isa.pharmacy.domain.enums.LoyaltyGroupType;
import com.isa.pharmacy.repository.LoyaltyGroupRepository;
import com.isa.pharmacy.service.interfaces.ILoyaltyGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoyaltyGroupService implements ILoyaltyGroupService {
    @Autowired
    private LoyaltyGroupRepository loyaltyGroupRepository;

    public int getLoyaltyPoints(LoyaltyGroupType type){
        LoyaltyGroup loyaltyGroup = loyaltyGroupRepository.findLoyaltyGroupByType(type);
        if(loyaltyGroup == null)
            throw new NotFoundException("Loyalty group doesn't exists.");
        return loyaltyGroup.getPoints();
    }

    public void updateLoyaltyPoints(LoyaltyGroup loyaltyGroup){
        if(loyaltyGroup.getPoints()<0)
            throw new BadRequestException("Loyalty points must must be greater than zero");
        LoyaltyGroup dbLoyaltyGroup = loyaltyGroupRepository.findLoyaltyGroupByType(loyaltyGroup.getType());
        if(dbLoyaltyGroup == null)
            throw new NotFoundException("Loyalty group doesn't exists.");
        LoyaltyGroup dbRegular = loyaltyGroupRepository.findLoyaltyGroupByType(LoyaltyGroupType.REGULAR);
        LoyaltyGroup dbSilver = loyaltyGroupRepository.findLoyaltyGroupByType(LoyaltyGroupType.SILVER);
        LoyaltyGroup dbGold = loyaltyGroupRepository.findLoyaltyGroupByType(LoyaltyGroupType.GOLD);

        if(dbLoyaltyGroup.getType().equals(LoyaltyGroupType.REGULAR) && loyaltyGroup.getPoints()>dbSilver.getPoints())
            throw new BadRequestException("Regular points must be less than silver points");
        if(dbLoyaltyGroup.getType().equals(LoyaltyGroupType.SILVER) && loyaltyGroup.getPoints()>dbGold.getPoints() || loyaltyGroup.getPoints()<dbRegular.getPoints())
            throw new BadRequestException("Silver points must be less than gold points and greater than regular.");
        if(dbLoyaltyGroup.getType().equals(LoyaltyGroupType.GOLD) && loyaltyGroup.getPoints()<dbSilver.getPoints())
            throw new BadRequestException("Gold points must be greater than silver points.");

        dbLoyaltyGroup.setPoints(loyaltyGroup.getPoints());
        loyaltyGroupRepository.save(dbLoyaltyGroup);
    }

    public String getLoyaltyGroupByPoints(int points){
        LoyaltyGroup eagerGroup = new LoyaltyGroup();
        boolean firstPass = true;
        int minPoints = 0;
        for(LoyaltyGroup group : getUserLoyaltyCategories()){
            if(firstPass){
                firstPass = false;
                eagerGroup = group;
                minPoints = group.getPoints();
            }
            if(group.getPoints() <= points && group.getPoints() <= eagerGroup.getPoints())
                eagerGroup = group;
        }
        if(points < minPoints)
            return "Not categorised";
        return eagerGroup.getType().name();
    }

    public List<LoyaltyGroup> getUserLoyaltyCategories(){
        List<LoyaltyGroup> categories = new ArrayList<>();
        List<LoyaltyGroup> loyaltyGroups = loyaltyGroupRepository.findAll();
        if(loyaltyGroups.isEmpty())
            throw new NotFoundException("There is no loyalty group.");
        for(LoyaltyGroup group : loyaltyGroups){
            if(group.getType() != LoyaltyGroupType.EXAMINATION && group.getType() != LoyaltyGroupType.COUNSELING)
                categories.add(group);
        }
        return categories;
    }
}
