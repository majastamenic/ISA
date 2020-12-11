import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/service/user.service';
import { LoginUserDto, User } from '../model/user-model';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user: LoginUserDto = { email: '', password: '' };

  constructor(private userService: UserService) { }

  ngOnInit(): void {
  }

  login(): void {
    this.userService.login(this.user).subscribe((returnedUser: User) => {
      alert('User with email ' + returnedUser.email + ' logged in');
    },
      (err: any) => {
        alert('Error while login ' + err.error.message);
      });
  }
}
