package com.isa.pharmacy.service;

import com.isa.pharmacy.controller.dto.PharmacyPriceDto;
import com.isa.pharmacy.controller.exception.NotFoundException;
import com.isa.pharmacy.domain.*;
import com.isa.pharmacy.repository.EPrescriptionRepository;
import com.isa.pharmacy.service.interfaces.*;
import com.isa.pharmacy.users.domain.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class EPrescriptionService implements IEPrescriptionService {

    @Autowired
    private EPrescriptionRepository ePrescriptionRepository;
    @Autowired
    private IMedicineEPrescriptionService medicineEService;
    @Autowired
    private IPharmacyService pharmacyService;
    @Autowired
    private IMedicinePharmacyService medicinePharmacyService;
    @Autowired
    private IEmailService emailService;

    public EPrescription save(EPrescription ePrescription) {
        for (MedicineEPrescription m : ePrescription.getListOfMedication()) {
            medicineEService.create(m);
        }
        return ePrescriptionRepository.save(ePrescription);
    }

    public EPrescription getById(Long id) {
        EPrescription ePrescription = ePrescriptionRepository.findEPrescriptionById(id);
        if(ePrescription == null)
            throw new NotFoundException("E-prescription doesn't exists.");
        return ePrescription;
    }

    public List<EPrescription> getByPatientEmail(String email){
        List<EPrescription> ePrescriptions = ePrescriptionRepository.findEPrescriptionByPatient_User_Email(email);
        if(ePrescriptions.isEmpty())
            throw new NotFoundException("Patient doesn't have any e-prescription");
        return ePrescriptions;
    }

    public EPrescription getByText(String text) {
        EPrescription ePrescription = ePrescriptionRepository.findEPrescriptionByFileText(text);
        if(ePrescription == null)
            throw new NotFoundException("E-prescription doesn't exists.");
        return ePrescription;
    }

    public List<EPrescription> getAll() {
        List<EPrescription> ePrescriptions = ePrescriptionRepository.findAll();
        if(ePrescriptions.isEmpty())
            throw new NotFoundException("There is no e-prescription");
        return ePrescriptions;
    }

    public List<PharmacyPriceDto> getPharmacy(EPrescription ePrescription){
        return pharmacyService.getPharmacyByEPrescription(ePrescription);
    }

    public void order(Long code, String phName){
        Pharmacy pharmacy = pharmacyService.getPharmacyByName(phName);
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
            try {
                emailService.sendEmailEPrescription(ePrescription);
            }catch (Exception e){}


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
        ePrescription.setPatient(patient);
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
        ePrescription.setFileText(patient.getUser().getName() + " " + patient.getUser().getSurname() + " " + medText);
        ePrescription.setListOfMedication(medicineEPrescriptions);
        return ePrescriptionRepository.save(ePrescription);
    }
}
