import { logging } from "protractor";
import { Observable } from "rxjs";
import { Medicine } from "../../medicine/model/medicine-model";

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

export interface EPrescriptionDto{
    code: string;
    patientName: string;
    dateOfIssue: Date;
    listOfMedications: Observable<MedicineEPrescription>;
    pharmacyList: Observable<Pharmacy>;
}

export interface Pharmacy{
    id: number;
    name: string;
    address: string;
    medicinePharmaciest: Observable<MedicinePharmacy>;
}

export interface MedicinePharmacy{
    id: number;
    price: number;
    quantity: number;
    medicine: Medicine;
    pharmacy: Pharmacy;
}