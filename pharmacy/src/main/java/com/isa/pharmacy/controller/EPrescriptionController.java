package com.isa.pharmacy.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.isa.pharmacy.controller.exception.NotFoundException;
import com.isa.pharmacy.controller.mapping.EPrescriptionMapper;
import com.isa.pharmacy.domain.EPrescription;
import com.isa.pharmacy.service.EPrescriptionService;
import com.isa.pharmacy.service.QRService;

@RestController
@RequestMapping("/ePrescription")
@CrossOrigin(value = "http://localhost:4200")
public class EPrescriptionController {

    @Autowired
    private EPrescriptionService ePrescriptionService;
    @Autowired
    private QRService qrService;


    private final String baseFileDestination;

    public EPrescriptionController() {
        baseFileDestination = new File("").getAbsolutePath().concat("/qrcodes/");
    }

    @GetMapping("/{id}")
    public EPrescription getEPrescription(@PathVariable("id") Long id) {
        EPrescription ePrescription = ePrescriptionService.getById(id);
        if (ePrescription == null) {
            throw new NotFoundException(String.format("User with id %s not found", id));
        }
        return ePrescription;
    }

    @PostMapping
    public EPrescription saveByText(@RequestBody String text) {
        EPrescription ePrescription = EPrescriptionMapper.mapStringToEPrescription(text);
        ePrescription = ePrescriptionService.save(ePrescription);
        return ePrescription;
    }

    @PostMapping("/uploadQr")
    public ResponseEntity<EPrescription> searchQrCode(@RequestParam("file") MultipartFile file) throws IOException, ParseException {
        if (file.isEmpty()) {
            throw new RuntimeException("File is empty!");
        }
        byte[] bytes = file.getBytes();
        BufferedOutputStream stream =
                new BufferedOutputStream(new FileOutputStream(new File(baseFileDestination + file.getOriginalFilename())));
        stream.write(bytes);
        stream.close();

        String text = qrService.readQrCode(baseFileDestination + file.getOriginalFilename());
        System.out.println(text);

        EPrescription ePrescription = ePrescriptionService.getByText(text);

        return ResponseEntity.ok(ePrescription);
    }


}
