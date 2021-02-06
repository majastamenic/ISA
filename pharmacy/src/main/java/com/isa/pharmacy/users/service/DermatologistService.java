package com.isa.pharmacy.users.service;

import com.isa.pharmacy.controller.exception.AlreadyExistsException;
import com.isa.pharmacy.users.domain.Dermatologist;
import com.isa.pharmacy.users.domain.User;
import com.isa.pharmacy.users.repository.DermatologistRepository;
import com.isa.pharmacy.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DermatologistService {
    @Autowired
    private DermatologistRepository dermatologistRepository;
    @Autowired
    private UserService userService;

    public void delete(Dermatologist dermatologist){
        dermatologistRepository.delete(dermatologist);
    }

    public Dermatologist save(Dermatologist dermatologist){
        return dermatologistRepository.save(dermatologist);
    }

    public List<Dermatologist> getAll(){
        return dermatologistRepository.findAll();
    }

    public Dermatologist update(Dermatologist d) {
        Dermatologist dermatologist = dermatologistRepository.findDermatologistById(d.getId());
        dermatologist.setUser(d.getUser());
        dermatologistRepository.save(dermatologist);
        return dermatologist;
    }

    public Dermatologist registration(Dermatologist dermatologist) {
        Dermatologist existingUser = dermatologistRepository.findDermatologistByUser_email(dermatologist.getUser().getEmail());
        if (existingUser == null) {
            userService.create(dermatologist.getUser());
            return dermatologistRepository.save(dermatologist);
        }
        throw new AlreadyExistsException(String.format("Patient with email %s, already exists", dermatologist.getUser().getEmail()));
    }
}
