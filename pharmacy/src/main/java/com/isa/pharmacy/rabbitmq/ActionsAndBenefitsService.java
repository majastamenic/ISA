package com.isa.pharmacy.rabbitmq;

import com.isa.pharmacy.controller.exception.NotFoundException;
import com.isa.pharmacy.service.EmailService;
import com.isa.pharmacy.users.domain.PharmacyAdmin;
import com.isa.pharmacy.users.service.PharmacyAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActionsAndBenefitsService {
    @Autowired
    private PharmacyAdminService pharmacyAdminService;
    @Autowired
    private EmailService emailService;

    public void send(ActionsAndBenefits actionsAndBenefits, String phAdminEmail){
        PharmacyAdmin pharmacyAdmin = pharmacyAdminService.getByEmail(phAdminEmail);
        List<String> emails = pharmacyAdmin.getPharmacy().getSubscribedEmails();
        if(emails.isEmpty())
            throw new NotFoundException("Your pharmacy has no subscribers.");
        for(String email: emails){
            try {
                emailService.sendAction(actionsAndBenefits, email, pharmacyAdmin.getPharmacy().getName());
            }catch (Exception e){}
        }

    }
}
