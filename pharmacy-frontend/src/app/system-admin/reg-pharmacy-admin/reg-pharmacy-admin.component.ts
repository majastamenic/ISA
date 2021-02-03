import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { UserRegistrationDto } from 'src/app/component/user/model/user-model';
import { PharmacyService } from 'src/app/service/pharmacy.service';
import { UserService } from 'src/app/service/user.service';
import { PharmacyDto } from '../add-pharmacy/model/pharmacy-model';

@Component({
  selector: 'app-reg-pharmacy-admin',
  templateUrl: './reg-pharmacy-admin.component.html',
  styleUrls: ['./reg-pharmacy-admin.component.css']
})
export class AddPharmacyAdminComponent implements OnInit {

  pharmacies: any;
  user: any = {}

  constructor(private userService: UserService, private toastrService:ToastrService, private pharmacyService: PharmacyService) { 
  }

  ngOnInit(): void {
    this.pharmacyService.getAll().subscribe(listPharmacy => {
      this.pharmacies = listPharmacy;
    });
  }

  registration(): void {
    let admin:any = {user: {email: this.user.email, name: this.user.name, surname: this.user.surname ,
      address: this.user.address, city:this.user.city, country:this.user.country, phone: this.user.phone, active:false}, 
      pharmacyId: this.user.pharmacy.id}
    this.userService.registrationpharmacyAdmin(admin).subscribe((returnedAdmin: PharmacyAdminDto) => {
      this.toastrService.success('Added new pharmacy admin.');
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
