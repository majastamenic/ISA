package com.isa.pharmacy.service;

import com.isa.pharmacy.controller.exception.AlreadyExistsException;
import com.isa.pharmacy.domain.Dermatologist;
import com.isa.pharmacy.domain.Diagnosis;
import com.isa.pharmacy.domain.Pharmacist;
import com.isa.pharmacy.domain.User;
import com.isa.pharmacy.repository.PharmacistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PharmacistService {
    @Autowired
    private PharmacistRepository pharmacistRepository;

    public Pharmacist save(Pharmacist p) { return pharmacistRepository.save(p); }

    public List<Pharmacist> getAll(){ return pharmacistRepository.findAll(); }
}
