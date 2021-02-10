package com.isa.pharmacy.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.isa.pharmacy.controller.dto.PharmacyPriceDto;
import com.isa.pharmacy.controller.exception.NotFoundException;
import com.isa.pharmacy.domain.MedicinePharmacy;
import com.isa.pharmacy.domain.Pharmacy;
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
    @Autowired
    private PharmacyService pharmacyService;
    @Autowired
    private MedicinePharmacyService medicinePharmacyService;

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
        EPrescription ePrescription = ePrescriptionRepository.findEPrescriptionByFileText(text);
        if(ePrescription == null)
            throw new NotFoundException("E-prescription doesn't exists.");
        return ePrescription;
    }

    public List<EPrescription> getAll() {
        return ePrescriptionRepository.findAll();
    }

    public List<PharmacyPriceDto> getPharmacy(EPrescription ePrescription){
        return pharmacyService.getPharmacyByEPrescription(ePrescription);
    }

    public void order(Long code, String phName){
        Pharmacy pharmacy = pharmacyService.getByName(phName);
        EPrescription ePrescription = findByCode(code);

        try{
            for(MedicineEPrescription medicineEPrescription: ePrescription.getListOfMedication()){
                for(MedicinePharmacy medicinePharmacy: pharmacy.getMedicinePharmacy()){
                    if(medicineEPrescription.getName().equals(medicinePharmacy.getMedicine().getName())){
                        medicinePharmacy.setQuantity(medicinePharmacy.getQuantity()-medicineEPrescription.getQuantity());
                        medicinePharmacyService.save(medicinePharmacy);
                    }
                }
            }

            ePrescriptionRepository.delete(ePrescription);

        }catch(Exception e){
            throw new NotFoundException("Order is not possible.");
        }
    }

    public EPrescription findByCode(Long code){
        EPrescription ePrescription = ePrescriptionRepository.findEPrescriptionByCode(code);
        if(ePrescription == null)
            throw new NotFoundException("E-prescription with code: "+ code + " doesn't exists.");
        return ePrescription;
    }
}
