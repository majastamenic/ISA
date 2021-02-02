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

  constructor(private userService: UserService, private router: Router, private toastrService: ToastrService) { }

  ngOnInit(): void {
    this.user = { email: '', password: '' };
  }

  login(): void {
    this.userService.login(this.user).subscribe((returnedUser: User) => {
      sessionStorage.setItem('user', this.user);
      this.router.navigate(['/home']);
      this.toastrService.success("User logged in successfully")
    },
      (err: any) => {
        this.toastrService.error(err.error.message)
      });
  }
}
