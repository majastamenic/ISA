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
  listDermatologists: any=[];
  loggedUser:any;
  duration:any;
  start = {hour: 13, minute: 30};
  minuteStep: number = 15;
  startTime: any ='';


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

}
