package com.isa.pharmacy.service;

import com.isa.pharmacy.controller.dto.AvailabilityMedicineDto;
import com.isa.pharmacy.controller.dto.MedicineDto;
import com.isa.pharmacy.controller.dto.MedicineLoyaltyDto;
import com.isa.pharmacy.controller.exception.InvalidActionException;
import com.isa.pharmacy.controller.exception.NotFoundException;
import com.isa.pharmacy.controller.mapping.MedicineMapper;
import com.isa.pharmacy.domain.Medicine;
import com.isa.pharmacy.domain.MedicinePharmacy;
import com.isa.pharmacy.domain.Pharmacy;
import com.isa.pharmacy.domain.enums.FormOfMedicine;
import com.isa.pharmacy.domain.enums.MedicinePublishingType;
import com.isa.pharmacy.repository.MedicineRepository;
import com.isa.pharmacy.service.interfaces.IEmailService;
import com.isa.pharmacy.service.interfaces.IMedicinePharmacyService;
import com.isa.pharmacy.service.interfaces.IMedicineService;
import com.isa.pharmacy.service.interfaces.IPharmacyService;
import com.isa.pharmacy.users.domain.PharmacyAdmin;
import com.isa.pharmacy.users.service.interfaces.IPharmacistService;
import com.isa.pharmacy.users.service.interfaces.IPharmacyAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class MedicineService implements IMedicineService {
    @Autowired
    private MedicineRepository medicineRepository;
    @Autowired
    private IPharmacyService pharmacyService;
    @Autowired
    private IMedicinePharmacyService medicinePharmacyService;
    @Autowired
    private IEmailService emailService;
    @Autowired
    private IPharmacyAdminService pharmacyAdminService;
    @Autowired
    private IPharmacistService pharmacistService;


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
        if(medicineList.isEmpty())
            throw new NotFoundException("Pharmacy system doesn't have any medicine");
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
        Pharmacy pharmacy = pharmacyService.getPharmacyByName(pharmacyName);
        return checkingMedicines(pharmacy, meds);
    }

    public List<AvailabilityMedicineDto> checkAvailabilityMedicinesByPharmacist(String pharmacistEmail, List<String> meds){
        Pharmacy pharmacy =  pharmacistService.findUserByEmail(pharmacistEmail).getPharmacy();
        return checkingMedicines(pharmacy, meds);
    }

    public List<AvailabilityMedicineDto> checkingMedicines(Pharmacy pharmacy, List<String> meds){
        List<AvailabilityMedicineDto> availabilityMedicineDtos = new ArrayList<>();
        boolean find = false;
        for(String med: meds){
            find = false;
            for(MedicinePharmacy mp: pharmacy.getMedicinePharmacy()){
                if(mp.getPharmacy().getName().equalsIgnoreCase(pharmacy.getName()) && med.equalsIgnoreCase(mp.getMedicine().getName())
                        && !find){
                    AvailabilityMedicineDto availMed = new AvailabilityMedicineDto();
                    if(mp.getQuantity()>0){
                        availMed.setAvailable(true);
                    }
                    else{
                        List<PharmacyAdmin> pharmacyAdmins = pharmacyAdminService.findPharmacyAdminByPharmacy(pharmacy.getName());
                        notifyPharmacyAdminsAboutMedicine(pharmacyAdmins, mp.getMedicine().getName());
                        availMed.setAvailable(false);
                        availMed.setAlternative(getAllMedicinesById(mp.getMedicine().getReplacementMedicines()));
                    }
                    availMed.setId(mp.getId());
                    availMed.setName(med);
                    availabilityMedicineDtos.add(availMed);
                    find = true;
                }
            }
        }
        return availabilityMedicineDtos;
    }

    public void notifyPharmacyAdminsAboutMedicine(List<PharmacyAdmin> pharmacyAdmins, String medicineName){
        for(PharmacyAdmin pa: pharmacyAdmins){
            String pharmacyAdmin = pa.getUser().getName().concat(" " + pa.getUser().getSurname());
            emailService.notifyAdminPharmacyAboutMedicine(pa.getUser().getEmail(), pharmacyAdmin, medicineName);
        }
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
        Pharmacy pharmacy = pharmacyService.getPharmacyByName(pharmacyName);
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

    public void update(Medicine medicine){
        medicineRepository.save(medicine);
    }

    public MedicineDto findMedicineSpecification(String name){
        Medicine medicine = findByName(name);
        MedicineDto medicineDto = new MedicineDto();
        if(medicine != null){
            medicineDto = MedicineMapper.mapMedicineToMedicineDto(medicine, "");
        }else{
            throw new InvalidActionException("Pharmacy don't have medicine with that name.");
        }
        return medicineDto;
    }

}
