package com.isa.pharmacy.service;

import com.isa.pharmacy.domain.Dermatologist;
import com.isa.pharmacy.repository.DermatologistRepository;

import java.util.List;

public class DermatologistService {

    private DermatologistRepository dermatologistRepository;

    public void delete(Dermatologist dermatologist){
        dermatologistRepository.delete(dermatologist);
    }

    public Dermatologist create(Dermatologist dermatologist){
        return dermatologistRepository.save(dermatologist);
    }

    public List<Dermatologist> getAll(){
        return dermatologistRepository.findAll();
    }
}
