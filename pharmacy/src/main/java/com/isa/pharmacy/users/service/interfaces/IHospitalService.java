package com.isa.pharmacy.users.service.interfaces;

import com.isa.pharmacy.users.domain.Hospital;

import java.util.List;

public interface IHospitalService {

     Hospital create(Hospital hospital);

     Hospital getByEmail(String email);

     List<Hospital> getAll();
}
