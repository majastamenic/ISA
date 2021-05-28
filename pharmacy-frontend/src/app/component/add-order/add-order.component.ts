import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { Observable } from 'rxjs';
import { OrderDto, OrderOfferDto } from 'src/app/model/order';
import { OrderService } from 'src/app/service/order.service';
import { PharmacistComponent } from '../pharmacy-admin/pharmacist/pharmacist.component';

@Component({
  selector: 'app-add-order',
  templateUrl: './add-order.component.html',
  styleUrls: ['./add-order.component.css']
})
export class AddOrderComponent implements OnInit {

  newOrder: OrderDto={price:0, quantity:0, pharmacyAdminEmail:"", endDate:"", medicineName:""};
  showCreateorder: boolean = false;
  listOrders: any;
  phAdmin:any;
  listOffers:any;
  showOffers: boolean= false;
  orderType: any;
  constructor(private orderService: OrderService, private toastrService: ToastrService) { }

  ngOnInit(): void {
    let userEmail = sessionStorage.getItem('user');
    if(userEmail){
      this.phAdmin = userEmail;
    }
    this.newOrder.pharmacyAdminEmail = this.phAdmin;
    this.orderService.getOrders(this.phAdmin).subscribe((orders: any) => {
      this.listOrders = orders;
    });
  }

  create(){
    this.orderService.create(this.newOrder).subscribe((response: any)=>{
      this.toastrService.success("Successfully created order.")
    },(err: any)=>{
      this.toastrService.error("Error "+ err.error.message)
    });
  }

  addOrder(){
    this.showCreateorder = true;
  }

  delete(i: any){
    this.orderService.delete(this.listOrders[i].id).subscribe((response: any)=>{
      this.toastrService.success("Order is deleted")
    },(err: any)=>{
      this.toastrService.error("Error "+ err.error.message)
    });
  }
  show(orderId:any,i:number){
    this.change();
    this.orderService.getOrderOffers(orderId).subscribe((orders: any) => {
      this.listOffers = orders;
    });
  }
  change(){
    this.showOffers = true;
  }
  set(offerId:any, i:number){
    this.orderService.updateWinner(offerId, this.phAdmin).subscribe((response: any)=>{
      this.toastrService.success("Winner is here!")
    },(err: any)=>{
      this.toastrService.error("Error "+ err.error.message)
    });
  }

  filter(){
    if(this.orderType == "PROCESSED"){
      this.orderService.getFinishedOrders(this.phAdmin).subscribe((orders: any) => {
        this.listOrders = orders;
      });
    }
    else{
      this.orderService.getOrders(this.phAdmin).subscribe((orders: any) => {
        this.listOrders = orders;
      });
    }
  }
}
