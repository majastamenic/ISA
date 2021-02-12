import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { PharmacyService } from 'src/app/service/pharmacy.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  pharmacies: any = [];

  constructor(private pharmacyService: PharmacyService,
              private toastrService: ToastrService) {
  }

  ngOnInit(): void {
    this.pharmacyService.getAll().subscribe(allPharmacies => {
      this.pharmacies = allPharmacies;
    }, error => {
      this.toastrService.error("Server error");
    });
  }
}