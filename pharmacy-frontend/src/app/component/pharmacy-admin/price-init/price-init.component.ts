import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { MedicinePharmacyService } from 'src/app/service/medicine-pharmacy.service';
import { PriceListService } from 'src/app/service/price-list.service';
import { PharmacyAdmin } from '../../user/model/pharmacy-admin';

@Component({
  selector: 'app-price-init',
  templateUrl: './price-init.component.html',
  styleUrls: ['./price-init.component.css']
})
export class PriceInitComponent implements OnInit {

  listMedications: any=[];
  medication : any;
  startDate: any;
  endDate: any;
  price: number;
  pharmacyAdmin: PharmacyAdmin;
  loggedUser: any = sessionStorage.getItem("user");

  constructor(private priceListService: PriceListService, 
    private toastrService: ToastrService,
    private medicinePharmacyService: MedicinePharmacyService) { 
      this.price=0;
      this.pharmacyAdmin={orders:"", pharmacy:"", schedule:"", user:""};
      let loggedUser = sessionStorage.getItem('user');
      if(loggedUser){
        this.priceListService.getPharmacyAdmin(loggedUser).subscribe((response: any)=>{
          this.pharmacyAdmin =response;
        });
      }
    }

  ngOnInit(): void {
    this.medicinePharmacyService.getByPharmacy(this.pharmacyAdmin.pharmacy).subscribe((response: any) =>{
      this.listMedications = response;
    });
  }
  define(){
    let priceDto:any ={
        startDate : `${this.startDate.year}-${this.startDate.month}-${this.startDate.day}`,
        endDate: `${this.endDate.year}-${this.endDate.month}-${this.endDate.day}`
    }
    this.priceListService.createPriceList(priceDto).subscribe((_ret: any) =>{
      this.toastrService.success("You added price successfuly");
    }) 

  }
}