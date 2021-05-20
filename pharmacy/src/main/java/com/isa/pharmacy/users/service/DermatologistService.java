package com.isa.pharmacy.users.service;

import com.isa.pharmacy.controller.dto.DermatologistDto;
import com.isa.pharmacy.controller.dto.VacationScheduleDto;
import com.isa.pharmacy.controller.exception.AlreadyExistsException;
import com.isa.pharmacy.controller.exception.InvalidActionException;
import com.isa.pharmacy.controller.exception.NotFoundException;
import com.isa.pharmacy.controller.mapping.DermatologistMapper;
import com.isa.pharmacy.domain.Pharmacy;
import com.isa.pharmacy.scheduling.domain.VacationSchedule;
import com.isa.pharmacy.scheduling.service.interfaces.IVacationService;
import com.isa.pharmacy.scheduling.service.interfaces.IWorkScheduleService;
import com.isa.pharmacy.service.interfaces.IExaminationService;
import com.isa.pharmacy.service.interfaces.IPharmacyService;
import com.isa.pharmacy.users.domain.Dermatologist;
import com.isa.pharmacy.users.domain.Pharmacist;
import com.isa.pharmacy.users.domain.PharmacyAdmin;
import com.isa.pharmacy.users.repository.DermatologistRepository;
import com.isa.pharmacy.users.service.interfaces.IDermatologistService;
import com.isa.pharmacy.users.service.interfaces.IPharmacyAdminService;
import com.isa.pharmacy.users.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class DermatologistService implements IDermatologistService {
    @Autowired
    private DermatologistRepository dermatologistRepository;
    @Autowired
    private IUserService userService;
    @Autowired
    private IVacationService vacationService;
    @Autowired
    private IWorkScheduleService workScheduleService;
    @Autowired
    private IExaminationService examinationService;
    @Autowired
    private IPharmacyService pharmacyService;
    @Autowired
    private IPharmacyAdminService pharmacyAdminService;

    public void delete(Dermatologist dermatologist){
        dermatologistRepository.delete(dermatologist);
    }

    public Dermatologist save(Dermatologist dermatologist){
        return dermatologistRepository.save(dermatologist);
    }

    public List<Dermatologist> getAll(){
        List<Dermatologist> dermatologistList = dermatologistRepository.findAll();
        if(dermatologistList.isEmpty())
            throw new NotFoundException("There is no dermatologist.");
        return dermatologistList;
    }

    public Dermatologist update(Dermatologist d) {
        Dermatologist dermatologist = dermatologistRepository.findDermatologistById(d.getId());
        if(dermatologist == null)
            throw new NotFoundException("Dermatologist doesn't exists.");
        dermatologist.setUser(d.getUser());
        dermatologistRepository.save(dermatologist);
        return dermatologist;
    }

    public Dermatologist registration(Dermatologist dermatologist) {
        Dermatologist existingUser = dermatologistRepository.findDermatologistByUser_email(dermatologist.getUser().getEmail());
        if (existingUser == null) {
            userService.create(dermatologist.getUser());
            return dermatologistRepository.save(dermatologist);
        }
        throw new AlreadyExistsException(String.format("Patient with email %s, already exists", dermatologist.getUser().getEmail()));
    }

    public Dermatologist findUserByEmail(String email){
        Dermatologist dermatologist = dermatologistRepository.findDermatologistByUser_email(email);
        if(dermatologist == null)
            throw new NotFoundException("Dermatologist with email: "+ email + "doesn't exists.");
        return dermatologist;
    }

    public List<DermatologistDto> dermatologistListByPharmacyName(String name){
        Pharmacy pharmacy = pharmacyService.getPharmacyByName(name);
        List<Dermatologist> dermatologistList = dermatologistRepository.findDermatologistByPharmacy_id(pharmacy.getId());
        List<DermatologistDto> dermatologistDtos = new ArrayList<DermatologistDto>();
        for (Dermatologist dermatologist:dermatologistList){
            dermatologistDtos.add(DermatologistMapper.mapDermatologistToDermatologistDto(dermatologist));
        }
        return dermatologistDtos;
    }

    public void deleteFromPharmacy(String email, String adminEmail){
        PharmacyAdmin admin = pharmacyAdminService.findPharmacyAdminByEmail(adminEmail);
        Pharmacy pharmacy = pharmacyService.getById(admin.getPharmacy().getId());
        Dermatologist dermatologist = dermatologistRepository.findDermatologistByUser_email(email);
        List<Pharmacy> pharmacyList =dermatologist.getPharmacy();
        if(!pharmacyList.contains(pharmacy)){
            throw new InvalidActionException("You are not allowed to delete this dermatologist");
        }
        pharmacyList.remove(pharmacy);
        dermatologist.setPharmacy(pharmacyList);
        update(dermatologist);
    }

    public boolean checkVacationTerm(VacationScheduleDto vacationScheduleDto, String email){
        VacationSchedule vacationSchedule = new VacationSchedule();
        Dermatologist dermatologist = dermatologistRepository.findDermatologistByUser_email(email);
        if(vacationScheduleDto == null || dermatologist == null){
            throw new NullPointerException("No parametars");
        }
        Date requiredStartDate = vacationScheduleDto.getStartDate();
        Date requiredEndDate = vacationScheduleDto.getEndDate();
        if(requiredStartDate.before(requiredEndDate) || requiredStartDate.equals(requiredEndDate) || requiredEndDate == null){
            boolean validVacationTerms = vacationService.compareDateWithVacations(vacationService.getVacationScheduleByDermatologist(email),
                    requiredStartDate, requiredEndDate);
            boolean validWorkTimeTerms = workScheduleService.compareDateWithWorkTime(workScheduleService.getWorkScheduleByDermatologist(email),
                    requiredStartDate, requiredEndDate);
            boolean validExaminationTerms = examinationService.compareDateWithExaminationTerm(dermatologist,
                    requiredStartDate, requiredEndDate);
            if(validExaminationTerms && validVacationTerms && validWorkTimeTerms){
                vacationSchedule.setStartDate(requiredStartDate);
                vacationSchedule.setEndDate(requiredEndDate);
                vacationService.save(vacationSchedule);
                List<VacationSchedule> dermatologistVaca = new ArrayList<>();
                for(VacationSchedule vs : dermatologist.getVacationSchedules()){
                    dermatologistVaca.add(vs);
                }
                dermatologistVaca.add(vacationSchedule);
                dermatologist.setVacationSchedules(dermatologistVaca);
                save(dermatologist);
                return true;
            }
        }else{
            throw new InvalidActionException("Start date can't be after end date.");
        }

        return false;
    }

}
