package com.isa.pharmacy.controller.dto;

import com.isa.pharmacy.domain.enums.LoyaltyGroupType;

public class LoyaltyGroupDto {
    private LoyaltyGroupType type;
    private int points;

    public LoyaltyGroupDto(){}

    public LoyaltyGroupDto(LoyaltyGroupType type, int points) {
        this.type = type;
        this.points = points;
    }

    public LoyaltyGroupType getType() {
        return type;
    }

    public void setType(LoyaltyGroupType type) {
        this.type = type;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
