package com.isa.pharmacy.controller;

import com.isa.pharmacy.controller.dto.RegistrationDto;
import com.isa.pharmacy.controller.mapping.UserMapper;
import com.isa.pharmacy.users.domain.Supplier;
import com.isa.pharmacy.service.EmailService;
import com.isa.pharmacy.users.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/supplier")
@CrossOrigin(value = "http://localhost:4200")
public class SupplierController {
    @Autowired
    private SupplierService supplierService;
    @Autowired
    private EmailService emailService;
    @PostMapping
    public Supplier registration(@RequestBody RegistrationDto registrationDto) {
        Supplier supplier = supplierService.registration(UserMapper.mapRegistrationDtoToSupplier(registrationDto));
        emailService.activationEmail(supplier.getUser());
        return supplier;
    }
}
