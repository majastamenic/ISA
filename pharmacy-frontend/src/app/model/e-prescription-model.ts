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

export interface ePrescriptionClass {
    code: string;
    patientName: string;
    date: Date;
    medicines: Medicine[];
  }
  
  export interface Medicine{
    quantity: number;
    name: string; 
  }

