package com.isa.pharmacy.service;

import com.isa.pharmacy.controller.exception.AlreadyExistsException;
import com.isa.pharmacy.controller.exception.NotFoundException;
import com.isa.pharmacy.domain.Complaint;
import com.isa.pharmacy.repository.ComplaintRepository;
import com.isa.pharmacy.service.interfaces.*;
import com.isa.pharmacy.users.domain.Patient;
import com.isa.pharmacy.users.service.interfaces.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ComplaintService implements IComplaintService {
    @Autowired
    private ComplaintRepository complaintRepository;
    @Autowired
    private IPatientService patientService;
    @Autowired
    private ICounselingService counselingService;
    @Autowired
    private IExaminationService examinationService;
    @Autowired
    private IPharmacyService pharmacyService;
    @Autowired
    private IEmailService emailService;

    public List<Complaint> getAll(){
        List<Complaint> complaintList = complaintRepository.findAll();
        if(complaintList.isEmpty())
            throw new NotFoundException("There is no complaints.");
        return complaintList;
    }

    public void save(Complaint complaint){
        complaintRepository.save(complaint);
    }

    public List<String> getComplaintType(String email){
        Patient patient = patientService.getPatient(email);
        List<String> types = new ArrayList<>();
        types.addAll(counselingService.getPharmacistNameByPatient(patient));
        types.addAll(examinationService.getDermatologistNameByPatient(patient));
        types.addAll(pharmacyService.getPharmacyName());

        if(types.isEmpty())
            throw new NotFoundException("You were not in contact with either the pharmacy or their employees.");

        return types;
    }

    public Complaint addResponse(Complaint complaint){
        Complaint dbComplaint = complaintRepository.findComplaintById(complaint.getId());
        if(dbComplaint == null)
            throw new NotFoundException("Complaint doesn't exists.");
        if(dbComplaint.getResponseComplaint() != null)
            throw new AlreadyExistsException("Complaint response already exists");
        dbComplaint.setResponseComplaint(complaint.getResponseComplaint());
        try {
            emailService.sendComplaintResponse(complaint);
        }catch (Exception e){}

        return dbComplaint;
    }

    public void delete(Long id){
        Complaint complaint = complaintRepository.findComplaintById(id);
        if(complaint == null)
            throw new NotFoundException("Complaint doesn't exists already.");
        complaintRepository.delete(complaint);
    }
}
