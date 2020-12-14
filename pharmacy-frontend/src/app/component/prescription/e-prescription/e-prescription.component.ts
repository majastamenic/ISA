import { Component, OnInit } from '@angular/core';
import { EPrescription } from '../model/e-prescription-model';
import { UploadQRComponent } from '../upload-qr/upload-qr.component';

@Component({
  selector: 'app-e-prescription',
  templateUrl: './e-prescription.component.html',
  styleUrls: ['./e-prescription.component.css']
})
export class EPrescriptionComponent implements OnInit {

  ePrescription: EPrescription | undefined;
  
  constructor() {
    
   }

  
  ngOnInit(): void {
//    this.ePrescription = JSON.parse(localStorage.getItem('ePrescription'));
  }



}
