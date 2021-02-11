import { Component, OnInit } from '@angular/core';
import { ScheduleCounselingService } from 'src/app/service/schedule-counseling.service';
import { PharmacistService } from 'src/app/service/pharmacist.service';
import { Counseling } from '../../model/counseling';
import { IDatePickerConfig } from 'ng2-date-picker';
import { NgbDateStruct } from '@ng-bootstrap/ng-bootstrap';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-schedule-counseling',
  templateUrl: './schedule-counseling.component.html',
  styleUrls: ['./schedule-counseling.component.css']
})
export class ScheduleCounselingComponent implements OnInit {

  loggedUser: any = sessionStorage.getItem('user');
  loggedUserRole: any = sessionStorage.getItem('role');

  model: any;
  startTime = { hour: 13, minute: 30 };
  endTime = { hour: this.startTime.hour, minute: this.startTime.minute};
  minuteStep = 30;

  counseling: Counseling = { id:'', counselingStatus: '', user: {}, patientDto: {}, schedule: {}, report: {}, patientCame: false };

  constructor(private scheduleCounseling: ScheduleCounselingService, private router: Router,
    private _ActivatedRoute: ActivatedRoute, private toastrService: ToastrService) {
      if(!this.loggedUser){
        this.router.navigate(['login']);
        toastrService.info('Please login first!');
      }
     }

  ngOnInit(): void {
    if(this.loggedUserRole == 'PHARMACIST'){
      this.counseling.user = this.loggedUser;
    }else{
      this.router.navigate(['home']);
      this.toastrService.error('You do not have access rights for this page!');
    }
  }

  schedule() {
    const counseling = {
      schedule: {
        startDate: `${this.model.year}-${this.model.month}-${this.model.day}`,
        endDate: `${this.model.year}-${this.model.month}-${this.model.day}`,
        startTime: `${this.startTime.hour}:${this.startTime.minute}:00`,
        endTime: `${this.endTime.hour}:${this.endTime.minute}:00`
      },
      report: {
        
      }
    }

    this.scheduleCounseling.createCounseling(counseling).subscribe(counseling => {
      console.log(counseling);
      this.router.navigate(['home'])
    })
  }


}

