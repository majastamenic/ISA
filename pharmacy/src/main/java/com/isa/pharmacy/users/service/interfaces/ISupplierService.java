package com.isa.pharmacy.users.service.interfaces;

import com.isa.pharmacy.controller.exception.AlreadyExistsException;
import com.isa.pharmacy.controller.exception.NotFoundException;
import com.isa.pharmacy.users.domain.Supplier;

public interface ISupplierService {
     Supplier registration(Supplier supplier);

     Supplier getByEmail(String email);
}
