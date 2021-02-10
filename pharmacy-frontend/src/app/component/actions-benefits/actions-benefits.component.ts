import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { ActionsBenefitsService } from 'src/app/service/actions-benefits.service';
import { HospitalService } from 'src/app/service/hospital.service';
import { UserService } from 'src/app/service/user.service';
import { ActionsBenefits, ActionsBenefitsDto } from './model/actions-benefits-model';

@Component({
  selector: 'app-actions-benefits',
  templateUrl: './actions-benefits.component.html',
  styleUrls: ['./actions-benefits.component.css']
})
export class ActionsBenefitsComponent implements OnInit {

  phAdmin: string = ''

  actionBenefit: ActionsBenefitsDto = {message: '', startDate: new Date(), endDate: new Date()};
  constructor(private actionsBenefitsService: ActionsBenefitsService, private hospitalService: HospitalService, private toastrService: ToastrService,
    private userService: UserService, private router: Router) { }

  ngOnInit(): void {
    if(!this.userService.isPharmacyAdmin()){
      this.router.navigate(['home']);
      this.toastrService.error('Unauthorized access.');
    }
    let userEmail = sessionStorage.getItem('user');
    if(userEmail){
      this.phAdmin = userEmail;
    }
  }

  send(): void{
    this.actionsBenefitsService.send(this.actionBenefit, this.phAdmin).subscribe((returnedAction: string) => {
      this.toastrService.success('Action or benefit send.');
    },
      (err: any) => {
        this.toastrService.error(err.error.message);
      });
  }

}
