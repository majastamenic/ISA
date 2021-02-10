import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { PharmacistService } from 'service/pharmacist.service';
import { Pharmacist } from '../../../model/pharmacist';
import { PharmacistComponent } from '../pharmacist/pharmacist.component';

@Component({
  selector: 'app-all-pharmacists',
  templateUrl: './all-pharmacists.component.html',
  styleUrls: ['./all-pharmacists.component.css']
})
export class AllPharmacistsComponent implements OnInit {

  id : any;
  pharmacists: Pharmacist[] = [];
  constructor(private _ActivatedRoute: ActivatedRoute, private pharmacistSevice: PharmacistService) { }

  ngOnInit(): void {
    this._ActivatedRoute.paramMap.subscribe(params => { 
      this.id = params.get('id');
    });

    this.pharmacistSevice.getPharmacistsByPharmacyId(this.id).subscribe((data: Pharmacist[]) => {
      this.pharmacists = data;
    });
  }

  define(){
    
  }



}
