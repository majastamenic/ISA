import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { PharmacistService } from 'src/app/service/pharmacist.service';

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
        //this.pharmacistService.getFreePharmacistOnDate(pharmacy, );
      });
    }else{
      this.router.navigate(['login']);
      this.toastrService.info('Please log in first.');
    }
  }

}
