import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { PharmacyService } from 'src/app/service/pharmacy.service';
import { RatingService } from 'src/app/service/rating.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  pharmacies: any = [];
  lat:any;
  lng:any;

  constructor(private pharmacyService: PharmacyService,
              private toastrService: ToastrService
              ,public ratingService: RatingService ) {
                
    if (navigator)
    {
    navigator.geolocation.getCurrentPosition( pos => {
        this.lng = +pos.coords.longitude;
        this.lat = +pos.coords.latitude;
      });
    }
  }

  ngOnInit(): void {
    this.pharmacyService.getAll().subscribe(allPharmacies => {
      this.pharmacies = allPharmacies;
      for(let ph of this.pharmacies){
        this.ratingService.getAverageRatePharmacy(ph.name).subscribe(ocena => {
          ph.rate = ocena;
        });
        }
    }, error => {
      this.toastrService.error("Server error");
    });
  }
}