package com.isa.pharmacy.controller.mapping;

import com.isa.pharmacy.controller.dto.CreateComplaintDto;
import com.isa.pharmacy.domain.Complaint;
import com.isa.pharmacy.users.domain.Patient;
import com.isa.pharmacy.users.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;

public class ComplaintMapper {

    public static Complaint mapComplaintDtoToComplaint(CreateComplaintDto createComplaintDto, Patient patient){
        Complaint complaint = new Complaint();
        complaint.setComplaintMessage(createComplaintDto.getSubject() + "\n" + createComplaintDto.getComplaintText());
        complaint.setPatient(patient);
        return complaint;
    }
}
