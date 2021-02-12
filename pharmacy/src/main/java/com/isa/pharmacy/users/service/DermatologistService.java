package com.isa.pharmacy.users.service;

import com.isa.pharmacy.controller.exception.AlreadyExistsException;
import com.isa.pharmacy.controller.exception.NotFoundException;
import com.isa.pharmacy.users.domain.Dermatologist;
import com.isa.pharmacy.users.repository.DermatologistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.NoRouteToHostException;
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
        List<Dermatologist> dermatologistList = dermatologistRepository.findAll();
        if(dermatologistList.isEmpty())
            throw new NotFoundException("There is no dermatologist.");
        return dermatologistList;
    }

    public Dermatologist update(Dermatologist d) {
        Dermatologist dermatologist = dermatologistRepository.findDermatologistById(d.getId());
        if(dermatologist == null)
            throw new NotFoundException("Dermatologist doesn't exists.");
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

    public Dermatologist findUserByEmail(String email){
        Dermatologist dermatologist = dermatologistRepository.findDermatologistByUser_email(email);
        if(dermatologist == null)
            throw new NotFoundException("Dermatologist with email: "+ email + "doesn't exists.");
        return dermatologist;
    }


}
