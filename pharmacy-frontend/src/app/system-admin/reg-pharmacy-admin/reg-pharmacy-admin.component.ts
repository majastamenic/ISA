import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { PharmacyService } from 'src/app/service/pharmacy.service';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-reg-pharmacy-admin',
  templateUrl: './reg-pharmacy-admin.component.html',
  styleUrls: ['./reg-pharmacy-admin.component.css']
})
export class AddPharmacyAdminComponent implements OnInit {

  admin:any = {email: '', name: '', surname: '', address: '', city:'', country:'', phone: '', active:false, role: 6, pharmacyId: 0}
  pharmacies: any;
  pharmacy: any;

  constructor(private userService: UserService, private toastrService:ToastrService, private pharmacyService: PharmacyService) { 
  }

  ngOnInit(): void {
    this.pharmacyService.getAll().subscribe(listPharmacy => {
      this.pharmacies = listPharmacy;
    });
  }

  registration(): void {
    this.admin.pharmacyId = this.pharmacy.id;
    this.userService.registrationpharmacyAdmin(this.admin).subscribe((returnedAdmin: any) => {
      this.toastrService.success('Added new pharmacy admin.');
    },
      (err: any) => {
        alert('Registration error ' + err.error.message);
      });
  }

}