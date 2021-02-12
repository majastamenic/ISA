import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { MedicinePharmacyService } from 'src/app/service/medicine-pharmacy.service';
import { MedicineReservationService } from 'src/app/service/medicine-reservation.service';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-medicine-reservation',
  templateUrl: './medicine-reservation.component.html',
  styleUrls: ['./medicine-reservation.component.css']
})
export class MedicineReservationComponent implements OnInit {

  loggedUser = sessionStorage.getItem('user');
  eagerDate: any;

  medicineName: any;
  reservation: any = {patientEmail:this.loggedUser, pharmacyName:'', medicineName:'', dueDate:'', amount:''};
  medicinePharmacy: any;
  pharmacies: any = [];
  selectedPharmacy: any;

  constructor(private medicineReservationService: MedicineReservationService,
              private medicinePharmacyService: MedicinePharmacyService,
              private userService: UserService,
              private _ActivatedRoute: ActivatedRoute,
              private router: Router,
              private toastrService: ToastrService) { }

  ngOnInit(): void {
    if(this.loggedUser && this.userService.isPatient()){
      this._ActivatedRoute.paramMap.subscribe(params => { 
        this.medicineName = params.get('medicineName');
        this.reservation.medicineName = this.medicineName;
        this.medicinePharmacyService.getByMedicine(this.medicineName).subscribe(pharmacies => {
          this.pharmacies = pharmacies;
        })
      });
    }else{
      this.router.navigate(['login']);
      this.toastrService.info('Please login first!');
    }
  }

  reserve(){
    if(typeof this.eagerDate != 'object'){
      this.toastrService.error("Invalid date format!");
      return;
    }
    this.reservation.dueDate = `${this.eagerDate.year}-${this.eagerDate.month}-${this.eagerDate.day}`;
    this.reservation.pharmacyName = this.selectedPharmacy.pharmacyName;
    this.medicineReservationService.createReservation(this.reservation).subscribe(reservated => {
      this.router.navigate(['medicines']);
      this.toastrService.success('Reservation successfull!');
    }, error => {
      this.toastrService.error(error.error.message);
    })
  }

}
