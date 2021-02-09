import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { PharmacistService } from 'service/pharmacist.service';
import { PharmacyService } from 'service/pharmacy.service';

@Component({
  selector: 'app-pharmacy-profile',
  templateUrl: './pharmacy-profile.component.html',
  styleUrls: ['./pharmacy-profile.component.css']
})
export class PharmacyProfileComponent implements OnInit {

  userLogin: boolean = false;
  loginUser: string = '';

  pharmacyName: any;
  constructor(private _ActivatedRoute: ActivatedRoute, private pharmacyService: PharmacyService,
    private toastrService: ToastrService) {
   }

  ngOnInit(): void {
    this._ActivatedRoute.paramMap.subscribe(params => { 
      this.pharmacyName = params.get('pharmacyName');
    });

    let userEmail = sessionStorage.getItem('user');
    if(userEmail){
      this.loginUser = userEmail;
      this.userLogin = true;
    }
  }

  subscribe(){
    this.pharmacyService.subscribe(this.loginUser, this.pharmacyName).subscribe((response: any) => { 
      this.toastrService.success("You've subscribed to " + this.pharmacyName+" pharmacy.");
    }, (err: any) => {
      this.toastrService.error(err.error.message)
    });
  }

}
