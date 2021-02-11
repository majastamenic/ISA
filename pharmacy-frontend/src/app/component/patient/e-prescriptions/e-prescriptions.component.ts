import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { EPrescriptionService } from 'src/app/service/e-prescription.service';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-e-prescriptions',
  templateUrl: './e-prescriptions.component.html',
  styleUrls: ['./e-prescriptions.component.css']
})
export class EPrescriptionsComponent implements OnInit {

  loggedUser = sessionStorage.getItem('user');

  ePrescriptions: any = [];

  constructor(private eprescriptionService: EPrescriptionService,
              private userService: UserService,
              private toastrService: ToastrService,
              private router: Router) { }

  ngOnInit(): void {
    if(this.loggedUser && this.userService.isPatient()){
      this.eprescriptionService.getPatientsEprescriptions(this.loggedUser).subscribe(ePrescritpions => {
        this.ePrescriptions = ePrescritpions;
      })
    } else {
      this.router.navigate(['login']);
      this.toastrService.info('Please log in first.');
    }
  }
}
