import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/service/user.service';
import { User, UserRegistrationDto } from '../model/user-model';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  user: UserRegistrationDto = { email: '', password: '', name: '', surname: '', address: '', city: '',
                              country: '', phone: ''};

  constructor(private userService: UserService) { }

  ngOnInit(): void {
  }

  registration(): void {
    this.userService.registration(this.user).subscribe((returnedUser: User) => {
      alert('User with email ' + returnedUser.email + ' registered');
    },
      (err: any) => {
        alert('Registration error ' + err.error.message);
      });
  }

}
