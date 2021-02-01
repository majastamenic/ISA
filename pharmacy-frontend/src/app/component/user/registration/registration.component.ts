import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from 'src/app/service/user.service';
import { User, UserRegistrationDto } from '../model/user-model';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  user: any;
  verificationCode: string =  '';
  registered = false;

  constructor(private userService: UserService, private router: Router) { }

  ngOnInit(): void {
    this.user = { email: '', password: '', passwordAgain: '',name: '', surname: '', address: '', city: '',
    country: '', phone: '', role: 0};
  }

  registration(): void {
    this.userService.registration(this.user).subscribe((returnedUser: User) => {
      alert('Please check your email.');
      this.registered = true;
    },
      (err: any) => {
        alert('Registration error ' + err.error.message);
      });
  }

  verification(): void {
    this.userService.verification(this.user, this.verificationCode).subscribe((returnedUser: User) => {
      alert('User with email ' + returnedUser.email + ' is registered.');
      this.router.navigate(['/login']);
    },
      (err: any) => {
        alert('Error while verification ' + err.error.message);
      });
  }

}
