import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { PharmacyService } from 'src/app/service/pharmacy.service';
import { Pharmacy, PharmacyDto } from './model/pharmacy-model';

@Component({
  selector: 'app-add-pharmacy',
  templateUrl: './add-pharmacy.component.html',
  styleUrls: ['./add-pharmacy.component.css']
})
export class AddPharmacyComponent implements OnInit {
  pharmacy: PharmacyDto = {name: '', address: ''};
  constructor(private pharmacyService: PharmacyService, private toastrService: ToastrService) { }

  ngOnInit(): void {
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
