package com.isa.pharmacy.controller;

import com.isa.pharmacy.controller.dto.EPrescriptionDto;
import com.isa.pharmacy.controller.dto.PharmacyPriceDto;
import com.isa.pharmacy.controller.exception.NotFoundException;
import com.isa.pharmacy.controller.mapping.EPrescriptionMapper;
import com.isa.pharmacy.domain.EPrescription;
import com.isa.pharmacy.domain.Pharmacy;
import com.isa.pharmacy.service.EPrescriptionService;
import com.isa.pharmacy.service.PharmacyService;
import com.isa.pharmacy.service.QRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

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
        if (ePrescription == null)
            throw new NotFoundException(String.format("User with id %s not found", id));
        return ePrescription;
    }

    @PostMapping
    public EPrescription saveByText(@RequestBody String text) {
        EPrescription ePrescription = EPrescriptionMapper.mapStringToEPrescription(text);
        return ePrescriptionService.save(ePrescription);
    }

    @PostMapping("/uploadQr")
    public EPrescriptionDto searchQrCode(@RequestParam("file") MultipartFile file) throws IOException, ParseException {
        if (file.isEmpty()) throw new RuntimeException("File is empty!");
        byte[] bytes = file.getBytes();

        try (BufferedOutputStream stream = new BufferedOutputStream(
                new FileOutputStream(baseFileDestination + file.getOriginalFilename()))){
            stream.write(bytes);
        }catch (Exception e){
            e.printStackTrace();
        }
        String text = qrService.readQrCode(baseFileDestination + file.getOriginalFilename());
        System.out.println(text);

        EPrescription ePrescription = ePrescriptionService.getByText(text);
        List<PharmacyPriceDto> pharmacyPriceDtoList = ePrescriptionService.getPharmacy(ePrescription);

        return EPrescriptionMapper.mapEPrescriptionToEPrescriptionDto(ePrescription, pharmacyPriceDtoList);
    }

    @PutMapping("/order/{code}/{phName}")
    public void order(@PathVariable Long code, @PathVariable String phName){
        ePrescriptionService.order(code, phName);
    }


}
