package com.isa.pharmacy.service.interfaces;

import com.isa.pharmacy.domain.LoyaltyGroup;
import com.isa.pharmacy.domain.enums.LoyaltyGroupType;

import java.util.List;

public interface ILoyaltyGroupService {
     int getLoyaltyPoints(LoyaltyGroupType type);

     void updateLoyaltyPoints(LoyaltyGroup loyaltyGroup);

     String getLoyaltyGroupByPoints(int points);

     List<LoyaltyGroup> getUserLoyaltyCategories();
}
