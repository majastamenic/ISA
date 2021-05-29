import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { DermatologistService } from 'src/app/service/dermatologist.service';

@Component({
  selector: 'app-dermatologist-free-terms',
  templateUrl: './dermatologist-free-terms.component.html',
  styleUrls: ['./dermatologist-free-terms.component.css']
})
export class DermatologistFreeTermsComponent implements OnInit {

  startDate: any;
  price:any;
  selectedDermatologist:any;
  selectedDermatologist1:any;
  listDermatologists: any=[];
  loggedUser:any;
  duration:any;
  start = {hour: 8, minute: 0};
  end = {hour: 14, minute: 0};
  start1 = {hour: 8, minute: 0};
  minuteStep: number = 15;
  minuteStep1: number = 15;
  startTime: any ='';
  startTime1: any ='';
  endTime1: any ='';
  startDate1: any;
  endDate1:any;
  showAddDerm: boolean= false;
  allDermatologists: any=[];

  constructor(private toastrService: ToastrService, private dermatologistService: DermatologistService) { }

  ngOnInit(): void {
    this.loggedUser = sessionStorage.getItem("user");
    this.dermatologistService.getDermatologistsByAdmin(this.loggedUser).subscribe((response: any) =>{
      this.listDermatologists = response;
    });
  }

  define(){
    this.startTime = `${this.start.hour}:${this.start.minute}:00`;
    let examDto:any ={email:this.selectedDermatologist.user.email,startDate: this.startDate, startTime: this.startTime,
    duration: this.duration, price:this.price, adminEmail: this.loggedUser};
    this.dermatologistService.addExamination(examDto).subscribe((_ret: any) =>{
      this.toastrService.success("Successfuly created examination");
    },(err: any)=>{
      this.toastrService.error("Error "+ err.error.message)
    }) 
  }
  addDermatologist(){
    this.showAddDerm = true;
    this.dermatologistService.getAll().subscribe((_ret: any) =>{
      this.allDermatologists = _ret;
    }) 
  }
  define1(){
    this.startTime1 = `${this.start1.hour}:${this.start1.minute}:00`;
    this.endTime1 = `${this.end.hour}:${this.end.minute}:00`;
    let examDto:any ={email:this.selectedDermatologist1.user.email, startDate: this.startDate1, endDate:this.endDate1,
       startTime: this.startTime1, endTime:this.endTime1, adminEmail: this.loggedUser};
       this.dermatologistService.addDermatologistAndWorkschedule(examDto).subscribe((_ret: any) =>{
        this.toastrService.success("Successfuly added dermatologist and workschedule");
      },(err: any)=>{
        this.toastrService.error("Error "+ err.error.message)
      }) 
  }

}
