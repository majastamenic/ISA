import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Dermatologist } from 'src/app/model/dermatologist';
import { DermatologistService } from 'src/app/service/dermatologist.service';

@Component({
  selector: 'app-all-dermatologists',
  templateUrl: './all-dermatologists.component.html',
  styleUrls: ['./all-dermatologists.component.css']
})
export class AllDermatologistsComponent implements OnInit {

  dermatologists: Dermatologist[]=[];
  pharmacyName: any;
  constructor(private _ActivatedRoute: ActivatedRoute, private dermatologistService: DermatologistService) { }

  ngOnInit(): void {
    this._ActivatedRoute.paramMap.subscribe(params => { 
      this.pharmacyName = params.get('pharmacyName');
    });

    this.dermatologistService.getDermatologistsByPharmacyName(this.pharmacyName).subscribe((data: Dermatologist[]) => {
      this.dermatologists = data;
    });
  }
  define(){
    
  }

}
