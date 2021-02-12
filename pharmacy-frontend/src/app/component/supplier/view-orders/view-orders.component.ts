import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Observable } from 'rxjs';
import { OrderOfferType, SupplierOfferDto } from 'src/app/model/order';
import { OrderService } from 'src/app/service/order.service';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-view-orders',
  templateUrl: './view-orders.component.html',
  styleUrls: ['./view-orders.component.css']
})
export class ViewOrdersComponent implements OnInit {

  orders: any = [];
  supplier: any;
  supplierOffers: any;
  addOfferView: boolean = false;
  isEditable: boolean = false;
  newOffer: any = {};
  enableEditIndex: any;
  offerType: any;

  constructor(private orderService: OrderService, private toastrService: ToastrService,
    private userService: UserService, private router: Router) { }

  ngOnInit(): void {
    if(!this.userService.isSupplier()){
      this.router.navigate(['home']);
    }
    let userEmail = sessionStorage.getItem('user');
    if(userEmail){
      this.supplier = userEmail;
    }
    this.orderService.getSupplierOffers(this.supplier).subscribe((offersList: Observable<any>) =>{
      this.orders = offersList;
    }, (err: any) => {
      this.toastrService.info(err.error.message);
    });
  }

  addOffer(e: Event, i: any){
    this.addOfferView = true; 
    this.enableEditIndex = i;
  }

  create(){
    this.newOffer.supplierEmail = this.supplier;
    this.newOffer.type = OrderOfferType.WAITING_FOR_ANSWER;
    this.newOffer.orderId = this.orders[this.enableEditIndex].id;
    this.orderService.createOffer(this.newOffer).subscribe((response: any) =>{
      this.isEditable = false;
      this.addOfferView = false;
      this.toastrService.success("Added offer");
    }, (err: any) => {
        this.toastrService.error("Error: "+ err.error.message);
    });
  }

  cancel(){
    this.addOfferView = false;
  }

  edit(i: any){
    if(this.orders[i].endDate < Date.now){
      this.isEditable = true;
    }
  }

  filter(){
    this.orderService.filter(this.supplier, this.offerType).subscribe((offersList: Observable<any>) =>{
      this.orders = offersList;
    }, (err: any) => {
      this.toastrService.info(err.error.message);
    });
  }
}
