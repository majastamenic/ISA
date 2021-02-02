import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { UserRegistrationDto } from 'src/app/component/user/model/user-model';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-add-pharmacy-admin',
  templateUrl: './add-pharmacy-admin.component.html',
  styleUrls: ['./add-pharmacy-admin.component.css']
})
export class AddPharmacyAdminComponent implements OnInit {

  user: UserRegistrationDto = { email: '', password: '', passwordAgain: '', name: '', surname: '', address: '', city: '',
  country: '', phone: ''};

  constructor(private userService: UserService, private toastrService:ToastrService) { }

  ngOnInit(): void {
  }

}
