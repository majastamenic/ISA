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

  constructor(private userService: UserService, private router: Router) { }

  ngOnInit(): void {
    this.user = { email: '', password: '', passwordAgain: '',name: '', surname: '', address: '', city: '',
    country: '', phone: ''};
  }

  registration(): void {
    this.userService.registration(this.user).subscribe((returnedUser: User) => {
      alert('Please check your email.');
      this.router.navigate(['/verification']);
    },
      (err: any) => {
        alert('Registration error ' + err.error.message);
      });
  }

}
