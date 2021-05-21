import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
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
  loggedUser: any = sessionStorage.getItem('user');
  constructor(private _ActivatedRoute: ActivatedRoute, private toastrService: ToastrService, private dermatologistService: DermatologistService) { }

  ngOnInit(): void {
    this._ActivatedRoute.paramMap.subscribe(params => { 
      this.pharmacyName = params.get('pharmacyName');
    });

    this.dermatologistService.getDermatologistsByPharmacyName(this.pharmacyName).subscribe((data: Dermatologist[]) => {
      this.dermatologists = data;
    },(err: any)=>{
      this.toastrService.error("Error "+ err.error.message)
    });
  }
  define(dermatologistEmail: "" , i:number){
    this.dermatologistService.deleteDermatologist(dermatologistEmail,this.loggedUser).subscribe((data: any) => {
      this.toastrService.success('Dermatologist deleted!');
    }, (error: { status: number; error: { message: string | undefined; }; }) => {
      if(error.status == 400)
        this.toastrService.warning(error.error.message);
      else
        this.toastrService.error("Server error: can't cancel examination!");
    })
  }

}
