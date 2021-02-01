package com.isa.pharmacy.controller.mapping;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.isa.pharmacy.domain.EPrescription;
import com.isa.pharmacy.domain.MedicineEPrescription;

public class EPrescriptionMapper {

    public static EPrescription mapStringToEPrescription(String text) {
        EPrescription ePrescription = new EPrescription();
        String[] parts = text.split("\\r?\\n");
        String[] textParts = parts[1].split(":");
        String textObj = textParts[1];
        textObj = textObj.substring(2, textObj.length() - 1);

        String[] splitText = textObj.split(" ");

        String note = splitText[0] + " " + splitText[1] + "\n" + splitText[2] + "\n" + splitText[3] + "\n" + splitText[4] + "\n" + splitText[5];

        ePrescription.setFileText(note);
        ePrescription.setPatientName(splitText[0] + " " + splitText[1]);
        ePrescription.setCode(Long.parseLong(splitText[2]));
        ePrescription.setDateOfIssue(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()));

        List<MedicineEPrescription> listMedicine = new ArrayList<>();
        MedicineEPrescription medicineEPrescription = new MedicineEPrescription();
        medicineEPrescription.setCode(new Random().nextLong());
        medicineEPrescription.setName(splitText[4]);
        medicineEPrescription.setQuantity(Integer.parseInt(splitText[5]));

        listMedicine.add(medicineEPrescription);

        ePrescription.setListOfMedication(listMedicine);

        return ePrescription;
    }
}
