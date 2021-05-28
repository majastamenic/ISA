import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { VacationScheduleService } from 'src/app/service/vacation-schedule.service';

@Component({
  selector: 'app-vacations',
  templateUrl: './vacations.component.html',
  styleUrls: ['./vacations.component.css']
})
export class VacationsComponent implements OnInit {

  vacations:any=[];
  loggedUser: any = sessionStorage.getItem('user');
  message: any;

  constructor(private vacationService:VacationScheduleService, private toastrService:ToastrService) { }

  ngOnInit(): void {
    this.vacationService.getVacationsRequestsPharmacists(this.loggedUser).subscribe((response: any) =>{
      this.vacations = response;
    });
  }
  confirm(vacationSc:0, i:number){
    let vacationDto: any = {confirmed:"Confirmed", message:"", vacationScheduleId: vacationSc};

    this.vacationService.confirmationVacationTermPharmacist(vacationDto).subscribe((_ret: any) =>{
      this.toastrService.success("Successfuly confirmed");
    },(err: any)=>{
      this.toastrService.error("Error "+ err.error.message)
    }) 
  }

  decline(vacationSc:0, i:number){
    let vacationDto: any = {confirmed:"Unconfirmed", message:this.message, vacationScheduleId: vacationSc};
    this.vacationService.confirmationVacationTermPharmacist(vacationDto).subscribe((_ret: any) =>{
      this.toastrService.success("Successfuly declined");
    },(err: any)=>{
      this.toastrService.error("Error "+ err.error.message)
    }) 
  }
}
