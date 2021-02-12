import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { UserService } from 'src/app/service/user.service';
import { User } from '../../../model/user-model';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  user: any;
  verificationCode: string =  '';

  constructor(private userService: UserService, private router: Router, private toastrService: ToastrService) { }

  ngOnInit(): void {
    this.user = { email: '', password: '', passwordAgain: '',name: '', surname: '', address: '', city: '',
    country: '', phone: '', role: 0};
  }

  registration(): void {
    this.userService.registration(this.user).subscribe((returnedUser: User) => {
      this.toastrService.success('Please check your email.');
      this.router.navigate(['/login']);
    },
      (err: any) => {
        this.toastrService.error('Registration error ' + err.error.message);
      });
  }
}
