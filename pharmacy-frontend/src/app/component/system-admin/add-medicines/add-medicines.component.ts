import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Medicine, MedicineDto } from 'src/app/model/medicine-model';
import { MedicineService } from 'src/app/service/medicine.service';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-add-medicines',
  templateUrl: './add-medicines.component.html',
  styleUrls: ['./add-medicines.component.css']
})
export class AddMedicinesComponent implements OnInit {
  medicine: any = {};
  constructor(private medicineService: MedicineService, private toastrService: ToastrService,
    private userService: UserService, private router: Router) { }

  ngOnInit(): void {
    if(!this.userService.isAdmin()){
      this.router.navigate(['home']);
      this.toastrService.error('Unauthorized access.');
    }
  }
  addMedicine(){
    this.medicineService.create(this.medicine).subscribe((returnedMedicine: Medicine) => {
      this.toastrService.success('Added medicine');
    },
      (err: any) => {
        this.toastrService.error('Error' + err.error.message);
      });
  }
}
