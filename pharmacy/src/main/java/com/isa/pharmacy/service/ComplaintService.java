package com.isa.pharmacy.service;

import com.isa.pharmacy.repository.ComplaintRepository;
import com.isa.pharmacy.users.domain.Patient;
import com.isa.pharmacy.users.domain.User;
import com.isa.pharmacy.users.service.PatientService;
import com.isa.pharmacy.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ComplaintService {
    @Autowired
    private ComplaintRepository complaintRepository;
    @Autowired
    private PatientService patientService;
    @Autowired
    private CounselingService counselingService;

    public List<String> getComplaintType(String email){
        Patient patient = patientService.getPatient(email);
        List<String> types = new ArrayList<>();

        types.addAll(counselingService.getPharmacistNameByPatient(patient));


        return types;
    }
}
