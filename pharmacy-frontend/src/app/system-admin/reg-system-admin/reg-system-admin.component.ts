import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { User, UserRegistrationDto } from 'src/app/component/user/model/user-model';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-reg-system-admin',
  templateUrl: './reg-system-admin.component.html',
  styleUrls: ['./reg-system-admin.component.css']
})
export class RegSystemAdminComponent implements OnInit {

  user: UserRegistrationDto = { email: '', password: '', passwordAgain: '', name: '', surname: '', address: '', city: '',
  country: '', phone: '', role: 1};

  constructor(private userService: UserService, private toastrService: ToastrService) { }

  ngOnInit(): void {
  }

  registration(): void {
    this.userService.registrationSystemAdmin(this.user).subscribe((returnedUser: User) => {
      this.toastrService.success('Added new system administrator.');
    },
      (err: any) => {
        this.toastrService.error('Registration error ' + err.error.message);
      });
  }
}
