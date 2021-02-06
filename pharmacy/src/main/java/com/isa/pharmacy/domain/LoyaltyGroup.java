package com.isa.pharmacy.domain;

import com.isa.pharmacy.domain.enums.LoyaltyGroupType;

import javax.persistence.*;

@Entity
public class LoyaltyGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private LoyaltyGroupType type;
    @Column
    private int points;

    public LoyaltyGroup(){}

    public LoyaltyGroup(Long id, LoyaltyGroupType type, int points) {
        this.id = id;
        this.type = type;
        this.points = points;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
