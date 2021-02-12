import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { MedicineService } from 'src/app/service/medicine.service';

@Component({
  selector: 'app-publishing-reserved-medicine',
  templateUrl: './publishing-reserved-medicine.component.html',
  styleUrls: ['./publishing-reserved-medicine.component.css']
})
export class PublishingReservedMedicineComponent implements OnInit {

  code: any;
  loggedUser: any = sessionStorage.getItem('user');
  loggedUserRole: any = sessionStorage.getItem('role');

  constructor(private medicineService: MedicineService, private toastrService: ToastrService,
    private router: Router) { }

  ngOnInit(): void {
    if(!this.loggedUser){
      this.router.navigate(['login']);
      this.toastrService.info('Please login first!');
    }
  }

  publishReservation(){
    if(this.loggedUserRole == 'PHARMACIST'){
      this.medicineService.acceptReservation(this.loggedUser, this.code).subscribe(resv => {
        console.log(resv);
        if(resv){
          this.toastrService.success("Reservation is accepted.");
          window.location.reload();
        }else{
          window.location.reload();
          this.toastrService.success("Reservation code is not valid.");
        }
      })
    }else{
      this.router.navigate(['home']);
      this.toastrService.error('You do not have access rights for this page!');
    }
  }

}
