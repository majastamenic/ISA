import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-pharmacy-profile',
  templateUrl: './pharmacy-profile.component.html',
  styleUrls: ['./pharmacy-profile.component.css']
})
export class PharmacyProfileComponent implements OnInit {

  pharmacyName: any;
  constructor(private _ActivatedRoute: ActivatedRoute) {
   }

  ngOnInit(): void {
    this._ActivatedRoute.paramMap.subscribe(params => { 
      this.pharmacyName = params.get('pharmacyName');
    });

  }

}
