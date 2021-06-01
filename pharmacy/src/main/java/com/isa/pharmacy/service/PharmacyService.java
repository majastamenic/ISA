package com.isa.pharmacy.service;

import com.isa.pharmacy.controller.dto.*;
import com.isa.pharmacy.controller.exception.AlreadyExistsException;
import com.isa.pharmacy.controller.exception.NotFoundException;
import com.isa.pharmacy.controller.mapping.MedicineMapper;
import com.isa.pharmacy.controller.mapping.PharmacyMapper;
import com.isa.pharmacy.domain.*;
import com.isa.pharmacy.repository.*;
import com.isa.pharmacy.service.interfaces.*;
import com.isa.pharmacy.users.domain.Pharmacist;
import com.isa.pharmacy.users.domain.PharmacyAdmin;
import com.isa.pharmacy.users.service.interfaces.IPharmacistService;
import com.isa.pharmacy.users.service.interfaces.IPharmacyAdminService;
import org.hibernate.mapping.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PharmacyService implements IPharmacyService {

    @Autowired
    private PharmacyRepository pharmacyRepository;
    @Autowired
    private IPharmacistService pharmacistService;
    @Autowired
    private IMedicineReservationService medicineReservationService;
    @Autowired
    private IPharmacyAdminService pharmacyAdminService;
    @Autowired
    private MedicinePharmacyRepository medicinePharmacyRepository;
    @Autowired
    private PriceListRepository priceListRepository;
    @Autowired
    private ExaminationRepository examinationRepository;
    @Autowired
    private MedicineReservationRepository medicineReservationRepository;
    @Value("${apiKey}")
    private String apiKey;

    public Pharmacy save(Pharmacy p) {
        return pharmacyRepository.save(p);
    }

    public Pharmacy getById(Long id) {
        return pharmacyRepository.findPharmacyById(id);
    }

    public List<GetAllPharmaciesDto> getAll() {
        List<Pharmacy> pharmacies = pharmacyRepository.findAll();
        List<GetAllPharmaciesDto> pharmaciesDtos = new ArrayList<>();
        for (Pharmacy pharmacy: pharmacies) {
            pharmaciesDtos.add(PharmacyMapper.mapPharmacyToGetAllPharmaciesDto(pharmacy));
        }
        return pharmaciesDtos;
    }

    public List<Medicine> getMedicinesFromPharmacy(String pharmacyName) {
        Pharmacy pharmacy = getPharmacyByName(pharmacyName);
        List<Medicine> medicineList = new ArrayList<>();
        for (MedicinePharmacy medicinePharmacy : pharmacy.getMedicinePharmacy()) {
            medicineList.add(medicinePharmacy.getMedicine());
        }
        return medicineList;
    }

    public int hasPharmacyMedication(String pharmacyName, String medicineName) {
        Pharmacy pharmacy = getPharmacyByName(pharmacyName);
        for (MedicinePharmacy medicinePharmacy : pharmacy.getMedicinePharmacy()) {
            if (medicinePharmacy.getMedicine().getName().equalsIgnoreCase(medicineName))
                return medicinePharmacy.getQuantity();
        }
        throw new NotFoundException(String.format("Pharmacy %s doesn't have %s medicine", pharmacyName, medicineName));
    }

    public Medicine checkAvailability(String medicineName, String pharmacyName) {
        Pharmacy pharmacy = getPharmacyByName(pharmacyName);
        for (MedicinePharmacy medicinePharmacy : pharmacy.getMedicinePharmacy()) {
            if (medicinePharmacy.getMedicine().getName().equalsIgnoreCase(medicineName))
                return medicinePharmacy.getMedicine();
        }
        return null;
    }

    public Integer pharmacyProfit(Date startDate, Date endDate, String adminEmail){
        Integer profit= 0;
        PharmacyAdmin admin = pharmacyAdminService.findPharmacyAdminByEmail(adminEmail);
        List<MedicinePharmacy> medicinePharmacies = medicinePharmacyRepository.findMedicinePharmacyByPharmacy_id(admin.getPharmacy().getId());
        List<Examination> examinations = examinationRepository.findExaminationByPharmacy_Id(admin.getPharmacy().getId());
        for(Examination e:examinations){
            if(e.getPharmacy().equals(admin.getPharmacy()) && e.getPatient()!=null && e.getPatientCame().equals(true) && e.getSchedule().getStartDate().before(endDate) && e.getSchedule().getStartDate().after(startDate))
                profit = profit + e.getPrice();

        }
        for(MedicinePharmacy medicinePharmacy:medicinePharmacies){
            List<MedicineReservation> medicineReservations = medicineReservationRepository.findMedicineReservationByMedicinePharmacy_Id(medicinePharmacy.getId());
            List<PriceList> priceLists = priceListRepository.getPriceListByMedicinePharmacy_Id(medicinePharmacy.getId());
            for(PriceList pl:priceLists){
                if(pl.getDateFrom().before(startDate)&&pl.getDateTo().after(endDate)&&pl.getDateFrom().before(endDate)&&pl.getDateTo().after(startDate)){
                    for(MedicineReservation medicineReservation:medicineReservations){
                        if(medicineReservation.getTaken().equals(true) && medicineReservation.getDueDate().after(startDate) && medicineReservation.getDueDate().before(endDate))
                            profit =profit+ pl.getPrice()*medicineReservation.getAmount();
                    }

                }
            }
        }

        return profit;
    }

    public List<MedicineDto> checkAvailabilities(List<String> medicinesName, String pharmacyName) {
        Pharmacy pharmacy = getPharmacyByName(pharmacyName);
        List<MedicineDto> medicineDtoList = new ArrayList<>();
        for (MedicinePharmacy medicinePharmacy : pharmacy.getMedicinePharmacy()) {
            for(String medicineName : medicinesName) {
                if (medicinePharmacy.getMedicine().getName().equalsIgnoreCase(medicineName))
                    medicineDtoList.add(MedicineMapper.mapMedicineToMedicineDto(medicinePharmacy.getMedicine(), pharmacyName));
            }
        }
        return medicineDtoList;
    }

    public MedicineDto orderMedicine(String medicineName, int amount, String pharmacyName) {
        Pharmacy pharmacy = getPharmacyByName(pharmacyName);
        for (MedicinePharmacy medicinePharmacy : pharmacy.getMedicinePharmacy()) {
            if (medicinePharmacy.getMedicine().getName().equalsIgnoreCase(medicineName)
                    && medicinePharmacy.getQuantity() >= amount) {
                medicinePharmacy.setQuantity(medicinePharmacy.getQuantity() - amount);
                pharmacyRepository.save(pharmacy);
                medicinePharmacy.setQuantity(amount);
                return MedicineMapper.mapMedicineToMedicineDto(medicinePharmacy.getMedicine(), pharmacyName);
            }
        }
        return null;
    }

    public List<MedicineDto> orderMedicines(List<MedicineOrderDto> medicineOrderDtoList,String pharmacyName) {
        List<MedicineDto> medicineDtoList = new ArrayList<>();
        for(MedicineOrderDto medicineOrderDto: medicineOrderDtoList){
            MedicineDto medicineDto = orderMedicine(medicineOrderDto.getMedicineName(), medicineOrderDto.getAmount(), pharmacyName);
            if(medicineDto != null)
                medicineDtoList.add(medicineDto);
        }
        return medicineDtoList;
    }

    public List<MedicineDto> getMedicineListFromPharmacy(String pharmacyName) {
        Pharmacy pharmacy = getPharmacyByName(pharmacyName);
        List<MedicineDto> medicineDtoList = new ArrayList<>();
        for (MedicinePharmacy medicinePharmacy : pharmacy.getMedicinePharmacy()) {
            medicineDtoList.add(MedicineMapper.mapMedicineToMedicineDto(medicinePharmacy.getMedicine(), pharmacyName));
        }
        return medicineDtoList;
    }

    public void checkApiKey(String apiKey){
        if (!(this.apiKey).equals(apiKey))
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
    }

    public List<String> getPharmacyName(String email){
        List<String> pharmacyNames = new ArrayList<>();
        List<MedicineReservation> medicineReservations = medicineReservationService.getAllReservationsByPatient(email);
        if (medicineReservations != null) {
            for(MedicineReservation med: medicineReservations){
                if(med.getTaken() != null && med.getTaken())
                    pharmacyNames.add(med.getMedicinePharmacy().getPharmacy().getName());
            }
        }
        return pharmacyNames.stream().distinct().collect(Collectors.toList());
    }

    public List<Pharmacy> getPharmaciesForCounseling(DateTimeDto eagerDate){
        List<Pharmacy> availablePharmacies = new ArrayList<>();
        List<String> addedPharmacies = new ArrayList<>();
        for(Pharmacist ph : pharmacistService.getFreePharmacistByDate(eagerDate)){
            if(!addedPharmacies.contains(ph.getPharmacy().getName())){
                availablePharmacies.add(pharmacyRepository.findPharmacyByName(ph.getPharmacy().getName()));
                addedPharmacies.add(ph.getPharmacy().getName());
            }
        }
        return availablePharmacies;
    }

    public List<Pharmacy> findPharmaciesBySubEmail(String email){
        List<Pharmacy> pharmacyList = pharmacyRepository.findPharmaciesBySubscriber(email);
        if(pharmacyList.isEmpty())
            throw new NotFoundException("User with email "+ email+" isn't subscribed to any pharmacy");
        return pharmacyList;
    }

    public void addSubscribe(String email, String phName){
        Pharmacy pharmacy = getPharmacyByName(phName);
        for(String subEmail: pharmacy.getSubscribedEmails())
            if(subEmail.equals(email))
                throw new AlreadyExistsException("You are already subscribed to "+phName+" pharmacy.");
        pharmacy.getSubscribedEmails().add(email);
        pharmacyRepository.save(pharmacy);
    }

    public void unsubscribe(String email, String phName){
        Pharmacy pharmacy = getPharmacyByName(phName);
        if(!pharmacy.getSubscribedEmails().isEmpty()) {
            pharmacy.getSubscribedEmails().remove(email);
            pharmacyRepository.save(pharmacy);
        }
    }

    public Pharmacy getPharmacyByName(String phName){
        Pharmacy pharmacy = pharmacyRepository.findPharmacyByName(phName);
        if(pharmacy == null)
            throw new NotFoundException("Pharmacy "+phName+ " doesn't exists.");
        return pharmacy;
    }

    public List<PharmacyPriceDto> getPharmacyByEPrescription(EPrescription ePrescription){
        List<Long> codes = new ArrayList<>();
        for(MedicineEPrescription med: ePrescription.getListOfMedication())
            codes.add(med.getCode());
        List<MedicinePharmacy> pharmacyList = pharmacyRepository.findPharmaciesByMedicineEprescription(codes);
        if(pharmacyList.isEmpty())
            throw new NotFoundException("Not found.");
        List<PharmacyPriceDto> pharmacyPriceDtos = new ArrayList<>();
        for(MedicinePharmacy medicinePharmacy: pharmacyList){
            PharmacyPriceDto pharmacyPriceDto = new PharmacyPriceDto();
            pharmacyPriceDto.setPhName(medicinePharmacy.getPharmacy().getName());
            pharmacyPriceDto.setPrice(medicinePharmacy.getPrice());
            pharmacyPriceDtos.add(pharmacyPriceDto);
        }
        return pharmacyPriceDtos;
    }

    public void update(Pharmacy pharmacy){
        pharmacyRepository.save(pharmacy);
    }
}
