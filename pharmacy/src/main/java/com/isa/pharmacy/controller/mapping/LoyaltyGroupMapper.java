package com.isa.pharmacy.controller.mapping;

import com.isa.pharmacy.controller.dto.LoyaltyGroupDto;
import com.isa.pharmacy.domain.LoyaltyGroup;

public class LoyaltyGroupMapper {
    public static LoyaltyGroup mapLoyaltyGroupDtoToLoyaltyGroup(LoyaltyGroupDto loyaltyGroupDto) {
        LoyaltyGroup loyaltyGroup = new LoyaltyGroup();
        loyaltyGroup.setPoints(loyaltyGroupDto.getPoints());
        loyaltyGroup.setType(loyaltyGroupDto.getType());
        return loyaltyGroup;
    }
}
