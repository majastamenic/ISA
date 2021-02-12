package com.isa.pharmacy.controller;

import com.isa.pharmacy.controller.dto.EPrescriptionDto;
import com.isa.pharmacy.controller.dto.PharmacyPriceDto;
import com.isa.pharmacy.controller.exception.NotFoundException;
import com.isa.pharmacy.controller.mapping.EPrescriptionMapper;
import com.isa.pharmacy.domain.EPrescription;
import com.isa.pharmacy.service.interfaces.IEPrescriptionService;
import com.isa.pharmacy.service.interfaces.IQrService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/ePrescription")
@CrossOrigin(origins ={ "http://localhost:4200", "https://pharmacy-25-frontend.herokuapp.com"})
public class EPrescriptionController {
    private static final Logger logger = LoggerFactory.getLogger(EPrescriptionController.class);

    @Autowired
    private IEPrescriptionService ePrescriptionService;
    @Autowired
    private IQrService qrService;

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

    @GetMapping("/patient/{patientEmail}")
    public List<EPrescriptionDto> getEprescriptionsByPatientEMail(@PathVariable String patientEmail){
        return EPrescriptionMapper.mapListEPrescriptionToEPrescriptionDto(ePrescriptionService.getByPatientEmail(patientEmail));
    }

    @PostMapping
    public EPrescription saveByText(@RequestBody String text) {
        EPrescription ePrescription = EPrescriptionMapper.mapStringToEPrescription(text);
        return ePrescriptionService.save(ePrescription);
    }

    @PostMapping("/uploadQr")
    public EPrescriptionDto searchQrCode(@RequestParam("file") MultipartFile file) throws IOException {
        if (file.isEmpty()) throw new RuntimeException("File is empty!");
        byte[] bytes = file.getBytes();

        try (BufferedOutputStream stream = new BufferedOutputStream(
                new FileOutputStream(baseFileDestination + file.getOriginalFilename()))){
            stream.write(bytes);
        }catch (Exception e){
            logger.error(e.getMessage());
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
