import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from 'src/app/service/user.service';
import { LoginUserDto, User } from '../model/user-model';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user: any;

  constructor(private userService: UserService, private router: Router) { }

  ngOnInit(): void {
    this.user = { email: '', password: '' };
  }

  login(): void {
    this.userService.login(this.user).subscribe((returnedUser: User) => {
      sessionStorage.setItem('user', this.user);
      this.router.navigate(['/home']);
    },
      (err: any) => {
        alert('Error while login ' + err.error.message);
      });
  }
}
