package com.isa.pharmacy.controller;

import com.isa.pharmacy.controller.dto.CounselingDto;
import com.isa.pharmacy.controller.mapping.CounselingMapper;
import com.isa.pharmacy.domain.Counseling;
import com.isa.pharmacy.users.domain.Patient;
import com.isa.pharmacy.users.domain.Pharmacist;
import com.isa.pharmacy.domain.Report;
import com.isa.pharmacy.service.CounselingService;
import com.isa.pharmacy.users.service.PatientService;
import com.isa.pharmacy.users.service.PharmacistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/counseling")
public class CounselingController {

    @Autowired
    private CounselingService counselingService;
    @Autowired
    private PharmacistService pharmacistService;
    @Autowired
    private PatientService patientService;

    @PostMapping("/add")
    public Counseling save(@RequestBody CounselingDto counselingDto) {
        Pharmacist pharmacist = pharmacistService.findUserByEmail(counselingDto.getEmail());
        Patient patient = patientService.getPatient(counselingDto.getPatientEmail());
        Counseling counseling = CounselingMapper.mapCounselingDtoToCounseling(counselingDto, pharmacist, patient);
        counseling.setReport(new Report());
        return counselingService.save(counseling);
    }

    @GetMapping
    public List<Counseling> getAll() { return counselingService.getAll(); }

    @GetMapping("/{email}")
    public List<CounselingDto> getAllByPharmacist(@PathVariable("email") String email) {
        Pharmacist pharmacist = pharmacistService.findUserByEmail(email);
        return counselingService.getAllByPharmacist(pharmacist);
    }

    @PostMapping("/update")
    public Counseling update(@RequestBody Counseling c) { return counselingService.save(c); }
}
