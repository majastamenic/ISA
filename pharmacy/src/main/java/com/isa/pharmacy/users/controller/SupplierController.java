package com.isa.pharmacy.users.controller;

import com.isa.pharmacy.service.interfaces.IEmailService;
import com.isa.pharmacy.users.controller.dto.RegistrationDto;
import com.isa.pharmacy.users.controller.mapping.UserMapper;
import com.isa.pharmacy.users.domain.Supplier;
import com.isa.pharmacy.users.service.interfaces.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/supplier")
@CrossOrigin(origins ={ "http://localhost:4200", "https://pharmacy-25-frontend.herokuapp.com"})
public class SupplierController {

    @Autowired
    private ISupplierService supplierService;
    @Autowired
    private IEmailService emailService;

    @PostMapping
    public Supplier registration(@RequestBody RegistrationDto registrationDto) {
        Supplier supplier = supplierService.registration(UserMapper.mapRegistrationDtoToSupplier(registrationDto));
        try {
            emailService.activationEmail(supplier.getUser());
        }catch (Exception e){}
        return supplier;
    }
}
