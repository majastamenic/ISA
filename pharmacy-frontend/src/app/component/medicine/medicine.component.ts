import { Component, Input, OnInit } from '@angular/core';
import { MedicineService } from 'src/app/service/medicine.service';

@Component({
  selector: 'app-medicine',
  templateUrl: './medicine.component.html',
  styleUrls: ['./medicine.component.css']
})
export class MedicineComponent implements OnInit {

  name: string = "";
  startPrice: any;
  endPrice: any;
  pharmacies: any;
  typeOfMedicine: any;
  manufactured: any;
  composition: any;
  formOfMedicine: any;
  publishingType: any;

  @Input('data') medicinesDtoList: any[] = [];
  page: number = 1;
  itemsPerPage: number = 2;
  viewSpec: boolean = false;
  enableViewIndex: any;
  total: number = 0;

  constructor(private medicineService: MedicineService) { }

  ngOnInit(): void {
    this.medicineService.getAllMedicinesDto(this.page - 1, 2).subscribe(listMedicineDto => {
      this.medicinesDtoList = listMedicineDto.content;
      this.total = listMedicineDto.totalElements;
      this.page = listMedicineDto.pageNumber + 1;
    });
  }

  onPageChanged(number: number) {
    this.medicineService.getAllMedicinesDto(number - 1, 2).subscribe(listMedicineDto => {
      this.medicinesDtoList = listMedicineDto.content;
      this.total = listMedicineDto.totalElements;
      this.page = number;
    });
  }
  viewSpecification(e: Event, i: any) {
    this.enableViewIndex = i;
    this.viewSpec = true;
  }

  cancel() {
    this.viewSpec = false;
  }

  search(){
    this.medicineService.searchFilter(2, 0, this.name, this.startPrice, this.endPrice, this.pharmacies,
      this.typeOfMedicine, this.manufactured, this.composition, this.formOfMedicine,
      this.publishingType).subscribe((responseMedicines: any) => {
        this.medicinesDtoList = responseMedicines.content;
        this.total = responseMedicines.totalElements;
        this.page = responseMedicines.pageNumber + 1;
    });
  }

}
