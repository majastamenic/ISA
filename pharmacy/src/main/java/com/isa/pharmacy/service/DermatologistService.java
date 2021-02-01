package com.isa.pharmacy.service;

import com.isa.pharmacy.domain.Profile.Dermatologist;
import com.isa.pharmacy.repository.DermatologistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DermatologistService {
    @Autowired
    private DermatologistRepository dermatologistRepository;

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
        dermatologist.setFirstLog(false);
        dermatologistRepository.save(dermatologist);
        return dermatologist;
    }
}
