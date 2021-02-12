package com.isa.pharmacy.domain;

import com.isa.pharmacy.domain.enums.LoyaltyGroupType;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class LoyaltyGroup implements Serializable {
    private static final long serialVersionUID = -7292156935382744908L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
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
