import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { User, UserRegistrationDto } from 'src/app/component/user/model/user-model';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-reg-dermatologist',
  templateUrl: './reg-dermatologist.component.html',
  styleUrls: ['./reg-dermatologist.component.css']
})
export class RegDermatologistComponent implements OnInit {

  user: UserRegistrationDto = { email: '', password: '', passwordAgain: '', name: '', surname: '', address: '', city: '',
  country: '', phone: '', role: 2};

  constructor(private userService: UserService, private toastrService:ToastrService) { }

  ngOnInit(): void {
  }

  
  registration(): void {
    this.userService.registrationDermatologist(this.user).subscribe((returnedUser: User) => {
      this.toastrService.success('Added new dermatologist.');
    },
      (err: any) => {
        this.toastrService.error('Registration error ' + err.error.message);
      });
  }

}
