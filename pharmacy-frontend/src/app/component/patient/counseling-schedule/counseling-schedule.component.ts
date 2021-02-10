import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { DateTime } from 'src/app/model/examination';
import { PharmacistService } from 'service/pharmacist.service';

@Component({
  selector: 'app-counseling-schedule',
  templateUrl: './counseling-schedule.component.html',
  styleUrls: ['./counseling-schedule.component.css']
})
export class CounselingScheduleComponent implements OnInit {

  loggedUser = sessionStorage.getItem('user');
  pharmacy: any;
  pharmacists: any;

  constructor(private pharmacistService:PharmacistService,
              private _ActivatedRoute: ActivatedRoute,
              private toastrService: ToastrService,
              private router: Router) { }

  ngOnInit(): void {
    if(this.loggedUser){
      this._ActivatedRoute.paramMap.subscribe(params => { 
        this.pharmacy = params.get('pharmacyName');
        let temp : DateTime = {date: '2021-02-15', time: '13:00:00'}
        this.pharmacistService.getFreePharmacistOnDate(this.pharmacy, temp).subscribe((data:any[]) => {
          if(data.length <= 0){
            this.toastrService.info('No pharamcist has been found for selected term!');
          }else{
            this.pharmacists = data;
          }
        })
      });
    }else{
      this.router.navigate(['login']);
      this.toastrService.info('Please log in first.');
    }
  }

  schedule(){

  }

}
