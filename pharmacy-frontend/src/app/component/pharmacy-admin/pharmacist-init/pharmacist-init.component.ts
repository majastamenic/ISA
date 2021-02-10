import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { PharmacistService } from 'src/app/service/pharmacist.service';
import { PharmacyService } from 'src/app/service/pharmacy.service';
import { WorkScheduleService } from 'src/app/service/work-schedule.service';
@Component({
  selector: 'app-pharmacist-init',
  templateUrl: './pharmacist-init.component.html',
  styleUrls: ['./pharmacist-init.component.css']
})
export class PharmacistInitComponent implements OnInit {

  user: any = {}
  listPharmacies: any = []
  listSchedules: any = []
  selectedWorkSchedules: any=[]
  constructor( private pharmacyService: PharmacyService, 
    private workSchedule:WorkScheduleService, 
    private pharmacistService:PharmacistService,
    private toastrService: ToastrService) { }

  ngOnInit(): void {
    this.pharmacyService.getAll().subscribe(response =>{
      this.listPharmacies = response;
    });
    this.workSchedule.getAll().subscribe(schedules =>{
      this.listSchedules = schedules;
      for(let schedule of this.listSchedules){
          schedule.label="From "+schedule.startDate+ " to " + schedule.endDate +", from time "+schedule.startTime+" to "+schedule.endTime;
      }
    })
  }

  registration(){
    let userDto:any = {user: {email: this.user.email, name: this.user.name, surname: this.user.surname ,
      address: this.user.address, city:this.user.city, country:this.user.country, phone: this.user.phone, active:false}, 
      pharmacyId: this.user.pharmacy.id}
      userDto.workScheduleIds = [];
      for(let schedule of this.selectedWorkSchedules){
        userDto.workScheduleIds.push(schedule.id);
      }
      this.pharmacistService.createPharmacist(userDto).subscribe((_ret: any) =>{
        this.toastrService.success("You added pharmacist successfuly");
      }) 
  }
}
