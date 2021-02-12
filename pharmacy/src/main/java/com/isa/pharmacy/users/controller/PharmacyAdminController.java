package com.isa.pharmacy.users.controller;
import com.isa.pharmacy.controller.exception.BadRequestException;
import com.isa.pharmacy.controller.exception.NotFoundException;
import com.isa.pharmacy.service.interfaces.IEmailService;
import com.isa.pharmacy.service.interfaces.IPharmacyService;
import com.isa.pharmacy.users.controller.dto.CreatePhAdminDto;
import com.isa.pharmacy.users.controller.mapping.PharmacyAdminMapper;
import com.isa.pharmacy.domain.Pharmacy;
import com.isa.pharmacy.users.domain.PharmacyAdmin;
import com.isa.pharmacy.users.service.interfaces.IPharmacyAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/phadmin")
@CrossOrigin(origins ={ "http://localhost:4200", "https://pharmacy-25-frontend.herokuapp.com"})
public class PharmacyAdminController {

    @Autowired
    private IPharmacyAdminService pharmacyAdminService;
    @Autowired
    private IEmailService emailService;
    @Autowired
    private IPharmacyService pharmacyService;

    @PostMapping
    public CreatePhAdminDto registration(@RequestBody CreatePhAdminDto createPhAdminDto) {
        Pharmacy pharmacy = pharmacyService.getById(createPhAdminDto.getPharmacyId());
        if(pharmacy == null)
            throw new NotFoundException("There is no pharmacy.");
        PharmacyAdmin pharmacyAdmin = pharmacyAdminService.registration(PharmacyAdminMapper.mapPharmacyAdminDtoToPharmacyAdmin(createPhAdminDto, pharmacy));
        try {
            emailService.activationEmail(pharmacyAdmin.getUser());
        }catch (Exception e){
            throw new BadRequestException("Email feature not available on heroku");
        }
        return PharmacyAdminMapper.mapPharmacyAdminToPharmacyAdminDto(pharmacyAdmin);
    }

    @GetMapping
    public List<PharmacyAdmin> findAll() { return pharmacyAdminService.findAll(); }

    @GetMapping("/{email}")
    public CreatePhAdminDto findPharmacyAdminByEmail(@PathVariable("email") String email){ return  pharmacyAdminService.findPharmacyAdminByEmail(email);}

}
