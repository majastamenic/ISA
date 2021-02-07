package com.isa.pharmacy.controller.mapping;

import com.isa.pharmacy.controller.dto.CreateComplaintDto;
import com.isa.pharmacy.controller.dto.ShowComplaintDto;
import com.isa.pharmacy.domain.Complaint;
import com.isa.pharmacy.users.domain.Patient;

import java.util.ArrayList;
import java.util.List;

public class ComplaintMapper {

    public static Complaint mapComplaintDtoToComplaint(CreateComplaintDto createComplaintDto, Patient patient){
        Complaint complaint = new Complaint();
        complaint.setComplaintMessage(createComplaintDto.getSubject() + "\n" + createComplaintDto.getComplaintText());
        complaint.setPatient(patient);
        return complaint;
    }

    public static Complaint mapShowComplaintDtoToComplaint(ShowComplaintDto showComplaintDto, Patient patient){
        Complaint complaint = new Complaint();
        complaint.setId(showComplaintDto.getId());
        complaint.setPatient(patient);
        complaint.setComplaintMessage(showComplaintDto.getMessage());
        complaint.setResponseComplaint(showComplaintDto.getResponse());
        return complaint;
    }

    public static ShowComplaintDto mapComplaintToShowComplaintDto(Complaint complaint){
        ShowComplaintDto showComplaintDto = new ShowComplaintDto();
        showComplaintDto.setId(complaint.getId());
        showComplaintDto.setPatientName(complaint.getPatient().getUser().getName()+" "+complaint.getPatient().getUser().getSurname()+" "+complaint.getPatient().getUser().getEmail());
        showComplaintDto.setMessage(complaint.getComplaintMessage());
        showComplaintDto.setResponse(complaint.getResponseComplaint());
        return showComplaintDto;
    }

    public static List<ShowComplaintDto> mapComplaintsToComplaintsDto(List<Complaint> complaintList){
        List<ShowComplaintDto> showComplaintDtoList = new ArrayList<>();
        for(Complaint complaint: complaintList)
            showComplaintDtoList.add(mapComplaintToShowComplaintDto(complaint));
        return showComplaintDtoList;
    }
}
