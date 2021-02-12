import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { UploadQrSevice } from 'src/app/service/upload-qr.service';
import { UserService } from 'src/app/service/user.service';
import { EPrescription } from '../../../model/e-prescription-model';

@Component({
  selector: 'app-upload-qr',
  templateUrl: './upload-qr.component.html',
  styleUrls: ['./upload-qr.component.css']
})
export class UploadQRComponent implements OnInit {

  viewEPrescription: boolean = false;
  ePrescription: any = {};
  file: any;
  pharmacies: any;
  pharmacy: any;

  constructor(private uploadQrService: UploadQrSevice, private router: Router, private toastrService: ToastrService,
    private userService: UserService) { }

  ngOnInit(): void {
    if(!this.userService.isPatient()){
      this.router.navigate(['home']);
      this.toastrService.info('Please log in first.');
    }
  }

  imageChoice(theEventFromHtml: any) {
    this.file = theEventFromHtml.target.files[0];
  }

  sendFile(): void {
    if (this.file !== null) {
      this.uploadQrService.uploadFiled(this.file).subscribe((returnedEPrescription: any) => {
        this.ePrescription = returnedEPrescription;
        this.viewEPrescription = true;
      },
      (err: any) => {
        this.toastrService.error('Error while reading QRcode ' + err.error.message);
      });
    }
  }

  send(){
    this.uploadQrService.order(this.ePrescription.code, this.pharmacy).subscribe((response: any)=>{
      this.toastrService.success("The order has been completed.");
      this.router.navigate(['home']);
    },(err: any) => {
      this.toastrService.error(err.error.message);
    });

  }
}

