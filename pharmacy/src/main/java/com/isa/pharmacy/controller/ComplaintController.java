package com.isa.pharmacy.controller;

import com.isa.pharmacy.service.ComplaintService;
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

    @GetMapping("/{email}")
    public List<String> getComplaintType(@PathVariable String email){
        return complaintService.getComplaintType(email);
    }
}
