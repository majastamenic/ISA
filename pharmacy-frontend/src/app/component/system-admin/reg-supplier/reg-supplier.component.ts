import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { User, UserRegistrationDto } from 'src/app/model/user-model';
import { UserService } from 'service/user.service';

@Component({
  selector: 'app-reg-supplier',
  templateUrl: './reg-supplier.component.html',
  styleUrls: ['./reg-supplier.component.css']
})
export class RegSupplierComponent implements OnInit {

  user: UserRegistrationDto = { email: '', password: '', passwordAgain: '', name: '', surname: '', address: '', city: '',
  country: '', phone: '', role: 2};

  constructor(private userService: UserService, private toastrService:ToastrService) { }

  ngOnInit(): void {
  }

  registration(): void {
    this.userService.registrationSupplier(this.user).subscribe((returnedUser: User) => {
      this.toastrService.success('Added new supplier.');
    },
      (err: any) => {
        this.toastrService.error('Registration error ' + err.error.message);
      });
  }

}
