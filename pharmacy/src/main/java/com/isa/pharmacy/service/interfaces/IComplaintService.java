package com.isa.pharmacy.service.interfaces;

import com.isa.pharmacy.domain.Complaint;

import java.util.List;

public interface IComplaintService {

     List<Complaint> getAll();

     void save(Complaint complaint);

     List<String> getComplaintType(String email);

     Complaint addResponse(Complaint complaint);

     void delete(Long id);
}
