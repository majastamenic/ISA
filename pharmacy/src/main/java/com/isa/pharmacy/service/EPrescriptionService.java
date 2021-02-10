package com.isa.pharmacy.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.isa.pharmacy.controller.dto.PharmacyPriceDto;
import com.isa.pharmacy.controller.exception.NotFoundException;
import com.isa.pharmacy.domain.*;
import com.isa.pharmacy.users.domain.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
                    if(medicineEPrescription.getName().equals(medicinePharmacy.getMedicine().getName()) && medicineEPrescription.getQuantity()<=medicinePharmacy.getQuantity()){
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

    public EPrescription createEPrescription(Prescription prescription, Patient patient){
        EPrescription ePrescription = new EPrescription();
        ePrescription.setCode(new Random().nextLong());
        ePrescription.setPatientName(patient.getUser().getName()+" "+patient.getUser().getSurname());
        ePrescription.setDateOfIssue(new Date());
        List<MedicineEPrescription> medicineEPrescriptions = new ArrayList<>();
        String medText="";
        for(Medicine medicine: prescription.getMedicines()){
            MedicineEPrescription medicineEPrescription = new MedicineEPrescription();
            medicineEPrescription.setCode(new Random().nextLong());
            medicineEPrescription.setName(medicine.getName());
            if((prescription.getDays()/10) < 1)
                medicineEPrescription.setQuantity(1);
            else
                medicineEPrescription.setQuantity(prescription.getDays()/10);
            medicineEPrescriptions.add(medicineEPrescription);
            medText = medicineEPrescription.getName() + ", ";
            medicineEService.create(medicineEPrescription);
        }
        if(!medText.equals(""))
            medText = medText.substring(medText.lastIndexOf(" "));
        ePrescription.setFileText(ePrescription.getPatientName()+" "+ medText);
        ePrescription.setListOfMedication(medicineEPrescriptions);
        return ePrescriptionRepository.save(ePrescription);
    }
}
