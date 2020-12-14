import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { EPrescription, MedicineEPrescription } from '../model/e-prescription-model';
import { UploadQRComponent } from '../upload-qr/upload-qr.component';

@Component({
  selector: 'app-e-prescription',
  templateUrl: './e-prescription.component.html',
  styleUrls: ['./e-prescription.component.css']
})
export class EPrescriptionComponent implements OnInit {

  ePrescription: EPrescription | undefined;
  medicinesList: Medicine[] = [
    {
      quantity: 1,
      name: 'brufen'
    },
    {
      quantity: 2,
      name: 'aspirin'
    }
  ];
  ePrescriptionObj: ePrescriptionClass = {code: '5472012479531', patientName: 'Marko Markovic',
  date: new Date(2013, 9, 22), medicines: this.medicinesList};
  medication: MedicineEPrescription = {
    id: 1,
    code:2342144,
    name: 'brufen',
    quantity: 2,
  }
  constructor() {}

  
  
  ngOnInit(): void {
    let objectFromStorage = localStorage.getItem('ePrescription');
    if (objectFromStorage) {
      this.ePrescription = JSON.parse(objectFromStorage);
      console.log(this.ePrescription);
    }
  }
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
