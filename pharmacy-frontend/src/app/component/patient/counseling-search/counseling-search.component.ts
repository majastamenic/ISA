import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { DateTime } from 'src/app/model/examination';
import { PharmacyService } from 'src/app/service/pharmacy.service';

@Component({
  selector: 'app-counseling-search',
  templateUrl: './counseling-search.component.html',
  styleUrls: ['./counseling-search.component.css']
})
export class CounselingSearchComponent implements OnInit {

  loggedUser = sessionStorage.getItem('user');
  isCounselingFound: boolean = false;

  startTime = {hour: 13, minute: 30};
  eagerDate: any;
  minuteStep: number = 15;

  dateTime: DateTime = {date: '', time: ''}
  pharmacies: any;

  constructor(private pharmacyService: PharmacyService,
              private router: Router,
              private toastrService: ToastrService
              ) { }

  ngOnInit(): void {
    if(!this.loggedUser){
      this.router.navigate(['login']);
      this.toastrService.info('Please log in first.');
    }
  }

  find(){
    if(typeof this.eagerDate != 'object'){
      this.toastrService.error("Invalid date format!");
      return;
    }
    if(this.startTime.hour > 23 || this.startTime.minute > 59){
      this.toastrService.error("Invalid time format!");
      return;
    }
    this.dateTime.date = `${this.eagerDate.year}-${this.eagerDate.month}-${this.eagerDate.day}`;
    this.dateTime.time = `${this.startTime.hour}:${this.startTime.minute}:00`;
    sessionStorage.setItem('date', this.dateTime.date);
    sessionStorage.setItem('time', this.dateTime.time);
    this.pharmacyService.getPharmaciesWithAvailablePharmacists(this.dateTime).subscribe((data: any[]) => {
      if(data.length <= 0)
        this.toastrService.info('There is no available pharmacists for selected term');
      else{
        this.pharmacies = data;
        this.isCounselingFound = true;
      }
    }, (error:any) => {
      this.toastrService.error("Server error");
    });
  }
}
