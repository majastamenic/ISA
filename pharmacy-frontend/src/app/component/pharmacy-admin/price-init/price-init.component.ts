import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { PriceDto } from 'src/app/model/price';
import { MedicinePharmacyService } from 'src/app/service/medicine-pharmacy.service';
import { PriceListService } from 'src/app/service/price-list.service';
import { PharmacyAdmin } from '../../../model/pharmacy-admin';

@Component({
  selector: 'app-price-init',
  templateUrl: './price-init.component.html',
  styleUrls: ['./price-init.component.css']
})
export class PriceInitComponent implements OnInit {

  listMedications: any=[];
  medication : any;
  priceDto:PriceDto={dateFrom: new Date(), dateTo: new Date(), price:0, medicineId:'', adminEmail:''}
  pharmacyAdmin : PharmacyAdmin = {user:"", pharmacyName:""};
  loggedUser:any;
  selectedMedicine: any;
  constructor(private priceListService: PriceListService, 
    private toastrService: ToastrService, private router: Router,
    private medicinePharmacyService: MedicinePharmacyService) { 
      
    }

  ngOnInit(): void {
    this.loggedUser = sessionStorage.getItem("user");
    this.priceDto.adminEmail = this.loggedUser;
    if(this.loggedUser){
    this.medicinePharmacyService.getByPharmacyAdmin(this.loggedUser).subscribe((response: any) =>{
      this.listMedications = response;
    },(err: any)=>{
      this.toastrService.error("Error "+ err.error.message)
    } );
  }
  else{
    this.router.navigate(['login']);
    this.toastrService.info('Please log in first.');
  }
  }
  define(){
    this.priceDto.medicineId = this.selectedMedicine.medicine.id
    this.priceListService.createPriceList(this.priceDto).subscribe((_ret: any) =>{
      this.toastrService.success("You added price successfuly");
    },(err: any)=>{
      this.toastrService.error("Error "+ err.error.message)
    }) 

  }
}