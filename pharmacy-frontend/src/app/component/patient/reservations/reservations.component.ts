import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { MedicineReservationService } from 'src/app/service/medicine-reservation.service';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-reservations',
  templateUrl: './reservations.component.html',
  styleUrls: ['./reservations.component.css']
})
export class ReservationsComponent implements OnInit {

  loggedUser = sessionStorage.getItem('user');

  reservations: any;

  constructor(private medicineReservationsService: MedicineReservationService,
              private userService: UserService,
              private toastrService: ToastrService,
              private router: Router) { }

  ngOnInit(): void {
    if(this.loggedUser && this.userService.isPatient()){
      this.medicineReservationsService.getAllReservationsByPatient(this.loggedUser).subscribe(data => {
        this.reservations = data;
      }, error => {
        this.toastrService.error('Server error');
      })
    }else{
      this.router.navigate(['login']);
      this.toastrService.info("Please log in first.");
    }
  }

  cancelReservation(reservationId: number, idx: number){
    this.medicineReservationsService.cancelReservation(reservationId).subscribe(() => {
      this.toastrService.success("Reservation canceled!");
      this.reservations.splice(idx, 1);
    }, error => {
      if(error.status == 400)
        this.toastrService.warning(error.error.message);
      else
        this.toastrService.error("Server error: can't cancel reservation");
    });
  }
}
