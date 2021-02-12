package com.isa.pharmacy.service.interfaces;

import com.isa.pharmacy.controller.dto.PharmacyPriceDto;
import com.isa.pharmacy.domain.*;
import com.isa.pharmacy.users.domain.Patient;

import java.util.List;

public interface IEPrescriptionService {
     EPrescription save(EPrescription ePrescription);

     EPrescription getById(Long id);

     List<EPrescription> getByPatientEmail(String email);

     EPrescription getByText(String text);

     List<EPrescription> getAll();

     List<PharmacyPriceDto> getPharmacy(EPrescription ePrescription);

     void order(Long code, String phName);

     EPrescription findByCode(Long code);

     EPrescription createEPrescription(Prescription prescription, Patient patient);
}
