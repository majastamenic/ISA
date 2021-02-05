package com.isa.pharmacy.controller;

import com.isa.pharmacy.controller.dto.RegistrationDto;
import com.isa.pharmacy.controller.mapping.UserMapper;
import com.isa.pharmacy.domain.users.Dermatologist;
import com.isa.pharmacy.service.DermatologistService;
import com.isa.pharmacy.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dermatologist")
@CrossOrigin(value = "http://localhost:4200")
public class DermatologistController {

    @Autowired
    private DermatologistService dermatologistService;
    @Autowired
    private EmailService emailService;

    @PostMapping
    public Dermatologist registration(@RequestBody RegistrationDto registrationDto) {
        Dermatologist dermatologist = dermatologistService.registration(UserMapper.mapRegistrationDtoToDermatologist(registrationDto));
        emailService.activationEmail(dermatologist.getUser());
        return dermatologist;
    }

    @PostMapping("/registration")
    public Dermatologist save(@RequestBody Dermatologist d) {
        return dermatologistService.save(d);
    }

    @GetMapping
    public List<Dermatologist> getAll() { return dermatologistService.getAll(); }

    @PostMapping("/update")
    public Dermatologist update(@RequestBody Dermatologist d) { return dermatologistService.update(d); }
}
