package com.isa.pharmacy.users.controller;

import com.isa.pharmacy.users.controller.dto.RegistrationDto;
import com.isa.pharmacy.users.controller.mapping.UserMapper;
import com.isa.pharmacy.users.domain.Dermatologist;
import com.isa.pharmacy.users.service.DermatologistService;
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
    //TODO: Dermatolog
    /*
    @PostMapping("/registration")
    public Dermatologist save(@RequestBody Dermatologist d) {
        return dermatologistService.save(d);
    }
    */
    @GetMapping
    public List<Dermatologist> getAll() { return dermatologistService.getAll(); }
    //TODO: Dermatolog 1
    /*
    @PostMapping("/update")
    public Dermatologist update(@RequestBody Dermatologist d) { return dermatologistService.update(d); }
     */
}
