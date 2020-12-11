import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { HospitalService } from 'src/app/service/hospital.service';
import { PharmacyService } from 'src/app/service/pharmacy.service';
import { HospitalRegistrationDto, Hospital } from './model/hospital-model';

@Component({
  selector: 'app-hospital',
  templateUrl: './hospital.component.html',
  styleUrls: ['./hospital.component.css']
})
export class HospitalComponent implements OnInit {

  hospital: HospitalRegistrationDto = {email: '', name: '', pharmacy: {}};
  selectedPharmacy: any;

  pharmacies: any;


  constructor(private hospitalService: HospitalService, private pharmacyService: PharmacyService) { }

  ngOnInit(): void {
    this.pharmacyService.getAll().subscribe(listPharmacy => {
      this.pharmacies = listPharmacy;
    });
  }


  registration(): void{
    this.hospitalService.send(this.hospital);
    this.hospitalService.registration(this.hospital).subscribe((returnedHospital: Hospital) => {
      alert('Welcome ' + returnedHospital.email + ' .\n' + 'Please check you email.');
    },
      (err: any) => {
        alert('Error while registered ' + err.error.message);
      });
  }

}
