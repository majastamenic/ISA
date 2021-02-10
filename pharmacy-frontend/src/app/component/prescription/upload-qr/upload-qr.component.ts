import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { UploadQrSevice } from 'src/app/service/upload-qr.service';
import {  EPrescription } from '../model/e-prescription-model';

@Component({
  selector: 'app-upload-qr',
  templateUrl: './upload-qr.component.html',
  styleUrls: ['./upload-qr.component.css']
})
export class UploadQRComponent implements OnInit {

  private file: any;
  public  ePrescription!: EPrescription;

  constructor(private uploadQrService: UploadQrSevice, private router: Router, private toastrService: ToastrService) { 
    
  }

  ngOnInit(): void {
  }


  imageChoice(theEventFromHtml: any) {
    this.file = theEventFromHtml.target.files[0];
  }

  sendFile(): void {
    if (this.file !== null) {
      this.uploadQrService.uploadFiled(this.file).subscribe((returnedEPrescription: EPrescription) => {
        this.ePrescription = returnedEPrescription;
        localStorage.setItem('ePrescription', JSON.stringify(returnedEPrescription));
        this.router.navigate(['ePrescription']);
      }, 
      (err: any) => {
        this.toastrService.error('Error while reading QRcode ' + err.error.message);
      }); 
    }
  }
}

