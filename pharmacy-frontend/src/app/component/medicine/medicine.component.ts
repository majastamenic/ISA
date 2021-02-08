import { Component, OnInit } from '@angular/core';
import { MedicineService } from 'src/app/service/medicine.service';

@Component({
  selector: 'app-medicine',
  templateUrl: './medicine.component.html',
  styleUrls: ['./medicine.component.css']
})
export class MedicineComponent implements OnInit {

  viewSpec: boolean = false;
  enableViewIndex: any;
  medicinesDtoList: any;

  constructor(private medicineService: MedicineService) { }

  ngOnInit(): void {
    this.medicineService.getAllMedicinesDto().subscribe(listMedicineDto => {
      this.medicinesDtoList = listMedicineDto;
    });
  }

  viewSpecification(e: Event, i: any){
    this.enableViewIndex = i;
    this.viewSpec = true;
  }

  cancel(){
    this.viewSpec = false;
  }

}
