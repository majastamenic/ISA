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

  medicines: any[] | undefined;

  constructor(private medicineService: MedicineService) { }

  ngOnInit(): void {
    this.medicineService.getAll().subscribe(listMedicine => {
      this.medicines = listMedicine;
    });
  }

}
