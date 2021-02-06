package com.isa.pharmacy.controller;

import com.isa.pharmacy.controller.dto.LoyaltyGroupDto;
import com.isa.pharmacy.controller.mapping.LoyaltyGroupMapper;
import com.isa.pharmacy.domain.enums.LoyaltyGroupType;
import com.isa.pharmacy.service.LoyaltyGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loyaltyGroup")
@CrossOrigin(value = "http://localhost:4200")
public class LoyaltyGroupController {
    @Autowired
    private LoyaltyGroupService loyaltyGroupService;

    @GetMapping("/{type}")
    public int getLoyaltyPoints(@PathVariable LoyaltyGroupType type){
        return loyaltyGroupService.getLoyaltyPoints(type);
    }

    @PutMapping
    public void updateLoyaltyPoints(@RequestBody LoyaltyGroupDto loyaltyGroupDto){
        loyaltyGroupService.updateLoyaltyPoints(LoyaltyGroupMapper.mapLoyaltyGroupDtoToLoyaltyGroup(loyaltyGroupDto));
    }
}
