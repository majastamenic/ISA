import { Observable } from "rxjs";

export interface EPrescription {
    id: number;
    code: string;
    patientName: string;
    dateOfIssue: Date;
    listOfMedication: Observable<MedicineEPrescription>;   
    note: string;
}

export interface MedicineEPrescription {
    id: number;
    code: number;
    name: string;
    quantity: number;
}