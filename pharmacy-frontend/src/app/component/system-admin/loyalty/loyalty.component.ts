import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { LoyaltyGroup, LoyaltyGroupType } from 'src/app/model/loyaltyGroup';
import { LoyaltyGroupService } from 'src/app/service/loyalty-group.service';
import { MedicineService } from 'src/app/service/medicine.service';
import { UserService } from 'src/app/service/user.service';

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
  enableEditReg = false;
  enableEditSil = false;
  enableEditGold = false;

  examLoyaltyPoints: LoyaltyGroup = {type: LoyaltyGroupType.EXAMINATION, points: 0};
  counsLoyaltyPoints: LoyaltyGroup = {type: LoyaltyGroupType.COUNSELING, points: 0};

  regLoyaltyPoints: LoyaltyGroup = {type: LoyaltyGroupType.REGULAR, points: 0};
  silLoyaltyPoints: LoyaltyGroup = {type: LoyaltyGroupType.SILVER, points: 0};
  goldLoyaltyPoints: LoyaltyGroup = {type: LoyaltyGroupType.GOLD, points: 0};

  prevExamPoints: any;
  prevCounsPoints: any;
  prevMedPoints: any;
  prevRegPoints: any;
  prevSilPoints: any;
  prevGoldPoints: any;

  constructor(private medicineService: MedicineService, private loyaltyGroupService: LoyaltyGroupService, 
    private toastrService: ToastrService, private userService: UserService, private router: Router) { 
    }

  ngOnInit(): void {
    if(!this.userService.isAdmin()){
      this.router.navigate(['home']);
    }
    this.medicineService.getAllMedLoyality().subscribe(listMedicineDto => {
      this.medicinesList = listMedicineDto;
    });
    this.loyaltyGroupService.getLoyaltyPoints(this.examLoyaltyPoints.type).subscribe((loyaltyPoints: number) => {
      this.examLoyaltyPoints.points = loyaltyPoints; 
      this.prevExamPoints = loyaltyPoints;
    });
    this.loyaltyGroupService.getLoyaltyPoints(this.counsLoyaltyPoints.type).subscribe((dbLoyaltyPoints: number) => {
      this.counsLoyaltyPoints.points = dbLoyaltyPoints;
      this.prevCounsPoints = dbLoyaltyPoints;
    });
    this.loyaltyGroupService.getLoyaltyPoints(this.regLoyaltyPoints.type).subscribe((dbRegPoints: number) =>{
      this.regLoyaltyPoints.points = dbRegPoints;
      this.prevRegPoints = dbRegPoints;
    });
    this.loyaltyGroupService.getLoyaltyPoints(this.silLoyaltyPoints.type).subscribe((dbSilPoints: number) =>{
      this.silLoyaltyPoints.points = dbSilPoints;
      this.prevSilPoints = dbSilPoints;
    });
    this.loyaltyGroupService.getLoyaltyPoints(this.goldLoyaltyPoints.type).subscribe((dbGoldPoints: number) =>{
      this.goldLoyaltyPoints.points = dbGoldPoints;
      this.prevGoldPoints = dbGoldPoints;
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

  cancelMedicine(i: any){
    this.medicinesList[i].loyaltyPoints = this.prevMedPoints;
    this.enableEdit = false;
  }

  enableEditMethod(e:Event, i:any) {
    this.prevMedPoints = this.medicinesList[i].loyaltyPoints;
    this.enableEdit = true;
    this.enableEditIndex = i;
  }

  saveExamPoints():any{
    this.loyaltyGroupService.setLoyaltyPoints(this.examLoyaltyPoints).subscribe((returnedExamPoints: any) => {
      this.enableEditExam = false;
      this.prevExamPoints = this.examLoyaltyPoints.points;
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
    this.examLoyaltyPoints.points = this.prevExamPoints;
    this.enableEditExam = false;
  }

  saveCounsPoints():any{
    this.loyaltyGroupService.setLoyaltyPoints(this.counsLoyaltyPoints).subscribe((returnedCounsPoints: any) => {
      this.enableEditConsu = false;
      this.prevCounsPoints = this.counsLoyaltyPoints.points;
      this.toastrService.success('Changed counseling loyalty points');
    },
      (err: any) => {
        this.toastrService.error('Error ' + err.error.message);
      });
  } 

  editCounsPoints(){
    this.enableEditConsu = true;
  }

  cancelCouns(){
    this.counsLoyaltyPoints.points = this.prevCounsPoints;
    this.enableEditConsu = false;
  }

  saveRegPoints():any{
    this.loyaltyGroupService.setLoyaltyPoints(this.regLoyaltyPoints).subscribe((returnedRegPoints: any) => {
      this.enableEditReg = false;
      this.prevRegPoints = this.regLoyaltyPoints.points;
      this.toastrService.success('Changed regular loyalty points');
    },
      (err: any) => {
        this.toastrService.error('Error ' + err.error.message);
      });
  } 

  editRegPoints(){
    this.enableEditReg = true;
  }

  cancelReg(){
    this.regLoyaltyPoints.points = this.prevRegPoints;
    this.enableEditReg = false;
  }

  saveSilver():any{
    this.loyaltyGroupService.setLoyaltyPoints(this.silLoyaltyPoints).subscribe((returnedSilvPoints: any) => {
      this.enableEditSil = false;
      this.prevSilPoints = this.silLoyaltyPoints.points;
      this.toastrService.success('Changed silver loyalty points');
    },
      (err: any) => {
        this.toastrService.error('Error ' + err.error.message);
      });
  } 

  editSilvPoints(){
    this.enableEditSil = true;
  }

  cancelSilv(){
    this.silLoyaltyPoints.points = this.prevSilPoints;
    this.enableEditSil = false;
  }

  saveGoldPoints():any{
    this.loyaltyGroupService.setLoyaltyPoints(this.goldLoyaltyPoints).subscribe((returnedGoldPoints: any) => {
      this.enableEditGold = false;
      this.prevGoldPoints = this.goldLoyaltyPoints.points;
      this.toastrService.success('Changed gold loyalty points');
    },
      (err: any) => {
        this.toastrService.error('Error ' + err.error.message);
      });
  } 

  editGoldPoints(){
    this.enableEditGold = true;
  }

  cancelGold(){
    this.goldLoyaltyPoints.points = this.prevGoldPoints;
    this.enableEditGold = false;
  }
}
