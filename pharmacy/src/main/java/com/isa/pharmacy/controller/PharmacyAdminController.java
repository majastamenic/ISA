package com.isa.pharmacy.controller;
import com.isa.pharmacy.controller.dto.PharmacyAdminDto;
import com.isa.pharmacy.controller.mapping.PharmacyAdminMapper;
import com.isa.pharmacy.domain.Profile.PharmacyAdmin;
import com.isa.pharmacy.service.PharmacyAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/phadmin")
@CrossOrigin(value = "http://localhost:4200")
public class PharmacyAdminController {
    @Autowired
    private PharmacyAdminService pharmacyAdminService;

    @PostMapping
    public PharmacyAdminDto save(@RequestBody PharmacyAdminDto pharmacyAdminDto){
        PharmacyAdmin pharmacyAdmin = pharmacyAdminService.save(PharmacyAdminMapper.mapPharmacyAdminDtoToPharmacyAdmin(pharmacyAdminDto));
        return PharmacyAdminMapper.mapPharmacyAdminToPharmacyAdminDto(pharmacyAdmin);
    }

    @GetMapping
    public List<PharmacyAdmin> findAll() { return pharmacyAdminService.findAll(); }

    @PutMapping("/update")
    public PharmacyAdmin update (@RequestBody PharmacyAdmin pharmacyAdmin){ return pharmacyAdminService.updateAdmin(pharmacyAdmin);}

    @GetMapping("/{email}")
    public PharmacyAdminDto findPharmacyAdminByEmail(@PathVariable("email") String email){ return  pharmacyAdminService.findPharmacyAdminByEmail(email);}
}
