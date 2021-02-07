import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { OrderOfferType, SupplierOfferDto } from 'src/app/model/order';
import { OrderService } from 'src/app/service/order.service';

@Component({
  selector: 'app-view-orders',
  templateUrl: './view-orders.component.html',
  styleUrls: ['./view-orders.component.css']
})
export class ViewOrdersComponent implements OnInit {

  orders: any;
  addOfferView: boolean = false;
  newOffer: any;

  constructor(private orderService: OrderService, private toastrService: ToastrService) { }

  ngOnInit(): void {
    this.orderService.getAll().subscribe(ordersList => {
      this.orders = ordersList;
    });
  }

  addOffer(){
    this.addOfferView = true;
  }

  create(){
    this.orderService.createOffer(this.newOffer).subscribe((response: any) =>{
        this.toastrService.success("Added offer");
    }, (err: any) => {
        this.toastrService.error("Error: "+ err.error.message);
    });
  }

  cancel(){
    this.addOfferView = false;
  }

}
