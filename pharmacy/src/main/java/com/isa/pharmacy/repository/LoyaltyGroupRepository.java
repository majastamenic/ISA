package com.isa.pharmacy.repository;

import com.isa.pharmacy.domain.LoyaltyGroup;
import com.isa.pharmacy.domain.enums.LoyaltyGroupType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoyaltyGroupRepository extends JpaRepository<LoyaltyGroup, Long> {
    LoyaltyGroup findLoyaltyGroupByType(LoyaltyGroupType loyaltyGroupType);
}
