package com.isa.pharmacy.service;

import java.util.ArrayList;
import java.util.List;

import com.isa.pharmacy.controller.dto.AvailabilityMedicineDto;
import com.isa.pharmacy.controller.dto.MedicineDto;
import com.isa.pharmacy.controller.dto.MedicineLoyaltyDto;
import com.isa.pharmacy.controller.exception.NotFoundException;
import com.isa.pharmacy.domain.enums.FormOfMedicine;
import com.isa.pharmacy.domain.enums.MedicinePublishingType;
import com.isa.pharmacy.controller.mapping.MedicineMapper;
import com.isa.pharmacy.domain.MedicinePharmacy;
import com.isa.pharmacy.domain.Pharmacy;
import com.isa.pharmacy.users.domain.Pharmacist;
import com.isa.pharmacy.users.domain.PharmacyAdmin;
import com.isa.pharmacy.users.service.PharmacistService;
import com.isa.pharmacy.users.service.PharmacyAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import com.isa.pharmacy.domain.Medicine;
import com.isa.pharmacy.repository.MedicineRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class MedicineService {
    @Autowired
    private MedicineRepository medicineRepository;
    @Autowired
    private PharmacyService pharmacyService;
    @Autowired
    private MedicinePharmacyService medicinePharmacyService;
    @Autowired
    private EmailService emailService;
    @Autowired
    private PharmacyAdminService pharmacyAdminService;
    @Autowired
    private PharmacistService pharmacistService;

    public Medicine create(Medicine medicine) {
        if (medicineRepository.findMedicineById(medicine.getId()) != null)
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        return medicineRepository.save(medicine);
    }

    public void delete(Medicine medicine) {
        medicineRepository.delete(medicine);
    }

    public Page<Medicine> filterMedicines(int pageSize, int numPage, String name, Double startPrice, Double endPrice,
                                          List<Long> pharmacies, String typeOfMedicine, String manufactured,
                                          String composition, FormOfMedicine formOfMedicine, MedicinePublishingType publishingType) {
        Pageable pageRequest = PageRequest.of(numPage, pageSize, Sort.by("name"));
        return medicineRepository.filterMedicine(name, startPrice, endPrice, pharmacies, typeOfMedicine == null ? "" : typeOfMedicine,
                manufactured == null ? "" : manufactured, composition == null ? "" : composition, formOfMedicine, publishingType, pageRequest);
    }

    public Medicine findById(Long id) {
        return medicineRepository.findMedicineById(id);
    }

    public Medicine findByName(String name) {
        return medicineRepository.findMedicineByName(name);
    }

    public Page<Medicine> getAll(int numPage, int pageSize) {
        Pageable pageRequest = PageRequest.of(numPage, pageSize);
        Page<Medicine> medicineList = medicineRepository.findAll(pageRequest);
        if (medicineList == null)
            throw new NotFoundException("Pharmacy system doesnt have any medicine");
        return medicineList;
    }

    public List<Medicine> getAll(){
        List<Medicine> medicineList = medicineRepository.findAll();
        if(medicineList == null)
            throw new NotFoundException("Pharmacy system doesnt have any medicine");
        return medicineList;
    }

    public List<MedicineDto> getAllMedicines() {
        List<MedicineDto> medicineDtoList = new ArrayList<>();
        for(Medicine medicine: medicineRepository.findAll()) {
            for (MedicinePharmacy medicinePharmacy :medicine.getMedicinePharmacy()) {
                medicineDtoList.add(MedicineMapper.mapMedicineToMedicineDto(medicinePharmacy.getMedicine(), medicinePharmacy.getPharmacy().getName()));
            }
        }
        return medicineDtoList;
    }

    public List<AvailabilityMedicineDto> checkAvailabilityMedicines(String pharmacyName, List<String> meds){
        Pharmacy pharmacy = pharmacyService.getByName(pharmacyName);
        List<AvailabilityMedicineDto> availabilityMedicineDtos = new ArrayList<>();
        for(String med: meds){
            for(MedicinePharmacy mp: pharmacy.getMedicinePharmacy()){
               if(mp.getPharmacy().getName().equalsIgnoreCase(pharmacyName) && med.equalsIgnoreCase(mp.getMedicine().getName())){
                   AvailabilityMedicineDto availMed = new AvailabilityMedicineDto();
                   if(mp.getQuantity()>0){
                       availMed.setAvailable(true);
                   }
                   else{
                       List<PharmacyAdmin> pharmacyAdmins = pharmacyAdminService.findPharmacyAdminByPharmacy(pharmacyName);
                       for(PharmacyAdmin pa: pharmacyAdmins){
                           String pharmacyAdmin = pa.getUser().getName().concat(" " + pa.getUser().getSurname());
                           emailService.notifyAdminPharmacyAboutMedicine(pa.getUser().getEmail(), pharmacyAdmin, mp.getMedicine().getName());
                       }
                       availMed.setAvailable(false);
                       List<String> alternative = getAllMedicinesById(mp.getMedicine().getReplacementMedicines());
                       availMed.setAlternative(alternative);
                   }
                   availMed.setId(mp.getId());
                   availMed.setName(med);
                   availabilityMedicineDtos.add(availMed);
               }
            }
        }
        return availabilityMedicineDtos;
    }



    public List<AvailabilityMedicineDto> checkAvailabilityMedicinesByPharmacist(String pharmacistEmail, List<String> meds){
        Pharmacist pharmacist = pharmacistService.findUserByEmail(pharmacistEmail);
        List<AvailabilityMedicineDto> availabilityMedicineDtos = new ArrayList<>();
        for(String med: meds){
            for(MedicinePharmacy mp: pharmacist.getPharmacy().getMedicinePharmacy()){
                if(mp.getPharmacy().getName().equalsIgnoreCase(pharmacist.getPharmacy().getName()) && med.equalsIgnoreCase(mp.getMedicine().getName())){
                    AvailabilityMedicineDto availMed = new AvailabilityMedicineDto();
                    if(mp.getQuantity()>0){
                        availMed.setAvailable(true);
                    }
                    else{
                        List<PharmacyAdmin> pharmacyAdmins = pharmacyAdminService.findPharmacyAdminByPharmacy(pharmacist.getPharmacy().getName());
                        for(PharmacyAdmin pa: pharmacyAdmins){
                            String pharmacyAdmin = pa.getUser().getName().concat(" " + pa.getUser().getSurname());
                            emailService.notifyAdminPharmacyAboutMedicine(pa.getUser().getEmail(), pharmacyAdmin, mp.getMedicine().getName());
                        }
                        availMed.setAvailable(false);
                        List<String> alternative = getAllMedicinesById(mp.getMedicine().getReplacementMedicines());
                        availMed.setAlternative(alternative);
                    }
                    availMed.setId(mp.getId());
                    availMed.setName(med);
                    availabilityMedicineDtos.add(availMed);
                }
            }
        }
        return availabilityMedicineDtos;
    }


    public MedicineLoyaltyDto changeLoyalty(MedicineLoyaltyDto medicineLoyaltyDto) {
        Medicine medicine = medicineRepository.findMedicineByCode(medicineLoyaltyDto.getCode());
        if (medicine == null)
            throw new NotFoundException("Medicine " + medicineLoyaltyDto.getName() + " doesnt exist.");
        medicine.setLoyaltyPoints(medicineLoyaltyDto.getLoyaltyPoints());
        medicineRepository.save(medicine);
        return medicineLoyaltyDto;
    }

    public List<Medicine> getMedicinesByNames(List<String> medicinesNames) {
        List<Medicine> medicineList = new ArrayList<>();
        List<Medicine> dbMedicines = medicineRepository.findAll();
        for (Medicine medicine : dbMedicines) {
            for (String name : medicinesNames) {
                if (medicine.getName().equals(name)) {
                    medicineList.add(medicine);
                }
            }
        }
        return medicineList;
    }

    public List<Medicine> getAllMedicinesByCode(List<Long> codes){
        List<Medicine> medicines = new ArrayList<>();
        if(codes != null){
            for(Long i : codes){
                for(Medicine m: getAll()){
                    if(m.getCode().equals(i))
                        medicines.add(m);
                }
            }
        }
        return  medicines;
    }

    public List<String> getAllMedicinesById(List<Long> ids){
        List<String> medNames = new ArrayList<>();
        if(ids != null){
            for(Long i : ids){
                for(Medicine m: getAll()){
                    if(m.getCode().equals(i))
                        medNames.add(m.getName());
                }
            }
        }
        return  medNames;
    }

    public List<Medicine> decreaseQuantityInPharmacy(List<Medicine> meds, String pharmacyName){
        List<Medicine> medicines = new ArrayList<>();
        Pharmacy pharmacy = pharmacyService.getByName(pharmacyName);
        if(meds != null && pharmacyName !=null){
            for(Medicine m: meds){
                for(MedicinePharmacy mp: pharmacy.getMedicinePharmacy()){
                    if(pharmacyName.equalsIgnoreCase(mp.getPharmacy().getName()) && mp.getMedicine().getName().equals(m.getName()) && mp.getQuantity()-1>=0){
                        mp.setQuantity(mp.getQuantity()-1);
                        medicinePharmacyService.save(mp);
                        medicines.add(mp.getMedicine());
                    }
                }
            }
        }
        return medicines;
    }

}
