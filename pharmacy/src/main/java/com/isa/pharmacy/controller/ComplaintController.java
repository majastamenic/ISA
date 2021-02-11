package com.isa.pharmacy.controller;

import com.isa.pharmacy.controller.dto.CreateComplaintDto;
import com.isa.pharmacy.controller.dto.ShowComplaintDto;
import com.isa.pharmacy.controller.mapping.ComplaintMapper;
import com.isa.pharmacy.domain.Complaint;
import com.isa.pharmacy.service.ComplaintService;
import com.isa.pharmacy.users.domain.Patient;
import com.isa.pharmacy.users.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/complaint")
@CrossOrigin(origins ={ "http://localhost:4200", "https://pharmacy-25-frontend.herokuapp.com"})
public class ComplaintController {
    @Autowired
    private ComplaintService complaintService;
    @Autowired
    private PatientService patientService;

    @GetMapping
    public List<ShowComplaintDto> getAll(){
        return ComplaintMapper.mapComplaintsToComplaintsDto(complaintService.getAll());
    }

    @GetMapping("/{email}")
    public List<String> getComplaintType(@PathVariable String email){
        return complaintService.getComplaintType(email);
    }

    @PostMapping
    public void save(@RequestBody CreateComplaintDto createComplaintDto){
        Patient patient = patientService.getPatient(createComplaintDto.getPatientEmail());
        complaintService.save(ComplaintMapper.mapComplaintDtoToComplaint(createComplaintDto, patient));
    }

    @PutMapping
    public ShowComplaintDto addResponse(@RequestBody ShowComplaintDto showComplaintDto){
        Patient patient = patientService.getPatient(showComplaintDto.getPatientName().split(" ")[2]);
        Complaint complaint = ComplaintMapper.mapShowComplaintDtoToComplaint(showComplaintDto, patient);
        return ComplaintMapper.mapComplaintToShowComplaintDto(complaintService.addResponse(complaint));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        complaintService.delete(id);
    }

}
