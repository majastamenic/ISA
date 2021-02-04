import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { MedicineService } from 'src/app/service/medicine.service';

@Component({
  selector: 'app-loyality',
  templateUrl: './loyality.component.html',
  styleUrls: ['./loyality.component.css']
})
export class LoyalityComponent implements OnInit {

  medicinesList: any;
  enableEdit: boolean = false;
  enableEditIndex = null;

  constructor(private medicineService: MedicineService, 
    private toastrService: ToastrService) { }

  ngOnInit(): void {
    this.medicineService.getAllMedLoyality().subscribe(listMedicineDto => {
      this.medicinesList = listMedicineDto;
    });
  }

  saveMedicine(i: any){
    this.enableEdit = false;
    this.medicineService.changeMedLoyality(this.medicinesList[i]).subscribe((returnedMed: any) => {
      this.toastrService.success('Changed '+ returnedMed.name+" loyalty points");
    },
      (err: any) => {
        this.toastrService.success('Error ' + err.error.message);
      });
  }

  cancelMedicine(){
    location.reload();
    this.enableEdit = false;
  }

  editMedicine(){
    this.enableEdit = true;
  }

  enableEditMethod(e:Event, i:any) {
    this.enableEdit = true;
    this.enableEditIndex = i;
  }

}
