import { Component, Input, OnInit } from '@angular/core';
import { MedicineService } from 'src/app/service/medicine.service';
import { PharmacistService } from 'src/app/service/pharmacist.service';
import { PharmacyService } from 'src/app/service/pharmacy.service';

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
  filterView: boolean = false;

  allPharmacies: any;
  selectedPharmacies: any = [];

  @Input('data') medicinesDtoList: any = [];
  page: number = 1;
  itemsPerPage: number = 2;
  viewSpec: boolean = false;
  enableViewIndex: any;
  total: number = 0;
  searchMode = false;

  constructor(private medicineService: MedicineService, private pharmacyService: PharmacyService) { }

  ngOnInit(): void {
    this.medicineService.getAllMedicinesDto(this.page - 1, 2).subscribe(listMedicineDto => {
      this.medicinesDtoList = listMedicineDto.content;
      this.total = listMedicineDto.totalElements;
      this.page = listMedicineDto.number + 1;
    });

    this.pharmacyService.getAll().subscribe((response: any) => {
      this.allPharmacies = response;
    });
  }

  onPageChanged(number: number) {
    this.page = number;
    if (this.searchMode == true) {
      this.search();
    } else {
      this.medicineService.getAllMedicinesDto(number - 1, 2).subscribe(listMedicineDto => {
        this.medicinesDtoList = listMedicineDto.content;
        this.total = listMedicineDto.totalElements;
      });
    }
  }
  viewSpecification(e: Event, i: any) {
    this.enableViewIndex = i;
    this.viewSpec = true;
  }

  cancel() {
    this.viewSpec = false;
  }

  search() {
    this.searchMode = true;
    this.pharmacies = [];
    if (this.selectedPharmacies && this.selectedPharmacies.length > 0) {
      for (let p of this.selectedPharmacies) {
        this.pharmacies.push(p.id);
      }
    }
    this.medicineService.searchFilter(2, this.page - 1, this.name, this.startPrice, this.endPrice, this.pharmacies,
      this.typeOfMedicine, this.manufactured, this.composition, this.formOfMedicine,
      this.publishingType).subscribe((responseMedicines: any) => {
        this.medicinesDtoList = responseMedicines.content;
        this.total = responseMedicines.totalElements;
        this.page = responseMedicines.number + 1;
        this.filterView = true;
      });
  }

  clearAll() {
    this.selectedPharmacies = [];
  }

}
