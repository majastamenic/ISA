import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { PatientService } from 'src/app/service/patient.service';
import { UserService } from 'src/app/service/user.service';
import { PasswordChangeDto } from '../../model/user-model';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

  passwordChange: boolean = false;
  allergyChange: boolean = false;
  newAllergy: string = '';

  
  patientAllergies: any = [];
  passwordDto: PasswordChangeDto = {oldPassword: "", newPassword: "", newPasswordRepeat: ""};
  user : any;
  loggedUserRole = sessionStorage.getItem("role");

  constructor(private userService: UserService, 
              private patientService: PatientService,
              private router: Router, 
              private toastrService: ToastrService) { 
  }

  ngOnInit(): void {
    let loggedUser = sessionStorage.getItem("user");
    if(loggedUser){
      let userRole = sessionStorage.getItem("role");
      if(userRole == 'PATIENT')
        this.patientService.getPatientByEmail(loggedUser).subscribe((data:any) => {
          this.patientAllergies = data.allergicMedicines;
        }, error => {
          this.toastrService.error("Unknown error");
        });

      this.userService.getUserByEmail(loggedUser).subscribe((data:any) =>{
        this.user = data;
      }, error => {
        sessionStorage.clear();
        this.router.navigate(['login']);
        this.toastrService.error("Unknown error, please log in again");
      });
    }else {
      this.router.navigate(['login']);
      this.toastrService.info('Please log in first.');
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

  updatePatientAllergies(){
    this.patientService.updateAllergies(this.user.email, this.patientAllergies).subscribe(data => {
      this.toastrService.success('Allergies succesfully updated');
      this.allergyChange = false;
    }, error => {
      this.toastrService.error('An error has occured while updating allergies');
    });
  }
}
