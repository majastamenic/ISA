import { Observable } from "rxjs";

export interface EPrescription {
    id: number;
    code: number;
    patientName: string;
    dateOfIssue: Date;
//    listOfMedication: Observable<MedicineEPrescription>;   
    fileText: string;
}

export interface MedicineEPrescription {
    id: number;
    code: number;
    name: string;
    quantity: number;
}

