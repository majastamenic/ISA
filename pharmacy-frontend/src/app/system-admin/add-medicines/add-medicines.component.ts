import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';
import { Medicine, MedicineDto } from 'src/app/component/medicine/model/medicine-model';
import { MedicineService } from 'src/app/service/medicine.service';

@Component({
  selector: 'app-add-medicines',
  templateUrl: './add-medicines.component.html',
  styleUrls: ['./add-medicines.component.css']
})
export class AddMedicinesComponent implements OnInit {
  medicine: any;
  constructor(private medicineService: MedicineService, private toastrService: ToastrService) { }

  ngOnInit(): void {
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
