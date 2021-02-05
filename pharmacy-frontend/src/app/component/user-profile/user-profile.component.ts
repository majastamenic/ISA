import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from 'src/app/service/user.service';
import { PasswordChangeDto } from '../user/model/user-model';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

  patient: any;
  passwordChange: boolean;
  passwordDto: PasswordChangeDto;
  user : any;
  loggedUserRole = sessionStorage.getItem("role");


  constructor(private userService: UserService, private router: Router) { 
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
    this.userService.updateUser(this.user)
    .subscribe(data => {
      alert("User info updated successfully");
    }, error => {
      alert("Something went wrong while updating user's infos!");
    });
  }

  updatePassword(){
    this.userService.updatePassword(this.user.email, this.passwordDto)
    .subscribe(data => {
      alert("Password change successfully");
      this.router.navigate(['/home'])
    }, error => {
      alert("Something went wrong while updating password");
    });
  }
}
