package com.isa.pharmacy.controller;

import com.isa.pharmacy.controller.dto.CounselingCreateDto;
import com.isa.pharmacy.controller.dto.CounselingDto;
import com.isa.pharmacy.controller.dto.CounselingFullDto;
import com.isa.pharmacy.controller.mapping.CounselingMapper;
import com.isa.pharmacy.domain.Counseling;
import com.isa.pharmacy.scheduling.DateConvert;
import com.isa.pharmacy.service.CounselingService;
import com.isa.pharmacy.users.domain.Pharmacist;
import com.isa.pharmacy.users.service.PatientService;
import com.isa.pharmacy.users.service.PharmacistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/counseling")
@CrossOrigin(value = "http://localhost:4200")
public class CounselingController {

    @Autowired
    private CounselingService counselingService;
    @Autowired
    private PharmacistService pharmacistService;
    @Autowired
    private PatientService patientService;


    @GetMapping
    public List<Counseling> getAll() { return counselingService.getAll(); }

    @GetMapping("/start/{id}")
    public CounselingDto getById(@PathVariable("id") long id) {
        return CounselingMapper.mapCounselingToCounselingDto(counselingService.getCounselingById(id));
    }

    @GetMapping("/{email}")
    public List<CounselingDto> getCounselingByPharmacist(@PathVariable("email") String email) {
        Pharmacist pharmacist = pharmacistService.findUserByEmail(email);
        return CounselingMapper.mapListCounselingToCounselingDto(
                counselingService.getCounselingByPharmacist(pharmacist));
    }

    @GetMapping("/patient/{email}")
    public List<CounselingFullDto> getAllCounselingsByPatient(@PathVariable String email){
        return CounselingMapper.mapListCounselingToCounsellingFullDto(counselingService.getAllPatientsCounselings(email));
    }

    @PostMapping("/add")
    public CounselingFullDto createCounseling(@RequestBody CounselingCreateDto counselingDto) {
        if(counselingDto.getSchedule().getEndTime() == null)
            DateConvert.addMinutes(counselingDto.getSchedule().getStartTime(), 15); // TODO: Dovrsiti ubacivanje vremena
        Counseling counseling = CounselingMapper.mapCounselingCreateDtoToCounseling(counselingDto);
        counseling.setPatient(patientService.getPatient(counselingDto.getPatientEmail()));
        counseling.setPharmacist(pharmacistService.findUserByEmail(counselingDto.getPharmacistEmail()));
        return CounselingMapper.mapCounselingToCounselingFullDto(counselingService.createCounseling(counseling));
    }

    //TODO: Masa
    /*
    @PostMapping("/update")
    public Counseling updateCounseling(@RequestBody CounselingDto c) { return counselingService.updateCounseling(c); }
    */

}
