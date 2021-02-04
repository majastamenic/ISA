import { Component, OnInit } from '@angular/core';
import { PatientService } from 'src/app/service/patient.service';
import { UserService } from 'src/app/service/user.service';
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
  user : any;
  loggedUserRole = sessionStorage.getItem("role");


  constructor(private patientService: PatientService, private userService: UserService) { 
    this.passwordChange = false;
    this.passwordDto = {oldPassword: "", newPassword: "", newPasswordRepeat: ""}
  }

  ngOnInit(): void {
    let loggedUser = sessionStorage.getItem("user");
    
    if(loggedUser){
      this.userService.getUserByEmail(loggedUser).subscribe((data:any) =>{
        this.user = data;
        console.log(data);
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
