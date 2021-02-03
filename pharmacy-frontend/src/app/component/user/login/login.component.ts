import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { UserService } from 'src/app/service/user.service';
import { LoginUserDto, User } from '../model/user-model';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user: any;
  changePassword: boolean = false;

  constructor(private userService: UserService, private router: Router, private toastrService: ToastrService) { }

  ngOnInit(): void {
    this.user = { email: '', password: '' };
  }

  login(): void {
    this.userService.login(this.user).subscribe((returnedUser: User) => {
      if(!this.user.active){
        this.changePassword = true;
        this.toastrService.warning("Please change your password");
      }else{
        sessionStorage.setItem('user', this.user.email);
        this.router.navigate(['/home']);
        this.toastrService.success("User logged in successfully")
      }
    },
      (err: any) => {
        this.toastrService.error(err.error.message)
      });
  }
  savePassword():void{
    this.userService.saveUser(this.user).subscribe((returnedUser: User) => {
      sessionStorage.setItem('user', this.user.email);
      this.router.navigate(['/home']);
      this.toastrService.success("User logged in successfully")
    },
    (err: any) => {
      this.toastrService.error(err.error.message)
    });
  }
}
