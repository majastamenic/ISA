package com.isa.pharmacy.controller;
import com.isa.pharmacy.domain.PharmacyAdmin;
import com.isa.pharmacy.service.PharmacyAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/phadmin")
public class PharmacyAdminController {
    @Autowired
    private PharmacyAdminService pharmacyAdminService;

    @PostMapping("/register")
    public PharmacyAdmin save(@RequestBody PharmacyAdmin pharmacyAdmin){ return pharmacyAdminService.save(pharmacyAdmin); }

    @GetMapping
    public List<PharmacyAdmin> findAll() { return pharmacyAdminService.findAll(); }

    @PostMapping("/update")
    public PharmacyAdmin update (@RequestBody PharmacyAdmin pharmacyAdmin){ return pharmacyAdminService.updateAdmin(pharmacyAdmin);}

}
