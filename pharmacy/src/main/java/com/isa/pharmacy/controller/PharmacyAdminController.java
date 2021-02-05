package com.isa.pharmacy.controller;
import com.isa.pharmacy.controller.dto.CreatePhAdminDto;
import com.isa.pharmacy.controller.mapping.PharmacyAdminMapper;
import com.isa.pharmacy.domain.Pharmacy;
import com.isa.pharmacy.users.domain.PharmacyAdmin;
import com.isa.pharmacy.service.EmailService;
import com.isa.pharmacy.users.service.PharmacyAdminService;
import com.isa.pharmacy.service.PharmacyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/phadmin")
@CrossOrigin(value = "http://localhost:4200")
public class PharmacyAdminController {
    @Autowired
    private PharmacyAdminService pharmacyAdminService;
    @Autowired
    private EmailService emailService;
    @Autowired
    private PharmacyService pharmacyService;

    @PostMapping
    public CreatePhAdminDto registration(@RequestBody CreatePhAdminDto createPhAdminDto) {
        Pharmacy pharmacy = pharmacyService.getById(createPhAdminDto.getPharmacyId());
        PharmacyAdmin pharmacyAdmin = pharmacyAdminService.registration(PharmacyAdminMapper.mapPharmacyAdminDtoToPharmacyAdmin(createPhAdminDto, pharmacy));
        emailService.activationEmail(pharmacyAdmin.getUser());
        return PharmacyAdminMapper.mapPharmacyAdminToPharmacyAdminDto(pharmacyAdmin);
    }

    @GetMapping
    public List<PharmacyAdmin> findAll() { return pharmacyAdminService.findAll(); }

    @PutMapping("/update")
    public PharmacyAdmin update (@RequestBody PharmacyAdmin pharmacyAdmin){ return pharmacyAdminService.updateAdmin(pharmacyAdmin);}

    @GetMapping("/{email}")
    public CreatePhAdminDto findPharmacyAdminByEmail(@PathVariable("email") String email){ return  pharmacyAdminService.findPharmacyAdminByEmail(email);}
}
