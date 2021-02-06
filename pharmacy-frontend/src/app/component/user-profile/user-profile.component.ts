import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { PatientService } from 'src/app/service/patient.service';
import { UserService } from 'src/app/service/user.service';
import { PasswordChangeDto } from '../user/model/user-model';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

  patientAllergies: any = [];
  passwordChange: boolean;
  passwordDto: PasswordChangeDto;
  user : any;
  loggedUserRole = sessionStorage.getItem("role");


  constructor(private userService: UserService, 
              private patientService: PatientService,
              private router: Router, 
              private toastrService: ToastrService) { 
    this.passwordChange = false;
    this.passwordDto = {oldPassword: "", newPassword: "", newPasswordRepeat: ""}
  }

  ngOnInit(): void {
    let loggedUser = sessionStorage.getItem("user");
    if(loggedUser){
      let userRole = sessionStorage.getItem("role");
      if(userRole == 'PATIENT')
        this.patientService.getPatientByEmail(loggedUser).subscribe(data => {
          this.patientAllergies = data;
        }, error => {
          this.toastrService.error("Unknown error");
        });
      this.userService.getUserByEmail(loggedUser).subscribe((data:any) =>{
        this.user = data;
        console.log(data);
      }, error => {
        this.toastrService.error("Unknown error");
      });
    }
  }

  update(){
    this.userService.updateUser(this.user)
    .subscribe(data => {
      this.toastrService.success("User info updated successfully");
    }, error => {
      this.toastrService.error("Something went wrong while updating user's infos!");
    });
  }

  updatePassword(){
    this.userService.updatePassword(this.user.email, this.passwordDto)
    .subscribe(data => {
      this.router.navigate(['/home']);
      this.toastrService.success("Password change successfully");
    }, error => {
      this.toastrService.error("Something went wrong while updating password");
    });
  }
}
