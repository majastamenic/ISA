package com.isa.pharmacy.controller;

import com.isa.pharmacy.controller.dto.LoyaltyGroupDto;
import com.isa.pharmacy.controller.mapping.LoyaltyGroupMapper;
import com.isa.pharmacy.domain.enums.LoyaltyGroupType;
import com.isa.pharmacy.service.interfaces.ILoyaltyGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loyaltyGroup")
@CrossOrigin(origins ={ "http://localhost:4200", "https://pharmacy-25-frontend.herokuapp.com"})
public class LoyaltyGroupController {
    @Autowired
    private ILoyaltyGroupService loyaltyGroupService;

    @GetMapping("/{type}")
    public int getLoyaltyPoints(@PathVariable LoyaltyGroupType type){
        return loyaltyGroupService.getLoyaltyPoints(type);
    }

    @GetMapping("/category")
    public String getCategoryByPoints(@RequestParam("points") int points){
        return loyaltyGroupService.getLoyaltyGroupByPoints(points);
    }

    @PutMapping
    public void updateLoyaltyPoints(@RequestBody LoyaltyGroupDto loyaltyGroupDto){
        loyaltyGroupService.updateLoyaltyPoints(LoyaltyGroupMapper.mapLoyaltyGroupDtoToLoyaltyGroup(loyaltyGroupDto));
    }
}
