import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { DateTime } from 'src/app/model/examination';
import { CounselingsService } from 'src/app/service/counselings.service';
import { PharmacistService } from 'src/app/service/pharmacist.service';


@Component({
  selector: 'app-counseling-schedule',
  templateUrl: './counseling-schedule.component.html',
  styleUrls: ['./counseling-schedule.component.css']
})
export class CounselingScheduleComponent implements OnInit {

  loggedUser = sessionStorage.getItem('user');
  dateTime: DateTime = {date: '', time: ''};
  pharmacy: any;
  pharmacists: any;

  constructor(private pharmacistService: PharmacistService,
              private counselingService: CounselingsService,
              private _ActivatedRoute: ActivatedRoute,
              private toastrService: ToastrService,
              private router: Router) { }

  ngOnInit(): void {
    if(this.loggedUser){
      let date = sessionStorage.getItem('date');
      let time = sessionStorage.getItem('time');
      if(date && time){
        this.dateTime.date = date;
        this.dateTime.time = time;
      }else{
        this.router.navigate(['patient/counselingSearch']);
        this.toastrService.warning('Please specify eager date and time!');
      }
      this._ActivatedRoute.paramMap.subscribe(params => { 
        this.pharmacy = params.get('pharmacyName');
        this.pharmacistService.getFreePharmacistOnDate(this.pharmacy, this.dateTime).subscribe((data:any[]) => {
          if(data.length <= 0){
            this.toastrService.info('No pharamcist has been found for selected term!');
          }else{
            this.pharmacists = data;
          }
        }, (error: any) => {
          this.toastrService.error("Unknown error");
        });
      }, error => {
        this.toastrService.error('No pharmacy has been specified!');
      });
    }else{
      this.router.navigate(['login']);
      this.toastrService.info('Please log in first.');
    }
  }

  schedule(pharmacistEmail: string){
    let counseling = {
      pharmacistEmail: pharmacistEmail,
      patientEmail: this.loggedUser,
      schedule: {
        startDate: this.dateTime.date,
        endDate: this.dateTime.date,
        startTime: this.dateTime.time,
      },
    };
    this.counselingService.addCounseling(counseling).subscribe(data => {
      if(data){
        this.router.navigate(['patient/counselings']);
        this.toastrService.success('Counseling successfuly scheduled!');
      }
        
    }, error => {
      this.toastrService.error("Error while scheduling counseling!");
    })
  }

}
