import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from 'src/app/service/user.service';
import {NgbDate, NgbCalendar} from '@ng-bootstrap/ng-bootstrap';
import { ToastrService } from 'ngx-toastr';
import { VacationScheduleService } from 'src/app/service/vacation-schedule.service';
import { PharmacistService } from 'src/app/service/pharmacist.service';
import { VacationSchedule } from 'src/app/model/vacation-schedule';

@Component({
  selector: 'app-schedule-vacation',
  templateUrl: './schedule-vacation.component.html',
  styleUrls: ['./schedule-vacation.component.css'],
  styles: [`
    .custom-day {
      text-align: center;
      padding: 0.185rem 0.25rem;
      display: inline-block;
      height: 2rem;
      width: 2rem;
    }
    .custom-day.focused {
      background-color: #e6e6e6;
    }
    .custom-day.range, .custom-day:hover {
      background-color: rgb(2, 117, 216);
      color: white;
    }
    .custom-day.faded {
      background-color: rgba(2, 117, 216, 0.5);
    }
  `]
})
export class ScheduleVacationComponent implements OnInit {

  loggedUser: any = sessionStorage.getItem('user');
  loggedUserRole: any = sessionStorage.getItem('role');

  user : any;
  hoveredDate: NgbDate | null = null;

  fromDate: NgbDate;
  toDate: NgbDate | null = null;

  vacationTerm: VacationSchedule = { startDate:'', endDate:''};

  constructor(calendar: NgbCalendar, private userService: UserService, private router: Router,
    private toastrService: ToastrService, private pharmacistService: PharmacistService) {
    this.fromDate = calendar.getToday();
    this.toDate = calendar.getNext(calendar.getToday(), 'd', 10);
   }

  ngOnInit(): void {
    if(this.loggedUserRole == 'PHARMACIST'){
      this.userService.getUserByEmail(this.loggedUser).subscribe((data:any) =>{
        this.user = data;
        console.log(data);
      });
    }else{
      this.router.navigate(['home']);
      this.toastrService.error('You do not have access rights for this page!');
    }

  }

  onDateSelection(date: NgbDate) {
    if (!this.fromDate && !this.toDate) {
      this.fromDate = date;
    } else if (this.fromDate && !this.toDate && date.after(this.fromDate)) {
      this.toDate = date;
    } else {
      this.toDate = null;
      this.fromDate = date;
    }
  }

  isHovered(date: NgbDate) {
    return this.fromDate && !this.toDate && this.hoveredDate && date.after(this.fromDate) && date.before(this.hoveredDate);
  }

  isInside(date: NgbDate) {
    return this.toDate && date.after(this.fromDate) && date.before(this.toDate);
  }

  isRange(date: NgbDate) {
    return date.equals(this.fromDate) || (this.toDate && date.equals(this.toDate)) || this.isInside(date) || this.isHovered(date);
  }

  scheduleVacation(){
    console.log(this.fromDate.year + '-' + this.fromDate.month + '-' + this.fromDate.day);
    console.log(this.toDate?.year + '-' + this.toDate?.month + '-' + this.toDate?.day);
    var toDateYear = this.toDate?.year;
    var toDateMonth = this.toDate?.month;
    var toDateDay = this.toDate?.day;
    if(this.toDate?.year == null){
      toDateYear = this.fromDate.year;
      toDateMonth = this.fromDate.month;
      toDateDay = this.fromDate.day;
    }
    this.vacationTerm.startDate = this.fromDate.year + '-' + this.fromDate.month + '-' + this.fromDate.day;
    this.vacationTerm.endDate = toDateYear + '-' + toDateMonth + '-' + toDateDay
    this.pharmacistService.scheduleVacationTerm(this.vacationTerm, this.loggedUser).subscribe(data => {
      if(data == true){
        this.toastrService.success('Term for vacation is accepted.');
      }else{
        this.toastrService.error('Term for vacation is occupied.');
      }
    }, error => {
      this.toastrService.error('Term for vacation is not valid.');
    });
  }

}
