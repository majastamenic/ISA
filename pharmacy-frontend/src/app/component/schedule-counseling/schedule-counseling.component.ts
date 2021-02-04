import { Component, OnInit } from '@angular/core';
import { ScheduleCounselingService } from 'src/app/service/schedule-counseling.service';
import { PharmacistService } from 'src/app/service/pharmacist.service';
import { Counseling } from '../user/model/counseling';
import { IDatePickerConfig } from 'ng2-date-picker';
import { NgbDateStruct } from '@ng-bootstrap/ng-bootstrap';
import { Router } from '@angular/router';

@Component({
  selector: 'app-schedule-counseling',
  templateUrl: './schedule-counseling.component.html',
  styleUrls: ['./schedule-counseling.component.css']
})
export class ScheduleCounselingComponent implements OnInit {

  model: any;
  startTime = { hour: 13, minute: 30 };
  endTime = { hour: this.startTime.hour, minute: this.startTime.minute};
  minuteStep = 30;

  counseling: Counseling = { counselingStatus: '', user: {}, patientDto: {}, schedule: {}, report: {}, patientCame: false };

  constructor(private scheduleCounseling: ScheduleCounselingService, private router: Router) { }

  ngOnInit(): void {
    this.counseling.user = sessionStorage.getItem('user');
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

