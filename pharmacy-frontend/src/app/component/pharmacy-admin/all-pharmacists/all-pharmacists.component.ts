import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Pharmacy } from 'src/app/model/pharmacy-model';
import { PharmacistService } from 'src/app/service/pharmacist.service';
import { PharmacyService } from 'src/app/service/pharmacy.service';
import { Pharmacist } from '../../../model/pharmacist';
import { PharmacistComponent } from '../pharmacist/pharmacist.component';

@Component({
  selector: 'app-all-pharmacists',
  templateUrl: './all-pharmacists.component.html',
  styleUrls: ['./all-pharmacists.component.css']
})
export class AllPharmacistsComponent implements OnInit {

  pharmacy: Pharmacy= {id: 0, name:'', address:''};
  pharmacists: Pharmacist[] = [];
  pharmacyName:any;
  id: any;
  constructor(private _ActivatedRoute: ActivatedRoute, private toastrService: ToastrService ,private pharmacistSevice: PharmacistService, private pharmacyService: PharmacyService) { }

  ngOnInit(): void {
    this._ActivatedRoute.paramMap.subscribe(params => { 
      this.pharmacyName = params.get('pharmacyName');
    });

    this.pharmacistSevice.getPharmacistsByPharmacyId(this.pharmacyName).subscribe((data: Pharmacist[]) => {
      this.pharmacists = data;
    });

  }

  define(){
    
  }



}
