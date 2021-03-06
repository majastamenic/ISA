import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { ExaminationService } from 'src/app/service/examination.service';
import { MedicinePharmacyService } from 'src/app/service/medicine-pharmacy.service';
import { PharmacyService } from 'src/app/service/pharmacy.service';

@Component({
  selector: 'app-graphs',
  templateUrl: './graphs.component.html',
  styleUrls: ['./graphs.component.css']
})
export class GraphsComponent implements OnInit {
  
  examinationNumbers:any;
  medicineNumber:any;
  profitNumber:any;
  showExaminations:boolean= false;
  showMedications:boolean= false;
  showProfit:boolean= false;
  userEmail:any= sessionStorage.getItem('user');
  saleData :any;
  dateFrom: any;
  dateTo:any;
  constructor(private exam:ExaminationService, private toastrService: ToastrService,private medicinePharmacy:MedicinePharmacyService, private router: Router, private pharmacyService:PharmacyService) { }

  ngOnInit(): void {
    if(this.userEmail){
    this.exam.getNumber(this.userEmail).subscribe((examinations: any) => {
      this.examinationNumbers = examinations;
      console.log(this.examinationNumbers);
      this.saleData = [
        { name: "Month", value: this.examinationNumbers[0] },
        { name: "Quartal", value: this.examinationNumbers[1] },
        { name: "Year", value: this.examinationNumbers[2] },
      ];
    },(err: any)=>{
      this.toastrService.error("Error "+ err.error.message)
    });
  }
  else{
    this.router.navigate(['login']);
    this.toastrService.info('Please log in first.');
  }
  }
  showExams(){
    this.showExaminations = true;
  }
  showMeds(){
    this.showMedications = true;
    this.medicinePharmacy.getNumber(this.userEmail).subscribe((examinations: any) => {
      this.medicineNumber = examinations;
      console.log(this.medicineNumber);
      this.saleData = [
        { name: "Month", value: this.medicineNumber[0] },
        { name: "Quartal", value: this.medicineNumber[1] },
        { name: "Year", value: this.medicineNumber[2] },
      ];
    },(err: any)=>{
      this.toastrService.error("Error "+ err.error.message)
    });
  }
  showProf(){
    this.showProfit = true;
  }
  showProfForPeriod(){
    this.showProfit = true;
    let dto: any= {startDate: this.dateFrom, endDate:this.dateTo, adminEmail: this.userEmail};
    this.pharmacyService.getProfit(dto).subscribe((examinations: any) => {
      this.profitNumber = examinations;
      console.log(this.profitNumber);
      this.saleData = [
        { name: "Profit", value: this.profitNumber }
      ];
    },(err: any)=>{
      this.toastrService.error("Error "+ err.error.message)
    });
  }

}
