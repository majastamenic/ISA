package com.isa.pharmacy.controller;

import com.isa.pharmacy.controller.dto.CounselingCreateDto;
import com.isa.pharmacy.controller.dto.CounselingDto;
import com.isa.pharmacy.controller.dto.CounselingFullDto;
import com.isa.pharmacy.controller.mapping.CounselingMapper;
import com.isa.pharmacy.domain.Counseling;
import com.isa.pharmacy.scheduling.DateManipulation;
import com.isa.pharmacy.service.interfaces.ICounselingService;
import com.isa.pharmacy.users.domain.Pharmacist;
import com.isa.pharmacy.users.service.interfaces.IPatientService;
import com.isa.pharmacy.users.service.interfaces.IPharmacistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/counseling")
@CrossOrigin(origins ={ "http://localhost:4200", "https://pharmacy-25-frontend.herokuapp.com"})
public class CounselingController {

    @Autowired
    private ICounselingService counselingService;
    @Autowired
    private IPharmacistService pharmacistService;
    @Autowired
    private IPatientService patientService;


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
            counselingDto.serScheduleEndTime(DateManipulation.addMinutes(counselingDto.getSchedule().getStartTime(), 15));
        Counseling counseling = CounselingMapper.mapCounselingCreateDtoToCounseling(counselingDto);
        counseling.setPatient(patientService.getPatient(counselingDto.getPatientEmail()));
        counseling.setPharmacist(pharmacistService.findUserByEmail(counselingDto.getPharmacistEmail()));
        return CounselingMapper.mapCounselingToCounselingFullDto(counselingService.createCounseling(counseling));
    }

    @PostMapping("/update")
    public CounselingDto updateCounseling(@RequestBody CounselingDto counseling) { return counselingService.updateCounseling(counseling); }

    @PostMapping("create/pharmacist")
    public boolean createCounselingByPharmacist(@RequestBody CounselingCreateDto counselingCreateDto){
        return  counselingService.createCounselingByPharmacist(counselingCreateDto);
    }

    @DeleteMapping("/{counselingId}")
    public void cancelCounseling(@PathVariable long counselingId){
        counselingService.cancelCounseling(counselingId);
    }


    @GetMapping("/find/{email}/{name}/{surname}")
    public List<CounselingDto> findCounselingByPatient(@PathVariable("email") String email, @PathVariable("name") String name, @PathVariable("surname") String surname){
        return counselingService.findCounselingByPatient(email, name, surname);
    }

}
