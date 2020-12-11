import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-e-prescription',
  templateUrl: './e-prescription.component.html',
  styleUrls: ['./e-prescription.component.css']
})
export class EPrescriptionComponent implements OnInit {

  public myAngularxQrCode = '';
  medicinesList: Medicine[] = [
    {
      name: 'brufen'
    },
    {
      name: 'aspirin'
    }
  ];
  ePrescription: ePrescriptionClass = {code: '234532', patientName: 'Marko Markovic',
  date: new Date(2013, 9, 22), medicines: this.medicinesList};
  constructor() {
    this.myAngularxQrCode = `BEGIN QRCODE:


    NAME: EPrescription


    CHANNEL: ePrescription


    DATE: 2020-12-12`;

  }

  ngOnInit(): void {

  }

}

// tslint:disable-next-line: class-name
export interface ePrescriptionClass {
  code: string;
  patientName: string;
  date: Date;
  medicines: Medicine[];
}

export interface Medicine {
  name: string;
}
