import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { UserService } from 'service/user.service';

@Component({
  selector: 'app-supplier',
  templateUrl: './supplier.component.html',
  styleUrls: ['./supplier.component.css']
})
export class SupplierComponent implements OnInit {

  constructor(private userService: UserService, private router: Router,
    private toastrService:ToastrService) { }

  ngOnInit(): void {
    if(!this.userService.isSupplier()){
      this.router.navigate(['home']);
      this.toastrService.error('Unauthorized access.');
    }
  }

}
