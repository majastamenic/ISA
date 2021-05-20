import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { MedicinePharmacy } from 'src/app/model/medicinePharmacy';
import { MedicinePharmacyService } from 'src/app/service/medicine-pharmacy.service';

@Component({
  selector: 'app-all-medications',
  templateUrl: './all-medications.component.html',
  styleUrls: ['./all-medications.component.css']
})
export class AllMedicationsComponent implements OnInit {

  id : any;
  medicine : MedicinePharmacy[]=[];
  pharmacyName:any;
  constructor(private medicinePharmacyService : MedicinePharmacyService,private _ActivatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this._ActivatedRoute.paramMap.subscribe(params => { 
      this.pharmacyName = params.get('pharmacyName');
    });

    this.medicinePharmacyService.getByPharmacy(this.pharmacyName).subscribe((data: MedicinePharmacy[]) => {
      this.medicine = data;
    });
  }

  define(){
    
  }
}