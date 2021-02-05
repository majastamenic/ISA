import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { CounselingService } from 'src/app/service/counseling.service';
import { ExaminationService } from 'src/app/service/examination.service';
import { MedicineService } from 'src/app/service/medicine.service';

@Component({
  selector: 'app-loyalty',
  templateUrl: './loyalty.component.html',
  styleUrls: ['./loyalty.component.css']
})
export class LoyalityComponent implements OnInit {

  medicinesList: any;
  enableEdit: boolean = false;
  enableEditIndex = null;
  enableEditExam = false;
  enableEditConsu = false;

  examLoyaltyPoints: number = 0;
  counsLoyaltyPoints: number = 0;

  constructor(private medicineService: MedicineService, private examService: ExaminationService,
    private counService: CounselingService ,private toastrService: ToastrService) { }

  ngOnInit(): void {
    this.medicineService.getAllMedLoyality().subscribe(listMedicineDto => {
      this.medicinesList = listMedicineDto;
    });
    this.examService.getLoyaltyPoints().subscribe((loyaltyPoints: number) => {
      this.examLoyaltyPoints = loyaltyPoints; 
    });
    this.counService.getLoyaltyPoints().subscribe((dbLoyaltyPoints: number) => {
      this.examLoyaltyPoints = dbLoyaltyPoints;
    });
  }

  saveMedicine(i: any){
    this.enableEdit = false;
    this.medicineService.changeMedLoyality(this.medicinesList[i]).subscribe((returnedMed: any) => {
      this.toastrService.success('Changed '+ returnedMed.name+" loyalty points");
    },
      (err: any) => {
        this.toastrService.error('Error ' + err.error.message);
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

  saveExamPoints():any{
    this.examService.setLoyaltyPoints(this.examLoyaltyPoints).subscribe((returnedExamPoints: any) => {
      this.enableEditExam = false;
      this.toastrService.success('Changed examination loyalty points');
    },
      (err: any) => {
        this.toastrService.error('Error ' + err.error.message);
      });
  }  

  editExamPoints(){
    this.enableEditExam = true;
  }

  cancelExam(){
    location.reload();
    this.enableEditExam = false;
  }

  saveCounsPoints():any{
    this.counService.setLoyaltyPoints(this.counsLoyaltyPoints).subscribe((returnedCounsPoints: any) => {
      this.enableEditConsu = false;
      this.toastrService.success('Changed examination loyalty points');
    },
      (err: any) => {
        this.toastrService.error('Error ' + err.error.message);
      });
  } 

  editCounsPoints(){
    this.enableEditConsu = true;
  }

  cancelCouns(){
    location.reload();
    this.enableEditConsu = false;
  }

}
