import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { PharmacyService } from 'service/pharmacy.service';
import { UserService } from 'service/user.service';

@Component({
  selector: 'app-subscribe-list',
  templateUrl: './subscribe-list.component.html',
  styleUrls: ['./subscribe-list.component.css']
})
export class SubscribeListComponent implements OnInit {

  loginUser: string = '';
  pharmacies: any;

  constructor(private userService: UserService, private toastrService: ToastrService,
    private router: Router, private pharcyService: PharmacyService) { }

  ngOnInit(): void {
    if(!this.userService.isPatient()){
      this.router.navigate(['home']);
      this.toastrService.error('Unauthorized access.');
    }
    let userEmail = sessionStorage.getItem('user');
    if(userEmail){
      this.loginUser = userEmail;
    }

    this.pharcyService.pharmacies_sub(this.loginUser).subscribe((response: any)=>{
      this.pharmacies = response;
    }, (err: any) => {
      this.toastrService.error(err.error.message);
    });
  }

  unsubsribe(i: any){
    this.pharcyService.unsubscribe(this.loginUser, this.pharmacies[i]).subscribe((response: any)=>{
      location.reload();
      this.toastrService.success("Unsubsribed to " + this.pharmacies[i] + " pharmacy.")
    }, (err: any) => {
      this.toastrService.error(err.error.message);
    });
  }

}
