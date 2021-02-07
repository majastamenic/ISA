package com.isa.pharmacy.users.service;

import com.isa.pharmacy.controller.exception.AlreadyExistsException;
import com.isa.pharmacy.controller.exception.NotFoundException;
import com.isa.pharmacy.users.domain.Supplier;
import com.isa.pharmacy.users.repository.SupplierRepository;
import com.isa.pharmacy.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupplierService {
    @Autowired
    private UserService userService;
    @Autowired
    private SupplierRepository supplierRepository;

    public Supplier registration(Supplier supplier) {
        Supplier existingUser = supplierRepository.findSupplierByUser_email(supplier.getUser().getEmail());
        if (existingUser == null) {
            userService.create(supplier.getUser());
            return supplierRepository.save(supplier);
        }
        throw new AlreadyExistsException(String.format("Supplier with email %s, already exists", supplier.getUser().getEmail()));
    }

    public Supplier getByEmail(String email){
        Supplier supplier = supplierRepository.findSupplierByUser_email(email);
        if(supplier == null)
            throw new NotFoundException("Supplier with email "+email+" doesn't exists.");
        return supplier;
    }
}
