import { Component, OnInit } from '@angular/core';
import { PatientService } from 'src/app/service/patient.service';
import { PasswordChangeDto, Patient } from '../user/model/user-model';

@Component({
  selector: 'app-patient-profile',
  templateUrl: './patient-profile.component.html',
  styleUrls: ['./patient-profile.component.css']
})
export class PatientProfileComponent implements OnInit {

  patient: any;
  passwordChange: boolean;
  passwordDto: PasswordChangeDto;


  constructor(private patientService: PatientService) { 
    this.passwordChange = false;
    this.passwordDto = {oldPassword: "", newPassword: "", newPasswordRepeat: ""}
  }

  ngOnInit(): void {
    let loggedUser = sessionStorage.getItem("user");
    let loggedUserRole = sessionStorage.getItem("role");
    
    if(loggedUser){
      this.patientService.getPatientByEmail(loggedUser)
      .subscribe(data => {
        this.patient = data;
      });
    }
  }

  update(){
    this.patientService.updatePatient(this.patient)
    .subscribe(data => {
      alert("Patient info updated successfully");
    }, error => {
      alert("Something went wrong while updating patient info!");
    });
  }

  updatePassword(){
    this.patientService.updatePassword(this.patient.user.email, this.passwordDto)
    .subscribe(data => {
      alert("Password change successfully");
    }, error => {
      alert("Something went wrong while updating password");
    });
  }
}
