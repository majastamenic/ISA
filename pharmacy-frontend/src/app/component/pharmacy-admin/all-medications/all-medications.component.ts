import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { MedicinePharmacy } from 'src/app/model/medicinePharmacy';
import { MedicinePharmacyService } from 'service/medicine-pharmacy.service';

@Component({
  selector: 'app-all-medications',
  templateUrl: './all-medications.component.html',
  styleUrls: ['./all-medications.component.css']
})
export class AllMedicationsComponent implements OnInit {

  id : any;
  medications : MedicinePharmacy[]=[];
  constructor(private medicinePharmacyService : MedicinePharmacyService,private _ActivatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this._ActivatedRoute.paramMap.subscribe(params => { 
      this.id = params.get('id');
    });

    this.medicinePharmacyService.getByPharmacy(this.id).subscribe((data: MedicinePharmacy[]) => {
      this.medications = data;
    });
  }

  define(){
    
  }
}