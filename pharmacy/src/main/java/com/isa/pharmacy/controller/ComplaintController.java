package com.isa.pharmacy.controller;

import com.isa.pharmacy.controller.dto.CreateComplaintDto;
import com.isa.pharmacy.controller.mapping.ComplaintMapper;
import com.isa.pharmacy.domain.Complaint;
import com.isa.pharmacy.service.ComplaintService;
import com.isa.pharmacy.users.domain.Patient;
import com.isa.pharmacy.users.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/complaint")
@CrossOrigin(value = "http://localhost:4200")
public class ComplaintController {
    @Autowired
    private ComplaintService complaintService;
    @Autowired
    private PatientService patientService;

    @GetMapping("/{email}")
    public List<String> getComplaintType(@PathVariable String email){
        return complaintService.getComplaintType(email);
    }

    @PostMapping
    public void save(@RequestBody CreateComplaintDto createComplaintDto){
        Patient patient = patientService.getPatient(createComplaintDto.getPatientEmail());
        complaintService.save(ComplaintMapper.mapComplaintDtoToComplaint(createComplaintDto, patient));
    }

}
