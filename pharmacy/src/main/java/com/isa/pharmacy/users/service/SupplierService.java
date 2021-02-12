package com.isa.pharmacy.users.service;

import com.isa.pharmacy.controller.exception.AlreadyExistsException;
import com.isa.pharmacy.controller.exception.NotFoundException;
import com.isa.pharmacy.users.domain.Supplier;
import com.isa.pharmacy.users.repository.SupplierRepository;
import com.isa.pharmacy.users.service.interfaces.ISupplierService;
import com.isa.pharmacy.users.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupplierService implements ISupplierService {
    @Autowired
    private IUserService userService;
    @Autowired
    private SupplierRepository supplierRepository;

    public Supplier registration(Supplier supplier) {
        Supplier existingUser = supplierRepository.findSupplierByUser_email(supplier.getUser().getEmail());
        if (existingUser != null)
            throw new AlreadyExistsException(String.format("Supplier with email %s, already exists", supplier.getUser().getEmail()));
        userService.create(supplier.getUser());
        return supplierRepository.save(supplier);
    }

    public Supplier getByEmail(String email){
        Supplier supplier = supplierRepository.findSupplierByUser_email(email);
        if(supplier == null)
            throw new NotFoundException("Supplier with email "+email+" doesn't exists.");
        return supplier;
    }
}
