import { Component, OnInit } from '@angular/core';
import { HospitalService } from 'src/app/service/hospital.service.service';
import { HospitalRegistrationDto, Hospital } from './model/hospital-model';

@Component({
  selector: 'app-hospital',
  templateUrl: './hospital.component.html',
  styleUrls: ['./hospital.component.css']
})
export class HospitalComponent implements OnInit {

  hospital: HospitalRegistrationDto = {email: '', name: ''};
  selectedPharmacy =  '';

  pharmacies: string[] = ['Jankovic'];


  constructor(private hospitalService: HospitalService) { }

  ngOnInit(): void {
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
