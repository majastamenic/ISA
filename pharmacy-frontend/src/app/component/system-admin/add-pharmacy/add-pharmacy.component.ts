import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { PharmacyService } from 'src/app/service/pharmacy.service';
import { UserService } from 'src/app/service/user.service';
import { Pharmacy, PharmacyDto } from '../../../model/pharmacy-model';

@Component({
  selector: 'app-add-pharmacy',
  templateUrl: './add-pharmacy.component.html',
  styleUrls: ['./add-pharmacy.component.css']
})
export class AddPharmacyComponent implements OnInit {
  pharmacy: PharmacyDto = {name: '', address: ''};
  constructor(private pharmacyService: PharmacyService, private toastrService: ToastrService,
    private userService: UserService, private router: Router) { }

  ngOnInit(): void {
    if(!this.userService.isAdmin()){
      this.router.navigate(['home']);
      this.toastrService.error('Unauthorized access.');
    }
  }

  addPharmacy(): void {
    this.pharmacyService.addPharmacy(this.pharmacy).subscribe((returnedPharmacy: Pharmacy) => {
      this.toastrService.success('Added new pharmacy.');
    },
      (err: any) => {
        this.toastrService.error('Error while add new pharmacy ' + err.error.message);
      });
  }

}
