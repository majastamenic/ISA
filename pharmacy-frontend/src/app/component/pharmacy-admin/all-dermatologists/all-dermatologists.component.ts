import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Dermatologist } from 'src/app/model/dermatologist';
import { DermatologistService } from 'src/app/service/dermatologist.service';
import { RatingService } from 'src/app/service/rating.service';

@Component({
  selector: 'app-all-dermatologists',
  templateUrl: './all-dermatologists.component.html',
  styleUrls: ['./all-dermatologists.component.css']
})
export class AllDermatologistsComponent implements OnInit {

  dermatologists: Dermatologist[]=[];
  pharmacyName: any;
  loggedUser: any = sessionStorage.getItem('user');
  name:any;
  surname:any;
  constructor(private _ActivatedRoute: ActivatedRoute, private toastrService: ToastrService,public ratingService: RatingService , private dermatologistService: DermatologistService) { }

  ngOnInit(): void {
    this._ActivatedRoute.paramMap.subscribe(params => { 
      this.pharmacyName = params.get('pharmacyName');
    });

    this.dermatologistService.getDermatologistsByPharmacyName(this.pharmacyName).subscribe((data: Dermatologist[]) => {
      this.dermatologists = data;
      for(let ph of this.dermatologists){
        this.ratingService.getAverageRateDermatologist(ph.user.email).subscribe(ocena => {
          ph.rate = ocena;
        });
        }
    },(err: any)=>{
      this.toastrService.error("Error "+ err.error.message)
    });
  }
  define(dermatologistEmail: "" , i:number){
    this.dermatologistService.deleteDermatologist(dermatologistEmail,this.loggedUser).subscribe((data: any) => {
      this.toastrService.success('Dermatologist deleted!');
      window.location.reload();
    }, (error: { status: number; error: { message: string | undefined; }; }) => {
      if(error.status == 400)
        this.toastrService.warning(error.error.message);
      else
        this.toastrService.error("Server error: can't delete dermatologist!");
    })
  }
  search(){
    this.dermatologistService.findByNameAndSurname(this.name, this.surname, this.pharmacyName).subscribe((data: any) => {
      this.dermatologists = data;
    }, (error: { status: number; error: { message: string | undefined; }; }) => {
      if(error.status == 400)
        this.toastrService.warning(error.error.message);
      else
        this.toastrService.error("Server error: can't find dermatologist!");
    })
  }

}
