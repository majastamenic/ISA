package com.isa.pharmacy.service;

import com.isa.pharmacy.domain.Dermatologist;
import com.isa.pharmacy.domain.Pharmacist;
import com.isa.pharmacy.repository.PharmacistRepository;

import java.util.List;

public class PharmacistService {

    private PharmacistRepository pharmacistRepository;

    public void delete(Pharmacist pharmacist){
        pharmacistRepository.delete(pharmacist);
    }

    public Pharmacist create(Pharmacist pharmacist){
        return pharmacistRepository.save(pharmacist);
    }

    public List<Pharmacist> getAll(){
        return pharmacistRepository.findAll();
    }
}
