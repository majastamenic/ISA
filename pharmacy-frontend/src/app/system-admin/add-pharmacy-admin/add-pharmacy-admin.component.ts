import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { UserRegistrationDto } from 'src/app/component/user/model/user-model';
import { PharmacyService } from 'src/app/service/pharmacy.service';
import { UserService } from 'src/app/service/user.service';
import { PharmacyDto } from '../add-pharmacy/model/pharmacy-model';

@Component({
  selector: 'app-add-pharmacy-admin',
  templateUrl: './add-pharmacy-admin.component.html',
  styleUrls: ['./add-pharmacy-admin.component.css']
})
export class AddPharmacyAdminComponent implements OnInit {

  user: UserRegistrationDto = { email: '', password: '', passwordAgain: '', name: '', surname: '', address: '', city: '',
  country: '', phone: '', role: 5};
  pharmacy: PharmacyDto = {name: '', address: ''}

  pharmacies: any;
  admin: PharmacyAdminDto = {user: this.user, pharmacy: this.pharmacy};

  constructor(private userService: UserService, private toastrService:ToastrService, private pharmacyService: PharmacyService) { }

  ngOnInit(): void {
    this.pharmacyService.getAll().subscribe(listPharmacy => {
      this.pharmacies = listPharmacy;
    });
  }

  registration(): void {
    this.userService.registrationpharmacyAdmin(this.admin).subscribe((returnedAdmin: PharmacyAdminDto) => {
      this.toastrService.success('Added new phar.');
    },
      (err: any) => {
        alert('Registration error ' + err.error.message);
      });
  }

}

export interface PharmacyAdminDto{
  user: UserRegistrationDto,
  pharmacy: PharmacyDto
}
