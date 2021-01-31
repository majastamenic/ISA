import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { MedicineService } from 'src/app/service/medicine.service';
import { Medicine } from './model/medicine-model';

@Component({
  selector: 'app-medicine',
  templateUrl: './medicine.component.html',
  styleUrls: ['./medicine.component.css']
})
export class MedicineComponent implements OnInit {

  medicinesDtoList: any;

  constructor(private medicineService: MedicineService) { }

  ngOnInit(): void {
    this.medicineService.getAllMedicinesDto().subscribe(listMedicineDto => {
      this.medicinesDtoList = listMedicineDto;
    });
  }

}
