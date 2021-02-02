import { Component, OnInit } from '@angular/core';
import { PatientService } from 'src/app/service/patient.service';
import { Patient } from '../user/model/user-model';

@Component({
  selector: 'app-patient-profile',
  templateUrl: './patient-profile.component.html',
  styleUrls: ['./patient-profile.component.css']
})
export class PatientProfileComponent implements OnInit {

  patient: any;

  constructor(private patientService: PatientService) { }

  ngOnInit(): void {
    let loggedUser = sessionStorage.getItem("user");
    
    if(loggedUser){
      this.patientService.getPatientByEmail(loggedUser).subscribe(data => {
        this.patient = data;
      });
    }
  }

  update(){
    this.patientService.updatePatient(this.patient).subscribe(data =>{
      alert("Uspesno azuriran pacijent");
    });
  }
}
