package com.isa.pharmacy.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.isa.pharmacy.domain.EPrescription;
import com.isa.pharmacy.domain.MedicineEPrescription;
import com.isa.pharmacy.repository.EPrescriptionRepository;

@Service
public class EPrescriptionService {

    @Autowired
    private EPrescriptionRepository ePrescriptionRepository;
    @Autowired
    private MedicineEPrescriptionService medicineEService;

    public EPrescription save(EPrescription ePrescription) {
        for (MedicineEPrescription m : ePrescription.getListOfMedication()) {
            MedicineEPrescription med = medicineEService.create(m);
        }
        return ePrescriptionRepository.save(ePrescription);
    }

    public EPrescription getById(Long id) {
        return ePrescriptionRepository.findEPrescriptionById(id);
    }

    public EPrescription getByText(String text) throws ParseException {

        for (EPrescription ePrescription : getAll()) {
            if (ePrescription.getFileText().equals(text)) {
                return ePrescription;
            }
        }
        return null;
    }

    public List<EPrescription> getAll() {
        return ePrescriptionRepository.findAll();
    }

}
