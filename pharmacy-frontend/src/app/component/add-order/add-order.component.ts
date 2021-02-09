import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { OrderService } from 'src/app/service/order.service';

@Component({
  selector: 'app-add-order',
  templateUrl: './add-order.component.html',
  styleUrls: ['./add-order.component.css']
})
export class AddOrderComponent implements OnInit {

  newOrder: any;
  showCreateorder: boolean = false;
  listOrders: any;

  constructor(private orderService: OrderService, private toastrService: ToastrService) { }

  ngOnInit(): void {
    this.orderService.getAll().subscribe(orders => {
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
}
